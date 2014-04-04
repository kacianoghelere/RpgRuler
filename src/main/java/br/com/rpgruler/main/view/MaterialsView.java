package br.com.rpgruler.main.view;

import br.com.gmp.comps.table.GMPTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.rpgruler.data.entitity.PrimeMaterial;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.bean.MaterialsBean;
import br.com.rpgruler.main.view.model.MaterialsModel;
import br.com.rpgruler.main.view.object.MaterialsParameter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class MaterialsView extends DefaultView implements TableSource<PrimeMaterial> {

    private MaterialsBean bean;
    private MaterialsModel model;

    /**
     * Cria nova instancia de MaterialsView
     *
     * @param mainScreen
     */
    public MaterialsView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
        this.bean = new MaterialsBean(this);
        this.model = new MaterialsModel();
        this.gTabMaterials.setModel(model);
        this.gTabMaterials.setSource(this);
    }

    @Override
    public List<PrimeMaterial> getTableData() {
        return new ArrayList<>();
    }

    public GMPTable getTable() {
        return gTabMaterials;
    }

    @Override
    public MaterialsBean getBean() {
        return bean;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSPMaterials = new javax.swing.JScrollPane();
        gTabMaterials = new br.com.gmp.comps.table.GMPTable(this, PrimeMaterial.class);
        jLName = new javax.swing.JLabel();
        gTName = new br.com.gmp.comps.textfield.GMPTextField();
        jLWeight = new javax.swing.JLabel();
        gCBClass = new br.com.gmp.comps.combobox.GMPComboBox();
        jLClass = new javax.swing.JLabel();
        jBRemove = new javax.swing.JButton();
        jBAdd = new javax.swing.JButton();
        nTWeight = new br.com.gmp.comps.textfield.NumericTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Materiais");
        setMaximumSize(new java.awt.Dimension(534, 387));
        setMinimumSize(new java.awt.Dimension(534, 387));

        gTabMaterials.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jSPMaterials.setViewportView(gTabMaterials);

        jLName.setText("Nome:");

        jLWeight.setText("Peso:");

        gCBClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        jLClass.setText("Classe:");

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLName)
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLWeight)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nTWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLClass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gCBClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSPMaterials, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLName)
                    .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gCBClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBAdd)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nTWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLWeight)))
                    .addComponent(jBRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSPMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gTName, nTWeight});

    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        new MaterialsParameter(gTName.getText(), HIDE_ON_CLOSE, Double.NaN);
        bean.add(new BeanEvent(this, new Object[]{}));
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        bean.remove(new BeanEvent(this, null));
    }//GEN-LAST:event_jBRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GMPComboBox gCBClass;
    private br.com.gmp.comps.textfield.GMPTextField gTName;
    private br.com.gmp.comps.table.GMPTable gTabMaterials;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLClass;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLWeight;
    private javax.swing.JScrollPane jSPMaterials;
    private br.com.gmp.comps.textfield.NumericTextField nTWeight;
    // End of variables declaration//GEN-END:variables

}
