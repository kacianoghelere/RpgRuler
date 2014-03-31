package br.com.rpgruler.main.view;

import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.view.bean.TermsBean;
import com.sun.glass.events.KeyEvent;
import javax.swing.JList;

/**
 *
 * @author kaciano
 */
public class TermsView extends DefaultView {

    private TermsBean bean;

    /**
     * Cria novo TermsView
     *
     * @param screen <code>MainScreen</code> Tela principal
     */
    public TermsView(MainScreen screen) {
        super(screen);
        bean = new TermsBean(this);
        initComponents();
    }

    /**
     * Retorna o objeto selecionado da lista indicado
     *
     * @param list <code>JList</code> Lista indicada
     * @return <code>Object</code> Objeto selecionado
     */
    private Object getSelectItem(JList list) {
        Object last = list.getModel().getElementAt(list.getMaxSelectionIndex());
        return list.getSelectedValue() != null
                ? list.getSelectedValue() : last;
    }

    /**
     * Retorna o objetos selecionados da lista indicado
     *
     * @param list <code>JList</code> Lista indicada
     * @return <code>Object[]</code> Objeto selecionado
     */
    private Object[] getSelectItems(JList list) {
        Object[] last = {list.getModel().getElementAt(list.getMaxSelectionIndex())};
        return list.getSelectedValues() != null
                ? list.getSelectedValues()
                : last;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPAttributes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAttributes = new javax.swing.JList();
        gTAttributes = new br.com.gmp.comps.textfield.GMPTextField();
        jPWeaponTypes = new javax.swing.JPanel();
        gTWeaponTypes = new br.com.gmp.comps.textfield.GMPTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListWeaponTypes = new javax.swing.JList();
        jPSkillTypes = new javax.swing.JPanel();
        gTSkillTypes = new br.com.gmp.comps.textfield.GMPTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListSkillTypes = new javax.swing.JList();
        jPArmorTypes = new javax.swing.JPanel();
        gTArmorTypes = new br.com.gmp.comps.textfield.GMPTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListArmorTypes = new javax.swing.JList();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Termos");

        jPAttributes.setBorder(javax.swing.BorderFactory.createTitledBorder("Atributos"));
        jPAttributes.setMaximumSize(new java.awt.Dimension(200, 230));
        jPAttributes.setMinimumSize(new java.awt.Dimension(200, 230));
        jPAttributes.setPreferredSize(new java.awt.Dimension(200, 230));

        jListAttributes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jListAttributesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jListAttributes);

        gTAttributes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTAttributesKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPAttributesLayout = new javax.swing.GroupLayout(jPAttributes);
        jPAttributes.setLayout(jPAttributesLayout);
        jPAttributesLayout.setHorizontalGroup(
            jPAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAttributesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(gTAttributes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPAttributesLayout.setVerticalGroup(
            jPAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAttributesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTAttributes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPWeaponTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de armas"));
        jPWeaponTypes.setMaximumSize(new java.awt.Dimension(200, 230));
        jPWeaponTypes.setMinimumSize(new java.awt.Dimension(200, 230));
        jPWeaponTypes.setPreferredSize(new java.awt.Dimension(200, 230));

        gTWeaponTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTWeaponTypesKeyReleased(evt);
            }
        });

        jListWeaponTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jListWeaponTypesKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jListWeaponTypes);

        javax.swing.GroupLayout jPWeaponTypesLayout = new javax.swing.GroupLayout(jPWeaponTypes);
        jPWeaponTypes.setLayout(jPWeaponTypesLayout);
        jPWeaponTypesLayout.setHorizontalGroup(
            jPWeaponTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPWeaponTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPWeaponTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(gTWeaponTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPWeaponTypesLayout.setVerticalGroup(
            jPWeaponTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPWeaponTypesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTWeaponTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPSkillTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de habilidades"));
        jPSkillTypes.setMaximumSize(new java.awt.Dimension(200, 230));
        jPSkillTypes.setMinimumSize(new java.awt.Dimension(200, 230));
        jPSkillTypes.setPreferredSize(new java.awt.Dimension(200, 230));

        gTSkillTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTSkillTypesKeyReleased(evt);
            }
        });

        jListSkillTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jListSkillTypesKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jListSkillTypes);

        javax.swing.GroupLayout jPSkillTypesLayout = new javax.swing.GroupLayout(jPSkillTypes);
        jPSkillTypes.setLayout(jPSkillTypesLayout);
        jPSkillTypesLayout.setHorizontalGroup(
            jPSkillTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSkillTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPSkillTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(gTSkillTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPSkillTypesLayout.setVerticalGroup(
            jPSkillTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSkillTypesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTSkillTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPArmorTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de armaduras"));
        jPArmorTypes.setMaximumSize(new java.awt.Dimension(200, 230));
        jPArmorTypes.setMinimumSize(new java.awt.Dimension(200, 230));
        jPArmorTypes.setPreferredSize(new java.awt.Dimension(200, 230));

        gTArmorTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTArmorTypesKeyReleased(evt);
            }
        });

        jListArmorTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jListArmorTypesKeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(jListArmorTypes);

        javax.swing.GroupLayout jPArmorTypesLayout = new javax.swing.GroupLayout(jPArmorTypes);
        jPArmorTypes.setLayout(jPArmorTypesLayout);
        jPArmorTypesLayout.setHorizontalGroup(
            jPArmorTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPArmorTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPArmorTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(gTArmorTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPArmorTypesLayout.setVerticalGroup(
            jPArmorTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPArmorTypesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTArmorTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPSkillTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPAttributes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPWeaponTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPArmorTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPWeaponTypes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPAttributes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPSkillTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPArmorTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void gTAttributesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTAttributesKeyReleased
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {

        }
    }//GEN-LAST:event_gTAttributesKeyReleased

    private void jListAttributesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListAttributesKeyReleased
        if (KeyEvent.VK_DELETE == evt.getKeyCode()) {

        }
    }//GEN-LAST:event_jListAttributesKeyReleased

    private void gTWeaponTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTWeaponTypesKeyReleased
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {

        }
    }//GEN-LAST:event_gTWeaponTypesKeyReleased

    private void jListWeaponTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListWeaponTypesKeyReleased
        if (KeyEvent.VK_DELETE == evt.getKeyCode()) {

        }
    }//GEN-LAST:event_jListWeaponTypesKeyReleased

    private void gTSkillTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTSkillTypesKeyReleased
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {

        }
    }//GEN-LAST:event_gTSkillTypesKeyReleased

    private void jListSkillTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListSkillTypesKeyReleased
        if (KeyEvent.VK_DELETE == evt.getKeyCode()) {

        }
    }//GEN-LAST:event_jListSkillTypesKeyReleased

    private void gTArmorTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTArmorTypesKeyReleased
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {

        }
    }//GEN-LAST:event_gTArmorTypesKeyReleased

    private void jListArmorTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListArmorTypesKeyReleased
        if (KeyEvent.VK_DELETE == evt.getKeyCode()) {

        }
    }//GEN-LAST:event_jListArmorTypesKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.textfield.GMPTextField gTArmorTypes;
    private br.com.gmp.comps.textfield.GMPTextField gTAttributes;
    private br.com.gmp.comps.textfield.GMPTextField gTSkillTypes;
    private br.com.gmp.comps.textfield.GMPTextField gTWeaponTypes;
    private javax.swing.JList jListArmorTypes;
    private javax.swing.JList jListAttributes;
    private javax.swing.JList jListSkillTypes;
    private javax.swing.JList jListWeaponTypes;
    private javax.swing.JPanel jPArmorTypes;
    private javax.swing.JPanel jPAttributes;
    private javax.swing.JPanel jPSkillTypes;
    private javax.swing.JPanel jPWeaponTypes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}
