Feature: Logout

  Scenario: Successful logout
    Given being logged
    When i click the logout button
    Then the inputs to login should be displayed