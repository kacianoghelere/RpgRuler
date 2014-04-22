package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * Entidade das perícias
 *
 * @author kaciano
 */
public class Expertise implements Serializable {

    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "title")
    private String title;
    @ColumnName(name = "Atributo chave")
    private String attribute;
    @ColumnName(name = "value")
    private BigInteger value;

    /**
     *
     */
    public Expertise() {
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
        if (!(object instanceof Expertise)) {
            return false;
        }
        Expertise other = (Expertise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rpgruler.data.entitity.Expertise[ id=" + id + " ]";
    }

}
