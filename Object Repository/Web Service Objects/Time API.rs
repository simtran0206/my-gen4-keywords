<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Time API</name>
   <tag></tag>
   <elementGuidId>8933bd71-2f37-4a86-9073-5607c8cb8d3b</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;year\&quot;: 2022,\n  \&quot;month\&quot;: \&quot;13\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>49f8af37-2cd2-4fda-bca8-f25baeb14f13</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.3.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://www.timeapi.io/api/Time/current/zone?timeZone=Europe/Amsterdam</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <validationSteps>
      <id>582ad389-d5a2-4e13-930c-afa508996226</id>
      <name>Validate Request Body - Fail</name>
      <type>JSON_SCHEMA</type>
      <dataType>URL</dataType>
      <target>RESPONSE</target>
      <data>${url}</data>
      <activate>true</activate>
   </validationSteps>
   <validationSteps>
      <id>de5f40df-3623-4701-8c7b-0c6445995ce6</id>
      <name>Validate Request Body - Pass</name>
      <type>AUTO_DETECT</type>
      <dataType>FILE</dataType>
      <target>REQUEST</target>
      <data>example/json/time-schema - Request Body - Pass.json</data>
      <activate>true</activate>
   </validationSteps>
   <validationSteps>
      <id>f39256f8-87aa-4f5e-9ef6-78fcf58e579e</id>
      <name>Validate Response - Pass</name>
      <type>JSON_SCHEMA</type>
      <dataType>FILE</dataType>
      <target>RESPONSE</target>
      <data>example/json/time-schema - Pass.json</data>
      <activate>true</activate>
   </validationSteps>
   <validationSteps>
      <id>188d0c8c-e5df-4209-b511-f68c3b63e1bc</id>
      <name>Validate Response - Fail 1</name>
      <type>JSON_SCHEMA</type>
      <dataType>FILE</dataType>
      <target>RESPONSE</target>
      <data>example/json/time-schema - Fail.json</data>
      <activate>true</activate>
   </validationSteps>
   <validationSteps>
      <id>6a76cfcd-a6c6-42d7-b206-d87c0cdfe7e2</id>
      <name>Validate Response - Fail 2</name>
      <type>XML_SCHEMA</type>
      <dataType>FILE</dataType>
      <target>RESPONSE</target>
      <data>example/json/time-schema - Fail 2.json</data>
      <activate>true</activate>
   </validationSteps>
   <validationSteps>
      <id>bf956188-d1dc-43d8-96b7-73f5d2e6da41</id>
      <name>Validate Response - Fail 3</name>
      <type>AUTO_DETECT</type>
      <dataType>URL</dataType>
      <target>RESPONSE</target>
      <data>https://drive.google.com/uc?export=download&amp;id=1rIxv-hUIxhFQaE_EA_Cm8YibsyGPKhdB</data>
      <activate>true</activate>
   </validationSteps>
   <validationSteps>
      <id>d0218dc5-7e14-47fd-80e3-abbbb6103ff2</id>
      <name>Validate Response - Error</name>
      <type>JSON_SCHEMA</type>
      <dataType>FILE</dataType>
      <target>RESPONSE</target>
      <data>example/json/time-schema - Error.json</data>
      <activate>true</activate>
   </validationSteps>
   <variables>
      <defaultValue>GlobalVariable.urlForWSValidation</defaultValue>
      <description></description>
      <id>93cc0e96-fb6e-479f-9e66-c94462c68f1c</id>
      <masked>false</masked>
      <name>url</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
