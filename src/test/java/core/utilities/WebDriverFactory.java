package core.utilities;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;


public class WebDriverFactory {

	
	public static final int CHROME_OBJECT_SYNC_DEFAULT_TIMEOUT = 20;
	
	public static final int OBJECT_SYNC_DEFAULT_TIMEOUT = 20;

	static WebDriver driver = null;

	public static WebDriver getDriver(String browser)
			throws Exception {

		
		String deviceType = "DESKTOP";
		String driverType = "Local";
		
		
		switch (deviceType) {
		case "DESKTOP":
			driver = getDesktopDriver(driverType, browser);
			break;
	
		default:
			throw new Exception("Exception initialising driver");
		}

		return driver;
	}
	
	


	private static WebDriver getDesktopDriver(String driverType, String browser) throws Exception {
		//int objectTimeout = 0;
		
		WebDriver driver = null;
	

			
			switch (browser.toUpperCase()) {
			case "CHROME":
				driver = initialiseChromeDriver();
				//objectTimeout = CHROME_OBJECT_SYNC_DEFAULT_TIMEOUT;
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

				break;
			

			default:
				throw new Exception("Exception initialising driver for browser: " + browser);
			}
		
		return driver;
	}

	
	private static WebDriver initialiseChromeDriver() throws MalformedURLException {
		WebDriver driver;

		
			driver = initialiseLocalChromeDriver();
		

		return driver;
	}
	

	private static WebDriver initialiseLocalChromeDriver() {
		
		String userDir = System.getProperty("user.dir");

		System.out.println(userDir);

		System.setProperty("webDriver.chrome.driver", userDir+"/drivers/chromedriver");

		return new ChromeDriver(setChromeCapability());
	}
	
	private static ChromeOptions setChromeCapability() {
			
			ChromeOptions options = new ChromeOptions();
			
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			
	
			return options;
		}

	

}
