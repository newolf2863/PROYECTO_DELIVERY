/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import basededatos.DataBase;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import mod_administracion.Cliente;
import mod_paquetes.Paquete;
import validaciones.*;



public class JFClientes extends javax.swing.JFrame {

    private boolean cedulaEsValida = false;
    private boolean nombreEsValido = false;
    private boolean apellidoEsValido = false;
    private boolean correoEsValido = false;
    private boolean telefonoEsValido = false;
    private boolean direccionEsValida = false;
    
    //ClasesValidadoras
    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
    //Mouse
    int xMouse, yMouse; 
    
    public JFClientes() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/iconos/icons8_Home_32px.png")).getImage());
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setLocationRelativeTo(null);
        cargarClientes();
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPRemitente = new javax.swing.JPanel();
        jPClientes = new javax.swing.JTabbedPane();
        jPPR1 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jTFNombresR = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jTFTelefonoR = new javax.swing.JTextField();
        jLTipoCli = new javax.swing.JLabel();
        jTFCIRegistrarC = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jTFDireccionR = new javax.swing.JTextField();
        jTFApellidosR = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        correoCli2 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jBRegistarCliente = new javax.swing.JButton();
        jPPA1 = new javax.swing.JPanel();
        jPActualizarClientes = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jBIActualizarAct1 = new javax.swing.JButton();
        CIselect = new javax.swing.JCheckBox();
        nombreSelect = new javax.swing.JCheckBox();
        apellidoSelect = new javax.swing.JCheckBox();
        apellidoActualizar = new javax.swing.JTextField();
        nombreActualizar = new javax.swing.JTextField();
        ciActualizar = new javax.swing.JTextField();
        telefonoSelect = new javax.swing.JCheckBox();
        direccionSelect = new javax.swing.JCheckBox();
        direccionActualizar = new javax.swing.JTextField();
        telefonoActualizar = new javax.swing.JTextField();
        correoSelect = new javax.swing.JCheckBox();
        correoActualizar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTCIBuscar = new javax.swing.JTextField();
        jBuscarCI = new javax.swing.JButton();
        jPPC1 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTablaClientesR = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remitente");
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        JPRemitente.setBackground(new java.awt.Color(245, 245, 245));
        JPRemitente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPRemitente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPPR1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));

        jLabel66.setText("Nombres");

        jTFNombresR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFNombresRFocusLost(evt);
            }
        });
        jTFNombresR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFNombresRKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombresRKeyTyped(evt);
            }
        });

        jLabel71.setText("Teléfono");

        jTFTelefonoR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFTelefonoRFocusLost(evt);
            }
        });
        jTFTelefonoR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFTelefonoRKeyReleased(evt);
            }
        });

        jLTipoCli.setText("CI");

        jTFCIRegistrarC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFCIRegistrarCFocusLost(evt);
            }
        });
        jTFCIRegistrarC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFCIRegistrarCKeyReleased(evt);
            }
        });

        jLabel73.setText("Dirección");

        jTFDireccionR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFDireccionRFocusLost(evt);
            }
        });
        jTFDireccionR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFDireccionRKeyReleased(evt);
            }
        });

        jTFApellidosR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFApellidosRFocusLost(evt);
            }
        });
        jTFApellidosR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFApellidosRKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFApellidosRKeyTyped(evt);
            }
        });

        jLabel89.setText("Apellidos");

        correoCli2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                correoCli2FocusLost(evt);
            }
        });
        correoCli2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                correoCli2KeyReleased(evt);
            }
        });

        jLabel87.setText("Correo");

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jLabel89)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel87, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFApellidosR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(correoCli2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTFCIRegistrarC, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel66)
                                .addComponent(jTFNombresR, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLTipoCli)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFDireccionR, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel73)
                            .addComponent(jTFTelefonoR, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel71))
                        .addGap(45, 45, 45))))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jLTipoCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFCIRegistrarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNombresR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFTelefonoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFDireccionR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel89)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFApellidosR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(correoCli2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPPR1.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, 241));

        jBRegistarCliente.setText("Registrar Cliente");
        jBRegistarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistarClienteActionPerformed(evt);
            }
        });
        jPPR1.add(jBRegistarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, -1));

        jPClientes.addTab("Registrar Cliente", jPPR1);

        jPPA1.setPreferredSize(new java.awt.Dimension(790, 459));
        jPPA1.setLayout(new java.awt.CardLayout());

        jPActualizarClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder("Actualizar Cliente"));
        jPanel40.setToolTipText("");
        jPanel40.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jBIActualizarAct1.setText("Actualizar");
        jBIActualizarAct1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIActualizarAct1ActionPerformed(evt);
            }
        });

        CIselect.setSelected(true);
        CIselect.setText("CI");
        CIselect.setEnabled(false);

        nombreSelect.setSelected(true);
        nombreSelect.setText("Nombres");
        nombreSelect.setEnabled(false);
        nombreSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreSelectActionPerformed(evt);
            }
        });

        apellidoSelect.setSelected(true);
        apellidoSelect.setText("Apellidos");
        apellidoSelect.setEnabled(false);

        apellidoActualizar.setEditable(false);

        nombreActualizar.setEditable(false);

        ciActualizar.setEditable(false);

        telefonoSelect.setText("Teléfono");
        telefonoSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoSelectActionPerformed(evt);
            }
        });

        direccionSelect.setText("Dirección");
        direccionSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionSelectActionPerformed(evt);
            }
        });

        direccionActualizar.setEnabled(false);
        direccionActualizar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                direccionActualizarFocusLost(evt);
            }
        });
        direccionActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                direccionActualizarKeyReleased(evt);
            }
        });

        telefonoActualizar.setEnabled(false);
        telefonoActualizar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                telefonoActualizarFocusLost(evt);
            }
        });
        telefonoActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telefonoActualizarKeyReleased(evt);
            }
        });

        correoSelect.setText("Correo");
        correoSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoSelectActionPerformed(evt);
            }
        });

        correoActualizar.setEnabled(false);
        correoActualizar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                correoActualizarFocusLost(evt);
            }
        });
        correoActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                correoActualizarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jBIActualizarAct1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telefonoSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreSelect)
                    .addComponent(CIselect)
                    .addComponent(correoSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direccionSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidoSelect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(correoActualizar)
                        .addComponent(ciActualizar)
                        .addComponent(direccionActualizar)
                        .addComponent(telefonoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(nombreActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(apellidoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CIselect)
                    .addComponent(ciActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreSelect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidoSelect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoSelect)
                    .addComponent(telefonoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionSelect)
                    .addComponent(direccionActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correoSelect)
                    .addComponent(correoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(jBIActualizarAct1)
                .addGap(14, 14, 14))
        );

        jPActualizarClientes.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 124, -1, 304));

        jLabel5.setText("CI");
        jPActualizarClientes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 66, 38, -1));
        jPActualizarClientes.add(jTCIBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 64, 200, 20));

        jBuscarCI.setText("Buscar");
        jBuscarCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarCIActionPerformed(evt);
            }
        });
        jPActualizarClientes.add(jBuscarCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 89, -1, -1));

        jPPA1.add(jPActualizarClientes, "card1");

        jPClientes.addTab("Actualizar Cliente", jPPA1);

        jPPC1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablaClientesR.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane16.setViewportView(jTablaClientesR);

        jPPC1.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 77, 898, 258));

        jPClientes.addTab("Consultar Clientes", jPPC1);

        JPRemitente.add(jPClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1060, 610));

        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel3.setBackground(new java.awt.Color(146, 10, 48));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Gestion de Envios");
        jPanel3.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Delete_32px.png"))); // NOI18N
        btnExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel3.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1055, 0, 35, 35));

        jPanel1.add(jPanel3, "card2");

        JPRemitente.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, -1));

        getContentPane().add(JPRemitente, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFNombresRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFNombresRFocusLost
        nombreEsValido = validarRegistroF.camposDeRegistros(jTFNombresR, "nombre");
        validarRegistroF.hideTooltip();
    }//GEN-LAST:event_jTFNombresRFocusLost

    private void jTFNombresRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombresRKeyTyped
        int maxLength = 40; // Límite de longitud de caracteres
        if (jTFNombresR.getText().length() >= maxLength) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFNombresRKeyTyped

    private void jTFTelefonoRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFTelefonoRFocusLost
        telefonoEsValido = validarRegistroF.camposDeRegistros(jTFTelefonoR, "telefono");
        validarRegistroF.hideTooltip();
    }//GEN-LAST:event_jTFTelefonoRFocusLost

    private void jTFCIRegistrarCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFCIRegistrarCFocusLost
        String cedula = jTFCIRegistrarC.getText();
        cedulaEsValida = validarRegistroF.camposDeRegistros(jTFCIRegistrarC, "cedula");
        validarRegistroF.hideTooltip();
    }//GEN-LAST:event_jTFCIRegistrarCFocusLost

    private void jTFDireccionRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFDireccionRFocusLost
        direccionEsValida = validarRegistroF.camposDeRegistros(jTFDireccionR, "direccion");
        validarRegistroF.hideTooltip();
    }//GEN-LAST:event_jTFDireccionRFocusLost

    private void jTFApellidosRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFApellidosRFocusLost
        apellidoEsValido = validarRegistroF.camposDeRegistros(jTFApellidosR, "nombre");
        validarRegistroF.hideTooltip();
    }//GEN-LAST:event_jTFApellidosRFocusLost

    private void jTFApellidosRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidosRKeyTyped
        int maxLength = 64; // Límite de longitud de caracteres
        if (jTFApellidosR.getText().length() >= maxLength) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFApellidosRKeyTyped

    private void correoCli2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoCli2FocusLost
        correoEsValido = validarRegistroF.camposDeRegistros(correoCli2, "email");
        validarRegistroF.hideTooltip();
    }//GEN-LAST:event_correoCli2FocusLost

    private void jBRegistarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistarClienteActionPerformed
        JTextField[] campos = {jTFCIRegistrarC, jTFNombresR, jTFApellidosR, correoCli2,
            jTFTelefonoR, jTFDireccionR};
        Boolean[] booleanosCliente = {cedulaEsValida, nombreEsValido, apellidoEsValido, correoEsValido,
            telefonoEsValido, direccionEsValida};
        String[] nombresCampos = {"documento", "nombre", "apellido", "correo", "teléfono", "dirección"};
        List<String> errores = validadorCheck.validarCamposLista(campos, booleanosCliente, nombresCampos);
        errores.addAll(validadorCheck.validarCamposVaciosLista(campos, booleanosCliente, nombresCampos));
        if (!errores.isEmpty()) {
            StringBuilder mensajeError = new StringBuilder("Se encontraron los siguientes errores:\n");
            for (String error : errores) {
                mensajeError.append("- ").append(error).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensajeError.toString(), "Errores", JOptionPane.ERROR_MESSAGE);
        } else {
            Object[] options = {"Si", "No"};
            int opcion = JOptionPane.showOptionDialog(null, "¿Deseas registrar los datos?", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (opcion == JOptionPane.YES_OPTION) {
                String nombresCliente = jTFNombresR.getText();
                String apellidosCliente = jTFApellidosR.getText();
                String telefonoClientes = jTFTelefonoR.getText();
                String direccionClientes = jTFDireccionR.getText();
                String correoDelCli = correoCli2.getText();
                String idCliente = jTFCIRegistrarC.getText();
                DataBase.obtenerInstancia().registrarCliente(nombresCliente, apellidosCliente, idCliente, direccionClientes, telefonoClientes, correoDelCli);
                vaciarCampos();
                JOptionPane.showMessageDialog(
                    null,
                    "El registro del cliente ha sido exitoso",
                    "Registro Exitoso",
                    JOptionPane.INFORMATION_MESSAGE
                );
                cargarClientes();
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    "El registro del cliente ha sido cancelado",
                    "Registro Cancelado",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_jBRegistarClienteActionPerformed

    private void jBIActualizarAct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIActualizarAct1ActionPerformed
        List<String> camposInvalidos = new ArrayList<>();
        String nuevaDireccion = null;
        String nuevoTelefono = null;
        String nuevoEmail = null;
        String atributoActualizar = "idCliente";
        String cedula = ciActualizar.getText();

        if (this.telefonoSelect.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(telefonoActualizar, "Teléfono del cliente")) {
                camposInvalidos.add("Teléfono del cliente");
            }
            nuevoTelefono = telefonoActualizar.getText();
        }

        if (this.direccionSelect.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(direccionActualizar, "Dirección del cliente")) {
                camposInvalidos.add("Dirección del cliente");
            }
            nuevaDireccion = direccionActualizar.getText();
        }

        if (this.correoSelect.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(correoActualizar, "Correo del cliente")) {
                camposInvalidos.add("Correo del cliente");
            }
            nuevoEmail = correoActualizar.getText();
        }

        if (!correoSelect.isSelected() && !direccionSelect.isSelected() && !telefonoSelect.isSelected()) {
            JOptionPane.showMessageDialog(this, "Seleccione al menos un atributo a actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detiene el registro si no se selecciona ningún atributo
        }

        if (!camposInvalidos.isEmpty()) {
            String camposInvalidosStr = String.join(", ", camposInvalidos);
            JOptionPane.showMessageDialog(this, "Los siguientes campos están vacíos: " + camposInvalidosStr, "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detiene el registro si hay campos inválidos
        }
        if (nuevaDireccion != null && !ValidadorDeRegistros.validarDireccion(nuevaDireccion)) {
            JOptionPane.showMessageDialog(null, "La nueva dirección no es válida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (nuevoTelefono != null && !ValidadorDeRegistros.validarTelefono(nuevoTelefono)) {
            JOptionPane.showMessageDialog(null, "El nuevo telefono no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (nuevoEmail != null && !ValidadorDeRegistros.validarEmail(nuevoEmail)) {
            JOptionPane.showMessageDialog(null, "El nuevo email no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (DataBase.obtenerInstancia().actualizarUsuario(cedula, nuevaDireccion, nuevoTelefono, nuevoEmail)) {
            JOptionPane.showMessageDialog(
                null,
                "El cliente ha sido actualizado",
                "Actualización Exitosa",
                JOptionPane.INFORMATION_MESSAGE
            );
            cargarClientes();
        }
    }//GEN-LAST:event_jBIActualizarAct1ActionPerformed

    private void direccionActualizarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_direccionActualizarFocusLost
    }//GEN-LAST:event_direccionActualizarFocusLost

    private void direccionActualizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionActualizarKeyReleased
    }//GEN-LAST:event_direccionActualizarKeyReleased

    private void telefonoActualizarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonoActualizarFocusLost
    }//GEN-LAST:event_telefonoActualizarFocusLost

    private void telefonoActualizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoActualizarKeyReleased
    }//GEN-LAST:event_telefonoActualizarKeyReleased

    private void correoActualizarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoActualizarFocusLost
    }//GEN-LAST:event_correoActualizarFocusLost

    private void correoActualizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoActualizarKeyReleased
    }//GEN-LAST:event_correoActualizarKeyReleased

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        getToolkit().beep();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro de cerrar la ventana?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void telefonoSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoSelectActionPerformed
        telefonoActualizar.setEnabled(telefonoSelect.isSelected());
    }//GEN-LAST:event_telefonoSelectActionPerformed

    private void direccionSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionSelectActionPerformed
        direccionActualizar.setEnabled(direccionSelect.isSelected());
    }//GEN-LAST:event_direccionSelectActionPerformed

    private void correoSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoSelectActionPerformed
        correoActualizar.setEnabled(correoSelect.isSelected());
    }//GEN-LAST:event_correoSelectActionPerformed

    private void jBuscarCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarCIActionPerformed
        String cedula = jTCIBuscar.getText();
        if (cedula.isBlank()) {
            JOptionPane.showMessageDialog(null, "Ingrese una cédula", "Llene el campo", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (!DataBase.obtenerInstancia().clienteExiste(cedula)) {
            JOptionPane.showMessageDialog(this, "El cliente no existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Cliente cliente = DataBase.obtenerInstancia().obtenerDatosPorCedula(cedula);
        ciActualizar.setText(cliente.getCedula());
        nombreActualizar.setText(cliente.getNombres());
        apellidoActualizar.setText(cliente.getApellidos());
        telefonoActualizar.setText(cliente.getTelefono());
        direccionActualizar.setText(cliente.getDireccion());
        correoActualizar.setText(cliente.getEmail());
        telefonoSelect.setSelected(false);
        direccionSelect.setSelected(false);
        correoSelect.setSelected(false);
        telefonoActualizar.setEnabled(false);
        direccionActualizar.setEnabled(false);
        correoActualizar.setEnabled(false);
    }//GEN-LAST:event_jBuscarCIActionPerformed

    private void nombreSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreSelectActionPerformed

    private void jTFCIRegistrarCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCIRegistrarCKeyReleased
        cedulaEsValida = validarRegistroF.camposDeRegistros(jTFCIRegistrarC, "cedula");
    }//GEN-LAST:event_jTFCIRegistrarCKeyReleased

    private void jTFNombresRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombresRKeyReleased
        nombreEsValido = validarRegistroF.camposDeRegistros(jTFNombresR, "nombre");
    }//GEN-LAST:event_jTFNombresRKeyReleased

    private void jTFApellidosRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidosRKeyReleased
       apellidoEsValido = validarRegistroF.camposDeRegistros(jTFApellidosR, "nombre");
    }//GEN-LAST:event_jTFApellidosRKeyReleased

    private void correoCli2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoCli2KeyReleased
       correoEsValido = validarRegistroF.camposDeRegistros(correoCli2, "email");
    }//GEN-LAST:event_correoCli2KeyReleased

    private void jTFTelefonoRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoRKeyReleased
       telefonoEsValido = validarRegistroF.camposDeRegistros(jTFTelefonoR, "telefono");
    }//GEN-LAST:event_jTFTelefonoRKeyReleased

    private void jTFDireccionRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDireccionRKeyReleased
       direccionEsValida = validarRegistroF.camposDeRegistros(jTFDireccionR, "direccion");
    }//GEN-LAST:event_jTFDireccionRKeyReleased

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
            java.util.logging.Logger.getLogger(JFClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CIselect;
    private javax.swing.JPanel JPRemitente;
    private javax.swing.JTextField apellidoActualizar;
    private javax.swing.JCheckBox apellidoSelect;
    private javax.swing.JButton btnExit;
    private javax.swing.JTextField ciActualizar;
    private javax.swing.JTextField correoActualizar;
    private javax.swing.JTextField correoCli2;
    private javax.swing.JCheckBox correoSelect;
    private javax.swing.JTextField direccionActualizar;
    private javax.swing.JCheckBox direccionSelect;
    private javax.swing.JButton jBIActualizarAct1;
    private javax.swing.JButton jBRegistarCliente;
    private javax.swing.JButton jBuscarCI;
    private javax.swing.JLabel jLTipoCli;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JPanel jPActualizarClientes;
    private javax.swing.JTabbedPane jPClientes;
    private javax.swing.JPanel jPPA1;
    private javax.swing.JPanel jPPC1;
    private javax.swing.JPanel jPPR1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JTextField jTCIBuscar;
    private javax.swing.JTextField jTFApellidosR;
    private javax.swing.JTextField jTFCIRegistrarC;
    private javax.swing.JTextField jTFDireccionR;
    private javax.swing.JTextField jTFNombresR;
    private javax.swing.JTextField jTFTelefonoR;
    private javax.swing.JTable jTablaClientesR;
    private javax.swing.JTextField nombreActualizar;
    private javax.swing.JCheckBox nombreSelect;
    private javax.swing.JTextField telefonoActualizar;
    private javax.swing.JCheckBox telefonoSelect;
    // End of variables declaration//GEN-END:variables

    private void vaciarCampos() {
        jTFCIRegistrarC.setText("");
        jTFNombresR.setText("");
        jTFTelefonoR.setText("");
        jTFApellidosR.setText("");
        correoCli2.setText("");
        jTFDireccionR.setText("");
    }

    private void cargarClientes() {
        DefaultTableModel model = new DefaultTableModel();
        jTablaClientesR.setModel(model);
        String[] columnNames = {
            "Nombres", "Apellidos", "Cedula", "Direccion", 
            "Telefono", "Email"
        };
        model.setColumnIdentifiers(columnNames);
        for (Cliente cliente : DataBase.obtenerInstancia().obtenerTodosLosUsuarios()) {
                model.addRow(new Object[]{
                cliente.getNombres(),
                cliente.getApellidos(),
                cliente.getCedula(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getEmail()
            });
        }    
    }
}