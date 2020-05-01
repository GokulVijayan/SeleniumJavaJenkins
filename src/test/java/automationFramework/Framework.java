package automationFramework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.Gson;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import report.TestReport;
import report.TestReportSteps;
import utility.CaptureScreenshot;
import utility.Constant;

public class Framework {

	/**
	 * Retrieve report file
	 * 
	 * @param classLoader
	 * @param fileName-
	 *            input json file name
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static List<TestReportSteps> getReportFile(ClassLoader classLoader, String fileName)
			throws IOException, ClassNotFoundException {
		TestReport testReport;
		Gson gson = new Gson();
		List<TestReportSteps> listOfReport;
		URL Selector = ClassLoader.getSystemResource(fileName);

		InputStream SelectorStream = Selector.openStream();
		BufferedReader reportReader = new BufferedReader(new InputStreamReader(SelectorStream, "UTF-8"));

		testReport = gson.fromJson(reportReader, TestReport.class);

		listOfReport = testReport.getTestReportSteps();
		return listOfReport;

	}
	
	
	
	

	
	public static WebElement elementSelectorUsingLocator(WebDriver driver, WebDriverWait wait, String by, String locator)
	{
		WebElement element = null;
		switch(by) {
		case "id": 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
			element = (WebElement) driver.findElement(By.id(locator));
			break;
		case "className":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
			element = (WebElement) driver.findElement(By.className(locator));
			break;
		case "xpath":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			element = (WebElement) driver.findElement(By.xpath(locator));
			break;
		case "linkText":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
			element = (WebElement) driver.findElement(By.linkText(locator));
			break;
		case "cssSelector":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
			element = (WebElement) driver.findElement(By.cssSelector(locator));
			break;
		case "tagName":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator)));
			element = (WebElement) driver.findElement(By.tagName(locator));
			break;
		case "partialLinkText":
			element = (WebElement) driver.findElement(By.partialLinkText(locator));
			break;
		}
		return element;
		
	}


	/**
	 * Retrieve screenshot file path
	 * 
	 * @param name
	 *            - name of screenshot file
	 * @return absolute path of screenshot file
	 */
	public static String getScreenshotPath(String name) {
		return Constant.currentDirectory + "\\Results\\Screenshots\\" + name
				+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "\\" + name
				+ new SimpleDateFormat("HH-mm-ss").format(new Date()) + "\\" + name + ".png";
	}
	
	/**
	 * Retrieve tesseract screenshot file path
	 * 
	 * @param name
	 *            - name of screenshot file
	 * @return absolute path of screenshot file
	 */
	public static String getTesseractPath(String name) {
		return Constant.currentDirectory + "\\Results\\TesseractScreenshots\\" + name
				+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "\\" + name
				+ new SimpleDateFormat("HH-mm-ss").format(new Date()) + "\\" + name + ".png";
	}
	
	
	/**
	* Capture error screenshot and return filePath of screenshot
	* 
	* @param name
	* - name of screenshot file
	* @return absolute path of screenshot file
	* @throws Exception 
	*/
	public static String getErrorScreenshot(AppiumDriver<MobileElement> driver, WebDriverWait wait) throws Exception {

	String filePath = Framework.getScreenshotPath("Error");
	CaptureScreenshot.takeSingleSnapShot(driver, filePath, wait);
	return filePath;
	}
	
	
	/**
	 * Retrieve ui map and test data input
	 * 
	 * @param classLoader
	 * @param fileName
	 *            - input json file name
	 * @param fullyQualifiedClassName
	 *            - class file to which input json is converted
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static <T> Object getInputJson(String fileName, String fullyQualifiedClassName)
			throws ClassNotFoundException, IOException {
		Gson gson = new Gson();
		Class<?> classType = Class.forName(fullyQualifiedClassName);

		URL Selector = ClassLoader.getSystemResource(fileName);

		InputStream SelectorStream = Selector.openStream();
		BufferedReader brSelector = new BufferedReader(new InputStreamReader(SelectorStream, "UTF-8"));

		Object selectorCaseObj = gson.fromJson(brSelector, classType);

		return selectorCaseObj;
	}
	
	
	public static void checkForElementVisibility(WebDriver driver, WebDriverWait wait, String by, String locator)
	{
		switch(by) {
		case "id": 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
			break;
		case "className":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
			break;
		case "name":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
			break;
		case "xpath":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			break;
		case "linkText":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
			break;
		case "cssSelector":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
			break;
		case "tagName":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator)));
			break;
		case "partialLinkText":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
			break;
		}
		
	}
	
	public static void checkForElementInVisibility(WebDriver driver, WebDriverWait wait, String by, String locator)
	{
		switch(by) {
		case "id": 
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(locator)));
			break;
		case "className":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(locator)));
			break;
		case "name":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(locator)));
			break;
		case "xpath":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
			break;
		case "linkText":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(locator)));
			break;
		case "cssSelector":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(locator)));
			break;
		case "tagName":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName(locator)));
			break;
		case "partialLinkText":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.partialLinkText(locator)));
			break;
		}
		
	}

	/**
	 * Capture screenshot and return filePath of screenshot in operator Portal
	 * 
	 * @param name
	 *            - name of screenshot file
	 * @return absolute path of screenshot file
	 * @throws Exception 
	 */
	public static String takeScreenshot(WebDriver driver, WebDriverWait wait, String name) throws Exception {
		
		String filePath = Framework.getScreenshotPath(name);
		CaptureScreenshot.takeSingleSnapShot(driver, filePath, wait);
		return filePath;
	}
	
	
	
}
