

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


	public class LogInPanel extends JPanel{
		private JLabel id;
		private JLabel label = new JLabel("New label");
		private JLabel label1 = new JLabel("New label");
		private JLabel label2 = new JLabel("New label");
		private JLabel label3 = new JLabel("");
		private JLabel password;
		private JTextField idTextField;
		private JTextField passwordTextField;
		private JButton logInButton;
		private JButton cancelButton;
		private JButton CreeazaCont;
    	private GridBagConstraints constraints;
    	private GridBagConstraints constraints1;
    	private GridBagConstraints constraints2;
    	private GridBagConstraints constraints3;

    public LogInPanel() {
        id = new JLabel("ID: ");
        password = new JLabel("Password: ");
        idTextField = new JTextField();
        passwordTextField = new JTextField();
        constraints = new GridBagConstraints();
        constraints1= new GridBagConstraints();
        logInButton = new JButton("Log In");
        constraints2= new GridBagConstraints();
        constraints3= new GridBagConstraints();
        cancelButton = new JButton("Cancel");
        CreeazaCont = new JButton("Creeaza Cont");
        Color culoarebuton=new Color(0x3A797F);
        Color culoarebackground=new Color(176, 224, 230); 
        setBackground(culoarebackground);
        
        
        //logInButton.setFont(new Font("Arial",Font.PLAIN,15));
        //logInButton.setBackground(culoarebuton);
        //logInButton.setForeground(Color.white);;
  
        password.setBounds(88, 111, 68, 33);
		//frame.getContentPane().add(password);
        
        
        passwordTextField.setBounds(166, 75, 190, 20);
		
		passwordTextField.setColumns(10);
        

        CreeazaCont.setForeground(new Color(255, 255, 255));
        CreeazaCont.setBackground(new Color(95, 158, 160));
        
        logInButton.setForeground(new Color(255, 255, 255));
        logInButton.setBackground(new Color(95, 158, 160));
        
        
        cancelButton.setForeground(new Color(255, 255, 255));
        cancelButton.setBackground(new Color(95, 158, 160));
        
        label=new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/man1.png")).getImage();
		
		label1=new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/key1.png")).getImage();
		
		
        //cancelButton.setFont(new Font("Arial",Font.PLAIN,15));
        //cancelButton.setBackground(culoarebuton);
        //cancelButton.setForeground(Color.white);;
  
        
        setLayout(new GridBagLayout());

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 0,0,10);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints2.insets = new Insets(20, 100,20,0);
        constraints1.insets = new Insets(0,0,0,0);
        constraints3.insets = new Insets(20,0,20,20);
        
        label.setIcon(new ImageIcon(img));
		label.setBounds(54, 45, 24, 72);
		add(label, constraints);
		constraints.gridx++;
        
        add(id, constraints);

        // constraints for the id text field
        constraints.gridx++;
        constraints.ipadx = 100;
        add(idTextField, constraints);

        // constraints for the password label
        constraints.gridx--;
        constraints.gridy++;
        constraints.ipadx = 0;
        label1.setIcon(new ImageIcon(img1));
		label1.setBounds(54, 92, 24, 72);
		constraints.gridx=0;
		add(label1, constraints);
		constraints.gridx++;
        add(password, constraints);

        // constraints for the password text field
        constraints.gridx++;
        constraints.ipadx = 130;
        add(passwordTextField, constraints);
        
        
        constraints.gridx=1;
        constraints.gridy=3;
        add(label3, constraints);
        
        constraints.gridy=3;
        constraints.gridx=2;
     
        
        
        label2=new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/lock.png")).getImage();
		label2.setIcon(new ImageIcon(img2));
		label2.setBounds(153, 140, 105, 96);
		add(label2, constraints);
		
        // constraints for the log in button
          constraints2.gridx=1;
          constraints2.gridy=5;
        add(logInButton, constraints2);
       

        // constraints for the new account button
        constraints1.gridx=2;
        constraints1.gridy=5;
        add(cancelButton, constraints1);
        
       // constraints3.gridx=3;
       // constraints3.gridy=6;
       // add(CreeazaCont, constraints3);
        
        
        
    }

    
    
    public void addLogInButtonActionListener(ActionListener actionListener) {
        logInButton.addActionListener(actionListener);
    }

    public void addCancelButtonActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }
    public void addCreeazaContActionListener(ActionListener actionListener) {
        CreeazaCont.addActionListener(actionListener);
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }
    
}

