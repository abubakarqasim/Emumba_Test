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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://weathershopper.pythonanywhere.com/')

WebUI.click(findTestObject('Object Repository/button_Buy moisturizers'))

WebUI.click(findTestObject('Object Repository/button_Add'))

WebUI.click(findTestObject('Object Repository/button_Cart - 1 item(s)'))

WebUI.click(findTestObject('Object Repository/span_Pay with Card'))

WebUI.setText(findTestObject('Object Repository/input_Pay INR 199.00_email'), 'abubakarqasim2518@gmail.com')

WebUI.setText(findTestObject('Object Repository/input_Pay INR 199.00_card_number'), '4242 4242 4242 4242')

WebUI.setText(findTestObject('Object Repository/input_Pay INR 199.00_cc-exp'), '03 / 23')

WebUI.setText(findTestObject('Object Repository/input_Pay INR 199.00_cc-csc'), '123')

WebUI.setText(findTestObject('Object Repository/input_Pay INR 199.00_zip'), '44000')

WebUI.click(findTestObject('Object Repository/span_Pay INR 199.00'))

