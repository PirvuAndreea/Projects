package poli_view;

import poli_model.Polinom;
import poli_controller.PolinomController;
public class MainClass {

	public static void main(String[] args) {
		Polinom polinom1=new Polinom();
		Polinom polinom2=new Polinom();
		PolinomView pview=new PolinomView(polinom1, polinom2);
		PolinomController pc=new PolinomController(polinom1, polinom2, pview);
		pview.setVisible(true);
		pview.setBounds(200,200,700,430);
		
	}

}
