Feature: Calculator startup

  Scenario: On start-up the display should show zero
    Given calculator was just turned on
    Then It shows zero

  Scenario: On start-up the display should show zero (as parameter)
    Given calculator was just turned on
    Then It shows "0"