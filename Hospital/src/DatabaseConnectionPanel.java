import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.*;
public class DatabaseConnectionPanel extends JPanel {
    private JButton connectAsAsistenta;
    private JButton connectAsMedic;
    private JButton connectAsLaborant;
   
    private JButton connectAsAdmin;
    
    private GridBagConstraints constraints;
    private JLabel welcomeLabel;

    public DatabaseConnectionPanel() {
        //setLayout(new GridBagLayout());
        
        //Color culoarebackground=new Color(0x20FFEBCD); 
    	//setVisible(true);
        JLabel background=new JLabel(new ImageIcon("C:\\Users\\Alexandru\\Desktop\\spital.jpg"));
       
        Color culoarebuton=new Color(0xFFFFFF);
       // setBackground(culoarebackground);
        //add(background);
        background.setLayout(new GridBagLayout());
        add(background);
        
        ImageIcon administratrorImage = new ImageIcon("C:\\Users\\Alexandru\\Desktop\\administrator_10.png");
        ImageIcon biologImage = new ImageIcon("C:\\Users\\Alexandru\\Desktop\\biolog_15.jpg");
        ImageIcon doctorImage = new ImageIcon("C:\\Users\\Alexandru\\Desktop\\doctor_11.jpg");
        ImageIcon asistentaImage = new ImageIcon("C:\\Users\\Alexandru\\Desktop\\asistenta_20.jpg");
        welcomeLabel = new JLabel("Bine ati venit!");
       // welcomeLabel.setAlignmentX(CENTER_ALIGNMENT);
        connectAsAsistenta = new JButton("Log in Asistenta",asistentaImage);
        connectAsMedic = new JButton("Log in Medic", doctorImage);
        connectAsLaborant = new JButton("Log in Biolog", biologImage);
      
       
        connectAsAdmin = new JButton("Log in Administrator", administratrorImage);

        connectAsAsistenta.setFont(new Font("Times New Roman",Font.PLAIN,15));
        connectAsAsistenta.setBackground(culoarebuton);
        connectAsAsistenta.setForeground(Color.black);

        connectAsMedic.setFont(new Font("Times New Roman",Font.PLAIN,15));
        connectAsMedic.setBackground(culoarebuton);
        connectAsMedic.setForeground(Color.black);

        connectAsLaborant.setFont(new Font("Times New Roman",Font.PLAIN,15));
        connectAsLaborant.setBackground(culoarebuton);
        connectAsLaborant.setForeground(Color.black);
        

        connectAsAdmin.setFont(new Font("Times New Roman",Font.PLAIN,15));
        connectAsAdmin.setBackground(culoarebuton);
        connectAsAdmin.setForeground(Color.black);
        
      
        welcomeLabel.setFont(new Font("Timesc New Roman",Font.CENTER_BASELINE,20));
        welcomeLabel.setForeground(Color.WHITE);

        
        constraints = new GridBagConstraints();
   

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        //constraints.insets = new Insets(20, 110, 20, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        //aici setezi dimensiunea butoanelor
        connectAsAsistenta.setPreferredSize(new Dimension(70, 50));
        connectAsMedic.setPreferredSize(new Dimension(80, 50));
        connectAsLaborant.setPreferredSize(new Dimension(50,50));
        
        connectAsAdmin.setPreferredSize(new Dimension(80,50));

        constraints.gridwidth = 1;
        welcomeLabel.setSize(new Dimension(50,50));
     
        
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridwidth = 1;
        constraints.gridy++;
        
        constraints.gridx=3;
        background. add(welcomeLabel, constraints);
       
        
        
        constraints.gridx=1;
        constraints.gridy++;
        
        background.add(connectAsAsistenta, constraints);
        constraints.gridx++;
        constraints.gridy++;
        
        
        background.add(connectAsMedic, constraints);
        constraints.gridx=constraints.gridx + 1;
        constraints.gridy=constraints.gridy + 1;
       
        
        background.add(connectAsLaborant, constraints);
        constraints.gridx=constraints.gridx + 1;
        constraints.gridy=constraints.gridy + 1;
      
        

        
        
        background.add(connectAsAdmin, constraints);
        constraints.gridx=constraints.gridx + 1;
      
     
        
    }

    public void addConnectAsAsistentaButtonActionListener(ActionListener actionListener) {
        connectAsAsistenta.addActionListener(actionListener);
    }

    public void addConnectAsMedicButtonActionListener(ActionListener actionListener) {
        connectAsMedic.addActionListener(actionListener);
    }

    public void addConnectAsLaborantButtonActionListener(ActionListener actionListener) {
        connectAsLaborant.addActionListener(actionListener);
    }
    

    
    
    public void addConnectAsAdminButtonActionListener(ActionListener actionListener) {
        connectAsAdmin.addActionListener(actionListener);
    }
}