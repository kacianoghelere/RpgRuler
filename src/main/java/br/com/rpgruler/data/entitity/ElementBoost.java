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
@Table(name = "ElementBoost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ElementBoost.findAll", query = "SELECT e FROM ElementBoost e"),
    @NamedQuery(name = "ElementBoost.findById", query = "SELECT e FROM ElementBoost e WHERE e.id = :id"),
    @NamedQuery(name = "ElementBoost.findByBoostName", query = "SELECT e FROM ElementBoost e WHERE e.boostName = :boostName")})
public class ElementBoost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "boost_name")
    private String boostName;
    @JoinColumn(name = "id_Effect", referencedColumnName = "id")
    @OneToOne
    private Effect idEffect;
    @OneToOne(mappedBy = "idElementBoost")
    private Element element;

    public ElementBoost() {
    }

    public ElementBoost(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoostName() {
        return boostName;
    }

    public void setBoostName(String boostName) {
        this.boostName = boostName;
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
        if (!(object instanceof ElementBoost)) {
            return false;
        }
        ElementBoost other = (ElementBoost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rpgruler.data.entitity.ElementBoost[ id=" + id + " ]";
    }
    
}
