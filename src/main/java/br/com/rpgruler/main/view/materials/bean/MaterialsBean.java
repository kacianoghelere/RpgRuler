package br.com.rpgruler.main.view.materials.bean;

import br.com.rpgruler.data.db.dao.MaterialsDAO;
import br.com.rpgruler.data.entity.PrimeMaterial;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.materials.MaterialsView;
import br.com.rpgruler.main.view.bean.ViewBean;
import br.com.rpgruler.main.view.object.ViewWrapper;
import java.util.List;

/**
 * Bean para controle da tela de materiais
 *
 * @author kaciano
 * @version 1.0
 */
public class MaterialsBean extends ViewBean<MaterialsView> {

    private MaterialsDAO dao;

    /**
     * Cria nova instancia de MaterialsBean
     *
     * @param view <code>MaterialsView</code> View do Bean
     */
    public MaterialsBean(MaterialsView view) {
        super(view);
        dao = new MaterialsDAO();
    }

    @Override
    public void commit(BeanEvent evt) {
        List<PrimeMaterial> data = getView().getModel().getData();
        dao.deleteAll();
        dao.insertAll(data);
    }

    /**
     * Adiciona novo material na lista da tabela
     *
     * @param evt <code>BeanEvent</code> Evento do bean
     */
    @Override
    public void add(BeanEvent evt) {
        ViewWrapper vw = evt.getWrapper();
        PrimeMaterial pm = new PrimeMaterial();
        pm.setId(getNextID());
        pm.setName((String) vw.getValue(0));
        pm.setMaterialClass((Integer) vw.getValue(1));
        pm.setWeight((Double) vw.getValue(2));
        pm.setResistence(pm.getWeight() * pm.getMaterialClass());
        getView().getModel().add(pm);
    }

    /**
     * Procura pelo próximo ID
     *
     * @return <code>Integer</code> Próximo ID
     */
    private Long getNextID() {
        Long id = (long) 0;
        for (PrimeMaterial mat : getView().getModel().getData()) {
            if (mat.getId() > id) {
                id = mat.getId();
            }
        }
        return (id + 1);
    }
}
