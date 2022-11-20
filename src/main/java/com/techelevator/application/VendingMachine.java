package com.techelevator.application;

import com.techelevator.models.Audit;
import com.techelevator.models.FileReading;
import com.techelevator.models.Snacks;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private List<Snacks> vendorSnackList = new ArrayList<>();
    private int bogodoCounter = 1;
    private BigDecimal previousBal = new BigDecimal("0.00");
    private BigDecimal presentBal = new BigDecimal("0.00");

    //TODO need a printout message for if nonexistant slot called. WITHOUT
    // printing each time it finds a not matching slot

    public void run() {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();
        MoneyBalance inputMoney = new MoneyBalance();
        PurchasingSnacks canBuy = new PurchasingSnacks();
        Audit addToAudit = new Audit();

        initializeVendingMachine();

        while (true)
        {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if (choice.equals("display")) {             // USER SELECTS DISPLAY VENDING MACHINE ITEMS
                userOutput.displaySnackList(vendorSnackList);

            } else if (choice.equals("purchase")) {     // USER SELECTS PURCHASE
                while (true) {
                    String choiceTwo = userInput.purchaseMenuOptions();

                    if (choiceTwo.equals("feed")) {                 // USER SELECTS FEED MONEY
                        userOutput.feedMessage();
                        String choiceThree = userInput.gimmeYoDollars();

                        if (choiceThree.equals("1") || choiceThree.equals("5") ||
                                choiceThree.equals("10") || choiceThree.equals("20")) {

                            BigDecimal choiceThreeBD = new BigDecimal(choiceThree).setScale(2);
                            inputMoney.addToCurrentBalance(choiceThreeBD);
                            userOutput.displayBalance(inputMoney);

                            presentBal = inputMoney.getCurrentBalance();
                            addToAudit.auditingFeed(choiceThreeBD, presentBal);

                        } else {
                            userOutput.invalidBillMessage();
                        }

                    } else if (choiceTwo.equals("dispense")) {      // USER SELECTS SELECT ITEM
                        userOutput.displaySnackList(vendorSnackList);
                        userOutput.chooseItem();
                        userOutput.displayBalance(inputMoney);
                        String choiceFour = userInput.gimmeYoSnacks();

                        for (Snacks eachItem : vendorSnackList) {
                            String slot = eachItem.getSnackSlot();
                            String name = eachItem.getSnackName();
                            double cost = eachItem.getSnackCost();
                            int stock = eachItem.getSnackStock();

                            if (choiceFour.equalsIgnoreCase(slot) && canBuy.enoughStock(stock)
                                    && canBuy.enoughMoney(cost, inputMoney)) {

                                inputMoney.bogodoSale(bogodoCounter, inputMoney);
                                bogodoCounter += 1;
                                eachItem.stockUpdate();
                                inputMoney.subtractFromCurrentBalance(BigDecimal.valueOf(cost));
                                userOutput.dispensingMessage(eachItem);

                                previousBal = presentBal;
                                presentBal = inputMoney.getCurrentBalance();
                                addToAudit.auditingPurchase(name, slot, previousBal, presentBal);

                            } else if (!canBuy.enoughStock(stock)){
                                userOutput.outOfStock();
                            }
                        }
                        userOutput.displayBalance(inputMoney);
                    } else if (choiceTwo.equals("end")) {           // USER SELECTS FINISH TRANSACTION
                        previousBal = presentBal;
                        Map<String, Integer> endMap = inputMoney.giveChange();
                        userOutput.displayEndTransaction(endMap);
                        inputMoney.subtractFromCurrentBalance(inputMoney.getCurrentBalance());
                        presentBal = inputMoney.getCurrentBalance();
                        addToAudit.auditingChange(previousBal, presentBal);

                        break;
                    }
                }
            } else if(choice.equals("exit")) {          // USER SELECTS EXIT
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
}
