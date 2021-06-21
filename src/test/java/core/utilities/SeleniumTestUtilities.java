package core.utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.Scenario;

public class SeleniumTestUtilities {

	private static WebDriver driver;
	
	
	
	private static int totalPlaceOrderAmount;
	
	
	public SeleniumTestUtilities(WebDriver driv, Scenario sce)
	{
		this.driver = driv;
		
	}

	public static void main(String[] args) throws Exception {

		// Create a new instance of the Firefox driver

		String userDir = System.getProperty("user.dir");

		System.out.println(userDir);

		System.setProperty("webDriver.chrome.driver", userDir + "/drivers/chromedriver");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		// Put a Implicit wait, this means that any search for elements on the page
		// could take the time the implicit wait is set for before throwing exception

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		// Launch the Online Store Website

		driver.get("https://www.demoblaze.com/index.html");

		userSelectProduct("Sony vaio i5");

		userSelectProduct("Dell i7 8gb");

		userAddToCart();

		userDeleteFromCart("Dell i7 8gb");

		userPlaceOrder();

		userPlaceOrderDetails();

		// userValidatePlaceOrderDetails();

		/*
		 * driver.findElement(By.xpath("//div//a[contains(text(),'Sign in')]")).click();
		 * 
		 * //Create a new User Account
		 * 
		 * createNewAccount();
		 * 
		 * driver.findElement(By.xpath("//div//a[contains(text(),'Sign in')]")).click();
		 * 
		 * // Print a Log In message to the screen
		 * 
		 * System.out.println("LogOut Successfully");
		 */

		// Close the driver

		driver.quit();

	}

	public static void userSelectProduct(String productsDetails) throws Exception {
		
		String productsDetailsXpath = "//div//a[contains(text(),'" + productsDetails + "')]";

		clickEventByXpath("//div//a[contains(text(),'Laptops')]");

		clickEventByXpath(productsDetailsXpath);

		clickEventByXpath("//div//a[contains(text(),'Add to cart')]");

		userConfirmSelectProduct();

		clickEventByXpath("//div//a[contains(text(),'Home')]");

	}
	
	public static void userConfirmSelectProduct() throws Exception {
	
		Thread.sleep(3000);
	
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert data: " + alertText);
		alert.accept();

	}
	
	public static void userAddToCart() throws Exception {

		clickEventByXpath("//div//a[contains(text(),'Cart')]");

	}

	public static void userPlaceOrder() throws Exception {

		Thread.sleep(3000);

		clickEventByXpath("//div//button[contains(text(),'Place Order')]");

	}

	public static void userDeleteFromCart(String productsDetails) throws Exception {

		int rowNum = driver
				.findElements(
						By.xpath("//div//table[@class='table table-bordered table-hover table-striped']//tbody//tr"))
				.size();

		int colNum = driver
				.findElements(By
						.xpath("//div//table[@class='table table-bordered table-hover table-striped']//thead//tr//th"))
				.size();

		System.out.println("Total number of rows = " + rowNum);
		System.out.println("Total number of columns = " + colNum);

		// div//table[@class='table table-bordered table-hover table-striped']

		boolean flag = false;

		// Locate 'Product Table' table using xpath
		WebElement ProdcutTable = driver
				.findElement(By.xpath("//div//table[@class='table table-bordered table-hover table-striped']"));

		// Get all web elements by tag name 'tr'
		List<WebElement> rowHeaderVals = ProdcutTable.findElements(By.xpath("//thead//tr"));
		List<WebElement> rowBodyVals = ProdcutTable.findElements(By.xpath("//tbody//tr"));

		// Get column header values from first row
		List<WebElement> colHeader = rowHeaderVals.get(0).findElements(By.xpath("th"));
		// Loop through the header values and print them to console
		System.out.println("Header values:");
		for (int i = 0; i < colHeader.size(); i++) {
			System.out.println(colHeader.get(i).getText());
		}

		System.out.println("---------------");
		// Loop through the remaining rows
		for (int i = 0; i < rowNum; i++) {
			// Get each row's column values by tag name
			List<WebElement> colVals = rowBodyVals.get(i).findElements(By.xpath("td"));
			// Loop through each column
			for (int j = 0; j < colNum; j++) {
				// Print the coulumn values to console
				System.out.println(colVals.get(j).getText());

				if (colVals.get(j).getText().equalsIgnoreCase(productsDetails)) {
					flag = true;
				}

				if (flag == true && colVals.get(j).getText().equalsIgnoreCase("Delete")) {

					String productsDetailsXpath = ".//td[text() = '" + productsDetails
							+ "']/following-sibling::td/a[text() = 'Delete']";

					clickEventByXpath(productsDetailsXpath);

					break;
				}
			}
			// Just a separator for each row
			System.out.println("---------------");
		}

	}

	public static void userPlaceOrderDetails() throws Exception {

		sendKeyValueByID("name", "Vikas Singh");

		sendKeyValueByID("country", "India");

		sendKeyValueByID("city", "Delhi");

		sendKeyValueByID("card", "376539809001004");

		sendKeyValueByID("month", "02");

		sendKeyValueByID("year", "26");

		clickEventByXpath("//div//button[contains(text(),'Purchase')]");

		userValidatePlaceOrderDetails();

		clickEventByXpath("//div//button[contains(text(),'OK')]");

	}

	public static void userValidatePlaceOrderDetails() throws Exception {

		String PlaceOrderDetails = driver.findElement(By.xpath("//div//p[@class='lead text-muted ']")).getText();

		String[] PlaceOrderDetailsArray = PlaceOrderDetails.split("\\n");

		String[] AmountDetails = PlaceOrderDetailsArray[1].split(" ");

		System.out.println(
				"userValidatePlaceOrderPaymentDetails  " + PlaceOrderDetailsArray[0] + " " + PlaceOrderDetailsArray[1]);

		int Amount = Integer.parseInt(AmountDetails[1]);

		if (Amount == totalPlaceOrderAmount)
			System.out.println("Amount == totalPlaceOrderAmount ");
		else
			System.out.println("Amount == totalPlaceOrderAmount ");

	}

	public static void sendKeyValueByID(String webElementId, String elementValue) {
		WebElement webElement = driver.findElement(By.id(webElementId));

		webElement.click();

		webElement.sendKeys(elementValue);

	}

	public static void sendKeyValueByXpath(String webElementId, String elementValue) {
		WebElement webElement = driver.findElement(By.xpath(webElementId));

		webElement.click();

		webElement.sendKeys(elementValue);

	}

	/**
	 * @Description : This method is used for selecting combo value from
	 *              ComboDropDown
	 * @param elementProperties
	 * @param option
	 * @return void
	 * @throws Exception
	 */
	public static void selectDropDownValueByID(String webElementId, String elementValue) throws Exception {
		{

			WebElement webElement = driver.findElement(By.id(webElementId));

			boolean optionFound = false;

			try {

				Select selector = new Select(webElement);
				List<WebElement> options = selector.getOptions();
				int index = 0;

				for (WebElement element : options) {
					String optionText = element.getText();

					if (optionText.trim().equals(elementValue)) {
						optionFound = true;
						break;
					} else
						index++;
				}

				// assertThat(optionFound,equalTo(true));

				if (optionFound == true)
					selector.selectByIndex(index);

			} catch (AssertionError | Exception e) {
				e.getMessage();
			}

		}
	}

	public static void clickEventByID(String webElementId) {
		WebElement webElement = driver.findElement(By.id(webElementId));

		webElement.click();

	}

	public static void clickEventByXpath(String webElementId) {
		WebElement webElement = driver.findElement(By.xpath(webElementId));

		webElement.click();

	}
	
	public static void clickEventByXpath(String webElementId, WebDriver driver, Scenario  scenario) {
		
		String productsDetailsXpath = "//div//a[contains(text(),'" + webElementId + "')]";
		
		WebElement webElement = driver.findElement(By.xpath(productsDetailsXpath));

		webElement.click();
		
		captureScreenShot( driver,   scenario);

	}
	
	
  public static void clickEventButtonByXpath(String webElementId, WebDriver driver, Scenario  scenario) {
		
		String productsDetailsXpath = "//div//button[contains(text(),'" + webElementId + "')]";
		
		WebElement webElement = driver.findElement(By.xpath(productsDetailsXpath));

		webElement.click();
		
		captureScreenShot( driver,   scenario);

	}
	
	
  public static void deleteEventByXpath(String productsDetailsXpath, WebDriver driver, Scenario  scenario) {
		
		WebElement webElement = driver.findElement(By.xpath(productsDetailsXpath));

		webElement.click();

	}
	
	
	
	public static void userConfirmSelectProduct(WebDriver driver, Scenario  scenario) throws Exception {
		
		Thread.sleep(3000);
	
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert data: " + alertText);
		alert.accept();

	}
	
	
  
	
	public static void captureScreenShot( WebDriver driver, Scenario  scenario) {
		
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		byte[] data = screenShot.getScreenshotAs(OutputType.BYTES);
		scenario.embed(data, "image/png");
		
	}
	
	
	public static void userPlaceOrder(WebDriver driver, Scenario  scenario) throws Exception {

		Thread.sleep(3000);

		

		clickEventByXpath("//div//button[contains(text(),'Place Order')]", driver,  scenario);

	}
	
	
	public static void userDeleteFromCart(String productsDetails, WebDriver driver, Scenario  scenario) throws Exception {

		int rowNum = driver
				.findElements(
						By.xpath("//div//table[@class='table table-bordered table-hover table-striped']//tbody//tr"))
				.size();

		int colNum = driver
				.findElements(By
						.xpath("//div//table[@class='table table-bordered table-hover table-striped']//thead//tr//th"))
				.size();

		System.out.println("Total number of rows = " + rowNum);
		System.out.println("Total number of columns = " + colNum);

		// div//table[@class='table table-bordered table-hover table-striped']

		boolean flag = false;

		// Locate 'Product Table' table using xpath
		WebElement ProdcutTable = driver
				.findElement(By.xpath("//div//table[@class='table table-bordered table-hover table-striped']"));

		// Get all web elements by tag name 'tr'
		List<WebElement> rowHeaderVals = ProdcutTable.findElements(By.xpath("//thead//tr"));
		List<WebElement> rowBodyVals = ProdcutTable.findElements(By.xpath("//tbody//tr"));

		// Get column header values from first row
		List<WebElement> colHeader = rowHeaderVals.get(0).findElements(By.xpath("th"));
		// Loop through the header values and print them to console
		System.out.println("Header values:");
		for (int i = 0; i < colHeader.size(); i++) {
			System.out.println(colHeader.get(i).getText());
		}

		System.out.println("---------------");
		// Loop through the remaining rows
		for (int i = 0; i < rowNum; i++) {
			
			// Get each row's column values by tag name
			List<WebElement> colVals = rowBodyVals.get(i).findElements(By.xpath("td"));
			// Loop through each column
			for (int j = 0; j < colNum; j++) {
				// Print the coulumn values to console
				System.out.println(colVals.get(j).getText());

				if (colVals.get(j).getText().equalsIgnoreCase(productsDetails)) {
					flag = true;
				}

				if (flag == true && colVals.get(j).getText().equalsIgnoreCase("Delete")) {

					String productsDetailsXpath = ".//td[text() = '" + productsDetails + "']/following-sibling::td/a[text() = 'Delete']";

					deleteEventByXpath(productsDetailsXpath, driver,  scenario);
					
					totalPlaceOrderAmount = Integer.parseInt(driver.findElement(By.id("totalp")).getText());
					
					Thread.sleep(3000);
	
					break;
				}
			}
			// Just a separator for each row
			System.out.println("---------------");
		}

	}
	
	
	public static void userPlaceOrderDetails(WebDriver driver, Scenario  scenario) throws Exception {

		sendKeyValueByID("name", "Vikas Singh", driver);

		sendKeyValueByID("country", "India", driver);

		sendKeyValueByID("city", "Delhi", driver);

		sendKeyValueByID("card", "376539809001004", driver);

		sendKeyValueByID("month", "02", driver);

		sendKeyValueByID("year", "26", driver);

	}
	
	
	public static void userValidatePlaceOrderDetails(WebDriver driver, Scenario  scenario) throws Exception {
		
		userValidatePlaceOrderDetails(driver);
	}
	
	
	public static void sendKeyValueByID(String webElementId, String elementValue, WebDriver driver) {
		WebElement webElement = driver.findElement(By.id(webElementId));

		webElement.click();

		webElement.sendKeys(elementValue);

	}
	
	public static void userValidatePlaceOrderDetails(WebDriver driver) throws Exception {

		String PlaceOrderDetails = driver.findElement(By.xpath("//div//p[@class='lead text-muted ']")).getText();

		String[] PlaceOrderDetailsArray = PlaceOrderDetails.split("\\n");

		String[] AmountDetails = PlaceOrderDetailsArray[1].split(" ");

		System.out.println(
				"userValidatePlaceOrderPaymentDetails  " + PlaceOrderDetailsArray[0] + " " + PlaceOrderDetailsArray[1]);

		int Amount = Integer.parseInt(AmountDetails[1]);

		if (Amount == totalPlaceOrderAmount)
			System.out.println("Amount == totalPlaceOrderAmount ");
		else
			System.out.println("Amount != totalPlaceOrderAmount ");

	}
	
	

}
