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
    private MixedElement idMixedElement;

    public Element() {
    }

    public Element(Integer id, String elementName, String elementSymbol) {
        this.id = id;
        this.elementName = elementName;
        this.elementSymbol = elementSymbol;
    }

    public Element(Integer id, String elementName, String elementSymbol, ElementBoost idElementBoost, ElementWeakness idElementWeakness, MixedElement idMixedElement) {
        this.id = id;
        this.elementName = elementName;
        this.elementSymbol = elementSymbol;
        this.idElementBoost = idElementBoost;
        this.idElementWeakness = idElementWeakness;
        this.idMixedElement = idMixedElement;
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
