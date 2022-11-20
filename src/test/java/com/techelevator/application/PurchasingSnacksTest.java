package com.techelevator.application;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PurchasingSnacksTest {

    @Test
    public void enoughMoney() {
        MoneyBalance moneyTest = new MoneyBalance();
        moneyTest.addToCurrentBalance(new BigDecimal("1.5"));
        PurchasingSnacks snackTest = new PurchasingSnacks();
        double costTest = 1.25;
        boolean expectedBoolean = true;

        boolean actualValue = snackTest.enoughMoney(costTest, moneyTest);

        Assert.assertEquals(expectedBoolean, actualValue);

    }

    @Test
    public void notEnoughMoney() {
        MoneyBalance moneyTest = new MoneyBalance();
        moneyTest.addToCurrentBalance(new BigDecimal("1"));
        PurchasingSnacks snackTest = new PurchasingSnacks();
        double costTest = 1.25;
        boolean expectedBoolean = false;

        boolean actualValue = snackTest.enoughMoney(costTest, moneyTest);

        Assert.assertEquals(expectedBoolean, actualValue);

    }
}