Feature: AutomationRegisterModule

  Background: 
    Given launch the browser

  @Test1
  Scenario: Verify user can able to register
    When I launch the application
    And I Enter the below values in register page
      | Fullname | Lastname   | Address | Email-Address            | Phone      | Gender | Hobbies               | Languages              | Skills  | Country | Confirm Country | Day | Month  | Year | Password | Confirm-Password |
      | Prasanna | Venkatesan | Delhi   | prasanna.venki@gmail.com | 9898121200 | Male   | Cricket,hockey,movies | Arabic,Hindi,Ukrainian | Windows | India   | India           |  23 | August | 1994 | Test@123 | Test@123         |

  @Test2
  Scenario: Check how to handle alerts
    When I launch the application
    And I click on Switch To button
    And I click on Alerts under Switch To
