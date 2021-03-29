

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InsertPacient extends JPanel {
    private JLabel CNPLabel;
    private JLabel NumeLabel;
    private JLabel DatanLabel;
    private JLabel ProfesieLabel;
    private JLabel AdresaLabel;
    private JLabel TelefonLabel;
    private JLabel GrupsangvinLabel;
    private JLabel AsiguratLabel;
    private JLabel ProvenientaLabel;
    private JLabel CategorieLabel;
    private JLabel SexLabel;
    private JLabel Simptome;
    private JTextField id_utilizatoor_field;
    private JTextField CNPTextField;
    private JTextField NumeTextField;
    private JTextField DataTextField;
    private JTextField ProfesieTextField;
    private JTextField AdresaTextField;
    private JTextField TelefonTextField;
    private JComboBox GrupsangvinComboBox;
    private JCheckBox AsiguratCheckBox;
    private JComboBox ProvenientaComboBox;
    private JComboBox CategorieComboBox;
    private JComboBox SexComboBox;
    private JTextField SimptomeField;
    private JButton cancelButton;
    private JButton insertPacient;


    private GridBagConstraints constraints;

    public InsertPacient() {
        setLayout(new GridBagLayout());

        CNPLabel= new JLabel("CNP:");
        NumeLabel= new JLabel("Nume:");
        DatanLabel= new JLabel("Data nasterii:(YYYY-MM-DD)");
        ProfesieLabel= new JLabel("Profesie:");
        AdresaLabel= new JLabel("Adresa:");
        TelefonLabel= new JLabel("Telefon:");
        GrupsangvinLabel= new JLabel("Grup sangvin:");
        AsiguratLabel= new JLabel("Asigurat:");
        ProvenientaLabel= new JLabel("Provenienta:");
        CategorieLabel= new JLabel("Categorie:");
        SexLabel= new JLabel("Sex:");
        Simptome=new JLabel("Simptome:");
        CNPTextField = new JTextField();
        NumeTextField= new JTextField();
        DataTextField= new JTextField();
        ProfesieTextField= new JTextField();
        AdresaTextField= new JTextField();
        TelefonTextField= new JTextField();
        GrupsangvinComboBox = new JComboBox(new String[]{"0", "A2", "B3", "AB4"});
        AsiguratCheckBox= new JCheckBox("Da");
        ProvenientaComboBox=new JComboBox(new String[]{"rural", "urban"});
        CategorieComboBox=new JComboBox(new String[]{"Adult", "Copil"});
        SexComboBox=new JComboBox(new String[]{"M", "F"});
        SimptomeField=new JTextField();
        Color culoarebackground=new Color(0x20BCCB); 
        setBackground(culoarebackground);
        
        cancelButton=new JButton("Cancel");
        insertPacient=new JButton("Adauga pacient");
       
        Color culoarebuton=new Color(0x3A797F);
        
        cancelButton.setFont(new Font("Arial",Font.PLAIN,15));
        cancelButton.setBackground(culoarebuton);
        cancelButton.setForeground(Color.white);; 
        
        insertPacient.setFont(new Font("Arial",Font.PLAIN,15));
        insertPacient.setBackground(culoarebuton);
        insertPacient.setForeground(Color.white);
        
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
        add(DatanLabel, constraints);

        constraints.gridx++;
        add(DataTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(ProfesieLabel, constraints);

        constraints.gridx++;
        add(ProfesieTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(AdresaLabel, constraints);

        constraints.gridx++;
        add(AdresaTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(TelefonLabel, constraints);

        constraints.gridx++;
        add(TelefonTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(GrupsangvinLabel, constraints);

        constraints.gridx++;
        add(GrupsangvinComboBox, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(AsiguratLabel, constraints);

        constraints.gridx++;
        add(AsiguratCheckBox, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(ProvenientaLabel, constraints);

        constraints.gridx++;
        add(ProvenientaComboBox, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(CategorieLabel, constraints);

        constraints.gridx++;
        add(CategorieComboBox, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(SexLabel, constraints);

        constraints.gridx++;
        add(SexComboBox, constraints);
        
        constraints.gridy++;
        constraints.gridx--;
        add(Simptome, constraints);

        constraints.gridx++;
        
        add(SimptomeField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(cancelButton, constraints);

        constraints.gridx++;
        add(insertPacient, constraints);

    }

    public void addCancelButtonActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    public void addInsertPacientActionListener(ActionListener actionListener) {
        insertPacient.addActionListener(actionListener);
    }

    
    public JTextField get_id_Field() {
        return id_utilizatoor_field;
    }
    
    public JTextField getCNPTextField() {
        return CNPTextField;
    }

    public JTextField getNumeTextField() {
        return NumeTextField;
    }

    public JTextField getDataTextField() {
        return DataTextField;
    }

    public JTextField getProfesieTextField() {
        return ProfesieTextField;
    }

    public JTextField getAdresaTextField() {
        return AdresaTextField;
    }

    public JTextField getTelefonTextField() {
        return TelefonTextField;
    }

    public String getGrupsangvinComboBox() {
        return GrupsangvinComboBox.getSelectedItem().toString();
    }

    public boolean getAsiguratCheckBox() {
        return AsiguratCheckBox.isSelected();
    }

    public String getProvenientaComboBox() {
        return ProvenientaComboBox.getSelectedItem().toString();
    }

    public String getCategorieComboBox() {
        return CategorieComboBox.getSelectedItem().toString();
    }

    public String getSexComboBox() {
        return SexComboBox.getSelectedItem().toString();
    }
    
    public JTextField getSimptome()
    {
    	return SimptomeField;
    }

}