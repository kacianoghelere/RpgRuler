package br.com.rpgruler.main.view.perk.bean;

import br.com.rpgruler.data.db.dao.PerkDAO;
import br.com.rpgruler.data.entitity.Perk;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.perk.PerkView;
import br.com.rpgruler.main.view.bean.ViewBean;

/**
 * Bean de controle para a PerkView
 *
 * @author kaciano
 */
public class PerkBean extends ViewBean<PerkView> {

    private PerkDAO dao;

    /**
     * Cria nova instancia de PerkBean
     *
     * @param view <code>PerkView</code> View do Bean
     */
    public PerkBean(PerkView view) {
        super(view);
        this.dao = new PerkDAO();
    }

    @Override
    public void save(BeanEvent evt) throws Exception {
        this.dao.replaceAll(getView().getModel().getData());
    }

    /**
     * Adiciona novo item na tabela
     *
     * @param evt <code>BeanEvent</code> Evento
     */
    @Override
    public void add(BeanEvent evt) {

    }

        /**
     * Retorna o próximo ID da lista
     *
     * @return <code>Long</code> Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Perk perk : getView().getModel().getData()) {
            if (id < perk.getId()) {
                id = perk.getId();
            }
        }
        return (id + 1);
    }
}
