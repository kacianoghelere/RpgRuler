package br.com.rpgruler.main.view;

import br.com.gmp.utils.image.ImageUtil;
import br.com.rpgruler.data.entitity.Element;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.model.ElementModel;
import br.com.rpgruler.main.view.generic.DefaultView;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
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
        jCSymbol.setModel(new DefaultComboBoxModel(getElementsIcons()));
        elementModel.setData(getDefaultElements());
        jTableElements.setModel(elementModel);
        moldeTable();
        setSize(498, 394);
    }

    /**
     * Modela os dados da tabela
     */
    private void moldeTable() {
        //----------------------------------------------------------------------
        // Adiciona o renderer
        jTableElements.getColumnModel().getColumn(SYMBOL_COLUMN).setCellRenderer((JTable table, Object value, boolean isSelected1, boolean hasFocus, int row, int column) -> {
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
            JComboBox combo = new JComboBox(getElementsIcons());
            combo.setSelectedItem(value);
            return jLabel;
        });
    }

    private ElementModel getModel() {
        return (ElementModel) jTableElements.getModel();
    }

    private List<Element> getDefaultElements() {
        List<Element> data = new ArrayList<>();
        data.add(new Element(new Long(1), "Fogo", "/RpgIcons/fire.png"));
        data.add(new Element(new Long(2), "Água", "/RpgIcons/water.png"));
        data.add(new Element(new Long(3), "Vento", "/RpgIcons/wind.png"));
        data.add(new Element(new Long(4), "Terra", "/RpgIcons/earth.png"));
        data.add(new Element(new Long(5), "Luz", "/RpgIcons/light.png"));
        data.add(new Element(new Long(6), "Sombra", "/RpgIcons/dark.png"));
        data.add(new Element(new Long(7), "Alquimia", "/RpgIcons/alchemy.png"));
        return data;
    }

    private String[] getElements() {
        return new String[]{"/RpgIcons/fire.png",
            "/RpgIcons/water.png",
            "/RpgIcons/wind.png",
            "/RpgIcons/earth.png",
            "/RpgIcons/light.png",
            "/RpgIcons/dark.png",
            "/RpgIcons/alchemy.png"};
    }

    private ImageIcon[] getElementsIcons() {
        ImageIcon[] icons = new ImageIcon[getElements().length];
        for (int i = 0; i < getElements().length; i++) {
            icons[i] = new ImageIcon(getClass().getResource(getElements()[i]));
            icons[i].setImage(new ImageUtil().getScaledImage(icons[i].getImage(), 20, 20));
        }
        return icons;
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
        jTTitle = new javax.swing.JTextField();
        jLTitle = new javax.swing.JLabel();
        jLSymbol = new javax.swing.JLabel();
        jCSymbol = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Elementos");
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

        jTableElements.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
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

        jLTitle.setText("Titulo");

        jLSymbol.setText("Simbolo");

        jCSymbol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCSymbol.setMinimumSize(new java.awt.Dimension(71, 30));
        jCSymbol.setPreferredSize(new java.awt.Dimension(71, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLSymbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSP, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLTitle)
                        .addComponent(jCSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLSymbol)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSP, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCSymbol, jLSymbol, jLTitle, jTTitle});

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
    private javax.swing.JComboBox jCSymbol;
    private javax.swing.JLabel jLSymbol;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JScrollPane jSP;
    private javax.swing.JTextField jTTitle;
    private javax.swing.JTable jTableElements;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
}
