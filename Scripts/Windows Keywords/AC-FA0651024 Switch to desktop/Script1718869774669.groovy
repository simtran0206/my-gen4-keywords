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
import java.awt.GraphicsConfiguration as GraphicsConfiguration
import java.awt.GraphicsDevice as GraphicsDevice
import java.awt.GraphicsEnvironment as GraphicsEnvironment
import java.awt.KeyboardFocusManager as KeyboardFocusManager
import java.awt.Window as Window

Windows.startApplication(GlobalVariable.NotepadPath, FailureHandling.STOP_ON_FAILURE)

Windows.switchToDesktop()

String appRootDriver = Windows.getDriver()

Windows.verifyEqual(appRootDriver.contains('app=Root'), true)

Windows.switchToApplication(FailureHandling.STOP_ON_FAILURE)

String appDriver = Windows.getDriver()

Windows.verifyEqual(appDriver.contains('notepad.exe'), true)

Windows.verifyElementPresent(findWindowsObject('Notepad/Text Editor'), 0)

Windows.closeApplication()

