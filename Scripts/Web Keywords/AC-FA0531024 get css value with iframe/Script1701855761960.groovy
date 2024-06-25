import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.sampleAUTIframePage)
def inputInsideIframe = findTestObject('Object Repository/Page_Demo AUT/input_First name_firstName_iframe')
def inputFirstNameWithoutIframe = findTestObject('Object Repository/Page_Demo AUT/input_First name_firstName')
def inputInvalid = findTestObject('Object Repository/Page_Demo AUT/input_not_exist')
def iframe = findTestObject('Object Repository/Page_Demo AUT/iframe_nested')

//TC: auto switch to iframe when get css value with element in iframe
String backgroundColorAutoSwitchIframe = WebUI.getCSSValue(inputInsideIframe, "background-color")

//Todo: bug https://katalon.atlassian.net/browse/STUDIO-4349
//String invalidInputBackgroudColor = WebUI.getCSSValue(inputInvalid, "background-color", FailureHandling.OPTIONAL)

WebUI.switchToFrame(iframe, GlobalVariable.defaultTimeout)
//TC: manual switch to iframe and then get css value with element in iframe
String backgroundColorNotAutoSwitchIframe = WebUI.getCSSValue(inputFirstNameWithoutIframe, "background-color")

//Todo: bug https://katalon.atlassian.net/browse/STUDIO-4349
//String invalidBackgroudColor = WebUI.getCSSValue(inputInsideIframe, "background-color", FailureHandling.OPTIONAL)


String browserName = DriverFactory.getExecutedBrowser().getName();
String expectedValue = "rgba(255, 255, 255, 1)";
if (browserName.contains("FIREFOX") || browserName.contains("SAFARI")) {
	expectedValue = "rgb(255, 255, 255)"
}
'Verify that the submit button has blue background'
WebUI.verifyEqual(backgroundColorAutoSwitchIframe, expectedValue);
WebUI.verifyEqual(backgroundColorNotAutoSwitchIframe, expectedValue);
