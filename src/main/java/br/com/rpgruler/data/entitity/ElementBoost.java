package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class ElementBoost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String boostName;
    private Effect idEffect;
    private Element element;

    public ElementBoost() {
    }

    public ElementBoost(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoostName() {
        return boostName;
    }

    public void setBoostName(String boostName) {
        this.boostName = boostName;
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
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final ElementBoost other = (ElementBoost) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "ElementBoost[" + id + "]";
    }

}
