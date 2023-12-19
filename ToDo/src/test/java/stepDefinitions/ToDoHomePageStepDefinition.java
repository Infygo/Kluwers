package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectManager;
import pageObjects.ToDoHomePage;
import utils.GenericUtils;
import utils.TestContextSetup;

public class ToDoHomePageStepDefinition {
	public WebDriver driver;
	TestContextSetup testContext;
	PageObjectManager pageObjectManager;
	GenericUtils genericUtils;

	public ToDoHomePage todoHomePage;

	public ToDoHomePageStepDefinition(TestContextSetup testContext) {
		this.testContext = testContext;
		todoHomePage = testContext.pageObjectManager.getToDoHomePage();
	}

	@Given("User is on the ToDo app home page")
	public void checkHomePage() {
		Assert.assertTrue(todoHomePage.getPageUrl().contains("angular2"));
	}

	@When("Page is loaded with the header {string} title {string}")
	public void checkHeaderTitle(String header, String title) {
		Assert.assertTrue(todoHomePage.getHeader().equals(header));
		Assert.assertTrue(todoHomePage.getTitle().equals(title));
	}

	@Then("User checks inputbox is present")
	public void user_checks_header_inputbox() {
		Assert.assertTrue(todoHomePage.checkInputBoxExists());
	}

	@And("User checks the footer notes links {int}")
	public void checkFooterNotesLinks(Integer numberOfLinks) {
		Assert.assertTrue(numberOfLinks == todoHomePage.getCountOfFooterLinks());
	}

	@Then("Add tasks to the ToDo app")
	public void addTasksToDo(DataTable dataTable) {
		List<Map<String, String>> tasks = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : tasks) {
			String todoTasks = row.get("Task");
			Integer rows = Integer.parseInt(row.get("rowid"));
			todoHomePage.addItemsToDo(todoTasks);
			Assert.assertTrue("Checks if each task is added", rows.equals(todoHomePage.todoRows()));
		}
	}

	@Then("User checks the count of tasks to be done {int}")
	public void todoTasksCount(Integer count) {
		Assert.assertEquals(count, todoHomePage.getItemLeftCount());
	}

}
