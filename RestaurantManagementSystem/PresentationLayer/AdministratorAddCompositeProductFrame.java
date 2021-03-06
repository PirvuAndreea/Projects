package PresentationLayer;

import BusinessLayer.BaseProduct;
import BusinessLayer.CompositeProduct;
import BusinessLayer.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class AdministratorAddCompositeProductFrame extends JFrame {
    private List<JCheckBox> jCheckBoxes;
    private List<JLabel> jLabels;

    AdministratorAddCompositeProductFrame(boolean edit, BusinessLayer.MenuItem menuItem) {
    
        setLayout(null);
        setSize(350, 450);
        setTitle("Add Composite Menu Item");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(15, 10, 50, 25);
        add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setBounds(70, 10, 250, 25);
        add(nameField);
        JLabel ingredientsLabel = new JLabel("Ingredients:");
        ingredientsLabel.setBounds(15, 45, 100, 25);
        add(ingredientsLabel);
        add(createJScrollPane());
        JButton addButton = new JButton("Add");
        addButton.setBounds(80, 380, 80, 25);
        add(addButton);
        JButton backButton = new JButton("Cancel");
        backButton.setBounds(180, 380, 80, 25);
        add(backButton);
        addButtonActionListener(addButton, nameField, edit, menuItem);
        backButtonActionListener(backButton);
        editCase(edit, nameField, menuItem, addButton);
        setVisible(true);
    }

    private JScrollPane createJScrollPane() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        List<BusinessLayer.MenuItem> menuItems = Restaurant.getBaseMenuItems();
        jCheckBoxes = new ArrayList<>();
        jLabels = new ArrayList<>();
        for (BusinessLayer.MenuItem menuItem1 : menuItems) {
            int i = menuItems.indexOf(menuItem1);
            JCheckBox jCheckBox = new JCheckBox();
            jCheckBox.setBounds(5, 5 + i * 30, 25, 25);
            jPanel.add(jCheckBox);
            JLabel jLabel = new JLabel(menuItem1.getName() + " - " + menuItem1.computePrice() + " RON");
            jLabel.setBounds(40, 5 + i * 30, 200, 25);
            jPanel.add(jLabel);
            jCheckBoxes.add(jCheckBox);
            jLabels.add(jLabel);
        }
        jPanel.setPreferredSize(new Dimension(280, 5 + 30 * menuItems.size()));
        JScrollPane jScrollPane = new JScrollPane(jPanel);
        jScrollPane.setBounds(15, 70, 305, 300);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        return jScrollPane;
    }

    private void addButtonActionListener(JButton addButton, JTextField nameField, boolean edit, BusinessLayer.MenuItem menuItem) {
        addButton.addActionListener(e -> {
            CompositeProduct compositeProduct = new CompositeProduct(nameField.getText());

            for (JCheckBox jCheckBox : jCheckBoxes) {
                if (jCheckBox.isSelected()) {
                    String string = jLabels.get(jCheckBoxes.indexOf(jCheckBox)).getText();
                    String ingredientName = "";
                    int ingredientPrice = 0;
                    int p = 1;
                    int i;
                    for (i = string.length() - 5; string.charAt(i) >= '0' && string.charAt(i) <= '9'; i--) {
                        ingredientPrice = ingredientPrice * p + string.charAt(i) - '0';
                        p = p * 10;
                    }
                    i = i - 3;
                    while (i >= 0) {
                        ingredientName = (string.charAt(i) + "").concat(ingredientName);
                        i--;
                    }
                    compositeProduct.addIngredient(new BaseProduct(ingredientName, ingredientPrice));
                }
            }
            if (edit)
                Restaurant.deleteItem(menuItem);
            Restaurant.createItem(compositeProduct);
            dispose();
        });
    }

   
    private void editCase(boolean edit, JTextField nameField, BusinessLayer.MenuItem menuItem, JButton addButton) {
        if (edit) {
            nameField.setText(menuItem.getName());
            addButton.setText("OK");
            setTitle("Edit Base Menu Item");
            CompositeProduct compositeProduct = (CompositeProduct) menuItem;
            List<BusinessLayer.MenuItem> menuItemList = compositeProduct.getIngredients();
            for (BusinessLayer.MenuItem menuItem1 : menuItemList) {
                for (JLabel jLabel : jLabels) {
                    if (jLabel.getText().compareTo(menuItem1.getName() + " - " + menuItem1.computePrice() + " RON") == 0) {
                        jCheckBoxes.get(jLabels.indexOf(jLabel)).setSelected(true);
                    }
                }
            }
        }
    }
    private void backButtonActionListener(JButton backButton) {
        backButton.addActionListener(e -> dispose());
    }
}