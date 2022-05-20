Feature: Explore

  Scenario: Successful Explore
    Given being logged
    When i click the explore link
    Then messages are loaded

  Scenario: Incorrect traslate
    Given being logged
    When i click the explore link
    And click traslate button
    Then error msg server appears

   Scenario: Correct Traslate
     Given being logged
     When i click the explore link
     And click traslate button
     Then not msg server error appears

  Scenario: Can visit the users profiles
    Given being logged
    When i click the explore link
    And click profile button
    Then profile appears