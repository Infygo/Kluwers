package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", 
				 glue = "stepDefinitions", 
				 tags = "@Positive or @Negative", 
				 plugin = {
						 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
						 "html:target/cucumberreport.html",
						 "json:target/cucumberreport.json", }, 
				 monochrome = true)
public class TestngTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
