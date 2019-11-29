package com.lesson6;

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
                "id" + id +
                ", name'" + name + '\'' +
                ", price" + price +
                '}';
    }

    public String toJSON(){
        return "{\n\"type\":\""+this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1)+"\""+"," +
                "\n\"id\":" + id +
                ",\n\"name\":\"" + name + "\"" +
                ",\n\"price\":" + price + "\n}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Product product = (Product) obj;
        if (getId() != product.getId()) {
            return false;
        }
        if (!getName().equals(product.getName())){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        long temp = getPrice();
        int result = 1;
        result = prime * result * getId() + (int) (temp ^ (temp >>> prime + 1));
        result = prime * result + getName().hashCode();
        return result;
    }
}
