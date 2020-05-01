package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constant {

	public static final int implicitWaitTimeout = 180;
	public static final String currentDirectory = System.getProperty("user.dir");
	public static final String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	public static final String currentTime = new SimpleDateFormat("HH-mm-ss").format(new Date());
	public static final String language = "EN";
	public static final String chromeDriverPath = currentDirectory + "\\Drivers\\chromedriver.exe";
	public static final int sleepTimeout = 0;
	public static final String countryCode = "+965";
	public static final String applicationUrl = "http://qc.precisionlandtrack.com";
	public static final String toastHeader = "//*[@id='toast-container']/div/div[1]";
	public static final String toastMeassage = "//*[@id='toast-container']/div/div[2]";
	public static final int languageCount=12;
	public static final int rideTypeCount=2;
	public static final String dateFormat="dd/MM/yyyy";
}
