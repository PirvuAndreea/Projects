package PresentationLayer;

import javax.swing.*;

class NotificationFrame extends JFrame {
    private NotificationFrame() {
        setLayout(null);
        setSize(160, 120);
        setTitle("Order");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(this.getX() + 420, this.getY());
        JLabel message = new JLabel("NEW ORDER!");
        message.setBounds(37, 10, 180, 30);
        add(message);
        JButton okButton = new JButton("OK");
        okButton.setBounds(37, 45, 80, 25);
        add(okButton); 
        okButton.addActionListener(e -> dispose());

        setVisible(true);
    }

    static void newOrderNotify() {
        NotificationFrame notificationFrame = new NotificationFrame();
        Timer timer = new Timer(2000, e -> {
            notificationFrame.setVisible(false);
            notificationFrame.dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }
}