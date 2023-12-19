package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriverSetup {
	public WebDriver driver;

	public WebDriver driverManager() throws IOException {
		String propsFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties";
		String chromeDriverPath = System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe";
		String geckoDriverPath = System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe";

		FileInputStream fis = new FileInputStream(propsFilePath);
		Properties props = new Properties();
		props.load(fis);

		String homeUrl = props.getProperty("todoAppUrl");
		String browser_from_propfile = props.getProperty("browser");
		String browser_from_maven = System.getProperty("browser");

		String browser = browser_from_maven != null ? browser_from_maven : browser_from_propfile;

		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", geckoDriverPath);
				driver = new FirefoxDriver();
			}
			
			driver.get(homeUrl);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		}
		return driver;
	}

	public void quitDriver() {
		driver.quit();
	}
}
