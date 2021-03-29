
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsAdapter;

public class PacientMainPanel extends JPanel {

	
	private JLabel label = new JLabel("New label");
   
	private JButton adaugaProgramare;
   // private JButton vizualizareRaspuns;
   // private JButton adaugaSimptome;

    private JButton logOut;

    GridBagConstraints constraints;

    public PacientMainPanel() {
    	adaugaProgramare = new JButton("Adauga programare");
      //  vizualizareRaspuns = new JButton("Vizualizeaza raspunsul medicului");
       //adaugaSimptome = new JButton("Adauga simptome");
        logOut = new JButton("Log out");

        Color culoarebackground=new Color(0x20BCCB); 
        setBackground(culoarebackground);
        Color culoarebuton=new Color(0x3A797F);
        
        adaugaProgramare.setFont(new Font("Arial",Font.PLAIN,18));
        adaugaProgramare.setBackground(culoarebuton);
        adaugaProgramare.setForeground(Color.white);; 
        
        
      //  vizualizareRaspuns.setFont(new Font("Arial",Font.PLAIN,18));
       // vizualizareRaspuns.setBackground(culoarebuton);
      //  vizualizareRaspuns.setForeground(Color.white);
        
        logOut.setFont(new Font("Arial",Font.PLAIN,18));
        logOut.setBackground(culoarebuton);
        logOut.setForeground(Color.white);
        
       // adaugaSimptome.setFont(new Font("Arial",Font.PLAIN,18));
       // adaugaSimptome.setBackground(culoarebuton);
       // adaugaSimptome.setForeground(Color.white);
        
        label=new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("pacient_3.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(54, 238, 185, 134);
		
        
        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.ipadx = 100;

        
        constraints.gridx=1;
        add(adaugaProgramare, constraints);
        
        
        
       // constraints.gridy++;
        

      //  add(vizualizareRaspuns, constraints);
        //constraints.gridy++;
        
        
       
        
        //add(adaugaSimptome, constraints);
        constraints.gridy++;
        
       add(logOut, constraints);
    
       constraints.gridy=10;
       constraints.gridx=10;
       label=new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/imagine.png")).getImage();
		label.setIcon(new ImageIcon(img1));
		label.setBounds(160, 114, 141, 224);
		add(label,constraints);
    }

    public void addAdaugareProgramareListener(ActionListener actionListener) {
    	adaugaProgramare.addActionListener(actionListener);
    }

    //public void addShowRapunsListener(ActionListener actionListener) {
   //	vizualizareRaspuns.addActionListener(actionListener);
   // }

    public void addLogOutListener(ActionListener actionListener) 
    { 
    	logOut.addActionListener(actionListener); 
    }
    
    //public void addAdaugaSimptomeListener(ActionListener actionListener) 
    //{ 
    //	adaugaSimptome.addActionListener(actionListener); 
   // }
}
