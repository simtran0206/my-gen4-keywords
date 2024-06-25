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

Windows.startApplication(GlobalVariable.KatalonPath, FailureHandling.STOP_ON_FAILURE)

beforeDelay = System.currentTimeMillis()

try {
    Windows.waitForElementPresent(findWindowsObject('Katalon/Pane Start Page Web content'), 2)

    assert false
}
catch (def Exception) {
	afterDelay = System.currentTimeMillis()
	delayTime = (afterDelay - beforeDelay)
	Windows.verifyGreaterThan(delayTime, 2000)
	Windows.verifyLessThan(delayTime, 3000)
    assert true
} 

Windows.waitForElementPresent(findWindowsObject('Katalon/Pane Start Page Web content'), 30)

Windows.closeApplication()

Windows.click(findWindowsObject('Katalon/Button Exit OK'))

