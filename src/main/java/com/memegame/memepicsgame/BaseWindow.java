package com.memegame.memepicsgame;

/**
 *
 * @author Ade
 * AHHAHAHAHAHAH WAIT SINGINT KO NALNAG 
 * SO THE USE OF THIS IS TO HAVE A SINGLE SOURCE OF TRUTH
 * AND MAINTAIN THAT EACH WINDOW CAN NAVIGATE TO OTHER :D
 */
public abstract class BaseWindow extends javax.swing.JFrame{
    //Get back!!! jk go back to the previous Jframe window ba
    protected abstract void goBack();
    //Opens another screen and closes this one.
    protected void goTo(BaseWindow next) {
        next.setVisible(true);
        dispose();
    }
}
