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
import com.sun.jna.Native as Native
import com.sun.jna.platform.win32.User32 as User32
import com.sun.jna.platform.win32.WinDef.HWND as HWND

Windows.startApplication(GlobalVariable.NotepadPath, FailureHandling.STOP_ON_FAILURE)

Windows.startApplication(GlobalVariable.PaintPath, FailureHandling.STOP_ON_FAILURE)

Windows.switchToWindowTitle('Untitled - Notepad')

User32 user32 = ((Native.loadLibrary('user32', User32.class)) as User32)

HWND foregroundWindow = user32.GetForegroundWindow()

int titleLength = User32.INSTANCE.GetWindowTextLength(foregroundWindow) + 1

char[] title = new char[titleLength]

User32.INSTANCE.GetWindowText(foregroundWindow, title, titleLength)

windowTitle = Native.toString(title)

Windows.verifyEqual(windowTitle.contains('Notepad'), true)

Windows.closeApplication()

