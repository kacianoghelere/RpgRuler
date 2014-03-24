package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class Element implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String elementName;
    private String elementSymbol;
    private ElementBoost idElementBoost;
    private ElementWeakness idElementWeakness;

    public Element() {
    }

    public Element(Integer id, String elementName, String elementSymbol) {
        this.id = id;
        this.elementName = elementName;
        this.elementSymbol = elementSymbol;
    }

    public Element(Integer id, String elementName, String elementSymbol, ElementBoost idElementBoost, ElementWeakness idElementWeakness) {
        this.id = id;
        this.elementName = elementName;
        this.elementSymbol = elementSymbol;
        this.idElementBoost = idElementBoost;
        this.idElementWeakness = idElementWeakness;        
    }

    public Element(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public ElementBoost getElementBoost() {
        return idElementBoost;
    }

    public void setElementBoost(ElementBoost idElementBoost) {
        this.idElementBoost = idElementBoost;
    }

    public ElementWeakness getElementWeakness() {
        return idElementWeakness;
    }

    public void setElementWeakness(ElementWeakness idElementWeakness) {
        this.idElementWeakness = idElementWeakness;
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
