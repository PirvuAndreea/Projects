

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ModificareMedicamente extends JPanel {
    private JLabel idProdusL;
    private JLabel pretL;
    private JTextField idMedicamentTF;
    private JTextField pretTF;
    private JButton cancelButton;
    private JButton modificaMedicamente;

    private GridBagConstraints constraints;

    public ModificareMedicamente() {
        setLayout(new GridBagLayout());

        idProdusL = new JLabel("ID produs:");
        pretL = new JLabel("Pret:");
        idMedicamentTF = new JTextField();
        pretTF = new JTextField();

        cancelButton = new JButton("Cancel");
        modificaMedicamente = new JButton("Modifica");
        Color culoarebuton=new Color(0x3A797F);
        Color culoarebackground=new Color(0x20BCCB);
        setBackground(culoarebackground);
        cancelButton.setFont(new Font("Arial",Font.PLAIN,15));
        cancelButton.setBackground(culoarebuton);
        cancelButton.setForeground(Color.white);; 
        
        modificaMedicamente.setFont(new Font("Arial",Font.PLAIN,15));
        modificaMedicamente.setBackground(culoarebuton);
        modificaMedicamente.setForeground(Color.white);

        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.ipadx = 100;

        add(idProdusL, constraints);

        constraints.gridx++;
        add(idMedicamentTF, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(pretL, constraints);

        constraints.gridx++;
        add(pretTF, constraints);

        constraints.gridy++;
        constraints.gridx--;

        add(cancelButton, constraints);

        constraints.gridx++;
        add(modificaMedicamente, constraints);
    }

    public void addCancelButtonActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    public void addModificaMedicamenteActionListener(ActionListener actionListener) {
        modificaMedicamente.addActionListener(actionListener);
    }

    public int getIdMedicamentTF() {
        return Integer.parseInt(idMedicamentTF.getText().trim());
    }

    public int getPretTF() {
        return Integer.parseInt(pretTF.getText().trim());
    }
}
