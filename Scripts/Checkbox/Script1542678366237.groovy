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
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

'1. Go to [Checkbox Demo] Screen'
WebUI.navigateToUrl('https://www.seleniumeasy.com/test/basic-checkbox-demo.html')

WebUI.waitForElementVisible(findTestObject('SelEasy/Logo'), 30)

WebUI.maximizeWindow()

WebUI.delay(2)

'2. Select the checkbox in [Single Checkbox Demo] section'
WebUI.scrollToElement(findTestObject('SelEasy/Single Checkbox Demo'), 2)

WebUI.check(findTestObject('SelEasy/Single Checkbox Demo'))

'3. Verify checkbox is selected'
WebUI.verifyElementChecked(findTestObject('SelEasy/Single Checkbox Demo'), 5)

WebUI.verifyElementText(findTestObject('SelEasy/VerifySingleCheckboxChecked'), 'Success - Check box is checked')

'4. Deselect the checkbox in [Single Checkbox Demo] section'
WebUI.uncheck(findTestObject('SelEasy/Single Checkbox Demo'))

'5. Verify checkbox is deselected'
WebUI.verifyElementNotChecked(findTestObject('SelEasy/Single Checkbox Demo'), 5)

def response = ((findTestObject('SelEasy/ServiceDemo')) as RequestObject)

def result = WS.sendRequest(response)

WS.verifyElementsCount(result, 'data.year', 3)


WS.verifyElementPropertyValue(result, 'data.year[1]', '2001', FailureHandling.STOP_ON_FAILURE)


WebUI.closeBrowser()

