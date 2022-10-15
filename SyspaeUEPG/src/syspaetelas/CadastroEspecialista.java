/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package syspaetelas;

import static java.lang.System.exit;
import static java.time.Clock.system;
import controleConexao.Conexao;
import java.sql.*;

/**
 *
 * @author carlo
 */
public class CadastroEspecialista extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroEspecialista
     */
    public CadastroEspecialista() {
        initComponents();
        //this.setExtendedState(MAXIMIZED_BOTH);
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

        lblNomeEspecialista = new javax.swing.JLabel();
        lblEspecialidade = new javax.swing.JLabel();
        txtfldNomeEspecialista = new javax.swing.JTextField();
        cmbbxEspecialidade = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblCamposObrigatorios = new javax.swing.JLabel();
        lblCRM = new javax.swing.JLabel();
        txtfldCRM = new javax.swing.JTextField();

        setTitle("Cadastrar Especialista");
        setLocation(new java.awt.Point(500, 200));
        setResizable(false);

        lblNomeEspecialista.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNomeEspecialista.setText("Nome*");

        lblEspecialidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEspecialidade.setText("Especialidade*");

        txtfldNomeEspecialista.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldNomeEspecialista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldNomeEspecialistaActionPerformed(evt);
            }
        });

        cmbbxEspecialidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxEspecialidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Fonoaudiologia", "Fisioterapia", "Psicologia", "Terapia Ocupacional", "Neurologia", "Odontologia", "Nutrição" }));
        cmbbxEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbxEspecialidadeActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblCamposObrigatorios.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCamposObrigatorios.setText("Campos com (*) são obrigatórios");

        lblCRM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCRM.setText("CRM*");

        txtfldCRM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCamposObrigatorios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCRM)
                            .addComponent(lblEspecialidade)
                            .addComponent(lblNomeEspecialista)
                            .addComponent(txtfldNomeEspecialista, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                            .addComponent(txtfldCRM, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbbxEspecialidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblNomeEspecialista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtfldNomeEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEspecialidade)
                .addGap(18, 18, 18)
                .addComponent(cmbbxEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCRM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtfldCRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(lblCamposObrigatorios))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfldNomeEspecialistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldNomeEspecialistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldNomeEspecialistaActionPerformed

    private void cmbbxEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxEspecialidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxEspecialidadeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CadastroEspecialista.this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:        
        String nome = txtfldNomeEspecialista.getText();
        String especialidade = cmbbxEspecialidade.getSelectedItem().toString();
        String crm = txtfldCRM.getText();
        int id = 0;
        
        String busca = "Select idespecialidade from especialidade where nome like '"+especialidade+"'";     
        
               
        Conexao con = new Conexao();
        ResultSet rs = con.executaBusca(busca);
        try {
            while(rs.next()){
                id = rs.getInt("idespecialidade");
            }
        } catch (Exception e) {
        }
        
        String SQL = "INSERT into profissional (nome, crm, fk_especialidade_idespecialidade) values ('"+nome+"', '"+crm+"', '"+id+"')";
        
        con.executaInsert(SQL);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbbxEspecialidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lblCRM;
    private javax.swing.JLabel lblCamposObrigatorios;
    private javax.swing.JLabel lblEspecialidade;
    private javax.swing.JLabel lblNomeEspecialista;
    private javax.swing.JTextField txtfldCRM;
    private javax.swing.JTextField txtfldNomeEspecialista;
    // End of variables declaration//GEN-END:variables
}
