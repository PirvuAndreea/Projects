

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdaugaInternare extends JPanel {
    private JLabel tipInternareLabel;
    private JLabel motivInternareLabel;
    private JComboBox tipInternareComboBox;
    private JTextField motivInternareTextField;
    private JButton cancelButton;
    private JButton adaugaInternare;

    private GridBagConstraints constraints;

    public AdaugaInternare() {
        setLayout(new GridBagLayout());

        tipInternareLabel = new JLabel("Tip internare:");
        tipInternareComboBox = new JComboBox(new String[]{"Urgenta", "Bilet de internare"});
        motivInternareLabel = new JLabel("Motiv internare:");
        motivInternareTextField = new JTextField();

        cancelButton = new JButton("Cancel");
        adaugaInternare = new JButton("Adauga internare");

        Color culoarebackground=new Color(0x20BCCB); 
        setBackground(culoarebackground);
        Color culoarebuton=new Color(0x3A797F);
        
        cancelButton.setFont(new Font("Arial",Font.PLAIN,15));
        cancelButton.setBackground(culoarebuton);
        cancelButton.setForeground(Color.white);; 
        
        adaugaInternare.setFont(new Font("Arial",Font.PLAIN,15));
        adaugaInternare.setBackground(culoarebuton);
        adaugaInternare.setForeground(Color.white);

        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.ipadx = 100;

        add(tipInternareLabel, constraints);

        constraints.gridx++;
        add(tipInternareComboBox, constraints);

        constraints.gridy++;
        constraints.gridx--;

        add(motivInternareLabel, constraints);

        constraints.gridx++;
        add(motivInternareTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;

        add(cancelButton, constraints);

        constraints.gridx++;
        add(adaugaInternare, constraints);
    }

    public void addCancelButtonActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    public void addAdaugaInternareActionListener(ActionListener actionListener) {
        adaugaInternare.addActionListener(actionListener);
    }

    public String getTipInternareComboBox() {
        return tipInternareComboBox.getSelectedItem().toString();
    }

    public JTextField getMotivInternareTextField() {
        return motivInternareTextField;
    }
}
