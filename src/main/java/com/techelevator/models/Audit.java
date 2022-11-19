package com.techelevator.models;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {
    private final LocalDateTime dateTime = LocalDateTime.now();
    //TODO spacing format

    //   01/01/2022 12:01:25 PM SingleMint Gum  C2  $6.75   $5.40

    public File createAuditFile(){
        final String path = "src/main/java/com/techelevator/models/";
        String auditFileName = "audit.txt";
        File auditFile = new File(path, auditFileName);
        try {
            auditFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Beep boop something happened.");
        }
        return auditFile;
    }

    public void auditingFeed(BigDecimal moneyFed, BigDecimal present) {
        try {
            PrintWriter auditWriter = new PrintWriter(new FileOutputStream(createAuditFile(), true));
            auditWriter.println(getDateTime() + " MONEY FED: $" + moneyFed + " $" + present);
            auditWriter.flush();
            auditWriter.close();
        } catch (FileNotFoundException e) {
        }
    }

    public void auditingPurchase(String name, String slot, BigDecimal previous, BigDecimal present) {
        try {
            PrintWriter auditWriter = new PrintWriter(new FileOutputStream(createAuditFile(), true));
            auditWriter.println(getDateTime() + " " + name + " " + slot + " $" + previous + " $" + present);
            auditWriter.flush();
            auditWriter.close();
        } catch (FileNotFoundException e) {
        }
    }

        public void auditingChange(BigDecimal previous, BigDecimal present) {
            try {
                PrintWriter auditWriter = new PrintWriter(new FileOutputStream(createAuditFile(), true));
                auditWriter.println(getDateTime() + " CHANGE GIVEN: $" + previous + " $" + present);
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
