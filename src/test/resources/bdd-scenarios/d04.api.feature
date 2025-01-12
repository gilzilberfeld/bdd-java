Feature: Using to run API

  Scenario: When pressing two numbers, it shows the numbers
    Given calculator is ready
    When send press "1"
    And  send press "2"
    Then it returns "12"

  Scenario: another way to test
    Given another calculator is ready
    When again send press "1"
    And  again send press "2"
    Then it returns another "12"

