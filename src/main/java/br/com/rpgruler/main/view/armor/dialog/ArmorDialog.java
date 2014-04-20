package br.com.rpgruler.main.view.armor.dialog;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.dialog.GDialog;
import br.com.rpgruler.data.entitity.Armor;
import br.com.rpgruler.data.entitity.ArmorType;
import br.com.rpgruler.data.entitity.Attributes;
import br.com.rpgruler.data.entitity.PrimeMaterial;
import br.com.rpgruler.main.view.armor.ArmorView;
import br.com.rpgruler.main.view.armor.bean.ArmorBean;
import br.com.rpgruler.main.view.armor.model.ArmorEffectModel;
import br.com.rpgruler.main.view.armor.model.RestrictionModel;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

/**
 *
 * @author kaciano
 */
public class ArmorDialog extends GDialog {

    private Armor armor;
    private ArmorBean bean;
    private ArmorView view;
    private RestrictionModel restrictionModel;
    private ArmorEffectModel effectModel;
    private GComboBoxModel<ArmorType> armorTypeModel;
    private GComboBoxModel<PrimeMaterial> materialModel1;
    private GComboBoxModel<PrimeMaterial> materialModel2;

    /**
     * Cria nova instancia de ArmorDialog
     *
     * @param view <code>ArmorView</code> Tela das Armaduras
     * @param armor <code>Armor</code> Armadura
     * @param modal <code>boolean</code> Modal?
     */
    public ArmorDialog(ArmorView view, Armor armor, boolean modal) {
        super(view.getMainScreen(), modal);
        this.view = view;
        initialize(armor);
    }

    /**
     * Método de inicialização
     *
     * @param armor <code>Armor</code> Armadura
     */
    private void initialize(Armor armor) {
        setSize(680, 541);
        initComponents();
        this.bean = (ArmorBean) view.getBean();
        this.restrictionModel = new RestrictionModel();
        this.effectModel = new ArmorEffectModel();
        this.armorTypeModel = new GComboBoxModel<>(bean.getArmorTypeDAO().getList());
        this.materialModel1 = new GComboBoxModel<>(bean.getMaterialsDAO().getList());
        this.materialModel2 = new GComboBoxModel<>(bean.getMaterialsDAO().getList());
        this.gTblRestrictions.setModel(restrictionModel);
        this.gTblEffects.setModel(effectModel);
        this.gCBType.setModel(armorTypeModel);
        this.gCBMat1.setModel(materialModel1);
        this.gCBMat2.setModel(materialModel2);
        JMenuItem jMIGen = new JMenuItem("Gerar nome", new ImageIcon(getClass()
                .getResource("/ComponentIcons/controlers/settings.png")));
        jMIGen.addActionListener((ActionEvent e) -> {
            autoName();
        });
        this.gTName.getComponentPopupMenu().add(jMIGen);
        setArmor(armor);
        setVisible(true);
    }

    /**
     * Cria o nome da armadura automaticamentes
     */
    private void autoName() {
        if (gCBType.validateComponent() && gCBMat1.validateComponent() && gCBMat2.validateComponent()) {
            ArmorType prefix = this.armorTypeModel.getSelectedItem();
            PrimeMaterial mat1 = this.materialModel1.getSelectedItem();
            PrimeMaterial mat2 = this.materialModel2.getSelectedItem();
            String name = prefix.getTypeName()
                    + " de " + mat1.getMaterialName()
                    + " e " + mat2.getMaterialName();
            this.gTName.setText(name);
        }
    }

    /**
     * Retorna a armadura que está sendo editada
     *
     * @return <code>Armor</code> Armadura
     */
    public Armor getArmor() {
        return armor;
    }

    /**
     * Modifica a armadura que está sendo editada
     *
     * @param armor <code>Armor</code> Armadura
     */
    public void setArmor(Armor armor) {
        try {
            if (armor != null) {
                this.armor = armor;
                this.gTName.setText(this.armor.getName());
                this.gTADesc.setText(this.armor.getDescription());
                this.gCBType.setSelectedItem(this.armor.getType());
                this.gCBMat1.setSelectedItem(this.armor.getMaterial1());
                this.gCBMat2.setSelectedItem(this.armor.getMaterial2());
                this.jSpinPrice.setValue(this.armor.getPrice());
                if (this.armor.getRestriction() != null) {
                    this.restrictionModel.setData(this.armor.getRestriction());
                }
                if (this.armor.getEffects() != null) {
                    this.effectModel.setData(this.armor.getEffects());
                }
                if (this.armor.getAttributes() != null) {
                    Attributes attr = this.armor.getAttributes();
                    jSpinStr.setValue(attr.getStrength());
                    jSpinDex.setValue(attr.getDexterity());
                    jSpinCon.setValue(attr.getConstitution());
                    jSpinInt.setValue(attr.getIntelligence());
                    jSpinWis.setValue(attr.getWisdom());
                    jSpinChar.setValue(attr.getCharisma());
                    jSpinDef.setValue(attr.getDefense());
                    jSpinEva.setValue(attr.getEvasion());
                    jSpinHP.setValue(attr.getHealth());
                }
            }
        } catch (Exception e) {
            Logger.getLogger(ArmorDialog.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Constroi os dados na armadura
     */
    private void buildArmor() {
        if (this.armor == null) {
            this.armor = new Armor();
        }
        if (this.armor.getId() == null) {
            this.armor.setId(bean.getNextID());
        }
        Attributes attr = new Attributes();
        attr.setStrength((Integer) jSpinStr.getValue());
        attr.setDexterity((Integer) jSpinDex.getValue());
        attr.setConstitution((Integer) jSpinCon.getValue());
        attr.setIntelligence((Integer) jSpinInt.getValue());
        attr.setWisdom((Integer) jSpinWis.getValue());
        attr.setCharisma((Integer) jSpinChar.getValue());
        attr.setDefense((Integer) jSpinDef.getValue());
        attr.setEvasion((Integer) jSpinEva.getValue());
        attr.setHealth((Integer) jSpinHP.getValue());
        this.armor.setAttributes(attr);
        this.armor.setName(gTName.getText());
        this.armor.setDescription(gTADesc.getText());
        this.armor.setPrice((Double) jSpinPrice.getValue());
        this.armor.setType(armorTypeModel.getSelectedItem());
        this.armor.setMaterial1(materialModel1.getSelectedItem());
        this.armor.setMaterial2(materialModel2.getSelectedItem());
        this.armor.setEffects(effectModel.getData());
        this.armor.setRestriction(restrictionModel.getData());
        this.armor.calcResistence();
    }

    /**
     * Valida se os campos estão todos preenchidos corretamente
     *
     * @return <code>boolean</code> Os campos estão todos preenchidos
     * corretamente?
     */
    private boolean validateFields() {
        if (gTName.validateComponent()) {
            if (gCBType.validateComponent()) {
                if (gCBMat1.validateComponent()) {
                    if (gCBMat2.validateComponent()) {
                        return true;
                    }
                }
            }
        }
        return false;
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

        jPCaracteristics = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gTblEffects = new br.com.gmp.comps.table.GTable();
        jBAddEffect = new javax.swing.JButton();
        jBRemoveEffect = new javax.swing.JButton();
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
        jPRestrictions = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        gTblRestrictions = new br.com.gmp.comps.table.GTable();
        jBRemoveRest = new javax.swing.JButton();
        jBAddRest = new javax.swing.JButton();
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
        jPDescription = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GMPTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jBAdd = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();

        setUndecorated(true);
        setMinimumSize(new java.awt.Dimension(680, 511));
        setResizable(false);

        jPCaracteristics.setBorder(javax.swing.BorderFactory.createTitledBorder("Caracteristicas"));

        gTblEffects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTblEffects.setOpaque(false);
        jScrollPane2.setViewportView(gTblEffects);

        jBAddEffect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAddEffect.setFocusable(false);
        jBAddEffect.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAddEffect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddEffectActionPerformed(evt);
            }
        });

        jBRemoveEffect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemoveEffect.setFocusable(false);
        jBRemoveEffect.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRemoveEffect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveEffectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCaracteristicsLayout = new javax.swing.GroupLayout(jPCaracteristics);
        jPCaracteristics.setLayout(jPCaracteristicsLayout);
        jPCaracteristicsLayout.setHorizontalGroup(
            jPCaracteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCaracteristicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCaracteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addGroup(jPCaracteristicsLayout.createSequentialGroup()
                        .addComponent(jBAddEffect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemoveEffect)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPCaracteristicsLayout.setVerticalGroup(
            jPCaracteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCaracteristicsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPCaracteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAddEffect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBRemoveEffect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPBasics.setBorder(javax.swing.BorderFactory.createTitledBorder("Configurações basicas"));

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

        jSpinPrice.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(0.5d)));

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
                            .addComponent(gCBType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gTName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
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
                                    .addComponent(gCBMat2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gCBMat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))))
        );

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
                    .addComponent(jSpinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPrice))
                .addContainerGap())
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBMat1, gCBMat2, gCBType, gTName, jSpinPrice});

        jPRestrictions.setBorder(javax.swing.BorderFactory.createTitledBorder("Restrições"));

        gTblRestrictions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTblRestrictions.setOpaque(false);
        jScrollPane5.setViewportView(gTblRestrictions);

        jBRemoveRest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemoveRest.setFocusable(false);
        jBRemoveRest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRemoveRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveRestActionPerformed(evt);
            }
        });

        jBAddRest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAddRest.setFocusable(false);
        jBAddRest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAddRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddRestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPRestrictionsLayout = new javax.swing.GroupLayout(jPRestrictions);
        jPRestrictions.setLayout(jPRestrictionsLayout);
        jPRestrictionsLayout.setHorizontalGroup(
            jPRestrictionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRestrictionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPRestrictionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addGroup(jPRestrictionsLayout.createSequentialGroup()
                        .addComponent(jBAddRest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemoveRest)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPRestrictionsLayout.setVerticalGroup(
            jPRestrictionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRestrictionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRestrictionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAddRest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBRemoveRest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setText("Salvar");
        jBAdd.setFocusable(false);
        jBAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });
        jToolBar1.add(jBAdd);

        jBCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBCancel.setText("Cancelar");
        jBCancel.setFocusable(false);
        jBCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });
        jToolBar1.add(jBCancel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(jPBasics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPRestrictions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCaracteristics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPBasics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPCaracteristics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPRestrictions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCancelActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        if (validateFields()) {
            buildArmor();
            this.dispose();
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBAddEffectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddEffectActionPerformed
        
    }//GEN-LAST:event_jBAddEffectActionPerformed

    private void jBRemoveEffectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveEffectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBRemoveEffectActionPerformed

    private void jBRemoveRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveRestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBRemoveRestActionPerformed

    private void jBAddRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddRestActionPerformed
        RestrictionDialog dialog = new RestrictionDialog(this, null, true);
    }//GEN-LAST:event_jBAddRestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLStr;
    private javax.swing.JLabel JLType;
    private br.com.gmp.comps.combobox.GComboBox gCBMat1;
    private br.com.gmp.comps.combobox.GComboBox gCBMat2;
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.textarea.GMPTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private br.com.gmp.comps.table.GTable gTblEffects;
    private br.com.gmp.comps.table.GTable gTblRestrictions;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBAddEffect;
    private javax.swing.JButton jBAddRest;
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBRemoveEffect;
    private javax.swing.JButton jBRemoveRest;
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
    private javax.swing.JPanel jPBasics;
    private javax.swing.JPanel jPCaracteristics;
    private javax.swing.JPanel jPDescription;
    private javax.swing.JPanel jPModifiers;
    private javax.swing.JPanel jPRestrictions;
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
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
