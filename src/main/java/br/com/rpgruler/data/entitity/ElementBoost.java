package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class ElementBoost implements Serializable {

    @Id
    private Integer id;
    private String boostName;
    private Effect idEffect;

    public ElementBoost() {
    }

    public ElementBoost(Integer id) {
        this.id = id;
    }

    public ElementBoost(Integer id, String boostName, Effect idEffect) {
        this.id = id;
        this.boostName = boostName;
        this.idEffect = idEffect;
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
        return boostName;
    }

}
