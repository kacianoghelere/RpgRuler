package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author kaciano
 */
public class PrimeMaterial implements Serializable {

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
        hash = 53 * hash + Objects.hashCode(this.id);
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
        return true;
    }

    @Override
    public String toString() {
        return "PrimeMaterial{" + "id=" + id + ", materialName=" + materialName + '}';
    }

}
