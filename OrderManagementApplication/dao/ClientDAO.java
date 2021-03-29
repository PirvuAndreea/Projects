package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector.ConnectionFactory;
import model.Client;
import model.Product;

public class ClientDAO extends AbstractDAO<Client>
{

public List<Client> get_lista_clienti() throws SQLException
{
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement prepST = null;
		ResultSet res = null;
		
		List<Client> lista_cl = new ArrayList<Client>();
		
		prepST = con.prepareStatement(createSelectAllQuery());
		res = prepST.executeQuery();
		
	   lista_cl = listaObiecte(res);
		
		close(res,prepST,con);

		return lista_cl;
	}	
	
	public void insert_client(Client c) throws SQLException
	{
		
		try 
		{
			insertObject(c);
		} 
		catch (IllegalArgumentException | IllegalAccessException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void delete_client(String nume_client,String prenume,String adresa) throws SQLException 
	{
		String numCol ="nume";
		String numCol1="prenume";
		String numCol2="adresa";
		try 
		{
			deleteObject(numCol,nume_client, numCol1,prenume, numCol2, adresa);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	   public static Client findByName(String name) throws SQLException 
	   {
				Connection connection = ConnectionFactory.getConnection();
				PreparedStatement findStatement = null;
				ResultSet rs = null; Product p = null;
				Client c=null;
				String findStatementString = "SELECT * FROM client WHERE nume = ?";
				try 
				{
					findStatement = connection.prepareStatement(findStatementString);
					findStatement.setString(2, name);
					rs = findStatement.executeQuery();
					if(rs.next()) 
					{
					String prenume=rs.getString(3);
					String nume = rs.getString(2);
					String adresa = rs.getString(1);
					c = new Client(prenume, nume, adresa);
					}
			
				} 
				finally
				{
					ConnectionFactory.close(rs);
					ConnectionFactory.close(findStatement);
					ConnectionFactory.close(connection);
				}
				return c;
			}
}
