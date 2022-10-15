/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package syspaetelas;

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
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
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
        tblBuscaAluno = new javax.swing.JTable();

        setTitle("Buscar Anamnese");

        cmbbxBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbbxBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF", "Matrícula", "Telefone", "Nome do Responsável", "Data de Nascimento" }));

        txtfldBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btn03Buscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn03Buscar.setText("Buscar");

        btn03Cancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn03Cancelar.setText("Cancelar");
        btn03Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn03CancelarActionPerformed(evt);
            }
        });

        btn03Selecionar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn03Selecionar.setText("Selecionar");

        lblBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblBusca.setText("Buscar por:");

        tblBuscaAluno.setAutoCreateRowSorter(true);
        tblBuscaAluno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblBuscaAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblBuscaAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "Data de Nascimento", "CPF", "Data da Anamnese"
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
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbbxBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfldBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
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
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBusca)
                    .addComponent(cmbbxBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn03Buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
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
    private javax.swing.JTable tblBuscaAluno;
    private javax.swing.JTextField txtfldBusca;
    // End of variables declaration//GEN-END:variables
}
