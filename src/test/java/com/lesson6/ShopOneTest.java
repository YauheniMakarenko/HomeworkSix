package com.lesson6;

import com.lesson.HomeworkSeven.*;
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
    private Check check;
    private List<Integer> listTest;

    @Before
    public void init() {
        listTest = new ArrayList<>();
        check = new Check();
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
    public void testInCheckAddProductNotNull(){
        Product monitor = null;
        check.addProductInCheck(monitor);
        Assert.assertEquals(0, check.getSum(), 0);
    }

    @Test
    public void testAddDuplicateToShop(){
        shopOne.addProductShop(product1);
        shopOne.addProductShop(product2);
        shopOne.addProductShop(product3);
        shopOne.addProductShop(product4);
        Assert.assertTrue(shopOne.getProductList().size() == 4);
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
        shopOne.addProductShop(product1);
        shopOne.addProductShop(product2);
        shopOne.addProductShop(product3);
        shopOne.addProductShop(product4);
        assertTrue(shopOne.getProductList().contains(product2));
    }

    @Test
    public void testCheckPrice() {
        check = shopOne.getCheck(listTest);
        Assert.assertEquals(636, check.getSum(), 0);
    }

    @Test
    public void testAddListIDNullToTheShop() {
        List<Integer> listTest = null;
        Assert.assertNotNull(shopOne.getCheck(listTest));
    }

    @Test
    public  void testNullItemsLeftInStore(){
        shopOne.getCheck(listTest);
        Assert.assertFalse(shopOne.getProductList().size() == 0);
    }

    @Test
    public  void testСheckWorkWithEmptyStore(){
        ShopOne shopOne1 = new ShopOne();
        shopOne1.getCheck(listTest);
        Assert.assertEquals(0, check.getSum(), 0);
    }
}
