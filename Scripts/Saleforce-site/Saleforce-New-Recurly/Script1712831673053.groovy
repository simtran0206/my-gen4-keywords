import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang.RandomStringUtils
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String charset = (('A'..'Z') + ('0'..'9')).join()
Integer length = 9
String randomString = RandomStringUtils.random(length, charset.toCharArray())

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-inc--demo.sandbox.my.salesforce.com/')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_pw'), 'EzSOryvUIy5yAnGqhHYG9WM2GdDepQhn')

WebUI.setText(findTestObject('Object Repository/Page_Login  Salesforce/input_Username_username'), 'philip.becker@katalon.com.demo')

WebUI.click(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_Login'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_Home  Salesforce/span_More'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_Home  Salesforce/span_Recurly Accounts'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_Recently Viewed  Recurly Accounts  Salesforce/a_New'))

WebUI.setText(findTestObject('Object Repository/Page_New Recurly Account  Salesforce/input__Name'), randomString)

WebUI.setText(findTestObject('Object Repository/Page_New Recurly Account  Salesforce/input_Company_recurly_v2__Company__c'), 'Katalon')

WebUI.setText(findTestObject('Object Repository/Page_New Recurly Account  Salesforce/input_First Name_recurly_v2__First_Name__c'), randomString)

WebUI.setText(findTestObject('Object Repository/Page_New Recurly Account  Salesforce/input_Last Name_recurly_v2__Last_Name__c'), 'Nguyen')

WebUI.setText(findTestObject('Object Repository/Page_New Recurly Account  Salesforce/input_Recurly Email_recurly_v2__Recurly_Email__c'), randomString + '@katalon.com')

WebUI.enhancedClick(findTestObject('Object Repository/Page_New Recurly Account  Salesforce/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_asdhklasd  Recurly Account  Salesforce/a_Details'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_asdhklasd  Recurly Account  Salesforce/a_Related'), 0)

WebUI.closeBrowser()

