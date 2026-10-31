package com.memegame.memepicsgame;

/**
 * The main menu and the first screen the player sees. It has four buttons:
 * Continue / New Game, Select Theme, Mechanics / Credits, and Close Game.
 * It's also where the game starts (see {@link #main(String[])}).
 */
public class MainWindow extends BaseWindow {
    //HEHE METHOD OVERRIDING SUR 
    @Override 
    protected void goBack(){
        System.exit(0);
    }
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

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnContinue = new javax.swing.JButton();
        btnTheme = new javax.swing.JButton();
        btnMechanics = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meme Pics");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PLAY/CONTINUE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("EXIT");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 510, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PICK THEME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, -1, 20));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MECHANICS/CREDITS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/rsz_mainbg.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/rsz_1exit.png"))); // NOI18N
        btnClose.addActionListener(this::btnCloseActionPerformed);
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 80, 70));

        btnContinue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/rsz_play.png"))); // NOI18N
        btnContinue.addActionListener(this::btnContinueActionPerformed);
        getContentPane().add(btnContinue, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 80, 70));

        btnTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/rsz_picktheme.png"))); // NOI18N
        btnTheme.setToolTipText("theme");
        btnTheme.addActionListener(this::btnThemeActionPerformed);
        getContentPane().add(btnTheme, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 80, 70));

        btnMechanics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/rsz_mechanic.png"))); // NOI18N
        btnMechanics.setText("Mechanics / Credits");
        btnMechanics.addActionListener(this::btnMechanicsActionPerformed);
        getContentPane().add(btnMechanics, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 80, 70));

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
        int i = GameData.getCurrentTheme();
        // Fall back to the first theme if the saved one is invalid or locked
        if (i < 0 || i >= GameData.getThemeCount() || !GameData.isUnlocked(i)) {
            i = 0;                               
        }
        Theme t = GameData.getTheme(i);
         // Replay mode when the player already solved every meme in the theme
        boolean replay = t.getSolvedCount() == t.getMemes().size();
        goTo(new GameWindow(t, replay));
    }//GEN-LAST:event_btnContinueActionPerformed
    // Select Theme button. Opens the theme selection screen
    private void btnThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemeActionPerformed
        goTo(new ThemeWindow());
    }//GEN-LAST:event_btnThemeActionPerformed
    // Mechanics / Credits button. Opens the how-to-play pop-up on top of
    private void btnMechanicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMechanicsActionPerformed
        new MechanicsDialogue(this, true).setVisible(true);
    }//GEN-LAST:event_btnMechanicsActionPerformed
    //Close Game button. Quits the whole program.
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        goBack();
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
