package br.com.rpgruler.main.view.generic;

import br.com.rpgruler.main.view.bean.DefaultViewBean;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.interfaces.ViewListener;
import javax.swing.JInternalFrame;

/**
 *
 * @author kaciano
 */
public class DefaultView extends JInternalFrame implements ViewListener {

    /**
     * Creates new form DefaultView
     */
    public DefaultView() {
        initialize();
    }

    /**
     * Metodo de inicialização
     */
    private void initialize() {
        initComponents();
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void process() {

    }

    @Override
    public void clear() {

    }

    @Override
    public void load() {

    }

    @Override
    public BeanListener getBean() {
        return new DefaultViewBean();
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(498, 394));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(498, 394));
        setVisible(true);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
