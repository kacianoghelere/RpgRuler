package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;

/**
 *
 * @author kaciano
 */
public class Perk implements Serializable {

    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String perkName;
    @ColumnName(name = "Descrição")
    private String perkDescription;
    @ColumnName(name = "Herdado")
    private Boolean inherited;
    @ColumnName(name = "Tipo")
    private PerkType perkType;

    /**
     *
     */
    public Perk() {
    }

    /**
     *
     * @param id
     */
    public Perk(Long id) {
        this.id = id;
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
    public String getPerkName() {
        return perkName;
    }

    /**
     *
     * @param perkName
     */
    public void setPerkName(String perkName) {
        this.perkName = perkName;
    }

    /**
     *
     * @return
     */
    public String getPerkDescription() {
        return perkDescription;
    }

    /**
     *
     * @param perkDescription
     */
    public void setPerkDescription(String perkDescription) {
        this.perkDescription = perkDescription;
    }

    /**
     *
     * @return
     */
    public Boolean getInherited() {
        return inherited;
    }

    /**
     *
     * @param inherited
     */
    public void setInherited(Boolean inherited) {
        this.inherited = inherited;
    }

    /**
     *
     * @return
     */
    public PerkType getPerkType() {
        return perkType;
    }

    /**
     *
     * @param perkType
     */
    public void setPerkType(PerkType perkType) {
        this.perkType = perkType;
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
        if (!(object instanceof Perk)) {
            return false;
        }
        Perk other = (Perk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rpgruler.data.entitity.Perk[ id=" + id + " ]";
    }

}
