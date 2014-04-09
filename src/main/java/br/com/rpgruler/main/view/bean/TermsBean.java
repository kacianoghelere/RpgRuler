package br.com.rpgruler.main.view.bean;

import br.com.rpgruler.data.entitity.WearType;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.TermsView;

/**
 * Bean para TermsView
 *
 * @author kaciano
 * @version 1.0
 */
public class TermsBean extends DefaultViewBean<TermsView> {

    /**
     * Cria nova instancia de TermsBean
     *
     * @param view <code>TermsView</code> View
     */
    public TermsBean(TermsView view) {
        super(view);
    }

    @Override
    public void save(BeanEvent evt) throws Exception {

    }

    /**
     * Retorna o próximo ID dos WearTypes
     *
     * @return <code>Long</code> Próximo ID para WearType
     */
    public Long getNextWearTypeID() {
        Long id = new Long(0);
        for (WearType type : getView().getWtModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

}
