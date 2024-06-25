
package sample

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper

public class Common {

	public static JsonSlurper jsonSlurper = new JsonSlurper()

	@Keyword
	def int createNewUser(int age, String username, String password, String gender, int expectedStatus) {
		RequestObject requestObject = findTestObject("Web Service Objects/POST a new user",
				["age": age, "username": username, "password": password, "gender": gender])
		ResponseObject response = WS.sendRequest(requestObject)
		def jsonResponse = jsonSlurper.parseText(response.getResponseText())
		return jsonResponse.id
	}

	@Keyword
	def static void findUserById(int id, int age, String username, String password, String gender, int expectedStatus) {
		'Disable HAR file generation - the file will not be generated after sending request'
		WS.setHarFileGeneration(false)
		'Get the status of generating a har file when sending a request is true or false'
		boolean isHarFileGenerationEnabled = WS.getHarFileGeneration()
		WS.comment("HAR file will be generated? " +isHarFileGenerationEnabled.toString())
		
		"Step: Send the request and get the response"
		WS.sendRequestAndVerify(findTestObject('Web Service Objects/GET user by id', [('id') : id]))
	}

	@Keyword
	def static void soap_multiply(Number first_number, Number second_number, Number expectedResult, Number numberOfReturnResult) {
		'Set access to external DTD allowed to verify element property (this is work arround for issue 1014 to make verifyElementText works)'
		System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
				"com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl")

		boolean isHarFileGenerationEnabled = WS.getHarFileGeneration()
		WS.comment("HAR file will be generated? " +isHarFileGenerationEnabled.toString())
		
		RequestObject requestObject = findTestObject('Web Service Objects/SOAP_Multiply', ["first_number": first_number, "second_number": second_number])
		ResponseObject response = WS.sendRequest(requestObject)
		println('Response value: ' + response.getResponseText())

		WS.verifyResponseStatusCode(response, 200, FailureHandling.CONTINUE_ON_FAILURE)
		WS.verifyElementPropertyValue(response, "MultiplyResponse.MultiplyResult", expectedResult)
		WS.verifyElementsCount(response, "MultiplyResponse.MultiplyResult", numberOfReturnResult)
		WS.verifyElementText(response, "MultiplyResponse.MultiplyResult", expectedResult.toString())
	}
}
