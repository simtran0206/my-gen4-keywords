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

Windows.startApplication(GlobalVariable.NotepadPath, FailureHandling.STOP_ON_FAILURE)

Windows.sendKeys(findWindowsObject('Notepad/MenuItem Help'), Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER))

Windows.verifyElementPresent(findWindowsObject('Notepad/TitleBar About Notepad'), 30)

Windows.click(findWindowsObject('Notepad/Button OK'))

beforeDelay = System.currentTimeMillis()

try {
    Windows.verifyElementPresent(findWindowsObject('Notepad/TitleBar About Notepad'), 10)

    assert false
}
catch (def Exception) {
	afterDelay = System.currentTimeMillis()
	delayTime = (afterDelay - beforeDelay)
	Windows.verifyGreaterThan(delayTime, 10000)
	Windows.verifyLessThan(delayTime, 11000)
	
    assert true
} 

Windows.closeApplication()

