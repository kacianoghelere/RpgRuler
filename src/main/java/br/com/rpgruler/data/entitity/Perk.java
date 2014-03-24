/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "Perk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perk.findAll", query = "SELECT p FROM Perk p"),
    @NamedQuery(name = "Perk.findById", query = "SELECT p FROM Perk p WHERE p.id = :id"),
    @NamedQuery(name = "Perk.findByPerkName", query = "SELECT p FROM Perk p WHERE p.perkName = :perkName"),
    @NamedQuery(name = "Perk.findByPerkDescription", query = "SELECT p FROM Perk p WHERE p.perkDescription = :perkDescription"),
    @NamedQuery(name = "Perk.findByInherited", query = "SELECT p FROM Perk p WHERE p.inherited = :inherited")})
public class Perk implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "perk_name")
    private String perkName;
    @Column(name = "perk_description")
    private String perkDescription;
    @Column(name = "inherited")
    private Boolean inherited;
    @JoinColumn(name = "id_Effect", referencedColumnName = "id")
    @OneToOne
    private Effect idEffect;
    @JoinColumn(name = "id_PerkType", referencedColumnName = "id")
    @OneToOne
    private PerkType idPerkType;

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
