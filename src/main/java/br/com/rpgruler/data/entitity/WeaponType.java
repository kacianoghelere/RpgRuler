package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Tipo de arma
 *
 * @author kaciano
 */
public class WeaponType implements Serializable {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String typeName;
    @ColumnName(name = "Dano base")
    private Double damageBase;
    @ColumnName(name = "Classificação")
    private Integer category;
    @ColumnName(name = "Uso")
    private WearType wearType;
    @ColumnName(name = "Quantidade 1")
    private Double materialAmount1;
    @ColumnName(name = "Quantidade 2")
    private Double materialAmount2;

    public WeaponType() {
    }

    public WeaponType(Long id, String typeName, Double damageBase, Integer category, WearType wearType, Double materialAmount1, Double materialAmount2) {
        this.id = id;
        this.typeName = typeName;
        this.damageBase = damageBase;
        this.category = category;
        this.wearType = wearType;
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

    public Double getDamageBase() {
        return damageBase;
    }

    public void setDamageBase(Double damageBase) {
        this.damageBase = damageBase;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public WearType getWearType() {
        return wearType;
    }

    public void setWearType(WearType wearType) {
        this.wearType = wearType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.typeName);
        hash = 29 * hash + Objects.hashCode(this.damageBase);
        hash = 29 * hash + Objects.hashCode(this.category);
        hash = 29 * hash + Objects.hashCode(this.wearType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WeaponType other = (WeaponType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.typeName, other.typeName)) {
            return false;
        }
        if (!Objects.equals(this.damageBase, other.damageBase)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        return Objects.equals(this.wearType, other.wearType);
    }

    @Override
    public String toString() {
        return typeName;
    }

}
