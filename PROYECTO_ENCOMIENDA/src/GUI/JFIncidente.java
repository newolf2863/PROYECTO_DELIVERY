/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import mod_incidentes.ErrorDireccion;
import mod_incidentes.Incidente;
import mod_incidentes.PaqueteEstropeado;
import mod_incidentes.PaquetePerdido;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import mod_administracion.Recepcionista;
import mod_administracion.ReporteNoPermitido;
import mod_incidentes.DevolucionPaquete;
import mod_incidentes.PaqueteNoTieneIncidente;
import mod_incidentes.PaqueteYaTieneIncidente;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;
import mod_paquetes.Seguimiento;

/**
 *
 * @author Moises Arequipa
 * @Grupo: Segunda es Todo
 */
public class JFIncidente extends javax.swing.JFrame {

    Recepcionista recepcionista;

    // Mouse
    int xMouse, yMouse;

    public JFIncidente(Recepcionista recepcionista) {
        initComponents();
        this.recepcionista = recepcionista;
        setIconImage(new ImageIcon(getClass().getResource("/iconos/exclamacion.png")).getImage());
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        jBRegistrarIncidente.setVisible(false);
        jTablaPaquete.setVisible(false);
        cargarIncidentes();
        
        DefaultTableModel modelo = new DefaultTableModel();
        jTIncidente.setModel(modelo);
        String[] columnNames = {
                "Propiedad", "Valor"
        };
        jTablaPaquete.setModel(modelo);
        modelo.setColumnIdentifiers(columnNames);
        jBResolverIncidente.setVisible(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
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
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Incidentes");
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        JPIncidentes.setBackground(new java.awt.Color(245, 245, 245));
        JPIncidentes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPIncidentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPIncidentes.setMinimumSize(new java.awt.Dimension(1180, 680));
        jPIncidentes.setPreferredSize(new java.awt.Dimension(1180, 607));
        jPIncidentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTPEmpleados1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPEmpleados1MouseClicked(evt);
            }
        });

        jPRE1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addContainerGap(37, Short.MAX_VALUE)
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
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
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

        jPRE1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 24, -1, -1));

        jTPEmpleados1.addTab("Registrar Incidente", jPRE1);

        jPAE1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel137.setText("Código tracking");
        jPanel11.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 163, -1));

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
        jPanel11.add(jTCodigoResolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 157, -1));

        jBConsultarIncidente.setText("Consultar");
        jBConsultarIncidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarIncidenteActionPerformed(evt);
            }
        });
        jPanel11.add(jBConsultarIncidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, -1, -1));

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
        jTIncidente.setRowHeight(40);
        jScrollPane8.setViewportView(jTIncidente);

        jPanel11.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 110, 930, 237));

        jBResolverIncidente.setText("Resolver");
        jBResolverIncidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResolverIncidenteActionPerformed(evt);
            }
        });
        jPanel11.add(jBResolverIncidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, -1, -1));

        jPAE1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 28, 1000, 520));

        jTPEmpleados1.addTab("Resolver Incidente", jPAE1);

        jPIncidentes.add(jTPEmpleados1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 6, -1, -1));

        JPIncidentes.add(jPIncidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1160, 640));

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
        jLabel69.setText("Incidentes");
        jPanel3.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        JPIncidentes.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 30));

        getContentPane().add(JPIncidentes, "card6");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionIncidentesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_seleccionIncidentesActionPerformed

    }// GEN-LAST:event_seleccionIncidentesActionPerformed

    private void jTCodigoTrackingKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTCodigoTrackingKeyReleased

    }// GEN-LAST:event_jTCodigoTrackingKeyReleased

    private void jBConsultarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBConsultarPaqueteActionPerformed
        Inventario inventario = Inventario.obtenerInstancia();
        if (jTCodigoTracking.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Ingrese un código tracking", "Llene el campo",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!inventario.existePaquete(jTCodigoTracking.getText())) {
            JOptionPane.showMessageDialog(null, "El paquete no existe", "Código tracking no existe",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Paquete paquete = inventario.obtenerPaquete(jTCodigoTracking.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        model.addColumn("Propiedad");
        model.addColumn("Valor");
        model.addRow(new Object[] { "Código de Tracking", paquete.obtenerCodigo() });
        model.addRow(new Object[] { "Volumen", paquete.getVolumen() + " m³" });
        model.addRow(new Object[] { "Peso", paquete.getPeso() + " kg" });
        model.addRow(new Object[] { "Contenido", paquete.getContenido() });
        model.addRow(new Object[] { "Remitente", paquete.getRemitente().toString() });
        model.addRow(new Object[] { "Provincia Origen", paquete.getProvinciaOrigen().name() });
        model.addRow(new Object[] { "Provincia Destino", paquete.getProvinciaDestino().name() });
        model.addRow(new Object[] { "Dirección Destino", paquete.getDireccionDestino() });
        model.addRow(new Object[] { "Estado", paquete.obtenerEstado().toString() });
        model.addRow(new Object[] { "Distancia Estimada", paquete.calcularDistancia() + " Km" });
        jTablaPaquete.setModel(model);
        jBRegistrarIncidente.setVisible(true);
        jTablaPaquete.setVisible(true);
    }// GEN-LAST:event_jBConsultarPaqueteActionPerformed

    private void jTPEmpleados1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTPEmpleados1MouseClicked

    }// GEN-LAST:event_jTPEmpleados1MouseClicked

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }// GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }// GEN-LAST:event_jPanel3MousePressed

    private void jTCodigoTrackingFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTCodigoTrackingFocusLost

    }// GEN-LAST:event_jTCodigoTrackingFocusLost

    private void jTCodigoTrackingActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTCodigoTrackingActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCodigoTrackingActionPerformed

    private void jBRegistrarIncidenteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBRegistrarIncidenteActionPerformed
        String incidente = (String) seleccionIncidentes.getSelectedItem();
        Paquete paquete = Inventario.obtenerInstancia().obtenerPaquete(jTCodigoTracking.getText());
        Incidente incidenteRegistrar = null;
        if (incidente.equals("Error Dirección")) {
            incidenteRegistrar = new ErrorDireccion();
        } else if (incidente.equals("Paquete Estropeado")) {
            incidenteRegistrar = new PaqueteEstropeado();
        } else if (incidente.equals("Paquete Perdido")) {
            incidenteRegistrar = new PaquetePerdido();
        }
        int respuesta = JOptionPane.showConfirmDialog(
            null,
            "¿Estás seguro de que deseas registrar este incidente?",
            "Confirmación de registro",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            recepcionista.setIncidenteAManejar(incidenteRegistrar);
            try {
                recepcionista.reportarIncidente(paquete);
            } catch (ReporteNoPermitido ex) {
                JOptionPane.showMessageDialog(
                    null,
                    "El paquete se encuentra fuera de su jurisdicción",
                    "Registro falló",
                    JOptionPane.INFORMATION_MESSAGE);
                return;
            } catch (PaqueteYaTieneIncidente ex) {
                JOptionPane.showMessageDialog(
                    null,
                    "El paquete ya cuenta con un incidente registrado",
                    "Registro falló",
                    JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(
                null,
                "El incidente se ha registrado",
                "Registro Exitoso",
                JOptionPane.INFORMATION_MESSAGE);
            Inventario.obtenerInstancia().guardarInventario();
            DefaultTableModel modeloTabla = (DefaultTableModel) jTablaPaquete.getModel();
            modeloTabla.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(
                null,
                "El registro del incidente se ha cancelado",
                "Registro Cancelado",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }// GEN-LAST:event_jBRegistrarIncidenteActionPerformed

    private void seleccionIncidentes1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_seleccionIncidentes1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_seleccionIncidentes1ActionPerformed

    private void jTCodigoResolverFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTCodigoResolverFocusLost
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCodigoResolverFocusLost

    private void jTCodigoResolverActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTCodigoResolverActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCodigoResolverActionPerformed

    private void jTCodigoResolverKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTCodigoResolverKeyReleased
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCodigoResolverKeyReleased

    private void jBConsultarIncidenteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBConsultarIncidenteActionPerformed
        Inventario inventario = Inventario.obtenerInstancia();
        if (jTCodigoResolver.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Ingrese un código tracking", "Llene el campo",
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!inventario.existePaquete(jTCodigoResolver.getText())) {
            JOptionPane.showMessageDialog(null, "El paquete no existe", "Código tracking no existe",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        Seguimiento seguimiento = inventario.obtenerPaquete(jTCodigoResolver.getText()).obtenerSeguimiento();
        if (!seguimiento.tieneIncidente()) {
            JOptionPane.showMessageDialog(null, "El paquete no tiene un incidente que resolver", "Incidente no existe",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        model.addColumn("Propiedad");
        model.addColumn("Valor");
        model.addRow(new Object[] { "Estado del paquete", seguimiento.obtenerEstado() });
        model.addRow(new Object[] { "Incidente", seguimiento.getIncidente()});
        model.addRow(new Object[] { "Registro", seguimiento.obtenerRegistroIncidente() });
        model.addRow(new Object[] { "Resolucion", seguimiento.obtenerResolucion()});
        jTIncidente.setModel(model);
        jBResolverIncidente.setVisible(true);
    }// GEN-LAST:event_jBConsultarIncidenteActionPerformed

    private void jBResolverIncidenteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBResolverIncidenteActionPerformed
        
        Inventario inventario = Inventario.obtenerInstancia();
        Paquete paquete = inventario.obtenerPaquete(jTCodigoResolver.getText());
        Seguimiento seguimiento = paquete.obtenerSeguimiento();
        if (seguimiento.obtenerResolucion() != null) {
            JOptionPane.showMessageDialog(
                null,
                "El incidente ya se ha resuelto",
                "Resolución registrada",
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        String incidente = seguimiento.getIncidente();
        Incidente incidenteRegistrar = null;
        if (incidente.equals("Error de dirección")) {
            incidenteRegistrar = new ErrorDireccion();
        } else if (incidente.equals("Paquete Estropeado")) {
            incidenteRegistrar = new PaqueteEstropeado();
        } else if (incidente.equals("Paquete Perdido")) {
            incidenteRegistrar = new PaquetePerdido();
        } else if (incidente.equals("Devolución de Paquete")) {
            incidenteRegistrar = new DevolucionPaquete();
        }
        int respuesta = JOptionPane.showConfirmDialog(
            null,
            "¿Estás seguro de que deseas resolver este incidente?",
            "Confirmación de resolución",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            recepcionista.setIncidenteAManejar(incidenteRegistrar);
            String inputValue = "";
            if (!(incidenteRegistrar instanceof DevolucionPaquete)) {
                JTextField textField = new JTextField();
                Object[] mensaje = {
                    recepcionista.getMensajeIncidente(),
                    textField
                };

                int option = JOptionPane.showConfirmDialog(null, mensaje, seguimiento.getIncidente(), JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    inputValue = textField.getText();
                } else {
                    return;
                }
            }
            
            try {
                recepcionista.resolverIncidente(paquete, new String[] {inputValue});
            } catch (ReporteNoPermitido ex) {
                JOptionPane.showMessageDialog(
                    null,
                    "El paquete se encuentra fuera de su jurisdicción",
                    "Registro falló",
                    JOptionPane.INFORMATION_MESSAGE);
                return;
            } catch (PaqueteNoTieneIncidente ex) {
                return;
            }
            JOptionPane.showMessageDialog(
                null,
                "El incidente se ha resuelto",
                "Resolución Exitosa",
                JOptionPane.INFORMATION_MESSAGE);
            Inventario.obtenerInstancia().guardarInventario();
            DefaultTableModel modeloTabla = (DefaultTableModel) jTIncidente.getModel();
            modeloTabla.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(
                null,
                "La resolución del incidente se ha cancelado",
                "Resolución Cancelada",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }// GEN-LAST:event_jBResolverIncidenteActionPerformed

    private void jTArgumentosFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTArgumentosFocusLost
        // TODO add your handling code here:
    }// GEN-LAST:event_jTArgumentosFocusLost

    private void jTArgumentosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTArgumentosActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTArgumentosActionPerformed

    private void jTArgumentosKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTArgumentosKeyReleased
        // TODO add your handling code here:
    }// GEN-LAST:event_jTArgumentosKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPIncidentes;
    private javax.swing.JButton jBConsultarIncidente;
    private javax.swing.JButton jBConsultarPaquete;
    private javax.swing.JButton jBRegistrarIncidente;
    private javax.swing.JButton jBResolverIncidente;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPAE1;
    private javax.swing.JPanel jPIncidentes;
    private javax.swing.JPanel jPRE1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField jTCodigoResolver;
    private javax.swing.JTextField jTCodigoTracking;
    private javax.swing.JTable jTIncidente;
    private javax.swing.JTabbedPane jTPEmpleados1;
    private javax.swing.JTable jTablaPaquete;
    private javax.swing.JComboBox<String> seleccionIncidentes;
    // End of variables declaration//GEN-END:variables

    private void cargarIncidentes() {
        seleccionIncidentes.removeAllItems();
        seleccionIncidentes.addItem("Error Dirección");
        seleccionIncidentes.addItem("Paquete Estropeado");
        seleccionIncidentes.addItem("Paquete Perdido");
    }
}
