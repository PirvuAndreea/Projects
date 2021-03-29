package model;

public class Client {
	private int id;
	private String adresa;
	private String nume;
	private String prenume;
	
	public Client(String adresa,String nume, String prenume)
	{
		this.adresa=adresa;
		this.nume=nume;
		this.prenume=prenume;
	}
	
	public Client(int id,String adresa,String nume, String prenume)
	{
		this.id=id;
		this.adresa=adresa;
		this.nume=nume;
		this.prenume=prenume;
	}
	
	public int getId()
	{
		return this.id;
		
	}
	public void setId(int idd)
	{
		this.id=idd;
	}
	
	public String getAdress()
	{
		return this.adresa;
		
	}
	
	public void setAdress(String adr)
	{
		
		this.adresa=adr;
	}
	
	public String getNume()
	{
		return this.nume;
	}
	
	public void setNume(String n)
	{
		this.nume=n;
		
	}
	public void setPrenume(String p)
	{
		
		this.prenume=p;
	}
	
	public String getPrenume()
	{
		
		return this.prenume;
	}

}
