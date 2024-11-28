package main.java.com.grocery.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.com.grocery.dat.MockData;

import java.io.File;
import java.io.IOException;



public class MockDataLoader {
    public static MockData loadMockData(String filePath) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), MockData.class);
    }
    
    public static void main(String[] args){
        try {
            MockData mockData = loadMockData("src/main/resources/mock_data.json");
            System.out.println("Product Catalog: ");
            mockData.getProductCatalog().forEach(product ->
            System.out.println(product.getName() + " - $" + product.getPrice())
            );
            System.out.println("\nUsers:");
            mockData.getUsers().forEach(user ->
            System.out.println(user.getName() + " - " + user.getEmail())
            );
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
