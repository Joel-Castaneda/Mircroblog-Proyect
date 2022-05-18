Feature: Follow other profiles

  Scenario: Follow succesful
    Given being logged
    When select other profile
    And click on follow
    Then follow-up message

  Scenario: Stop following
    Given being logged
    When select other profile
    And click stop following
    Then not following message
