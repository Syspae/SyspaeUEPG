/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package syspaetelas;
import controleConexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class HistoricoAtendimento extends javax.swing.JFrame {

    /**
     * Creates new form TelaHistoricoAtendimento
     */
    public HistoricoAtendimento() {
        initComponents();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    //Função para buscar os atendimentos baseado no combobox de busca
    private String preparaSQL(){
        switch ((String) cmbbxBusca.getSelectedItem()) {
            case "Nome":
                return """
                       SELECT idaluno, aluno.nome, to_char(data_nascimento, 'DD/MM/YYYY'), cpf, idatendimento, to_char(data_do_atendimento, 'DD/MM/YYYY'), profissional
                       FROM aluno as aluno
                       inner join atendimento as atendimento
                       ON aluno.idaluno = atendimento.fk_aluno_idaluno
                       WHERE aluno.nome like '"""+txtfldBusca.getText()+"%' order by aluno.nome ASC";
            case "CPF":
                return """
                       SELECT idaluno, aluno.nome, to_char(data_nascimento, 'DD/MM/YYYY'), cpf, idatendimento, to_char(data_do_atendimento, 'DD/MM/YYYY'), profissional
                       FROM aluno as aluno
                       inner join atendimento as atendimento
                       ON aluno.idaluno = atendimento.fk_aluno_idaluno
                       WHERE cpf like '"""+txtfldBusca.getText()+"%' order by aluno.nome ASC";
            case "Matrícula":
                return """
                       SELECT idaluno, aluno.nome, to_char(data_nascimento, 'DD/MM/YYYY'), cpf, idatendimento, to_char(data_do_atendimento, 'DD/MM/YYYY'), profissional
                       FROM aluno as aluno
                       inner join atendimento as atendimento
                       ON aluno.idaluno = atendimento.fk_aluno_idaluno
                       WHERE idaluno like '"""+txtfldBusca.getText()+"%' order by aluno.nome ASC";
            case "Nome do Responsável":
                return """
                       SELECT idaluno, aluno.nome, to_char(data_nascimento, 'DD/MM/YYYY'), cpf, idatendimento, to_char(data_do_atendimento, 'DD/MM/YYYY'), profissional
                       FROM aluno as aluno
                       inner join atendimento as atendimento
                       ON aluno.idaluno = atendimento.fk_aluno_idaluno
                       WHERE responsavel like '"""+txtfldBusca.getText()+"%' order by aluno.nome ASC";
            default:
                throw new AssertionError();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbbxBusca = new javax.swing.JComboBox<>();
        txtfldBusca = new javax.swing.JTextField();
        btn03Buscar = new javax.swing.JButton();
        btn03Cancelar = new javax.swing.JButton();
        btn03Selecionar = new javax.swing.JButton();
        lblBusca = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBuscaAtendimento = new javax.swing.JTable();

        setTitle("Histórico de Atendimentos");
        setResizable(false);

        cmbbxBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF", "Matrícula", "Data de Nascimento" }));

        txtfldBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btn03Buscar.setBackground(new java.awt.Color(242, 242, 242));
        btn03Buscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn03Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Buscar.png"))); // NOI18N
        btn03Buscar.setBorder(null);
        btn03Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn03BuscarActionPerformed(evt);
            }
        });

        btn03Cancelar.setBackground(new java.awt.Color(242, 242, 242));
        btn03Cancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn03Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Cancelar.png"))); // NOI18N
        btn03Cancelar.setBorder(null);
        btn03Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn03CancelarActionPerformed(evt);
            }
        });

        btn03Selecionar.setBackground(new java.awt.Color(242, 242, 242));
        btn03Selecionar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn03Selecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão Selecionar (1).png"))); // NOI18N
        btn03Selecionar.setBorder(null);
        btn03Selecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn03SelecionarActionPerformed(evt);
            }
        });

        lblBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblBusca.setText("Buscar por:");

        tblBuscaAtendimento.setAutoCreateRowSorter(true);
        tblBuscaAtendimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblBuscaAtendimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblBuscaAtendimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "Data de Nascimento", "CPF", "Nº Atendimento", "Data do Atendimento", "Especialista"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBuscaAtendimento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(tblBuscaAtendimento);
        if (tblBuscaAtendimento.getColumnModel().getColumnCount() > 0) {
            tblBuscaAtendimento.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblBuscaAtendimento.getColumnModel().getColumn(1).setPreferredWidth(285);
            tblBuscaAtendimento.getColumnModel().getColumn(2).setPreferredWidth(140);
            tblBuscaAtendimento.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblBuscaAtendimento.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblBuscaAtendimento.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblBuscaAtendimento.getColumnModel().getColumn(6).setPreferredWidth(250);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn03Selecionar)
                        .addGap(18, 18, 18)
                        .addComponent(btn03Cancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblBusca)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbbxBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtfldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn03Buscar))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBusca)
                        .addComponent(cmbbxBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn03Buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn03Cancelar)
                    .addComponent(btn03Selecionar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn03CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn03CancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn03CancelarActionPerformed

    private void btn03SelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn03SelecionarActionPerformed
        // TODO add your handling code here:
        int id = (int) tblBuscaAtendimento.getModel().getValueAt(tblBuscaAtendimento.getSelectedRow(), 4);        
        MostraAtendimento atendimento = new MostraAtendimento(id);
    }//GEN-LAST:event_btn03SelecionarActionPerformed

    private void btn03BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn03BuscarActionPerformed
        // TODO add your handling code here:
        if(txtfldBusca.getText().length() >= 3){
            DefaultTableModel table = (DefaultTableModel) tblBuscaAtendimento.getModel();
            table.setRowCount(0);
            Conexao con = new Conexao();
            ResultSet rs = con.executaBusca(preparaSQL());
            try {
                while(rs.next()){
                    Object[] row = new Object[7];
                    for(int i = 1; i<=7; i++) row[i-1] = rs.getObject(i);
                    ((DefaultTableModel) tblBuscaAtendimento.getModel()).insertRow(rs.getRow() - 1, row);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }       
        }
    }//GEN-LAST:event_btn03BuscarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn03Buscar;
    private javax.swing.JButton btn03Cancelar;
    private javax.swing.JButton btn03Selecionar;
    private javax.swing.JComboBox<String> cmbbxBusca;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JTable tblBuscaAtendimento;
    private javax.swing.JTextField txtfldBusca;
    // End of variables declaration//GEN-END:variables
}
