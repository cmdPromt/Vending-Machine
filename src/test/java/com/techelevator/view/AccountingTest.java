package com.techelevator.view;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AccountingTest {
    BigDecimal machineBalance = new BigDecimal("1.90");


    @Test
    public void changeBack() {

        String expectedResult = "Dispensing 1 Dollar Bills 3 Quarters 1 Dimes 1 Nickels ";
        String actaulResult = Accounting.changeBack(machineBalance);

        assertEquals(expectedResult, actaulResult);
    }
}
