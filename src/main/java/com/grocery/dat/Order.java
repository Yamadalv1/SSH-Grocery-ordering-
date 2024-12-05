package com.grocery.dat;

import java.util.List;

public class Order {
    private int orderId;
    private String date;
    private List<OrderItem> items;
    private double total;
    private String status;

    public int getOrderId(){
        return orderId;
    }

    public void setOrderId(int orderId){
        this.orderId = orderId;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public List<OrderItem> getItems(){
        return items;
    }

    public void setItems(List<OrderItem> items){
        this.items = items;
    }

    public double getTotal(){
        return total;
    }

    public void setTotal(double total){
        this.total = total;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
