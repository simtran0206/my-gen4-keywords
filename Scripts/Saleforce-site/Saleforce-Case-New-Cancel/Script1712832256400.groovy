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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-inc--demo.sandbox.my.salesforce.com/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Page_Login  Salesforce/input_Username_username'), 'philip.becker@katalon.com.demo')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_pw'), 'EzSOryvUIy5yAnGqhHYG9WM2GdDepQhn')

WebUI.click(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_Login'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_Home  Salesforce/a_Cases'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_Recently Viewed  Cases  Salesforce/a_New'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_New Case  Salesforce/h2_New Case'), 'New Case')

WebUI.enhancedClick(findTestObject('Object Repository/Page_New Case  Salesforce/span_On-Boarding Request_slds-radio--faux'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_New Case  Salesforce/button_Next'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_New Case Ticket  Salesforce/button_--None--'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_New Case Ticket  Salesforce/lightning-base-combobox-item_High'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_New Case Ticket  Salesforce/button_--None--_1'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_New Case Ticket  Salesforce/span_Katalon TestOps (Business)'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_New Case Ticket  Salesforce/button_--None--_1_2'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_New Case Ticket  Salesforce/lightning-base-combobox-item_Product Issues'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_New Case Ticket  Salesforce/button_Cancel'))

WebUI.closeBrowser()

