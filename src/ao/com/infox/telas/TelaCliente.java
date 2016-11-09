/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.com.infox.telas;

import ao.com.infox.dal.Conexao;
import com.sun.xml.internal.ws.client.ContentNegotiation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
// A linha abaixo importa recurso da biblioteca rs2xml.jar
import net.proteanit.sql.DbUtils;

/**
 *
 * @author proresol
 */
public class TelaCliente extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        conexao = Conexao.conector();
    }

    /**
     * This method is called from within the constructor to initialize th e
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    //Metodo que adiciona clientes na banco de dados a partir do formulario
    private void adicionarcliente() {
        try {
            String sql = "insert into tbclientes(nomecli,enderecocli,telefonecli,correiocli) values (?,?,?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeCli.getText());
            pst.setString(2, txtEndCli.getText());
            pst.setString(3, txtTelCli.getText());
            pst.setString(4, txtEmailCli.getText());

            // validação dos campos obrigatorios
            if (txtNomeCli.getText().isEmpty() || txtTelCli.getText().isEmpty() || txtEndCli.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");
                    txtNomeCli.setText(null);
                    txtEndCli.setText(null);
                    txtTelCli.setText(null);
                    txtEmailCli.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    //Metodo para consultar dados do cliente apartir do formulario
    private void pesquisarCliente() {
        //String SQL = "select * from tbclientes  where nomecli like ?";
        String SQL="select idcli as Codigo,nomecli as Nome, enderecocli as Endereço, telefonecli as Telefone, correiocli as Email from tbclientes where nomecli like ?";
        try {
            pst=conexao.prepareStatement(SQL);
            //Passando o conteudo caixa de pesquisa para string SQL concatenada com %
            pst.setString(1,txtCliPesquisar.getText()  + "%");          
            rs=pst.executeQuery();
            // Usando a bibilioteca rs2xml.jar para preencher a tabela
            tblclientes.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    // metodo para passar o conteudo da tabela para o formulario
    private void passar_campos(){
        int passar = tblclientes.getSelectedRow();
        txtidcli.setText(tblclientes.getModel().getValueAt(passar,0).toString());
        txtNomeCli.setText(tblclientes.getModel().getValueAt(passar,1).toString());
        txtEmailCli.setText(tblclientes.getModel().getValueAt(passar,2).toString());
        txtTelCli.setText(tblclientes.getModel().getValueAt(passar,3).toString());
        txtEndCli.setText(tblclientes.getModel().getValueAt(passar,4).toString());
        // a linha abaixo desabilita o butão adicionar
        btnCliAdicionar.setEnabled(false);

    }
    private void alterarcliente() {
        try {
            String sql = "update tbclientes set enderecocli=?,telefonecli=?,correiocli=?,nomecli=? where  idcli=?";
            pst = conexao.prepareStatement(sql);            
            pst.setString(1, txtEndCli.getText());
            pst.setString(2, txtTelCli.getText());
            pst.setString(3, txtEmailCli.getText());
            pst.setString(4, txtNomeCli.getText());
            pst.setString(5, txtidcli.getText());
             // validação dos campos obrigatorios
            if (txtNomeCli.getText().isEmpty() || txtTelCli.getText().isEmpty() || txtEndCli.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente Alterado com sucesso");
                    txtNomeCli.setText(null);
                    txtEndCli.setText(null);
                    txtTelCli.setText(null);
                    txtEmailCli.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    private void removercliente() {
        try {
            int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja elimiar este cliente", "Atenção",JOptionPane.YES_OPTION);
            if (confirmar==JOptionPane.YES_OPTION) {        
                String sql = "delete  from tbclientes where idcli=?";
                pst = conexao.prepareStatement(sql);            
                pst.setString(1, txtidcli.getText());              
                int removido = pst.executeUpdate();
                if (removido > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
                    txtNomeCli.setText(null);
                    txtEndCli.setText(null);
                    txtTelCli.setText(null);
                    txtEmailCli.setText(null);
                    btnCliAdicionar.setEnabled(true);
                }
              }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNomeCli = new javax.swing.JTextField();
        txtTelCli = new javax.swing.JTextField();
        txtEmailCli = new javax.swing.JTextField();
        txtEndCli = new javax.swing.JTextField();
        btnCliAdicionar = new javax.swing.JButton();
        btnCliAlterar = new javax.swing.JButton();
        btnUsuEliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCliPesquisar = new javax.swing.JTextField();
        btnCliPesquisar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblclientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtidcli = new javax.swing.JTextField();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

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
        jScrollPane2.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(740, 580));

        jLabel2.setText("* Nome");

        jLabel3.setText("* Telefone");

        jLabel4.setText("* Endereço");

        jLabel5.setText("E-mail");

        btnCliAdicionar.setIcon(new javax.swing.ImageIcon("/home/proresol/Imagens/icones/file_add.png")); // NOI18N
        btnCliAdicionar.setToolTipText("Adicionar");
        btnCliAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliAdicionar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCliAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliAdicionarActionPerformed(evt);
            }
        });

        btnCliAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ao/com/infox/icons/file_edit.png"))); // NOI18N
        btnCliAlterar.setToolTipText("Alterar");
        btnCliAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliAlterarActionPerformed(evt);
            }
        });

        btnUsuEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ao/com/infox/icons/file_delete.png"))); // NOI18N
        btnUsuEliminar.setToolTipText("Eliminar");
        btnUsuEliminar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuEliminarActionPerformed(evt);
            }
        });

        jLabel6.setText("* Campos obrogatórios");

        txtCliPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliPesquisarKeyReleased(evt);
            }
        });

        btnCliPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ao/com/infox/icons/find.png"))); // NOI18N

        tblclientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblclientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblclientes);

        jLabel1.setText("Codigo");

        txtidcli.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(btnCliAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(btnCliAlterar)
                .addGap(100, 100, 100)
                .addComponent(btnUsuEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(txtEmailCli, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTelCli, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNomeCli)
                                    .addComponent(txtEndCli)
                                    .addComponent(txtidcli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 222, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtidcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmailCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEndCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnCliAlterar)
                        .addComponent(btnCliAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnUsuEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCliAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliAdicionarActionPerformed
        // Chamando o mentoodo adicionar
        adicionarcliente();
    }//GEN-LAST:event_btnCliAdicionarActionPerformed

    private void btnCliAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliAlterarActionPerformed
        // Cahamando o metudo alterar
         alterarcliente();
         // a linha abaixo desabilita o butão adicionar
          btnCliAdicionar.setEnabled(true);
    }//GEN-LAST:event_btnCliAlterarActionPerformed

    private void btnUsuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuEliminarActionPerformed
        // Cahando o metodo eliminar
        removercliente();
    }//GEN-LAST:event_btnUsuEliminarActionPerformed
    // o evento abaixo pesquisa dados em fução da letras que forem digitadas
    private void txtCliPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliPesquisarKeyReleased
        // Chamando o metodo pesquisar clientes
        pesquisarCliente();
    }//GEN-LAST:event_txtCliPesquisarKeyReleased
// o evento abaixo preenche os dados do formulario com a linha selecinada na tabela
    private void tblclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblclientesMouseClicked
        //Camanddo o metodo passar campos
        passar_campos();
        
    }//GEN-LAST:event_tblclientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliAdicionar;
    private javax.swing.JButton btnCliAlterar;
    private javax.swing.JButton btnCliPesquisar;
    private javax.swing.JButton btnUsuEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblclientes;
    private javax.swing.JTextField txtCliPesquisar;
    private javax.swing.JTextField txtEmailCli;
    private javax.swing.JTextField txtEndCli;
    private javax.swing.JTextField txtNomeCli;
    private javax.swing.JTextField txtTelCli;
    private javax.swing.JTextField txtidcli;
    // End of variables declaration//GEN-END:variables
}
