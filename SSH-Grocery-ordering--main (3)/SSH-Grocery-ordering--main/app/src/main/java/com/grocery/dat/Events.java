package com.grocery.dat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Events extends JPanel {
    
    private static final long serialVersionUID = 1L;
    
    public Events() {
        

        
        setLayout(new BorderLayout(20, 20));
        setBackground(Color.white);
        setBorder(BorderFactory.createEmptyBorder(40, 20, 30, 20));
        

        
        JButton newEvent = new JButton("Order Grocery");
        newEvent.setFont(new Font("Helvetica", Font.PLAIN, 20));
        newEvent.setBackground(Color.decode("#00d1e8"));
        newEvent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        newEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
      
        JButton pastOrders = new JButton("View Past Orders");
        pastOrders.setFont(new Font("Helvetica", Font.PLAIN, 20));
        pastOrders.setBackground(Color.decode("#00d1e8"));
        pastOrders.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pastOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        
        JButton logout = new JButton("Logout");
        logout.setFont(new Font("Helvetica", Font.PLAIN, 20));
        logout.setBackground(Color.decode("#00d1e8"));
        logout.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10)); 
        buttonPanel.setBackground(Color.white);
        buttonPanel.add(newEvent);
        buttonPanel.add(pastOrders);
        buttonPanel.add(logout);
        
        
        
        add(buttonPanel, BorderLayout.NORTH);
        

    }
}
