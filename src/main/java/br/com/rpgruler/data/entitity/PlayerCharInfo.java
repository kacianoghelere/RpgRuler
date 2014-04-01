/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "player_char_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlayerCharInfo.findAll", query = "SELECT p FROM PlayerCharInfo p"),
    @NamedQuery(name = "PlayerCharInfo.findById", query = "SELECT p FROM PlayerCharInfo p WHERE p.id = :id"),
    @NamedQuery(name = "PlayerCharInfo.findByCharLevel", query = "SELECT p FROM PlayerCharInfo p WHERE p.charLevel = :charLevel"),
    @NamedQuery(name = "PlayerCharInfo.findByHp", query = "SELECT p FROM PlayerCharInfo p WHERE p.hp = :hp"),
    @NamedQuery(name = "PlayerCharInfo.findByStrength", query = "SELECT p FROM PlayerCharInfo p WHERE p.strength = :strength"),
    @NamedQuery(name = "PlayerCharInfo.findByDexterity", query = "SELECT p FROM PlayerCharInfo p WHERE p.dexterity = :dexterity"),
    @NamedQuery(name = "PlayerCharInfo.findByResistance", query = "SELECT p FROM PlayerCharInfo p WHERE p.resistance = :resistance"),
    @NamedQuery(name = "PlayerCharInfo.findByWisdom", query = "SELECT p FROM PlayerCharInfo p WHERE p.wisdom = :wisdom"),
    @NamedQuery(name = "PlayerCharInfo.findByLucky", query = "SELECT p FROM PlayerCharInfo p WHERE p.lucky = :lucky")})
public class PlayerCharInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "char_level")
    private long charLevel;
    @Basic(optional = false)
    @Column(name = "hp")
    private short hp;
    @Basic(optional = false)
    @Column(name = "strength")
    private short strength;
    @Basic(optional = false)
    @Column(name = "dexterity")
    private short dexterity;
    @Basic(optional = false)
    @Column(name = "resistance")
    private short resistance;
    @Basic(optional = false)
    @Column(name = "wisdom")
    private short wisdom;
    @Basic(optional = false)
    @Column(name = "lucky")
    private short lucky;
    @JoinColumn(name = "id_player_char", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlayerChar idPlayerChar;

    public PlayerCharInfo() {
    }

    public PlayerCharInfo(Long id) {
        this.id = id;
    }

    public PlayerCharInfo(Long id, long charLevel, short hp, short strength, short dexterity, short resistance, short wisdom, short lucky) {
        this.id = id;
        this.charLevel = charLevel;
        this.hp = hp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.resistance = resistance;
        this.wisdom = wisdom;
        this.lucky = lucky;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCharLevel() {
        return charLevel;
    }

    public void setCharLevel(long charLevel) {
        this.charLevel = charLevel;
    }

    public short getHp() {
        return hp;
    }

    public void setHp(short hp) {
        this.hp = hp;
    }

    public short getStrength() {
        return strength;
    }

    public void setStrength(short strength) {
        this.strength = strength;
    }

    public short getDexterity() {
        return dexterity;
    }

    public void setDexterity(short dexterity) {
        this.dexterity = dexterity;
    }

    public short getResistance() {
        return resistance;
    }

    public void setResistance(short resistance) {
        this.resistance = resistance;
    }

    public short getWisdom() {
        return wisdom;
    }

    public void setWisdom(short wisdom) {
        this.wisdom = wisdom;
    }

    public short getLucky() {
        return lucky;
    }

    public void setLucky(short lucky) {
        this.lucky = lucky;
    }

    public PlayerChar getIdPlayerChar() {
        return idPlayerChar;
    }

    public void setIdPlayerChar(PlayerChar idPlayerChar) {
        this.idPlayerChar = idPlayerChar;
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
