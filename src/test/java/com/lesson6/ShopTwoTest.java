package com.lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShopTwoTest {
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private ShopTwo shopTwo;
    private Check check = new Check();
    private List<Integer> listTest = new ArrayList<>();

    @Before
    public void init() {
        shopTwo = new ShopTwo();
        product1 = new Mouse(0001, "ScorpionG920", 70);
        product2 = new Keyboard(1010, "Razen", 156);
        product3 = new Keyboard(1230, "A4Tech", 180);
        product4 = new Monitor(2244, "BENQ", 230);

        shopTwo.addProductShop(product1);
        shopTwo.addProductShop(product2);
        shopTwo.addProductShop(product3);
        shopTwo.addProductShop(product4);


        listTest.add(0001);
        listTest.add(1010);
        listTest.add(1230);
        listTest.add(2244);
        listTest.add(2244);
    }

    @Test
    public void testThisClassProduct() {
        Product mouse = new Mouse(0001, "ScorpionG920", 70);
        Product keyboard = new Keyboard(1010, "Razen", 156);
        Product monitor = new Keyboard(1230, "A4Tech", 180);

        Assert.assertTrue(mouse instanceof Product);
        Assert.assertTrue(keyboard instanceof Product);
        Assert.assertTrue(monitor instanceof Product);
    }

    @Test
    public void testProductIdIsInTheShop() {
        Assert.assertNotNull(shopTwo.getProduct(1010));
    }

    @Test
    public void testGenerateCheckProduct() {
        double priceExpected = 636;
        check = shopTwo.getCheck(listTest);
        Assert.assertEquals(priceExpected, check.getSum(), 0);
    }

    @Test
    public void testAddListIDNullToTheShop() {
        List<Integer> listTest = null;
        Assert.assertNotNull(shopTwo.getCheck(listTest));
    }
}
