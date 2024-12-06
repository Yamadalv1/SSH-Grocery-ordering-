package com.grocery.dat;

public class Backend
{
     public static void main(String[] args) 
    {
        MockData mockData = new MockData();
        User user1 = new User();
        user1.setName("Ahmed");
        user1.setId(2490722);
        user1.setEmail("ahmedalam.usa@gmail.com");
        user1.setAddress("Birmingham, UK");
        mockData.setUsers(user1);
        System.out.println("Hello");
        System.out.println(user1.getName());
        System.out.println(user1.getId());
        System.out.println(user1.getEmail());
        System.out.println(user1.getAddress());
        

    }
}