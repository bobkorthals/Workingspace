/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.main;

import java.beans.PropertyChangeEvent;
import pas.bar.BarController;
import pas.course.CourseController;
import pas.facility.FacilityController;
import pas.financial.FinancialController;
import pas.member.MemberController;

/**
 *
 * @author jkg
 */
public class Main extends mvc.view.AbstractView {

    private MainController maincontroller;
    private MemberController membercontroller;

    /**
     * Creates new form main
     */
    public Main(MainController controller) {
        initComponents();
        this.maincontroller = controller;
        
    }

    @Override
    public MainController getController() {
        return this.maincontroller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent change) {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonFinancial = new javax.swing.JButton();
        buttonMembers = new javax.swing.JButton();
        buttonFacilities = new javax.swing.JButton();
        buttonCourses = new javax.swing.JButton();
        buttonBar = new javax.swing.JButton();

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setOpaque(false);

        buttonFinancial.setBackground(new java.awt.Color(155, 9, 46));
        buttonFinancial.setForeground(new java.awt.Color(255, 255, 255));
        buttonFinancial.setText("Financieel");
        buttonFinancial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFinancialActionPerformed(evt);
            }
        });

        buttonMembers.setBackground(new java.awt.Color(155, 9, 46));
        buttonMembers.setForeground(new java.awt.Color(255, 255, 255));
        buttonMembers.setText("Ledenregistratie");
        buttonMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMembersActionPerformed(evt);
            }
        });

        buttonFacilities.setBackground(new java.awt.Color(155, 9, 46));
        buttonFacilities.setForeground(new java.awt.Color(255, 255, 255));
        buttonFacilities.setText("Faciliteiten");
        buttonFacilities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFacilitiesActionPerformed(evt);
            }
        });

        buttonCourses.setBackground(new java.awt.Color(155, 9, 46));
        buttonCourses.setForeground(new java.awt.Color(255, 255, 255));
        buttonCourses.setText("Cursussen");
        buttonCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCoursesActionPerformed(evt);
            }
        });

        buttonBar.setBackground(new java.awt.Color(155, 9, 46));
        buttonBar.setForeground(new java.awt.Color(255, 255, 255));
        buttonBar.setText("Bar Applicatie");
        buttonBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonFacilities, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMembers, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(313, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonBar, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonFinancial, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonFinancial, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMembers, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonFacilities, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(jPanel1, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMembersActionPerformed
        new MemberController().indexAction();
    }//GEN-LAST:event_buttonMembersActionPerformed

    private void buttonFinancialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFinancialActionPerformed
        new FinancialController().defaultAction();        // TODO add your handling code here:
    }//GEN-LAST:event_buttonFinancialActionPerformed

    private void buttonFacilitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFacilitiesActionPerformed
        new FacilityController().facilityAction();        // TODO add your handling code here:
    }//GEN-LAST:event_buttonFacilitiesActionPerformed

    private void buttonCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCoursesActionPerformed
        new CourseController().CourseMainAction();        // Deze button opent de view CourseMain
    }//GEN-LAST:event_buttonCoursesActionPerformed

    private void buttonBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarActionPerformed
        new BarController().barAction();
    }//GEN-LAST:event_buttonBarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBar;
    private javax.swing.JButton buttonCourses;
    private javax.swing.JButton buttonFacilities;
    private javax.swing.JButton buttonFinancial;
    private javax.swing.JButton buttonMembers;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
