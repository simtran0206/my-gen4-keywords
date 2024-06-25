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

testStr = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'

Windows.setText(findWindowsObject('Object Repository/Notepad/Text Editor'), testStr)

inputStr = Windows.getText(findWindowsObject('Notepad/Text Editor'))

Windows.verifyMatch(inputStr, testStr, false)

try {
	Windows.verifyMatch(inputStr, 'wrong string', false)
	assert false
} catch(Exeption) {
	assert true 
}

Windows.verifyMatch(inputStr, '^[^\\d\n]*$', true)

try {
	Windows.verifyMatch(inputStr, '\\d', true)
	assert false
} catch(Exception) {
	assert true
}

Windows.clearText(findWindowsObject('Notepad/Text Editor'))

Windows.closeApplication()

