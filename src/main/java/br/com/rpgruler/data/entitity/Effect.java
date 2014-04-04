package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class Effect implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Código")
    private Long id;
    @Column(name = "Nome")
    private String effectName;
    @Basic(optional = false)
    @Column(name = "Proporção")
    private long strength;

    public Effect() {
    }

    public Effect(Long id) {
        this.id = id;
    }

    public Effect(Long id, String effectName, long strength) {
        this.id = id;
        this.effectName = effectName;
        this.strength = strength;
    }

    public Effect(Long id, long strength) {
        this.id = id;
        this.strength = strength;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEffectName() {
        return effectName;
    }

    public void setEffectName(String effectName) {
        this.effectName = effectName;
    }

    public long getStrength() {
        return strength;
    }

    public void setStrength(long strength) {
        this.strength = strength;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Effect)) {
            return false;
        }
        Effect other = (Effect) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return effectName;
    }

}
