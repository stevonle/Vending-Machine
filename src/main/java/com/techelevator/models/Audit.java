package com.techelevator.models;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {
    private final LocalDateTime dateTime = LocalDateTime.now();

    public File createAuditFile(){
        final String path = "src/main/java/com/techelevator/models/";
        String auditFileName = "audit.txt";
        File auditFile = new File(path, auditFileName);
        try {
            auditFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Beep boop file was unable to be created.");
        }
        return auditFile;
    }

    public void auditingFeed(BigDecimal moneyFed, BigDecimal present) {

        try {
            PrintWriter auditWriter = new PrintWriter(new FileOutputStream(createAuditFile(), true));
            String auditFormat = String.format("%-21s $%-8s $%-8s", " MONEY FED: ", moneyFed, present);
            auditWriter.println(getDateTime() + auditFormat);
            auditWriter.flush();
            auditWriter.close();
        } catch (FileNotFoundException e) {
        }
    }

    public void auditingPurchase(String name, String slot, BigDecimal previous, BigDecimal present) {
        try {
            PrintWriter auditWriter = new PrintWriter(new FileOutputStream(createAuditFile(), true));
            String auditFormat = String.format(" " + "%-16s %3s $%-8s $%-8s", name, slot, previous, present);
            auditWriter.println(getDateTime() + auditFormat);
            auditWriter.flush();
            auditWriter.close();
        } catch (FileNotFoundException e) {
        }
    }

    public void auditingChange(BigDecimal previous, BigDecimal present) {
        try {
            PrintWriter auditWriter = new PrintWriter(new FileOutputStream(createAuditFile(), true));
            String auditFormat = String.format("%-21s $%-8s $%-8s", " CHANGE GIVEN: ", previous, present);
            auditWriter.println(getDateTime() + auditFormat);
            auditWriter.flush();
                auditWriter.close();
        } catch (FileNotFoundException e) {
        }
    }

    public String getDateTime() {
        DateTimeFormatter formattingTime = DateTimeFormatter.ofPattern(" MM/dd/yyyy hh:mm:ss a");
        String auditDateTime = dateTime.format(formattingTime);
        return auditDateTime;
    }
}
