/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package syspaetelas;

import controleConexao.Conexao;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author carlo
 */
public class MostraAtendimento extends javax.swing.JFrame {

    private int idAluno;
    
    /**
     * Creates new form TelaCadastroAtendimento
     */
    public MostraAtendimento(int id) {
        initComponents();
        setLocationRelativeTo(null);
        this.setVisible(true);
        idAluno = id;
        mostraItens();
        System.out.println(idAluno);
    }
    
    private String preparaSQL(){
        return "select * from atendimento where CAST(idconsulta AS TEXT) like '"+idAluno+"'";        
    }
    
    private void mostraItens(){
        Conexao con = new Conexao();
        ResultSet rs = con.executaBusca(preparaSQL());
        try {
            while(rs.next()){
                cmbbxAluno.addItem(rs.getString("aluno"));
                txtfldDataAtendimento.setText(inverteData(rs.getDate("data_do_atendimento").toString()));
                cmbbxProfissional.addItem(rs.getString("profissional"));
                cmbbxEspecialidade.addItem(rs.getString("especialidade"));
                txtMotivoAtendimento.setText(rs.getString("motivo_do_atendimento"));
                txtDiagnostico.setText(rs.getString("diagnostico"));
                txtTratamento.setText(rs.getString("tratamento"));
            }
        } catch (Exception e) {
        }
    }
    
    private String inverteData(String data){
        Date novaData = Date.valueOf(data);
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(novaData); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSair = new javax.swing.JButton();
        cmbbxAluno = new javax.swing.JComboBox<>();
        cmbbxProfissional = new javax.swing.JComboBox<>();
        cmbbxEspecialidade = new javax.swing.JComboBox<>();
        txtfldDataAtendimento = new javax.swing.JFormattedTextField();
        lblDataAtendimento = new javax.swing.JLabel();
        lblEspecialidade = new javax.swing.JLabel();
        lblAluno = new javax.swing.JLabel();
        lblProfissional = new javax.swing.JLabel();
        btnAnamnese = new javax.swing.JButton();
        lblMotivoAtendimento = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivoAtendimento = new javax.swing.JTextArea();
        lblDiagnostico = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiagnostico = new javax.swing.JTextArea();
        lblTratamento = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTratamento = new javax.swing.JTextArea();

        setTitle("Cadastrar Atendimento");
        setResizable(false);

        btnSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        cmbbxAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cmbbxProfissional.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxProfissional.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbbxProfissionalItemStateChanged(evt);
            }
        });
        cmbbxProfissional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbxProfissionalActionPerformed(evt);
            }
        });
        cmbbxProfissional.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbbxProfissionalPropertyChange(evt);
            }
        });

        cmbbxEspecialidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        try {
            txtfldDataAtendimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfldDataAtendimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblDataAtendimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDataAtendimento.setText("Data do atendimento");

        lblEspecialidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEspecialidade.setText("Especialidade");

        lblAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblAluno.setText("Aluno");

        lblProfissional.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblProfissional.setText("Profissional");

        btnAnamnese.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAnamnese.setText("Anamnese");
        btnAnamnese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnamneseActionPerformed(evt);
            }
        });

        lblMotivoAtendimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMotivoAtendimento.setText("Motivo do atendimento");

        txtMotivoAtendimento.setColumns(20);
        txtMotivoAtendimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtMotivoAtendimento.setRows(5);
        jScrollPane1.setViewportView(txtMotivoAtendimento);

        lblDiagnostico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDiagnostico.setText("Diagnóstico");

        txtDiagnostico.setColumns(20);
        txtDiagnostico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDiagnostico.setRows(5);
        jScrollPane2.setViewportView(txtDiagnostico);

        lblTratamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTratamento.setText("Tratamento");

        txtTratamento.setColumns(20);
        txtTratamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTratamento.setRows(5);
        jScrollPane3.setViewportView(txtTratamento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTratamento)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblAluno)
                                            .addComponent(lblProfissional))
                                        .addGap(0, 217, Short.MAX_VALUE))
                                    .addComponent(cmbbxAluno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbbxProfissional, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblEspecialidade, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDataAtendimento)
                                        .addGap(135, 135, 135))
                                    .addComponent(cmbbxEspecialidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtfldDataAtendimento)
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAnamnese)
                                            .addComponent(btnSair)))))
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDiagnostico, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMotivoAtendimento, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataAtendimento)
                    .addComponent(lblAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbbxAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldDataAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnamnese))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEspecialidade)
                    .addComponent(lblProfissional))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbbxProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbbxEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblMotivoAtendimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDiagnostico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTratamento)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnamneseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnamneseActionPerformed
        // TODO add your handling code here:
        MostraAnamnese tela06 = new MostraAnamnese();
    }//GEN-LAST:event_btnAnamneseActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void cmbbxProfissionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxProfissionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxProfissionalActionPerformed

    private void cmbbxProfissionalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbbxProfissionalPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxProfissionalPropertyChange

    private void cmbbxProfissionalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbxProfissionalItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxProfissionalItemStateChanged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnamnese;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cmbbxAluno;
    private javax.swing.JComboBox<String> cmbbxEspecialidade;
    private javax.swing.JComboBox<String> cmbbxProfissional;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAluno;
    private javax.swing.JLabel lblDataAtendimento;
    private javax.swing.JLabel lblDiagnostico;
    private javax.swing.JLabel lblEspecialidade;
    private javax.swing.JLabel lblMotivoAtendimento;
    private javax.swing.JLabel lblProfissional;
    private javax.swing.JLabel lblTratamento;
    private javax.swing.JTextArea txtDiagnostico;
    private javax.swing.JTextArea txtMotivoAtendimento;
    private javax.swing.JTextArea txtTratamento;
    private javax.swing.JFormattedTextField txtfldDataAtendimento;
    // End of variables declaration//GEN-END:variables
}
