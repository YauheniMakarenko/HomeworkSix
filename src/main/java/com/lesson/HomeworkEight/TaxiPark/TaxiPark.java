package com.lesson.HomeworkEight.TaxiPark;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.Client;
import com.lesson.HomeworkEight.Enum.BodyType;
import com.lesson.HomeworkEight.Enum.CarClass;
import com.lesson.HomeworkEight.Enum.TypeOfDrive;
import com.lesson.HomeworkEight.File.CsvFile;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxiPark implements ITaxiPark {
    private Map<Car, Integer> mapCar = new HashMap<>();
    private Map<Car, Client> mapCarForClient = new HashMap<>();
    private int costOfCars;
    private ValidatorForMenu validatorForMenu = new ValidatorForMenu();
    private CsvFile csvFile = new CsvFile();
    private static TaxiPark instance;


    private TaxiPark() {
    }


    public static TaxiPark getInstance() {
        if (instance == null) {
            instance = new TaxiPark();
        }
        return instance;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            return;
        }
        if (!mapCar.containsKey(car)) {
            mapCar.put(car, 1);
            costOfCars += car.getPrice();
        } else {
            mapCar.put(car, mapCar.get(car) + 1);
            costOfCars += car.getPrice();
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
        System.out.println("Сost of all cars: " + costOfCars);
    }

    @Override
    public Map<Car, Integer> getMapCar() {
        return mapCar;
    }

    @Override
    public int getCostOfCars() {
        return costOfCars;
    }

    @Override
    public void sort() {
        List list = new ArrayList(getMapCar().entrySet());
        Collections.sort(list, (Comparator<Map.Entry<Car, Integer>>) (o1, o2) ->
                (int) Math.round(100.0 * (o1.getKey().getFuelConsumption() - o2.getKey().getFuelConsumption())));
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

    private List<Car> createListCar() {
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

    private Car createCar(String carString) {
        carString = carString.replace("{", "");
        carString = carString.replace("'", "");
        carString = carString.replace("Car", "");
        carString = carString.replace("}", "");
        carString = carString.replaceAll(" ", "");

        String[] pairs = carString.split(",");

        Car car = new Car(pairs[0].split("=")[1],
                pairs[1].split("=")[1],
                CarClass.valueOf(pairs[2].split("=")[1]),
                BodyType.valueOf(pairs[3].split("=")[1]),
                TypeOfDrive.valueOf(pairs[4].split("=")[1]),
                Integer.parseInt(pairs[5].split("=")[1]),
                Integer.parseInt(pairs[6].split("=")[1]),
                Integer.parseInt(pairs[7].split("=")[1]),
                Double.parseDouble(pairs[8].split("=")[1]));
        return car;
    }
}
