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
public class BuscaAnamnese extends javax.swing.JFrame {

    /**
     * Creates new form TelaBuscaAnamnese
     */
    public BuscaAnamnese() {
        initComponents();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private String preparaSQL(){
        switch ((String) cmbbxBusca.getSelectedItem()) {
            case "Nome":
                return "select idaluno, nome, to_char(aluno.data_nascimento, 'DD/MM/YYYY'), cpf, data_anamnese, idanamnese  from aluno, anamnese where nome like '" + txtfldBusca.getText() + "%'";
            case "CPF":
                return "select idaluno, nome, to_char(aluno.data_nascimento, 'DD/MM/YYYY'), cpf, data_anamnese, idanamnese  from aluno, anamnese where cpf like'" + txtfldBusca.getText() + "%'";
            case "Matrícula":
                return "select idaluno, nome, to_char(aluno.data_nascimento, 'DD/MM/YYYY'), cpf, data_anamnese, idanamnese  from aluno, anamnese where CAST(idaluno AS TEXT) like'" + txtfldBusca.getText() + "%'";
            case "Nome do Responsável":
                return "select idaluno, nome, to_char(aluno.data_nascimento, 'DD/MM/YYYY'), cpf, data_anamnese, idanamnese  from aluno, anamnese where responsavel like'" + txtfldBusca.getText() + "%'";
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
        tblBuscaAnamnese = new javax.swing.JTable();

        setTitle("Buscar Anamnese");
        setResizable(false);

        cmbbxBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF", "Matrícula", "Nome do Responsável", "Data de Nascimento" }));

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

        tblBuscaAnamnese.setAutoCreateRowSorter(true);
        tblBuscaAnamnese.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblBuscaAnamnese.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblBuscaAnamnese.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "Data de Nascimento", "CPF", "Data da Anamnese", "Nº Anamnese"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblBuscaAnamnese);
        if (tblBuscaAnamnese.getColumnModel().getColumnCount() > 0) {
            tblBuscaAnamnese.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblBuscaAnamnese.getColumnModel().getColumn(1).setPreferredWidth(140);
            tblBuscaAnamnese.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblBuscaAnamnese.getColumnModel().getColumn(3).setPreferredWidth(55);
            tblBuscaAnamnese.getColumnModel().getColumn(4).setPreferredWidth(70);
            tblBuscaAnamnese.getColumnModel().getColumn(5).setPreferredWidth(45);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbbxBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfldBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn03Buscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn03Selecionar)
                        .addGap(18, 18, 18)
                        .addComponent(btn03Cancelar))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(23, 23, 23))
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn03Cancelar)
                    .addComponent(btn03Selecionar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn03CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn03CancelarActionPerformed
        // TODO add your handling code here:
        BuscaAnamnese.this.dispose();
    }//GEN-LAST:event_btn03CancelarActionPerformed

    private void btn03BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn03BuscarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) tblBuscaAnamnese.getModel();
        table.setRowCount(0);
        Conexao con = new Conexao();
        ResultSet rs = con.executaBusca(preparaSQL());
        try {
            while(rs.next()){
                Object[] row = new Object [6];
                for(int i = 1; i<= 6; i++) row [i-1] = rs.getObject(i);
                ((DefaultTableModel) tblBuscaAnamnese.getModel()).insertRow(rs.getRow() - 1, row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn03BuscarActionPerformed

    private void btn03SelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn03SelecionarActionPerformed
        // TODO add your handling code here:   
        int id = (int) tblBuscaAnamnese.getModel().getValueAt(tblBuscaAnamnese.getSelectedRow(), 0);
        MostraAnamnese mostraAnamnese = new MostraAnamnese(id);
    }//GEN-LAST:event_btn03SelecionarActionPerformed

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
    private javax.swing.JTable tblBuscaAnamnese;
    private javax.swing.JTextField txtfldBusca;
    // End of variables declaration//GEN-END:variables
}
