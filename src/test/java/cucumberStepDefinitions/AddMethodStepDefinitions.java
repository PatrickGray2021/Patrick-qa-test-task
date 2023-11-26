package cucumberStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import simpleCalcPackage.SimpleCalc;

/**
 * Class to hold Cucumber step definition, see .feature file for scenarios.
 */
public class AddMethodStepDefinitions {

    private int firstNumber;
    private int secondNumber;
    private int returnedSum;

    @Given("I entered {int} + {int} into my calculator")
    public void initialise(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
    
    @When("I press add")
    public void addMethod(){
        returnedSum = SimpleCalc.INSTANCE.add(firstNumber, secondNumber);
    }

    @Then("The answer displayed should be the correct sum of {int}")
    public void verifyAddMethodEqualsTest(int expectedSum) {
        Assert.assertEquals(returnedSum, expectedSum);
    }

    @And("The answer should not be {int}")
    public void verifyAddMethodDoesNotEqualTest(int incorrectSum) {
        Assert.assertNotEquals(returnedSum, incorrectSum);
    }
}
