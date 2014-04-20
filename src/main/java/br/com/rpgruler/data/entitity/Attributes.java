package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;

/**
 * Entidade dos atributos para personagens, classes, raças, inimigos e
 * equipamentos.
 *
 * @author kaciano
 */
public class Attributes {

    @ColumnName(name = "FOR")
    private Integer strength;
    @ColumnName(name = "DES")
    private Integer dexterity;
    @ColumnName(name = "CON")
    private Integer constitution;
    @ColumnName(name = "INT")
    private Integer intelligence;
    @ColumnName(name = "WIS")
    private Integer wisdom;
    @ColumnName(name = "CHA")
    private Integer charisma;
    @ColumnName(name = "HP")
    private Integer health;
    @ColumnName(name = "ATK")
    private Integer attack;
    @ColumnName(name = "DEF")
    private Integer defense;
    @ColumnName(name = "EVA")
    private Integer evasion;

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
     * Constroi nova instancia de Attributes
     *
     * @param str <code>Integer</code> Força
     * @param dex <code>Integer</code> Destreza
     * @param con <code>Integer</code> Constituição
     * @param intel <code>Integer</code> Inteligencia
     * @param wis <code>Integer</code> Sabedoria
     * @param charm <code>Integer</code> Carisma
     * @param hp <code>Integer</code> Pontos de vida
     * @param atk <code>Integer</code> Ataque
     * @param def <code>Integer</code> Defesa
     * @param eva <code>Integer</code> Evasão
     */
    public Attributes(Integer str, Integer dex, Integer con, Integer intel, Integer wis, Integer charm, Integer hp, Integer atk, Integer def, Integer eva) {
        this.strength = str;
        this.dexterity = dex;
        this.constitution = con;
        this.intelligence = intel;
        this.wisdom = wis;
        this.charisma = charm;
        this.health = hp;
        this.attack = atk;
        this.defense = def;
        this.evasion = eva;
    }

    @Override
    public String toString() {
        return "FOR: " + strength
                + ", DES: " + dexterity
                + ", CON: " + constitution
                + ", INT: " + intelligence
                + ", SAB: " + wisdom
                + ", CAR: " + charisma
                + ", HP: " + health
                + ", ATK: " + attack
                + ", DEF: " + defense
                + ", EVA: " + evasion;
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

    /**
     * Retorna os Pontos de vida
     *
     * @return <code>Integer</code> Pontos de vida
     */
    public Integer getHealth() {
        return health;
    }

    /**
     * Modifica os Pontos de vida
     *
     * @param health <code>Integer</code> Pontos de vida
     */
    public void setHealth(Integer health) {
        this.health = health;
    }

    /**
     * Retorna o Ataque
     *
     * @return <code>Integer</code> Ataque
     */
    public Integer getAttack() {
        return attack;
    }

    /**
     * Modifica o Ataque
     *
     * @param attack <code>Integer</code> Ataque
     */
    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    /**
     * Retorna a defesa
     *
     * @return <code>Integer</code> Defesa
     */
    public Integer getDefense() {
        return defense;
    }

    /**
     * Modifica a defesa
     *
     * @param defense <code>Integer</code> Defesa
     */
    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    /**
     * Retorna a Evasão
     *
     * @return <code>Integer</code> Evasão
     */
    public Integer getEvasion() {
        return evasion;
    }

    /**
     * Modifica a Evasão
     *
     * @param evasion <code>Integer</code> Evasão
     */
    public void setEvasion(Integer evasion) {
        this.evasion = evasion;
    }

}
