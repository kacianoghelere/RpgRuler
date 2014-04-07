package br.com.rpgruler.main.view;

import br.com.gmp.comps.baloontip.src.BalloonUtil;
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
import java.util.logging.Level;
import java.util.logging.Logger;

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
        setSize(650, 400);
        this.bean = new MaterialsBean(this);
        this.model = new MaterialsModel();
        this.gTabMaterials.setModel(model);
        this.gTabMaterials.setSource(this);
    }

    @Override
    public List<PrimeMaterial> getTableData() {
        return new ArrayList<>();
    }

    /**
     * Retorna a tabela de materiais
     *
     * @return GMPTable Tabela de materiais
     */
    public GMPTable getTable() {
        return gTabMaterials;
    }

    @Override
    public MaterialsBean getBean() {
        return bean;
    }

    /**
     * Retorna o modelo da tabela de materiais
     *
     * @return MaterialsModel Modelo da tabela de materiais
     */
    public MaterialsModel getModel() {
        return model;
    }

    /**
     * Modifica o modelo da tabela de materiais
     *
     * @param model MaterialsModel Modelo da tabela de materiais
     */
    public void setModel(MaterialsModel model) {
        this.model = model;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSPMaterials = new javax.swing.JScrollPane();
        gTabMaterials = new br.com.gmp.comps.table.GMPTable(this, PrimeMaterial.class);
        jTBControls = new javax.swing.JToolBar();
        jLName = new javax.swing.JLabel();
        gTName = new br.com.gmp.comps.textfield.GMPTextField();
        jLClass = new javax.swing.JLabel();
        jSpClass = new javax.swing.JSpinner();
        jLWeight = new javax.swing.JLabel();
        nTWeight = new br.com.gmp.comps.textfield.NumericTextField();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Materiais");
        setMaximumSize(new java.awt.Dimension(650, 400));
        setMinimumSize(new java.awt.Dimension(650, 400));
        setPreferredSize(new java.awt.Dimension(650, 400));

        gTabMaterials.setMaxRows(15);
        gTabMaterials.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jSPMaterials.setViewportView(gTabMaterials);

        jTBControls.setFloatable(false);
        jTBControls.setRollover(true);

        jLName.setText("Nome:");
        jTBControls.add(jLName);
        jTBControls.add(gTName);

        jLClass.setText("Classe:");
        jTBControls.add(jLClass);

        jSpClass.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));
        jTBControls.add(jSpClass);

        jLWeight.setText("Peso:");
        jTBControls.add(jLWeight);

        nTWeight.setMaximumSize(new java.awt.Dimension(200, 2147483647));
        jTBControls.add(nTWeight);

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });
        jTBControls.add(jBAdd);

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });
        jTBControls.add(jBRemove);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPMaterials, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jTBControls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTBControls, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSPMaterials, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        if (!gTName.getText().isEmpty()) {
            if (!nTWeight.getText().isEmpty()) {
                MaterialsParameter param;
                param = new MaterialsParameter(gTName.getText(),
                        (Integer) jSpClass.getValue(), nTWeight.getDouble());
                bean.add(new BeanEvent(this, param));
            } else {
                new BalloonUtil().showTimedBallon(nTWeight, "O peso não foi digitado");
            }
        } else {
            new BalloonUtil().showTimedBallon(gTName, "O nome não foi digitado");
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        if (gTabMaterials.getSelectedRow() >= 0) {
            try {
                PrimeMaterial mat = model.getObject(gTabMaterials.getSelectedRow());
                bean.remove(new BeanEvent(this, mat));
            } catch (Exception e) {
                Logger.getLogger(MaterialsView.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            new BalloonUtil().showTimedBallon(jBRemove, "Nenhum item selecionado");
        }
    }//GEN-LAST:event_jBRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.textfield.GMPTextField gTName;
    private br.com.gmp.comps.table.GMPTable gTabMaterials;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLClass;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLWeight;
    private javax.swing.JScrollPane jSPMaterials;
    private javax.swing.JSpinner jSpClass;
    private javax.swing.JToolBar jTBControls;
    private br.com.gmp.comps.textfield.NumericTextField nTWeight;
    // End of variables declaration//GEN-END:variables

}
