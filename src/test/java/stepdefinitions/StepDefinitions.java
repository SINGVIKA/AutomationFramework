package stepdefinitions;

import org.openqa.selenium.WebDriver;

import core.utilities.BrowserHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	WebDriver driver = null;
	
	@Before
	public void setup()
	{
		System.out.println("Before is executed FIRST regardless of it's placement");
	}

	@After
	public void cleanUp()
	{
		System.out.println("After is executed at LAST regardless of it's placement\n");
	}
	
	
	@Given("User is on login page")
	public void user_is_on_login_page() throws Exception {
		
		 driver = BrowserHelper.initialiseDriver("Chrome");
		 
		 driver.get("http://automationpractice.com/index.php");
	    
	}

	@Given("User clicks the Sign-in Link in header")
	public void user_clicks_the_Sign_in_Link_in_header() {
	  
	}

	@Then("User navigate to login page {string}")
	public void user_navigate_to_login_page(String string) {
	 
	}

	@When("User clicks the Sign-in button")
	public void user_clicks_the_Sign_in_button() {
	   
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
	   
	}

	@When("User clicks the {string} submit button")
	public void user_clicks_the_submit_button(String string) {
	   
	}
	
	@Then("User aspects {string} for Invalid Crederntails")
	public void user_aspects_for_Invalid_Crederntails(String string) {
	   
	}


}
