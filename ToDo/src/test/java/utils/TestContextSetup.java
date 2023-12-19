package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class TestContextSetup {
	public WebDriver driver;
	public BaseDriverSetup baseDriver;
	public GenericUtils genericUtils;

	public TestContextSetup() throws IOException {
		baseDriver = new BaseDriverSetup();
		genericUtils = new GenericUtils(baseDriver.driverManager());
	}

}
