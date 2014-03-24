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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Effect")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Effect.findAll", query = "SELECT e FROM Effect e"),
    @NamedQuery(name = "Effect.findById", query = "SELECT e FROM Effect e WHERE e.id = :id"),
    @NamedQuery(name = "Effect.findByEffectName", query = "SELECT e FROM Effect e WHERE e.effectName = :effectName"),
    @NamedQuery(name = "Effect.findByStrength", query = "SELECT e FROM Effect e WHERE e.strength = :strength")})
public class Effect implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "effect_name")
    private String effectName;
    @Basic(optional = false)
    @Column(name = "strength")
    private long strength;
    @OneToOne(mappedBy = "idEffect")
    private Status status;
    @OneToOne(mappedBy = "idEffect")
    private ElementBoost elementBoost;
    @OneToOne(mappedBy = "idEffect")
    private ElementWeakness elementWeakness;
    @OneToOne(mappedBy = "idEffect")
    private Perk perk;

    public Effect() {
    }

    public Effect(Long id) {
        this.id = id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ElementBoost getElementBoost() {
        return elementBoost;
    }

    public void setElementBoost(ElementBoost elementBoost) {
        this.elementBoost = elementBoost;
    }

    public ElementWeakness getElementWeakness() {
        return elementWeakness;
    }

    public void setElementWeakness(ElementWeakness elementWeakness) {
        this.elementWeakness = elementWeakness;
    }

    public Perk getPerk() {
        return perk;
    }

    public void setPerk(Perk perk) {
        this.perk = perk;
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
        return "br.com.rpgruler.data.entitity.Effect[ id=" + id + " ]";
    }
    
}
