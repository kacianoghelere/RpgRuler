package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;

/**
 *
 * @author kaciano
 */
public class ArmorType implements Serializable {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String typeName;
    @ColumnName(name = "Quantidade 1")
    private Double materialAmount1;
    @ColumnName(name = "Quantidade 2")
    private Double materialAmount2;

    public ArmorType() {
    }

    public ArmorType(Long id) {
        this.id = id;
    }

    public ArmorType(Long id, String typeName, Double materialAmount1, Double materialAmount2) {
        this.id = id;
        this.typeName = typeName;
        this.materialAmount1 = materialAmount1;
        this.materialAmount2 = materialAmount2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Double getMaterialAmount1() {
        return materialAmount1;
    }

    public void setMaterialAmount1(Double amount1) {
        this.materialAmount1 = amount1;
    }

    public Double getMaterialAmount2() {
        return materialAmount2;
    }

    public void setMaterialAmount2(Double amount2) {
        this.materialAmount2 = amount2;
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
        if (!(object instanceof ArmorType)) {
            return false;
        }
        ArmorType other = (ArmorType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rpgruler.data.entitity.ArmorType[ id=" + id + " ]";
    }

}
