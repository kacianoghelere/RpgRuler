package br.com.rpgruler.main.view.interfaces;

import br.com.rpgruler.main.object.BeanEvent;

/**
 *
 * @author kaciano
 */
public interface BeanListener {

    /**
     * Metodo padrão para salvar
     *
     * @param evt <code>BeanEvent</code> Evento
     */
    void save(BeanEvent evt);

    /**
     * Metodo padrão para deletar
     *
     * @param evt <code>BeanEvent</code> Evento
     */
    void delete(BeanEvent evt);

    /**
     * Metodo padrão para processar os dados
     *
     * @param evt <code>BeanEvent</code> Evento
     */
    void process(BeanEvent evt);

    /**
     * Metodo padrão para limpar a tela
     *
     * @param evt <code>BeanEvent</code> Evento
     */
    void clear(BeanEvent evt);

    /**
     * Metodo padrão para carregar a tela
     *
     * @param evt <code>BeanEvent</code> Evento
     */
    void load(BeanEvent evt);
}
