package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Edible {
    String message;
    String name;
    BigDecimal price;
    int stockLeft;

    public Edible(String name, BigDecimal price) {
        this.name = name;
        this.price = price;

    }

    public void setStockLeft(int stockLeft) {
        this.stockLeft = stockLeft;
    }

    public int getStockLeft() {
        return stockLeft;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

