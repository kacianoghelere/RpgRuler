package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author kaciano
 */
public class Expertise implements Serializable {

    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "title")
    private String title;
    @ColumnName(name = "keyskill")
    private BigInteger keyskill;
    @ColumnName(name = "value")
    private BigInteger value;

    /**
     *
     */
    public Expertise() {
    }

    /**
     *
     * @param id
     */
    public Expertise(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public BigInteger getKeyskill() {
        return keyskill;
    }

    /**
     *
     * @param keyskill
     */
    public void setKeyskill(BigInteger keyskill) {
        this.keyskill = keyskill;
    }

    /**
     *
     * @return
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(BigInteger value) {
        this.value = value;
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
