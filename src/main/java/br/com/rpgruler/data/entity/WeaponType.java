package br.com.rpgruler.data.entity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Tipo de arma
 *
 * @author kaciano
 */
public class WeaponType extends Type {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String typeName;
    @Editable
    @ColumnName(name = "Dano base")
    private Double damageBase;
    @Editable
    @ColumnName(name = "Categoria")
    private Integer category;
    @ColumnName(name = "Porte")
    private UseType wearType;
    @Editable
    @ColumnName(name = "Quantidade 1")
    private Double materialAmount1;
    @Editable
    @ColumnName(name = "Quantidade 2")
    private Double materialAmount2;

    /**
     * Cria nova instancia de WeaponType
     */
    public WeaponType() {
    }

    /**
     * Cria nova instancia de WeaponType
     *
     * @param id <code>Long</code> Código do tipo de arma
     * @param typeName <code>String</code> Titulo do tipo de arma
     * @param damageBase <code>Double</code> Dano base do tipo
     * @param category <code>Integer</code> Classificação do tipo
     * @param wearType <code>WearType</code> Tipo de porte
     * @param materialAmount1 <code>Double</code> Qtd. do material 1
     * @param materialAmount2 <code>Double</code> Qtd. do material 2
     */
    public WeaponType(Long id, String typeName, Double damageBase, Integer category, UseType wearType, Double materialAmount1, Double materialAmount2) {
        this.id = id;
        this.typeName = typeName;
        this.damageBase = damageBase;
        this.category = category;
        this.wearType = wearType;
        this.materialAmount1 = materialAmount1;
        this.materialAmount2 = materialAmount2;
    }

    /**
     * Retorna o Código do tipo de arma
     *
     * @return <code>Long</code> Código do tipo de arma
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Código do tipo de arma
     *
     * @param id <code>Long</code> Código do tipo de arma
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Titulo do tipo de arma
     *
     * @return <code>String</code> Titulo do tipo de arma
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Modifica o Titulo do tipo de arma
     *
     * @param typeName <code>String</code> Titulo do tipo de arma
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * Retorna a Qtd. do material 1
     *
     * @return <code>Double</code> Qtd. do material 1
     */
    public Double getMaterialAmount1() {
        return materialAmount1;
    }

    /**
     * Modifica a Qtd. do material 1
     *
     * @param amount1 <code>Double</code> Qtd. do material 1
     */
    public void setMaterialAmount1(Double amount1) {
        this.materialAmount1 = amount1;
    }

    /**
     * Retorna a Qtd. do material 2
     *
     * @return <code>Double</code> Qtd. do material 2
     */
    public Double getMaterialAmount2() {
        return materialAmount2;
    }

    /**
     * Modifica a Qtd. do material 2
     *
     * @param amount2 <code>Double</code> Qtd. do material 2
     */
    public void setMaterialAmount2(Double amount2) {
        this.materialAmount2 = amount2;
    }

    /**
     * Retorna o Dano base do tipo
     *
     * @return <code>Double</code> Dano base do tipo
     */
    public Double getDamageBase() {
        return damageBase;
    }

    /**
     * Modifica o Dano base do tipo
     *
     * @param damageBase <code>Double</code> Dano base do tipo
     */
    public void setDamageBase(Double damageBase) {
        this.damageBase = damageBase;
    }

    /**
     * Retorna a Classificação do tipo
     *
     * @return <code>Integer</code> Classificação do tipo
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * Modifica a Classificação do tipo
     *
     * @param category <code>Integer</code> Classificação do tipo
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * Retorna o Tipo de porte
     *
     * @return <code>WearType</code> Tipo de porte
     */
    public UseType getWearType() {
        return wearType;
    }

    /**
     * Modifica o Tipo de porte
     *
     * @param wearType <code>WearType</code> Tipo de porte
     */
    public void setWearType(UseType wearType) {
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
