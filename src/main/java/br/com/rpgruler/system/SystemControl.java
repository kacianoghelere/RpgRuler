package br.com.rpgruler.system;

import br.com.rpgruler.main.MainScreen;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Classe de inicialização da aplicação
 *
 * @author kaciano
 */
public class SystemControl {

    /**
     * Cria nova instancia de SystemControl
     */
    public SystemControl() {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainScreen().setVisible(true);
        });
    }

    /**
     * Método de inicialização principal
     *
     * @param args Argumentos
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SystemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        SystemControl systemControl = new SystemControl();
    }
}
