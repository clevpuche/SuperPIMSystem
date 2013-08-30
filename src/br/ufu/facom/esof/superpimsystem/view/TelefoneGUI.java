package br.ufu.facom.esof.superpimsystem.view;

import br.ufu.facom.esof.superpimsystem.dao.DAOFactory;
import javax.swing.JOptionPane;
import br.ufu.facom.esof.superpimsystem.model.Uteis;

public class TelefoneGUI extends javax.swing.JFrame {

    Uteis atual;
    Principal p;

    /** Creates new form TelefoneGUI */
    public TelefoneGUI(Principal p) {
        super("Adicionar / Editar Telefones Úteis");
        initComponents();
        setLocationRelativeTo(null);
        bExcluir.setEnabled(false);
        this.p = p;
    }

    public TelefoneGUI(Principal p,Uteis atual) {
        super("Adicionar / Editar Telefones Úteis");
        initComponents();
        setLocationRelativeTo(null);
        this.atual = atual;
        carregarTelefone();
        this.p = p;
    }

    public void carregarTelefone() {
        campoDescricao.setText(atual.getDescricao());
        campoTelefone.setText(atual.getTel());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoTelefone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tel.png"))); // NOI18N
        jLabel1.setText("Adicionar / Editar Telefones Úteis");

        jLabel2.setText("Telefone");

        jLabel3.setText("Descrição");

        campoDescricao.setColumns(20);
        campoDescricao.setRows(5);
        jScrollPane1.setViewportView(campoDescricao);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/addTelefone.png"))); // NOI18N
        jButton1.setText("Salvar");
        jButton1.setPreferredSize(new java.awt.Dimension(130, 60));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sign-Shutdown-icon.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluirTelefone.png"))); // NOI18N
        bExcluir.setText("Excluir");
        bExcluir.setPreferredSize(new java.awt.Dimension(130, 60));
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoTelefone))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(196, 196, 196))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
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
            br.ufu.facom.esof.superpimsystem.dao.DAO d = br.ufu.facom.esof.superpimsystem.dao.DAOFactory.getInstance().getDAO(DAOFactory.UTEIS);
            if (atual == null) {
                if (campoDescricao.getText().equals("") || campoTelefone.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Por favor preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }else{
                    d.salvar(new Uteis(campoDescricao.getText(), campoTelefone.getText()));
                }

            } else {
                if (campoDescricao.getText().equals("") || campoTelefone.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Por favor preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
               }else{
                    atual.setDescricao(campoDescricao.getText());
                    atual.setTel(campoTelefone.getText());
                    d.update(atual);
                }

            }
            p.modeloTelefone.limpar();
            p.modeloTelefone.addListaDeUteis(d.getAllUti());
            p.modeloTelefone.filtrar("");
            JOptionPane.showMessageDialog(this, "Serial/Senha salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        // TODO add your handling code here:
         try {
            br.ufu.facom.esof.superpimsystem.dao.DAO d = br.ufu.facom.esof.superpimsystem.dao.DAOFactory.getInstance().getDAO(DAOFactory.UTEIS);
            d.delete(atual);
            p.modeloTelefone.limpar();
            p.modeloTelefone.addListaDeUteis(d.getAllUti());
            p.modeloTelefone.filtrar("");
            JOptionPane.showMessageDialog(this, "Serial/Senha excluida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
         }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
         }
    }//GEN-LAST:event_bExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bExcluir;
    private javax.swing.JTextArea campoDescricao;
    private javax.swing.JTextField campoTelefone;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
