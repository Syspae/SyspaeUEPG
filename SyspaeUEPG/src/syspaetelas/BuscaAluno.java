/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package syspaetelas;
import controleConexao.Conexao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import syspaetelas.*;
/**
 *
 * @author carlo
 */
public class BuscaAluno extends javax.swing.JFrame {

    /**
     * Creates new form TelaBuscaAluno
     */
    public BuscaAluno() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        
        
        
    }

    private String preparaSQL(){
        String busca = txtfldBusca.getText();
        String tipoBusca = cmbbxBusca.getSelectedItem().toString();
        switch (tipoBusca) {
            case "Nome":
                return "select idaluno, nome, to_char(data_nascimento, 'DD/MM/YYYY'), cpf, responsavel  from aluno where nome like '" + busca + "%'";
            case "CPF":
                return "select idaluno, nome, to_char(data_nascimento, 'DD/MM/YYYY'), cpf, responsavel  from aluno where cpf like '" + busca + "%'";
            case "Matrícula":
                return "select idaluno, nome, to_char(data_nascimento, 'DD/MM/YYYY'), cpf, responsavel  from aluno where idaluno like '" + busca + "%'";
            case "Nome do Responsável":
                return "select idaluno, nome, to_char(data_nascimento, 'DD/MM/YYYY'), cpf, responsavel  from aluno where responsavel like '" + busca + "%'";
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblBusca = new javax.swing.JLabel();
        cmbbxBusca = new javax.swing.JComboBox<>();
        txtfldBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBuscaAluno = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setTitle("Buscar Aluno");

        lblBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblBusca.setText("Buscar por:");

        cmbbxBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF", "Matrícula", "Nome do Responsável" }));
        cmbbxBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbxBuscaActionPerformed(evt);
            }
        });

        txtfldBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtfldBusca.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtfldBuscaInputMethodTextChanged(evt);
            }
        });
        txtfldBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldBuscaActionPerformed(evt);
            }
        });
        txtfldBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfldBuscaKeyTyped(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSelecionar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.setMinimumSize(new java.awt.Dimension(188, 61));
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        tblBuscaAluno.setAutoCreateRowSorter(true);
        tblBuscaAluno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblBuscaAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblBuscaAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "Data de Nascimento", "CPF", "Responsável"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblBuscaAluno);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBusca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbbxBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtfldBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar))
                            .addComponent(jScrollPane3))))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBusca)
                    .addComponent(cmbbxBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(204, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        BuscaAluno.this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        // TODO add your handling code here:
        int id = 0;
        int row = tblBuscaAluno.getSelectedRow();
        
        String s = tblBuscaAluno.getModel().getValueAt(row, 0)+"";
        
        EditarAluno editar = new EditarAluno(s);
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void txtfldBuscaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtfldBuscaInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldBuscaInputMethodTextChanged

    private void txtfldBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfldBuscaKeyTyped

    }//GEN-LAST:event_txtfldBuscaKeyTyped

    private void cmbbxBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxBuscaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbbxBuscaActionPerformed

    private void txtfldBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldBuscaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) tblBuscaAluno.getModel();
        table.setRowCount(0);
        Conexao con = new Conexao();        
        ResultSet rs = con.executaBusca(preparaSQL());        
        try {
            while(rs.next()){
                Object[] row = new Object [5];
                for(int i = 1; i <= 5; i++){
                    row[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel) tblBuscaAluno.getModel()).insertRow(rs.getRow() - 1, row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscaAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox<String> cmbbxBusca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JTable tblBuscaAluno;
    private javax.swing.JTextField txtfldBusca;
    // End of variables declaration//GEN-END:variables
}
