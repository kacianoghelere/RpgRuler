package br.com.rpgruler.main.view;

import br.com.gmp.comps.baloontip.src.BalloonUtil;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.interact.WindowUtil;
import br.com.rpgruler.data.db.dao.ArmorTypeDAO;
import br.com.rpgruler.data.entitity.ArmorType;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.bean.ArmorTypeBean;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.interfaces.HasTable;
import br.com.rpgruler.main.view.model.ArmorTypeModel;
import br.com.rpgruler.main.view.object.ArmorTypeParameter;
import br.com.rpgruler.main.view.object.ViewParameter;
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
public class ArmorTypeView extends DefaultView implements TableSource<ArmorType>, HasTable {

    private ArmorTypeBean bean;
    private ArmorTypeModel model;

    /**
     * Cria nova instancia de ArmorTypeView
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     */
    public ArmorTypeView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.initComponents();
        this.setSize(600, 480);
        this.setControls(new ViewParameter(true, false, false, false));
        this.bean = new ArmorTypeBean(this);
        this.model = new ArmorTypeModel();
        this.gTable.buildTable(this, 0, model);
    }

    @Override
    public List<ArmorType> getTableData() {
        return new ArmorTypeDAO().getList();
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
     * Adiciona um item na tabela
     */
    @Override
    public void add() {
        try {
            if (gTName.validateComponent()) {
                ArmorTypeParameter type = new ArmorTypeParameter();
                type.setTypeName(gTName.getText());
                type.setMaterialAmount1(Double.parseDouble(jSpQtd1.getValue().toString()));
                type.setMaterialAmount2(Double.parseDouble(jSpQtd2.getValue().toString()));
                bean.add(new BeanEvent(this, type));
            }
        } catch (NumberFormatException e) {
            Logger.getLogger(ArmorTypeView.class.getName())
                    .log(Level.SEVERE, null, e);
        }
    }

    /**
     * Remove um item da tabela
     */
    @Override
    public void remove() {
        String text = "Deseja remover os itens selecionados?";
        if (WindowUtil.confirmation(this, "Remover", text, "Sim", "Não")) {
            try {
                if (gTable.getSelectedRow() >= 0) {
                    List<ArmorType> types = new ArrayList<>();
                    for (int i : gTable.getSelectedRows()) {
                        System.out.println("Removendo a linha: " + i);
                        types.add(model.getObject(i));
                    }
                    bean.remove(new BeanEvent(this, types.toArray(new ArmorType[]{})));
                } else {
                    new BalloonUtil().showTimedBallon(gTable, "Nenhum item selecionado");
                }
            } catch (NumberFormatException e) {
                Logger.getLogger(ArmorTypeView.class.getName())
                        .log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public GTable getTable() {
        return gTable;
    }

    @Override
    public ArmorTypeModel getModel() {
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

        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLName = new javax.swing.JLabel();
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLQtd1 = new javax.swing.JLabel();
        jSpQtd1 = new javax.swing.JSpinner();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLQtd2 = new javax.swing.JLabel();
        jSpQtd2 = new javax.swing.JSpinner();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();

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

        jSpQtd1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jToolBar1.add(jSpQtd1);
        jToolBar1.add(jSeparator3);

        jLQtd2.setText("Qtd. Material 2:");
        jToolBar1.add(jLQtd2);

        jSpQtd2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
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

        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTable.setToolTipText("Matérias primas");
        jScrollPane1.setViewportView(gTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLQtd1;
    private javax.swing.JLabel jLQtd2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JSpinner jSpQtd1;
    private javax.swing.JSpinner jSpQtd2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
