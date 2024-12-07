package com.grocery.dat;

import java.util.ArrayList;
import java.util.List; 
import java.util.Scanner;

//import com.fasterxml.jackson.core.format.InputAccessor;

public class Backend
{
    public MockData mockData = new MockData();

    public static void main(String[] args) 
    {
        Backend backend = new Backend();
        backend.userList();
        backend.productCatalog();
        backend.appStart();
    }

    public void userList()
    {
        User user1 = new User();
        user1.setName("Max");
        user1.setId(1);
        user1.setEmail("max@example.com");
        user1.setAddress("Tennis Court");
        mockData.setUsers(user1);

        User user2 = new User();
        user2.setName("Oscar");
        user2.setId(2);
        user2.setEmail("oscar@example.com");
        user2.setAddress("Tennis Court");
        mockData.setUsers(user2);
    }

    public void productCatalog()
    {
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Orange");
        product1.setPrice(1.7);
        product1.setPreviousPrice(2.0);
        product1.setAvailable(true);
        product1.setCategory("Fruits");
        product1.setDiscount(0.3);
        product1.setDescription("Fresh and juicy oranges.");
        product1.setSource("Tesco");
        mockData.setProductCatalog(product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Milk");
        product2.setPrice(2.0);
        product2.setPreviousPrice(2.2);
        product2.setAvailable(true);
        product2.setCategory("Dairy");
        product2.setDiscount(0.2);
        product2.setDescription("1 liter of low-fat milk.");
        product2.setSource("Asda");
        mockData.setProductCatalog(product2);

        Product product3 = new Product();
        product3.setId(3);
        product3.setName("Bread");
        product3.setPrice(2.3);
        product3.setPreviousPrice(null);
        product3.setAvailable(false);
        product3.setCategory("Bakery");
        product3.setDiscount(0.0);
        product3.setDescription("Whole grain bread.");
        product3.setSource("COOP");
        mockData.setProductCatalog(product3);

    }

    public void appStart()
    {
        int currentUser;
        int optionSelected;
        List<User> userList = new ArrayList<>();
        userList.addAll(mockData.getUsers());

        System.out.println("Welcome to Grocery Delivery Service!");
        System.out.println("UserName\tUserId");
        
        for (int i = 0; i < userList.size(); i++)
        {
            User user = userList.get(i);
            System.out.println(user.getName() + "\t\t" + user.getId());
        }

        System.out.println("Please Enter your user Id: ");
        Scanner input = new Scanner(System.in);
        currentUser = input.nextInt();
        User user = userList.get(currentUser - 1);
        System.out.println("Please choose one option");
        System.out.println("1: Order Grocery");
        System.out.println("2: View your past orders");
        System.out.println("3: View your household past orders");
        while (true)
        {
            System.out.println("Enter option number: ");
        
            optionSelected = input.nextInt();
            if (optionSelected == 1) 
            {
                user = orderGrocery(user);
                userList.add(currentUser - 1, user);
                break;
            }
            else if (optionSelected == 2) 
            {
                System.out.println("Need to write code for it yet");
            }
            else if (optionSelected == 3) 
            {
                System.out.println("Need to write code for it yet");
            }
            else
            {
                System.out.println("Chosee Valid Option");
            }
        }
        input.close();
    }

    public User orderGrocery(User currentUser)
    {
        User user = currentUser;
        Scanner input = new Scanner(System.in);
        int initateCheckout;
        List<OrderItem> orderItems = new ArrayList<>();
        List<Product> productsCatalog = new ArrayList<>();
        productsCatalog.addAll(mockData.getProductCatalog());
        System.out.println("!!!!Products Catalog!!!!");
        System.out.println("Id | Name | Price | Previous Price | IsAvailable | Category | Discount | Description | Source");
        for (int i = 0; i < productsCatalog.size(); i++)
        {
            Product product = productsCatalog.get(i);
            System.out.println(" " + product.getId() + "   " + product.getName() + "  " + "£" + product.getPrice() + 
                               "  " + "£" + product.getPreviousPrice() + "  " + product.isAvailable() + "  " + product.getCategory() + 
                               " " + "£" + product.getDiscount() + "  "  + product.getDescription() + "  " + product.getSource());
        }
        while (true)
        {
            System.out.println ("Enter Product Id To Add To Cart or 0 to checkout: ");
            initateCheckout = input.nextInt();
            if (initateCheckout == 0)
            {
                user.setCurrentCart(orderItems);
                System.out.println("Your Cart");
                System.out.println("Id\tName\tPrice\tQuantity\tTotal Price");
                for (int j = 0; j < orderItems.size(); j++)
                {
                    System.out.println(orderItems.get(j).getProductId() + "  " + orderItems.get(j).getProductName() + "  " + orderItems.get(j).getProductPrice() + 
                                       "  " + orderItems.get(j).getQuantity() + "  " + orderItems.get(j).getTotalProductPrice());
                }
                System.out.println("Are you sure to Checkout? Enter 1 for Yes: ");
                int j = input.nextInt();
                if (j == 1)
                {
                    System.out.println("Checkout Successfully");
                }
                break;
            }
            else
            {
                System.out.println("Enter Product Quantity: ");
                int productQuantity = input.nextInt();
                orderItems.add(addToCart(initateCheckout, productsCatalog.get(initateCheckout - 1).getName(), 
                                          productQuantity,productsCatalog.get(initateCheckout - 1).getPrice()));
                System.out.println("Product Added");
            }
        }
        input.close();
        return(user);
    }

    public OrderItem addToCart(int id, String name, int quantity, double price)
    {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(id);
        orderItem.setProductName(name);
        orderItem.setQuantity(quantity);
        orderItem.setProductPrice(price);
        orderItem.setTotalProductPrice(price, quantity);
        
        return (orderItem);
    } 
    public MockData getMockData() {
        return mockData;
    }

} 
