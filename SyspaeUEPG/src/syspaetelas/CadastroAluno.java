/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package syspaetelas;

import static java.lang.System.exit;
import controleConexao.Conexao;

/**
 *
 * @author carlo
 */
public class CadastroAluno extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroAluno
     */
    public CadastroAluno(boolean cadastro) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        
        if(!cadastro){
            desabilitaCampos();
        }
        
        
        
    }
    
    private boolean desabilitaCampos(){
        txtfldNome.setEnabled(false);
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
            fldDataNascimento.setEnabled(false);
            spnPessoasNaCasa.setEnabled(false);
            txtfldBairro.setEnabled(false);
            txtfldCEP.setEnabled(false);
            txtfldCGM.setEnabled(false);
            txtfldCPF.setEnabled(false);
            txtfldCidade.setEnabled(false);
            txtfldComplemento.setEnabled(false);
            txtfldDataEmissao.setEnabled(false);
            cmbbxDocumentoFiliacao2.setEnabled(false);
            txtfldEmail.setEnabled(false);
            txtfldEndereco.setEnabled(false);
            txtfldFiliacao1.setEnabled(false);
            txtfldFiliacao2.setEnabled(false);
            txtfldLivroFolhas.setEnabled(false);
            txtfldMatricula.setEnabled(false);
            txtfldMunicipio.setEnabled(false);
            txtfldNDocumentoFiliacao1.setEnabled(false);
            txtfldNDocumentoFiliacao2.setEnabled(false);
            txtfldNDocumentoResponsavel.setEnabled(false);
            txtfldNascimentoCasamento.setEnabled(false);
            txtfldNdaCasa.setEnabled(false);
            txtfldNome.setEnabled(false);
            txtfldNomeCartorio.setEnabled(false);
            txtfldNumeroContato.setEnabled(false);
            txtfldOrgaoEmissor.setEnabled(false);
            txtfldPaisNatural.setEnabled(false);
            txtfldRG.setEnabled(false);
            txtfldRNE.setEnabled(false);
            txtfldResponsavel.setEnabled(false);

            //Desativar botão de Salvar
            btnSalvar.setEnabled(false);
            
            return true;
    }
    
    private char estado_civil(){
        String getestado_civil = cmbbxEstadoCivil.getSelectedItem().toString();
        char estado_civil;
        switch (getestado_civil) {
            case "Solteiro(a)":
                estado_civil = 'S';
                return estado_civil;
            case "Casado(a)":
                estado_civil = 'C';
                return estado_civil;
            case "Divorciado(a)":
                estado_civil = 'D';
                return estado_civil;
            case "Separado(a)":
                estado_civil = 'H';
                return estado_civil;
            case "Viúvo(a)":
                estado_civil = 'V';
                return estado_civil;
            default:
                throw new AssertionError();
        }
    }
    
    private String uf(String qual){
        String getuf = "null";
        if(qual.equals("nat")) getuf = cmbbxUF.getSelectedItem().toString();
        if(qual.equals("atual")) getuf = cmbbxEstado.getSelectedItem().toString();
        String uf_atual;
        switch (getuf) {
            case "Acre":
                uf_atual = "AC";
                return uf_atual;
            case "Alagoas":
                uf_atual = "AL";
                return uf_atual;
            case "Amapá":
                uf_atual = "AP"; 
                return uf_atual;
            case "Amazonas":
                uf_atual = "AM";
                return uf_atual;
            case "Bahia":
                uf_atual = "BH";
                return uf_atual;
            case "Ceará":
                uf_atual = "CE";
                return uf_atual;
            case "Distrito Federal":
                uf_atual = "DF";
                return uf_atual;
            case "Espírito Santo":
                uf_atual = "ES";
                return uf_atual;
            case "Goiás":
                uf_atual = "GO";
                return uf_atual;
            case "Maranhão":
                uf_atual = "MA";
                return uf_atual;
            case "Mato Grosso":
                uf_atual = "MT";
                return uf_atual;
            case "Mato Grosso do Sul":
                uf_atual = "MS";
                return uf_atual;
            case "Minas Gerais":
                uf_atual = "MG";
                return uf_atual;
            case "Pará":
                uf_atual = "PA";
                return uf_atual;
            case "Paraíba":
                uf_atual = "PB";
                return uf_atual;
            case "Paraná":
                uf_atual = "PR";
                return uf_atual;
            case "Pernambuco":
                uf_atual = "PE";
                return uf_atual;
            case "Piauí":
                uf_atual = "PI";
                return uf_atual;
            case "Rio de Janeiro":
                uf_atual = "RJ";
                return uf_atual;
            case "Rio Grande do Norte":
                uf_atual = "RN";
                return uf_atual;
            case "Rio Grande do Sul":
                uf_atual = "RS";
                return uf_atual;
            case "Rondônia":
                uf_atual = "RO";
                return uf_atual;
            case "Roraima":
                uf_atual = "RR";
                return uf_atual;
            case "Santa Catarina":
                uf_atual = "SC";
                return uf_atual;
            case "São Paulo":
                uf_atual = "SP";
                return uf_atual;
            case "Sergipe":
                uf_atual = "SE"; 
                return uf_atual;
            case "Tocantins":
                uf_atual = "TO";
                return uf_atual;                
            default:
                throw new AssertionError();
        }
    }
    
    private char transporte(){
        char transporte;
        String getTransporte = cmbbxTipoTransporte.getSelectedItem().toString();
        switch (getTransporte) {
            case "Próprio":
                transporte = 'P';
                return transporte;
            case "Escolar Rural":
                transporte = 'R';
                return transporte;
            case "Escolar Urbano":
                transporte = 'U';
                return transporte;
            default:
                throw new AssertionError();
        }
    }
    
    private char moradia(){
        char moradia = ' ';
        String getMoradia = cmbbxTipoMoradia.getSelectedItem().toString();
        switch (getMoradia) {
            case "Própria":
                moradia = 'P';
                return moradia;
            case "Alugada":
                moradia = 'A';
                return moradia;
            case "Cedida":
                moradia = 'C';
                return moradia;
            default:
                throw new AssertionError();
        }
    }
    
    private String renda(){
        String renda;
        String getRenda = cmbbxRendaFamiliar.getSelectedItem().toString();
        switch (getRenda) {
            case "Sem renda":
                renda = "NaN";
                return renda;
            case "Até 1 sálario mínimo":
                renda = "at1";
                return renda;
            case "Entre 1 e 3 sálarios mínimo":
                renda = "1a3";
                return renda;
            case "Entre 3 e 5 sálarios mínimo":
                renda = "3a5";
                return renda;
            case "Mais de 5 sálarios mínimo":
                renda = "5ms";
                return renda;                
            default:
                throw new AssertionError();
        }
    }
    
    private char sexo(){
        char sexo;
        String getSexo = cmbbxSexo.getSelectedItem().toString();
        switch (getSexo) {
            case "Masculino":
                sexo = 'M';
                return sexo;
            case "Feminino":
                sexo = 'F';
                return sexo;
            default:
                throw new AssertionError();
        }
    }
    
    private boolean bolsa_familia(){
        String getBolsa = cmbbxRecebeBolsaFamilia.getSelectedItem().toString();
        switch (getBolsa) {
            case "Não":
                return false;
            case "Sim":
                return true;
            default:
                throw new AssertionError();
        }
    }
    
    private char bpc(){
        String getbpc = cmbbxRecebeBPC.getSelectedItem().toString();
        switch (getbpc) {
            case "Não":
                return 'N';
            case "Sim":
                return 'S';
            default:
                throw new AssertionError();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSair = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        txtfldMatricula = new javax.swing.JTextField();
        txtfldNome = new javax.swing.JTextField();
        txtfldCGM = new javax.swing.JTextField();
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
        txtfldMunicipio = new javax.swing.JTextField();
        lblUF = new javax.swing.JLabel();
        cmbbxUF = new javax.swing.JComboBox<>();
        lblRG = new javax.swing.JLabel();
        txtfldRG = new javax.swing.JFormattedTextField();
        lblOrgaoEmissor = new javax.swing.JLabel();
        txtfldOrgaoEmissor = new javax.swing.JTextField();
        lblPaisNatual = new javax.swing.JLabel();
        txtfldPaisNatural = new javax.swing.JTextField();
        txtfldCEP = new javax.swing.JFormattedTextField();
        lblCEP = new javax.swing.JLabel();
        lblRNE = new javax.swing.JLabel();
        txtfldRNE = new javax.swing.JTextField();
        lblResponsavel = new javax.swing.JLabel();
        txtfldResponsavel = new javax.swing.JTextField();
        lblFiliacao1 = new javax.swing.JLabel();
        txtfldFiliacao1 = new javax.swing.JTextField();
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
        txtfldNascimentoCasamento = new javax.swing.JTextField();
        lblNascimentoCasamento = new javax.swing.JLabel();
        txtfldLivroFolhas = new javax.swing.JTextField();
        lblLivroFolhas = new javax.swing.JLabel();
        lblDataEmissao = new javax.swing.JLabel();
        txtfldNomeCartorio = new javax.swing.JTextField();
        lblNomeCartorio = new javax.swing.JLabel();
        cmbbxDocumentoResposavel = new javax.swing.JComboBox<>();
        lblDocumentoResponsavel = new javax.swing.JLabel();
        txtfldNDocumentoResponsavel = new javax.swing.JTextField();
        lblNDocumentoResponsavel = new javax.swing.JLabel();
        cmbbxGrauParentesco = new javax.swing.JComboBox<>();
        lblGrauParentesco = new javax.swing.JLabel();
        txtfldEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtfldNumeroContato = new javax.swing.JFormattedTextField();
        lblNumeroContato = new javax.swing.JLabel();
        cmbbxDocumentoFiliacao1 = new javax.swing.JComboBox<>();
        lblDocumentoFiliacao1 = new javax.swing.JLabel();
        txtfldNDocumentoFiliacao1 = new javax.swing.JTextField();
        lblNDocumentoFiliacao1 = new javax.swing.JLabel();
        cmbbxDocumentoFiliacao2 = new javax.swing.JComboBox<>();
        lblDocumentoFiliacao2 = new javax.swing.JLabel();
        lblNDocumentoFiliacao2 = new javax.swing.JLabel();
        txtfldNdaCasa = new javax.swing.JTextField();
        txtfldComplemento = new javax.swing.JTextField();
        txtfldBairro = new javax.swing.JTextField();
        txtfldCidade = new javax.swing.JTextField();
        cmbbxEstado = new javax.swing.JComboBox<>();
        lblNdaCasa = new javax.swing.JLabel();
        lblComplemento = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtfldDataEmissao = new javax.swing.JFormattedTextField();
        txtfldFiliacao2 = new javax.swing.JTextField();
        lblFiliacao2 = new javax.swing.JLabel();
        txtfldNDocumentoFiliacao2 = new javax.swing.JTextField();
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

        setTitle("Cadastrar Aluno");

        btnSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNome.setText("Nome*");

        lblMatricula.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMatricula.setText("Matrícula*");

        txtfldMatricula.setEditable(false);
        txtfldMatricula.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldMatriculaActionPerformed(evt);
            }
        });

        txtfldNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldNomeActionPerformed(evt);
            }
        });

        txtfldCGM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldCGM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldCGMActionPerformed(evt);
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
        fldDataNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fldDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldDataNascimentoActionPerformed(evt);
            }
        });

        cmbbxSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Masculino", "Feminino" }));

        cmbbxEstadoCivil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Solteiro(a)", "Casado(a)", "Divorciado(a)", "Separado(a)", "Viúvo(a)" }));

        lblCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCPF.setText("CPF*");

        try {
            txtfldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfldCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblMunicipio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMunicipio.setText("Naturalidade/Município");

        txtfldMunicipio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblUF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUF.setText("UF");

        cmbbxUF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceara", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));
        cmbbxUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbxUFActionPerformed(evt);
            }
        });

        lblRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRG.setText("Carteira de Identidade RG");

        try {
            txtfldRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfldRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblOrgaoEmissor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblOrgaoEmissor.setText("Órgão Emissor");

        txtfldOrgaoEmissor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblPaisNatual.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPaisNatual.setText("País Natural");

        txtfldPaisNatural.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        try {
            txtfldCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfldCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCEP.setText("CEP");

        lblRNE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRNE.setText("RNE");

        txtfldRNE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblResponsavel.setText("Nome do Responsável*");

        txtfldResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFiliacao1.setText("Filiação 1");

        txtfldFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblEndereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEndereco.setText("Endereço*");

        txtfldEndereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

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

        btnSalvar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtfldNascimentoCasamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblNascimentoCasamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNascimentoCasamento.setText("Certidão de Nascimento/Casamento");

        txtfldLivroFolhas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblLivroFolhas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblLivroFolhas.setText("Livro/Folhas");

        lblDataEmissao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDataEmissao.setText("Data de Emissão");

        txtfldNomeCartorio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblNomeCartorio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNomeCartorio.setText("Nome do Cartório/UF");

        cmbbxDocumentoResposavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxDocumentoResposavel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "CPF", "CNH", "RG", "RNE", "Outro" }));

        lblDocumentoResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDocumentoResponsavel.setText("Documento");

        txtfldNDocumentoResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblNDocumentoResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNDocumentoResponsavel.setText("Número");

        cmbbxGrauParentesco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxGrauParentesco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Pai", "Mãe", "Avô(ó)", "Bisavô(ó)", "Filho(a)", "Neto(a)", "Bisneto(a)", "Irmão(ã)", "Tio(a)", "Sobrinho(a)", "Outro" }));

        lblGrauParentesco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblGrauParentesco.setText("Grau de Parentesco");

        txtfldEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEmail.setText("Email");

        try {
            txtfldNumeroContato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfldNumeroContato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblNumeroContato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNumeroContato.setText("Telefone para Contato");

        cmbbxDocumentoFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxDocumentoFiliacao1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "CPF", "CNH", "RG", "RNE", "Outro" }));

        lblDocumentoFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDocumentoFiliacao1.setText("Documento");

        txtfldNDocumentoFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldNDocumentoFiliacao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldNDocumentoFiliacao1ActionPerformed(evt);
            }
        });

        lblNDocumentoFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNDocumentoFiliacao1.setText("Número");

        cmbbxDocumentoFiliacao2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxDocumentoFiliacao2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "CPF", "CNH", "RG", "RNE", "Outro" }));

        lblDocumentoFiliacao2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDocumentoFiliacao2.setText("Documento");

        lblNDocumentoFiliacao2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNDocumentoFiliacao2.setText("Número");

        txtfldNdaCasa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtfldComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtfldBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldBairroActionPerformed(evt);
            }
        });

        txtfldCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cmbbxEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceara", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));

        lblNdaCasa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNdaCasa.setText("Número da casa");

        lblComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblComplemento.setText("Complemento");

        lblBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblBairro.setText("Bairro");

        lblCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCidade.setText("Cidade");

        lblEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEstado.setText("Estado");

        try {
            txtfldDataEmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfldDataEmissao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtfldFiliacao2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldFiliacao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldFiliacao2ActionPerformed(evt);
            }
        });

        lblFiliacao2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFiliacao2.setText("Filiação 2");

        txtfldNDocumentoFiliacao2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldNDocumentoFiliacao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldNDocumentoFiliacao2ActionPerformed(evt);
            }
        });

        lblEscolaridadeFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEscolaridadeFiliacao1.setText("Escolariedade Filiação  1");

        cmbbxEscolariedadeFiliacao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxEscolariedadeFiliacao1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Analfabeto", "Até 5º Ano Incompleto", "5º Ano Completo", "6º ao 9º Ano do Fundamental", "Fundamental Completo", "Médio Incompleto", "Médio Completo", "Superior Incompleto", "Superior Completo", "Mestrado", "Doutorado", "Ignorado" }));

        lblTipoTransporte.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTipoTransporte.setText("Tipo de Transporte");

        cmbbxTipoTransporte.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxTipoTransporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Próprio", "Escolar Rural", "Escolar Urbano" }));

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
        lblTipoMoradia.setText("Tipo de Moradia");

        cmbbxTipoMoradia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxTipoMoradia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Própria", "Alugada", "Cedida" }));

        lblRecebeBPC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRecebeBPC.setText("Recebe BPC?");

        cmbbxRecebeBPC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxRecebeBPC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

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
        lblPessoasNaCasa.setText("Quantas pessoas moram na casa?");

        spnPessoasNaCasa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spnPessoasNaCasa.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblRendaFamiliar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRendaFamiliar.setText("Renda Familiar");

        cmbbxRendaFamiliar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxRendaFamiliar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem renda", "Até 1 sálario mínimo", "Entre 1 e 3 sálarios mínimos", "Entre 3 e 5 sálarios mínimos", "Mais de 5 sálarios mínimos" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(898, 898, 898)
                        .addComponent(lblDocumentoFiliacao2)
                        .addGap(96, 96, 96)
                        .addComponent(lblNDocumentoFiliacao2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chckbxCentroAtendimentoEspecializado)
                                    .addComponent(chckbxOutraEscola)
                                    .addComponent(chckbxNaPropriaEscola)
                                    .addComponent(chckbxAtendimentoEspecializado)
                                    .addComponent(chckbxProfessorEspecializado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chckbxComputadoresAdaptados)
                                    .addComponent(chckbxLivrosAmpliados)
                                    .addComponent(chckbxComunicacaoAlternativa)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chckbxRegleteSoroba)
                                            .addComponent(chckbxCarteirasAdaptadas))
                                        .addGap(214, 214, 214)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(spnPessoasNaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblPessoasNaCasa)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chckbxAtendente)
                                    .addComponent(chckbxInterpreteLibras))
                                .addGap(205, 205, 205)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chckbxMuletasBengalas)
                                    .addComponent(chckbxUsoCadeiraRodas)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblEndereco)
                                            .addComponent(txtfldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblNdaCasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtfldNdaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblComplemento)
                                            .addComponent(txtfldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(165, 165, 165)
                                        .addComponent(lblNEE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBairro)
                                    .addComponent(txtfldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblEscolaridadeFiliacao1)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblTipoTransporte))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmbbxEscolariedadeFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cmbbxEscolariedadeFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbllEscolariedadeFiliacao2))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblTipoMoradia)
                                                    .addComponent(cmbbxTipoMoradia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cmbbxTipoTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCidade))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblRecebeBolsaFamilia)
                                            .addComponent(cmbbxRecebeBolsaFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbbxRecebeBPC, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblRecebeBPC)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblRendaFamiliar)
                                            .addComponent(cmbbxRendaFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(527, 527, 527))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(431, 431, 431))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCPF)
                                    .addComponent(txtfldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblRG)
                                    .addComponent(txtfldRG, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfldOrgaoEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblOrgaoEmissor)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtfldRNE, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblRNE))
                                    .addGap(137, 137, 137)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblNascimentoCasamento)
                                            .addGap(18, 18, 18)
                                            .addComponent(lblLivroFolhas))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtfldNascimentoCasamento, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtfldLivroFolhas, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtfldFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblFiliacao1))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cmbbxDocumentoResposavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblDocumentoResponsavel)
                                                .addComponent(lblDocumentoFiliacao1))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblNDocumentoFiliacao1)
                                                .addComponent(lblNDocumentoResponsavel)
                                                .addComponent(txtfldNDocumentoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cmbbxDocumentoFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtfldNDocumentoFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(txtfldResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResponsavel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbbxGrauParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGrauParentesco))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmail))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtfldCGM, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblCGM))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(fldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblNascimento))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmbbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblSexo))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmbbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblEstadoCivil)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtfldMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblMunicipio))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmbbxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblUF))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtfldPaisNatural, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblPaisNatual))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblCEP)
                                                    .addComponent(txtfldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblNomeCartorio)
                                                .addComponent(txtfldNomeCartorio, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtfldNumeroContato, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblNumeroContato, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(txtfldDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDataEmissao)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblFiliacao2)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtfldFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmbbxDocumentoFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtfldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblEstado)
                                                    .addComponent(txtfldNDocumentoFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cmbbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMatricula)
                            .addComponent(txtfldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(txtfldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(195, 195, 195))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMatricula)
                            .addComponent(lblNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEstadoCivil)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblSexo)
                                .addComponent(lblNascimento)
                                .addComponent(lblCGM)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfldCGM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblUF)
                                    .addComponent(lblPaisNatual)
                                    .addComponent(lblCEP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbbxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfldPaisNatural, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMunicipio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfldMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNomeCartorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfldNomeCartorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(lblNumeroContato))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfldNumeroContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDocumentoFiliacao2)
                            .addComponent(lblNDocumentoFiliacao2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblRG)
                                    .addComponent(lblOrgaoEmissor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtfldRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfldOrgaoEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNascimentoCasamento)
                            .addComponent(lblRNE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblLivroFolhas)
                                .addComponent(lblDataEmissao)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfldRNE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtfldNascimentoCasamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtfldLivroFolhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtfldDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblResponsavel)
                            .addComponent(lblDocumentoResponsavel)
                            .addComponent(lblNDocumentoResponsavel)
                            .addComponent(lblGrauParentesco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfldResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbbxDocumentoResposavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfldNDocumentoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbbxGrauParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFiliacao2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFiliacao1)
                                .addComponent(lblDocumentoFiliacao1)
                                .addComponent(lblNDocumentoFiliacao1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfldFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbbxDocumentoFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfldNDocumentoFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfldFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbbxDocumentoFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfldNDocumentoFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblBairro)
                                    .addComponent(lblCidade))
                                .addComponent(lblEstado, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtfldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblEndereco)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtfldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNdaCasa)
                            .addComponent(lblComplemento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfldNdaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEscolaridadeFiliacao1)
                                    .addComponent(lblTipoTransporte))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbbxEscolariedadeFiliacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbbxTipoTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbllEscolariedadeFiliacao2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbbxEscolariedadeFiliacao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTipoMoradia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbbxTipoMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblRecebeBolsaFamilia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbbxRecebeBolsaFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblRecebeBPC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbbxRecebeBPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPessoasNaCasa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnPessoasNaCasa))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRendaFamiliar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbbxRendaFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSair)
                            .addComponent(btnSalvar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblNEE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chckbxInterpreteLibras)
                            .addComponent(chckbxUsoCadeiraRodas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chckbxAtendente)
                            .addComponent(chckbxMuletasBengalas))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chckbxProfessorEspecializado)
                            .addComponent(chckbxLivrosAmpliados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chckbxAtendimentoEspecializado)
                            .addComponent(chckbxRegleteSoroba))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chckbxNaPropriaEscola)
                            .addComponent(chckbxCarteirasAdaptadas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chckbxOutraEscola)
                            .addComponent(chckbxComputadoresAdaptados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chckbxCentroAtendimentoEspecializado)
                            .addComponent(chckbxComunicacaoAlternativa))))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        CadastroAluno.this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtfldMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldMatriculaActionPerformed

    private void txtfldNDocumentoFiliacao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldNDocumentoFiliacao1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldNDocumentoFiliacao1ActionPerformed

    private void txtfldNDocumentoFiliacao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldNDocumentoFiliacao2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldNDocumentoFiliacao2ActionPerformed

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

    private void txtfldCGMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldCGMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldCGMActionPerformed

    private void txtfldFiliacao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldFiliacao2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldFiliacao2ActionPerformed

    private void cmbbxRecebeBolsaFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxRecebeBolsaFamiliaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxRecebeBolsaFamiliaActionPerformed

    private void cmbbxEscolariedadeFiliacao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxEscolariedadeFiliacao2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbxEscolariedadeFiliacao2ActionPerformed

    private void txtfldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldNomeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:        
        int id;
        String nome = txtfldNome.getText();
        String cgm = txtfldCGM.getText();
        String data_nascimento = fldDataNascimento.getText();       
        String cpf = txtfldCPF.getText();
        String rg = txtfldRG.getText();
        String orgao_emissor = txtfldOrgaoEmissor.getText();
        String naturalidade_municipio = txtfldMunicipio.getText();
        String pais_natural = txtfldPaisNatural.getText();
        String cep = txtfldCEP.getText();
        String rne = txtfldRNE.getText();
        String certidao = txtfldNascimentoCasamento.getText();
        String livro_folhas = txtfldLivroFolhas.getText();
        String data_emissao = txtfldDataEmissao.getText();
        String nome_cartorio = txtfldNomeCartorio.getText();
        String nome_responsavel = txtfldResponsavel.getText();
        String doc_resp = cmbbxDocumentoResposavel.getSelectedItem().toString();
        String num_doc_resp = txtfldNDocumentoResponsavel.getText();
        String grau_parentesco = cmbbxGrauParentesco.getSelectedItem().toString();
        String email = txtfldEmail.getText();
        String telefone_contato = txtfldNumeroContato.getText();
        String filiacao1 = txtfldFiliacao1.getText();
        String doc_f1 = cmbbxDocumentoFiliacao1.getSelectedItem().toString();
        String num_doc_f1 = txtfldNDocumentoFiliacao1.getText();
        String esc_f1 = cmbbxEscolariedadeFiliacao1.getSelectedItem().toString();
        String filiacao2 = txtfldFiliacao2.getText();
        String doc_f2 = cmbbxDocumentoFiliacao2.getSelectedItem().toString();
        String num_doc_f2 = txtfldNDocumentoFiliacao1.getText();
        String esc_f2 = cmbbxEscolariedadeFiliacao2.getSelectedItem().toString();
        String endereco = txtfldEndereco.getText();
        String num_casa = txtfldNdaCasa.getText();
        String complemento = txtfldComplemento.getText();
        String bairro = txtfldBairro.getText();
        String cidade = txtfldCidade.getText();
        Boolean interprete_libras = chckbxInterpreteLibras.isEnabled();
        Boolean atendente = chckbxAtendente.isEnabled();
        Boolean prof_espec_permanente = chckbxProfessorEspecializado.isEnabled();
        Boolean atend_edc_espc = chckbxAtendimentoEspecializado.isEnabled();
        Boolean propria_escola = chckbxNaPropriaEscola.isEnabled();
        Boolean outra_escola = chckbxOutraEscola.isEnabled();
        Boolean centro_atd_edc_espc = chckbxCentroAtendimentoEspecializado.isEnabled();
        Boolean cadeira_rodas = chckbxUsoCadeiraRodas.isEnabled();
        Boolean muletas_bengalas = chckbxMuletasBengalas.isEnabled();
        Boolean livros_ampliados = chckbxLivrosAmpliados.isEnabled();
        Boolean reglete_soroba = chckbxRegleteSoroba.isEnabled();
        Boolean carteiras_adpts = chckbxCarteirasAdaptadas.isEnabled();
        Boolean compt_adpts = chckbxComputadoresAdaptados.isEnabled();
        Boolean mat_comn_alt = chckbxComunicacaoAlternativa.isEnabled();        
        int pessoas_moram_casa = spnPessoasNaCasa.getComponentCount();

        
        char estado_civil = estado_civil();
        String uf_nat = uf("nat");
        String uf_atual = uf("atual");
        char transporte = transporte();
        char moradia = moradia();
        String renda = renda();
        char sexo = sexo();
        boolean bolsa_familia = bolsa_familia();
        char bpc = bpc();
         
        Conexao con = new Conexao();
        String SQL = "INSERT into aluno (nome, cgm, municipio_nat, data_nascimento,"
                                        + "pais_nat, rg, orgao_rg, cpf, rne, certidao_nascimento, livro_folhas,"
                                        + " nome_cartorio, data_emissao, responsavel, doc_resp, numero_doc_resp, grau_parentesco,"
                                        + " email_resp, telefone_contato, filiacao_1, doc_f1, num_doc_f1,"
                                        + " filiacao_2, doc_f2, num_doc_f2, endereco, num_casa, complemento,"
                                        + " bairro, cidade, cep, estado_civil, uf_nat, escolaridade_f1, escolaridade_f2, uf_atual,"
                                        + " tipo_transporte, tipo_moradia, renda_familiar, interprete_libras, atendente, professor_especializado_permanente,"
                                        + " atendimento_educacional_especializado, na_propria_escola, centro_de_atendimento_educacional_especializado,"
                                        + " uso_de_cadeira_de_rodas, uso_de_muletas_bengalas, livros_ampliados, reglete_soroba_braile,"
                                        + " carteiras_adaptadas, computadores_adaptados, sexo, materiais_de_comunicacao_alternativa, outra_escola,"
                                        + " bolsa_familia, bpc, pessoas_na_casa)"
                                        + "values ('"+nome+"', '"+cgm+"', '"+naturalidade_municipio+"', '"+data_nascimento+"'"
                                        + ", '"+pais_natural+"', '"+rg+"', '"+orgao_emissor+"', '"+cpf+"', '"+rne+"', '"+certidao+"', '"+livro_folhas+"'"
                                        + ", '"+nome_cartorio+"', '"+data_emissao+"', '"+nome_responsavel+"', '"+doc_resp+"', '"+num_doc_resp+"', '"+grau_parentesco+"'"                       
                                        + ", '"+email+"', '"+telefone_contato+"', '"+filiacao1+"', '"+doc_f1+"', '"+num_doc_f1+"', '"+filiacao2+"'"
                                        + ", '"+doc_f2+"', '"+num_doc_f2+"', '"+endereco+"', '"+num_casa+"', '"+complemento+"', '"+bairro+"', '"+cidade+"'"
                                        + ", '"+cep+"','"+estado_civil+"', '"+uf_nat+"', '"+esc_f1+"', '"+esc_f2+"', '"+uf_atual+"', '" +transporte+"', '"+moradia+"', '"+renda+"'"
                                        + ", '"+interprete_libras+"', '"+atendente+"', '"+prof_espec_permanente+"', '"+atend_edc_espc+"', '"+propria_escola+"', '"+centro_atd_edc_espc+"'"
                                        + ", '"+cadeira_rodas+"', '"+muletas_bengalas+"', '"+livros_ampliados+"', '"+reglete_soroba+"', '"+carteiras_adpts+"', '"+compt_adpts+"'"
                                        + ", '"+sexo+"', '"+mat_comn_alt+"', '"+outra_escola+"', '"+bolsa_familia+"', '"+bpc+"', '"+pessoas_moram_casa+"'"
                                        + ")" ; 

        
        int insert = con.executaInsert(SQL);
        
        //Abertura da tela de sucesso ou não da operação
        Confirmação tela07 = new Confirmação(insert);
        tela07.setVisible(true);
        
        //desabilitaCampos();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void fldDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldDataNascimentoActionPerformed

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
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblDataEmissao;
    private javax.swing.JLabel lblDocumentoFiliacao1;
    private javax.swing.JLabel lblDocumentoFiliacao2;
    private javax.swing.JLabel lblDocumentoResponsavel;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
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
    private javax.swing.JFormattedTextField txtfldRG;
    private javax.swing.JTextField txtfldRNE;
    private javax.swing.JTextField txtfldResponsavel;
    // End of variables declaration//GEN-END:variables
}
