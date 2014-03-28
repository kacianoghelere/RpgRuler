package br.com.rpgruler.main.interfaces;

import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.DefaultView;
import br.com.rpgruler.main.view.interfaces.ViewListener;

/**
 * Interface do bean para a tela principal
 *
 * @author kaciano
 */
public interface MainListener {

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

    /**
     * Volta os dados do frame para o estado inicial
     */
    void clear();

    /**
     * Retorna a View selecionada
     *
     * @return <code>DefaultView</code> View Selecionada
     */
    DefaultView getActualView();

    /**
     * Modifica a view selecionada
     *
     * @param view <code>DefaultView</code> View Selecionada
     */
    void setActualView(DefaultView view);

    /**
     * Insere uma nova view no desktop
     *
     * @param view <code>DefaultView</code> View
     */
    void insertView(DefaultView view);
}
