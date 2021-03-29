

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/////// Aceasta clasa reprezinta controlorul ce face legatura intre GUI si baza de date ///////

public class ApplicationLogicController {

    private DatabaseConnectionController databaseConnectionController;
    private DatabaseLogicController databaseLogicController;
    private GraphicController graphicController;
    private String id, password;
    private boolean connectedAsAdmin, connectedAsAsistenta;
    private boolean connectedAsLaborant, connectedAsMedic;
    private String decizie;
    private boolean update;


    public ApplicationLogicController() {
        // connect to database
        databaseConnectionController = new DatabaseConnectionController();
        // show GUI
        graphicController = new GraphicController();
        displayMainFrame();
        displayDatabaseConnectionPanel();
    }

    private void displayMainFrame() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showMainFrame();
            }
        });
    }

    private void displayDatabaseConnectionPanel() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showDatabaseConnectionPanel();
                addDatabaseConnectionPanelConnectAsAsistentaButtonActionListener();
                addDatabaseConnectionPanelConnectAsMedicButtonActionListener();
                addDatabaseConnectionConnectAsAdministratorActionListener();
                addDatabaseConnectionConnectAsBiologActionListener();
            }
        });
    }

    private void displayLogInPanel() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showLogInPanel();
                addLogInPanelCancelButtonActionListener();
                addLogInPanelLogInButtonActionListener();
            }
        });
    }
    

    private void addDatabaseConnectionPanelConnectAsMedicButtonActionListener() {
        graphicController.getDatabaseConnectionPanel().addConnectAsMedicButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseConnectionController.connectToDatabaseAsMedic();
                try {
                    databaseLogicController = new DatabaseLogicController(databaseConnectionController.getConnection());
                }
                catch (SQLException exception) {
                    JOptionPane.showMessageDialog(null, "Database Logic Controller initialization failed", null,
                            JOptionPane.ERROR_MESSAGE);
                }
                
                connectedAsAsistenta = false;
                connectedAsAdmin = false;
              
                connectedAsLaborant = false;
                connectedAsMedic = true;
                displayLogInPanel();
            }
        });
    }
    
    
    
    
    

    private void addDatabaseConnectionPanelConnectAsAsistentaButtonActionListener() {
        graphicController.getDatabaseConnectionPanel().addConnectAsAsistentaButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseConnectionController.connectToDatabaseAsAsistenta();
                try {
                    databaseLogicController = new DatabaseLogicController(databaseConnectionController.getConnection());
                }
                catch (SQLException exception) {
                    JOptionPane.showMessageDialog(null, "Database Logic Controller initialization failed", null,
                            JOptionPane.ERROR_MESSAGE);
                }
                connectedAsAsistenta = true;
                connectedAsAdmin = false;
              
                connectedAsLaborant = false;
                connectedAsMedic = false;
                displayLogInPanel();
            }
        });
    }

    private void addDatabaseConnectionConnectAsBiologActionListener() {
        graphicController.getDatabaseConnectionPanel().addConnectAsLaborantButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseConnectionController.connectToDatabaseAsBiolog();
                try {
                    databaseLogicController = new DatabaseLogicController(databaseConnectionController.getConnection());
                }
                catch (SQLException exception) {
                    JOptionPane.showMessageDialog(null, "Database Logic Controller initialization failed", null,
                            JOptionPane.ERROR_MESSAGE);
                }
                connectedAsAsistenta = false;
                connectedAsAdmin = false;
               
                connectedAsLaborant = true;
                connectedAsMedic = false;
                displayLogInPanel();
            }
            
        });
    }

    private void addDatabaseConnectionConnectAsAdministratorActionListener() {
        graphicController.getDatabaseConnectionPanel().addConnectAsAdminButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseConnectionController.connectToDatabaseAsAdmin();
                try {
                    databaseLogicController = new DatabaseLogicController(databaseConnectionController.getConnection());
                }
                catch (SQLException exception) {
                    JOptionPane.showMessageDialog(null, "Database Logic Controller initialization failed", null,
                            JOptionPane.ERROR_MESSAGE);
                }
                connectedAsAdmin = true;
                connectedAsAsistenta = false;
                
                connectedAsLaborant = false;
                connectedAsMedic = false;
                displayLogInPanel();
            }
        });
    }

    private void addLogInPanelLogInButtonActionListener() {
        graphicController.getLogInPanel().addLogInButtonActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id = graphicController.getLogInPanel().getIdTextField().getText();
                password = graphicController.getLogInPanel().getPasswordTextField().getText();
                
                if(connectedAsLaborant==false && connectedAsAsistenta==true && connectedAsAdmin==false && connectedAsMedic==false) {
                    if(databaseLogicController.verifyLogInConditionsAsAsistenta(id, password)) {
                        displayMainApplicationPanel();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Datele asistentei sunt gresite", null, JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else if(connectedAsLaborant==false && connectedAsAsistenta==false && connectedAsAdmin==false && connectedAsMedic==true) {
                    if(databaseLogicController.verifyLogInConditionsAsMedic(id, password)) {
                        displayMedicMainApplicationPanel();
                    
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Datele medicului sunt gresite", null, JOptionPane.PLAIN_MESSAGE);
                    }
                }
                
                else if(connectedAsLaborant==true && connectedAsAsistenta==false && connectedAsAdmin==false && connectedAsMedic==false) {
                    if(databaseLogicController.verifyLogInConditionsAsBiolog(id, password)) {
                        displayBiologMainApplicationPanel();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Datele laborantului sunt gresite", null, JOptionPane.PLAIN_MESSAGE);
                    }
                }
                
               
                
                else if(connectedAsLaborant==false && connectedAsAsistenta==false && connectedAsAdmin==true && connectedAsMedic==false) {
                    if(databaseLogicController.verifyLogInConditionsAsAdmin(id, password)) {
                    	
                        displayAdminMainApplicationPanel();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Datele administratorului sunt gresite", null, JOptionPane.PLAIN_MESSAGE);
                    }
                } 
                

             
            }
        });
        
        
    }
    
    

    

    private void addLogInPanelCancelButtonActionListener() {
        graphicController.getLogInPanel().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayDatabaseConnectionPanel();
            }
        });
    }
    


    private void displayMedicMainApplicationPanel() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showMedicMainPanel();
                addMedicMainPanelshowFisaPacientActionListener();
                addMainMedicMainPaneladaugaRegistruActionListener() ;
                addMedicMainPanelshowConsultActionListener();
                addMedicMainPanelshowAnalizeActionListener();
                addMedicMainPanelmodificaPacientActionListener();
                addMedicMainPanelshowPacientiActionListener();
                addMedicMainPanelInsertTratamentActionListener();
                addMainMedicMainPanelLogOutActionListener();
                //addMainMedicMainPanelVizualizareSimptome();
            }
        });
    }

    
    
    private void displayAdminMainApplicationPanel() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showAdministratorMainPanel();
                addMainAdminMainPanelModificareNumarPaturiActionListener();
                addMainAdministratorMainPanelModificaPretMedicamenteActionListener();
                addMainAdministratorMainPanelshowSectiiActionListener();
                addMainAdministratorMainPanelshowProduseActionListener();
                addMainAdminMainPanelNumarPacientiActionListener();
                addMainAdminMainPanelLogOutActionListener();
            }
        });
    }

    private void displayMainApplicationPanel() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showAsistentaMainPanel();
                addMainAsistentaMainPanelInsertPacientActionListener();
                addMainAsistentaMainPanelInsertConsultActionListener();
               // addMainAsistentaMainPaneladaugaRegistruActionListener();
                addMainAsistentaMainPaneladaugaInternareActionListener();
                addMainAsistentaMainPaneladaugaFisaPacientActionListener();
           //     addMainAsistentaMainPanelInsertTratamentActionListener();
                addMainAsistentaMainPanelcerereLaboratorActionListener();
                addMainAsistentaMainPanelcerereMedicamenteActionListener();
                addMainAsistentaMainPanelfisaExternareActionListener();
             //   addAsistentaMainPanelfisaExternareActionListener();
              //  addMainAsistentaMainPanelmodificaPacientActionListener();
                //addMainAsistentaMainPanelistoricActionListener();
                addMainAsistentaMainPanelcautarePacientActionListener();
                addMainAsistentaMainPanelshowPacientiActionListener();
                addMainAsistentaMainPanelshowRegistruActionListener();
                addMainAsistentaMainPanelshowConsultActionListener();
                addMainAsistentaMainPanelshowInternareActionListener();
                addMainAsistentaMainPanelshowFisaPacientActionListener();
                addMainAsistentaMainPanelshowSectiiActionListener();
              //  addMainAsistentaMainPanelshowAnalizeActionListener();
                addMainAsistentaMainPanelshowTratamentActionListener();
                //addMainAsistentaMainPanelshowProduseActionListener();
                addMainAsistentaMainPanelshowExternariActionListener();
                addMainAsistentaMainPanelshowIstoricActionListener();
                addAsistentaMainPanelshowProgramariActionListener();
                addMainAsistentaMainPanelLogOutActionListener();
            }
        });
    }
    
    public void  addMainAsistentaMainPanelshowSectiiActionListener() {
        graphicController.getAsistentaMainPanel().addShowSectii(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaySectii();
            }
        });

    }
    
    public void addMainAsistentaMainPanelshowPacientiActionListener()
    {
        graphicController.getAsistentaMainPanel().addShowPacienti(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPacient();
            }
        });
    }
    
    public void addMainAsistentaMainPanelshowConsultActionListener() {

        graphicController.getAsistentaMainPanel().addShowConsult(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayConsult();
            }
        });

    }
    private void addMainAsistentaMainPanelfisaExternareActionListener() {
        graphicController.getAsistentaMainPanel().addFisaExternareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInsertFisaExternare();
            }
        });
    }
    
    public void addMainAsistentaMainPanelshowFisaPacientActionListener(){

        graphicController.getAsistentaMainPanel().addShowFisaPacient(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFisaPacient();
            }
        });
    }

    private void displayBiologMainApplicationPanel() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showBiologMainPanel();
                addMainBiologMainPanelbuletinAnalizeActionListener();
                addMainBiologMainPanelshowCerereLaboratorActionListener();
                addMainBiologMainPanelLogOutActionListener();
            }
        });
    }

    
    private void addMainMedicMainPanelLogOutActionListener() {
        graphicController.getMedicMainPanel().addLogOut(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseConnectionController.deconnectFromDatabase();
                displayDatabaseConnectionPanel();
            }
        });
    }
    
    
  
    //ADMIN

    private void addMainAdminMainPanelLogOutActionListener() {
        graphicController.getAdministratorMainPanel().addLogOut(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseConnectionController.deconnectFromDatabase();
                displayDatabaseConnectionPanel();
            }
        });
    }


    private void addMainAdminMainPanelModificareNumarPaturiActionListener() {
        graphicController.getAdministratorMainPanel().addModificaPaturiListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayModificaPaturi();
            }
        });
    }
    
    private void addMainAdminMainPanelNumarPacientiActionListener() {
        graphicController.getAdministratorMainPanel().addActualizareNrPacientiListener(new ActionListener() {
            @Override
           
            public void actionPerformed(ActionEvent e) {
                displayNrPacienti();
            }
        });
    }

    private void displayModificaPaturi() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showModificarePaturiPanel();
                addMPatButtonListener();
                addMPatCancelListener();
            }
        });
    }
    private void displayNrPacienti() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showActualizarePacienti();
                addActualizareNrPacButtonListener();
                addActualizareNrPacCancelListener();
               
            }
        });
    }

    
    
    

    private void addMPatButtonListener() {
        graphicController.getModificarePaturi().addModificaPaturiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = graphicController.getModificarePaturi().getIdSectieTF();
                int nrpaturi = graphicController.getModificarePaturi().getNrPaturiTF();
                String result = databaseLogicController.newModificarePaturi(id, nrpaturi);
                if(result.equals("Sectia cu id-ul: "+id+" nu exista")) {
                    JOptionPane.showMessageDialog(null, "ID sectie nevalid", null, JOptionPane.ERROR_MESSAGE);
                }
                else {
                    displayAdminMainApplicationPanel();
                }
            }
        });
    }
    
    
    
    
    
  
    private void addActualizareNrPacButtonListener() {
        graphicController.getActualizarePacienti().addActualizarePacientiActionListener(new ActionListener() {

            @Override
            
            public void actionPerformed(ActionEvent e) {
                int id_sectie = graphicController.getActualizarePacienti().getIdSectieTF();
                int nr_pacienti= graphicController.getActualizarePacienti().getNrPacientiTF();
                String result = databaseLogicController.newActualizarePacienti(id_sectie, nr_pacienti);
                if(result.equals("Sectia cu id-ul: "+id+" nu exista")) {
                    JOptionPane.showMessageDialog(null, "ID sectie nevalid", null, JOptionPane.ERROR_MESSAGE);
                }
                else {
                    displayAdminMainApplicationPanel();
                }
            }
            
        });
    }
    
    
    
    

    private void addMPatCancelListener() {
        graphicController.getModificarePaturi().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAdminMainApplicationPanel();
            }
        });
    }


    private void addMainAsistentaMainPanelVizualizeazaProgramariActionListener() {
        graphicController.getAsistentaMainPanel().addVizualizeazaProgramariListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	displayVizualizeazaProgramari();
            }
        });
    }

    private void displayVizualizeazaProgramari() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showVizualizareProgramariPanel();
                addMPButtonListener();
                addMPCancelListener();
            }
        });
    }
    private void addActualizareNrPacCancelListener() {
        graphicController.getActualizarePacienti().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAdminMainApplicationPanel();
            }
        });
    }

    
    
    
    
    private void addMainAdministratorMainPanelModificaPretMedicamenteActionListener() {
        graphicController.getAdministratorMainPanel().addModificaMedicamenteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphicController.showModificareMedicamentePanel();
                displayModificaPretMedicamente();
            }
        });
    }

    private void displayModificaPretMedicamente() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showModificareMedicamentePanel();
                addMMButtonListener();
                addMMCancelListener();
            }
        });
    }

    private void addMMButtonListener() {
        graphicController.getModificareMedicamente().addModificaMedicamenteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = graphicController.getModificareMedicamente().getIdMedicamentTF();
                int pret = graphicController.getModificareMedicamente().getPretTF();
                String result = databaseLogicController.newModificarePret(id, pret);
                if(result.equals("Produsul nu exista")) {
                    JOptionPane.showMessageDialog(null, "Produsul nu exista", null, JOptionPane.ERROR_MESSAGE);
                }
                else {
                    displayAdminMainApplicationPanel();
                }
            }
        });
    }

    private void addMMCancelListener() {
        graphicController.getModificareMedicamente().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAdminMainApplicationPanel();
            }
        });
    }

    private void addMainAdministratorMainPanelshowSectiiActionListener() {
        graphicController.getAdministratorMainPanel().addShowSecii(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaySectii();
            }
        });
    }

    private void addMainAdministratorMainPanelshowProduseActionListener() {
        graphicController.getAdministratorMainPanel().addShowProduse(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayProduse();
            }
        });
    }
    

    private void displayProduse()
    {
        String[] columnNames = {"id","Pret","Idmedicament","Medicament","idmatsanitar","Material Sanitar"};
        ResultSet resultSet = databaseLogicController.showProduseInfo();
        String[][] data = parsematrixShowProduse(resultSet, 0, 6);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showVizProduse(data, columnNames);
            }
        });
    }
    
    
    
    
    
    
    

    //END_ADMIN

    //BIOLOG

    private void addMainBiologMainPanelLogOutActionListener() {
        graphicController.getBiologMainPanel().addLogOut(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseConnectionController.deconnectFromDatabase();
                displayDatabaseConnectionPanel();
            }
        });
    }
    


    private void addMainBiologMainPanelbuletinAnalizeActionListener() {
        graphicController.getBiologMainPanel().addBuletinAnalizeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInsertBuletinAnalize();
            }
        });
    }

    private void displayInsertBuletinAnalize() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showBuletinAnalizePanel();
                addBAButtonListener();
                addBACancelListener();
            }
        });
    }

    private void addBAButtonListener() {
        graphicController.getBuletinAnalize().addInsertBuletinActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeBiolog = graphicController.getBuletinAnalize().getNumeBiologTF().getText();
                String  Evaluarea_Calitatii = graphicController.getBuletinAnalize().getEvaluareCalitateCB();
                String Rezultat = graphicController.getBuletinAnalize().getRezultatTF().getText();
                String Observatii = graphicController.getBuletinAnalize().getObservatiiTF().getText();
                int Pret = graphicController.getBuletinAnalize().getPretTF();
                int nrFisa = Integer.parseInt(graphicController.getBuletinAnalize().getNrFisaTF().getText());
                String tip_analiza = graphicController.getBuletinAnalize().getTipAnalizaTF().getText();
                if(databaseLogicController.newBuletinAnalize(nrFisa,numeBiolog,tip_analiza, Evaluarea_Calitatii, Rezultat, Observatii, Pret)) {
                    displayBiologMainApplicationPanel();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Verify the input data", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    private void addMainBiologMainPanelshowCerereLaboratorActionListener() {
        graphicController.getBiologMainPanel().addShowCerereLaborator(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    displayCerereLaborator();
            }
        });
    }

    private void displayCerereLaborator()
    {
        String[] columnNames = {"Cod","NrFisa","Data cerere","Prioritate","Tip Analiza"};
        ResultSet resultSet = databaseLogicController.showCerereLaboratorInfo();
        String[][] data = parsematrixShowRegistrul(resultSet,0, 5);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showVizCerereLaborator(data, columnNames);
            }
        });
    }

    private String[][] parsematrixShowRegistrul(ResultSet resultSet,int rowCount, int columnCount) {
        String[][] result = new String[rowCount][columnCount];
        int i = 0;
        try {
            while (resultSet.next()) {
                int j = 0;

                if (i >= rowCount) {
                    result = copyMatrix(result, rowCount, columnCount);
                    rowCount++;
                }

                Integer temp = resultSet.getInt(1);
                result[i][j] = temp.toString();
                j++;

                temp = resultSet.getInt(2);
                result[i][j] = temp.toString();
                j++;

                result[i][j] = resultSet.getString(3);
                j++;

                result[i][j] = resultSet.getString(4);
                j++;

                result[i][j] = resultSet.getString(5);
                j++;


                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }

    //END BIOLOG

    //ASISTENTA

    private void addMainAsistentaMainPanelLogOutActionListener() {
        graphicController.getAsistentaMainPanel().addLogOut(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseConnectionController.deconnectFromDatabase();
                displayDatabaseConnectionPanel();
            }
        });
    }


    private void addMainAsistentaMainPanelInsertPacientActionListener() {
        graphicController.getAsistentaMainPanel().addInsertPacientListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPacientInsert();
            }
        });
    }

    private void  displayPacientInsert() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showInsertPacientPanel();
                addIPPCancelButtonActionListener();
                addIPPAddButtonActionListener();
            }
        });
    }

    private void addIPPAddButtonActionListener () {
        graphicController.getInsertPacient().addInsertPacientActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	
                    String CNP = graphicController.getInsertPacient().getCNPTextField().getText();
                    String nume = graphicController.getInsertPacient().getNumeTextField().getText();
                    String data_n = graphicController.getInsertPacient().getDataTextField().getText();
                    String profesie = graphicController.getInsertPacient().getProfesieTextField().getText();
                    String adresa = graphicController.getInsertPacient().getAdresaTextField().getText();
                    String telefon = graphicController.getInsertPacient().getTelefonTextField().getText();
                    String grup_sangvin = graphicController.getInsertPacient().getGrupsangvinComboBox();
                    boolean asigurat = graphicController.getInsertPacient().getAsiguratCheckBox();
                    String sex = graphicController.getInsertPacient().getSexComboBox();
                    String provenienta = graphicController.getInsertPacient().getProvenientaComboBox();
                    String categorie = graphicController.getInsertPacient().getCategorieComboBox();
                    String Simptome=graphicController.getInsertPacient().getSimptome().getText();
                    String result = databaseLogicController.insertNewPacient(CNP, nume, data_n, profesie, adresa, telefon, grup_sangvin, asigurat, sex, provenienta, categorie,Simptome);
                    if (!result.equals("eroare")) {
                        if(result.equals("update")) {
                            update = true;
                            System.out.println(result);
                        }
                        displayInsertConsult();
                    } else {
                        JOptionPane.showMessageDialog(null, "Verify the input data", null, JOptionPane.ERROR_MESSAGE);
                    }
                }
        });
    }

    private void addIPPCancelButtonActionListener() {
        graphicController.getInsertPacient().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMainApplicationPanel();
            }
        });
    }


    
    private void addMainAsistentaMainPanelInsertConsultActionListener() {
        graphicController.getAsistentaMainPanel().addInsertConsultListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInsertConsult();
            }
        });
    }

    private void displayInsertConsult() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showInsertConsultPanel();
                addICPAddButtonListener();
                addICPCancelButtonListener();
            }
        });
    }
    

    private void addICPAddButtonListener() {
        graphicController.getInsertConsult().addInsertConsultActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idSectie = Integer.parseInt(graphicController.getInsertConsult().getIdSectieTextField().getText());
                String medic = graphicController.getInsertConsult().getMedicTextField().getText();
                String tipTrimitere = graphicController.getInsertConsult().getTipTrimitereComboBox();
                String tipConsult = graphicController.getInsertConsult().getTipConsultTextField().getText();
                String Diagnostic = graphicController.getInsertConsult().getDiagnosticTextField().getText();
                String Decizie = graphicController.getInsertConsult().getDecizieComboBox();
                int Cost=Integer.parseInt(graphicController.getInsertConsult().getCostTextField().getText());
                String nume_pacient=graphicController.getInsertConsult().getNumeTextField().getText();
                decizie = Decizie;

                if (databaseLogicController.insertNewConsult(idSectie, medic, tipTrimitere, tipConsult, Diagnostic, Decizie,Cost,nume_pacient)) {
                	displayInsertConsult();
                	displayMainApplicationPanel();
                } else {
                    JOptionPane.showMessageDialog(null, "Verify the input data", null, JOptionPane.ERROR_MESSAGE);

                }
            }
        });
    }

    private void addICPCancelButtonListener() {
        graphicController.getInsertConsult().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMainApplicationPanel();
            }
        });
    }


    private void addMainMedicMainPaneladaugaRegistruActionListener() {
        graphicController.getMedicMainPanel().addAdaugareRegistruListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diplayInsertRegistru();
            }
        });
    }



    private void addURAddButtonListener() {
        graphicController.getAdaugaRegistru().addAdaugaRegistruActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int parafa = Integer.parseInt(graphicController.getAdaugaRegistru().getParafaTextField().getText());
                if (databaseLogicController.insertUpdateRegistru(parafa)) {
                    if(decizie.equals("Se interneaza")) {
                        displayInsertInternare();
                    }
                    else {
                        displayMainApplicationPanel();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Verify the input data", null, JOptionPane.ERROR_MESSAGE);
                    displayMainApplicationPanel();
                }
            }
        });
    }

    private void addARAddButtonListener() {
        graphicController.getAdaugaRegistru().addAdaugaRegistruActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int parafa = Integer.parseInt(graphicController.getAdaugaRegistru().getParafaTextField().getText());
                int id=Integer.parseInt(graphicController.getAdaugaRegistru().getIdTextField().getText());
                if (databaseLogicController.insertNewRegistru(parafa,id)) {
                   // if(decizie.equals("Se interneaza")) {
                        diplayInsertRegistru();
                        displayMedicMainApplicationPanel();
                   // }
                   // else {
                       
                   // }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Verify the input data", null, JOptionPane.ERROR_MESSAGE);
                    displayMedicMainApplicationPanel();
                }
            }
        });
    }
    private void diplayInsertRegistru() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if(update==false) {
                    graphicController.showAdaugaRegistruPanel();
                    addARAddButtonListener();
                    addARAddCancelListener();
                }
                else {
                    graphicController.showAdaugaRegistruPanel();
                    addURAddButtonListener();
                    addARAddCancelListener();
                    update=false;
                }
            }
        });
    }
    private void addARAddCancelListener() {
        graphicController.getAdaugaRegistru().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMedicMainApplicationPanel();
            }
        });
    }


    private void addMainAsistentaMainPaneladaugaInternareActionListener() {
        graphicController.getAsistentaMainPanel().addAdaugaInternareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInsertInternare();
            }
        });
    }

    private void displayInsertInternare() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               // graphicController.showAdaugaRegistruPanel();
            	graphicController.showAdaugaInternarePanel();
                addAIAddButtonListener();
                addAIAddCancelListener();
            }
        });
    }

    private void addAIAddButtonListener() {
        graphicController.getAdaugaInternare().addAdaugaInternareActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipInternare = graphicController.getAdaugaInternare().getTipInternareComboBox();
                String motivInternare = graphicController.getAdaugaInternare().getMotivInternareTextField().getText();
                if(databaseLogicController.insertNewInternare(tipInternare, motivInternare)) {
                    displayInsertFisaPacient();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Verify the input data", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void addAIAddCancelListener() {
        graphicController.getAdaugaInternare().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMainApplicationPanel();
            }
        });
    }


    private void addMainAsistentaMainPaneladaugaFisaPacientActionListener() {
        graphicController.getAsistentaMainPanel().addAdaugaFisaPacient(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInsertFisaPacient();
            }
        });
    }

    private void displayInsertFisaPacient() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showAdaugaFisaPacientPanel();
                addAFPButtonListener();
                addAFPCancelListener();
            }
        });
    }

    private void addAFPButtonListener() {
        graphicController.getAdaugaFisaPacient().addAdaugaFisaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float temp = graphicController.getAdaugaFisaPacient().getTemperaturaTextField();
                String tens = graphicController.getAdaugaFisaPacient().getTensiuneTextField().getText();
                int puls = graphicController.getAdaugaFisaPacient().getPulsTextField();
                String evolutie = graphicController.getAdaugaFisaPacient().getEvolutieComboBox();
                String motive_internare = graphicController.getAdaugaFisaPacient().getMotiveInternareTextField().getText();
                if(databaseLogicController.insertNewFisaPacient(temp, tens, puls, evolutie, motive_internare)) {
                    displayMainApplicationPanel();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Verify the input data", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void addAFPCancelListener() {
        graphicController.getAdaugaFisaPacient().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMainApplicationPanel();
            }
        });
    }


    private void addMedicMainPanelInsertTratamentActionListener() {
        graphicController.getMedicMainPanel().addAdaugaTratamentListener
(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInsertTratament();
            }
        });
    }

    private void displayInsertTratament() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showInsertTratamentPanel();
                addITButtonListener();
                addITCancelListener();
            }
        });
    }

    private void addITButtonListener() {
        graphicController.getInsertTratament().addInsertTratamentActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String DenumireMedicament = graphicController.getInsertTratament().getDenumireMedicamentTextField().getText();
                String DenumireSanitar = graphicController.getInsertTratament().getDenumireSanitarTextField().getText();
                int cost = Integer.parseInt(graphicController.getInsertTratament().getCostTextField().getText());
                int NrFisa = Integer.parseInt(graphicController.getInsertTratament().getNrFisaTextField().getText());
                if(databaseLogicController.insertNewTratament(NrFisa,DenumireMedicament, DenumireSanitar, cost)) {
                	displayMedicMainApplicationPanel();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Verify the input data", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void addITCancelListener() {
        graphicController.getInsertTratament().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMedicMainApplicationPanel();
            }
        });
    }


    private void addMainAsistentaMainPanelcerereLaboratorActionListener() {
        graphicController.getAsistentaMainPanel().addCerereLaboratorListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInsertCerereLaborator();
            }
        });
    }

    private void displayInsertCerereLaborator() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showCerereLaboratorPanel();
                addCLButtonListener();
                addCLCancelListener();
            }
        });
    }

    private void addCLButtonListener() {
        graphicController.getCerereLaborator().addCerereLaboratorActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nrFisa = graphicController.getCerereLaborator().getNrFisaTF();
                String prioritate = graphicController.getCerereLaborator().getPrioritateCB();
                String tip = graphicController.getCerereLaborator().getTipTF().getText();
                String result = databaseLogicController.newCerereLaborator(nrFisa, prioritate, tip);
                if(result.equals("Numar fisa nevalid!")) {
                    JOptionPane.showMessageDialog(null, "Numar fisa nevalid", null, JOptionPane.ERROR_MESSAGE);
                }
                else {
                    displayMainApplicationPanel();
                }
            }
        });
    }

    private void addCLCancelListener() {
        graphicController.getCerereLaborator().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMainApplicationPanel();
            }
        });
    }


    private void addMainAsistentaMainPanelcerereMedicamenteActionListener() {
        graphicController.getAsistentaMainPanel().addCerereMedicamenteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInsertCerereMedicament();
            }
        });
    }

    private void displayInsertCerereMedicament() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showCerereMedicamentePanel();
                displayTratament();
                addCMButtonListener();
                addCMCancelListener();
            }
        });
    }

    private void addCMButtonListener() {
        graphicController.getCerereMedicament().addCerereMedicamentActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idTratament = graphicController.getCerereMedicament().getIdTratamentTF();
                int cantitate = graphicController.getCerereMedicament().getCantitateTF();
                String result = databaseLogicController.insertNewCerereMedicament(idTratament, cantitate);
                if(result.equals("Nu exista produsul")) {
                    JOptionPane.showMessageDialog(null, "Nu exista produsul", null, JOptionPane.ERROR_MESSAGE);
                }
                else {
                    displayMainApplicationPanel();
                }
            }
        });
    }

    private void addCMCancelListener() {
        graphicController.getCerereMedicament().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMainApplicationPanel();
            }
        });
    }

    private void addBACancelListener() {
        graphicController.getBuletinAnalize().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBiologMainApplicationPanel();
            }
        });
    }


    private void addAsistentaMainPanelfisaExternareActionListener() {
        graphicController.getAsistentaMainPanel().addFisaExternareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInsertFisaExternare();
            }
        });
    }

    private void displayInsertFisaExternare() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showFisaExternarePanel();
                addFEButtonListener();
                addFECancelListener();
            }
        });
    }

    
    private void addFEButtonListener() {
        graphicController.getFisaExternare().addInsertExternareActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nrFisa = Integer.parseInt(graphicController.getFisaExternare().getNrFisaTF().getText());
                String epicriza = graphicController.getFisaExternare().getEpicrizaTF().getText();
                String recomandari = graphicController.getFisaExternare().getRecomandariTF().getText();
                String result = databaseLogicController.newFisaExternare(nrFisa, epicriza, recomandari);
                if(result.equals("Numar fisa nevalid!")) {
                    JOptionPane.showMessageDialog(null, "Numar fisa nevalid", null, JOptionPane.ERROR_MESSAGE);
                }
                else if(result.equals("Eroare!")){
                    JOptionPane.showMessageDialog(null, "Eroare baza de date!", null, JOptionPane.ERROR_MESSAGE);
                }
                else {
                    displayInsertIstoric();
                }
            }
        });
    }

    private void addFECancelListener() {
        graphicController.getFisaExternare().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMainApplicationPanel();
            }
        });
    }


    private void addMedicMainPanelmodificaPacientActionListener() {
        graphicController.getMedicMainPanel().addModificaStarePacientListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayModificaPacient();
            }
        });
    }

    private void displayModificaPacient() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showModificaPacientPanel();
                addMPButtonListener();
                addMPCancelListener();
            }
        });
    }

    private void addMPButtonListener() {
        graphicController.getModificaPacient().addModificaPacientActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ok1=0, ok2=0;
                int nrfisa = Integer.parseInt(graphicController.getModificaPacient().getNrFisaTF().getText());
                float temp = graphicController.getModificaPacient().getTemperaturaTextField();
                String tens = graphicController.getModificaPacient().getTensiuneTextField().getText();
                int puls = graphicController.getModificaPacient().getPulsTextField();
                String evolutie = graphicController.getModificaPacient().getEvolutieComboBox();
                String result = databaseLogicController.newModificaPacient(nrfisa, temp, tens, puls, evolutie);
                if(temp<35 || temp>41.5) {
                    ok1=1;
                }
                if(puls<50 || puls>120) {
                    ok2=1;
                }
                if(ok1==1&&ok2==1) {
                    JOptionPane.showMessageDialog(null, "Temperatura si pulsul gresite", null, JOptionPane.ERROR_MESSAGE);
                }
                else if(ok1==1) {
                    JOptionPane.showMessageDialog(null, "Temperatura gresita", null, JOptionPane.ERROR_MESSAGE);
                }
                else if(ok2==1) {
                    JOptionPane.showMessageDialog(null, "Puls gresit", null, JOptionPane.ERROR_MESSAGE);
                }
                else if(result.equals("Pacientul cu NrFisa: "+nrfisa+" nu are o fisa de pacient")) {
                    JOptionPane.showMessageDialog(null, "Pacientul nu are fisa de pacient", null, JOptionPane.ERROR_MESSAGE);
                }
                else {
                    displayMedicMainApplicationPanel();
                }
            }
        });
    }

    private void addMPCancelListener() {
        graphicController.getModificaPacient().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMedicMainApplicationPanel();
            }
        });
    }


    private void addMainAsistentaMainPanelcautarePacientActionListener() {
        graphicController.getAsistentaMainPanel().addCautarePacient(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayCautarePacient();
            }
        });
    }

    private void displayCautarePacient() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                graphicController.showCautarePacientPanel();
                addCPButtonListener();
                addCPCancelListener();
            }
        });
    }

    private void addCPButtonListener() {
        graphicController.getCautarePacient().addCautarePacientActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CNP = graphicController.getCautarePacient().getCNPTextField().getText();
                ResultSet resultSet = databaseLogicController.cautarePacient(CNP);
                String result = new String();
                try {
                        resultSet.next();
                        result = resultSet.getString(1);
                    }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                }
                finally {
                    if(result.equals("Pacientul cu CNP-ul: "+CNP+" nu se afla in registru")) {
                        JOptionPane.showMessageDialog(null, "Pacientul nu se afla in registru", null, JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        displayShowCautarePacient(CNP, resultSet);
                    }
                }
            }
        });
    }

    private void displayShowCautarePacient(String CNP, ResultSet resultSet) {
        String[] columnNames = {"id","Nume","CNP","Data nasterii","Adresa","Telefon","Profesie","Provenienta","Categorie","Grup sangvin","Sex","Asigurat"};
        String[][] data = parsematrixShowCautarePacient(resultSet, 1, 12);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showVizPacienti(data, columnNames);
            }
        });
    }

    private void addCPCancelListener() {
        graphicController.getCautarePacient().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMainApplicationPanel();
            }
        });
    }


    private void addMainAsistentaMainPanelistoricActionListener() {
        graphicController.getAsistentaMainPanel().addShowIstoric(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInsertIstoric();
            }
        });
    }

    private void displayInsertIstoric() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            graphicController.showIstoricPanel();
            addIPButtonListener();
            addIPCancelListener();
            }
        });
    }

    private void addIPButtonListener() {
        graphicController.getIstoric().addInsertIstoricActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CNP = graphicController.getIstoric().getCNPTextField().getText();
                if(databaseLogicController.newIstoric(CNP)) {
                    displayMainApplicationPanel();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Verify the input data", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void addIPCancelListener() {
        graphicController.getIstoric().addCancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMainApplicationPanel();
            }
        });
    }


    public void addMainAsistentaMainPanelshowIstoricActionListener() {
        graphicController.getAsistentaMainPanel().addShowIstoric(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayIstoric();
            }
        });
    }

    private void displayIstoric()
    {
        String[] columnNames = {"id","CNP","consultatii","tratamente","externari"};
        ResultSet resultSet = databaseLogicController.showIstoricInfo();
        String[][] data = parsematrixShowIstoric(resultSet, 0, 5);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showVizIstoric(data, columnNames);
            }
        });
    }


    private String[][] parsematrixShowIstoric(ResultSet resultSet, int rowCount, int columnCount) {
        String[][] result = new String[rowCount][columnCount];
        int i = 0;
        try {
            while (resultSet.next()) {
                int j = 0;

                if (i >= rowCount) {
                    result = copyMatrix(result, rowCount, columnCount);
                    rowCount++;
                }

                Integer temp = resultSet.getInt(1);
                result[i][j] = temp.toString();
                j++;

                result[i][j] = resultSet.getString(2);
                j++;

                result[i][j] = resultSet.getString(3);
                j++;

                result[i][j] = resultSet.getString(4);
                j++;

                result[i][j] = resultSet.getString(5);
                j++;

               // result[i][j] = resultSet.getString(6);
                //j++;

                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }


    public void addMainAsistentaMainPanelshowExternariActionListener() {

        graphicController.getAsistentaMainPanel().addShowExternari(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayExternari();
            }
        });
    }

    private void displayExternari()
    {
        String[] columnNames = {"idPacient","NrFoaie","Nume","Data externare","Epicriza","Recomandari","Cost total"};
        ResultSet resultSet = databaseLogicController.showExternariInfo();
        String[][] data = parsematrixShowExternari(resultSet, 0, 7);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showVizExternare(data, columnNames);
            }
        });
    }

    private String[][] parsematrixShowExternari(ResultSet resultSet, int rowCount, int columnCount) {
        String[][] result = new String[rowCount][columnCount];
        int i = 0;
        try {
            while (resultSet.next()) {
                int j = 0;

                if (i >= rowCount) {
                    result = copyMatrix(result, rowCount, columnCount);
                    rowCount++;
                }

                Integer temp = resultSet.getInt(1);
                result[i][j] = temp.toString();
                j++;

                temp = resultSet.getInt(2);
                result[i][j] = temp.toString();
                j++;

                result[i][j] = resultSet.getString(3);
                j++;

                result[i][j] = resultSet.getString(4);
                j++;

                result[i][j] = resultSet.getString(5);
                j++;

                result[i][j] = resultSet.getString(6);
                j++;

                Float nr=resultSet.getFloat(7);
                result[i][j] = nr.toString();
                j++;

                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }




    private String[][] parsematrixShowProduse(ResultSet resultSet, int rowCount, int columnCount) {
        String[][] result = new String[rowCount][columnCount];
        int i = 0;
        try {
            while (resultSet.next()) {
                int j = 0;

                if (i >= rowCount) {
                    result = copyMatrix(result, rowCount, columnCount);
                    rowCount++;
                }

                Integer temp = resultSet.getInt(1);
                result[i][j] = temp.toString();
                j++;

                Float nr=resultSet.getFloat(2);
                result[i][j] = nr.toString();
                j++;

                temp = resultSet.getInt(3);
                result[i][j] = temp.toString();
                j++;

                result[i][j] = resultSet.getString(4);
                j++;

                temp = resultSet.getInt(5);
                result[i][j] = temp.toString();
                j++;

                result[i][j] = resultSet.getString(6);
                j++;

                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }


    public void  addMainAsistentaMainPanelshowTratamentActionListener() {

        graphicController.getAsistentaMainPanel().addShowTratament(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTratament();
            }
        });
    }
    public void  addMedicMainPanelshowSimptometActionListener() {

        graphicController.getAsistentaMainPanel().addShowTratament(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTratament();
            }
        });
    }



    private void displayTratament()
    {
        String[] columnNames = {"idTratament","NrFisa","Nume Pacient","Medicament","Material sanitar","Cost"};
        ResultSet resultSet = databaseLogicController.showTratamentInfo();
        String[][] data = parsematrixShowTratament(resultSet, 0, 6);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showVizTratament(data, columnNames);
            }
        });

    }

    private String[][] parsematrixShowTratament(ResultSet resultSet, int rowCount, int columnCount) {
        String[][] result = new String[rowCount][columnCount];
        int i = 0;
        try {
            while (resultSet.next()) {
                int j = 0;

                if (i >= rowCount) {
                    result = copyMatrix(result, rowCount, columnCount);
                    rowCount++;
                }

                Integer temp = resultSet.getInt(1);
                result[i][j] = temp.toString();
                j++;

                temp = resultSet.getInt(2);
                result[i][j] = temp.toString();
                j++;

                result[i][j] = resultSet.getString(3);
                j++;

                result[i][j] = resultSet.getString(4);
                j++;

                result[i][j] = resultSet.getString(5);
                j++;

                Float nr=resultSet.getFloat(6);

                result[i][j] =nr.toString();
                j++;

                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }


    public void  addMedicMainPanelshowAnalizeActionListener()
    {

        graphicController.getMedicMainPanel().addVizualizareAnalizeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAnalize();
            }
        });

    }

    private void displayAnalize()
    {
        String[] columnNames = {"codCerere","Nume Pacient","Biolog","Tip Analiza","Evaluarea calitatii","Rezultat","Observatii","Pret"};
        ResultSet resultSet = databaseLogicController.showAnalizeInfo();
        String[][] data = parsematrixShowAnalize(resultSet, 0, 8);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showVizAnalize(data, columnNames);
            }
        });
    }


    private String[][] parsematrixShowAnalize(ResultSet resultSet, int rowCount, int columnCount) {
        String[][] result = new String[rowCount][columnCount];
        int i = 0;
        try {
            while (resultSet.next()) {
                int j = 0;

                if (i >= rowCount) {
                    result = copyMatrix(result, rowCount, columnCount);
                    rowCount++;
                }

                Integer temp = resultSet.getInt(1);
                result[i][j] = temp.toString();
                j++;

                result[i][j] = resultSet.getString(2);
                j++;

                result[i][j] = resultSet.getString(3);
                j++;

                result[i][j] = resultSet.getString(4);
                j++;

                result[i][j] = resultSet.getString(5);
                j++;

                result[i][j] = resultSet.getString(6);
                j++;

                result[i][j] = resultSet.getString(7);
                j++;

                temp = resultSet.getInt(8);
                result[i][j] = temp.toString();
                j++;

                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

/*
    public void  addMainAsistentaMainPanelshowSectiiActionListener() {
        graphicController.getAsistentaMainPanel().addShowSecii(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaySectii();
            }
        });

    }
*/
    private void displaySectii()
    {
        String[] columnNames = {"id","Nume","Nr paturi","Sef sectie"};
        ResultSet resultSet = databaseLogicController.showSectiiInfo();
        String[][] data = parsematrixShowSectii(resultSet, 0, 4);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showVizSectii(data, columnNames);
            }
        });
    }

    private String[][] parsematrixShowSectii(ResultSet resultSet, int rowCount, int columnCount) {
        String[][] result = new String[rowCount][columnCount];
        int i = 0;
        try {
            while (resultSet.next()) {
                int j = 0;

                if (i >= rowCount) {
                    result = copyMatrix(result, rowCount, columnCount);
                    rowCount++;
                }

                Integer temp = resultSet.getInt(1);
                result[i][j] = temp.toString();
                j++;

                result[i][j] = resultSet.getString(2);
                j++;

                temp=resultSet.getInt(3);
                result[i][j] =temp.toString();
                j++;

                result[i][j] =resultSet.getString(4);
                j++;

                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }


    public void addMedicMainPanelshowFisaPacientActionListener(){

        graphicController.getMedicMainPanel().addVizualizareFisaPacientListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFisaPacient();
            }
        });
    }

    private void displayProgramari()
    {
        String[] columnNames = {"id_medic","id_pacient","ziua_programarii","luna_programarii","ora"};
        ResultSet resultSet = databaseLogicController.showProgramari();
        String[][] data = parsematrixShowProgramari(resultSet, 0, 5);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showVizFisaPacient(data, columnNames);
            }
        });
    }

    private String[][] parsematrixShowProgramari(ResultSet resultSet, int rowCount, int columnCount) {
        String[][] result = new String[rowCount][columnCount];
        int i = 0;
        try {
            while (resultSet.next()) {
                int j = 0;

                if (i >= rowCount) {
                    result = copyMatrix(result, rowCount, columnCount);
                    rowCount++;
                }

                Integer temp = resultSet.getInt(1);
                result[i][j] = temp.toString();
                j++;
                
                
                Integer temp1 = resultSet.getInt(2);
                result[i][j] = temp.toString();
                j++;

                
                Integer ziua=resultSet.getInt(3);
                result[i][j] =ziua.toString();
                j++;

                
                Integer luna=resultSet.getInt(4);
                result[i][j] =luna.toString();
                j++;


                result[i][j] = resultSet.getString(5);
                j++;

                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    //programari
    
    public void addAsistentaMainPanelshowProgramariActionListener(){

        graphicController.getAsistentaMainPanel().addVizualizeazaProgramariListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayProgramari();
            }
        });
    }

    private void displayFisaPacient()
    {
        String[] columnNames = {"NrFisa","Nume","Temperatura","Tensiune","Puls","Evolutie"};
        ResultSet resultSet = databaseLogicController.showFisaPacientInfo();
        String[][] data = parsematrixShowFisaPacient(resultSet, 0, 6);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showVizFisaPacient(data, columnNames);
            }
        });
    }

    private String[][] parsematrixShowFisaPacient(ResultSet resultSet, int rowCount, int columnCount) {
        String[][] result = new String[rowCount][columnCount];
        int i = 0;
        try {
            while (resultSet.next()) {
                int j = 0;

                if (i >= rowCount) {
                    result = copyMatrix(result, rowCount, columnCount);
                    rowCount++;
                }

                Integer temp = resultSet.getInt(1);
                result[i][j] = temp.toString();
                j++;

                result[i][j] = resultSet.getString(2);
                j++;

                Float nr=resultSet.getFloat(3);
                result[i][j] =nr.toString();
                j++;

                result[i][j] =resultSet.getString(4);
                j++;

                temp=resultSet.getInt(5);
                result[i][j] = temp.toString();
                j++;

                result[i][j] = resultSet.getString(6);
                j++;

                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }


    public void addMainAsistentaMainPanelshowInternareActionListener() {

        graphicController.getAsistentaMainPanel().addShowInternare(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInternare();
            }
        });
    }

    private void displayInternare()
    {
        String[] columnNames = {"NrFoaie","NrCons","Nume","Medic","Tipul internarii","Motivele internarii","Diagnostic"};
        ResultSet resultSet = databaseLogicController.showInternariInfo();
        String[][] data = parsematrixShowInternare(resultSet, 0, 7);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showVizInternare(data, columnNames);
            }
        });
    }

    private String[][] parsematrixShowInternare(ResultSet resultSet, int rowCount, int columnCount) {
        String[][] result = new String[rowCount][columnCount];
        int i = 0;
        try {
            while (resultSet.next()) {
                int j = 0;

                if (i >= rowCount) {
                    result = copyMatrix(result, rowCount, columnCount);
                    rowCount++;
                }

                Integer temp = resultSet.getInt(1);
                result[i][j] = temp.toString();
                j++;

                temp = resultSet.getInt(2);
                result[i][j] = temp.toString();
                j++;

                result[i][j] =resultSet.getString(3);
                j++;

                result[i][j] =resultSet.getString(4);
                j++;

                result[i][j] = resultSet.getString(5);
                j++;

                result[i][j] = resultSet.getString(6);
                j++;

                result[i][j] = resultSet.getString(7);
                j++;

                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }


    public void addMedicMainPanelshowConsultActionListener() {

        graphicController.getMedicMainPanel().addVizualizareConsultariListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayConsult();
            }
        });

    }

    private void displayConsult()
    {
        String[] columnNames = {"NrCons","idPacient","idSectie","Nume","Medic","Tip trimitere","Tip consult","Data consult","Diagnostic","Decizie"};
        ResultSet resultSet = databaseLogicController.showConsultInfo();
        String[][] data = parsematrixShowConsult(resultSet, 0, 10);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showVizConsult(data, columnNames);
            }
        });
    }

    private String[][] parsematrixShowConsult(ResultSet resultSet, int rowCount, int columnCount) {
        String[][] result = new String[rowCount][columnCount];
        int i = 0;
        try {
            while (resultSet.next()) {
                int j = 0;

                if (i >= rowCount) {
                    result = copyMatrix(result, rowCount, columnCount);
                    rowCount++;
                }

                Integer temp = resultSet.getInt(1);
                result[i][j] = temp.toString();
                j++;

                temp = resultSet.getInt(2);
                result[i][j] = temp.toString();
                j++;

                temp = resultSet.getInt(3);
                result[i][j] =temp.toString();
                j++;

                result[i][j] =resultSet.getString(4);
                j++;

                result[i][j] = resultSet.getString(5);
                j++;

                result[i][j] = resultSet.getString(6);
                j++;

                result[i][j] = resultSet.getString(7);
                j++;

                result[i][j] = resultSet.getString(8);
                j++;

                result[i][j] = resultSet.getString(9);
                j++;

                result[i][j] = resultSet.getString(10);
                j++;

                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }


    public void addMainAsistentaMainPanelshowRegistruActionListener() {
        graphicController.getAsistentaMainPanel().addShowRegistru(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRegistru();
            }
        });
    }
    
    private void displayRegistru()
    {
        String[] columnNames = {"id","id_medic","NrReg","NrCrt","Parafa"};
        ResultSet resultSet = databaseLogicController.showRegistruInfo();
        String[][] data = parsematrixShowRegistru(resultSet, 0, 5);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showVizRegistru(data, columnNames);
            }
        });
    }

    private String[][] parsematrixShowRegistru(ResultSet resultSet, int rowCount, int columnCount) {
        String[][] result = new String[rowCount][columnCount];
        int i = 0;
        try {
            while (resultSet.next()) {
                int j = 0;

                if (i >= rowCount) {
                    result = copyMatrix(result, rowCount, columnCount);
                    rowCount++;
                }

                Integer temp = resultSet.getInt(1);
                result[i][j] = temp.toString();
                j++;

                temp = resultSet.getInt(2);
                result[i][j] = temp.toString();
                j++;

                temp = resultSet.getInt(3);
                result[i][j] =temp.toString();
                j++;

                temp = resultSet.getInt(4);
                result[i][j] =temp.toString();
                j++;
                
                temp = resultSet.getInt(4);
                result[i][j] =temp.toString();
                j++;

                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }


    public void addMedicMainPanelshowPacientiActionListener()
    {
        graphicController.getMedicMainPanel().addVizualizarePacientiListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPacient();
            }
        });
    }
    //String CNP, String nume, String data_n, String profesie, String adresa, String telefon, String grup_sangvin, boolean asigurat, String sex, String provenienta, String categorie
    private void displayPacient() {
        String[] columnNames = {"id","Nume","CNP","Data nasterii","Adresa","Telefon","Profesie","Provenienta","Categorie","Grup sangvin","Sex","Asigurat"};
        ResultSet resultSet = databaseLogicController.showPacientiInfo();
        String[][] data = parsematrixShowPacient(resultSet, 0, 12);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                graphicController.showVizPacienti(data, columnNames);
            }
        });
    }

    private String[][] parsematrixShowCautarePacient(ResultSet resultSet, int rowCount, int columnCount) {
        String[][] result = new String[rowCount][columnCount];
        int i = 0;
        try {
            resultSet.previous();
            while (resultSet.next()) {
                int j = 0;

                if (i >= rowCount) {
                    result = copyMatrix(result, rowCount, columnCount);
                    rowCount++;
                }

                Integer temp = resultSet.getInt(1);
                result[i][j] = temp.toString();
                j++;

                result[i][j] = resultSet.getString(2);
                j++;

                result[i][j] = resultSet.getString(3);
                j++;

                result[i][j] = resultSet.getString(4);
                j++;

                result[i][j] = resultSet.getString(5);
                j++;

                result[i][j] = resultSet.getString(6);
                j++;

                result[i][j] = resultSet.getString(7);
                j++;

                result[i][j] = resultSet.getString(8);
                j++;

                result[i][j] = resultSet.getString(9);
                j++;

                result[i][j] = resultSet.getString(10);
                j++;

                result[i][j] = resultSet.getString(11);
                j++;

                result[i][j] = resultSet.getString(12);
                j++;

                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }

    private String[][] parsematrixShowPacient(ResultSet resultSet, int rowCount, int columnCount) {
        String[][] result = new String[rowCount][columnCount];
        int i = 0;
        try {
            while (resultSet.next()) {
                int j = 0;

                if (i >= rowCount) {
                    result = copyMatrix(result, rowCount, columnCount);
                    rowCount++;
                }

                Integer temp = resultSet.getInt(1);
                result[i][j] = temp.toString();
                j++;

                result[i][j] = resultSet.getString(2);
                j++;

                result[i][j] = resultSet.getString(3);
                j++;

                result[i][j] = resultSet.getString(4);
                j++;

                result[i][j] = resultSet.getString(5);
                j++;

                result[i][j] = resultSet.getString(6);
                j++;

                result[i][j] = resultSet.getString(7);
                j++;

                result[i][j] = resultSet.getString(8);
                j++;

                result[i][j] = resultSet.getString(9);
                j++;

                result[i][j] = resultSet.getString(10);
                j++;

                result[i][j] = resultSet.getString(11);
                j++;

                result[i][j] = resultSet.getString(12);
                j++;

                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }

  

    
    //END ASISTENTA

    private String[][] copyMatrix(String[][] data, Integer rowCount, Integer columnCount) {
        String[][] result = new String[rowCount + 1][columnCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                result[i][j] = data[i][j];
            }
        }
        return result;
    }

}