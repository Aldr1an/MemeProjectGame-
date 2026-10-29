package com.memegame.memepicsgame;

/**
 * The main menu and the first screen the player sees. It has four buttons:
 * Continue / New Game, Select Theme, Mechanics / Credits, and Close Game.
 * It's also where the game starts (see {@link #main(String[])}).
 */
public class MainWindow extends javax.swing.JFrame {
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainWindow.class.getName());

    /**
     * Builds the menu window and centers it on the screen.
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

        btnMechanics.setText("Mechanics / Credits");
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
    /**
     * Continue / New Game button. Opens the game on the theme the player
     * was last on. If there's no valid saved theme, or that theme is still
     * locked, it falls back to the first theme. If every meme in that
     * theme is already solved, the game opens in replay mode.
     *
     * @param evt the button click event
     */
    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        int i = GameData.currentTheme;
        // Fall back to the first theme if the saved one is invalid or locked
        if (i < 0 || i >= GameData.THEMES.size() || !GameData.isUnlocked(i)) {
            i = 0;                               
        }
        Theme t = GameData.THEMES.get(i);
         // Replay mode when the player already solved every meme in the theme
        boolean replay = t.getSolvedCount() == t.getMemes().size();
        new GameWindow(t, replay).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnContinueActionPerformed
    // Select Theme button. Opens the theme selection screen
    private void btnThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemeActionPerformed
        new ThemeWindow().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThemeActionPerformed
    // Mechanics / Credits button. Opens the how-to-play pop-up on top of
    private void btnMechanicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMechanicsActionPerformed
        new MechanicsDialogue(this, true).setVisible(true);
    }//GEN-LAST:event_btnMechanicsActionPerformed
    //Close Game button. Quits the whole program.
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
