package stepdefinitions;

import static core.utilities.SeleniumTestUtilities.captureScreenShot;
import static core.utilities.SeleniumTestUtilities.clickEventByXpath;
import static core.utilities.SeleniumTestUtilities.userConfirmSelectProduct;
import static core.utilities.SeleniumTestUtilities.userDeleteFromCart;
import static core.utilities.SeleniumTestUtilities.userPlaceOrderDetails;
import static core.utilities.SeleniumTestUtilities.clickEventButtonByXpath;
import static core.utilities.SeleniumTestUtilities.userValidatePlaceOrderDetails;





import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import core.utilities.BrowserHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	WebDriver driver = null;

	String applicationUrl = "https://www.demoblaze.com/index.html";

	Scenario scenario;

	TakesScreenshot screenShot;
	
	@Before
	public void setup(Scenario sce) {
		this.scenario = sce;

	}

	@After
	public void cleanUp() {
		
		captureScreenShot(driver, scenario);

		BrowserHelper.killDriver();
		scenario.write("Browser is closed");
	}

	@Given("User is on {string} page")
	public void user_is_on_page(String string) throws Exception {

		driver = BrowserHelper.initialiseDriver("Chrome");
		driver.get(applicationUrl);
		scenario.write("Chrome Driver Invoked & URL Navigated as " + applicationUrl);
	}

	@When("User clicks on {string} link")
	public void user_clicks_on_link(String elementName) {

		clickEventByXpath(elementName, driver, scenario);

	}
	
	@Then("User confirm to add the prodcuts on {string}")
	public void user_confirm_to_add_the_prodcuts_on(String string) throws Exception {
	   
		userConfirmSelectProduct(driver, scenario);
	}


	@Then("User navigate to {string}")
	public void user_navigate_to(String string) {
	    
	}
	
	@Then("User wants to remove prodcuts as {string} from CartOrder")
	public void user_wants_to_remove_prodcuts_as_from_CartOrder(String elementName) throws Exception {
		userDeleteFromCart(elementName, driver, scenario);
	}
	
	@Then("User clicks on {string} button")
	public void user_clicks_on_button(String elementName) {
		
		clickEventButtonByXpath(elementName, driver, scenario);
		
	}

	
	@Then("User fills the payments details")
	public void user_fills_the_payments_details() throws Exception {
		userPlaceOrderDetails(driver, scenario);
	}

	@Then("User Validate the payment details")
	public void user_Validate_the_payment_details() throws Exception {
		userValidatePlaceOrderDetails(driver);
	}

}
