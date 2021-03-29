
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsAdapter;

public class MedicMainPanel extends JPanel {

    private JButton adaugare_tratament;
    private JButton modifica_stare_pacient;
    private JButton vizualizare_pacienti;
    private JButton vizualizare_consultari;
    private JButton vizualizare_fisa_pacient;
    private JButton vizualizare_analize;
    private JButton adauga_registru;

    private JButton logOut;
    
    
    
    
    GridBagConstraints constraints;

    public MedicMainPanel() {
        
    	setLayout(new GridBagLayout());
    	
    	adaugare_tratament = new JButton("Adaugare tratament");
    	modifica_stare_pacient= new JButton("Modifica stare pacient");
    	vizualizare_pacienti= new JButton("vizualizare pacienti");
    	vizualizare_consultari= new JButton("Vizualizare consultatii");
    	vizualizare_fisa_pacient = new JButton("Vizualizare fisa pacient");
    	vizualizare_analize= new JButton("Vizualizare analize");
        logOut = new JButton("Log out");
        adauga_registru=new JButton("Adaugare in registru");

     
        
        Color culoarebuton=new Color(0x3A797F);
        Color culoarebackground=new Color(176, 224, 230); 
        setBackground(culoarebackground);

        
        
        adaugare_tratament.setFont(new Font("Arial",Font.PLAIN,18));
        adaugare_tratament.setBackground(culoarebuton);
        adaugare_tratament.setForeground(Color.white);
        
        
        
        modifica_stare_pacient.setFont(new Font("Arial",Font.PLAIN,18));
        modifica_stare_pacient.setBackground(culoarebuton);
        modifica_stare_pacient.setForeground(Color.white);;
         
        vizualizare_consultari.setFont(new Font("Arial",Font.PLAIN,18));
        vizualizare_consultari.setBackground(culoarebuton);
        vizualizare_consultari.setForeground(Color.white);;
         
        vizualizare_pacienti .setFont(new Font("Arial",Font.PLAIN,18));
        vizualizare_pacienti .setBackground(culoarebuton);
        vizualizare_pacienti .setForeground(Color.white);
        
        
        vizualizare_fisa_pacient .setFont(new Font("Arial",Font.PLAIN,18));
        vizualizare_fisa_pacient .setBackground(culoarebuton);
        vizualizare_fisa_pacient.setForeground(Color.white);
        
        vizualizare_analize.setFont(new Font("Arial",Font.PLAIN,18));
        vizualizare_analize.setBackground(culoarebuton);
        vizualizare_analize.setForeground(Color.white);
        
        logOut.setFont(new Font("Arial",Font.PLAIN,18));
        logOut.setBackground(culoarebuton);
        logOut.setForeground(Color.white);
        
        adauga_registru .setFont(new Font("Arial",Font.PLAIN,18));
        adauga_registru  .setBackground(culoarebuton);
        adauga_registru  .setForeground(Color.white);
        

        
        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.CENTER;
        constraints.gridx =0;
        constraints.gridy =0;
        constraints.insets = new Insets(8,8,8,8);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx =0.5;
        constraints.weighty = 0.5;
        
        
        constraints.gridx++;

        add(adaugare_tratament, constraints);
        constraints.gridy++;
        add(modifica_stare_pacient,constraints);
        constraints.gridy++;
        add(vizualizare_pacienti, constraints);
        constraints.gridy++;
        add(vizualizare_consultari, constraints);
        constraints.gridy++;
        
        add(vizualizare_fisa_pacient, constraints);
        constraints.gridy++;
        
        add(vizualizare_analize, constraints);
        constraints.gridy++;
        add(adauga_registru, constraints);
        constraints.gridy++;

        add(logOut,constraints);
     
    }


    
    
    public void addAdaugaTratamentListener(ActionListener actionListener) {
        adaugare_tratament.addActionListener(actionListener);
    }

    public void addModificaStarePacientListener(ActionListener actionListener) {
        modifica_stare_pacient.addActionListener(actionListener);
    }
    
    public void addVizualizarePacientiListener(ActionListener actionListener) {
        vizualizare_pacienti.addActionListener(actionListener);
    }


    public void addVizualizareConsultariListener(ActionListener actionListener) {
        vizualizare_consultari.addActionListener(actionListener);
    }

    public void addVizualizareFisaPacientListener(ActionListener actionListener) {
        vizualizare_fisa_pacient.addActionListener(actionListener);
    }
    
    public void addVizualizareAnalizeListener(ActionListener actionListener) {
        vizualizare_analize.addActionListener(actionListener);
    }
    
    public void addAdaugareRegistruListener(ActionListener actionListener) {
        adauga_registru.addActionListener(actionListener);
    }
    

    
    
    public void addLogOut(ActionListener actionListener) { logOut.addActionListener(actionListener); }
}

