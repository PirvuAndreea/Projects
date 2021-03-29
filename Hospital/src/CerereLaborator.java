

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CerereLaborator extends JPanel {
    private JLabel nrFisaL;
    private JLabel prioritateL;
    private JLabel tipL;
    private JTextField nrFisaTF;
    private JComboBox prioritateCB;
    private JTextField tipTF;
    private JButton cancelButton;
    private JButton cerereLaborator;

    GridBagConstraints constraints;

    public CerereLaborator() {
        setLayout(new GridBagLayout());

        nrFisaL = new JLabel("Numar fisa pacient:");
        prioritateL = new JLabel("Prioritate:");
        tipL = new JLabel("Tip:");
        nrFisaTF = new JTextField();
        prioritateCB = new JComboBox(new String[]{"urgenta", "normala"});
        tipTF = new JTextField();

        cancelButton = new JButton("Cancel");
        cerereLaborator = new JButton("Cerere laborator");
        Color culoarebuton=new Color(0x3A797F);
        
        cancelButton.setFont(new Font("Arial",Font.PLAIN,15));
        cancelButton.setBackground(culoarebuton);
        cancelButton.setForeground(Color.white);; 
        
        cerereLaborator.setFont(new Font("Arial",Font.PLAIN,15));
        cerereLaborator.setBackground(culoarebuton);
        cerereLaborator.setForeground(Color.white);

        constraints = new GridBagConstraints();

        Color culoarebackground=new Color(0x20BCCB); 
        setBackground(culoarebackground);
        
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.ipadx = 100;

        add(nrFisaL, constraints);

        constraints.gridx++;
        add(nrFisaTF, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(prioritateL, constraints);

        constraints.gridx++;
        add(prioritateCB, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(tipL, constraints);

        constraints.gridx++;
        add(tipTF, constraints);

        constraints.gridx--;
        constraints.gridy++;
        add(cancelButton, constraints);

        constraints.gridx++;
        add(cerereLaborator, constraints);
    }

    public void addCancelButtonActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    public void addCerereLaboratorActionListener(ActionListener actionListener) {
        cerereLaborator.addActionListener(actionListener);
    }

    public int getNrFisaTF() {
        return Integer.parseInt(nrFisaTF.getText().trim());
    }

    public String getPrioritateCB() {
        return prioritateCB.getSelectedItem().toString();
    }

    public JTextField getTipTF() {
        return tipTF;
    }
}

