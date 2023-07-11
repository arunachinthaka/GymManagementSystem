/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

/**
 *
 * @author Aruna
 */
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdf  
{
    public static void pdfGenerstor(String message, String customerName){
        //created PDF document instance   
            Document doc = new Document();  
            try  
            {  
            //generate a PDF at the specified location  
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Invoices\\"+customerName+" Invoice.pdf"));  
            System.out.println("PDF created.");  
            //opens the PDF  
            doc.open();  
            //adds paragraph to the PDF file  
            doc.add(new Paragraph(message));   
            //close the PDF file  
            doc.close();  
            //closes the writer  
            writer.close();  
            }   
            catch (DocumentException e)  
            {  
            e.printStackTrace();  
            }   
            catch (FileNotFoundException e)  
            {  
            e.printStackTrace();  
            }
    }
    
    
public static void main(String args[])  
{  
  
}  
}  
