package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author kaciano
 */
public class PlayerChar implements Serializable {

    @Id

    @Column(name = "Código")
    private Long id;
    @Column(name = "Nome")
    private String charName;
    @Column(name = "Jogador")
    private String playerName;
    @Column(name = "Idade")
    private Integer age;
    @Column(name = "Sexo")
    private Character sex;
    @Column(name = "Altura")
    private Integer height;
    @Column(name = "Peso")
    private Integer weight;
    @Column(name = "Classe")
    private CharClass idCharClass;
    @Column(name = "Raça")
    private CharRace idCharRace;
    @Column(name = "Informações")
    private Collection<PlayerCharInfo> playerCharInfoCollection;
    @Column(name = "Pericias")
    private Collection<Expertise> expertiseCollection;

    public PlayerChar() {
    }

    public PlayerChar(Long id) {
        this.id = id;
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
