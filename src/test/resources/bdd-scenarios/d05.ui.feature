Feature: Calculator UI

  Scenario: When adding two numbers it shows the results
    Given calculator page is loaded
    When  press button "1"
    And  press button "+"
    And  press button "2"
    And  press button "="
    Then The result should be "3"
