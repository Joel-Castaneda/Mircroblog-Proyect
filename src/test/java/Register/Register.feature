Feature: Register

  Scenario: Successful register
    Given Test page is not down
    When i write my information
    And i click the register button
    Then a successful registration message should pop out

  Scenario: Registration with empty fields
    Given Test page is not down
    When i click the register button without any info
    Then should stay in register page

  Scenario: registration with an already existent username
    Given Test page is not down
    When i enter my information using an username that already exists
    And i click the register button
    Then an error message should appear

  Scenario: registration with an email already in use
    Given Test page is not down
    When i enter my information using an email that already is in use
    And i click the register button
    Then an error message should appear

  Scenario: The info in password and confirm password do not coincide
    Given Test page is not down
    When i enter my information while the info in both password fields don't coincide
    And i click the register button
    Then an error message should appear

  Scenario: registration using an invalid email
    Given Test page is not down
    When i enter my information using an invalid email
    And i click the register button
    Then an error message should appear

