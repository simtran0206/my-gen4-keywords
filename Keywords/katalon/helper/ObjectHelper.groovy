package katalon.helper

import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

public class ObjectHelper {

	/**
	 * Get attribute value of an object
	 * @param testObj the object that want to get attribute value
	 * @param attribute the attribute that want to get value
	 * @return String of innerHTML value of the object 
	 */
	@Keyword
	def String getFrameOjectAttributeValue(TestObject testObj, String attribute) {

		// Go to parent frame
		WebUiCommonHelper.switchToParentFrame(testObj)
		// Find the desired object located under a frame
		WebElement webElement = WebUIAbstractKeyword.findWebElement(testObj)
		//Get the attribute of the found object
		String returnedHTML = webElement.getAttribute(attribute)

		return returnedHTML
	}
}
