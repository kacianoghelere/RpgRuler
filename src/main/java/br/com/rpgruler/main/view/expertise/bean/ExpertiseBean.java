package br.com.rpgruler.main.view.expertise.bean;

import br.com.rpgruler.data.db.dao.ExpertiseDAO;
import br.com.rpgruler.data.entitity.Attribute;
import br.com.rpgruler.data.entitity.Expertise;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.bean.ViewBean;
import br.com.rpgruler.main.view.expertise.ExpertiseView;
import br.com.rpgruler.main.view.object.ViewWrapper;

/**
 * Bean de controle para tela de perícias
 *
 * @author kaciano
 * @version 1.0
 */
public class ExpertiseBean extends ViewBean<ExpertiseView> {

    private ExpertiseDAO dao;

    /**
     * Cria nova instancia de ExpertiseBean
     *
     * @param view <code>ExpertiseView</code> View do Bean
     */
    public ExpertiseBean(ExpertiseView view) {
        super(view);
        this.dao = new ExpertiseDAO();
    }

    @Override
    public void save(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        ViewWrapper vw = evt.getWrapper();
        String title = (String) vw.getValue(0);
        Attribute attr = (Attribute) vw.getValue(1);
        Integer value = (Integer) vw.getValue(2);
        getView().getModel().add(new Expertise(getNextID(), title, attr, value));
    }

    /**
     * Retorna o próximo ID da lista
     *
     * @return <code>Long</code> Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Expertise exp : getView().getModel().getData()) {
            if (id < exp.getId()) {
                id = exp.getId();
            }
        }
        return (id + 1);
    }
}
