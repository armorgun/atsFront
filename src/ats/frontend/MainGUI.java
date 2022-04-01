/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ats.frontend;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author armor
 */
public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainGUI
     */
    
    private ats.frontend.AdvisorStuff.AdvisorGUI advisor;
    private ats.frontend.OfficeStuff.OfficeGUI office;
    
    
    public static int stockno=0;
    public static String userName=null;
    
    public MainGUI(int type , String uName) {
        this.userName=uName;
        switch (type) {
            case 0:
                initComponents();
                break;
            case 1:
                initComponents2();
                advisor.setOpaque(false);
                break;
            default:
                initComponents3();
                office.setOpaque(false);
                
                break;
        }
        
        
        
        try {
            stockno=Login.db.get1INT("SELECT lateststock FROM ats_sysdb.agencydetails")[0];
        } catch (SQLException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
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

        advisorGUI1 = new ats.frontend.AdvisorStuff.AdvisorGUI();
        adminGUI1 = new ats.frontend.AdminStuff.AdminGUI();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ATS System");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(6);
        setUndecorated(true);
        setSize(new java.awt.Dimension(904, 543));
        getContentPane().setLayout(null);

        adminGUI1.setBackground(new java.awt.Color(51, 51, 51));
        adminGUI1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminGUI1FocusGained(evt);
            }
        });
        getContentPane().add(adminGUI1);
        adminGUI1.setBounds(0, 0, 1920, 1080);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ats/frontend/plane_flying_at_night-wallpaper-1920x1080.jpg"))); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -2, 1920, 1040);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 1010, 1920, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminGUI1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminGUI1FocusGained
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_adminGUI1FocusGained

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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            //new MainGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ats.frontend.AdminStuff.AdminGUI adminGUI1;
    private ats.frontend.AdvisorStuff.AdvisorGUI advisorGUI1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void initComponents2() {

        advisorGUI1 = new ats.frontend.AdvisorStuff.AdvisorGUI();
        advisor = new ats.frontend.AdvisorStuff.AdvisorGUI();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ATS System");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(6);
        setUndecorated(true);
        setSize(new java.awt.Dimension(904, 543));
        getContentPane().setLayout(null);

        
        getContentPane().add(advisor);
        advisor.setBounds(0, 0, 1920, 1080);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ats/frontend/plane_flying_at_night-wallpaper-1920x1080.jpg"))); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -2, 1920, 1040);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 1010, 1920, 70);

        pack();
    }

    private void initComponents3() {

        advisorGUI1 = new ats.frontend.AdvisorStuff.AdvisorGUI();
        office = new ats.frontend.OfficeStuff.OfficeGUI();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ATS System");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(6);
        setUndecorated(true);
        setSize(new java.awt.Dimension(904, 543));
        getContentPane().setLayout(null);

       
        getContentPane().add(office);
        office.setBounds(0, 0, 1920, 1080);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ats/frontend/plane_flying_at_night-wallpaper-1920x1080.jpg"))); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -2, 1920, 1040);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 1010, 1920, 70);

        pack();
    }
}
