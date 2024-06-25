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
import org.openqa.selenium.WebElement

WebUI.openBrowser(GlobalVariable.sampleAUTIframePage)
def inputTextInsideIframe = findTestObject('Object Repository/Page_Demo AUT/input text in iframe')
def inputTextWithoutIframe = findTestObject('Object Repository/Page_Demo AUT/input text')
def notExistInputIframe= findTestObject('Object Repository/Page_Demo AUT/input_not_exist_iframe')
def List<String> expectAtrribute =["firstName","lastName","dob","address","company"];

//TC: auto switch to iframe and findWebElements with non-exist webElement
def List<WebElement> objNotExistInput = WebUI.findWebElements(notExistInputIframe, 1,FailureHandling.OPTIONAL);
WebUI.verifyEqual(objNotExistInput.size(), 0)

//TC: auto switch to iframe and findWebElements existing webElement
def List<WebElement> objInputs = WebUI.findWebElements(inputTextInsideIframe, 10);
WebUI.verifyEqual(objInputs.size(), 5)

def iframe = findTestObject('Object Repository/Page_Demo AUT/iframe_nested')
WebUI.switchToFrame(iframe, GlobalVariable.defaultTimeout)
for (int i = 0;  i < objInputs.size(); ++i) {
	def objAtrribute = objInputs.get(i).getAttribute("name")
	WebUI.verifyMatch(objAtrribute, expectAtrribute.get(i), false)
}

//TC: manual switch to iframe and findWebElements
def List<WebElement> objInputsWithoutIframe = WebUI.findWebElements(inputTextWithoutIframe, 10);
WebUI.verifyEqual(objInputsWithoutIframe.size(), 5)


