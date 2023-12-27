Feature: Validate Negative scenarios for the TODO app

  @Negative @duplicateTasks
  Scenario: Check if duplicate tasks can be added
    Given User is on the ToDo app home page
    Then Add tasks to the ToDo app
      | Task          | rowid |
      | FlightTickets |     1 |
      | FlightTickets |     2 |
    And Check if 2 Duplicate tasks are added

  @Negative @blankcase
  Scenario: Check if blank characters, spaces can be added to todo tasks
    Given User is on the ToDo app home page
    Then Add empty , input space tasks to the todo list
    And Check if task is not added

  @Negative @minmax
  Scenario Outline: Check Minimum and Maximum characters input to the todo app
    Given User is on the ToDo app home page
    Then Add tasks to the ToDo app
      | Task                                                                                 | rowid |
      |                                                                                    1 |     1 |
      | FlightTicketsExamPreparations@1234$%^&(Laundry-Wash-CycleRepair-GROCERYSHOPPING!!!!! |     2 |
    And Mark the tasks as Done
    Then Check if the tasks are marked Completed <TaskCount>
    And User checks the count of tasks to be done <ItemsLeft>

    Examples: 
      | TaskCount | ItemsLeft |
      |         2 |         0 |

  @Negative @refresh
  Scenario Outline: Refreshing browser window holds the data entered
    Given User is on the ToDo app home page
    Then Add tasks to the ToDo app
      | Task              | rowid |
      | Exams preparation |     1 |
      | FlightTickets     |     2 |
      | Check !@$%^&*     |     3 |
    And User refreshes the browsing window
    Then User checks the count of tasks to be done <ItemsLeft>
    Then Mark the tasks as Done
    And User refreshes the browsing window
    Then Check if the tasks are marked Completed <TasksDone>
    Then User deletes all tasks <TaskCount>
    And User refreshes the browsing window
    And Check if tasks are deleted

    Examples: 
      | ItemsLeft | TasksDone | TaskCount |
      |         3 |         3 |         3 |
