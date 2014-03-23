package br.com.rpgruler.main.bean;

import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.interfaces.MainListener;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.generic.DefaultView;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import javax.swing.JDesktopPane;

/**
 * Bean de controle da tela principal
 *
 * @author kaciano
 */
public class MainScreenBean implements MainListener {

    private MainScreen screen;

    /**
     * Cria nova instancia de MainScreenBean
     *
     * @param mainScreen MainScreen
     */
    public MainScreenBean(MainScreen mainScreen) {
        this.screen = mainScreen;
    }

    @Override
    public void save(BeanEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(BeanEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void process(BeanEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear(BeanEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load(BeanEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultView getActualView() {
        return (DefaultView) this.screen.getDesktop().getSelectedFrame();
    }

    @Override
    public void insertView(DefaultView view) {
        if (!isOnDesktop(view)) {
            screen.getDesktop().add(view);
            screen.getDesktop().setLayer(view, JDesktopPane.FRAME_CONTENT_LAYER);
            System.out.println(view.getSize());
        } else {
            System.out.println("View já está aberta");
        }
    }

    /**
     * Verifica se a View já está na tela
     *
     * @param view DefaultView
     * @return Boolean Está na tela?
     */
    private Boolean isOnDesktop(DefaultView view) {
        boolean inDesktop = false;
        for (Component c : screen.getDesktop().getComponents()) {
            if (c instanceof DefaultView) {
                DefaultView v = (DefaultView) c;
                if (v.equals(view)) {
                    inDesktop = true;
                }
            }
        }
        return inDesktop;
    }

    /**
     * Remove todos os frames da tela principal
     */
    public void clearDesktop() {
        screen.getDesktop().removeAll();
    }

}
