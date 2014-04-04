package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;

/**
 *
 * @author kaciano
 */
public class Element implements Serializable {

    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String elementName;
    @ColumnName(name = "Simbolo")
    private String elementSymbol;

    public Element() {
    }

    public Element(Long id) {
        this.id = id;
    }

    public Element(Long id, String elementName, String elementSymbol) {
        this.id = id;
        this.elementName = elementName;
        this.elementSymbol = elementSymbol;
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
