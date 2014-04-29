package br.com.rpgruler.main.view.character.object;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class CharacterSheet {

    private String charName;
    private String playerName;
    private int level;

    public CharacterSheet(String charName, String playerName, int level) {
        this.charName = charName;
        this.playerName = playerName;
        this.level = level;
    }

    public List<CharacterSheet> getSheet() {
        List<CharacterSheet> sheet = new ArrayList<>();
        sheet.add(this);
        return sheet;
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
