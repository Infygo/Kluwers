package pageObjects;

import org.openqa.selenium.WebDriver;

// class dedicated for creating page objects for the pages 

public class PageObjectManager {

	public ToDoHomePage todoHomePage;
	public WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public ToDoHomePage getToDoHomePage() {
		todoHomePage = new ToDoHomePage(driver);
		return todoHomePage;
	}

}
