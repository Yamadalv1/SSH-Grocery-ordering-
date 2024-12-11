package com.grocery.dat;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Backend {
    public MockData mockData = new MockData();

    public static void main(String[] args) {
        Backend backend = new Backend();
        backend.userList();
        backend.productCatalog();
        backend.appStart();
    }

    public void userList() {
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

    public void productCatalog() {
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

    public void appStart() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Grocery Delivery Service!");
            System.out.println("1: Login");
            System.out.println("2: Exit");
            System.out.println("Enter your choice: ");

            int choice = input.nextInt();
            if (choice == 1) {
                login(input);
            } else if (choice == 2) {
                System.out.println("Thank you for using the Grocery Delivery Service!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        input.close();
    }

    public void login(Scanner input) {
        List<User> userList = new ArrayList<>(mockData.getUsers());

        System.out.println("UserName\tUserId");
        for (User user : userList) {
            System.out.println(user.getName() + "\t\t" + user.getId());
        }

        System.out.println("Please Enter your user Id: ");
        int currentUser = input.nextInt();
        if (currentUser <= 0 || currentUser > userList.size()) {
            System.out.println("Invalid User ID. Returning to login screen.");
            return;
        }

        User user = userList.get(currentUser - 1);

        
        while (true) {
            System.out.println("Please choose one option:");
            System.out.println("1: Order Grocery");
            System.out.println("2: View your past orders");
            System.out.println("3: Logout");

            System.out.println("Enter option number: ");
            int optionSelected = input.nextInt();

            if (optionSelected == 1) {
                user = orderGrocery(user);
            } else if (optionSelected == 2) {
                new PastOrdersWindow(userList);
            } else if (optionSelected == 3) {
                System.out.println("Logging out...");
                break;
            } else {
                System.out.println("Choose a valid option");
            }
        }
    }

    public User orderGrocery(User currentUser) {
        new OrderWindow(mockData.getProductCatalog(), currentUser);
        return currentUser;
    }

    public OrderItem addToCart(int id, String name, int quantity, double price) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(id);
        orderItem.setProductName(name);
        orderItem.setQuantity(quantity);
        orderItem.setProductPrice(price);
        orderItem.setTotalProductPrice(price, quantity);
        return orderItem;
    }

    public MockData getMockData() {
        return mockData;
    }
}
