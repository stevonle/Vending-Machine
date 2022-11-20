package com.techelevator.models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SnacksTest {

    @Test
    public void drinkInSnackTypeMessage() {
        Snacks snackObj = new Snacks();

        String testValue = "Drink";
        String expectedValue = "Drinky, Drinky, Slurp Slurp!";

        String actualValue = snackObj.snackTypeMessage(testValue);

        Assert.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void breadInSnackTypeMessage() {
        Snacks snackObj = new Snacks();

        String testValue = "Bread";
        String expectedValue = "";

        String actualValue = snackObj.snackTypeMessage(testValue);

        Assert.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void stockIs6Test() {
        Snacks snackObj = new Snacks();
        int expectedStock = 5;

        snackObj.stockUpdate();

        Assert.assertEquals(expectedStock, snackObj.getSnackStock());
    }

    @Test
    public void stockIs0Test() {
        Snacks snackObj = new Snacks();
        snackObj.setSnackStock(0);
        int expectedStock = 0;

        snackObj.stockUpdate();

        Assert.assertEquals(expectedStock, snackObj.getSnackStock());
    }
}