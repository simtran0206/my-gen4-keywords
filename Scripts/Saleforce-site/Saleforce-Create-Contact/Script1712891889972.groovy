import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang.RandomStringUtils

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String charset = (('A'..'Z') + ('0'..'9')).join()
Integer length = 9
String randomString = RandomStringUtils.random(length, charset.toCharArray())

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-inc--demo.sandbox.my.salesforce.com/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Page_Login  Salesforce/input_Username_username'), 'philip.becker@katalon.com.demo')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_pw'), 'EzSOryvUIy5yAnGqhHYG9WM2GdDepQhn')

WebUI.click(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_Login'))

WebUI.enhancedClick(findTestObject('Object Repository/Page_Fy23 Global Forecast  Salesforce/a_Forecasts'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Recently Viewed  Accounts  Salesforce/a_Contacts'), 30)

WebUI.enhancedClick(findTestObject('Object Repository/Page_Recently Viewed  Accounts  Salesforce/a_Contacts'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Recently Viewed  Contacts  Salesforce/a_New'), 30)
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Recently Viewed  Contacts  Salesforce/a_New'), 30)

WebUI.enhancedClick(findTestObject('Object Repository/Page_Recently Viewed  Contacts  Salesforce/a_New'))
WebUI.delay(5)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_New Contact  Salesforce/input_First Name_firstName'), 30)
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_New Contact  Salesforce/input_First Name_firstName'), 30)

WebUI.setText(findTestObject('Object Repository/Page_New Contact  Salesforce/input_First Name_firstName'), randomString)

WebUI.setText(findTestObject('Object Repository/Page_New Contact  Salesforce/input__lastName'), 'Nguyen')

WebUI.setText(findTestObject('Object Repository/Page_New Contact  Salesforce/input_Suffix_suffix'), 'Mr')

WebUI.setText(findTestObject('Object Repository/Page_New Contact  Salesforce/input_Email_Email'), randomString + '@katalon.com')

WebUI.click(findTestObject('Object Repository/Page_New Contact  Salesforce/button_Save'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_New Contact  Salesforce/h2_We hit a snag'), 'We hit a snag.')

WebUI.enhancedClick(findTestObject('Object Repository/Page_New Contact  Salesforce/button_Cancel'))

WebUI.closeBrowser()

