package com.example.demoTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class MoneyTest {
    public void immutableConstructor(){
        Money money = new Money(500, "USD");
        Assert.assertEquals(money.getAmount(), 500);
        Assert.assertEquals(money.getCurrency(), "USD");
    }
}
