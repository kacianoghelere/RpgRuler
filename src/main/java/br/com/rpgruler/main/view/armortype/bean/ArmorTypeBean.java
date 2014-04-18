package br.com.rpgruler.main.view.armortype.bean;

import br.com.rpgruler.data.db.dao.ArmorTypeDAO;
import br.com.rpgruler.data.entitity.ArmorType;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.armortype.ArmorTypeView;
import br.com.rpgruler.main.view.bean.ViewBean;
import br.com.rpgruler.main.view.armortype.object.ArmorTypeParameter;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class ArmorTypeBean extends ViewBean<ArmorTypeView> {

    private ArmorTypeDAO dao;

    /**
     *
     * @param view
     */
    public ArmorTypeBean(ArmorTypeView view) {
        super(view);
        dao = new ArmorTypeDAO();
    }

    @Override
    public void save(BeanEvent evt) throws Exception {
        List<ArmorType> data = getView().getModel().getData();
        dao.deleteAll();
        dao.insertAll(data);
    }

    /**
     * Adiciona novo ArmorType na tabela
     *
     * @param evt <code>BeanEvent</code> Evento do bean
     */
    @Override
    public void add(BeanEvent evt) {
        ArmorTypeParameter param = (ArmorTypeParameter) evt.getValue();
        ArmorType type = new ArmorType(Long.MIN_VALUE, param.getTypeName(),
                param.getMaterialAmount1(), param.getMaterialAmount2());
        Long nextID = getNextID();
        type.setId(nextID);
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

    /**
     * Procura pelo próximo ID
     *
     * @return <code>Integer</code> Próximo ID
     */
    private Long getNextID() {
        Long id = (long) 0;
        for (ArmorType type : getView().getModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

}
