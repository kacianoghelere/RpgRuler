package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;

/**
 * Entidade dos atributos para personagens, classes, raças, inimigos e
 * equipamentos.
 *
 * @author kaciano
 */
public class Attributes {

    @Editable
    @ColumnName(name = "FOR")
    private Integer strength;
    @Editable
    @ColumnName(name = "DES")
    private Integer dexterity;
    @Editable
    @ColumnName(name = "CON")
    private Integer constitution;
    @Editable
    @ColumnName(name = "INT")
    private Integer intelligence;
    @Editable
    @ColumnName(name = "WIS")
    private Integer wisdom;
    @Editable
    @ColumnName(name = "CHA")
    private Integer charisma;

    /**
     * Constroi nova instancia de Attributes
     */
    public Attributes() {
    }

    /**
     * Constroi nova instancia de Attributes
     *
     * @param str <code>Integer</code> Força
     * @param dex <code>Integer</code> Destreza
     * @param cons <code>Integer</code> Constituição
     * @param intel <code>Integer</code> Inteligencia
     * @param wis <code>Integer</code> Sabedoria
     * @param charm <code>Integer</code> Carisma
     */
    public Attributes(Integer str, Integer dex, Integer cons, Integer intel, Integer wis, Integer charm) {
        this.strength = str;
        this.dexterity = dex;
        this.constitution = cons;
        this.intelligence = intel;
        this.wisdom = wis;
        this.charisma = charm;
    }

    /**
     * Retorna a Força
     *
     * @return <code>Integer</code> Força
     */
    public Integer getStrength() {
        return strength;
    }

    /**
     * Modifica a Força
     *
     * @param strength <code>Integer</code> Força
     */
    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    /**
     * Retorna a Destreza
     *
     * @return <code>Integer</code> Destreza
     */
    public Integer getDexterity() {
        return dexterity;
    }

    /**
     * Modifica a Destreza
     *
     * @param dexterity <code>Integer</code> Destreza
     */
    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * Retorna a Constituição
     *
     * @return <code>Integer</code> Constituição
     */
    public Integer getConstitution() {
        return constitution;
    }

    /**
     * Modifica a Constituição
     *
     * @param constitution <code>Integer</code> Constituição
     */
    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    /**
     * Retorna a Inteligencia
     *
     * @return <code>Integer</code> Inteligencia
     */
    public Integer getIntelligence() {
        return intelligence;
    }

    /**
     * Modifica a Inteligencia
     *
     * @param intelligence <code>Integer</code> Inteligencia
     */
    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * Retorna a Sabedoria
     *
     * @return <code>Integer</code> Sabedoria
     */
    public Integer getWisdom() {
        return wisdom;
    }

    /**
     * Modifica a Sabedoria
     *
     * @param wisdom <code>Integer</code> Sabedoria
     */
    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    /**
     * Retorna o Carisma
     *
     * @return <code>Integer</code> Carisma
     */
    public Integer getCharisma() {
        return charisma;
    }

    /**
     * Modifica o Carisma
     *
     * @param charisma <code>Integer</code> Carisma
     */
    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

}
