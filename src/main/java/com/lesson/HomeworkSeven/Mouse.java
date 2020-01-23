package com.lesson.HomeworkSeven;

public class Mouse extends Product {

    public Mouse(int id, String name, int price){
        super(id, name, price);
    }


    @Override
    public String getName() {
        System.out.println("Name");
        return super.getName();
    }

    @Override
    public int getId() {
        System.out.println("Id");
        return super.getId();
    }

    @Override
    public int getPrice() {
        System.out.println("Цена");
        return super.getPrice();
    }
}
