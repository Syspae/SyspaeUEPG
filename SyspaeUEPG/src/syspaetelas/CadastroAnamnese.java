/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package syspaetelas;

import controleConexao.Conexao;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author carlo
 */
public class CadastroAnamnese extends javax.swing.JFrame {
    
    /**
     * Creates new form TelaCadastroAnamnese
     */
    public CadastroAnamnese(int id) {
        initComponents();
        setLocationRelativeTo(null);
        this.setVisible(true);
        buscaAlunos(id);
        data();
        idade();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void idade(){
        LocalDate atual = LocalDate.parse(txtfldDataAnamnese.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate nascimento = LocalDate.parse(txtfldDataNascimento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        Period idade = Period.between(nascimento, atual);
        lblIdade.setText(Integer.toString(idade.getYears()));
    }
    
    private void data(){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime dataAtual = LocalDateTime.now();
        txtfldDataAnamnese.setText(formatador.format(dataAtual));
    }
    
    //Função que coloca o aluno passado pelo atendimento no combobox
    private void buscaAlunos(int id){
        String busca = "Select nome from aluno where idaluno = "+id+"";
        Conexao con = new Conexao();
        ResultSet rs = con.executaBusca(busca);
        try {
            while(rs.next()){
                cmbbxNome.addItem(rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Função que coloca a data de nascimento do aluno selecionado pelo combobox
    private void buscaNascimento(){   
        String buscaNome = "Select data_nascimento from aluno where nome like '"+cmbbxNome.getSelectedItem()+"'";
        Conexao con = new Conexao();
        ResultSet rs = con.executaBusca(buscaNome);
        try {
            while(rs.next()){
                txtfldDataNascimento.setText(formataData(rs.getString("data_nascimento")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Função para o tratamento da data trazida pelo banco
    private String formataData(String data){
        Date novaData = Date.valueOf(data);
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(novaData);        
    }
    
    private boolean validaData(String data){
        LocalDate atual = LocalDate.now();
        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascimento = LocalDate.parse(data, formatador);
        
        return !nascimento.isAfter(atual);
    }
    
    //Função para pegar os campos preenchidos e transformar na SQL pra inserção
    private String preparaSQL(){       
        return "INSERT into anamnese (data_anamnese, doencas_familia, atendimentos_odontologicos, encaminhamentos_para_a_rede,"
                                            + "surdez_leve_ou_moderada, surdez_severa_ou_profunda, baixa_visao, cegueira, deficiencia_fisica,"
                                            + "surdocegueira, ingestao_de_alcool, habito_de_fumar, sindrome_de_down, condutas_tipicas, altas_habilidades_superdotado,"
                                            + "deficiencia_mental, deficiencia_multipla, autismo)"
                                            + "values ('"+txtfldDataAnamnese.getText()+"', '"+txtDoencaFamilia.getText()+"', '"+txtAtendimentosOdonto.getText()+"', '"+txtEncaminhamentos.getText()+"', '"+chckbxSurdezLeveModerada.isSelected()+"', '"+chckbxSurdezSeveraProfunda.isSelected()+"'"
                                            + ", '"+chckbxBaixaVisao.isSelected()+"', '"+chckbxCegueira.isSelected()+"', '"+chckbxDeficienciaFisica.isSelected()+"', '"+chckbxSurdocegueira.isSelected()+"', '"+chckbxIngestaoAlcool.isSelected()+"', '"+chckbxHabitoFumar.isSelected()+"'"
                                            + ", '"+chckbxSindromeDown.isSelected()+"', '"+chckbxCondutasTipicas.isSelected()+"', '"+chckbxAltasHabilidadesSuperdotado.isSelected()+"', '"+chckbxDeficienciaMental.isSelected()+"', '"+chckbxDeficienciaMultipla.isSelected()+"', '"+chckbxAutismo.isSelected()+"'"
                                            + ")";       
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
        btnSalvar = new javax.swing.JButton();
        lblSucesso = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();

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

        btnCancelar.setBackground(new java.awt.Color(242, 242, 242));
        btnCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Sair (1).png"))); // NOI18N
        btnCancelar.setBorder(null);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(242, 242, 242));
        btnSalvar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Salvar.png"))); // NOI18N
        btnSalvar.setBorder(null);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(cmbbxNome, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtfldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDataAnamnese, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtfldDataAnamnese, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDoencaFamilia)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblSucesso)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                                    .addComponent(lblEncaminhamentos, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAtendimentosOdonto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chckbxCegueira)
                                    .addComponent(chckbxBaixaVisao)
                                    .addComponent(chckbxSurdocegueira)
                                    .addComponent(chckbxDeficienciaFisica)
                                    .addComponent(chckbxHabitoFumar)
                                    .addComponent(chckbxIngestaoAlcool)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chckbxSurdezLeveModerada)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblIdade))
                                    .addComponent(chckbxSurdezSeveraProfunda)
                                    .addComponent(chckbxCondutasTipicas)
                                    .addComponent(chckbxSindromeDown)
                                    .addComponent(chckbxDeficienciaMental)
                                    .addComponent(chckbxAltasHabilidadesSuperdotado)
                                    .addComponent(chckbxAutismo)
                                    .addComponent(chckbxDeficienciaMultipla)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btnSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)))
                        .addGap(39, 39, 39))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(lblSucesso))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(btnCancelar))))
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
                                .addGap(28, 28, 28)
                                .addComponent(btnSalvar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblIdade)))
                .addContainerGap(18, Short.MAX_VALUE))
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
        TelaConfirma sair = new TelaConfirma(this, true);
        if(sair.getReturnStatus()==1) this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if(validaData(txtfldDataAnamnese.getText())){
            if(validaData(txtfldDataNascimento.getText())){
                String SQL = preparaSQL();
                Conexao con = new Conexao();        
                int insert = con.executaInsert(SQL);
                if(insert == 1){
                    lblSucesso.setText("Anamnese salva com sucesso!");
                }
            }
        }        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cmbbxNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxNomeActionPerformed
        // TODO add your handling code here:
        buscaNascimento();
    }//GEN-LAST:event_cmbbxNomeActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
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
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSucesso;
    private javax.swing.JTextArea txtAtendimentosOdonto;
    private javax.swing.JTextArea txtDoencaFamilia;
    private javax.swing.JTextArea txtEncaminhamentos;
    private javax.swing.JFormattedTextField txtfldDataAnamnese;
    private javax.swing.JFormattedTextField txtfldDataNascimento;
    // End of variables declaration//GEN-END:variables
}
