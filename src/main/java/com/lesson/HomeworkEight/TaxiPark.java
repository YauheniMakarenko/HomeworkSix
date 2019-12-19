package com.lesson.HomeworkEight;

import com.lesson.HomeworkEight.File.CsvFile;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxiPark {
    private Map<Car, Integer> mapCar;
    private Map<String, Client> mapCarForClient;
    private int sum;
    ValidatorForMenu validatorForMenu = new ValidatorForMenu();

    public TaxiPark() {
        this.mapCar = new HashMap<>();
        this.mapCarForClient = new HashMap<>();
    }

    public void addCar(Car car) {
        if (car == null) {
            return;
        }
        if (!mapCar.containsKey(car)) {
            mapCar.put(car, 1);
            sum += car.getPrice();
        } else {
            mapCar.put(car, mapCar.get(car) + 1);
            sum += car.getPrice();
        }
    }

    public void addCar(List<Car> list) {
        for (int i = 0; i < list.size(); i++) {
            addCar(list.get(i));
        }
    }

    public void printOrders() {
        System.out.println("Список всех заказов");
        for (Map.Entry<String, Client> map : mapCarForClient.entrySet()) {
            System.out.println(map.getKey() + ":" + map.getValue());
        }
        System.out.println("--------------------------------------------");
    }

    public void printCar() {
        System.out.println("Список всех автомобилей");
        for (Map.Entry<Car, Integer> map : mapCar.entrySet()) {
            System.out.println(map.getKey() + ":" + map.getValue());
        }
        System.out.println("--------------------------------------------");
        System.out.println("Сost of all cars: " + sum);
    }

    public Map<Car, Integer> getMapCar() {
        return mapCar;
    }

    public void sort() {
        List list = new ArrayList(getMapCar().entrySet());
        Collections.sort(list, new CompareCar());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private String listPars(String givenString){
        String group = null;
        Pattern pattern = Pattern.compile(".+\\}");
        Matcher matcher = pattern.matcher(givenString);
        if (matcher.find()) {
            group = matcher.group();
        }
        return group;
    }

    public void addClient() {
        Scanner scanner = new Scanner(System.in);
        List<Car> listCar = new ArrayList(mapCar.entrySet());
        List<String> listCarString = new ArrayList<>();
        for (int i = 0; i < listCar.size(); i++) {
            System.out.println(i + ") " + listPars(String.valueOf(listCar.get(i))));
            listCarString.add(listPars(String.valueOf(listCar.get(i))));
        }
        System.out.println("Выберите автомобиль (цифрой!):");
        String keyString;
        int keyInt;
        keyString = scanner.next();
        while (!validatorForMenu.validate(keyString)) {
            System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
            keyString = scanner.next();
        }
        keyInt = Integer.parseInt(keyString);
        for (int i = 0; i < listCarString.size(); i++) {
            if (keyInt == i) {
                System.out.println("Введите ваше имя:");
                String stringName = scanner.next();
                System.out.println("Введите адрес:");
                String stringAddress = scanner.next();
                mapCarForClient.put(listCarString.get(keyInt), new Client(stringName, stringAddress));
                CsvFile csvFile = new CsvFile();
                csvFile.addProductInFile(mapCarForClient.toString(), "Orders.csv");
            }
        }
        System.out.println("Вы успешно заказали машину!");
    }
}
