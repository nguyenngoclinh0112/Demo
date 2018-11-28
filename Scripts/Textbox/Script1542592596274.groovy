import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import java.sql.ResultSet as ResultSet

WebUI.openBrowser('')
//Test for commit and push code
'1. Go to [Simple Form Demo] Screen'
WebUI.navigateToUrl(url)

WebUI.waitForElementVisible(findTestObject('SelEasy/Logo'), 10)

WebUI.maximizeWindow()

WebUI.delay(2)

'2. Enter message'
WebUI.sendKeys(findTestObject('SelEasy/TextBoxMessage'), message)

WebUI.delay(2)

WebUI.click(findTestObject('SelEasy/ShowMessageBtn'))

WebUI.delay(2)

'3. Verify the value of textbox with sepcified value'
WebUI.verifyElementText(findTestObject('SelEasy/TextBoxDisplay'), message)

CustomKeywords.'com.database.DemoMySql.connectDB'(GlobalVariable.DBCon, GlobalVariable.DBName, GlobalVariable.Port, GlobalVariable.Username, 
    GlobalVariable.Password)

CustomKeywords.'com.database.DemoMySql.execute'('SELECT Description FROM Static_Content WHERE Type_Testing = \"textbox\"')

CustomKeywords.'com.database.DemoMySql.closeDatabaseConnection'()

