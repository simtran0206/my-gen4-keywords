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

String strTest = "This is a string test"
Windows.verifyEqual(strTest, 'This is a string test')
try {
	Windows.verifyEqual(strTest, 'This is a wrong string test')
	assert false
} catch(Exception) {
	assert true
}

Number numberTest = 10
Windows.verifyEqual(numberTest, 10)

try {
	Windows.verifyEqual(numberTest, 11)
	assert false
} catch(Exception) {
	assert true
}

Windows.setText(findWindowsObject('Object Repository/Notepad/Text Editor'), 'Lorem ipsum dolor sit amet, consectetur adipiscing elit')

Windows.verifyEqual(Windows.getText(findWindowsObject('Notepad/Text Editor')), 'Lorem ipsum dolor sit amet, consectetur adipiscing elit')

try {
	Windows.verifyEqual(Windows.getText(findWindowsObject('Notepad/Text Editor')), 'Lorem ipsum dolor sit amet')
	assert false
	
} catch(Exception) {
	assert true
}

Windows.clearText(findWindowsObject('Notepad/Text Editor'))

Windows.closeApplication()

