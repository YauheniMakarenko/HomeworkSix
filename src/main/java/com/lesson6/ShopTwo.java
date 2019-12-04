package com.lesson6;

import java.util.*;

public class ShopTwo implements ShopInterface {
    private Map<Product, Integer> mapProduct = new HashMap<>();
    private Map<Integer, Product> mapIdToProduct = new HashMap<>();

    public void addProductShop(List<Product> list){
        for (int i = 0; i < list.size(); i++) {
            addProductShop(list.get(i));
        }
    }

    public void addProductShop(Product product) {
        if (product == null) {
            return;
        }
        if (!mapProduct.containsKey(product)) {
            mapProduct.put(product, 1);
        } else {
            mapProduct.put(product, mapProduct.get(product) + 1);
        }
        mapIdToProduct.put(product.getId(), product);
    }

    public Check getCheck(Product product){
        Check check = new Check();
        if (product == null) {
            return check;
        }
            addToCheck(product.getId(), check);
        return check;
    }

    public Check getCheck(List<Integer> list){
        Check check = new Check();
        if (list == null) {
            return check;
        }
        for (int i = 0; i < list.size(); i++) {
            addToCheck(list.get(i), check);
        }
        return check;
    }

    private void addToCheck(Integer idProduct, Check check) {
        Integer countProduct = mapProduct.get(mapIdToProduct.get(idProduct));
        Product product = mapIdToProduct.get(idProduct);
        if (mapIdToProduct.containsKey(idProduct)) {
            if (countProduct <= 1) {
                mapProduct.remove(product);
                mapIdToProduct.remove(idProduct);
            } else {
                mapProduct.put(product, countProduct - 1);
            }
            check.addProductInCheck(product);
        }
    }

    public void printCheck(Check check) {
        check.generateCheck();
    }

    public Product getProduct(int idProduct){
        return mapIdToProduct.get(idProduct);
    }

    public Map<Product, Integer> getMapProduct() {
        return mapProduct;
    }
}
