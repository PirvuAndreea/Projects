package poli_controller;
import poli_model.Polinom;
import poli_view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PolinomController {
	private Polinom polinom1;
	private Polinom polinom2;
	private PolinomView pview;
	
	public PolinomController(Polinom polinom1, Polinom polinom2, PolinomView pview) {
		this.polinom1=polinom1;
		this.polinom2=polinom2;
		this.pview=pview;
		
		
		
		pview.addAdunareListener(new AdunareListener());
		pview.addScadereListener(new ScadereListener());
		pview.addInmultireListener(new InmultireListener());
		pview.addDerivareListener(new DerivareListener());
		pview.addIntegrareListener(new IntegrareListener());
		pview.addImpartireListener(new ImpartireListener());
		pview.addClearListener(new ClearListener());
		pview.addClearAllListener(new ClearAllListener());
		
	}
	
	    class AdunareListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s1="";
			String s2="";
			polinom1=new Polinom();
			polinom2=new Polinom();
			s1=pview.getInput1();
			s2=pview.getInput2();
			polinom1.setPolinom(s1);
			polinom2.setPolinom(s2);
			pview.setRezultat(polinom1.adunare(polinom2).FormarePolinom());
		}
	}
	    class ScadereListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String s1="";
				String s2="";
				polinom1=new Polinom();
				polinom2=new Polinom();
				s1=pview.getInput1();
				s2=pview.getInput2();
				polinom1.setPolinom(s1);
				polinom2.setPolinom(s2);
				pview.setRezultat(polinom1.scadere(polinom2).FormarePolinom());
				
			}
	    }
	    class  InmultireListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String s1="";
				String s2="";
				polinom1=new Polinom();
				polinom2=new Polinom();
				s1=pview.getInput1();
				s2=pview.getInput2();
				polinom1.setPolinom(s1);
				polinom2.setPolinom(s2);
				pview.setRezultat(polinom1.inmulteste(polinom2).FormarePolinom());
				
			}
	    	
	    }
	    class  ImpartireListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String s1="";
				String s2="";
				polinom1=new Polinom();
				polinom2=new Polinom();
				s1=pview.getInput1();
				s2=pview.getInput2();
				polinom1.setPolinom(s1);
				polinom2.setPolinom(s2);
				pview.setRezultat(polinom1.imparte(polinom2));
				
			}
	    }
	    class DerivareListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String s="";
				polinom1=new Polinom();
				s=pview.getInput1();
				polinom1.setPolinom(s);
				pview.setRezultat(polinom1.derivare().FormarePolinom());
				
			}
	    	
	    }
	    class IntegrareListener implements ActionListener{
	    	public void actionPerformed(ActionEvent e) {
				String s="";
				polinom1=new Polinom();
				s=pview.getInput1();
				polinom1.setPolinom(s);
				pview.setRezultat(polinom1.integrare().FormarePolinomDouble());
				
			}
	    }
	    class ClearListener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				pview.reset();
				
			}
	    	
	    }
	    class ClearAllListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				pview.resetAll();
				pview.setRezultat("");
				
			}
	    	
	    }
	
}


	