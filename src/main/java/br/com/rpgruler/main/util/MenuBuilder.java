package br.com.rpgruler.main.util;

import br.com.gmp.utils.reflection.ObjectInstance;
import br.com.gmp.utils.reflection.ReflectionUtil;
import br.com.rpgruler.data.db.dao.MenuDAO;
import br.com.rpgruler.data.db.dao.MenuItemDAO;
import br.com.rpgruler.data.entitity.Menu;
import br.com.rpgruler.data.entitity.MenuItem;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.view.View;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

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
     *
     * @throws java.lang.ClassNotFoundException Exceção de classe desconhecida
     */
    public void build() throws ClassNotFoundException {
        List<Menu> menus = menuDAO.getList();
        List<MenuItem> views = viewDAO.getList();
        build(menus, views, true);
    }

    /**
     * Inicia a construção do menu
     *
     * @param menus <code>List(Menu)</code> Listas de Menus
     * @param items <code>List(MenuItem)</code> Listas de MenuItems
     * @param execute <code>boolean</code> O item deve executar a função?
     * @throws java.lang.ClassNotFoundException Exceção de classe desconhecida
     */
    public void build(List<Menu> menus, List<MenuItem> items, boolean execute) throws ClassNotFoundException {
        //Collections.sort(menus);
        //Collections.sort(items);
        buildMenu(menus);
        buildItems(items, execute);
        SwingUtilities.updateComponentTreeUI(root);
    }

    /**
     * Inicia a construção do menu
     *
     * @param menus <code>List(Menu)</code> Listas de menus
     */
    public void buildMenu(List<Menu> menus) {
        root.removeAll();
        //Collections.sort(menus);
        menus.stream().forEach((Menu menu) -> {
            if (menu.getParent() == 0) {
                insertMenu(root, menu);
            } else {
                recursiveMenus(root, menu);
            }
        });
        SwingUtilities.updateComponentTreeUI(root);
    }

    /**
     * Insere um novo menu no menu pai
     *
     * @param parent <code>JMenu</code> Menu pai
     * @param menu <code>Menu</code> Menu à ser inserido
     */
    private void insertMenu(JMenu parent, Menu menu) {
        JMenu jmenu = generateMenu(menu);
        parent.add(jmenu);
    }

    /**
     * Insere os menus recursivamente
     *
     * @param parent <code>JMenu</code> Menu pai
     * @param menu <code>Menu</code> Menu à ser inserido
     */
    private void recursiveMenus(JMenu parent, Menu menu) {
        for (Component comp : parent.getMenuComponents()) {
            JMenu jmenu = (JMenu) comp;
            Long menuid = Long.parseLong(jmenu.getText().split("-")[0].trim());
            if (menu.getParent().equals(menuid)) {
                System.out.println("(INFO) Inserindo em: " + jmenu.getText());
                insertMenu(jmenu, menu);
                break;
            } else {
                recursiveMenus(jmenu, menu);
            }
        }
    }

    /**
     * Constroi os itens nos menus
     *
     * @param items <code>List(MenuItem)</code> Listas de MenuItems
     * @param execute <code>boolean</code> O item deve executar a função?
     * @throws java.lang.ClassNotFoundException Exceção de classe desconhecida
     */
    public void buildItems(List<MenuItem> items, boolean execute) throws ClassNotFoundException {
        //Collections.sort(items);
        for (MenuItem item : items) {
            if (((long) 0) == item.getMenu()) {
                insertItem(root, item, execute);
            } else {
                recursiveItems(root, item, execute);
            }
        }
    }

    /**
     * Constroi os itens recursivamente nos menus
     *
     * @param jmenu <code>JMenu</code> Menu de base
     * @param item <code>MenuItem</code> Item a ser inserido
     * @param execute <code>boolean</code> O item deve executar a função?
     * @throws java.lang.ClassNotFoundException Exceção de classe desconhecida
     */
    public void recursiveItems(JMenu jmenu, MenuItem item, boolean execute) throws ClassNotFoundException {
        for (Component comp : jmenu.getMenuComponents()) {
            JMenu menu = (JMenu) comp;
            Long menuid = Long.parseLong(menu.getText().split("-")[0].trim());
            if (item.getMenu().equals(menuid)) {
                insertItem(menu, item, execute);
                break;
            } else {
                recursiveItems(menu, item, execute);
            }
        }
    }

    /**
     * Insere o item no Menu
     *
     * @param menu <code>JMenu</code> Menu de base
     * @param item <code>List(MenuView)</code> Lista de Views
     * @param execute <code>boolean</code> O item deve executar a função?
     * @throws java.lang.ClassNotFoundException Exceção de classe não encontrada
     */
    private void insertItem(JMenu menu, MenuItem item, boolean execute) throws ClassNotFoundException {
        JMenuItem jitem = generateItem(item, execute);
        menu.add(jitem);
    }

    /**
     * Retorna um JMenu construido a partir de um Menu
     *
     * @param menu <code>Menu</code> Objeto de Menu
     * @return <code>JMenu</code> JMenu gerado
     */
    public JMenu generateMenu(Menu menu) {
        JMenu jmenu = new JMenu();
        jmenu.setName(menu.toString());
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
        ObjectInstance inst = new ObjectInstance(objClass, argTypes, arguments);
        if (execute) {
            item.addActionListener((ActionEvent e) -> {
                try {
                    View newView = (View) reflect.newInstance(inst);
                    mainScreen.getListener().insertView(newView);
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
