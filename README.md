# Kluwers Test Automation Framework for ToDoApp
Light weight ToDo app and development of Cucumber Test Automation framework to test the ToDo app
- [About](#about)
- [FrameworkDesign](#frameworkdesign)
- [Features](#features)
- [Testcases](#testcases)
- [Execution](#execution)
- [TestResults](#testresults)
- [Reporting](#reports)
- [Utils](#utils)

## About
- The Automation framework for testing the ToDo app is developed and implemented in Cucumber BDD with Gherkin syntax making it easier for the test scenarios to be understood in simple english
- Automation is implemented in Selenium with Java 
- Framework is developed using Page object pattern facilitating easy segregation of methods and locators specific for the page
- Stepdefinition implementing and validating the steps from the feature file 
- Maven build management tool is used 
- TestRunner is implemented with TestNG
- Assertions using Testng asserts
- Reporting in the Framework is achieved using Extentreport , html and json format
- Test cases can be executed in either chrome or firefox browser based on the maven browser parameter passed in the maven command
- browser and url parameters are set in the properties file and can be overrided from maven command line

## FrameworkDesign 
- The Framework is designed to support Page object factory pattern
- feature package - will hold the feature files with the positive , negative scenarios
- pageObject package - will hold the pageobjects for each page and a pageobject manager
- runner package - will hold the test runner file where the feature, stepdefinition and tagging is glued along with reporting plugins
- stepdefintion package - will hold dedicated step definition for each methods and actions performed on each page along with the hooks file
- utils package - holds the common generic methods that can be used across the framework
- resources folder - will have the driver files, properties files
- Reporting - framework supports extentreports, html and json
![image](https://github.com/Infygo/WoltersKluwers/assets/39874937/1f674491-eeca-4c9a-b303-37a78a7475ab)

## Features 
- ToDo tasks / Items can be added to the app
- Count of ToDo tasks is displayed
- Toggle can marked to make a task complete
- Completed tasks can be cleared using the Clear completed button
- Tasks can be deleted using the delete button

## Testcases
- Automation test cases are created for Positive scenarios and Negative scenarios that are listed below
- PositiveScenario.feature file will have the background and only positive E2E scenarios with tagging **@Positive**
- NegativeScenario.feature file will have only negative scenarios with tagging **@Negative**
- With the tagging concept the runner can be adjusted to execute only positive or negative scenarios or both based on the execution requirement 

### Positive Scenarios 
#### Background (Prerequisite)
- List of tasks can be added in the todo app - Task data with different types such as text, number, special characters are added

#### Scenario1 @UiCheck
- ToDo app UI is validated in terms of number of links, headers and title url
#### Scenario2 @AddTasks
- Tasks are added to the app
- Tasks to be done (Item left) is validated and verified
#### Scenario3 @DeleteTasks
- Tasks added to the app are deleted using the delete button
- Check and assert if all the tasks are deleted
#### Scenario4 @DoneTasks
- Tasks added to the app are marked done using the toggle button 
- Check and assert if all the tasks are marked to done
- Check and asserts if items left count matches
#### Scenario5 @ClearCompleted
- Tasks added to the app are marked done using the toggle button 
- Completed tasks are cleared using the clear button
- Check and asserts tasks are cleared
#### Scenario6 @UnCheckDoneTask
- Tasks added to the app are marked done using the toggle button 
- User unchecks the marked tasks
- Check and asserts unchecked tasks are added to items left count


### Negative Scenarios
#### Scenario1 @duplicateTasks
- Tasks with same name are added
- Check if the duplicate tasks are added
- Test fails if the duplicate tasks are added to the app if there is no validation on duplication of tasks
#### Scenario2 @blankcase  
- Tasks are tried to add which has only space characters
- Test passes if app doesnt allow blank , space characters to be added as tasks
#### Scenario3 @minmax
- Tasks are added with min character of size 1
- Task is added with a max character of approx 50 char count
#### Scenario4 @refresh
- Tasks is added to app and then window refreshed to see if the data still holds after page refresh
- Tested refresh with Marking tasks as Done, Deleting, Clearing completed options
  
## Execution
### Execution1 using IDE 
- git clone the repo https://github.com/Infygo/WoltersKluwers.git
- open the Project ToDo in Eclipse / IntelliJ Ide
- Navigate to - ToDo\src\test\java\runner\TestngTestRunner.java
- Right click on the TestngTestRunner.java
- Run as TestNG Test

### Execution2 using command line 
- Prerequisite
  - Download apache maven https://maven.apache.org/download.cgi -> apache-maven-3.9.6-bin.zip
  - Extract zip folder to a location - Add the bin directory of the extracted Maven folder to your system's PATH environment variable.
  - Open the System Properties dialog (Right-click on This PC or Computer, select Properties, then click on "Advanced system settings")- Click the "Environment Variables" button - Under "System variables," find and select the Path variable, then click "Edit."
  - Click "New" and add the path to the bin directory (e.g., C:\Program Files\Apache\apache-maven-3.x.x\bin)
  - check installation success running the command mvn -v in command prompt
    
- git clone the repo **https://github.com/Infygo/WoltersKluwers.git**
- Change directory in the command prompt to the project folder location - cd .\ToDo
- run the command: **mvn clean**
- Once the build is success
- run the command for chrome execution : **mvn test -Dcucumber.filter.tags="@Positive or @Negative" -Dbrowser=chrome**
- run the command for firefox execution : **mvn test -Dcucumber.filter.tags="@Positive or @Negative" -Dbrowser=firefox**
- the execution of above command will execute both the positive and negative test case scenarios 
- Tests will start getting executed and browser invocation will be triggered automatically

## TestResults 
### Positive scenarios 
- All the 6 scenarios will pass
### Negative scenarios 
- 1 test case will fail since the app allows duplicate tasks to be added
- 3 test cases will pass as they work as expected

## Reporting 
### Reports 
- Extentsreports are configured offering rich reporting experience - Open the Spark.html file under ExtentReport folder
  ![image](https://github.com/Infygo/WoltersKluwers/assets/39874937/d223490c-4db2-46d3-92f2-6acae53165f7)

- Json and html reports are also generated as part of the framework
  ![image](https://github.com/Infygo/WoltersKluwers/assets/39874937/8ecea387-7ebf-40e9-a42f-b03222c0ff43)

## Utils
- Screenshots of failing scenarios are taken and appended to the extent report






