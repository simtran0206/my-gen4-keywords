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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

"PREPARE DATA"
	'Step: Prepare request Body - set data for new user'
	HashMap<String, Object> newUser = new HashMap<>()
	//set age
	newUser.put('age', age as Integer)
	//set username
	newUser.put('username', username)
	//set password
	newUser.put('password', password)
	//set gender - either 'MALE' or 'FEMALE'
	newUser.put('gender', gender)
	//set avatar - null 
	newUser.put('avatar', avatar)
	
	//Convert map into Json
	def jsonBodyContent = new groovy.json.JsonBuilder()
	jsonBodyContent newUser
	//Convert Json into String
	String bodyContent = jsonBodyContent.toString()
	//Create body content property
	HttpTextBodyContent httpBodyContent = new HttpTextBodyContent(bodyContent);
	
	"Step: Prepare request Header - create header properties"
	List<TestObjectProperty> httpHeaderProperties = new ArrayList<>()
	httpHeaderProperties.add(new TestObjectProperty("Content-Type", ConditionType.EQUALS, 'application/json'))
	
	"Step: Prepare WS request"
	RequestObject scriptedWSO = new RequestObject("Create a new user")
	scriptedWSO.setBodyContent(httpBodyContent)
	scriptedWSO.setServiceType("REST")
	scriptedWSO.setHttpHeaderProperties(httpHeaderProperties)
	scriptedWSO.setRestUrl(GlobalVariable.webServiceBaseURL + "/api/users/json")
	scriptedWSO.setRestRequestMethod("POST")
"END PREPARE DATA"
	
'Do not generate har file when sending a request.'
WS.setHarFileGeneration(false)
'Generating har file when sending a request. This is the default setting.'
WS.setHarFileGeneration(true)
'Get the status of generating a har file when sending a request is true or false'
WS.comment("HAR file will be generated? " + WS.getHarFileGeneration().toString())

"Step: Send the request and get the response"
ResponseObject response = WS.sendRequest(scriptedWSO)

"Step: Verify response code"
WS.verifyResponseStatusCodeInRange(response, 200, 202)
"Step:Verify element 'age' of new user is correct"
WS.verifyElementPropertyValue(response, "age", age)
"Step:Verify element 'username' of new user is correct"
WS.verifyElementPropertyValue(response, "username", username)