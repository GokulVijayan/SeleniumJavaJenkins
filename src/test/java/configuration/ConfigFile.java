package configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;

public class ConfigFile {
	
	
	public static String language;
	public static WebDriverWait wait;
	public static WebDriver driver;
	

	/**
	 * Retrieve chrome driver path specified in constant file
	 * @return driverPath if driverPath != null else return RuntimeException
	 */
	public static String getChromeDriverPath() {
		String driverPath = Constant.chromeDriverPath;
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("DriverPath not specified in the constant file.");
	}
	
	/**
	 * Retrieve chrome driver
	 */
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	/**
	 * Initialize paxWeb or portal web application.Set driver property, configurations and launch the browser.
	 */
	@SuppressWarnings("deprecation")
	public static void initializeTest( )
	{

			
			ChromeOptions chromeOptions= new ChromeOptions();
			//chromeOptions.setBinary("C:\\Users\\gokul.vijayan\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
			chromeOptions.setBinary("C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
			System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
			driver = new ChromeDriver(chromeOptions); 
			driver.manage().window().maximize();
			
		
			System.out.println("Chrome browser launched successfully");
	}
	
	public static JSONArray RetrieveTestData(String fileName) throws IOException, JSONException
    {
		String path1 = "src/test/resources";
		 
		File file = new File(path1);
		String path = file.getAbsolutePath()+"\\TestData\\"+fileName;
		String data = new String(Files.readAllBytes(Paths.get(path))); 
		
        JSONObject obj = new JSONObject(data);
        JSONArray testData = obj.getJSONArray("TestData");
        
        return testData;
    }
	
	public static JSONObject RetrieveUIMap(String fileName) throws IOException, JSONException
    {
		String path1 = "src/test/resources";
		 
		File file = new File(path1);
		String path = file.getAbsolutePath()+"\\uiMap\\"+fileName;
		String data = new String(Files.readAllBytes(Paths.get(path))); 
		
        JSONObject obj = new JSONObject(data);
        
        return obj;
    }
	
	
}
