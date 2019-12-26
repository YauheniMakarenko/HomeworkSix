package com.lesson.HomeworkTen;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Reccursion reccursion = new Reccursion();

        reccursion.allNumber(15);
        System.out.println();
        System.out.println("--------");
        System.out.println(reccursion.sumOfDigits(585));
        System.out.println(reccursion.palindrome("qwerttrewq"));

        List<Product> productList = Arrays.asList(
                new Product(1, "Razen", 156),
                new Product(2, "BENQ", 190),
                new Product(3, "Razen", 430),
                new Product(4, "Skorp", 200),
                new Product(5, "Lenovo", 380),
                new Product(6, "A4Tech", 590),
                new Product(7, "AMD", 700),
                new Product(8, "Nvidia", 900)
        );

        List<String> collect2 = productList.stream()
                .map(product -> product.getName())
                .sorted((product1, product2) -> product1.compareTo(product2))
                .collect(Collectors.toList());
        System.out.println(collect2);

        OptionalDouble collect4 = productList.stream()
                .map(product -> product.getPrice())
                .mapToDouble((product) -> (product)).average();
        System.out.println(collect4);

        Map<Integer, Product> collect5 = productList.stream()
                .collect(Collectors.toMap((product) -> product.getId(), (Product) -> Product));
        System.out.println(collect5);

        /*List collect6 = productList.stream()
                .;
        System.out.println(collect6);*/
    }

}
