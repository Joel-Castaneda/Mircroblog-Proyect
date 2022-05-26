Feature:Profile

  Scenario: Edit profile
    Given being logged
    When I input my profile changes
    And click on send button
    Then the alert of changes made appears
