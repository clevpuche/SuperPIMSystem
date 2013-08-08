

package br.ufu.facom.esof.superpimsystem.view;

import br.ufu.facom.esof.superpimsystem.dao.DAOFactory;
import javax.swing.JOptionPane;
import br.ufu.facom.esof.superpimsystem.control.SerialSenha;


public class SerialGUI extends javax.swing.JFrame {

    SerialSenha atual;
    Principal p;

    /** Creates new form SerialGUI */
    public SerialGUI(Principal p) {
        super("Adicionar / Editar Serial ou Senha");
        initComponents();
        setLocationRelativeTo(null);
        bExcluir.setEnabled(false);
        this.p = p;
    }

        public SerialGUI(Principal p,SerialSenha atual) {
        super("Adicionar / Editar Serial ou Senha");
        initComponents();
        setLocationRelativeTo(null);
        this.atual = atual;
        carregarSerial();
        this.p = p;
    }
        public void carregarSerial(){
            campoComentario.setText(atual.getComentario());
            campoPass.setText(atual.getSenhaSerial());
            campoUser.setText(atual.getUsuarioSoft());
        }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoUser = new javax.swing.JTextField();
        campoPass = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoComentario = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/serial.png"))); // NOI18N
        jLabel1.setText("Adicionar / Editar Seriais ou Senhas");

        jLabel2.setText("Usuário / Software");

        jLabel3.setText("Senha / Serial");

        jLabel4.setText("Comentário");

        campoComentario.setColumns(20);
        campoComentario.setRows(5);
        jScrollPane1.setViewportView(campoComentario);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionarChave.png"))); // NOI18N
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

        bExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluirChave.png"))); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoPass, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoUser, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(239, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(223, 223, 223))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(12, Short.MAX_VALUE))
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
            br.ufu.facom.esof.superpimsystem.dao.DAO d = br.ufu.facom.esof.superpimsystem.dao.DAOFactory.getInstance().getDAO(DAOFactory.SENHA);
            if (atual == null) {

                if (campoUser.getText().equals("") || campoPass.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Por favor preencha o Usuario e a Senha.", "Erro", JOptionPane.ERROR_MESSAGE);
                }else{
                    d.salvar(new SerialSenha(campoUser.getText(), campoPass.getText(), campoComentario.getText()));
                }

            } else {
                if (campoUser.getText().equals("") || campoPass.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Por favor preencha o Usuario e a Senha.", "Erro", JOptionPane.ERROR_MESSAGE);
                }else{
                    atual.setComentario(campoComentario.getText());
                    atual.setSenhaSerial(campoPass.getText());
                    atual.setUsuarioSoft(campoUser.getText());
                    d.update(atual);
                }

            }

            p.modeloSerial.limpar();
            p.modeloSerial.addListaDeSerialSenha(d.getAllSen());
            p.modeloSerial.filtrarSenha("");
            JOptionPane.showMessageDialog(this, "Serial/Senha salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        // TODO add your handling code here:
         try {
            br.ufu.facom.esof.superpimsystem.dao.DAO d = br.ufu.facom.esof.superpimsystem.dao.DAOFactory.getInstance().getDAO(DAOFactory.SENHA);
            d.delete(atual);
              p.modeloSerial.limpar();
            p.modeloSerial.addListaDeSerialSenha(d.getAllSen());
            p.modeloSerial.filtrarSenha("");
            JOptionPane.showMessageDialog(this, "Serial/Senha excluida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
         }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
         }
    }//GEN-LAST:event_bExcluirActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bExcluir;
    private javax.swing.JTextArea campoComentario;
    private javax.swing.JTextField campoPass;
    private javax.swing.JTextField campoUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
