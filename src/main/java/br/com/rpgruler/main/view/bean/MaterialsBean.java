package br.com.rpgruler.main.view.bean;

import br.com.rpgruler.data.db.dao.MaterialsDAO;
import br.com.rpgruler.data.entitity.PrimeMaterial;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.MaterialsView;
import br.com.rpgruler.main.view.model.MaterialsModel;
import br.com.rpgruler.main.view.object.MaterialsParameter;
import java.util.List;

/**
 * Bean para controle da tela de materiais
 *
 * @author kaciano
 * @version 1.0
 */
public class MaterialsBean extends DefaultViewBean<MaterialsView> {

    private MaterialsDAO dao;

    public MaterialsBean(MaterialsView view) {
        super(view);
        dao = new MaterialsDAO();
    }

    @Override
    public void save(BeanEvent evt) {
        List<PrimeMaterial> data = getView().getModel().getData();
        dao.deleteAll();
        dao.insertAll(data);
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
        Long nextID = getNextID();
        pm.setId(nextID);
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

    /**
     * Procura pelo próximo ID
     *
     * @return <code>Integer</code> Próximo ID
     */
    private Long getNextID() {
        Long id = new Long(0);
        for (PrimeMaterial mat : getView().getModel().getData()) {
            if (mat.getId() > id) {
                id = mat.getId();
            }
        }
        return (id + 1);
    }
}
