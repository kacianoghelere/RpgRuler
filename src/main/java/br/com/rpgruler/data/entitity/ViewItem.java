package br.com.rpgruler.data.entitity;

import java.util.Objects;

/**
 * Objeto para criação de atalhos das telas
 *
 * @author kaciano
 */
public class ViewItem {

    private Long id;
    private Long parent;
    private String objClass;
    private String title;
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
     * @param parent <code>Long</code> ID do menu pai
     * @param objClass <code>String</code> Classe do MenuView
     * @param title <code>String</code> Titulo do MenuView
     * @param icon <code>String</code> Icone do MenuViewMenuView
     */
    public ViewItem(Long id, Long parent, String objClass, String title, String icon) {
        this.id = id;
        this.parent = parent;
        this.objClass = objClass;
        this.title = title;
        this.icon = icon;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.parent);
        hash = 89 * hash + Objects.hashCode(this.objClass);
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
        if (!Objects.equals(this.parent, other.parent)) {
            return false;
        }
        if (!Objects.equals(this.objClass, other.objClass)) {
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
    public Long getParent() {
        return parent;
    }

    /**
     * Modifica o ID do menu pai
     *
     * @param parent <code>Long</code> ID do menu pai
     */
    public void setParent(Long parent) {
        this.parent = parent;
    }

    /**
     * Retorna a classe do ViewItem
     *
     * @return <code>String</code> Classe do ViewItem
     */
    public String getObjClass() {
        return objClass;
    }

    /**
     * Retorna a classe do ViewItem
     *
     * @param objClass <code>String</code> Classe do ViewItem
     */
    public void setObjClass(String objClass) {
        this.objClass = objClass;
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
