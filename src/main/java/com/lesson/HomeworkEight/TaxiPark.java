package com.lesson.HomeworkEight;

import com.lesson.HomeworkEight.Enum.BodyType;
import com.lesson.HomeworkEight.Enum.CarClass;
import com.lesson.HomeworkEight.Enum.TypeOfDrive;
import com.lesson.HomeworkEight.File.CsvFile;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxiPark {
    private Map<Car, Integer> mapCar;
    private Map<Car, Client> mapCarForClient;
    private int sum;
    ValidatorForMenu validatorForMenu = new ValidatorForMenu();
    CsvFile csvFile = new CsvFile();


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
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            addCar(list.get(i));
        }
    }

    public void printOrders() {
        System.out.println("Список всех заказов");
        for (Map.Entry<Car, Client> map : mapCarForClient.entrySet()) {
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

    public int getSum() {
        return sum;
    }

    public void sort() {
        List list = new ArrayList(getMapCar().entrySet());
        Collections.sort(list, new CompareCar());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void addClient() {
        Scanner scanner = new Scanner(System.in);
        List<Car> listCarString = createListCar();
        System.out.println("Выберите автомобиль цифрой:");
        int keyInt;
        String keyString = scanner.next();
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
                Client client = new Client(stringName, stringAddress);
                mapCarForClient.put(listCarString.get(keyInt), client);
                csvFile.addProductInFile(listCarString.get(keyInt), client);
                System.out.println("Вы успешно заказали машину!");
            }
        }
    }

    private List<Car> createListCar(){
        List<Car> listCarBefore = new ArrayList(mapCar.entrySet());
        List<Car> listCarAfter = new ArrayList<>();
        for (int i = 0; i < listCarBefore.size(); i++) {
            Pattern pattern = Pattern.compile(".+\\}");
            Matcher matcher = pattern.matcher(String.valueOf(listCarBefore.get(i)));
            if (matcher.find()) {
                String group = matcher.group();
                System.out.println(i + ") " + group);
                listCarAfter.add(createCar(group));
            }
        }
        return listCarAfter;
    }

    private Car createCar(String productsString) {
        productsString = productsString.replace("{", "");
        productsString = productsString.replace("'", "");
        productsString = productsString.replace("Car", "");
        productsString = productsString.replace("}", "");
        productsString = productsString.replaceAll(" ", "");

        String[] pairs = productsString.split(",");

        String[] split0 = pairs[0].split("=");
        String[] split1 = pairs[1].split("=");
        String[] split2 = pairs[2].split("=");
        String[] split3 = pairs[3].split("=");
        String[] split4 = pairs[4].split("=");
        String[] split5 = pairs[5].split("=");
        String[] split6 = pairs[6].split("=");
        String[] split7 = pairs[7].split("=");
        String[] split8 = pairs[8].split("=");
        Car car = new Car(split0[1],
                split1[1],
                CarClass.valueOf(split2[1]),
                BodyType.valueOf(split3[1]),
                TypeOfDrive.valueOf(split4[1]),
                Integer.parseInt(split5[1]),
                Integer.parseInt(split6[1]),
                Integer.parseInt(split7[1]),
                Double.parseDouble(split8[1]));
        return car;
    }
}
