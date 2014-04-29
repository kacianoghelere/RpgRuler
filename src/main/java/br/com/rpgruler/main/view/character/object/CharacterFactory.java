package br.com.rpgruler.main.view.character.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class CharacterFactory implements Serializable {

    public List<CharacterSheet> getSheet() {
        List<CharacterSheet> sheet = new ArrayList<>();
        sheet.add(new CharacterSheet("teste", "teste", 20));
        return sheet;
    }
}
