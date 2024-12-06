package com.grocery.dat;

import java.util.ArrayList;
import java.util.List;

public class MockData {
    private List<Product> productCatalog;
    private List<User> usersList = new ArrayList<>(); //modiefied

    public List<Product> getProductCatalog(){
        return productCatalog;
    }

    public void setProductCatalog(List<Product> productCatalog){
        this.productCatalog = productCatalog;
    }

    public List<User> getUsers(){
        return usersList; //modiefied
    }

    public void setUsers(User users){ //modified
        usersList.add(users); // modiefied
    }
}
