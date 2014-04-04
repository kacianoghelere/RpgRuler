package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author kaciano
 */
public class EnemyRace implements Serializable {

    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Titulo")
    private String raceName;
    @ColumnName(name = "Bonûs HP")
    private Integer bonusHp;
    @ColumnName(name = "Bonûs Força")
    private Integer bonusStr;
    @ColumnName(name = "Bonûs Destreza")
    private Integer bonusDex;
    @ColumnName(name = "Bonûs Sabedoria")
    private Integer bonusWis;
    @ColumnName(name = "Bonûs Resistencia")
    private Integer bonusRes;
    @ColumnName(name = "Bonûs sorte")
    private Integer bonusLuc;
    @ColumnName(name = "Vantagens")
    private Collection<Perk> perkCollection;

    public EnemyRace() {
    }

    public EnemyRace(Long id) {
        this.id = id;
    }

    public EnemyRace(Long id, String raceName, Integer bonusHp, Integer bonusStr, Integer bonusDex, Integer bonusWis, Integer bonusRes, Integer bonusLuc, Collection<Perk> perkCollection) {
        this.id = id;
        this.raceName = raceName;
        this.bonusHp = bonusHp;
        this.bonusStr = bonusStr;
        this.bonusDex = bonusDex;
        this.bonusWis = bonusWis;
        this.bonusRes = bonusRes;
        this.bonusLuc = bonusLuc;
        this.perkCollection = perkCollection;
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

    public Integer getBonusHp() {
        return bonusHp;
    }

    public void setBonusHp(Integer bonusHp) {
        this.bonusHp = bonusHp;
    }

    public Integer getBonusStr() {
        return bonusStr;
    }

    public void setBonusStr(Integer bonusStr) {
        this.bonusStr = bonusStr;
    }

    public Integer getBonusDex() {
        return bonusDex;
    }

    public void setBonusDex(Integer bonusDex) {
        this.bonusDex = bonusDex;
    }

    public Integer getBonusWis() {
        return bonusWis;
    }

    public void setBonusWis(Integer bonusWis) {
        this.bonusWis = bonusWis;
    }

    public Integer getBonusRes() {
        return bonusRes;
    }

    public void setBonusRes(Integer bonusRes) {
        this.bonusRes = bonusRes;
    }

    public Integer getBonusLuc() {
        return bonusLuc;
    }

    public void setBonusLuc(Integer bonusLuc) {
        this.bonusLuc = bonusLuc;
    }

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
        return "br.com.rpgruler.data.entitity.CharRace[ id=" + id + " ]";
    }

}
