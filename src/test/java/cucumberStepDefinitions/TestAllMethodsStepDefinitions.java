package cucumberStepDefinitions;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import simpleCalcPackage.SimpleCalc;

public class TestAllMethodsStepDefinitions {

    private final int firstNumber = 3;
    private final int secondNumber = 3;
    private int[] arrayOfNums;

    @Given("I have some calculations to do")
    public void initialise() {
     arrayOfNums = new int[]{firstNumber,secondNumber,3};
    }

    @When("When I add 3 + 3 together the answer should be 6")
    public void AddMethod(){
        Assert.assertEquals(SimpleCalc.INSTANCE.add(firstNumber,secondNumber),6);
    }

    @Then("If I multiply 3 * 3 the answer will be 9")
    public void MultiplyMethod(){
      Assert.assertEquals(SimpleCalc.INSTANCE.multiply(firstNumber,secondNumber),9);
    }

    @But("The sum of all evens when I enter 3 , 3 ,3 should not be > 0")
    public void sumOfEvensMethod(){
    Assert.assertFalse(SimpleCalc.INSTANCE.sumOfEvens(arrayOfNums) > 0);
    }
}