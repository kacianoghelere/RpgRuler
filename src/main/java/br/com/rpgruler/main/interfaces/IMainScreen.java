package br.com.rpgruler.main.interfaces;

/**
 * Interface da tela principal
 *
 * @author kaciano
 */
public interface IMainScreen {

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
}
