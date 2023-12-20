package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", 
				 glue = "stepDefinitions", 
				 tags = "@Positive or @Negative",
				 plugin = {"html:target/cucumber-report.html",
						    "json:target/cucumber-report.json", 
						    }, 
				 monochrome = true)
public class TestngTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
