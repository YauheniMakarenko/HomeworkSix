package com.taxiPark;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.Client;
import com.lesson.HomeworkEight.Enum.BodyType;
import com.lesson.HomeworkEight.Enum.CarClass;
import com.lesson.HomeworkEight.Enum.TypeOfDrive;
import com.lesson.HomeworkEight.File.ReadJSON;
import com.lesson.HomeworkEight.TaxiPark;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxiParkTest {
    private TaxiPark taxiPark;
    private Map<Car, Integer> mapCar;
    private Map<Car, Client> mapCarForClient;
    private int sum;

    @Before
    public void init(){
        taxiPark = TaxiPark.getInstance();
        mapCar = new HashMap<>();
        mapCarForClient = new HashMap<>();

        ReadJSON productFileReadJSON = new ReadJSON();
        taxiPark.addCar(productFileReadJSON.createLispProductFile("listCar.json"));
    }

    @Test
    public void testCostAllCars(){
        Assert.assertEquals(1365900, taxiPark.getSum());
    }

    @Test
    public void testAddCar(){
        Car car = new Car("FORD", "focus", CarClass.D, BodyType.SEDAN, TypeOfDrive.FULL, 6700, 2018, 200, 8.8);
        taxiPark.addCar(car);
        Assert.assertTrue(taxiPark.getMapCar().containsKey(car));
    }

    @Test
    public void testAddDublicateCarsInTaxoPark(){
        Car car = new Car("FORD", "focus", CarClass.D, BodyType.SEDAN, TypeOfDrive.FULL, 6700, 2018, 200, 8.8);
        taxiPark.addCar(car);
        taxiPark.addCar(car);
        taxiPark.addCar(car);
        taxiPark.addCar(car);
        taxiPark.addCar(car);
        Assert.assertTrue(taxiPark.getMapCar().get(car) == 5);
    }

    @Test
    public void testAddCarNullInTaxoPark(){
        Car car = null;
        taxiPark.addCar(car);
        Assert.assertNull(taxiPark.getMapCar().get(car));
    }

    @Test
    public void testAddListCarNullInTaxoPark(){
        TaxiPark taxiParkTest = TaxiPark.getInstance();
        List<Car> list = null;
        taxiParkTest.addCar(list);
        Assert.assertNotNull(taxiParkTest.getMapCar()); //{}
    }

}
