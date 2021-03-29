package pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import connector.ConnectionFactory;

public class ReportProduct {
	public void Report(int i) throws SQLException, FileNotFoundException, DocumentException {
		Document document=new Document();
		 
		 
		PdfWriter.getInstance(document, new FileOutputStream("Report Product" + i + ".pdf"));
		 
		 document.open();
		  Connection con=ConnectionFactory.getConnection();
		  
		  PreparedStatement st=null;
		  ResultSet rs=null;
		  String sql="SELECT * from Product";
		  st=con.prepareStatement(sql);
		  rs=st.executeQuery();
		  
		  PdfPTable my_table=new PdfPTable(3);
		  PdfPCell table_cell;
		  
		  while(rs.next())
		  {
			  String dep_cantitate=rs.getString("cantitate");
			table_cell=new PdfPCell(new Phrase(dep_cantitate));
			my_table.addCell(table_cell);
			
			String dep_pret=rs.getString("pret");
			table_cell=new PdfPCell(new Phrase(dep_pret));
			my_table.addCell(table_cell);
			
			
			
			String dep_nume=rs.getString("nume");
			table_cell=new PdfPCell(new Phrase(dep_nume));
			my_table.addCell(table_cell);
			  
		  }
		 
			  
		 document.add(my_table); 
		 document.close();
		} 
		
}
