package br.com.rpgruler.system;

import br.com.rpgruler.main.MainScreen;

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
     *
     * @param args
     */
    public static void main(String[] args) {
        SystemControl systemControl = new SystemControl();
    }
}
