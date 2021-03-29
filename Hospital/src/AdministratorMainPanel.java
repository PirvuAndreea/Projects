
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsAdapter;

public class AdministratorMainPanel extends JPanel {

    private JButton modificaMedicamente;
    private JButton modificaPaturi;
    private JButton showProduse;
    private JButton showSectii;
    private JButton actualizare_nr_pacienti;
    private JButton logOut;
    
    
    
    
    GridBagConstraints constraints;

    public AdministratorMainPanel() {
        
    	setLayout(new GridBagLayout());
    	
    	actualizare_nr_pacienti = new JButton("Actualizati nr de pacienti din sectie");
    	modificaMedicamente = new JButton("Actualizare pret medicamente");
        modificaPaturi = new JButton("Actualizare numar paturi");
        showSectii = new JButton("Vizualizeaza sectiile");
        showProduse = new JButton("Vizualizeaza produsele");
        logOut = new JButton("Log out");

     
        Color culoarebuton=new Color(0x3A797F);
        Color culoarebackground=new Color(176, 224, 230); 
        setBackground(culoarebackground);
        
        
        actualizare_nr_pacienti.setFont(new Font("Arial",Font.PLAIN,18));
        actualizare_nr_pacienti.setBackground(culoarebuton);
        actualizare_nr_pacienti.setForeground(Color.white);
        
        
        
        modificaMedicamente.setFont(new Font("Arial",Font.PLAIN,18));
        modificaMedicamente.setBackground(culoarebuton);
        modificaMedicamente.setForeground(Color.white);;
         
        
        modificaPaturi.setFont(new Font("Arial",Font.PLAIN,18));
        modificaPaturi.setBackground(culoarebuton);
        modificaPaturi.setForeground(Color.white);
        
        
        showSectii.setFont(new Font("Arial",Font.PLAIN,18));
        showSectii.setBackground(culoarebuton);
        showSectii.setForeground(Color.white);
        
        showProduse.setFont(new Font("Arial",Font.PLAIN,18));
        showProduse.setBackground(culoarebuton);
        showProduse.setForeground(Color.white);
        
        logOut.setFont(new Font("Arial",Font.PLAIN,18));
        logOut.setBackground(culoarebuton);
        logOut.setForeground(Color.white);
        
        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.CENTER;
        constraints.gridx =0;
        constraints.gridy =0;
        constraints.insets = new Insets(8,8,8,8);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx =0.5;
        constraints.weighty = 0.5;
        
        
        constraints.gridx++;

        add(showSectii, constraints);
        constraints.gridy++;
        add(actualizare_nr_pacienti,constraints);
        constraints.gridy++;
        add(modificaPaturi, constraints);
        constraints.gridy++;
        add(modificaMedicamente, constraints);
        constraints.gridy++;
        add(showProduse, constraints);
        constraints.gridy++;
        add(logOut,constraints);
     
    }


    
    
    public void addModificaMedicamenteListener(ActionListener actionListener) {
        modificaMedicamente.addActionListener(actionListener);
    }

    public void addModificaPaturiListener(ActionListener actionListener) {
        modificaPaturi.addActionListener(actionListener);
    }
    
    public void addActualizareNrPacientiListener(ActionListener actionListener) {
        actualizare_nr_pacienti.addActionListener(actionListener);
    }


    public void addShowProduse(ActionListener actionListener) {
        showProduse.addActionListener(actionListener);
    }

    public void addShowSecii(ActionListener actionListener) {
        showSectii.addActionListener(actionListener);
    }

    public void addLogOut(ActionListener actionListener) { logOut.addActionListener(actionListener); }
}
