

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FisaExternare extends JPanel {
    private JLabel nrFisaL;
    private JLabel epicrizaL;
    private JLabel recomandariL;
    private JTextField nrFisaTF;
    private JTextField epicrizaTF;
    private JTextField recomandariTF;
    private JButton cancelButton;
    private JButton insertExternare;

    private GridBagConstraints constraints;

    public FisaExternare() {
        setLayout(new GridBagLayout());

        nrFisaL = new JLabel("Numar fisa pacient:");
        epicrizaL = new JLabel("Epicriza:");
        recomandariL = new JLabel("Recomandari:");
        nrFisaTF = new JTextField();
        epicrizaTF = new JTextField();
        recomandariTF = new JTextField();

        cancelButton = new JButton("Cancel");
        insertExternare = new JButton("Adauga externare");
        Color culoarebuton=new Color(0x3A797F);
        
        cancelButton.setFont(new Font("Arial",Font.PLAIN,15));
        cancelButton.setBackground(culoarebuton);
        cancelButton.setForeground(Color.white);; 
        
        insertExternare.setFont(new Font("Arial",Font.PLAIN,15));
        insertExternare.setBackground(culoarebuton);
        insertExternare.setForeground(Color.white);
         
        
        
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

        add(nrFisaL, constraints);

        constraints.gridx++;
        add(nrFisaTF, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(epicrizaL, constraints);

        constraints.gridx++;
        add(epicrizaTF, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(recomandariL, constraints);

        constraints.gridx++;
        add(recomandariTF, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(cancelButton, constraints);

        constraints.gridx++;
        add(insertExternare, constraints);
    }

    public void addCancelButtonActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    public void addInsertExternareActionListener(ActionListener actionListener) {
        insertExternare.addActionListener(actionListener);
    }

    public JTextField getNrFisaTF() {
        return nrFisaTF;
    }

    public JTextField getEpicrizaTF() {
        return epicrizaTF;
    }

    public JTextField getRecomandariTF() {
        return recomandariTF;
    }
}
