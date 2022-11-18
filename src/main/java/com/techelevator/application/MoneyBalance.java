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

    public BigDecimal subtractFromCurrentBalance(BigDecimal cost){
//        if (currentBalance.subtract(cost).compareTo(BigDecimal.ZERO) >= 0) {
            currentBalance = (currentBalance.subtract(cost));
//        } else {
//            System.out.println("You don't have enough money to purchase this snack");
//        }
        return currentBalance;
    }

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
