/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package syspaetelas;

import static java.lang.System.exit;

/**
 *
 * @author carlo
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn01CadAluno = new javax.swing.JButton();
        btn01buscarAluno = new javax.swing.JButton();
        btn01NovoAtend = new javax.swing.JButton();
        btn01HistAtend = new javax.swing.JButton();
        btn01BuscaAnamnese = new javax.swing.JButton();
        btn01CadEspecialista = new javax.swing.JButton();
        btn01Sair = new javax.swing.JButton();

        setTitle("Syspae");

        btn01CadAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01CadAluno.setText("Cadastrar Aluno");
        btn01CadAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01CadAlunoActionPerformed(evt);
            }
        });

        btn01buscarAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01buscarAluno.setText("Buscar Aluno");
        btn01buscarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01buscarAlunoActionPerformed(evt);
            }
        });

        btn01NovoAtend.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01NovoAtend.setText("Novo Atendimento");
        btn01NovoAtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01NovoAtendActionPerformed(evt);
            }
        });

        btn01HistAtend.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01HistAtend.setText("Histórico de Atendimento");
        btn01HistAtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01HistAtendActionPerformed(evt);
            }
        });

        btn01BuscaAnamnese.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01BuscaAnamnese.setText("Buscar Anamneses");
        btn01BuscaAnamnese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01BuscaAnamneseActionPerformed(evt);
            }
        });

        btn01CadEspecialista.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01CadEspecialista.setText("Cadastrar Especialistas");
        btn01CadEspecialista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01CadEspecialistaActionPerformed(evt);
            }
        });

        btn01Sair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01Sair.setText("Sair");
        btn01Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01SairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btn01CadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn01buscarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn01NovoAtend)
                .addGap(18, 18, 18)
                .addComponent(btn01HistAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn01BuscaAnamnese)
                .addGap(18, 18, 18)
                .addComponent(btn01CadEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                .addComponent(btn01Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn01Sair, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(btn01CadEspecialista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn01BuscaAnamnese, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn01CadAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn01buscarAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn01NovoAtend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn01HistAtend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(378, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn01CadAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01CadAlunoActionPerformed
        // TODO add your handling code here:
        TelaCadastroAluno tela01 = new TelaCadastroAluno();
        tela01.setVisible(true);
    }//GEN-LAST:event_btn01CadAlunoActionPerformed

    private void btn01buscarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01buscarAlunoActionPerformed
        // TODO add your handling code here:
        TelaBuscaAluno tela02 = new TelaBuscaAluno();
        tela02.setVisible(true);
    }//GEN-LAST:event_btn01buscarAlunoActionPerformed

    private void btn01NovoAtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01NovoAtendActionPerformed
        // TODO add your handling code here:
        TelaCadastroAtendimento tela03 = new TelaCadastroAtendimento();
        tela03.setVisible(true);
    }//GEN-LAST:event_btn01NovoAtendActionPerformed

    private void btn01HistAtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01HistAtendActionPerformed
        // TODO add your handling code here:
        TelaHistoricoAtendimento tela04 = new TelaHistoricoAtendimento();
        tela04.setVisible(true);
    }//GEN-LAST:event_btn01HistAtendActionPerformed

    private void btn01BuscaAnamneseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01BuscaAnamneseActionPerformed
        // TODO add your handling code here:
        TelaBuscaAnamnese tela05 = new TelaBuscaAnamnese();
        tela05.setVisible(true);
    }//GEN-LAST:event_btn01BuscaAnamneseActionPerformed

    private void btn01CadEspecialistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01CadEspecialistaActionPerformed
        // TODO add your handling code here:
        TelaCadastroEspecialista tela06 = new TelaCadastroEspecialista();
        tela06.setVisible(true);
    }//GEN-LAST:event_btn01CadEspecialistaActionPerformed

    private void btn01SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01SairActionPerformed
        // TODO add your handling code here:
        exit(0);
    }//GEN-LAST:event_btn01SairActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn01BuscaAnamnese;
    private javax.swing.JButton btn01CadAluno;
    private javax.swing.JButton btn01CadEspecialista;
    private javax.swing.JButton btn01HistAtend;
    private javax.swing.JButton btn01NovoAtend;
    private javax.swing.JButton btn01Sair;
    private javax.swing.JButton btn01buscarAluno;
    // End of variables declaration//GEN-END:variables
}
