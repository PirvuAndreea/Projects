package start;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import com.itextpdf.text.DocumentException;


import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Client;
import model.Orders;
import model.Product;
import pdf.ReportClient;
import pdf.ReportOrder;
import pdf.ReportProduct;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, SQLException, DocumentException {
		File readFile = new File(args[0]);
		FileParser fp=new FileParser();
		Scanner scanner=new Scanner(readFile);
		fp.readFromFile(scanner,args[0]);
	
	}
}


