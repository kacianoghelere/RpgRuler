package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;

/**
 *
 * @author kaciano
 */
public class Effect implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String effectName;
    @ColumnName(name = "Proporção")
    private long strength;

    /**
     *
     */
    public Effect() {
    }

    /**
     *
     * @param id
     */
    public Effect(Long id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param effectName
     */
    public Effect(Long id, String effectName) {
        this.id = id;
        this.effectName = effectName;
        this.strength = (long) 0;
    }

    /**
     *
     * @param id
     * @param effectName
     * @param strength
     */
    public Effect(Long id, String effectName, long strength) {
        this.id = id;
        this.effectName = effectName;
        this.strength = strength;
    }

    /**
     *
     * @param id
     * @param strength
     */
    public Effect(Long id, long strength) {
        this.id = id;
        this.strength = strength;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getEffectName() {
        return effectName;
    }

    /**
     *
     * @param effectName
     */
    public void setEffectName(String effectName) {
        this.effectName = effectName;
    }

    /**
     *
     * @return
     */
    public long getStrength() {
        return strength;
    }

    /**
     *
     * @param strength
     */
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
