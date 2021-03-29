


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ActualizarePacienti extends JPanel {
    private JLabel id_sectie_L;
    private JLabel nr_pacienti_L;
    private JTextField id_sectie_TF;
    private JTextField nr_pacienti_TF;
    private JButton cancelButton;
    private JButton modifica_nr_pacienti;

    private GridBagConstraints constraints;

    public ActualizarePacienti() {
        setLayout(new GridBagLayout());

        id_sectie_L = new JLabel("ID Sectie:");
        nr_pacienti_L = new JLabel("Numar pacienti");
        id_sectie_TF = new JTextField();
        nr_pacienti_TF = new JTextField();

        cancelButton = new JButton("Cancel");
        modifica_nr_pacienti = new JButton("Modifica");
       
        Color culoarebuton=new Color(0x3A797F);
        
        cancelButton.setFont(new Font("Arial",Font.PLAIN,15));
        cancelButton.setBackground(culoarebuton);
        cancelButton.setForeground(Color.white);; 
        
        modifica_nr_pacienti.setFont(new Font("Arial",Font.PLAIN,15));
        modifica_nr_pacienti.setBackground(culoarebuton);
        modifica_nr_pacienti.setForeground(Color.white);

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
        
        add(id_sectie_L, constraints);

        constraints.gridx++;
        add(id_sectie_TF, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(nr_pacienti_L, constraints);

        constraints.gridx++;
        add(nr_pacienti_TF, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(cancelButton, constraints);

        constraints.gridx++;
        add(modifica_nr_pacienti, constraints);
    }

    public void addCancelButtonActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    public void addActualizarePacientiActionListener(ActionListener actionListener) {
        modifica_nr_pacienti.addActionListener(actionListener);
    }

    public int getIdSectieTF() {
        return Integer.parseInt(id_sectie_TF.getText().trim());
    }

    public int getNrPacientiTF() {
        return Integer.parseInt(nr_pacienti_TF.getText().trim());
    }
}
