package br.com.rpgruler.main.actions;

import br.com.rpgruler.main.view.View;
import java.awt.event.ActionEvent;

/**
 * Ação padrão para salvar os dados, tecla F2
 *
 * @author kaciano
 */
public class SaveAction extends FrameAction {

    /**
     * Cria nova instancia de SaveAction
     *
     * @param view <code>View</code> da ação
     */
    public SaveAction(View view) {
        super("save", view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        getView().getMainScreen().save(null);
    }

}
