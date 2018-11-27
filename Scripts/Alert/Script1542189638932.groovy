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
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser('')

'1. Go to Alert Demo Screen'
WebUI.navigateToUrl(url)

WebUI.waitForElementVisible(findTestObject('SelEasy/Logo'), 10)

WebUI.maximizeWindow()

WebUI.delay(2)

'2. Click on the second [Click me!] button'
WebUI.click(findTestObject('SelEasy/Click me'))

WebUI.delay(2)

//'Option1 - Getting the text from the alert and storing it in Variable'
//alertText = WebUI.getAlertText(FailureHandling.STOP_ON_FAILURE)
//Need to import DriverFactory and WebDriver
'3.1. Option2 - Getting the text from the alert and storing it in Variable'
WebDriver driver = DriverFactory.getWebDriver()

String alertText = driver.switchTo().alert().getText()

'3.2. Verify Alert Text'
WebUI.verifyMatch(alertText, 'Press a button!', false)

'4. Click on [OK] from Alert'
WebUI.acceptAlert(FailureHandling.STOP_ON_FAILURE)

'5. Verify you clicked on [OK]'
WebUI.verifyElementText(findTestObject('SelEasy/Confirm Demo'), 'You pressed OK!')

WebUI.delay(3)

'6. Click on the second [Click me!] button'
WebUI.click(findTestObject('SelEasy/Click me'))

WebUI.delay(2)

'7. Click on [Cancel] from Alert'
WebUI.dismissAlert()

'8. Verify you clicked on [Cancel]'
WebUI.verifyElementText(findTestObject('SelEasy/Confirm Demo'), 'You pressed Cancel!')

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('SelEasy/Prompt Box Button'), 2)

'9. Click on [Click for Prompt Box] button'
WebUI.click(findTestObject('SelEasy/Prompt Box Button'))

WebUI.delay(2)

WebUI.setAlertText(String_Input)

//driver.switchTo().alert().sendKeys('Linh Test')
WebUI.delay(2)

'10. Input text into prompt popup - Linh Test'
WebUI.acceptAlert()

WebUI.scrollToElement(findTestObject('SelEasy/Prompt Box Button'), 2)

'11. Verify inputted text'
String Result = WebUI.concatenate(((['You have entered \'', String_Input, '\' !']) as String[]), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('SelEasy/Prompt Demo Result'), Result)

WebUI.closeBrowser()

