
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Istoric extends JPanel {
    private JLabel CNPL;
    private JTextField CNPTF;
    private JButton cancelButton;
    private JButton insertIstoric;

    private GridBagConstraints constraints;

    public Istoric() {
        setLayout(new GridBagLayout());

        CNPL = new JLabel("CNP:");
        CNPTF = new JTextField();

        cancelButton = new JButton("Cancel");
        insertIstoric = new JButton("Adauga istoricul");

        Color culoarebackground=new Color(0x20BCCB); 
        setBackground(culoarebackground);
         Color culoarebuton=new Color(0x3A797F);
        
        cancelButton.setFont(new Font("Arial",Font.PLAIN,15));
        cancelButton.setBackground(culoarebuton);
        cancelButton.setForeground(Color.white);; 
        
        insertIstoric.setFont(new Font("Arial",Font.PLAIN,15));
        insertIstoric.setBackground(culoarebuton);
        insertIstoric.setForeground(Color.white);
        
        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.ipadx = 100;

        add(CNPL, constraints);

        constraints.gridx++;
        add(CNPTF, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(cancelButton, constraints);

        constraints.gridx++;
        add(insertIstoric, constraints);
    }

    public void addCancelButtonActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    public void addInsertIstoricActionListener(ActionListener actionListener) {
        insertIstoric.addActionListener(actionListener);
    }

    public JTextField getCNPTextField() {
        return CNPTF;
    }
}
