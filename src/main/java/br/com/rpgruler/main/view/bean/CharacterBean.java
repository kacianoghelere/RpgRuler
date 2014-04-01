package br.com.rpgruler.main.view.bean;

import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.CharacterView;

/**
 * Bean de controle para a tela de personagens
 *
 * @author kaciano
 */
public class CharacterBean extends DefaultViewBean<CharacterView> {

    public CharacterBean(CharacterView view) {
        super(view);
    }

    @Override
    public void save(BeanEvent evt) {
        super.save(evt);
    }

    @Override
    public void delete(BeanEvent evt) {
        super.delete(evt);
    }

    @Override
    public void process(BeanEvent evt) {
        super.process(evt);
    }

    @Override
    public void clear(BeanEvent evt) {
        super.clear(evt);
    }

    @Override
    public void load(BeanEvent evt) {
        super.load(evt);
    }

}
