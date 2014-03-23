package br.com.rpgruler.main.view;

import br.com.rpgruler.data.entitity.Element;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.elements.ElementModel;
import br.com.rpgruler.main.view.generic.DefaultView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author kaciano
 */
public class ElementView extends DefaultView {

    private MainScreen screen;
    private ElementModel elementModel = new ElementModel();
    private int ID_COLUMN = 0;
    private int TITLE_COLUMN = 1;
    private int SYMBOL_COLUMN = 2;

    /**
     * Cria nova instancia de ElementView
     *
     * @param screen MainScreen
     */
    public ElementView(MainScreen screen) {
        this.screen = screen;
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
        elementModel.setData(getDefaultElements());
        jTableElements.setModel(elementModel);
        moldeTable();
        setSize(498, 394);
    }

    /**
     * Modela os dados da tabela
     */
    private void moldeTable() {
        URL resources = getClass().getResource("/RpgIcons/fire.png");
        System.out.println(resources.toString());
        ImageIcon icon = new ImageIcon(resources);
        System.out.println(icon.getDescription());
        jTableElements.getColumnModel().getColumn(SYMBOL_COLUMN).setCellRenderer((JTable table, Object value, boolean isSelected1, boolean hasFocus, int row, int column) -> {
            URL resource = getClass().getResource((String) getModel().getValueAt(row, SYMBOL_COLUMN));
            ImageIcon ic = new ImageIcon(resource);
            return new JLabel(ic);
        });
    }

    private ElementModel getModel() {
        return (ElementModel) jTableElements.getModel();
    }

    private List<Element> getDefaultElements() {
        List<Element> data = new ArrayList<>();
        data.add(new Element(new Long(1), "Fogo", "/RpgIcons/fire.png"));
        return data;
    }

    // <editor-fold defaultstate="collapsed" desc="Get's & Set's">
    public MainScreen getScreen() {
        return screen;
    }

    public void setScreen(MainScreen screen) {
        this.screen = screen;
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
        jSP = new javax.swing.JScrollPane();
        jTableElements = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Elementos");
        setMinimumSize(new java.awt.Dimension(498, 394));
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

        jTableElements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "ID", "Titulo", "Simbolo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableElements.setRowHeight(36);
        jSP.setViewportView(jTableElements);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSP, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSP, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JScrollPane jSP;
    private javax.swing.JTable jTableElements;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
}
