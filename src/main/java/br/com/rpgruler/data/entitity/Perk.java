package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class Perk implements Serializable {

    @Id
    private Long id;
    private String perkName;
    private String perkDescription;
    private Boolean inherited;
    private Effect idEffect;
    private PerkType idPerkType;

    public Perk() {
    }

    public Perk(Long id) {
        this.id = id;
    }

    public Perk(Long id, String perkName, String perkDescription, Boolean inherited, Effect idEffect, PerkType idPerkType) {
        this.id = id;
        this.perkName = perkName;
        this.perkDescription = perkDescription;
        this.inherited = inherited;
        this.idEffect = idEffect;
        this.idPerkType = idPerkType;
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

    public Effect getIdEffect() {
        return idEffect;
    }

    public void setIdEffect(Effect idEffect) {
        this.idEffect = idEffect;
    }

    public PerkType getIdPerkType() {
        return idPerkType;
    }

    public void setIdPerkType(PerkType idPerkType) {
        this.idPerkType = idPerkType;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Perk other = (Perk) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Perk[" + id +"]";
    }

}
