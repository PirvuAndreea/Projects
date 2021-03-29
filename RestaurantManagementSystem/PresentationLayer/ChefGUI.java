package PresentationLayer;

import BusinessLayer.Order;
import BusinessLayer.Restaurant;
import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChefGUI extends JFrame implements Observer {
    public ChefGUI() {
        setLayout(null);
        setSize(400, 650);
        setTitle("Chef");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(this.getX() + 420, this.getY());
        List<Order> orders = Restaurant.createOrderList();
        add(createJScrollPane(orders));

        setVisible(true);
    }

    public void update() {
        NotificationFrame.newOrderNotify();
    }
    
    private JScrollPane createJScrollPane(List<Order> orders) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        int contor = 0;

        for (Order order : orders) {
            if (!order.isDone()) {
                JLabel jLabel = new JLabel("Order: " + order.getOrderID());
                jLabel.setBounds(15, 10 + contor * 40, 200, 25);
                jPanel.add(jLabel);
                JButton jButton = new JButton("Done");
                jButton.setBounds(255, 10 + contor * 40, 80, 25);
                buttonActionListener(jButton, order);
                jPanel.add(jButton);
                contor++;
            }
        }
        jPanel.setPreferredSize(new Dimension(280, 15 + 40 * contor));
        JScrollPane jScrollPane = new JScrollPane(jPanel);
        jScrollPane.setBounds(10, 10, 367, 595);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        return jScrollPane;
    }

    private void buttonActionListener(JButton jButton, Order order) {
        jButton.addActionListener(e -> {
            Restaurant.getOrder(order.getOrderID()).setDone(true);
            Main.getWaiterGUI().getJFrame().dispose();
            Main.setWaiterGUI(new WaiterGUI());
            ChefGUI chefGraphicalUserInterface = new ChefGUI();
            Main.setChefGUI(chefGraphicalUserInterface);
            Main.getWaiterGUI().addObserver(chefGraphicalUserInterface);
            dispose();
        });
    }
  
}