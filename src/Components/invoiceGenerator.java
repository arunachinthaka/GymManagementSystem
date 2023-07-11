/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import com.glasspanepopup.GlassPanePopup;
import com.samplemessage.Message2;

/**
 *
 * @author Aruna
 */
public class invoiceGenerator {
    Message2 msg = new Message2();
    public static String invoice(String customerName, String payDate, String nextDate, String payment, String type) {
        String invoice = (
        "----------------------------"+"\n"
        + "\t"+" INVOICE"+"\n"
        +"----------------------------"+"\n"
        +"\t"+"FITNESS GYM"+"\n"
        +"----------------------------"+"\n"
        +"Member Name : \t"+customerName+"\n"
        +"Amount : \tRs. "+payment+"\n"
        +"Package : \t"+type+"\n"        
        +"Payment Date : \t"+payDate+"\n"
        +"Next Payment : \t"+nextDate+"\n"
        +"----------------------------"+"\n"
        +"\t"+"Thank you.");
        
        System.out.println(invoice);
        return invoice;
    }
    
}
