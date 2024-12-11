package ListProduct;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Product Catalog");
        frame.setSize(1000, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("Products", JLabel.CENTER);
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        container.add(titleLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(30, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        List<Products> products = loadProducts();

        int columns = 3;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).isAvailable()) {
                JPanel productPanel = createProductPanel(products.get(i));
                gbc.gridx = i % columns;
                gbc.gridy = i / columns;
                mainPanel.add(productPanel, gbc);
            }
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        container.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().add(container);
        frame.setVisible(true);
    }

    private static List<Products> loadProducts() {
        List<Products> products = new ArrayList<>();
        products.add(new Products(1, "Orange", 1.7, 2.0, true, "Fruits", 0.3, "Fresh and juicy oranges.", "Tesco", "pic/orange.jpg"));
        products.add(new Products(2, "Milk", 2.0, 2.2, true, "Dairy", 0.2, "1 liter of low-fat milk.", "Asda", "pic/milk.jpeg"));
        products.add(new Products(3, "Bread", 2.3, 0.0, true, "Bakery", 0.0, "Whole grain bread.", "COOP", "pic/bread.jpg"));
        products.add(new Products(4, "Eggs", 1.6, 1.8, true, "Dairy", 0.2, "Pack of 6 eggs.", "Sainsbury's", "pic/eggs.jpg"));
        products.add(new Products(5, "Pasta", 1.0, 1.3, true, "Penne", 0.3, "Fresh made Italian Penne pasta.", "Aldi", "pic/pasta.jpg"));

        return products;
    }

    private static JPanel createProductPanel(Products product) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK, 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        panel.setBackground(Color.WHITE);

        panel.setPreferredSize(new Dimension(300, 350));

        String imagePath = product.getImagePath();
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        panel.add(imageLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel nameLabel = new JLabel(product.getName());
        nameLabel.setFont(new Font("Helvetica", Font.BOLD, 30));

        String oldPrice = product.getPreviousPrice() > 0
            ? "<span style='text-decoration: line-through; color: red; font-size: 16px;'>$" + product.getPreviousPrice() + "</span>"
            : "";
        String newPrice = "<span style='color: green; font-size: 16px;'>$" + product.getPrice() + "</span>";

        JLabel priceLabel = new JLabel("<html>" + oldPrice + " " + newPrice + "</html>");

        JLabel descriptionLabel = new JLabel("<html>" + product.getDescription() + "</html>");
        JLabel sourceLabel = new JLabel("Source: " + product.getSource());

        JButton orderButton = new JButton("Order");
        orderButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Ordering: " + product.getName()));

        panel.add(nameLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(priceLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(descriptionLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(sourceLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

//        panel.add(orderButton);

        return panel;
    }
}


