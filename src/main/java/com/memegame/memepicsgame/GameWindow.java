/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.memegame.memepicsgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Ade
 */
public class GameWindow extends javax.swing.JFrame {
    private boolean replay;
    private ArrayList<Meme> pool;
    private boolean roundDone = false;
    private Meme current;
    //buttons and slots decleration
    private JButton[] letterButtons, slotButtons;
    private int[] slotSource;
    private int clueCredits = 9999;
    private Theme theme;
    

    private void showMeme(Meme m) {
        //fields need to maintain order
        current = m;
        roundDone = false;
        setupLetters(m.getAnswer());
        // assembling Pic display
        JLabel[] picLabels = {lblPic1, lblPic2, lblPic3, lblPic4};
        //storing pics to paths varialbe
        String[] paths = current.getPicPaths();
        //putting pics into display.
        for (int i = 0; i < picLabels.length; i++) {
            picLabels[i].setText("");
            picLabels[i].setIcon(new ImageIcon(getClass().getResource(paths[i])));
        }
    }
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GameWindow.class.getName());

    /**
     * Creates new form GameWindow
     */
    public GameWindow(Theme theme, boolean replay) {
        initComponents();
        this.theme = theme;
        this.replay = replay;
        if (replay){
            pool = new ArrayList<>(theme.getMemes());
            Collections.shuffle(pool);
        }

        //setting the window to the middle of screen.
        setLocationRelativeTo(null);
        letterButtons = new JButton[]{btnLetter1, btnLetter2, btnLetter3, btnLetter4, btnLetter5, btnLetter6,
            btnLetter7, btnLetter8, btnLetter9, btnLetter10, btnLetter11, btnLetter12};
        slotButtons = new JButton[]{btnSlot1, btnSlot2, btnSlot3, btnSlot4, btnSlot5, btnSlot6, btnSlot7,
            btnSlot8, btnSlot9, btnSlot10};
        lblCredits.setText("Clues: " + clueCredits);
        slotSource = new int[slotButtons.length];
        showMeme(pickNext());
    }

    private void setupLetters(String answer) {
        //array that can grow not a fixed amount, good for taking the answer+generated letters.
        ArrayList<Character> letters = new ArrayList<>();
        //breaking everyletter to char in answer and setting them up to Uppercase + adding them to the array above.
        for (char c : answer.toUpperCase().toCharArray()) {
            letters.add(c);
        }
        //initialzing the object rand (randomizer).
        Random rand = new Random();
        //the list yes I know what they're called now. gets measured in size whaddaya to the buttons
        //anyways the reason it gets measure is the answer alr occupies some of the letters and it just needs filler this is how we add them
        while (letters.size() < letterButtons.length) {
            letters.add((char) ('A' + rand.nextInt(26)));
        }
        //shuffling the answer+filler :)
        Collections.shuffle(letters);
        //counts the shuffled letters :)
        //readys the buttons(char) to be converted back to string :), then displays them.
        for (int i = 0; i < letterButtons.length; i++) {
            letterButtons[i].setText(String.valueOf(letters.get(i)));
            letterButtons[i].setVisible(true);
        }
        //right sets the slot buttons foh display / how many are to be displayed.
        for (int s = 0; s < slotButtons.length; s++) {
            slotButtons[s].setText("");
            slotButtons[s].setVisible(s < answer.length());
            //it goes through every input and decreases them making them -1 to set the other logic where it will enounter a slotsource[i] += 1
            slotSource[s] = -1;
        }
    }
    
    private String getGuess() {
        String guess = "";
        for (int s = 0; s < slotButtons.length; s++) {
            if (slotButtons[s].isVisible()) {
                guess += slotButtons[s].getText();
            }
        }
        return guess;
    }

    private boolean slotsFull() {
        for (int s = 0; s < slotButtons.length; s++) {
            if (slotButtons[s].isVisible() && slotSource[s] == -1) {
                return false;
            }
        }
        return true;
    }

    private void checkIfDone() {
        if (slotsFull() && current.checkAnswer(getGuess())) {
            clueCredits++;
            SaveManager.save();
            lblCredits.setText("Clues: " + clueCredits);
            roundDone = true;
            //meowmewomeow
            CongratsDialog dlg = new CongratsDialog(this, true);
            dlg.setMeme(current);
            dlg.setHasNext(replay ? !pool.isEmpty() : theme.getRandomUnsolved() != null); 
            dlg.setVisible(true);
            String choice = dlg.getChoice();
            if (choice.equals("menu")) {
                new MainWindow().setVisible(true);
                dispose();
            } else if (choice.equals("theme")) {
                new ThemeWindow().setVisible(true);
                dispose();
            } else {
                Meme next = theme.getRandomUnsolved();
                if(next != null){
                    showMeme(next);
                } else {
                    new ThemeWindow().setVisible(true);
                    dispose();
                }
            }
        } else if (slotsFull() && !current.checkAnswer(getGuess())) {
            for (JButton b : slotButtons) {
                b.setForeground(java.awt.Color.RED);
            }
        }
    }
    private Meme pickNext() {
        if(replay) return pool.isEmpty() ? null : pool.remove(0);
        return theme.getRandomUnsolved();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPic1 = new javax.swing.JLabel();
        lblPic2 = new javax.swing.JLabel();
        lblPic3 = new javax.swing.JLabel();
        lblPic4 = new javax.swing.JLabel();
        btnSlotPanel = new javax.swing.JPanel();
        btnSlot1 = new javax.swing.JButton();
        btnSlot2 = new javax.swing.JButton();
        btnSlot3 = new javax.swing.JButton();
        btnSlot4 = new javax.swing.JButton();
        btnSlot5 = new javax.swing.JButton();
        btnSlot6 = new javax.swing.JButton();
        btnSlot7 = new javax.swing.JButton();
        btnSlot8 = new javax.swing.JButton();
        btnSlot9 = new javax.swing.JButton();
        btnSlot10 = new javax.swing.JButton();
        btnClue = new javax.swing.JButton();
        lblCredits = new javax.swing.JLabel();
        btnPanel = new javax.swing.JPanel();
        btnLetter1 = new javax.swing.JButton();
        btnLetter2 = new javax.swing.JButton();
        btnLetter3 = new javax.swing.JButton();
        btnLetter5 = new javax.swing.JButton();
        btnLetter6 = new javax.swing.JButton();
        btnLetter7 = new javax.swing.JButton();
        btnLetter8 = new javax.swing.JButton();
        btnLetter9 = new javax.swing.JButton();
        btnLetter4 = new javax.swing.JButton();
        btnLetter10 = new javax.swing.JButton();
        btnLetter11 = new javax.swing.JButton();
        btnLetter12 = new javax.swing.JButton();
        btnReturntoThemes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GameWindow");
        setResizable(false);

        lblPic1.setText("Pic 1");
        lblPic1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPic2.setText("Pic 2");
        lblPic2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPic3.setText("Pic 3");
        lblPic3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPic4.setText("Pic 4");
        lblPic4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSlot1.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSlot1.addActionListener(this::btnSlot1ActionPerformed);
        btnSlotPanel.add(btnSlot1);

        btnSlot2.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSlot2.addActionListener(this::btnSlot1ActionPerformed);
        btnSlotPanel.add(btnSlot2);

        btnSlot3.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSlot3.addActionListener(this::btnSlot1ActionPerformed);
        btnSlotPanel.add(btnSlot3);

        btnSlot4.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSlot4.addActionListener(this::btnSlot1ActionPerformed);
        btnSlotPanel.add(btnSlot4);

        btnSlot5.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSlot5.addActionListener(this::btnSlot1ActionPerformed);
        btnSlotPanel.add(btnSlot5);

        btnSlot6.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSlot6.addActionListener(this::btnSlot1ActionPerformed);
        btnSlotPanel.add(btnSlot6);

        btnSlot7.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSlot7.addActionListener(this::btnSlot1ActionPerformed);
        btnSlotPanel.add(btnSlot7);

        btnSlot8.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSlot8.addActionListener(this::btnSlot1ActionPerformed);
        btnSlotPanel.add(btnSlot8);

        btnSlot9.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSlot9.addActionListener(this::btnSlot1ActionPerformed);
        btnSlotPanel.add(btnSlot9);

        btnSlot10.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSlot10.addActionListener(this::btnSlot1ActionPerformed);
        btnSlotPanel.add(btnSlot10);

        btnClue.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClue.setText("Clue");
        btnClue.setActionCommand("");
        btnClue.setPreferredSize(new java.awt.Dimension(60, 40));
        btnClue.addActionListener(this::btnCluebtnLetter1ActionPerformed);

        lblCredits.setBackground(new java.awt.Color(255, 255, 255));
        lblCredits.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCredits.setForeground(new java.awt.Color(255, 255, 255));

        btnPanel.setDoubleBuffered(false);
        btnPanel.setPreferredSize(new java.awt.Dimension(360, 110));
        btnPanel.setLayout(new java.awt.GridLayout(2, 6, 8, 8));

        btnLetter1.setText("A");
        btnLetter1.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLetter1.addActionListener(this::btnLetter1ActionPerformed);
        btnPanel.add(btnLetter1);

        btnLetter2.setText("B");
        btnLetter2.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLetter2.addActionListener(this::btnLetter1ActionPerformed);
        btnPanel.add(btnLetter2);

        btnLetter3.setText("C");
        btnLetter3.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLetter3.addActionListener(this::btnLetter1ActionPerformed);
        btnPanel.add(btnLetter3);

        btnLetter5.setText("E");
        btnLetter5.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLetter5.addActionListener(this::btnLetter1ActionPerformed);
        btnPanel.add(btnLetter5);

        btnLetter6.setText("F");
        btnLetter6.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLetter6.addActionListener(this::btnLetter1ActionPerformed);
        btnPanel.add(btnLetter6);

        btnLetter7.setText("G");
        btnLetter7.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLetter7.addActionListener(this::btnLetter1ActionPerformed);
        btnPanel.add(btnLetter7);

        btnLetter8.setText("H");
        btnLetter8.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLetter8.addActionListener(this::btnLetter1ActionPerformed);
        btnPanel.add(btnLetter8);

        btnLetter9.setText("I");
        btnLetter9.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLetter9.addActionListener(this::btnLetter1ActionPerformed);
        btnPanel.add(btnLetter9);

        btnLetter4.setText("D");
        btnLetter4.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLetter4.addActionListener(this::btnLetter1ActionPerformed);
        btnPanel.add(btnLetter4);

        btnLetter10.setText("J");
        btnLetter10.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLetter10.addActionListener(this::btnLetter1ActionPerformed);
        btnPanel.add(btnLetter10);

        btnLetter11.setText("K");
        btnLetter11.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLetter11.addActionListener(this::btnLetter1ActionPerformed);
        btnPanel.add(btnLetter11);

        btnLetter12.setText("L");
        btnLetter12.setPreferredSize(new java.awt.Dimension(40, 40));
        btnLetter12.addActionListener(this::btnLetter1ActionPerformed);
        btnPanel.add(btnLetter12);

        btnReturntoThemes.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        btnReturntoThemes.setText("<-- Return To Themes");
        btnReturntoThemes.setActionCommand("");
        btnReturntoThemes.addActionListener(this::btnReturntoThemesActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnReturntoThemes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(lblPic1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(lblPic2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(lblPic3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPic4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(btnSlotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 60, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnClue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblPic1, lblPic2, lblPic3, lblPic4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReturntoThemes))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPic1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPic2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPic3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPic4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnSlotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnClue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addComponent(btnPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblPic1, lblPic2, lblPic3, lblPic4});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLetter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetter1ActionPerformed
        if (roundDone) {
            return;
        }
        JButton clicked = (JButton) evt.getSource();
        int tile = -1;
        for (int i = 0; i < letterButtons.length; i++) {
            if (letterButtons[i] == clicked) {
                tile = i;
            }
        }
        for (int s = 0; s < slotButtons.length; s++) {
            if (slotButtons[s].isVisible() && slotSource[s] == -1) {
                slotButtons[s].setText(clicked.getText());
                slotSource[s] = tile;
                clicked.setVisible(false);
                break;
            }
        }
        checkIfDone();
    }//GEN-LAST:event_btnLetter1ActionPerformed

    private void btnSlot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSlot1ActionPerformed
        if (roundDone) {
            return;
        }
        JButton clicked = (JButton) evt.getSource();
        for (int i = 0; i < slotButtons.length; i++) {
            if (slotButtons[i] == clicked) {
                if (slotSource[i] != -1) {
                    int tile = slotSource[i];                 // which tile did this letter come from?
                    letterButtons[tile].setVisible(true);     // bring that tile back
                    slotButtons[i].setText("");               // empty the slot
                    slotSource[i] = -1;
                }
                for (JButton b : slotButtons) {
                    b.setForeground(java.awt.Color.BLACK);
                }
            }
        }
    }//GEN-LAST:event_btnSlot1ActionPerformed

    private void btnCluebtnLetter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCluebtnLetter1ActionPerformed
        if (roundDone) {
            return;
        }
        if (clueCredits <1){
            return;
        }
        String answer = current.getAnswer().toUpperCase();

        // Pass 1: send every WRONG letter back to its tile
        for (int s = 0; s < answer.length(); s++) {
            String expected = String.valueOf(answer.charAt(s));
            if (slotSource[s] != -1 && !slotButtons[s].getText().equals(expected)) {
                letterButtons[slotSource[s]].setVisible(true);
                slotButtons[s].setText("");
                slotSource[s] = -1;
                for (JButton b : slotButtons) {
                    b.setForeground(java.awt.Color.BLACK);
                }
            }
        }

        // Pass 2: fill the FIRST empty slot with its correct letter
        for (int s = 0; s < answer.length(); s++) {
            if (slotSource[s] == -1) {
                String expected = String.valueOf(answer.charAt(s));
                for (int t = 0; t < letterButtons.length; t++) {
                    if (letterButtons[t].isVisible() && letterButtons[t].getText().equals(expected)) {
                        slotButtons[s].setText(expected);
                        slotSource[s] = t;
                        letterButtons[t].setVisible(false);
                        break;
                    }
                }
                clueCredits--;
                lblCredits.setText("Clues: " + clueCredits);
                checkIfDone();        // the clue might have just completed the word
                return;
            }
        }
    }//GEN-LAST:event_btnCluebtnLetter1ActionPerformed

    private void btnReturntoThemesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturntoThemesActionPerformed
        new ThemeWindow().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReturntoThemesActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new GameWindow(GameData.THEMES.get(0), false).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClue;
    private javax.swing.JButton btnLetter1;
    private javax.swing.JButton btnLetter10;
    private javax.swing.JButton btnLetter11;
    private javax.swing.JButton btnLetter12;
    private javax.swing.JButton btnLetter2;
    private javax.swing.JButton btnLetter3;
    private javax.swing.JButton btnLetter4;
    private javax.swing.JButton btnLetter5;
    private javax.swing.JButton btnLetter6;
    private javax.swing.JButton btnLetter7;
    private javax.swing.JButton btnLetter8;
    private javax.swing.JButton btnLetter9;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton btnReturntoThemes;
    private javax.swing.JButton btnSlot1;
    private javax.swing.JButton btnSlot10;
    private javax.swing.JButton btnSlot2;
    private javax.swing.JButton btnSlot3;
    private javax.swing.JButton btnSlot4;
    private javax.swing.JButton btnSlot5;
    private javax.swing.JButton btnSlot6;
    private javax.swing.JButton btnSlot7;
    private javax.swing.JButton btnSlot8;
    private javax.swing.JButton btnSlot9;
    private javax.swing.JPanel btnSlotPanel;
    private javax.swing.JLabel lblCredits;
    private javax.swing.JLabel lblPic1;
    private javax.swing.JLabel lblPic2;
    private javax.swing.JLabel lblPic3;
    private javax.swing.JLabel lblPic4;
    // End of variables declaration//GEN-END:variables
}
