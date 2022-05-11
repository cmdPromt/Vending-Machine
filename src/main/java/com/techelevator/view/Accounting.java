package com.techelevator.view;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.io.*;
import java.lang.management.BufferPoolMXBean;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class Accounting {
    private static BigDecimal machineBalance = new BigDecimal("0.00");
    private static boolean keepRunning;
    private static Scanner userInput = new Scanner(System.in);

    public static void purchaseMenu() {

        try {

            do {
                System.out.println(" *********************************************");
                System.out.println("                DMITRII'S DELI                  ");
                System.out.println(" *********************************************");
                System.out.println();
                System.out.println();
                System.out.println("**********************************************");
                System.out.printf("*%16s%1s%16s","","(M) Feed Money","*\n");
                System.out.println("**********************************************");
                System.out.printf("*%15s%1s%16s","","(S) Select Item","*\n");
                System.out.println("**********************************************");
                System.out.printf("*%12s%1s%12s"," ","(F) Finish Transaction", "*\n");
                System.out.println("**********************************************");
                System.out.println();

                System.out.println("Current Money Provided : " + machineBalance);

                String choice = userInput.nextLine().toUpperCase();


                if (choice.toUpperCase().equals("M")) {
                    moneyMenu();
                }
                    if (choice.toUpperCase().equals("S")) {
                        saleMenu();
                    } else if (choice.toUpperCase().equals("F")) {
                        System.out.println(changeBack(machineBalance));

                    }



            }
            while (keepRunning);

        } catch (Exception e) {

        }

    }

    public static void vend(String vend1) {
        machineBalance = machineBalance.subtract(Menu.getPrice(vend1));
        Menu.setProducts(vend1);
        String auditMessage = Menu.getName(vend1) + " " + vend1;
        audit(auditMessage, Menu.getPrice(vend1), 1);
        System.out.print(Menu.getName(vend1) + ", $");
        System.out.print(Menu.getPrice(vend1) + "\n");
        System.out.println("Remaining balance : $" + machineBalance);

    }

    public static String changeBack(BigDecimal remainingBalance) {
        String changeBack = "Dispensing ";
        BigDecimal amount = (remainingBalance.multiply(new BigDecimal("100")));
        audit("CHANGE GIVEN:", remainingBalance, -1);
        int amountInt = amount.intValue();

        int dollars = amountInt / 100;
        amountInt = amountInt % 100;
        int quarters = amountInt / 25;
        amountInt = amountInt % 25;
        int dime = amountInt / 10;
        amountInt = amountInt % 10;
        int nickle = amountInt / 5;
        if (dollars > 0) {
            changeBack += dollars + " Dollar Bills ";
        }
        if (quarters > 0) {
            changeBack += quarters + " Quarters ";
        }
        if (dime > 0) {
            changeBack += dime + " Dimes ";
        }
        if (nickle > 0) {
            changeBack += nickle + " Nickels ";
        }
        machineBalance = (new BigDecimal("0.00"));

        return changeBack;

    }

    public static void audit(String message, BigDecimal audit, int operator) {

        if(operator == -1){
            machineBalance = new BigDecimal("0.00");
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        try {
            File auditFile = new File("Audit.txt");

            try (PrintWriter pw = new PrintWriter(new FileOutputStream(auditFile, true))) {
                pw.println(now.format(dtf) + " " + message + "\t" + "$" + audit + " " + "$" + machineBalance);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void moneyMenu() {
        boolean moneyQuit = false;
        do {
            System.out.println(" *********************************************");
            System.out.println("                DMITRII'S DELI                  ");
            System.out.println(" *********************************************");
            System.out.println();
            System.out.println();
            System.out.println("**********************************************");
            System.out.printf("*%18s%1s%19s","","1. Add $1","*\n");
            System.out.println("**********************************************");
            System.out.printf("*%18s%1s%19s","","2. Add $5","*\n");
            System.out.println("**********************************************");
            System.out.printf("*%17s%1s%19s"," ","3. Add $10", "*\n");
            System.out.println("**********************************************");
            System.out.printf("*%17s%1s%19s"," ","4. Add $20", "*\n");
            System.out.println("**********************************************");
            System.out.printf("*%11s%1s%12s"," ","5. Go to Item selection", "*\n");
            System.out.println("**********************************************");
            System.out.println();

            String moneyChoice = userInput.nextLine();
            System.out.println("Choose amount to add : ");


            if (moneyChoice.equals("1")) {
                machineBalance = machineBalance.add(new BigDecimal("1.00"));
                audit("MONEY FED:", new BigDecimal(1.00), 1);
            } else if (moneyChoice.equals("2")) {
                machineBalance = machineBalance.add(new BigDecimal("5.00"));
                audit("MONEY FED:", new BigDecimal("5.00"), 1);
            } else if (moneyChoice.equals("3")) {
                machineBalance = machineBalance.add(new BigDecimal("10.00"));
                audit("MONEY FED:", new BigDecimal("10.00"), 1);
            } else if (moneyChoice.equals("4")) {
                machineBalance = machineBalance.add(new BigDecimal("20.00"));
                audit("MONEY FED:", new BigDecimal("20.00"), 1);
            } else if (moneyChoice.equals("5")) {
              saleMenu();
              moneyQuit= true;
            }
            System.out.println(machineBalance);

        } while (!moneyQuit);
    }

    public static void saleMenu() {
        boolean salesQuit = false;
        do {
            System.out.println(Menu.displayProducts());

            System.out.println("Select Product, or press 'X' to exit ");
            String selectProduct = userInput.nextLine().toUpperCase();
            if (selectProduct.toUpperCase().equals("X")) {
                salesQuit = true;
                purchaseMenu();
            } else if (Menu.productExists(selectProduct)) {


                if (machineBalance.compareTo(Menu.getPrice(selectProduct)) != -1) {

                    if (Menu.getStock(selectProduct) != 0) {

                        vend(selectProduct);

                    } else {

                        System.out.println("THAT ITEM IS NO LONGER UNAVAILABLE");
                    }
                } else {
                    System.out.println("Insufficient funds");
                }

            } else {
                System.out.println("Invalid selection");

            }


        } while (!salesQuit);

    }
}


