package br.com.rpgruler.main.view;

import br.com.gmp.comps.model.GListModel;
import br.com.rpgruler.data.entitity.Effect;
import br.com.rpgruler.data.entitity.WearType;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.bean.TermsBean;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.object.ViewParameter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;

/**
 *
 * @author kaciano
 */
public class TermsView extends DefaultView {

    private TermsBean bean;
    private GListModel<WearType> wtModel;
    private GListModel<Effect> efModel;

    /**
     * Cria nova instancia de TermsView
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     */
    public TermsView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
        this.setSize(460, 300);
        this.setControls(new ViewParameter(true, false, false, true));
        this.bean = new TermsBean(this);
        this.wtModel = new GListModel<>();
        this.efModel = new GListModel<>();
        this.jListWearTypes.setModel(wtModel);
        this.jListEffects.setModel(efModel);
        this.gTWearTypes.setPlaceholder("Tipo de uso");
        try {
            this.bean.load(null);
        } catch (Exception ex) {
            Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void load() {
        super.load(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Retorna a lista de tipos de uso para armas
     *
     * @return <code>JList</code> Lista de tipos de uso para armas
     */
    public JList getWearList() {
        return jListWearTypes;
    }

    /**
     * Adiciona novo elemento na lista de tipos de uso para armas
     */
    public void addWearType() {
        if (gTWearTypes.validateComponent()) {
            bean.addWearType(new BeanEvent(this, gTWearTypes.getText()));
            gTWearTypes.setText("");
        }
    }

    /**
     * Remove o WearType selecionado
     */
    private void removeWearType() {
        if (jListWearTypes.getSelectedIndex() >= 0) {
            WearType wt = wtModel.getElementAt(jListWearTypes.getSelectedIndex());
            wtModel.remove(wt);
        }
    }

    /**
     * Adiciona novo elemento na lista de efeitos
     */
    public void addEffect() {
        if (gTEffects.validateComponent()) {
            bean.addEffect(new BeanEvent(this, gTEffects.getText()));
            gTEffects.setText("");
        }
    }

    /**
     * Remove o Effect selecionado
     */
    private void removeEffect() {
        if (jListEffects.getSelectedIndex() >= 0) {
            Effect ef = efModel.getElementAt(jListEffects.getSelectedIndex());
            efModel.remove(ef);
        }
    }

    /**
     * Retorna o modelo de lista dos WearTypes
     *
     * @return <code>GListModel(WearType)</code>
     */
    public GListModel<WearType> getWtModel() {
        return this.wtModel;
    }

    /**
     * Retorna o modelo de lista dos Effects
     *
     * @return <code>GListModel(Effect)</code>
     */
    public GListModel<Effect> getEfModel() {
        return efModel;
    }

    @Override
    public BeanListener getBean() {
        return bean;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPWearTypes = new javax.swing.JPanel();
        jSP1 = new javax.swing.JScrollPane();
        jListWearTypes = new javax.swing.JList();
        gTWearTypes = new br.com.gmp.comps.textfield.GMPTextField();
        jPEffects = new javax.swing.JPanel();
        jSP2 = new javax.swing.JScrollPane();
        jListEffects = new javax.swing.JList();
        gTEffects = new br.com.gmp.comps.textfield.GMPTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Termos comuns");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1213_.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(460, 300));
        setMinimumSize(new java.awt.Dimension(460, 300));
        setPreferredSize(new java.awt.Dimension(460, 300));
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        jPWearTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Usos de armas"));

        jListWearTypes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListWearTypes.setMaximumSize(new java.awt.Dimension(150, 125));
        jListWearTypes.setMinimumSize(new java.awt.Dimension(150, 125));
        jListWearTypes.setPreferredSize(new java.awt.Dimension(150, 125));
        jListWearTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jListWearTypesKeyReleased(evt);
            }
        });
        jSP1.setViewportView(jListWearTypes);

        gTWearTypes.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTWearTypes.setMinimumSize(new java.awt.Dimension(150, 28));
        gTWearTypes.setPreferredSize(new java.awt.Dimension(150, 28));
        gTWearTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTWearTypesKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPWearTypesLayout = new javax.swing.GroupLayout(jPWearTypes);
        jPWearTypes.setLayout(jPWearTypesLayout);
        jPWearTypesLayout.setHorizontalGroup(
            jPWearTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPWearTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPWearTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSP1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(gTWearTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPWearTypesLayout.setVerticalGroup(
            jPWearTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPWearTypesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jSP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTWearTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPWearTypes);

        jPEffects.setBorder(javax.swing.BorderFactory.createTitledBorder("Efeitos"));

        jListEffects.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListEffects.setMaximumSize(new java.awt.Dimension(150, 125));
        jListEffects.setMinimumSize(new java.awt.Dimension(150, 125));
        jListEffects.setPreferredSize(new java.awt.Dimension(150, 125));
        jListEffects.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jListEffectsKeyReleased(evt);
            }
        });
        jSP2.setViewportView(jListEffects);

        gTEffects.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTEffects.setMinimumSize(new java.awt.Dimension(150, 28));
        gTEffects.setPreferredSize(new java.awt.Dimension(150, 28));
        gTEffects.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTEffectsKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPEffectsLayout = new javax.swing.GroupLayout(jPEffects);
        jPEffects.setLayout(jPEffectsLayout);
        jPEffectsLayout.setHorizontalGroup(
            jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEffectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSP2)
                    .addComponent(gTEffects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPEffectsLayout.setVerticalGroup(
            jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEffectsLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jSP2)
                .addGap(6, 6, 6)
                .addComponent(gTEffects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPEffects);
    }// </editor-fold>//GEN-END:initComponents

    private void gTWearTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTWearTypesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addWearType();
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTWearTypesKeyReleased

    private void jListWearTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListWearTypesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeWearType();
            } catch (Exception e) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_jListWearTypesKeyReleased

    private void jListEffectsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListEffectsKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeEffect();
            } catch (Exception e) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_jListEffectsKeyReleased

    private void gTEffectsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTEffectsKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addEffect();
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTEffectsKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.textfield.GMPTextField gTEffects;
    private br.com.gmp.comps.textfield.GMPTextField gTWearTypes;
    private javax.swing.JList jListEffects;
    private javax.swing.JList jListWearTypes;
    private javax.swing.JPanel jPEffects;
    private javax.swing.JPanel jPWearTypes;
    private javax.swing.JScrollPane jSP1;
    private javax.swing.JScrollPane jSP2;
    // End of variables declaration//GEN-END:variables
}
