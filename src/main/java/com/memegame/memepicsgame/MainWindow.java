package com.memegame.memepicsgame;

public class MainWindow extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainWindow.class.getName());

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleName = new javax.swing.JLabel();
        btnContinue = new javax.swing.JButton();
        btnTheme = new javax.swing.JButton();
        btnMechanics = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meme Pics");
        setResizable(false);

        titleName.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleName.setText("4pics, 1Meme");
        titleName.setName(""); // NOI18N

        btnContinue.setText("Continue / New Game");
        btnContinue.addActionListener(this::btnContinueActionPerformed);

        btnTheme.setText("Select Theme");
        btnTheme.addActionListener(this::btnThemeActionPerformed);

        btnMechanics.setText("Mechanics");
        btnMechanics.addActionListener(this::btnMechanicsActionPerformed);

        btnClose.setText("Close Game");
        btnClose.addActionListener(this::btnCloseActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(351, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnMechanics)
                    .addComponent(btnClose)
                    .addComponent(titleName, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContinue)
                    .addComponent(btnTheme))
                .addGap(351, 351, 351))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClose, btnContinue, btnMechanics, btnTheme});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(titleName)
                .addGap(47, 47, 47)
                .addComponent(btnContinue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTheme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMechanics)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //mainMenubtn
    //Button for going into the Continue/NewGame logic
    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        new GameWindow(GameData.THEMES.get(0), false).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnContinueActionPerformed
      
    private void btnThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemeActionPerformed
        new ThemeWindow().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThemeActionPerformed

    private void btnMechanicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMechanicsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMechanicsActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SaveManager.load();
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainWindow().setVisible(true));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnMechanics;
    private javax.swing.JButton btnTheme;
    private javax.swing.JLabel titleName;
    // End of variables declaration//GEN-END:variables
}
