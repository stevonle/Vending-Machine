package com.techelevator.models;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Testing {
    public static void main(String[] args) {
        Audit testAudit = new Audit();
        testAudit.auditingFeed();
        //testAudit.auditingPurchase();
        testAudit.auditingChange();
    }
}
