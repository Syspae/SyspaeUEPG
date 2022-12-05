/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package syspaetelas;

import controleConexao.Conexao;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class MostraAnamnese extends javax.swing.JFrame {

    private int idAnamnese;
    /**
     * Creates new form TelaCadastroAnamnese
     * @param id
     */
    public MostraAnamnese(int id) {
        initComponents();
        setLocationRelativeTo(null);
        this.setVisible(true);
        idAnamnese = id;
        mostraItens();
        txtfldDataAnamnese.setEditable(false);
        txtfldDataNascimento.setEditable(false);
        cmbbxNome.setEnabled(false);
        desabilitaCampos();
        btnEditar.setVisible(true);
    }

    //Função que prepara a string passada como SQL
    private String preparaSQL(){
        return "SELECT * FROM anamnese as anamnese inner join aluno as aluno ON aluno.idaluno = anamnese.fk_aluno_idaluno WHERE idanamnese = '"+idAnamnese+"'";
    }
    
    //Função que formata a data
    private String formataData(String data){
        Date novaData = Date.valueOf(data);
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(novaData); 
    }
    
    //Função que desabilita os campos 
    private void desabilitaCampos(){
        // Textfield's
        txtfldDataNascimento.setEditable(false);
        txtfldDataAnamnese.setEditable(false);
        txtAtendimentosOdonto.setEditable(false);
        txtDoencaFamilia.setEditable(false);
        txtEncaminhamentos.setEditable(false);
        // Combo box's
        cmbbxNome.setEnabled(false);
        // Check box's
        chckbxSurdezLeveModerada.setEnabled(false);
        chckbxSurdezSeveraProfunda.setEnabled(false);
        chckbxBaixaVisao.setEnabled(false);
        chckbxCegueira.setEnabled(false);
        chckbxDeficienciaFisica.setEnabled(false);
        chckbxSurdocegueira.setEnabled(false);
        chckbxIngestaoAlcool.setEnabled(false);
        chckbxHabitoFumar.setEnabled(false);
        chckbxSindromeDown.setEnabled(false);
        chckbxCondutasTipicas.setEnabled(false);
        chckbxAltasHabilidadesSuperdotado.setEnabled(false);
        chckbxDeficienciaMental.setEnabled(false);
        chckbxDeficienciaMultipla.setEnabled(false);
        chckbxAutismo.setEnabled(false);
        btnSalvar.setVisible(false);
        btnEditar.setVisible(true);
    }
    
    // Função para habilitar os campos
    private void habilitaCampos(){
        // Textfield's
        txtfldDataNascimento.setEditable(true);
        txtfldDataAnamnese.setEditable(true);
        txtAtendimentosOdonto.setEditable(true);
        txtDoencaFamilia.setEditable(true);
        txtEncaminhamentos.setEditable(true);
        // Combo box's
        cmbbxNome.setEnabled(true);
        // Check box's
        chckbxSurdezLeveModerada.setEnabled(true);
        chckbxSurdezSeveraProfunda.setEnabled(true);
        chckbxBaixaVisao.setEnabled(true);
        chckbxCegueira.setEnabled(true);
        chckbxDeficienciaFisica.setEnabled(true);
        chckbxSurdocegueira.setEnabled(true);
        chckbxIngestaoAlcool.setEnabled(true);
        chckbxHabitoFumar.setEnabled(true);
        chckbxSindromeDown.setEnabled(true);
        chckbxCondutasTipicas.setEnabled(true);
        chckbxAltasHabilidadesSuperdotado.setEnabled(true);
        chckbxDeficienciaMental.setEnabled(true);
        chckbxDeficienciaMultipla.setEnabled(true);
        chckbxAutismo.setEnabled(true);
        btnEditar.setVisible(false);
        btnSalvar.setVisible(true);
    }
    
    //Função que pega as informações do banco e coloca nos campos
    private void mostraItens(){
        desabilitaCampos();
        Conexao con = new Conexao();
        ResultSet rs = con.executaBusca(preparaSQL());
        try {
            while(rs.next()){
                cmbbxNome.addItem(rs.getString("nome"));
                txtfldDataNascimento.setText(formataData(rs.getString("data_nascimento")));
                txtfldDataAnamnese.setText(formataData(rs.getString("data_anamnese")));
                txtDoencaFamilia.setText(rs.getString("doencas_familia"));
                txtAtendimentosOdonto.setText(rs.getString("atendimentos_odontologicos"));
                txtEncaminhamentos.setText(rs.getString("encaminhamentos_para_a_rede"));
                chckbxSurdezLeveModerada.setSelected(rs.getBoolean("surdez_leve_ou_moderada"));
                chckbxSurdezSeveraProfunda.setSelected(rs.getBoolean("surdez_severa_ou_profunda"));
                chckbxBaixaVisao.setSelected(rs.getBoolean("baixa_visao"));
                chckbxCegueira.setSelected(rs.getBoolean("cegueira"));
                chckbxDeficienciaFisica.setSelected(rs.getBoolean("deficiencia_fisica"));
                chckbxSurdocegueira.setSelected(rs.getBoolean("surdocegueira"));
                chckbxIngestaoAlcool.setSelected(rs.getBoolean("ingestao_de_alcool"));
                chckbxHabitoFumar.setSelected(rs.getBoolean("habito_de_fumar"));
                chckbxSindromeDown.setSelected(rs.getBoolean("sindrome_de_down"));
                chckbxCondutasTipicas.setSelected(rs.getBoolean("condutas_tipicas"));
                chckbxAltasHabilidadesSuperdotado.setSelected(rs.getBoolean("altas_habilidades_superdotado"));
                chckbxDeficienciaMental.setSelected(rs.getBoolean("deficiencia_mental"));
                chckbxDeficienciaMultipla.setSelected(rs.getBoolean("deficiencia_multipla"));
                chckbxAutismo.setSelected(rs.getBoolean("autismo"));
                updatePossivel(rs.getString("datamodificacao"));
            }
        } catch (Exception ex) {
            Logger.getLogger(MostraAnamnese.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    // Função para validar as datas
    private boolean validaData(String data){
        LocalDate atual = LocalDate.now();
        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascimento = LocalDate.parse(data, formatador);
        
        return !nascimento.isAfter(atual);
    }
    
    // Função para verificar se é possivel alterar a anamnese
    private void updatePossivel(String dataModificacao){
        LocalDate atual = LocalDate.now();
        Date dataCriacao = Date.valueOf(dataModificacao);
        Period tempo = Period.between(dataCriacao.toLocalDate(), atual);
        int dias = tempo.getDays();
        if(dias < 3) {
            habilitaCampos();
            btnSalvar.setVisible(true);
        }else {
            desabilitaCampos();
            btnSalvar.setVisible(false);
        }
    }
    
    // Função para preparar a string do update
    private String preparaUpdate(){
        return "UPDATE anamnese SET data_nascimento = '"+txtfldDataNascimento.getText()+"', data_anamnese = '"+txtfldDataAnamnese.getText()+"', doencas_familia = '"+txtDoencaFamilia.getText()+"',"
                + "atendimentos_odontologicos = '"+txtAtendimentosOdonto.getText()+"', encaminhamentos_para_a_rede = '"+txtEncaminhamentos.getText()+"', surdez_leve_ou_moderada = '"+chckbxSurdezLeveModerada.isSelected()+"',"
                + "surdez_severa_ou_profunda = '"+chckbxSurdezSeveraProfunda.isSelected()+"', baixa_visao = '"+chckbxBaixaVisao.isSelected()+"', cegueira = '"+chckbxCegueira.isSelected()+"', deficiencia_fisica = '"+chckbxDeficienciaFisica.isSelected()+"',"
                + "surdocegueira = '"+chckbxSurdocegueira.isSelected()+"', ingestao_de_alcool = '"+chckbxIngestaoAlcool.isSelected()+"', habito_de_fumar = '"+chckbxHabitoFumar.isSelected()+"', sindrome_de_down = '"+chckbxSindromeDown.isSelected()+"',"
                + "condutas_tipicas = '"+chckbxCondutasTipicas.isSelected()+"', altas_habilidades_superdotado = '"+chckbxAltasHabilidadesSuperdotado.isSelected()+"', deficiencia_mental = '"+chckbxDeficienciaMental.isSelected()+"',"
                + "deficiencia_multipla = '"+chckbxDeficienciaMultipla.isSelected()+"', autismo = '"+chckbxAutismo.isSelected()+"' where idanamnese = "+idAnamnese+"";
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
        btnCancelar = new javax.swing.JButton();
        lblSucesso = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
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
        lblIdade = new javax.swing.JLabel();
        lblIdadeAluno = new javax.swing.JLabel();
        chckbxSurdezSeveraProfunda = new javax.swing.JCheckBox();
        chckbxSurdezLeveModerada = new javax.swing.JCheckBox();
        chckbxBaixaVisao = new javax.swing.JCheckBox();
        btnEditar = new javax.swing.JButton();

        setTitle("Anamnese");
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
        txtDoencaFamilia.setToolTipText("Doenças que os familiares possuem ou já possuíram");
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
        txtEncaminhamentos.setToolTipText("Encaminhamento para a rede como o CREAS");
        jScrollPane3.setViewportView(txtEncaminhamentos);

        btnCancelar.setBackground(new java.awt.Color(242, 242, 242));
        btnCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Cancelar.png"))); // NOI18N
        btnCancelar.setBorder(null);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblSucesso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSucesso.setForeground(new java.awt.Color(38, 151, 0));

        btnSalvar.setBackground(new java.awt.Color(242, 242, 242));
        btnSalvar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Salvar.png"))); // NOI18N
        btnSalvar.setBorder(null);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

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
        chckbxDeficienciaMultipla.setText("Deficiência Multípla");
        chckbxDeficienciaMultipla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbxDeficienciaMultiplaActionPerformed(evt);
            }
        });

        chckbxAutismo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxAutismo.setText("Autismo");

        lblIdade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblIdadeAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblIdadeAluno.setText("Idade do Aluno");

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

        btnEditar.setBackground(new java.awt.Color(242, 242, 242));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Editar.png"))); // NOI18N
        btnEditar.setBorder(null);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblNome)
                        .addGap(347, 347, 347)
                        .addComponent(lblDataNascimento)
                        .addGap(35, 35, 35)
                        .addComponent(lblDataAnamnese))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(cmbbxNome, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtfldDataAnamnese, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblDoencaFamilia)
                        .addGap(405, 405, 405)
                        .addComponent(lblIdadeAluno)
                        .addGap(6, 6, 6)
                        .addComponent(lblIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chckbxAltasHabilidadesSuperdotado)
                            .addComponent(chckbxAutismo)
                            .addComponent(chckbxBaixaVisao)
                            .addComponent(chckbxCegueira)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblAtendimentosOdonto)
                        .addGap(232, 232, 232)
                        .addComponent(chckbxCondutasTipicas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chckbxDeficienciaFisica)
                            .addComponent(chckbxDeficienciaMental)
                            .addComponent(chckbxDeficienciaMultipla)
                            .addComponent(chckbxHabitoFumar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblEncaminhamentos)
                        .addGap(216, 216, 216)
                        .addComponent(chckbxIngestaoAlcool))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chckbxSindromeDown)
                            .addComponent(chckbxSurdezLeveModerada)
                            .addComponent(chckbxSurdezSeveraProfunda)
                            .addComponent(chckbxSurdocegueira)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(btnCancelar)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(lblDataNascimento)
                    .addComponent(lblDataAnamnese))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbbxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldDataAnamnese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDoencaFamilia)
                    .addComponent(lblIdadeAluno)
                    .addComponent(lblIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chckbxAltasHabilidadesSuperdotado)
                        .addGap(6, 6, 6)
                        .addComponent(chckbxAutismo)
                        .addGap(6, 6, 6)
                        .addComponent(chckbxBaixaVisao)
                        .addGap(6, 6, 6)
                        .addComponent(chckbxCegueira)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblAtendimentosOdonto))
                    .addComponent(chckbxCondutasTipicas))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(chckbxDeficienciaFisica)
                        .addGap(6, 6, 6)
                        .addComponent(chckbxDeficienciaMental)
                        .addGap(6, 6, 6)
                        .addComponent(chckbxDeficienciaMultipla)
                        .addGap(6, 6, 6)
                        .addComponent(chckbxHabitoFumar)))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEncaminhamentos)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(chckbxIngestaoAlcool)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(chckbxSindromeDown)
                        .addGap(6, 6, 6)
                        .addComponent(chckbxSurdezLeveModerada)
                        .addGap(6, 6, 6)
                        .addComponent(chckbxSurdezSeveraProfunda)
                        .addGap(6, 6, 6)
                        .addComponent(chckbxSurdocegueira)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar)
                            .addComponent(btnSalvar)
                            .addComponent(btnCancelar))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Botão para fechar a janela
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbbxNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxNomeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // Botão para salvar a edição
        if(validaData(txtfldDataAnamnese.getText())){
            if(validaData(txtfldDataNascimento.getText())){
                Conexao con = new Conexao();        
                int insert = con.executaInsert(preparaUpdate());
                if(insert == 1){
                    lblSucesso.setText("Anamnese salva com sucesso!");
                    desabilitaCampos();
                }
            }
        }  
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void chckbxDeficienciaFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbxDeficienciaFisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckbxDeficienciaFisicaActionPerformed

    private void chckbxHabitoFumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbxHabitoFumarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckbxHabitoFumarActionPerformed

    private void chckbxDeficienciaMultiplaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbxDeficienciaMultiplaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckbxDeficienciaMultiplaActionPerformed

    private void chckbxSurdezLeveModeradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbxSurdezLeveModeradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckbxSurdezLeveModeradaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        habilitaCampos();
    }//GEN-LAST:event_btnEditarActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
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
    private javax.swing.JLabel lblIdadeAluno;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSucesso;
    private javax.swing.JTextArea txtAtendimentosOdonto;
    private javax.swing.JTextArea txtDoencaFamilia;
    private javax.swing.JTextArea txtEncaminhamentos;
    private javax.swing.JFormattedTextField txtfldDataAnamnese;
    private javax.swing.JFormattedTextField txtfldDataNascimento;
    // End of variables declaration//GEN-END:variables
}
