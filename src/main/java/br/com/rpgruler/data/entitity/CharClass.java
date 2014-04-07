package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 *
 * @author kaciano
 */
public class CharClass implements Serializable {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Titulo")
    private String title;
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
    @Ignore
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
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CharClass other = (CharClass) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return title;
    }

}
