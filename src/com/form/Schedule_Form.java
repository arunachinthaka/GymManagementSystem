package com.form;

import com.component.Form;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.glasspanepopup.GlassPanePopup;
import com.samplemessage.Message2;

public class Schedule_Form extends Form {

    JDBC.Jdbc DB = new JDBC.Jdbc();
    Message2 msg = new Message2();
    public Schedule_Form() {
        initComponents();
        comboLoader();
        tableDataClear();
        tableDataLoader();
    }
    String id;
    private void clear(){
        nameTXT.setText("");
        instructorCOM.setSelectedIndex(0);
    }
    private void tableDataClear(){
        try {
            while (0<=showTBL.getRowCount()){
                DefaultTableModel table = (DefaultTableModel)showTBL.getModel();
                table.removeRow(showTBL.getRowCount()-1);
            }
        } catch (Exception e) {
            System.out.println("Member Form tableDataClear: "+e);
        }
    }
    
    String schName;
    String insId;
    String statusSch;
    String userNameDB;
    private void tableDataLoader (){
        
        try {
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM schedule");
            
            
            while (rs.next()){
                schName = String.valueOf(rs.getString("schedule_name"));
                insId = String.valueOf(rs.getString("instructor_id"));
                statusSch = String.valueOf(rs.getString("status"));
                java.sql.ResultSet rs2 = DB.getdata("SELECT * FROM users WHERE id = '"+insId+"'");
                while(rs2.next()){
                    userNameDB = String.valueOf(rs2.getString("username"));

                    if (statusSch.equals("active")){
                         String table_data[] = {schName, userNameDB};
                         DefaultTableModel table = (DefaultTableModel)showTBL.getModel();

                         table.addRow(table_data);
                     }
                }
        }
            
            
        } catch (Exception e) {
            System.out.println("Error(userform tableDataLoader): "+e);
        }
    }
    private void comboLoader(){
        instructorCOM.addItem("Select");
        try {
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM users");
            while (rs.next()){
                        String Uname = String.valueOf(rs.getString("username"));
                        instructorCOM.addItem(Uname);
            }
        } catch (Exception ex) {
            Logger.getLogger(Member_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTXT = new javax.swing.JTextField();
        instructorCOM = new javax.swing.JComboBox<>();
        saveBTN = new Components.ButtonGradient();
        updateBTN = new Components.ButtonGradient();
        removeBTN = new Components.ButtonGradient();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showTBL = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create a schedule", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setText("Schedule Name ");

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel2.setText("Assinged Instructor");

        nameTXT.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        instructorCOM.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        saveBTN.setText("Save");
        saveBTN.setColor1(new java.awt.Color(102, 255, 102));
        saveBTN.setColor2(new java.awt.Color(51, 255, 0));
        saveBTN.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        saveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTNActionPerformed(evt);
            }
        });

        updateBTN.setText("Update");
        updateBTN.setColor1(new java.awt.Color(255, 255, 51));
        updateBTN.setColor2(new java.awt.Color(255, 204, 0));
        updateBTN.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        updateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTNActionPerformed(evt);
            }
        });

        removeBTN.setText("Remove");
        removeBTN.setColor1(new java.awt.Color(255, 51, 51));
        removeBTN.setColor2(new java.awt.Color(255, 0, 0));
        removeBTN.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        removeBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nameTXT)
                        .addComponent(instructorCOM, 0, 223, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(338, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(nameTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(instructorCOM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        showTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Assinged Instractor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        showTBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showTBLMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(showTBL);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed
 
        String shName = nameTXT.getText();
        String combo = instructorCOM.getSelectedItem().toString();
        try {
            // TODO add your handling code here:
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM users WHERE username = '"+combo+"'");
            while(rs.next()){
                id = String.valueOf(rs.getString("id"));
            }
            if(shName.equals("")){
                msg.textSet("Schedule name can't empty", "Schedule name Error!!");
                GlassPanePopup.showPopup(msg);
            }else{
                if(combo.equals("Select")){
                    msg.textSet("Select a Instructor", "Combo Box Error!!");
                    GlassPanePopup.showPopup(msg);
                }else{
                    DB.putdata("INSERT INTO schedule (instructor_id, schedule_name, status) VALUES('"+id+"', '"+shName+"', 'active')");
                    tableDataClear();
                    tableDataLoader();
                    clear();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Schedule_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_saveBTNActionPerformed

    private void updateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTNActionPerformed
        // TODO add your handling code here:
         
        String shName = nameTXT.getText();
        String combo = instructorCOM.getSelectedItem().toString();
        try {
            // TODO add your handling code here:
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM users WHERE username = '"+combo+"'");
            while(rs.next()){
                id = String.valueOf(rs.getString("id"));
            }
            if(shName.equals("")){
                msg.textSet("Schedule name can't empty", "Schedule name Error!!");
                GlassPanePopup.showPopup(msg);
            }else{
                if(combo.equals("Select")){
                    msg.textSet("Select a Instructor", "Combo Box Error!!");
                    GlassPanePopup.showPopup(msg);
                }else{
                    DB.putdata("UPDATE schedule SET instructor_id = '"+id+"' WHERE schedule_name = '"+shName+"'");
                    tableDataClear();
                    tableDataLoader();
                    saveBTN.setEnabled(true);
                    nameTXT.setEditable(true);
                    updateBTN.setEnabled(false);
                    removeBTN.setEnabled(false);
                    clear();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Schedule_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    }//GEN-LAST:event_updateBTNActionPerformed

    private void removeBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBTNActionPerformed
        // TODO add your handling code here:
        String shName = nameTXT.getText();
        String combo = instructorCOM.getSelectedItem().toString();
        try {
            // TODO add your handling code here:
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM users WHERE username = '"+combo+"'");
            while(rs.next()){
                id = String.valueOf(rs.getString("id"));
            }
            if(shName.equals("")){
                msg.textSet("Schedule name can't empty", "Schedule name Error!!");
                GlassPanePopup.showPopup(msg);
            }else{
                if(combo.equals("Select")){
                    msg.textSet("Select a Instructor", "Combo Box Error!!");
                    GlassPanePopup.showPopup(msg);
                }else{
                    DB.putdata("UPDATE schedule SET status = 'deactive' WHERE schedule_name = '"+shName+"'");
                    tableDataClear();
                    tableDataLoader();
                    saveBTN.setEnabled(true);
                    nameTXT.setEditable(true);
                    updateBTN.setEnabled(false);
                    removeBTN.setEnabled(false);
                    clear();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Schedule_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_removeBTNActionPerformed

    private void showTBLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showTBLMousePressed
        // TODO add your handling code here:
        showTBL.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                int row = showTBL.getSelectedRow();
                String name = showTBL.getValueAt(row, 0).toString();
                String user = showTBL.getValueAt(row, 1).toString();
                
                saveBTN.setEnabled(false);
                nameTXT.setEditable(false);
                updateBTN.setEnabled(true);
                removeBTN.setEnabled(true);
                
                nameTXT.setText(name);
                instructorCOM.setSelectedItem(user);
                        
            }
        });
    }//GEN-LAST:event_showTBLMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> instructorCOM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTXT;
    private Components.ButtonGradient removeBTN;
    private Components.ButtonGradient saveBTN;
    private javax.swing.JTable showTBL;
    private Components.ButtonGradient updateBTN;
    // End of variables declaration//GEN-END:variables
}
