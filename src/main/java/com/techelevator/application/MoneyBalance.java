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
            currentBalance = (currentBalance.subtract(cost));
        return currentBalance;
    }
//BigDecimal snackCostBD = new BigDecimal(String.valueOf(snackCost));
//        double moneyMinusSnackCost = inputMoney.getCurrentBalance().subtract(snackCostBD).doubleValue();
//       boolean enoughMoney = moneyMinusSnackCost >= 0;
//       return enoughMoney;

    public String giveChange(){
        int nickels = 0;
        int quarters = 0;
        int dimes = 0;
        int dollars = 0;

        while(this.currentBalance.doubleValue() >= 1.0){
            currentBalance.subtract(BigDecimal.ONE);
            dollars += 1;
        }
        while(this.currentBalance.doubleValue() >= 0.25){
            currentBalance.subtract(new BigDecimal(".25"));
            quarters += 1;
        }
        while(this.currentBalance.doubleValue() >= 0.1){
            currentBalance.subtract(new BigDecimal(".1"));
            dimes += 1;
        }
        while(this.currentBalance.doubleValue() >= 0.05){
            currentBalance.subtract(new BigDecimal(".05"));
            nickels += 1;
        }
        currentBalance = BigDecimal.ZERO;
        System.out.println("Here's your change! Dollars: " + dollars + " Quarters: " + quarters + " Dimes: " + dimes + " Nickels: " + nickels);
        return "";
    }

    public BigDecimal bogodoSale(){
        return currentBalance = currentBalance.add(BigDecimal.ONE);
    }



    public BigDecimal getMoneyFed() {
        return moneyFed;
    }
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }
}
