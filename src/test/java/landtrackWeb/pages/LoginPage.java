package landtrackWeb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationFramework.Framework;
import configuration.ConfigFile;
import landtrackWeb.genericComponenets.ReusableComponentsWeb;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import report.TestReportSteps;
import utility.CaptureScreenshot;


public class LoginPage {

	public static List<TestReportSteps> listOfReport = null;
	public static JSONObject selector;
	static String otp;
	static int noOfWords;
	static ClassLoader classLoader;
	static String filePath, paxNumber;
	public static List<String> screenshotPath = new ArrayList<String>();
	static String numberInProfilePage = "",nameInHomePage;
	static boolean isUserVerified = true;

	public LoginPage() throws IOException, JSONException 
    {
		selector = ConfigFile.RetrieveUIMap("LoginPageSelector.json");
	}
	
    /// <summary>
    /// Login to iMAAP web application
    /// </summary>
    /// <param name="inputjson"></param>
    /// <returns></returns>
    public  List<TestReportSteps> LoginToApplication(WebDriver driver, WebDriverWait wait, JSONObject inputjson) throws ClassNotFoundException, IOException
    {
    	
    	listOfReport = Framework.getReportFile(classLoader,"report/LoginReport.json");
    	int step = 0;
    	
        try
        {
        	ReusableComponentsWeb.sendKeys(driver, wait, inputjson.get("username").toString(), "xpath", selector.get("username").toString());
        	listOfReport.get(step++).setActualResultFail("");
        	
        	ReusableComponentsWeb.sendKeys(driver, wait, inputjson.get("password").toString(), "xpath", selector.get("password").toString());
        	listOfReport.get(step++).setActualResultFail("");
        	
        	 filePath = Framework.getScreenshotPath("Enter Details");
 			CaptureScreenshot.takeSingleSnapShot(driver, filePath, wait);
 			screenshotPath.add(filePath);		    
 		    listOfReport.get(step++).setActualResultFail("");
        	
        	ReusableComponentsWeb.click(driver, wait, "xpath", selector.get("loginButton").toString());
        	listOfReport.get(step++).setActualResultFail("");
        	
        	ReusableComponentsWeb.waitUntilElementVisibility(driver, wait, "xpath", selector.get("verifyLogin").toString());
        	listOfReport.get(step++).setActualResultFail("");
        	
        	
        	ReusableComponentsWeb.waitUntilElementInvisibility(driver, wait, "xpath", selector.get("loader").toString());
        	listOfReport.get(step++).setActualResultFail("");
        
        	filePath = Framework.getScreenshotPath("Verify Login");
  			CaptureScreenshot.takeSingleSnapShot(driver, filePath, wait);
  			screenshotPath.add(filePath);		    
  		    listOfReport.get(step++).setActualResultFail("");
         	
			
        	
        	return listOfReport;

        }
        catch (Exception e)
        {
        
        }
        return listOfReport;
    }
    
    public List<String> getFilePath()
	{
		return screenshotPath;
	}
    
    
  

}
