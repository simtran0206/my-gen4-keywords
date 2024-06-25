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
def inputInsideIframe = findTestObject('Object Repository/Page_Demo AUT/input_First name_firstName_iframe')
def inputFirstNameWithoutIframe = findTestObject('Object Repository/Page_Demo AUT/input_First name_firstName')
def notExistInputIframe= findTestObject('Object Repository/Page_Demo AUT/input_not_exist_iframe')

//TC: auto switch to iframe and findWebElement with non-exist webElement
def WebElement objNotExistInput = WebUI.findWebElement(notExistInputIframe, 1,FailureHandling.OPTIONAL);
WebUI.verifyEqual(objNotExistInput, null) 

//TC: auto switch to iframe and findWebElement existing webElement
def WebElement objInput = WebUI.findWebElement(inputInsideIframe, 10);

def iframe = findTestObject('Object Repository/Page_Demo AUT/iframe_nested')
WebUI.switchToFrame(iframe, GlobalVariable.defaultTimeout)

objInput.sendKeys("testing")
def text = objInput.getAttribute("value")
WebUI.verifyEqual(text, "testing");

//TC: manual switch to iframe and findWebElement
def WebElement objInput2 = WebUI.findWebElement(inputFirstNameWithoutIframe, 10);
objInput2.clear();
objInput2.sendKeys("testing2")
def text2 = objInput.getAttribute("value")
WebUI.verifyEqual(text2, "testing2");