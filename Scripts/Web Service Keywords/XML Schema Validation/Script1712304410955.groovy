import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.regex.Pattern

import org.apache.commons.io.FileUtils

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

res = WS.sendRequest(findTestObject('Web Service Objects/XML'))

String xml = '''<?xml version="1.0" encoding="utf-8"?>
<List>
    <item>
        <username>James Johnson</username>
        <password>789</password>
        <gender>FEMALE</gender>
        <age>75</age>
        <avatar/>
    </item>
</List>'''

String xmlFile = FileUtils.readFileToString(new File("example/xml/person.xml"));

"Validate an XML response in Validation tab"
//WS.sendRequestAndVerify(findTestObject('Web Service Objects/Calculator'), FailureHandling.OPTIONAL)

"Validate an XML response with Schema in a File - PASS"
WS.validateXmlAgainstSchema(res, "example/xml/person.xsd");

"Validate an XML response with Schema in a File - FAILED"
try {
	WS.validateXmlAgainstSchema(xml, "example/xml/personWrong.xsd", FailureHandling.STOP_ON_FAILURE);
	KeywordUtil.markFailed('The Expectation is Error Exception')
}
catch(Exception ex){
	println ex.message
	CustomKeywords.'katalon.helper.verifyHelper.verifyMessageExist'(ex.message, 'Invalid content was found starting with element')
}


"Validate an XML file with Schema in a File - PASS"
WS.validateXmlAgainstSchema(xmlFile, "example/xml/person.xsd", FailureHandling.STOP_ON_FAILURE);

"Validate response of a SOAP object with XML Schema"
WS.sendRequestAndVerify(findTestObject("Web Service Objects/Calculator"), FailureHandling.STOP_ON_FAILURE)


"Validate response of a SOAP object with XML Schema"
try {
	WS.sendRequestAndVerify(findTestObject("Web Service Objects/Calculator Wrong Validation"), FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.markFailed('The Expectation is Error Exception')
}
catch (Exception ex) {
	println ex.message
	CustomKeywords.'katalon.helper.verifyHelper.verifyMessageExist'(ex.message, 'Cannot find the declaration of element')
	
}
