/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import mod_administracion.Recepcionista;
import mod_administracion.Usuario;
import mod_facturacion.CalculoPrecio;
import mod_facturacion.Cotizacion;
import mod_facturacion.Factura;
import mod_facturacion.Precio;
import mod_paquetes.Paquete;

/**
 *
 * @author USUARIO
 */
public class JFFacturacion extends javax.swing.JFrame {
    int xMouse, yMouse;
    private Recepcionista recepcionista;

    public JFFacturacion(Recepcionista recepcionista) {
        initComponents();
        this.recepcionista = recepcionista;
        setIconImage(new ImageIcon(getClass().getResource("/iconos/factura.png")).getImage());
        cargarFacturas();
        setLocationRelativeTo(null);
        jBGenerarFactura.setVisible(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPFyV = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPRegistrarFactura = new javax.swing.JPanel();
        jPDatosCliente = new javax.swing.JPanel();
        jTNombreCliente = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTTelefonoCliente = new javax.swing.JTextField();
        jLCITipoCliente = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTDireccionCliente = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jTApellidosCliente = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jTcorreoCli = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTCedulaCliente = new javax.swing.JTextField();
        jPDatosFactura = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jTFnumerofactura = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTFechaEmisionFactura = new javax.swing.JTextField();
        jLPrecioPaquete = new javax.swing.JLabel();
        jLPrecioImpuesto = new javax.swing.JLabel();
        jTPrecioPaquete = new javax.swing.JTextField();
        jTPrecioImpuesto = new javax.swing.JTextField();
        jLTotal = new javax.swing.JLabel();
        jTTotal = new javax.swing.JTextField();
        jPPaquete = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jTCodigoPaquete = new javax.swing.JTextField();
        btnBuscarPaquete = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jTContenidoPaquete = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTNombreDestinatario = new javax.swing.JTextField();
        jBGenerarFactura = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLPrecioDistancia = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jTPrecioDistancia = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jPConsultarFactura = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        jTablaRegistrarFactura = new javax.swing.JTable();
        btnAbrirFactura = new javax.swing.JButton();
        jTCodigoFactura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarFactura = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Facturación");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPFyV.setBackground(new java.awt.Color(245, 245, 245));
        JPFyV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPRegistrarFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del cliente"));
        jPDatosCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTNombreCliente.setEditable(false);
        jPDatosCliente.add(jTNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 250, -1));

        jLabel30.setText("Teléfono móvil:");
        jPDatosCliente.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jTTelefonoCliente.setEditable(false);
        jPDatosCliente.add(jTTelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 250, -1));

        jLCITipoCliente.setText("CI:");
        jPDatosCliente.add(jLCITipoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel33.setText("Dirección:");
        jPDatosCliente.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jTDireccionCliente.setEditable(false);
        jPDatosCliente.add(jTDireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 250, -1));

        jLabel45.setText("Apellidos:");
        jPDatosCliente.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jTApellidosCliente.setEditable(false);
        jPDatosCliente.add(jTApellidosCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 250, -1));

        jLabel85.setText("Correo:");
        jPDatosCliente.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 43, -1));

        jTcorreoCli.setEditable(false);
        jPDatosCliente.add(jTcorreoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 250, -1));

        jLabel31.setText("Nombres:");
        jPDatosCliente.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jTCedulaCliente.setEditable(false);
        jPDatosCliente.add(jTCedulaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 250, -1));

        jPRegistrarFactura.add(jPDatosCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 450, 270));

        jPDatosFactura.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Factura"));
        jPDatosFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setText("Número de factura");
        jPDatosFactura.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 35, -1, -1));

        jTFnumerofactura.setEditable(false);
        jPDatosFactura.add(jTFnumerofactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 112, -1));

        jLabel38.setText("Fecha de emisión");
        jPDatosFactura.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 91, -1, -1));

        jTFechaEmisionFactura.setEditable(false);
        jPDatosFactura.add(jTFechaEmisionFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 112, -1));

        jPRegistrarFactura.add(jPDatosFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 190, 180));

        jLPrecioPaquete.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLPrecioPaquete.setText("Precio Paquete");
        jPRegistrarFactura.add(jLPrecioPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 440, 120, -1));

        jLPrecioImpuesto.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLPrecioImpuesto.setText("IVA (15%)");
        jPRegistrarFactura.add(jLPrecioImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 470, -1, -1));

        jTPrecioPaquete.setEditable(false);
        jPRegistrarFactura.add(jTPrecioPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 440, 151, -1));

        jTPrecioImpuesto.setEditable(false);
        jTPrecioImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPrecioImpuestoActionPerformed(evt);
            }
        });
        jPRegistrarFactura.add(jTPrecioImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 470, 151, -1));

        jLTotal.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLTotal.setText("Total");
        jPRegistrarFactura.add(jLTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, -1, -1));

        jTTotal.setEditable(false);
        jTTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTTotalActionPerformed(evt);
            }
        });
        jPRegistrarFactura.add(jTTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 500, 151, -1));

        jPPaquete.setBorder(javax.swing.BorderFactory.createTitledBorder("Paquete"));
        jPPaquete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setText("Código paquete");
        jPPaquete.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jTCodigoPaquete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCodigoPaqueteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCodigoPaqueteKeyTyped(evt);
            }
        });
        jPPaquete.add(jTCodigoPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 142, -1));

        btnBuscarPaquete.setText("Buscar");
        btnBuscarPaquete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPaqueteActionPerformed(evt);
            }
        });
        jPPaquete.add(btnBuscarPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel64.setText("Contenido");
        jPPaquete.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jTContenidoPaquete.setEditable(false);
        jTContenidoPaquete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTContenidoPaqueteKeyReleased(evt);
            }
        });
        jPPaquete.add(jTContenidoPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 200, 30));

        jLabel29.setText("Nombre Destinatario");
        jPPaquete.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jTNombreDestinatario.setEditable(false);
        jPPaquete.add(jTNombreDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 200, 30));

        jPRegistrarFactura.add(jPPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 230));

        jBGenerarFactura.setText("Generar Factura");
        jBGenerarFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGenerarFacturaActionPerformed(evt);
            }
        });
        jPRegistrarFactura.add(jBGenerarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 550, -1, -1));
        jPRegistrarFactura.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 360, 1190, 10));

        jLabel67.setText("$");
        jPRegistrarFactura.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 500, -1, -1));

        jLabel68.setText("$");
        jPRegistrarFactura.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 470, -1, -1));

        jLPrecioDistancia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLPrecioDistancia.setText("Precio Distancia");
        jPRegistrarFactura.add(jLPrecioDistancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 410, 120, -1));

        jLabel70.setText("$");
        jPRegistrarFactura.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 410, 10, -1));

        jTPrecioDistancia.setEditable(false);
        jTPrecioDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPrecioDistanciaActionPerformed(evt);
            }
        });
        jPRegistrarFactura.add(jTPrecioDistancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 410, 151, -1));

        jLabel71.setText("$");
        jPRegistrarFactura.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 440, 10, -1));

        jTabbedPane1.addTab("Registrar factura", jPRegistrarFactura);

        jPConsultarFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablaRegistrarFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Contenido", "Remitente", "Destinario", "Provincia Origen", "Provincia Destino", "Dirección Destino", "Precio Total", "Fecha y Hora Emitida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaRegistrarFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaRegistrarFacturaMouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(jTablaRegistrarFactura);

        jPConsultarFactura.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 1050, 390));

        btnAbrirFactura.setText("Abrir");
        btnAbrirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirFacturaActionPerformed(evt);
            }
        });
        jPConsultarFactura.add(btnAbrirFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 530, 90, 30));
        jPConsultarFactura.add(jTCodigoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 160, -1));

        jLabel1.setText("Código Factura");
        jPConsultarFactura.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        btnBuscarFactura.setText("Buscar");
        btnBuscarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFacturaActionPerformed(evt);
            }
        });
        jPConsultarFactura.add(btnBuscarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        jTabbedPane1.addTab("Consultar facturas", jPConsultarFactura);

        JPFyV.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1150, 630));

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
        jLabel69.setText("Facturación");
        jPanel3.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        JPFyV.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 30));

        getContentPane().add(JPFyV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTCodigoPaqueteKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTCodigoPaqueteKeyReleased

    }// GEN-LAST:event_jTCodigoPaqueteKeyReleased

    private void jTCodigoPaqueteKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTCodigoPaqueteKeyTyped
        char variable = evt.getKeyChar();
        if (Character.isLetter(variable)) {
            getToolkit().beep();
            evt.consume();
            jTCodigoPaquete.requestFocus();
            JOptionPane.showMessageDialog(null, "Ingrese solo números");
        }
    }// GEN-LAST:event_jTCodigoPaqueteKeyTyped

    private void btnBuscarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarPaqueteActionPerformed
        String codigoTracking = jTCodigoPaquete.getText();
        Paquete paquete = recepcionista.obtenerPaquete(codigoTracking);
        if (paquete == null) {
            JOptionPane.showMessageDialog(null, "No existe paquete.", "PAPU", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String contenidoPaquete = paquete.getContenido();
        String nombreDestinatario = paquete.getNombreDestinatario();

        Usuario remitente = paquete.getRemitente();
        String nombresRemitente = remitente.getNombres();
        String apellidosRemitente = remitente.getApellidos();
        String cedulaRemitente = remitente.getCedula();
        String telefonoRemitente = remitente.getTelefono();
        String direccionRemitente = remitente.getDireccion();
        String correoRemitente = remitente.getEmail();

        String codigoFactura = recepcionista.getSiguienteCodigoFactura();
        Precio precioDelPaquete = recepcionista.obtenerPrecioPaquete(paquete);
        ArrayList<CalculoPrecio> preciosIndividuales = precioDelPaquete.obtenerPreciosIndividuales();
        double precioPaquete = preciosIndividuales.get(0).obtenerMonto();
        double precioDistancia = preciosIndividuales.get(1).obtenerMonto();
        double precioImpuesto = preciosIndividuales.get(2).obtenerMonto();
        double precioTotal = precioDelPaquete.getPrecioTotalPaquete();

        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fechaActual.format(formatoFecha);

        jTFechaEmisionFactura.setText(fechaFormateada);

        jTNombreDestinatario.setText(nombreDestinatario);
        jTContenidoPaquete.setText(contenidoPaquete);
        jTFnumerofactura.setText(codigoFactura);
        jTCedulaCliente.setText(cedulaRemitente);
        jTNombreCliente.setText(nombresRemitente);
        jTApellidosCliente.setText(apellidosRemitente);
        jTTelefonoCliente.setText(telefonoRemitente);
        jTDireccionCliente.setText(direccionRemitente);
        jTcorreoCli.setText(correoRemitente);
        jTPrecioDistancia.setText(String.valueOf(precioDistancia));
        jTPrecioImpuesto.setText(String.valueOf(precioImpuesto));
        jTPrecioPaquete.setText(String.valueOf(precioPaquete));
        jTTotal.setText(String.valueOf(precioTotal));
        jBGenerarFactura.setVisible(true);
    }// GEN-LAST:event_btnBuscarPaqueteActionPerformed

    private void jTContenidoPaqueteKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTContenidoPaqueteKeyReleased

    }// GEN-LAST:event_jTContenidoPaqueteKeyReleased

    private void jBGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBGenerarFacturaActionPerformed
        String codigoTracking = jTCodigoPaquete.getText();
        Paquete paquete = recepcionista.obtenerPaquete(codigoTracking);
        recepcionista.emitirFacturaPaquete(paquete);
        cargarFacturas();
        JOptionPane.showMessageDialog(null, "Se generó la factura existosamente.", "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }// GEN-LAST:event_jBGenerarFacturaActionPerformed

    private void jTablaRegistrarFacturaMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTablaRegistrarFacturaMouseClicked

    }// GEN-LAST:event_jTablaRegistrarFacturaMouseClicked

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }// GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }// GEN-LAST:event_jPanel3MousePressed

    private void jTTotalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTTotalActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTTotalActionPerformed

    private void jTPrecioDistanciaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTPrecioDistanciaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPrecioDistanciaActionPerformed

    private void jTPrecioImpuestoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTPrecioImpuestoActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPrecioImpuestoActionPerformed

    private void btnBuscarFacturaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarFacturaActionPerformed
        String codigoFactura = jTCodigoFactura.getText();
        Factura factura = recepcionista.buscarFactura(codigoFactura);
        if (factura == null) {
            JOptionPane.showMessageDialog(null, "No hay esa factura.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DefaultTableModel model = (DefaultTableModel) jTablaRegistrarFactura.getModel();
            model.setRowCount(0);
            Object[] row = {
                    factura.obtenerCodigo(),
                    factura.obtenerDescripcion(),
                    obtenerDatosCliente(factura)[0],
                    factura.obtenerNombreDestinatario(),
                    factura.obtenerProvinciaOrigen(),
                    factura.obtenerProvinciaDestino(),
                    factura.obtenerDireccionDestino(),
                    factura.obtenerPrecioTotal(),
                    factura.obtenerFechaEmision(),
            };
            model.addRow(row);
            JOptionPane.showMessageDialog(null, "La factura fue encontrada con éxito.", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }// GEN-LAST:event_btnBuscarFacturaActionPerformed

    private void btnAbrirFacturaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAbrirFacturaActionPerformed
        JTable tabla = jTablaRegistrarFactura;
        int selectedRow = tabla.getSelectedRow();
        if (selectedRow != -1) {
            TableModel model = tabla.getModel();
            Object value = model.getValueAt(selectedRow, 0);
            Factura factura = recepcionista.buscarFactura(String.valueOf(value));
            Usuario remitente = factura.obtenerCliente();
            String nombresRemitente = remitente.getNombres();
            String apellidosRemitente = remitente.getApellidos();
            String direccionRemitente = remitente.getDireccion();
            String telefonoRemitente = remitente.getTelefono();
            String cedulaRemitente = remitente.getCedula();
            Precio precio = factura.obtenerPrecio();
            ArrayList<CalculoPrecio> preciosIndividuales = precio.obtenerPreciosIndividuales();
            double precioPaquete = preciosIndividuales.get(0).obtenerMonto();
            double precioDistancia = preciosIndividuales.get(1).obtenerMonto();
            double precioImpuesto = preciosIndividuales.get(2).obtenerMonto();
            double precioTotal = precio.getPrecioTotalPaquete();
            JFFactura mostrarFactura = new JFFactura(factura.obtenerCodigo(), factura.obtenerFechaEmision(),
                    factura.obtenerCodigoTracking(), factura.obtenerNombreDestinatario(),
                    factura.obtenerProvinciaDestino(),
                    factura.obtenerDireccionDestino(), factura.obtenerDescripcion(), factura.obtenerPesoPaquete(),
                    nombresRemitente, apellidosRemitente, direccionRemitente, telefonoRemitente, cedulaRemitente,
                    precioPaquete, precioDistancia, precioImpuesto, precioTotal);
            mostrarFactura.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una factura, por favor.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }// GEN-LAST:event_btnAbrirFacturaActionPerformed

    private void cargarFacturas() {
        Cotizacion cotizacion = Cotizacion.obtenerInstancia();
        ArrayList<Factura> facturas = cotizacion.obtenerFacturas();
        DefaultTableModel model = (DefaultTableModel) jTablaRegistrarFactura.getModel();

        model.setRowCount(0);

        for (Factura factura : facturas) {
            Object[] row = {
                    factura.obtenerCodigo(),
                    factura.obtenerDescripcion(),
                    obtenerDatosCliente(factura)[0],
                    factura.obtenerNombreDestinatario(),
                    factura.obtenerProvinciaOrigen(),
                    factura.obtenerProvinciaDestino(),
                    factura.obtenerDireccionDestino(),
                    factura.obtenerPrecioTotal(),
                    factura.obtenerFechaEmision(),
            };
            model.addRow(row);
        }
    }

    public String[] obtenerDatosCliente(Factura factura) {
        String[] datosCliente = new String[5];
        Usuario cliente = factura.obtenerCliente();
        datosCliente[0] = cliente.getNombres() + " " + cliente.getApellidos();
        datosCliente[1] = cliente.getCedula();
        return datosCliente;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPFyV;
    private javax.swing.JButton btnAbrirFactura;
    private javax.swing.JButton btnBuscarFactura;
    private javax.swing.JButton btnBuscarPaquete;
    private javax.swing.JButton jBGenerarFactura;
    private javax.swing.JLabel jLCITipoCliente;
    private javax.swing.JLabel jLPrecioDistancia;
    private javax.swing.JLabel jLPrecioImpuesto;
    private javax.swing.JLabel jLPrecioPaquete;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JPanel jPConsultarFactura;
    private javax.swing.JPanel jPDatosCliente;
    private javax.swing.JPanel jPDatosFactura;
    private javax.swing.JPanel jPPaquete;
    private javax.swing.JPanel jPRegistrarFactura;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTApellidosCliente;
    private javax.swing.JTextField jTCedulaCliente;
    private javax.swing.JTextField jTCodigoFactura;
    private javax.swing.JTextField jTCodigoPaquete;
    private javax.swing.JTextField jTContenidoPaquete;
    private javax.swing.JTextField jTDireccionCliente;
    private javax.swing.JTextField jTFechaEmisionFactura;
    private javax.swing.JTextField jTFnumerofactura;
    private javax.swing.JTextField jTNombreCliente;
    private javax.swing.JTextField jTNombreDestinatario;
    private javax.swing.JTextField jTPrecioDistancia;
    private javax.swing.JTextField jTPrecioImpuesto;
    private javax.swing.JTextField jTPrecioPaquete;
    private javax.swing.JTextField jTTelefonoCliente;
    private javax.swing.JTextField jTTotal;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablaRegistrarFactura;
    private javax.swing.JTextField jTcorreoCli;
    // End of variables declaration//GEN-END:variables

}
