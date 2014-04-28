package br.com.rpgruler.main.view.expertise.bean;

import br.com.rpgruler.data.db.dao.ExpertiseDAO;
import br.com.rpgruler.data.db.dao.ExpertiseTypeDAO;
import br.com.rpgruler.data.entity.Attribute;
import br.com.rpgruler.data.entity.Expertise;
import br.com.rpgruler.data.entity.ExpertiseType;
import br.com.rpgruler.data.entity.MainAttributes;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.bean.ViewBean;
import br.com.rpgruler.main.view.expertise.ExpertiseView;
import br.com.rpgruler.main.view.object.ViewWrapper;
import javax.swing.SwingUtilities;

/**
 * Bean de controle para tela de perícias
 *
 * @author kaciano
 * @version 1.0
 */
public class ExpertiseBean extends ViewBean<ExpertiseView> {

    private final ExpertiseDAO dao;
    private final ExpertiseTypeDAO typeDAO;

    /**
     * Cria nova instancia de ExpertiseBean
     *
     * @param view <code>ExpertiseView</code> View do Bean
     */
    public ExpertiseBean(ExpertiseView view) {
        super(view);
        this.dao = new ExpertiseDAO();
        this.typeDAO = new ExpertiseTypeDAO();
    }

    @Override
    public void save(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        getView().getAttrModel().setData(new MainAttributes().getAttributes());
        getView().getTypeModel().setData(typeDAO.getList());
        SwingUtilities.updateComponentTreeUI(getView());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        ViewWrapper vw = evt.getWrapper();
        Long id = getNextID();
        String title = (String) vw.getValue(0);
        Attribute attr = (Attribute) vw.getValue(1);
        ExpertiseType type = (ExpertiseType) vw.getValue(2);
        Integer value = (Integer) vw.getValue(3);
        getView().getModel().add(new Expertise(id, title, type, attr, value));
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
