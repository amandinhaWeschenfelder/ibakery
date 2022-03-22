/**
NOME: Luana Kuntz e Amanda Weschenfelder
TURMA: INF4AT
DATA: 02/02/2022
 */
package view;

import javax.swing.JOptionPane;
import modelDominio.Produto;
import view.gerente.*;
import view.*;

public class formCadastroCaixa extends javax.swing.JDialog {

   
    public formCadastroCaixa() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        logo2 = new javax.swing.JLabel();
        jTFIdentificadorVenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jBCadastrarVenda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListaProduto = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jBCadastrarProdutoLista = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jSQuantidadeProduto = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFValor = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jCBProdutos = new javax.swing.JComboBox<>();
        jBAtualizarProduto1 = new javax.swing.JButton();

        jPanel4.setBackground(new java.awt.Color(215, 181, 109));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela cadastro de venda");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(570, 565));

        jPanel5.setBackground(new java.awt.Color(215, 181, 109));

        logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Logo.png"))); // NOI18N
        logo2.setText("jLabel3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(logo2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(logo2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTFIdentificadorVenda.setEditable(false);
        jTFIdentificadorVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIdentificadorVendaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu Condensed", 1, 18)); // NOI18N
        jLabel3.setText("Cadastro de vendas");
        jLabel3.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel1.setText("ID");

        jBCadastrarVenda.setBackground(new java.awt.Color(140, 61, 44));
        jBCadastrarVenda.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jBCadastrarVenda.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrarVenda.setText("Finalizar");
        jBCadastrarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarVendaActionPerformed(evt);
            }
        });

        jTListaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "Qtd", "Un. medida", "R$ "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTListaProduto);
        if (jTListaProduto.getColumnModel().getColumnCount() > 0) {
            jTListaProduto.getColumnModel().getColumn(1).setMinWidth(80);
            jTListaProduto.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTListaProduto.getColumnModel().getColumn(1).setMaxWidth(80);
            jTListaProduto.getColumnModel().getColumn(2).setMinWidth(80);
            jTListaProduto.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTListaProduto.getColumnModel().getColumn(2).setMaxWidth(80);
            jTListaProduto.getColumnModel().getColumn(3).setMinWidth(80);
            jTListaProduto.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTListaProduto.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        jLabel12.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel12.setText("Quantidade:");
        jLabel12.setToolTipText("O seu nome será utilizado para login. Ex: amanda.");

        jBCadastrarProdutoLista.setBackground(new java.awt.Color(140, 61, 44));
        jBCadastrarProdutoLista.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jBCadastrarProdutoLista.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrarProdutoLista.setText("Adicionar");
        jBCadastrarProdutoLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarProdutoListaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel13.setText("Produto:");
        jLabel13.setToolTipText("O seu nome será utilizado para login. Ex: amanda.");

        jLabel10.setFont(new java.awt.Font("Ubuntu Condensed", 1, 18)); // NOI18N
        jLabel10.setText("Produtos");

        jLabel4.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel4.setText("R$:");

        jTFValor.setEditable(false);

        jPanel6.setBackground(new java.awt.Color(215, 181, 109));
        jPanel6.setPreferredSize(new java.awt.Dimension(570, 61));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        jBAtualizarProduto1.setBackground(new java.awt.Color(140, 61, 44));
        jBAtualizarProduto1.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jBAtualizarProduto1.setForeground(new java.awt.Color(255, 255, 255));
        jBAtualizarProduto1.setText("Voltar");
        jBAtualizarProduto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarProduto1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(80, 80, 80)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTFIdentificadorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBCadastrarProdutoLista))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(37, 37, 37)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jCBProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(76, 76, 76)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jBCadastrarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBAtualizarProduto1))
                                .addComponent(jTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFIdentificadorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jCBProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jSQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCadastrarProdutoLista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCadastrarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAtualizarProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadastrarProdutoListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarProdutoListaActionPerformed
        Produto produto = (Produto) jCBProdutos.getSelectedItem(); 
        int quantidade = Integer.parseInt(jSQuantidadeProduto.getValue().toString());
        
        if (produto.equals("")){ 
            JOptionPane.showMessageDialog(this, "Selecione um produto!");
            jCBProdutos.requestFocus();
        } else if (quantidade <0){
            JOptionPane.showMessageDialog(this, "Quantidade inválida! \n Digite um valor maior que zero!");
            jSQuantidadeProduto.requestFocus();
        } else {
        
        }
    }//GEN-LAST:event_jBCadastrarProdutoListaActionPerformed

    private void jTFIdentificadorVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIdentificadorVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIdentificadorVendaActionPerformed

    private void jBCadastrarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarVendaActionPerformed
        
        
    }//GEN-LAST:event_jBCadastrarVendaActionPerformed

    private void jBAtualizarProduto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarProduto1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBAtualizarProduto1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formCadastroCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formCadastroCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formCadastroCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formCadastroCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formCadastroCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBAtualizarProduto1;
    private javax.swing.JButton jBCadastrarProdutoLista;
    private javax.swing.JButton jBCadastrarVenda;
    private javax.swing.JComboBox<String> jCBProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSpinner jSQuantidadeProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFIdentificadorVenda;
    private javax.swing.JTextField jTFValor;
    private javax.swing.JTable jTListaProduto;
    private javax.swing.JLabel logo2;
    // End of variables declaration//GEN-END:variables
}
