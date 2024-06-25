import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-inc--demo.sandbox.my.salesforce.com/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Page_Login  Salesforce/input_Username_username'), 'philip.becker@katalon.com.demo')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_pw'), 'EzSOryvUIy5yAnGqhHYG9WM2GdDepQhn')

WebUI.click(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_Login'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_Home  Salesforce/span_Opportunities'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Pipeline Inspection  Opportunities  Sa_9e3985/p_Open Pipeline'), 'Open Pipeline')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Pipeline Inspection  Opportunities  Sa_9e3985/p_New'), 'New')

WebUI.enhancedClick(findTestObject('Object Repository/Page_Pipeline Inspection  Opportunities  Sa_9e3985/button_New'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_New Opportunity  Salesforce/span_Cancel'))

WebUI.closeBrowser()

