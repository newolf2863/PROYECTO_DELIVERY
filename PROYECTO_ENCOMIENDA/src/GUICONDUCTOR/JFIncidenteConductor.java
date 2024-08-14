/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUICONDUCTOR;

import GUI.*;
import mod_incidentes.ErrorDireccion;
import mod_incidentes.GestorIncidente;
import mod_incidentes.EstadoIncidente;
import mod_incidentes.PaqueteEstropeado;
import mod_incidentes.PaquetePerdido;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import mod_administracion.Conductor;
import mod_administracion.Recepcionista;
import mod_paquetes.EnCurso;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;
import mod_paquetes.Pendiente;
import mod_paquetes.Seguimiento;
import mod_transporte.Asignacion;
import validaciones.*;

/**
 * JFrame para la gestión de incidentes por parte de conductores
 * Incluye funcionalidades para registrar y resolver incidentes
 * Se conecta con otros módulos para obtener y actualizar datos de incidentes
 * y paquetes
 * 
 * @Grupo: Segunda es Todo
 */
public class JFIncidenteConductor extends javax.swing.JFrame {

    /**
     * Creates new form JFIncidente
     * Constructor que inicializa el formulario de incidentes
     * @param inventario Listado de paquetes disponibles
     */
    //Validadores
    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
    ArrayList<Paquete> inventario;
    
    //Mouse
    int xMouse, yMouse;

    //Incidentes
    private boolean idIncidenteValidar = false;
    private boolean descriptionValidar = false;
    private boolean seleccionValidar = false;

    /**
     * Constructor que inicializa el formulario de incidentes
     * @param inventario Listado de paquetes disponibles
     */
    public JFIncidenteConductor(ArrayList<Paquete> inventario) {
        initComponents();
        this.inventario = inventario;
        setIconImage(new ImageIcon(getClass().getResource("/iconos/exclamacion.png")).getImage());
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setLocationRelativeTo(null);
        placeHolder();
        jBRegistrarIncidente.setVisible(false);
        jTablaPaquete.setVisible(false);
        cargarIncidentes();
        
    }

    /**
     * Método para colocar un placeholder en el campo de código de tracking
     */
    private void placeHolder() {
        TextPrompt texto1 = new TextPrompt("Obligatorio", jTCodigoTracking);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPIncidentes = new javax.swing.JPanel();
        jPIncidentes = new javax.swing.JPanel();
        jTPEmpleados1 = new javax.swing.JTabbedPane();
        jPRE1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        seleccionIncidentes = new javax.swing.JComboBox<>();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jTCodigoTracking = new javax.swing.JTextField();
        jBConsultarPaquete = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTablaPaquete = new javax.swing.JTable();
        jBRegistrarIncidente = new javax.swing.JButton();
        jPAE1 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jTCodigoResolver = new javax.swing.JTextField();
        jBConsultarIncidente = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTIncidente = new javax.swing.JTable();
        jBResolverIncidente = new javax.swing.JButton();
        jLabel138 = new javax.swing.JLabel();
        jTArgumentos = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Incidentes");
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        JPIncidentes.setBackground(new java.awt.Color(245, 245, 245));
        JPIncidentes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPIncidentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTPEmpleados1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPEmpleados1MouseClicked(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        seleccionIncidentes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Daño en el Paquete", "Error de Dirección", "Paquete Perdido", "Rechazo Entrega" }));
        seleccionIncidentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionIncidentesActionPerformed(evt);
            }
        });

        jLabel133.setText("Tipo de incidente:");

        jLabel134.setText("Código tracking");

        jTCodigoTracking.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCodigoTrackingFocusLost(evt);
            }
        });
        jTCodigoTracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCodigoTrackingActionPerformed(evt);
            }
        });
        jTCodigoTracking.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCodigoTrackingKeyReleased(evt);
            }
        });

        jBConsultarPaquete.setText("Consultar");
        jBConsultarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarPaqueteActionPerformed(evt);
            }
        });

        jTablaPaquete.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTablaPaquete);

        jBRegistrarIncidente.setText("Registrar");
        jBRegistrarIncidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarIncidenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel134, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTCodigoTracking, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seleccionIncidentes, javax.swing.GroupLayout.Alignment.LEADING, 0, 157, Short.MAX_VALUE))
                        .addGap(263, 263, 263))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jBConsultarPaquete)
                        .addGap(113, 113, 113))))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(302, 302, 302)
                    .addComponent(jBRegistrarIncidente)
                    .addContainerGap(307, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel134)
                    .addComponent(jTCodigoTracking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBConsultarPaquete)
                .addGap(2, 2, 2)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133)
                    .addComponent(seleccionIncidentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                    .addContainerGap(368, Short.MAX_VALUE)
                    .addComponent(jBRegistrarIncidente)
                    .addGap(10, 10, 10)))
        );

        javax.swing.GroupLayout jPRE1Layout = new javax.swing.GroupLayout(jPRE1);
        jPRE1.setLayout(jPRE1Layout);
        jPRE1Layout.setHorizontalGroup(
            jPRE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRE1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPRE1Layout.setVerticalGroup(
            jPRE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRE1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jTPEmpleados1.addTab("Registrar Incidente", jPRE1);

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel137.setText("Código tracking");

        jTCodigoResolver.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCodigoResolverFocusLost(evt);
            }
        });
        jTCodigoResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCodigoResolverActionPerformed(evt);
            }
        });
        jTCodigoResolver.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCodigoResolverKeyReleased(evt);
            }
        });

        jBConsultarIncidente.setText("Consultar");
        jBConsultarIncidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarIncidenteActionPerformed(evt);
            }
        });

        jTIncidente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTIncidente);

        jBResolverIncidente.setText("Resolver");
        jBResolverIncidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResolverIncidenteActionPerformed(evt);
            }
        });

        jLabel138.setText("Argumentos");

        jTArgumentos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTArgumentosFocusLost(evt);
            }
        });
        jTArgumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTArgumentosActionPerformed(evt);
            }
        });
        jTArgumentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTArgumentosKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 37, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jTArgumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(257, 257, 257))))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTCodigoResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jBConsultarIncidente))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jBResolverIncidente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTCodigoResolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBConsultarIncidente))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTArgumentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel138))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jBResolverIncidente)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPAE1Layout = new javax.swing.GroupLayout(jPAE1);
        jPAE1.setLayout(jPAE1Layout);
        jPAE1Layout.setHorizontalGroup(
            jPAE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAE1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPAE1Layout.setVerticalGroup(
            jPAE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAE1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTPEmpleados1.addTab("Resolver Incidente", jPAE1);

        javax.swing.GroupLayout jPIncidentesLayout = new javax.swing.GroupLayout(jPIncidentes);
        jPIncidentes.setLayout(jPIncidentesLayout);
        jPIncidentesLayout.setHorizontalGroup(
            jPIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIncidentesLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jTPEmpleados1, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPIncidentesLayout.setVerticalGroup(
            jPIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIncidentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTPEmpleados1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        JPIncidentes.add(jPIncidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1080, 640));

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

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Gestion de Envios");

        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/power_24dp.png"))); // NOI18N
        btnExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1040, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JPIncidentes.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, -1));

        getContentPane().add(JPIncidentes, "card6");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción al seleccionar un incidente
     * @param evt evento de selección
     */
    private void seleccionIncidentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionIncidentesActionPerformed

    }//GEN-LAST:event_seleccionIncidentesActionPerformed

    /**
     * Acción al soltar una tecla en el campo de código de tracking
     * @param evt evento de teclado
     */
    private void jTCodigoTrackingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCodigoTrackingKeyReleased

    }//GEN-LAST:event_jTCodigoTrackingKeyReleased

    /**
     * Acción al presionar el botón de consultar paquete
     * @param evt evento de acción
     */
    private void jBConsultarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarPaqueteActionPerformed
        if (jTCodigoTracking.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Ingrese un código tracking", "Llene el campo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Paquete paqueteIncidente = obtenerPaquete(jTCodigoTracking.getText());
        if(inventario == null){
            JOptionPane.showMessageDialog(null, "No tiene Paquetes","No tiene Paquetes", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for(Paquete paquete: inventario){
            if(paquete.getCodigoTracking().equals(jTCodigoTracking.getText())){
                paqueteIncidente = paquete;
            }
        }
        if (paqueteIncidente == null) {
            JOptionPane.showMessageDialog(null, "El paquete no existe", "Código tracking no existe", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        model.addColumn("Propiedad");
        model.addColumn("Valor");
        model.addRow(new Object[]{"Código de Tracking", paqueteIncidente.getCodigoTracking()});
        model.addRow(new Object[]{"Volumen", paqueteIncidente.getVolumen() + " m³"});
        model.addRow(new Object[]{"Peso", paqueteIncidente.getPeso() + " kg"});
        model.addRow(new Object[]{"Contenido", paqueteIncidente.getContenido()});
        model.addRow(new Object[]{"Remitente", paqueteIncidente.getRemitente().toString()});
        model.addRow(new Object[]{"Provincia Origen", paqueteIncidente.getProvinciaOrigen().name()});
        model.addRow(new Object[]{"Provincia Destino", paqueteIncidente.getProvinciaDestino().name()});
        model.addRow(new Object[]{"Dirección Destino", paqueteIncidente.getDireccionDestino()});
        model.addRow(new Object[]{"Estado", paqueteIncidente.obtenerEstado().toString()});
        model.addRow(new Object[]{"Distancia Estimada", paqueteIncidente.calcularDistancia() + " Km"});
        jTablaPaquete.setModel(model);
        jBRegistrarIncidente.setVisible(true);
        jTablaPaquete.setVisible(true);
    }//GEN-LAST:event_jBConsultarPaqueteActionPerformed

    /**
     * Acción al hacer clic en el tab de empleados
     * @param evt evento de mouse
     */
    private void jTPEmpleados1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPEmpleados1MouseClicked

    }//GEN-LAST:event_jTPEmpleados1MouseClicked

    /**
     * Acción al presionar el botón de salir
     * @param evt evento de acción
     */
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        getToolkit().beep();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro de quieres cerrar la ventana?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * Acción al arrastrar el panel superior
     * @param evt evento de mouse
     */
    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel3MouseDragged

    /**
     * Acción al presionar el panel superior
     * @param evt evento de mouse
     */
    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    /**
     * Acción al perder el foco en el campo de código de tracking
     * @param evt evento de foco
     */
    private void jTCodigoTrackingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCodigoTrackingFocusLost
        
    }//GEN-LAST:event_jTCodigoTrackingFocusLost

    /**
     * Acción al realizar acción en el campo de código de tracking
     * @param evt evento de acción
     */
    private void jTCodigoTrackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCodigoTrackingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCodigoTrackingActionPerformed

    /**
     * Método para obtener un paquete según su código de tracking
     * @param codigo Código de tracking del paquete
     * @return Paquete encontrado o null si no existe
     */
    private Paquete obtenerPaquete(String codigo){
        for(Paquete paquete :inventario){
            if(paquete.getCodigoTracking().equals(codigo)){
                return paquete;
            }
        }
        return null;
    }
    
    /**
     * Acción al presionar el botón de registrar incidente
     * @param evt evento de acción
     */
    private void jBRegistrarIncidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarIncidenteActionPerformed
        if (jTCodigoTracking.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Ingrese un código tracking", "Llene el campo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String incidente = (String) seleccionIncidentes.getSelectedItem();
        Paquete paquete = obtenerPaquete(jTCodigoTracking.getText());
        EstadoIncidente incidenteRegistrar = null;
        if (incidente.equals("Error Dirección")) {
            incidenteRegistrar = new ErrorDireccion();
        } else if (incidente.equals("Paquete Estropeado")) {
            incidenteRegistrar = new PaqueteEstropeado();
        } else if (incidente.equals("Paquete Perdido")) {
            incidenteRegistrar = new PaquetePerdido();
        }
        if (!(paquete.obtenerEstado() instanceof EnCurso)) {
            JOptionPane.showMessageDialog(
                null,
                "El paquete se encuentra fuera de su jurisdicción",
                "Registro falló",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(
            null,
            "¿Estás seguro de que deseas registrar este incidente?",
            "Confirmación de registro",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            GestorIncidente gi = new GestorIncidente(incidenteRegistrar);
            gi.crearIncidente(paquete);
            JOptionPane.showMessageDialog(
                null,
                "El incidente se ha registrado",
                "Registro Exitoso",
                JOptionPane.INFORMATION_MESSAGE
            );
            Asignacion.obtenerInstancia().guardarRelacionPaquetes();
            DefaultTableModel modeloTabla = (DefaultTableModel) jTablaPaquete.getModel();
            modeloTabla.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(
                null,
                "El registro del incidente se ha cancelado",
                "Registro Cancelado",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }//GEN-LAST:event_jBRegistrarIncidenteActionPerformed

    /**
     * Acción al perder el foco en el campo de código de resolver
     * @param evt evento de foco
     */
    private void jTCodigoResolverFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCodigoResolverFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCodigoResolverFocusLost

    /**
     * Acción al realizar acción en el campo de código de resolver
     * @param evt evento de acción
     */
    private void jTCodigoResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCodigoResolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCodigoResolverActionPerformed

    /**
     * Acción al soltar una tecla en el campo de código de resolver
     * @param evt evento de teclado
     */
    private void jTCodigoResolverKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCodigoResolverKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCodigoResolverKeyReleased

    /**
     * Acción al presionar el botón de consultar incidente
     * @param evt evento de acción
     */
    private void jBConsultarIncidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarIncidenteActionPerformed
        if (jTCodigoResolver.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Ingrese un código tracking", "Llene el campo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Paquete paquete = obtenerPaquete(jTCodigoResolver.getText());
        if (paquete == null) {
            JOptionPane.showMessageDialog(null, "El paquete no existe", "Código tracking no existe", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Seguimiento seguimiento = paquete.obtenerSeguimiento();
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        model.addColumn("Propiedad");
        model.addColumn("Valor");
        model.addRow(new Object[]{"Estado del paquete", seguimiento.obtenerEstado()});
        model.addRow(new Object[]{"Incidente", seguimiento.obtenerRegistroIncidente()});
        jTIncidente.setModel(model);
        jBResolverIncidente.setVisible(true);
    }//GEN-LAST:event_jBConsultarIncidenteActionPerformed

    /**
     * Acción al presionar el botón de resolver incidente
     * @param evt evento de acción
     */
    private void jBResolverIncidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResolverIncidenteActionPerformed
        Paquete paquete = obtenerPaquete(jTCodigoResolver.getText());
        String incidente = paquete.obtenerSeguimiento().obtenerRegistroIncidente();
        EstadoIncidente incidenteRegistrar = null;
        
        if (incidente.equals("No se ha podido entregar el paquete en la dirección proporcionada")) {
            incidenteRegistrar = new ErrorDireccion();
        } else if (incidente.equals("El paquete se encuentra en malas condiciones")) {
            incidenteRegistrar = new PaqueteEstropeado();
        } else if (incidente.equals("La ubicación de su paquete es desconocida")) {
            incidenteRegistrar = new PaquetePerdido();
        }
        if (!(paquete.obtenerEstado() instanceof EnCurso)) {
            JOptionPane.showMessageDialog(
                null,
                "El paquete se encuentra fuera de su jurisdicción",
                "Resolución falló",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        String argumentos = jTArgumentos.getText();
        if (argumentos.isBlank()) {
            JOptionPane.showMessageDialog(
                null,
                "Ingrese los argumentos",
                "Error",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(
            null,
            "¿Estás seguro de que deseas resolver este incidente?",
            "Confirmación de resolución",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            String[] partes = argumentos.split("\\s+");
            GestorIncidente gi = new GestorIncidente(incidenteRegistrar);
            gi.iniciarSoporte(paquete, partes);
            JOptionPane.showMessageDialog(
                null,
                "El incidente se ha resuelto",
                "Resolución Exitosa",
                JOptionPane.INFORMATION_MESSAGE
            );
            Asignacion.obtenerInstancia().guardarRelacionPaquetes();
            DefaultTableModel modeloTabla = (DefaultTableModel) jTIncidente.getModel();
            modeloTabla.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(
                null,
                "La resolución del incidente se ha cancelado",
                "Resolución Cancelada",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }//GEN-LAST:event_jBResolverIncidenteActionPerformed

    /**
     * Acción al perder el foco en el campo de argumentos
     * @param evt evento de foco
     */
    private void jTArgumentosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTArgumentosFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTArgumentosFocusLost

    /**
     * Acción al realizar acción en el campo de argumentos
     * @param evt evento de acción
     */
    private void jTArgumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTArgumentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTArgumentosActionPerformed

    /**
     * Acción al soltar una tecla en el campo de argumentos
     * @param evt evento de teclado
     */
    private void jTArgumentosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTArgumentosKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTArgumentosKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPIncidentes;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton jBConsultarIncidente;
    private javax.swing.JButton jBConsultarPaquete;
    private javax.swing.JButton jBRegistrarIncidente;
    private javax.swing.JButton jBResolverIncidente;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPAE1;
    private javax.swing.JPanel jPIncidentes;
    private javax.swing.JPanel jPRE1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField jTArgumentos;
    private javax.swing.JTextField jTCodigoResolver;
    private javax.swing.JTextField jTCodigoTracking;
    private javax.swing.JTable jTIncidente;
    private javax.swing.JTabbedPane jTPEmpleados1;
    private javax.swing.JTable jTablaPaquete;
    private javax.swing.JComboBox<String> seleccionIncidentes;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para cargar los tipos de incidentes en el JComboBox
     */
    private void cargarIncidentes() {
        seleccionIncidentes.removeAllItems();
        seleccionIncidentes.addItem("Error Dirección");
        seleccionIncidentes.addItem("Paquete Estropeado");
        seleccionIncidentes.addItem("Paquete Perdido");
    }
}
