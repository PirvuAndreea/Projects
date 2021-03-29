

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ModificarePaturi extends JPanel {
    private JLabel idSectieL;
    private JLabel nrPaturiL;
    private JTextField idSectieTF;
    private JTextField nrPaturiTF;
    private JButton cancelButton;
    private JButton modificaPaturi;

    private GridBagConstraints constraints;

    public ModificarePaturi() {
        setLayout(new GridBagLayout());

        idSectieL = new JLabel("ID Sectie:");
        nrPaturiL = new JLabel("Numar paturi");
        idSectieTF = new JTextField();
        nrPaturiTF = new JTextField();

        cancelButton = new JButton("Cancel");
        modificaPaturi = new JButton("Modifica");
       
        Color culoarebuton=new Color(0x3A797F);
        
        cancelButton.setFont(new Font("Arial",Font.PLAIN,15));
        cancelButton.setBackground(culoarebuton);
        cancelButton.setForeground(Color.white);; 
        
        modificaPaturi.setFont(new Font("Arial",Font.PLAIN,15));
        modificaPaturi.setBackground(culoarebuton);
        modificaPaturi.setForeground(Color.white);

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
        
        add(idSectieL, constraints);

        constraints.gridx++;
        add(idSectieTF, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(nrPaturiL, constraints);

        constraints.gridx++;
        add(nrPaturiTF, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(cancelButton, constraints);

        constraints.gridx++;
        add(modificaPaturi, constraints);
    }

    public void addCancelButtonActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    public void addModificaPaturiActionListener(ActionListener actionListener) {
        modificaPaturi.addActionListener(actionListener);
    }

    public int getIdSectieTF() {
        return Integer.parseInt(idSectieTF.getText().trim());
    }

    public int getNrPaturiTF() {
        return Integer.parseInt(nrPaturiTF.getText().trim());
    }
}
