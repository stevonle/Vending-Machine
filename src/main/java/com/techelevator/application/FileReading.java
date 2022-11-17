package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReading {
    private List<String[]> snackList = new ArrayList<>();

    public List<String[]> readsFileAndGetsSnackInfo() {
        try {
            Scanner input = new Scanner(new File("catering.csv"));

            while (input.hasNextLine()) {
                String eachLine = input.nextLine();
                String[] snackInfo = eachLine.split(",");
                snackList.add(snackInfo);
            }
//            for (String[] eachSnack : snackList) {
//                for (String eachSnackInfo : eachSnack) {
//                    System.out.println(eachSnackInfo);
//                }
//            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
        return snackList;
    }

    public List<String[]> getSnackList() {
        return snackList;
    }
}
