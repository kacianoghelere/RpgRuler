package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class Effect implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String effectName;
    private Integer strength;

    public Effect() {
    }

    public Effect(Integer id) {
        this.id = id;
    }

    public Effect(Integer id, Integer strength) {
        this.id = id;
        this.strength = strength;
    }

    public Effect(Integer id, String effectName, Integer strength) {
        this.id = id;
        this.effectName = effectName;
        this.strength = strength;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEffectName() {
        return effectName;
    }

    public void setEffectName(String effectName) {
        this.effectName = effectName;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Effect other = (Effect) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Effect[" + id + ", " + effectName + ", " + strength + "]";
    }

}
