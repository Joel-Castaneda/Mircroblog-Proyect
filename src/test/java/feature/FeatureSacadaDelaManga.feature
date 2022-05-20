Feature: De la manga


  Scenario: Scenario 1
    Given I am logged in the application
    When I publish a comment
    Then I can see the comment in the main page
