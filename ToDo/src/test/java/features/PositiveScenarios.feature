#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Validate Positive E2E scenarios & functionalities of the TODO app

  #@UiCheck
  #Scenario Outline: Validate the UI , Header, InputBox & Footer links
  #Given User is on the ToDo app home page
  #When Page is loaded with the header <Header> title <Title>
  #Then User checks inputbox is present
  #And User checks the footer notes links <FooterLinks>
  #Examples:
  #| Title                | Header  | FooterLinks |
  #| "Angular2 • TodoMVC" | "todos" |           4 |
  @AddTasks
  Scenario Outline: Add tasks to the app and validate the count of tasks to be done
    Given User is on the ToDo app home page
    Then Add tasks to the ToDo app
      | Task              | rowid |
      | Exams preparation |     1 |
      | FlightTickets     |     2 |
      | Check !@$%^&*     |     3 |
      | 1234567890        |     4 |
      | Groceries         |     5 |
    Then User checks the count of tasks to be done <Count>

    Examples: 
      | Count |
      |     5 |

  @EditAddedTask
  Scenario Outline: Edit added task in the todo app
  	Given User is on the ToDo app home page 
  	Then Add tasks to the 
