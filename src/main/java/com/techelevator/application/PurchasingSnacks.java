package com.techelevator.application;

import java.math.BigDecimal;

public class PurchasingSnacks {
    //can only buy if have enough money
    public boolean enoughMoney(double snackCost, MoneyBalance inputMoney){
        BigDecimal snackCostBD = new BigDecimal(String.valueOf(snackCost));
        double moneyMinusSnackCost = inputMoney.getCurrentBalance().subtract(snackCostBD).doubleValue();
       boolean enoughMoney = moneyMinusSnackCost >= 0;
       return enoughMoney;
    }
    //can only buy if enough stock
    public boolean enoughStock(int snackStock){
        return snackStock > 0;
    }
}
