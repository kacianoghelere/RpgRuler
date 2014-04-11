package br.com.rpgruler.main.view;

import br.com.gmp.comps.baloontip.src.BalloonUtil;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.interact.WindowUtil;
import br.com.rpgruler.data.db.dao.MaterialsDAO;
import br.com.rpgruler.data.entitity.PrimeMaterial;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.bean.MaterialsBean;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.interfaces.HasTable;
import br.com.rpgruler.main.view.model.MaterialsModel;
import br.com.rpgruler.main.view.object.MaterialsParameter;
import br.com.rpgruler.main.view.object.ViewParameter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * View de cadastro para matérias primas
 *
 * @author kaciano
 * @version 1.0
 */
public class MaterialsView extends DefaultView implements TableSource<PrimeMaterial>, HasTable {

    private MaterialsBean bean;
    private MaterialsModel model;

    /**
     * Cria nova instancia de MaterialsView
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     */
    public MaterialsView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.initComponents();
        this.setSize(650, 400);
        this.setControls(new ViewParameter(true, false, false, false));
        this.bean = new MaterialsBean(this);
        this.model = new MaterialsModel();
        this.gTable.buildTable(this, 0, model);
    }

    @Override
    public List<PrimeMaterial> getTableData() {
        return new MaterialsDAO().getList();
    }

    /**
     * Modifica o modelo da tabela de materiais
     *
     * @param model <code>MaterialsModel</code> Modelo da tabela de materiais
     */
    public void setModel(MaterialsModel model) {
        this.model = model;
    }

    @Override
    public void add() {
        try {
            if (gTName.validateComponent()) {
                if (nTWeight.validateComponent()) {
                    MaterialsParameter param;
                    param = new MaterialsParameter(gTName.getText(),
                            (Integer) jSpClass.getValue(), nTWeight.getDouble());
                    bean.add(new BeanEvent(this, param));
                }
            }
        } catch (Exception e) {
            Logger.getLogger(MaterialsView.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void remove() {
        String text = "Deseja remover os itens selecionados?";
        if (WindowUtil.confirmation(this, "Remover", text, "Sim", "Não")) {
            try {
                if (gTable.getSelectedRowCount() > 0) {
                    model.remove(gTable.getSelectedRows());
                }               
            } catch (NumberFormatException e) {
                Logger.getLogger(MaterialsView.class.getName())
                        .log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public GTable getTable() {
        return gTable;
    }

    @Override
    public MaterialsModel getModel() {
        return model;
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

        jTBControls = new javax.swing.JToolBar();
        jLName = new javax.swing.JLabel();
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jLClass = new javax.swing.JLabel();
        jSpClass = new javax.swing.JSpinner();
        jLWeight = new javax.swing.JLabel();
        nTWeight = new br.com.gmp.comps.textfield.NumericTextField();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Materiais");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1285_.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(650, 400));
        setMinimumSize(new java.awt.Dimension(650, 400));
        setPreferredSize(new java.awt.Dimension(650, 400));

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

        jScrollPane1.setViewportView(gTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTBControls, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTBControls, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        add();
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        remove();
    }//GEN-LAST:event_jBRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.textfield.GTextField gTName;
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLClass;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLWeight;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpClass;
    private javax.swing.JToolBar jTBControls;
    private br.com.gmp.comps.textfield.NumericTextField nTWeight;
    // End of variables declaration//GEN-END:variables

}
