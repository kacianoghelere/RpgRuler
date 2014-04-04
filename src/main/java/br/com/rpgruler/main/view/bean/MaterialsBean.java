package br.com.rpgruler.main.view.bean;

import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.MaterialsView;

/**
 * Bean para controle da tela de materiais
 *
 * @author kaciano
 * @version 1.0
 */
public class MaterialsBean extends DefaultViewBean<MaterialsView> {

    public MaterialsBean(MaterialsView view) {
        super(view);
    }

    @Override
    public void save(BeanEvent evt) {

    }

    @Override
    public void delete(BeanEvent evt) {

    }

    @Override
    public void process(BeanEvent evt) {

    }

    @Override
    public void clear(BeanEvent evt) {

    }

    @Override
    public void load(BeanEvent evt) {

    }

    public void add(BeanEvent evt) {
        getView().getTable();
    }

    public void remove(BeanEvent evt) {

    }

}
