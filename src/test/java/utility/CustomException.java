package utility;




import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

@SuppressWarnings("serial")
public class CustomException extends RuntimeException{
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	public CustomException(String message)
	  {

	
	  }
	public CustomException(String by, String locator,Throwable cause) {
		System.out.println(cause);
		switch(by) {
		case "id": 
			wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.id(locator)));
			break;
		case "className":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.className(locator)));
			break;
		case "name":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.name(locator)));
			break;
		case "xpath":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath(locator)));
			break;
		case "linkText":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.linkText(locator)));
			break;
		case "cssSelector":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.cssSelector(locator)));
			break;
		case "tagName":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.tagName(locator)));
			break;
		case "partialLinkText":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.partialLinkText(locator)));
			break;
		}
	}
	
}
