package com.lesson.HomeworkEight.File;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkSeven.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteJSON {

    public void addProductInFile(Car car, String fileName) {
        List<String> listProduct = new ArrayList<>();
        if ((listProduct.size() == 0 && (overwriteExistingProducts(fileName).length() == 0))) {
            listProduct.add("[\n");
        }
        String string = toJSON(car);
        if (listProduct == null) {
            listProduct.add(string + ",\n");
        } else {
            listProduct.add(string + "\n]");
        }
        fileWrite(listProduct, fileName);

    }

    public void addProductInFile(List<Car> car, String fileName){
        for (int i = 0; i < car.size(); i++) {
            addProductInFile(car.get(i), fileName);
        }
    }

    private void fileWrite(List<String> listProduct, String fileName){
        String string = overwriteExistingProducts(fileName);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            if (string != null) {
                bufferedWriter.write(string);
            }
            for (int i = 0; i < listProduct.size(); i++) {
                bufferedWriter.append(listProduct.get(i));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }


    }

    private String overwriteExistingProducts(String fileName) {
        String str;
        String rez = "";
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            do {
                str = bufferedReader.readLine();
                if (str != null) {
                    rez += str + "\n";
                } else if (rez.length() != 0) {
                    rez = rez.substring(0, rez.length() - 3);
                    rez += ",\n";
                }
            } while (str != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rez;
    }

    public String toJSON(Car car) {
        return "{\n\"producer\":\"" + car.getProducer() + "\"" +
                ",\n\"model\":\"" + car.getModel() + "\"" +
                ",\n\"CarClass\":\"" + car.getCarСlass() + "\"" +
                ",\n\"bodyType\":\"" + car.getBodyType() + "\"" +
                ",\n\"typeOfDrive\":\"" + car.getTypeOfDrive() + "\"" +
                ",\n\"price\":" + car.getPrice() +
                ",\n\"year\":" + car.getYear() +
                ",\n\"maxSpeed\":" + car.getMaxSpeed() +
                ",\n\"fuelConsumption\":" + car.getFuelConsumption() + "\n}";
    }
}
