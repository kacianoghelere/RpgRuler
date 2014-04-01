/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "player_char")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlayerChar.findAll", query = "SELECT p FROM PlayerChar p"),
    @NamedQuery(name = "PlayerChar.findById", query = "SELECT p FROM PlayerChar p WHERE p.id = :id"),
    @NamedQuery(name = "PlayerChar.findByCharName", query = "SELECT p FROM PlayerChar p WHERE p.charName = :charName"),
    @NamedQuery(name = "PlayerChar.findByPlayerName", query = "SELECT p FROM PlayerChar p WHERE p.playerName = :playerName"),
    @NamedQuery(name = "PlayerChar.findByAge", query = "SELECT p FROM PlayerChar p WHERE p.age = :age"),
    @NamedQuery(name = "PlayerChar.findBySex", query = "SELECT p FROM PlayerChar p WHERE p.sex = :sex"),
    @NamedQuery(name = "PlayerChar.findByHeight", query = "SELECT p FROM PlayerChar p WHERE p.height = :height"),
    @NamedQuery(name = "PlayerChar.findByWeight", query = "SELECT p FROM PlayerChar p WHERE p.weight = :weight")})
public class PlayerChar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "char_name")
    private String charName;
    @Column(name = "player_name")
    private String playerName;
    @Column(name = "age")
    private Short age;
    @Column(name = "sex")
    private Character sex;
    @Column(name = "height")
    private Short height;
    @Column(name = "weight")
    private Short weight;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlayerChar")
    private Collection<PlayerCharInfo> playerCharInfoCollection;
    @JoinColumn(name = "id_char_class", referencedColumnName = "id")
    @OneToOne
    private CharClass idCharClass;
    @JoinColumn(name = "id_char_race", referencedColumnName = "id")
    @OneToOne
    private CharRace idCharRace;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlayerChar")
    private Collection<Expertise> expertiseCollection;

    public PlayerChar() {
    }

    public PlayerChar(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Short getHeight() {
        return height;
    }

    public void setHeight(Short height) {
        this.height = height;
    }

    public Short getWeight() {
        return weight;
    }

    public void setWeight(Short weight) {
        this.weight = weight;
    }

    @XmlTransient
    public Collection<PlayerCharInfo> getPlayerCharInfoCollection() {
        return playerCharInfoCollection;
    }

    public void setPlayerCharInfoCollection(Collection<PlayerCharInfo> playerCharInfoCollection) {
        this.playerCharInfoCollection = playerCharInfoCollection;
    }

    public CharClass getIdCharClass() {
        return idCharClass;
    }

    public void setIdCharClass(CharClass idCharClass) {
        this.idCharClass = idCharClass;
    }

    public CharRace getIdCharRace() {
        return idCharRace;
    }

    public void setIdCharRace(CharRace idCharRace) {
        this.idCharRace = idCharRace;
    }

    @XmlTransient
    public Collection<Expertise> getExpertiseCollection() {
        return expertiseCollection;
    }

    public void setExpertiseCollection(Collection<Expertise> expertiseCollection) {
        this.expertiseCollection = expertiseCollection;
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
        if (!(object instanceof PlayerChar)) {
            return false;
        }
        PlayerChar other = (PlayerChar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rpgruler.data.entitity.PlayerChar[ id=" + id + " ]";
    }
    
}
