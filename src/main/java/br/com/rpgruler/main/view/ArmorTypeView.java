package br.com.rpgruler.main.view;

import br.com.gmp.comps.baloontip.src.BalloonUtil;
import br.com.gmp.comps.table.GMPTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.rpgruler.data.entitity.ArmorType;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.bean.ArmorTypeBean;
import br.com.rpgruler.main.view.model.ArmorTypeModel;
import br.com.rpgruler.main.view.object.ArmorTypeParameter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cadastro de tipos de armaduras
 *
 * @author kaciano
 * @version 1.0
 */
public class ArmorTypeView extends DefaultView implements TableSource<ArmorType> {

    private ArmorTypeBean bean;
    private ArmorTypeModel model;

    /**
     * Cria nova instancia de ArmorTypeView
     *
     * @param mainScreen <code>MainScreen</code>
     */
    public ArmorTypeView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
        setSize(600, 480);
        this.bean = new ArmorTypeBean(this);
        this.model = new ArmorTypeModel();
        this.gTable.setModel(model);
        this.gTable.setSource(this);
        this.gTable.setMaxRows(20);
    }

    @Override
    public List<ArmorType> getTableData() {
        return new ArrayList<>();
    }

    /**
     * Retorna a tabela
     *
     * @return <code>GMPTable</code>
     */
    public GMPTable getTable() {
        return gTable;
    }

    /**
     * Modifica a tabela
     *
     * @param gTable <code>GMPTable</code>
     */
    public void setTable(GMPTable gTable) {
        this.gTable = gTable;
    }

    /**
     * Retorna o modelo de tabela
     *
     * @return <code>ArmorTypeModel</code>
     */
    public ArmorTypeModel getModel() {
        return model;
    }

    /**
     * Modifica o modelo de tabela
     *
     * @param model <code>ArmorTypeModel</code>
     */
    public void setModel(ArmorTypeModel model) {
        this.model = model;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLName = new javax.swing.JLabel();
        gTName = new br.com.gmp.comps.textfield.GMPTextField();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLQtd1 = new javax.swing.JLabel();
        jSpQtd1 = new javax.swing.JSpinner();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLQtd2 = new javax.swing.JLabel();
        jSpQtd2 = new javax.swing.JSpinner();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GMPTable(this, ArmorType.class);

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Tipos de armaduras");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/armor/DVK/DVK_3.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(600, 480));
        setPreferredSize(new java.awt.Dimension(600, 480));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        jLName.setText("Nome:");
        jToolBar1.add(jLName);
        jToolBar1.add(gTName);
        jToolBar1.add(jSeparator2);

        jLQtd1.setText("Qtd. Material 1:");
        jToolBar1.add(jLQtd1);
        jToolBar1.add(jSpQtd1);
        jToolBar1.add(jSeparator3);

        jLQtd2.setText("Qtd. Material 2:");
        jToolBar1.add(jLQtd2);
        jToolBar1.add(jSpQtd2);
        jToolBar1.add(jSeparator4);

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setFocusable(false);
        jBAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });
        jToolBar1.add(jBAdd);

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.setFocusable(false);
        jBRemove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });
        jToolBar1.add(jBRemove);

        jScrollPane2.setViewportView(gTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        try {
            if (!gTName.getText().isEmpty()) {
                ArmorTypeParameter type = new ArmorTypeParameter();
                type.setTypeName(gTName.getText());
                type.setMaterialAmount1(Double.parseDouble(jSpQtd1.getValue().toString()));
                type.setMaterialAmount2(Double.parseDouble(jSpQtd2.getValue().toString()));
                bean.add(new BeanEvent(this, type));
                model.reload();
            } else {
                new BalloonUtil().showTimedBallon(gTName, "O nome não foi digitado");
            }
        } catch (NumberFormatException e) {
            Logger.getLogger(ArmorTypeView.class.getName())
                    .log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        try {
            if (gTable.getSelectedRow() >= 0) {
                ArmorType type = model.getObject(gTable.getSelectedRow());
                bean.remove(new BeanEvent(this, type));
                model.reload();
            }
        } catch (NumberFormatException e) {
            Logger.getLogger(ArmorTypeView.class.getName())
                    .log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jBRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.textfield.GMPTextField gTName;
    private br.com.gmp.comps.table.GMPTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLQtd1;
    private javax.swing.JLabel jLQtd2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JSpinner jSpQtd1;
    private javax.swing.JSpinner jSpQtd2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
