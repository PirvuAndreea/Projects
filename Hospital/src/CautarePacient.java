

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CautarePacient extends JPanel {
    private JLabel CNPLabel;
    private JTextField CNPTextField;
    private JButton cancelButton;
    private JButton cautarePacient;

    private GridBagConstraints constraints;

    public CautarePacient() {
        setLayout(new GridBagLayout());
        CNPLabel= new JLabel("CNP:");
        CNPTextField = new JTextField();

        cancelButton=new JButton("Cancel");
        cautarePacient=new JButton("Cauta");

        Color culoarebuton=new Color(0x3A797F);
        
        cancelButton.setFont(new Font("Arial",Font.PLAIN,15));
        cancelButton.setBackground(culoarebuton);
        cancelButton.setForeground(Color.white);; 
        
        cautarePacient.setFont(new Font("Arial",Font.PLAIN,15));
        cautarePacient.setBackground(culoarebuton);
        cautarePacient.setForeground(Color.white);

        Color culoarebackground=new Color(0x20BCCB); 
        setBackground(culoarebackground);
        
        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.ipadx = 100;

        add(CNPLabel, constraints);

        constraints.gridx++;
        add(CNPTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(cancelButton, constraints);

        constraints.gridx++;
        add(cautarePacient, constraints);
    }

    public void addCancelButtonActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);

    }

    public void addCautarePacientActionListener(ActionListener actionListener) {
        cautarePacient.addActionListener(actionListener);

    }

    public JTextField getCNPTextField() {
        return CNPTextField;
    }
}
