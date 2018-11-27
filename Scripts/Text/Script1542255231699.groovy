import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.sql.ResultSet as ResultSet
import com.gargoylesoftware.htmlunit.javascript.host.dom.Text as Text
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent
import java.util.List as List
import java.util.concurrent.locks.Condition as Condition
import java.util.ArrayList as ArrayList

WebUI.openBrowser('')

'1. Go to [Simple Form Demo] Screen'
WebUI.navigateToUrl(url)

WebUI.waitForElementVisible(findTestObject('SelEasy/Text'), 30)

'2. Verify text [This would be your first example to start with Selenium.] with specified value'
WebUI.verifyElementText(findTestObject('SelEasy/Text'), TextVar)

'3. Verify text [This would be your first example to start with Selenium.] with result getting from database'
CustomKeywords.'com.database.DemoMySql.connectDB'("db4free.net", "mrvautotestdb", "3306", "mrvautotestdb", "mrvautotestdb")

ResultSet queryResult = CustomKeywords.'com.database.DemoMySql.executeQuery'('SELECT Description FROM Static_Content')

queryResult.next()

String valueFromDatabase = queryResult.getString(1)

println(valueFromDatabase)

WebUI.verifyMatch(valueFromDatabase, TextVar, false)

CustomKeywords.'com.database.DemoMySql.closeDatabaseConnection'()

//Verify respones with GET
'4. Verify text [This would be your first example to start with Selenium.] with result getting from WS'
def response = ((findTestObject('Object Repository/SelEasy/GET')) as RequestObject)

List<TestObjectProperty> params = new ArrayList()

params.add(new TestObjectProperty('upc', ConditionType.EQUALS, '22369700000'))

response.setRestParameters(params)

List<TestObjectProperty> headerparams = new ArrayList()

headerparams.add(new TestObjectProperty('apikey', ConditionType.EQUALS, 'l7xxad8578ca824c49d998247d31d4efabfb'))

response.setHttpHeaderProperties(headerparams)

//Make Get Request
def result = WS.sendRequest(response)

//Verify title from response
WS.verifyElementPropertyValue(result, 'priceLocation.skuId[0]', '22369700000', FailureHandling.STOP_ON_FAILURE)

