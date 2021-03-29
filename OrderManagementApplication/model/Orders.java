package model;

public class Orders {
	private Integer id;
	private Integer cantitate;
	private String nume_cl;
	private String prenume_cl;
	private String nume_produs;
	
	
	public Orders(String nume_cl,String prenume_cl,String nume_produs,Integer cantitate)
	{
				
		this.cantitate=cantitate;
		this.nume_cl=nume_cl;
		this.nume_produs=nume_produs;
		this.prenume_cl=prenume_cl;
				
	}	
	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer i)
	{
		this.id=i;
	}
	public Integer getCantitate()
	{
		return this.cantitate;
	}
	
	public void setCantitate(Integer c)
	{
		this.cantitate=c;
	}
	
	public String getCName()
	{
		return this.nume_cl;
	}
	
	public void setCName(String a)
	{
		this.nume_cl=a;
	}
	
	
	public String getPrenumeClient()
	{
		return this.prenume_cl;
	}
	
	public void set_premume_cl(String a)
	{
		this.prenume_cl=a;
	}
	
	
	
	
	public String getNumeProdus()
	{
		return this.nume_produs;
	}
	
	public void setNumeProdus(String a)
	{
		this.nume_produs=a;
	}
	
	

}
