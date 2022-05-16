Feature: Login

  Scenario: Successful Login
    Given Test page is not down
    When i write my information
    And i click the login button
    Then a welcome message pops up

  Scenario: Wrong username
    Given Test page is not down
    When i enter an username not registered with a password
    And i click the login button
    Then an error message appears

  Scenario: Wrong password
    Given Test page is not down
    When i enter a registered username with a wrong password
    And i click the login button
    Then an error message appears

  Scenario: click the checkbox
    Given Test page is not down
    When i write my information with the checkbox marked
    And i click the login button
    And i click on log out
    Then my information should appear already writen
