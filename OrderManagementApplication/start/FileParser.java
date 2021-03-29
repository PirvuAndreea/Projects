package start;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;


import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Client;
import model.Orders;
import model.Product;
import pdf.OrderBill;
import pdf.ReportClient;
import pdf.ReportOrder;
import pdf.ReportProduct;

public class FileParser {
	public FileParser() {
		
	}

public void readFromFile(Scanner scanner, String filename)throws FileNotFoundException, SQLException, DocumentException{
	String[] line,name,nameSplit;
	String firstName,addr,productName,last_name;
	Integer client_ord,pret;
	double price;
	int cantitate;
	int index=1;
	int index1=1;
	int index2=1;
	int index3=1;
	Client c;
	Product p;
	Orders o;
	Integer clientId=0;
	Integer productId=0;
	Integer ordId=0;
	File file = new File(filename);
	scanner = new Scanner(file);
	
	while(scanner.hasNextLine()) 
	{
	line=scanner.nextLine().split(":");
	if(line[0].equals("Insert client")) {
		name=line[1].split(",");
	    addr=name[1];
		nameSplit=name[0].split(" ");
		firstName=nameSplit[1];
		last_name=nameSplit[0];
		ClientDAO cl = new ClientDAO();
		c = new Client(addr,last_name,firstName);
		cl.insert_client(c);
		
	}
	
	if(line[0].equals("Insert product")) {
		name=line[1].split(",");
		productName=name[0];
		productId++;
		cantitate=Integer.parseInt(name[1]);
		price=Double.parseDouble(name[2]);	
		p = new Product(cantitate,price,productName);
		ProductDAO pe=new ProductDAO();
		pe.insertProductDAO(p);	
	}
	if(line[0].equals("Delete client")) {
		name=line[1].split(",");
	    addr=name[1];
		nameSplit=name[0].split(" ");
		firstName=nameSplit[1];
		last_name=nameSplit[0];
		ClientDAO cl=new ClientDAO();
		cl.delete_client(last_name, firstName, addr);
	}
	
	if(line[0].equals("Delete Product")) {
		name=line[1].split(",");
		productName=name[0];
		ProductDAO pd=new ProductDAO();
		pd.deleteProduct(productName);
	}
	
	
	if(line[0].equals("Order")) {
		name=line[1].split(",");
		productName=name[1];
		nameSplit=name[0].split(" ");
		firstName=nameSplit[1];
		last_name=nameSplit[0];
	    cantitate=Integer.parseInt(name[2]);
	    o=new Orders(firstName,last_name, productName,cantitate);
	    OrderDAO ord=new OrderDAO();
	    ord.adaugaOrder(o);
	   OrderBill rp= new OrderBill();
	    rp.Raport(o,index);
	    index++;
		}
	
	  if(line[0].equals("Report client"))
	    {
		  ReportClient rp=new ReportClient();
		  rp.Report(index1);
		  index1++;
		
	    }
	  if(line[0].equals("Report order"))
		{
			  ReportOrder ro=new ReportOrder();
			  ro.Report(index2);
			  index2++;
			
		}
	  if(line[0].equals("Report product"))
		{
		  ReportProduct ro=new ReportProduct();
		  ro.Report(index3);
		  index3++;
		}
	
	}
	
}
}




