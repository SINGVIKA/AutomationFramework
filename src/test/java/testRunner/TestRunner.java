package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
 features = "src/test/resources/features", 
 glue={"stepdefinitions"}, 
 tags="@Login", monochrome = true,
	plugin = {"pretty", "json:target/cucumber-json/cucumber.json" ,"html:target/cucumber-maven-report" }


 
		)
 
public class TestRunner {
	
	
 
}
