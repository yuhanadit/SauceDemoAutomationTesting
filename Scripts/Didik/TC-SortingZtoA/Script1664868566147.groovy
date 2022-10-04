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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('Trainer/TC-Login-Success'), [:], FailureHandling.STOP_ON_FAILURE)

try {
    WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Swag Labs/select_Name (A to Z)Name (Z to A)Price (low_f7e90a'), 
        'za', true)
}
catch (Exception e) {
} 

List<WebElement> webItemList = WebUI.findWebElements(findTestObject('Object Repository/Page_Swag Labs/list_judul'),10)

List<String> orilist = new ArrayList()

List<String> sortedList = new ArrayList()

for(data in webItemList) {
	println data.getText()
	orilist.add(data.getText())
	sortedList.add(data.getText())
}

//Collections.sort(sortedList) //as
Collections.sort(sortedList, Collections.reverseOrder()) //des

println "A"

if(!orilist.equals(sortedList)) {
	KeywordUtil.markFailed("Sorting Tidak Sesuai")
}
