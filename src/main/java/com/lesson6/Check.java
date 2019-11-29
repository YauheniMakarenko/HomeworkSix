package com.lesson6;

import java.util.HashMap;
import java.util.Map;

public class Check {
    private Map<Product, Integer> mapCheak = new HashMap<>();

    public int getSum() {
        return sum;
    }

    private int sum = 0;

    public void generateCheck() {
        System.out.println(" Check");
        System.out.println("---------------------------");
        for (Map.Entry<Product, Integer> p : mapCheak.entrySet()) {
            System.out.println(p.getKey().getName() + " " + p.getValue() + "шт.");
        }
        System.out.println("---------------------------");
        System.out.println(" Price: " + sum);
    }

    public void addProductInCheck(Product product) {
        if (product==null) return;
        if (!mapCheak.containsKey(product)) {
            mapCheak.put(product, 1);
            sum += product.getPrice();
        } else {
            mapCheak.replace(product, mapCheak.get(product) + 1);
            sum += product.getPrice();
        }
    }

    public Map<Product, Integer> getMapCheak() {
        return mapCheak;
    }


}
