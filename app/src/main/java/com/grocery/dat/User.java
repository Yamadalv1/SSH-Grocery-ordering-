package app.src.main.java.com.grocery.dat;


import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String email;
    private String address;
    private int household;
    private List<OrderItem> currentCart;
    private List<Order> orderHistory = new ArrayList<>();

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public int getHouseHold(){
        return household;
    }

    public void setHouseHold(int houseHold){
        this.household = houseHold;
    }

    public List<OrderItem> getCurrentCart(){
        return currentCart;
    }

    public void setCurrentCart(List<OrderItem> currentCart){
        this.currentCart = currentCart;
    }

    public List<Order> getOrderHistory(){
        return orderHistory;
    }

    public void setOrderHistory(Order orderHistory){
        this.orderHistory.add(orderHistory);
    }

}
