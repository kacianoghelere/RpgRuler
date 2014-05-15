package br.com.rpgruler.main;

import br.com.gmp.utils.system.SystemProperties;
import br.com.rpgruler.main.bean.MainScreenBean;
import br.com.rpgruler.main.interfaces.Main;
import br.com.rpgruler.main.interfaces.MainListener;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.util.MenuBuilder;
import br.com.rpgruler.main.view.armor.ArmorView;
import br.com.rpgruler.main.view.armortype.ArmorTypeView;
import br.com.rpgruler.main.view.character.CharacterView;
import br.com.rpgruler.main.view.dice.DiceView;
import br.com.rpgruler.main.view.effect.EffectView;
import br.com.rpgruler.main.view.element.ElementView;
import br.com.rpgruler.main.view.expertise.ExpertiseView;
import br.com.rpgruler.main.view.materials.MaterialsView;
import br.com.rpgruler.main.view.menu.MenuView;
import br.com.rpgruler.main.view.perk.PerkView;
import br.com.rpgruler.main.view.terms.TermsView;
import br.com.rpgruler.main.view.menuitem.MenuItemView;
import br.com.rpgruler.main.view.object.ViewParameter;
import br.com.rpgruler.main.view.weapontype.WeaponTypeView;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;

/**
 * Tela principal
 *
 * @author kaciano
 */
public class MainScreen extends javax.swing.JFrame implements Main {

    /**
     * Tipo de mensagem para erros
     */
    public static int ERROR_MSG = 4;

    /**
     * Tipo de mensagem para informação
     */
    public static int INFORMATIVE_MSG = 1;

    /**
     * Tipo de mensagem para questionamento
     */
    public static int QUESTION_MSG = 2;

    /**
     * Tipo de mensagem para secesso
     */
    public static int SUCCESS_MSG = 5;

    /**
     * Tipo de mensagem para avisos
     */
    public static int WARNING_MSG = 3;

    /**
     * Icone de mensagem para erros
     */
    public static String ERROR_ICON = "/ComponentIcons/transition/toolbar/4.png";

    /**
     * Icone de mensagem para informação
     */
    public static String INFORMATIVE_ICON = "/ComponentIcons/transition/toolbar/1.png";

    /**
     * Icone de mensagem para questionamento
     */
    public static String QUESTION_ICON = "/ComponentIcons/transition/toolbar/2.png";

    /**
     * Icone de mensagem para secesso
     */
    public static String SUCCESS_ICON = "/ComponentIcons/transition/toolbar/5.png";

    /**
     * Icone de mensagem para avisos
     */
    public static String WARNING_ICON = "/ComponentIcons/transition/toolbar/3.png";
    private final String ICON = "/dices/d12-icon.png";
    private MainListener listener;

    /**
     * Cria novo MainScreen
     */
    public MainScreen() {
        initialize();
        try {
            new MenuBuilder(this, jMRoot).build();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo de inicialização
     */
    private void initialize() {
        setIconImage(new ImageIcon(getClass().getResource(ICON)).getImage());
        initComponents();
        setControls(new ViewParameter(false, false, false, false));
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        listener = new MainScreenBean(this);
        printTypedMsg("Aplicaçao iniciada", INFORMATIVE_MSG);
    }

    @Override
    public void commit(ActionEvent evt) {
        listener.commit(new BeanEvent(this, evt));
    }

    @Override
    public void process(ActionEvent evt) {
        listener.process(new BeanEvent(this, evt));
    }

    @Override
    public void clear(ActionEvent evt) {
        listener.clear(new BeanEvent(this, evt));
    }

    @Override
    public void load(ActionEvent evt) {
        listener.load(new BeanEvent(this, evt));
    }

    //<editor-fold desc="Get's & Set's" defaultstate="collapsed">
    /**
     * Retorna o listener
     *
     * @return <code>MainListener</code> Listener do frame principal
     */
    public MainListener getListener() {
        return listener;
    }

    /**
     * Modifica o listener
     *
     * @param listener <code>MainListener</code> Listener do frame principal
     */
    public void setListener(MainListener listener) {
        this.listener = listener;
    }

    /**
     * Retorno o desktop
     *
     * @return <code>JDesktopPane</code>
     */
    public JDesktopPane getDesktop() {
        return desktop;
    }

    /**
     * Modifica o desktop
     *
     * @param desktop <code>JDesktopPane</code>
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
        this.jBProcess.setEnabled(controls[1]);
        this.jBClear.setEnabled(controls[2]);
        this.jBRefresh.setEnabled(controls[3]);
    }

    /**
     * Modifica os controles de acordo com a View ativa
     *
     * @param param <code>ViewParameter</code> Parametros das opções de controle
     */
    public void setControls(ViewParameter param) {
        this.jBSave.setEnabled(param.isSave());
        this.jBProcess.setEnabled(param.isProcess());
        this.jBClear.setEnabled(param.isClear());
        this.jBRefresh.setEnabled(param.isLoad());
    }

    /**
     * Imprime uma mensagem na barra de mensagens <br><br>
     * Tipo de mensagem : Variavel utilizada<br>
     * Mensagem de questionamento : MainScreen.QUESTION_ICON<br>
     * Mensagem informativa : MainScreen.INFORMATIVE_ICON<br>
     * Mensagem de aviso : MainScreen.WARNING_ICON<br>
     * Mensagem de erro : MainScreen.ERROR_ICON<br>
     * Mensagem de sucesso : MainScreen.SUCCESS_ICON<br>
     *
     * @param text <code>String</code> Texto à ser impresso
     * @param icon <code>String</code> Icone de tipo para a mensagem
     */
    private void printMsg(String text, String icon) {
        ImageIcon ic = new javax.swing.ImageIcon(getClass().getResource(icon));
        this.jLMsgs.setText(text);
        this.jLMsgs.setIcon(ic);
    }

    /**
     * Imprime uma mensagem na barra de mensagens<br><br>
     * Tipo de mensagem : Mensagem<br>
     * Mensagem informativa : 1 <br>
     * Mensagem de questionamento : 2<br>
     * Mensagem de aviso : 3<br>
     * Mensagem de erro : 4<br>
     * Mensagem de sucesso : 5<br>
     *
     * @param text <code>String</code> Texto à ser impresso
     * @param type <code>int</code> Tipo da mensagem
     */
    public void printTypedMsg(String text, int type) {
        switch (type) {
            case 1:
                printMsg(text, INFORMATIVE_ICON);
                System.out.println(SystemProperties.ANSI_BLUE
                        + "(INFO) " + text
                        + SystemProperties.ANSI_BLACK);
                break;
            case 2:
                printMsg(text, QUESTION_ICON);
                System.out.println(SystemProperties.ANSI_BLUE
                        + "(QUESTION) " + text
                        + SystemProperties.ANSI_BLACK);
                break;
            case 3:
                printMsg(text, WARNING_ICON);
                System.out.println(SystemProperties.ANSI_YELLOW
                        + "(WARNING) " + text
                        + SystemProperties.ANSI_BLACK);
                break;
            case 4:
                printMsg(text, ERROR_ICON);
                System.out.println(SystemProperties.ANSI_RED
                        + "(ERROR) " + text
                        + SystemProperties.ANSI_BLACK);
            case 5:
                printMsg(text, SUCCESS_ICON);
                System.out.println(SystemProperties.ANSI_GREEN
                        + "(SUCCESS) " + text
                        + SystemProperties.ANSI_BLACK);
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
     * Limpa as informações da barra de mensagem
     */
    public void clearMsg() {
        this.jLMsgs.setText("");
        this.jLMsgs.setIcon(null);
    }

    /**
     * Retorna o menu raiz
     *
     * @return <code>JMenu</code> Menu raiz
     */
    public JMenu getRoot() {
        return jMInfo;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar = new javax.swing.JToolBar();
        jBSave = new javax.swing.JButton();
        jBProcess = new javax.swing.JButton();
        jBClear = new javax.swing.JButton();
        jBRefresh = new javax.swing.JButton();
        jBDice = new javax.swing.JButton();
        desktop = new javax.swing.JDesktopPane();
        jTBMsgs = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLMsgs = new javax.swing.JLabel();
        jTBSearch = new javax.swing.JToolBar();
        gTView = new br.com.gmp.comps.textfield.GTextField();
        jMenuBar = new javax.swing.JMenuBar();
        jMOptions = new javax.swing.JMenu();
        jMISave = new javax.swing.JMenuItem();
        jMIProcess = new javax.swing.JMenuItem();
        jMIRefresh = new javax.swing.JMenuItem();
        jMIDice = new javax.swing.JMenuItem();
        jMControls = new javax.swing.JMenu();
        jMIMenus = new javax.swing.JMenuItem();
        jMIViews = new javax.swing.JMenuItem();
        jMInfo = new javax.swing.JMenu();
        jMIRegPerk = new javax.swing.JMenuItem();
        jMIRegElement = new javax.swing.JMenuItem();
        jMIMaterials = new javax.swing.JMenuItem();
        jMITerms = new javax.swing.JMenuItem();
        jMIEffects = new javax.swing.JMenuItem();
        jMIExpertise = new javax.swing.JMenuItem();
        jMICharacter = new javax.swing.JMenuItem();
        jMWeapons = new javax.swing.JMenu();
        jMIWeaponTypes = new javax.swing.JMenuItem();
        jMArmors = new javax.swing.JMenu();
        jMIArmors = new javax.swing.JMenuItem();
        jMIArmorTypes = new javax.swing.JMenuItem();
        jMRoot = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RPG");
        setName("Form"); // NOI18N

        jToolBar.setFloatable(false);
        jToolBar.setRollover(true);
        jToolBar.setName("jToolBar"); // NOI18N

        jBSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/save.png"))); // NOI18N
        jBSave.setToolTipText("Salvar");
        jBSave.setFocusable(false);
        jBSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBSave.setName("jBSave"); // NOI18N
        jBSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
            }
        });
        jToolBar.add(jBSave);

        jBProcess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/settings.png"))); // NOI18N
        jBProcess.setToolTipText("Processar");
        jBProcess.setFocusable(false);
        jBProcess.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBProcess.setName("jBProcess"); // NOI18N
        jBProcess.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProcessActionPerformed(evt);
            }
        });
        jToolBar.add(jBProcess);

        jBClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/brush.png"))); // NOI18N
        jBClear.setToolTipText("Limpar");
        jBClear.setFocusable(false);
        jBClear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBClear.setName("jBClear"); // NOI18N
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
        jBRefresh.setName("jBRefresh"); // NOI18N
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
        jBDice.setName("jBDice"); // NOI18N
        jBDice.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDiceActionPerformed(evt);
            }
        });
        jToolBar.add(jBDice);

        desktop.setBackground(new java.awt.Color(204, 204, 204));
        desktop.setName("desktop"); // NOI18N

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 886, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jTBMsgs.setFloatable(false);
        jTBMsgs.setRollover(true);
        jTBMsgs.setName("jTBMsgs"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N
        jTBMsgs.add(jSeparator1);

        jLMsgs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/transition/toolbar/1.png"))); // NOI18N
        jLMsgs.setText("Mensagens");
        jLMsgs.setName("jLMsgs"); // NOI18N
        jLMsgs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLMsgsMouseClicked(evt);
            }
        });
        jTBMsgs.add(jLMsgs);

        jTBSearch.setFloatable(false);
        jTBSearch.setRollover(true);
        jTBSearch.setName("jTBSearch"); // NOI18N

        gTView.setName("gTView"); // NOI18N
        jTBSearch.add(gTView);

        jMenuBar.setName("jMenuBar"); // NOI18N

        jMOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1246_.png"))); // NOI18N
        jMOptions.setText("Opções");
        jMOptions.setName("jMOptions"); // NOI18N

        jMISave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/save.png"))); // NOI18N
        jMISave.setText("Salvar");
        jMISave.setName("jMISave"); // NOI18N
        jMISave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISaveActionPerformed(evt);
            }
        });
        jMOptions.add(jMISave);

        jMIProcess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/settings.png"))); // NOI18N
        jMIProcess.setText("Processar");
        jMIProcess.setName("jMIProcess"); // NOI18N
        jMIProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIProcessActionPerformed(evt);
            }
        });
        jMOptions.add(jMIProcess);

        jMIRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/transition/switch.png"))); // NOI18N
        jMIRefresh.setText("Recarregar");
        jMIRefresh.setName("jMIRefresh"); // NOI18N
        jMIRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRefreshActionPerformed(evt);
            }
        });
        jMOptions.add(jMIRefresh);

        jMIDice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/dice.gif"))); // NOI18N
        jMIDice.setText("Jogar dados");
        jMIDice.setName("jMIDice"); // NOI18N
        jMIDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDiceActionPerformed(evt);
            }
        });
        jMOptions.add(jMIDice);

        jMControls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/window/frame.png"))); // NOI18N
        jMControls.setText("Cadastros");
        jMControls.setName("jMControls"); // NOI18N

        jMIMenus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/menubar/menubar.png"))); // NOI18N
        jMIMenus.setText("Menus");
        jMIMenus.setName("jMIMenus"); // NOI18N
        jMIMenus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIMenusActionPerformed(evt);
            }
        });
        jMControls.add(jMIMenus);

        jMIViews.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/window/dialog.png"))); // NOI18N
        jMIViews.setText("Telas");
        jMIViews.setName("jMIViews"); // NOI18N
        jMIViews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIViewsActionPerformed(evt);
            }
        });
        jMControls.add(jMIViews);

        jMOptions.add(jMControls);

        jMenuBar.add(jMOptions);

        jMInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1214_.png"))); // NOI18N
        jMInfo.setText("Informações");
        jMInfo.setName("jMInfo"); // NOI18N

        jMIRegPerk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1215_.png"))); // NOI18N
        jMIRegPerk.setMnemonic('v');
        jMIRegPerk.setText("Vantagens");
        jMIRegPerk.setName("jMIRegPerk"); // NOI18N
        jMIRegPerk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRegPerkActionPerformed(evt);
            }
        });
        jMInfo.add(jMIRegPerk);

        jMIRegElement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1399_@.png"))); // NOI18N
        jMIRegElement.setMnemonic('e');
        jMIRegElement.setText("Elementos");
        jMIRegElement.setName("jMIRegElement"); // NOI18N
        jMIRegElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRegElementActionPerformed(evt);
            }
        });
        jMInfo.add(jMIRegElement);

        jMIMaterials.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1285_.png"))); // NOI18N
        jMIMaterials.setMnemonic('M');
        jMIMaterials.setText("Materiais");
        jMIMaterials.setName("jMIMaterials"); // NOI18N
        jMIMaterials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIMaterialsActionPerformed(evt);
            }
        });
        jMInfo.add(jMIMaterials);

        jMITerms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1213_.png"))); // NOI18N
        jMITerms.setMnemonic('t');
        jMITerms.setText("Termos");
        jMITerms.setName("jMITerms"); // NOI18N
        jMITerms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMITermsActionPerformed(evt);
            }
        });
        jMInfo.add(jMITerms);

        jMIEffects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/status/slice1390_@.png"))); // NOI18N
        jMIEffects.setMnemonic('f');
        jMIEffects.setText("Efeitos");
        jMIEffects.setName("jMIEffects"); // NOI18N
        jMIEffects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIEffectsActionPerformed(evt);
            }
        });
        jMInfo.add(jMIEffects);

        jMIExpertise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1352_@.png"))); // NOI18N
        jMIExpertise.setMnemonic('p');
        jMIExpertise.setText("Perícias");
        jMIExpertise.setName("jMIExpertise"); // NOI18N
        jMIExpertise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIExpertiseActionPerformed(evt);
            }
        });
        jMInfo.add(jMIExpertise);

        jMICharacter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1405_@.png"))); // NOI18N
        jMICharacter.setText("Personagens");
        jMICharacter.setName("jMICharacter"); // NOI18N
        jMICharacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICharacterActionPerformed(evt);
            }
        });
        jMInfo.add(jMICharacter);

        jMWeapons.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/weapons/DK/DK_4.png"))); // NOI18N
        jMWeapons.setText("Armas");
        jMWeapons.setName("jMWeapons"); // NOI18N

        jMIWeaponTypes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/weapons/DK/DK_25.png"))); // NOI18N
        jMIWeaponTypes.setText("Tipos de armas");
        jMIWeaponTypes.setName("jMIWeaponTypes"); // NOI18N
        jMIWeaponTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIWeaponTypesActionPerformed(evt);
            }
        });
        jMWeapons.add(jMIWeaponTypes);

        jMInfo.add(jMWeapons);

        jMArmors.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/armor/DVK/DVK_3.png"))); // NOI18N
        jMArmors.setText("Armaduras");
        jMArmors.setName("jMArmors"); // NOI18N

        jMIArmors.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/armor/P/P_21.png"))); // NOI18N
        jMIArmors.setText("Armaduras");
        jMIArmors.setName("jMIArmors"); // NOI18N
        jMIArmors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIArmorsActionPerformed(evt);
            }
        });
        jMArmors.add(jMIArmors);

        jMIArmorTypes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/armor/R/R_0.png"))); // NOI18N
        jMIArmorTypes.setText("Tipos de armaduras");
        jMIArmorTypes.setName("jMIArmorTypes"); // NOI18N
        jMIArmorTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIArmorTypesActionPerformed(evt);
            }
        });
        jMArmors.add(jMIArmorTypes);

        jMInfo.add(jMArmors);

        jMenuBar.add(jMInfo);

        jMRoot.setText("Root");
        jMRoot.setName("jMRoot"); // NOI18N
        jMenuBar.add(jMRoot);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
            .addComponent(jTBMsgs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jTBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(desktop)
                .addGap(0, 0, 0)
                .addComponent(jTBMsgs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
        commit(evt);
    }//GEN-LAST:event_jBSaveActionPerformed

    private void jBProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProcessActionPerformed
        process(evt);
    }//GEN-LAST:event_jBProcessActionPerformed

    private void jBRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRefreshActionPerformed
        load(evt);
    }//GEN-LAST:event_jBRefreshActionPerformed

    private void jMISaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISaveActionPerformed
        commit(evt);
    }//GEN-LAST:event_jMISaveActionPerformed

    private void jMIProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIProcessActionPerformed
        process(evt);
    }//GEN-LAST:event_jMIProcessActionPerformed

    private void jMIRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRefreshActionPerformed
        load(evt);
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
        clear(evt);
    }//GEN-LAST:event_jBClearActionPerformed

    private void jMIMaterialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIMaterialsActionPerformed
        listener.insertView(new MaterialsView(this));
    }//GEN-LAST:event_jMIMaterialsActionPerformed

    private void jLMsgsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLMsgsMouseClicked
        clearMsg();
    }//GEN-LAST:event_jLMsgsMouseClicked

    private void jMIArmorTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIArmorTypesActionPerformed
        listener.insertView(new ArmorTypeView(this));
    }//GEN-LAST:event_jMIArmorTypesActionPerformed

    private void jMITermsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMITermsActionPerformed
        listener.insertView(new TermsView(this));
    }//GEN-LAST:event_jMITermsActionPerformed

    private void jMIMenusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIMenusActionPerformed
        listener.insertView(new MenuView(this));
    }//GEN-LAST:event_jMIMenusActionPerformed

    private void jMIViewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIViewsActionPerformed
        listener.insertView(new MenuItemView(this));
    }//GEN-LAST:event_jMIViewsActionPerformed

    private void jMIEffectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEffectsActionPerformed
        listener.insertView(new EffectView(this));
    }//GEN-LAST:event_jMIEffectsActionPerformed

    private void jMIWeaponTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIWeaponTypesActionPerformed
        listener.insertView(new WeaponTypeView(this));
    }//GEN-LAST:event_jMIWeaponTypesActionPerformed

    private void jMIArmorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIArmorsActionPerformed
        listener.insertView(new ArmorView(this));
    }//GEN-LAST:event_jMIArmorsActionPerformed

    private void jMIExpertiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIExpertiseActionPerformed
        listener.insertView(new ExpertiseView(this));
    }//GEN-LAST:event_jMIExpertiseActionPerformed

    private void jMICharacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICharacterActionPerformed
        listener.insertView(new CharacterView(this));
    }//GEN-LAST:event_jMICharacterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private br.com.gmp.comps.textfield.GTextField gTView;
    private javax.swing.JButton jBClear;
    private javax.swing.JButton jBDice;
    private javax.swing.JButton jBProcess;
    private javax.swing.JButton jBRefresh;
    private javax.swing.JButton jBSave;
    private javax.swing.JLabel jLMsgs;
    private javax.swing.JMenu jMArmors;
    private javax.swing.JMenu jMControls;
    private javax.swing.JMenuItem jMIArmorTypes;
    private javax.swing.JMenuItem jMIArmors;
    private javax.swing.JMenuItem jMICharacter;
    private javax.swing.JMenuItem jMIDice;
    private javax.swing.JMenuItem jMIEffects;
    private javax.swing.JMenuItem jMIExpertise;
    private javax.swing.JMenuItem jMIMaterials;
    private javax.swing.JMenuItem jMIMenus;
    private javax.swing.JMenuItem jMIProcess;
    private javax.swing.JMenuItem jMIRefresh;
    private javax.swing.JMenuItem jMIRegElement;
    private javax.swing.JMenuItem jMIRegPerk;
    private javax.swing.JMenuItem jMISave;
    private javax.swing.JMenuItem jMITerms;
    private javax.swing.JMenuItem jMIViews;
    private javax.swing.JMenuItem jMIWeaponTypes;
    private javax.swing.JMenu jMInfo;
    private javax.swing.JMenu jMOptions;
    private javax.swing.JMenu jMRoot;
    private javax.swing.JMenu jMWeapons;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jTBMsgs;
    private javax.swing.JToolBar jTBSearch;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
}
