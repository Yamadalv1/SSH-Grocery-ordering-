package com.grocery.dat;

import java.util.ArrayList;
import java.util.List;

public class MockData {
    private final List<Product> productCatalog = new ArrayList<>();
    private final List<User> usersList = new ArrayList<>(); 

    public List<Product> getProductCatalog(){
        return productCatalog;
    }

    public void setProductCatalog(Product products){
        productCatalog.add(products);
    }

    public List<User> getUsers(){
        return usersList; 
    }

    public void setUsers(User users){
        usersList.add(users); 
    }
} 
