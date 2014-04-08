package br.com.rpgruler.main.view.bean;

import br.com.rpgruler.data.entitity.ArmorType;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.ArmorTypeView;
import br.com.rpgruler.main.view.object.ArmorTypeParameter;

/**
 *
 * @author kaciano
 */
public class ArmorTypeBean extends DefaultViewBean<ArmorTypeView> {

    public ArmorTypeBean(ArmorTypeView view) {
        super(view);
    }

    @Override
    public void save(BeanEvent evt) {
        super.save(evt); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(BeanEvent evt) {
        super.delete(evt); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void process(BeanEvent evt) {
        super.process(evt); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear(BeanEvent evt) {
        super.clear(evt); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load(BeanEvent evt) {
        super.load(evt); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adiciona novo ArmorType na tabela
     *
     * @param evt <code>BeanEvent</code> Evento do bean
     */
    public void add(BeanEvent evt) {
        ArmorTypeParameter param = (ArmorTypeParameter) evt.getValue();
        ArmorType type = new ArmorType(Long.MIN_VALUE, param.getTypeName(),
                param.getMaterialAmount1(), param.getMaterialAmount2());
        type.setId(Long.MIN_VALUE);
        type.setTypeName(param.getTypeName());
        type.setMaterialAmount1(param.getMaterialAmount1());
        type.setMaterialAmount2(param.getMaterialAmount2());
        getView().getModel().add(type);
    }

    /**
     * Remove um ArmorType na tabela
     *
     * @param evt <code>BeanEvent</code> Evento do bean
     */
    public void remove(BeanEvent evt) {
        getView().getModel().remove((ArmorType[]) evt.getValue());
    }

}
