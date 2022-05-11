package com.techelevator.view;

import org.junit.Test;

import javax.swing.text.StyledEditorKit;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void productExists() {
        Menu menu = new Menu();
        Boolean expectedResult = true;
        assertTrue(menu.productExists("A3"));
        boolean expectedResult1 = false;
        assertFalse(menu.productExists("AR22"));
    }

    @Test
    public void getPrice() {
        Menu menu = new Menu();
        BigDecimal expectedReturn = new BigDecimal("5.25");
        BigDecimal actualReturn = Menu.getPrice("A2");
        assertEquals(expectedReturn, actualReturn);
    }

    @Test
    public void getStock() {
        Menu menu = new Menu();
        Integer expectedReturn = 7;
        Integer actualReturn = Menu.getStock("A1");
        Integer actualReturn1 = menu.getStock("A2");
        assertEquals(expectedReturn, actualReturn, actualReturn1);
        Integer expectedReturn1 = 7;
        Integer actualReturn2 = menu.getStock("A3");
        Integer actualReturn3 = menu.getStock("A4");
        assertEquals(expectedReturn1, actualReturn2, actualReturn3);
    }

    @Test
    public void getName() {
        Menu menu = new Menu();
        String expectedReturn = "Chocolate Bar";
        String actualReturn = Menu.getName("A4");
        assertEquals(expectedReturn, actualReturn);
    }

}
