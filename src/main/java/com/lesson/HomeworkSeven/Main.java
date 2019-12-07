package com.lesson.HomeworkSeven;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Product mouse = new Mouse(0001, "ScorpionG920", 70 );
        Product keyboard1 = new Keyboard(1010, "Razen", 156);
        Product keyboard2 = new Keyboard(1230, "A4Tech",180);
        Product monitor = new Monitor(2244, "BENQ", 230);

        List list = new ArrayList();
        list.add(mouse);
        list.add(monitor);
        list.add(keyboard2);
        list.add(keyboard1);

        CsvFile csvFile = new CsvFile();
        csvFile.addProductInFile(mouse, "productsInShopCSV.csv");  //Можно лист передать!


        ShopOne shopOne = new ShopOne();
        try{
            shopOne.addProductShop(csvFile.createListProductFromFile("productsInShopCSV.csv"));
        }catch (FileNotFoundException e) {
            System.out.println("Input problem");
            System.out.println(e);
            shopOne.addProductShop(mouse);
        }


        List list2 = new ArrayList();
        list2.add(0001);
        list2.add(1010);
        list2.add(2244);
        shopOne.printCheck(shopOne.getCheck(list2));
        System.out.println("########################");


        ProductFileWriteJSON productFileWriteJSON = new ProductFileWriteJSON();
        ProductFileReadJSON productFileReadJSON = new ProductFileReadJSON();
        productFileWriteJSON.addProductInFile(monitor, "productsInShopJSON.json");  //Можно лист передать!

        ShopTwo shopTwo = new ShopTwo();
        try{
            shopTwo.addProductShop(productFileReadJSON.createLispProductFile("productsInShopJSON.json"));
        }catch (FileNotFoundException e){
            System.out.println("Input problem");
            System.out.println(e);
            shopTwo.addProductShop(monitor);
        }

        List list3 = new ArrayList();
        list3.add(1010);
        list3.add(1010);
        list3.add(2244);
        list3.add(2244);
        list3.add(0001);
        shopTwo.printCheck(shopTwo.getCheck(list3));
        System.out.println("Осталось: " + shopTwo.getMapProduct());
    }
}
