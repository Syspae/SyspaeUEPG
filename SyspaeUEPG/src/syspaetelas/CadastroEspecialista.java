/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package syspaetelas;

import static java.lang.System.exit;
import static java.time.Clock.system;
import controleConexao.Conexao;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JTextField;

/**
 *
 * @author carlo
 */
public class CadastroEspecialista extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroEspecialista
     */
    
    //Somente números nos TextFields
    public final class JtextFieldSomenteNumeros extends JTextField {
    private int maximoCaracteres=-1;// definição de -1
    // como  valor normal de um textfield sem limite de caracters
    public JtextFieldSomenteNumeros() {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);}});
    }

    public JtextFieldSomenteNumeros(int maximo) {
    super();
    setMaximoCaracteres(maximo);// define o tamanho máximo
    //que deve ser aceito no jtextfield que foi recebido no  construtor

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);}});
    }

    private void jTextFieldKeyTyped(KeyEvent evt) {

    String caracteres="abcdefghijklmnopqrstuvwxyzABCDEFGHUIJKLMNOPQRSTUVWXYZ";// lista de caracters que não devem ser aceitos
    if(caracteres.contains(evt.getKeyChar()+"")){// se o character que gerou o evento estiver na lista
    evt.consume();//aciona esse propriedade para eliminar a ação do evento
    }
    if((getText().length()>=getMaximoCaracteres())&&(getMaximoCaracteres()!=-1)){
    //if para saber se precisa verificar também o tamanho da string do campo
    // maior ou igual ao tamanho máximo, cancela e nao deixa inserir mais
    evt.consume();
    setText(getText().substring(0,getMaximoCaracteres()));
    // esta linha acima é para remover os caracters inválidos caso o usuário tenha copiado o
    //conteúdo de algum lugar ou seja com tamanho maior que o definido
    }//fim do if do tamanho da string do campo

 }
    
    public int getMaximoCaracteres() {
        return maximoCaracteres;
    }
    public void setMaximoCaracteres(int maximoCaracteres) {
        this.maximoCaracteres = maximoCaracteres;
    }
}    
    
    //Somente letras nos TextFields
    public final class JtextFieldSomenteLetras extends JTextField {
    private int maximoCaracteres=-1;// definição de -1
    // como  valor normal de um textfield sem limite de caracters
    public JtextFieldSomenteLetras() {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);}});
    }

    public JtextFieldSomenteLetras(int maximo) {
    super();
    setMaximoCaracteres(maximo);// define o tamanho máximo
    //que deve ser aceito no jtextfield que foi recebido no  construtor

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);}});
    }

    private void jTextFieldKeyTyped(KeyEvent evt) {

    String caracteres="0987654321";// lista de caracters que não devem ser aceitos
    if(caracteres.contains(evt.getKeyChar()+"")){// se o character que gerou o evento estiver na lista
    evt.consume();//aciona esse propriedade para eliminar a ação do evento
    }
    if((getText().length()>=getMaximoCaracteres())&&(getMaximoCaracteres()!=-1)){
    //if para saber se precisa verificar também o tamanho da string do campo
    // maior ou igual ao tamanho máximo, cancela e nao deixa inserir mais
    evt.consume();
    setText(getText().substring(0,getMaximoCaracteres()));
    // esta linha acima é para remover os caracters inválidos caso o usuário tenha copiado o
    //conteúdo de algum lugar ou seja com tamanho maior que o definido
    }//fim do if do tamanho sa string do campo

 }
    
    public int getMaximoCaracteres() {
        return maximoCaracteres;
    }
    public void setMaximoCaracteres(int maximoCaracteres) {
        this.maximoCaracteres = maximoCaracteres;
    }
}
    
    public CadastroEspecialista() {
        initComponents();
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
    }
    
    private String preparaSQL(){
        int id = 0;        
        String busca = "Select idespecialidade from especialidade where nome like '"+cmbbxEspecialidade.getSelectedItem().toString()+"'";            
               
        Conexao con = new Conexao();
        ResultSet rs = con.executaBusca(busca);
        try {
            while(rs.next()){
                id = rs.getInt("idespecialidade");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return "INSERT into profissional (nome, crm, fk_especialidade_idespecialidade) values ('"+txtfldNomeEspecialista.getText()+"', '"+txtfldCRM.getText()+"', '"+id+"')";
    }
    
    private void desabilitaCampos(){
        txtfldNomeEspecialista.setEditable(false);
        cmbbxEspecialidade.setEnabled(false);
        txtfldCRM.setEditable(false);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSucesso = new javax.swing.JLabel();
        lblNomeEspecialista = new javax.swing.JLabel();
        lblEspecialidade = new javax.swing.JLabel();
        txtfldNomeEspecialista = new JtextFieldSomenteLetras(100);
        cmbbxEspecialidade = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        lblCamposObrigatorios = new javax.swing.JLabel();
        lblCRM = new javax.swing.JLabel();
        txtfldCRM = new JtextFieldSomenteNumeros(20);
        lblErro = new javax.swing.JLabel();

        setTitle("Cadastrar Especialista");
        setLocation(new java.awt.Point(400, 200));
        setResizable(false);

        lblSucesso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSucesso.setForeground(new java.awt.Color(38, 151, 0));

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

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblCamposObrigatorios.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCamposObrigatorios.setText("Campos com (*) são obrigatórios");

        lblCRM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCRM.setText("CRM*");

        txtfldCRM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblErro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblErro.setForeground(new java.awt.Color(204, 0, 0));
        lblErro.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblNomeEspecialista))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(txtfldNomeEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblEspecialidade))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(cmbbxEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblCRM))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(txtfldCRM, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblCamposObrigatorios))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lblSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblErro, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(btnSalvar)
                        .addGap(12, 12, 12)
                        .addComponent(btnCancelar)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblNomeEspecialista)
                .addGap(6, 6, 6)
                .addComponent(txtfldNomeEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEspecialidade)
                .addGap(6, 6, 6)
                .addComponent(cmbbxEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCRM)
                .addGap(6, 6, 6)
                .addComponent(txtfldCRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(lblCamposObrigatorios)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblErro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfldNomeEspecialistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldNomeEspecialistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldNomeEspecialistaActionPerformed

    private void cmbbxEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxEspecialidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxEspecialidadeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        CadastroEspecialista.this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:        
        Conexao con = new Conexao();        
        int insert = con.executaInsert(preparaSQL());
        if(insert==1){
                lblErro.setVisible(false);
                lblSucesso.setText("Cadastro efetuado com sucesso!");
                desabilitaCampos();
                btnSalvar.setEnabled(false);
            }
    }//GEN-LAST:event_btnSalvarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbbxEspecialidade;
    private javax.swing.JLabel lblCRM;
    private javax.swing.JLabel lblCamposObrigatorios;
    private javax.swing.JLabel lblErro;
    private javax.swing.JLabel lblEspecialidade;
    private javax.swing.JLabel lblNomeEspecialista;
    private javax.swing.JLabel lblSucesso;
    private javax.swing.JTextField txtfldCRM;
    private javax.swing.JTextField txtfldNomeEspecialista;
    // End of variables declaration//GEN-END:variables
}
