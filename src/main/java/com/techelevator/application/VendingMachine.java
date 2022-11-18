package com.techelevator.application;

import com.techelevator.models.Snacks;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine 
{
    private List<Snacks> vendorSnackList = new ArrayList<>();
    private final BigDecimal BOGODO_DISCOUNT = BigDecimal.ONE;

    public void run()                     //MOVE ALL SOUT INTO USEROUTPUT CLASS
    {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();

        // initialize vending machine
        initializeVendingMachine();
        //initialize balance
        MoneyBalance inputMoney = new MoneyBalance();
        int bogodoCounter = 0;

        while (true)
        {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if (choice.equals("display"))
            {
                // display the vending machine slots
                System.out.println("Slot | Name | Cost | Type | Stock Left");
                for (Snacks eachItem : vendorSnackList){
                    System.out.print(eachItem.getSnackSlot() + " | ");
                    System.out.print(eachItem.getSnackName() + " | ");
                    System.out.print("$" + eachItem.getSnackCost() + " | ");
                    System.out.print(eachItem.getSnackType() + " | ");
                    System.out.println(eachItem.getSnackStock());
                }
            }

            else if (choice.equals("purchase"))
            {
                // make a purchase
             while (true) {
                 String choiceTwo = userInput.purchaseMenuOptions();

                 if (choiceTwo.equals("feed")) {
                     System.out.println("Please feed me money. Only $1, $5, $10, $20 bills are accepted.");
                     String choiceThree = userInput.gimmeYoDollars();

                     if (choiceThree.equals("1") || choiceThree.equals("5") || choiceThree.equals("10") || choiceThree.equals("20")) {
                         BigDecimal choiceThreeBD = BigDecimal.valueOf(Double.parseDouble(choiceThree));
                         inputMoney.addToCurrentBalance(choiceThreeBD);
                     } else {
                         System.out.println("Not a valid bill.");
                     }

                 } else if (choiceTwo.equals("dispense")) {
                     while (true) {
                         System.out.println("Slot | Name | Cost | Type | Stock Left");
                         for (Snacks eachItem : vendorSnackList){
                             System.out.print(eachItem.getSnackSlot() + " | ");
                             System.out.print(eachItem.getSnackName() + " | ");
                             System.out.print("$" + eachItem.getSnackCost() + " | ");
                             System.out.print(eachItem.getSnackType() + " | ");
                             System.out.println(eachItem.getSnackStock());
                         }
                         System.out.println();
                         System.out.println("Please choose the item you would like:");
                         //fix so shows 2 decimal points
                         System.out.println("Your current money provided: $" + inputMoney.getCurrentBalance() + "0.");

                         String choiceFour = userInput.gimmeYoSnacks();
                         //List<Snacks> chosenSnack = new ArrayList<>();
                         for (Snacks eachItem : vendorSnackList) {
                             if (choiceFour.equals(eachItem.getSnackSlot())) {
                                 if (eachItem.getSnackStock() > 0 /*&& inputMoney.getCurrentBalance().subtract(eachItem.getSnackCost()).compareTo(BigDecimal.ZERO) >= 0*/) {
                                     if (bogodoCounter % 2 == 0) {
                                         inputMoney.addToCurrentBalance(BOGODO_DISCOUNT);
                                     }
                                     BigDecimal choiceFourBD = BigDecimal.valueOf(eachItem.getSnackCost());
                                     inputMoney.subtractFromCurrentBalance(choiceFourBD);
                                     eachItem.stockUpdate();
                                     bogodoCounter += 1;
                                     System.out.println("Dispensing " + eachItem.getSnackName() + " $" + eachItem.getSnackCost());
                                     System.out.println(eachItem.snackTypeMessage(eachItem.getSnackType()));
                                 } else if (eachItem.getSnackStock() == 0){
                                     System.out.println("Product No Longer Available");
                                 }
                             } else {
                                 System.out.println("Invalid slot");
                             }
                         }
                     }

                 } else if (choiceTwo.equals("end")) {
                     System.out.println("Here is your change. Thank you for your business.");
                 }
                 //fix so shows 2 decimal points
                 //System.out.println("Your current money provided: $" + inputMoney.getCurrentBalance() + "0.");
             }

            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }

    public void initializeVendingMachine() {
        FileReading cateringFile = new FileReading();
        cateringFile.readsFileAndGetsSnackInfo();
        List<String[]> snackListToStringArray = cateringFile.getSnackList();

        for (int i = 0; i < snackListToStringArray.size(); i++) {
            String[] snackInfo = snackListToStringArray.get(i);

            String slot = snackInfo[0];
            String name = snackInfo[1];
            double cost = Double.parseDouble(snackInfo[2]);
            String type = snackInfo[3];

            Snacks eachSnack = new Snacks(slot, name, cost, type);
            vendorSnackList.add(eachSnack);
        }
    }

    public List<Snacks> getVendorSnackList() {

        return vendorSnackList;
    }
}
