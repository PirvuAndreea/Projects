package tema2;

public class Client {
	private int id;
	private int arrivet;
	private int servicet;
	private int waitingt;
	public Client(int id, int arrivet, int waitingt)
	{
		this.id=id;
		this.arrivet=arrivet;
		this.waitingt=waitingt;
	}
	public int getID()
	{
		return this.id;	
	}
	public int getArrivet()
	{
		return this.arrivet;
	}
	public int getServicet()
	{
		return this.servicet;
	}
	public void setArrivet(int at) {
		
		this.arrivet=at;
	}
	public void setServicet(int st)
	{
		this.servicet=st;
	}
	public int getWaitingt() {
        return this.waitingt;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public void setArrivalt(int at) {
        this.arrivet = at;
    }

    public void setWaitingTime(int wat) {
        this.waitingt = wat;
    }
	
}
