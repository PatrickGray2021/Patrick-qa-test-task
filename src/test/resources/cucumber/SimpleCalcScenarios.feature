Feature: Using a simple calculator
  As a mathematician
  I want to use a calculator to add, multiply and find the sum of numbers
  I expected the returned number to be correct

  Scenario Outline: Adding two numbers
    Given I entered <firstNumber> + <secondNumber> into my calculator
    When I press add
    Then The answer displayed should be the correct sum of <expectedSum>
    And The answer should not be <incorrectSum>

    Examples:
      | firstNumber | secondNumber | expectedSum | incorrectSum |
      | 2           | 2            | 4           | -4           |
      | -2          | -2           | -4          | 4            |
      | 50          | 50           | 100         | 99           |
      | 1000000     | 1000000      | 2000000     | 2147483647   |

  Scenario Outline: Multiplying two numbers
    Given I entered <firstNumber> * <secondNumber> into my calculator
    When I press multiply
    Then The displayed answer should match the expected sum of <expectedSum>
    And The answer should not be <incorrectSum> without a dp

    Examples:
      | firstNumber | secondNumber | expectedSum | incorrectSum |
      | 10.0        | 2.0          | 20.0        | 20           |
      | 99.66       | 25.3         | 2521.398    | 2521         |
      | -45.25      | -2.0         | 90.5        | -90          |
      | -2.0        | 1.0          | -2.0        | 3            |

  Scenario: Sum of all even numbers
    Given A list of numbers [1,2,3,4,5,6,7]
    When I type them into the calculator
    Then The result should be the sum of ONLY even number
    And Not the sum of odd numbers

  Scenario: Run through a number of calculations
    Given I have some accounting to do
    When When I add 3 + 3 together the answer should be 6
    Then If I multiply 3 * 3 the answer will be 9
    But my calculation should fail if I expect to get a value greater than 0 when I find the sum of all even numbers for [3,3,3]