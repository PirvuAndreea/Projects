
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class AdaugaFisaPacient extends JPanel {
    private JLabel temperaturaLabel;
    private JLabel tensiuneLabel;
    private JLabel pulsLabel;
    private JLabel evolutieLabel;
    private JLabel motiv_internareLabel;
    private JTextField temperaturaTextField;
    private JTextField tensiuneTextField;
    private JTextField pulsTextField;
    private JTextField motiv_internareTextField;
    private JComboBox evolutieComboBox;
    private JButton cancelButton;
    private JButton adaugaFisa;

    private GridBagConstraints constraints;

    public AdaugaFisaPacient() {
        setLayout(new GridBagLayout());

        temperaturaLabel = new JLabel("Temperatura:");
        tensiuneLabel = new JLabel("Tensiune:");
        pulsLabel = new JLabel("Puls:");
        evolutieLabel= new JLabel("Evolutie:");
        motiv_internareLabel = new JLabel("Motivele internarii: ");
        motiv_internareTextField = new JTextField();
        temperaturaTextField = new JTextField();
        tensiuneTextField = new JTextField();
        pulsTextField = new JTextField();
        evolutieComboBox = new JComboBox(new String[]{"Vindecat", "Ameliorat", "Stationara"});
        cancelButton = new JButton("Cancel");
        adaugaFisa = new JButton("Adauga fisa");

        Color culoarebackground=new Color(0x20BCCB); 
        setBackground(culoarebackground);
        Color culoarebuton=new Color(0x3A797F);
        
        cancelButton.setFont(new Font("Arial",Font.PLAIN,15));
        cancelButton.setBackground(culoarebuton);
        cancelButton.setForeground(Color.white);; 
        
        adaugaFisa.setFont(new Font("Arial",Font.PLAIN,15));
        adaugaFisa.setBackground(culoarebuton);
        adaugaFisa.setForeground(Color.white);

        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.ipadx = 100;

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
        add(motiv_internareLabel, constraints);

        constraints.gridx++;
        add(motiv_internareTextField, constraints);
        
        constraints.gridy++;
        constraints.gridx--;
        add(cancelButton, constraints);

        constraints.gridx++;
        add(adaugaFisa, constraints);
    }

    public void addCancelButtonActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    public void addAdaugaFisaActionListener(ActionListener actionListener) {
        adaugaFisa.addActionListener(actionListener);
    }

    public float getTemperaturaTextField() {
        System.out.println(Float.parseFloat(temperaturaTextField.getText().trim()));
        return Float.parseFloat(temperaturaTextField.getText().trim());
    }

    public JTextField getTensiuneTextField() {
        return tensiuneTextField;
    }
    public JTextField getMotiveInternareTextField() {
        return motiv_internareTextField;
    }

    public int getPulsTextField() {
        return Integer.parseInt(pulsTextField.getText().trim());
    }

    public String getEvolutieComboBox() {
        return evolutieComboBox.getSelectedItem().toString();
    }
}
