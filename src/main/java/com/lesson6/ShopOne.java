package com.lesson6;

import java.util.ArrayList;
import java.util.List;

public class ShopOne implements ShopInterface  {
    private List<Product> productList = new ArrayList<>();

    public void addProductShop(Product product) {
        if (productList.contains(product)) return;
        productList.add(product);
    }

    public void addProductShop(List<Product> list){
        for (int i = 0; i < list.size(); i++) {
            productList.add(list.get(i));
        }
    }

    public Check getCheck(List<Integer> list) {
        Check check = new Check();
        if (list == null) {
            return check;
        }
        for (int i = 0; i < productList.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == productList.get(i).getId()) {
                    check.addProductInCheck(productList.get(i));
                }
            }
        }
        return check;
    }

    public void printCheck(Check check) {
        check.generateCheck();
    }

    public List<Product> getProductList() {
        return productList;
    }
}
