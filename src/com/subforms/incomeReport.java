/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.subforms;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.glasspanepopup.GlassPanePopup;
import com.samplemessage.Message2;



/**
 *
 * @author Aruna
 */

public class incomeReport extends javax.swing.JFrame {

    /**
     * Creates new form incomeReport
     */
    JDBC.Jdbc DB = new JDBC.Jdbc();
    Message2 msg = new Message2();
    String cusid;
    String amount;
    String datePaid;
    String plan;
    public incomeReport() {
        initComponents();
        formDateTXT.setText("");
        toDateTXT.setText("");
        formDateTXT.setEditable(false);
        toDateTXT.setEditable(false);
        GlassPanePopup.install(this);
    }

    private void tableDataLoader(String fd, String td){
        try {      
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM payments WHERE date_paid BETWEEN '"+formDateTXT.getText()+"' AND '"+toDateTXT.getText()+"'");
                    while(rs.next()){
                        cusid = String.valueOf(rs.getString("customer_id"));
                        amount = String.valueOf(rs.getString("amount"));
                        datePaid = String.valueOf(rs.getString("date_paid"));
                        plan = String.valueOf(rs.getString("payment_type"));
                        System.out.println("Cus ID"+cusid);
                        System.out.println("amount"+amount);
                        System.out.println("datepaid"+datePaid);
                        System.out.println("plan"+plan);
                        
                        java.sql.ResultSet rs2 = DB.getdata("SELECT * FROM customers WHERE id = '"+cusid+"'");
                        while(rs2.next()){
                            String cusName = String.valueOf(rs2.getString("name"));
                            String status = String.valueOf(rs2.getString("deleted"));
                            System.out.println("Cus Name"+cusName);
                            System.out.println("Status"+status);
                            
                            if(status.equals("no")){
                                String table_data[] = {cusName, amount, datePaid, plan};
                                DefaultTableModel table = (DefaultTableModel)incomeTBL.getModel();
                                table.addRow(table_data);
                            }
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(incomeReport.class.getName()).log(Level.SEVERE, null, ex);
                }  
    }
    
    private void tableDataClear(){
        try {
            while (0<=incomeTBL.getRowCount()){
                DefaultTableModel table = (DefaultTableModel)incomeTBL.getModel();
                table.removeRow(incomeTBL.getRowCount()-1);
            }
        } catch (Exception e) {
            System.out.println("Member Form tableDataClear: "+e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fromDate = new com.datechooser.DateChooser();
        toDate = new com.datechooser.DateChooser();
        toDateTXT = new javax.swing.JTextField();
        formDateTXT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        findBTN = new com.samplemessage.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        incomeTBL = new javax.swing.JTable();
        printReportBTN = new com.samplemessage.Button();
        jLabel2 = new javax.swing.JLabel();

        fromDate.setForeground(new java.awt.Color(153, 153, 255));
        fromDate.setDateFormat("yyyy-MM-dd");
        fromDate.setTextRefernce(formDateTXT);

        toDate.setForeground(new java.awt.Color(153, 153, 255));
        toDate.setDateFormat("yyyy-MM-dd");
        toDate.setTextRefernce(toDateTXT);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Income Report");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        toDateTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toDateTXTActionPerformed(evt);
            }
        });
        getContentPane().add(toDateTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 170, 40));

        formDateTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formDateTXTActionPerformed(evt);
            }
        });
        getContentPane().add(formDateTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 170, 40));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("to");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 40, -1));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("From");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 40, -1));

        findBTN.setBackground(new java.awt.Color(51, 51, 255));
        findBTN.setForeground(new java.awt.Color(255, 255, 255));
        findBTN.setText("Find");
        findBTN.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        findBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findBTNActionPerformed(evt);
            }
        });
        getContentPane().add(findBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 80, -1));

        incomeTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Amount", "Date Paid", "Payment Plan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(incomeTBL);
        if (incomeTBL.getColumnModel().getColumnCount() > 0) {
            incomeTBL.getColumnModel().getColumn(1).setResizable(false);
            incomeTBL.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 780, 320));

        printReportBTN.setBackground(new java.awt.Color(102, 204, 0));
        printReportBTN.setForeground(new java.awt.Color(255, 255, 255));
        printReportBTN.setText("Print Report");
        printReportBTN.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        printReportBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printReportBTNActionPerformed(evt);
            }
        });
        getContentPane().add(printReportBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 200, 100, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/incomeReport.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void toDateTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDateTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toDateTXTActionPerformed

    private void formDateTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formDateTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formDateTXTActionPerformed

    private void findBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findBTNActionPerformed
        // TODO add your handling code here:
        
        if(formDateTXT.getText().equals("")||toDateTXT.getText().equals("")){
            System.out.println("can't empty");
            msg.textSet("Select Dates", "Date Error");
            GlassPanePopup.showPopup(msg);
        }else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fromDate = LocalDate.parse(formDateTXT.getText(), formatter);
            LocalDate toDate = LocalDate.parse(toDateTXT.getText(), formatter);
            LocalDate nowDate = LocalDate.now();
        
            if (fromDate.isAfter(toDate)) {
                tableDataClear();
                tableDataLoader(formDateTXT.getText(), toDateTXT.getText());  
                System.out.println("1");
            }else if(fromDate.isBefore(toDate)){
                tableDataClear();
                tableDataLoader(formDateTXT.getText(), toDateTXT.getText());
                System.out.println("2");
            }
            else {
                System.out.println("date1 and date2 are equal");
                msg.textSet("Dates are same", "Date");
                GlassPanePopup.showPopup(msg);
            }
        }
    }//GEN-LAST:event_findBTNActionPerformed

    private void printReportBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printReportBTNActionPerformed
        if(formDateTXT.getText().equals("")||toDateTXT.getText().equals("")){
            System.out.println("can't empty");
            msg.textSet("Select Dates", "Date Error");
            GlassPanePopup.showPopup(msg);
        }else{
        try {
            // TODO add your handling code here:
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM payments WHERE date_paid BETWEEN '"+formDateTXT.getText()+"' AND '"+toDateTXT.getText()+"'");
            StringBuilder htmlTable = new StringBuilder();
            
                htmlTable.append("<head>");
                htmlTable.append("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">");
                htmlTable.append("</head>");
                htmlTable.append("<caption>"+"Income Report"+"</caption>");
                htmlTable.append("<table class=\"table\">");
                htmlTable.append("<thead class=\"thead-dark\">");

                // Create table headers
                htmlTable.append("<tr>");
                htmlTable.append("<th>Name</th>");
                htmlTable.append("<th>Amount</th>");
                htmlTable.append("<th>Date Paid</th>");
                htmlTable.append("<th>Payment Plan</th>");
                htmlTable.append("</tr>");
                htmlTable.append("</thead>");
                htmlTable.append("<tbody>");
                
                while(rs.next()){
                    cusid = String.valueOf(rs.getString("customer_id"));
                    amount = String.valueOf(rs.getString("amount"));
                    datePaid = String.valueOf(rs.getString("date_paid"));
                    plan = String.valueOf(rs.getString("payment_type"));
                    
                    java.sql.ResultSet rs2 = DB.getdata("SELECT * FROM customers WHERE id = '"+cusid+"'");
                        while(rs2.next()){
                            String cusName = String.valueOf(rs2.getString("name"));
                            String status = String.valueOf(rs2.getString("deleted"));
                            
                            if(status.equals("no")){
                                  htmlTable.append("<tr>");
                                  htmlTable.append("<td>").append(cusName).append("</td>");
                                  htmlTable.append("<td>").append(amount).append("</td>");
                                  htmlTable.append("<td>").append(datePaid).append("</td>");
                                  htmlTable.append("<td>").append(plan).append("</td>");
                                  htmlTable.append("</tr>");
                            }
                        }
                }
                htmlTable.append("</tbody>");
                htmlTable.append("</table>");
                String fileName = "Income_Report_"+formDateTXT.getText()+"_to_"+toDateTXT.getText()+"_.html";
                
                try (FileWriter fileWriter = new FileWriter(fileName)) {
                    fileWriter.write(htmlTable.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("HTML table saved to " + fileName);
                msg.textSet("Report Printed : \n"+fileName, "Printed");
                GlassPanePopup.showPopup(msg);
                

                
        } catch (Exception  ex) {
            Logger.getLogger(incomeReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printReportBTNActionPerformed
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(incomeReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(incomeReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(incomeReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(incomeReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new incomeReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.samplemessage.Button findBTN;
    private javax.swing.JTextField formDateTXT;
    private com.datechooser.DateChooser fromDate;
    private javax.swing.JTable incomeTBL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.samplemessage.Button printReportBTN;
    private com.datechooser.DateChooser toDate;
    private javax.swing.JTextField toDateTXT;
    // End of variables declaration//GEN-END:variables

    private void append(String td) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
