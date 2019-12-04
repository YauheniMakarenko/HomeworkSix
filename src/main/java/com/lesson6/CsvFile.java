package com.lesson6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvFile {

    public List<Product> createListProductFromFile(String fileName) throws IOException {
        List<Product> products = new ArrayList<>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String productString;
        do {
            productString = bufferedReader.readLine();
            if (productString == null) break;

            Product product = createProduct(productString);
            products.add(product);
        } while (productString != null);
        return products;
    }

    private static Product createProduct(String productString) {
        String[] split = productString.split(",");
        Product product1 = new Product(
                Integer.parseInt(split[0]),
                split[1],
                Integer.parseInt(split[2])
        );
        Product product = product1;
        return product;
    }

    public void addProductInFile(Product product, String fileName) {
        try(FileWriter fileWriter = new FileWriter(fileName, true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(product.getId() + "," + product.getName() + "," + product.getPrice() + "\n");
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addProductInFile(List<Product> product, String fileName) {
        for (int i = 0; i < product.size(); i++){
            addProductInFile(product.get(i), fileName);
        }
    }
}
