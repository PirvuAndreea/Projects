package poli_view;
import poli_model.Polinom;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class PolinomView extends JFrame{
	private JTextField input1 = new JTextField(20);
	private JTextField input2=new JTextField(20);
	private JTextField rezultat=new JTextField(20);
	private JButton adunareBtn=new JButton("+");
	private JButton scadereBtn=new JButton("-");
	private JButton inmultireBtn=new JButton("*");
	private JButton impartireBtn=new JButton("/");
	private JButton derivareBtn=new JButton("Derivare Polinom 1");
	private JButton integrareBtn = new JButton("Integrare Polinom 1");
	private JButton stergere=new JButton("Clear");
	private JButton stergere_all=new JButton("Clear All");
	
	private Polinom polinom1=new Polinom();
	private Polinom polinom2=new Polinom();
	
	public PolinomView (Polinom polinom1, Polinom polinom2) {
		this.polinom1=polinom1;
		this.polinom2=polinom2;
		
		 Color culoarebackground=new Color(0x20FFEFD5); 
	     Color culoarebuton=new Color(0xDCDCDC);
		 
		rezultat.setText("");
		rezultat.setEditable(false);
		
		JPanel content=new JPanel();
		content.setLayout(null);
	    content.setBackground(culoarebackground);
		
		JLabel polin_label=new JLabel("Polinom 1: ");
		content.add(polin_label);
		polin_label.setBounds(10,10,400,30);
		
		JLabel polin_label2=new JLabel("Polinom 2: ");
		content.add(polin_label2);
		polin_label2.setBounds(10,50,400,30);
		
	    content.add(input1);
	 	input1.setBounds(100,10,400,30);
		
		content.add(input2);
		input2.setBounds(100,50,400,30);
		
		content.add(adunareBtn);
		adunareBtn.setBounds(20,110,50,40);
	    adunareBtn.setBackground(culoarebuton);
		
		content.add(scadereBtn);
		scadereBtn.setBounds(80,110,50,40);
		scadereBtn.setBackground(culoarebuton);
		
		content.add(inmultireBtn);
		inmultireBtn.setBounds(140,110,50,40);
		inmultireBtn.setBackground(culoarebuton);
		
		content.add(impartireBtn);
		impartireBtn.setBounds(200,110,50,40);
		impartireBtn.setBackground(culoarebuton);
		
		content.add(derivareBtn);
		derivareBtn.setBounds(260,110,150,40);
		derivareBtn.setBackground(culoarebuton);
		
		content.add(integrareBtn);
		integrareBtn.setBounds(420,110,150,40);
		integrareBtn.setBackground(culoarebuton);
		
		JLabel rez_label=new JLabel("Rezultat: ");
		content.add(rez_label);
		rez_label.setBounds(10, 180, 400,30);
		
		content.add(rezultat);
		rezultat.setBounds(100, 180, 400,60);
		
		content.add(stergere);
		stergere.setBounds(150, 310, 100,40);
		stergere.setBackground(culoarebuton);
		
		content.add(stergere_all);
		stergere_all.setBounds(300,310,100,40);
		stergere_all.setBackground(culoarebuton);
		
	
		this.setContentPane(content);
		this.pack();
		this.setTitle("Sistem de procesare a polinoamelor");
		
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public String getInput1() {
		return input1.getText();
	}
	public String getInput2() {
		return input2.getText();
	}
	public void showErr(String err) {
       JOptionPane.showMessageDialog(this, err);		
	}
	public void setRezultat(String r)
	{
		this.rezultat.setText(r);
	}
	public void reset() {
		this.rezultat.setText(null);
	}
	public void resetAll() {
		this.rezultat.setText(null);
		this.input1.setText(null);
		this.input2.setText(null);
	}

	
	public void addClearListener(ActionListener a) {
		stergere.addActionListener(a);
	}
	public void addClearAllListener(ActionListener a) {
		stergere_all.addActionListener(a);
	}
	public void addAdunareListener(ActionListener al) {
		adunareBtn.addActionListener(al);
	}
	public void addScadereListener(ActionListener al) {
		scadereBtn.addActionListener(al);
	}
	public void addInmultireListener(ActionListener al) {
		inmultireBtn.addActionListener(al);
	}
	public void addImpartireListener(ActionListener al) {
		impartireBtn.addActionListener(al);
	}
	public void addDerivareListener(ActionListener al) {
		derivareBtn.addActionListener(al);
	}
	public void addIntegrareListener(ActionListener al) {
		integrareBtn.addActionListener(al);
	}
	
	
}
