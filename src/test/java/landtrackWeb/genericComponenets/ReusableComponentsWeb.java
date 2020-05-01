package landtrackWeb.genericComponenets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import java.util.NoSuchElementException;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationFramework.Framework;

import org.openqa.selenium.interactions.Actions;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utility.Constant;

import org.openqa.selenium.support.ui.Select;

public class ReusableComponentsWeb {
	private static WebElement element = null;
	static JSONObject jsonObject;
	static int count;
	
	/**
	 * Tap the element specified
	 * 
	 * @param driver
	 *            - web driver
	 * @param wait
	 *            - Wait timeout in seconds
	 * @param elementId
	 *            - Id of element to be clicked
	 * @throws Exception
	 */
	public static void click(WebDriver driver, WebDriverWait wait, String by, String locatorString) throws Exception {
		try {
			element = (WebElement) Framework.elementSelectorUsingLocator(driver, wait, by, locatorString);
			element.click();

		} catch (Exception e) {
			System.out.println("Click operation failed");
			throw (e);
		}
	}

	/**
	 * Send input data specified to the element specified
	 * 
	 * @param driver
	 *            - web driver
	 * @param wait
	 *            - Wait timeout in seconds
	 * @param inputData
	 *            - input data to send
	 * @param elementId
	 *            - id of web element
	 * @throws Exception
	 */
	public static void sendKeys(WebDriver driver, WebDriverWait wait, String inputData, String by, String locatorString)
			throws Exception {
		try {
			element = (WebElement) Framework.elementSelectorUsingLocator(driver, wait, by, locatorString);
			element.sendKeys(inputData);

		} catch (Exception e) {
			System.out.println("Sendkeys operation failed");
			throw (e);
		}
	}

	/**
	 * Wait until element is invisible
	 * 
	 * @param driver
	 *            - web driver
	 * @param wait
	 *            - Wait timeout in seconds
	 * @param elementId
	 *            - id of web element
	 * @throws Exception
	 */
	public static void waitUntilElementInvisibility(WebDriver driver, WebDriverWait wait, String by,
			String locatorString) throws Exception {
		try {
			Framework.checkForElementInVisibility(driver, wait, by, locatorString);
		} catch (Exception e) {
			System.out.println("Invisibility Check failed");
			throw (e);
		}
	}

	/**
	 * Wait until element is visible
	 * 
	 * @param driver
	 *            - web driver
	 * @param wait
	 *            - Wait timeout in seconds
	 * @param elementId
	 *            - id of web element
	 * @throws Exception
	 */
	public static void waitUntilElementVisibility(WebDriver driver, WebDriverWait wait, String by, String locatorString)
			throws Exception {
		try {
			Framework.checkForElementVisibility(driver, wait, by, locatorString);
		} catch (Exception e) {
			System.out.println("Visisbility Check failed");
			throw (e);
		}
	}

	/**
	 * Retrieve text
	 * 
	 * @param driver
	 *            - web driver
	 * @param wait
	 *            - Wait timeout in seconds
	 * @param elementId
	 *            - Id of element to be clicked
	 * @return
	 * @throws Exception
	 */
	public static String RetrieveText(WebDriver driver, WebDriverWait wait, String by, String locatorString)
			throws Exception {
		try {
			WebElement element = Framework.elementSelectorUsingLocator(driver, wait, by, locatorString);
			String text = element.getText();
			return text;
		} catch (Exception e) {
			System.out.println("Text retrieval failed");
			throw (e);
		}
	}

	/**
	 * Compare text1 and text2.Returns true if both texts match and return false
	 * otherwise
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 * @throws Exception
	 */
	public static boolean CompareText(String text1, String text2) throws Exception {
		try {
			text1 = text1.trim().replaceAll("^\\s+", "").replaceAll("\\s++$", "");
			text2 = text2.trim().replaceAll("^\\s+", "");
			int result = (text1).compareToIgnoreCase(text2);
			if (result == 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println("Text comparison failed");
			throw (e);
		}
	}

	/**
	 * Return true if text1 contains text - text2 and flase otherwise
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 * @throws Exception
	 */
	public static boolean ContainsText(String text1, String text2) throws Exception {
		try {
			text1 = text1.trim().replaceAll("^\\s+", "").replaceAll("\\s++$", "");
			text2 = text2.trim().replaceAll("^\\s+", "");
			boolean result = (text1).contains(text2);
			return result;

		} catch (Exception e) {
			System.out.println("Text comparison failed");
			throw (e);
		}
	}

	/**
	 * Clear data specified to the element specified
	 * 
	 * @param driver
	 *            - web driver
	 * @param wait
	 *            - Wait timeout in seconds
	 * @param elementId
	 *            - id of web element
	 * @throws Exception
	 */
	public static void clearText(WebDriver driver, WebDriverWait wait, String by, String locatorString)
			throws Exception {
		try {
			((RemoteWebElement) Framework.elementSelectorUsingLocator(driver, wait, by, locatorString)).clear();

		} catch (Exception e) {
			System.out.println("Clear Text operation failed");
			throw (e);
		}
	}

	/**
	 * Format the date time in specified format
	 * 
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static String retieveFormattedDateTime(String format) throws Exception {
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			Date dateObject = new Date();
			String formattedCurrentDateTime = dateFormat.format(dateObject);
			return formattedCurrentDateTime;
		} catch (Exception e) {
			System.out.println("Formatting failed");
			throw (e);
		}
	}

	/**
	 * Retrieve minute difference between ride start time (format1 "HH:mm") and ride
	 * end time (format2 "HH:mm")
	 * 
	 * @param startTime
	 *            - ride start time in "HH:mm" format
	 * @param endTime
	 *            - ride end time in "HH:mm" format
	 * @return
	 * @throws Exception
	 */
	public static String retieveRideMinuteDifference(String startTime, String endTime) throws Exception {
		Date d1 = null;
		Date d2 = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");

			d1 = format.parse(startTime);
			d2 = format.parse(endTime);

			// in milliseconds
			long diff = d2.getTime() - d1.getTime();
			long diffMinutes = diff / (60 * 1000) % 60;

			return String.valueOf(diffMinutes);
		} catch (Exception e) {
			System.out.println("Formatting failed");
			throw (e);
		}
	}

	/**
	 * Scrolls and moves to the element specified and click on it
	 * 
	 * @param driver
	 *            - Web driver
	 * @param wait
	 *            - Wait timeout in seconds
	 * @param elementXpath
	 *            - xpath of element to be clicked
	 * @throws Exception
	 */
	public static void scrollClickAction(WebDriver driver, WebDriverWait wait, String elementXpath) throws Exception {
		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		} catch (Exception e) {
			System.out.println("Click action operation failed");
			throw (e);
		}
	}

	/**
	 * Swipe from specified first element to second element
	 * 
	 * @param driver
	 * @param elementLocator1-Locator
	 *            string of first element
	 * @param elementLocator2-Locator
	 *            string of second element
	 * @throws Exception
	 */
	public static void swipeFromElementToElement(WebDriver driver, WebDriverWait wait, String byElementlocator1,
			String elementLocator1, String byElementlocator2, String elementLocator2) throws Exception {
		try {
			WebElement element1 = Framework.elementSelectorUsingLocator(driver, wait, byElementlocator1,
					elementLocator1);
			WebElement element2;

			element2 = Framework.elementSelectorUsingLocator(driver, wait, byElementlocator2, elementLocator2);

			@SuppressWarnings("rawtypes")
			TouchAction action = new TouchAction((PerformsTouchActions) driver);
			int x1 = element1.getLocation().getX();
			int y1 = element1.getLocation().getY();

			int x2 = element2.getLocation().getX();
			int y2 = element2.getLocation().getY();

			action.press(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					.moveTo(PointOption.point(x2, y2)).release().perform();
		} catch (Exception e) {
			System.out.println("Swipe operation failed");
			throw (e);
		}
	}

	/**
	 * Scrolls and moves to the element specified and click on it
	 * 
	 * @param driver
	 *            - Web driver
	 * @param wait
	 *            - Wait timeout in seconds
	 * @param elementXpath
	 *            - xpath of element to be clicked
	 * @throws Exception
	 */
	public static void scrollIntoView(WebDriver driver, WebDriverWait wait, String elementXpath) throws Exception {
		try {
			WebElement element = driver.findElement(By.xpath(elementXpath));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		} catch (Exception e) {
			System.out.println("Scroll into view operation failed");
			throw (e);
		}
	}

	public static boolean select(WebDriver driver, WebDriverWait wait, String selectData, String dropdownXpath) {
		WebElement mySelectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath)));
		Select dropdown = new Select(mySelectElement);
		try {
			dropdown.selectByVisibleText(selectData);
			return true;
		} catch (Exception e) {
			System.out.println("User was not able to select value from list");
			return false;
		}

	}

	public static boolean verifyToast(WebDriver driver, WebDriverWait wait, String toastHeaderText, String toastMessage)
			throws Exception {
		String actualMessage = RetrieveText(driver, wait, "xpath", Constant.toastMeassage);
		String toastHeader = RetrieveText(driver, wait, "xpath", Constant.toastHeader);

		if (toastHeader.equalsIgnoreCase(toastHeaderText)) {
			if (actualMessage.equalsIgnoreCase(toastMessage)) {
				return true;
			}
		}
		return false;
	}

	public static String getString(int size) {
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(size, useLetters, useNumbers);
		return generatedString;
	}

	/**
	 * Click the element specified using javascript executor
	 * 
	 * @param driver
	 *            - Web driver
	 * @param wait
	 *            - Wait timeout in seconds
	 * @param elementXpath
	 *            - xpath of element to be clicked
	 */

	public static boolean JEClick(WebDriver driver, WebDriverWait wait, String XPath) throws Exception {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath)));
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				return true;
			} else {
				return false;
			}
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			return false;

		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static void picker(WebDriver driver, WebDriverWait wait, String dateSelector) {
		String className = "wj-day-othermonth";
		int dayOfMonth, maxDays;
		String path;
		WebElement elem = null;
		try {
			Calendar cal = Calendar.getInstance();
			dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
			maxDays = new GregorianCalendar().getActualMaximum(Calendar.DAY_OF_MONTH);
			if (dayOfMonth < 30)
				dayOfMonth++;
			else if (dayOfMonth == 30 && maxDays == 31)
				dayOfMonth = 31;
			else if (dayOfMonth == 30 && maxDays == 30)
				dayOfMonth = 1;
			else if (dayOfMonth == 31)
				dayOfMonth = 1;
			path = String.valueOf(dayOfMonth);
			WebElement dateWidgetFrom = wait
					.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(dateSelector))));
			// This are the columns of the from date picker table
			List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
			List<WebElement> col = dateWidgetFrom.findElements(By.className(className));
			columns.removeAll(col);
			for (WebElement cell : columns) {
				if (cell.getText().equals(path)) {
					elem = cell;
					new Actions(driver).moveToElement(elem).click().perform();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("User was not able to select date from calender");
		}

	}

	public static void currentDatePicker(WebDriver driver, WebDriverWait wait, String dateSelector) {
		String className = "wj-day-othermonth";
		int dayOfMonth;
		String path;
		WebElement elem = null;
		try {
			Calendar cal = Calendar.getInstance();
			dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

			path = String.valueOf(dayOfMonth);
			WebElement dateWidgetFrom = wait
					.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(dateSelector))));
			// This are the columns of the from date picker table
			List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
			List<WebElement> col = dateWidgetFrom.findElements(By.className(className));
			columns.removeAll(col);
			for (WebElement cell : columns) {
				if (cell.getText().equals(path)) {
					elem = cell;
					new Actions(driver).moveToElement(elem).click().perform();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("User was not able to select date from calender");
		}

	}

	public static boolean upload(WebDriver driver, WebDriverWait wait, String uploadSelector) throws IOException {

		try {
			WebElement elem = driver.findElement(By.xpath(uploadSelector));
			new Actions(driver).moveToElement(elem).click().perform();
			Runtime.getRuntime().exec(Constant.currentDirectory + "\\testexecute.exe");
			return true;
		} catch (Exception e) {
			System.out.println("User was not able to upload document");
			return false;
		}

	}

	public static boolean selectByText(WebDriver driver, WebDriverWait wait, String selectData,
			String dropdownDownButton, String dropdownUpButton, String listXpath, String labelXpath) throws Exception {
		// Initialize local variables
		int listCount = 0;
		String[] inputData = selectData.split(",");

		// Click dropdown button
		click(driver, wait, "xpath", dropdownDownButton);

		// Get list of elements in the dropdown
		listCount = getElementCount(driver, wait, listXpath);

		for (int i = 1; i <= listCount; i++) {
			String xpath = listXpath + "[" + i + "]" + labelXpath;
			String text = driver.findElement(By.xpath(xpath)).getText();

			// Check for input test data in the dropdown list
			if (Arrays.asList(inputData).contains(text)) {
				// Select the input data in the list
				try {
					click(driver, wait, "xpath", dropdownDownButton);
				} catch (Exception e) {
					System.out.println("Unable to select from dropdown list");
					return false;
				}
			}
		}
		click(driver, wait, "xpath", dropdownUpButton);
		return true;
	}

	/**
	 * Retrieve count of list of elements using input xpath of element specified
	 * 
	 * @param driver
	 *            - Web driver
	 * @param wait
	 *            - Wait timeout in seconds
	 * @param elementXpath
	 *            - xpath of web element
	 * @return
	 */
	public static int getElementCount(WebDriver driver, WebDriverWait wait, String elementXpath) {
		try {
			List<WebElement> element = driver.findElements(By.xpath(elementXpath));
			count = element.size();
			return count;
		} catch (Exception e) {
			System.out.println("Retrieve element count operation failed");
			return count;
		}

	}

	public static void selectFromDropDown(WebDriver driver, WebDriverWait wait, String selectData,
			String dropdownButton, String listXpath, int count) throws Exception {

		// Initialize local variables
		int listCount = 0;
		String[] inputData = selectData.split(",");

		// Click dropdown button
		click(driver, wait, "xpath", dropdownButton);

		// Get list of elements in the dropdown
		listCount = count;

		for (int i = 1; i <= listCount; i++) {
			String xpath = listXpath + "/div[" + i + "]/label";
			String text = driver.findElement(By.xpath(xpath)).getText();

			// Check for input test data in the dropdown list
			if (Arrays.asList(inputData).contains(text)) {
				// Select the input data in the list
				try {
					click(driver, wait, "xpath", xpath);
					return;

				} catch (Exception e) {
					System.out.println("Unable to select from dropdown list");
				}
			}
		}
		// click(driver, wait,"xpath", dropdownButton);

	}
	
	public static void selectFromDropDown(WebDriver driver, WebDriverWait wait, String selectData, String listXpath, int count) throws Exception {
		
		//Initialize local variables
				int listCount = 0;
				String[] inputData = selectData.split(",");
				
				
				//Get list of elements in the dropdown
				listCount = count;
				
				for (int i = 1; i <= listCount; i++) 
				{
					String xpath = listXpath+"/div[" + i + "]/label";
					String text = driver.findElement(By.xpath(xpath)).getText();
					
					//Check for input test data in the dropdown list
					if (Arrays.asList(inputData).contains(text)) 
					{
						//Select the input data in the list
						try
						{
							click(driver, wait,"xpath", xpath);
							return;
							
						}
						catch(Exception e)
						{
							System.out.println("Unable to select from dropdown list");
						}
					}
				}
				//click(driver, wait,"xpath", dropdownButton);
		
	}

	public static void pickNextDay(WebDriver driver, WebDriverWait wait, String dateSelector) {
		String className = "wj-day-othermonth";
		int dayOfMonth;
		String path;
		WebElement elem = null;
		try {
			Calendar cal = Calendar.getInstance();
			dayOfMonth = cal.get(Calendar.DAY_OF_MONTH) + 1;

			path = String.valueOf(dayOfMonth);
			WebElement dateWidgetFrom = wait
					.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(dateSelector))));
			// This are the columns of the from date picker table
			List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
			List<WebElement> col = dateWidgetFrom.findElements(By.className(className));
			columns.removeAll(col);
			for (WebElement cell : columns) {
				if (cell.getText().equals(path)) {
					elem = cell;
					new Actions(driver).moveToElement(elem).click().perform();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("User was not able to select date from calender");
		}

	}

	public static void setFocus(WebDriver driver, WebDriverWait wait, String by, String locatorString) {
		try {
			element = (WebElement) Framework.elementSelectorUsingLocator(driver, wait, by, locatorString);
			new Actions(driver).moveToElement(element).perform();
		} catch (Exception e) {
			System.out.println("User was not able to focus to an element");
		}

	}

	public static void scroll(WebDriver driver, WebDriverWait wait, String scrollbarSelector) {

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(scrollbarSelector)));
			EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
			eventDriver.executeScript("document.querySelector('" + scrollbarSelector + "').scrollLeft=500");
		} catch (Exception e) {
			System.out.println("User was not able to scroll the grid");
		}

	}
	public static void scrollGridLeft(WebDriver driver, WebDriverWait wait, String scrollbarSelector)
	{

		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(scrollbarSelector)));
			EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
			eventDriver.executeScript("document.querySelector('" + scrollbarSelector + "').scrollLeft=-500");
		} 
		catch (Exception e) 
		{
			System.out.println("User was not able to scroll the grid");
		}

	}
	/**
	 * selects the date specified in the test data
	 * @param driver
	 * @param wait
	 * @param dateSelector
	 * @param inputDate-the input date
	 * @param monthYearSelector-for accessing month and year
	 * @param forward -to move to next year
	 * @param backward -to move back to next year
	 * @param selectMonth -month table
	 */
	public static void datePicker(WebDriver driver, WebDriverWait wait, String dateSelector,String inputDate,String monthYearSelector,String forward,String backward,String selectMonth) {
		String className = "wj-day-othermonth",findMonth;
		int year,findYear;
		String findDay,month;
		String[]  monthYear,findMonthYear;
		try {	
			findMonthYear=inputDate.split("/");
			findDay=findMonthYear[0];
			findMonth=findMonthYear[1];
			findYear=Integer.parseInt(findMonthYear[2]);
			monthYear=RetrieveText(driver, wait,"xpath", monthYearSelector).split(" ");
			month=monthYear[0];
			year=Integer.parseInt(monthYear[1]);
			if(year==findYear && month.substring(0,3).toLowerCase()==findMonth.toLowerCase())
			{
				selectDay(driver,findDay,dateSelector,className);
			}
			else if(year==findYear)
			{
				click(driver, wait, "xpath", monthYearSelector);
				selectMonth(driver,findMonth,dateSelector,selectMonth);
				selectDay(driver,findDay,dateSelector,className);
			}
			else
			{
				if(findYear>year)
				{	
					click(driver, wait, "xpath", monthYearSelector);
					for(int i=year;i<findYear;i++)
					{
						click(driver, wait, "xpath", forward);
					}
					selectMonth(driver,findMonth,dateSelector,selectMonth);
					selectDay(driver,findDay,dateSelector,className);
					
				}
				else if(findYear<year)
				{
					click(driver, wait, "xpath", monthYearSelector);
					for(int i=findYear;i<year;i++)
					{
						click(driver, wait, "xpath", backward);
					}
					selectMonth(driver,findMonth,dateSelector,selectMonth);
					selectDay(driver,findDay,dateSelector,className);
				}
			}
		} catch (Exception e) {
			System.out.println("User was not able to select date from calender");
		}

	}
	public static void selectDay(WebDriver driver,String path,String dateSelector,String className)
	{	
		WebElement elem = null;
		WebElement dateWidgetFrom = driver.findElement(By.xpath(dateSelector));
		// This are the columns of the from date picker table
		List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
		List<WebElement> col = dateWidgetFrom.findElements(By.className(className));
		columns.removeAll(col);		
		for (WebElement cell : columns) {
			if (cell.getText().equals(path)) {
				elem = cell;
				new Actions(driver).moveToElement(elem).click().perform();
				break;
			}
		}
	}
		public static void selectMonth(WebDriver driver,String path,String dateSelector,String className)
		{	
			WebElement elem = null;
			WebElement dateWidgetFrom = driver.findElement(By.xpath(className));
			// This are the columns of the from date picker table
			List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));		
			for (WebElement cell : columns) {
				if (cell.getText().equals(path)) {
					elem = cell;
					new Actions(driver).moveToElement(elem).click().perform();
					break;
				}
			}
	}
	public static String convertDateFormat(String fromDateFormat,String toDateFormat,String dateToBeConverted) throws ParseException
	{
		DateFormat originalFormat = new SimpleDateFormat(toDateFormat);
		DateFormat targetFormat = new SimpleDateFormat(fromDateFormat);
		Date date = originalFormat.parse(dateToBeConverted);
		String formattedDate = targetFormat.format(date); 
		return formattedDate;
	}
	
	public static void selectFromOwnerDropDown(WebDriver driver, WebDriverWait wait, String selectData, String listXpath) throws Exception {
		
		//Initialize local variables
				int listCount = 0;
				String[] inputData = selectData.split(",");
				
				
				//Get list of elements in the dropdown
				listCount = 1000;
				
				for (int i = 1; i <= listCount; i++) 
				{
					String xpath = listXpath+"/div[" + i + "]";
					String text = driver.findElement(By.xpath(xpath)).getText();
					
					//Check for input test data in the dropdown list
					if (Arrays.asList(inputData).contains(text)) 
					{
						//Select the input data in the list
						try
						{
							click(driver, wait,"xpath", xpath);
							return;
							
						}
						catch(Exception e)
						{
							System.out.println("Unable to select from dropdown list");
						}
					}
				}
				//click(driver, wait,"xpath", dropdownButton);
		
	}
	
}
