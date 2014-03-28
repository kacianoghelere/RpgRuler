package br.com.rpgruler.main.view.interfaces;

import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.view.bean.DefaultViewBean;

/**
 * Interface para Views
 *
 * @author kaciano
 */
public interface ViewListener {

    /**
     * Metodo padrão para salvar
     *
     * @see
     * br.com.rpgruler.main.view.bean.DefaultViewBean#save(br.com.rpgruler.main.object.BeanEvent)
     */
    void save();

    /**
     * Metodo padrão para deletar
     *
     * @see
     * br.com.rpgruler.main.view.bean.DefaultViewBean#delete(br.com.rpgruler.main.object.BeanEvent)
     */
    void delete();

    /**
     * Metodo padrão para processar os dados
     *
     * @see
     * br.com.rpgruler.main.view.bean.DefaultViewBean#process(br.com.rpgruler.main.object.BeanEvent)
     */
    void process();

    /**
     * Metodo padrão para limpar a tela
     *
     * @see
     * br.com.rpgruler.main.view.bean.DefaultViewBean#clear(br.com.rpgruler.main.object.BeanEvent)
     */
    void clear();

    /**
     * Metodo padrão para carregar a tela
     *
     * @see
     * br.com.rpgruler.main.view.bean.DefaultViewBean#load(br.com.rpgruler.main.object.BeanEvent)
     */
    void load();

    /**
     * Retorna o Bean da View
     *
     * @return <code>BeanListener</code>
     */
    BeanListener getBean();

    /**
     * Retorna a tela principal
     *
     * @return <code>MainScreen</code>
     */
    MainScreen getMainScreen();
}
