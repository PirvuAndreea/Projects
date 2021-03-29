

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ModificaPacient extends JPanel {
    private JLabel nrFisaL;
    private JLabel temperaturaLabel;
    private JLabel tensiuneLabel;
    private JLabel pulsLabel;
    private JLabel evolutieLabel;
    private JTextField nrFisaTF;
    private JTextField temperaturaTextField;
    private JTextField tensiuneTextField;
    private JTextField pulsTextField;
    private JComboBox evolutieComboBox;
    private JButton cancelButton;
    private JButton modificaPacient;

    private GridBagConstraints constraints;

    public ModificaPacient() {
        setLayout(new GridBagLayout());

        nrFisaL = new JLabel("Numar fisa pacient:");
        temperaturaLabel = new JLabel("Temperatura:");
        tensiuneLabel = new JLabel("Tensiune:");
        pulsLabel = new JLabel("Puls:");
        evolutieLabel= new JLabel("Evolutie:");
        nrFisaTF = new JTextField();
        temperaturaTextField = new JTextField();
        tensiuneTextField = new JTextField();
        pulsTextField = new JTextField();
        evolutieComboBox = new JComboBox(new String[]{"Vindecat", "Ameliorat", "Stationara"});
        cancelButton = new JButton("Cancel");
        modificaPacient = new JButton("Modifica");
        Color culoarebuton=new Color(0x3A797F);
        
        cancelButton.setFont(new Font("Arial",Font.PLAIN,15));
        cancelButton.setBackground(culoarebuton);
        cancelButton.setForeground(Color.white);; 
        
        modificaPacient.setFont(new Font("Arial",Font.PLAIN,15));
        modificaPacient.setBackground(culoarebuton);
        modificaPacient.setForeground(Color.white);; 

        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.ipadx = 100;

        Color culoarebackground=new Color(0x20BCCB); 
        setBackground(culoarebackground);
        
        add(nrFisaL, constraints);

        constraints.gridx++;
        add(nrFisaTF, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(temperaturaLabel, constraints);

        constraints.gridx++;
        add(temperaturaTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(tensiuneLabel, constraints);

        constraints.gridx++;
        add(tensiuneTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(pulsLabel, constraints);

        constraints.gridx++;
        add(pulsTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(evolutieLabel, constraints);

        constraints.gridx++;
        add(evolutieComboBox, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(cancelButton, constraints);

        constraints.gridx++;
        add(modificaPacient, constraints);
    }

    public void addCancelButtonActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    public void addModificaPacientActionListener(ActionListener actionListener) {
        modificaPacient.addActionListener(actionListener);
    }

    public JTextField getNrFisaTF() {
        return nrFisaTF;
    }

    public float getTemperaturaTextField() {
        return Float.parseFloat(temperaturaTextField.getText().trim());
    }

    public JTextField getTensiuneTextField() {
        return tensiuneTextField;
    }

    public int getPulsTextField() {
        return Integer.parseInt(pulsTextField.getText().trim());
    }

    public String getEvolutieComboBox() {
        return evolutieComboBox.getSelectedItem().toString();
    }
}

