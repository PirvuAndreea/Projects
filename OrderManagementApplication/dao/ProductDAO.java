package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector.ConnectionFactory;
import model.Product;

public class ProductDAO extends AbstractDAO<Product> 
{
	
	public List<Product> getListaProduseDAO() throws SQLException
	{
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement prepST = null;
		ResultSet res = null;
		List<Product> prodList = new ArrayList<Product>();
		prepST = con.prepareStatement(createSelectAllQuery());
		res = prepST.executeQuery();
		prodList = listaObiecte(res);
		close(res,prepST,con);
		return prodList;
	}
	
   public void insertProductDAO(Product p) throws SQLException 
   {
		
		try 
		{
			insertObject(p);
		} 
		catch (IllegalArgumentException | IllegalAccessException e)
		{
			e.printStackTrace();
		}		
	}
   

   public void deleteProduct(String numeProdus) 
   {
	   String fieldName = "nume";
	   
	   try {
		deleteObject1(fieldName,numeProdus);
	} catch (SQLException e) {
		e.printStackTrace();
	}
   }
   
   public static Product findByName(String name) throws SQLException 
   {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null; Product p = null;
		String findStatementString = "SELECT * FROM Product WHERE nume = ?";
		try
		{
			findStatement = connection.prepareStatement(findStatementString);
			findStatement.setString(1, name);
			rs = findStatement.executeQuery();
			if(rs.next())
			{
				String name2 = rs.getString(3);
				//System.out.println(name2);
				int amount = rs.getInt(1);
				double price = rs.getDouble(2);
				p = new Product( amount, price, name2);
				
			}
			
	
		} 
		finally
		{
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(connection);
		}
		return p;
	}

   
}
