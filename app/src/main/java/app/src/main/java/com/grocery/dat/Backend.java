package app.src.main.java.com.grocery.dat;

import java.util.ArrayList;
import java.util.List; 
import java.util.Scanner;

//import com.fasterxml.jackson.core.format.InputAccessor;

public class Backend
{
    public MockData mockData = new MockData();

    Scanner input = new Scanner(System.in);

    int orderId = 1;

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
        user1.setHouseHold(1);
        mockData.setUsers(user1);

        User user2 = new User();
        user2.setName("Oscar");
        user2.setId(2);
        user2.setEmail("oscar@example.com");
        user2.setAddress("Tennis Court");
        user2.setHouseHold(1);
        mockData.setUsers(user2);

        User user3 = new User();
        user3.setName("Carlos");
        user3.setId(3);
        user3.setEmail("carlos@example.com");
        user3.setAddress("Mason");
        user3.setHouseHold(2);
        mockData.setUsers(user3);

        User user4 = new User();
        user4.setName("Tom");
        user4.setId(4);
        user4.setEmail("tom@example.com");
        user4.setAddress("Tennis Court");
        user4.setHouseHold(1);
        mockData.setUsers(user4);

        User user5 = new User();
        user5.setName("Charles");
        user5.setId(5);
        user5.setEmail("charles@example.com");
        user5.setAddress("Mason");
        user5.setHouseHold(2);
        mockData.setUsers(user5);
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

        while (true) 
        { 
            System.out.println("Welcome to Grocery Delivery Service!");
            System.out.println("UserName\tUserId\tHouseHold");
            
            for (int i = 0; i < userList.size(); i++)
            {
                User user = userList.get(i);
                System.out.println(user.getName() + "\t\t" + user.getId() + "\t\t" + user.getHouseHold());
            }

            System.out.println("Please Enter your user Id or -1 to close Delivery Service: ");
            currentUser = input.nextInt();
            if (currentUser == -1)
            {
                System.out.println("Delivery Service Closed");
                break;
            }
            User user = userList.get(currentUser - 1);
                
            while (true)
            {
                System.out.println("Please choose one option");
                System.out.println("1: Order Grocery");
                System.out.println("2: View your past orders");
                System.out.println("3: View your household past orders");
                System.out.println("4: End current session");
                System.out.println("Enter option number: ");
            
                optionSelected = input.nextInt();
                if (optionSelected == 1) 
                {
                    user = orderGrocery(user);
                    userList.set(currentUser - 1, user);
                }
                else if (optionSelected == 2) 
                {
                    List<Order> currentOrderHistory = new ArrayList<>();
                    currentOrderHistory.addAll(user.getOrderHistory());

                    for (int i = 0; i < currentOrderHistory.size(); i++)
                    {
                        Order currentOrder = currentOrderHistory.get(i);
                        System.out.println("Order Id: " + currentOrder.getOrderId());
                        System.out.println("Item Name\tPrice\tQuantity\tTotal Price");
                        List<OrderItem> orderItems = currentOrder.getItems();
                        for(int j = 0; j < orderItems.size(); j++)
                        {
                            System.out.println(orderItems.get(j).getProductName() + "  " + orderItems.get(j).getProductPrice() +
                                               "  " + orderItems.get(j).getQuantity() + "  " + orderItems.get(j).getTotalProductPrice());
                        }
                        System.out.println("________________________________________________________");
                    }
                }
                else if (optionSelected == 3) 
                {
                    if (user.getHouseHold() == 1)
                    {
                        List<Order> houseHoldOrderHistory = new ArrayList<>();

                        User user1 = userList.get(0);
                        User user2 = userList.get(1);
                        User user3 = userList.get(3);

                        houseHoldOrderHistory.addAll(user1.getOrderHistory());
                        houseHoldOrderHistory.addAll(user2.getOrderHistory());
                        houseHoldOrderHistory.addAll(user3.getOrderHistory());

                        System.out.println("Item Name\tPrice\tQuantity\tTotal Price");

                        for (int i = 0; i < houseHoldOrderHistory.size(); i++)
                        {
                            Order currentOrder = houseHoldOrderHistory.get(i);
                            List<OrderItem> orderItems = currentOrder.getItems();
                            for(int j = 0; j < orderItems.size(); j++)
                            {
                                System.out.println(orderItems.get(j).getProductName() + "  " + orderItems.get(j).getProductPrice() +
                                                "  " + orderItems.get(j).getQuantity() + "  " + orderItems.get(j).getTotalProductPrice());
                            }
                        }
                    }
                    else
                    {
                        User user1 = userList.get(2);
                        User user2 = userList.get(4);
                        List<Order> houseHoldOrderHistory = new ArrayList<>();
                        houseHoldOrderHistory.addAll(user1.getOrderHistory());
                        houseHoldOrderHistory.addAll(user2.getOrderHistory());



                    }
                }
                else if (optionSelected == 4)
                {
                    System.out.println("Session Ended");
                    break;
                }
                else 
                {
                    System.out.println("Chosee Valid Option");
                }
            }
        }
    }

        

    public User orderGrocery(User currentUser)
    {
        User user = currentUser;
        
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
                    Order newOrder = new Order();
                    newOrder.setItems(orderItems);
                    newOrder.setOrderId(orderId);
                    orderId++;
                    user.setOrderHistory(newOrder);
                    System.out.println("Checkout Successfully");
                    break;
                }
                else
                {
                    System.out.println("Checkout Unsuccessfull");
                }
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
