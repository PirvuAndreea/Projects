

import javax.swing.*;



import java.awt.*;

public class GraphicController {
    private MainFrame mainFrame;
    private DatabaseConnectionPanel databaseConnectionPanel;
    private LogInPanel logInPanel;
    private AsistentaMainPanel asistentaMainPanel;
    private AdministratorMainPanel administratorMainPanel;
    private BiologMainPanel biologMainPanel;
    private MedicMainPanel medicMainPanel;
    private PacientMainPanel pacientMainPanel;
    private ShowInfoTable vizualizareProgramari;
    
    private InsertPacient insertPacient;
    private InsertConsult insertConsult;
    private AdaugaRegistru adaugaRegistru;
    private AdaugaInternare adaugaInternare;
    private AdaugaFisaPacient adaugaFisaPacient;
    private ActualizarePacienti actualizare_pacienti;
    private CerereLaborator cerereLaborator;
    private CerereMedicament cerereMedicament;
    private InsertTratament insertTratament;
    private ModificaPacient modificaPacient;
    private FisaExternare fisaExternare;
    private BuletinAnalize buletinAnalize;
    private Istoric istoric;
    private CautarePacient cautarePacient;
    private ShowPacient showPacient;
    //admin
    private ModificareMedicamente modificareMedicamente;
    private ModificarePaturi modificarePaturi;

    private ShowInfoTable vizPacienti;
    private ShowInfoTable vizRegistru;
    private ShowInfoTable vizConsult;
    private ShowInfoTable vizInternare;
    private ShowInfoTable vizFisaPacient;
    private ShowSectiiInfo vizSectii;
    private ShowInfoTable vizAnalize;
    private ShowInfoTable vizTratament;
    private ShowInfoTable vizProduse;
    private ShowInfoTable vizExternare;
    private ShowInfoTable vizIstoric;
    private ShowInfoTable vizSimptome;
    private ShowInfoTable vizCerereLaborator;
    private Color culoarebackground=new Color(0x20BCCB);
    public GraphicController() {
    }

    public void showMainFrame() {
        mainFrame = new MainFrame();
        mainFrame.setTitle("Policlinica");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setBackground(culoarebackground);
   
        ImageIcon img=new ImageIcon("C:\\Users\\ABC\\Desktop\\asistenta.png");
        setIconImage(img.getImage());
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    private void setIconImage(Image image) {
		// TODO Auto-generated method stub
		mainFrame.setIconImage(image);
	}

	public void showDatabaseConnectionPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Policlinica");
        databaseConnectionPanel = new DatabaseConnectionPanel();
        mainFrame.add(databaseConnectionPanel);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showLogInPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Log In");
        logInPanel = new LogInPanel();
        mainFrame.add(logInPanel);
        mainFrame.setBounds(700, 200, 647, 418);
        mainFrame.pack();
    	/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInPanel1 window = new LogInPanel1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
    
*/
    }
    public void showVizualizareProgramariPanel() {
   	 mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Programari");
        cautarePacient = new CautarePacient();
        mainFrame.add(vizualizareProgramari);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    
    public void showAsistentaMainPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Asistenta");
        asistentaMainPanel = new AsistentaMainPanel();
        mainFrame.add(asistentaMainPanel);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showAdministratorMainPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Administrator");
        administratorMainPanel = new AdministratorMainPanel();
        mainFrame.add(administratorMainPanel);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showBiologMainPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Biolog");
        biologMainPanel = new BiologMainPanel();
        mainFrame.add(biologMainPanel);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }
    
    public void showMedicMainPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Medic");
        medicMainPanel = new MedicMainPanel();
        mainFrame.add(medicMainPanel);
        //mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.getBounds();
        mainFrame.pack();
    }

    
    public void showPacientMainPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Pacient");
        pacientMainPanel = new PacientMainPanel();
        mainFrame.add(pacientMainPanel);
       // mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.getBounds();
        mainFrame.pack();
    }

    public void showAdaugaFisaPacientPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Fisa Pacient");
        adaugaFisaPacient = new AdaugaFisaPacient();
        mainFrame.add(adaugaFisaPacient);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showAdaugaInternarePanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Internare");
        adaugaInternare = new AdaugaInternare();
        mainFrame.add(adaugaInternare);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showAdaugaRegistruPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Registru");
        adaugaRegistru = new AdaugaRegistru();
        mainFrame.add(adaugaRegistru);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showBuletinAnalizePanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Buletin de Analize");
        buletinAnalize = new BuletinAnalize();
        mainFrame.add(buletinAnalize);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void setShowPacient(String[][] data, String[] columnNames) {
        showPacient = new ShowPacient(data, columnNames);
    }

    public void showCerereLaboratorPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Cerere laborator");
        cerereLaborator = new CerereLaborator();
        mainFrame.add(cerereLaborator);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showCerereMedicamentePanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Cerere Medicamente");
        cerereMedicament = new CerereMedicament();
        mainFrame.add(cerereMedicament);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showFisaExternarePanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Fisa externare");
        fisaExternare = new FisaExternare();
        mainFrame.add(fisaExternare);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showInsertConsultPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Consult");
        insertConsult = new InsertConsult();
        mainFrame.add(insertConsult);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showInsertPacientPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Pacient");
        insertPacient = new InsertPacient();
        mainFrame.add(insertPacient);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showInsertTratamentPanel () {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Tratament");
        insertTratament = new InsertTratament();
        mainFrame.add(insertTratament);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showIstoricPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Istoric Pacient");
        istoric = new Istoric();
        mainFrame.add(istoric);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showModificaPacientPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        modificaPacient = new ModificaPacient();
        mainFrame.add(modificaPacient);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showModificareMedicamentePanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Pret Medicamente");
        modificareMedicamente = new ModificareMedicamente();
        mainFrame.add(modificareMedicamente);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showModificarePaturiPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Numar paturi");
        modificarePaturi = new ModificarePaturi();
        mainFrame.add(modificarePaturi);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }
    
    public void showActualizarePacienti() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Numar pacienti");
        actualizare_pacienti = new ActualizarePacienti();
        mainFrame.add(actualizare_pacienti);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }
    

    public void showCautarePacientPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.setTitle("Cautare Pacient");
        cautarePacient = new CautarePacient();
        mainFrame.add(cautarePacient);
        mainFrame.setBounds(500, 200, 647, 418);
        mainFrame.pack();
    }

    public void showVizPacienti(String[][] data, String[] columnNames) {
        vizPacienti = new ShowInfoTable(data, columnNames);
    }

    public void showVizRegistru(String[][] data, String[] columnNames) {
        vizRegistru = new ShowInfoTable(data, columnNames);
    }

    public void showVizConsult (String[][] data, String[] columnNames) {
        vizConsult = new ShowInfoTable(data, columnNames);
    }

    public void showVizInternare (String[][] data, String[] columnNames) {
        vizInternare = new ShowInfoTable(data, columnNames);
    }

    public void showVizFisaPacient (String[][] data, String[] columnNames) {
        vizFisaPacient = new ShowInfoTable(data, columnNames);
    }

    public void showVizSectii (String[][] data, String[] columnNames) {
        vizSectii = new ShowSectiiInfo(data, columnNames);
    }

    public void showVizAnalize (String[][] data, String[] columnNames) {
        vizAnalize = new ShowInfoTable(data, columnNames);
    }

    public void showVizTratament (String[][] data, String[] columnNames) {
        vizTratament = new ShowInfoTable(data, columnNames);
    }

    public void showVizProduse (String[][] data, String[] columnNames) {
        vizProduse = new ShowInfoTable(data, columnNames);
    }

    public void showVizExternare (String[][] data, String[] columnNames) {
        vizExternare = new ShowInfoTable(data, columnNames);
    }

    public void showVizIstoric (String[][] data, String[] columnNames) {
        vizIstoric = new ShowInfoTable(data, columnNames);
    }
    
    public void showVizSimptome (String[][] data, String[] columnNames) {
        vizSimptome = new ShowInfoTable(data, columnNames);
    }


    public void showVizCerereLaborator (String[][] data, String[] columnNames) {
        vizCerereLaborator = new ShowInfoTable(data, columnNames);
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public DatabaseConnectionPanel getDatabaseConnectionPanel() {
        return databaseConnectionPanel;
    }

    public LogInPanel getLogInPanel()
    {
        return logInPanel;
    }
    


    public AsistentaMainPanel getAsistentaMainPanel() {
        return asistentaMainPanel;
    }

    public AdministratorMainPanel getAdministratorMainPanel() {
        return administratorMainPanel;
    }
    
    public PacientMainPanel getPacientMainPanel() {
        return pacientMainPanel;
    }
    
    public MedicMainPanel getMedicMainPanel() {
        return medicMainPanel;
    }
    

    public BiologMainPanel getBiologMainPanel() {
        return biologMainPanel;
    }

    public InsertPacient getInsertPacient() {
        return insertPacient;
    }

    public InsertConsult getInsertConsult() {
        return insertConsult;
    }

    public AdaugaRegistru getAdaugaRegistru() {
        return adaugaRegistru;
    }

    public AdaugaInternare getAdaugaInternare() {
        return adaugaInternare;
    }

    public AdaugaFisaPacient getAdaugaFisaPacient() {
        return adaugaFisaPacient;
    }

    public CerereLaborator getCerereLaborator() {
        return cerereLaborator;
    }

    public CerereMedicament getCerereMedicament() {
        return cerereMedicament;
    }

    public InsertTratament getInsertTratament() {
        return insertTratament;
    }

    public ModificaPacient getModificaPacient() {
        return modificaPacient;
    }

    public FisaExternare getFisaExternare() {
        return fisaExternare;
    }

    public BuletinAnalize getBuletinAnalize() {
        return buletinAnalize;
    }

    public Istoric getIstoric() {
        return istoric;
    }

    public CautarePacient getCautarePacient() {
        return cautarePacient;
    }

    public ModificareMedicamente getModificareMedicamente() {
        return modificareMedicamente;
    }

    public ModificarePaturi getModificarePaturi() {
        return modificarePaturi;
    }
    
    public ActualizarePacienti getActualizarePacienti() {
        return actualizare_pacienti;
    }

}

