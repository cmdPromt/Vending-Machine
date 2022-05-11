package com.techelevator.view;

import java.math.BigDecimal;

public class Drink extends Edible{
    private String message;
    private String name;
    private int stockLeft;
    private BigDecimal price;


    public Drink(String name, BigDecimal price) {
        super(name, price);
    }

    public void setStockLeft(int stockLeft) {
        this.stockLeft = stockLeft;
    }

    public int getStockLeft() {
        return stockLeft;
    }


}

