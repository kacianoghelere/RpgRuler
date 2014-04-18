package br.com.rpgruler.main.view.perk;

import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.interact.WindowUtil;
import br.com.rpgruler.data.db.dao.PerkDAO;
import br.com.rpgruler.data.entitity.Perk;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.view.View;
import br.com.rpgruler.main.view.perk.bean.PerkBean;
import br.com.rpgruler.main.view.perk.dialog.PerkDialog;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.interfaces.TableView;
import br.com.rpgruler.main.view.menu.MenuView;
import br.com.rpgruler.main.view.perk.model.PerkModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * View de cadastro e manutenção de perks
 *
 * @author kaciano
 */
public class PerkView extends View implements TableSource<Perk>, TableView {

    private PerkBean bean;
    private PerkModel model;

    /**
     * Cria nova instancia de PerkView
     *
     * @param screen <code>MainScreen</code> Tela principal
     */
    public PerkView(MainScreen screen) {
        super(screen);
        initialize();
    }

    /**
     * Metodo de inicialização
     */
    private void initialize() {
        setSize(320, 300);
        initComponents();
        this.model = new PerkModel();
        this.bean = new PerkBean(this);
    }

    @Override
    public List<Perk> getTableData() {
        return new PerkDAO().getList();
    }

    @Override
    public void add() {
        
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
                Logger.getLogger(MenuView.class.getName())
                        .log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public GTable getTable() {
        return this.gTable;
    }

    @Override
    public PerkModel getModel() {
        return this.model;
    }

    @Override
    public BeanListener getBean() {
        return this.bean;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar = new javax.swing.JToolBar();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jSP = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Vantagens");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1215_.png"))); // NOI18N

        jToolBar.setFloatable(false);
        jToolBar.setRollover(true);

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setFocusable(false);
        jBAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });
        jToolBar.add(jBAdd);

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.setFocusable(false);
        jBRemove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });
        jToolBar.add(jBRemove);

        jSP.setBorder(javax.swing.BorderFactory.createTitledBorder("Vantagens"));

        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTable.setOpaque(false);
        jSP.setViewportView(gTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSP, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSP, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        PerkDialog jDialog = new PerkDialog(this, true);
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JScrollPane jSP;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
}
