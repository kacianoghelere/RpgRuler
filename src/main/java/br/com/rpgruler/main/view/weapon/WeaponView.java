package br.com.rpgruler.main.view.weapon;

import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.rpgruler.data.db.dao.WeaponDAO;
import br.com.rpgruler.data.entity.Weapon;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.util.Description;
import br.com.rpgruler.main.util.TableUtil;
import br.com.rpgruler.main.view.View;
import br.com.rpgruler.main.view.interfaces.TableView;
import br.com.rpgruler.main.view.weapon.bean.WeaponBean;
import br.com.rpgruler.main.view.weapon.model.WeaponModel;
import java.util.List;

/**
 * View para cadastro e controle de armas
 *
 * @author kaciano
 */
public class WeaponView extends View implements TableView, TableSource<Weapon> {

    private WeaponBean bean;
    private WeaponModel model;
    private TableUtil tableUtil;

    /**
     * Cria nova instancia de WeaponView
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     */
    public WeaponView(MainScreen mainScreen) {
        super(mainScreen);
        this.initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
        this.model = new WeaponModel();
        this.tableUtil = new TableUtil(this);
        this.bean = new WeaponBean(this);
    }

    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void edit() {

    }

    @Override
    public GTable getTable() {
        return gTable;
    }

    @Override
    public WeaponModel getModel() {
        return model;
    }

    @Override
    public List<Weapon> getTableData() {
        return new WeaponDAO().getList();
    }

    @Override
    public WeaponBean getBean() {
        return bean;
    }

    @Override
    public Description getDescription() {
        return new Description()
                .setTitle(getTitle())
                .setDescription("Tela de controle e cadastro de armas")
                .setSave("Remove os itens antigos e salva os novos.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jBEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Armas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/weapons/K/K_64.png"))); // NOI18N

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

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

        jBEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/menubar/menubar/edit.png"))); // NOI18N
        jBEdit.setFocusable(false);
        jBEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditActionPerformed(evt);
            }
        });
        jToolBar1.add(jBEdit);

        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTable.setOpaque(false);
        jScrollPane1.setViewportView(gTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditActionPerformed
        edit();
    }//GEN-LAST:event_jBEditActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        remove();
    }//GEN-LAST:event_jBRemoveActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        add();
    }//GEN-LAST:event_jBAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBEdit;
    private javax.swing.JButton jBRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}