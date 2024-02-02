import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.*;

public class main {
	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {

		Document obj = new Document(PageSize.A4, 20, 20, 20, 20);
		obj.addAuthor("Author");
		obj.addTitle("Title");

		PdfWriter.getInstance(obj, new FileOutputStream("E:\\github\\Hemant-Dev\\javaPdfMaker\\pdfs\\new.pdf"));

		float documentWidth = obj.getPageSize().getWidth() - obj.leftMargin() - obj.rightMargin();
		float documentHeight = obj.getPageSize().getHeight() - obj.topMargin() - obj.bottomMargin();
		File path = new File("image");
		File[] files = path.listFiles();
		Image image;

		obj.open();
		for (int file = 0; file < files.length; file++) {
			if (files[file].isFile()) {
				System.out.println(files[file]);
				image = Image.getInstance(files[file].getPath());
				image.scaleAbsolute(documentWidth, documentHeight);

				obj.add(image);
			}
		}
		obj.close();
		System.out.println("Pdf created successfully!");

		File inputFile = new File("image\\IMG_20230817_172504.jpg");
		BufferedImage inputImage = ImageIO.read(inputFile);
		Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
		ImageWriter writer = writers.next();
	
		File outputFile = new File("image\\compressed\\compressed.jpg");
		ImageOutputStream outputStream = ImageIO.createImageOutputStream(outputFile);
		writer.setOutput(outputStream);
	
		ImageWriteParam params = writer.getDefaultWriteParam();
		params.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		params.setCompressionQuality(0.5f);
	
		writer.write(null, new IIOImage(inputImage, null, null), params);		
		
		outputStream.close();
		writer.dispose();
		System.out.println("Image Compressed Successfully");
	}
}

