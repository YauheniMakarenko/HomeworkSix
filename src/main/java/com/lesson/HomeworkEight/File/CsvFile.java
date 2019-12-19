package com.lesson.HomeworkEight.File;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class CsvFile {

    public void addProductInFile(String s, String fileName) {
        try(FileWriter fileWriter = new FileWriter(fileName, true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append( s + "\n");
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
