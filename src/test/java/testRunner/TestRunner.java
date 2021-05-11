package testRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
 features = "src/test/resources/features", 
 glue={"src.test.java.stepdefinitions"}, 
 tags="@Login", monochrome = true,
	plugin = {"pretty", "html:target/cucumber-html-report"}


 
		)
 
public class TestRunner {
	
	/*@BeforeClass
	public static void junitsetup() {
		
		System.out.println("@beforeclass");
	}

	@AfterClass
	public static void junitendup() {
	
		System.out.println("@Afterclass");
	}*/
 
}
