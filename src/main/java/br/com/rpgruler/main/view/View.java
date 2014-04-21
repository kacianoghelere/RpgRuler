package br.com.rpgruler.main.view;

import br.com.gmp.comps.baloontip.src.BalloonUtil;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.dialog.DescriptionDialog;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.interfaces.ViewListener;
import br.com.rpgruler.main.view.object.ViewParameter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 * View padrão para embasamento
 *
 * @author kaciano
 * @version 1.0
 */
public abstract class View extends JInternalFrame implements ViewListener {

    private final MainScreen mainScreen;
    private Boolean canSave;
    private Boolean canProcess;
    private Boolean canClear;
    private Boolean canLoad;
    private String alias = "";
    private String description = "<html><b>View</b> padrão!</html>";

    /**
     * Cria nova instancia de DefaultView
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     */
    public View(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
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
                mainScreen.getListener().setActualView(View.this);
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                mainScreen.getListener().clear();
            }

        });
        DescribeAction describe = new DescribeAction();
        getRootPane().getActionMap().put("describe", describe);
        getRootPane().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "describe");
    }

    /**
     * Modifica os controles da view
     *
     * @param param <code>ViewParameter</code> Parametro para carregamento de
     * views
     */
    public void setControls(ViewParameter param) {
        this.canSave = param.isSave();
        this.canProcess = param.isProcess();
        this.canClear = param.isClear();
        this.canLoad = param.isLoad();
    }

    /**
     * Descreve o uso da view e suas funções
     *
     * @throws java.lang.Exception Exceção padrão
     */
    public void describe() throws Exception {
        new DescriptionDialog(this, getDescription());        
    }

    /**
     * Classe privada para uso da descrição
     */
    private class DescribeAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                describe();
            } catch (Exception ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * Retorna a descrição da tela
     *
     * @return <code>String</code> Descrição da tela
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica a descrição da tela
     *
     * @param description <code>String</code> Descrição da tela
     */
    public void setDescription(String description) {
        this.description = description;
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
    public Boolean canProcces() {
        return canProcess;
    }

    @Override
    public void setProcces(boolean process) {
        canProcess = process;
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
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        getBean().save(new BeanEvent(View.this, null));
                    } catch (Exception ex) {
                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
            showMessage("Salvo.", MainScreen.SUCCESS_MSG);
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void process() {
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        getBean().process(new BeanEvent(View.this, null));
                    } catch (Exception ex) {
                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
            showMessage("Dados processados.", MainScreen.INFORMATIVE_MSG);
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void clear() {
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        getBean().clear(new BeanEvent(View.this, null));
                    } catch (Exception ex) {
                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
            showMessage("Dados preenchidos removidos.", MainScreen.INFORMATIVE_MSG);
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void load() {
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        getBean().load(new BeanEvent(View.this, null));
                    } catch (Exception ex) {
                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
            showMessage("Dados carregados.", MainScreen.INFORMATIVE_MSG);
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void showMessage(String msg, int type) {
        getMainScreen().printTypedMsg(msg, type);
    }

    @Override
    public void showBalloon(JComponent component, String text) {
        new BalloonUtil().showTimedBallon(component, text);
    }

    @Override
    public abstract BeanListener getBean();

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
