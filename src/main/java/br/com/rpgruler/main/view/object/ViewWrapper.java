package br.com.rpgruler.main.view.object;

import br.com.rpgruler.main.view.View;
import java.util.ArrayList;
import java.util.List;

/**
 * Involcro para transporte de dados entre views e beans
 *
 * @author kaciano
 * @version 1.0
 * @see br.com.rpgruler.main.view.View
 */
public class ViewWrapper {

    private View view;
    private List<Object> values = new ArrayList<>();

    /**
     * Cria nova instancia de ViewWrapper
     *
     * @param view <code>View</code> View do ViewWrapper
     */
    public ViewWrapper(View view) {
        this.view = view;
    }

    /**
     * Adiciona novo valor para ser transportado
     *
     * @param value <code>Object</code> Valor à ser transportado
     */
    public void addValue(Object value) {
        values.add(value);
    }

    /**
     * Limpa os valores carregados
     */
    public void clear() {
        values.clear();
    }

    /**
     * Retorna a View do ViewWrapper
     *
     * @return <code>View</code> View do ViewWrapper
     */
    public View getView() {
        return view;
    }

    /**
     * Modifica a View do ViewWrapper
     *
     * @param view <code>View</code> View do ViewWrapper
     */
    public void setView(View view) {
        this.view = view;
    }

    /**
     * Retorna a lista de valores a serem transportados
     *
     * @return <code>List(Object)</code> Lista de valores
     */
    public List<Object> getValues() {
        return values;
    }

    /**
     * Modifica a lista de valores a serem transportados
     *
     * @param values <code>List(Object)</code> Lista de valores
     */
    public void setValues(List<Object> values) {
        this.values = values;
    }

}
