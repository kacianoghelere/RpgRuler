package br.com.rpgruler.main.view.bean;

import br.com.gmp.comps.model.GListModel;
import br.com.rpgruler.data.db.dao.EffectDAO;
import br.com.rpgruler.data.db.dao.WearTypeDAO;
import br.com.rpgruler.data.entitity.Effect;
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
    private EffectDAO effectDao;

    /**
     * Cria nova instancia de TermsBean
     *
     * @param view <code>TermsView</code> View
     */
    public TermsBean(TermsView view) {
        super(view);
        this.wtDao = new WearTypeDAO();
        this.effectDao = new EffectDAO();
    }

    @Override
    public void save(BeanEvent evt) throws Exception {
        wtDao.deleteAll();
        effectDao.deleteAll();
        wtDao.insertAll(getView().getWtModel().getData());
        effectDao.insertAll(getView().getEfModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        GListModel<WearType> wtModel = getView().getWtModel();
        wtModel.setData(wtDao.getList());
        GListModel<Effect> efModel = getView().getEfModel();
        efModel.setData(effectDao.getList());
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
     * Adiciona novo elemento na lista de WearTypes
     *
     * @param evt <code>BeanEvent</code> Evento do Bean
     */
    public void addEffect(BeanEvent evt) {
        Long nextId = getNextEffectID();
        Effect type = new Effect(nextId, (String) evt.getValue());
        getView().getEfModel().add(type);
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

    /**
     * Retorna o próximo ID dos Effect
     *
     * @return <code>Long</code> Próximo ID para Effect
     */
    public Long getNextEffectID() {
        Long id = (long) 0;
        for (Effect effect : getView().getEfModel().getData()) {
            if (effect.getId() > id) {
                id = effect.getId();
            }
        }
        return (id + 1);
    }

}
