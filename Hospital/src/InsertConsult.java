

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InsertConsult extends JPanel {
    private JLabel idSectieLabel;
    private JLabel MedicLabel;
    private JLabel tipTrimitereLabel;
    private JLabel tipConsultLabel;
    private JLabel DiagnosticLabel;
    private JLabel DecizieLabel;
    private JLabel CostLabel;
    private JLabel NumeLabel;
    private JTextField idSectieTextField;
    private JTextField MedicTextField;
    private JComboBox tipTrimitereComboBox;
    private JTextField tipConsultTextField;
    private JTextField DiagnosticTextField;
    private JComboBox DecizieComboBox;
    private JTextField CostTextField;
    private JTextField NumeTextField;
    private JButton cancelButton;
    private JButton insertConsult;

    private GridBagConstraints constraints;

    public InsertConsult() {
        setLayout(new GridBagLayout());

        idSectieLabel = new JLabel("ID Sectie:");
        MedicLabel = new JLabel("Medic:");
        tipTrimitereLabel = new JLabel("Tip trimitere:");
        tipConsultLabel = new JLabel("Tip consult:");
        DiagnosticLabel = new JLabel("Diagnostic");
        DecizieLabel = new JLabel("Decizie:");
        CostLabel=new JLabel("Cost:");
        NumeLabel=new JLabel("Nume pacient:");
        idSectieTextField = new JTextField();
        MedicTextField = new JTextField();
        tipTrimitereComboBox = new JComboBox(new String[]{"internare", "trimitere", "nu are"});
        tipConsultTextField = new JTextField();
        DiagnosticTextField = new JTextField();
        DecizieComboBox = new JComboBox(new String[]{"Se interneaza", "Pleaca acasa"});
        CostTextField =new JTextField();
        NumeTextField=new JTextField();
        Color culoarebackground=new Color(0x20BCCB); 
        setBackground(culoarebackground);
        
        cancelButton = new JButton("Cancel");
        insertConsult = new JButton("Adauga consult");
        Color culoarebuton=new Color(0x3A797F);
        
        cancelButton.setFont(new Font("Arial",Font.PLAIN,15));
        cancelButton.setBackground(culoarebuton);
        cancelButton.setForeground(Color.white);; 
        
        insertConsult.setFont(new Font("Arial",Font.PLAIN,15));
        insertConsult.setBackground(culoarebuton);
        insertConsult.setForeground(Color.white);

        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.ipadx = 100;

        add(idSectieLabel, constraints);

        constraints.gridx++;
        add(idSectieTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(MedicLabel, constraints);

        constraints.gridx++;
        add(MedicTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(tipTrimitereLabel, constraints);

        constraints.gridx++;
        add(tipTrimitereComboBox, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(tipConsultLabel, constraints);

        constraints.gridx++;
        add(tipConsultTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(DiagnosticLabel, constraints);

        constraints.gridx++;
        add(DiagnosticTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(DecizieLabel, constraints);

        constraints.gridx++;
        add(DecizieComboBox, constraints);
        
        //aici
        constraints.gridy++;
        constraints.gridx--;
        add(NumeLabel, constraints);
        constraints.gridx++;
        add(NumeTextField, constraints);
        
        constraints.gridy++;
        constraints.gridx--;
        add(CostLabel, constraints);

        constraints.gridx++;
       
        add(CostTextField, constraints);

        constraints.gridy++;
        constraints.gridx--;
        add(cancelButton, constraints);

        constraints.gridx++;
        add(insertConsult, constraints);
        
    
        
        
       
        
     
        

        

        
       
        
    }

    public void addCancelButtonActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    public void addInsertConsultActionListener(ActionListener actionListener) {
        insertConsult.addActionListener(actionListener);
    }

    public JTextField getIdSectieTextField() {
        return idSectieTextField;
    }

    public JTextField getCostTextField() {
        return CostTextField;
    }
    
    public JTextField getNumeTextField() {
        return NumeTextField;
    }
    
    public JTextField getMedicTextField() {
        return MedicTextField;
    }

    public String getTipTrimitereComboBox() {
        return tipTrimitereComboBox.getSelectedItem().toString();
    }

    public JTextField getTipConsultTextField() {
        return tipConsultTextField;
    }

    public JTextField getDiagnosticTextField() {
        return DiagnosticTextField;
    }

    public String getDecizieComboBox() {
        return DecizieComboBox.getSelectedItem().toString();
    }
    
    
    
    
}
