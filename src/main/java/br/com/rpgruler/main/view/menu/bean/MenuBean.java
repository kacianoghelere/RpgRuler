package br.com.rpgruler.main.view.menu.bean;

import br.com.rpgruler.data.db.dao.MenuDAO;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.util.MenuBuilder;
import br.com.rpgruler.main.view.bean.DefaultViewBean;
import br.com.rpgruler.main.view.menu.MenuView;

/**
 * Bean de controle para a View de menus
 *
 * @author kaciano
 * @version 1.0
 */
public class MenuBean extends DefaultViewBean<MenuView> {

    private MenuDAO dao;

    /**
     * Cria nova instancia de MenuBean
     *
     * @param view <code>MenuView</code> Tela
     */
    public MenuBean(MenuView view) {
        super(view);
        this.dao = new MenuDAO();
    }

    @Override
    public void process(BeanEvent evt) throws Exception {
        new MenuBuilder(getView().getRoot()).buildMenu(getView().getModel().getData());
    }

    /**
     * Constroi os dados no menu de pré-visualização
     */
    public void buildPreview() {

    }

}
