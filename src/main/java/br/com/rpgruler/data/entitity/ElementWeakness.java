package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class ElementWeakness implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String weaknessName;
    private Effect idEffect;
    private Element element;

    public ElementWeakness() {
    }

    public ElementWeakness(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeaknessName() {
        return weaknessName;
    }

    public void setWeaknessName(String weaknessName) {
        this.weaknessName = weaknessName;
    }

    public Effect getIdEffect() {
        return idEffect;
    }

    public void setIdEffect(Effect idEffect) {
        this.idEffect = idEffect;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final ElementWeakness other = (ElementWeakness) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ElementWeakness[" + id + "]";
    }

}
