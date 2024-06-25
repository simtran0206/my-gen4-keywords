package katalon.helper

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.nio.charset.Charset
import org.apache.commons.io.FileUtils
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.FileUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class FileHelper {
	static String getFileExtension(String filename){
		if(filename.lastIndexOf('.') > 0){
			return filename.substring(filename.lastIndexOf('.') + 1)
		}
		return ""
	}

	/**
	 * Get content of the file
	 * @param filePath path to navigate to the file
	 * @return a string of content file
	 */
	@Keyword
	def String getFileValue(String filePath) {
		if(filePath != null && filePath != "") {
			File fileContent = FileUtil.getFile(filePath)
			String content = FileUtils.readFileToString(fileContent, Charset.defaultCharset())
			return content
		}
		else WebUI.comment("There is no file provided")
	}
}
