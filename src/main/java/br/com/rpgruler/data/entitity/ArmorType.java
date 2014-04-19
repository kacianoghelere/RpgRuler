package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Tipo de armadura
 *
 * @author kaciano
 */
public class ArmorType extends Type {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String typeName;
    @Editable
    @ColumnName(name = "Base")
    private Double base;
    @Editable
    @ColumnName(name = "Quantidade 1")
    private Double materialAmount1;
    @Editable
    @ColumnName(name = "Quantidade 2")
    private Double materialAmount2;

    /**
     *
     */
    public ArmorType() {
    }

    /**
     *
     * @param id
     */
    public ArmorType(Long id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param typeName
     * @param materialAmount1
     * @param materialAmount2
     */
    public ArmorType(Long id, String typeName, Double materialAmount1, Double materialAmount2) {
        this.id = id;
        this.typeName = typeName;
        this.materialAmount1 = materialAmount1;
        this.materialAmount2 = materialAmount2;
    }

    /**
     *
     * @param id
     * @param typeName
     * @param base
     * @param materialAmount1
     * @param materialAmount2
     */
    public ArmorType(Long id, String typeName, Double base, Double materialAmount1, Double materialAmount2) {
        this.id = id;
        this.typeName = typeName;
        this.base = base;
        this.materialAmount1 = materialAmount1;
        this.materialAmount2 = materialAmount2;
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
    public String getTypeName() {
        return typeName;
    }

    /**
     *
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     *
     * @return
     */
    public Double getBase() {
        return base;
    }

    /**
     *
     * @param base
     */
    public void setBase(Double base) {
        this.base = base;
    }

    /**
     *
     * @return
     */
    public Double getMaterialAmount1() {
        return materialAmount1;
    }

    /**
     *
     * @param amount1
     */
    public void setMaterialAmount1(Double amount1) {
        this.materialAmount1 = amount1;
    }

    /**
     *
     * @return
     */
    public Double getMaterialAmount2() {
        return materialAmount2;
    }

    /**
     *
     * @param amount2
     */
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
