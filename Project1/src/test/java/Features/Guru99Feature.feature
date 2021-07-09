Feature: Guru99 application
Alert handling

  Background: 
    Given launch the browser
  
  @AcceptAlert
  Scenario: Verify the alert accept 
     When I launch guru99 application
      And I enter the "123" customerid
      And I click on submit button
     Then I verify "Do you really want to delete this Customer?" message is displayed and click on "ok" in the alert window
     
  @DismissAlert
  Scenario: Verify the alert accept 
     When I launch guru99 application
      And I enter the "123" customerid
      And I click on submit button
     Then I verify "Do you really want to delete this Customer?" message is displayed and click on "cancel" in the alert window