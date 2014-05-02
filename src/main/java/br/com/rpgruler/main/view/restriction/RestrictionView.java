/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rpgruler.main.view.restriction;

import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.view.View;
import br.com.rpgruler.main.view.interfaces.BeanListener;

/**
 * Tela para cadastro de restrições
 *
 * @author kaciano
 * @version 1.0
 */
public class RestrictionView extends View {

    /**
     * Cria nova instancia de RestrictionView
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     */
    public RestrictionView(MainScreen mainScreen) {
        super(mainScreen);
    }

    /**
     * Método de inicialização
     */
    public void initialize() {
        initComponents();
    }

    @Override
    public BeanListener getBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setTitle("Restrições");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice168_.png"))); // NOI18N
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
