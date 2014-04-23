package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Entidade das perícias
 *
 * @author kaciano
 * @version 1.0
 */
public class Expertise implements Serializable {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "title")
    private String title;
    @ColumnName(name = "Atributo chave")
    private Attribute attribute;
    @Editable
    @ColumnName(name = "value")
    private Integer value;

    /**
     * Cria nova instancia de Expertise
     */
    public Expertise() {
    }

    /**
     * Cria nova instancia de Expertise
     *
     * @param id <code>Long</code> ID da perícia
     * @param title <code>String</code> Titulo da perícia
     * @param attribute <code>Attribute</code> Atributo chave
     * @param value <code>Integer</code> Valor da perícia
     */
    public Expertise(Long id, String title, Attribute attribute, Integer value) {
        this.id = id;
        this.title = title;
        this.attribute = attribute;
        this.value = value;
    }

    /**
     * Retorna o ID da perícia
     *
     * @return <code>Long</code> ID da perícia
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID da perícia
     *
     * @param id <code>Long</code> ID da perícia
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o titulo da perícia
     *
     * @return <code>String</code> Titulo da perícia
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o titulo da perícia
     *
     * @param title <code>String</code> Titulo da perícia
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna o atributo chave
     *
     * @return <code>Attribute</code> Atributo chave
     */
    public Attribute getAttribute() {
        return attribute;
    }

    /**
     * Modifica o atributo chave
     *
     * @param attribute <code>Attribute</code> Atributo chave
     */
    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    /**
     * Retorna o valor da perícia
     *
     * @return <code>Integer</code> Valor da perícia
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Modifica o valor da perícia
     *
     * @param value <code>Integer</code> Valor da perícia
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.attribute);
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
        final Expertise other = (Expertise) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.attribute, other.attribute);
    }

    @Override
    public String toString() {
        return title + "(" + value + ")";
    }

}
