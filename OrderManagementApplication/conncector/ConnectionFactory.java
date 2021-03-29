package connector;

import java.sql.*;
//import com.mysql.*;

@SuppressWarnings("unused")
public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/mag";
	private static final String USER = "root";
	private static final String PASS = "";
	
	private static ConnectionFactory singleInstance = new ConnectionFactory();
	
	private ConnectionFactory() 
	{
		
			try 
			{
				Class.forName(DRIVER);
			} 
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}		
	}
	
	private Connection createConnection()
	{		
		
		try
		{
			Connection con = DriverManager.getConnection(DBURL, USER, PASS);
			return con;

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		return null;		
	}
	
	public static Connection getConnection()
	{
		Connection conect = singleInstance.createConnection();
		
		if(conect != null) 
		{
			System.out.println("connected to database");
		} else
		{
			System.out.println("unconnected to database");
		}
		
		return conect;
	}
	
	public static void close(Connection conection) {
		try
		{
			conection.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Statement statem) 
	{
		try 
		{
			statem.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet res)
	{
		try 
		{
			res.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
}
