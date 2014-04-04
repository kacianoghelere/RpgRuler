package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class Expertise implements Serializable {

    @Id
    @Column(name = "Código")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "keyskill")
    private BigInteger keyskill;
    @Column(name = "value")
    private BigInteger value;

    public Expertise() {
    }

    public Expertise(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigInteger getKeyskill() {
        return keyskill;
    }

    public void setKeyskill(BigInteger keyskill) {
        this.keyskill = keyskill;
    }

    public BigInteger getValue() {
        return value;
    }

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
