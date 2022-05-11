package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Menu {
    private static Map<String, Edible> products = new HashMap<>();

    public static boolean productExists(String bob) {
       return products.containsKey(bob);
    }

    public static BigDecimal getPrice(String price){
        return products.get(price).price;
    }

    public static int getStock(String item){
        return products.get(item).getStockLeft();
    }

    public static String getName(String item){
        return products.get(item).getName();
    }

    public Menu() {
        boolean quit = false;
        File menu = new File("catering.csv");
        do {
            try (Scanner menuScan = new Scanner(menu)) {

                while (menuScan.hasNextLine()) {
                    String[] menuLine = menuScan.nextLine().split("\\,");
                    if (menuLine[2].equals("Munchy")) {
                        Edible munchy = new Munchy(menuLine[1], new BigDecimal(menuLine[3]));
                        munchy.setStockLeft(7);
                        munchy.setMessage("Munchy, Munchy, so Good!");
                        products.put(menuLine[0], munchy);


                    } else if (menuLine[2].equals("Sandwich")) {
                        Edible sandwich = new Sandwich(menuLine[1], new BigDecimal(menuLine[3]));
                        sandwich.setStockLeft(7);
                        sandwich.setMessage("Sandwich So Delicious, Yum!");
                        products.put(menuLine[0], sandwich);


                    } else if (menuLine[2].equals("Drink")) {
                        Edible drink = new Drink(menuLine[1], new BigDecimal(menuLine[3]));
                        drink.setStockLeft(7);
                        drink.setMessage("Drinky, Drinky, Slurp Slurp!");
                        products.put(menuLine[0], drink);

                    } else if (menuLine[2].equals("Dessert")) {
                        Edible dessert = new Dessert(menuLine[1], new BigDecimal(menuLine[3]));
                        dessert.setStockLeft(7);
                        dessert.setMessage("Sugar, Sugar, so Sweet!");
                        products.put(menuLine[0], dessert);

                    }
                }

                quit = true;

            } catch (FileNotFoundException e) {

            }

        } while (!quit);

    }

    public static String displayProducts() {
        String outputString = "";

        Set<String> menuKeys = products.keySet();

        for (String key : menuKeys) {

//             outputString += key + " - " + products.get(key).name + " - $" +
//                    products.get(key).price.toString() + " ";
            outputString += String.format("|%2s| %-19s|%5s%-12s $%5s%2s", key, products.get(key).getName(),"",
                                  products.get(key).getClass().getName().substring(22), products.get(key).price, "");


            if (products.get(key).getStockLeft() == 0){
                outputString += String.format("|%5s| %n", " NO LONGER AVAILABLE");
            }
            else {
                outputString += String.format("|%5s| %n", products.get(key).getStockLeft() + " Remaining");
            }
        }
        return outputString;
    }

    public static void setProducts(String entry) {
        int initialStock = products.get(entry).getStockLeft();
        products.get(entry).setStockLeft(initialStock - 1);
        System.out.println(products.get(entry).getMessage());
    }
}





