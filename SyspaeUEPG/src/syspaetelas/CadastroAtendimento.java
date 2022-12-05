/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package syspaetelas;

import controleConexao.Conexao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class CadastroAtendimento extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroAtendimento
     */
    public CadastroAtendimento() {
        initComponents();
        setLocationRelativeTo(null);
        this.setVisible(true);
        buscaAlunos();
        buscaProfissional();
        data();
        cmbbxEspecialidade.setEnabled(false);
        btnAnamnese.setEnabled(false);
    }
    
    // Função para pegar e formatar a data atual do sistema
    private void data(){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime dataAtual = LocalDateTime.now();
        txtfldDataAtendimento.setText(formatador.format(dataAtual));
    }
    
    //Função para pegar os alunos cadastrados e colocar no combobox
    private void buscaAlunos(){
        cmbbxAluno.addItem("");
        Conexao con = new Conexao();
        ResultSet rs = con.executaBusca("Select nome from aluno order by nome ASC");
        try {
            while(rs.next()){
                cmbbxAluno.addItem(rs.getString("nome"));
            }
        } catch (Exception ex) {
            Logger.getLogger(CadastroAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String especialidade(String id){
        switch (id) {
            case "1":
                return "Fono";
            case "2":
                return "Fisio";
            case "3":
                return "Psico";
            case "4":
                return "Terapia";
            case "5":
                return "Neuro";
            case "6": 
                return "Odonto";
            case "7":
                return "Nutri";
            default:
                throw new AssertionError();
        }
    }
    
    //Função para pegar os profissionais cadastrados e colocar no combobox
    private void buscaProfissional(){
        cmbbxProfissional.addItem("");
        Conexao con = new Conexao();
        ResultSet rs = con.executaBusca("Select * from profissional order by nome ASC");
        try {
            while(rs.next()){
                cmbbxProfissional.addItem(rs.getString("nome") + " - " + especialidade(rs.getString("fk_especialidade_idespecialidade")));
            }
        } catch (Exception ex) {
            Logger.getLogger(CadastroAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    
    //Função para pegar o ID da especialidade relacionada ao profissional
    private int buscaEspecialidadeID(){
        int id = 0;
        Conexao con = new Conexao();
        ResultSet rs = con.executaBusca("select fk_especialidade_idespecialidade from profissional where nome like '"+cmbbxProfissional.getSelectedItem().toString()+"'");
        try {
            while(rs.next()){
                id = rs.getInt("fk_especialidade_idespecialidade");
            }
        } catch (Exception ex) {
            Logger.getLogger(CadastroAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    //Função para pegar o nome da especialidade baseado no ID
    private void buscaEspecialidadeNome(){
        int id = buscaEspecialidadeID();
        System.out.println(id);
        Conexao con = new Conexao();
        ResultSet rs = con.executaBusca("Select nome_especialidade from especialidade where CAST(idespecialidade AS TEXT) like '"+id+"'");
        try {
            while(rs.next()){
                cmbbxEspecialidade.setText(rs.getString("nome_especialidade"));
            }
        } catch (Exception ex) {
            Logger.getLogger(CadastroAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Função para pegar o ID do aluno selecionado no combobox
    private int idAluno(){        
        Conexao con = new Conexao();
        ResultSet rs = con.executaBusca("Select idaluno from aluno where nome like '"+cmbbxAluno.getSelectedItem().toString()+"'");
        int id = 0;
        try {
            while(rs.next()){
                id = rs.getInt("idaluno");
            }
        } catch (Exception ex) {
             Logger.getLogger(CadastroAtendimento.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return id;
    }
    
    //Função para pegar o ID do profissional selecionado no combobox
    private int idProfissional(){
        Conexao con = new Conexao();
        ResultSet rs = con.executaBusca("Select * from profissional where nome like '"+cmbbxProfissional.getSelectedItem().toString()+"%'");
        int id = 0;
        try {
            while(rs.next()){
                id = rs.getInt("idprofissional");
            }
        } catch (Exception ex) {
             Logger.getLogger(CadastroAtendimento.class.getName()).log(Level.SEVERE, null, ex);                       
        }
        return id;
    }
    
    //Função para desabilitar os campos ao salvar
    private void desabilitaCampos(){
        // Textfield's
        txtfldDataAtendimento.setEditable(false);
        txtMotivoAtendimento.setEditable(false);
        txtDiagnostico.setEditable(false);
        txtTratamento.setEditable(false);
        // Combo box's
        cmbbxAluno.setEnabled(false);        
        cmbbxProfissional.setEnabled(false);
        cmbbxEspecialidade.setEnabled(false);
        // Botões
        btnSalvar.setEnabled(false);
    }
    
    // Função para validar as datas
    private boolean validaData(String data){
        LocalDate atual = LocalDate.now();
        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascimento = LocalDate.parse(data, formatador);
        
        return !nascimento.isAfter(atual);
    }
    
    // Função para inserir a data atual como data de modificação
    private String dataModificacao(){
        LocalDate atual = LocalDate.now();        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatador.format(atual);
    }
    
    // Função para verificar se os campos foram preenchidos corretamente
    private boolean verificaCampos(){
        if(cmbbxAluno.getSelectedItem().toString().isEmpty()){lblErro.setText("Selecione um aluno!"); return false;}
        if(cmbbxProfissional.getSelectedItem().toString().isEmpty()){lblErro.setText("Selecione um profissional!"); return false;}
        return true;
    }
    
    //Função para pegar os campos preenchidos e transformar na SQL pra inserção
    private String preparaSQL(){
        return "Insert into atendimento (data_do_atendimento, motivo_do_atendimento, diagnostico, tratamento, fk_aluno_idaluno, fk_profissional_idprofissional, aluno, profissional, especialidade,datamodificacao) "
                    + "values ('"+txtfldDataAtendimento.getText()+"', '"+txtMotivoAtendimento.getText()+"', '"+txtDiagnostico.getText()+"'"
                    + ", '"+txtTratamento.getText()+"', '"+idAluno()+"', '"+idProfissional()+"', '"+cmbbxAluno.getSelectedItem().toString()+"', "
                    + "'"+cmbbxProfissional.getSelectedItem().toString()+"', '"+cmbbxEspecialidade.getText()+"','"+dataModificacao()+"')";
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSair = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        cmbbxAluno = new javax.swing.JComboBox<>();
        cmbbxProfissional = new javax.swing.JComboBox<>();
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
        lblErro = new javax.swing.JLabel();
        lblSucesso = new javax.swing.JLabel();
        cmbbxEspecialidade = new javax.swing.JTextField();

        setTitle("Cadastrar Atendimento");
        setResizable(false);

        btnSair.setBackground(new java.awt.Color(242, 242, 242));
        btnSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Sair (1).png"))); // NOI18N
        btnSair.setBorder(null);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
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

        cmbbxAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxAluno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbbxAlunoItemStateChanged(evt);
            }
        });

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

        btnAnamnese.setBackground(new java.awt.Color(242, 242, 242));
        btnAnamnese.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAnamnese.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Anamnese.png"))); // NOI18N
        btnAnamnese.setBorder(null);
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

        lblErro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblErro.setForeground(new java.awt.Color(204, 0, 0));
        lblErro.setToolTipText("");

        lblSucesso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSucesso.setForeground(new java.awt.Color(38, 151, 0));

        cmbbxEspecialidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

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
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblAluno)
                                                    .addComponent(lblProfissional))
                                                .addGap(0, 375, Short.MAX_VALUE))
                                            .addComponent(cmbbxAluno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbbxProfissional, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblErro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblEspecialidade)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblDataAtendimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtfldDataAtendimento)
                                            .addComponent(btnSalvar))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(btnAnamnese))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(btnSair))))
                                    .addComponent(cmbbxEspecialidade)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDataAtendimento)
                            .addComponent(lblAluno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbbxAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtfldDataAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAnamnese))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 5, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSair)
                                    .addComponent(btnSalvar)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblErro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnamneseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnamneseActionPerformed
        // Botão para criar uma nova anamnese        
        CadastroAnamnese tela06 = new CadastroAnamnese(idAluno());
    }//GEN-LAST:event_btnAnamneseActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // Botão para salvar o atendimento
        if(validaData(txtfldDataAtendimento.getText())){
            if(verificaCampos()){
                Conexao con = new Conexao();
                int insert = con.executaInsert(preparaSQL());
                if(insert == 1){
                    lblErro.setVisible(false);
                    lblSucesso.setText("Atendimento efetuado com sucesso!");
                    btnAnamnese.setEnabled(true);
                    desabilitaCampos();
                }else lblErro.setText("Erro ao cadastrar atendimento!");
            }
        }        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // Botão para fechar a janela
        if(!cmbbxAluno.getSelectedItem().toString().isBlank() || !btnSalvar.isEnabled()){
        TelaConfirma sair = new TelaConfirma(this, true);
        if(sair.getReturnStatus()==1) this.dispose();
        }else this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void cmbbxProfissionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxProfissionalActionPerformed
        // TODO add your handling code here:
        if(!cmbbxProfissional.getSelectedItem().toString().isBlank()){
        buscaEspecialidadeNome();
        }
    }//GEN-LAST:event_cmbbxProfissionalActionPerformed

    private void cmbbxProfissionalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbbxProfissionalPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbbxProfissionalPropertyChange

    private void cmbbxProfissionalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbxProfissionalItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbbxProfissionalItemStateChanged

    private void cmbbxAlunoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbxAlunoItemStateChanged
        // Função para apenas habilitar o botão da anamnese se houver um aluno selecionado 
        btnAnamnese.setEnabled(true);
        if(cmbbxAluno.getSelectedItem().toString().isBlank())btnAnamnese.setEnabled(false);
    }//GEN-LAST:event_cmbbxAlunoItemStateChanged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnamnese;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbbxAluno;
    private javax.swing.JTextField cmbbxEspecialidade;
    private javax.swing.JComboBox<String> cmbbxProfissional;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAluno;
    private javax.swing.JLabel lblDataAtendimento;
    private javax.swing.JLabel lblDiagnostico;
    private javax.swing.JLabel lblErro;
    private javax.swing.JLabel lblEspecialidade;
    private javax.swing.JLabel lblMotivoAtendimento;
    private javax.swing.JLabel lblProfissional;
    private javax.swing.JLabel lblSucesso;
    private javax.swing.JLabel lblTratamento;
    private javax.swing.JTextArea txtDiagnostico;
    private javax.swing.JTextArea txtMotivoAtendimento;
    private javax.swing.JTextArea txtTratamento;
    private javax.swing.JFormattedTextField txtfldDataAtendimento;
    // End of variables declaration//GEN-END:variables
}
