package model;

public class Product {
	private Number id;
	private Number cantitate;
	private Number pret;
	private String nume;
	
	public Product (Number id,Number cantitate,Number pret,String nume)
	{
		this.id=id;
		this.cantitate=cantitate;
		this.pret=pret;
		this.nume=nume;
	}
	
	public Product (Number cantitate,Number pret,String nume)
	{
		
		this.cantitate=cantitate;
		this.pret=pret;
		this.nume=nume;
	}
	
	
	public Number getId() {
		return this.id;
	}
	
	public void setId(int i)
	{
		this.id=i;
	}
	
	public Number getCantitate()
	{
		return this.cantitate;
	}
	
	public void setCantitate(int c)
	{
		this.cantitate=c;
	}
	
	public Number getPret()
	{
		return this.pret;
	}
	
	public void setPret(double p)
	{
		this.pret=p;
	}
	
	public void setNume(String n)
	{
		this.nume=n;
		
	}
	
	public String getNume()
	{
		return this.nume;
	}
}

