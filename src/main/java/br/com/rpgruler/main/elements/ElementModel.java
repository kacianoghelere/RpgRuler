package br.com.rpgruler.main.elements;

import br.com.rpgruler.data.entitity.Element;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Modelo de tabela para elementos
 *
 * @author kaciano
 */
public class ElementModel extends AbstractTableModel {

    private List<Element> data;
    private String[] columns = {"ID", "Titulo", "Simbolo"};

    public ElementModel() {
        data = new ArrayList<>();
    }

    public ElementModel(List data) {
        this.data = data;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return data.get(row).getId();
            case 1:
                return data.get(row).getElementName();
            case 2:
                return data.get(row).getElementSymbol();
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int index) {
        switch (index) {
            case 0:
                return Long.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            default:
                return String.class;
        }
    }

    /**
     * Retorna o objeto da linha selecionada
     *
     * @param index Endereço do elemento
     * @return Element
     */
    public Element getObject(int index) {
        try {
            return data.get(index);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Adiciona novo Element
     *
     * @param element Element
     */
    public void add(Element element) {
        if (element != null) {
            this.data.add(element);
            fireTableDataChanged();
        }
    }

    /**
     * Remove o Element indicado
     *
     * @param element Element
     */
    public void delete(Element element) {
        if (element != null && data.contains(element)) {
            this.data.remove(element);
            fireTableDataChanged();
        }
    }

    /**
     * Limpa o modelo
     */
    public void clear() {
        data.clear();
    }

    public List<Element> getData() {
        return data;
    }

    public void setData(List<Element> data) {
        if (data != null) {
            this.data = data;
            fireTableDataChanged();
        }
    }

}
