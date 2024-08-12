/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUICONDUCTOR;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import mod_administracion.Conductor;

import mod_paquetes.Paquete;

import validaciones.*;

/**
 * Clase para la interfaz de gestión de paquetes para conductores.
 * Permite consultar y eliminar paquetes.
 */
public class JFPaquetesConductor extends javax.swing.JFrame {
    // Validadores de registros y componentes Swing
    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
    private Conductor conductor;
    // Variables para manejo del mouse
    int xMouse, yMouse;
    private ArrayList<Paquete> inventario;

    /**
     * Constructor de la clase.
     * 
     * @param inventario Lista de paquetes.
     * @param conductor  Conductor asignado.
     */
    public JFPaquetesConductor(ArrayList<Paquete> inventario, Conductor conductor) {
        this.conductor = conductor;
        this.inventario = inventario;
        initComponents(); // Inicializa los componentes de la interfaz gráfica
        setIconImage(new ImageIcon(getClass().getResource("/iconos/caja.png")).getImage()); // Establece el icono de la
                                                                                            // ventana
        refrescarInventario(); // Refresca la tabla de inventario
        jTablaPaquete.setVisible(false); // Oculta la tabla de detalles del paquete
        DefaultTableModel model = new DefaultTableModel(); // Modelo de la tabla de detalles del paquete
        model.addColumn("Propiedad");
        model.addColumn("Valor");
        jTablaPaquete.setModel(model);
        jBEliminarPaquete.setVisible(false); // Oculta el botón de eliminar paquete
        // Listener para la selección de filas en la tabla de inventario
        jTablaInventario.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = jTablaInventario.getSelectedRow(); // Obtiene la fila seleccionada
                    if (selectedRow != -1) {
                        String codigoTracking = jTablaInventario.getValueAt(selectedRow, 0).toString(); // Obtiene el
                                                                                                        // código de
                                                                                                        // tracking del
                                                                                                        // paquete
                                                                                                        // seleccionado
                        Paquete paquete = obtenerPaquete(codigoTracking);

                        if (paquete == null) {
                            return;
                        }
                        // Mostrar un JOptionPane con la información de la fila seleccionada
                        JOptionPane.showMessageDialog(null,
                                paquete.toString(),
                                "Información del Paquete",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    /**
     * Método para refrescar la tabla de inventario.
     */
    private void refrescarInventario() {
        DefaultTableModel model = new DefaultTableModel();
        jTablaInventario.setModel(model); // Establece el modelo de la tabla
        String[] columnNames = {
                "Código de Tracking", "Volumen", "Peso", "Contenido",
                "Remitente", "Provincia Origen", "Provincia Destino"
        };
        model.setColumnIdentifiers(columnNames); // Establece los nombres de las columnas
        if (inventario != null) {
            for (Paquete paquete : inventario) {
                model.addRow(new Object[] {
                        paquete.obtenerCodigo(),
                        paquete.getVolumen(),
                        paquete.getPeso(),
                        paquete.getContenido(),
                        paquete.getRemitente().toString(),
                        paquete.getProvinciaOrigen().name(),
                        paquete.getProvinciaDestino().name()
                });
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPrincipal = new javax.swing.JPanel();
        jPanel_General = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTablaInventario = new javax.swing.JTable();
        jPIA = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTablaPaquete = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTCodigoEliminar = new javax.swing.JTextField();
        jBEliminarPaquete = new javax.swing.JButton();
        jBConsultarPaquete1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Paqueteria");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel69.setText("Gestion de Paquetes");
        jPanel3.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 30));

        jPrincipal.setMinimumSize(new java.awt.Dimension(1180, 620));
        jPrincipal.setPreferredSize(new java.awt.Dimension(1180, 620));
        jPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablaInventario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTablaInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablaInventario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane9.setViewportView(jTablaInventario);

        jPanel5.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1100, 460));

        jPanel_General.addTab("Consultar Inventario", jPanel5);

        jPIA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPIA.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 940, 237));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Código Tracking");
        jPIA.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));
        jPIA.add(jTCodigoEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 200, 20));

        jBEliminarPaquete.setText("Entregar");
        jBEliminarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarPaqueteActionPerformed(evt);
            }
        });
        jPIA.add(jBEliminarPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, 110, 40));

        jBConsultarPaquete1.setText("Ver paquete");
        jBConsultarPaquete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarPaquete1ActionPerformed(evt);
            }
        });
        jPIA.add(jBConsultarPaquete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, -1, -1));

        jPanel_General.addTab("Entregar Paquete", jPIA);

        jPrincipal.add(jPanel_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1150, 560));

        getContentPane().add(jPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1180, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }// GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }// GEN-LAST:event_jPanel3MouseDragged

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExitActionPerformed
        getToolkit().beep();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro de cerrar esta ventana?", "Warning",
                dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }// GEN-LAST:event_btnExitActionPerformed

    /**
     * Método para obtener un paquete por su código de tracking.
     * 
     * @param codigo Código de tracking del paquete.
     * @return El paquete correspondiente, o null si no se encuentra.
     */
    private Paquete obtenerPaquete(String codigo) {
        for (Paquete paquete : inventario) {
            if (paquete.getCodigoTracking().equals(codigo)) {
                return paquete;
            }
        }
        return null;
    }

    private void jBConsultarPaquete1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBConsultarPaquete1ActionPerformed
        String codigo = jTCodigoEliminar.getText();
        Paquete paquete = obtenerPaquete(codigo);
        if (codigo.isBlank()) {
            JOptionPane.showMessageDialog(null, "Ingrese un código tracking", "Llene el campo",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (paquete == null) {
            JOptionPane.showMessageDialog(null, "El paquete no existe", "Código tracking no existe",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

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
        jTablaPaquete.setVisible(true);
        jBEliminarPaquete.setVisible(true);
    }// GEN-LAST:event_jBConsultarPaquete1ActionPerformed

    private void jBEliminarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBEliminarPaqueteActionPerformed
        Paquete paquete = obtenerPaquete(jTCodigoEliminar.getText());
        if (paquete == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "No existe paquete " + jTCodigoEliminar.getText(),
                    "No existe paquete ",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Estás seguro de que deseas entregar el paquete con código de tracking: " + jTCodigoEliminar.getText()
                        + "?",
                "Confirmación de Entrega",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            // El usuario confirmó la eliminación
            // Eliminar el paquete del inventario
            JOptionPane.showMessageDialog(
                    null,
                    "El paquete con código " + jTCodigoEliminar.getText() + " ha sido entregado.",
                    "Entrega Exitosa",
                    JOptionPane.INFORMATION_MESSAGE);
            inventario.remove(paquete);
            conductor.entregarPaquete(jTCodigoEliminar.getText());
            refrescarInventario();
            DefaultTableModel modeloTabla = (DefaultTableModel) jTablaPaquete.getModel();
            modeloTabla.setRowCount(0); // Vacía la tabla de detalles del paquete
        } else {
            // El usuario canceló la eliminación
            JOptionPane.showMessageDialog(
                    null,
                    "La entrega del paquete con código " + jTCodigoEliminar.getText() + " ha sido cancelada.",
                    "Entrega Cancelada",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }// GEN-LAST:event_jBEliminarPaqueteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConsultarPaquete1;
    private javax.swing.JButton jBEliminarPaquete;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPIA;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jPanel_General;
    private javax.swing.JPanel jPrincipal;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTCodigoEliminar;
    private javax.swing.JTable jTablaInventario;
    private javax.swing.JTable jTablaPaquete;
    // End of variables declaration//GEN-END:variables

}
