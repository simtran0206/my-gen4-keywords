import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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
import java.nio.file.Paths
import java.nio.file.Path

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.sampleAUTUploadImgByDragAndDrop)

//WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Demo AUT/Page_Imgur The magic of the Internet/span_Post Title'), 10)
WebUI.verifyElementText(findTestObject('Object Repository/Page_Free upload and file sharing with Uplo_66f28f/span_Drag and drop your files here or click to'),
	'Drag and drop your files here or click to')

def filePath = RunConfiguration.getProjectDir() + '/Testing Data/Katalon-Devices.JPG'

def filePath1 = RunConfiguration.getProjectDir() + '/Testing Data/Katalon-Devices 1.JPG'

def filePath2 = RunConfiguration.getProjectDir() + '/Testing Data/Katalon-Devices 2.JPG'

Path projectPath = Paths.get(RunConfiguration.getProjectDir())
File uploadedFilePath =  projectPath.resolve("Images").resolve("Katalon-Devices.JPG").toFile()
def fileImg = RunConfiguration.getProjectDir() + '/Images/Katalon-Devices.JPG'

def concatenatedFilePath = (((filePath + '\n') + filePath1) + '\n') + filePath2

println uploadedFilePath
WebUI.uploadFileWithDragAndDrop(findTestObject('Object Repository/Page_Free upload and file sharing with Uplo_66f28f/div_Drag and drop your files here or click _c8d0b8'),uploadedFilePath.toString())

"Verify image uploaded by checking textbox 'Post title' - only appear after images upload to create a post"
//WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Demo AUT/Page_Imgur The magic of the Internet/span_Post Title'), 10, FailureHandling.OPTIONAL)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Free upload and file sharing with Uplo_66f28f/div_1 selected file ready to send'), 
    '1 selected file ready to send')

"Verify image uploaded by checking 'Sign in' button"
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Demo AUT/Page_Imgur The magic of the Internet/a_Sign in'), 10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Free upload and file sharing with Uplo_66f28f/button_Add more files'),
	0)
