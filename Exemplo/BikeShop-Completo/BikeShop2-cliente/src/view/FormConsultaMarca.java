/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import modelDominio.Marca;
import view.tablemodel.MarcaTableModel;

/**
 *
 * @author herrmann
 */
public class FormConsultaMarca extends javax.swing.JDialog {

    // TableModel da Tabela de Marcas que será utilizada 
    private MarcaTableModel marcamodel;     
    
    // Método para atualizar a tabela a cada vez 
    public void atualizarTabela(){
        switch (jCmbFiltro.getSelectedIndex()){ // verificando o filtro selecionado
            // se o usuário escolheu NOME (case 1)
            // então chama o método getlistaMarcaNome do Controller passando o texto digitado
            // Esse método retorna somente as Marcas que atenderem aos filtros selecionados
            case 1 :  
                marcamodel = new MarcaTableModel(BikeShopcliente.ccont.marcaListaNome(jtxtProcurar.getText()));
                break;
            // Qualquer outra coisa chama o método getlistaMarca do Controller
            // Esse método retorna todas as Marcas
            default : 
                marcamodel = new MarcaTableModel(BikeShopcliente.ccont.marcaLista());
        }
        jtblMarcas.setModel(marcamodel); //setando o modelo correto para a tabela do formulário
   }
    
    /**
     * Creates new form frmConsultaMarca
     */
    public FormConsultaMarca() {
        initComponents();
        atualizarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblMarcas = new javax.swing.JTable();
        jCmbFiltro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jtxtProcurar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Marcas");

        jtblMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtblMarcas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblMarcasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblMarcas);

        jCmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Nome" }));
        jCmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbFiltroActionPerformed(evt);
            }
        });

        jLabel1.setText("Campo para busca:");

        jtxtProcurar.setToolTipText("");
        jtxtProcurar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtProcurarKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(184, 219, 227));

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/left-arrow.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVoltar.setFocusable(false);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/plus.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAdicionar.setFocusable(false);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jCmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        //Criando o formulário de cadastro passando null como parâmetro
        //O formulário de cadastro recebe uma Raça como parâmetro, quando for para editar 
        // um registro. Neste caso, estamos adicionando um novo registro.
        FormCadastroMarca frmrac = new FormCadastroMarca(null);
        // abrindo formulario modal (Só é possível quando o formulário for do tipo JDialog
        frmrac.setModal(true);
        // Como foi setado para o formulário ser MODAL. Aqui o sistema ficará travado
        frmrac.setVisible(true); 
        // Quando o usuário fechar o cadastro de Marcas deve-se novamente atualizar a tabela
        atualizarTabela();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void jtblMarcasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblMarcasMouseClicked
        //Criando o formulário de cadastro passando a Marca selecionada como parâmetro
        //O formulário de cadastro recebe uma Raça como parâmetro, quando for para editar 
        // um registro. Note que o método getMarca foi implementado anteriormente no 
        // TableModelo
        Marca rc = marcamodel.getMarca(jtblMarcas.getSelectedRow());
        FormCadastroMarca frmcadrac = new FormCadastroMarca(rc);
        // abrindo formulario modal (Só é possível quando o formulário for do tipo JDialog
        frmcadrac.setModal(true);
         // Como foi setado para o formulário ser MODAL. Aqui o sistema ficará travado
        frmcadrac.setVisible(true);
        // Quando o usuário fechar o cadastro de Marcas deve-se novamente atualizar a tabela
        atualizarTabela();
    }//GEN-LAST:event_jtblMarcasMouseClicked

    private void jCmbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbFiltroActionPerformed
        // Quando o usuário muda o filtro o método atualizarTabela é chamado
        atualizarTabela(); 
    }//GEN-LAST:event_jCmbFiltroActionPerformed

    private void jtxtProcurarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtProcurarKeyReleased
        // Quando o usuário digitar algo no campo de procura o método atualizarTabela é chamado
        atualizarTabela(); 
    }//GEN-LAST:event_jtxtProcurarKeyReleased

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(FormConsultaMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormConsultaMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormConsultaMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormConsultaMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new FormConsultaMarca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> jCmbFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable jtblMarcas;
    private javax.swing.JTextField jtxtProcurar;
    // End of variables declaration//GEN-END:variables
}
