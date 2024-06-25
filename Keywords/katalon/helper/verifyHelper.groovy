package katalon.helper
import java.util.regex.Pattern

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil



class verifyHelper {
	/**
	 * 
	 */
	@Keyword
	verifyMessageExist(String observedMessage,String expectedMessage){
		def pattern = Pattern.compile(".*"+expectedMessage +".*");
		def matcher = (observedMessage =~ pattern)
		if (matcher) {
			def extractedSubstring = matcher[0]
			println("Extracted Substring: $extractedSubstring")
			KeywordUtil.markPassed('The message "' + expectedMessage +'" exist.')
		}else {
			KeywordUtil.markFailed('The message "' + expectedMessage +'" does not exist.')
		}
	}
}