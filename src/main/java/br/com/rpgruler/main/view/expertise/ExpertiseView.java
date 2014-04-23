package br.com.rpgruler.main.view.expertise;

import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.util.Description;
import br.com.rpgruler.main.view.View;
import br.com.rpgruler.main.view.expertise.bean.ExpertiseBean;

/**
 * Tela para cadastro e controle de perícias
 *
 * @author kaciano
 */
public class ExpertiseView extends View {

    private ExpertiseBean bean;

    /**
     * Cria nova instancia de ExpertiseView
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     */
    public ExpertiseView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     *
     */
    private void initialize() {
        initComponents();
        this.bean = new ExpertiseBean(this);
    }

    @Override
    public ExpertiseBean getBean() {
        return bean;
    }

    @Override
    public String getDescription() {
        return new Description()
                .setTitle(getTitle())
                .setDescription("")
                .setSave("")
                .setProcces("")
                .setClear("")
                .setLoad("")
                .format();
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Perícias");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1352_@.png"))); // NOI18N
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
