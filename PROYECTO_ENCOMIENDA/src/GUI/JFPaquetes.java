/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import basededatos.DataBase;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTextField;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableRowSorter;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import mod_administracion.Cliente;
import mod_administracion.Recepcionista;
import mod_administracion.Usuario;
import mod_facturacion.CalculoPrecio;
import mod_facturacion.Precio;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;
import mod_transporte.Provincia;
import validaciones.*;


/**
 *
 * @author USUARIO
 */
public class JFPaquetes extends javax.swing.JFrame {
    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
    private boolean volumenValidar = false;
    private boolean pesoValidar = false;
    private boolean remitenteValidar = false;
    private boolean contenidoValidar=false;
    private boolean direccionValidar = false;
    private boolean destinatarioValidar = false;
    private Inventario inventario;
    private Recepcionista recepcionista;
    
    //Mouse
    int xMouse, yMouse;  
    
    public JFPaquetes(Recepcionista recepcionista){      
        this.recepcionista = recepcionista;
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/iconos/caja.png")).getImage());
        inventario = Inventario.obtenerInstancia();
        cargarProvincias();
        refrescarInventario();
        desvanecerP();
        placeHolder();
        jBRegistrarPAInventario.setVisible(false);
        jTablaPaquete.setVisible(false);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Propiedad");
        model.addColumn("Valor");
        jTablaPaquete.setModel(model);
        jBEliminarPaquete.setVisible(false);
        jTablaInventario.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = jTablaInventario.getSelectedRow();
                    if (selectedRow != -1) {
                        String codigoTracking = jTablaInventario.getValueAt(selectedRow, 0).toString();
                        Paquete paquete = inventario.obtenerPaquete(codigoTracking);
                        // Mostrar un JOptionPane con la información de la fila seleccionada
                        JOptionPane.showMessageDialog(null, 
                            paquete.toString(), 
                            "Información del Paquete", 
                            JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        setLocationRelativeTo(null);
    }
    
    private void cargarInventario() {
        inventario = Inventario.obtenerInstancia();
        inventario.cargarInventario();
    }
    
    private void refrescarInventario() {
        DefaultTableModel model = new DefaultTableModel();
        jTablaInventario.setModel(model);
        String[] columnNames = {
            "Código de Tracking", "Volumen", "Peso", "Contenido", 
            "Remitente", "Provincia Origen", "Provincia Destino"
        };
        model.setColumnIdentifiers(columnNames);
        for (Paquete paquete : inventario.obtenerPaquetes()) {
                model.addRow(new Object[]{
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
    
    private void cargarProvincias() {
        JComboDestino.removeAllItems();
        for (Provincia provincia : Provincia.values()) {
            JComboDestino.addItem(provincia.name());
        }
    }
    
    private void placeHolder() {
        TextPrompt texto1 = new TextPrompt("Obligatorio", jTContenidoPaquete);
        TextPrompt texto2 = new TextPrompt("Obligatorio", jTVolumen);
        TextPrompt texto3 = new TextPrompt("Obligatorio", jTPeso);
        TextPrompt texto = new TextPrompt("Obligatorio", jTRemitente);
        TextPrompt texto5 = new TextPrompt("Obligatorio", jTDireccion1);
        TextPrompt texto4 = new TextPrompt("Obligatorio", jTDestinatario);
    }    
     
    public void desvanecerP() {
        JLabel[] labels = {
             errorInventario1, errorInventario2, errorInventario3,
            errorInventario4, errorInventario6, errorInventario7, errorInventario8};
        for (JLabel label : labels) {
            label.setVisible(false);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jPrincipal = new javax.swing.JPanel();
        jPanel_General = new javax.swing.JTabbedPane();
        jPIR = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTCodigoTracking = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTPeso = new javax.swing.JTextField();
        jBRegistrar = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        errorInventario2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        errorInventario1 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jTContenidoPaquete = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jTRemitente = new javax.swing.JTextField();
        errorInventario4 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jTVolumen = new javax.swing.JTextField();
        errorInventario3 = new javax.swing.JLabel();
        errorInventario6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTDestinatario = new javax.swing.JTextField();
        errorInventario7 = new javax.swing.JLabel();
        jBEliminar = new javax.swing.JButton();
        jLabelPrecioPaquete = new javax.swing.JLabel();
        jLabelImpuesto = new javax.swing.JLabel();
        jLabelPrecioDistancia = new javax.swing.JLabel();
        JLabelPrecioTotal = new javax.swing.JLabel();
        JComboDestino = new javax.swing.JComboBox<>();
        jBRegistrarPAInventario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTDireccion1 = new javax.swing.JTextField();
        errorInventario8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTablaInventario = new javax.swing.JTable();
        jPIA = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
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
        jPanel3.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1015, 0, 35, 35));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, -1));

        jPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPIR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del paquete"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Código Tracking");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 27, 89, -1));

        jTCodigoTracking.setEditable(false);
        jPanel2.add(jTCodigoTracking, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 24, 203, -1));

        jLabel13.setText("Contenido");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 88, -1, -1));

        jLabel11.setText("Peso");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 162, -1, -1));

        jTPeso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTPesoFocusLost(evt);
            }
        });
        jTPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesoKeyReleased(evt);
            }
        });
        jPanel2.add(jTPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 156, 204, -1));

        jBRegistrar.setText("Agregar Registro");
        jBRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(jBRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 294, 134, -1));

        jLabel60.setText("Kg");
        jPanel2.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 159, -1, -1));

        errorInventario2.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario2.setText("Peso no válido");
        jPanel2.add(errorInventario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 184, -1, -1));

        jLabel14.setText("Volumen");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 91, -1, -1));

        errorInventario1.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario1.setText("Volumen no válido");
        jPanel2.add(errorInventario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 113, 113, -1));

        jLabel61.setText("m3");
        jPanel2.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 88, -1, -1));

        jTContenidoPaquete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTContenidoPaqueteFocusLost(evt);
            }
        });
        jPanel2.add(jTContenidoPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 85, 254, -1));

        jLabel53.setText("Remitente");
        jPanel2.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 24, -1, -1));

        jTRemitente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTRemitenteFocusLost(evt);
            }
        });
        jTRemitente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTRemitenteKeyReleased(evt);
            }
        });
        jPanel2.add(jTRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 18, 254, -1));

        errorInventario4.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario4.setText("Remitente no válido");
        jPanel2.add(errorInventario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 46, -1, -1));

        jLabel63.setText("Destino");
        jPanel2.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 218, -1, -1));

        jTVolumen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTVolumenFocusLost(evt);
            }
        });
        jTVolumen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTVolumenKeyReleased(evt);
            }
        });
        jPanel2.add(jTVolumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 85, 204, -1));

        errorInventario3.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario3.setText("Destino no válido");
        jPanel2.add(errorInventario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 246, -1, -1));

        errorInventario6.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario6.setText("Contenido no válido");
        jPanel2.add(errorInventario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 113, -1, -1));

        jLabel1.setText("Dirección");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 159, 55, -1));

        jTDestinatario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTDestinatarioFocusLost(evt);
            }
        });
        jPanel2.add(jTDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 218, 254, -1));

        errorInventario7.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario7.setText("Dirección no válido");
        jPanel2.add(errorInventario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 184, -1, -1));

        jBEliminar.setText("Eliminar Registro");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 294, 133, -1));

        jLabelPrecioPaquete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPrecioPaquete.setText("Precio paquete :");
        jPanel2.add(jLabelPrecioPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 343, -1, -1));

        jLabelImpuesto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelImpuesto.setText("Impuesto :");
        jPanel2.add(jLabelImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 407, -1, -1));

        jLabelPrecioDistancia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPrecioDistancia.setText("Precio distancia :");
        jPanel2.add(jLabelPrecioDistancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, -1, -1));

        JLabelPrecioTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLabelPrecioTotal.setText("Precio total :");
        jPanel2.add(JLabelPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 439, -1, -1));

        JComboDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JComboDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboDestinoActionPerformed(evt);
            }
        });
        jPanel2.add(JComboDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 218, 204, -1));

        jBRegistrarPAInventario.setText("Agregar al inventario");
        jBRegistrarPAInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarPAInventarioActionPerformed(evt);
            }
        });
        jPanel2.add(jBRegistrarPAInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 488, -1, -1));

        jLabel2.setText("Destinatario");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 221, -1, -1));

        jTDireccion1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTDireccion1FocusLost(evt);
            }
        });
        jPanel2.add(jTDireccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 156, 254, -1));

        errorInventario8.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario8.setText("Destinatario no válido");
        jPanel2.add(errorInventario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 246, 142, -1));

        jPIR.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, 991, 530));

        jPanel_General.addTab("Registrar Paquete", jPIR);

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

        jPanel5.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 896, 330));

        jPanel_General.addTab("Consultar Inventario", jPanel5);

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

        jPIA.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(982, 0, -1, -1));

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

        jPIA.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 650, 237));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Código Tracking");
        jPIA.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));
        jPIA.add(jTCodigoEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 200, 20));

        jBEliminarPaquete.setText("Eliminar");
        jBEliminarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarPaqueteActionPerformed(evt);
            }
        });
        jPIA.add(jBEliminarPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, -1, -1));

        jBConsultarPaquete1.setText("Ver paquete");
        jBConsultarPaquete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarPaquete1ActionPerformed(evt);
            }
        });
        jPIA.add(jBConsultarPaquete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        jPanel_General.addTab("Eliminar Paquete", jPIA);

        jPrincipal.add(jPanel_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1030, 610));

        getContentPane().add(jPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1010, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTPesoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTPesoFocusLost
        pesoValidar = validarRegistroF.camposDeRegistros(jTPeso, errorInventario2, "precio");
    }//GEN-LAST:event_jTPesoFocusLost

    private void jTPesoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesoKeyReleased
        pesoValidar = validarRegistroF.camposDeRegistros(jTPeso, errorInventario2, "precio");
    }//GEN-LAST:event_jTPesoKeyReleased

    private void jBRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarActionPerformed
 JTextField[] campos = {jTVolumen,jTPeso,jTRemitente, jTDestinatario, jTContenidoPaquete, jTDestinatario};
        Boolean[] booleanItem = {volumenValidar,pesoValidar,remitenteValidar, direccionValidar, contenidoValidar, destinatarioValidar};
        JLabel[] labels = {errorInventario1, errorInventario2, errorInventario4,errorInventario7,errorInventario6, errorInventario8};
        String[] nombresCampos = {"Volumen", "Peso", "Remitente","Direccion", "Contenido del paquete", "Destinatario"};
        List<String> errores = validadorCheck.validarCamposLista(campos, booleanItem, labels, nombresCampos);
        errores.addAll(validadorCheck.validarCamposVaciosLista(campos, booleanItem, labels, nombresCampos));
        String estado = "Pendiente";
        
        Provincia destino = null;
        Class<?> enumClass;
        try {
            enumClass = Class.forName("mod_transporte.Provincia");
            destino = (Provincia) Enum.valueOf((Class<Enum>) enumClass, JComboDestino.getSelectedItem().toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPaquetes.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!errores.isEmpty()) {
            StringBuilder mensajeError = new StringBuilder("Se encontraron los siguientes errores:\n");
            for (String error : errores) {
                mensajeError.append("- ").append(error).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensajeError.toString(), "Errores", JOptionPane.ERROR_MESSAGE);
        } else if (JComboDestino.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Escoja un destino", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (destino.equals(recepcionista.obtenerSucursal())) {
            JOptionPane.showMessageDialog(null, "El Destino debe ser otra provincia distinta a la sucursal", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!DataBase.obtenerInstancia().clienteExiste(jTRemitente.getText())) {
            JOptionPane.showMessageDialog(null, "El cliente no está registrado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String codigo = inventario.getSiguienteCodigoTracking();
            double volumen = Double.parseDouble(jTVolumen.getText());
            double peso = Double.parseDouble(jTPeso.getText());
            String contenido = jTContenidoPaquete.getText();
            Cliente cliente = DataBase.obtenerInstancia().obtenerDatosPorCedula(jTRemitente.getText());
            Provincia origen = recepcionista.obtenerSucursal();
            String direccion = jTDireccion1.getText();
            String destinatario = jTDestinatario.getText();
            Paquete paquete = new Paquete(codigo, volumen, peso, contenido, cliente, origen, destino, direccion, destinatario);
            recepcionista.registrarPaquete(paquete);
            jTCodigoTracking.setText(codigo);
            mostrarPrecio();
            jBRegistrarPAInventario.setVisible(true);
        }
    }//GEN-LAST:event_jBRegistrarActionPerformed

    private void jTRemitenteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTRemitenteFocusLost
        remitenteValidar = validarRegistroF.camposDeRegistros(jTRemitente, errorInventario4, "cedula");
    }//GEN-LAST:event_jTRemitenteFocusLost

    private void jTRemitenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTRemitenteKeyReleased
        remitenteValidar = validarRegistroF.camposDeRegistros(jTRemitente, errorInventario4, "d");
    }//GEN-LAST:event_jTRemitenteKeyReleased

    private void jTVolumenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTVolumenFocusLost
        volumenValidar = validarRegistroF.camposDeRegistros(jTVolumen, errorInventario1, "precio");
    }//GEN-LAST:event_jTVolumenFocusLost

    private void jTVolumenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTVolumenKeyReleased
        volumenValidar = validarRegistroF.camposDeRegistros(jTVolumen, errorInventario1, "precio");
    }//GEN-LAST:event_jTVolumenKeyReleased

    private void jBRegistrarPAInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarPAInventarioActionPerformed
        recepcionista.agregarPaqueteInventario();
        recepcionista.eliminarPaqueteRegistrado();
        refrescarInventario();
        inventario.guardarInventario();
        vaciarCampos();
        JOptionPane.showMessageDialog(null, "El paquete se agregó correctamente al inventario.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jBRegistrarPAInventarioActionPerformed

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        getToolkit().beep();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro de cerrar esta ventana?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void jTContenidoPaqueteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTContenidoPaqueteFocusLost
       contenidoValidar = validarRegistroF.camposDeRegistros(jTContenidoPaquete, errorInventario6, "d");
    }//GEN-LAST:event_jTContenidoPaqueteFocusLost

    private void jTDestinatarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTDestinatarioFocusLost
        destinatarioValidar = validarRegistroF.camposDeRegistros(jTDestinatario, errorInventario8, "d");
    }//GEN-LAST:event_jTDestinatarioFocusLost

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        vaciarCampos();
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBEliminarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarPaqueteActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Estás seguro de que deseas eliminar el paquete con código de tracking: " + jTCodigoEliminar.getText() + "?",
                "Confirmación de Eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            // El usuario confirmó la eliminación
            Paquete paquete = inventario.obtenerPaquete(jTCodigoEliminar.getText());
            inventario.eliminarPaquete(paquete);
            refrescarInventario();
            inventario.guardarInventario();
            JOptionPane.showMessageDialog(
                    null,
                    "El paquete con código " + jTCodigoEliminar.getText() + " ha sido eliminado.",
                    "Eliminación Exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );
            DefaultTableModel modeloTabla = (DefaultTableModel) jTablaPaquete.getModel();
            modeloTabla.setRowCount(0);
        } else {
            // El usuario canceló la eliminación
            JOptionPane.showMessageDialog(
                    null,
                    "La eliminación del paquete con código " + jTCodigoEliminar.getText() + " ha sido cancelada.",
                    "Eliminación Cancelada",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }//GEN-LAST:event_jBEliminarPaqueteActionPerformed

    private void jBConsultarPaquete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarPaquete1ActionPerformed
        String codigo = jTCodigoEliminar.getText();
        if (codigo.isBlank()) {
            JOptionPane.showMessageDialog(null, "Ingrese un código tracking", "Llene el campo", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (!inventario.existePaquete(codigo)) {
            JOptionPane.showMessageDialog(null, "El paquete no existe", "Código tracking no existe", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Paquete paquete = inventario.obtenerPaquete(codigo);
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        model.addColumn("Propiedad");
        model.addColumn("Valor");
        model.addRow(new Object[]{"Código de Tracking", paquete.obtenerCodigo()});
        model.addRow(new Object[]{"Volumen", paquete.getVolumen() + " m³"});
        model.addRow(new Object[]{"Peso", paquete.getPeso() + " kg"});
        model.addRow(new Object[]{"Contenido", paquete.getContenido()});
        model.addRow(new Object[]{"Remitente", paquete.getRemitente().toString()});
        model.addRow(new Object[]{"Provincia Origen", paquete.getProvinciaOrigen().name()});
        model.addRow(new Object[]{"Provincia Destino", paquete.getProvinciaDestino().name()});
        model.addRow(new Object[]{"Dirección Destino", paquete.getDireccionDestino()});
        model.addRow(new Object[]{"Estado", paquete.obtenerEstado().toString()});
        model.addRow(new Object[]{"Distancia Estimada", paquete.calcularDistancia() + " Km"});
        jTablaPaquete.setModel(model);
        jTablaPaquete.setVisible(true);
        jBEliminarPaquete.setVisible(true);
    }//GEN-LAST:event_jBConsultarPaquete1ActionPerformed

    private void jTDireccion1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTDireccion1FocusLost
        direccionValidar = validarRegistroF.camposDeRegistros(jTDireccion1, errorInventario7, "d");
    }//GEN-LAST:event_jTDireccion1FocusLost

    private void JComboDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboDestinoActionPerformed

    private void vaciarCampos() {
        recepcionista.eliminarPaqueteRegistrado();
        jLabelPrecioPaquete.setText("Precio Paquete : ");
        jLabelPrecioDistancia.setText("Precio Distancia : ");
        jLabelImpuesto.setText("Impuesto : ");
        JLabelPrecioTotal.setText("Precio total : ");
        jTCodigoTracking.setText("");
        jTVolumen.setText("");
        jTPeso.setText("");
        jTRemitente.setText("");
        jTContenidoPaquete.setText("");
        jTDestinatario.setText("");
        jBRegistrarPAInventario.setVisible(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboDestino;
    private javax.swing.JLabel JLabelPrecioTotal;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel errorInventario1;
    private javax.swing.JLabel errorInventario2;
    private javax.swing.JLabel errorInventario3;
    private javax.swing.JLabel errorInventario4;
    private javax.swing.JLabel errorInventario6;
    private javax.swing.JLabel errorInventario7;
    private javax.swing.JLabel errorInventario8;
    private javax.swing.JButton jBConsultarPaquete1;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBEliminarPaquete;
    private javax.swing.JButton jBRegistrar;
    private javax.swing.JButton jBRegistrarPAInventario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabelImpuesto;
    private javax.swing.JLabel jLabelPrecioDistancia;
    private javax.swing.JLabel jLabelPrecioPaquete;
    private javax.swing.JPanel jPIA;
    private javax.swing.JPanel jPIR;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jPanel_General;
    private javax.swing.JPanel jPrincipal;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTCodigoEliminar;
    private javax.swing.JTextField jTCodigoTracking;
    private javax.swing.JTextField jTContenidoPaquete;
    private javax.swing.JTextField jTDestinatario;
    private javax.swing.JTextField jTDireccion1;
    private javax.swing.JTextField jTPeso;
    private javax.swing.JTextField jTRemitente;
    private javax.swing.JTextField jTVolumen;
    private javax.swing.JTable jTablaInventario;
    private javax.swing.JTable jTablaPaquete;
    // End of variables declaration//GEN-END:variables

    private void mostrarPrecio() {
        Precio precio = recepcionista.consultarPrecioPaquete();
        ArrayList<CalculoPrecio> precios = precio.obtenerPreciosIndividuales();
        jLabelPrecioPaquete.setText("Precio Paquete : " + precios.get(0).obtenerMonto());
        jLabelPrecioDistancia.setText("Precio Distancia : " + precios.get(1).obtenerMonto());
        jLabelImpuesto.setText("Impuesto : " + precios.get(2).obtenerMonto());
        JLabelPrecioTotal.setText("Precio total : " + precio.getPrecioTotalPaquete());
    }
}