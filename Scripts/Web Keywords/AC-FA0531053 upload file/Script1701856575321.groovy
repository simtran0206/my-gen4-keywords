import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.nio.file.Paths
import java.nio.file.Path
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.sampleAUTFileUploadPage)

def uploadedFileName = "sample-text-file.txt"

def fileUploadInput = findTestObject('Object Repository/Page_Demo AUT/input_Capture object_file-upload')

Path projectPath = Paths.get(RunConfiguration.getProjectDir())
File uploadedFilePath =  projectPath.resolve("Sample Files").resolve(uploadedFileName).toFile()

WebUI.verifyTextNotPresent(uploadedFileName, false)

WebUI.uploadFile(fileUploadInput, uploadedFilePath.toString())

'Verify the name of the uploaded file show up on page (this only occurs if we have uploaded a file)'
WebUI.verifyTextPresent(uploadedFileName, false)
