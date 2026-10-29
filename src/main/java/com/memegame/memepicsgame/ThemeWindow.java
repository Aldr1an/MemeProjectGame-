package com.memegame.memepicsgame;

import javax.swing.JButton;
import javax.swing.JProgressBar;

/**
 * The theme selection screen. It shows one button per theme (Post Covid,
 * Covid, Pre Covid) with a progress bar under each one showing how much of
 * that theme is solved. A theme's button is only clickable once the theme
 * before it has been completed. A Back button returns to the main menu.
 */
public class ThemeWindow extends javax.swing.JFrame {
    
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
        
        for (int i = 0; i < GameData.THEMES.size(); i++) {
            Theme t = GameData.THEMES.get(i);
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
        Theme t = GameData.THEMES.get(i);
        boolean replay = t.getSolvedCount() == t.getMemes().size();
        if (replay) {
            javax.swing.JOptionPane.showMessageDialog(this, "Theme complete play it again from the start.");
        
        }
        new GameWindow(t, replay).setVisible(true);
        dispose();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Select Theme");
        setResizable(false);

        titleTheme.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        titleTheme.setText("Select a Theme");

        btnBack.setText("Back");
        btnBack.addActionListener(this::btnBackActionPerformed);

        btnPostcovid.setText("Post Covid");
        btnPostcovid.addActionListener(this::btnPostcovidActionPerformed);

        btnCovid.setText("Covid");
        btnCovid.addActionListener(this::btnCovidActionPerformed);

        btnPrecovid.setText("Pre Covid");
        btnPrecovid.addActionListener(this::btnPrecovidActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(titleTheme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btnPostcovid)
                .addGap(219, 219, 219)
                .addComponent(btnCovid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrecovid)
                .addGap(142, 142, 142))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(pbPostcovid, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(pbCovid, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(pbPrecovid, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pbCovid, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleTheme)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPostcovid)
                            .addComponent(btnCovid)
                            .addComponent(btnPrecovid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pbPostcovid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pbPrecovid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // To go back to the Main Window
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new MainWindow().setVisible(true);
        this.dispose();
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
    private javax.swing.JProgressBar pbCovid;
    private javax.swing.JProgressBar pbPostcovid;
    private javax.swing.JProgressBar pbPrecovid;
    private javax.swing.JLabel titleTheme;
    // End of variables declaration//GEN-END:variables
}
