package com.techelevator.models;

import java.io.*;
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

    public void auditingFeed() {

        try {
            PrintWriter auditWriter = new PrintWriter(new FileOutputStream(createAuditFile(), true));
            auditWriter.println(getDateTime() + "MONEY FED: " );
            auditWriter.flush();
            auditWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void auditingPurchase(String auditName, String auditSlot) { //add int prevBal, int curBal
        try {
            PrintWriter auditWriter = new PrintWriter(new FileOutputStream(createAuditFile(), true));
            auditWriter.println(getDateTime() + " " + auditName + " " + auditSlot );
            auditWriter.flush();
            auditWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


        public void auditingChange() {
            try {
                PrintWriter auditWriter = new PrintWriter(new FileOutputStream(createAuditFile(), true));
                auditWriter.println(getDateTime() + " CHANGE GIVEN: ");
                auditWriter.flush();
                auditWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    public String getDateTime() {
        DateTimeFormatter formattingTime = DateTimeFormatter.ofPattern(" MM/dd/yyyy hh:mm:ss a");
        String auditDateTime = dateTime.format(formattingTime);
        return auditDateTime;
    }

}
