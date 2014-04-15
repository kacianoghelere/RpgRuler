package br.com.rpgruler.main.util;

import br.com.gmp.utils.reflection.ReflectionUtil;
import br.com.rpgruler.data.db.dao.MenuDAO;
import br.com.rpgruler.data.db.dao.MenuItemDAO;
import br.com.rpgruler.data.entitity.Menu;
import br.com.rpgruler.data.entitity.MenuItem;
import br.com.rpgruler.main.MainScreen;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Classe utilitária para construção de menus e dos respectivos itens
 *
 * @author kaciano
 * @version 1.0
 * @see br.com.rpgruler.data.db.dao.MenuDAO
 * @see br.com.rpgruler.data.db.dao.MenuItemDAO
 * @see br.com.rpgruler.data.entitity.Menu
 * @see br.com.rpgruler.data.entitity.MenuItem
 */
public class MenuBuilder {

    private MainScreen mainScreen;
    private JMenu root;
    private MenuDAO menuDAO;
    private MenuItemDAO viewDAO;

    /**
     * Cria nova instancia de MenuBuilder
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     * @param root <code>JMenu</code> Menu raiz
     */
    public MenuBuilder(MainScreen mainScreen, JMenu root) {
        this.mainScreen = mainScreen;
        this.root = root;
        this.menuDAO = new MenuDAO();
        this.viewDAO = new MenuItemDAO();
    }

    /**
     * Inicia a construção do menu
     */
    public void build() {
        List<Menu> menus = menuDAO.getList();
        List<MenuItem> views = viewDAO.getList();
        build(menus, views, true);
    }

    /**
     * Inicia a construção do menu
     *
     * @param menus <code>List(Menu)</code> Listas de Menus
     * @param views <code>List(MenuView)</code> Listas de MenuViews
     * @param execute <code>boolean</code> O item deve executar a função?
     */
    public void build(List<Menu> menus, List<MenuItem> views, boolean execute) {
        root.removeAll();
        menus.stream().forEach((Menu menu) -> {
            if (menu.getParent() == 0) {
                try {
                    JMenu generated = generateMenu(menu);
                    buildItem(generated, views, execute);
                    root.add(generated);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuBuilder.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            } else {
                menus.stream().filter((parent) -> (parent.getId().equals(menu.getId()))).forEach((Menu parent) -> {
                    for (Component component : root.getComponents()) {
                        if (component instanceof JMenu) {
                            JMenu jmenu = (JMenu) component;
                            if (jmenu.getText().equals(parent.toString())) {
                                try {
                                    JMenu generated = generateMenu(menu);
                                    buildItem(generated, views, execute);
                                    jmenu.add(generated);
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(MenuBuilder.class.getName())
                                            .log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                });
            }
        });
    }

    /**
     * Inicia a construção do menu
     *
     * @param menus <code>List(Menu)</code> Listas de menus
     */
    public void buildMenu(List<Menu> menus) {
        root.removeAll();
        menus.stream().forEach((Menu menu) -> {
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
     * Constroi os items no Menu
     *
     * @param menu <code>JMenu</code> Menu de base
     * @param views <code>List(MenuView)</code> Lista de Views
     * @param execute <code>boolean</code> O item deve executar a função?
     * @throws java.lang.ClassNotFoundException Exceção de classe não encontrada
     */
    public void buildItem(JMenu menu, List<MenuItem> views, boolean execute) throws ClassNotFoundException {
        for (MenuItem view : views) {
            long menuid = Long.parseLong(menu.toString().split("-")[0]);
            if (view.getId().equals(menuid)) {
                JMenuItem item = generateItem(view, execute);
                menu.add(item);
            }
        }
    }

    /**
     * Retorna um JMenu construido a partir de um Menu
     *
     * @param menu <code>Menu</code> Objeto de Menu
     * @return <code>JMenu</code> JMenu gerado
     */
    public JMenu generateMenu(Menu menu) {
        JMenu jmenu = new JMenu();
        jmenu.setText(menu.toString());
        jmenu.setIcon(new ImageIcon(getClass().getResource(menu.getIcon())));
        return jmenu;
    }

    /**
     * Retorna um JMenuItem construido a partir de um MenuItem
     *
     * @param view <code>MenuItem</code> Objeto da View
     * @param execute <code>boolean</code> O item deve executar a função?
     * @return <code>JMenuItem</code> Item criado
     * @throws ClassNotFoundException Exceção de classe não encontrada
     */
    public JMenuItem generateItem(MenuItem view, boolean execute) throws ClassNotFoundException {
        ReflectionUtil reflect = new ReflectionUtil();
        JMenuItem item = new JMenuItem();
        item.setText(view.toString());
        item.setIcon(new ImageIcon(getClass().getResource(view.getIcon())));
        Class<?> objClass = Class.forName(view.getViewClass());
        Class<?>[] argTypes = new Class[]{MainScreen.class};
        Object[] arguments = new Object[]{mainScreen};
        if (execute) {
            item.addActionListener((ActionEvent e) -> {
                try {
                    reflect.newInstance(objClass, argTypes, arguments);
                } catch (InstantiationException ex) {
                    Logger.getLogger(MenuBuilder.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            });
        }
        return item;
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
