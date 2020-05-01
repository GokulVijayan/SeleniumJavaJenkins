package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CaptureScreenshot {

	static boolean IsScreenshotCaptured = true;

	/**
	 *  Take non scrollable screenshot and save it in filePath specified
	 * @param webdriver - web driver used
	 * @param filePath - path for saving screenshot
	 * @param wait - wait for capturing screenshot for 'wait' seconds
	 * @throws Exception
	 */
	
	public static void takeSingleSnapShot(AppiumDriver<MobileElement> driver, String filePath, WebDriverWait wait) throws Exception
	{

		if (driver.toString().contains("(null)"))
			IsScreenshotCaptured = false;
		else if (filePath.isEmpty())
			IsScreenshotCaptured = false;
		else 
		{
			System.out.println("Capture screenshot of page");

			// Convert web driver object to TakeScreenshot
			TakesScreenshot screenshot = ((TakesScreenshot) driver);

			// Call getScreenshotAs method to create image file
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

			// Move image file to new destination
			File destinationFile = new File(filePath);

			// Copy file at destination
			FileUtils.copyFile(sourceFile, destinationFile);

			IsScreenshotCaptured = true;
			if (IsScreenshotCaptured == true) {
				System.out.println("Screenshot of page captured successfully");
			} else {
				System.out.println("Screenshot of page can't be captured");
			}
		}
		
	}
	/**
	 *  Take non scrollable screenshot and save it in filePath specified
	 * @param webdriver - web driver used
	 * @param filePath - path for saving screenshot
	 * @param wait - wait for capturing screenshot for 'wait' seconds
	 * @throws Exception
	 */
	
	public static void takeSingleSnapShot(WebDriver webdriver, String filePath, WebDriverWait wait) throws Exception
	{

		boolean IsScreenshotCaptured;
		if (webdriver.toString().contains("(null)"))
			IsScreenshotCaptured = false;
		else if (filePath.isEmpty())
			IsScreenshotCaptured = false;
		else 
		{
			System.out.println("Capture screenshot of page");

			// Convert web driver object to TakeScreenshot
			TakesScreenshot screenshot = ((TakesScreenshot) webdriver);

			// Call getScreenshotAs method to create image file
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

			// Move image file to new destination
			File destinationFile = new File(filePath);

			// Copy file at destination
			FileUtils.copyFile(sourceFile, destinationFile);

			IsScreenshotCaptured = true;
			if (IsScreenshotCaptured == true) {
				System.out.println("Screenshot of page captured successfully");
			} else {
				System.out.println("Screenshot of page can't be captured");
			}
		}
		
	}
	
}
