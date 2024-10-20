package com.example.demoTest.services;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class CalculatorServiceTest {

    // DataProvider for addition and subtraction tests
    @DataProvider(name = "numbersForAdditionAndSubtraction")
    public static Object[][] getNumbers() {
        return new Object[][]{
                {10, 5},     // Test case 1
                {20, 20},    // Test case 2
                {-4, -3},    // Test case 3
                {0, 0}       // Test case 4 (optional)
        };
    }

    // DataProvider for multiplication and division tests
    @DataProvider(name = "numbersForMultiplicationAndDivision")
    public static Object[][] getNumbersForMultiplicationAndDivision() {
        return new Object[][]{
                {6, 3},      // Test case 1
                {10, 2},     // Test case 2
                {0, 5},      // Test case 3
                {15, -3}     // Test case 4
        };
    }

    @Test(dataProvider = "numbersForAdditionAndSubtraction")
    public void givenCalcService_whenAddingNumbers_thenReturnSum(int num1, int num2) {
        // Arrange
        CalculatorService calculatorService = new CalculatorService();
        // Act
        int actualResults = calculatorService.add(num1, num2);
        int expectedResults = num1 + num2;
        // Assert
        Assert.assertEquals(actualResults, expectedResults, "Adding two numbers");
    }

    @Test(dataProvider = "numbersForAdditionAndSubtraction")
    public void givenCalcService_whenSubtractingNumbers_thenReturnDifference(int num1, int num2) {
        // Arrange
        CalculatorService calculatorService = new CalculatorService();
        // Act
        int actualResults = calculatorService.subtract(num1, num2);
        int expectedResults = num1 - num2;
        // Assert
        Assert.assertEquals(actualResults, expectedResults, "Subtracting two numbers");
    }

    @Test(dataProvider = "numbersForMultiplicationAndDivision")
    public void givenCalcService_whenMultiplyingNumbers_thenReturnProduct(int num1, int num2) {
        // Arrange
        CalculatorService calculatorService = new CalculatorService();
        // Act
        int actualResults = calculatorService.multiply(num1, num2);
        int expectedResults = num1 * num2;
        // Assert
        Assert.assertEquals(actualResults, expectedResults, "Multiplying two numbers");
    }

    @Test(dataProvider = "numbersForMultiplicationAndDivision")
    public void givenCalcService_whenDividingNumbers_thenReturnQuotient(int num1, int num2) {
        // Arrange
        CalculatorService calculatorService = new CalculatorService();
        // Act
        int actualResults = 0;
        if (num2 != 0) { // Prevent division by zero
            actualResults = calculatorService.divide(num1, num2);
        }
        int expectedResults = (num2 != 0) ? num1 / num2 : 0; // Handle division by zero case
        // Assert
        Assert.assertEquals(actualResults, expectedResults, "Dividing two numbers");
    }
}
