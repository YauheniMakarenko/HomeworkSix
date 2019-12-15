package com.lesson.HomeworkEight.File;

import com.lesson.HomeworkEight.*;
import com.lesson.HomeworkEight.Enum.BodyType;
import com.lesson.HomeworkEight.Enum.CarClass;
import com.lesson.HomeworkEight.Enum.Producer;
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

        String[] split0 = pairs[0].split(":");
        String[] split1 = pairs[1].split(":");
        String[] split2 = pairs[2].split(":");
        String[] split3 = pairs[3].split(":");
        String[] split4 = pairs[4].split(":");
        String[] split5 = pairs[5].split(":");
        String[] split6 = pairs[6].split(":");
        String[] split7 = pairs[7].split(":");
        String[] split8 = pairs[8].split(":");
        Car car = new Car(Producer.valueOf(split0[1]),
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
