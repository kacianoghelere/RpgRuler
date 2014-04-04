package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class CharClass implements Serializable {

    @Id
    @Column(name = "Código")
    private Long id;
    @Column(name = "Titulo")
    private String title;
    @Column(name = "Bonûs HP")
    private Integer bonusHp;
    @Column(name = "Bonûs Força")
    private Integer bonusStr;
    @Column(name = "Bonûs Destreza")
    private Integer bonusDex;
    @Column(name = "Bonûs Sabedoria")
    private Integer bonusWis;
    @Column(name = "Bonûs Resistencia")
    private Integer bonusRes;
    @Column(name = "Bonûs sorte")
    private Integer bonusLuc;
    @Column(name = "Vantagens")
    private Collection<Perk> perkCollection;

    public CharClass() {
    }

    public CharClass(Long id) {
        this.id = id;
    }

    public CharClass(Long id, Integer bonusHp, Integer bonusStr, Integer bonusDex, Integer bonusRes, Integer bonusWis, Integer bonusLuc) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getBonusRes() {
        return bonusRes;
    }

    public void setBonusRes(Integer bonusRes) {
        this.bonusRes = bonusRes;
    }

    public Integer getBonusWis() {
        return bonusWis;
    }

    public void setBonusWis(Integer bonusWis) {
        this.bonusWis = bonusWis;
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
        if (!(object instanceof CharClass)) {
            return false;
        }
        CharClass other = (CharClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rpgruler.data.entitity.CharClass[ id=" + id + " ]";
    }

}
