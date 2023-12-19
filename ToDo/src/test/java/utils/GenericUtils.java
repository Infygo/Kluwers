package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	public static WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement getWebElement(WebElement locator) {
		return locator;
	}
	
	public static WebElement explicitWait(By locator) {
		 WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 return expWait.until(ExpectedConditions.visibilityOfElementLocated(locator));		
	}

	public static void actionMouseMovement(WebElement locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(locator)).build().perform();
	}

	public static boolean checkElementPresent(WebElement locator) {
		locator = getWebElement(locator);
		try {
			if (locator.isDisplayed()) {
				System.out.println("element is present");
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
