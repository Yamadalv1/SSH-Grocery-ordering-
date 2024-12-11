package com.grocery.dat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OrderWindow {

    private List<Product> productsCatalog;
    private User currentUser;
    private DefaultTableModel cartModel;

    public OrderWindow(List<Product> productsCatalog, User currentUser) {
        this.productsCatalog = productsCatalog;
        this.currentUser = currentUser;
        createWindow();
    }
    
    private double calculateTotal(List<OrderItem> orderItems) {
        double total = 0;
        for (OrderItem item : orderItems) {
            total += item.getTotalProductPrice();
        }
        return total;
    }
    
    private int generateOrderId() {
        
        return (int) (System.currentTimeMillis() / 1000);  
    }



    private void createWindow() {
        JFrame frame = new JFrame("Order Grocery");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        
        String[] productColumns = {"ID", "Name", "Price", "Available", "Category"};
        DefaultTableModel productModel = new DefaultTableModel(productColumns, 0);
        for (Product product : productsCatalog) {
            productModel.addRow(new Object[]{
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.isAvailable(),
                    product.getCategory()
            });
        }
        JTable productTable = new JTable(productModel);
        JScrollPane productScrollPane = new JScrollPane(productTable);

        
        String[] cartColumns = {"ID", "Name", "Price", "Quantity", "Total Price"};
        cartModel = new DefaultTableModel(cartColumns, 0);
        JTable cartTable = new JTable(cartModel);
        JScrollPane cartScrollPane = new JScrollPane(cartTable);

        
        JPanel buttonPanel = new JPanel();
        JButton addToCartButton = new JButton("Add to Cart");
        JButton checkoutButton = new JButton("Checkout");

        buttonPanel.add(addToCartButton);
        buttonPanel.add(checkoutButton);

        
        frame.add(new JLabel("Product Catalog"), BorderLayout.NORTH);
        frame.add(productScrollPane, BorderLayout.WEST);
        frame.add(cartScrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        
        

        
        addToCartButton.addActionListener(e -> addToCart(productTable));
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Order newOrder = new Order();
                newOrder.setOrderId(generateOrderId());  
                newOrder.setDate(java.time.LocalDate.now().toString());  
                List<OrderItem> orderItems = new ArrayList<>();

                
                for (int i = 0; i < cartModel.getRowCount(); i++) {
                    int productId = (int) cartModel.getValueAt(i, 0);
                    String productName = (String) cartModel.getValueAt(i, 1);
                    double productPrice = (double) cartModel.getValueAt(i, 2);
                    int quantity = (int) cartModel.getValueAt(i, 3);
                    double totalPrice = (double) cartModel.getValueAt(i, 4);

                    OrderItem orderItem = new OrderItem();
                    orderItem.setProductId(productId);
                    orderItem.setProductName(productName);
                    orderItem.setQuantity(quantity);
                    orderItem.setProductPrice(productPrice);
                    orderItem.setTotalProductPrice(productPrice, quantity);
                    
                    orderItems.add(orderItem);
                }

                newOrder.setItems(orderItems);
                newOrder.setTotal(calculateTotal(orderItems));  
                newOrder.setStatus("Completed");

                
                currentUser.getOrderHistory().add(newOrder);

                
                currentUser.setCurrentCart(new ArrayList<>());

                
                JOptionPane.showMessageDialog(
                    frame, 
                    "Checkout successful! Your order has been saved to your order history.", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE 
                );
            }
        });


        frame.setVisible(true);
    }

    private void addToCart(JTable productTable) {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow != -1) {
            boolean isAvailable = (boolean) productTable.getValueAt(selectedRow, 3); 
            if (!isAvailable) {
                JOptionPane.showMessageDialog(null, "This product is currently unavailable and cannot be added to the cart.");
                return; 
            }

            int productId = (int) productTable.getValueAt(selectedRow, 0);
            String productName = (String) productTable.getValueAt(selectedRow, 1);
            double productPrice = (double) productTable.getValueAt(selectedRow, 2);

            String quantityStr = JOptionPane.showInputDialog("Enter Quantity:");
            try {
                int quantity = Integer.parseInt(quantityStr);
                double totalPrice = productPrice * quantity;

                cartModel.addRow(new Object[]{productId, productName, productPrice, quantity, totalPrice});
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid quantity.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a product to add.");
        }
    }



}
