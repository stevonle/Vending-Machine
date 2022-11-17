package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snacks {
    private String snackSlot;
    private String snackName;
    private double snackCost;
    private String snackType;
    private int snackStock = 6;
    private List<String[]> snackList = new ArrayList<>();

    public Snacks() {
    }

    public Snacks(String snackSlot, String snackName, double snackCost, String snackType) {
        this.snackSlot = snackSlot;
        this.snackName = snackName;
        this.snackCost = snackCost;
        this.snackType = snackType;
    }

    public String getSnackSlot() {
        return snackSlot;
    }

    public String getSnackName() {
        return snackName;
    }

    public double getSnackCost() {
        return snackCost;
    }

    public String getSnackType() {
        return snackType;
    }

    public int getSnackStock() {
        return snackStock;
    }

    public List<String[]> getSnackList() {
        return snackList;
    }
}
