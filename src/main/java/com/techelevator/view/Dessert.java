package com.techelevator.view;

import java.math.BigDecimal;

public class Dessert extends Edible {
    private String message;
    private String name;
    private int stockLeft;
    private BigDecimal price;


    public Dessert(String name, BigDecimal price) {
        super(name, price);
    }

    public void setStockLeft(int stockLeft) {
        this.stockLeft = stockLeft;
    }

    public int getStockLeft() {
        return stockLeft;
    }

}
