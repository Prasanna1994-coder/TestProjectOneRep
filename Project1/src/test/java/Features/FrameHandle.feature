Feature: Handling the frame

  Background: 
    Given launch the browser

  Scenario: How to handle the frame
    When I launch frame handle application
    And I enter "Prasanna" and "Ushavenki@1994" in the login page
    And I click on submit button in frame handler site
