package br.com.rpgruler.main.view.interfaces;

import br.com.rpgruler.main.view.bean.DefaultViewBean;

/**
 * Interface para Views
 *
 * @author kaciano
 */
public interface ViewListener {

    /**
     * Metodo padrão para salvar
     */
    void save();

    /**
     * Metodo padrão para deletar
     */
    void delete();

    /**
     * Metodo padrão para processar os dados
     */
    void process();

    /**
     * Metodo padrão para limpar a tela
     */
    void clear();

    /**
     * Metodo padrão para carregar a tela
     */
    void load();

    /**
     * Retorna o Bean da View
     *
     * @return BeanListener
     */
    BeanListener getBean();
}
