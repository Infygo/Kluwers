package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public BaseDriverSetup baseDriver;
	public PageObjectManager pageObjectManager;
	public GenericUtils genericUtils;

	public TestContextSetup() throws IOException {
		baseDriver = new BaseDriverSetup();
		pageObjectManager = new PageObjectManager(baseDriver.driverManager());
		genericUtils = new GenericUtils(baseDriver.driverManager());
	}

}
