/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misys.tiplus2.migdirector;

import com.misys.tiplus2.migdirector.gui.HistoryIFrame;
import com.misys.tiplus2.migdirector.gui.SettingsIFrame;
import com.misys.tiplus2.migdirector.gui.MappingIFrame;
import com.misys.tiplus2.migdirector.gui.MessageIFrame;
import com.misys.tiplus2.migdirector.gui.NamespaceIFrame;
import com.misys.tiplus2.migdirector.gui.ReportIFrame;
import com.misys.tiplus2.migdirector.gui.RunIFrame;
import javax.swing.JFrame;

/**
 *
 * @author falmarez
 */
public class MigrationDirector extends javax.swing.JFrame {
    
    

    /**
     * Creates new form MigrationDirector
     */
    public MigrationDirector() {
        initComponents();
        initExternalPane();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        settingsMenuI = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mappingsMenuI = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        namespacesMenuI = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        saveMenuI = new javax.swing.JMenuItem();
        saveAsMenuI = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        exitMenuI = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        viewHistMenuI = new javax.swing.JMenuItem();
        runMenu = new javax.swing.JMenu();
        runMigMenuI = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        runRepMenuI = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        aboutMenuI = new javax.swing.JMenuItem();
        docuMenuI = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Migration Director Beta");
        setName("migDirectorFrame"); // NOI18N

        desktopPane.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1003, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        fileMenu.setText("File");

        settingsMenuI.setText("Settings...");
        settingsMenuI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsMenuIActionPerformed(evt);
            }
        });
        fileMenu.add(settingsMenuI);
        fileMenu.add(jSeparator1);

        mappingsMenuI.setText("Mappings...");
        mappingsMenuI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mappingsMenuIActionPerformed(evt);
            }
        });
        fileMenu.add(mappingsMenuI);
        fileMenu.add(jSeparator2);

        namespacesMenuI.setText("Namespaces...");
        namespacesMenuI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namespacesMenuIActionPerformed(evt);
            }
        });
        fileMenu.add(namespacesMenuI);

        jMenuItem2.setText("Messages...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem2);
        fileMenu.add(jSeparator4);

        saveMenuI.setText("Save");
        saveMenuI.setEnabled(false);
        fileMenu.add(saveMenuI);

        saveAsMenuI.setText("Save As...");
        saveAsMenuI.setEnabled(false);
        fileMenu.add(saveAsMenuI);
        fileMenu.add(jSeparator5);

        exitMenuI.setText("Exit");
        exitMenuI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuIActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuI);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Edit");

        viewHistMenuI.setText("View History...");
        viewHistMenuI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewHistMenuIActionPerformed(evt);
            }
        });
        editMenu.add(viewHistMenuI);

        jMenuBar1.add(editMenu);

        runMenu.setText("Run");

        runMigMenuI.setText("Run migration...");
        runMigMenuI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runMigMenuIActionPerformed(evt);
            }
        });
        runMenu.add(runMigMenuI);
        runMenu.add(jSeparator3);

        runRepMenuI.setText("Run report");
        runRepMenuI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runRepMenuIActionPerformed(evt);
            }
        });
        runMenu.add(runRepMenuI);

        jMenuBar1.add(runMenu);

        aboutMenu.setText("About");

        aboutMenuI.setText("About");
        aboutMenuI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuIActionPerformed(evt);
            }
        });
        aboutMenu.add(aboutMenuI);

        jMenuBar1.add(aboutMenu);

        docuMenuI.setText("Help");

        jMenuItem1.setText("Documentation");
        docuMenuI.add(jMenuItem1);

        jMenuBar1.add(docuMenuI);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mappingsMenuIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mappingsMenuIActionPerformed
        // TODO add your handling code here:
        
        mappingIFrame.setVisible(true);
        
    }//GEN-LAST:event_mappingsMenuIActionPerformed

    private void runMigMenuIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runMigMenuIActionPerformed
        // TODO add your handling code here:
          
        runIFrame.setVisible(true);
    }//GEN-LAST:event_runMigMenuIActionPerformed

    private void settingsMenuIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsMenuIActionPerformed
        // TODO add your handling code here:
        
        settingsIFrame.setVisible(true);
        
    }//GEN-LAST:event_settingsMenuIActionPerformed

    private void exitMenuIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuIActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMenuIActionPerformed

    private void namespacesMenuIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namespacesMenuIActionPerformed
        // TODO add your handling code here:
       
        namespaceIFrame.setVisible(true);
    }//GEN-LAST:event_namespacesMenuIActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
        messageIFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void viewHistMenuIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewHistMenuIActionPerformed
        // TODO add your handling code here:
        historyIFrame.setVisible(true);
    }//GEN-LAST:event_viewHistMenuIActionPerformed

    private void runRepMenuIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runRepMenuIActionPerformed
        // TODO add your handling code here:
        reportIFrame.setVisible(true);
    }//GEN-LAST:event_runRepMenuIActionPerformed

    private void aboutMenuIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aboutMenuIActionPerformed

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
            java.util.logging.Logger.getLogger(MigrationDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MigrationDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MigrationDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MigrationDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MigrationDirector migDir = new MigrationDirector();
                migDir.setVisible(true);
                migDir.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
    }
    
    //External IFrame
    private SettingsIFrame settingsIFrame;
    private MappingIFrame mappingIFrame;
    private NamespaceIFrame namespaceIFrame;
    private MessageIFrame messageIFrame;
    private HistoryIFrame historyIFrame;
    private RunIFrame runIFrame;
    private ReportIFrame reportIFrame;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenuItem aboutMenuI;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu docuMenuI;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuI;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JMenuItem mappingsMenuI;
    private javax.swing.JMenuItem namespacesMenuI;
    private javax.swing.JMenu runMenu;
    private javax.swing.JMenuItem runMigMenuI;
    private javax.swing.JMenuItem runRepMenuI;
    private javax.swing.JMenuItem saveAsMenuI;
    private javax.swing.JMenuItem saveMenuI;
    private javax.swing.JMenuItem settingsMenuI;
    private javax.swing.JMenuItem viewHistMenuI;
    // End of variables declaration//GEN-END:variables

    private void initExternalPane() {
    //instantiate
    settingsIFrame = new SettingsIFrame();
    mappingIFrame = new MappingIFrame();
    namespaceIFrame = new NamespaceIFrame();
    messageIFrame = new MessageIFrame();
    historyIFrame = new HistoryIFrame();
    runIFrame = new RunIFrame();
    reportIFrame = new ReportIFrame();
    
    
    desktopPane.add(settingsIFrame);
    desktopPane.add(mappingIFrame);
    desktopPane.add(namespaceIFrame);
    desktopPane.add(messageIFrame);
    desktopPane.add(historyIFrame);
    desktopPane.add(runIFrame);
    desktopPane.add(reportIFrame);
    }
}
