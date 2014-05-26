package br.com.rpgruler.main.view.object;

import br.com.rpgruler.main.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Involcro para transporte de dados entre views e beans
 *
 * @author kaciano
 * @version 1.0
 * @see br.com.rpgruler.main.view.View
 */
public class ViewWrapper {

    private View view;
    private final List<Object> list = new ArrayList<>();
    private final Map<String, Object> map = new HashMap<>();

    /**
     * Cria nova instancia de ViewWrapper
     *
     * @param view <code>View</code> View do ViewWrapper
     */
    public ViewWrapper(View view) {
        this.view = view;
    }

    /**
     * Adiciona novo valor na lista para ser transportado
     *
     * @param value <code>Object</code> Valor à ser transportado
     * @return <code>ViewWrapper</code> Wrapper
     */
    public ViewWrapper addValue(Object value) {
        list.add(value);
        return this;
    }

    /**
     * Adiciona novo valor no mapa para ser transportado
     *
     * @param key <code>String</code> Chave do valor
     * @param value <code>Object</code> Valor à ser transportado
     * @return <code>ViewWrapper</code> Wrapper
     */
    public ViewWrapper addValue(String key, Object value) {
        map.put(key, value);
        return this;
    }

    /**
     * Retorna o objeto carregado na posição indicada
     *
     * @param index <code>int</code> Posição do objeto
     * @return <code>Object</code> Valor transportado
     * @throws java.lang.Exception Exceção lançada
     */
    public Object getValue(int index) throws Exception {
        return list.get(index);
    }

    /**
     * Retorna o objeto carregado na posição indicada
     *
     * @param key <code>int</code> Chave do objeto
     * @return <code>Object</code> Valor transportado
     * @throws java.lang.Exception Exceção lançada
     */
    public Object getValue(String key) throws Exception {
        return map.get(key);
    }

    /**
     * Limpa todos os valores carregados
     */
    public void clear() {
        list.clear();
        map.clear();
    }

    /**
     * Limpa todos os valores carregados na lista
     */
    public void clearList() {
        list.clear();
    }

    /**
     * Limpa todos os valores carregados no mapa
     */
    public void clearMap() {
        map.clear();
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
     * Retorna a lista de valores transportados
     *
     * @return <code>List(Object)</code> Lista de valores
     */
    public List<Object> getList() {
        return list;
    }

    /**
     * Retorna o mapa de valores transportados
     *
     * @return <code>Map(String, Object)</code> Mapa de valores
     */
    public Map<String, Object> getMap() {
        return map;
    }

}
