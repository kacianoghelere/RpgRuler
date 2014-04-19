package br.com.rpgruler.main.view.terms;

import br.com.gmp.comps.model.GListModel;
import br.com.rpgruler.data.entitity.EffectType;
import br.com.rpgruler.data.entitity.PerkType;
import br.com.rpgruler.data.entitity.RestrictionType;
import br.com.rpgruler.data.entitity.UseType;
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
    private GListModel<UseType> useModel;
    private GListModel<EffectType> efModel;
    private GListModel<PerkType> perkModel;
    private GListModel<RestrictionType> restModel;

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
        this.setSize(754, 300);
        this.setControls(new ViewParameter(true, false, false, true));
        this.bean = new TermsBean(this);
        this.useModel = new GListModel<>();
        this.efModel = new GListModel<>();
        this.perkModel = new GListModel<>();
        this.restModel = new GListModel<>();
        this.gLtUseTp.setModel(useModel);
        this.gLtEffectTp.setModel(efModel);
        this.gLtPerkTp.setModel(perkModel);
        this.gLtRestTp.setModel(restModel);
        this.gTUseTp.setPlaceholder("Tipos de uso");
        this.gTEffectTp.setPlaceholder("Tipos de efeitos");
        this.gTPerkTp.setPlaceholder("Tipos de vantagens");
        this.gTRestrictTp.setPlaceholder("Tipos de restrição");
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
        return gLtUseTp;
    }

    /**
     * Adiciona novo elemento na lista de tipos de uso para armas
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    public void addUseType(KeyEvent evt) {
        if (gTUseTp.validateComponent()) {
            bean.addUseTp(new BeanEvent(this, gTUseTp.getText()));
            gTUseTp.setText("");
        }
    }

    /**
     * Remove o UseType selecionado
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void removeUseType(KeyEvent evt) {
        if (gLtUseTp.getModel().getSize() > 0 && gLtUseTp.getSelectedIndex() >= 0) {
            UseType wt = useModel.getElementAt(gLtUseTp.getSelectedIndex());
            useModel.remove(wt);
        }
    }

    /**
     * Adiciona novo elemento na lista de efeitos
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    public void addEffectType(KeyEvent evt) {
        if (gTEffectTp.validateComponent()) {
            bean.addEffectTp(new BeanEvent(this, gTEffectTp.getText()));
            gTEffectTp.setText("");
        }
    }

    /**
     * Remove o EffectType selecionado
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void removeEffectType(KeyEvent evt) {
        if (gLtEffectTp.getModel().getSize() > 0 && gLtEffectTp.getSelectedIndex() >= 0) {
            EffectType ef = efModel.getElementAt(gLtEffectTp.getSelectedIndex());
            efModel.remove(ef);
        }
    }

    /**
     * Adiciona novo elemento na lista de PerkTypes
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    public void addPerkType(KeyEvent evt) {
        if (gTPerkTp.validateComponent()) {
            bean.addPerkTp(new BeanEvent(this, gTPerkTp.getText()));
            gTPerkTp.setText("");
        }
    }

    /**
     * Remove o PerkType selecionado
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void removePerkType(KeyEvent evt) {
        if (gLtPerkTp.getModel().getSize() > 0 && gLtPerkTp.getSelectedIndex() >= 0) {
            PerkType type = perkModel.getElementAt(gLtPerkTp.getSelectedIndex());
            perkModel.remove(type);
        }
    }

    /**
     * Adiciona novo elemento na lista de PerkTypes
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    public void addRestType(KeyEvent evt) {
        if (gTRestrictTp.validateComponent()) {
            bean.addRestTp(new BeanEvent(this, gTRestrictTp.getText()));
            gTRestrictTp.setText("");
        }
    }

    /**
     * Remove o RestrictionType selecionado
     *
     * @param evt <code>KeyEvent</code> Evento do teclado
     */
    private void removeRestType(KeyEvent evt) {
        if (gLtRestTp.getModel().getSize() > 0 && gLtRestTp.getSelectedIndex() >= 0) {
            RestrictionType type = restModel.getElementAt(gLtRestTp.getSelectedIndex());
            restModel.remove(type);
        }
    }

    /**
     * Retorna o modelo de lista dos WearTypes
     *
     * @return <code>GListModel(WearType)</code>
     */
    public GListModel<UseType> getUseModel() {
        return this.useModel;
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

    /**
     * Retorna o modelo de lista dos RestrictionTypes
     *
     * @return <code>GListModel(RestrictionType)</code>
     */
    public GListModel<RestrictionType> getRestModel() {
        return restModel;
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
        gTUseTp = new br.com.gmp.comps.textfield.GTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        gLtUseTp = new br.com.gmp.comps.list.GList();
        jPEffects = new javax.swing.JPanel();
        gTEffectTp = new br.com.gmp.comps.textfield.GTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        gLtEffectTp = new br.com.gmp.comps.list.GList();
        jPPerkTypes = new javax.swing.JPanel();
        gTPerkTp = new br.com.gmp.comps.textfield.GTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        gLtPerkTp = new br.com.gmp.comps.list.GList();
        jPRestrictTypes = new javax.swing.JPanel();
        gTRestrictTp = new br.com.gmp.comps.textfield.GTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        gLtRestTp = new br.com.gmp.comps.list.GList();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Termos comuns");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1213_.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(754, 300));
        setMinimumSize(new java.awt.Dimension(754, 300));
        setPreferredSize(new java.awt.Dimension(754, 300));
        getContentPane().setLayout(new java.awt.GridLayout(1, 4));

        jPWearTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Usos de armas"));

        gTUseTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTUseTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTUseTp.setNextFocusableComponent(gTEffectTp);
        gTUseTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTUseTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTUseTpKeyReleased(evt);
            }
        });

        gLtUseTp.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        gLtUseTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtUseTpKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(gLtUseTp);

        javax.swing.GroupLayout jPWearTypesLayout = new javax.swing.GroupLayout(jPWearTypes);
        jPWearTypes.setLayout(jPWearTypesLayout);
        jPWearTypesLayout.setHorizontalGroup(
            jPWearTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPWearTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPWearTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gTUseTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPWearTypesLayout.setVerticalGroup(
            jPWearTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPWearTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTUseTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPWearTypes);

        jPEffects.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Efeitos"));

        gTEffectTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTEffectTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTEffectTp.setNextFocusableComponent(gTPerkTp);
        gTEffectTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTEffectTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTEffectTpKeyReleased(evt);
            }
        });

        gLtEffectTp.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        gLtEffectTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtEffectTpKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(gLtEffectTp);

        javax.swing.GroupLayout jPEffectsLayout = new javax.swing.GroupLayout(jPEffects);
        jPEffects.setLayout(jPEffectsLayout);
        jPEffectsLayout.setHorizontalGroup(
            jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEffectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTEffectTp, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPEffectsLayout.setVerticalGroup(
            jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEffectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTEffectTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPEffects);

        jPPerkTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Vantagens"));

        gTPerkTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTPerkTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTPerkTp.setNextFocusableComponent(gTUseTp);
        gTPerkTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTPerkTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTPerkTpKeyReleased(evt);
            }
        });

        gLtPerkTp.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        gLtPerkTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtPerkTpKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(gLtPerkTp);

        javax.swing.GroupLayout jPPerkTypesLayout = new javax.swing.GroupLayout(jPPerkTypes);
        jPPerkTypes.setLayout(jPPerkTypesLayout);
        jPPerkTypesLayout.setHorizontalGroup(
            jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPerkTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTPerkTp, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPPerkTypesLayout.setVerticalGroup(
            jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPerkTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTPerkTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPPerkTypes);

        jPRestrictTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Restrições"));

        gTRestrictTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTRestrictTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTRestrictTp.setNextFocusableComponent(gTUseTp);
        gTRestrictTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTRestrictTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTRestrictTpKeyReleased(evt);
            }
        });

        gLtRestTp.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        gLtRestTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtRestTpKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(gLtRestTp);

        javax.swing.GroupLayout jPRestrictTypesLayout = new javax.swing.GroupLayout(jPRestrictTypes);
        jPRestrictTypes.setLayout(jPRestrictTypesLayout);
        jPRestrictTypesLayout.setHorizontalGroup(
            jPRestrictTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRestrictTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPRestrictTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTRestrictTp, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPRestrictTypesLayout.setVerticalGroup(
            jPRestrictTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRestrictTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTRestrictTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPRestrictTypes);
    }// </editor-fold>//GEN-END:initComponents

    private void gTUseTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTUseTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addUseType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTUseTpKeyReleased

    private void gTEffectTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTEffectTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addEffectType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTEffectTpKeyReleased

    private void gTPerkTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTPerkTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addPerkType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTPerkTpKeyReleased

    private void gLtUseTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtUseTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeUseType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gLtUseTpKeyReleased

    private void gLtEffectTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtEffectTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeEffectType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gLtEffectTpKeyReleased

    private void gLtPerkTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtPerkTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removePerkType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gLtPerkTpKeyReleased

    private void gTRestrictTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTRestrictTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addRestType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTRestrictTpKeyReleased

    private void gLtRestTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtRestTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeRestType(evt);
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gLtRestTpKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.list.GList gLtEffectTp;
    private br.com.gmp.comps.list.GList gLtPerkTp;
    private br.com.gmp.comps.list.GList gLtRestTp;
    private br.com.gmp.comps.list.GList gLtUseTp;
    private br.com.gmp.comps.textfield.GTextField gTEffectTp;
    private br.com.gmp.comps.textfield.GTextField gTPerkTp;
    private br.com.gmp.comps.textfield.GTextField gTRestrictTp;
    private br.com.gmp.comps.textfield.GTextField gTUseTp;
    private javax.swing.JPanel jPEffects;
    private javax.swing.JPanel jPPerkTypes;
    private javax.swing.JPanel jPRestrictTypes;
    private javax.swing.JPanel jPWearTypes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
