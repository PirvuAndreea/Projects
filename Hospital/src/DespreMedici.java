

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class DespreMedici {

	JFrame frame;
	private JLabel label = new JLabel("New label");
	private JLabel label1 = new JLabel("New label");
	private JLabel label2 = new JLabel("New label");
	private JLabel label3 = new JLabel("New label");
	private JLabel label4 = new JLabel("New label");
	private JLabel label5 = new JLabel("New label");
	private JLabel label6 = new JLabel("New label");
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public DespreMedici() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.setBounds(100, 100, 878, 604);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label=new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/2.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(54, 238, 185, 134);
		frame.getContentPane().add(label);
		
		label1=new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/1.jpg")).getImage();
		label1.setIcon(new ImageIcon(img1));
		label1.setBounds(54, 383, 185, 134);
		frame.getContentPane().add(label1);	
		
		label2=new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/3.jpg")).getImage();
		label2.setIcon(new ImageIcon(img2));
		label2.setBounds(538, 76, 155, 134);
		frame.getContentPane().add(label2);	
		
		label3=new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/4.jpg")).getImage();
		label3.setIcon(new ImageIcon(img3));
		label3.setBounds(538, 238, 155, 134);
		frame.getContentPane().add(label3);
		
		
		label5=new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/5.jpg")).getImage();
		label5.setIcon(new ImageIcon(img5));
		label5.setBounds(472, 383, 281, 134);
		frame.getContentPane().add(label5);	
		
		label4=new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/6.jpg")).getImage();
		label4.setIcon(new ImageIcon(img4));
		label4.setBounds(54, 76, 281, 134);
		frame.getContentPane().add(label4);	
		
		JLabel lblOParteDin = new JLabel("O parte din echipa noastr\u0103");
		lblOParteDin.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblOParteDin.setHorizontalAlignment(SwingConstants.CENTER);
		lblOParteDin.setForeground(new Color(0, 0, 0));
		lblOParteDin.setBounds(274, 24, 299, 40);
		frame.getContentPane().add(lblOParteDin);
		
		JButton btnnapoi = new JButton("\u00CEnapoi");
		btnnapoi.setForeground(new Color(255, 255, 255));
		btnnapoi.setBackground(new Color(0, 139, 139));
		btnnapoi.setBounds(286, 499, 101, 35);
		frame.getContentPane().add(btnnapoi);
		
		
		btnnapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DesprePoliclinica window = new DesprePoliclinica();
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
