package com.form;

import Components.datePicker;
import Components.phoneAndMailValidate;
import com.component.Form;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.SimpleDoc;
import javax.swing.table.DefaultTableModel;
import com.passwordprotect.PasswordEncryption;
import com.glasspanepopup.GlassPanePopup;
import com.samplemessage.Message;
import com.samplemessage.Message2;

public class Member_Form extends Form {

    JDBC.Jdbc DB = new JDBC.Jdbc();
    Message2 msg = new Message2();
    Message msg2 = new Message();
    boolean req;
    String cellData;
    String schName;
    phoneAndMailValidate validate = new phoneAndMailValidate();
    
    public Member_Form() {
        initComponents();
        tableDataClear();
        tableDataLoader();
        updateBTN.setEnabled(false);
        deleteBTN.setEnabled(false);
        scheduleLoader();
    }
    
    private void scheduleLoader(){
        scheduleCOM.addItem("Select");
        try {
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM schedule");
            while (rs.next()){
                        String name = String.valueOf(rs.getString("schedule_name"));
                        scheduleCOM.addItem(name);
            }
        } catch (Exception ex) {
            Logger.getLogger(Member_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean hasDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    
    private void clear(){
        nameTXT.setText("");
        addressTXT.setText("");
        phoneTXT.setText("");
        emailTXT.setText("");
        joinDateTXT.setText("");
        statusCOM.setSelectedIndex(0);
        scheduleCOM.setSelectedIndex(0);
    }
    
    private void loader(String sql, String option){
        String name = nameTXT.getText();
        String address = addressTXT.getText();
        String phoneNo = phoneTXT.getText();
        String email = emailTXT.getText();
        String joinDate = joinDateTXT.getText();
        String status = statusCOM.getSelectedItem().toString();
        String sch = scheduleCOM.getSelectedItem().toString();
        if(name.equals("")){
            msg.textSet("Name Can't be Empty", "Error !");
            GlassPanePopup.showPopup(msg);
        }else{
           if (hasDigit(name)){
               msg.textSet("Name can't have numbers", "Name Error!!!");
               System.out.println("Debug Mode : Name have a Number");
               GlassPanePopup.showPopup(msg);
           }
           else{
               if(address.equals("")){
                   msg.textSet("Address can't be empty", "Error !");
                   GlassPanePopup.showPopup(msg);
               }else{
                   if(phoneNo.equals("")){
                       msg.textSet("Phone number can't be empty", "Error !");
                       GlassPanePopup.showPopup(msg); 
                   }else{
                       if(!validate.isValid(phoneNo)){
                           msg.textSet("Number is wrong", "Error !");
                           GlassPanePopup.showPopup(msg);
                       }else{
                           if(email.equals("")){
                               msg.textSet("Enter email or enter Null", "Error !");
                               GlassPanePopup.showPopup(msg);
                           }else{
                               if(!validate.isValidEmail(email)){
                                   msg.textSet("Email is Wrong", "Error !");
                                   GlassPanePopup.showPopup(msg);
                               }else{
                                   if(joinDate.equals("")){
                                       msg.textSet("Join date can't be empty", "Error !");
                                       GlassPanePopup.showPopup(msg);
                                   }else{
                                       if(status.equals("Select")){
                                           msg.textSet("Select the Status", "Error !");
                                           GlassPanePopup.showPopup(msg);
                                       }else{
                                           if(sch.equals("Select")){
                                               msg.textSet("Select the Schedule", "Error !");
                                               GlassPanePopup.showPopup(msg);
                                           }else{
                                                try {
                                                    DB.putdata(sql);
                                           }    catch (Exception ex) {
                                                    Logger.getLogger(Member_Form.class.getName()).log(Level.SEVERE, null, ex);
                                                } 
                                           } 
                                        }
                                   }
                               }
                           }
                       }
                   }
               }
           }
        }
    }
    
    private void tableDataClear(){
        try {
            while (0<=memberTBL.getRowCount()){
                DefaultTableModel table = (DefaultTableModel)memberTBL.getModel();
                table.removeRow(memberTBL.getRowCount()-1);
            }
        } catch (Exception e) {
            System.out.println("Member Form tableDataClear: "+e);
        }
    }
    
    private void tableDataLoader (){
        try {
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM customers");   
            while (rs.next()){
                String no = String.valueOf(rs.getString("id"));
                String name = String.valueOf(rs.getString("name"));
                String address = String.valueOf(rs.getString("address"));
                String phone = String.valueOf(rs.getString("phone"));
                String email = String.valueOf(rs.getString("email"));
                String join_date = String.valueOf(rs.getString("join_date"));
                String status = String.valueOf(rs.getString("status"));
                String deleted = String.valueOf(rs.getString("deleted"));
                
                if (deleted.equals("no")){
                    String table_data[] = {no, name, address, phone, email, join_date, status};
                        DefaultTableModel table = (DefaultTableModel)memberTBL.getModel();
                
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

        date = new com.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addressTXT = new javax.swing.JTextField();
        nameTXT = new javax.swing.JTextField();
        phoneTXT = new javax.swing.JTextField();
        emailTXT = new javax.swing.JTextField();
        joinDateTXT = new javax.swing.JTextField();
        selectDateBTN = new com.samplemessage.Button();
        statusCOM = new javax.swing.JComboBox<>();
        updateBTN = new Components.ButtonGradient();
        saveBTN = new Components.ButtonGradient();
        deleteBTN = new Components.ButtonGradient();
        jLabel7 = new javax.swing.JLabel();
        scheduleCOM = new javax.swing.JComboBox<>();
        clearBTN = new Components.ButtonGradient();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberTBL = new javax.swing.JTable();

        date.setForeground(new java.awt.Color(51, 51, 255));
        date.setDateFormat("yyyy-MM-dd");
        date.setTextRefernce(joinDateTXT);

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel2.setText("Address");

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel4.setText("Phone No");

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel5.setText("Join Date");

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel6.setText("Status");

        addressTXT.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        nameTXT.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        phoneTXT.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        emailTXT.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        joinDateTXT.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        selectDateBTN.setBackground(new java.awt.Color(0, 102, 255));
        selectDateBTN.setText("Select Date");
        selectDateBTN.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        selectDateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDateBTNActionPerformed(evt);
            }
        });

        statusCOM.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        statusCOM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Registred", "Active", "Inactive" }));

        updateBTN.setText("Update");
        updateBTN.setColor1(new java.awt.Color(255, 255, 102));
        updateBTN.setColor2(new java.awt.Color(204, 204, 0));
        updateBTN.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        updateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTNActionPerformed(evt);
            }
        });

        saveBTN.setText("Save");
        saveBTN.setColor1(new java.awt.Color(51, 255, 0));
        saveBTN.setColor2(new java.awt.Color(0, 204, 51));
        saveBTN.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        saveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTNActionPerformed(evt);
            }
        });

        deleteBTN.setText("Delete");
        deleteBTN.setColor1(new java.awt.Color(255, 102, 102));
        deleteBTN.setColor2(new java.awt.Color(255, 0, 51));
        deleteBTN.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        deleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel7.setText("Schedule");

        scheduleCOM.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        clearBTN.setText("Clear");
        clearBTN.setColor1(new java.awt.Color(102, 102, 255));
        clearBTN.setColor2(new java.awt.Color(0, 0, 255));
        clearBTN.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        clearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nameTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phoneTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(emailTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addressTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(joinDateTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(selectDateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(statusCOM, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scheduleCOM, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(saveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(joinDateTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectDateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusCOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scheduleCOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jPanel2.setOpaque(false);

        memberTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Address", "Phone", "Email", "Join Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        memberTBL.setOpaque(false);
        memberTBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memberTBLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(memberTBL);
        if (memberTBL.getColumnModel().getColumnCount() > 0) {
            memberTBL.getColumnModel().getColumn(0).setPreferredWidth(1);
            memberTBL.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void memberTBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberTBLMouseClicked
        // TODO add your handling code here:
        
        memberTBL.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = memberTBL.getSelectedRow();
                cellData = memberTBL.getValueAt(row, 0).toString();
                nameTXT.setEnabled(false);
                joinDateTXT.setEnabled(false);
                selectDateBTN.setEnabled(false);
                saveBTN.setEnabled(false);
                updateBTN.setEnabled(true);
                deleteBTN.setEnabled(true);
                System.out.println("Cell Data table : "+cellData);
                try {
                    java.sql.ResultSet rs = DB.getdata("SELECT * FROM customers WHERE id = '"+cellData+"'");   
                    while (rs.next()){
                        String name = String.valueOf(rs.getString("name"));
                        String address = String.valueOf(rs.getString("address"));
                        String phone = String.valueOf(rs.getString("phone"));
                        String email = String.valueOf(rs.getString("email"));
                        String join_date = String.valueOf(rs.getString("join_date"));
                        String status = String.valueOf(rs.getString("status"));
                        String schId = String.valueOf(rs.getString("schedule_id"));
                        
                        try {
                            java.sql.ResultSet rs2 = DB.getdata("SELECT * FROM schedule WHERE id = '"+schId+"'");
                            while (rs2.next()){
                                        schName = String.valueOf(rs2.getString("schedule_name"));
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(Member_Form.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        nameTXT.setText(name);
                        addressTXT.setText(address);
                        phoneTXT.setText(phone);
                        emailTXT.setText(email);
                        joinDateTXT.setText(join_date);
                        statusCOM.setSelectedItem(status);
                        scheduleCOM.setSelectedItem(schName);

                        
            }

            } catch (Exception es) {
                System.out.println("Error(Member form tableDataLoader): "+es);
            }
                }
        });
        
    }//GEN-LAST:event_memberTBLMouseClicked
    String shId;
    private void updateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTNActionPerformed
        // TODO add your handling code here:
        String address = addressTXT.getText();
        String phoneNo = phoneTXT.getText();
        String email = emailTXT.getText();
        String status = statusCOM.getSelectedItem().toString();
        String shName = scheduleCOM.getSelectedItem().toString();
        try {
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM schedule WHERE schedule_name = '"+shName+"'");
            while(rs.next()){
                shId = String.valueOf(rs.getString("id"));
            }
        } catch (Exception ex) {
            Logger.getLogger(Member_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(address.equals("")){
            msg.textSet("Address can not Empty!", "Address Error!");
            System.out.println("member form update btn : Address feild");
        }else{
            if (phoneNo.equals("")) {
                msg.textSet("Phone Number can not Empty!", "Phone No Error!");
                System.out.println("member form update btn : Phone No feild");
            }else{
                if (!phoneAndMailValidate.isValid(phoneNo)) {
                    msg.textSet("Phone Number not Valid!", "Phone No Error!");
                    System.out.println("member form update btn : Phone No not valid");
                }else{
                    if(status.equals("Select")){
                        msg.textSet("Please Select a Status!", "Status Error!");
                        System.out.println("member form update btn : Not Stasus selcted");
                    }else{
                        String sql = "UPDATE customers SET address = '"+address+"', phone = '"+phoneNo+"', email = '"+email+"', status = '"+status+"', schedule_id = '"+shId+"' WHERE id = '"+cellData+"'";
                        try {
                            DB.putdata(sql);
                            System.out.println("member form update btn : Data Written.");
                            tableDataClear();
                            tableDataLoader();
                            saveBTN.setEnabled(true);
                            updateBTN.setEnabled(false);
                            deleteBTN.setEnabled(false);
                            nameTXT.setEnabled(true);
                            joinDateTXT.setEnabled(true);
                            selectDateBTN.setEnabled(true);
                            clear();
                            
                        } catch (Exception ex) {
                            Logger.getLogger(Member_Form.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
        
    }//GEN-LAST:event_updateBTNActionPerformed

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed
        // TODO add your handling code here:
        String name = nameTXT.getText();
        String address = addressTXT.getText();
        String phoneNo = phoneTXT.getText();
        String email = emailTXT.getText();
        String joinDate = joinDateTXT.getText();
        String status = statusCOM.getSelectedItem().toString();
        String shName = scheduleCOM.getSelectedItem().toString();
        try {
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM schedule WHERE schedule_name = '"+shName+"'");
            while(rs.next()){
                shId = String.valueOf(rs.getString("id"));
            }
        } catch (Exception ex) {
            Logger.getLogger(Member_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "INSERT INTO customers(name, address, phone, email, join_date, status, deleted, schedule_id) VALUES('"+name+"','"+address+"','"+phoneNo+"','"+email+"','"+joinDate+"','"+status+"', 'no', '"+shId+"')";
        loader(query, "Save");
        tableDataClear();
        tableDataLoader();
        clear();
    }//GEN-LAST:event_saveBTNActionPerformed

    private void selectDateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDateBTNActionPerformed
        // TODO add your handling code here:
        date.showPopup();
    }//GEN-LAST:event_selectDateBTNActionPerformed

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        // TODO add your handling code here:
        try {
            DB.putdata("UPDATE customers SET deleted = 'yes' WHERE id = '"+cellData+"'");
            tableDataClear();
            tableDataLoader();
            clear();
            saveBTN.setEnabled(true);
            updateBTN.setEnabled(false);
            deleteBTN.setEnabled(false);
            nameTXT.setEnabled(true);
            joinDateTXT.setEnabled(true);
            selectDateBTN.setEnabled(true);
        } catch (Exception ex) {
            System.out.println("Member Form Delete Button : "+ex);
            Logger.getLogger(Users_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteBTNActionPerformed

    private void clearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBTNActionPerformed
        // TODO add your handling code here:
        clear();
        nameTXT.setEnabled(true);
        joinDateTXT.setEnabled(true);
        selectDateBTN.setEnabled(true);
    }//GEN-LAST:event_clearBTNActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTXT;
    private Components.ButtonGradient clearBTN;
    private com.datechooser.DateChooser date;
    private Components.ButtonGradient deleteBTN;
    private javax.swing.JTextField emailTXT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField joinDateTXT;
    private javax.swing.JTable memberTBL;
    private javax.swing.JTextField nameTXT;
    private javax.swing.JTextField phoneTXT;
    private Components.ButtonGradient saveBTN;
    private javax.swing.JComboBox<String> scheduleCOM;
    private com.samplemessage.Button selectDateBTN;
    private javax.swing.JComboBox<String> statusCOM;
    private Components.ButtonGradient updateBTN;
    // End of variables declaration//GEN-END:variables
}
