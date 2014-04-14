package br.com.rpgruler.main.util;

import br.com.rpgruler.data.db.dao.MenuDAO;
import br.com.rpgruler.data.db.dao.MenuViewDAO;
import br.com.rpgruler.data.entitity.Menu;
import br.com.rpgruler.main.view.menu.MenuView;
import java.awt.Component;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JMenu;

/**
 * Classe utilitária para construção de menus e dos respectivos itens
 *
 * @author kaciano
 * @version 1.0
 */
public class MenuBuilder {

    private JMenu root;
    private MenuDAO menuDAO;
    private MenuViewDAO viewDAO;

    /**
     * Cria nova instancia de MenuBuilder
     *
     * @param root <code>JMenu</code> Menu raiz
     */
    public MenuBuilder(JMenu root) {
        this.root = root;
        this.menuDAO = new MenuDAO();
        this.viewDAO = new MenuViewDAO();
    }

    /**
     * Inicia a construção do menu
     */
    public void build() {
        List<Menu> menus = menuDAO.getList();
        List<MenuView> views = viewDAO.getList();
    }

    /**
     * Inicia a construção do menu
     *
     * @param menus <code>List(Menu)</code> Listas de Menus
     * @param views <code>List(MenuView)</code> Listas de MenuViews
     */
    public void build(List<Menu> menus, List<MenuView> views) {

    }

    /**
     * Inicia a construção do menu
     *
     * @param menus <code>List(Menu)</code> Listas de menus
     */
    public void buildMenu(List<Menu> menus) {
        root.removeAll();
        menus.stream().forEach((menu) -> {
            if (menu.getParent() == 0) {
                root.add(generateMenu(menu));
            } else {
                menus.stream().filter((parent) -> (parent.getId().equals(menu.getId()))).forEach((parent) -> {
                    for (Component component : root.getComponents()) {
                        if (component instanceof JMenu) {
                            JMenu jmenu = (JMenu) component;
                            if (jmenu.getText().equals(parent.toString())) {
                                jmenu.add(generateMenu(menu));
                            }
                        }
                    }
                });
            }
        });
    }

    /**
     * Retorna um JMenu cosntruido a partir de um Menu
     *
     * @param menu <code>Menu</code> Objeto de MenuF
     * @return <code>JMenu</code> JMenu gerado
     */
    public JMenu generateMenu(Menu menu) {
        JMenu jmenu = new JMenu();
        jmenu.setText(menu.toString());
        jmenu.setIcon(new ImageIcon(getClass().getResource(menu.getIcon())));
        return jmenu;
    }

    /**
     * Retorna o menu raiz
     *
     * @return <code>JMenu</code> Menu raiz
     */
    public JMenu getRoot() {
        return root;
    }

    /**
     * Modifica o menu raiz
     *
     * @param root <code>JMenu</code> Menu raiz
     */
    public void setRoot(JMenu root) {
        this.root = root;
    }

}
