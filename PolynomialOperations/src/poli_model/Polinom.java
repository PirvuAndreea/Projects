package poli_model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Polinom {
	private	List<Monom> listaMonoame = new ArrayList<Monom>();
	private int nrMonoame;
	String string="";
	
	public Polinom() {
		ArrayList<Monom>listaMonoame=new ArrayList();
		this.listaMonoame=listaMonoame;
	}
	public void addMonoame(Monom monom) {
		listaMonoame.add(monom);
		nrMonoame++;		
	}
      public List<Monom> getMonom(){
		return this.listaMonoame;
		
	}
	 public void setPolinom(String s){
		
		  Pattern pat = Pattern.compile("([+-]?\\b\\d+)?[+-]?[x]?\\^?(\\d+)?");
		  Matcher mat = pat.matcher(s);	  
		  List <String> listaGrupuri = new ArrayList<String>();
			while(mat.find()){
				listaGrupuri.add(mat.group());
			}
			Monom monom = new Monom(0,0);
			String grup = new String();
			Integer i = 0;
			for( i=0; i<listaGrupuri.size()-1; i++)
			{
				grup = listaGrupuri.get(i);			
				monom = monom.setMonom(grup);						
				this.getMonom().add(monom);		
			}
		 
	}
		
	
	public String FormarePolinom() //throws ExceptieFormat
	{
		String formare_polinom="";
		String p="";
		String c="";
		for (Monom monoame:listaMonoame)
		{
			int coef=(int) monoame.getCoeficient();
			if(monoame.getCoeficient()==0)//daca polinomul e gol continuam
				continue;
			if(coef!=1 && coef != -1 ) {
				c=coef + "";
			}
			 if(coef>=1) //daca coeficientul este pozitiv punem semnul "+"
			{
				c="+" + coef;
			}
			if(coef==1) { //daca coeficientul este 1, nu il punem, punem doar semnul "+"
				c="+";
			}
			if(coef==-1) {// daca coeficientul este -1, punem doar "-"
				c="-";
			}
			/*if(monoame.getPutere()<0)
			{
				throw new ExceptieFormat("ati introdus puteri negative");
			}*/
			if(monoame.getPutere()!=0 && monoame.getPutere()!=1) //daca puterea este diferita de 0 si 1 punem "x^"
			{
				p="x^" + (int) monoame.getPutere();
			}
			else if(monoame.getPutere()==1) //daca puterea e 1 punem doar "x" fara "^"
			{
				p="x";
			}
			else
				p=""; //daca puterea este 0, nu punem nimic
			if(coef==1 && monoame.getPutere()==0) //daca coeficientul este 1 si puterea 0 punem doar coeficientul 1
			{
				c="+1";
			}
			if(coef==-1 && monoame.getPutere()==0) //daca coeficientul este -1 si puterea este 0 punem doar coeficientul -1
			{
				c="-1";
			}
			formare_polinom=formare_polinom+c+p; //realizam formarea totala a polinomului 	
		}
		return formare_polinom;
	}
	
	
	public String FormarePolinomDouble() //throws ExceptieFormat
	{
		String formare_polinom="";
		String p="";
		String c="";
		for (Monom monoame:listaMonoame)
		{
			double coef=monoame.GetCoefDouble();
			if(monoame.GetCoefDouble()==0)//daca polinomul e gol continuam
				continue;
			if(coef!=1.0 && coef != -1.0 ) {
				c=coef + "";
			}
			 if(coef>=0.0) //daca coeficientul este pozitiv punem semnul "+"
			{
				c="+" + coef;
			}
			if(coef==1.0) { //daca coeficientul este 1, nu il punem, punem doar semnul "+"
				c="+";
			}
			if(coef==-1.0) {// daca coeficientul este -1, punem doar "-"
				c="-";
			}
			/*if(monoame.getPutere()<0)
			{
				throw new ExceptieFormat("ati introdus puteri negative");
			}*/
			if(monoame.getPutere()!=0 && monoame.getPutere()!=1) //daca puterea este diferita de 0 si 1 punem "x^"
			{
				p="x^" + (int) monoame.getPutere();	
			}
			else if(monoame.getPutere()==1) //daca puterea e 1 punem doar "x" fara "^"
			{
				p="x";
			}
			else
				p=""; //daca puterea este 0, nu punem nimic
			if(coef==1.0 && monoame.getPutere()==0) //daca coeficientul este 1 si puterea 0 punem doar coeficientul 1
			{
				c="+1.0";
			}
			if(coef==-1.0 && monoame.getPutere()==0) //daca coeficientul este -1 si puterea este 0 punem doar coeficientul -1
			{
				c="-1.0";
			}
			formare_polinom=formare_polinom+c+p; //realizam formarea totala a polinomului 	
		}
		return formare_polinom;
	}
	
	
    public Polinom adunare( Polinom Q) {
		Monom m;
		Polinom rez=new Polinom();
		Integer nr_monoame_P=this.getMonom().size();
		Integer nr_monoame_Q=Q.getMonom().size();
		Integer i=0; 
		Integer j=0; 
		
		while(i<nr_monoame_P && j<nr_monoame_Q) 
		{
			Integer coefP=this.getMonom().get(i).getCoeficient(); 
			Integer coefQ=Q.getMonom().get(j).getCoeficient();
			Integer putereP=this.getMonom().get(i).getPutere();
			Integer putereQ=Q.getMonom().get(j).getPutere();
			if(putereP==putereQ) 
			{
				m=new Monom(putereP, coefP+coefQ); 
				i++;
				j++;
			}
			else if(putereP>putereQ)
			{
				m=new Monom(putereP, coefP);
				i++;
			}
			else
			{
				m=new Monom(putereQ, coefQ); 
				j++;
			}
			rez.addMonoame(m); 
			}
		while(i<nr_monoame_P) 
		{
			Integer coefP=this.getMonom().get(i).getCoeficient(); 
			Integer putereP=this.getMonom().get(i).getPutere();
			m=new Monom(putereP, coefP);
			i++;
			rez.addMonoame(m);
		}
		while(j<nr_monoame_Q)
		{
			Integer coefQ=Q.getMonom().get(j).getCoeficient();
			Integer putereQ=Q.getMonom().get(j).getPutere();
			m=new Monom(putereQ, coefQ);
			j++;
			rez.addMonoame(m);
		}
		return rez;
    }
    //la fel ca la adunare doar ca punem - inaintea coeficientilor din al doilea polinom pentru ca - schimba semnul
    public Polinom scadere(Polinom Q) {
    	Integer i=0; 
    	Integer j=0;
    	Polinom rez=new Polinom();
    	Monom m;
    	Integer nr_monoame_P=this.getMonom().size();
    	Integer nr_monoame_Q=Q.getMonom().size();
    	while(i<nr_monoame_P && j<nr_monoame_Q){
    		Integer coefP=this.getMonom().get(i).getCoeficient();
    		Integer coefQ=Q.getMonom().get(j).getCoeficient();
    		Integer putereP=this.getMonom().get(i).getPutere();
    		Integer putereQ=Q.getMonom().get(j).getPutere();
    		if(putereP==putereQ){
    			m=new Monom(putereQ, coefP - coefQ);
    			i++;
    			j++;
    		}
    		else if(putereP > putereQ){
    			m=new Monom(putereP, coefP);
    			i++;
    		}
    		else
    		{
    			m=new Monom(putereQ, -coefQ);
    			j++;
    		}
    		rez.addMonoame(m);	
    	}
    	while(i<nr_monoame_P){
    		Integer coefP=this.getMonom().get(i).getCoeficient();
    		Integer putereP=this.getMonom().get(i).getPutere();
    		m=new Monom(putereP, coefP);
    		i++;
    		rez.addMonoame(m);
    	}
    	while(j<nr_monoame_Q) {
    		Integer coefQ=Q.getMonom().get(j).getCoeficient();
    		Integer putereQ=Q.getMonom().get(j).getPutere();
    		m=new Monom(putereQ, -coefQ);
    		j++;
    		rez.addMonoame(m);
    	}
    	return rez;
    }
    public Polinom inmulteste(Polinom Q)
    {
    	int i=0; 
    	int j=0;
    	Monom m;
    	Polinom rez=new Polinom();
    	int nr_monoame_P=this.getMonom().size();
    	int nr_monoame_Q=Q.getMonom().size();
    	while(i<nr_monoame_P){
    		Integer coefP=this.getMonom().get(i).getCoeficient();
    		Integer putereP=this.getMonom().get(i).getPutere();
    		i++; //inmulteste fiecare element din polinomul P 
    		j=0; //cu primul element din polinomul Q , 
    		while(j<nr_monoame_Q){
    			Integer coefQ=Q.getMonom().get(j).getCoeficient();
    			Integer putereQ=Q.getMonom().get(j).getPutere();
    			m=new Monom(putereP+putereQ, coefP*coefQ);//coeficientii se inmultesc, puterile se aduna
    			rez.addMonoame(m);
    			j++;
    		}
    	}
    	return rez;
    }
    
    public Polinom derivare()
    {
    	Polinom rez=new Polinom();
    	Monom m1;
    	for(Monom m:listaMonoame){
    		Integer coef=m.getCoeficient();
    		Integer putere=m.getPutere();
    		if(putere!=0){
    			m1=new Monom(putere-1, coef*putere);
    			rez.addMonoame(m1);
    		}
    	}
    	return rez;
    }
    public Polinom integrare() {
    	Polinom rez=new Polinom();
    	for(Monom m:listaMonoame){
    	    Integer putere=m.getPutere();
    	    Double coeficient= m.GetCoefDouble();
    	    m=new Monom(putere+1, coeficient/(putere+1));
    	    rez.addMonoame(m);		
    	    	}
    	  return rez;
    }
    
    public Polinom copie() {
  	  Polinom copie = new Polinom();
  	  for(Monom m : this.getMonom()) {
  		  Monom m2 = new Monom(m.getPutere(),m.GetCoefDouble());
          copie.addMonoame(m2);
  	  }	
  	  return copie;
    }
 
    public void elimMonom(int i) {
		listaMonoame.remove(i);
	}
   
    public String imparte (Polinom p)
    {
    	Polinom cat=new Polinom();
    	Polinom copthis=new Polinom();
    	if(this.getMonom().get(0).getPutere()<p.getMonom().get(0).getPutere()) {
    		System.out.println("nu se pot imparti polin");//exceptie
    	}
    	else
    	{	
    		copthis=this.copie();
    	//	while(this.getMonom().get(0).getPutere()>=p.getMonom().get(0).getPutere()) {
    		Double coef=this.getMonom().get(0).GetCoefDouble();
        	Integer putere=this.getMonom().get(0).getPutere();
        	Double coefp=p.getMonom().get(0).GetCoefDouble();
        	Integer puterep=p.getMonom().get(0).getPutere();
        	Monom m=new Monom(putere-puterep, coef/coefp);
        	Polinom aux=new Polinom();
        	aux.addMonoame(m);
        	Polinom copie_cat=new Polinom();
        	cat.addMonoame(m);
        	copie_cat.addMonoame(m);
        	Polinom rez_mul=new Polinom();
        	rez_mul=copie_cat.inmulteste(p);
        	copthis=copthis.scadere(rez_mul);
    		}
        // }
    		return "cat: " + cat.FormarePolinomDouble() + "  rest: " + copthis.FormarePolinomDouble();
    	}
  
}
   
    
   

  


