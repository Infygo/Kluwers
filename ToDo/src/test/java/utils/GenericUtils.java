package utils;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	public static WebElement getWebElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static String getTextOfWebElement(By locator) {
		return getWebElement(locator).getText();
	}

	public static WebElement explicitWait(By locator) {
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return expWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void emptyTaskInputBox(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element)
		.click()
		.keyDown(Keys.SHIFT)
		.keyDown(Keys.HOME)
		.sendKeys(element, Keys.BACK_SPACE)
		.build().perform();
	}
	
	public static void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public static void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick().build().perform();
	}
	

	public static boolean checkElementPresent(By locator) {
		if(driver.findElements(locator).isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}

}
