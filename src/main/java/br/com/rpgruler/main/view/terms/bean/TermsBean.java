package br.com.rpgruler.main.view.terms.bean;

import br.com.rpgruler.data.db.dao.EffectTypeDAO;
import br.com.rpgruler.data.db.dao.PerkTypeDAO;
import br.com.rpgruler.data.db.dao.RestrictionTypeDAO;
import br.com.rpgruler.data.db.dao.UseTypeDAO;
import br.com.rpgruler.data.entitity.EffectType;
import br.com.rpgruler.data.entitity.PerkType;
import br.com.rpgruler.data.entitity.RestrictionType;
import br.com.rpgruler.data.entitity.UseType;
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

    private final UseTypeDAO useTypeDao;
    private final EffectTypeDAO effectTypeDAO;
    private final PerkTypeDAO perkTypeDao;
    private final RestrictionTypeDAO restDao;

    /**
     * Cria nova instancia de TermsBean
     *
     * @param view <code>TermsView</code> View
     */
    public TermsBean(TermsView view) {
        super(view);
        this.useTypeDao = new UseTypeDAO();
        this.effectTypeDAO = new EffectTypeDAO();
        this.perkTypeDao = new PerkTypeDAO();
        this.restDao = new RestrictionTypeDAO();
    }

    @Override
    public void save(BeanEvent evt) throws Exception {
        useTypeDao.replaceAll(getView().getUseModel().getData());
        effectTypeDAO.replaceAll(getView().getEfModel().getData());
        perkTypeDao.replaceAll(getView().getPerkModel().getData());
        restDao.replaceAll(getView().getRestModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        getView().getUseModel().setData(useTypeDao.getList());
        getView().getEfModel().setData(effectTypeDAO.getList());
        getView().getPerkModel().setData(perkTypeDao.getList());
        getView().getRestModel().setData(restDao.getList());
    }

    /**
     * Adiciona novo elemento na lista de UseTypes
     *
     * @param evt <code>BeanEvent</code> Evento do Bean
     */
    public void addUseTp(BeanEvent evt) {
        Long nextId = getNextUseID();
        UseType type = new UseType(nextId, (String) evt.getValue());
        getView().getUseModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de efeitos
     *
     * @param evt <code>BeanEvent</code> Evento do Bean
     */
    public void addEffectTp(BeanEvent evt) {
        Long nextId = getNextEffectID();
        EffectType type = new EffectType(nextId, (String) evt.getValue());
        getView().getEfModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de PerkTypes
     *
     * @param evt <code>BeanEvent</code> Evento do Bean
     */
    public void addPerkTp(BeanEvent evt) {
        Long nextId = getNextPerkID();
        PerkType type = new PerkType(nextId, (String) evt.getValue());
        getView().getPerkModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de RestrictionType
     *
     * @param evt <code>BeanEvent</code> Evento do Bean
     */
    public void addRestTp(BeanEvent evt) {
        Long nextId = getNextRestID();
        RestrictionType type = new RestrictionType(nextId, (String) evt.getValue());
        getView().getRestModel().add(type);
    }

    /**
     * Retorna o próximo ID dos UseTypes
     *
     * @return <code>Long</code> Próximo ID para UseType
     */
    public Long getNextUseID() {
        Long id = (long) 0;
        for (UseType type : getView().getUseModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

    /**
     * Retorna o próximo ID dos EffectType
     *
     * @return <code>Long</code> Próximo ID para EffectType
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

    /**
     * Retorna o próximo ID dos RestrictionTypes
     *
     * @return <code>Long</code> Próximo ID para RestrictionType
     */
    public Long getNextRestID() {
        Long id = (long) 0;
        for (RestrictionType type : getView().getRestModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

}
