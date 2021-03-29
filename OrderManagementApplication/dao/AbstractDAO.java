
package dao;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connector.ConnectionFactory;

public class AbstractDAO<T> 
{
	
	private final Class<T> type;
	
	@SuppressWarnings("rawtypes")
	public Class getType()
	{
		return type;
	}
	public void close(ResultSet res, PreparedStatement prepSt,Connection con) 
	{
		ConnectionFactory.close(res);
		ConnectionFactory.close(prepSt);
		ConnectionFactory.close(con);	
	}
	
	@SuppressWarnings("unchecked")	
	public AbstractDAO() 
	{
		this.type = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public String createSelectAllQuery() 
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT * FROM ");
		sb.append(type.getSimpleName());
		
		return sb.toString();
	}		
	
	
	public String createUpdateQuery(Object obj,int id) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder sb = new StringBuilder();		
		sb.append("UPDATE " + type.getSimpleName() + " SET ");
		int i = 0,j=0;
		String fieldName = null;
		
		for(Field field: obj.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object value;
			if (i==0) { 
				fieldName= field.getName();
				i = 1; continue;
			}
			value = field.get(obj);
			
			System.out.println(value);
			
			if((++j) == obj.getClass().getDeclaredFields().length-1) {
				sb.append(field.getName()+"=");
				if(value instanceof Number) {
					sb.append(value);
				}
				else if(value instanceof String) {
				sb.append("'"+value+"'");
				}
			}
			else
			{
				sb.append(field.getName()+"=");
				if(value instanceof Number) 
				{
					sb.append(value+",");
				}
				else if(value instanceof String) 
				{
				sb.append("'"+value+"',");
				}
			}				
		}
		sb.append(" WHERE "+ fieldName + "="+id);
		return sb.toString();
	}
	
	public String createInsertQuery(String field, String values)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT into ");
		sb.append(type.getSimpleName());
		sb.append("("+field+")");
		sb.append("values("+values+")");
		
		return sb.toString();	
	}

	public String createDeleteQuery(String field)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("DELETE FROM ");
		sb.append(type.getSimpleName()+" WHERE ");
		sb.append(field + "=?");
		
		return sb.toString();
	}
	public String createDeleteQuery1(String field, String field1, String field2)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("DELETE FROM ");
		sb.append(type.getSimpleName()+" WHERE ");
		sb.append(field + "=? and ");
		sb.append(field1 + "=? and ");
		sb.append(field2 + "=? ");
		
		return sb.toString();
	}
	
	public static String retrieveValues(Object obj) throws IllegalArgumentException, IllegalAccessException {
		
		StringBuilder values = new StringBuilder(); 
		int j = 0;
		
		for(Field field: obj.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object value;
			
			value = field.get(obj);		
			
			if((++j) == obj.getClass().getDeclaredFields().length) {
				if(value instanceof Number) {
					values.append(value);
				}
				else if(value instanceof String) {
				values.append(value+" ");
				}
			}else {
				if(value instanceof Number) {
					values.append(value+",");
				}
				else if(value instanceof String) {
				values.append(value+",");
				}
			}			
		}		
		
		return values.toString();
	}
	
	
	public static List<String> retrieveProperties(Object obj) throws IllegalArgumentException, IllegalAccessException {		
		List<String> fieldValues = new ArrayList<String>();		
		StringBuilder values = new StringBuilder(); 
		StringBuilder fields = new StringBuilder();
		int i = 0,j = 0;
		
		for(Field field: obj.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object value;
			if (i==0) { //System.out.println("///"+field.get(obj));
				i= 1; continue;}			
			
			if((++j) == obj.getClass().getDeclaredFields().length-1) {
				fields.append(field.getName()+" ");
			}
			else {
				fields.append(field.getName()+",");
			}			
			value = field.get(obj);		
			
			if(j == obj.getClass().getDeclaredFields().length-1) {
				if(value instanceof Number) {
					values.append(value);
				}
				else if(value instanceof String) {
				values.append("'"+value+"'");
				}
			}else {
				if(value instanceof Number) {
					values.append(value+",");
				}
				else if(value instanceof String) {
				values.append("'"+value+"',");
				}
			}			
		}		
		fieldValues.add(fields.toString());
		
		System.out.println(fieldValues.get(0));
		fieldValues.add(values.toString());
		
		return fieldValues;
	}

	
	public void insertObject(Object o) throws SQLException, IllegalArgumentException, IllegalAccessException {
		
		List<String> fieldValues = new ArrayList<String>();
		fieldValues = retrieveProperties(o);
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement prepST = null;
						
		prepST = con.prepareStatement(createInsertQuery(fieldValues.get(0),fieldValues.get(1)));
		
		 prepST.executeUpdate();
		
		ConnectionFactory.close(prepST);
		ConnectionFactory.close(con);
	}
	
	
	public void updateObject(Object o,int id) throws IllegalArgumentException, IllegalAccessException, SQLException {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement prepST = null;
						
		prepST = con.prepareStatement(createUpdateQuery(o,id));
		
		 prepST.executeUpdate();
		
		ConnectionFactory.close(prepST);
		ConnectionFactory.close(con);
		
	}
	public void deleteObject1(String field, Object numeId) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement prepST = null;
		
		prepST = con.prepareStatement(createDeleteQuery(field));
		prepST.setObject(1, numeId);
       
		prepST.executeUpdate();
		
		ConnectionFactory.close(prepST);
		ConnectionFactory.close(con);
	}
	
	
	public void deleteObject(String field, Object numeId, String field1, Object n2,String field2, Object n3) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement prepST = null;
		prepST = con.prepareStatement(createDeleteQuery1(field,field1,field2));
		prepST.setObject(1, numeId);
		prepST.setObject(2, n2);
		prepST.setObject(3, n3);
       
		prepST.executeUpdate();
		
		ConnectionFactory.close(prepST);
		ConnectionFactory.close(con);

	}
	
	public List<T> listaObiecte(ResultSet res){
		List<T> lista = new ArrayList<T>();
		
		try {
			while(res.next()) {
				T instance = type.newInstance();
				
				for(Field field: type.getDeclaredFields()) {
					Object value = res.getObject(field.getName());
					PropertyDescriptor propDesc = new PropertyDescriptor(field.getName(),type);
					Method met = propDesc.getWriteMethod();
					met.invoke(instance,value);
				}
				lista.add(instance);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
		return lista;
	}
	
	public List<T> getListaObiecte()
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement prepST = null;
		ResultSet res = null;
		
		List<T> listaObj = new ArrayList<>();
		
		try {
			prepST = con.prepareStatement(createSelectAllQuery());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			res = prepST.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		listaObj = listaObiecte(res);
		
		close(res,prepST,con);
		return listaObj;
	
	}

	public Number valoare (ResultSet res,String field){
		Number instance = null;
		try {
			while(res.next()) {
				Object value = res.getObject(field);
				instance = (Number) value;				
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} 		
		return instance;
	}
	
	public String valoare2 (ResultSet res,String field){
		String instance = null;
		try {
			while(res.next()) {
				Object value = res.getObject(field);
				instance = (String) value;				
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} 		
		return instance;
	}
}