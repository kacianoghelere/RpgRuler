package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;

/**
 * Entidade dos atributos para personagens, classes, raças, inimigos e
 * equipamentos.
 *
 * @author kaciano
 */
public class MainAttributes {

    @ColumnName(name = "FOR")
    private Attribute strength;
    @ColumnName(name = "DES")
    private Attribute dexterity;
    @ColumnName(name = "CON")
    private Attribute constitution;
    @ColumnName(name = "INT")
    private Attribute intelligence;
    @ColumnName(name = "WIS")
    private Attribute wisdom;
    @ColumnName(name = "CHA")
    private Attribute charisma;
    @ColumnName(name = "HP")
    private Attribute health;
    @ColumnName(name = "ATK")
    private Attribute attack;
    @ColumnName(name = "DEF")
    private Attribute defense;
    @ColumnName(name = "EVA")
    private Attribute evasion;

    /**
     * Constroi nova instancia de Attributes
     */
    public MainAttributes() {
        this.strength = new Attribute((long) 1, "Força", "FOR", 0);
        this.dexterity = new Attribute((long) 2, "Destreza", "DEX", 0);
        this.constitution = new Attribute((long) 3, "Constituição", "CON", 0);
        this.intelligence = new Attribute((long) 4, "Inteligencia", "INT", 0);
        this.wisdom = new Attribute((long) 5, "Sabedoria", "SAB", 0);
        this.charisma = new Attribute((long) 6, "Carisma", "CAR", 0);
        this.health = new Attribute((long) 7, "Saúde", "HP", 0);
        this.attack = new Attribute((long) 8, "Ataque", "ATK", 0);
        this.defense = new Attribute((long) 9, "Defesa", "DEF", 0);
        this.evasion = new Attribute((long) 10, "Evsão", "EVA", 0);
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
     */
    public MainAttributes(Integer str, Integer dex, Integer con, Integer intel, Integer wis, Integer charm) {
        this.strength = new Attribute((long) 1, "Força", "FOR", str);
        this.dexterity = new Attribute((long) 2, "Destreza", "DEX", dex);
        this.constitution = new Attribute((long) 3, "Constituição", "CON", con);
        this.intelligence = new Attribute((long) 4, "Inteligencia", "INT", intel);
        this.wisdom = new Attribute((long) 5, "Sabedoria", "SAB", wis);
        this.charisma = new Attribute((long) 6, "Carisma", "CAR", charm);
        this.health = new Attribute((long) 7, "Saúde", "HP", 0);
        this.attack = new Attribute((long) 8, "Ataque", "ATK", 0);
        this.defense = new Attribute((long) 9, "Defesa", "DEF", 0);
        this.evasion = new Attribute((long) 10, "Evsão", "EVA", 0);
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
    public MainAttributes(Integer str, Integer dex, Integer con, Integer intel, Integer wis, Integer charm, Integer hp, Integer atk, Integer def, Integer eva) {
        this.strength = new Attribute((long) 1, "Força", "FOR", str);
        this.dexterity = new Attribute((long) 2, "Destreza", "DEX", dex);
        this.constitution = new Attribute((long) 3, "Constituição", "CON", con);
        this.intelligence = new Attribute((long) 4, "Inteligencia", "INT", intel);
        this.wisdom = new Attribute((long) 5, "Sabedoria", "SAB", wis);
        this.charisma = new Attribute((long) 6, "Carisma", "CAR", charm);
        this.health = new Attribute((long) 7, "Saúde", "HP", hp);
        this.attack = new Attribute((long) 8, "Ataque", "ATK", atk);
        this.defense = new Attribute((long) 9, "Defesa", "DEF", def);
        this.evasion = new Attribute((long) 10, "Evsão", "EVA", eva);
    }

    @Override
    public String toString() {
        return strength.getAlias() + ": " + strength.getValue() + ",\n"
                + dexterity.getAlias() + ": " + dexterity.getValue() + ",\n"
                + constitution.getAlias() + ": " + constitution.getValue() + ",\n"
                + intelligence.getAlias() + ": " + intelligence.getValue() + ",\n"
                + wisdom.getAlias() + ": " + wisdom.getValue() + ",\n"
                + charisma.getAlias() + ": " + charisma.getValue() + ",\n"
                + health.getAlias() + ": " + health.getValue() + ",\n"
                + attack.getAlias() + ": " + attack.getValue() + ",\n"
                + defense.getAlias() + ": " + defense.getValue() + ",\n"
                + evasion.getAlias() + ": " + evasion.getValue() + "\n";
    }

    /**
     * Retorna os principais atributos usados
     *
     * @return <code>Attribute[]</code> Principais atributos
     */
    public Attribute[] getAttributes() {
        return new Attribute[]{
            strength,
            dexterity,
            constitution,
            intelligence,
            wisdom,
            charisma
        };
    }

    /**
     * Retorna a Força
     *
     * @return <code>Integer</code> Força
     */
    public Integer getStrength() {
        return strength.getValue();
    }

    /**
     * Modifica a Força
     *
     * @param strength <code>Integer</code> Força
     */
    public void setStrength(Integer strength) {
        this.strength.setValue(strength);
    }

    /**
     * Retorna a Destreza
     *
     * @return <code>Integer</code> Destreza
     */
    public Integer getDexterity() {
        return dexterity.getValue();
    }

    /**
     * Modifica a Destreza
     *
     * @param dexterity <code>Integer</code> Destreza
     */
    public void setDexterity(Integer dexterity) {
        this.dexterity.setValue(dexterity);
    }

    /**
     * Retorna a Constituição
     *
     * @return <code>Integer</code> Constituição
     */
    public Integer getConstitution() {
        return constitution.getValue();
    }

    /**
     * Modifica a Constituição
     *
     * @param constitution <code>Integer</code> Constituição
     */
    public void setConstitution(Integer constitution) {
        this.constitution.setValue(constitution);
    }

    /**
     * Retorna a Inteligencia
     *
     * @return <code>Integer</code> Inteligencia
     */
    public Integer getIntelligence() {
        return intelligence.getValue();
    }

    /**
     * Modifica a Inteligencia
     *
     * @param intelligence <code>Integer</code> Inteligencia
     */
    public void setIntelligence(Integer intelligence) {
        this.intelligence.setValue(intelligence);
    }

    /**
     * Retorna a Sabedoria
     *
     * @return <code>Integer</code> Sabedoria
     */
    public Integer getWisdom() {
        return wisdom.getValue();
    }

    /**
     * Modifica a Sabedoria
     *
     * @param wisdom <code>Integer</code> Sabedoria
     */
    public void setWisdom(Integer wisdom) {
        this.wisdom.setValue(wisdom);
    }

    /**
     * Retorna o Carisma
     *
     * @return <code>Integer</code> Carisma
     */
    public Integer getCharisma() {
        return charisma.getValue();
    }

    /**
     * Modifica o Carisma
     *
     * @param charisma <code>Integer</code> Carisma
     */
    public void setCharisma(Integer charisma) {
        this.charisma.setValue(charisma);
    }

    /**
     * Retorna os Pontos de vida
     *
     * @return <code>Integer</code> Pontos de vida
     */
    public Integer getHealth() {
        return health.getValue();
    }

    /**
     * Modifica os Pontos de vida
     *
     * @param health <code>Integer</code> Pontos de vida
     */
    public void setHealth(Integer health) {
        this.health.setValue(health);
    }

    /**
     * Retorna o Ataque
     *
     * @return <code>Integer</code> Ataque
     */
    public Integer getAttack() {
        return attack.getValue();
    }

    /**
     * Modifica o Ataque
     *
     * @param attack <code>Integer</code> Ataque
     */
    public void setAttack(Integer attack) {
        this.attack.setValue(attack);
    }

    /**
     * Retorna a defesa
     *
     * @return <code>Integer</code> Defesa
     */
    public Integer getDefense() {
        return defense.getValue();
    }

    /**
     * Modifica a defesa
     *
     * @param defense <code>Integer</code> Defesa
     */
    public void setDefense(Integer defense) {
        this.defense.setValue(defense);
    }

    /**
     * Retorna a Evasão
     *
     * @return <code>Integer</code> Evasão
     */
    public Integer getEvasion() {
        return evasion.getValue();
    }

    /**
     * Modifica a Evasão
     *
     * @param evasion <code>Integer</code> Evasão
     */
    public void setEvasion(Integer evasion) {
        this.evasion.setValue(evasion);
    }

}
