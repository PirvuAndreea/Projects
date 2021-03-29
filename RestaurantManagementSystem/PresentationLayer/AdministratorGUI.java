package PresentationLayer;

import BusinessLayer.CompositeProduct;
import BusinessLayer.MenuItem;
import BusinessLayer.Restaurant;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdministratorGUI extends JFrame {
    private JTable jTable;
    Color culoarebackground=new Color(0x20D3D3D3); 
    public AdministratorGUI() {
        setLayout(null);
        setSize(400, 650);
        setTitle("Administrator");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(this.getX() - 420, this.getY());
        JButton addBaseButton = new JButton("Add Base Menu Item");
        addBaseButton.setBounds(5, 5, 376, 25);
        add(addBaseButton);
        addBaseButton.setBackground(culoarebackground);
        JButton addCompositeButton = new JButton("Add Composite Menu Item");
        addCompositeButton.setBounds(5, 35, 376, 25);
        add(addCompositeButton);
        addCompositeButton.setBackground(culoarebackground);
        JButton editButton = new JButton("Edit Menu Item");
        editButton.setBounds(5, 65, 376, 25);
        add(editButton);
        editButton.setBackground(culoarebackground);
        JButton deleteButton = new JButton("Delete Menu Item");
        deleteButton.setBounds(5, 95, 376, 25);
        add(deleteButton);
        deleteButton.setBackground(culoarebackground);
        add(createJScrollPane());
        addBaseButtonActionListener(addBaseButton);
        addCompositeButtonActionListener(addCompositeButton);
        editButtonActionListener(editButton);
        deleteButtonActionListener(deleteButton);

        setVisible(true);
    }

    private JScrollPane createJScrollPane() {
        jTable = Restaurant.createTable();
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (jTable.getRowCount() > 0)
            jTable.setRowSelectionInterval(0, 0);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(5, 125, 376, 484);
        return jScrollPane;
    }

    private void addBaseButtonActionListener(JButton addBaseButton) {
        addBaseButton.addActionListener(e -> {
            AdministratorAddBaseProductFrame adminAddEditBaseFrame = new AdministratorAddBaseProductFrame(false, null);
            adminAddEditBaseFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    new AdministratorGUI();
                    dispose();
                }
            });
        });
    }

    private void addCompositeButtonActionListener(JButton addCompositeButton) {
        addCompositeButton.addActionListener(e -> {
            AdministratorAddCompositeProductFrame adminAddEditCompositeFrame = new AdministratorAddCompositeProductFrame(false, null);
            adminAddEditCompositeFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    new AdministratorGUI();
                    dispose();
                }
            });
        });
    }

    private void editButtonActionListener(JButton editButton) {
        editButton.addActionListener(e -> {
            MenuItem menuItem = Restaurant.getItem(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());

            if (menuItem.getClass().getSimpleName().compareTo("BaseProduct") == 0) {
                AdministratorAddBaseProductFrame adminAddEditBaseFrame = new AdministratorAddBaseProductFrame(true, menuItem);
                adminAddEditBaseFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        new AdministratorGUI();
                        dispose();
                    }
                });
            } else {
                AdministratorAddCompositeProductFrame adminAddEditCompositeFrame = new AdministratorAddCompositeProductFrame(true, menuItem);
                adminAddEditCompositeFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        new AdministratorGUI();
                        dispose();
                    }
                });
            }
        });
    }

    private void deleteButtonActionListener(JButton deleteButton) {
        deleteButton.addActionListener(e -> {
            if (Restaurant.canBeDeleted(jTable.getValueAt(jTable.getSelectedRow(), 0).toString())) {
                Restaurant.deleteItem(new CompositeProduct(jTable.getValueAt(jTable.getSelectedRow(), 0).toString()));
                new AdministratorGUI();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Can not delete");
            }
        });
    }
}