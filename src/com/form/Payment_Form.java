package com.form;

import Components.GeneratePdf;
import Components.PaymentCalculator;
import Components.StringValidator;
import Components.htmlCreate;
import Components.invoiceGenerator;
import com.component.Form;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import com.glasspanepopup.GlassPanePopup;
import com.samplemessage.Message2;

public class Payment_Form extends Form {
    JDBC.Jdbc DB = new JDBC.Jdbc();
    Message2 msg = new Message2();

    public Payment_Form() {
        initComponents();
        calBTN.setEnabled(false);
    }
    String text;
    double payment;
    public String radioSelect(){
        ButtonGroup BG = new ButtonGroup();
        BG.add(monthlyRAD);
        BG.add(annualRAD);
        
        ActionListener listner =  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                JRadioButton radioButton = (JRadioButton) e.getSource();
                
                text = radioButton.getText();
                
            }
            
        };
        monthlyRAD.addActionListener(listner);
        annualRAD.addActionListener(listner);
        return text;
    }
    
    private void tableDataClear(){
        try {
            while (0<=statusTBL.getRowCount()){
                DefaultTableModel table = (DefaultTableModel)statusTBL.getModel();
                table.removeRow(statusTBL.getRowCount()-1);
            }
        } catch (Exception e) {
            System.out.println("Member Form tableDataClear: "+e);
        }
    }
    
    private void tableDataLoader (){
        String ID = searchTXT.getText();
        try {
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM customers WHERE name LIKE '%"+ID+"%'");   
            while (rs.next()){
                String no = String.valueOf(rs.getString("id"));
                String name = String.valueOf(rs.getString("name"));
                String address = String.valueOf(rs.getString("address"));
                String status = String.valueOf(rs.getString("status"));
                String deleted = String.valueOf(rs.getString("deleted"));
                
                if (deleted.equals("no")){
                    String table_data[] = {no, name, address, status};
                        DefaultTableModel table = (DefaultTableModel)statusTBL.getModel();
                
                        table.addRow(table_data);
                }
        }
            
        } catch (Exception e) {
            System.out.println("Error(userform tableDataLoader): "+e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchBTN = new com.samplemessage.Button();
        searchTXT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        memIdLBL = new javax.swing.JLabel();
        memNameLBL = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        monthlyRAD = new javax.swing.JRadioButton();
        annualRAD = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        dateSelectTXT = new javax.swing.JTextField();
        periodLBL = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        timePeriodLBL = new javax.swing.JLabel();
        amountLBL1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nextDateLBL = new javax.swing.JLabel();
        calBTN = new com.samplemessage.Button();
        payBTN = new Components.ButtonGradient();
        invoiceBTN = new Components.ButtonGradient();
        printCHK = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        statusTBL = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        searchBTN.setBackground(new java.awt.Color(153, 153, 255));
        searchBTN.setText("Search");
        searchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBTNActionPerformed(evt);
            }
        });

        searchTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTXTActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel2.setText("Member ID");

        memIdLBL.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        memNameLBL.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel5.setText("Member Name");

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel6.setText("Payment Type");

        monthlyRAD.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        monthlyRAD.setText("Monthly");
        monthlyRAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyRADActionPerformed(evt);
            }
        });

        annualRAD.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        annualRAD.setText("Annually");
        annualRAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annualRADActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel7.setText("Paymont Time");

        dateSelectTXT.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        periodLBL.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel8.setText("Your Pament Amout for");

        timePeriodLBL.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        amountLBL1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel9.setText("Next Payment Date");

        nextDateLBL.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        calBTN.setBackground(new java.awt.Color(153, 153, 255));
        calBTN.setText("Calculate");
        calBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBTNActionPerformed(evt);
            }
        });

        payBTN.setText("Pay");
        payBTN.setColor1(new java.awt.Color(51, 51, 255));
        payBTN.setColor2(new java.awt.Color(0, 51, 204));
        payBTN.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        payBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBTNActionPerformed(evt);
            }
        });

        invoiceBTN.setText("Print");
        invoiceBTN.setColor1(new java.awt.Color(51, 51, 255));
        invoiceBTN.setColor2(new java.awt.Color(0, 51, 204));
        invoiceBTN.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        invoiceBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceBTNActionPerformed(evt);
            }
        });

        printCHK.setText("Print Invoice when Pay");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(memIdLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timePeriodLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(monthlyRAD, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(annualRAD))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(dateSelectTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(periodLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(calBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(memNameLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(amountLBL1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nextDateLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(payBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(invoiceBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(printCHK)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(searchTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memIdLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memNameLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthlyRAD)
                    .addComponent(annualRAD))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateSelectTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(periodLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(calBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timePeriodLBL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amountLBL1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(searchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(searchTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nextDateLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(payBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invoiceBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printCHK)
                        .addContainerGap())))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        statusTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Member ID", "Member Name", "Member Address", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        statusTBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                statusTBLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(statusTBL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTXTActionPerformed

    private void searchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBTNActionPerformed
        // TODO add your handling code here:
        tableDataClear();
        tableDataLoader();
    }//GEN-LAST:event_searchBTNActionPerformed

    private void monthlyRADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyRADActionPerformed
        System.out.println(radioSelect());
        periodLBL.setText("Months");
        calBTN.setEnabled(true);
        
    }//GEN-LAST:event_monthlyRADActionPerformed

    private void annualRADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annualRADActionPerformed
        // TODO add your handling code here:
        System.out.println(radioSelect());
        periodLBL.setText("Years");
        calBTN.setEnabled(true);
        
    }//GEN-LAST:event_annualRADActionPerformed

    private void calBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBTNActionPerformed
        // TODO add your handling code here:
        String period = dateSelectTXT.getText();
        System.out.println(period);
        if(period.equals("")){
            msg.textSet("Paymont Time Can't Empty", "Month Count Error!");
            GlassPanePopup.showPopup(msg);
            System.out.println("empty");
        }else{
            if(StringValidator.hasTextAndNumbers(period)){
                msg.textSet("Paymont Time can't include letters.", "Month Count Error!");
                GlassPanePopup.showPopup(msg);
                System.out.println("letters");
            }else{
                if(!monthlyRAD.isSelected()&&!annualRAD.isSelected()){
                    System.out.println("select");
                    msg.textSet("Select a Payment Type", "Payment Type Error!");
                    GlassPanePopup.showPopup(msg);
                }else{
                    if(monthlyRAD.isSelected()){
                        LocalDate currentMonth = LocalDate.now();
                        payment = 1500*Integer.parseInt(period);
                        timePeriodLBL.setText(period+" Months.");
                        amountLBL1.setText("Rs. "+String.valueOf(payment)+" /=");
                        LocalDate nextPaymentMonth = PaymentCalculator.calculateNextPaymentMonth(currentMonth, Integer.parseInt(period));
                        nextDateLBL.setText(PaymentCalculator.formatPaymentDate(nextPaymentMonth));
                        
                    }else if(annualRAD.isSelected()){
                        payment = 10000*Integer.parseInt(period);
                        timePeriodLBL.setText(period+" Years.");
                        amountLBL1.setText("Rs. "+String.valueOf(payment)+" /=");
                        LocalDate nextPaymentYear = PaymentCalculator.calculateNextPaymentYear(Integer.parseInt(period));
                        nextDateLBL.setText(nextPaymentYear.toString());
                    }
                }
            }
        }
    }//GEN-LAST:event_calBTNActionPerformed

    private void statusTBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statusTBLMouseClicked
        // TODO add your handling code here:
        
        statusTBL.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = statusTBL.getSelectedRow();
                calBTN.setEnabled(true);
                String cellData = statusTBL.getValueAt(row, 0).toString();
                
                try {
                    java.sql.ResultSet rs = DB.getdata("SELECT * FROM customers WHERE id = '"+cellData+"'");
                    while(rs.next()){
                        String id = String.valueOf(rs.getString("id"));
                        String name = String.valueOf(rs.getString("name"));
                        String jDate = String.valueOf(rs.getString("join_date"));
                       
                        
                        memIdLBL.setText(id);
                        memNameLBL.setText(name);
                        
                        
                        
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Payment_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }//GEN-LAST:event_statusTBLMouseClicked

    private void payBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBTNActionPerformed
        String customerId = memIdLBL.getText();
        String customerName = memNameLBL.getText();
        String customerPayment = String.valueOf(payment);
        String currentDate = LocalDate.now().toString();
        String nextPaymentDate = nextDateLBL.getText();
        String paymentType = radioSelect();
        System.out.println(paymentType);
        
        
        if (printCHK.isSelected()){
            if(customerId.equals("")){
                msg.textSet("Please Select a Member First !!", "Member not Selected");
                GlassPanePopup.showPopup(msg);
            }else{
                if(customerId.equals("")){
                    msg.textSet("Please Select a Member First !!", "Member not Selected");
                    GlassPanePopup.showPopup(msg);
                }else{
                    if(customerPayment.equals("")){
                        msg.textSet("Calculate Payment", "Calculate Payment");
                        GlassPanePopup.showPopup(msg);
                    }else{
                        if(nextPaymentDate.equals("")){
                            msg.textSet("Calculate Payment", "Calculate Payment");
                            GlassPanePopup.showPopup(msg);
                        }else{
                            try {
                                DB.putdata("INSERT INTO payments (customer_id, amount, date_paid, next_paid, payment_type) VALUES('"+customerId+"', '"+customerPayment+"', '"+currentDate+"', '"+nextPaymentDate+"', '"+paymentType+"')");
                                DB.putdata("UPDATE customers SET status = 'Active' WHERE id = '"+customerId+"'");
                            } catch (Exception e) {
                                 Logger.getLogger(Payment_Form.class.getName()).log(Level.SEVERE, null, e);
                            }
                            
                        }
                    }
                }
            
            }
            String invoice = invoiceGenerator.invoice(customerName, currentDate, nextPaymentDate, customerPayment, paymentType);
            msg.textSet(invoice, "Invoice");
            GlassPanePopup.showPopup(msg);
            GeneratePdf.pdfGenerstor(invoice, customerName);
        }else{
           try {
            if(customerId.equals("")){
                msg.textSet("Please Select a Member First !!", "Member not Selected");
                GlassPanePopup.showPopup(msg);
            }else{
                if(customerName.equals("")){
                    msg.textSet("Please Select a Member First !!", "Member not Selected");
                    GlassPanePopup.showPopup(msg);
                }else{
                    if(customerPayment.equals("")){
                        msg.textSet("Calculate Payment", "Calculate Payment");
                        GlassPanePopup.showPopup(msg);
                    }else{
                        if(nextPaymentDate.equals("")){
                            msg.textSet("Calculate Payment", "Calculate Payment");
                            GlassPanePopup.showPopup(msg);
                        }else{
                            DB.putdata("INSERT INTO payments (customer_id, amount, date_paid, next_paid, payment_type) VALUES('"+customerId+"', '"+customerPayment+"', '"+currentDate+"', '"+nextPaymentDate+"', '"+paymentType+"')");
                            DB.putdata("UPDATE customers SET status = 'Active' WHERE id = '"+customerId+"'");
                            msg.textSet("Payment Success", "Success");
                            GlassPanePopup.showPopup(msg);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Payment_Form.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
        
    }//GEN-LAST:event_payBTNActionPerformed

    private void invoiceBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceBTNActionPerformed
        // TODO add your handling code here:
        String customerId = memIdLBL.getText();
        String customerName = memNameLBL.getText();
        String customerPayment = String.valueOf(payment);
        String currentDate = LocalDate.now().toString();
        String nextPaymentDate = nextDateLBL.getText();
        String paymentType = radioSelect();
        
        if(customerId.equals("")){
            msg.textSet("Please Select a Member First", "Select a Member");
            GlassPanePopup.showPopup(msg);
        }else{
            if (!monthlyRAD.isSelected()&&!annualRAD.isSelected()){
                msg.textSet("Please Select a Payment Type", "Select a Payment Type");
                GlassPanePopup.showPopup(msg);
            }else{
                if(nextPaymentDate.equals("")){
                    msg.textSet("Please Select a Payment Time", "Select a Payment Time");
                    GlassPanePopup.showPopup(msg);
                }else{
                   String invoice = invoiceGenerator.invoice(customerName, currentDate, nextPaymentDate, customerPayment, paymentType);
                   String bill = htmlCreate.billCreate(customerName, currentDate, nextPaymentDate, customerPayment, paymentType);
                   System.out.println(bill);
                   msg.textSet(invoice, "Invoice");
                   GlassPanePopup.showPopup(msg);
                   GeneratePdf.pdfGenerstor(invoice, customerName);
                }
            }
        }
        
    }//GEN-LAST:event_invoiceBTNActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountLBL1;
    private javax.swing.JRadioButton annualRAD;
    private com.samplemessage.Button calBTN;
    private javax.swing.JTextField dateSelectTXT;
    private Components.ButtonGradient invoiceBTN;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel memIdLBL;
    private javax.swing.JLabel memNameLBL;
    private javax.swing.JRadioButton monthlyRAD;
    private javax.swing.JLabel nextDateLBL;
    private Components.ButtonGradient payBTN;
    private javax.swing.JLabel periodLBL;
    private javax.swing.JCheckBox printCHK;
    private com.samplemessage.Button searchBTN;
    private javax.swing.JTextField searchTXT;
    private javax.swing.JTable statusTBL;
    private javax.swing.JLabel timePeriodLBL;
    // End of variables declaration//GEN-END:variables
}
