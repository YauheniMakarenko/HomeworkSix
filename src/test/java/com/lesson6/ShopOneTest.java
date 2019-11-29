package com.lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ShopOneTest {
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private ShopOne shopOne;
    private Check check = new Check();
    private List<Integer> listTest = new ArrayList<>();

    @Before
    public void init() {
        shopOne = new ShopOne();
        product1 = new Mouse(0001, "ScorpionG920", 70);
        product2 = new Keyboard(1010, "Razen", 156);
        product3 = new Keyboard(1230, "A4Tech", 180);
        product4 = new Monitor(2244, "BENQ", 230);

        shopOne.addProductShop(product1);
        shopOne.addProductShop(product2);
        shopOne.addProductShop(product3);
        shopOne.addProductShop(product4);


        listTest.add(0001);
        listTest.add(1010);
        listTest.add(1230);
        listTest.add(2244);
    }


    @Test
    public void testAddingItems() {
        shopOne.addProductShop(product1);
        shopOne.addProductShop(product2);
        shopOne.addProductShop(product3);
        shopOne.addProductShop(product4);
        assertTrue(shopOne.getProductList().contains(product3));
    }

    @Test
    public void testThisClassProduct() {
        Assert.assertTrue(product1 instanceof Product);
        Assert.assertTrue(product3 instanceof Product);
        Assert.assertTrue(product2 instanceof Product);

    }

    @Test
    public void testCheckPrice() {
        check = shopOne.getCheck(listTest);
        Assert.assertEquals(636, check.getSum(), 0);
    }

    @Test
    public void testAddCheck() {
        check.addProductInCheck(product3);
        Assert.assertEquals(180, check.getSum(), 0);
    }

    @Test
    public void testAddNullProductToTheCheck() {
        Product monitor = null;
        check.addProductInCheck(monitor);
        Assert.assertEquals(0, check.getSum(), 0);
    }


}
