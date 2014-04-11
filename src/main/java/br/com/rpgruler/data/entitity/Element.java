package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author kaciano
 */
public class Element implements Serializable {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String elementName;
    @ColumnName(name = "Simbolo")
    private String elementSymbol;
    @ColumnName(name = "Bonûs")
    private Element bonus;
    @ColumnName(name = "Fraqueza")
    private Element weakness;

    public Element() {
    }

    public Element(Long id) {
        this.id = id;
    }

    public Element(Long id, String elementName, String elementSymbol) {
        this.id = id;
        this.elementName = elementName;
        this.elementSymbol = elementSymbol;
    }

    public Element(Long id, String elementName, String elementSymbol, Element bonus, Element weakness) {
        this.id = id;
        this.elementName = elementName;
        this.elementSymbol = elementSymbol;
        this.bonus = bonus;
        this.weakness = weakness;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementSymbol() {
        return elementSymbol;
    }

    public void setElementSymbol(String elementSymbol) {
        this.elementSymbol = elementSymbol;
    }

    public Element getBonus() {
        return bonus;
    }

    public void setBonus(Element bonus) {
        this.bonus = bonus;
    }

    public Element getWeakness() {
        return weakness;
    }

    public void setWeakness(Element weakness) {
        this.weakness = weakness;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.elementName);
        hash = 53 * hash + Objects.hashCode(this.elementSymbol);
        hash = 53 * hash + Objects.hashCode(this.bonus);
        hash = 53 * hash + Objects.hashCode(this.weakness);
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
        final Element other = (Element) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.elementName, other.elementName)) {
            return false;
        }
        if (!Objects.equals(this.elementSymbol, other.elementSymbol)) {
            return false;
        }
        if (!Objects.equals(this.bonus, other.bonus)) {
            return false;
        }
        return Objects.equals(this.weakness, other.weakness);
    }

    @Override
    public String toString() {
        return elementName;
    }

}
