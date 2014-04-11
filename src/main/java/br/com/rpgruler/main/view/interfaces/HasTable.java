package br.com.rpgruler.main.view.interfaces;

import br.com.gmp.comps.model.GTableModel;
import br.com.gmp.comps.table.GTable;

/**
 * Interface padrão para views que contem dados em tabelas
 *
 * @author kaciano
 * @version 1.0
 */
public interface HasTable {

    /**
     * Adiciona um item na tabela
     */
    void add();

    /**
     * Remove um item na tabela
     */
    void remove();

    /**
     * Retorna a tabela
     *
     * @return <code>GTable</code>
     */
    GTable getTable();

    /**
     * Retorna o modelo da tabela
     *
     * @return <code>GTableModel</code>
     */
    GTableModel getModel();
}
