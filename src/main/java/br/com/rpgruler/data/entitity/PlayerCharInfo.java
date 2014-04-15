package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;

/**
 *
 * @author kaciano
 */
public class PlayerCharInfo implements Serializable {

    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nivel")
    private long charLevel;
    @ColumnName(name = "HP")
    private Integer hp;
    @ColumnName(name = "Força")
    private Integer strength;
    @ColumnName(name = "Destreza")
    private Integer dexterity;
    @ColumnName(name = "Sabedoria")
    private Integer wisdom;
    @ColumnName(name = "Resistencia")
    private Integer resistance;
    @ColumnName(name = "Sorte")
    private Integer lucky;
    @ColumnName(name = "Personagem")
    private PlayerChar playerChar;

    /**
     *
     */
    public PlayerCharInfo() {
    }

    /**
     *
     * @param id
     */
    public PlayerCharInfo(Long id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param charLevel
     * @param hp
     * @param strength
     * @param dexterity
     * @param resistance
     * @param wisdom
     * @param lucky
     */
    public PlayerCharInfo(Long id, long charLevel, Integer hp, Integer strength, Integer dexterity, Integer resistance, Integer wisdom, Integer lucky) {
        this.id = id;
        this.charLevel = charLevel;
        this.hp = hp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.resistance = resistance;
        this.wisdom = wisdom;
        this.lucky = lucky;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public long getCharLevel() {
        return charLevel;
    }

    /**
     *
     * @param charLevel
     */
    public void setCharLevel(long charLevel) {
        this.charLevel = charLevel;
    }

    /**
     *
     * @return
     */
    public Integer getHp() {
        return hp;
    }

    /**
     *
     * @param hp
     */
    public void setHp(Integer hp) {
        this.hp = hp;
    }

    /**
     *
     * @return
     */
    public Integer getStrength() {
        return strength;
    }

    /**
     *
     * @param strength
     */
    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    /**
     *
     * @return
     */
    public Integer getDexterity() {
        return dexterity;
    }

    /**
     *
     * @param dexterity
     */
    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    /**
     *
     * @return
     */
    public Integer getResistance() {
        return resistance;
    }

    /**
     *
     * @param resistance
     */
    public void setResistance(Integer resistance) {
        this.resistance = resistance;
    }

    /**
     *
     * @return
     */
    public Integer getWisdom() {
        return wisdom;
    }

    /**
     *
     * @param wisdom
     */
    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    /**
     *
     * @return
     */
    public Integer getLucky() {
        return lucky;
    }

    /**
     *
     * @param lucky
     */
    public void setLucky(Integer lucky) {
        this.lucky = lucky;
    }

    /**
     *
     * @return
     */
    public PlayerChar getIdPlayerChar() {
        return playerChar;
    }

    /**
     *
     * @param idPlayerChar
     */
    public void setIdPlayerChar(PlayerChar idPlayerChar) {
        this.playerChar = idPlayerChar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayerCharInfo)) {
            return false;
        }
        PlayerCharInfo other = (PlayerCharInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rpgruler.data.entitity.PlayerCharInfo[ id=" + id + " ]";
    }

}
