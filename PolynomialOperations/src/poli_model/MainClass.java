package poli_model;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Monom a=new Monom(3, 2);
	//	System.out.println(a.getCoeficient());
	//	System.out.println(a.getPutere());
	//	a.setCoeficient(23);
	//	System.out.println(a.getCoeficient());
	//	a.setPutere(8);
	//	System.out.println(a.getPutere());
	    Polinom p1=new Polinom();
		Polinom p2=new Polinom();
		Polinom p3=new Polinom();
		Monom m1=new Monom(4,3);
		Monom m2=new Monom(3,-3);
		Monom m3=new Monom(2,7);
		Monom m4=new Monom(1,-10);
		Monom m5=new Monom(0,-20);
		Monom m6= new Monom(4,3);
		Monom m7=new Monom(3,8);
		Monom m8=new Monom(2,5);
		Monom m9=new Monom(1,11);
		Monom m10=new Monom(0,-7);
		p1.addMonoame(m1);
		p1.addMonoame(m2);
		p1.addMonoame(m3);
		p1.addMonoame(m4);
		p1.addMonoame(m5);
		p2.addMonoame(m6);
		p2.addMonoame(m7);
		p2.addMonoame(m8);
		p2.addMonoame(m9);
		p2.addMonoame(m10);
		
		
		//try {
		//System.out.println("polinom 1:  " + p1.FormarePolinom());
		//System.out.println("polinom 2:  " + p2.FormarePolinom());
		//}
		/*catch (ExceptieFormat e)
		{
			System.out.println("format gresit");
		}
		//System.out.println(p1.getMonom(2));
		//Integer coefP=p1.getMonom(0).getPutere();
		//System.out.println(coefP);
	//	System.out.println(p1.getNrMonoame());
	//	System.out.println(p2.getNrMonoame());
		
		Polinom rez_add = new Polinom();
		Polinom rez=new Polinom();
		*/
		
		Monom a1=new Monom(3,2);
		Monom a2=new Monom(2,5);
		Monom a3=new Monom(1,10);
		Monom a4=new Monom(0,-1);
	
		p3.addMonoame(a1);
		p3.addMonoame(a2);
		p3.addMonoame(a3);
		p3.addMonoame(a4);
	    
		
	 	System.out.println("polinom1" + p1.FormarePolinom());
	 	System.out.println("polinom2"+ p2.FormarePolinom());
		System.out.println("polinom3"+ p3.FormarePolinom());
		System.out.println("adunare:  " + p1.adunare(p2).FormarePolinom());
		
		System.out.println("inmultire:   " + p1.inmulteste(p2).FormarePolinom());
		System.out.println("derivare:   " + p3.derivare().FormarePolinom());
		System.out.println("integrare:  "+p3.integrare().FormarePolinomDouble());
		
		System.out.println("scadere:  " + p1.scadere(p2).FormarePolinom());
		 
		Polinom p4=new Polinom();
		Polinom p5=new Polinom();
		Monom b1=new Monom(2,1);
		Monom b2=new Monom(0,1);
		Monom b3=new Monom(1,1);
		p4.addMonoame(b1);
		p4.addMonoame(b2);
		p5.addMonoame(b3);
		Polinom p=new Polinom();
		p.setPolinom("x^2+x");
	//	System.out.println(p.getMonom(0).getCoeficient());
	//	System.out.println(p.getMonom(0).getPutere());
		Polinom pol=new Polinom();
		pol.setPolinom("x");
	//	System.out.println(pol.getMonom(0).getCoeficient());
	//	System.out.println(pol.getMonom(0).getPutere());
		Polinom pi=new Polinom();
	//	pi=p.impartire(pol);
		System.out.println(p.imparte(pol));
		
		
	
		
		   
		
		
		
		
		
		
		

	}

}
