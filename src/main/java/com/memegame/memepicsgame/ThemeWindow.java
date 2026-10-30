package com.memegame.memepicsgame;

import javax.swing.JButton;
import javax.swing.JProgressBar;

/**
 * The theme selection screen. It shows one button per theme (Post Covid,
 * Covid, Pre Covid) with a progress bar under each one showing how much of
 * that theme is solved. A theme's button is only clickable once the theme
 * before it has been completed. A Back button returns to the main menu.
 */
public class ThemeWindow extends BaseWindow {
        @Override
        protected void goBack(){
            new MainWindow().setVisible(true);
            this.dispose();
        }
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ThemeWindow.class.getName());
    
    
    /**
     * Builds the theme screen. For each theme, it fills in the progress bar
     * with the percentage solved and greys out the button if the theme is
     * still locked.
     * <p>
     * Note: this is written for exactly three themes. Adding a fourth
     * theme to {@link GameData#THEMES} also needs a new button and
     * progress bar added here, or the game will crash.
     */
    public ThemeWindow() {
        initComponents();
        setLocationRelativeTo(null);
        JButton[] themeButtons = {btnPostcovid, btnCovid, btnPrecovid};
        JProgressBar[] bars = {pbPostcovid, pbCovid, pbPrecovid};
        
        for (int i = 0; i < GameData.getThemeCount(); i++) {
            Theme t = GameData.getTheme(i);
            bars[i].setValue(t.getProgressPercent());
            themeButtons[i].setEnabled(GameData.isUnlocked(i));
        }
    }
        /**
     * Opens the game on the chosen theme and closes this screen. If the
     * theme is already fully solved, a message pops up first and the game
     * starts in replay mode, so every meme in it can be played again.
     *
     * @param i the theme's position in {@link GameData#THEMES}
     *          (0 = Post Covid, 1 = Covid, 2 = Pre Covid)
     */
    private void openTheme(int i){
        Theme t = GameData.getTheme(i);
        boolean replay = t.getSolvedCount() == t.getMemes().size();
        if (replay) {
            javax.swing.JOptionPane.showMessageDialog(this, "Theme complete play it again from the start.");
        
        }
        goTo(new GameWindow(t, replay));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleTheme = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnPostcovid = new javax.swing.JButton();
        btnCovid = new javax.swing.JButton();
        btnPrecovid = new javax.swing.JButton();
        pbPostcovid = new javax.swing.JProgressBar();
        pbCovid = new javax.swing.JProgressBar();
        pbPrecovid = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Select Theme");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleTheme.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        titleTheme.setForeground(new java.awt.Color(255, 255, 255));
        titleTheme.setText("Select a Theme");
        getContentPane().add(titleTheme, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 20, -1, -1));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/rsz_1themeback.png"))); // NOI18N
        btnBack.addActionListener(this::btnBackActionPerformed);
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 105, 41));

        btnPostcovid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/rsz_posttheme.png"))); // NOI18N
        btnPostcovid.addActionListener(this::btnPostcovidActionPerformed);
        getContentPane().add(btnPostcovid, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 220, 350));

        btnCovid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/rsz_covidtheme.png"))); // NOI18N
        btnCovid.addActionListener(this::btnCovidActionPerformed);
        getContentPane().add(btnCovid, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 220, 350));

        btnPrecovid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/rsz_pretheme.png"))); // NOI18N
        btnPrecovid.addActionListener(this::btnPrecovidActionPerformed);
        getContentPane().add(btnPrecovid, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 220, 350));
        getContentPane().add(pbPostcovid, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 470, 220, 26));
        getContentPane().add(pbCovid, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 470, 220, 30));
        getContentPane().add(pbPrecovid, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 470, 220, 26));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pre-Covid");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Post-Covid");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Covid");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/themebg.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // To go back to the Main Window
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed
    // Open POST Covid Theme :)
    private void btnPostcovidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostcovidActionPerformed
        
        openTheme(0);
        
    }//GEN-LAST:event_btnPostcovidActionPerformed
    // Open COVID theme
    private void btnCovidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCovidActionPerformed
        openTheme(1);
    }//GEN-LAST:event_btnCovidActionPerformed
    // Open PRE Covid Theme
    private void btnPrecovidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrecovidActionPerformed
        openTheme(2);
    }//GEN-LAST:event_btnPrecovidActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ThemeWindow().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCovid;
    private javax.swing.JButton btnPostcovid;
    private javax.swing.JButton btnPrecovid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar pbCovid;
    private javax.swing.JProgressBar pbPostcovid;
    private javax.swing.JProgressBar pbPrecovid;
    private javax.swing.JLabel titleTheme;
    // End of variables declaration//GEN-END:variables
}
