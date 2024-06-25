import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//OR tag expression

CucumberKW.runFeatureFileWithTags('Include/features/Sample/Sample File.feature', ((['@tag1 or @tag2']) as String[]), FailureHandling.STOP_ON_FAILURE)

String[] logTags1 = ["@tag2, @doubletag"] as String[]
CucumberKW.runFeatureFileWithTags("Include/features/Sample/Sample File.feature", logTags1, FailureHandling.STOP_ON_FAILURE)
//or
String[] logTags2 = ["@tag1 or @regression"] as String[]
CucumberKW.runFeatureFileWithTags("Include/features/Sample/Sample File.feature", logTags2, FailureHandling.STOP_ON_FAILURE)

//
//AND tag expression
CucumberKW.runFeatureFileWithTags("Include/features/Sample/Sample File.feature", "@tag1 and @doubletag")

String[] logTags3 = ["@tag1", "@doubletag"] as String[]
CucumberKW.runFeatureFileWithTags("Include/features/Sample/Sample File.feature", logTags3, FailureHandling.STOP_ON_FAILURE)
//
CucumberKW.runFeatureFileWithTags('Include/features/Sample/Sample File.feature', "@tag1", "@doubletag")
//
//This stepp still passed but no Scenario running
String []tags = new String[2]
tags[0]= "@tag2"
tags[1]= "@regression"

CucumberKW.runFeatureFileWithTags('Include/features/Sample/Sample File.feature', tags, FailureHandling.STOP_ON_FAILURE)