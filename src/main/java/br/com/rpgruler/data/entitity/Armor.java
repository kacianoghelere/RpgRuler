package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;

/**
 *
 * @author kaciano
 */
public class Armor implements Serializable {

    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Tipo de armadura")
    private ArmorType armorType;
    @ColumnName(name = "Material 1")
    private PrimeMaterial primeMaterial1;
    @ColumnName(name = "Material 2")
    private PrimeMaterial primeMaterial2;

    public Armor() {
    }

    public Armor(Long id) {
        this.id = id;
    }

    public Armor(Long id, ArmorType armorType, PrimeMaterial primeMaterial1,
            Double materialAmount1, PrimeMaterial primeMaterial2,
            Double materialAmount2) {
        this.id = id;
        this.armorType = armorType;
        this.primeMaterial1 = primeMaterial1;
        this.primeMaterial2 = primeMaterial2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public PrimeMaterial getPrimeMaterial1() {
        return primeMaterial1;
    }

    public void setPrimeMaterial1(PrimeMaterial primeMaterial1) {
        this.primeMaterial1 = primeMaterial1;
    }

    public PrimeMaterial getPrimeMaterial2() {
        return primeMaterial2;
    }

    public void setPrimeMaterial2(PrimeMaterial primeMaterial2) {
        this.primeMaterial2 = primeMaterial2;
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
        if (!(object instanceof Armor)) {
            return false;
        }
        Armor other = (Armor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rpgruler.data.entitity.Armor[ id=" + id + " ]";
    }

}
