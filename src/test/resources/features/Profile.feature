Feature:Profile

  Scenario: Edit profile
    Given be logged in
    When I input my profile changes
    And click on send button
    Then the alert of changes made appears
