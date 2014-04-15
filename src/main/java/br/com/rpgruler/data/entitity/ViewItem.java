package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import java.util.Objects;

/**
 * Objeto para criação de atalhos das telas
 *
 * @author kaciano
 */
public class ViewItem {

    @ColumnName(name = "ID")
    private Long id;
    @ColumnName(name = "Menu")
    private Long menu;
    @ColumnName(name = "Titulo")
    private String title;    
    @ColumnName(name = "Classe")
    private String viewClass;
    @ColumnName(name = "Ícone")
    private String icon;

    /**
     * Cria nova instancia de Menu
     */
    public ViewItem() {
    }

    /**
     * Cria nova instancia de Menu
     *
     * @param id <code>Long</code> ID do MenuView
     * @param parent <code>Long</code> ID do menu
     * @param viewClass <code>String</code> Classe do MenuView
     * @param title <code>String</code> Titulo do MenuView
     * @param icon <code>String</code> Icone do MenuViewMenuView
     */
    public ViewItem(Long id, Long parent, String viewClass, String title, String icon) {
        this.id = id;
        this.menu = parent;
        this.viewClass = viewClass;
        this.title = title;
        this.icon = icon;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.menu);
        hash = 89 * hash + Objects.hashCode(this.viewClass);
        hash = 89 * hash + Objects.hashCode(this.title);
        hash = 89 * hash + Objects.hashCode(this.icon);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ViewItem other = (ViewItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.menu, other.menu)) {
            return false;
        }
        if (!Objects.equals(this.viewClass, other.viewClass)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return Objects.equals(this.icon, other.icon);
    }

    @Override
    public String toString() {
        return id + " - " + title;
    }

    /**
     * Retorna o ID do ViewItem
     *
     * @return <code>Long</code> ID do ViewItem
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do ViewItem
     *
     * @param id <code>Long</code> ID do ViewItem
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o ID do menu pai
     *
     * @return <code>Long</code> ID do menu pai
     */
    public Long getMenu() {
        return menu;
    }

    /**
     * Modifica o ID do menu pai
     *
     * @param menu <code>Long</code> ID do menu pai
     */
    public void setMenu(Long menu) {
        this.menu = menu;
    }

    /**
     * Retorna a classe do ViewItem
     *
     * @return <code>String</code> Classe do ViewItem
     */
    public String getViewClass() {
        return viewClass;
    }

    /**
     * Retorna a classe do ViewItem
     *
     * @param viewClass <code>String</code> Classe do ViewItem
     */
    public void setViewClass(String viewClass) {
        this.viewClass = viewClass;
    }

    /**
     * Retorna o titulo do ViewItem
     *
     * @return <code>String</code> Titulo do ViewItem
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o titulo do ViewItem
     *
     * @param title <code>String</code> Titulo do ViewItem
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna o icone do ViewItem
     *
     * @return <code>String</code> Icone do ViewItem
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Modifica o icone do ViewItem
     *
     * @param icon <code>String</code> Icone do ViewItem
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

}
