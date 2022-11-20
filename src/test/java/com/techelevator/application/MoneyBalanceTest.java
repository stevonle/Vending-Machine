package com.techelevator.application;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.Bidi;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MoneyBalanceTest {

    @Test
    public void addTenToNothing() {
        BigDecimal testValue = BigDecimal.TEN;
        BigDecimal expectedValue = BigDecimal.TEN;
        MoneyBalance mbObject = new MoneyBalance();

        BigDecimal actualValue = mbObject.addToCurrentBalance(testValue);
        boolean valuesEqual = expectedValue.compareTo(actualValue) == 0;

        Assert.assertTrue(valuesEqual);

    }

    @Test
    public void subtractTenFromNothing() {
        BigDecimal testValue = BigDecimal.TEN;
        BigDecimal expectedValue = BigDecimal.ZERO;
        MoneyBalance mbObject = new MoneyBalance();

        BigDecimal actualValue = mbObject.subtractFromCurrentBalance(testValue);
        boolean valuesEqual = expectedValue.compareTo(actualValue) == 0;

        Assert.assertTrue(valuesEqual);
    }

    @Test
    public void giveChangeTest() {
        BigDecimal testValue = new BigDecimal("6.65");
        MoneyBalance mbObject = new MoneyBalance();
        Map<String, Integer> testMap = new HashMap<String, Integer>();
        testMap.put("dollars", 6);
        testMap.put("quarters", 2);
        testMap.put("dimes", 1);
        testMap.put("nickels", 1);

        Map<String, Integer> actualMap = mbObject.giveChange();

        Assert.assertEquals(testMap, actualMap);
    }

    @Test
    public void noBogodoSale() {
        BigDecimal testValue = BigDecimal.ZERO;
        BigDecimal expectedValue = new BigDecimal("0");
        MoneyBalance mbObject = new MoneyBalance();

       BigDecimal actualValue = mbObject.bogodoSale(1, mbObject);

       Assert.assertEquals(testValue, actualValue);
    }

    @Test
    public void yesBogodoSale() {
        BigDecimal testValue = BigDecimal.ONE;
        BigDecimal expectedValue = new BigDecimal("1");
        MoneyBalance mbObject = new MoneyBalance();

        BigDecimal actualValue = mbObject.bogodoSale(2, mbObject);

        Assert.assertEquals(testValue, actualValue);
    }
}