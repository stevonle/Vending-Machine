package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private Scanner scanner = new Scanner(System.in);

    public String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("D")) {
            return "display";
        } else if (option.equals("P")) {
            return "purchase";
        } else if (option.equals("E")) {
            return "exit";
        } else {
            return "";
        }
    }

    public String purchaseMenuOptions() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");

        System.out.println();
        System.out.print("Please select an option: ");
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("M")) {
            return "feed";
        } else if (option.equals("S")) {
            return "dispense";
        } else if (option.equals("F")) {
            return "end";
        } else return "";
    }

    public String gimmeYoDollars(){
        System.out.println();
        System.out.print("Please select an option: ");
        String selectedOption = scanner.nextLine();

        if(selectedOption.equals("1")){
            return "1";
        } else if(selectedOption.equals("5")){
            return "5";
        } else if(selectedOption.equals("10")){
            return "10";
        } else if (selectedOption.equals("20")){
            return "20";
        } else return "";
    }

    public String gimmeYoSnacks() {
        System.out.println();
        System.out.print("Please select your snack by inputting the slot identifier: ");
        String selectedSnack = scanner.nextLine();

        return selectedSnack;
    }
}

