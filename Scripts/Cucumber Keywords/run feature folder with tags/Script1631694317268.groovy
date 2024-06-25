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

// Enable this steps will make all following script become their sub-tree
//String []tags = new String[3]
//tags[0]= "@tag2"
//tags[1]= "@regression"
//tags[2] = "@login"
//
//CucumberKW.runFeatureFolderWithTags('Include/features/Katalon QA', tags)

//AND
CucumberKW.runFeatureFolderWithTags("Include/features/Katalon QA/", "@tag1 and @test")

String[] logTags = ["@tag1", "@doubletag"] as String[]
CucumberKW.runFeatureFolderWithTags("Include/features/Sample/", logTags, FailureHandling.STOP_ON_FAILURE)

//OR
CucumberKW.runFeatureFolderWithTags("Include/features/Sample/", "@tag1 or @tag2")

CucumberKW.runFeatureFolderWithTags("Include/features/Sample/", "@tag1, @tag2")

String[] logTags1 = ["@tag1 or @regression"] as String[]
CucumberKW.runFeatureFolderWithTags("Include/features/Katalon QA/", logTags1, FailureHandling.STOP_ON_FAILURE)

