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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "enemy_race")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnemyRace.findAll", query = "SELECT e FROM EnemyRace e"),
    @NamedQuery(name = "EnemyRace.findById", query = "SELECT e FROM EnemyRace e WHERE e.id = :id"),
    @NamedQuery(name = "EnemyRace.findByRaceName", query = "SELECT e FROM EnemyRace e WHERE e.raceName = :raceName"),
    @NamedQuery(name = "EnemyRace.findByBonusHp", query = "SELECT e FROM EnemyRace e WHERE e.bonusHp = :bonusHp"),
    @NamedQuery(name = "EnemyRace.findByBonusStr", query = "SELECT e FROM EnemyRace e WHERE e.bonusStr = :bonusStr"),
    @NamedQuery(name = "EnemyRace.findByBonusDex", query = "SELECT e FROM EnemyRace e WHERE e.bonusDex = :bonusDex"),
    @NamedQuery(name = "EnemyRace.findByBonusRes", query = "SELECT e FROM EnemyRace e WHERE e.bonusRes = :bonusRes"),
    @NamedQuery(name = "EnemyRace.findByBonusWis", query = "SELECT e FROM EnemyRace e WHERE e.bonusWis = :bonusWis"),
    @NamedQuery(name = "EnemyRace.findByBonusLuc", query = "SELECT e FROM EnemyRace e WHERE e.bonusLuc = :bonusLuc")})
public class EnemyRace implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "race_name")
    private String raceName;
    @Basic(optional = false)
    @Column(name = "bonus_hp")
    private short bonusHp;
    @Basic(optional = false)
    @Column(name = "bonus_str")
    private short bonusStr;
    @Basic(optional = false)
    @Column(name = "bonus_dex")
    private short bonusDex;
    @Basic(optional = false)
    @Column(name = "bonus_res")
    private short bonusRes;
    @Basic(optional = false)
    @Column(name = "bonus_wis")
    private short bonusWis;
    @Basic(optional = false)
    @Column(name = "bonus_luc")
    private short bonusLuc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEnemyRace")
    private Collection<Perk> perkCollection;

    public EnemyRace() {
    }

    public EnemyRace(Long id) {
        this.id = id;
    }

    public EnemyRace(Long id, short bonusHp, short bonusStr, short bonusDex, short bonusRes, short bonusWis, short bonusLuc) {
        this.id = id;
        this.bonusHp = bonusHp;
        this.bonusStr = bonusStr;
        this.bonusDex = bonusDex;
        this.bonusRes = bonusRes;
        this.bonusWis = bonusWis;
        this.bonusLuc = bonusLuc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public short getBonusHp() {
        return bonusHp;
    }

    public void setBonusHp(short bonusHp) {
        this.bonusHp = bonusHp;
    }

    public short getBonusStr() {
        return bonusStr;
    }

    public void setBonusStr(short bonusStr) {
        this.bonusStr = bonusStr;
    }

    public short getBonusDex() {
        return bonusDex;
    }

    public void setBonusDex(short bonusDex) {
        this.bonusDex = bonusDex;
    }

    public short getBonusRes() {
        return bonusRes;
    }

    public void setBonusRes(short bonusRes) {
        this.bonusRes = bonusRes;
    }

    public short getBonusWis() {
        return bonusWis;
    }

    public void setBonusWis(short bonusWis) {
        this.bonusWis = bonusWis;
    }

    public short getBonusLuc() {
        return bonusLuc;
    }

    public void setBonusLuc(short bonusLuc) {
        this.bonusLuc = bonusLuc;
    }

    @XmlTransient
    public Collection<Perk> getPerkCollection() {
        return perkCollection;
    }

    public void setPerkCollection(Collection<Perk> perkCollection) {
        this.perkCollection = perkCollection;
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
        if (!(object instanceof EnemyRace)) {
            return false;
        }
        EnemyRace other = (EnemyRace) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rpgruler.data.entitity.EnemyRace[ id=" + id + " ]";
    }
    
}
