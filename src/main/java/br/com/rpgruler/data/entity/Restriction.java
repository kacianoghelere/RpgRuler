package br.com.rpgruler.data.entity;

import br.com.gmp.comps.annotations.ColumnName;

/**
 * Restrição de uso para equipamentos
 *
 * @author kaciano
 */
public class Restriction {

    @ColumnName(name = "Tipo")
    private RestrictionType type;
    @ColumnName(name = "Valor")
    private Integer value;

    /**
     * Cria nova instancia de Restriction
     */
    public Restriction() {
    }

    /**
     * Cria nova instancia de Restriction
     *
     * @param type <code>RestrictionType</code> Tipo da Restrição
     * @param value <code>Integer</code> Valor da Restrição
     */
    public Restriction(RestrictionType type, Integer value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Retorna o Tipo da Restrição
     *
     * @return <code>RestrictionType</code> Tipo da Restrição
     */
    public RestrictionType getType() {
        return type;
    }

    /**
     * Modifica o Tipo da Restrição
     *
     * @param type <code>RestrictionType</code> Tipo da Restrição
     */
    public void setType(RestrictionType type) {
        this.type = type;
    }

    /**
     * Retorna o Valor da Restrição
     *
     * @return <code>Integer</code> Valor da Restrição
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Modifica o Valor da Restrição
     *
     * @param value <code>Integer</code> Valor da Restrição
     */
    public void setValue(Integer value) {
        this.value = value;
    }

}
