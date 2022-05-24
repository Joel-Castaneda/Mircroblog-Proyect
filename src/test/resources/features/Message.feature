Feature: Message

  Scenario: Succesful message
    Given being logged
    When I write the message
    And click the send button
    Then the message is sent

  Scenario: Empty message
    Given being logged
    When I write an empty message
    And click the message button
    Then the message is not sent


