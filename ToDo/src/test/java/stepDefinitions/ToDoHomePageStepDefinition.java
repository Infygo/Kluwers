package stepDefinitions;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
	private List<String> updateTasks;

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
			Assert.assertTrue(rows.equals(todoHomePage.todoRows()));
		}
	}

	@Then("User checks the count of tasks to be done {int}")
	public void todoTasksCount(Integer count) {
		Assert.assertEquals(count, todoHomePage.getItemLeftCount());
	}

	@Then("User deletes all tasks {int}")
	public void deleteTasks(Integer tasksToDelete) {
		for (int i = 0; i < tasksToDelete; i++) {
			todoHomePage.clickDestroy();
		}
	}

	@And("Check if tasks are deleted")
	public void checkIfTasksExists() {
		Assert.assertFalse(todoHomePage.checkToDoTasksExists());
	}
	
	@And("Check if task is not added")
	public void checkIfTasksNotAdded() {
		Assert.assertFalse(todoHomePage.checkToDoTasksExists());
	}
	
	@And("Mark the tasks as Done")
	public void markTasksToDone() {
		todoHomePage.clickOnToggles();
	}
	
	@Then("Check if the tasks are marked Completed {int}")
	public void checkDoneTasks(Integer doneTasksCount) {
		Assert.assertEquals(doneTasksCount, todoHomePage.getCompletedTasksCount());
	}
	
	@Then("User clicks on Clear Completed button")
	public void clearTasks() {
		todoHomePage.clickClearCompleted();
		Assert.assertFalse(todoHomePage.checkCompletedTasksExists());
	}
	
	@And("Check if {int} Duplicate tasks are added")
	public void duplicateTasks(Integer duplicateTasks) {
		Assert.assertNotEquals(duplicateTasks,todoHomePage.getItemLeftCount());
	}
	
	@Then("Add empty , input space tasks to the todo list")
	public void addEmptyTasks() {
		todoHomePage.addBlankItems();
	}
	
	@And("User refreshes the browsing window")
	public void refreshWindow() {
		GenericUtils.refreshWindow();
	}

}
