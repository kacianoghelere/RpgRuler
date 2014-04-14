package br.com.rpgruler.main.view.menu.bean;

import br.com.rpgruler.data.db.dao.MenuDAO;
import br.com.rpgruler.data.entitity.Menu;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.util.MenuBuilder;
import br.com.rpgruler.main.view.bean.DefaultViewBean;
import br.com.rpgruler.main.view.menu.MenuView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

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
        System.out.println( getMenuIcons().length);
        getView().getIconModel().setData(getMenuIcons());
        getView().getParentModel().setData(getParentMenus());
    }

    @Override
    public void process(BeanEvent evt) throws Exception {
        buildPreview();
    }

    /**
     * Constroi os dados no menu de pré-visualização
     */
    public void buildPreview() {
        new MenuBuilder(getView().getMainScreen(), getView().getRoot())
                .buildMenu(getView().getModel().getData());
    }

    /**
     * Retorna o próximo ID da lista
     *
     * @return <code>Long</code> Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Menu menu : getView().getModel().getData()) {
            if (id < menu.getId()) {
                id = menu.getId();
            }
        }
        return id + 1;
    }

    /**
     * Retorna um array com os icones possiveis para menus
     *
     * @return <code>ImageIcon[]</code> Array de iconess
     */
    private ImageIcon[] getMenuIcons() {
        String path = "/RpgIcons/misc/";
        List<ImageIcon> icons = new ArrayList<>();
        File dir = new File(getClass().getResource(path).getFile());
        for (File file : dir.listFiles()) {
            icons.add(new ImageIcon(getClass().getResource(path + file.getName())));
        }
        return icons.toArray(new ImageIcon[]{});
    }

    /**
     * Retorna lista de menus superiores
     *
     * @return <code>List(Menu)</code>
     */
    private List<Menu> getParentMenus() {
        List<Menu> parents = new ArrayList<>();
        parents.add(new Menu((long) 0, "Raiz", null));
        dao.getList().stream().forEach((menu) -> {
            parents.add(menu);
        });
        return parents;
    }

}
