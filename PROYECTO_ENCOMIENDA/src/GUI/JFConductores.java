/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import basededatos.DataBase;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import mod_administracion.Conductor;
import mod_administracion.Recepcionista;
import mod_transporte.Asignacion;
import validaciones.*;

/**
 *
 * @author USUARIO
 */
public class JFConductores extends javax.swing.JFrame {
    // Validadores

    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
    private Recepcionista recepcionista;

    // Mouse
    int xMouse, yMouse;

    public JFConductores(Recepcionista recepcionista) {
        initComponents();
        this.recepcionista = recepcionista;
        setIconImage(new ImageIcon(getClass().getResource("/iconos/exclamacion.png")).getImage());
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setLocationRelativeTo(null);
        cargarConductores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPProovedores = new javax.swing.JPanel();
        jPGP = new javax.swing.JTabbedPane();
        jPPR = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTConductores = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTCedulaConductor = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTNombreConductor = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTApellidoConductor = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jTTelefonoConductor = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jTCorreoConductor = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jTDireccionConductor = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTClaveConductor = new javax.swing.JTextField();
        jTNombreUsuario1 = new javax.swing.JTextField();
        jBRegistrarConductor = new javax.swing.JButton();
        jPPC = new javax.swing.JPanel();
        jPIA = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTablaConductor = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTCodigoEliminar = new javax.swing.JTextField();
        jBEliminarConductor = new javax.swing.JButton();
        jBConsultarConductor = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        JPProovedores.setBackground(new java.awt.Color(245, 245, 245));
        JPProovedores.setMinimumSize(new java.awt.Dimension(1180, 540));
        JPProovedores.setPreferredSize(new java.awt.Dimension(1180, 660));
        JPProovedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPPR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTConductores.setModel(new javax.swing.table.DefaultTableModel(
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
        jTConductores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTConductoresMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTConductores);

        jPPR.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 1080, 210));

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos conductor"));
        jPanel15.setToolTipText("");
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos personales del conductor"));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setText("Cédula");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 29, -1, -1));

        jTCedulaConductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCedulaConductorFocusLost(evt);
            }
        });
        jTCedulaConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCedulaConductorKeyReleased(evt);
            }
        });
        jPanel9.add(jTCedulaConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 21, 247, -1));

        jLabel22.setText("Nombres");
        jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 54, -1, -1));

        jTNombreConductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTNombreConductorFocusLost(evt);
            }
        });
        jTNombreConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreConductorKeyReleased(evt);
            }
        });
        jPanel9.add(jTNombreConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 51, 247, -1));

        jLabel23.setText("Apellido");
        jPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 85, -1, -1));

        jTApellidoConductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTApellidoConductorFocusLost(evt);
            }
        });
        jTApellidoConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTApellidoConductorKeyReleased(evt);
            }
        });
        jPanel9.add(jTApellidoConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 82, 247, -1));

        jLabel107.setText("Teléfono");
        jPanel9.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 116, -1, -1));

        jTTelefonoConductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTTelefonoConductorFocusLost(evt);
            }
        });
        jTTelefonoConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTTelefonoConductorKeyReleased(evt);
            }
        });
        jPanel9.add(jTTelefonoConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 110, 247, -1));

        jLabel87.setText("Correo");
        jPanel9.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 150, 43, -1));

        jTCorreoConductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCorreoConductorFocusLost(evt);
            }
        });
        jTCorreoConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCorreoConductorKeyReleased(evt);
            }
        });
        jPanel9.add(jTCorreoConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 144, 247, -1));

        jLabel73.setText("Dirección");
        jPanel9.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 181, -1, -1));

        jTDireccionConductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTDireccionConductorFocusLost(evt);
            }
        });
        jTDireccionConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTDireccionConductorKeyReleased(evt);
            }
        });
        jPanel9.add(jTDireccionConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 178, 246, -1));

        jLabel25.setText("Nombre de usuario");
        jPanel9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 24, -1, -1));

        jLabel26.setText("Clave");
        jPanel9.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 89, -1, -1));

        jTClaveConductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTClaveConductorFocusLost(evt);
            }
        });
        jTClaveConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTClaveConductorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTClaveConductorKeyTyped(evt);
            }
        });
        jPanel9.add(jTClaveConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 111, 187, -1));

        jTNombreUsuario1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTNombreUsuario1FocusLost(evt);
            }
        });
        jTNombreUsuario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreUsuario1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNombreUsuario1KeyTyped(evt);
            }
        });
        jPanel9.add(jTNombreUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 45, 187, -1));

        jPanel15.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 24, 638, 234));

        jBRegistrarConductor.setText("Registrar datos");
        jBRegistrarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarConductorActionPerformed(evt);
            }
        });
        jPanel15.add(jBRegistrarConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 276, -1, -1));

        jPPR.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 930, 310));

        jPGP.addTab("Registrar Conductor", jPPR);

        jPPC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPIA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        jPIA.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 110, -1, -1));

        jTablaConductor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTablaConductor);

        jPIA.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 860, 237));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Cedula Conductor");
        jPIA.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));
        jPIA.add(jTCodigoEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 200, 20));

        jBEliminarConductor.setText("Eliminar");
        jBEliminarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarConductorActionPerformed(evt);
            }
        });
        jPIA.add(jBEliminarConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 110, 40));

        jBConsultarConductor.setText("Ver Conductor");
        jBConsultarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarConductorActionPerformed(evt);
            }
        });
        jPIA.add(jBConsultarConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        jPPC.add(jPIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 575));

        jPGP.addTab("Eliminar Conductor", jPPC);

        JPProovedores.add(jPGP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1140, 600));

        jPanel3.setBackground(new java.awt.Color(146, 10, 48));
        jPanel3.setMinimumSize(new java.awt.Dimension(1180, 35));
        jPanel3.setPreferredSize(new java.awt.Dimension(1180, 35));
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
        jLabel69.setText("Conductores");
        jPanel3.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        JPProovedores.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(JPProovedores, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTConductoresMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTConductoresMouseClicked

    }// GEN-LAST:event_jTConductoresMouseClicked

    private void jTCedulaConductorFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTCedulaConductorFocusLost
        // cedulaConductorValidar =
        // validarRegistroF.camposDeRegistros(jTCedulaConductor, errorProveedores3,
        // "cedula");
    }// GEN-LAST:event_jTCedulaConductorFocusLost

    private void jTCedulaConductorKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTCedulaConductorKeyReleased
        // cedulaConductorValidar =
        // validarRegistroF.camposDeRegistros(jTCedulaConductor, errorProveedores3,
        // "cedula");
    }// GEN-LAST:event_jTCedulaConductorKeyReleased

    private void jTNombreConductorFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTNombreConductorFocusLost
        // nombreConductorValidar =
        // validarRegistroF.camposDeRegistros(jTNombreConductor, errorProveedores4,
        // "n");
    }// GEN-LAST:event_jTNombreConductorFocusLost

    private void jTNombreConductorKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTNombreConductorKeyReleased
        // nombreConductorValidar =
        // validarRegistroF.camposDeRegistros(jTNombreConductor, errorProveedores4,
        // "n");
    }// GEN-LAST:event_jTNombreConductorKeyReleased

    private void jTApellidoConductorFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTApellidoConductorFocusLost
        // apellidoConductorValidar =
        // validarRegistroF.camposDeRegistros(jTApellidoConductor, errorProveedores5,
        // "n");
    }// GEN-LAST:event_jTApellidoConductorFocusLost

    private void jTApellidoConductorKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTApellidoConductorKeyReleased
        // apellidoConductorValidar =
        // validarRegistroF.camposDeRegistros(jTApellidoConductor, errorProveedores5,
        // "n");
    }// GEN-LAST:event_jTApellidoConductorKeyReleased

    private void jTTelefonoConductorFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTTelefonoConductorFocusLost
        // telefonoConductorValidar =
        // validarRegistroF.camposDeRegistros(jTTelefonoConductor, errorProveedores6,
        // "telefono");
    }// GEN-LAST:event_jTTelefonoConductorFocusLost

    private void jTTelefonoConductorKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTTelefonoConductorKeyReleased
        // telefonoConductorValidar =
        // validarRegistroF.camposDeRegistros(jTTelefonoConductor, errorProveedores6,
        // "telefono");
    }// GEN-LAST:event_jTTelefonoConductorKeyReleased

    private void jBRegistrarConductorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBRegistrarConductorActionPerformed
        String cedula = jTCedulaConductor.getText();
        if (!ValidadorDeRegistros.validarCedula(cedula)) {
            JOptionPane.showMessageDialog(this, "Cédula es inválida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (DataBase.obtenerInstancia().clienteExiste(cedula)) {
            JOptionPane.showMessageDialog(this, "Cédula ya registrada", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nombres = jTNombreConductor.getText();
        if (!ValidadorDeRegistros.validarNombres(nombres)) {
            JOptionPane.showMessageDialog(this, "Los nombres son inválidos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String apellidos = jTApellidoConductor.getText();
        if (!ValidadorDeRegistros.validarNombres(apellidos)) {
            JOptionPane.showMessageDialog(this, "Los apellidos son inválidos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String telefono = jTTelefonoConductor.getText();
        if (!ValidadorDeRegistros.validarTelefono(telefono)) {
            JOptionPane.showMessageDialog(this, "El teléfono es inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String correo = jTCorreoConductor.getText();
        if (!ValidadorDeRegistros.validarEmail(correo)) {
            JOptionPane.showMessageDialog(this, "El correo es inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String direccion = jTDireccionConductor.getText();
        if (!ValidadorDeRegistros.validarDireccion(direccion)) {
            JOptionPane.showMessageDialog(this, "La dirección es inválida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nombreUsuario = jTNombreUsuario1.getText();
        if (nombreUsuario.isEmpty() || nombreUsuario.length() < 5) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario es inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String clave = jTClaveConductor.getText();
        if (clave.isEmpty() || clave.length() < 5) {
            JOptionPane.showMessageDialog(this, "La clave es inválida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!DataBase.obtenerInstancia().esNombreUsuarioUnico(nombreUsuario)) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DataBase.obtenerInstancia().insertarConductor(nombres, apellidos, cedula, direccion, telefono, correo,
                nombreUsuario, clave, recepcionista.obtenerSucursal());
        Conductor conductor = new Conductor(nombres, apellidos, cedula, direccion, telefono, correo);
        Asignacion.obtenerInstancia().agregarConductor(conductor);

        JOptionPane.showMessageDialog(
                null,
                "El registro del conductor ha sido exitoso",
                "Registro Exitoso",
                JOptionPane.INFORMATION_MESSAGE);
        vaciarCampos();
        cargarConductores();
    }// GEN-LAST:event_jBRegistrarConductorActionPerformed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }// GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }// GEN-LAST:event_jPanel3MousePressed

    private void jTCorreoConductorFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTCorreoConductorFocusLost
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCorreoConductorFocusLost

    private void jTCorreoConductorKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTCorreoConductorKeyReleased
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCorreoConductorKeyReleased

    private void jTDireccionConductorFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTDireccionConductorFocusLost
        // TODO add your handling code here:
    }// GEN-LAST:event_jTDireccionConductorFocusLost

    private void jTDireccionConductorKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTDireccionConductorKeyReleased
        // TODO add your handling code here:
    }// GEN-LAST:event_jTDireccionConductorKeyReleased

    private void jTClaveConductorFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTClaveConductorFocusLost
        // TODO add your handling code here:
    }// GEN-LAST:event_jTClaveConductorFocusLost

    private void jTClaveConductorKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTClaveConductorKeyReleased
        // TODO add your handling code here:
    }// GEN-LAST:event_jTClaveConductorKeyReleased

    private void jTNombreUsuario1FocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTNombreUsuario1FocusLost
        // TODO add your handling code here:
    }// GEN-LAST:event_jTNombreUsuario1FocusLost

    private void jTNombreUsuario1KeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTNombreUsuario1KeyReleased
        // TODO add your handling code here:
    }// GEN-LAST:event_jTNombreUsuario1KeyReleased

    private void jTNombreUsuario1KeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTNombreUsuario1KeyTyped
        char c = evt.getKeyChar();
        if (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
            if (!((Character.isLetter(c) && Character.isLowerCase(c))
                    || (Character.isLetter(c) && Character.isUpperCase(c))
                    || Character.isDigit(c) || c == 'ñ' || c == 'Ñ')) {
                evt.consume(); // No permite ingresar el carácter
                // Mostrar mensaje de advertencia
                JOptionPane.showMessageDialog(this, "Solo se permiten letras y números.");
            }
        }
    }// GEN-LAST:event_jTNombreUsuario1KeyTyped

    private void jTClaveConductorKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTClaveConductorKeyTyped
        char c = evt.getKeyChar();
        if (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
            if (!((Character.isLetter(c) && Character.isLowerCase(c))
                    || (Character.isLetter(c) && Character.isUpperCase(c))
                    || Character.isDigit(c) || c == 'ñ' || c == 'Ñ')) {
                evt.consume(); // No permite ingresar el carácter
                // Mostrar mensaje de advertencia
                JOptionPane.showMessageDialog(this, "Solo se permiten letras y números.");
            }
        }
    }// GEN-LAST:event_jTClaveConductorKeyTyped

    private void jBEliminarConductorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBEliminarConductorActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Estás seguro de que deseas eliminar el conductor con cedula: " + jTCodigoEliminar.getText() + "?",
                "Confirmación de Eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            String codigo = jTCodigoEliminar.getText();

            // El usuario confirmó la eliminación
            Conductor conductor = Asignacion.obtenerInstancia().obtenerConductorPorCedula(codigo);
            Asignacion.obtenerInstancia().eliminarConductor(conductor);
            Asignacion.obtenerInstancia().borrarRelacionConductorVehiculo(conductor);
            Asignacion.obtenerInstancia().guardarConductores();
            JOptionPane.showMessageDialog(
                    null,
                    "El conductor con cedula " + jTCodigoEliminar.getText() + " ha sido eliminado.",
                    "Eliminación Exitosa",
                    JOptionPane.INFORMATION_MESSAGE);
            DefaultTableModel modeloTabla = (DefaultTableModel) jTablaConductor.getModel();
            modeloTabla.setRowCount(0);
        } else {
            // El usuario canceló la eliminación
            JOptionPane.showMessageDialog(
                    null,
                    "La eliminación del conductor con cedula " + jTCodigoEliminar.getText() + " ha sido cancelada.",
                    "Eliminación Cancelada",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }// GEN-LAST:event_jBEliminarConductorActionPerformed

    private void jBConsultarConductorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBConsultarConductorActionPerformed
        String codigo = jTCodigoEliminar.getText();
        Conductor conductor = Asignacion.obtenerInstancia().obtenerConductorPorCedula(codigo);
        if (codigo.isBlank()) {
            JOptionPane.showMessageDialog(null, "Ingrese una cedula", "Llene el campo",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (conductor == null) {
            JOptionPane.showMessageDialog(null, "El Conductor no existe", "El Conductor no existe",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        String[] columnNames = {
                "Cedula", "Nombres", "Email", "Telefono"
        };
        model.setColumnIdentifiers(columnNames);
        model.addRow(new Object[] {
                conductor.getCedula(),
                conductor.getNombres() + " " + conductor.getApellidos(),
                conductor.getEmail(),
                conductor.getTelefono()
        });
        jTablaConductor.setModel(model);
        jTablaConductor.setVisible(true);
        jBEliminarConductor.setVisible(true);
    }// GEN-LAST:event_jBConsultarConductorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPProovedores;
    private javax.swing.JButton jBConsultarConductor;
    private javax.swing.JButton jBEliminarConductor;
    private javax.swing.JButton jBRegistrarConductor;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JTabbedPane jPGP;
    private javax.swing.JPanel jPIA;
    private javax.swing.JPanel jPPC;
    private javax.swing.JPanel jPPR;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTApellidoConductor;
    private javax.swing.JTextField jTCedulaConductor;
    private javax.swing.JTextField jTClaveConductor;
    private javax.swing.JTextField jTCodigoEliminar;
    private javax.swing.JTable jTConductores;
    private javax.swing.JTextField jTCorreoConductor;
    private javax.swing.JTextField jTDireccionConductor;
    private javax.swing.JTextField jTNombreConductor;
    private javax.swing.JTextField jTNombreUsuario1;
    private javax.swing.JTextField jTTelefonoConductor;
    private javax.swing.JTable jTablaConductor;
    // End of variables declaration//GEN-END:variables

    private void vaciarCampos() {
        jTCedulaConductor.setText("");
        jTNombreConductor.setText("");
        jTApellidoConductor.setText("");
        jTTelefonoConductor.setText("");
        jTCorreoConductor.setText("");
        jTDireccionConductor.setText("");
        jTNombreUsuario1.setText("");
        jTClaveConductor.setText("");
    }

    private void cargarConductores() {
        DefaultTableModel model = (DefaultTableModel) jTConductores.getModel();
        ArrayList<Conductor> conductores = Asignacion.obtenerInstancia().obtenerConductores();
        model.setRowCount(0);
        String[] columnNames = {
                "Cedula", "Nombres", "Email", "Telefono"
        };
        model.setColumnIdentifiers(columnNames);
        for (Conductor conductor : conductores) {
            Object[] row = {
                    conductor.getNombres(),
                    conductor.getApellidos(),
                    conductor.getCedula(),
                    conductor.getDireccion(),
                    conductor.getTelefono(),
                    conductor.getEmail(),
            };
            model.addRow(row);
        }
    }
}
