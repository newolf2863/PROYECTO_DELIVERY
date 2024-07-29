/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_encomienda.GUI;

import java.sql.Connection;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_encomienda.BDYValidaciones.CreadorTablas;
import proyecto_encomienda.BDYValidaciones.ContadorDeIDs;
import proyecto_encomienda.BDYValidaciones.IncidentesBaseDeDatos;
import proyecto_encomienda.BDYValidaciones.TextPrompt;
import proyecto_encomienda.BDYValidaciones.ValidadorDeRegistros;
import proyecto_encomienda.BDYValidaciones.ValidadorDeSwings;
import proyecto_encomienda.BDYValidaciones.VisibilidadManager;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;
import proyecto_encomienda.INCIDENTES.DanioPaquete;
import proyecto_encomienda.INCIDENTES.ErrorDireccion;
import proyecto_encomienda.INCIDENTES.GestorIncidentes;
import proyecto_encomienda.INCIDENTES.Incidente;
import proyecto_encomienda.INCIDENTES.PaquetePerdido;
import proyecto_encomienda.INCIDENTES.RechazoEntrega;

/**
 *
 * @author Moises Arequipa
 * @Grupo: Segunda es Todo
 */
public class JFIncidente extends javax.swing.JFrame {

    /**
     * Creates new form JFIncidente
     */
    //Validadores
    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
    //Connexion
    Connection cnx;
    private ContadorDeIDs contadorDeIDs;
    private VisibilidadManager visibilidadManager;
    //Mouse
    int xMouse, yMouse;

    //Incidentes
    private boolean idIncidenteValidar = false;
    private boolean descriptionValidar = false;
    private boolean seleccionValidar = false;

    
    
    public JFIncidente(Connection conexion) {
        initComponents();
        this.cnx = conexion;
        setIconImage(new ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/exclamacion.png")).getImage());
        // Inicializa el campo IDIncidentesTF con el siguiente ID
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.contadorDeIDs = new ContadorDeIDs();
        int siguienteId = contadorDeIDs.obtenerSiguienteIdIncidente(cnx);
        IDIncidentesTF.setText(String.valueOf(siguienteId));
        this.visibilidadManager = new VisibilidadManager();
        desaparecerLabels();
        setLocationRelativeTo(null);
        placeHolder();
    }

    public JFIncidente() {
        initComponents();
    }

    private void placeHolder() {
        TextPrompt texto1 = new TextPrompt("Obligatorio", TFIDPIncidentes);
        TextPrompt texto2 = new TextPrompt("Obligatorio", TFRazonIncidentes);
    }

    public void desaparecerLabels() {
        JLabel[] labels = {errorIncidente1, errorIncidente2};
        visibilidadManager.desvanecerLabels(labels);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPIncidentes = new javax.swing.JPanel();
        jPIncidentes = new javax.swing.JPanel();
        jTPEmpleados1 = new javax.swing.JTabbedPane();
        jPRE1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        SeleccionIncidentesCB = new javax.swing.JComboBox<>();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        TFIDPIncidentes = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        RegistrarIncidentesButton = new javax.swing.JButton();
        jLabel136 = new javax.swing.JLabel();
        IDIncidentesTF = new javax.swing.JTextField();
        errorIncidente1 = new javax.swing.JLabel();
        errorIncidente2 = new javax.swing.JLabel();
        TFRazonIncidentes = new javax.swing.JTextField();
        errorIncidente3 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        jTIncidentes = new javax.swing.JTable();
        jPAE1 = new javax.swing.JPanel();
        jScrollPane29 = new javax.swing.JScrollPane();
        jTIncidentes1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPEE1 = new javax.swing.JPanel();
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

        SeleccionIncidentesCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Daño en el Paquete", "Error de Dirección", "Paquete Perdido", "Rechazo Entrega" }));
        SeleccionIncidentesCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionIncidentesCBActionPerformed(evt);
            }
        });

        jLabel133.setText("Tipo de incidente:");

        jLabel134.setText("Código único del paquete");

        TFIDPIncidentes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFIDPIncidentesFocusLost(evt);
            }
        });
        TFIDPIncidentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFIDPIncidentesActionPerformed(evt);
            }
        });
        TFIDPIncidentes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFIDPIncidentesKeyReleased(evt);
            }
        });

        jLabel135.setText("Descripción del incidente");

        RegistrarIncidentesButton.setText("Registrar");
        RegistrarIncidentesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarIncidentesButtonActionPerformed(evt);
            }
        });

        jLabel136.setText("Código único del incidente");

        IDIncidentesTF.setEditable(false);
        IDIncidentesTF.setEnabled(false);

        errorIncidente1.setForeground(new java.awt.Color(255, 0, 51));
        errorIncidente1.setText("Código único inválido");

        errorIncidente2.setForeground(new java.awt.Color(255, 0, 51));
        errorIncidente2.setText("Ingrese una descripción");

        TFRazonIncidentes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFRazonIncidentesFocusLost(evt);
            }
        });
        TFRazonIncidentes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFRazonIncidentesKeyReleased(evt);
            }
        });

        errorIncidente3.setForeground(new java.awt.Color(255, 0, 51));
        errorIncidente3.setText("Selección inválida");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel134, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                        .addComponent(jLabel133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel135)
                    .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorIncidente3)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(errorIncidente2)
                        .addComponent(RegistrarIncidentesButton)
                        .addComponent(SeleccionIncidentesCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TFIDPIncidentes)
                        .addComponent(IDIncidentesTF)
                        .addComponent(errorIncidente1))
                    .addComponent(TFRazonIncidentes, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel136)
                    .addComponent(IDIncidentesTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel134)
                    .addComponent(TFIDPIncidentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(errorIncidente1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133)
                    .addComponent(SeleccionIncidentesCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorIncidente3)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel135))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(TFRazonIncidentes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorIncidente2)
                .addGap(18, 18, 18)
                .addComponent(RegistrarIncidentesButton)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTIncidentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cod. Incidente", "Cod. Paquete", "Tipo Incidente", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane28.setViewportView(jTIncidentes);

        javax.swing.GroupLayout jPRE1Layout = new javax.swing.GroupLayout(jPRE1);
        jPRE1.setLayout(jPRE1Layout);
        jPRE1Layout.setHorizontalGroup(
            jPRE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRE1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPRE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane28))
                .addContainerGap(264, Short.MAX_VALUE))
        );
        jPRE1Layout.setVerticalGroup(
            jPRE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRE1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTPEmpleados1.addTab("Registrar Incidente", jPRE1);

        jTIncidentes1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cod. Incidente", "Cod. Paquete", "Tipo Incidente", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane29.setViewportView(jTIncidentes1);

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPAE1Layout = new javax.swing.GroupLayout(jPAE1);
        jPAE1.setLayout(jPAE1Layout);
        jPAE1Layout.setHorizontalGroup(
            jPAE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAE1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane29, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addGap(83, 83, 83)
                .addGroup(jPAE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(86, 86, 86))
        );
        jPAE1Layout.setVerticalGroup(
            jPAE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAE1Layout.createSequentialGroup()
                .addGroup(jPAE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPAE1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPAE1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(392, Short.MAX_VALUE))
        );

        jTPEmpleados1.addTab("Actualizar", jPAE1);

        javax.swing.GroupLayout jPEE1Layout = new javax.swing.GroupLayout(jPEE1);
        jPEE1.setLayout(jPEE1Layout);
        jPEE1Layout.setHorizontalGroup(
            jPEE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 965, Short.MAX_VALUE)
        );
        jPEE1Layout.setVerticalGroup(
            jPEE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        jTPEmpleados1.addTab("Cambiar de estado", jPEE1);

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
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/power_24dp.png"))); // NOI18N
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

    private void SeleccionIncidentesCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionIncidentesCBActionPerformed
        // Obtener el texto seleccionado del JComboBox
        String tipoIncidente = (String) SeleccionIncidentesCB.getSelectedItem();
        // Comprobar si el texto seleccionado es "Selecciona"
        if ("Selecciona".equals(tipoIncidente)) {
            seleccionValidar = false;
            errorIncidente3.setVisible(true);
        } else {
            seleccionValidar = true;
            errorIncidente3.setVisible(false);
        }
    }//GEN-LAST:event_SeleccionIncidentesCBActionPerformed

    private void TFIDPIncidentesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFIDPIncidentesKeyReleased
        String idPaqueteStr = TFIDPIncidentes.getText().trim();
        DefaultTableModel modelo = new CreadorTablas().mostrarVistaDatosPaquete(cnx, idPaqueteStr);
        jTIncidentes.setModel(modelo);
        idIncidenteValidar = validarRegistroF.camposDeRegistros(TFIDPIncidentes, errorIncidente1, "i");
    }//GEN-LAST:event_TFIDPIncidentesKeyReleased

    private void RegistrarIncidentesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarIncidentesButtonActionPerformed
        int idPaquete = Integer.parseInt(TFIDPIncidentes.getText());
        String tipoIncidente = SeleccionIncidentesCB.getSelectedItem().toString();
        JTextField[] campos = {TFIDPIncidentes, TFRazonIncidentes};
        Boolean[] booleanItem = {idIncidenteValidar, descriptionValidar};
        JLabel[] labels = {errorIncidente1, errorIncidente2};
        String[] nombresCampos = {"Código Único del Incidente", "descripción"};
        List<String> errores = validadorCheck.validarCamposLista(campos, booleanItem, labels, nombresCampos);
        errores.addAll(validadorCheck.validarCamposVaciosLista(campos, booleanItem, labels, nombresCampos));
        if ("Selecciona".equals(tipoIncidente)) {
            errores.add("Error en el campo Selecciona : El campo es inválido .");
        } else {
            seleccionValidar = true;
        }
        
        if (!IncidentesBaseDeDatos.verificarCodigoTracking(cnx, idPaquete)) {
        errores.add("El paquete con ID " + idPaquete + " no tiene un código de seguimiento válido."
                + "codigoTraking");
    }

        if (!errores.isEmpty() || !seleccionValidar) {
            StringBuilder mensajeError = new StringBuilder("Se encontraron los siguientes errores:\n");
            for (String error : errores) {
                mensajeError.append("- ").append(error).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensajeError.toString(), "Errores", JOptionPane.ERROR_MESSAGE);
        } else {
            String descripcion = TFRazonIncidentes.getText();
            int idIncidente = Integer.parseInt(IDIncidentesTF.getText());
            
            
            Inventario inventario = new Inventario(); // Asegúrate de tener una instancia de Inventario
            GestorIncidentes gestorIncidentes = new GestorIncidentes(inventario, cnx);

            // Crear el incidente según el tipo
            Incidente incidente = null;
            switch (tipoIncidente) {
                case "Daño en el Paquete" ->
                    incidente = new DanioPaquete(descripcion, idPaquete, idIncidente, cnx);
                case "Error de Dirección" ->
                    incidente = new ErrorDireccion(descripcion, idPaquete, idIncidente, cnx);
                case "Paquete Perdido" ->
                    incidente = new PaquetePerdido(descripcion, idPaquete, idIncidente, cnx);
                case "Rechazo Entrega" ->
                    incidente = new RechazoEntrega(descripcion, idPaquete, idIncidente, cnx);
                default ->
                    throw new IllegalArgumentException("Tipo de incidente desconocido: " + tipoIncidente);
            }
            // Registrar el incidente
            gestorIncidentes.crearIncidente(incidente, idPaquete);
            // Usar VisibilidadManager para ocultar los labels
            visibilidadManager.desvanecerLabels(labels);
            TFIDPIncidentes.setText("");
            TFRazonIncidentes.setText("");
            int siguienteId = contadorDeIDs.obtenerSiguienteIdIncidente(cnx);
            IDIncidentesTF.setText(String.valueOf(siguienteId));
        }
    }//GEN-LAST:event_RegistrarIncidentesButtonActionPerformed

    private void jTPEmpleados1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPEmpleados1MouseClicked

    }//GEN-LAST:event_jTPEmpleados1MouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        getToolkit().beep();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro de quieres cerrar la ventana?", "Warning", dialogButton);
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

    private void TFIDPIncidentesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFIDPIncidentesFocusLost
        idIncidenteValidar = validarRegistroF.camposDeRegistros(TFIDPIncidentes, errorIncidente1, "i");
    }//GEN-LAST:event_TFIDPIncidentesFocusLost

    private void TFRazonIncidentesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFRazonIncidentesFocusLost
        descriptionValidar = validarRegistroF.camposDeRegistros(TFRazonIncidentes, errorIncidente2, "d");
    }//GEN-LAST:event_TFRazonIncidentesFocusLost

    private void TFRazonIncidentesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRazonIncidentesKeyReleased
        descriptionValidar = validarRegistroF.camposDeRegistros(TFRazonIncidentes, errorIncidente2, "d");
    }//GEN-LAST:event_TFRazonIncidentesKeyReleased

    private void TFIDPIncidentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFIDPIncidentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFIDPIncidentesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(JFIncidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFIncidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFIncidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFIncidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFIncidente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDIncidentesTF;
    private javax.swing.JPanel JPIncidentes;
    private javax.swing.JButton RegistrarIncidentesButton;
    private javax.swing.JComboBox<String> SeleccionIncidentesCB;
    private javax.swing.JTextField TFIDPIncidentes;
    private javax.swing.JTextField TFRazonIncidentes;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel errorIncidente1;
    private javax.swing.JLabel errorIncidente2;
    private javax.swing.JLabel errorIncidente3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPAE1;
    private javax.swing.JPanel jPEE1;
    private javax.swing.JPanel jPIncidentes;
    private javax.swing.JPanel jPRE1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JTable jTIncidentes;
    private javax.swing.JTable jTIncidentes1;
    private javax.swing.JTabbedPane jTPEmpleados1;
    // End of variables declaration//GEN-END:variables
}
