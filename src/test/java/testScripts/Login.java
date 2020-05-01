
package testScripts;




import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import configuration.ConfigFile;


import landtrackWeb.pages.LoginPage;
import report.Report;
import report.TestReportSteps;
import utility.Constant;
import utility.ReportModifier;

@Listeners({ ReportModifier.class })
public class Login {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebDriverWait driverWait;
	public static String Objective;
	public static JSONArray inputjson;
	LoginPage loginPage;
	private static List<TestReportSteps> finalTestReport = new ArrayList<>();
	List<String> screenshotPath = new ArrayList<String>();
	public JSONObject listOfInputs;
	
	@BeforeTest
	public void init() throws Exception {
		Objective = "To Verify that user is able to login to landtrack application";
		

		
		ConfigFile.initializeTest();
		driver = ConfigFile.getDriver();
		driver.get(Constant.applicationUrl);
		wait = new WebDriverWait(driver, Constant.implicitWaitTimeout);
		String title= driver.getTitle();
		System.out.println(title);
		
		inputjson=ConfigFile.RetrieveTestData("LoginTest.json");
		loginPage=new LoginPage();
		
		
	}
	@Test
	public void login() throws Exception {

		List<TestReportSteps> report = null;

		for (int i = 0; i < inputjson.length(); i++) {
			listOfInputs = inputjson.getJSONObject(i);
		}	
		report = loginPage.LoginToApplication(driver, wait, listOfInputs);
		// Add report
		finalTestReport.addAll(report);		

		for (String s : loginPage.getFilePath()) {
			screenshotPath.add(s);
		}
	}
	
	
	
	@AfterTest
	public void quit() throws Exception {

		// Generate test report
		Report.WriteResultToHtml(driver, finalTestReport, screenshotPath, Objective);
		driver.quit();

	}
}
