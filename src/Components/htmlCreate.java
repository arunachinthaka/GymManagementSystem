/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Aruna
 */
public class htmlCreate {
    public static String billCreate(String customerName, String payDate, String nextDate, String payment, String type){
        String htmlCode = "<html>"
                + "<head>"
                +   "<title>"+customerName+"_Invoice"+"</title>"
                +   "<style>"
                + "/* Center Alignment for Single Row */\n" +
                    ".invoice-table .center-row td {\n" +
                    "  text-align: center;\n" +
                    "}"
                + ".invoice-table {\n" +
                        "  width: 100%;\n" +
                        "  border-collapse: collapse;\n" +
                        "  font-family: Arial, sans-serif;\n" +
                        "}\n" +
                        "\n" +
                        ".invoice-table th,\n" +
                        ".invoice-table td {\n" +
                        "  padding: 10px;\n" +
                        "  text-align: left;\n" +
                        "  border-bottom: 1px solid #ddd;\n" +
                        "}\n" +
                        "\n" +
                        ".invoice-table th {\n" +
                        "  background-color: #f2f2f2;\n" +
                        "  font-weight: bold;\n" +
                        "}\n" +
                        "\n" +
                        "/* Hover Effect */\n" +
                        ".invoice-table tbody tr:hover {\n" +
                        "  background-color: #f9f9f9;\n" +
                        "  cursor: pointer;\n" +
                        "}\n" +
                        "\n" +
                        "/* Alternating Row Colors */\n" +
                        ".invoice-table tbody tr:nth-child(even) {\n" +
                        "  background-color: #f6f6f6;\n" +
                        "}\n" +
                        "\n" +
                        "/* Total Row Styling */\n" +
                        ".invoice-table .total-row {\n" +
                        "  font-weight: bold;\n" +
                        
                
                "}"
                +   "</style>"
                + "</head>"
                + "<body>"
                +   "<table class = invoice-table>"
                +       "<caption class=\"center-row\">"+"INVOICE"+"</caption>"
                +       "<tr class=\"center-row\">"
                +           "<th colspan = 2>FITNESS GYM</th>"
                +       "</tr>"
                +       "<tr>"
                +           "<td>Member Name</td>"
                +           "<td>"+customerName+"</td>"
                +       "</tr>"
                +       "<tr>"
                +           "<td>Amount</td>"
                +           "<td>"+payment+"</td>"
                +       "</tr>"
                +       "<tr>"
                +           "<td>Package</td>"
                +           "<td>"+type+"</td>"
                +       "</tr>"
                +       "<tr>"
                +           "<td>Payment Date</td>"
                +           "<td>"+payDate+"</td>"
                +       "</tr>"
                +       "<tr>"
                +           "<td>Next Pay Date</td>"
                +           "<td>"+nextDate+"</td>"
                +       "</tr>"
                +       "<tr class=\"center-row\">"
                +           "<td colspan = 2>Thank You !!!</td>"
                +       "</tr>"
                + "</table>"
                + "</body>"
                + "</html>";
        
        
        try {
            String filePath = "C:/Invoices/"+customerName+"_Invoice_.html"; // Specify the desired file path
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(htmlCode);
            writer.close();
            System.out.println("HTML file created successfully.");
        } catch (IOException e) {
            System.err.println("Error creating HTML file: " + e.getMessage());
        }
        return null;    
    }
}
