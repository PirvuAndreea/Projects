

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CerereMedicament extends JPanel {
    private JLabel idTratamentLabel;
    private JLabel cantitateLabel;
    private JTextField idTratamentTF;
    private JTextField cantitateTF;
    private JButton cancelButton;
    private JButton cerereMedicament;

    GridBagConstraints constraints;

    public CerereMedicament() {
        setLayout(new GridBagLayout());

        idTratamentLabel = new JLabel("ID tratament:");
        cantitateLabel = new JLabel("Cantitate:");
        idTratamentTF = new JTextField();
        cantitateTF = new JTextField();

        cancelButton = new JButton("Cancel");
        cerereMedicament = new JButton("Cerere medicamente");

        constraints = new GridBagConstraints();

        Color culoarebackground=new Color(0x20BCCB); 
        setBackground(culoarebackground);
        
        Color culoarebuton=new Color(0x3A797F);
        
        cancelButton.setFont(new Font("Arial",Font.PLAIN,15));
        cancelButton.setBackground(culoarebuton);
        cancelButton.setForeground(Color.white);; 
        
        cerereMedicament.setFont(new Font("Arial",Font.PLAIN,15));
        cerereMedicament.setBackground(culoarebuton);
        cerereMedicament.setForeground(Color.white);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.ipadx = 100;

        add(idTratamentLabel, constraints);

        constraints.gridx++;
        add(idTratamentTF, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(cantitateLabel, constraints);

        constraints.gridx++;
        add(cantitateTF, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(cancelButton, constraints);

        constraints.gridx++;
        add(cerereMedicament, constraints);
    }

    public void addCancelButtonActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    public void addCerereMedicamentActionListener(ActionListener actionListener) {
        cerereMedicament.addActionListener(actionListener);
    }

    public int getIdTratamentTF() {
        return Integer.parseInt(idTratamentTF.getText().trim());
    }

    public int getCantitateTF() {
        return Integer.parseInt(cantitateTF.getText().trim());
    }
}
