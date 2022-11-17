package com.techelevator.application;

import com.techelevator.models.Snacks;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.util.List;

public class VendingMachine 
{
    public void run()
    {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();

        // initialize vending machine
        initializeVendingMachine();

        while(true)
        {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }

    public void initializeVendingMachine() {
        FileReading fileReading = new FileReading();
        fileReading.readsFileAndGetsSnackInfo();
        List<String[]> list = fileReading.getSnackList();
        for (int i = 0; i < list.size(); i++) {
            String[] snackInfo = list.get(i);

            String slot = snackInfo[0];
            String name = snackInfo[1];
            double cost = Double.parseDouble(snackInfo[2]);
            String type = snackInfo[3];

            Snacks eachSnack = new Snacks(slot, name, cost, type);
            System.out.println(eachSnack.getSnackStock());
        }
    }
}
