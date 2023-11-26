package cucumberStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import simpleCalcPackage.SimpleCalc;

import java.util.Arrays;

public class SumOfEvensStepDefinition {

    private int returnedSumOfInts;
    private int expectedSumOfInts;
    private int incorrectSum;

    @Given("A list of numbers [1,2,3,4,5,6,7]")
    @When("I type them into the calculator")
    public void initialise() {
        int[] sequenceOfInts = new int[]{1, 2, 3, 4, 5, 6, 7};
        expectedSumOfInts = Arrays.stream(sequenceOfInts).filter(i -> i % 2 == 0).sum();
        incorrectSum = Arrays.stream(sequenceOfInts).filter(i -> i % 2 == 1).sum();
        returnedSumOfInts = SimpleCalc.INSTANCE.sumOfEvens(sequenceOfInts);
    }

    @Then("The result should be the sum of ONLY even number")
    @And("Not the sum of odd numbers")
    public void verifyMethod() {
        Assert.assertEquals(returnedSumOfInts, expectedSumOfInts);
        Assert.assertNotEquals(incorrectSum, expectedSumOfInts);
    }
}
