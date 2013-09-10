package br.ufu.facom.esof.superpimsystem.view;

import br.ufu.facom.esof.superpimsystem.dao.DAOFactory;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import br.ufu.facom.esof.superpimsystem.model.Anotacao;
import br.ufu.facom.esof.superpimsystem.model.Compromisso;
import br.ufu.facom.esof.superpimsystem.model.Contato;
import br.ufu.facom.esof.superpimsystem.model.DadosPessoais;
import br.ufu.facom.esof.superpimsystem.model.Receita;
import br.ufu.facom.esof.superpimsystem.model.SerialSenha;
import br.ufu.facom.esof.superpimsystem.model.ThreadCompromisso;
import br.ufu.facom.esof.superpimsystem.model.Uteis;
import br.ufu.facom.esof.superpimsystem.control.AnotacoesControl;
import br.ufu.facom.esof.superpimsystem.control.CompromissosControl;
import br.ufu.facom.esof.superpimsystem.control.ContatosControl;
import br.ufu.facom.esof.superpimsystem.control.ReceitasControl;
import br.ufu.facom.esof.superpimsystem.control.SerialControl;
import br.ufu.facom.esof.superpimsystem.control.TelefoneControl;
import com.restfb.exception.FacebookOAuthException;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import sun.misc.Signal;

public class Principal extends javax.swing.JFrame {

    AnotacoesControl modeloAnotacoes;
    public static CompromissosControl modeloComprimissos;
    ContatosControl modeloContatos;
    SerialControl modeloSerial;
    TelefoneControl modeloTelefone;
    ReceitasControl modeloReceita;
    SystemTray systemTray;
    final JPopupMenu popup = new JPopupMenu();
    TrayIcon trayIcon;
    public static DadosPessoais dados;
    ThreadCompromisso t;

    public Principal() {
        super("Super PIM System");
        this.setIconImage(createImage("/imagens/diario.png", "Icone tray"));

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }

        initComponents();
        arrumarConfigs();
        verificarDados();
        carregarDadosBanco();
        
        this.setResizable(false);
        setLocationRelativeTo(null);

        modeloContatos.filtrarNome("");
        modeloComprimissos.filtrarData("");
        modeloSerial.filtrarSenha("");
        modeloAnotacoes.filtrar("");
        modeloTelefone.filtrar("");
        modeloReceita.filtrarNome("");

        tabelaAnotacoes.setAutoResizeMode(tabelaAnotacoes.AUTO_RESIZE_ALL_COLUMNS);
        tabelaCompromissos.setAutoResizeMode(tabelaCompromissos.AUTO_RESIZE_ALL_COLUMNS);
        tabelaContatos.setAutoResizeMode(tabelaContatos.AUTO_RESIZE_ALL_COLUMNS);
        tabelaSerial.setAutoResizeMode(tabelaSerial.AUTO_RESIZE_ALL_COLUMNS);
        tabelaTelefone.setAutoResizeMode(tabelaTelefone.AUTO_RESIZE_ALL_COLUMNS);
        tabelaReceitas.setAutoResizeMode(tabelaReceitas.AUTO_RESIZE_ALL_COLUMNS);

        setExtendedState(MAXIMIZED_BOTH);

        Thread tread = new Thread(t);
        tread.start();
        
        this.show();
        ContatosControl cc = new ContatosControl();


        try {
            cc.comprimentaAniversariantes();
        }
        catch (FacebookOAuthException f) {
            JOptionPane.showMessageDialog(this, "Erro ao realizar login no Facebbok: AccessToken Expirou!\nGere outro AccessToken, insira-o nos dados pessoais"
                    + "e reinicie o sistema SuperPimSystem.", "Access Token Expirado", JOptionPane.ERROR_MESSAGE);
        }
        catch (SQLException s) {
            
        }
        catch (NullPointerException n) {
            
        }
        
       
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pesquisaContatos = new javax.swing.ButtonGroup();
        pesquisaCompromissos = new javax.swing.ButtonGroup();
        pesquisaSerial = new javax.swing.ButtonGroup();
        grupoReceitas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jButtonCalendario = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        jButtonFacebook = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        abaPainel = new javax.swing.JTabbedPane();
        abaContatos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoPesquisaContato = new javax.swing.JTextField();
        opNome = new javax.swing.JRadioButton();
        opDDD = new javax.swing.JRadioButton();
        opCidade = new javax.swing.JRadioButton();
        opBairro = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContatos = new javax.swing.JTable();
        abaCompromissos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoPesquisaCompromissos = new javax.swing.JTextField();
        opData = new javax.swing.JRadioButton();
        opHora = new javax.swing.JRadioButton();
        opLocal = new javax.swing.JRadioButton();
        opEstatus = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCompromissos = new javax.swing.JTable();
        abaSeriais = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        campoPesquisaSerial = new javax.swing.JTextField();
        opUser = new javax.swing.JRadioButton();
        opPass = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaSerial = new javax.swing.JTable();
        abaTelefones = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        campoPesquisaTelefone = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaTelefone = new javax.swing.JTable();
        AbaAnotacoes = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        campoPesquisaAnotacoes = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaAnotacoes = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        campoPesquisaReceita = new javax.swing.JTextField();
        op_Receitas_Nome = new javax.swing.JRadioButton();
        op_Receitas_Ingrediente = new javax.swing.JRadioButton();
        opCategoria = new javax.swing.JRadioButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaReceitas = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToolBar1.setFloatable(false);
        jToolBar1.add(jSeparator3);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/contato.png"))); // NOI18N
        jButton1.setText("Adicionar Contato");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/compromisso.png"))); // NOI18N
        jButton2.setText("Adicionar Compromisso");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/serial.png"))); // NOI18N
        jButton3.setText("Adicionar Serial/Senha");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator6);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tel.png"))); // NOI18N
        jButton4.setText("Adicionar Telefones Úteis");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/anotacao.png"))); // NOI18N
        jButton5.setText("Adicionar Anotação");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Receita.png"))); // NOI18N
        jButton6.setText("Adicionar Receita");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);
        jToolBar1.add(jSeparator8);

        jButtonCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/calendario.png"))); // NOI18N
        jButtonCalendario.setText("Calendário");
        jButtonCalendario.setFocusable(false);
        jButtonCalendario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCalendario.setMaximumSize(new java.awt.Dimension(89, 84));
        jButtonCalendario.setMinimumSize(new java.awt.Dimension(89, 84));
        jButtonCalendario.setPreferredSize(new java.awt.Dimension(89, 84));
        jButtonCalendario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalendarioActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonCalendario);
        jToolBar1.add(jSeparator9);

        jButtonFacebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/face.png"))); // NOI18N
        jButtonFacebook.setText("Facebook");
        jButtonFacebook.setFocusable(false);
        jButtonFacebook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonFacebook.setMaximumSize(new java.awt.Dimension(89, 84));
        jButtonFacebook.setMinimumSize(new java.awt.Dimension(89, 84));
        jButtonFacebook.setPreferredSize(new java.awt.Dimension(89, 84));
        jButtonFacebook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonFacebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFacebookActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonFacebook);
        jToolBar1.add(jSeparator10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));

        jLabel1.setText("Pesquisar por:");

        campoPesquisaContato.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                campoPesquisaContatoCaretUpdate(evt);
            }
        });

        pesquisaContatos.add(opNome);
        opNome.setSelected(true);
        opNome.setText("Nome");
        opNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opNomeActionPerformed(evt);
            }
        });

        pesquisaContatos.add(opDDD);
        opDDD.setText("DDD");

        pesquisaContatos.add(opCidade);
        opCidade.setText("Cidade");

        pesquisaContatos.add(opBairro);
        opBairro.setText("Bairro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPesquisaContato, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(opNome)
                .addGap(18, 18, 18)
                .addComponent(opDDD)
                .addGap(18, 18, 18)
                .addComponent(opCidade)
                .addGap(18, 18, 18)
                .addComponent(opBairro)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoPesquisaContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opNome)
                    .addComponent(opDDD)
                    .addComponent(opCidade)
                    .addComponent(opBairro))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tabelaContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "DDD", "Telefone", "Celular", "Cidade", "Bairro", "Endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaContatos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelaContatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaContatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaContatos);
        tabelaContatos.getColumnModel().getColumn(0).setResizable(false);
        tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabelaContatos.getColumnModel().getColumn(1).setResizable(false);
        tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabelaContatos.getColumnModel().getColumn(2).setResizable(false);
        tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabelaContatos.getColumnModel().getColumn(3).setResizable(false);
        tabelaContatos.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabelaContatos.getColumnModel().getColumn(4).setResizable(false);
        tabelaContatos.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabelaContatos.getColumnModel().getColumn(5).setResizable(false);
        tabelaContatos.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabelaContatos.getColumnModel().getColumn(6).setResizable(false);
        tabelaContatos.getColumnModel().getColumn(6).setPreferredWidth(160);

        javax.swing.GroupLayout abaContatosLayout = new javax.swing.GroupLayout(abaContatos);
        abaContatos.setLayout(abaContatosLayout);
        abaContatosLayout.setHorizontalGroup(
            abaContatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaContatosLayout.createSequentialGroup()
                .addGroup(abaContatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(abaContatosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        abaContatosLayout.setVerticalGroup(
            abaContatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaContatosLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );

        abaPainel.addTab("Contatos", abaContatos);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));

        jLabel2.setText("Pesquisar por:");

        campoPesquisaCompromissos.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                campoPesquisaCompromissosCaretUpdate(evt);
            }
        });

        pesquisaCompromissos.add(opData);
        opData.setSelected(true);
        opData.setText("Data");

        pesquisaCompromissos.add(opHora);
        opHora.setText("Hora");

        pesquisaCompromissos.add(opLocal);
        opLocal.setText("Local");

        pesquisaCompromissos.add(opEstatus);
        opEstatus.setText("Detalhes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPesquisaCompromissos, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(opData)
                .addGap(18, 18, 18)
                .addComponent(opHora)
                .addGap(18, 18, 18)
                .addComponent(opLocal)
                .addGap(18, 18, 18)
                .addComponent(opEstatus)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoPesquisaCompromissos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opData)
                    .addComponent(opHora)
                    .addComponent(opLocal)
                    .addComponent(opEstatus))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tabelaCompromissos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Data", "Hora", "Local", "Estatus", "Detalhes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaCompromissos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCompromissosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaCompromissos);

        javax.swing.GroupLayout abaCompromissosLayout = new javax.swing.GroupLayout(abaCompromissos);
        abaCompromissos.setLayout(abaCompromissosLayout);
        abaCompromissosLayout.setHorizontalGroup(
            abaCompromissosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaCompromissosLayout.createSequentialGroup()
                .addGroup(abaCompromissosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaCompromissosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        abaCompromissosLayout.setVerticalGroup(
            abaCompromissosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaCompromissosLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );

        abaPainel.addTab("Compromissos", abaCompromissos);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));

        jLabel3.setText("Pesquisar por:");

        campoPesquisaSerial.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                campoPesquisaSerialCaretUpdate(evt);
            }
        });

        pesquisaSerial.add(opUser);
        opUser.setSelected(true);
        opUser.setText("Usuario");

        pesquisaSerial.add(opPass);
        opPass.setText("Senha");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPesquisaSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(opUser)
                .addGap(18, 18, 18)
                .addComponent(opPass)
                .addContainerGap(333, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoPesquisaSerial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opUser)
                    .addComponent(opPass))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tabelaSerial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Usuário / Sofware", "Senha / Serial", "Comentário"
            }
        ));
        tabelaSerial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaSerialMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaSerial);

        javax.swing.GroupLayout abaSeriaisLayout = new javax.swing.GroupLayout(abaSeriais);
        abaSeriais.setLayout(abaSeriaisLayout);
        abaSeriaisLayout.setHorizontalGroup(
            abaSeriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaSeriaisLayout.createSequentialGroup()
                .addGroup(abaSeriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaSeriaisLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        abaSeriaisLayout.setVerticalGroup(
            abaSeriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaSeriaisLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );

        abaPainel.addTab("Seriais/Senhas", abaSeriais);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));

        jLabel4.setText("Pesquisar por:");

        campoPesquisaTelefone.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                campoPesquisaTelefoneCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPesquisaTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(485, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoPesquisaTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tabelaTelefone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Telefone", "Descrição"
            }
        ));
        tabelaTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTelefoneMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelaTelefone);

        javax.swing.GroupLayout abaTelefonesLayout = new javax.swing.GroupLayout(abaTelefones);
        abaTelefones.setLayout(abaTelefonesLayout);
        abaTelefonesLayout.setHorizontalGroup(
            abaTelefonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaTelefonesLayout.createSequentialGroup()
                .addGroup(abaTelefonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaTelefonesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        abaTelefonesLayout.setVerticalGroup(
            abaTelefonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaTelefonesLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
        );

        abaPainel.addTab("Telefones Úteis", abaTelefones);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));

        jLabel5.setText("Pesquisar por:");

        campoPesquisaAnotacoes.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                campoPesquisaAnotacoesCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPesquisaAnotacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(485, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoPesquisaAnotacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tabelaAnotacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Título", "Conteúdo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaAnotacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAnotacoesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelaAnotacoes);

        javax.swing.GroupLayout AbaAnotacoesLayout = new javax.swing.GroupLayout(AbaAnotacoes);
        AbaAnotacoes.setLayout(AbaAnotacoesLayout);
        AbaAnotacoesLayout.setHorizontalGroup(
            AbaAnotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaAnotacoesLayout.createSequentialGroup()
                .addGroup(AbaAnotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AbaAnotacoesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AbaAnotacoesLayout.setVerticalGroup(
            AbaAnotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaAnotacoesLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
        );

        abaPainel.addTab("Anotações", AbaAnotacoes);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));

        jLabel9.setText("Pesquisar por:");

        campoPesquisaReceita.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                campoPesquisaReceitaCaretUpdate(evt);
            }
        });

        grupoReceitas.add(op_Receitas_Nome);
        op_Receitas_Nome.setSelected(true);
        op_Receitas_Nome.setText("Nome");

        grupoReceitas.add(op_Receitas_Ingrediente);
        op_Receitas_Ingrediente.setText("Ingrediente");

        grupoReceitas.add(opCategoria);
        opCategoria.setText("Categoria");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPesquisaReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(op_Receitas_Nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(op_Receitas_Ingrediente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opCategoria)
                .addContainerGap(252, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(campoPesquisaReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(op_Receitas_Nome)
                    .addComponent(op_Receitas_Ingrediente)
                    .addComponent(opCategoria))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tabelaReceitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Ingredientes", "Modo de Preparo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaReceitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaReceitasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelaReceitas);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );

        abaPainel.addTab("Receitas", jPanel7);

        jMenu1.setText("Arquivo");

        jMenuItem2.setText("Alterar Dados Pessoais ...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Fechar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");

        jMenuItem1.setText("Sobre...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(abaPainel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(abaPainel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Sobre s = new Sobre();
        s.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void campoPesquisaContatoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_campoPesquisaContatoCaretUpdate
        // TODO add your handling code here:
        if (opNome.isSelected()) {
            modeloContatos.filtrarNome(campoPesquisaContato.getText());
        }

        if (opBairro.isSelected()) {
            modeloContatos.filtrarBairro(campoPesquisaContato.getText());
        }

        if (opCidade.isSelected()) {
            modeloContatos.filtrarCidade(campoPesquisaContato.getText());
        }


        if (opDDD.isSelected()) {
            modeloContatos.filtrarDDD(campoPesquisaContato.getText());
        }

    }//GEN-LAST:event_campoPesquisaContatoCaretUpdate

    private void campoPesquisaCompromissosCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_campoPesquisaCompromissosCaretUpdate
        // TODO add your handling code here:
        if (opData.isSelected()) {
            modeloComprimissos.filtrarData(campoPesquisaCompromissos.getText());
        }

        if (opHora.isSelected()) {
            modeloComprimissos.filtrarHora(campoPesquisaCompromissos.getText());
        }

        if (opLocal.isSelected()) {
            modeloComprimissos.filtrarLocal(campoPesquisaCompromissos.getText());
        }

        if (opEstatus.isSelected()) {
            modeloComprimissos.filtrarDetalhes(campoPesquisaCompromissos.getText());
        }

    }//GEN-LAST:event_campoPesquisaCompromissosCaretUpdate

    private void campoPesquisaSerialCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_campoPesquisaSerialCaretUpdate
        // TODO add your handling code here:
        if (opPass.isSelected()) {
            modeloSerial.filtrarSenha(campoPesquisaSerial.getText());
        }

        if (opUser.isSelected()) {
            modeloSerial.filtrarUsuario(campoPesquisaSerial.getText());
        }


    }//GEN-LAST:event_campoPesquisaSerialCaretUpdate

    private void campoPesquisaTelefoneCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_campoPesquisaTelefoneCaretUpdate
        // TODO add your handling code here:
        modeloTelefone.filtrar(campoPesquisaTelefone.getText());

    }//GEN-LAST:event_campoPesquisaTelefoneCaretUpdate

    private void campoPesquisaAnotacoesCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_campoPesquisaAnotacoesCaretUpdate
        modeloAnotacoes.filtrar(campoPesquisaAnotacoes.getText());

    }//GEN-LAST:event_campoPesquisaAnotacoesCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ContatoGUI con = new ContatoGUI(this);
        con.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CompromissoGUI comp = new CompromissoGUI(this, t);
        comp.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        SerialGUI ser = new SerialGUI(this);
        ser.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TelefoneGUI telG = new TelefoneGUI(this);
        telG.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        AnotacaoGUI anot = new AnotacaoGUI(this);
        anot.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tabelaContatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaContatosMouseClicked
        ContatoGUI contato = new ContatoGUI(this, modeloContatos.getContato(tabelaContatos.getSelectedRow()));
        contato.setVisible(true);
    }//GEN-LAST:event_tabelaContatosMouseClicked

    private void tabelaCompromissosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCompromissosMouseClicked
        // TODO add your handling code here:
        CompromissoGUI compro = new CompromissoGUI(this, modeloComprimissos.getCompromisso(tabelaCompromissos.getSelectedRow()), t);
        compro.setVisible(true);
    }//GEN-LAST:event_tabelaCompromissosMouseClicked

    private void tabelaSerialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaSerialMouseClicked
        // TODO add your handling code here:
        SerialGUI serial = new SerialGUI(this, modeloSerial.getSerialSenha(tabelaSerial.getSelectedRow()));
        serial.setVisible(true);
    }//GEN-LAST:event_tabelaSerialMouseClicked

    private void tabelaTelefoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTelefoneMouseClicked
        // TODO add your handling code here:
        TelefoneGUI telef = new TelefoneGUI(this, modeloTelefone.getUteis(tabelaTelefone.getSelectedRow()));
        telef.setVisible(true);
    }//GEN-LAST:event_tabelaTelefoneMouseClicked

    private void tabelaAnotacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAnotacoesMouseClicked
        // TODO add your handling code here:
        AnotacaoGUI anot = new AnotacaoGUI(this, modeloAnotacoes.getAnotacao(tabelaAnotacoes.getSelectedRow()));
        anot.setVisible(true);
    }//GEN-LAST:event_tabelaAnotacoesMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void campoPesquisaReceitaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_campoPesquisaReceitaCaretUpdate
        // TODO add your handling code here:
        if (op_Receitas_Nome.isSelected()) {
            modeloReceita.filtrarNome(campoPesquisaReceita.getText());

        } else if (op_Receitas_Ingrediente.isSelected()) {
            modeloReceita.filtrarIngrediente(campoPesquisaReceita.getText());

        } else {
            modeloReceita.filtrarCategoria(campoPesquisaReceita.getText());

        }
    }//GEN-LAST:event_campoPesquisaReceitaCaretUpdate

    private void tabelaReceitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaReceitasMouseClicked
        // TODO add your handling code here:
        ReceitasGUI rSS = new ReceitasGUI(this, modeloReceita.getReceita(tabelaReceitas.getSelectedRow()));
        rSS.setVisible(true);
    }//GEN-LAST:event_tabelaReceitasMouseClicked

    private void jButtonCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalendarioActionPerformed
        // TODO add your handling code here:
        CalendarioGUI cal = new CalendarioGUI();
        cal.setVisible(true);
    }//GEN-LAST:event_jButtonCalendarioActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        br.ufu.facom.esof.superpimsystem.dao.DAO d2 = br.ufu.facom.esof.superpimsystem.dao.DAOFactory.getInstance().getDAO(DAOFactory.DADOS);

        DadosPessoaisGUI dpg = new DadosPessoaisGUI(d2);
        dpg.setAlwaysOnTop(true);
        dpg.setVisible(true);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        ReceitasGUI rG = new ReceitasGUI(this);
        rG.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void opNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opNomeActionPerformed

    private void jButtonFacebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFacebookActionPerformed
        // TODO add your handling code here:
        FacebookGUI face = new FacebookGUI();
        face.setVisible(true);
    }//GEN-LAST:event_jButtonFacebookActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       JOptionPane.showMessageDialog(null, "Fechando Super PIM System... Obrigado!\n\n..:: Super PIM System ::..", "Fechando...", JOptionPane.WARNING_MESSAGE);
                DAOFactory.getInstance().fechaConexao();
                System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                System.out.println("Starting Super PIM System...\nDone!");
                new Principal();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AbaAnotacoes;
    private javax.swing.JPanel abaCompromissos;
    private javax.swing.JPanel abaContatos;
    private javax.swing.JTabbedPane abaPainel;
    private javax.swing.JPanel abaSeriais;
    private javax.swing.JPanel abaTelefones;
    private javax.swing.JTextField campoPesquisaAnotacoes;
    private javax.swing.JTextField campoPesquisaCompromissos;
    private javax.swing.JTextField campoPesquisaContato;
    private javax.swing.JTextField campoPesquisaReceita;
    private javax.swing.JTextField campoPesquisaSerial;
    private javax.swing.JTextField campoPesquisaTelefone;
    private javax.swing.ButtonGroup grupoReceitas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonCalendario;
    private javax.swing.JButton jButtonFacebook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JRadioButton opBairro;
    private javax.swing.JRadioButton opCategoria;
    private javax.swing.JRadioButton opCidade;
    private javax.swing.JRadioButton opDDD;
    private javax.swing.JRadioButton opData;
    private javax.swing.JRadioButton opEstatus;
    private javax.swing.JRadioButton opHora;
    private javax.swing.JRadioButton opLocal;
    private javax.swing.JRadioButton opNome;
    private javax.swing.JRadioButton opPass;
    private javax.swing.JRadioButton opUser;
    private javax.swing.JRadioButton op_Receitas_Ingrediente;
    private javax.swing.JRadioButton op_Receitas_Nome;
    private javax.swing.ButtonGroup pesquisaCompromissos;
    private javax.swing.ButtonGroup pesquisaContatos;
    private javax.swing.ButtonGroup pesquisaSerial;
    private javax.swing.JTable tabelaAnotacoes;
    private javax.swing.JTable tabelaCompromissos;
    private javax.swing.JTable tabelaContatos;
    private javax.swing.JTable tabelaReceitas;
    private javax.swing.JTable tabelaSerial;
    private javax.swing.JTable tabelaTelefone;
    // End of variables declaration//GEN-END:variables

    protected static Image createImage(String path, String description) {
        URL imageURL = Principal.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }

    private void mostraJanela() {
        if (this.isVisible()) {

            this.setVisible(false);

        } else {

            this.setVisible(true);

        }//end else

    }

    private void criarPopUp() {
        JMenuItem itemSobre = new JMenuItem("Sobre", new javax.swing.ImageIcon(getClass().getResource("/imagens/POPsobre.png")));
        JMenuItem itemFechar = new JMenuItem("Fechar", new javax.swing.ImageIcon(getClass().getResource("/imagens/POPfechar.png")));
        JMenuItem itemCalendario = new JMenuItem("Calendário", new javax.swing.ImageIcon(getClass().getResource("/imagens/POPcalendario.png")));

        JMenu cadastrar = new JMenu("Cadastro");
        cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/POPcadastro.png")));

        JMenuItem itemContato = new JMenuItem("Contato", new javax.swing.ImageIcon(getClass().getResource("/imagens/POPcontato.png")));
        JMenuItem itemCompromisso = new JMenuItem("Compromisso", new javax.swing.ImageIcon(getClass().getResource("/imagens/POPcompromisso.png")));
        JMenuItem itemSerial = new JMenuItem("Serial / Senha", new javax.swing.ImageIcon(getClass().getResource("/imagens/POPserial.png")));
        JMenuItem itemTel = new JMenuItem("Telefones Úteis", new javax.swing.ImageIcon(getClass().getResource("/imagens/POPtelefone.png")));
        JMenuItem itemAnotacao = new JMenuItem("Anotação", new javax.swing.ImageIcon(getClass().getResource("/imagens/POPanotacao.png")));
        JMenuItem itemReceita = new JMenuItem("Receita", new javax.swing.ImageIcon(getClass().getResource("/imagens/POPreceita.png")));


        //adicionando no popup
        popup.add(cadastrar);
        cadastrar.add(itemContato);
        cadastrar.addSeparator();
        cadastrar.add(itemCompromisso);
        cadastrar.addSeparator();
        cadastrar.add(itemSerial);
        cadastrar.addSeparator();
        cadastrar.add(itemTel);
        cadastrar.addSeparator();
        cadastrar.add(itemAnotacao);
        cadastrar.addSeparator();
        cadastrar.add(itemReceita);
        popup.addSeparator();
        popup.add(itemCalendario);
        popup.addSeparator();
        popup.add(itemSobre);
        popup.addSeparator();
        popup.add(itemFechar);

        //criando os eventos...
        itemCalendario.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                CalendarioGUI cal = new CalendarioGUI();
                cal.setVisible(true);
            }
        });

        itemSobre.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Sobre s = new Sobre();
                s.setVisible(true);
            }
        });

        itemFechar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Fechando Super PIM System... Obrigado!\n\n..:: Super PIM System ::..", "Fechando...", JOptionPane.WARNING_MESSAGE);
                DAOFactory.getInstance().fechaConexao();
                System.exit(0);
            }
        });

        ActionListener eventoMenuItem = new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JMenuItem item = (JMenuItem) e.getSource();

                if ("Contato".equals(item.getLabel())) {
                    ContatoGUI cG = new ContatoGUI(Principal.this);
                    cG.setVisible(true);

                } else if ("Compromisso".equals(item.getLabel())) {
                    CompromissoGUI cGG = new CompromissoGUI(Principal.this, t);
                    cGG.setVisible(true);

                } else if ("Serial / Senha".equals(item.getLabel())) {
                    SerialGUI sG = new SerialGUI(Principal.this);
                    sG.setVisible(true);

                } else if ("Telefones Úteis".equals(item.getLabel())) {
                    TelefoneGUI tG = new TelefoneGUI(Principal.this);
                    tG.setVisible(true);

                } else if ("Anotação".equals(item.getLabel())) {
                    AnotacaoGUI aG = new AnotacaoGUI(Principal.this);
                    aG.setVisible(true);
                } else if ("Receita".equals(item.getLabel())) {
                    ReceitasGUI rG = new ReceitasGUI(Principal.this);
                    rG.setVisible(true);
                }
            }
        };

        //setando o listener
        itemContato.addActionListener(eventoMenuItem);
        itemCompromisso.addActionListener(eventoMenuItem);
        itemSerial.addActionListener(eventoMenuItem);
        itemTel.addActionListener(eventoMenuItem);
        itemAnotacao.addActionListener(eventoMenuItem);
        itemReceita.addActionListener(eventoMenuItem);
    }

    private void verificarDados() {
        try {
            br.ufu.facom.esof.superpimsystem.dao.DAO d2 = null;
            d2 = br.ufu.facom.esof.superpimsystem.dao.DAOFactory.getInstance().getDAO(DAOFactory.DADOS);
            dados = d2.getDado();


                if (dados.getNome().equals("NaoRegistrou2") || dados.getEmail().equals("NaoRegistrou@NaoRegistrou2")) {
                    DadosPessoaisGUI dpgui = new DadosPessoaisGUI(d2);
                    dpgui.setAlwaysOnTop(true);
                    dpgui.setVisible(true);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void arrumarConfigs() {
        systemTray = SystemTray.getSystemTray();

        trayIcon = new TrayIcon(createImage("/imagens/diario.png", "Icone tray"), "Super PIM System", null);

        trayIcon.setImageAutoSize(true);

        criarPopUp();

        try {
            systemTray.add(trayIcon);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro crítico!\nO seu sistema não suporta icones na bandeja!\nFinalizando o programa!", "Erro fatal", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }//end catch


        trayIcon.setToolTip("..:: Super PIM System ::..\nClique com o botão direito ou clique duas vezes.");
        ToolTipManager.sharedInstance().setInitialDelay(0);

        
        trayIcon.addMouseListener(new MouseAdapter() {

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.setLocation(e.getX(), e.getY());
                    popup.setInvoker(popup);
                    popup.setVisible(true);
                }

                if (e.getClickCount() == 2) {
                    mostraJanela();
                }
            }
        });


        JLabel c = new JLabel("Contatos        ");
        c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/listaContatos.png")));

        JLabel com = new JLabel("Compromissos    ");
        com.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/listaCompromissos.png")));

        JLabel s = new JLabel("Seriais / Senhas");
        s.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/listaSerial.png")));

        JLabel t = new JLabel("Telefones Úteis ");
        t.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/listaTelefones.png")));

        JLabel a = new JLabel("Anotações       ");
        a.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/listaAnotacoes.png")));

        JLabel r = new JLabel("Receitas       ");
        r.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/listaReceita.png")));

        abaPainel.setTabComponentAt(0, c);
        abaPainel.setTabComponentAt(1, com);
        abaPainel.setTabComponentAt(2, s);
        abaPainel.setTabComponentAt(3, t);
        abaPainel.setTabComponentAt(4, a);
        abaPainel.setTabComponentAt(5, r);
    }

    private void carregarDadosBanco() {
        br.ufu.facom.esof.superpimsystem.dao.DAO d = null;
        br.ufu.facom.esof.superpimsystem.dao.DAO dComp = null;

        modeloAnotacoes = new AnotacoesControl();
        modeloComprimissos = new CompromissosControl();
        modeloContatos = new ContatosControl();
        modeloSerial = new SerialControl();
        modeloTelefone = new TelefoneControl();
        modeloReceita = new ReceitasControl();


        ArrayList<Anotacao> pegueiAnot = null;
        ArrayList<Compromisso> pegueiCom = null;
        ArrayList<Contato> pegueiCon = null;
        ArrayList<SerialSenha> pegueiSer = null;
        ArrayList<Uteis> pegueiUte = null;
        ArrayList<Receita> pegueiRec = null;

        try {

            d = br.ufu.facom.esof.superpimsystem.dao.DAOFactory.getInstance().getDAO(DAOFactory.ANOTACAO);
            pegueiAnot = d.getAllAnot();

            dComp = br.ufu.facom.esof.superpimsystem.dao.DAOFactory.getInstance().getDAO(DAOFactory.COMPROMISSO);
            pegueiCom = dComp.getAllComp();


            d = br.ufu.facom.esof.superpimsystem.dao.DAOFactory.getInstance().getDAO(DAOFactory.CONTATO);
            pegueiCon = d.getAllCon();

            d = br.ufu.facom.esof.superpimsystem.dao.DAOFactory.getInstance().getDAO(DAOFactory.RECEITA);
            pegueiRec = d.getAllRec();

            d = br.ufu.facom.esof.superpimsystem.dao.DAOFactory.getInstance().getDAO(DAOFactory.SENHA);
            pegueiSer = d.getAllSen();

            d = br.ufu.facom.esof.superpimsystem.dao.DAOFactory.getInstance().getDAO(DAOFactory.UTEIS);
            pegueiUte = d.getAllUti();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: na criacao do D " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }


        if (pegueiAnot != null) {
            modeloAnotacoes.addListaDeAnotacao(pegueiAnot);
        }

        if (pegueiCom != null) {
            modeloComprimissos.addListaDeCompromisso(pegueiCom);
        }

        if (pegueiCon != null) {
            modeloContatos.addListaDeContato(pegueiCon);
        }

        if (pegueiRec != null) {
            modeloReceita.addListaDeReceita(pegueiRec);
        }

        if (pegueiSer != null) {
            modeloSerial.addListaDeSerialSenha(pegueiSer);
        }

        if (pegueiUte != null) {
            modeloTelefone.addListaDeUteis(pegueiUte);
        }

        tabelaAnotacoes.setModel(modeloAnotacoes);
        tabelaCompromissos.setModel(modeloComprimissos);
        tabelaContatos.setModel(modeloContatos);
        tabelaSerial.setModel(modeloSerial);
        tabelaTelefone.setModel(modeloTelefone);
        tabelaReceitas.setModel(modeloReceita);
        
        t = new ThreadCompromisso(dComp);
    }
}
