/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package syspaetelas;

import controleConexao.Conexao;
import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import relatorios.Relatorio;

/**
 *
 * @author carlo
 */
public class MenuInicial extends javax.swing.JFrame {

     
    Conexao con = new Conexao();
    /**
     * Creates new form TelaInicial
     */
    public MenuInicial() {
        initComponents();
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        btn01BuscaEspecialista = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();

        setTitle("Syspae");
        setResizable(false);

        btn01CadAluno.setBackground(new java.awt.Color(242, 242, 242));
        btn01CadAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01CadAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Cadastrar Aluno (3).png"))); // NOI18N
        btn01CadAluno.setBorder(null);
        btn01CadAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01CadAlunoActionPerformed(evt);
            }
        });

        btn01buscarAluno.setBackground(new java.awt.Color(242, 242, 242));
        btn01buscarAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01buscarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Buscar Aluno.png"))); // NOI18N
        btn01buscarAluno.setBorder(null);
        btn01buscarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01buscarAlunoActionPerformed(evt);
            }
        });

        btn01NovoAtend.setBackground(new java.awt.Color(242, 242, 242));
        btn01NovoAtend.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01NovoAtend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Novo Atendimento.png"))); // NOI18N
        btn01NovoAtend.setBorder(null);
        btn01NovoAtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01NovoAtendActionPerformed(evt);
            }
        });

        btn01HistAtend.setBackground(new java.awt.Color(242, 242, 242));
        btn01HistAtend.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01HistAtend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Histórico Atendimento.png"))); // NOI18N
        btn01HistAtend.setBorder(null);
        btn01HistAtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01HistAtendActionPerformed(evt);
            }
        });

        btn01BuscaAnamnese.setBackground(new java.awt.Color(242, 242, 242));
        btn01BuscaAnamnese.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01BuscaAnamnese.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Buscar Anamnese.png"))); // NOI18N
        btn01BuscaAnamnese.setBorder(null);
        btn01BuscaAnamnese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01BuscaAnamneseActionPerformed(evt);
            }
        });

        btn01CadEspecialista.setBackground(new java.awt.Color(242, 242, 242));
        btn01CadEspecialista.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01CadEspecialista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Cadastrar Especialista.png"))); // NOI18N
        btn01CadEspecialista.setBorder(null);
        btn01CadEspecialista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01CadEspecialistaActionPerformed(evt);
            }
        });

        btn01Sair.setBackground(new java.awt.Color(242, 242, 242));
        btn01Sair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Sair.png"))); // NOI18N
        btn01Sair.setBorder(null);
        btn01Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01SairActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tela de Fundo.png"))); // NOI18N

        btn01BuscaEspecialista.setBackground(new java.awt.Color(242, 242, 242));
        btn01BuscaEspecialista.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn01BuscaEspecialista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Buscar Especialista (1).png"))); // NOI18N
        btn01BuscaEspecialista.setBorder(null);
        btn01BuscaEspecialista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01BuscaEspecialistaActionPerformed(evt);
            }
        });

        btnRelatorio.setText("Relatorio");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn01CadAluno)
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
                        .addGap(18, 18, 18)
                        .addComponent(btn01BuscaEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRelatorio)
                        .addGap(82, 82, 82)
                        .addComponent(btn01Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn01BuscaAnamnese, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn01buscarAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn01NovoAtend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn01HistAtend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btn01CadAluno)
                            .addComponent(btn01CadEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn01Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn01BuscaEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRelatorio)
                        .addGap(41, 41, 41)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn01CadAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01CadAlunoActionPerformed
        // TODO add your handling code here:
        CadastroAluno tela01 = new CadastroAluno("cadastro");
    }//GEN-LAST:event_btn01CadAlunoActionPerformed

    private void btn01buscarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01buscarAlunoActionPerformed
        // TODO add your handling code here:
        BuscaAluno tela02 = new BuscaAluno();      
    }//GEN-LAST:event_btn01buscarAlunoActionPerformed

    private void btn01NovoAtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01NovoAtendActionPerformed
        // TODO add your handling code here:
        CadastroAtendimento tela03 = new CadastroAtendimento();
    }//GEN-LAST:event_btn01NovoAtendActionPerformed

    private void btn01HistAtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01HistAtendActionPerformed
        // TODO add your handling code here:
        HistoricoAtendimento tela04 = new HistoricoAtendimento();
    }//GEN-LAST:event_btn01HistAtendActionPerformed

    private void btn01BuscaAnamneseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01BuscaAnamneseActionPerformed
        // TODO add your handling code here:
        BuscaAnamnese tela05 = new BuscaAnamnese();
    }//GEN-LAST:event_btn01BuscaAnamneseActionPerformed

    private void btn01CadEspecialistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01CadEspecialistaActionPerformed
        // TODO add your handling code here:
        CadastroEspecialista tela06 = new CadastroEspecialista();
    }//GEN-LAST:event_btn01CadEspecialistaActionPerformed

    private void btn01SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01SairActionPerformed
        // TODO add your handling code here:        
        TelaConfirma sair = new TelaConfirma(this, true);
        if(sair.getReturnStatus()==1) exit(1);
    }//GEN-LAST:event_btn01SairActionPerformed

    private void btn01BuscaEspecialistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01BuscaEspecialistaActionPerformed
        // TODO add your handling code here:
        BuscaEspecialista tela07 = new BuscaEspecialista();
    }//GEN-LAST:event_btn01BuscaEspecialistaActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        // TODO add your handling code here:
        Relatorio relatorio = new Relatorio();
        try {
            relatorio.geraRelatorio();
        } catch (JRException ex) {
            Logger.getLogger(MenuInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRelatorioActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn01BuscaAnamnese;
    private javax.swing.JButton btn01BuscaEspecialista;
    private javax.swing.JButton btn01CadAluno;
    private javax.swing.JButton btn01CadEspecialista;
    private javax.swing.JButton btn01HistAtend;
    private javax.swing.JButton btn01NovoAtend;
    private javax.swing.JButton btn01Sair;
    private javax.swing.JButton btn01buscarAluno;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
