package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Modo de uso das armas
 *
 * @author kaciano
 */
public class UseType extends Type {

    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Uso")
    private String typeName;

    /**
     * Cria nova instancia de WearType
     */
    public UseType() {
    }

    /**
     * Cria nova instancia de WearType
     *
     * @param id <code>Long</code> Código do tipo
     * @param typeName <code>String</code> Titulo do tipo
     */
    public UseType(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.typeName);
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
        final UseType other = (UseType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.typeName, other.typeName);
    }

    @Override
    public String toString() {
        return typeName;
    }

    /**
     * Retorna o Código do tipo
     *
     * @return <code>Long</code> Código do tipo
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Código do tipo
     *
     * @param id <code>Long</code> Código do tipo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Titulo do tipo
     *
     * @return <code>String</code> Titulo do tipo
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Modifica o Titulo do tipo
     *
     * @param typeName <code>String</code> Titulo do tipo
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
