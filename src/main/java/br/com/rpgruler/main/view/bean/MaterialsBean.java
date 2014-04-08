package br.com.rpgruler.main.view.bean;

import br.com.rpgruler.data.entitity.PrimeMaterial;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.MaterialsView;
import br.com.rpgruler.main.view.model.MaterialsModel;
import br.com.rpgruler.main.view.object.MaterialsParameter;

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

    /**
     * Adiciona novo material na lista da tabela
     *
     * @param evt <code>BeanEvent</code> Evento do bean
     */
    public void add(BeanEvent evt) {
        MaterialsParameter param = (MaterialsParameter) evt.getValue();
        MaterialsModel model = getView().getModel();
        PrimeMaterial pm = new PrimeMaterial();
        pm.setId(Long.MIN_VALUE);
        pm.setMaterialName(param.getMaterialName());
        pm.setMaterialClass(param.getMaterialClass());
        pm.setWeight(param.getMaterialWeight());
        pm.setResistence(pm.getWeight() * pm.getMaterialClass());
        model.add(pm);
    }

    /**
     * Remove um material da lista da tabela
     *
     * @param evt <code>BeanEvent</code> Evento do bean
     */
    public void remove(BeanEvent evt) {        
        getView().getModel().remove((PrimeMaterial[]) evt.getValue());
    }

}
