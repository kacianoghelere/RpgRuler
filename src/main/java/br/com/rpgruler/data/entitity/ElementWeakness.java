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
@Table(name = "ElementWeakness")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ElementWeakness.findAll", query = "SELECT e FROM ElementWeakness e"),
    @NamedQuery(name = "ElementWeakness.findById", query = "SELECT e FROM ElementWeakness e WHERE e.id = :id"),
    @NamedQuery(name = "ElementWeakness.findByWeaknessName", query = "SELECT e FROM ElementWeakness e WHERE e.weaknessName = :weaknessName")})
public class ElementWeakness implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "weakness_name")
    private String weaknessName;
    @JoinColumn(name = "id_Effect", referencedColumnName = "id")
    @OneToOne
    private Effect idEffect;
    @OneToOne(mappedBy = "idElementWeakness")
    private Element element;

    public ElementWeakness() {
    }

    public ElementWeakness(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeaknessName() {
        return weaknessName;
    }

    public void setWeaknessName(String weaknessName) {
        this.weaknessName = weaknessName;
    }

    public Effect getIdEffect() {
        return idEffect;
    }

    public void setIdEffect(Effect idEffect) {
        this.idEffect = idEffect;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
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
        if (!(object instanceof ElementWeakness)) {
            return false;
        }
        ElementWeakness other = (ElementWeakness) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rpgruler.data.entitity.ElementWeakness[ id=" + id + " ]";
    }
    
}
