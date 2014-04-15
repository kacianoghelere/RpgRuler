package br.com.rpgruler.main.view.perk;

import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.view.View;
import br.com.rpgruler.main.view.perk.bean.PerkBean;
import br.com.rpgruler.main.view.dialog.PerkDialog;
import br.com.rpgruler.main.view.interfaces.BeanListener;

/**
 * View de cadastro e manutenção de perks
 *
 * @author kaciano
 */
public class PerkView extends View {

    private PerkBean bean;

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
        this.bean = new PerkBean(this);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        gMPTable1 = new br.com.gmp.comps.table.GMPTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setTitle("Vantagens");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1215_.png"))); // NOI18N

        jScrollPane1.setViewportView(gMPTable1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PerkDialog jDialog = new PerkDialog(this.getMainScreen(), true);
        jDialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.table.GMPTable gMPTable1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
