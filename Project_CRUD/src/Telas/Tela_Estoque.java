
package Telas;

import Entidades.Produto;
import java.awt.Dimension;
import static java.lang.Float.parseFloat;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tela_Estoque extends javax.swing.JFrame { 

    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private Produto exibirProdutos;

    public Tela_Estoque() {

        initComponents();

        criarTabela();

        exibirProdutos = new Produto();
        exibirProdutos.setModeloTabela(modeloTabela);

        modeloTabela.addTableModelListener(e -> {
   
        });

        atualizarTabela();
    }

    private void criarTabela() {

        tabela = new JTable();
        modeloTabela = new DefaultTableModel();

        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("NOME");
        modeloTabela.addColumn("ESPECIFICAÇÕES");
        modeloTabela.addColumn("PREÇO CUSTO");
        modeloTabela.addColumn("PREÇO VENDA");
        modeloTabela.addColumn("ESTADO");

        tabela.setModel(modeloTabela);

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        setLayout(null);

        scrollPane.setBounds(50, 50, 400, 300);

        add(scrollPane);
    }

    private void atualizarTabela() {
        
        modeloTabela.setRowCount(0);

        for (Produto produto : Produto.listaProdutos) {
            exibirProdutos.adicionarProduto(produto);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Produtos");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jButton1.setText("Excluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(526, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(277, 277, 277)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
        int rowIndex = tabela.getSelectedRow();

        if (rowIndex != -1) {

            ((DefaultTableModel) tabela.getModel()).removeRow(rowIndex);

            Produto.listaProdutos.remove(rowIndex);

        } else {
            
            JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada", "Aviso", JOptionPane.WARNING_MESSAGE);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    int rowIndex = tabela.getSelectedRow();
        
     if (rowIndex != -1) {
    JOptionPane.showMessageDialog(this, "1 - NOME\n 2 - ESPECIFICAÇÕES\n 3 - PREÇO CUSTO\n 4 - PREÇO VENDA\n 5 - ESTADO\n", "Escolha um valor a ser alterado: ", JOptionPane.INFORMATION_MESSAGE);

    String op = JOptionPane.showInputDialog(this, "Digite o número da opção:");

    if (op != null && !op.isEmpty()) {
        switch (op) {
        case "1":
            String novoNome = JOptionPane.showInputDialog(this, "Digite o novo nome:");
            Produto.listaProdutos.get(rowIndex).setNome(novoNome);
            modeloTabela.setValueAt(novoNome, rowIndex, 1);
            break;
        case "2":
            String novasEspecificacoes = JOptionPane.showInputDialog(this, "Digite as novas especificações:");
            Produto.listaProdutos.get(rowIndex).setEspecificacoes(novasEspecificacoes);
            modeloTabela.setValueAt(novasEspecificacoes, rowIndex, 2);
            break;
        case "3":
            String novoPrecoCusto = JOptionPane.showInputDialog(this, "Digite o novo preço de custo:");
            Produto.listaProdutos.get(rowIndex).setPrecoCusto(parseFloat(novoPrecoCusto));
            modeloTabela.setValueAt(novoPrecoCusto, rowIndex, 3);
            break;
        case "4":
            String novoPrecoVenda = JOptionPane.showInputDialog(this, "Digite o novo preço de venda:");
            Produto.listaProdutos.get(rowIndex).setPrecoVenda(parseFloat(novoPrecoVenda));
            modeloTabela.setValueAt(novoPrecoVenda, rowIndex, 4);
            break;
        case "5":
            String[] opcoes = {"Habilitado", "Desabilitado"};
            int escolha = JOptionPane.showOptionDialog(
                this,
                "Escolha o novo estado:",
                "Escolha",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );
            if (escolha == 0 || escolha == 1) {
                boolean novoEstado = (escolha == 0);
                Produto.listaProdutos.get(rowIndex).setHabilitadoVendas(novoEstado);
                modeloTabela.setValueAt(novoEstado ? "Habilitado" : "Desabilitado", rowIndex, 5);
            } else {
                JOptionPane.showMessageDialog(this, "Escolha inválida", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            break;
            default:
                JOptionPane.showMessageDialog(this, "Opção inválida", "Aviso", JOptionPane.WARNING_MESSAGE);
                break;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Escolha não válida", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada", "Aviso", JOptionPane.WARNING_MESSAGE);
        }          
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Estoque().setVisible(true);
                
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
