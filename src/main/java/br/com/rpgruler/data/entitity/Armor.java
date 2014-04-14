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
    @ColumnName(name = "Resistencia")
    private Double resistence;
    @ColumnName(name = "Material 1")
    private PrimeMaterial pMaterial1;
    @ColumnName(name = "Material 2")
    private PrimeMaterial pMaterial2;

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
        this.pMaterial1 = primeMaterial1;
        this.pMaterial2 = primeMaterial2;
    }

    public Armor(Long id, ArmorType armorType, Double resistence, 
            PrimeMaterial pMaterial1, PrimeMaterial pMaterial2) {
        this.id = id;
        this.armorType = armorType;
        this.resistence = resistence;
        this.pMaterial1 = pMaterial1;
        this.pMaterial2 = pMaterial2;
    }

    public void calcResistence() {
        this.resistence = (pMaterial1.getResistence()
                + pMaterial2.getResistence() 
                + armorType.getBase());
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

    public Double getResistence() {
        return resistence;
    }

    public void setResistence(Double resistence) {
        this.resistence = resistence;
    }

    public PrimeMaterial getpMaterial1() {
        return pMaterial1;
    }

    public void setpMaterial1(PrimeMaterial pMaterial1) {
        this.pMaterial1 = pMaterial1;
    }

    public PrimeMaterial getpMaterial2() {
        return pMaterial2;
    }

    public void setpMaterial2(PrimeMaterial pMaterial2) {
        this.pMaterial2 = pMaterial2;
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
