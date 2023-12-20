package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.GenericUtils;
import java.util.List;

public class ToDoHomePage {
	public WebDriver driver;

	public ToDoHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By titleHeader = By.xpath("//h1[text()='todos']");
	By inputTextBox = By.xpath("//header/input[1]");
	By webLinks = By.xpath("//a");
	By listofToDos = By.xpath("//ul[@class='todo-list']/li");
	By editToDoList = By.xpath("//ul[@class='todo-list']/li[@class='editing']");
	By completedToDos = By.xpath("//ul[@class='todo-list']/li[@class='completed']");
	By toggleCheckBox = By.xpath("//input[@class='toggle']");
	By countToDoItems = By.xpath("//span[@class='todo-count']/strong");
	By clearCompletedButton = By.xpath("//button[@class='clear-completed']");
	By destroyButton = By.xpath("//button[@class='destroy']");

	public String getTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public String getHeader() {
		return GenericUtils.getTextOfWebElement(titleHeader);
	}

	public Boolean checkInputBoxExists() {
		return GenericUtils.checkElementPresent(inputTextBox);
	}

	public Integer getCountOfFooterLinks() {
		return driver.findElements(webLinks).size();
	}

	public Integer getItemLeftCount() {
		return Integer.parseInt(GenericUtils.getTextOfWebElement(countToDoItems));
	}

	public Integer getCompletedTasksCount() {
		return driver.findElements(completedToDos).size();
	}

	public Integer todoRows() {
		return driver.findElements(listofToDos).size();
	}

	public void clickClearCompleted() {
		driver.findElement(clearCompletedButton).click();
	}

	public void clickDestroy() {
		GenericUtils.moveToElement(driver.findElement(listofToDos));
		driver.findElement(destroyButton).click();
	}
	
	public boolean checkToDoTasksExists() {
		return GenericUtils.checkElementPresent(listofToDos);
	}
	
	public boolean checkCompletedTasksExists() {
		return GenericUtils.checkElementPresent(completedToDos);
	}

	public void clickOnToggles() {
		List<WebElement> toggles = driver.findElements(toggleCheckBox);
		for (WebElement ele : toggles) {
			ele.click();
		}
	}

	public void addItemsToDo(String todoTasks) {
		WebElement inputBox = GenericUtils.explicitWait(inputTextBox);
		inputBox.click();
		inputBox.sendKeys(todoTasks);
		inputBox.sendKeys(Keys.ENTER);
	}
	
	public void addBlankItems() {
		WebElement inputBox = driver.findElement(inputTextBox);
		inputBox.click();
		inputBox.sendKeys(Keys.ENTER);
		inputBox.sendKeys(Keys.SPACE);
		inputBox.sendKeys(Keys.ENTER);		
	}
}
