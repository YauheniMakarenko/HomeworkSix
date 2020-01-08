package com.lesson.HomeworkTen;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    Reccursion reccursion = new Reccursion();

    public static void main(String[] args) {

        Reccursion reccursion = new Reccursion();

        reccursion.allNumber(15);
        System.out.println();
        System.out.println("--------");
        System.out.println(reccursion.sumOfDigits(585));
        System.out.println(reccursion.palindrome("ТЕБЕТ"));

        List<Product> productList = Arrays.asList(
                new Product(1, "Razen", 156),
                new Product(2, "BENQ", 190),
                new Product(3, "Razen", 430),
                new Product(4, "Skorp", 200),
                new Product(5, "Lenovo", 380),
                new Product(6, "A4Tech", 590),
                new Product(7, "AMD", 700),
                new Product(8, "Nvidia", 900),
                new Product(9, "ТЕБЕТ", 837),
                new Product(10, "ТЕБЕТ", 837),
                new Product(11, "ТЕБЕТ", 837)
        );

        List<Product> collect1 = productList.stream()
                .filter(product -> reccursion.palindrome(product.getName()))
                .collect(Collectors.toList());
        System.out.println(collect1);

        List<String> collect2 = productList.stream()
                .map(product -> product.getName())
                .sorted((product1, product2) -> product1.compareTo(product2))
                .collect(Collectors.toList());
        System.out.println(collect2);

        List<Product> collect3 = productList.stream()
                .sorted((o1, o2) -> (-Integer.compare(o1.getPrice(), o2.getPrice())))
                .skip(5)
                .collect(Collectors.toList());
        System.out.println(collect3);

        OptionalDouble collect4 = productList.stream()
                .map(product -> product.getPrice())
                .mapToDouble((product) -> (product)).average();
        System.out.println(collect4);

        Map<Integer, Object> collect5 = productList.stream()
                .collect(Collectors.toMap((product) -> product.getId(), (product) -> "name:" + product.getName() + ", price:" + product.getPrice()));
        System.out.println(collect5);

        Map<Product, Long> collect6 = productList.stream()
                .collect(Collectors.toMap(product -> product, product -> productList.stream()
                        .filter(product1 -> product1.getName().equals(product.getName())).count()));
        System.out.println(collect6);


    }

}
