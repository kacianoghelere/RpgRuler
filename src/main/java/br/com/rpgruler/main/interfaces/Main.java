package br.com.rpgruler.main.interfaces;

import java.awt.event.ActionEvent;

/**
 * Interface da tela principal
 *
 * @author kaciano
 */
public interface Main {

    /**
     * Metodo padrão para salvar
     *
     * @param evt <code>ActionEvent</code>
     */
    void commit(ActionEvent evt);

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
