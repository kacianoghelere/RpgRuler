package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class Perk implements Serializable {

    @Id
    @Column(name = "Código")
    private Long id;
    @Column(name = "Nome")
    private String perkName;
    @Column(name = "Descrição")
    private String perkDescription;
    @Column(name = "Herdado")
    private Boolean inherited;
    @Column(name = "Tipo")
    private PerkType perkType;

    public Perk() {
    }

    public Perk(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerkName() {
        return perkName;
    }

    public void setPerkName(String perkName) {
        this.perkName = perkName;
    }

    public String getPerkDescription() {
        return perkDescription;
    }

    public void setPerkDescription(String perkDescription) {
        this.perkDescription = perkDescription;
    }

    public Boolean getInherited() {
        return inherited;
    }

    public void setInherited(Boolean inherited) {
        this.inherited = inherited;
    }

    public PerkType getPerkType() {
        return perkType;
    }

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
