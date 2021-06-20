package core.utilities;

import org.openqa.selenium.WebDriver;


public class BrowserHelper {

	public static final int CHROME_OBJECT_SYNC_DEFAULT_TIMEOUT = 6;
	public static final int OBJECT_SYNC_DEFAULT_TIMEOUT = 20;
	
	
		public static void overrideDriver(WebDriver webDriver) {
			driver =webDriver;
		}
		public static boolean doesDriverExist() {
			return !(driver == null);
		}


	private static WebDriver driver = null;

	public static WebDriver initialiseDriver(String Browser) throws Exception {
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Creating a new driver");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");

		driver = getDriver(Browser);
		
		
		return  driver;
	}

	
	public static WebDriver getDriver(String Browser)
			throws Exception {
		
		String deviceType ="DESKTOP";

		WebDriver driver = null;
		switch (deviceType) {
		case "DESKTOP":
			driver =  WebDriverFactory.getDriver(Browser);
			break;
			
		default:
			throw new Exception("Exception initialising driver");
		}

		return driver;
	}
	
}
