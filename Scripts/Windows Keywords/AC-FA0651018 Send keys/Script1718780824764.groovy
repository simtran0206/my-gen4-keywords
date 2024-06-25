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
import org.openqa.selenium.WebDriver

Windows.startApplication(GlobalVariable.NotepadPath, FailureHandling.STOP_ON_FAILURE)

Windows.sendKeys(findWindowsObject('Notepad/MenuItem Help'), Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER))

Windows.verifyElementPresent(findWindowsObject('Notepad/TitleBar About Notepad'), 0)

Windows.click(findWindowsObject('Notepad/Button OK'))

Windows.sendKeys(findWindowsObject('Object Repository/Notepad/Text Editor'), Keys.chord(Keys.SHIFT, 'abcde'))

Windows.verifyEqual(Windows.getText(findWindowsObject('Notepad/Text Editor')), 'ABCDE')

Windows.clearText(findWindowsObject('Notepad/Text Editor'))

Windows.sendKeys(findWindowsObject('Object Repository/Notepad/Text Editor'), Keys.chord(Keys.ALT, Keys.F4))

WebDriver driver = Windows.getDriver()

try {
	driver.getTitle()
	assert false
}
catch(Exception) {
	assert true
}

