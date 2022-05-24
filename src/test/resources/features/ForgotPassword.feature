Feature: Forgot password

  Scenario: Change password
    Given Click en contraseña olvidada
    When Enter email
    And Click Button
    Then a successful registration message should pop out

  Scenario: Invalid email
    Given Click en contraseña olvidada
    When Enter invalid email
    And Click Button
    Then an error message should appear