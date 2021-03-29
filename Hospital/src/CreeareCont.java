

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CreeareCont extends JPanel {
    private JLabel CNPLabel;
    private JLabel NumeLabel;
    private JLabel emailLabel;
    private JLabel usernameLabel;
    private JLabel parolaLabel;
    
    private JTextField CNPTextField;
    private JTextField NumeTextField;
    private JTextField emailTextField;
    private JTextField usernameTextField;
    private JTextField parolaTextField;
    private JButton creeazaCont;


    private GridBagConstraints constraints;

    public  CreeareCont() {
        setLayout(new GridBagLayout());

        CNPLabel= new JLabel("CNP:");
        NumeLabel= new JLabel("Nume:");
        emailLabel = new JLabel("E-mail:");
        usernameLabel = new JLabel("Username:");
        parolaLabel = new JLabel("Parola:");
        CNPTextField = new JTextField();
        NumeTextField= new JTextField();
       emailTextField = new JTextField();
       usernameTextField= new JTextField();
       parolaTextField = new JTextField();
        Color culoarebackground=new Color(0x20BCCB); 
        setBackground(culoarebackground);
        
       
        creeazaCont=new JButton("Creeaza cont");
       
        Color culoarebuton=new Color(0x3A797F);
        
        
        
        creeazaCont.setFont(new Font("Arial",Font.PLAIN,15));
        creeazaCont.setBackground(culoarebuton);
        creeazaCont.setForeground(Color.white);
        
        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.ipadx = 100;

        

        constraints.gridx++;
   
        add(CNPLabel, constraints);

        constraints.gridx++;
        add(CNPTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        
        

        
        add(NumeLabel, constraints);

        constraints.gridx++;
        add(NumeTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(emailLabel, constraints);

        constraints.gridx++;
        add(emailTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(usernameLabel, constraints);

        constraints.gridx++;
        add(usernameTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(parolaLabel, constraints);

        constraints.gridx++;
        add(parolaTextField, constraints);

       

        constraints.gridx++;
        add(creeazaCont, constraints);

    }

  

    public void addCreeazaContActionListener(ActionListener actionListener) {
    	creeazaCont.addActionListener(actionListener);
    }

    
   
    
    public JTextField getCNPTextField() {
        return CNPTextField;
    }

    public JTextField getNumeTextField() {
        return NumeTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JTextField getUserNameTextField() {
        return usernameTextField;
    }

    public JTextField getParolaTextField() {
        return parolaTextField;
    }

    

}