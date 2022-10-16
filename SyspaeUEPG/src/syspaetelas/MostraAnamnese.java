/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package syspaetelas;

import controleConexao.Conexao;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 *
 * @author carlo
 */
public class MostraAnamnese extends javax.swing.JFrame {

    private int idAnamnese;
    /**
     * Creates new form TelaCadastroAnamnese
     */
    public MostraAnamnese(int id) {
        initComponents();
        setLocationRelativeTo(null);
        this.setVisible(true);
        idAnamnese = id;
        mostraItens();
    }

    private String preparaSQL(){
        return "select * from anamnese, aluno where fk_atendimento_idatendimento = '"+idAnamnese+"'";
    }
    
    private String inverteData(String data){
        Date novaData = Date.valueOf(data);
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(novaData); 
    }
    
    private void mostraItens(){
        Conexao con = new Conexao();
        ResultSet rs = con.executaBusca(preparaSQL());
        try {
            while(rs.next()){
                cmbbxNome.addItem(rs.getString("nome"));
                txtfldDataAnamnese.setText(inverteData(rs.getString("data_anamnese")));
                txtDoencaFamilia.setText(rs.getString("doencas_familia"));
                txtAtendimentosOdonto.setText(rs.getString("atendimentos_odontologicos"));
                txtEncaminhamentos.setText(rs.getString("encaminhamentos_para_a_rede"));
                chckbxSurdezLeveModerada.setSelected(rs.getBoolean("surdez_leve_ou_moderada"));
                chckbxSurdezSeveraProfunda.setSelected(rs.getBoolean("surdez_severa_ou_profunda"));
                chckbxBaixaVisao.setSelected(rs.getBoolean("baixa_visao"));
                chckbxCegueira.setSelected(rs.getBoolean("cegueira"));
                chckbxDeficienciaFisica.setSelected(rs.getBoolean("deficiencia_fisica"));
                chckbxSurdocegueira.setSelected(rs.getBoolean("surdocegueira"));
                chckbxIngestaoAlcool.setSelected(rs.getBoolean("intestao_de_alcool"));
                chckbxHabitoFumar.setSelected(rs.getBoolean("habito_de_fumar"));
                chckbxSindromeDown.setSelected(rs.getBoolean("sindrome_de_down"));
                chckbxCondutasTipicas.setSelected(rs.getBoolean("condutas_tipiocas"));
                chckbxAltasHabilidadesSuperdotado.setSelected(rs.getBoolean("altas_habilidades_superdotado"));
                chckbxDeficienciaMental.setSelected(rs.getBoolean("deficiencia_mental"));
                chckbxDeficienciaMultipla.setSelected(rs.getBoolean("deficiencia_multipla"));
                chckbxAutismo.setSelected(rs.getBoolean("autismo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        cmbbxNome = new javax.swing.JComboBox<>();
        lblDoencaFamilia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDoencaFamilia = new javax.swing.JTextArea();
        txtfldDataNascimento = new javax.swing.JFormattedTextField();
        txtfldDataAnamnese = new javax.swing.JFormattedTextField();
        lblDataNascimento = new javax.swing.JLabel();
        lblDataAnamnese = new javax.swing.JLabel();
        lblAtendimentosOdonto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAtendimentosOdonto = new javax.swing.JTextArea();
        lblEncaminhamentos = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtEncaminhamentos = new javax.swing.JTextArea();
        chckbxSurdezSeveraProfunda = new javax.swing.JCheckBox();
        chckbxSurdezLeveModerada = new javax.swing.JCheckBox();
        chckbxBaixaVisao = new javax.swing.JCheckBox();
        chckbxCegueira = new javax.swing.JCheckBox();
        chckbxDeficienciaFisica = new javax.swing.JCheckBox();
        chckbxSurdocegueira = new javax.swing.JCheckBox();
        chckbxIngestaoAlcool = new javax.swing.JCheckBox();
        chckbxHabitoFumar = new javax.swing.JCheckBox();
        chckbxSindromeDown = new javax.swing.JCheckBox();
        chckbxCondutasTipicas = new javax.swing.JCheckBox();
        chckbxAltasHabilidadesSuperdotado = new javax.swing.JCheckBox();
        chckbxDeficienciaMental = new javax.swing.JCheckBox();
        chckbxDeficienciaMultipla = new javax.swing.JCheckBox();
        chckbxAutismo = new javax.swing.JCheckBox();
        btnCancelar = new javax.swing.JButton();
        lblSucesso = new javax.swing.JLabel();

        setTitle("Cadastrar Anamnese");
        setResizable(false);

        lblNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNome.setText("Nome");

        cmbbxNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbxNomeActionPerformed(evt);
            }
        });

        lblDoencaFamilia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDoencaFamilia.setText("Doenças na família");

        txtDoencaFamilia.setColumns(20);
        txtDoencaFamilia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDoencaFamilia.setRows(5);
        jScrollPane1.setViewportView(txtDoencaFamilia);

        try {
            txtfldDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfldDataNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        try {
            txtfldDataAnamnese.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfldDataAnamnese.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblDataNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDataNascimento.setText("Data de Nascimento");

        lblDataAnamnese.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDataAnamnese.setText("Data da Anamnese");

        lblAtendimentosOdonto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblAtendimentosOdonto.setText("Atendimentos odontológicos");

        txtAtendimentosOdonto.setColumns(20);
        txtAtendimentosOdonto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAtendimentosOdonto.setRows(5);
        jScrollPane2.setViewportView(txtAtendimentosOdonto);

        lblEncaminhamentos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEncaminhamentos.setText("Encaminhamentos para a rede");

        txtEncaminhamentos.setColumns(20);
        txtEncaminhamentos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEncaminhamentos.setRows(5);
        jScrollPane3.setViewportView(txtEncaminhamentos);

        chckbxSurdezSeveraProfunda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxSurdezSeveraProfunda.setText("Surdez severa ou profunda");

        chckbxSurdezLeveModerada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxSurdezLeveModerada.setText("Surdez leve ou moderada");
        chckbxSurdezLeveModerada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbxSurdezLeveModeradaActionPerformed(evt);
            }
        });

        chckbxBaixaVisao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxBaixaVisao.setText("Baixa visão");

        chckbxCegueira.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxCegueira.setText("Cegueira");

        chckbxDeficienciaFisica.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxDeficienciaFisica.setText("Deficiência física");
        chckbxDeficienciaFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbxDeficienciaFisicaActionPerformed(evt);
            }
        });

        chckbxSurdocegueira.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxSurdocegueira.setText("Surdocegueira");

        chckbxIngestaoAlcool.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxIngestaoAlcool.setText("Ingestão de álcool");

        chckbxHabitoFumar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxHabitoFumar.setText("Hábito de fumar");
        chckbxHabitoFumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbxHabitoFumarActionPerformed(evt);
            }
        });

        chckbxSindromeDown.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxSindromeDown.setText("Síndrome de Down");

        chckbxCondutasTipicas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxCondutasTipicas.setText("Condutas típicas");

        chckbxAltasHabilidadesSuperdotado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxAltasHabilidadesSuperdotado.setText("Altas habilidades, superdotado");

        chckbxDeficienciaMental.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxDeficienciaMental.setText("Deficiência Mental");

        chckbxDeficienciaMultipla.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxDeficienciaMultipla.setText("Deficiência multípla");
        chckbxDeficienciaMultipla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbxDeficienciaMultiplaActionPerformed(evt);
            }
        });

        chckbxAutismo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxAutismo.setText("Autismo");

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblSucesso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSucesso.setForeground(new java.awt.Color(38, 151, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDoencaFamilia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblNome)
                                                .addGap(0, 329, Short.MAX_VALUE))
                                            .addComponent(cmbbxNome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtfldDataNascimento))
                                        .addGap(35, 35, 35)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblDataAnamnese, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtfldDataAnamnese))))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSucesso)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                                .addComponent(lblEncaminhamentos, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblAtendimentosOdonto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chckbxCegueira)
                            .addComponent(chckbxBaixaVisao)
                            .addComponent(chckbxSurdocegueira)
                            .addComponent(chckbxDeficienciaFisica)
                            .addComponent(chckbxHabitoFumar)
                            .addComponent(chckbxIngestaoAlcool)
                            .addComponent(chckbxSurdezLeveModerada)
                            .addComponent(chckbxSurdezSeveraProfunda)
                            .addComponent(chckbxCondutasTipicas)
                            .addComponent(chckbxSindromeDown)
                            .addComponent(chckbxDeficienciaMental)
                            .addComponent(chckbxAltasHabilidadesSuperdotado)
                            .addComponent(chckbxAutismo)
                            .addComponent(chckbxDeficienciaMultipla))
                        .addGap(69, 69, 69))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblDataNascimento)
                    .addComponent(lblDataAnamnese))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbbxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldDataAnamnese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDoencaFamilia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblAtendimentosOdonto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEncaminhamentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chckbxSurdezLeveModerada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckbxSurdezSeveraProfunda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckbxBaixaVisao)
                        .addGap(8, 8, 8)
                        .addComponent(chckbxCegueira)
                        .addGap(3, 3, 3)
                        .addComponent(chckbxDeficienciaFisica)
                        .addGap(8, 8, 8)
                        .addComponent(chckbxSurdocegueira)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckbxIngestaoAlcool)
                        .addGap(8, 8, 8)
                        .addComponent(chckbxHabitoFumar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckbxSindromeDown)
                        .addGap(8, 8, 8)
                        .addComponent(chckbxCondutasTipicas)
                        .addGap(3, 3, 3)
                        .addComponent(chckbxAltasHabilidadesSuperdotado)
                        .addGap(8, 8, 8)
                        .addComponent(chckbxDeficienciaMental)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckbxDeficienciaMultipla)
                        .addGap(8, 8, 8)
                        .addComponent(chckbxAutismo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(lblSucesso))
                        .addGap(45, 45, 45))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chckbxSurdezLeveModeradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbxSurdezLeveModeradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckbxSurdezLeveModeradaActionPerformed

    private void chckbxDeficienciaFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbxDeficienciaFisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckbxDeficienciaFisicaActionPerformed

    private void chckbxHabitoFumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbxHabitoFumarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckbxHabitoFumarActionPerformed

    private void chckbxDeficienciaMultiplaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbxDeficienciaMultiplaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckbxDeficienciaMultiplaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbbxNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxNomeActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JCheckBox chckbxAltasHabilidadesSuperdotado;
    private javax.swing.JCheckBox chckbxAutismo;
    private javax.swing.JCheckBox chckbxBaixaVisao;
    private javax.swing.JCheckBox chckbxCegueira;
    private javax.swing.JCheckBox chckbxCondutasTipicas;
    private javax.swing.JCheckBox chckbxDeficienciaFisica;
    private javax.swing.JCheckBox chckbxDeficienciaMental;
    private javax.swing.JCheckBox chckbxDeficienciaMultipla;
    private javax.swing.JCheckBox chckbxHabitoFumar;
    private javax.swing.JCheckBox chckbxIngestaoAlcool;
    private javax.swing.JCheckBox chckbxSindromeDown;
    private javax.swing.JCheckBox chckbxSurdezLeveModerada;
    private javax.swing.JCheckBox chckbxSurdezSeveraProfunda;
    private javax.swing.JCheckBox chckbxSurdocegueira;
    private javax.swing.JComboBox<String> cmbbxNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAtendimentosOdonto;
    private javax.swing.JLabel lblDataAnamnese;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblDoencaFamilia;
    private javax.swing.JLabel lblEncaminhamentos;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSucesso;
    private javax.swing.JTextArea txtAtendimentosOdonto;
    private javax.swing.JTextArea txtDoencaFamilia;
    private javax.swing.JTextArea txtEncaminhamentos;
    private javax.swing.JFormattedTextField txtfldDataAnamnese;
    private javax.swing.JFormattedTextField txtfldDataNascimento;
    // End of variables declaration//GEN-END:variables
}
