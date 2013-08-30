package br.ufu.facom.esof.superpimsystem.view;

import br.ufu.facom.esof.superpimsystem.dao.DAOFactory;
import javax.swing.JOptionPane;
import br.ufu.facom.esof.superpimsystem.model.Receita;


public class ReceitasGUI extends javax.swing.JFrame {

    Receita atual;
    Principal p;

    public ReceitasGUI(Principal p) {
        super("Adicionar / Editar Receitas");
        initComponents();
        setLocationRelativeTo(null);
        bExcluir.setEnabled(false);
        this.p = p;

    }

    public ReceitasGUI(Principal p,Receita atual) {
        super("Adicionar / Editar Receitas");
        initComponents();
        setLocationRelativeTo(null);
        this.atual = atual;
        PreencherReceitas();
        this.p = p;

    }

    public void PreencherReceitas() {
        campoModo.setText(atual.getModoDePreparo());
        campoIngri.setText(atual.getIngredientes().toString());
        campoNome.setText(atual.getNomeDaReceita());
        comboCategoria.setSelectedItem(atual.getCategoria());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoModo = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        campoIngri = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Receita.png"))); // NOI18N
        jLabel1.setText("Adicionar / Editar Receitas");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sign-Shutdown-icon.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/retReceita.png"))); // NOI18N
        bExcluir.setText("Excluir");
        bExcluir.setPreferredSize(new java.awt.Dimension(130, 60));
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/addReceita.png"))); // NOI18N
        jButton1.setText("Salvar");
        jButton1.setPreferredSize(new java.awt.Dimension(130, 60));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel3.setText("Modo de Preparo");

        campoModo.setColumns(20);
        campoModo.setRows(5);
        jScrollPane1.setViewportView(campoModo);

        jLabel4.setText("Ingredientes");

        campoIngri.setColumns(20);
        campoIngri.setRows(5);
        jScrollPane2.setViewportView(campoIngri);

        jLabel5.setText("Categoria");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entradas", "Saladas", "Aves", "Carnes", "Peixes e Frutos do Mar", "Pães e Salgados", "Acompanhamentos", "Massas", "Sopas", "Sobremesas", "Bebidas", "Temáticos" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(jLabel4))
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         try {
            br.ufu.facom.esof.superpimsystem.dao.DAO d = br.ufu.facom.esof.superpimsystem.dao.DAOFactory.getInstance().getDAO(DAOFactory.RECEITA);
            if (atual == null) {
                 if (campoNome.getText().equals("") || campoIngri.getText().equals("") || campoModo.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Por favor preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    d.salvar(new Receita(campoNome.getText(), campoModo.getText(), campoIngri.getText(), comboCategoria.getSelectedItem().toString()));
                }
            } else {
                 if (campoNome.getText().equals("") || campoIngri.getText().equals("") || campoModo.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Por favor preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    atual.setCategoria(comboCategoria.getSelectedItem().toString());
                    atual.setIngredientes(campoIngri.getText());
                    atual.setModoDePreparo(campoModo.getText());
                    atual.setNomeDaReceita(campoNome.getText());
                    d.update(atual);
                }
            }
            p.modeloReceita.limpar();
            p.modeloReceita.addListaDeReceita(d.getAllRec());
            p.modeloReceita.filtrarNome("");
            JOptionPane.showMessageDialog(this, "Receita salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }


           
               
}//GEN-LAST:event_jButton1ActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        // TODO add your handling code here:
        try {
            br.ufu.facom.esof.superpimsystem.dao.DAO d = br.ufu.facom.esof.superpimsystem.dao.DAOFactory.getInstance().getDAO(DAOFactory.RECEITA);
            d.delete(atual);
            p.modeloReceita.limpar();
            p.modeloReceita.addListaDeReceita(d.getAllRec());
            p.modeloReceita.filtrarNome("");
            JOptionPane.showMessageDialog(this, "Receita excluida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
         }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
         }
    }//GEN-LAST:event_bExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bExcluir;
    private javax.swing.JTextArea campoIngri;
    private javax.swing.JTextArea campoModo;
    private javax.swing.JTextField campoNome;
    private javax.swing.JComboBox comboCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
