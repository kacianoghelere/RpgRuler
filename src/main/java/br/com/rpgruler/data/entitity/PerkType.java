package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class PerkType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String typeName;

    public PerkType() {
    }

    public PerkType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final PerkType other = (PerkType) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "PerkType[" + id + ", " + typeName + "]";
    }

}
