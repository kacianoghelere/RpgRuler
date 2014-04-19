package br.com.rpgruler.main.view.armor.bean;

import br.com.rpgruler.data.db.dao.ArmorTypeDAO;
import br.com.rpgruler.data.db.dao.MaterialsDAO;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.armor.ArmorView;
import br.com.rpgruler.main.view.bean.ViewBean;

/**
 * Bean de controle para tela de armaduras
 *
 * @author kaciano
 * @version 1.0
 */
public class ArmorBean extends ViewBean<ArmorView> {

    private ArmorTypeDAO armorTypeDAO;
    private MaterialsDAO materialsDAO;
    
    /**
     * Cria nova instancia de ArmorBean
     *
     * @param view <code>ArmorView</code> Tela de armaduras
     */
    public ArmorBean(ArmorView view) {
        super(view);
        this.armorTypeDAO = new ArmorTypeDAO();
        this.materialsDAO = new MaterialsDAO();
    }

    @Override
    public void save(BeanEvent evt) throws Exception {
        super.save(evt);
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        getView().getArmorTypeModel().setData(armorTypeDAO.getList());
        getView().getMaterialModel1().setData(materialsDAO.getList());
        getView().getMaterialModel2().setData(materialsDAO.getList());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        super.add(evt);
    }

    @Override
    public void build(BeanEvent evt) throws Exception {
        super.build(evt);
    }

}
