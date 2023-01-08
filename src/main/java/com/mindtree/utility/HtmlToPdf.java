package com.mindtree.utility;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.mindtree.reusuablecomponents.AllObjects;
import com.mindtree.reusuablecomponents.Report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class HtmlToPdf extends AllObjects{
	

  
    /**
     * Html to pdf conversion example.
     * @param file
     * @throws IOException
     * @throws DocumentException
     */
    public void createPdf(String file) throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        // step 3
        document.open();
        // step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new FileInputStream(System.getProperty("user.dir")+propertyFiledata.takeDataFromProperty().getProperty("HTML")));
        // step 5
        document.close();
    }

    public void pdf() throws IOException, DocumentException {
		File file = new File(System.getProperty("user.dir")+propertyFiledata.takeDataFromProperty().getProperty("DEST")+Report.da+propertyFiledata.takeDataFromProperty().getProperty("DEST2"));
        file.getParentFile().mkdirs();
        new HtmlToPdf().createPdf(System.getProperty("user.dir")+propertyFiledata.takeDataFromProperty().getProperty("DEST")+Report.da+propertyFiledata.takeDataFromProperty().getProperty("DEST2"));
	}
 
}