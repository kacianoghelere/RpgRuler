package br.com.rpgruler.main.view.bean;

import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.PerkView;

/**
 *
 * @author kaciano
 */
public class PerkBean extends DefaultViewBean<PerkView> {

    private PerkView view;

    public PerkBean(PerkView view) {
        super(view);
        this.view = view;
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

    @Override
    public PerkView getView() {
        return view;
    }

    /**
     * Modifica a view do bean
     *
     * @param view <code>PerkView</code> Tela
     */
    public void setView(PerkView view) {
        this.view = view;
    }

}
