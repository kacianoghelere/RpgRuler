package br.com.rpgruler.main.view.weapontype.bean;

import br.com.rpgruler.data.db.dao.WeaponTypeDAO;
import br.com.rpgruler.data.db.dao.UseTypeDAO;
import br.com.rpgruler.data.db.dao.WeaponSizeDAO;
import br.com.rpgruler.data.entity.WeaponType;
import br.com.rpgruler.data.entity.UseType;
import br.com.rpgruler.data.entity.WeaponSize;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.bean.ViewBean;
import br.com.rpgruler.main.view.object.ViewWrapper;
import br.com.rpgruler.main.view.weapontype.WeaponTypeView;

/**
 * Bean de controle para WeaponTypeView
 *
 * @author kaciano
 */
public class WeaponTypeBean extends ViewBean<WeaponTypeView> {

    private final WeaponTypeDAO dao;

    /**
     * Cria nova instancia de WeaponTypeBean
     *
     * @param view <code>WeaponTypeView</code> View do Bean
     */
    public WeaponTypeBean(WeaponTypeView view) {
        super(view);
        this.dao = new WeaponTypeDAO();
        getView().getUseModel().setData(new UseTypeDAO().getList());
    }

    @Override
    public void save(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        getView().getUseModel().setData(new UseTypeDAO().getList());
        getView().getSizeModel().setData(new WeaponSizeDAO().getList());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        Long nextID = getNextID();
        ViewWrapper vw = evt.getWrapper();
        WeaponType type = new WeaponType();
        type.setId(nextID);
        type.setTypeName((String) vw.getValue(0));
        type.setCategory((Integer) vw.getValue(1));
        type.setDamageBase((Double) vw.getValue(2));
        type.setWearType((UseType) vw.getValue(3));
        type.setMaterialAmount1((Double) vw.getValue(4));
        type.setMaterialAmount2((Double) vw.getValue(5));
        type.setSize((WeaponSize) vw.getValue(6));
        type.setRange((Integer) vw.getValue(7));
        getView().getModel().add(type);
    }

    /**
     * Procura pelo próximo ID
     *
     * @return <code>Integer</code> Próximo ID
     */
    private Long getNextID() {
        Long id = (long) 0;
        for (WeaponType type : getView().getModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }
}
