Feature: Examples - calculator pressing and display

Scenario Outline: When pressing a sequence, show the results
  Given a calculator
  When pressing a sequence "<keys>"
  Then it displays "<result>"

  Examples:
    | keys      | result  |
    |           | 0       |
    | 1         | 1       |
    | 12        | 12      |
    | 02        | 2       |