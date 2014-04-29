package br.com.rpgruler.main.view.character.object;

import java.io.Serializable;

/**
 *
 * @author kaciano
 */
public class CharacterSheet implements Serializable {

    private String charName;
    private String playerName;
    private int level;

    public CharacterSheet(String charName, String playerName, int level) {
        this.charName = charName;
        this.playerName = playerName;
        this.level = level;
    }

    public CharacterSheet() {
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
