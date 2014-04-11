package br.com.rpgruler.main.view;

import br.com.gmp.comps.table.GTable;
import br.com.rpgruler.data.db.dao.ElementDAO;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.view.model.ElementModel;
import br.com.rpgruler.main.view.bean.ElementBean;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.interfaces.HasTable;
import java.net.URL;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * View dos Elementos
 *
 * @author kaciano
 */
public class ElementView extends DefaultView implements HasTable {

    private ElementBean bean;
    private ElementModel elementModel;
    private final int ID_COLUMN = 0;
    private final int TITLE_COLUMN = 1;
    private final int SYMBOL_COLUMN = 2;

    /**
     * Cria nova instancia de ElementView
     *
     * @param screen <code>MainScreen</code> Tela principal
     */
    public ElementView(MainScreen screen) {
        super(screen);
        elementModel = new ElementModel();
        setSave(true);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
        bean = new ElementBean(this);
        ElementDAO dao = new ElementDAO();
        jCSymbol.setModel(new DefaultComboBoxModel(bean.getElementsIcons()));
        if (dao.getList().isEmpty()) {
            dao.insertAll(bean.getElements());
        }
        elementModel.setData(dao.getList());
        gTable.setModel(elementModel);
        buildTable();
        setSize(700, 394);
    }

    /**
     * Monta os dados da tabela
     */
    private void buildTable() {
        //----------------------------------------------------------------------
        // Adiciona o renderer
        gTable.getColumnModel().getColumn(SYMBOL_COLUMN).setCellRenderer((JTable table, Object value, boolean isSelected1, boolean hasFocus, int row, int column) -> {
            URL resource = getClass().getResource((String) value);
            ImageIcon ic = new ImageIcon(resource);
            JLabel jLabel = new JLabel(ic);
            if (isSelected1) {
                jLabel.setOpaque(true);
                jLabel.setBackground(table.getSelectionBackground());
            } else {
                jLabel.setOpaque(false);
                jLabel.setBackground(new JLabel().getBackground());
            }
            JComboBox combo = new JComboBox(bean.getElementsIcons());
            combo.setSelectedItem(value);
            return jLabel;
        });
    }

    /**
     * Adiciona novo elemento na tabela
     */
    public void add() {
        String title = jTTitle.getText();
        int symbol = jCSymbol.getSelectedIndex();
        System.out.println(symbol);
        bean.addElement(title, symbol);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GTable getTable() {
        return gTable;
    }

    @Override
    public ElementModel getModel() {
        return elementModel;
    }

    @Override
    public BeanListener getBean() {
        return bean;
    }

    // <editor-fold defaultstate="collapsed" desc="Get's & Set's">
    public JComboBox getjCSymbol() {
        return jCSymbol;
    }

    public void setjCSymbol(JComboBox jCSymbol) {
        this.jCSymbol = jCSymbol;
    }

    public JTextField getjTTitle() {
        return jTTitle;
    }

    public void setjTTitle(JTextField jTTitle) {
        this.jTTitle = jTTitle;
    }

    // </editor-fold>
    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar = new javax.swing.JToolBar();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jTTitle = new javax.swing.JTextField();
        jLTitle = new javax.swing.JLabel();
        jLSymbol = new javax.swing.JLabel();
        jCSymbol = new javax.swing.JComboBox();
        jCWeak = new javax.swing.JComboBox();
        jLWeak = new javax.swing.JLabel();
        jLBonus = new javax.swing.JLabel();
        jCBonus = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Elementos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1399_@.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(628, 394));
        setPreferredSize(new java.awt.Dimension(628, 394));
        setVisible(true);

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

        jLTitle.setText("Titulo");

        jLSymbol.setText("Simbolo");

        jCSymbol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCSymbol.setMinimumSize(new java.awt.Dimension(71, 30));
        jCSymbol.setPreferredSize(new java.awt.Dimension(71, 30));

        jCWeak.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLWeak.setText("Fraqueza:");

        jLBonus.setText("Bonus:");

        jCBonus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(gTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLSymbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLWeak)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCWeak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLBonus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSymbol)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLTitle)
                        .addComponent(jCSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCWeak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLWeak)
                        .addComponent(jLBonus)
                        .addComponent(jCBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCBonus, jCSymbol, jCWeak, jLBonus, jLSymbol, jLTitle, jLWeak, jTTitle});

    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        add();
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JComboBox jCBonus;
    private javax.swing.JComboBox jCSymbol;
    private javax.swing.JComboBox jCWeak;
    private javax.swing.JLabel jLBonus;
    private javax.swing.JLabel jLSymbol;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLWeak;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTTitle;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables

}
