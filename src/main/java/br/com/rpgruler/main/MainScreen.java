package br.com.rpgruler.main;

import br.com.rpgruler.main.bean.MainScreenBean;
import br.com.rpgruler.main.interfaces.IMainScreen;
import br.com.rpgruler.main.interfaces.MainListener;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.DiceView;
import br.com.rpgruler.main.view.ElementView;
import br.com.rpgruler.main.view.PerkView;
import javax.swing.JDesktopPane;

/**
 *
 * @author kaciano
 */
public class MainScreen extends javax.swing.JFrame implements IMainScreen {

    private MainListener listener;

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initialize();
    }

    /**
     * Metodo de inicialização
     */
    private void initialize() {
        initComponents();
        setControls(false, false, false, false, false);
        listener = new MainScreenBean(this);
    }

    @Override
    public void save() {
        listener.save(new BeanEvent(this, null));
    }

    @Override
    public void delete() {
        listener.delete(new BeanEvent(this, null));
    }

    @Override
    public void process() {
        listener.process(new BeanEvent(this, null));
    }

    @Override
    public void clear() {
        listener.clear(new BeanEvent(this, null));
    }

    @Override
    public void load() {
        listener.load(new BeanEvent(this, null));
    }

    //<editor-fold desc="Get's & Set's" defaultstate="collapsed">
    /**
     * Retorna o listener
     *
     * @return MainListener
     */
    public MainListener getListener() {
        return listener;
    }

    /**
     * Modifica o listener
     *
     * @param listener MainListener
     */
    public void setListener(MainListener listener) {
        this.listener = listener;
    }

    /**
     * Retorno o desktop
     *
     * @return JDesktopPane
     */
    public JDesktopPane getDesktop() {
        return desktop;
    }

    /**
     * Modifica o desktop
     *
     * @param desktop JDesktopPane
     */
    public void setDesktop(JDesktopPane desktop) {
        this.desktop = desktop;
    }

    /**
     * Modifica os controles de acordo com a View ativa
     *
     * @param controls <code>boolean[]</code> Array com as opções de controle
     */
    public void setControls(Boolean... controls) {
        this.jBSave.setEnabled(controls[0]);
        this.jBDelete.setEnabled(controls[1]);
        this.jBProcess.setEnabled(controls[2]);
        this.jBClear.setEnabled(controls[3]);
        this.jBRefresh.setEnabled(controls[4]);
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar = new javax.swing.JToolBar();
        jBSave = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jBProcess = new javax.swing.JButton();
        jBClear = new javax.swing.JButton();
        jBRefresh = new javax.swing.JButton();
        jBDice = new javax.swing.JButton();
        desktop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMOptions = new javax.swing.JMenu();
        jMISave = new javax.swing.JMenuItem();
        jMIDelete = new javax.swing.JMenuItem();
        jMIProcess = new javax.swing.JMenuItem();
        jMIRefresh = new javax.swing.JMenuItem();
        jMIDice = new javax.swing.JMenuItem();
        jMElement = new javax.swing.JMenu();
        jMIRegElement = new javax.swing.JMenuItem();
        jMPerk = new javax.swing.JMenu();
        jMIRegPerk = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar.setFloatable(false);
        jToolBar.setRollover(true);

        jBSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/save.png"))); // NOI18N
        jBSave.setToolTipText("Salvar");
        jBSave.setFocusable(false);
        jBSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
            }
        });
        jToolBar.add(jBSave);

        jBDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/trash-16.png"))); // NOI18N
        jBDelete.setToolTipText("Deletar");
        jBDelete.setFocusable(false);
        jBDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });
        jToolBar.add(jBDelete);

        jBProcess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/settings.png"))); // NOI18N
        jBProcess.setToolTipText("Processar");
        jBProcess.setFocusable(false);
        jBProcess.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBProcess.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProcessActionPerformed(evt);
            }
        });
        jToolBar.add(jBProcess);

        jBClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/progress/progress.png"))); // NOI18N
        jBClear.setToolTipText("Limpar");
        jBClear.setFocusable(false);
        jBClear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBClear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClearActionPerformed(evt);
            }
        });
        jToolBar.add(jBClear);

        jBRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/transition/switch.png"))); // NOI18N
        jBRefresh.setToolTipText("Recarregar");
        jBRefresh.setFocusable(false);
        jBRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRefreshActionPerformed(evt);
            }
        });
        jToolBar.add(jBRefresh);

        jBDice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/dice.gif"))); // NOI18N
        jBDice.setToolTipText("Jogar dados");
        jBDice.setFocusable(false);
        jBDice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBDice.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDiceActionPerformed(evt);
            }
        });
        jToolBar.add(jBDice);

        desktop.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );

        jLabel1.setText("Mensagens");

        jMOptions.setText("Opções");

        jMISave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/save.png"))); // NOI18N
        jMISave.setText("Salvar");
        jMISave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISaveActionPerformed(evt);
            }
        });
        jMOptions.add(jMISave);

        jMIDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/trash-16.png"))); // NOI18N
        jMIDelete.setText("Deletar");
        jMIDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDeleteActionPerformed(evt);
            }
        });
        jMOptions.add(jMIDelete);

        jMIProcess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/settings.png"))); // NOI18N
        jMIProcess.setText("Processar");
        jMIProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIProcessActionPerformed(evt);
            }
        });
        jMOptions.add(jMIProcess);

        jMIRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/transition/switch.png"))); // NOI18N
        jMIRefresh.setText("Recarregar");
        jMIRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRefreshActionPerformed(evt);
            }
        });
        jMOptions.add(jMIRefresh);

        jMIDice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/dice.gif"))); // NOI18N
        jMIDice.setText("Jogar dados");
        jMIDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDiceActionPerformed(evt);
            }
        });
        jMOptions.add(jMIDice);

        jMenuBar.add(jMOptions);

        jMElement.setText("Elementos");

        jMIRegElement.setText("Cadastro");
        jMIRegElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRegElementActionPerformed(evt);
            }
        });
        jMElement.add(jMIRegElement);

        jMenuBar.add(jMElement);

        jMPerk.setText("Vantagens");

        jMIRegPerk.setText("Cadastro");
        jMIRegPerk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRegPerkActionPerformed(evt);
            }
        });
        jMPerk.add(jMIRegPerk);

        jMenuBar.add(jMPerk);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
            .addComponent(desktop)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(desktop)
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
        save();
    }//GEN-LAST:event_jBSaveActionPerformed

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        delete();
    }//GEN-LAST:event_jBDeleteActionPerformed

    private void jBProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProcessActionPerformed
        process();
    }//GEN-LAST:event_jBProcessActionPerformed

    private void jBRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRefreshActionPerformed
        load();
    }//GEN-LAST:event_jBRefreshActionPerformed

    private void jMISaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISaveActionPerformed
        save();
    }//GEN-LAST:event_jMISaveActionPerformed

    private void jMIDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDeleteActionPerformed
        delete();
    }//GEN-LAST:event_jMIDeleteActionPerformed

    private void jMIProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIProcessActionPerformed
        process();
    }//GEN-LAST:event_jMIProcessActionPerformed

    private void jMIRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRefreshActionPerformed
        load();
    }//GEN-LAST:event_jMIRefreshActionPerformed

    private void jMIRegElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRegElementActionPerformed
        listener.insertView(new ElementView(this));
    }//GEN-LAST:event_jMIRegElementActionPerformed

    private void jMIDiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDiceActionPerformed
        listener.insertView(new DiceView(this));
    }//GEN-LAST:event_jMIDiceActionPerformed

    private void jBDiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDiceActionPerformed
        listener.insertView(new DiceView(this));
    }//GEN-LAST:event_jBDiceActionPerformed

    private void jMIRegPerkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRegPerkActionPerformed
        listener.insertView(new PerkView(this));
    }//GEN-LAST:event_jMIRegPerkActionPerformed

    private void jBClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBClearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JButton jBClear;
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBDice;
    private javax.swing.JButton jBProcess;
    private javax.swing.JButton jBRefresh;
    private javax.swing.JButton jBSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMElement;
    private javax.swing.JMenuItem jMIDelete;
    private javax.swing.JMenuItem jMIDice;
    private javax.swing.JMenuItem jMIProcess;
    private javax.swing.JMenuItem jMIRefresh;
    private javax.swing.JMenuItem jMIRegElement;
    private javax.swing.JMenuItem jMIRegPerk;
    private javax.swing.JMenuItem jMISave;
    private javax.swing.JMenu jMOptions;
    private javax.swing.JMenu jMPerk;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
}
