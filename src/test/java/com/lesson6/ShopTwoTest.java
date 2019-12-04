package com.lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ShopTwoTest {
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private ShopTwo shopTwo;
    private Check check;
    private List<Integer> listTest = new ArrayList<>();

    @Before
    public void init() {
        shopTwo = new ShopTwo();
        check = new Check();
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

    }

    @Test
    public void testInCheckAddProductNotNull(){
        Product monitor = null;
        Check checkActual = new Check();
        checkActual.addProductInCheck(monitor);
        Assert.assertEquals(0, check.getSum(), 0);
    }

    @Test
    public void testAddDuplicatesToShop(){
        shopTwo.addProductShop(product4);
        shopTwo.addProductShop(product4);
        shopTwo.addProductShop(product4);
        shopTwo.addProductShop(product4);
        Assert.assertTrue(shopTwo.getMapProduct().containsValue(5));

    }

    @Test
    public void testAddDuplicatesToCheck(){
        check.addProductInCheck(product1);
        check.addProductInCheck(product1);
        check.addProductInCheck(product1);
        check.addProductInCheck(product1);
        Assert.assertEquals(280, check.getSum(), 0);
    }

    @Test
    public void testAddingProduct() {
        shopTwo.addProductShop(product1);
        shopTwo.addProductShop(product2);
        shopTwo.addProductShop(product3);
        shopTwo.addProductShop(product4);
        assertTrue(shopTwo.getMapProduct().containsKey(product2));
    }

    @Test
    public void testProductIdIsInTheShop() {
        Assert.assertNotNull(shopTwo.getProduct(1010));
    }

    @Test
    public void testGenerateCheckProduct() {
        check = shopTwo.getCheck(listTest);
        Assert.assertEquals(636, check.getSum(), 0);
    }

    @Test
    public void testAddListIDNullToTheShop() {
        List<Integer> listTest = null;
        Assert.assertNotNull(shopTwo.getCheck(listTest));
    }

    @Test
    public  void testNullItemsLeftInStore(){
        shopTwo.getCheck(listTest);
        Assert.assertTrue(shopTwo.getMapProduct().size() == 0);
    }

    @Test
    public  void testСheckWorkWithEmptyStore(){
        ShopOne shopOne1 = new ShopOne();
        shopOne1.getCheck(listTest);
        Assert.assertEquals(0, check.getSum(), 0);
    }
}
