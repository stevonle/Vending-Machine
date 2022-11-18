package com.techelevator.ui;

import com.techelevator.models.Snacks;

import java.math.BigDecimal;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public void displaySnackList(Snacks eachItem)
    {
        System.out.print(eachItem.getSnackSlot() + " | ");
        System.out.print(eachItem.getSnackName() + " | ");
        System.out.print("$" + eachItem.getSnackCost() + " | ");
        System.out.print(eachItem.getSnackType() + " | ");
        System.out.println(eachItem.getSnackStock());
    }

}
