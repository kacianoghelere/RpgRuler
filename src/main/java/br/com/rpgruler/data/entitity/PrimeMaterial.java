package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Matérias primas
 *
 * @author kaciano
 */
public class PrimeMaterial implements Serializable {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String materialName;
    @ColumnName(name = "Peso/Unidade")
    private Double weight;
    @ColumnName(name = "Classe")
    private Integer materialClass;
    @ColumnName(name = "Resistencia/Unidade")
    private Double resistence;

    public PrimeMaterial() {
    }

    public PrimeMaterial(Long id) {
        this.id = id;
    }

    public PrimeMaterial(Long id, Integer materialClass) {
        this.id = id;
        this.materialClass = materialClass;
    }

    public PrimeMaterial(Long id, String materialName, Double weight, Integer materialClass) {
        this.id = id;
        this.materialName = materialName;
        this.weight = weight;
        this.materialClass = materialClass;
        this.resistence = (weight * materialClass);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getMaterialClass() {
        return materialClass;
    }

    public void setMaterialClass(Integer materialClass) {
        this.materialClass = materialClass;
    }

    public Double getResistence() {
        return resistence;
    }

    public void setResistence(Double resistence) {
        this.resistence = resistence;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.materialName);
        hash = 23 * hash + Objects.hashCode(this.weight);
        hash = 23 * hash + Objects.hashCode(this.materialClass);
        hash = 23 * hash + Objects.hashCode(this.resistence);
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
        final PrimeMaterial other = (PrimeMaterial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.materialName, other.materialName)) {
            return false;
        }
        if (!Objects.equals(this.weight, other.weight)) {
            return false;
        }
        if (!Objects.equals(this.materialClass, other.materialClass)) {
            return false;
        }
        return Objects.equals(this.resistence, other.resistence);
    }

    @Override
    public String toString() {
        return materialName;
    }

}
