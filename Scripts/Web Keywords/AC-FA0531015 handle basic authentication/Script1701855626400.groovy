import org.apache.commons.lang3.SystemUtils

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.util.CryptoUtil

import internal.GlobalVariable


"START DATA PREPARRATION"
String browserName = DriverFactory.getExecutedBrowser().getName();
print browserName
def decryptedPassword = (CryptoUtil.decode(CryptoUtil.getDefault("RAIVpflpDOg=")))
"END DATA PREPARATION"

WebUI.openBrowser('')	
WebUI.authenticate(GlobalVariable.basicAuthAUT, "admin", decryptedPassword, GlobalVariable.defaultTimeout)
WebUI.delay(5)
WebUI.verifyTextPresent("Congratulations! You must have the proper credentials.", false)
