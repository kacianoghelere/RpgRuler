package br.com.rpgruler.main.view.menu;

import br.com.gmp.comps.model.GTableModel;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.rpgruler.data.db.dao.MenuDAO;
import br.com.rpgruler.data.entitity.Menu;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.view.DefaultView;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.interfaces.HasTable;
import br.com.rpgruler.main.view.menu.bean.MenuBean;
import br.com.rpgruler.main.view.menu.model.MenuModel;
import br.com.rpgruler.main.view.object.ViewParameter;
import java.util.List;
import javax.swing.JMenu;

/**
 * View para controle de menus
 *
 * @author kaciano
 * @version 1.0
 */
public class MenuView extends DefaultView implements TableSource<Menu>, HasTable {

    private MenuBean bean;
    private MenuModel model;

    /**
     * Cria nova instancia de MenuView
     *
     * @param mainScreen <code>MainScreen</code>
     */
    public MenuView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
        this.setControls(new ViewParameter(true, true, true, false));
        this.setSize(540, 415);
        this.bean = new MenuBean(this);
        this.model = new MenuModel();
        this.gTable.buildTable(this, 0, model);
    }

    @Override
    public List<Menu> getTableData() {
        return new MenuDAO().getList();
    }

    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }

    @Override
    public GTable getTable() {
        return this.gTable;
    }

    @Override
    public GTableModel getModel() {
        return this.model;
    }

    @Override
    public BeanListener getBean() {
        return this.bean;
    }

    /**
     * Retorna o menu de pré-visualização
     *
     * @return <code>JMenu</code> Menu de pré-visualização
     */
    public JMenu getRoot() {
        return this.jMVisual;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMVisual = new javax.swing.JMenu();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de menus");
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(540, 415));
        setPreferredSize(new java.awt.Dimension(540, 415));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Menus"));

        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(gTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMVisual.setText("Visualização*");
        jMenuBar1.add(jMVisual);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JMenu jMVisual;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
