/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rpgruler.main.view.armor.dialog;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.dialog.GDialog;
import br.com.rpgruler.data.db.dao.RestrictionTypeDAO;
import br.com.rpgruler.data.entitity.Restriction;
import br.com.rpgruler.data.entitity.RestrictionType;
import br.com.rpgruler.main.view.armor.ArmorView;

/**
 * Tela auxiliar para resgistro de restrições
 *
 * @author kaciano
 */
public class RestrictionDialog extends GDialog {

    private ArmorView view;
    private Restriction restriction;
    private GComboBoxModel<RestrictionType> restModel;

    /**
     * Cria nova instancia de RestrictionDialog
     *
     * @param view <code>ArmorView</code>
     * @param restriction <code>Restriction</code> Restrição
     * @param modal <code>boolean</code> Modal?
     */
    public RestrictionDialog(ArmorView view, Restriction restriction, boolean modal) {
        super(view.getMainScreen(), modal);
        this.view = view;
        this.restriction = restriction;
        this.initialize(restriction);
    }

    /**
     * Método de inicialização
     *
     * @param restriction <code>Restriction</code> Restrição
     */
    private void initialize(Restriction restriction) {
        setSize(275, 120);
        initComponents();
        this.restModel = new GComboBoxModel<>();
        this.restModel.setData(new RestrictionTypeDAO().getList());
        this.gCBType.setModel(restModel);
    }

    /**
     * Retorna a Restriction que está sendo manipulada
     *
     * @return <code>Restriction</code> Restrição
     */
    public Restriction getRestriction() {
        return restriction;
    }

    /**
     * Modifica a Restriction que está sendo manipulada
     *
     * @param restriction <code>Restriction</code> Restrição
     */
    public void setRestriction(Restriction restriction) {
        try {
            if (restriction != null) {
                this.restriction = restriction;

            }
        } catch (Exception e) {
        }
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLType = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        jLValue = new javax.swing.JLabel();
        nTValue = new br.com.gmp.comps.textfield.NumericTextField();
        jBSave = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(275, 120));
        setMinimumSize(new java.awt.Dimension(275, 120));

        jLType.setText("Tipo:");

        jLValue.setText("Valor:");

        nTValue.setText("numericTextField1");

        jBSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBSave.setText("Salvar");
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
            }
        });

        jBCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBCancel.setText("Cancelar");
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gCBType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nTValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBSave, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLType)
                    .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nTValue, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSave)
                    .addComponent(jBCancel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBSaveActionPerformed

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBSave;
    private javax.swing.JLabel jLType;
    private javax.swing.JLabel jLValue;
    private br.com.gmp.comps.textfield.NumericTextField nTValue;
    // End of variables declaration//GEN-END:variables
}
