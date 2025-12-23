package br.com.infox.telas;

import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null; // conecta com o banco
    PreparedStatement pst = null; // pst prepara a conexao
    ResultSet rs = null; //rs exibe a conexão

    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    // método para consultar usuário
    private void consultar() {
        String sql = "select * from tbusuarios where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, idUsuarioInserir.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                nomeUsuarioInserir.setText(rs.getString(2));
                telefoneUsuarioInserir.setText(rs.getString(3));
                loginUsuarioInserir.setText(rs.getString(4));
                senhaUsuarioInserir.setText(rs.getString(5));
                perfilUsuarioInserir.setSelectedItem(rs.getString(6)); // essa linha se refere a combobox
                cargoUsuarioInserir.setText(rs.getString(7));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
                //as linhas abaixo "limpam" os campos
                nomeUsuarioInserir.setText(null);
                telefoneUsuarioInserir.setText(null);
                loginUsuarioInserir.setText(null);
                senhaUsuarioInserir.setText(null);
                cargoUsuarioInserir.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // metodo para adiconar usuarios
    private void adicionar() {
        String sql = "insert into tbusuarios(iduser,usuario,fone,login,senha,perfil,cargo) values(?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, idUsuarioInserir.getText());
            pst.setString(2, nomeUsuarioInserir.getText());
            pst.setString(3, telefoneUsuarioInserir.getText());
            pst.setString(4, loginUsuarioInserir.getText());
            pst.setString(5, senhaUsuarioInserir.getText());
            pst.setString(6, perfilUsuarioInserir.getSelectedItem().toString());
            pst.setString(7, cargoUsuarioInserir.getText());
            //validação dos campos obrigatorios
            if ((idUsuarioInserir.getText().isEmpty()) || (nomeUsuarioInserir.getText().isEmpty()) || (loginUsuarioInserir.getText().isEmpty()) || (senhaUsuarioInserir.getText().isEmpty()) || (cargoUsuarioInserir.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

            
            // a linha abaixo atualiza a tabela usuario com os dados do formulario
            int adicionado = pst.executeUpdate();
            // a linha abaixo serve de apoio de entendendimento da logica
            //System.out.println(adicionado);
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");
                //as linhas abaixo "limpam" os campos
                idUsuarioInserir.setText(null);
                nomeUsuarioInserir.setText(null);
                telefoneUsuarioInserir.setText(null);
                loginUsuarioInserir.setText(null);
                senhaUsuarioInserir.setText(null);
                cargoUsuarioInserir.setText(null);
            }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idUsuario = new javax.swing.JLabel();
        nomeUsuario = new javax.swing.JLabel();
        loginUsuario = new javax.swing.JLabel();
        senhaUsuario = new javax.swing.JLabel();
        perfilUsuario = new javax.swing.JLabel();
        cargoUsuario = new javax.swing.JLabel();
        idUsuarioInserir = new javax.swing.JTextField();
        nomeUsuarioInserir = new javax.swing.JTextField();
        loginUsuarioInserir = new javax.swing.JTextField();
        senhaUsuarioInserir = new javax.swing.JTextField();
        cargoUsuarioInserir = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        perfilUsuarioInserir = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        createUsuario = new javax.swing.JButton();
        readUsuario = new javax.swing.JButton();
        updateUsuario = new javax.swing.JButton();
        deleteUsuario = new javax.swing.JButton();
        senhaUsuario1 = new javax.swing.JLabel();
        telefoneUsuarioInserir = new javax.swing.JTextField();
        camposObrigatorios = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(600, 600));

        idUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        idUsuario.setText("*ID");

        nomeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nomeUsuario.setText("*Nome");

        loginUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        loginUsuario.setText("*Login");

        senhaUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        senhaUsuario.setText("*Senha");

        perfilUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        perfilUsuario.setText("*Perfil");

        cargoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cargoUsuario.setText("*Cargo");

        idUsuarioInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idUsuarioInserirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("Dados de Usuários");

        perfilUsuarioInserir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "adm", "usuario" }));
        perfilUsuarioInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilUsuarioInserirActionPerformed(evt);
            }
        });

        createUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/create.png"))); // NOI18N
        createUsuario.setToolTipText("Adicionar");
        createUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUsuarioActionPerformed(evt);
            }
        });

        readUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/read.png"))); // NOI18N
        readUsuario.setToolTipText("Consultar");
        readUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        readUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readUsuarioActionPerformed(evt);
            }
        });

        updateUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/update.png"))); // NOI18N
        updateUsuario.setToolTipText("Alterar");
        updateUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUsuarioActionPerformed(evt);
            }
        });

        deleteUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/delete.png"))); // NOI18N
        deleteUsuario.setToolTipText("Remover");
        deleteUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        senhaUsuario1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        senhaUsuario1.setText("Telefone");

        camposObrigatorios.setText("*Campos obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(createUsuario)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(perfilUsuario)
                                    .addComponent(cargoUsuario)
                                    .addComponent(senhaUsuario1))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cargoUsuarioInserir)
                                    .addComponent(perfilUsuarioInserir, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(telefoneUsuarioInserir)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeUsuario)
                                    .addComponent(idUsuario)
                                    .addComponent(loginUsuario)
                                    .addComponent(senhaUsuario))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeUsuarioInserir, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(loginUsuarioInserir)
                                    .addComponent(senhaUsuarioInserir)
                                    .addComponent(idUsuarioInserir)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 171, Short.MAX_VALUE)))
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(readUsuario)
                        .addGap(82, 82, 82)
                        .addComponent(updateUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteUsuario)
                        .addGap(76, 76, 76))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(camposObrigatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(camposObrigatorios)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idUsuarioInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idUsuario))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomeUsuario)
                            .addComponent(nomeUsuarioInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(loginUsuarioInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(loginUsuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaUsuarioInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefoneUsuarioInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaUsuario1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(perfilUsuarioInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(perfilUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cargoUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cargoUsuarioInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(createUsuario)
                    .addComponent(deleteUsuario)
                    .addComponent(updateUsuario)
                    .addComponent(readUsuario))
                .addGap(71, 71, 71))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cargoUsuario, idUsuario, loginUsuario, nomeUsuario, perfilUsuario, senhaUsuario});

        setBounds(0, 0, 600, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void idUsuarioInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idUsuarioInserirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idUsuarioInserirActionPerformed

    private void perfilUsuarioInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilUsuarioInserirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perfilUsuarioInserirActionPerformed

    private void createUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUsuarioActionPerformed
        //chamando o metodo adicionar
        adicionar();
    }//GEN-LAST:event_createUsuarioActionPerformed

    private void readUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readUsuarioActionPerformed
        // chamando o metodo consultar
        consultar();
    }//GEN-LAST:event_readUsuarioActionPerformed

    private void updateUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel camposObrigatorios;
    private javax.swing.JLabel cargoUsuario;
    private javax.swing.JTextField cargoUsuarioInserir;
    private javax.swing.JButton createUsuario;
    private javax.swing.JButton deleteUsuario;
    private javax.swing.JLabel idUsuario;
    private javax.swing.JTextField idUsuarioInserir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel loginUsuario;
    private javax.swing.JTextField loginUsuarioInserir;
    private javax.swing.JLabel nomeUsuario;
    private javax.swing.JTextField nomeUsuarioInserir;
    private javax.swing.JLabel perfilUsuario;
    private javax.swing.JComboBox<String> perfilUsuarioInserir;
    private javax.swing.JButton readUsuario;
    private javax.swing.JLabel senhaUsuario;
    private javax.swing.JLabel senhaUsuario1;
    private javax.swing.JTextField senhaUsuarioInserir;
    private javax.swing.JTextField telefoneUsuarioInserir;
    private javax.swing.JButton updateUsuario;
    // End of variables declaration//GEN-END:variables
}
