package br.com.rpgruler.main.view.armor;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.model.GListModel;
import br.com.rpgruler.data.entitity.Armor;
import br.com.rpgruler.data.entitity.ArmorType;
import br.com.rpgruler.data.entitity.PrimeMaterial;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.view.View;
import br.com.rpgruler.main.view.armor.bean.ArmorBean;
import br.com.rpgruler.main.view.armor.model.ArmorEffectModel;
import br.com.rpgruler.main.view.armor.model.RestrictionModel;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kaciano
 */
public class ArmorView extends View {

    private ArmorBean bean;
    private GListModel<Armor> armorModel;
    private RestrictionModel restrictionModel;
    private ArmorEffectModel effectModel;
    private GComboBoxModel<ArmorType> armorTypeModel;
    private GComboBoxModel<PrimeMaterial> materialModel1;
    private GComboBoxModel<PrimeMaterial> materialModel2;

    /**
     * Cria nova instancia de ArmorView
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     */
    public ArmorView(MainScreen mainScreen) {
        super(mainScreen);
        this.initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.setSize(800, 530);
        this.initComponents();
        this.armorModel = new GListModel<>();
        this.restrictionModel = new RestrictionModel();
        this.effectModel = new ArmorEffectModel();
        this.armorTypeModel = new GComboBoxModel<>();
        this.materialModel1 = new GComboBoxModel<>();
        this.materialModel2 = new GComboBoxModel<>();
        this.bean = new ArmorBean(this);
        try {
            this.bean.load(null);
        } catch (Exception ex) {
            Logger.getLogger(ArmorView.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.gCBType.setModel(armorTypeModel);
        this.gCBMat1.setModel(materialModel1);
        this.gCBMat2.setModel(materialModel2);
    }

    @Override
    public void save() {
        if (gTName.validateComponent()) {
            if (gCBType.validateComponent()) {
                if (gCBMat1.validateComponent()) {
                    if (gCBMat2.validateComponent()) {

                    }
                }
            }
        }
        super.save();
    }

    @Override
    public BeanListener getBean() {
        return this.bean;
    }

    /**
     * Retorna o Modelo das armaduras
     *
     * @return <code>GListModel(Armor)</code> Modelo das armaduras
     */
    public GListModel<Armor> getArmorModel() {
        return armorModel;
    }

    /**
     * Retorna o Modelo das restrições
     *
     * @return <code>RestrictionModel</code> Modelo das restrições
     */
    public RestrictionModel getRestrictionModel() {
        return restrictionModel;
    }

    /**
     * Retorna o Modelo dos efeitos de armaduras
     *
     * @return <code>ArmorEffectModel</code> Modelo dos efeitos de armaduras
     */
    public ArmorEffectModel getEffectModel() {
        return effectModel;
    }

    /**
     * Retorna o Modelo dos Tipos de armaduras
     *
     * @return <code>GComboBoxModel(ArmorType)</code> Tipos de armaduras
     */
    public GComboBoxModel<ArmorType> getArmorTypeModel() {
        return armorTypeModel;
    }

    /**
     * Retorna o Modelo dos Materiais 1
     *
     * @return <code>GComboBoxModel(PrimeMaterial)</code> Materiais 1
     */
    public GComboBoxModel<PrimeMaterial> getMaterialModel1() {
        return materialModel1;
    }

    /**
     * Retorna o Modelo dos Materiais 2
     *
     * @return <code>GComboBoxModel(PrimeMaterial)</code> Materiais 2
     */
    public GComboBoxModel<PrimeMaterial> getMaterialModel2() {
        return materialModel2;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopName = new javax.swing.JPopupMenu();
        jMIGenName = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        gListArmors = new br.com.gmp.comps.list.GList();
        jPBasics = new javax.swing.JPanel();
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jLMat1 = new javax.swing.JLabel();
        gCBMat1 = new br.com.gmp.comps.combobox.GComboBox();
        gCBMat2 = new br.com.gmp.comps.combobox.GComboBox();
        jLMat2 = new javax.swing.JLabel();
        JLType = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        jLName = new javax.swing.JLabel();
        jLPrice = new javax.swing.JLabel();
        jSpinPrice = new javax.swing.JSpinner();
        jPCaracteristics = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gTblCaracteristics = new br.com.gmp.comps.table.GTable();
        jPDescription = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GMPTextArea();
        jBNew = new javax.swing.JButton();
        jPRestrictions = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        gTblRestrictions = new br.com.gmp.comps.table.GTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPModifiers = new javax.swing.JPanel();
        JLStr = new javax.swing.JLabel();
        jSpinStr = new javax.swing.JSpinner();
        jLDex = new javax.swing.JLabel();
        jSpinDex = new javax.swing.JSpinner();
        jSpinInt = new javax.swing.JSpinner();
        jLInt = new javax.swing.JLabel();
        jSpinChar = new javax.swing.JSpinner();
        jSpinCon = new javax.swing.JSpinner();
        jLChar = new javax.swing.JLabel();
        jLCon = new javax.swing.JLabel();
        jSpinWis = new javax.swing.JSpinner();
        jLWis = new javax.swing.JLabel();
        jSpinEva = new javax.swing.JSpinner();
        jSpinDef = new javax.swing.JSpinner();
        jLEva = new javax.swing.JLabel();
        jLDef = new javax.swing.JLabel();
        jSpinHP = new javax.swing.JSpinner();
        jLHP = new javax.swing.JLabel();

        jMIGenName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/settings.png"))); // NOI18N
        jMIGenName.setText("Gerar nome");
        jMIGenName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIGenNameActionPerformed(evt);
            }
        });
        jPopName.add(jMIGenName);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Armaduras");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/armor/P/P_21.png"))); // NOI18N

        gListArmors.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(gListArmors);

        jPBasics.setBorder(javax.swing.BorderFactory.createTitledBorder("Configurações basicas"));

        gTName.setComponentPopupMenu(jPopName);

        jLMat1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMat1.setText("Material 1:");

        jLMat2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMat2.setText("Material 2:");

        JLType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JLType.setText("Tipo:");

        jLName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName.setText("Nome:");

        jLPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLPrice.setText("Preço:");

        jSpinPrice.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0)));

        javax.swing.GroupLayout jPBasicsLayout = new javax.swing.GroupLayout(jPBasics);
        jPBasics.setLayout(jPBasicsLayout);
        jPBasicsLayout.setHorizontalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLType)
                            .addComponent(jLName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLMat1)
                            .addComponent(jLMat2)
                            .addComponent(jLPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPBasicsLayout.createSequentialGroup()
                                .addComponent(jSpinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPBasicsLayout.createSequentialGroup()
                                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(gCBMat2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gCBMat1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {gCBMat1, gCBMat2, gCBType, gTName});

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JLType, jLMat1, jLMat2, jLName, jLPrice});

        jPBasicsLayout.setVerticalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLName)
                    .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLType)
                    .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLMat1)
                    .addComponent(gCBMat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCBMat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMat2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPrice)
                    .addComponent(jSpinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBMat1, gCBMat2, gCBType, gTName, jSpinPrice});

        jPCaracteristics.setBorder(javax.swing.BorderFactory.createTitledBorder("Caracteristicas"));

        gTblCaracteristics.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTblCaracteristics.setOpaque(false);
        jScrollPane2.setViewportView(gTblCaracteristics);

        javax.swing.GroupLayout jPCaracteristicsLayout = new javax.swing.GroupLayout(jPCaracteristics);
        jPCaracteristics.setLayout(jPCaracteristicsLayout);
        jPCaracteristicsLayout.setHorizontalGroup(
            jPCaracteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCaracteristicsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPCaracteristicsLayout.setVerticalGroup(
            jPCaracteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCaracteristicsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPDescription.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));

        gTADesc.setColumns(20);
        gTADesc.setRows(5);
        jScrollPane3.setViewportView(gTADesc);

        javax.swing.GroupLayout jPDescriptionLayout = new javax.swing.GroupLayout(jPDescription);
        jPDescription.setLayout(jPDescriptionLayout);
        jPDescriptionLayout.setHorizontalGroup(
            jPDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPDescriptionLayout.setVerticalGroup(
            jPDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        jBNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBNew.setText("Novo");
        jBNew.setToolTipText("Gerar nome");
        jBNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNewActionPerformed(evt);
            }
        });

        jPRestrictions.setBorder(javax.swing.BorderFactory.createTitledBorder("Restrições"));

        gTblRestrictions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTblRestrictions.setOpaque(false);
        jScrollPane5.setViewportView(gTblRestrictions);

        javax.swing.GroupLayout jPRestrictionsLayout = new javax.swing.GroupLayout(jPRestrictions);
        jPRestrictions.setLayout(jPRestrictionsLayout);
        jPRestrictionsLayout.setHorizontalGroup(
            jPRestrictionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPRestrictionsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPRestrictionsLayout.setVerticalGroup(
            jPRestrictionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPRestrictionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificadores"));

        JLStr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JLStr.setText("FOR:");

        jSpinStr.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jLDex.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLDex.setText("DES:");

        jSpinDex.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jSpinInt.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jLInt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLInt.setText("INT:");

        jSpinChar.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jSpinCon.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jLChar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLChar.setText("CAR:");

        jLCon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLCon.setText("CON:");

        jSpinWis.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jLWis.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLWis.setText("SAB:");

        jSpinEva.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jSpinDef.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jLEva.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLEva.setText("EVA:");

        jLDef.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLDef.setText("DEF:");

        jSpinHP.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jLHP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLHP.setText("HP:");

        javax.swing.GroupLayout jPModifiersLayout = new javax.swing.GroupLayout(jPModifiers);
        jPModifiers.setLayout(jPModifiersLayout);
        jPModifiersLayout.setHorizontalGroup(
            jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModifiersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPModifiersLayout.createSequentialGroup()
                        .addComponent(JLStr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinStr, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinDex, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLInt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinInt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPModifiersLayout.createSequentialGroup()
                        .addComponent(jLWis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinWis, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLCon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinCon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLChar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinChar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPModifiersLayout.createSequentialGroup()
                        .addComponent(jLHP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinHP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDef)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinDef, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLEva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinEva, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPModifiersLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jSpinChar, jSpinCon, jSpinDef, jSpinDex, jSpinEva, jSpinHP, jSpinInt, jSpinStr, jSpinWis});

        jPModifiersLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JLStr, jLChar, jLCon, jLDef, jLDex, jLEva, jLHP, jLInt, jLWis});

        jPModifiersLayout.setVerticalGroup(
            jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModifiersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLStr)
                    .addComponent(jSpinStr, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDex)
                    .addComponent(jSpinDex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLInt)
                    .addComponent(jSpinInt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLWis)
                    .addComponent(jSpinWis, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCon)
                    .addComponent(jSpinCon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLChar)
                    .addComponent(jSpinChar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLHP)
                    .addComponent(jSpinHP, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDef)
                    .addComponent(jSpinDef, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLEva)
                    .addComponent(jSpinEva, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPModifiersLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jSpinChar, jSpinCon, jSpinDef, jSpinDex, jSpinEva, jSpinHP, jSpinInt, jSpinStr, jSpinWis});

        jScrollPane4.setViewportView(jPModifiers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBNew, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addComponent(jPBasics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPCaracteristics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPRestrictions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPBasics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPCaracteristics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPRestrictions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBNew)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNewActionPerformed

    }//GEN-LAST:event_jBNewActionPerformed

    private void jMIGenNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIGenNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMIGenNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLStr;
    private javax.swing.JLabel JLType;
    private br.com.gmp.comps.combobox.GComboBox gCBMat1;
    private br.com.gmp.comps.combobox.GComboBox gCBMat2;
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.list.GList gListArmors;
    private br.com.gmp.comps.textarea.GMPTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private br.com.gmp.comps.table.GTable gTblCaracteristics;
    private br.com.gmp.comps.table.GTable gTblRestrictions;
    private javax.swing.JButton jBNew;
    private javax.swing.JLabel jLChar;
    private javax.swing.JLabel jLCon;
    private javax.swing.JLabel jLDef;
    private javax.swing.JLabel jLDex;
    private javax.swing.JLabel jLEva;
    private javax.swing.JLabel jLHP;
    private javax.swing.JLabel jLInt;
    private javax.swing.JLabel jLMat1;
    private javax.swing.JLabel jLMat2;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLPrice;
    private javax.swing.JLabel jLWis;
    private javax.swing.JMenuItem jMIGenName;
    private javax.swing.JPanel jPBasics;
    private javax.swing.JPanel jPCaracteristics;
    private javax.swing.JPanel jPDescription;
    private javax.swing.JPanel jPModifiers;
    private javax.swing.JPanel jPRestrictions;
    private javax.swing.JPopupMenu jPopName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinChar;
    private javax.swing.JSpinner jSpinCon;
    private javax.swing.JSpinner jSpinDef;
    private javax.swing.JSpinner jSpinDex;
    private javax.swing.JSpinner jSpinEva;
    private javax.swing.JSpinner jSpinHP;
    private javax.swing.JSpinner jSpinInt;
    private javax.swing.JSpinner jSpinPrice;
    private javax.swing.JSpinner jSpinStr;
    private javax.swing.JSpinner jSpinWis;
    // End of variables declaration//GEN-END:variables
}
