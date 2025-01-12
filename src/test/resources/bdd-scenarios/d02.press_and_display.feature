Feature: Calculator pressing and display

  Scenario: When pressing 1 show 1
    Given calculator is on
    When  pressing "1"
    Then It displays "1"

  Scenario: When pressing two numbers, it shows the numbers
    Given calculator is on
    When pressing "1"
    And  pressing "2"
    Then It displays "12"

  Scenario: When pressing zero and a number, show just the number
    Given calculator is on
    When pressing "0"
    And  pressing "2"
    Then It displays "2"
