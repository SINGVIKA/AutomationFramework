package testRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
	
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) throws Exception {
		
		// Create a new instance of the Firefox driver

		String userDir = System.getProperty("user.dir");

		System.out.println(userDir);

		System.setProperty("WebDriver.chrome.driver", userDir+"/drivers/chromedriver");

		driver = new ChromeDriver();

		// Put a Implicit wait, this means that any search for elements on the page
		// could take the time the implicit wait is set for before throwing exception

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Launch the Online Store Website

		driver.get("http://automationpractice.com/index.php");
		
		
		
		driver.findElement(By.xpath("//div//a[contains(text(),'Sign in')]")).click();
		
		//Login By Existing User
		
		loginNewUser();
		
		driver.findElement(By.xpath("//div//a[contains(text(),'Sign in')]")).click();
		
		//Create a new User Account
		
		createNewAccount();
		
		driver.findElement(By.xpath("//div//a[contains(text(),'Sign in')]")).click();
		
		// Print a Log In message to the screen

		System.out.println("LogOut Successfully");

		// Close the driver

		driver.quit();

	}
	
	public static void loginNewUser() throws Exception
	{
		
		 sendKeyValueByID("email","SingVika1@gmail.com");
		 
		 sendKeyValueByID("passwd","password12345");
		 
		 clickEventByID("SubmitLogin");
	}
	
	
	public static void createNewAccount() throws Exception
	{
	    
	    sendKeyValueByID("email_create","SingVika1@gmail.com");
				
		clickEventByID("SubmitCreate");
		
		clickEventByID("id_gender1");

		sendKeyValueByID("customer_firstname","Vikas");
		
		sendKeyValueByID("customer_lastname","Singh");
		
		sendKeyValueByID("passwd","password12345");
		
		sendKeyValueByID("firstname","Vikas");
		
		sendKeyValueByID("lastname","Singh");
		
		sendKeyValueByID("company","Cognizant");
		
		sendKeyValueByID("address1","Cognizant Technology Solutions");
		
		sendKeyValueByID("address2","Teaneck");
		
		sendKeyValueByID("city","New Jersey");
		
		sendKeyValueByID("postcode","07666");
		
		sendKeyValueByID("other","N/A");
		
		selectDropDownValueByID("id_state","New Jersey");
		
		sendKeyValueByID("phone","(201) 801-0233");
		
		sendKeyValueByID("phone_mobile","+447404262519");
		
		sendKeyValueByID("alias","SingVika01");
		
		clickEventByID("submitAccount");
		
	}
	
	public static void sendKeyValueByID(String webElementId, String elementValue)
	{
		WebElement webElement = driver.findElement(By.id(webElementId));
		
		webElement.click();
		
		webElement.sendKeys(elementValue);
		
	}
	
	
	/**
	 * @Description : This method is used for selecting combo value from ComboDropDown
	 * @param elementProperties
	 * @param option
	 * @return void
	 * @throws Exception
	 */
	public static void selectDropDownValueByID(String webElementId, String elementValue) throws Exception
	{
		{
			
			WebElement webElement = driver.findElement(By.id(webElementId));
			
			boolean optionFound = false;
			
			
				try
				{
					
					Select selector = new Select(webElement);
					List<WebElement> options = selector.getOptions();
					int index = 0;
					
					for (WebElement element:options)
					{
						String optionText = element.getText();
						
						if (optionText.trim().equals(elementValue)) 
						{
							optionFound = true;
							break;
						}
						else index++;
					}
					
					//assertThat(optionFound,equalTo(true));
					
					if(optionFound==true)
					selector.selectByIndex(index);

					
				}
				catch(AssertionError | Exception e)
				{
					e.getMessage();				
				}
			
		}
	}
	
	public static void clickEventByID(String webElementId)
	{
		WebElement webElement = driver.findElement(By.id(webElementId));
		
		webElement.click();
		
	}

}
