package com.lesson6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Product mouse = new Mouse(0001, "ScorpionG920", 70 );
        Product keyboard1 = new Keyboard(1010, "Razen", 156);
        Product keyboard2 = new Keyboard(1230, "A4Tech",180);
        Product monitor = new Monitor(2244, "BENQ", 230);

        ShopOne shopOne = new ShopOne();
        shopOne.addProductShop(keyboard1);
        shopOne.addProductShop(keyboard2);
        shopOne.addProductShop(mouse);
        shopOne.addProductShop(monitor);
        List list = new ArrayList();
        list.add(1010);
        list.add(1010);
        list.add(1010);
        list.add(1230);
        list.add(0001);
        list.add(2244);
        list.add(2244);
        shopOne.printCheck(shopOne.getCheck(list));
        System.out.println("########################");

        ShopTwo shopTwo = new ShopTwo();
        shopTwo.addProductShop(keyboard1);
        shopTwo.addProductShop(keyboard1);
        shopTwo.addProductShop(keyboard1);
        shopTwo.addProductShop(keyboard2);
        shopTwo.addProductShop(keyboard2);
        shopTwo.addProductShop(monitor);
        shopTwo.addProductShop(monitor);
        shopTwo.addProductShop(monitor);
        shopTwo.addProductShop(mouse);
        shopTwo.addProductShop(mouse);


        List list2 = new ArrayList();
        list2.add(1010);
        list2.add(1010);
        list2.add(1010);
        list2.add(1010);
        list2.add(2244);
        list2.add(2244);
        list2.add(2244);
        list2.add(2244);
        list2.add(0001);
        shopTwo.printCheck(shopTwo.getCheck(list2));
        System.out.println("Осталось: " + shopTwo.getMapProduct());
    }
}
