Feature: Validate Positive E2E scenarios & functionalities of the TODO app

  Background: 
    Given User is on the ToDo app home page
    Then Add tasks to the ToDo app
      | Task              | rowid |
      | Exams preparation |     1 |
      | FlightTickets     |     2 |
      | Check !@$%^&*     |     3 |
      |        1234567890 |     4 |
      | Groceries         |     5 |

  @UiCheck @Positive
  Scenario Outline: Validate the UI , Header, InputBox & Footer links
    When Page is loaded with the header <Header> title <Title>
    Then User checks inputbox is present
    And User checks the footer notes links <FooterLinks>

    Examples: 
      | Title                | Header  | FooterLinks |
      | "Angular2 • TodoMVC" | "todos" |           4 |

  @AddTasks @Positive
  Scenario Outline: Add tasks to the app and validate the count of tasks to be done
    Then User checks the count of tasks to be done <ItemsLeft>

    Examples: 
      | ItemsLeft |
      |         5 |

  @DeleteTasks @Positive
  Scenario Outline: Check if the tasks can be deleted using cross button
    Then User checks the count of tasks to be done <TaskCount>
    Then User deletes all tasks <TaskCount>
    And Check if tasks are deleted

    Examples: 
      | TaskCount |
      |         5 |

  @DoneTasks @Positive
  Scenario Outline: Check if the tasks can be marked done using toggle button
    And Mark the tasks as Done
    Then Check if the tasks are marked Completed <TaskCount>
    And User checks the count of tasks to be done <ItemsLeft>

    Examples: 
      | TaskCount | ItemsLeft |
      |         5 |         0 |

  @ClearCompleted @Positive
  Scenario Outline: Checks if the tasks completed can be Cleared
    And Mark the tasks as Done
    Then User clicks on Clear Completed button
    And Check if tasks are deleted

  @UnCheckDoneTask @Positive
  Scenario Outline: Check if a done task can be unchecked and change reflects
    And Mark the tasks as Done
    Then User checks the count of tasks to be done <ItemsLeft>
    And Mark the tasks as Done
    Then User checks the count of tasks to be done <ItemsLeftUpdated>

    Examples: 
      | ItemsLeft | ItemsLeftUpdated |
      |         0 |                5 |
