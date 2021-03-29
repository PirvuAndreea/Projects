

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;



public class AsistentaMainPanel extends JPanel {

	 private JButton insertPacient;
	    private JButton insertConsult;
	//    private JButton adaugaRegistru;
	    private JButton adaugaIntertnare;
	    private JButton adaugaFisaPacient;
	  //  private JButton insertTratament;
	    private JButton cerereLaborator;
	    private JButton cerereMedicamente;
	    private JButton fisaExternare;
	   // private JButton modificaPacient;
	   // private JButton istoric;
	    private JButton cautarePacient;
	    private JButton showPacienti;
	    private JButton showRegistru;
	    private JButton showConsult;
	    private JButton showInternare;
	    private JButton showFisaPacient;
	    private JButton showSectii;
	    //private JButton showAnalize;
	    private JButton showTratament;
	   // private JButton showProduse;
	    private JButton showExternari;
	    private JButton showIstoric;
	    private JButton logOut;
	    private GridBagConstraints constraints;
	    private JButton vizualizeazaProgramari;
	    
	    public AsistentaMainPanel() {
	    	 setLayout(new GridBagLayout());

	         Color culoarebackground=new Color(0x20BCCB);
	         setBackground(culoarebackground);
	         insertPacient = new JButton("Adauga pacient");
	         insertConsult = new JButton("   Adauga consult  ");
	         vizualizeazaProgramari = new JButton("Vizualzare programari");
	         adaugaIntertnare = new JButton("Internare noua");
	         adaugaFisaPacient = new JButton("Adauga fisa pacient");
	         cerereLaborator = new JButton("Cerere laborator noua");
	         cerereMedicamente = new JButton("Cerere medicamente");
	         fisaExternare = new JButton("Fisa de externare");
	         vizualizeazaProgramari = new JButton("Vizualizare programari");
	         cautarePacient = new JButton("Cauta pacient");
	        showPacienti = new JButton("Vizualizeaza pacienti");
	        
	         showRegistru = new JButton("Vizualizeaza registrul");
	         
	         showInternare = new JButton("Vizualizeaza internarile");
	        
	         showTratament = new JButton("Vizualizeaza tratamentele");

	         showExternari = new JButton("Vizualizeaza externarile");
	         showIstoric = new JButton("Vizualizeaza istoricul");
	         
	         showConsult = new JButton("Vizualizeaza consulturile");
	         
	         showFisaPacient = new JButton("Vizualizare fisa pacient");
	         
	         showSectii = new JButton("Vizualizeaza sectii");
	         logOut = new JButton("Log out");

	         Color culoarebuton=new Color(0x3A797F);
	      
	         insertPacient.setFont(new Font("Arial",Font.PLAIN,18));
	         insertPacient.setBackground(culoarebuton);
	         insertPacient.setForeground(Color.white);;



	         showRegistru.setFont(new Font("Arial",Font.PLAIN,18));
	         showRegistru.setBackground(culoarebuton);
	         showRegistru.setForeground(Color.white);
	         


	         showInternare.setFont(new Font("Arial",Font.PLAIN,18));
	         showInternare.setBackground(culoarebuton);
	         showInternare.setForeground(Color.white);


	         showPacienti.setFont(new Font("Arial",Font.PLAIN,18));
	         showPacienti.setBackground(culoarebuton);
	         showPacienti.setForeground(Color.white);

	     

	       

	         
	         showTratament.setFont(new Font("Arial",Font.PLAIN,18));
	         showTratament.setBackground(culoarebuton);
	         showTratament.setForeground(Color.white);

	         
	         showExternari.setFont(new Font("Arial",Font.PLAIN,18));
	         showExternari.setBackground(culoarebuton);
	         showExternari.setForeground(Color.white);
	         
	         showIstoric.setFont(new Font("Arial",Font.PLAIN,18));
	         showIstoric.setBackground(culoarebuton);
	         showIstoric.setForeground(Color.white);

	         logOut.setFont(new Font("Arial",Font.PLAIN,18));
	         logOut.setBackground(culoarebuton);
	         logOut.setForeground(Color.white);
	         
	         insertConsult.setFont(new Font("Arial",Font.PLAIN,18));
	         insertConsult.setBackground(culoarebuton);
	         insertConsult.setForeground(Color.white);

	         vizualizeazaProgramari.setFont(new Font("Arial",Font.PLAIN,18));
	         vizualizeazaProgramari.setBackground(culoarebuton);
	         vizualizeazaProgramari.setForeground(Color.white);
	         
	         adaugaIntertnare.setFont(new Font("Arial",Font.PLAIN,18));
	         adaugaIntertnare.setBackground(culoarebuton);
	         adaugaIntertnare.setForeground(Color.white);
	         
	         adaugaFisaPacient.setFont(new Font("Arial",Font.PLAIN,18));
	         adaugaFisaPacient.setBackground(culoarebuton);
	         adaugaFisaPacient.setForeground(Color.white);


	         cerereLaborator.setFont(new Font("Arial",Font.PLAIN,18));
	         cerereLaborator.setBackground(culoarebuton);
	         cerereLaborator.setForeground(Color.white);

	         cerereMedicamente.setFont(new Font("Arial",Font.PLAIN,18));
	         cerereMedicamente.setBackground(culoarebuton);
	         cerereMedicamente.setForeground(Color.white);

	         fisaExternare.setFont(new Font("Arial",Font.PLAIN,18));
	         fisaExternare.setBackground(culoarebuton);
	         fisaExternare.setForeground(Color.white);
	         

	         cautarePacient.setFont(new Font("Arial",Font.PLAIN,18));
	         cautarePacient.setBackground(culoarebuton);
	         cautarePacient.setForeground(Color.white);
	         
	         
	         showConsult.setFont(new Font("Arial",Font.PLAIN,18));
	         showConsult.setBackground(culoarebuton);
	         showConsult.setForeground(Color.white);
	         
	         showFisaPacient.setFont(new Font("Arial",Font.PLAIN,18));
	         showFisaPacient.setBackground(culoarebuton);
	         showFisaPacient.setForeground(Color.white);
	         
	         
	         showSectii.setFont(new Font("Arial",Font.PLAIN,18));
	         showSectii.setBackground(culoarebuton);
	         showSectii.setForeground(Color.white);
	         
	         
	         constraints = new GridBagConstraints();

	         constraints.fill = GridBagConstraints.CENTER;
	         constraints.gridx =0;
	         constraints.gridy =0;
	         constraints.insets = new Insets(10, 10,10, 10);
	         constraints.anchor = GridBagConstraints.CENTER;
	         constraints.weightx =0.5;
	         constraints.weighty = 0.5;

	         constraints.gridx++;
	         add(cautarePacient,constraints);
	         constraints.gridy++;
	         add(insertPacient, constraints);
	          constraints.gridy++;
	         add(showRegistru,constraints);
	           constraints.gridy++;
	      
	         add(insertConsult,constraints);
	         constraints.gridy++;

	       add(cerereLaborator,constraints);

	       constraints.gridy++;

	       add(showPacienti,constraints);

	        
	       //coloana 3
	       constraints.gridx++;
	       constraints.gridy=0;
	       
	       add(showTratament,constraints);
	         constraints.gridy++;
	       add(adaugaIntertnare,constraints);
	       
	         constraints.gridy++;
	       add(adaugaFisaPacient,constraints);
	         constraints.gridy++;
	       add(showExternari,constraints);
	       
	       constraints.gridy++;
	       add(showConsult,constraints);
	       
	         constraints.gridy++;
	       add(showInternare,constraints); 
	       //coloana 4
	       constraints.gridx++;
	       constraints.gridy=0;
	       add(fisaExternare,constraints);
	          constraints.gridy++;
	       add(vizualizeazaProgramari,constraints);
	       
	         constraints.gridy++;

	       add(showIstoric,constraints);
	       constraints.gridy++;
	       add(cerereMedicamente,constraints);
	       
	       constraints.gridy++;
	       add(showFisaPacient,constraints);
	       
	       constraints.gridy++;
	       add(showSectii,constraints);
	       
	       constraints.gridy+=4;
	       add(logOut,constraints);
	       constraints.gridy-=4;

	     
	         
	         
	         
	     }

	     public void addInsertPacientListener(ActionListener actionListener) {
	         insertPacient.addActionListener(actionListener);
	     }

	     public void addInsertConsultListener(ActionListener actionListener) {
	         insertConsult.addActionListener(actionListener);
	     }

	    // public void addAdaugaRegistruListener(ActionListener actionListener) {
	      //   vizualizeazaProgramari.addActionListener(actionListener);
	    // }

	     public void addAdaugaInternareListener(ActionListener actionListener) {
	         adaugaIntertnare.addActionListener(actionListener);
	     }

	     public void addAdaugaFisaPacient(ActionListener actionListener) {
	         adaugaFisaPacient.addActionListener(actionListener);
	     }



	     public void addCerereLaboratorListener(ActionListener actionListener) {
	         cerereLaborator.addActionListener(actionListener);
	     }

	     public void addCerereMedicamenteListener(ActionListener actionListener) {
	         cerereMedicamente.addActionListener(actionListener);
	     }

	     public void addFisaExternareListener(ActionListener actionListener) {
	         fisaExternare.addActionListener(actionListener);
	     }

	     public void addVizualizeazaProgramariListener(ActionListener actionListener) {
	     	vizualizeazaProgramari.addActionListener(actionListener);
	     }

	    // public void addIstoricListener(ActionListener actionListener) {
	     //    istoric.addActionListener(actionListener);
	    // }

	     public void addCautarePacient(ActionListener actionListener) {
	         cautarePacient.addActionListener(actionListener);
	     }



	     public void addShowRegistru(ActionListener actionListener) {
	         showRegistru.addActionListener(actionListener);
	     }



	     public void addShowInternare(ActionListener actionListener) {
	         showInternare.addActionListener(actionListener);
	     }
	     public void addAddIstoric(ActionListener actionListener) {
	         showInternare.addActionListener(actionListener);
	     }

	     public void addShowFisaPacient(ActionListener actionListener) {
	         showFisaPacient.addActionListener(actionListener);
	     }
 
	     

	     public void addShowTratament(ActionListener actionListener) {
	         showTratament.addActionListener(actionListener);
	     }

	     public void addShowExternari(ActionListener actionListener) {
	         showExternari.addActionListener(actionListener);
	     }

	     public void addShowIstoric(ActionListener actionListener) {
	         showIstoric.addActionListener(actionListener);
	     }

	     public void addShowConsult(ActionListener actionListener) {
	        showConsult.addActionListener(actionListener);
	     }

	     public void addShowPacienti(ActionListener actionListener) {
		        showPacienti.addActionListener(actionListener);
		     }

	     public void addShowSectii(ActionListener actionListener) {
		        showSectii.addActionListener(actionListener);
		     }
	     public void addLogOut(ActionListener actionListener) { logOut.addActionListener(actionListener);}
	 }