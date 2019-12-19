package com.lesson.HomeworkEight.File;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.Client;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class CsvFile {

    public void addProductInFile(Car car, Client client, String fileName) {
        try(FileWriter fileWriter = new FileWriter(fileName, true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append( car + " = " + client  + "\n");
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
