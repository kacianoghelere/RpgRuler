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
        this.jListWearTypes.setModel(wtModel);
        this.jListEffectTypes.setModel(efModel);
        this.jListPerkTypes.setModel(perkModel);
        this.gTWearTypes.setPlaceholder("Tipos de uso");
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
    public void addEffectType() {
        if (gTEffectTypes.validateComponent()) {
            bean.addEffect(new BeanEvent(this, gTEffectTypes.getText()));
            gTEffectTypes.setText("");
        }
    }

    /**
     * Remove o EffectType selecionado
     */
    private void removeEffectType() {
        if (jListEffectTypes.getSelectedIndex() >= 0) {
            EffectType ef = efModel.getElementAt(jListEffectTypes.getSelectedIndex());
            efModel.remove(ef);
        }
    }

    /**
     * Adiciona novo elemento na lista de PerkTypes
     */
    public void addPerkType() {
        if (gTEffectTypes.validateComponent()) {
            bean.addEffect(new BeanEvent(this, gTPerkTypes.getText()));
            gTEffectTypes.setText("");
        }
    }

    /**
     * Remove o PerkType selecionado
     */
    private void removePerkType() {
        if (jListPerkTypes.getSelectedIndex() >= 0) {
            PerkType type = perkModel.getElementAt(jListPerkTypes.getSelectedIndex());
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
        jSP1 = new javax.swing.JScrollPane();
        jListWearTypes = new javax.swing.JList();
        gTWearTypes = new br.com.gmp.comps.textfield.GTextField();
        jPEffects = new javax.swing.JPanel();
        jSP2 = new javax.swing.JScrollPane();
        jListEffectTypes = new javax.swing.JList();
        gTEffectTypes = new br.com.gmp.comps.textfield.GTextField();
        jPPerkTypes = new javax.swing.JPanel();
        jSP3 = new javax.swing.JScrollPane();
        jListPerkTypes = new javax.swing.JList();
        gTPerkTypes = new br.com.gmp.comps.textfield.GTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Termos comuns");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1213_.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(620, 300));
        setMinimumSize(new java.awt.Dimension(620, 300));
        setPreferredSize(new java.awt.Dimension(620, 300));
        getContentPane().setLayout(new java.awt.GridLayout(1, 3));

        jPWearTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Usos de armas"));

        jListWearTypes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListWearTypes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
                    .addComponent(jSP1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(gTWearTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPWearTypesLayout.setVerticalGroup(
            jPWearTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPWearTypesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jSP1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTWearTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPWearTypes);

        jPEffects.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Efeitos"));

        jListEffectTypes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListEffectTypes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListEffectTypes.setMaximumSize(new java.awt.Dimension(150, 125));
        jListEffectTypes.setMinimumSize(new java.awt.Dimension(150, 125));
        jListEffectTypes.setPreferredSize(new java.awt.Dimension(150, 125));
        jListEffectTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jListEffectTypesKeyReleased(evt);
            }
        });
        jSP2.setViewportView(jListEffectTypes);

        gTEffectTypes.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTEffectTypes.setMinimumSize(new java.awt.Dimension(150, 28));
        gTEffectTypes.setPreferredSize(new java.awt.Dimension(150, 28));
        gTEffectTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTEffectTypesKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPEffectsLayout = new javax.swing.GroupLayout(jPEffects);
        jPEffects.setLayout(jPEffectsLayout);
        jPEffectsLayout.setHorizontalGroup(
            jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEffectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSP2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(gTEffectTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPEffectsLayout.setVerticalGroup(
            jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEffectsLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jSP2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(gTEffectTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPEffects);

        jPPerkTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Efeitos"));

        jListPerkTypes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListPerkTypes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListPerkTypes.setMaximumSize(new java.awt.Dimension(150, 125));
        jListPerkTypes.setMinimumSize(new java.awt.Dimension(150, 125));
        jListPerkTypes.setPreferredSize(new java.awt.Dimension(150, 125));
        jListPerkTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jListPerkTypesKeyReleased(evt);
            }
        });
        jSP3.setViewportView(jListPerkTypes);

        gTPerkTypes.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTPerkTypes.setMinimumSize(new java.awt.Dimension(150, 28));
        gTPerkTypes.setPreferredSize(new java.awt.Dimension(150, 28));
        gTPerkTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTPerkTypesKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPPerkTypesLayout = new javax.swing.GroupLayout(jPPerkTypes);
        jPPerkTypes.setLayout(jPPerkTypesLayout);
        jPPerkTypesLayout.setHorizontalGroup(
            jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPerkTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSP3, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(gTPerkTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPPerkTypesLayout.setVerticalGroup(
            jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPerkTypesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jSP3, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(gTPerkTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPPerkTypes);
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

    private void jListEffectTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListEffectTypesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeEffectType();
            } catch (Exception e) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_jListEffectTypesKeyReleased

    private void gTEffectTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTEffectTypesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addEffectType();
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTEffectTypesKeyReleased

    private void jListPerkTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListPerkTypesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removePerkType();
            } catch (Exception e) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_jListPerkTypesKeyReleased

    private void gTPerkTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTPerkTypesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addPerkType();
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTPerkTypesKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.textfield.GTextField gTEffectTypes;
    private br.com.gmp.comps.textfield.GTextField gTPerkTypes;
    private br.com.gmp.comps.textfield.GTextField gTWearTypes;
    private javax.swing.JList jListEffectTypes;
    private javax.swing.JList jListPerkTypes;
    private javax.swing.JList jListWearTypes;
    private javax.swing.JPanel jPEffects;
    private javax.swing.JPanel jPPerkTypes;
    private javax.swing.JPanel jPWearTypes;
    private javax.swing.JScrollPane jSP1;
    private javax.swing.JScrollPane jSP2;
    private javax.swing.JScrollPane jSP3;
    // End of variables declaration//GEN-END:variables
}
