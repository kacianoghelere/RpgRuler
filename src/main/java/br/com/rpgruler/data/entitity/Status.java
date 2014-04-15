package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;

/**
 *
 * @author kaciano
 */
public class Status implements Serializable {

    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String statusName;
    @ColumnName(name = "Duração")
    private long duration;
    @ColumnName(name = "Efeito")
    private Effect idEffect;

    /**
     *
     */
    public Status() {
    }

    /**
     *
     * @param id
     */
    public Status(Long id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param duration
     */
    public Status(Long id, long duration) {
        this.id = id;
        this.duration = duration;
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
    public String getStatusName() {
        return statusName;
    }

    /**
     *
     * @param statusName
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    /**
     *
     * @return
     */
    public long getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    /**
     *
     * @return
     */
    public Effect getIdEffect() {
        return idEffect;
    }

    /**
     *
     * @param idEffect
     */
    public void setIdEffect(Effect idEffect) {
        this.idEffect = idEffect;
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
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rpgruler.data.entitity.Status[ id=" + id + " ]";
    }

}
