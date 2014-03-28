package br.com.rpgruler.main.view.interfaces;

import br.com.rpgruler.main.MainScreen;

/**
 * Interface para Views
 *
 * @author kaciano
 */
public interface ViewListener {

    /**
     * Retorna se a View pode salvar
     *
     * @return <code>Boolean</code> Pode salvar
     */
    Boolean canSave();

    /**
     * Retorna se a View pode deletar
     *
     * @return <code>Boolean</code> Pode deletar
     */
    Boolean canDelete();

    /**
     * Retorna se a View pode processar
     *
     * @return <code>Boolean</code> Pode processar
     */
    Boolean canProcces();

    /**
     * Retorna se a View pode limpar
     *
     * @return <code>Boolean</code> Pode limpar
     */
    Boolean canClear();

    /**
     * Retorna se a View pode carregar
     *
     * @return <code>Boolean</code> Pode carregar
     */
    Boolean canLoad();

    /**
     * Modifica a permissão para salvar
     *
     * @param save <code>Boolean</code> Pode salvar
     */
    void setSave(boolean save);

    /**
     * Modifica a permissão para deletar
     *
     * @param delete <code>Boolean</code> Pode deletar
     */
    void setDelete(boolean delete);

    /**
     * Modifica a permissão para processar
     *
     * @param process <code>Boolean</code> Pode processar
     */
    void setProcces(boolean process);

    /**
     * Modifica a permissão para limpar
     *
     * @param clear <code>Boolean</code> Pode limpar
     */
    void setClear(boolean clear);

    /**
     * Modifica a permissão para carregar
     *
     * @param load <code>Boolean</code> Pode carregar
     */
    void setLoad(boolean load);

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
