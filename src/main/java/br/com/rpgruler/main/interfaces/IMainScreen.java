package br.com.rpgruler.main.interfaces;

import java.awt.event.ActionEvent;

/**
 * Interface da tela principal
 *
 * @author kaciano
 */
public interface IMainScreen {

    /**
     * Metodo padrão para salvar
     *
     * @param evt <code>ActionEvent</code>
     */
    void save(ActionEvent evt);

    /**
     * Metodo padrão para deletar
     *
     * @param evt <code>ActionEvent</code>
     */
    void delete(ActionEvent evt);

    /**
     * Metodo padrão para processar os dados
     *
     * @param evt <code>ActionEvent</code>
     */
    void process(ActionEvent evt);

    /**
     * Metodo padrão para limpar a tela
     *
     * @param evt <code>ActionEvent</code>
     */
    void clear(ActionEvent evt);

    /**
     * Metodo padrão para carregar a tela
     *
     * @param evt <code>ActionEvent</code>
     */
    void load(ActionEvent evt);
}
