package com.lesson.HomeworkEight;

import com.lesson.HomeworkEight.Enum.BodyType;
import com.lesson.HomeworkEight.Enum.CarClass;
import com.lesson.HomeworkEight.Enum.Producer;
import com.lesson.HomeworkEight.Enum.TypeOfDrive;
import com.lesson.HomeworkEight.Menu.MainMenu;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new MainMenu().start();
    }

    public List add() {
        List<Car> listCar = new ArrayList<>();
        listCar.add(new Car(Producer.NISSAN, "GT-R", CarClass.S, BodyType.SEDAN, TypeOfDrive.REAR, 32000, 1995, 300, 20));
        listCar.add(new Car(Producer.MERCEDESBENZ, "CLS-63-AMG", CarClass.D, BodyType.COUPE, TypeOfDrive.FULL, 110000, 2019, 250, 15));
        listCar.add(new Car(Producer.MERCEDESBENZ, "AMG-G63", CarClass.J, BodyType.SUV, TypeOfDrive.FULL, 120000, 2019, 250, 13));
        listCar.add(new Car(Producer.MERCEDESBENZ, "Maybach S-650-Guard", CarClass.F, BodyType.SEDAN, TypeOfDrive.FULL, 1000000, 2019, 190, 8.7));
        listCar.add(new Car(Producer.HYUNDAI, "Solaris", CarClass.B, BodyType.SEDAN, TypeOfDrive.FULL, 4500, 2017, 190, 5.7));
        listCar.add(new Car(Producer.HYUNDAI, "Solaris", CarClass.B, BodyType.SEDAN, TypeOfDrive.FULL, 4500, 2017, 190, 5.7));
        listCar.add(new Car(Producer.KIA, "Rio", CarClass.B, BodyType.SEDAN, TypeOfDrive.FRONT, 11000, 2017, 190, 3.8));
        listCar.add(new Car(Producer.SKODA, "Rapid", CarClass.C, BodyType.SEDAN, TypeOfDrive.FRONT, 12500, 2012, 190, 5.6));
        listCar.add(new Car(Producer.RENAULT, "Logan", CarClass.B, BodyType.SEDAN, TypeOfDrive.FRONT, 9200, 2004, 175, 7.9));
        listCar.add(new Car(Producer.FORD, "Focus", CarClass.C, BodyType.SEDAN, TypeOfDrive.FRONT, 9200, 2011, 195, 8.3));
        listCar.add(new Car(Producer.TOYOTA, "Camry", CarClass.E, BodyType.SEDAN, TypeOfDrive.FULL, 18000, 2016, 210, 9.7));
        listCar.add(new Car(Producer.SKODA, "Octavia", CarClass.C, BodyType.HATCHBACK, TypeOfDrive.FULL, 35000, 2019, 230, 5));
        return listCar;
    }
}
