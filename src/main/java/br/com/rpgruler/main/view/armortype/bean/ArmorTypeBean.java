package br.com.rpgruler.main.view.armortype.bean;

import br.com.rpgruler.data.db.dao.ArmorTypeDAO;
import br.com.rpgruler.data.entity.ArmorType;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.armortype.ArmorTypeView;
import br.com.rpgruler.main.view.bean.ViewBean;
import br.com.rpgruler.main.view.object.ViewWrapper;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class ArmorTypeBean extends ViewBean<ArmorTypeView> {

    private ArmorTypeDAO dao;

    /**
     * Cria nova instancia de ArmorTypeBean
     *
     * @param view <code>ArmorTypeView</code> View do Bean
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
        ViewWrapper vw = evt.getWrapper();
        ArmorType type = new ArmorType();
        Long nextID = getNextID();
        type.setId(nextID);
        type.setTitle((String) vw.getValue(0));
        type.setMaterialAmount1((Double) vw.getValue(1));
        type.setMaterialAmount2((Double) vw.getValue(2));
        type.setBase((Double) vw.getValue(3));
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
