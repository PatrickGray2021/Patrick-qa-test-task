package unitTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import simpleCalcPackage.SimpleCalc;

import java.util.Arrays;

/**
 * TestNG unit test coverage for SimpleCal.kt.
 */
public class TestNGUnitTests {

    @Test
    public void addMethodTest() {
        // coverage for positive numbers
        int positiveIntsToAdd = SimpleCalc.INSTANCE.add(2, 2);
        Assert.assertEquals(positiveIntsToAdd, 4);
        Assert.assertNotEquals(positiveIntsToAdd, 5);

        // coverage for negative numbers
        int negativeIntsToAdd = SimpleCalc.INSTANCE.add(-1, -1);
        Assert.assertEquals(negativeIntsToAdd, -2);
        Assert.assertNotEquals(negativeIntsToAdd, 2);
    }

    @Test
    public void multiplyMethodTest() {
        // coverage for positive numbers
        double doublesToMultiply = SimpleCalc.INSTANCE.multiply(2, 2);
        Assert.assertEquals(doublesToMultiply, 4);
        Assert.assertNotEquals(doublesToMultiply, 6);

        // coverage for negative numbers
        double negativeIntsToMultiply = SimpleCalc.INSTANCE.multiply(-2, -2);
        Assert.assertEquals(negativeIntsToMultiply, 4);
        Assert.assertNotEquals(negativeIntsToMultiply, -4);
    }

    @Test
    public void sumOfEvensMethodTest() {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // evens
        Assert.assertEquals(Arrays.stream(intArray).filter(i -> i % 2 == 0).sum(), SimpleCalc.INSTANCE.sumOfEvens(intArray));
        // odds
        Assert.assertNotEquals(Arrays.stream(intArray).filter(i -> i % 2 != 0).sum(), SimpleCalc.INSTANCE.sumOfEvens(intArray));
    }
}
