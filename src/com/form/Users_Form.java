package com.form;

import JDBC.Jdbc;
import com.component.Form;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.passwordprotect.PasswordEncryption;
import com.glasspanepopup.GlassPanePopup;
import com.samplemessage.Message2;

public class Users_Form extends Form {
JDBC.Jdbc DB = new Jdbc();
Message2 msg = new Message2();
String id;
Components.JTableUtils row = new Components.JTableUtils();
    public Users_Form() {
        initComponents();
        tableDataClear();
        tableDataLoader();
        updateBTN.setEnabled(false);
        deleteBTN.setEnabled(false);
    }
    
    public static boolean hasDigit(String string) {
        for (char character : string.toCharArray()) {
            if (Character.isDigit(character)) {
                return true;
            }
        }
            return false;
}
    
    
    private void DBtableDataWrite(String query, String type){
       String username = userNameTXT.getText();
        String password = userPasswordTXT.getText();
        String name = nameTXT.getText();
        String role = roleComboBox.getSelectedItem().toString();
        
        
        if(username.equals("")||password.equals("")||name.equals("")){
            msg.textSet("Username, Password and Name Can't be Empty", "error!");
            GlassPanePopup.showPopup(msg);
             //JOptionPane.showMessageDialog(null, "Username, Password and Name Can't be Empty", "Error", JOptionPane.INFORMATION_MESSAGE);
             System.out.println("Didn't input username, password and name");
        }else if(role == "Select"){
            msg.textSet("Pleae Select User Role", "Select user ROLE!");
            GlassPanePopup.showPopup(msg);
            //JOptionPane.showMessageDialog(null, "Pleae Select User Role", "Select user ROLE", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Role Not selected");
        }else{
            boolean startsWithDigit = Character.isDigit(username.charAt(0));
            int pwdCharacterCount = password.length();
            int uNameCharacterCount = username.length();
            int nameCharacterCount = name.length();
            if(nameCharacterCount<3){
                msg.textSet("Name Must have 6 Characters Minimum", "Name Error!");
                GlassPanePopup.showPopup(msg);
            }else if(startsWithDigit){
                msg.textSet("Username Can't Start with a Number", "Username Error!");
                GlassPanePopup.showPopup(msg);
                //JOptionPane.showMessageDialog(null, "Username Can't Start with a Number", "Username Error", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("User name Start with a number");
            }else if(uNameCharacterCount<4){
                msg.textSet("Username Must have 4 Characters Minimum", "Username Error!");
                GlassPanePopup.showPopup(msg);
                System.out.println("username not have 4 characters");
            }else if(pwdCharacterCount<6){
                msg.textSet("Password Must have 6 Characters Minimum", "Password Error!");
                GlassPanePopup.showPopup(msg);
                //JOptionPane.showMessageDialog(null, "Password Must have 6 Characters Minimum", "Password Error", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("password not have 6 characters");
            }else{
                try {
                    DB.putdata(query);
                } catch (Exception ex) {
                    System.out.println("User Form "+type+"Button : "+ex);
                    Logger.getLogger(Users_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
                tableDataClear();
                tableDataLoader();
                inputClear();
            }
        
        } 
    }
    
    
    private void inputClear(){
        userNameTXT.setText("");
        userPasswordTXT.setText("");
        nameTXT.setText("");
        roleComboBox.setSelectedIndex(0);
        passwordCheckBox.setSelected(false); 
    }
    
    public boolean checkUsernameExists(String username) {
        boolean exists = false;

        try {
           java.sql.ResultSet rs = DB.getdata("SELECT username FROM users");
           while (rs.next()){
                String DBuserName = String.valueOf(rs.getString("username"));
                if(DBuserName.equals(username)){
                    exists=true;
                }
           }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return exists;
    }
    
    private void tableDataClear(){
        try {
            while (0<=userTBL.getRowCount()){
                DefaultTableModel table = (DefaultTableModel)userTBL.getModel();
                table.removeRow(userTBL.getRowCount()-1);
            }
        } catch (Exception e) {
            System.out.println("ussr form tableDataClear: "+e);
        }
    }
    
    private void tableDataLoader (){
        try {
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM users"); 
            
            while (rs.next()){
                    String name = String.valueOf(rs.getString("name"));
                    String username = String.valueOf(rs.getString("username"));
                    String role = String.valueOf(rs.getString("role"));
                    String status = String.valueOf(rs.getString("status"));
                
                    if(status.equals("active")){
                        String table_data[] = {name, username, role};
                        DefaultTableModel table = (DefaultTableModel)userTBL.getModel();
                
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userNameTXT = new javax.swing.JTextField();
        userPasswordTXT = new javax.swing.JPasswordField();
        roleComboBox = new javax.swing.JComboBox<>();
        passwordCheckBox = new javax.swing.JCheckBox();
        saveBTN = new Components.ButtonGradient();
        updateBTN = new Components.ButtonGradient();
        deleteBTN = new Components.ButtonGradient();
        nameTXT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        clearBTN = new Components.ButtonGradient();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTBL = new javax.swing.JTable();

        jPanel1.setOpaque(false);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 1, true));
        jPanel2.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setText("Password");

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel2.setText("Role");

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel3.setText("User Name");

        userNameTXT.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        userNameTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTXTActionPerformed(evt);
            }
        });

        userPasswordTXT.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        roleComboBox.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Admin", "Courch" }));
        roleComboBox.setToolTipText("Select User Role");

        passwordCheckBox.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        passwordCheckBox.setText("Show Password");
        passwordCheckBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        passwordCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordCheckBoxActionPerformed(evt);
            }
        });

        saveBTN.setText("Save");
        saveBTN.setColor1(new java.awt.Color(51, 255, 0));
        saveBTN.setColor2(new java.awt.Color(51, 204, 0));
        saveBTN.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        saveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTNActionPerformed(evt);
            }
        });

        updateBTN.setText("Update");
        updateBTN.setColor1(new java.awt.Color(255, 204, 102));
        updateBTN.setColor2(new java.awt.Color(255, 153, 0));
        updateBTN.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        updateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTNActionPerformed(evt);
            }
        });

        deleteBTN.setText("Delete");
        deleteBTN.setColor1(new java.awt.Color(255, 102, 102));
        deleteBTN.setColor2(new java.awt.Color(255, 0, 0));
        deleteBTN.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        deleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNActionPerformed(evt);
            }
        });

        nameTXT.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        nameTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTXTActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel4.setText("Name");

        clearBTN.setText("Clear");
        clearBTN.setColor1(new java.awt.Color(0, 51, 255));
        clearBTN.setColor2(new java.awt.Color(0, 0, 204));
        clearBTN.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        clearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roleComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(saveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(updateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(35, 35, 35)
                        .addComponent(deleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(clearBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userPasswordTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(userNameTXT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nameTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(userNameTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nameTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userPasswordTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordCheckBox))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 1, true));
        jPanel3.setOpaque(false);

        userTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Username", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userTBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTBLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userTBL);
        if (userTBL.getColumnModel().getColumnCount() > 0) {
            userTBL.getColumnModel().getColumn(0).setResizable(false);
            userTBL.getColumnModel().getColumn(1).setResizable(false);
            userTBL.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userNameTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTXTActionPerformed

    private void passwordCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordCheckBoxActionPerformed
         if (passwordCheckBox.isSelected()) {
            userPasswordTXT.setEchoChar((char) 0); // Show the password characters
    } else {
            userPasswordTXT.setEchoChar('*'); // Hide the password characters
    }
    }//GEN-LAST:event_passwordCheckBoxActionPerformed

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed

        String username = userNameTXT.getText();
        String name = nameTXT.getText();
        String password = PasswordEncryption.encryptPassword(userPasswordTXT.getText());
        String combo = roleComboBox.getSelectedItem().toString();
        
        if(hasDigit(name)){
            msg.textSet("Name can't contain numbers!", "Name Error!");
            GlassPanePopup.showPopup(msg);
            System.out.println("User form - Debug mode : user name have numbers");
        }
        else if(checkUsernameExists(username)){
            msg.textSet("Put another username", "Username Exists");
            GlassPanePopup.showPopup(msg);
            //JOptionPane.showMessageDialog(null, "Put another username", "Username Exists", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Username exist");
        }else {
           String sql = "INSERT INTO users(username, password, role, name, status) VALUES('"+username+"','"+password+"','"+combo+"','"+name+"','active')"; 
           DBtableDataWrite(sql, "Save");
        }
        
    }//GEN-LAST:event_saveBTNActionPerformed

    private void updateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTNActionPerformed
        saveBTN.setEnabled(false);
        String username = userNameTXT.getText();
        String name = nameTXT.getText();
        String password = PasswordEncryption.encryptPassword(userPasswordTXT.getText());
        String role = roleComboBox.getSelectedItem().toString();
        String sql = "UPDATE users SET username = '"+username+"', password = '"+password+"', role = '"+role+"', name = '"+name+"', status = 'active' WHERE id = '"+id+"'";
        
        DBtableDataWrite(sql, "Update");
        userNameTXT.setEnabled(true);
        nameTXT.setEnabled(true);
        roleComboBox.setEnabled(true);
        
    }//GEN-LAST:event_updateBTNActionPerformed

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
    try {
        DB.putdata("UPDATE users SET status = 'deleted' WHERE id = '"+id+"'");
    } catch (Exception ex) {
        System.out.println("User Form Delete Button : "+ex);
        Logger.getLogger(Users_Form.class.getName()).log(Level.SEVERE, null, ex);
    }
    inputClear();
    tableDataClear();
    tableDataLoader();
    updateBTN.setEnabled(false);
    deleteBTN.setEnabled(false);
    saveBTN.setEnabled(true);
    userNameTXT.setEnabled(true);
    nameTXT.setEnabled(true);
    roleComboBox.setEnabled(true);
    
    }//GEN-LAST:event_deleteBTNActionPerformed

    private void nameTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTXTActionPerformed

    private void userTBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTBLMouseClicked
        saveBTN.setEnabled(false);
        updateBTN.setEnabled(true);
        deleteBTN.setEnabled(true);
        userNameTXT.setEnabled(false);
        nameTXT.setEnabled(false);
        roleComboBox.setEnabled(false);
        String cellData;
        userTBL.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = userTBL.getSelectedRow();
                String cellData = userTBL.getValueAt(row, 1).toString();
                
                try {
                    java.sql.ResultSet rs = DB.getdata("SELECT * FROM users where username = '"+cellData+"'");   
                    while (rs.next()){
                        id = String.valueOf(rs.getString("id"));
                        String name = String.valueOf(rs.getString("name"));
                        String username = String.valueOf(rs.getString("username"));
                        String role = String.valueOf(rs.getString("role"));
                        String password = PasswordEncryption.decryptPassword(String.valueOf(rs.getString("password")));
                        
                        userNameTXT.setText(username);
                        userPasswordTXT.setText(password);
                        nameTXT.setText(name);
                        roleComboBox.setSelectedItem(role);
        }
            
        } catch (Exception ae) {
            System.out.println("Error(User Table Moused Clicked): "+ae);
        }
            }
        });
    }//GEN-LAST:event_userTBLMouseClicked

    private void clearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBTNActionPerformed
        // TODO add your handling code here:
        inputClear();
        saveBTN.setEnabled(true);
        updateBTN.setEnabled(false);
        deleteBTN.setEnabled(false);
        userNameTXT.setEnabled(true);
        nameTXT.setEnabled(true);
        roleComboBox.setEnabled(true);
    }//GEN-LAST:event_clearBTNActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.ButtonGradient clearBTN;
    private Components.ButtonGradient deleteBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTXT;
    private javax.swing.JCheckBox passwordCheckBox;
    private javax.swing.JComboBox<String> roleComboBox;
    private Components.ButtonGradient saveBTN;
    private Components.ButtonGradient updateBTN;
    private javax.swing.JTextField userNameTXT;
    private javax.swing.JPasswordField userPasswordTXT;
    private javax.swing.JTable userTBL;
    // End of variables declaration//GEN-END:variables
}
