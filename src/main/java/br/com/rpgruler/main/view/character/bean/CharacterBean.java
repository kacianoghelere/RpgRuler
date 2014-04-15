package br.com.rpgruler.main.view.character.bean;

import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.character.CharacterView;
import br.com.rpgruler.main.view.bean.ViewBean;

/**
 * Bean de controle para a tela de personagens
 *
 * @author kaciano
 */
public class CharacterBean extends ViewBean<CharacterView> {

    public CharacterBean(CharacterView view) {
        super(view);
    }

    @Override
    public void save(BeanEvent evt) throws Exception {
        super.save(evt);
    }

    @Override
    public void process(BeanEvent evt) throws Exception {
        super.process(evt);
    }

    @Override
    public void clear(BeanEvent evt) throws Exception {
        super.clear(evt);
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        super.load(evt);
    }

}
