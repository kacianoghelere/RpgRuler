package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Tipo de armadura
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
    @ColumnName(name = "Base")
    private Double base;
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

    public ArmorType(Long id, String typeName, Double base, Double materialAmount1, Double materialAmount2) {
        this.id = id;
        this.typeName = typeName;
        this.base = base;
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

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
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
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.typeName);
        hash = 89 * hash + Objects.hashCode(this.materialAmount1);
        hash = 89 * hash + Objects.hashCode(this.materialAmount2);
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
        final ArmorType other = (ArmorType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.typeName, other.typeName)) {
            return false;
        }
        if (!Objects.equals(this.materialAmount1, other.materialAmount1)) {
            return false;
        }
        return Objects.equals(this.materialAmount2, other.materialAmount2);
    }

    @Override
    public String toString() {
        return typeName;
    }

}
