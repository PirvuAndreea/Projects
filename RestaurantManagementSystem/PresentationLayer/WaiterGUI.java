package PresentationLayer;

import BusinessLayer.Observable;
import BusinessLayer.Order;
import BusinessLayer.Restaurant;
import Main.Main;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WaiterGUI extends Observable {
    private JTable jTable;
    private JFrame jFrame = new JFrame();
    Color culoarebackground=new Color(0x20D3D3D3);
    public WaiterGUI() {
 
        jFrame.setLayout(null);
        jFrame.setSize(400, 650);
        jFrame.setTitle("Waiter");
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton addButton = new JButton("New Order");
        addButton.setBounds(5, 5, 376, 25);
        addButton.setBackground(culoarebackground);
        jFrame.add(addButton);
        JButton billButton = new JButton("Bill Order");
        billButton.setBounds(5, 35, 376, 25);
        billButton.setBackground(culoarebackground);
        jFrame.add(billButton);
        jFrame.add(createJScrollPane());
       
        addButtonActionListener(addButton, jFrame);
        billButtonActionListener(billButton, jFrame);

        jFrame.setVisible(true);
    }

    private JScrollPane createJScrollPane() {
        jTable = Restaurant.createOrdersTable();
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (jTable.getRowCount() > 0)
            jTable.setRowSelectionInterval(0, 0);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(5, 65, 376, 544);
        return jScrollPane;
    }

    private void addButtonActionListener(JButton addButton, JFrame jFrame) {
        addButton.addActionListener(e -> {
            WaiterAddNewOrderFrame addOrderFrame = new WaiterAddNewOrderFrame();
            addOrderFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    Main.getChefGUI().dispose();
                    ChefGUI chefG = new ChefGUI();
                    Main.setChefGUI(chefG);
                    Main.getWaiterGUI().addObserver(chefG);
                    notifyAllObservers();
                    Main.setWaiterGUI(new WaiterGUI());
                    jFrame.dispose();
                }
            });
        });
    }
    private void billButtonActionListener(JButton billButton, JFrame jFrame) {
        billButton.addActionListener(e -> {
            Order order = Restaurant.getOrder(Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString()));
            JOptionPane.showMessageDialog(null, Restaurant.generateBill(order));
            Restaurant.deleteOrder(order);
            Main.getChefGUI().dispose();
            ChefGUI chefG = new ChefGUI();
            Main.setChefGUI(chefG);
            Main.getWaiterGUI().addObserver(chefG);
            Main.setWaiterGUI(new WaiterGUI());
            jFrame.dispose();
        });
    }
    JFrame getJFrame() {
        return jFrame;
    }
}