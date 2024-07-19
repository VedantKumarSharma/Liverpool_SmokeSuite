import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.mobile.contribution.MobileDriverCleaner
import com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner
import com.kms.katalon.core.windows.keyword.contribution.WindowsDriverCleaner
import com.kms.katalon.core.testng.keyword.internal.TestNGDriverCleaner


DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.windows.keyword.contribution.WindowsDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.testng.keyword.internal.TestNGDriverCleaner())


RunConfiguration.setExecutionSettingFile('C:\\Users\\mahi1\\AppData\\Local\\Temp\\Katalon\\Test Cases\\AccountManagement\\TS_SMOKE_SUITE_016\\20230811_140946\\execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runTestCaseRawScript(
'''import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

not_run: WebUI.openBrowser('')

not_run: WebUI.navigateToUrl(GlobalVariable.LiverpoolURL)

not_run: WebUI.maximizeWindow()

not_run: WebUI.click(findTestObject('HomePage/Iniciar sesion'))

not_run: WebUI.callTestCase(findTestCase('CommonMethods/loginFromHomePage'), [('username') : GlobalVariable.username, ('password') : GlobalVariable.password], 
    FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.mouseOver(findTestObject('HomePage/AfterLogin_Homepage'))

not_run: WebUI.click(findTestObject('AccountManagement/MyAccountButton_Account'))

not_run: WebUI.click(findTestObject('AccountManagement/UpdatePeronalData_Account'))

not_run: WebUI.verifyElementPresent(findTestObject('AccountManagement/updatePage_Account'), 0)

String name = CustomKeywords.'customkeywords.myKeywords.randomString'()

WebUI.click(findTestObject('AccountManagement/FirstNameProfile_Account'))

//WebUI.clearText(findTestObject('AccountManagement/FirstNameProfile_Account'))
WebUI.sendKeys(findTestObject('AccountManagement/FirstNameProfile_Account'), Keys.chord(Keys.BACK_SPACE))

WebUI.delay(5)

WebUI.setText(findTestObject('AccountManagement/FirstNameProfile_Account'), name)

lastname = WebUI.getText(findTestObject('AccountManagement/LastName_Account'))

accountname = ((name + ' ') + lastname)

WebUI.click(findTestObject('AccountManagement/UpdateButton_Account'))

fnamelname = WebUI.getText(findTestObject('AccountManagement/PersonalDataName_Account'))

if (fnamelname == accountname) {
    println('Checked')
} else {
    KeywordUtil.markFailed('Name is not updated !')
}

''', 'Test Cases/AccountManagement/TS_SMOKE_SUITE_016', new TestCaseBinding('Test Cases/AccountManagement/TS_SMOKE_SUITE_016',[:]), FailureHandling.STOP_ON_FAILURE , false)
    
