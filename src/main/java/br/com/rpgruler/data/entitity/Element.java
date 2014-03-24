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
import javax.persistence.ManyToOne;
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
@Table(name = "Element")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Element.findAll", query = "SELECT e FROM Element e"),
    @NamedQuery(name = "Element.findById", query = "SELECT e FROM Element e WHERE e.id = :id"),
    @NamedQuery(name = "Element.findByElementName", query = "SELECT e FROM Element e WHERE e.elementName = :elementName"),
    @NamedQuery(name = "Element.findByElementSymbol", query = "SELECT e FROM Element e WHERE e.elementSymbol = :elementSymbol")})
public class Element implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "element_name")
    private String elementName;
    @Column(name = "element_symbol")
    private String elementSymbol;
    @JoinColumn(name = "id_ElementBoost", referencedColumnName = "id")
    @OneToOne
    private ElementBoost idElementBoost;
    @JoinColumn(name = "id_ElementWeakness", referencedColumnName = "id")
    @OneToOne
    private ElementWeakness idElementWeakness;
    @JoinColumn(name = "id_MixedElement", referencedColumnName = "id")
    @ManyToOne
    private MixedElement idMixedElement;

    public Element() {
    }

    public Element(Long id, String elementName, String elementSymbol) {
        this.id = id;
        this.elementName = elementName;
        this.elementSymbol = elementSymbol;
    }
    public Element(Long id, String elementName, String elementSymbol, ElementBoost idElementBoost, ElementWeakness idElementWeakness, MixedElement idMixedElement) {
        this.id = id;
        this.elementName = elementName;
        this.elementSymbol = elementSymbol;
        this.idElementBoost = idElementBoost;
        this.idElementWeakness = idElementWeakness;
        this.idMixedElement = idMixedElement;
    }

    public Element(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementSymbol() {
        return elementSymbol;
    }

    public void setElementSymbol(String elementSymbol) {
        this.elementSymbol = elementSymbol;
    }

    public ElementBoost getIdElementBoost() {
        return idElementBoost;
    }

    public void setIdElementBoost(ElementBoost idElementBoost) {
        this.idElementBoost = idElementBoost;
    }

    public ElementWeakness getIdElementWeakness() {
        return idElementWeakness;
    }

    public void setIdElementWeakness(ElementWeakness idElementWeakness) {
        this.idElementWeakness = idElementWeakness;
    }

    public MixedElement getIdMixedElement() {
        return idMixedElement;
    }

    public void setIdMixedElement(MixedElement idMixedElement) {
        this.idMixedElement = idMixedElement;
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
        if (!(object instanceof Element)) {
            return false;
        }
        Element other = (Element) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rpgruler.data.entitity.Element[ id=" + id + " ]";
    }
    
}
