package com.form;

import com.component.Form;
import com.subforms.incomeReport;

public class Report_Form extends Form {

    public Report_Form() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        incomeReportLBL = new javax.swing.JLabel();
        memberReportLBL = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        incomeReportLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PaymentReport.png"))); // NOI18N
        incomeReportLBL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        incomeReportLBL.setPreferredSize(new java.awt.Dimension(930, 753));
        incomeReportLBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                incomeReportLBLMousePressed(evt);
            }
        });

        memberReportLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MemberReport.png"))); // NOI18N
        memberReportLBL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        memberReportLBL.setPreferredSize(new java.awt.Dimension(930, 753));
        memberReportLBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                memberReportLBLMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(incomeReportLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(memberReportLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(685, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(memberReportLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(incomeReportLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(374, Short.MAX_VALUE))
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

    private void incomeReportLBLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_incomeReportLBLMousePressed
        // TODO add your handling code here:
        com.subforms.incomeReport i = new com.subforms.incomeReport();
        i.setVisible(true);
    }//GEN-LAST:event_incomeReportLBLMousePressed

    private void memberReportLBLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberReportLBLMousePressed
        // TODO add your handling code here:
        com.subforms.memberReport m = new com.subforms.memberReport();
        m.setVisible(true);
    }//GEN-LAST:event_memberReportLBLMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel incomeReportLBL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel memberReportLBL;
    // End of variables declaration//GEN-END:variables
}
