package com.techelevator.application;

import java.math.BigDecimal;

public class MoneyBalance {
    private BigDecimal moneyFed;
    private BigDecimal currentBalance = new BigDecimal(0.00);

    public MoneyBalance(){
    }

    public BigDecimal addToCurrentBalance(BigDecimal moneyFed){
        currentBalance=(currentBalance.add(moneyFed));
        return currentBalance;
        //BigDecimal moneyFedDecimal = new BigDecimal(moneyFed);
    }

//    public BigDecimal subtractFromCurrentBalance(){
//        currentBalance=(currentBalance.subtract(snackCost));
//        return currentBalance;
//    }
    public BigDecimal giveChange(){
        //return in .05, .1, .25, 1.0 (single dollars) (using the smallest amount of coins possible).
        return currentBalance;
    }







    public BigDecimal getMoneyFed() {
        return moneyFed;
    }
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }
}
