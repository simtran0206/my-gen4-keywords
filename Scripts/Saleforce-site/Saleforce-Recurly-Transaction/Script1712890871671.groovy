import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang.RandomStringUtils
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String charset = (('A'..'Z') + ('0'..'9')).join()
Integer length = 15
String randomString = RandomStringUtils.random(length, charset.toCharArray())

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-inc--demo.sandbox.my.salesforce.com/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Page_Login  Salesforce/input_Username_username'), 'philip.becker@katalon.com.demo')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_pw'), 'EzSOryvUIy5yAnGqhHYG9WM2GdDepQhn')

WebUI.click(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_Login'))

WebUI.click(findTestObject('Object Repository/Page_Home  Salesforce/span_More'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_Home  Salesforce/a_Recurly Transactions'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_Recently Viewed  Recurly Transactions _d93119/a_New'))

WebUI.setText(findTestObject('Object Repository/Page_New Recurly Transaction  Salesforce/input__Name'), randomString)

WebUI.enhancedClick(findTestObject('Object Repository/Page_New Recurly Transaction  Salesforce/button_Save'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_thibsad  Recurly Transaction  Salesforce/button_New Contact'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_New Contact  Salesforce/h2_New Contact'), 'New Contact')

WebUI.enhancedClick(findTestObject('Object Repository/Page_New Contact  Salesforce/button_Cancel'))

WebUI.closeBrowser()

