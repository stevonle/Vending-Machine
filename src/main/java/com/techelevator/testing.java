package com.techelevator;

import com.techelevator.application.FileReading;
import com.techelevator.application.VendingMachine;
import com.techelevator.models.Snacks;

public class testing {
    public static void main(String[] args) {
//        VendingMachine idk = new VendingMachine();
//        idk.initializeVendingMachine();
        FileReading file = new FileReading();
        file.readsFileAndGetsSnackInfo();
    }
}
