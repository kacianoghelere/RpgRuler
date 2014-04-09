package br.com.rpgruler.main.view;

import br.com.gmp.comps.model.GListModel;
import br.com.rpgruler.data.entitity.WearType;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.view.bean.TermsBean;
import br.com.rpgruler.main.view.object.ViewParameter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;

/**
 *
 * @author kaciano
 */
public class TermsView extends DefaultView {

    private TermsBean bean;
    private GListModel<WearType> wtModel;

    /**
     * Cria nova instancia de TermsView
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     */
    public TermsView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
        this.setSize(460, 300);
        this.setControls(new ViewParameter(true, false, false, false));
        this.bean = new TermsBean(this);
        this.wtModel = new GListModel<>();
        this.jListWearTypes.setModel(wtModel);
        this.gTWearTypes.setPlaceholder("Tipo de uso");
    }

    /**
     * Retorna a lista de tipos de uso para armas
     *
     * @return <code>JList</code> Lista de tipos de uso para armas
     */
    public JList getWearList() {
        return jListWearTypes;
    }

    /**
     * Adiciona novo elemento na lista de tipos de uso para armas
     */
    public void add() {
        if (gTWearTypes.validateComponent()) {
            wtModel.add(new WearType(Long.MIN_VALUE, gTWearTypes.getText()));
            gTWearTypes.setText("");
        }
    }

    /**
     * Retorna o modelo 
     * @return 
     */
    public GListModel<WearType> getWtModel() {
        return this.wtModel;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPWearTypes = new javax.swing.JPanel();
        jSP1 = new javax.swing.JScrollPane();
        jListWearTypes = new javax.swing.JList();
        gTWearTypes = new br.com.gmp.comps.textfield.GMPTextField();
        jPShit = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Termos comuns");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1213_.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(460, 300));
        setMinimumSize(new java.awt.Dimension(460, 300));
        setPreferredSize(new java.awt.Dimension(460, 300));
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        jPWearTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Usos de armas"));

        jListWearTypes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListWearTypes.setMaximumSize(new java.awt.Dimension(150, 125));
        jListWearTypes.setMinimumSize(new java.awt.Dimension(150, 125));
        jListWearTypes.setPreferredSize(new java.awt.Dimension(150, 125));
        jSP1.setViewportView(jListWearTypes);

        gTWearTypes.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTWearTypes.setMinimumSize(new java.awt.Dimension(150, 28));
        gTWearTypes.setPreferredSize(new java.awt.Dimension(150, 28));
        gTWearTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTWearTypesKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPWearTypesLayout = new javax.swing.GroupLayout(jPWearTypes);
        jPWearTypes.setLayout(jPWearTypesLayout);
        jPWearTypesLayout.setHorizontalGroup(
            jPWearTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPWearTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPWearTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSP1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addComponent(gTWearTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPWearTypesLayout.setVerticalGroup(
            jPWearTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPWearTypesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jSP1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTWearTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPWearTypes);

        jPShit.setBorder(javax.swing.BorderFactory.createTitledBorder("Qualquer outra merda..."));
        getContentPane().add(jPShit);
    }// </editor-fold>//GEN-END:initComponents

    private void gTWearTypesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTWearTypesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                add();
            } catch (Exception ex) {
                Logger.getLogger(TermsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTWearTypesKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.textfield.GMPTextField gTWearTypes;
    private javax.swing.JList jListWearTypes;
    private javax.swing.JPanel jPShit;
    private javax.swing.JPanel jPWearTypes;
    private javax.swing.JScrollPane jSP1;
    // End of variables declaration//GEN-END:variables
}
