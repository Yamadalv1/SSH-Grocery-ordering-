package com.grocery.dat;

import java.util.List;

public class MockData {
    private List<Product> productCatalog;
    private List<User> users;

    public List<Product> getProductCatalog(){
        return productCatalog;
    }

    public void setProductCatalog(List<Product> productCatalog){
        this.productCatalog = productCatalog;
    }

    public List<User> getUsers(){
        return users;
    }

    public void setUsers(List<User> users){
        this.users = users;
    }
    
}
