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
    public void save(BeanEvent evt) throws Exception {
        super.save(evt);
    }

    @Override
    public void delete(BeanEvent evt) throws Exception {
        super.delete(evt);
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
