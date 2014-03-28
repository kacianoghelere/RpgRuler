package br.com.rpgruler.main.view;

import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.bean.DefaultViewBean;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.interfaces.ViewListener;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 * View padrão para embasamento
 *
 * @author kaciano
 * @version 1.0
 */
public class DefaultView extends JInternalFrame implements ViewListener {

    private final MainScreen mainScreen;
    private BeanListener bean;
    public Boolean canSave;
    public Boolean canDelete;
    public Boolean canProcces;
    public Boolean canClear;
    public Boolean canLoad;

    /**
     * Cria nova instancia de DefaultView
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     */
    public DefaultView(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        bean = new DefaultViewBean(this);
        initialize();
    }

    /**
     * Metodo de inicialização
     */
    private void initialize() {
        initComponents();
        addInternalFrameListener(new InternalFrameAdapter() {

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                mainScreen.getListener().setActualView(DefaultView.this);
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                mainScreen.getListener().clear();
            }

        });
    }

    @Override
    public Boolean canSave() {
        return canSave;
    }

    @Override
    public void setSave(boolean save) {
        canSave = save;
    }

    @Override
    public Boolean canDelete() {
        return canDelete;
    }

    @Override
    public void setDelete(boolean delete) {
        canDelete = delete;
    }

    @Override
    public Boolean canProcces() {
        return canProcces;
    }

    @Override
    public void setProcces(boolean process) {
        canProcces = process;
    }

    @Override
    public Boolean canClear() {
        return this.canClear;
    }

    @Override
    public void setClear(boolean clear) {
        this.canClear = clear;
    }

    @Override
    public Boolean canLoad() {
        return canLoad;
    }

    @Override
    public void setLoad(boolean load) {
        canLoad = load;
    }

    @Override
    public void save() {
        bean.save(new BeanEvent(this, null));
    }

    @Override
    public void delete() {
        bean.delete(new BeanEvent(this, null));
    }

    @Override
    public void process() {
        bean.process(new BeanEvent(this, null));
    }

    @Override
    public void clear() {
        bean.clear(new BeanEvent(this, null));
    }

    @Override
    public void load() {
        bean.load(new BeanEvent(this, null));
    }

    @Override
    public BeanListener getBean() {
        return bean;
    }

    /**
     * Modifica o bean da view
     *
     * @param bean <code>BeanListener</code> Novo bean
     */
    public void setBean(BeanListener bean) {
        this.bean = bean;
    }

    @Override
    public MainScreen getMainScreen() {
        return this.mainScreen;
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
