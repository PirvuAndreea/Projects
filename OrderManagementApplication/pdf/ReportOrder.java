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

public class ReportOrder {
	public void Report(int i) throws SQLException, FileNotFoundException, DocumentException {
		Document document=new Document();
		 
		 
		PdfWriter.getInstance(document, new FileOutputStream("Report Order"+i+".pdf"));
		 
		 document.open();
		  Connection con=ConnectionFactory.getConnection();
		  
		  PreparedStatement st=null;
		  ResultSet rs=null;
		  String sql="SELECT * from Orders";
		  st=con.prepareStatement(sql);
		  rs=st.executeQuery();
		  
		  PdfPTable my_table=new PdfPTable(4);
		  PdfPCell table_cell;
		  
		  while(rs.next())
		  {
			  String dep_nume=rs.getString("nume_cl");
			table_cell=new PdfPCell(new Phrase(dep_nume));
			my_table.addCell(table_cell);
			
			String dep_prenume=rs.getString("prenume_cl");
			table_cell=new PdfPCell(new Phrase(dep_prenume));
			my_table.addCell(table_cell);
			
			
			
			String dep_numeprodus=rs.getString("nume_produs");
			table_cell=new PdfPCell(new Phrase(dep_numeprodus));
			my_table.addCell(table_cell);
			
			String dep_cantitate=rs.getString("cantitate");
			table_cell=new PdfPCell(new Phrase(dep_cantitate));
			my_table.addCell(table_cell);
			  
		  }
		 
			  
		 document.add(my_table); 
		 document.close();
		} 
		
}
