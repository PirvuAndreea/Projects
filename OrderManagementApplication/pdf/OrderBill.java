package pdf;

import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfWriter;

import dao.ProductDAO;
import model.Orders;
import model.Product;

public class OrderBill {
	public void Raport(Orders o, int i) throws SQLException{
		Document document = new Document();
		//String filename = "Order" +".pdf";
		Product p1 = ProductDAO.findByName(o.getNumeProdus());
		if(o.getCantitate()>p1.getCantitate().intValue())
		{
			
			
			try{
			PdfWriter.getInstance(document, new FileOutputStream("Order"+i+".pdf"));
			document.open();
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));	
			Font f1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 45);
			FontSelector selector = new FontSelector();
			selector.addFont(f1);
			Phrase title = selector.process('\n' + "Order Bill");
			Paragraph title2 = new Paragraph();
			title2.add(title);
			title2.setAlignment(Element.ALIGN_CENTER);
			document.add(title2);
			document.add(new Phrase("\n"));
			document.add(new Phrase("\n"));
		Paragraph para1=new Paragraph("Out of stock! Stock available: "+p1.getCantitate())	;
		para1.setFirstLineIndent(30);
		document.add(para1);
			}catch(Exception e){
				
			}
			document.close();
		
		}
		
		else
		{
		try{
		PdfWriter.getInstance(document, new FileOutputStream("Order"+i+".pdf"));
		document.open();
		document.add(new Phrase("\n"));
		document.add(new Phrase("\n"));
		document.add(new Phrase("\n"));
		document.add(new Phrase("\n"));
		document.add(new Phrase("\n"));
		document.add(new Phrase("\n"));
		document.add(new Phrase("\n"));
		Font f1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 45);
		FontSelector selector = new FontSelector();
		selector.addFont(f1);
		Phrase title = selector.process('\n' + "OrderBll");
		Paragraph title2 = new Paragraph();
		title2.add(title);
		title2.setAlignment(Element.ALIGN_CENTER);
		document.add(title2);
		document.add(new Phrase("\n"));
		document.add(new Phrase("\n"));
		Font f2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 18);
		FontSelector selector2 = new FontSelector();
		selector2.addFont(f2);
		Phrase details = selector2.process("Detalii: ");
		Paragraph title3 = new Paragraph();
		title3.add(details);
		document.add(title3);
		document.add(new Phrase("\n"));
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
		Paragraph odate = new Paragraph("DATA: " + timeStamp);
		document.add(odate);
		Paragraph para2 = new Paragraph("Nume: " + o.getPrenumeClient()+" "+o.getCName());
		document.add(para2);
		document.add(new Phrase("\n"));
		document.add(new Phrase("\n"));
		Phrase ordered = selector2.process("Ordered products: ");
		Paragraph title4 = new Paragraph();
		title4.add(ordered);
		document.add(title4);
		document.add(new Phrase("\n"));
		Paragraph para5 = new Paragraph(o.getNumeProdus() + " " + o.getCantitate());
		document.add(para5);
		String numeProdus=o.getNumeProdus();
		Product p = ProductDAO.findByName(numeProdus);
		Paragraph para6 = new Paragraph("Total: " + o.getCantitate()*p.getPret().doubleValue());
		para6.setAlignment(Element.ALIGN_RIGHT);
		document.add(para6);
		document.add(new Phrase("\n"));
		document.add(new Phrase("\n"));
		Paragraph exp = new Paragraph("Order expected to arrive in about 3-7 days from the date of submission. Please contact us in case of any inconvenience at the following email addres: warehouse@contact.com.");
		exp.setFirstLineIndent(50);
		document.add(exp);
		
		}catch(Exception e){
			
		}
		document.close();
	}
}
}
