package br.com.rpgruler.data.entitity;

import br.com.gmp.comps.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author kaciano
 */
public class PlayerChar implements Serializable {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String charName;
    @ColumnName(name = "Jogador")
    private String playerName;
    @ColumnName(name = "Idade")
    private Integer age;
    @ColumnName(name = "Sexo")
    private Character sex;
    @ColumnName(name = "Altura")
    private Integer height;
    @ColumnName(name = "Peso")
    private Integer weight;
    @ColumnName(name = "Classe")
    private CharClass charClass;
    @ColumnName(name = "Raça")
    private CharRace charRace;
    @Ignore
    @ColumnName(name = "Informações")
    private Collection<PlayerCharInfo> playerCharInfoCollection;
    @Ignore
    @ColumnName(name = "Pericias")
    private Collection<Expertise> expertiseCollection;

    public PlayerChar() {
    }

    public PlayerChar(String charName, String playerName, Integer age, Character sex, Integer height, Integer weight) {
        this.charName = charName;
        this.playerName = playerName;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Collection<PlayerCharInfo> getPlayerCharInfoCollection() {
        return playerCharInfoCollection;
    }

    public void setPlayerCharInfoCollection(Collection<PlayerCharInfo> playerCharInfoCollection) {
        this.playerCharInfoCollection = playerCharInfoCollection;
    }

    public CharClass getCharClass() {
        return charClass;
    }

    public void setCharClass(CharClass charClass) {
        this.charClass = charClass;
    }

    public CharRace getCharRace() {
        return charRace;
    }

    public void setCharRace(CharRace charRace) {
        this.charRace = charRace;
    }

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
