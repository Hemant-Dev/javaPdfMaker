import java.io.*;
import java.net.MalformedURLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.*;

public class main {
	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException{

		Document obj = new Document(PageSize.A4, 20, 20, 20, 20);
		obj.addAuthor("Author");
		obj.addTitle("Title");
		PdfWriter.getInstance(obj, new FileOutputStream("E:\\github\\Hemant-Dev\\javaPdfMaker\\new.pdf"));
     	obj.open();
     	Image image = Image.getInstance("C:\\Users\\Hemant Patel\\OneDrive\\Pictures\\God of War\\ScreenShot-2022-10-22_11-14-59.png");
		image.scaleAbsolute(100, 100);
		obj.add(image);
		obj.close();     	   	
		System.out.println("Pdf created successfully!");	
	}
}