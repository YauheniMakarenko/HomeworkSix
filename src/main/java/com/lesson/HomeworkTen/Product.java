package com.lesson.HomeworkTen;

import java.util.Objects;

public class Product {
    private final String name;
    private final int id;
    private final int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id:" + id +
                ", name:'" + name + '\'' +
                ", price:" + price +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                price == product.price &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, price);
    }
}
