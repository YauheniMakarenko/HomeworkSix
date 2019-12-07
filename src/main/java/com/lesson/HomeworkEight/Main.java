package com.lesson.HomeworkEight;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Car> listCar = new ArrayList<>();
        listCar.add(new Car(Producer.NISSAN, "GT-R", BodyType.SEDAN, TypeOfDrive.REAR, 32000, 1995, 1000000, 300, 20, 1000, true));
        listCar.add(new Car(Producer.MERCEDESBENZ, "CLS-63-AMG", BodyType.COUPE, TypeOfDrive.FULL, 110000, 2019,0, 250, 15, 1500, true));
        listCar.add(new Car(Producer.MERCEDESBENZ, "AMG-G63", BodyType.SUV, TypeOfDrive.FULL, 120000, 2019, 0, 250 ,13, 2500, true));
        listCar.add(new Car(Producer.MERCEDESBENZ, "Maybach S 650 Guard", BodyType.SEDAN, TypeOfDrive.FULL, 1000000, 2019, 0, 190, 8.7, 2000, true));



        TaxiPark taxiPark = new TaxiPark();
        try{
            ProductFileReadJSON productFileReadJSON = new ProductFileReadJSON();
            taxiPark.addCar(productFileReadJSON.createLispProductFile("listCar.json"));
        }catch (IOException e) {
            e.printStackTrace();
            taxiPark.addCar(listCar);
        }
        taxiPark.print();

    }
}
