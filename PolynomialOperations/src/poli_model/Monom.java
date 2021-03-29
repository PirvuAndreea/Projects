package poli_model;

public class Monom {
	Number coeficient;
	Number putere;
	public Monom(Number putere, Number coeficient){
		this.putere=putere;
		this.coeficient=coeficient;
	}
	public Integer getCoeficient() {
		return this.coeficient.intValue();
	}
	public Integer getPutere()
	{
		return this.putere.intValue();
	}
	public void setCoeficient(Integer c)
	{
		this.coeficient=c;
	}
	public void setPutere(Integer p)
	{
		this.putere=p;
	}
	public Double GetCoefDouble() {
		return this.coeficient.doubleValue();
	}
	public void setCoeficientDouble(double c)
	{
		this.coeficient=c;
	}
	
public Monom setMonom(String s) {
		
		Monom monom;
		if(s.startsWith("x")||s.startsWith("+x")){
			if(s.endsWith("x")) {
				monom=new Monom(1,1) ;
			}
			 else 
			{
			monom= new Monom(Integer.parseInt(s.substring(s.indexOf("^")+1)),1);
		    }
		}
		else if(s.startsWith("-x")) {				
			if( s.endsWith("x"))
				{
				monom= new Monom(-1,1);
				}
			else
			{
			monom=new Monom(Integer.parseInt(s.substring(s.indexOf("^")+1)),-1);	
			}
		}
		else if(s.equals("0")) {
				 monom = new Monom(0,0);
			}
		else if(!s.contains("x")) {
			 monom = new Monom(0,Integer.parseInt(s));
		}
		else if(s.contains("x") && s.endsWith("x")){
			 monom = new Monom(1,Integer.parseInt( s.substring(0, s.indexOf("x"))));
		}
		else {
			monom = new Monom(Integer.parseInt(s.substring(s.indexOf("^")+1, s.length())),Integer.parseInt(s.substring(0,s.indexOf("x"))));	
		}
		return  monom;
	}	
}

