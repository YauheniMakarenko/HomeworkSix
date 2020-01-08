package com.lesson.HomeworkEight.SortStrategy;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.TaxiPark;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.*;

public class SortTopByPrice implements SortStrategy {

    private ValidatorForMenu validatorForMenu = new ValidatorForMenu();

    @Override
    public void sortTop() {
        List list = new ArrayList(TaxiPark.getInstance().getMapCar().entrySet());
        Collections.sort(list, (Comparator<Map.Entry<Car, Integer>>) (o1, o2) -> o2.getKey().getPrice() - o1.getKey().getPrice());
        System.out.println("Введите количество машин для вывода");
        Scanner scanner = new Scanner(System.in);
        String keyString = scanner.next();
        while (!validatorForMenu.validate(keyString)){
            System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
            System.out.println("Введите количество машин для вывода: ");
            keyString = scanner.next();
        }
        int key = Integer.parseInt(keyString);
        if (key > list.size()){
            key = list.size();
        }
        for (int i = 0; i < key; i++) {
            System.out.println(list.get(i));
        }
    }
}
