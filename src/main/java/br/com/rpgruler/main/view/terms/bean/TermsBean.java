package br.com.rpgruler.main.view.terms.bean;

import br.com.gmp.comps.model.GListModel;
import br.com.rpgruler.data.db.dao.EffectTypeDAO;
import br.com.rpgruler.data.db.dao.PerkTypeDAO;
import br.com.rpgruler.data.db.dao.WearTypeDAO;
import br.com.rpgruler.data.entitity.EffectType;
import br.com.rpgruler.data.entitity.PerkType;
import br.com.rpgruler.data.entitity.WearType;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.bean.ViewBean;
import br.com.rpgruler.main.view.terms.TermsView;

/**
 * Bean para TermsView
 *
 * @author kaciano
 * @version 1.0
 */
public class TermsBean extends ViewBean<TermsView> {

    private WearTypeDAO wearTypeDao;
    private EffectTypeDAO effectTypeDAO;
    private PerkTypeDAO perkTypeDao;

    /**
     * Cria nova instancia de TermsBean
     *
     * @param view <code>TermsView</code> View
     */
    public TermsBean(TermsView view) {
        super(view);
        this.wearTypeDao = new WearTypeDAO();
        this.effectTypeDAO = new EffectTypeDAO();
        this.perkTypeDao = new PerkTypeDAO();
    }

    @Override
    public void save(BeanEvent evt) throws Exception {
        wearTypeDao.replaceAll(getView().getWtModel().getData());
        effectTypeDAO.replaceAll(getView().getEfModel().getData());
        perkTypeDao.replaceAll(getView().getPerkModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        GListModel<WearType> wtModel = getView().getWtModel();
        wtModel.setData(wearTypeDao.getList());
        GListModel<EffectType> efModel = getView().getEfModel();
        efModel.setData(effectTypeDAO.getList());
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
     * Adiciona novo elemento na lista de efeitos
     *
     * @param evt <code>BeanEvent</code> Evento do Bean
     */
    public void addEffect(BeanEvent evt) {
        Long nextId = getNextEffectID();
        EffectType type = new EffectType(nextId, (String) evt.getValue());
        getView().getEfModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de PerkTypes
     *
     * @param evt <code>BeanEvent</code> Evento do Bean
     */
    public void addPerk(BeanEvent evt) {
        Long nextId = getNextPerkID();
        PerkType type = new PerkType(nextId, (String) evt.getValue());
        getView().getPerkModel().add(type);
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
        for (EffectType type : getView().getEfModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

    /**
     * Retorna o próximo ID dos PerkTypes
     *
     * @return <code>Long</code> Próximo ID para PerkType
     */
    public Long getNextPerkID() {
        Long id = (long) 0;
        for (PerkType type : getView().getPerkModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

}
