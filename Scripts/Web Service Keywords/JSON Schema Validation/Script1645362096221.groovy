import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findRequestObject
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


def schemaPass = """
{
    "\$schema": "http://json-schema.org/draft-06/schema#",
    "\$ref": "#/definitions/Welcome",
    "definitions": {
        "Welcome": {
            "type": "object",
            "additionalProperties": false,
            "properties": {
                "year": {
                    "type": "integer"
                },
                "month": {
                    "type": "integer"
                },
                "day": {
                    "type": "integer"
                },
                "hour": {
                    "type": "integer"
                },
                "minute": {
                    "type": "integer"
                },
                "seconds": {
                    "type": "integer"
                },
                "milliSeconds": {
                    "type": "integer"
                },
                "dateTime": {
                    "type": "string",
                    "format": "date-time"
                },
                "date": {
                    "type": "string"
                },
                "time": {
                    "type": "string"
                },
                "timeZone": {
                    "type": "string"
                },
                "dayOfWeek": {
                    "type": "string"
                },
                "dstActive": {
                    "type": "boolean"
                }
            },
            "required": [
                "date",
                "dateTime",
                "day",
                "dayOfWeek",
                "dstActive",
                "hour",
                "milliSeconds",
                "minute",
                "month",
                "seconds",
                "time",
                "timeZone",
                "year"
            ],
            "title": "Welcome"
        }
    }
}
"""

String jsonObject = """
{
  "year":2022,
  "month":3,
  "day":23,
  "hour":5,
  "minute":55,
  "seconds":35,
  "milliSeconds":141,
  "dateTime":"2022-03-23T05:55:35.1413744",
  "date":"03/23/2022",
  "time":"05:55",
  "timeZone":"Europe/Amsterdam",
  "dayOfWeek":"Wednesday",
  "dstActive":false
}
"""

"Validate a JSON object with an input Schema - PASS"
WS.validateJsonAgainstSchema(jsonObject, schemaPass)

def response = WS.sendRequest(findTestObject('Web Service Objects/Time API'))

"Validate a JSON response with an input Schema - FAILED"
WS.validateJsonAgainstSchema(response, schemaPass)

"Validate a JSON response with a Schema from a File Path - PASS"
WS.validateJsonAgainstSchema(response, 'example/json/time-schema - Fail.json', FailureHandling.OPTIONAL)

"Validate a JSON respone with a Schema from a URL - PASSED"
String timeSchemaURLPass = "https://drive.google.com/uc?export=download&id=19KAtIcDA99HotZSmvthQ9wvcZFqF2kej"
WS.validateJsonAgainstSchema(response, timeSchemaURLPass, FailureHandling.OPTIONAL)

"Validate a JSON respone with a Schema from a URL - FAILED"
String timeSchemaURLFailed = "https://drive.google.com/uc?export=download&id=1rIxv-hUIxhFQaE_EA_Cm8YibsyGPKhdB"
WS.validateJsonAgainstSchema(response, timeSchemaURLFailed, FailureHandling.OPTIONAL)

"Validate request and response of a JSON from an input File Path in Validation tab - PASS"
def response2 = WS.sendRequestAndVerify(findTestObject('Web Service Objects/Time API'), FailureHandling.OPTIONAL)




