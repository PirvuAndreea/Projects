package pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import connector.ConnectionFactory;
public class ReportClient {
 
	public void Report(int i) throws SQLException, FileNotFoundException, DocumentException {
		Document document=new Document();
		 
		 
		PdfWriter.getInstance(document, new FileOutputStream("Report Client"+i+".pdf"));
		 
		 document.open();
		  Connection con=ConnectionFactory.getConnection();
		  
		  PreparedStatement st=null;
		  ResultSet rs=null;
		  String sql="SELECT * from Client";
		  st=con.prepareStatement(sql);
		  rs=st.executeQuery();
		  
		  PdfPTable my_table=new PdfPTable(3);
		  PdfPCell table_cell;
		  
		  while(rs.next())
		  {
			  String dep_nume=rs.getString("nume");
			table_cell=new PdfPCell(new Phrase(dep_nume));
			my_table.addCell(table_cell);
			
			String dep_prenume=rs.getString("prenume");
			table_cell=new PdfPCell(new Phrase(dep_prenume));
			my_table.addCell(table_cell);
			
			
			
			String dep_adress=rs.getString("adresa");
			table_cell=new PdfPCell(new Phrase(dep_adress));
			my_table.addCell(table_cell);
			  
		  }
		 
			  
		 document.add(my_table); 
		 document.close();
		} 
		
		
}

	
	
	

	
