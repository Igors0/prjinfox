/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.com.infox.telas;

import ao.com.infox.dal.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    //Metodo para consultar dados do cliente apartir do formulario
    private void consultar(){
         String SQL = "select * from tbclientes where idcliente =?";
        try {
            pst = conexao.prepareStatement(SQL);
            pst.setString(1, txtIdCliente.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtNomeCliente.setText(rs.getString(2));
                txtEndCliente.setText(rs.getString(3));
                txtTelCliente.setText(rs.getString(4));          
                txtEmailCliente.setText(rs.getString(5));
                
            } else {
                JOptionPane.showMessageDialog(null, "Utilizador não cadastrado");
                //as Linha abaixo limpam os campos caso o utilizador não exista
                //txtUsuNome.setText(null);
                //txtUsuTelefone.setText(null);
                //txtUsuLogin.setText(null);
                //txtUsuSenha.setText(null);
               // cboUsuPerfil.setSelectedItem(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        txtNomeCliente = new javax.swing.JTextField();
        txtTelCliente = new javax.swing.JTextField();
        txtEmailCliente = new javax.swing.JTextField();
        txtEndCliente = new javax.swing.JTextField();
        btnUsuAdicionar = new javax.swing.JButton();
        btnUsuConsultar = new javax.swing.JButton();
        btnUsualterar = new javax.swing.JButton();
        btnUsuEliminar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(640, 480));

        jLabel1.setText("Codigo");

        jLabel2.setText("* Nome");

        jLabel3.setText("* Telefone");

        jLabel4.setText("* Endereço");

        jLabel5.setText("E-mail");

        btnUsuAdicionar.setIcon(new javax.swing.ImageIcon("/home/proresol/Imagens/icones/file_add.png")); // NOI18N
        btnUsuAdicionar.setToolTipText("Adicionar");
        btnUsuAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuAdicionar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuAdicionarActionPerformed(evt);
            }
        });

        btnUsuConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ao/com/infox/icons/file_search.png"))); // NOI18N
        btnUsuConsultar.setToolTipText("Consultar");
        btnUsuConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuConsultar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuConsultarActionPerformed(evt);
            }
        });

        btnUsualterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ao/com/infox/icons/file_edit.png"))); // NOI18N
        btnUsualterar.setToolTipText("Alterar");
        btnUsualterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsualterarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEndCliente)
                                    .addComponent(txtEmailCliente)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUsuAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(btnUsuConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(btnUsualterar)
                                .addGap(48, 48, 48)
                                .addComponent(btnUsuEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEndCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUsuAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnUsuEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUsualterar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuAdicionarActionPerformed
        // Chamando o mentoodo adicionar
       // adicionar();
    }//GEN-LAST:event_btnUsuAdicionarActionPerformed

    private void btnUsuConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuConsultarActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_btnUsuConsultarActionPerformed

    private void btnUsualterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsualterarActionPerformed
        // Cahamando o metudo alterar
       // alterar();
    }//GEN-LAST:event_btnUsualterarActionPerformed

    private void btnUsuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuEliminarActionPerformed
        // Cahando o metodo eliminar
       // eliminar();
    }//GEN-LAST:event_btnUsuEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsuAdicionar;
    private javax.swing.JButton btnUsuConsultar;
    private javax.swing.JButton btnUsuEliminar;
    private javax.swing.JButton btnUsualterar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtEndCliente;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtTelCliente;
    // End of variables declaration//GEN-END:variables
}
