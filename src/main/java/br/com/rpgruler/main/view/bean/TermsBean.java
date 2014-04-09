package br.com.rpgruler.main.view.bean;

import br.com.rpgruler.data.db.dao.WearTypeDAO;
import br.com.rpgruler.data.entitity.WearType;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.TermsView;
import java.util.List;

/**
 * Bean para TermsView
 *
 * @author kaciano
 * @version 1.0
 */
public class TermsBean extends DefaultViewBean<TermsView> {

    private WearTypeDAO wtDao;

    /**
     * Cria nova instancia de TermsBean
     *
     * @param view <code>TermsView</code> View
     */
    public TermsBean(TermsView view) {
        super(view);
        this.wtDao = new WearTypeDAO();
    }

    @Override
    public void save(BeanEvent evt) throws Exception {
        wtDao.deleteAll();
        List<WearType> data = getView().getWtModel().getData();
        wtDao.insertAll(data);
    }

    /**
     * Adiciona novo elemento na lista de WearTypes
     *
     * @param evt <code>BeanEvent</code> Evento do Bean
     */
    public void addWearType(BeanEvent evt) {
        Long nextId = getNextWTID();
        WearType type = new WearType(nextId, (String) evt.getValue());
        getView().getWtModel().add(type);
    }

    /**
     * Retorna o próximo ID dos WearTypes
     *
     * @return <code>Long</code> Próximo ID para WearType
     */
    public Long getNextWTID() {
        Long id = (long) 0;
        for (WearType type : getView().getWtModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

}
