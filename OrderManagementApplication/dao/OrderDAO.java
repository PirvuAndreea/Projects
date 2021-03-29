package dao;


import java.sql.SQLException;

import model.Orders;

public class OrderDAO extends AbstractDAO<Orders> {
	
		
public void update_order(Orders ord, int idOrd)
{
		
		try
		{
			updateObject(ord,idOrd);
		} 
		catch (IllegalArgumentException | IllegalAccessException | SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
		public void adaugaOrder(Orders ord) 
		{
				try 
				{
					insertObject(ord);
				} 
				catch (IllegalArgumentException | IllegalAccessException | SQLException e) 
				{
					e.printStackTrace();
				}
		}
		
		
		
		
}
