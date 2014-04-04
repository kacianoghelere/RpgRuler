package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class PrimeMaterial implements Serializable {

    @Id
    @Column(name = "Código")
    private Long id;
    @Column(name = "Nome")
    private String materialName;
    @Column(name = "Peso/Unidade")
    private Double weight;
    @Basic(optional = false)
    @Column(name = "Classe")
    private Integer materialClass;
    @Column(name = "Resistencia/Unidade")
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
