Feature: OrangeHRM

  Background: 
    Given launch the browser

  @Test1
  Scenario: Verifying the login using valid credentials
    When I launch the OrangeHRM application
    And I enter the "Admin" and "admin123"
    And I click on Submit button
    Then I verify the "OrangeHRM" page is displayed

  @OrangeTest2
  Scenario: Verify users page options under Admin
    When I launch the OrangeHRM application
    And I enter the "Admin" and "admin123"
    And I click on Submit button
    And I mouse hover to "users" option
    And I click on "User" menu
    And I enter below employee details
      | Username | User Role | Employee Name | Status  |
      | Admin    | Admin     | Paul          | Enabled |
    And I Click on search button
    Then I Verify below value is displayed
      | Username | User Role | Employee Name | Status  |
      | Admin    | Admin     | Paul          | Enabled |

  @JobTitle
  Scenario: Verify user can able to add new job title
    When I launch the OrangeHRM application
    And I enter the "Admin" and "admin123"
    And I click on Submit button
    And I mouse hover to "job" option
    And I click on "job titles" menu
    And I add the below job title
      | Title      | Description     | Notes      |
      | Test title | Description one | Notes test |