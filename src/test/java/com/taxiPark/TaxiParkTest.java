package com.taxiPark;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.Client;
import com.lesson.HomeworkEight.Enum.BodyType;
import com.lesson.HomeworkEight.Enum.CarClass;
import com.lesson.HomeworkEight.Enum.TypeOfDrive;
import com.lesson.HomeworkEight.File.ReadJSON;
import com.lesson.HomeworkEight.SortStrategy.SortTopByMaxSpeed;
import com.lesson.HomeworkEight.SortStrategy.SortTopByPrice;
import com.lesson.HomeworkEight.TaxiPark.TaxiPark;
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

    @Before
    public void init(){
        taxiPark = TaxiPark.getInstance();
        mapCar = new HashMap<>();
        mapCarForClient = new HashMap<>();


    }

    @Test
    public void testCostAllCars(){
        ReadJSON productFileReadJSON = new ReadJSON();
        taxiPark.addCar(productFileReadJSON.createLispProductFile("listCar.json"));
        Assert.assertEquals(1365900, taxiPark.getCostOfCars());
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

    @Test
    public void testTopCarSpeed(){
        Car car1 = new Car("AAAA", "AAAA", CarClass.D, BodyType.SEDAN, TypeOfDrive.FULL, 150000, 2018, 350, 8.8);
        Car car2 = new Car("BBB", "AAAA", CarClass.D, BodyType.SEDAN, TypeOfDrive.FULL, 200000, 2018, 300, 7.8);
        Car car3 = new Car("CCC", "AAAA", CarClass.D, BodyType.SEDAN, TypeOfDrive.FULL, 250000, 2018, 400, 6.8);
        Car car4 = new Car("DDD", "AAAA", CarClass.D, BodyType.SEDAN, TypeOfDrive.FULL, 150000, 2018, 450, 10.8);
        taxiPark.addCar(car1);
        taxiPark.addCar(car2);
        taxiPark.addCar(car3);
        taxiPark.addCar(car4);
        List<Map.Entry<Car, Integer>> list = new SortTopByMaxSpeed().sortTop();
        Assert.assertTrue(list.get(0).getKey() == car4);
        Assert.assertTrue(list.get(1).getKey() == car3);
        Assert.assertTrue(list.get(2).getKey() == car1);
    }

    @Test
    public void testTopCarPrice(){
        Car car1 = new Car("AAAA", "AAAA", CarClass.D, BodyType.SEDAN, TypeOfDrive.FULL, 150000, 2018, 350, 8.8);
        Car car2 = new Car("BBB", "AAAA", CarClass.D, BodyType.SEDAN, TypeOfDrive.FULL, 200000, 2018, 300, 7.8);
        Car car3 = new Car("CCC", "AAAA", CarClass.D, BodyType.SEDAN, TypeOfDrive.FULL, 250000, 2018, 400, 6.8);
        Car car4 = new Car("DDD", "AAAA", CarClass.D, BodyType.SEDAN, TypeOfDrive.FULL, 100000, 2018, 450, 10.8);
        taxiPark.addCar(car1);
        taxiPark.addCar(car2);
        taxiPark.addCar(car3);
        taxiPark.addCar(car4);
        List<Map.Entry<Car, Integer>> list = new SortTopByPrice().sortTop();
        Assert.assertTrue(list.get(0).getKey() == car3);
        Assert.assertTrue(list.get(1).getKey() == car2);
        Assert.assertTrue(list.get(2).getKey() == car1);
    }
}
