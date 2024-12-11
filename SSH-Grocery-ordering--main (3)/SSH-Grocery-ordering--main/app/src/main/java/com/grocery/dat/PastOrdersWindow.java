package com.grocery.dat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PastOrdersWindow {

    private JFrame frame;

    public PastOrdersWindow(List<User> users) {
        
        frame = new JFrame("Past Orders");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);

        
        String[] columnNames = {"User", "Order ID", "Date", "Total", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        
        for (User user : users) {
            List<Order> orderHistory = user.getOrderHistory();
            for (Order order : orderHistory) {
                Object[] row = {user.getName(), order.getOrderId(), order.getDate(), order.getTotal(), order.getStatus()};
                tableModel.addRow(row);
            }
        }

        
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        
        frame.setVisible(true);
    }
}
