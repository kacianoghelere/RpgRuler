package br.com.rpgruler.main.view.perk.dialog;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.dialog.GDialog;
import br.com.rpgruler.data.db.dao.PerkTypeDAO;
import br.com.rpgruler.data.entitity.Perk;
import br.com.rpgruler.data.entitity.PerkType;
import br.com.rpgruler.main.view.perk.PerkView;
import br.com.rpgruler.main.view.perk.bean.PerkBean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Janela de dialogo para cadastro de perks
 *
 * @author kaciano
 * @version 1.0
 */
public class PerkDialog extends GDialog {

    private Perk perk;
    private PerkView perks;
    private GComboBoxModel<PerkType> typeModel;

    /**
     * Cria nova instancia de PerkDialog
     *
     * @param perks <code>PerkView</code> Tela de Perks
     * @param perk <code>Perk</code> Perk a ser editado
     * @param modal <code>boolean</code> Modal?
     */
    public PerkDialog(PerkView perks, Perk perk, boolean modal) {
        super(perks.getMainScreen(), modal);
        this.perks = perks;
        initialize(perk);
    }

    /**
     * Método de inicialização
     */
    private void initialize(Perk perk) {
        this.setSize(400, 236);
        this.initComponents();
        this.typeModel = new GComboBoxModel<>(new PerkTypeDAO().getList());
        this.gCBType.setModel(typeModel);
        this.setPerk(perk);
        this.setVisible(true);
    }

    /**
     * Constroi os dados do Perk na tela caso ele exista
     *
     * @param perk <code>Perk</code> Perk a ser editado
     */
    public void setPerk(Perk perk) {
        try {
            if (perk != null) {
                this.perk = perk;
                this.gTID.setLong(this.perk.getId());
                this.gTTitle.setText(this.perk.getTitle());
                this.gTADesc.setText(this.perk.getDescription());
                this.jChInherited.setSelected(this.perk.isInherited());
                if (typeModel.contains(this.perk.getType())) {
                    this.gCBType.setSelectedItem(this.perk.getType());
                }
            } else {
                PerkBean bean = (PerkBean) this.perks.getBean();
                this.perk = new Perk();
                this.perk.setId(bean.getNextID());
                this.gTID.setLong(this.perk.getId());
            }
        } catch (Exception e) {
            Logger.getLogger(PerkDialog.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Retorna o Perk que está em edição
     *
     * @return <code>Perk</code> Perk em edição
     */
    public Perk getPerk() {
        try {            
            if (gTTitle.validateComponent()) {
                if (gCBType.validateComponent()) {
                    if (gTADesc.validateComponent()) {                        
                        perk.setId(gTID.getLong());
                        perk.setTitle(gTTitle.getText());
                        perk.setInherited(jChInherited.isSelected());
                        perk.setDescription(gTADesc.getText());
                        perk.setType(typeModel.getSelectedItem());
                        return perk;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            Logger.getLogger(PerkDialog.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gTTitle = new br.com.gmp.comps.textfield.GTextField();
        jLTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GMPTextArea();
        jBAdd = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();
        jChInherited = new javax.swing.JCheckBox();
        jLType = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        gTID = new br.com.gmp.comps.textfield.GTextField();
        jLID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLTitle.setText("Titulo:");

        gTADesc.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));
        gTADesc.setColumns(20);
        gTADesc.setMaximumlength(255);
        gTADesc.setRows(5);
        jScrollPane2.setViewportView(gTADesc);

        jBAdd.setText("Salvar");
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jBCancel.setText("Cancelar");
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });

        jChInherited.setText("Herdavel");

        jLType.setText("Tipo:");

        gTID.setEnabled(false);

        jLID.setText("Código:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLID)
                            .addComponent(jLTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gTID, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(gTTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jChInherited))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gTID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLType)
                    .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChInherited))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAdd)
                    .addComponent(jBCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        if (getPerk() != null) {
            dispose();
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jBCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.textarea.GMPTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTID;
    private br.com.gmp.comps.textfield.GTextField gTTitle;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBCancel;
    private javax.swing.JCheckBox jChInherited;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLType;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
