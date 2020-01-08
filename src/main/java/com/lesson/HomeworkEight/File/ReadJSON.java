package com.lesson.HomeworkEight.File;

import com.lesson.HomeworkEight.*;
import com.lesson.HomeworkEight.Enum.BodyType;
import com.lesson.HomeworkEight.Enum.CarClass;
import com.lesson.HomeworkEight.Enum.TypeOfDrive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadJSON {

    private List<Car> createProducts(String productsString) {
        String[] split = productsString.split("},\\{");

        List<String> processedString = new ArrayList<>();
        for (String s1 : split) {
            processedString.add(s1.replaceAll("\\{", "").replaceAll("}", ""));
        }
        List<Car> cars = new ArrayList<>();
        for (String s1 : processedString) {
            cars.add(createProduct(s1));
        }
        return cars;
    }

    private Car createProduct(String productsString) {
        String[] pairs = productsString.split(",");

        Car car = new Car(pairs[0].split(":")[1],
                pairs[1].split(":")[1],
                CarClass.valueOf(pairs[2].split(":")[1]),
                BodyType.valueOf(pairs[3].split(":")[1]),
                TypeOfDrive.valueOf(pairs[4].split(":")[1]),
                Integer.parseInt(pairs[5].split(":")[1]),
                Integer.parseInt(pairs[6].split(":")[1]),
                Integer.parseInt(pairs[7].split(":")[1]),
                Double.parseDouble(pairs[8].split(":")[1]));
        return car;
    }

    public List<Car> createLispProductFile(String fileName) {

        String accumulator = "";
        try(FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String string = "";
            while (string != null) {
                string = bufferedReader.readLine();
                if (string == null) break;
                accumulator += string;
            }
        }catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        accumulator = accumulator.replace("[", "");
        accumulator = accumulator.replace("]", "");
        accumulator = accumulator.replace("\"", "");
        accumulator = accumulator.replaceAll(" ", "");

        List<Car> listCar = createProducts(accumulator);

        return listCar;
    }
}
