package br.com.rpgruler.main.view.terms;

import br.com.gmp.comps.model.GListModel;
import br.com.rpgruler.data.entitity.EffectType;
import br.com.rpgruler.data.entitity.PerkType;
import br.com.rpgruler.data.entitity.WearType;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.View;
import br.com.rpgruler.main.view.terms.bean.TermsBean;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.object.ViewParameter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;

/**
 * Tela para cadastro de termos comuns
 *
 * @author kaciano
 * @version 1.0
 */
public class TermsView extends View {

    private TermsBean bean;
    private GListModel<WearType> wtModel;
    private GListModel<EffectType> efModel;
    private GListModel<PerkType> perkModel;

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
        this.setSize(620, 300);
        this.setControls(new ViewParameter(true, false, false, true));
        this.bean = new TermsBean(this);
        this.wtModel = new GListModel<>();
        this.efModel = new GListModel<>();
        this.perkModel = new GListModel<>();
        this.gListWearTypes.setModel(wtModel);
        this.gListEffectTypes.setModel(efModel);
        this.gListPerkTypes.setModel(perkModel);
        this.gTWearTypes.setPlaceholder("Tipos de uso");
        this.gTWearTypes.grabFocus();
        this.gTEffectTypes.setPlaceholder("Tipos de efeitos");
        this.gTPerkTypes.setPlaceholder("Tipos de vantagens");
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
        return gListWearTypes;
    }

    /**
     * Adiciona novo elemento na lista de tipos de uso para armas
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    public void addWearType(KeyEvent evt) {
        if (gTWearTypes.validateComponent()) {
            bean.addWearType(new BeanEvent(this, gTWearTypes.getText()));
            gTWearTypes.setText("");
        }
    }

    /**
     * Remove o WearType selecionado
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void removeWearType(KeyEvent evt) {
        if (gListWearTypes.getModel().getSize() > 0 && gListWearTypes.getSelectedIndex() >= 0) {
            WearType wt = wtModel.getElementAt(gListWearTypes.getSelectedIndex());
            wtModel.remove(wt);
        }
    }

    /**
     * Adiciona novo elemento na lista de efeitos
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    public void addEffectType(KeyEvent evt) {
        if (gTEffectTypes.validateComponent()) {
            bean.addEffect(new BeanEvent(this, gTEffectTypes.getText()));
            gTEffectTypes.setText("");
        }
    }

    /**
     * Remove o EffectType selecionado
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void removeEffectType(KeyEvent evt) {
        if (gListEffectTypes.getModel().getSize() > 0 && gListEffectTypes.getSelectedIndex() >= 0) {
            EffectType ef = efModel.getElementAt(gListEffectTypes.getSelectedIndex());
            efModel.remove(ef);
        }
    }

    /**
     * Adiciona novo elemento na lista de PerkTypes
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    public void addPerkType(KeyEvent evt) {
        if (gTPerkTypes.validateComponent()) {
            bean.addPerk(new BeanEvent(this, gTPerkTypes.getText()));
            gTPerkTypes.setText("");
        }
    }

    /**
     * Remove o PerkType selecionado
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void removePerkType(KeyEvent evt) {
        if (gListPerkTypes.getModel().getSize() > 0 && gListPerkTypes.getSelectedIndex() >= 0) {
            PerkType type = perkModel.getElementAt(gListPerkTypes.getSelectedIndex());
            perkModel.remove(type);
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
     * Retorna o modelo de lista dos EffectTypes
     *
     * @return <code>GListModel(EffectType)</code>
     */
    public GListModel<EffectType> getEfModel() {
        return efModel;
    }

    /**
     * Retorna o modelo de lista dos PerkTypes
     *
     * @return <code>GListModel(PerkType)</code>
     */
    public GListModel<PerkType> getPerkModel() {
        return perkModel;
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
        gTWearTypes = new br.com.gmp.comps.textfield.GTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        gListWearTypes = new br.com.gmp.comps.list.GList();
        jPEffects = new javax.swing.JPanel();
        gTEffectTypes = new br.com.gmp.comps.textfield.GTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        gListEffectTypes = new br.com.gmp.comps.list.GList();
        jPPerkTypes = new javax.swing.JPanel();
        gTPerkTypes = new br.com.gmp.comps.textfield.GTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        gListPerkTypes = new br.com.gmp.comps.list.GList();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Termos comuns");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1213_.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(620, 300));
        setMinimumSize(new java.awt.Dimension(620, 300));
        setPreferredSize(new java.awt.Dimension(620, 300));
        getContentPane().setLayout(new java.awt.GridLayout());

        jPWearTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Usos de armas"));

        gTWearTypes.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTWearTypes.setMinimumSize(new java.awt.Dimension(150, 28));
        gTWearTypes.setNextFocusableComponent(gTEffectTypes);
        gTWearTypes.setPreferredSize(new java.awt.Dimension(150, 28));
        gTWearTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTWearTypesKeyReleased(evt);
            }
        });

        gListWearTypes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        gListWearTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gListWearTypesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(gListWearTypes);

        javax.swing.GroupLayout jPWearTypesLayout = new javax.swing.GroupLayout(jPWearTypes);
        jPWearTypes.setLayout(jPWearTypesLayout);
        jPWearTypesLayout.setHorizontalGroup(
            jPWearTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPWearTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPWearTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gTWearTypes, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPWearTypesLayout.setVerticalGroup(
            jPWearTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPWearTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTWearTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPWearTypes);

        jPEffects.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Efeitos"));

        gTEffectTypes.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTEffectTypes.setMinimumSize(new java.awt.Dimension(150, 28));
        gTEffectTypes.setNextFocusableComponent(gTPerkTypes);
        gTEffectTypes.setPreferredSize(new java.awt.Dimension(150, 28));
        gTEffectTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTEffectTypesKeyReleased(evt);
            }
        });

        gListEffectTypes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        gListEffectTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gListEffectTypesKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(gListEffectTypes);

        javax.swing.GroupLayout jPEffectsLayout = new javax.swing.GroupLayout(jPEffects);
        jPEffects.setLayout(jPEffectsLayout);
        jPEffectsLayout.setHorizontalGroup(
            jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEffectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTEffectTypes, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPEffectsLayout.setVerticalGroup(
            jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEffectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTEffectTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPEffects);

        jPPerkTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Vantagens"));

        gTPerkTypes.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTPerkTypes.setMinimumSize(new java.awt.Dimension(150, 28));
        gTPerkTypes.setNextFocusableComponent(gTWearTypes);
        gTPerkTypes.setPreferredSize(new java.awt.Dimension(150, 28));
        gTPerkTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTPerkTypesKeyReleased(evt);
            }
        });

        gListPerkTypes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        gListPerkTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gListPerkTypesKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(gListPerkTypes);

        javax.swing.GroupLayout jPPerkTypesLayout = new javax.swing.GroupLayout(jPPerkTypes);
        jPPerkTypes.setLayout(jPPerkTypesLayout);
        jPPerkTypesLayout.setHorizontalGroup(
            jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPerkTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTPerkTypes, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPPerkTypesLayout.setVerticalGroup(
            jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPerkTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTPerkTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPPerkTypes);
    }// </editor-fold>//GEN-END:initComponents

    private void gTWearTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTWearTypesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addWearType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTWearTypesKeyReleased

    private void gTEffectTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTEffectTypesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addEffectType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTEffectTypesKeyReleased

    private void gTPerkTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTPerkTypesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addPerkType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTPerkTypesKeyReleased

    private void gListWearTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gListWearTypesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeWearType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gListWearTypesKeyReleased

    private void gListEffectTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gListEffectTypesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeEffectType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gListEffectTypesKeyReleased

    private void gListPerkTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gListPerkTypesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removePerkType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gListPerkTypesKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.list.GList gListEffectTypes;
    private br.com.gmp.comps.list.GList gListPerkTypes;
    private br.com.gmp.comps.list.GList gListWearTypes;
    private br.com.gmp.comps.textfield.GTextField gTEffectTypes;
    private br.com.gmp.comps.textfield.GTextField gTPerkTypes;
    private br.com.gmp.comps.textfield.GTextField gTWearTypes;
    private javax.swing.JPanel jPEffects;
    private javax.swing.JPanel jPPerkTypes;
    private javax.swing.JPanel jPWearTypes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
