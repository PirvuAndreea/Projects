

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DesprePoliclinica {

	JFrame frame;
	private DespreMedici info;
	private GraphicController graphicController;
	private LogInPanel log;
	/**
	 * Launch the application.
	 */
	private JLabel label = new JLabel("New label");
	
	

	/**
	 * Create the application.
	 */
	public DesprePoliclinica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.setBounds(100, 100, 878, 604);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBineAtiVenit = new JLabel("Bine a\u021Bi venit la Policlinic\u0103!");
		lblBineAtiVenit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBineAtiVenit.setHorizontalAlignment(SwingConstants.CENTER);
		lblBineAtiVenit.setForeground(new Color(0, 0, 0));
		lblBineAtiVenit.setBounds(273, 11, 270, 39);
		frame.getContentPane().add(lblBineAtiVenit);
		
		JTextArea txtrSpitalulClinicJudeean = new JTextArea();
		txtrSpitalulClinicJudeean.setBackground(new Color(224, 255, 255));
		txtrSpitalulClinicJudeean.setText("        Policlinica nostr\u0103 este cea mai mare unitate sanitar\u0103 public\u0103 din Transilvania,\r\nde interes local, regional \u015Fi jude\u0163ean, care asigur\u0103 servicii medicale, av\u00E2nd 1089 paturi\r\nde spitalizare continu\u0103, din care 939 de paturi pentru adul\u0163i \u015Fi 150 paturi pentru copii, precum\r\n\u015Fi un num\u0103r de 123 paturi de spitalizare de zi, \u015Fi 12 paturi pentru \u00EEnso\u0163itori.");
		txtrSpitalulClinicJudeean.setBounds(41, 61, 729, 76);
		frame.getContentPane().add(txtrSpitalulClinicJudeean);
		
		JTextArea txtrMisuneaNoastr = new JTextArea();
		txtrMisuneaNoastr.setBackground(new Color(224, 255, 255));
		txtrMisuneaNoastr.setText("        Misunea noastr\u0103 este prestataea unui act medical de calitate, \u00EEntr-un mediu sigur\r\n\u0219i confortabil, astfel \u00EEnc\u00E2t pacien\u021Bii s\u0103 beneficieze de cele mai bune \u00EEngrijiri.\r\n");
		txtrMisuneaNoastr.setBounds(41, 137, 703, 39);
		frame.getContentPane().add(txtrMisuneaNoastr);
		
		JTextArea txtrSeciilePoliclinicii = new JTextArea();
		txtrSeciilePoliclinicii.setBackground(new Color(224, 255, 255));
		txtrSeciilePoliclinicii.setText("Sec\u021Biile policlinicii:\r\n1. Sec\u021Bia Chirurgie Vasculara\r\n2. Sec\u021Bia Medicin\u0103 Intern\u0103\r\n3. Sec\u021Bia Gastroenterologie\r\n4. Sec\u021Bia Cardiologie\r\n5. Sec\u021Bia Neurologie\r\n6. Sec\u021Bia Chirurgie \u0219i Ortopedie Pediatric\u0103\r\n7. Sec\u021Bia Neurochirurgie\r\n8. Sec\u021Bia ORL\r\n9. Sec\u021Bia Recuperare\r\n10. Sec\u021Bia Chirurgie Oral\u0103 \u0219i Maxilo-Facial\u0103");
		txtrSeciilePoliclinicii.setBounds(101, 178, 442, 202);
		frame.getContentPane().add(txtrSeciilePoliclinicii);
		
		JButton btnNewButton = new JButton("Despre medici");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(585, 389, 196, 49);
		frame.getContentPane().add(btnNewButton);
		
		/*JButton btnnapoi = new JButton("\u00CEnapoi");
		btnnapoi.setForeground(Color.WHITE);
		btnnapoi.setBackground(new Color(0, 128, 128));
		btnnapoi.setBounds(41, 391, 142, 39);
		frame.getContentPane().add(btnnapoi);*/
		
		label=new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/hos1.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(559, 187, 185, 134);
		frame.getContentPane().add(label);	
		
	
		btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									DespreMedici window = new DespreMedici();
									window.frame.setVisible(true);
									
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						
					}
				});
		
		
	}
	
	
	
}
