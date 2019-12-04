package com.lesson6;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CheckTest {
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private ShopOne shopOne;
    private Check check;
    private List<Integer> listTest = new ArrayList<>();


    @Before
    public void init() {
        shopOne = new ShopOne();
        product1 = new Mouse(0001, "ScorpionG920", 70);
        product2 = new Keyboard(1010, "Razen", 156);
        product3 = new Keyboard(1230, "A4Tech", 180);
        product4 = new Monitor(2244, "BENQ", 230);
    }

    @Test
    public void testAddProducts(){
        shopOne.addProductShop(product1);
        listTest.add(product1.getId());
        check = shopOne.getCheck(listTest);
        assertTrue(check.getMapCheak().containsKey(product1));
    }

    @Test
    public void testCantPutNullItemInShop() {
        Product product = null;
        check = new Check();
        check.addProductInCheck(product);
        assertFalse(check.getMapCheak().containsKey(product));
    }

}
