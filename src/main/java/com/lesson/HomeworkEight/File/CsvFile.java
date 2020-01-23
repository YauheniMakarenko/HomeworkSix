package com.lesson.HomeworkEight.File;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.Client;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class CsvFile {

    public void addProductInFile(Car car, Client client) {
        try(FileWriter fileWriter = new FileWriter("Orders.csv", true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append( car + " = " + client  + "\n");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
