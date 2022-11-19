package com.techelevator.application;

import com.techelevator.models.Audit;
import com.techelevator.models.FileReading;
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
    //TODO need a printout message for if nonexistant slot called. WITHOUT printing each time it finds a not matching slot

    public void run()
    {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();

        // initialize vending machine
        initializeVendingMachine();
        //initialize balance
        MoneyBalance inputMoney = new MoneyBalance();
        //initialize purchasingSnacks
        PurchasingSnacks buyable = new PurchasingSnacks();
        //initialize Audit
        Audit addToAudit = new Audit();
        Audit auditPrevBal = new Audit();
        Audit auditCurBal = new Audit();


        int bogodoCounter = 1;


        while (true)
        {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if (choice.equals("display"))
            {
                // display the vending machine slots
                userOutput.displaySnackList(vendorSnackList);
            }

            else if (choice.equals("purchase")) {
             while (true) {
                 String choiceTwo = userInput.purchaseMenuOptions();

                 if (choiceTwo.equals("feed")) {
                     userOutput.feedMessage();
                     String choiceThree = userInput.gimmeYoDollars();

                     if (choiceThree.equals("1") || choiceThree.equals("5") || choiceThree.equals("10") || choiceThree.equals("20")) {
                         BigDecimal choiceThreeBD = BigDecimal.valueOf(Double.parseDouble(choiceThree));
                         //auditPrevBal =
                         inputMoney.addToCurrentBalance(choiceThreeBD);
                         userOutput.displayBalance(inputMoney);
//                         auditCurBal += choiceThreeBD;
                         //save to auditFeed
                     } else {
                         userOutput.invalidBillMessage();
                     }

                 } else if (choiceTwo.equals("dispense")) {

                     userOutput.displaySnackList(vendorSnackList);

                         userOutput.chooseItem();
                         userOutput.displayBalance(inputMoney);

                         String choiceFour = userInput.gimmeYoSnacks();

                         for (Snacks eachItem : vendorSnackList) {
                             if (choiceFour.equals(eachItem.getSnackSlot())) {
                                 if (buyable.enoughStock(eachItem.getSnackStock()) && buyable.enoughMoney(eachItem.getSnackCost(), inputMoney)) {

                                     applyBOGODOSale(bogodoCounter, inputMoney);
                                     bogodoCounter += 1;

                                     BigDecimal choiceFourBD = BigDecimal.valueOf(eachItem.getSnackCost());
                                     inputMoney.subtractFromCurrentBalance(choiceFourBD);
                                     addToAudit.auditingPurchase(eachItem.getSnackName(), eachItem.getSnackSlot());

                                     eachItem.stockUpdate();
                                     //call auditingPurchase here
                                     userOutput.dispensingMessage(eachItem);

                                     //update currentBalance AND becomes new prevBalance
                                 } else if (!buyable.enoughStock(eachItem.getSnackStock())){
                                     userOutput.outOfStock();
                                 } else {
                                     userOutput.invalidSlotOrMoney();
                                 }
                             }
                         }
                         System.out.println("Current balance: $" + inputMoney.getCurrentBalance());

                 } else if (choiceTwo.equals("end")) {
                     inputMoney.giveChange();
                     //curBal always = 0
                     break;
                 }
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

    public void applyBOGODOSale(int bogodoCounter, MoneyBalance inputMoney) {
        if (bogodoCounter % 2 == 0) {
            inputMoney.bogodoSale();
        }
    }

    public List<Snacks> getVendorSnackList() {

        return vendorSnackList;
    }
}
