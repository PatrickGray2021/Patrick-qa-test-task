package cucumberStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import simpleCalcPackage.SimpleCalc;

/**
 * Step definitions for Scenario: Multiplying two numbers.
 */
public class MultiplyMethodStepDefinitions {

    private double firstNumber;
    private double secondNumber;
    private double returnedSum;

    @Given("I entered {double} * {double} into my calculator")
    public void initialise(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @When("I press multiply")
    public void MultiplyMethod() {
        returnedSum = SimpleCalc.INSTANCE.multiply(firstNumber, secondNumber);
    }

    @Then("The displayed answer should match the expected sum of {double}")
    public void verifyMultiplyEqualsSum(double expectedSum) {
        Assert.assertEquals(returnedSum, expectedSum);
    }

    @And("The answer should not be {int} without a dp")
    public void verifyMultiplyDoesNotEqualSum(int incorrectSum) {
        Assert.assertNotEquals(returnedSum, incorrectSum);
    }
}
