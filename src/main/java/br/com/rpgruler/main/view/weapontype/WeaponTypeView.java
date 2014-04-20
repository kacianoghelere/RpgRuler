package br.com.rpgruler.main.view.weapontype;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.rpgruler.data.db.dao.WeaponTypeDAO;
import br.com.rpgruler.data.entitity.WeaponType;
import br.com.rpgruler.data.entitity.UseType;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.util.TableUtil;
import br.com.rpgruler.main.view.View;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.interfaces.TableView;
import br.com.rpgruler.main.view.object.ViewParameter;
import br.com.rpgruler.main.view.object.ViewWrapper;
import br.com.rpgruler.main.view.weapontype.bean.WeaponTypeBean;
import br.com.rpgruler.main.view.weapontype.model.WeaponTypeModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * View de cadastro para tipos de armas
 *
 * @author kaciano
 */
public class WeaponTypeView extends View implements TableView, TableSource<WeaponType> {

    private WeaponTypeBean bean;
    private WeaponTypeModel model;
    private GComboBoxModel<UseType> useModel;
    private TableUtil tableUtil;

    /**
     * Cria nova instancia de WeaponTypeView
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     */
    public WeaponTypeView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.initComponents();
        this.setSize(630, 400);
        this.setControls(new ViewParameter(true, false, false, false));
        this.initComponents();
        this.model = new WeaponTypeModel();
        this.useModel = new GComboBoxModel<>();
        this.gTable.buildTable(this, 0, model);
        this.tableUtil = new TableUtil(this);
        this.bean = new WeaponTypeBean(this);
        this.gCBWear.setGModel(useModel);
    }

    @Override
    public void add() {
        try {
            if (gTTitle.validateComponent()) {
                if (nTBaseDmg.validateComponent()) {
                    if (gCBWear.validateComponent()) {
                        ViewWrapper vw = new ViewWrapper(this);
                        vw.addValue(gTTitle.getText());
                        vw.addValue((Integer) jSpinCategory.getValue());
                        vw.addValue(nTBaseDmg.getDouble());
                        vw.addValue(useModel.getSelectedItem());
                        vw.addValue((Double) jSpQtd1.getValue());
                        vw.addValue((Double) jSpQtd2.getValue());
                        bean.add(new BeanEvent(vw));
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(WeaponTypeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remove() {
        tableUtil.remove(null);
    }

    @Override
    public void edit() {

    }

    @Override
    public GTable getTable() {
        return this.gTable;
    }

    @Override
    public WeaponTypeModel getModel() {
        return this.model;
    }

    @Override
    public List<WeaponType> getTableData() {
        return new WeaponTypeDAO().getList();
    }

    @Override
    public BeanListener getBean() {
        return this.bean;
    }

    /**
     * Retorna o modelo dos UseTypes
     *
     * @return <code>UseType</code> Modelo dos UseTypes
     */
    public GComboBoxModel<UseType> getUseModel() {
        return useModel;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();
        jLTitle = new javax.swing.JLabel();
        gTTitle = new br.com.gmp.comps.textfield.GTextField();
        jSpQtd2 = new javax.swing.JSpinner();
        jLQtd2 = new javax.swing.JLabel();
        jSpQtd1 = new javax.swing.JSpinner();
        jLQtd1 = new javax.swing.JLabel();
        nTBaseDmg = new br.com.gmp.comps.textfield.NumericTextField();
        jLBaseDmg = new javax.swing.JLabel();
        jLWear = new javax.swing.JLabel();
        gCBWear = new br.com.gmp.comps.combobox.GComboBox();
        jLCategory = new javax.swing.JLabel();
        jSpinCategory = new javax.swing.JSpinner();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Tipos de armas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/weapons/DK/DK_4.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(630, 400));
        setPreferredSize(new java.awt.Dimension(630, 400));

        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(gTable);

        jLTitle.setText("Titulo:");

        jSpQtd2.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 0.5d));

        jLQtd2.setText("Qtd. Material 2:");

        jSpQtd1.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 0.5d));

        jLQtd1.setText("Qtd. Material 1:");

        jLBaseDmg.setText("Dano base:");

        jLWear.setText("Porte:");

        jLCategory.setText("Categoria:");

        jSpinCategory.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setText("Adicionar");
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.setText("Remover");
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gTTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLBaseDmg)
                        .addGap(7, 7, 7)
                        .addComponent(nTBaseDmg, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLWear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCBWear, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLCategory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLQtd1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBRemove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLQtd2)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpQtd2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(jSpQtd1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jSpQtd1, jSpQtd2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTitle)
                    .addComponent(gTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nTBaseDmg, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLBaseDmg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLQtd1)
                    .addComponent(jSpQtd1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLWear)
                    .addComponent(jLCategory)
                    .addComponent(jSpinCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gCBWear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAdd)
                    .addComponent(jBRemove)
                    .addComponent(jLQtd2)
                    .addComponent(jSpQtd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jSpQtd1, jSpQtd2});

    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        try {
            add();
        } catch (Exception e) {
            Logger.getLogger(WeaponTypeView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        try {
            remove();
        } catch (Exception e) {
            Logger.getLogger(WeaponTypeView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jBRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBWear;
    private br.com.gmp.comps.textfield.GTextField gTTitle;
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLBaseDmg;
    private javax.swing.JLabel jLCategory;
    private javax.swing.JLabel jLQtd1;
    private javax.swing.JLabel jLQtd2;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLWear;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpQtd1;
    private javax.swing.JSpinner jSpQtd2;
    private javax.swing.JSpinner jSpinCategory;
    private br.com.gmp.comps.textfield.NumericTextField nTBaseDmg;
    // End of variables declaration//GEN-END:variables
}
