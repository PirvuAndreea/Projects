package PresentationLayer;

import BusinessLayer.BaseProduct;
import BusinessLayer.MenuItem;
import BusinessLayer.Restaurant;

import java.awt.Color;

import javax.swing.*;

class AdministratorAddBaseProductFrame extends JFrame {
	   Color culoarebackground=new Color(0x20FFDEAD); 
    AdministratorAddBaseProductFrame(boolean edit, MenuItem menuItem) {
        
        setLayout(null);
        setSize(350, 150);
        setTitle("Add Base Menu Item");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(15, 10, 50, 25);
        add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setBounds(70, 10, 250, 25);
        add(nameField);
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(15, 40, 50, 25);
        add(priceLabel);
        JTextField priceField = new JTextField();
        priceField.setBounds(70, 40, 250, 25);
        add(priceField);
        JButton addButton = new JButton("Add");
        addButton.setBounds(80, 75, 80, 25);
        add(addButton);
        JButton CancelButton = new JButton("Cancel");
        CancelButton.setBounds(180, 75, 80, 25);
        add(CancelButton);
        
        addButtonActionListener(addButton, priceField, edit, menuItem, nameField);
        backButtonActionListener(CancelButton);

       
        if (edit) {
            nameField.setText(menuItem.getName());
            priceField.setText(menuItem.computePrice() + "");
            addButton.setText("OK");
            setTitle("Edit Base Menu Item");
        }

        setVisible(true);
    }

    private void addButtonActionListener(JButton addButton, JTextField priceField, boolean edit, MenuItem menuItem, JTextField nameField) {
        addButton.addActionListener(e -> {
            try {
                int price = Integer.parseInt(priceField.getText());
                if (edit) {
                    Restaurant.editItem(menuItem, nameField.getText(), price);
                    Restaurant.updatePrices();
                } else
                    Restaurant.createItem(new BaseProduct(nameField.getText(), price));
                dispose();
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(null, "Incorrect input");
            }
        });
    }

    private void backButtonActionListener(JButton backButton) {
        backButton.addActionListener(e -> dispose());
    }
}
