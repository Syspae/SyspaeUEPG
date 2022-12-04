/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package syspaetelas;

import static java.lang.System.exit;
import controleConexao.Conexao;
import java.awt.event.KeyEvent;
import java.lang.System.Logger;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.logging.Level;
import javax.swing.JTextField;

/**
 *
 * @author carlo
 */
public class CadastroAluno extends javax.swing.JFrame {


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
    
    /**
     * Creates new form TelaCadastroAluno
     * @param cadastro
     */
    public CadastroAluno(String cadastro) {
        initComponents();
        setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        txtfldPaisNatural.setText("Brasil");
               
    }
    
    //Função para desabilitar os campos ao salvar
    private void desabilitaCampos(){
            //Checkboxs
            chckbxAtendente.setEnabled(false);
            chckbxAtendimentoEspecializado.setEnabled(false);
            chckbxCarteirasAdaptadas.setEnabled(false);
            chckbxCentroAtendimentoEspecializado.setEnabled(false);
            chckbxComputadoresAdaptados.setEnabled(false);
            chckbxComunicacaoAlternativa.setEnabled(false);
            chckbxInterpreteLibras.setEnabled(false);
            chckbxLivrosAmpliados.setEnabled(false);
            chckbxMuletasBengalas.setEnabled(false);
            chckbxNaPropriaEscola.setEnabled(false);
            chckbxOutraEscola.setEnabled(false);
            chckbxProfessorEspecializado.setEnabled(false);
            chckbxRegleteSoroba.setEnabled(false);
            chckbxUsoCadeiraRodas.setEnabled(false);
            cmbbxEscolariedadeFiliacao1.setEnabled(false);
            cmbbxDocumentoFiliacao1.setEnabled(false);
            cmbbxDocumentoResposavel.setEnabled(false);
            cmbbxEscolariedadeFiliacao2.setEnabled(false);
            cmbbxEstado.setEnabled(false);
            cmbbxEstadoCivil.setEnabled(false);
            cmbbxGrauParentesco.setEnabled(false);
            cmbbxRecebeBPC.setEnabled(false);
            cmbbxRecebeBolsaFamilia.setEnabled(false);
            cmbbxRendaFamiliar.setEnabled(false);
            cmbbxSexo.setEnabled(false);
            cmbbxTipoMoradia.setEnabled(false);
            cmbbxTipoTransporte.setEnabled(false);
            cmbbxUF.setEnabled(false);            
            //txtflds
            fldDataNascimento.setEditable(false);            
            txtfldBairro.setEditable(false);
            txtfldCEP.setEditable(false);
            txtfldCGM.setEditable(false);
            txtfldCPF.setEditable(false);
            txtfldCidade.setEditable(false);
            txtfldComplemento.setEditable(false);
            txtfldDataEmissao.setEditable(false);
            txtfldFiliacao1.setEditable(false);
            txtfldEndereco.setEditable(false);
            txtfldFiliacao1.setEditable(false);
            txtfldFiliacao2.setEditable(false);
            txtfldLivroFolhas.setEditable(false);
            txtfldMatricula.setEditable(false);
            txtfldMunicipio.setEditable(false);
            txtfldNDocumentoFiliacao1.setEditable(false);
            txtfldNDocumentoFiliacao2.setEditable(false);
            txtfldNDocumentoResponsavel.setEditable(false);
            txtfldNascimentoCasamento.setEditable(false);
            txtfldNdaCasa.setEditable(false);
            txtfldNomeCartorio.setEditable(false);
            txtfldNumeroContato.setEditable(false);
            txtfldOrgaoEmissor.setEditable(false);
            txtfldPaisNatural.setEditable(false);
            txtfldRG.setEditable(false);
            txtfldRNE.setEditable(false);
            txtfldResponsavel.setEditable(false);
            txtfldNome.setEditable(false);
            txtfldEmail.setEditable(false);
            //cmbbxs
            cmbbxDocumentoFiliacao2.setEnabled(false);
            cmbbxCorRaca.setEnabled(false);    
            //spnrs
            spnPessoasNaCasa.setEnabled(false);
            //Desativar botão de Salvar
            btnSalvar.setEnabled(false);
    }
    
    //Funções para tratamento de dados para mandar ao banco
    private char estado_civil(){
        switch (cmbbxEstadoCivil.getSelectedItem().toString()) {
            case "--Selecione--":
                return ' ';
            case "Solteiro(a)":
                return 'S';
            case "Casado(a)":
                return 'C';
            case "Divorciado(a)":
                return 'D';
            case "Separado(a)":
                return 'H';
            case "Viúvo(a)":
                return 'V';
            default:
                throw new AssertionError();
        }
    }
    
    private String uf(String qual){
        String getuf = "null";
        if(qual.equals("nat")) getuf = cmbbxUF.getSelectedItem().toString();
        if(qual.equals("atual")) getuf = cmbbxEstado.getSelectedItem().toString();
        switch (getuf) {
            case "--Selecione--":
                return "  ";
            case "Acre":
                return "AC";
            case "Alagoas":
                return "AL";
            case "Amapá":
                return "AP";
            case "Amazonas":
                return "AM";
            case "Bahia":
                return "BH";
            case "Ceará":
                return "CE";
            case "Distrito Federal":
                return "DF";
            case "Espírito Santo":
                return "ES";
            case "Goiás":
                return "GO";
            case "Maranhão":
                return "MA";
            case "Mato Grosso":
                return "MT";
            case "Mato Grosso do Sul":
                return "MS";
            case "Minas Gerais":
                return "MG";
            case "Pará":
                return "PA";
            case "Paraíba":
                return "PB";
            case "Paraná":
                return "PR";
            case "Pernambuco":
                return "PE";
            case "Piauí":
                return "PI";
            case "Rio de Janeiro":
                return "RJ";
            case "Rio Grande do Norte":
                return "RN";
            case "Rio Grande do Sul":
                return "RS";
            case "Rondônia":
                return "RO";
            case "Roraima":
                return "RR";
            case "Santa Catarina":
                return "SC";
            case "São Paulo":
                return "SP";
            case "Sergipe":
                return "SE";
            case "Tocantins":
                return "TO";                
            default:
                throw new AssertionError();
        }
    }
    
    private char transporte(){
        switch (cmbbxTipoTransporte.getSelectedItem().toString()) {
            case "--Selecione--":
                return ' ';
            case "Próprio":
                return 'P';
            case "Escolar Rural":
                return 'R';
            case "Escolar Urbano":
                return 'U';
            default:
                throw new AssertionError();
        }
    }
    
    private char moradia(){
        switch (cmbbxTipoMoradia.getSelectedItem().toString()) {
            case "--Selecione--":
                return ' ';
            case "Própria":
                return 'P';
            case "Alugada":
                return 'A';
            case "Cedida":
                return 'C';
            default:
                throw new AssertionError();
        }
    }
    
    private String renda(){
        switch (cmbbxRendaFamiliar.getSelectedItem().toString()) {
            case "--Selecione--":
                return "   ";
            case "Sem renda":
                return "NaN";
            case "Até 1 sálario mínimo":
                return "at1";
            case "Entre 1 e 3 sálarios mínimos":
                return "1a3";
            case "Entre 3 e 5 sálarios mínimos":
                return "3a5";
            case "Mais de 5 sálarios mínimos":
                return "5ms";                
            default:
                throw new AssertionError();
        }
    }
    
    private char sexo(){
        switch (cmbbxSexo.getSelectedItem().toString()) {
            case "--Selecione--":
                return ' ';
            case "Masculino":
                return 'M';
            case "Feminino":
                return 'F';
            default:
                throw new AssertionError();
        }
    }
    
    private boolean bolsa_familia(){
        switch (cmbbxRecebeBolsaFamilia.getSelectedItem().toString()) {
            case "Não":
                return false;
            case "Sim":
                return true;
            default:
                throw new AssertionError();
        }
    }
    
    private boolean bpc(){
        switch (cmbbxRecebeBPC.getSelectedItem().toString()) {
            case "Não":
                return false;
            case "Sim":
                return true;
            default:
                throw new AssertionError();
        }
    }
    
    private char cor_raca(){
        switch (cmbbxCorRaca.getSelectedItem().toString()) {
            case "--Selecione--":
                return ' ';
            case "Branca":
                return 'B';
            case "Preta":
                return 'P';
            case "Parda":
                return 'R';
            case "Amarela":
                return 'A';
            case "Indígena":
                return 'I';
            default:
                throw new AssertionError();
        }
    }
    
    private boolean validaCpf(String cpf){        
        if (cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999") ||
            (cpf.length() != 11))
            return(false);
        
        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
    }
   
    // Função para validar os campos obrigatorios
    private int validaObrigatorios(){        
        char estado_civil = estado_civil();
        String uf_nat = uf("nat");
        String uf_atual = uf("atual");
        char transporte = transporte();
        char moradia = moradia();
        String renda = renda();
        char sexo = sexo();
        char cor_raca = cor_raca();        
        boolean cpf = validaCpf(txtfldCPF.getText());  
        
        if(txtfldNome.getText().isBlank()){lblErro.setText("Campo obrigatorio Nome não preenchido!"); return 0;}        
        if(cor_raca == ' '){lblErro.setText("Campo obrigatorio Cor/Raça não preenchido!"); return 0;}
        if(fldDataNascimento.getText().equals("  /  /    ")){lblErro.setText("Campo obrigatorio data de nascimento não preenchido!"); return 0;}
        boolean data = validaData(fldDataNascimento.getText());
        if(!data){lblErro.setText("Data Invalida!"); return 0;}
        if(sexo == ' '){lblErro.setText("Campo obrigatorio Sexo não preenchido!"); return 0;}
        if(estado_civil == ' '){lblErro.setText("Campo obrigatorio Estado Civil não preenchido!"); return 0;}
        if(!cpf){lblErro.setText("CPF invalido!"); return 0;}
        if(txtfldMunicipio.getText().isBlank()){lblErro.setText("Campo obrigatorio Naturalidade/Municipio não preenchido!"); return 0;}
        if(uf_nat.equals("  ")){lblErro.setText("Campo obrigatorio UF não preenchido!"); return 0;}
        if(txtfldPaisNatural.getText().isBlank()){lblErro.setText("Campo obrigatorio Pais natural não preenchido!"); return 0;}
        if(txtfldCEP.getText().isBlank()){lblErro.setText("Campo obrigatorio CEP não preenchido!"); return 0;}
        if(txtfldResponsavel.getText().isBlank()){lblErro.setText("Campo obrigatorio Nome do Responsavel não preenchido!"); return 0;}
        if(txtfldNumeroContato.getText().isBlank()){lblErro.setText("Campo obrigatorio Telefone para contato não preenchido!"); return 0;}
        if(txtfldEndereco.getText().isBlank()){lblErro.setText("Campo obrigatorio Endereço não preenchido!"); return 0;}
        if(txtfldNdaCasa.getText().isBlank()){lblErro.setText("Campo obrigatorio Numero da casa não preenchido!"); return 0;}
        if(txtfldBairro.getText().isBlank()){lblErro.setText("Campo obrigatorio Bairro não preenchido!"); return 0;}
        if(txtfldCidade.getText().isBlank()){lblErro.setText("Campo obrigatorio Cidade não preenchido!"); return 0;}
        if(uf_atual.equals("  ")){lblErro.setText("Campo obrigatorio Estado não preenchido!"); return 0;}
        if(transporte == ' '){lblErro.setText("Campo obrigatorio Tipo de Transporte não preenchido!"); return 0;}
        if(moradia == ' '){lblErro.setText("Campo obrigatorio Tipo de Moradia não preenchido!"); return 0;}
        if(renda.equals("   ")){lblErro.setText("Campo obrigatorio Renda Familiar não preenchido!"); return 0;}        
        
        return 1;
}
    
    // Função para validar as datas
    private boolean validaData(String data){
        LocalDate atual = LocalDate.now();
        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascimento = LocalDate.parse(data, formatador);
        
        return !nascimento.isAfter(atual);
    }
    
    // Função para formatar a data de moficação
    private String dataModificacao(){
        LocalDate atual = LocalDate.now();        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatador.format(atual);
    }
    
    //Função para pegar os campos preenchidos e transformar na SQL pra inserção
    private String preparaSQL(){     
        String data_emissao = txtfldDataEmissao.getText();
        String doc_resp = cmbbxDocumentoResposavel.getSelectedItem().toString();
        String grau_parentesco = cmbbxGrauParentesco.getSelectedItem().toString();
        String doc_f1 = cmbbxDocumentoFiliacao1.getSelectedItem().toString();
        String esc_f1 = cmbbxEscolariedadeFiliacao1.getSelectedItem().toString();
        String doc_f2 = cmbbxDocumentoFiliacao2.getSelectedItem().toString();
        String esc_f2 = cmbbxEscolariedadeFiliacao2.getSelectedItem().toString();
        int pessoas_moram_casa = (int) spnPessoasNaCasa.getValue();        
        
        char estado_civil = estado_civil();
        String uf_nat = uf("nat");
        String uf_atual = uf("atual");
        char transporte = transporte();
        char moradia = moradia();
        String renda = renda();
        char sexo = sexo();
        boolean bolsa_familia = bolsa_familia();
        boolean bpc = bpc();
        char cor_raca = cor_raca();
        String dataModificacao = dataModificacao();
               
        if(doc_f1.equals("--Selecione--")) doc_f1 = "NaN";
        if(doc_f2.equals("--Selecione--")) doc_f2 = "NaN";
        if(doc_resp.equals("--Selecione--")) doc_resp= "NaN";
        if(grau_parentesco.equals("--Selecione--")) grau_parentesco = "NaN";
        if(esc_f1.equals("--Selecione--")) esc_f1 = "NaN";
        if(esc_f2.equals("--Selecione--")) esc_f2 = "NaN";
        if(data_emissao.equals("  /  /    ")) data_emissao = "11/11/1111";
        
        String SQL = "INSERT into aluno "
                + "(nome, cgm, municipio_nat, data_nascimento,"
                + "pais_nat, rg, orgao_rg, cpf, rne, certidao_nascimento, livro_folhas,"
                + " nome_cartorio, data_emissao, responsavel, doc_resp, numero_doc_resp, grau_parentesco,"
                + " email_resp, telefone_contato, filiacao_1, doc_f1, num_doc_f1,"
                + " filiacao_2, doc_f2, num_doc_f2, endereco, num_casa, complemento,"
                + " bairro, cidade, cep, estado_civil, uf_nat, escolaridade_f1, escolaridade_f2, uf_atual,"
                + " tipo_transporte, tipo_moradia, renda_familiar, interprete_libras, atendente, professor_especializado_permanente,"
                + " atendimento_educacional_especializado, na_propria_escola, centro_de_atendimento_educacional_especializado,"
                + " uso_de_cadeira_de_rodas, uso_de_muletas_bengalas, livros_ampliados, reglete_soroba_braile,"
                + " carteiras_adaptadas, computadores_adaptados, sexo, materiais_de_comunicacao_alternativa, outra_escola,"
                + " bolsa_familia, bpc, pessoas_na_casa, cor_raca, datamodificacao, inativado)"
                + "values "
                + "('"+txtfldNome.getText()+"', '"+txtfldCGM.getText()+"', '"+txtfldMunicipio.getText()+"', '"+fldDataNascimento.getText()+"'"
                + ", '"+txtfldPaisNatural.getText()+"', '"+txtfldRG.getText()+"', '"+txtfldOrgaoEmissor.getText()+"', '"+txtfldCPF.getText()+"'"
                + ", '"+txtfldRNE.getText()+"', '"+txtfldNascimentoCasamento.getText()+"', '"+txtfldLivroFolhas.getText()+"'"
                + ", '"+txtfldNomeCartorio.getText()+"', '"+data_emissao+"', '"+txtfldResponsavel.getText()+"', '"+doc_resp+"', '"+txtfldNDocumentoResponsavel.getText()+"', '"+grau_parentesco+"'"                       
                + ", '"+txtfldEmail.getText()+"', '"+txtfldNumeroContato.getText()+"', '"+txtfldFiliacao1.getText()+"', '"+doc_f1+"', '"+txtfldNDocumentoFiliacao1.getText()+"', '"+txtfldFiliacao2.getText()+"'"
                + ", '"+doc_f2+"', '"+txtfldNDocumentoFiliacao1.getText()+"', '"+txtfldEndereco.getText()+"', '"+txtfldNdaCasa.getText()+"', '"+txtfldComplemento.getText()+"', '"+txtfldBairro.getText()+"', '"+txtfldCidade.getText()+"'"
                + ", '"+txtfldCEP.getText()+"','"+estado_civil+"', '"+uf_nat+"', '"+esc_f1+"', '"+esc_f2+"', '"+uf_atual+"', '" +transporte+"', '"+moradia+"', '"+renda+"'"
                + ", '"+chckbxInterpreteLibras.isSelected()+"', '"+chckbxAtendente.isSelected()+"', '"+chckbxProfessorEspecializado.isSelected()+"', '"+chckbxAtendimentoEspecializado.isSelected()+"', '"+chckbxNaPropriaEscola.isSelected()+"', '"+chckbxCentroAtendimentoEspecializado.isSelected()+"'"
                + ", '"+chckbxUsoCadeiraRodas.isSelected()+"', '"+chckbxMuletasBengalas.isSelected()+"', '"+chckbxLivrosAmpliados.isSelected()+"', '"+chckbxRegleteSoroba.isSelected()+"', '"+chckbxCarteirasAdaptadas.isSelected()+"', '"+chckbxComputadoresAdaptados.isSelected()+"'"
                + ", '"+sexo+"', '"+chckbxComunicacaoAlternativa.isSelected()+"', '"+chckbxOutraEscola.isSelected()+"', '"+bolsa_familia+"', '"+bpc+"', '"+pessoas_moram_casa+"', '"+cor_raca+"', '"+dataModificacao+"', 'false'"
                + ")" ;
        
        return SQL;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSair = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        txtfldMatricula = new javax.swing.JTextField();
        lblCGM = new javax.swing.JLabel();
        lblNascimento = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblEstadoCivil = new javax.swing.JLabel();
        fldDataNascimento = new javax.swing.JFormattedTextField();
        cmbbxSexo = new javax.swing.JComboBox<>();
        cmbbxEstadoCivil = new javax.swing.JComboBox<>();
        lblCPF = new javax.swing.JLabel();
        txtfldCPF = new javax.swing.JFormattedTextField();
        lblMunicipio = new javax.swing.JLabel();
        lblUF = new javax.swing.JLabel();
        cmbbxUF = new javax.swing.JComboBox<>();
        lblRG = new javax.swing.JLabel();
        lblOrgaoEmissor = new javax.swing.JLabel();
        lblPaisNatual = new javax.swing.JLabel();
        txtfldCEP = new javax.swing.JFormattedTextField();
        lblCEP = new javax.swing.JLabel();
        lblRNE = new javax.swing.JLabel();
        lblResponsavel = new javax.swing.JLabel();
        lblFiliacao1 = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        txtfldEndereco = new javax.swing.JTextField();
        lblNEE = new javax.swing.JLabel();
        chckbxInterpreteLibras = new javax.swing.JCheckBox();
        chckbxAtendente = new javax.swing.JCheckBox();
        chckbxProfessorEspecializado = new javax.swing.JCheckBox();
        chckbxAtendimentoEspecializado = new javax.swing.JCheckBox();
        chckbxNaPropriaEscola = new javax.swing.JCheckBox();
        chckbxOutraEscola = new javax.swing.JCheckBox();
        chckbxCentroAtendimentoEspecializado = new javax.swing.JCheckBox();
        chckbxUsoCadeiraRodas = new javax.swing.JCheckBox();
        chckbxMuletasBengalas = new javax.swing.JCheckBox();
        chckbxLivrosAmpliados = new javax.swing.JCheckBox();
        chckbxRegleteSoroba = new javax.swing.JCheckBox();
        chckbxCarteirasAdaptadas = new javax.swing.JCheckBox();
        chckbxComputadoresAdaptados = new javax.swing.JCheckBox();
        chckbxComunicacaoAlternativa = new javax.swing.JCheckBox();
        btnSalvar = new javax.swing.JButton();
        lblNascimentoCasamento = new javax.swing.JLabel();
        lblLivroFolhas = new javax.swing.JLabel();
        lblDataEmissao = new javax.swing.JLabel();
        lblNomeCartorio = new javax.swing.JLabel();
        cmbbxDocumentoResposavel = new javax.swing.JComboBox<>();
        lblDocumentoResponsavel = new javax.swing.JLabel();
        lblNDocumentoResponsavel = new javax.swing.JLabel();
        cmbbxGrauParentesco = new javax.swing.JComboBox<>();
        lblGrauParentesco = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtfldNumeroContato = new javax.swing.JFormattedTextField();
        lblNumeroContato = new javax.swing.JLabel();
        cmbbxDocumentoFiliacao1 = new javax.swing.JComboBox<>();
        lblDocumentoFiliacao1 = new javax.swing.JLabel();
        lblNDocumentoFiliacao1 = new javax.swing.JLabel();
        cmbbxDocumentoFiliacao2 = new javax.swing.JComboBox<>();
        lblDocumentoFiliacao2 = new javax.swing.JLabel();
        lblNDocumentoFiliacao2 = new javax.swing.JLabel();
        txtfldComplemento = new javax.swing.JTextField();
        txtfldBairro = new javax.swing.JTextField();
        cmbbxEstado = new javax.swing.JComboBox<>();
        lblNdaCasa = new javax.swing.JLabel();
        lblComplemento = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtfldDataEmissao = new javax.swing.JFormattedTextField();
        lblFiliacao2 = new javax.swing.JLabel();
        lblEscolaridadeFiliacao1 = new javax.swing.JLabel();
        cmbbxEscolariedadeFiliacao1 = new javax.swing.JComboBox<>();
        lblTipoTransporte = new javax.swing.JLabel();
        cmbbxTipoTransporte = new javax.swing.JComboBox<>();
        lbllEscolariedadeFiliacao2 = new javax.swing.JLabel();
        cmbbxEscolariedadeFiliacao2 = new javax.swing.JComboBox<>();
        lblTipoMoradia = new javax.swing.JLabel();
        cmbbxTipoMoradia = new javax.swing.JComboBox<>();
        lblRecebeBPC = new javax.swing.JLabel();
        cmbbxRecebeBPC = new javax.swing.JComboBox<>();
        lblRecebeBolsaFamilia = new javax.swing.JLabel();
        cmbbxRecebeBolsaFamilia = new javax.swing.JComboBox<>();
        lblPessoasNaCasa = new javax.swing.JLabel();
        spnPessoasNaCasa = new javax.swing.JSpinner();
        lblRendaFamiliar = new javax.swing.JLabel();
        cmbbxRendaFamiliar = new javax.swing.JComboBox<>();
        txtfldEmail = new javax.swing.JTextField();
        lblCorRaca = new javax.swing.JLabel();
        cmbbxCorRaca = new javax.swing.JComboBox<>();
        lblCampos = new javax.swing.JLabel();
        txtfldNome = new JtextFieldSomenteLetras(100);
        txtfldOrgaoEmissor = new JtextFieldSomenteLetras(5);
        txtfldMunicipio = new JtextFieldSomenteLetras(50);
        txtfldPaisNatural = new JtextFieldSomenteLetras(15);
        txtfldNomeCartorio = new JtextFieldSomenteLetras(150);
        txtfldResponsavel = new JtextFieldSomenteLetras(100);
        txtfldFiliacao1 = new JtextFieldSomenteLetras(100);
        txtfldFiliacao2 = new JtextFieldSomenteLetras(100);
        txtfldCidade = new JtextFieldSomenteLetras(50);
        txtfldCGM = new JtextFieldSomenteNumeros(20);
        txtfldRG = new JtextFieldSomenteNumeros(9);
        txtfldRNE = new JtextFieldSomenteNumeros(15);
        txtfldNascimentoCasamento = new JtextFieldSomenteNumeros(30);
        txtfldNDocumentoResponsavel = new JtextFieldSomenteNumeros(30);
        txtfldNDocumentoFiliacao1 = new JtextFieldSomenteNumeros(30);
        txtfldNDocumentoFiliacao2 = new JtextFieldSomenteNumeros(30);
        txtfldNdaCasa = new JtextFieldSomenteNumeros(6);
        txtfldLivroFolhas = new JtextFieldSomenteNumeros(9);
        lblErro = new javax.swing.JLabel();
        lblSucesso = new javax.swing.JLabel();

        setTitle("Cadastrar Aluno");
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

        lblNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNome.setText("Nome*");

        lblMatricula.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMatricula.setText("Matrícula");

        txtfldMatricula.setEditable(false);
        txtfldMatricula.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldMatricula.setToolTipText("Matrícula gerada automaticamente");
        txtfldMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldMatriculaActionPerformed(evt);
            }
        });

        lblCGM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCGM.setText("CGM");

        lblNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNascimento.setText("Data de Nascimento*");

        lblSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSexo.setText("Sexo*");

        lblEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEstadoCivil.setText("Estado Cívil*");

        try {
            fldDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fldDataNascimento.setToolTipText("Data de Nascimento do Aluno");
        fldDataNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fldDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldDataNascimentoActionPerformed(evt);
            }
        });

        cmbbxSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Feminino", "Masculino" }));
        cmbbxSexo.setToolTipText("Sexo do Aluno");
        cmbbxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbxSexoActionPerformed(evt);
            }
        });

        cmbbxEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Casado(a)", "Divorciado(a)", "Separado(a)", "Solteiro(a)", "Viúvo(a)" }));
        cmbbxEstadoCivil.setToolTipText("Estado Civil do Aluno");

        lblCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCPF.setText("CPF*");

        try {
            txtfldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfldCPF.setToolTipText("CPF do Aluno");
        txtfldCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblMunicipio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMunicipio.setText("Naturalidade/Município*");

        lblUF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUF.setText("UF*");

        cmbbxUF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceara", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));
        cmbbxUF.setToolTipText("Estado de Naturalidade do Aluno");
        cmbbxUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbxUFActionPerformed(evt);
            }
        });

        lblRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRG.setText("Carteira de Identidade RG");

        lblOrgaoEmissor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblOrgaoEmissor.setText("Órgão Emissor");

        lblPaisNatual.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPaisNatual.setText("País Natural*");

        try {
            txtfldCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfldCEP.setToolTipText("CEP de endereço do Aluno");
        txtfldCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCEP.setText("CEP*");

        lblRNE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRNE.setText("RNE");

        lblResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblResponsavel.setText("Nome do Responsável*");

        lblFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFiliacao1.setText("Filiação 1");

        lblEndereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEndereco.setText("Endereço*");

        txtfldEndereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldEndereco.setToolTipText("Endereço do Aluno (Logradouro)");

        lblNEE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNEE.setText("Necessidades Educacionais Especiais");

        chckbxInterpreteLibras.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxInterpreteLibras.setText("Interprete de Libras");
        chckbxInterpreteLibras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbxInterpreteLibrasActionPerformed(evt);
            }
        });

        chckbxAtendente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxAtendente.setText("Atendente");

        chckbxProfessorEspecializado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxProfessorEspecializado.setText("Professor Especializado Permanente");

        chckbxAtendimentoEspecializado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxAtendimentoEspecializado.setText("Atendimento Educacional Especializado");

        chckbxNaPropriaEscola.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxNaPropriaEscola.setText("Na própria escola");

        chckbxOutraEscola.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxOutraEscola.setText("Outra escola");
        chckbxOutraEscola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbxOutraEscolaActionPerformed(evt);
            }
        });

        chckbxCentroAtendimentoEspecializado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxCentroAtendimentoEspecializado.setText("Centro de Atendimento Educacional Especializado");

        chckbxUsoCadeiraRodas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxUsoCadeiraRodas.setText("Uso de Cadeira de Rodas");

        chckbxMuletasBengalas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxMuletasBengalas.setText("Uso de Muletas, Bengalas, etc");
        chckbxMuletasBengalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbxMuletasBengalasActionPerformed(evt);
            }
        });

        chckbxLivrosAmpliados.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxLivrosAmpliados.setText("Livros Ampliados");

        chckbxRegleteSoroba.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxRegleteSoroba.setText("Reglete, Sorobã, Braile");

        chckbxCarteirasAdaptadas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxCarteirasAdaptadas.setText("Carteiras Adaptadas");

        chckbxComputadoresAdaptados.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxComputadoresAdaptados.setText("Computadores Adaptados");

        chckbxComunicacaoAlternativa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckbxComunicacaoAlternativa.setText("Materiais de Comunicação Alternativa e Adaptada");

        btnSalvar.setBackground(new java.awt.Color(242, 242, 242));
        btnSalvar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Salvar.png"))); // NOI18N
        btnSalvar.setBorder(null);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblNascimentoCasamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNascimentoCasamento.setText("Certidão de Nascimento/Casamento");

        lblLivroFolhas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblLivroFolhas.setText("Livro/Folhas");

        lblDataEmissao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDataEmissao.setText("Data de Emissão");

        lblNomeCartorio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNomeCartorio.setText("Nome do Cartório/UF");

        cmbbxDocumentoResposavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxDocumentoResposavel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "CNH", "CPF", "RG", "RNE", "Outro" }));
        cmbbxDocumentoResposavel.setToolTipText("Tipo de Documento do Responsável");

        lblDocumentoResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDocumentoResponsavel.setText("Documento");

        lblNDocumentoResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNDocumentoResponsavel.setText("Número");

        cmbbxGrauParentesco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxGrauParentesco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Avô(ó)", "Bisavô(ó)", "Bisneto(a)", "Filho(a)", "Irmão(ã)", "Mãe", "Neto(a)", "Pai", "Sobrinho(a)", "Tio(a)", "Outro" }));
        cmbbxGrauParentesco.setToolTipText("Grau de Parentesco do Responsável");

        lblGrauParentesco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblGrauParentesco.setText("Grau de Parentesco");

        lblEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEmail.setText("Email");

        try {
            txtfldNumeroContato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfldNumeroContato.setToolTipText("Telefone para Contato com o Responsável");
        txtfldNumeroContato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldNumeroContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldNumeroContatoActionPerformed(evt);
            }
        });

        lblNumeroContato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNumeroContato.setText("Telefone para Contato*");

        cmbbxDocumentoFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxDocumentoFiliacao1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "CNH", "CPF", "RG", "RNE", "Outro" }));
        cmbbxDocumentoFiliacao1.setToolTipText("Tipo de Documento da Filiação 1");
        cmbbxDocumentoFiliacao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbxDocumentoFiliacao1ActionPerformed(evt);
            }
        });

        lblDocumentoFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDocumentoFiliacao1.setText("Documento");

        lblNDocumentoFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNDocumentoFiliacao1.setText("Número");

        cmbbxDocumentoFiliacao2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxDocumentoFiliacao2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "CNH", "CPF", "RG", "RNE", "Outro" }));
        cmbbxDocumentoFiliacao2.setToolTipText("Tipo de Documento da Filiação 2");

        lblDocumentoFiliacao2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDocumentoFiliacao2.setText("Documento");

        lblNDocumentoFiliacao2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNDocumentoFiliacao2.setText("Número");

        txtfldComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldComplemento.setToolTipText("Complemento do Endereço");

        txtfldBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldBairro.setToolTipText("Bairro do Endereço");
        txtfldBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldBairroActionPerformed(evt);
            }
        });

        cmbbxEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceara", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));
        cmbbxEstado.setToolTipText("Estado do Endereço");
        cmbbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbxEstadoActionPerformed(evt);
            }
        });

        lblNdaCasa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNdaCasa.setText("Número da casa*");

        lblComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblComplemento.setText("Complemento");

        lblBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblBairro.setText("Bairro*");

        lblCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCidade.setText("Cidade*");

        lblEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEstado.setText("Estado*");

        try {
            txtfldDataEmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfldDataEmissao.setToolTipText("Data de Emissão da Certidão");
        txtfldDataEmissao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblFiliacao2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFiliacao2.setText("Filiação 2");

        lblEscolaridadeFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEscolaridadeFiliacao1.setText("Escolariedade Filiação  1");

        cmbbxEscolariedadeFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxEscolariedadeFiliacao1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Analfabeto", "Até 5º Ano Incompleto", "5º Ano Completo", "6º ao 9º Ano do Fundamental", "Fundamental Completo", "Médio Incompleto", "Médio Completo", "Superior Incompleto", "Superior Completo", "Mestrado", "Doutorado", "Ignorado" }));

        lblTipoTransporte.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTipoTransporte.setText("Tipo de Transporte*");

        cmbbxTipoTransporte.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxTipoTransporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Escolar Urbano", "Escolar Rural", "Próprio" }));

        lbllEscolariedadeFiliacao2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbllEscolariedadeFiliacao2.setText("Escolariedade Filiação 2");

        cmbbxEscolariedadeFiliacao2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxEscolariedadeFiliacao2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Analfabeto", "Até 5º Ano Incompleto", "5º Ano Completo", "6º ao 9º Ano do Fundamental", "Fundamental Completo", "Médio Incompleto", "Médio Completo", "Superior Incompleto", "Superior Completo", "Mestrado", "Doutorado", "Ignorado" }));
        cmbbxEscolariedadeFiliacao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbxEscolariedadeFiliacao2ActionPerformed(evt);
            }
        });

        lblTipoMoradia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTipoMoradia.setText("Tipo de Moradia*");

        cmbbxTipoMoradia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxTipoMoradia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Alugada", "Cedida", "Própria" }));

        lblRecebeBPC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRecebeBPC.setText("Recebe BPC?");

        cmbbxRecebeBPC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxRecebeBPC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        cmbbxRecebeBPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbxRecebeBPCActionPerformed(evt);
            }
        });

        lblRecebeBolsaFamilia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRecebeBolsaFamilia.setText("Recebe Bolsa Familia?");

        cmbbxRecebeBolsaFamilia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxRecebeBolsaFamilia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        cmbbxRecebeBolsaFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbxRecebeBolsaFamiliaActionPerformed(evt);
            }
        });

        lblPessoasNaCasa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPessoasNaCasa.setText("Quantas pessoas moram na casa?*");

        spnPessoasNaCasa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spnPessoasNaCasa.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnPessoasNaCasa.setToolTipText("Quantidade de pessoas na casa contando com o aluno");

        lblRendaFamiliar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRendaFamiliar.setText("Renda Familiar*");

        cmbbxRendaFamiliar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxRendaFamiliar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Sem renda", "Até 1 sálario mínimo", "Entre 1 e 3 sálarios mínimos", "Entre 3 e 5 sálarios mínimos", "Mais de 5 sálarios mínimos" }));
        cmbbxRendaFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbxRendaFamiliarActionPerformed(evt);
            }
        });

        txtfldEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldEmail.setToolTipText("Email do Responsável");
        txtfldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldEmailActionPerformed(evt);
            }
        });

        lblCorRaca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCorRaca.setText("Cor/Raça*");

        cmbbxCorRaca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxCorRaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Amarela", "Branca", "Indígena", "Parda", "Preta" }));
        cmbbxCorRaca.setToolTipText("Cor/Raça do aluno");

        lblCampos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCampos.setText("Campos com (*) são obrigatórios");

        txtfldNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldNome.setToolTipText("Nome do Aluno");
        txtfldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldNomeActionPerformed(evt);
            }
        });

        txtfldOrgaoEmissor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldOrgaoEmissor.setToolTipText("Órgão Emissor do RG");

        txtfldMunicipio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldMunicipio.setToolTipText("Município de Naturalidade do Aluno");

        txtfldPaisNatural.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldPaisNatural.setToolTipText("País de Naturalidade do Aluno");

        txtfldNomeCartorio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldNomeCartorio.setToolTipText("Nome do Cartório em que foi emitida a certidão");

        txtfldResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldResponsavel.setToolTipText("Nome do Responsável pelo Aluno");

        txtfldFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldFiliacao1.setToolTipText("Nome da Filiação 1");

        txtfldFiliacao2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldFiliacao2.setToolTipText("Nome da Filiação 2");

        txtfldCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldCidade.setToolTipText("Cidade do Endereço");

        txtfldCGM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldCGM.setToolTipText("Código Geral de Matrícula do Aluno");

        txtfldRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldRG.setToolTipText("Carteira de Identidade do Aluno");
        txtfldRG.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtfldRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldRGActionPerformed(evt);
            }
        });

        txtfldRNE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldRNE.setToolTipText("Registro Nacional Estrangeiro (caso aluno seja estrangeiro)");

        txtfldNascimentoCasamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldNascimentoCasamento.setToolTipText("Certidão de Casamento ou Nascimento do Aluno");

        txtfldNDocumentoResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldNDocumentoResponsavel.setToolTipText("Número do Documento do Responsável");

        txtfldNDocumentoFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldNDocumentoFiliacao1.setToolTipText("Número do Documento da Filiação 1");

        txtfldNDocumentoFiliacao2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldNDocumentoFiliacao2.setToolTipText("Número do Documento da Filiação 2");

        txtfldNdaCasa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldNdaCasa.setToolTipText("Número da casa");

        txtfldLivroFolhas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldLivroFolhas.setToolTipText("Livro e Folhas da Certidão");

        lblErro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblErro.setForeground(new java.awt.Color(204, 0, 0));
        lblErro.setToolTipText("");

        lblSucesso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSucesso.setForeground(new java.awt.Color(38, 151, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblMatricula)
                        .addGap(81, 81, 81)
                        .addComponent(lblNome)
                        .addGap(392, 392, 392)
                        .addComponent(lblCorRaca)
                        .addGap(87, 87, 87)
                        .addComponent(lblCGM)
                        .addGap(108, 108, 108)
                        .addComponent(lblNascimento)
                        .addGap(18, 18, 18)
                        .addComponent(lblSexo)
                        .addGap(115, 115, 115)
                        .addComponent(lblEstadoCivil))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtfldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbbxCorRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldCGM, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblCPF)
                        .addGap(135, 135, 135)
                        .addComponent(lblRG)
                        .addGap(18, 18, 18)
                        .addComponent(lblOrgaoEmissor)
                        .addGap(126, 126, 126)
                        .addComponent(lblMunicipio)
                        .addGap(109, 109, 109)
                        .addComponent(lblUF)
                        .addGap(161, 161, 161)
                        .addComponent(lblPaisNatual)
                        .addGap(120, 120, 120)
                        .addComponent(lblCEP))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtfldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldRG, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldOrgaoEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbbxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldPaisNatural, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblRNE)
                        .addGap(140, 140, 140)
                        .addComponent(lblNascimentoCasamento)
                        .addGap(90, 90, 90)
                        .addComponent(lblLivroFolhas)
                        .addGap(45, 45, 45)
                        .addComponent(lblDataEmissao)
                        .addGap(36, 36, 36)
                        .addComponent(lblNomeCartorio))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtfldRNE, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(txtfldNascimentoCasamento, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldLivroFolhas, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldNomeCartorio, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblResponsavel)
                        .addGap(286, 286, 286)
                        .addComponent(lblDocumentoResponsavel)
                        .addGap(63, 63, 63)
                        .addComponent(lblNDocumentoResponsavel)
                        .addGap(104, 104, 104)
                        .addComponent(lblGrauParentesco)
                        .addGap(18, 18, 18)
                        .addComponent(lblEmail)
                        .addGap(238, 238, 238)
                        .addComponent(lblNumeroContato, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtfldResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbbxDocumentoResposavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldNDocumentoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbbxGrauParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtfldNumeroContato, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblFiliacao1)
                        .addGap(331, 331, 331)
                        .addComponent(lblDocumentoFiliacao1)
                        .addGap(63, 63, 63)
                        .addComponent(lblNDocumentoFiliacao1)
                        .addGap(104, 104, 104)
                        .addComponent(lblFiliacao2)
                        .addGap(205, 205, 205)
                        .addComponent(lblDocumentoFiliacao2)
                        .addGap(87, 87, 87)
                        .addComponent(lblNDocumentoFiliacao2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtfldFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbbxDocumentoFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldNDocumentoFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbbxDocumentoFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldNDocumentoFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblEndereco)
                        .addGap(267, 267, 267)
                        .addComponent(lblNdaCasa)
                        .addGap(18, 18, 18)
                        .addComponent(lblComplemento)
                        .addGap(134, 134, 134)
                        .addComponent(lblBairro)
                        .addGap(138, 138, 138)
                        .addComponent(lblCidade)
                        .addGap(225, 225, 225)
                        .addComponent(lblEstado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtfldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldNdaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(cmbbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(lblNEE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(chckbxInterpreteLibras)
                        .addGap(205, 205, 205)
                        .addComponent(chckbxUsoCadeiraRodas)
                        .addGap(266, 266, 266)
                        .addComponent(lblTipoTransporte)
                        .addGap(24, 24, 24)
                        .addComponent(lblEscolaridadeFiliacao1)
                        .addGap(18, 18, 18)
                        .addComponent(lblRecebeBolsaFamilia))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(chckbxAtendente)
                        .addGap(264, 264, 264)
                        .addComponent(chckbxMuletasBengalas)
                        .addGap(238, 238, 238)
                        .addComponent(cmbbxTipoTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(cmbbxEscolariedadeFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbbxRecebeBolsaFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(chckbxProfessorEspecializado)
                        .addGap(97, 97, 97)
                        .addComponent(chckbxLivrosAmpliados)
                        .addGap(322, 322, 322)
                        .addComponent(lblTipoMoradia)
                        .addGap(43, 43, 43)
                        .addComponent(lbllEscolariedadeFiliacao2)
                        .addGap(22, 22, 22)
                        .addComponent(lblRecebeBPC))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(chckbxAtendimentoEspecializado)
                        .addGap(79, 79, 79)
                        .addComponent(chckbxRegleteSoroba)
                        .addGap(282, 282, 282)
                        .addComponent(cmbbxTipoMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(cmbbxEscolariedadeFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbbxRecebeBPC, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chckbxNaPropriaEscola)
                            .addComponent(chckbxOutraEscola))
                        .addGap(218, 218, 218)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chckbxCarteirasAdaptadas)
                            .addComponent(chckbxComputadoresAdaptados))
                        .addGap(264, 264, 264)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPessoasNaCasa)
                            .addComponent(spnPessoasNaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRendaFamiliar)
                            .addComponent(cmbbxRendaFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chckbxCentroAtendimentoEspecializado)
                            .addComponent(lblCampos))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chckbxComunicacaoAlternativa)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErro, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(lblSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMatricula)
                    .addComponent(lblNome)
                    .addComponent(lblCorRaca)
                    .addComponent(lblCGM)
                    .addComponent(lblNascimento)
                    .addComponent(lblSexo)
                    .addComponent(lblEstadoCivil))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbbxCorRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldCGM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCPF)
                    .addComponent(lblRG)
                    .addComponent(lblOrgaoEmissor)
                    .addComponent(lblMunicipio)
                    .addComponent(lblUF)
                    .addComponent(lblPaisNatual)
                    .addComponent(lblCEP))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldOrgaoEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbbxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldPaisNatural, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRNE)
                    .addComponent(lblNascimentoCasamento)
                    .addComponent(lblLivroFolhas)
                    .addComponent(lblDataEmissao)
                    .addComponent(lblNomeCartorio))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfldRNE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldNascimentoCasamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldLivroFolhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldNomeCartorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResponsavel)
                    .addComponent(lblDocumentoResponsavel)
                    .addComponent(lblNDocumentoResponsavel)
                    .addComponent(lblGrauParentesco)
                    .addComponent(lblEmail)
                    .addComponent(lblNumeroContato))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfldResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbbxDocumentoResposavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldNDocumentoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbbxGrauParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldNumeroContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFiliacao1)
                    .addComponent(lblDocumentoFiliacao1)
                    .addComponent(lblNDocumentoFiliacao1)
                    .addComponent(lblFiliacao2)
                    .addComponent(lblDocumentoFiliacao2)
                    .addComponent(lblNDocumentoFiliacao2))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfldFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbbxDocumentoFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldNDocumentoFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbbxDocumentoFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldNDocumentoFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEndereco)
                    .addComponent(lblNdaCasa)
                    .addComponent(lblComplemento)
                    .addComponent(lblBairro)
                    .addComponent(lblCidade)
                    .addComponent(lblEstado))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldNdaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(lblNEE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chckbxInterpreteLibras)
                    .addComponent(chckbxUsoCadeiraRodas)
                    .addComponent(lblTipoTransporte)
                    .addComponent(lblEscolaridadeFiliacao1)
                    .addComponent(lblRecebeBolsaFamilia))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cmbbxTipoTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cmbbxEscolariedadeFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cmbbxRecebeBolsaFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chckbxAtendente)
                            .addComponent(chckbxMuletasBengalas))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chckbxProfessorEspecializado)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(chckbxLivrosAmpliados))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblTipoMoradia))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbllEscolariedadeFiliacao2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblRecebeBPC)))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(chckbxAtendimentoEspecializado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(chckbxRegleteSoroba))
                    .addComponent(cmbbxTipoMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbbxEscolariedadeFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbbxRecebeBPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chckbxNaPropriaEscola)
                        .addGap(6, 6, 6)
                        .addComponent(chckbxOutraEscola))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(chckbxCarteirasAdaptadas)
                        .addGap(6, 6, 6)
                        .addComponent(chckbxComputadoresAdaptados))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblPessoasNaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnPessoasNaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblRendaFamiliar)
                        .addGap(6, 6, 6)
                        .addComponent(cmbbxRendaFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chckbxCentroAtendimentoEspecializado)
                        .addGap(12, 12, 12)
                        .addComponent(lblCampos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chckbxComunicacaoAlternativa)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblErro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvar)
                            .addComponent(btnSair))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // Botão para fechar a janela
        TelaConfirma sair = new TelaConfirma(this, true);
        if(sair.getReturnStatus()==1) this.dispose(); 
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtfldMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldMatriculaActionPerformed

    private void txtfldBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldBairroActionPerformed

    private void cmbbxUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxUFActionPerformed

    private void chckbxInterpreteLibrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbxInterpreteLibrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckbxInterpreteLibrasActionPerformed

    private void chckbxOutraEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbxOutraEscolaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckbxOutraEscolaActionPerformed

    private void chckbxMuletasBengalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbxMuletasBengalasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckbxMuletasBengalasActionPerformed

    private void cmbbxRecebeBolsaFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxRecebeBolsaFamiliaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxRecebeBolsaFamiliaActionPerformed

    private void cmbbxEscolariedadeFiliacao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxEscolariedadeFiliacao2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxEscolariedadeFiliacao2ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // Botão para salvar os dados do aluno
        int valida = validaObrigatorios();
        if(valida==1){
            Conexao con = new Conexao();        
            int insert = con.executaInsert(preparaSQL());     

            //Colocar ID na tela
            String id = null; 
            String sqlbusca = "SELECT currval(pg_get_serial_sequence('aluno','idaluno'))";
            ResultSet rs = con.executaBusca(sqlbusca);
            try {
                while(rs.next()){
                    id = rs.getString(1);
                }
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtfldMatricula.setText(id);      

            if(insert==1){
                lblErro.setVisible(false);
                lblSucesso.setText("Cadastro efetuado com sucesso!");
                desabilitaCampos();
                dispose();                
                CadastroAluno tela02 = new CadastroAluno("cadastro");
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void fldDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldDataNascimentoActionPerformed

    private void cmbbxRendaFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxRendaFamiliarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxRendaFamiliarActionPerformed

    private void txtfldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldNomeActionPerformed

    private void cmbbxRecebeBPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxRecebeBPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxRecebeBPCActionPerformed

    private void cmbbxDocumentoFiliacao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxDocumentoFiliacao1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxDocumentoFiliacao1ActionPerformed

    private void cmbbxSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxSexoActionPerformed

    private void txtfldNumeroContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldNumeroContatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldNumeroContatoActionPerformed

    private void txtfldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldEmailActionPerformed

    private void cmbbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxEstadoActionPerformed

    private void txtfldRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldRGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldRGActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chckbxAtendente;
    private javax.swing.JCheckBox chckbxAtendimentoEspecializado;
    private javax.swing.JCheckBox chckbxCarteirasAdaptadas;
    private javax.swing.JCheckBox chckbxCentroAtendimentoEspecializado;
    private javax.swing.JCheckBox chckbxComputadoresAdaptados;
    private javax.swing.JCheckBox chckbxComunicacaoAlternativa;
    private javax.swing.JCheckBox chckbxInterpreteLibras;
    private javax.swing.JCheckBox chckbxLivrosAmpliados;
    private javax.swing.JCheckBox chckbxMuletasBengalas;
    private javax.swing.JCheckBox chckbxNaPropriaEscola;
    private javax.swing.JCheckBox chckbxOutraEscola;
    private javax.swing.JCheckBox chckbxProfessorEspecializado;
    private javax.swing.JCheckBox chckbxRegleteSoroba;
    private javax.swing.JCheckBox chckbxUsoCadeiraRodas;
    private javax.swing.JComboBox<String> cmbbxCorRaca;
    private javax.swing.JComboBox<String> cmbbxDocumentoFiliacao1;
    private javax.swing.JComboBox<String> cmbbxDocumentoFiliacao2;
    private javax.swing.JComboBox<String> cmbbxDocumentoResposavel;
    private javax.swing.JComboBox<String> cmbbxEscolariedadeFiliacao1;
    private javax.swing.JComboBox<String> cmbbxEscolariedadeFiliacao2;
    private javax.swing.JComboBox<String> cmbbxEstado;
    private javax.swing.JComboBox<String> cmbbxEstadoCivil;
    private javax.swing.JComboBox<String> cmbbxGrauParentesco;
    private javax.swing.JComboBox<String> cmbbxRecebeBPC;
    private javax.swing.JComboBox<String> cmbbxRecebeBolsaFamilia;
    private javax.swing.JComboBox<String> cmbbxRendaFamiliar;
    private javax.swing.JComboBox<String> cmbbxSexo;
    private javax.swing.JComboBox<String> cmbbxTipoMoradia;
    private javax.swing.JComboBox<String> cmbbxTipoTransporte;
    private javax.swing.JComboBox<String> cmbbxUF;
    private javax.swing.JFormattedTextField fldDataNascimento;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCGM;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCampos;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblCorRaca;
    private javax.swing.JLabel lblDataEmissao;
    private javax.swing.JLabel lblDocumentoFiliacao1;
    private javax.swing.JLabel lblDocumentoFiliacao2;
    private javax.swing.JLabel lblDocumentoResponsavel;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblErro;
    private javax.swing.JLabel lblEscolaridadeFiliacao1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblFiliacao1;
    private javax.swing.JLabel lblFiliacao2;
    private javax.swing.JLabel lblGrauParentesco;
    private javax.swing.JLabel lblLivroFolhas;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblMunicipio;
    private javax.swing.JLabel lblNDocumentoFiliacao1;
    private javax.swing.JLabel lblNDocumentoFiliacao2;
    private javax.swing.JLabel lblNDocumentoResponsavel;
    private javax.swing.JLabel lblNEE;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNascimentoCasamento;
    private javax.swing.JLabel lblNdaCasa;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeCartorio;
    private javax.swing.JLabel lblNumeroContato;
    private javax.swing.JLabel lblOrgaoEmissor;
    private javax.swing.JLabel lblPaisNatual;
    private javax.swing.JLabel lblPessoasNaCasa;
    private javax.swing.JLabel lblRG;
    private javax.swing.JLabel lblRNE;
    private javax.swing.JLabel lblRecebeBPC;
    private javax.swing.JLabel lblRecebeBolsaFamilia;
    private javax.swing.JLabel lblRendaFamiliar;
    private javax.swing.JLabel lblResponsavel;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSucesso;
    private javax.swing.JLabel lblTipoMoradia;
    private javax.swing.JLabel lblTipoTransporte;
    private javax.swing.JLabel lblUF;
    private javax.swing.JLabel lbllEscolariedadeFiliacao2;
    private javax.swing.JSpinner spnPessoasNaCasa;
    private javax.swing.JTextField txtfldBairro;
    private javax.swing.JFormattedTextField txtfldCEP;
    private javax.swing.JTextField txtfldCGM;
    private javax.swing.JFormattedTextField txtfldCPF;
    private javax.swing.JTextField txtfldCidade;
    private javax.swing.JTextField txtfldComplemento;
    private javax.swing.JFormattedTextField txtfldDataEmissao;
    private javax.swing.JTextField txtfldEmail;
    private javax.swing.JTextField txtfldEndereco;
    private javax.swing.JTextField txtfldFiliacao1;
    private javax.swing.JTextField txtfldFiliacao2;
    private javax.swing.JTextField txtfldLivroFolhas;
    private javax.swing.JTextField txtfldMatricula;
    private javax.swing.JTextField txtfldMunicipio;
    private javax.swing.JTextField txtfldNDocumentoFiliacao1;
    private javax.swing.JTextField txtfldNDocumentoFiliacao2;
    private javax.swing.JTextField txtfldNDocumentoResponsavel;
    private javax.swing.JTextField txtfldNascimentoCasamento;
    private javax.swing.JTextField txtfldNdaCasa;
    private javax.swing.JTextField txtfldNome;
    private javax.swing.JTextField txtfldNomeCartorio;
    private javax.swing.JFormattedTextField txtfldNumeroContato;
    private javax.swing.JTextField txtfldOrgaoEmissor;
    private javax.swing.JTextField txtfldPaisNatural;
    private javax.swing.JTextField txtfldRG;
    private javax.swing.JTextField txtfldRNE;
    private javax.swing.JTextField txtfldResponsavel;
    // End of variables declaration//GEN-END:variables
}
