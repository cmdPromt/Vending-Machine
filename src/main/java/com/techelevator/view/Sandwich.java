package com.techelevator.view;

import java.math.BigDecimal;

public class Sandwich extends Edible{
    private String message;
    private String name;
    private int stockLeft;
    private BigDecimal price;


    public Sandwich(String name, BigDecimal price) {
        super(name, price);
    }

    public void setStockLeft(int stockLeft) {
        this.stockLeft = stockLeft;
    }

    public int getStockLeft() {
        return stockLeft;
    }

}
