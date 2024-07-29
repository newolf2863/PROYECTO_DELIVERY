/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_encomienda.GUI;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_encomienda.BDYValidaciones.ConsultarBD;
import proyecto_encomienda.BDYValidaciones.CreadorTablas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import proyecto_encomienda.BDYValidaciones.ActualizarEstadoFactura;
import proyecto_encomienda.BDYValidaciones.RegistrarDatosFactura;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import com.toedter.calendar.JTextFieldDateEditor;
import java.util.List;
import javax.swing.JLabel;
import proyecto_encomienda.BDYValidaciones.ValidadorDeSwings;
import proyecto_encomienda.BDYValidaciones.ValidadorDeRegistros;
import proyecto_encomienda.BDYValidaciones.VisibilidadManager;
/**
 *
 * @author USUARIO
 */
public class JFFacturacion extends javax.swing.JFrame {
//Validadores

    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
//Factura
  private boolean nombreNegocioValido = false;
    private boolean estadoPagoP = false;
    private boolean rucV = false;
    private boolean dirNeg = false;
    private boolean telefonoNeg = false;
    private boolean rucCliente = false;
    private boolean nombreCFactura = false;
    private boolean apellidoCFactura = false;
    private boolean telfCliente = false;
    private boolean dirCliente = false;
    private boolean correoElectronico = false;
    private  boolean cambiarSesion = true;

    private boolean nombreItemValidar1 = false;
    private boolean stockValidar1 = false;
    private boolean precioUValidar1 = false;
    
//Mouse
    int xMouse, yMouse;
    private VisibilidadManager visibilidadManager;
    Connection cnx;
    
    public JFFacturacion(Connection cnx) {
        initComponents();
        this.cnx=cnx;
        setIconImage(new ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/factura.png")).getImage());
        this.visibilidadManager = new VisibilidadManager();
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        java.util.Date fechaActual = new java.util.Date();
        JTextFieldDateEditor editor = (JTextFieldDateEditor) jDateChooserFecha.getDateEditor();
        editor.setEditable(false);
        jDateChooserFecha.setMaxSelectableDate(fechaActual); // Fecha máxima permitida
        jDateChooserFecha.setMinSelectableDate(null);
        setLocationRelativeTo(null);
        deshabilitar();
    }
    
    public JFFacturacion() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/factura.png")).getImage());
        // Inicializa el campo IDIncidentesTF con el siguiente ID
        this.visibilidadManager = new VisibilidadManager();
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    }

    public boolean isCambiarSesion() {
        return cambiarSesion;
    }

    public void setCambiarSesion(boolean cambiarSesion) {
        this.cambiarSesion = cambiarSesion;
    }

    

    private void validarCamposJuridico() {
        String nacionalExtranjero = jCBNacionalExtranjero1.getSelectedItem().toString();
        String naturalJuridico = jCBJuridicoNatural1.getSelectedItem().toString();

        if (nacionalExtranjero.equals("Selecciona") || naturalJuridico.equals("Natural o Jurídico")) {
            jTCIDelCliente.setEnabled(false); // Deshabilitar el campo si las selecciones no son válidas
        } else {
            jTCIDelCliente.setEnabled(true); // Habilitar el campo si las selecciones son válidas
        }
    }
    
    public void detectorExtranjeroNacional() {
        String seleccionExtranjero = (String) jCBNacionalExtranjero1.getSelectedItem();
        if ("Nacional".equals(seleccionExtranjero)) {
            jTTelefonoCliente.setText("+593-");
        } else if ("Extranjero".equals(seleccionExtranjero)) {
            jTTelefonoCliente.setText("+1-");
        }
    }
    
     public boolean fechaVacia(JDateChooser dateChooser, JLabel label) {
        if (dateChooser.getDate() == null) {
            label.setVisible(true);
            return false;
        } else {
            label.setVisible(false);
            return true;
        }
    }
     
      public void cambiarValoresFalsosF() {
        nombreNegocioValido = false;
        estadoPagoP = false;
        rucV = false;
        dirNeg = false;
        telefonoNeg = false;
        rucCliente = false;
        nombreCFactura = false;
        apellidoCFactura = false;
        telfCliente = false;
        dirCliente = false;
        correoElectronico = false;
    }
      
        public void cambiarValoresNego() {
        nombreNegocioValido = true;
        estadoPagoP = true;
        rucV = true;
        dirNeg = true;
        telefonoNeg = true;
    }
        
        
      
      private void deshabilitarCampos() {
        // Deshabilitar los componentes
        jBRegistrarFactura.setEnabled(false);
        jTFnumerofactura.setEnabled(false);
        jDateChooserFecha.setEnabled(false);
        jCBEstadoPago.setEnabled(true);
        jTFNombreNegocio.setEnabled(false);
        jTFRUCNegocio.setEnabled(false);
        jTFDirNegocio.setEnabled(false);
        jTFTelefonoNegocio.setEnabled(false);
        jCBNacionalExtranjero1.setEnabled(false);
        jCBJuridicoNatural1.setEnabled(false);
        jTCIDelCliente.setEnabled(false);
        jTFApeliidosCliente.setEnabled(false);
        jTTelefonoCliente.setEnabled(false);
        jTDireccionCliente.setEnabled(false);
        correoCli.setEnabled(false);
        jTNombreCliente.setEnabled(false);
        // Habilitar los componentes
        idItemFactura.setEnabled(true);
        jTextField25.setEnabled(true);
        jBAgregarProducto.setEnabled(true);
        jBQuitarProducto.setEnabled(true);
        jBGenerarFactura.setEnabled(true);

    }

    private void limpiarYCambiarCampos() {
        jDateChooserFecha.setEnabled(true);
        jCBEstadoPago.setEnabled(false);
        jTFNombreNegocio.setEnabled(true);
        jTFRUCNegocio.setEnabled(true);
        jTFDirNegocio.setEnabled(true);
        jTFTelefonoNegocio.setEnabled(true);
        jCBNacionalExtranjero1.setEnabled(true);
        jCBJuridicoNatural1.setEnabled(true);
        jTCIDelCliente.setEnabled(true);
        jTNombreCliente.setEnabled(true);
        jTFApeliidosCliente.setEnabled(true);
        jTTelefonoCliente.setEnabled(true);
        jTDireccionCliente.setEnabled(true);
        correoCli.setEnabled(true);
        jBRegistrarFactura.setEnabled(true);
        idItemFactura.setEnabled(false);
        jTextField25.setEnabled(false);
        jBAgregarProducto.setEnabled(false);
        jBQuitarProducto.setEnabled(false);
        jBGenerarFactura.setEnabled(false);

        jTFNombreNegocio.setText("");
        jTFRUCNegocio.setText("");
        jTFDirNegocio.setText("");
        jTFTelefonoNegocio.setText("");
        jTCIDelCliente.setText("");
        jTNombreCliente.setText("");
        jTFApeliidosCliente.setText("");
        jTTelefonoCliente.setText("");
        jTDireccionCliente.setText("");
        correoCli.setText("");
        jTFSubtotal.setText("");
        jTextField5.setText("");
        idItemFactura.setText("");
        idItemFactura.setText("");
        jTextField25.setText("");
        jDateChooserFecha.setDate(null);

    }
    
    public void deshabilitar() {
        jTCIDelCliente.setEnabled(false);
        jTextField25.setEnabled(false);
        jBAgregarProducto.setEnabled(false);
        jBQuitarProducto.setEnabled(false);
        jBGenerarFactura.setEnabled(false);
        jCBEstadoPago.setEnabled(false);
    }
    
     private void actualizarTablaComprasClienteID(int idFactura) {
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarItemsID(cnx, idFactura);
        jTablaRegistrarFactura.setModel(modelo); // Actualizar la tabla con el nuevo modelo
    }
     
      private String getValueAtSelectedRow(DefaultTableModel model, int selectedRow, String columnName) {
        int colIndex = model.findColumn(columnName);
        return colIndex != -1 ? model.getValueAt(selectedRow, colIndex).toString() : "";
    }
      
       private void fillBusinessFields(String ruc, String nombre, String direccion, String telefono) {
        jTFRUCNegocio.setText(ruc);
        jTFNombreNegocio.setText(nombre);
        jTFDirNegocio.setText(direccion);
        jTFTelefonoNegocio.setText(telefono);
    }

    private void fillProducto(String idtems, String nombreproducto) {
        idItemFactura.setText(idtems);
        nombreProducto.setText(nombreproducto);
    }

    private void fillClientFields(String id, String nombre, String apellido, String telefono, String direccion, String esExtranjero, String tipo, String correo) {

        if (esExtranjero.equals("Extranjero")) {  // Supongo que "true" indica extranjero
            jCBNacionalExtranjero1.setSelectedItem("Extranjero");
        } else {
            if (esExtranjero.equals("Nacional")) {  // Supongo que "true" indica extranjero
                jCBNacionalExtranjero1.setSelectedItem("Nacional");
            }
        }

        if (tipo.equals("Jurídico")) {  // Supongo que "true" indica extranjero
            jCBJuridicoNatural1.setSelectedItem("Jurídico");
        } else {
            if (tipo.equals("Natural")) {  // Supongo que "true" indica extranjero
                jCBJuridicoNatural1.setSelectedItem("Natural");
            }
        }
        jTCIDelCliente.setText(id);
        jTNombreCliente.setText(nombre);
        jTFApeliidosCliente.setText(apellido);
        jTTelefonoCliente.setText(telefono);
        jTDireccionCliente.setText(direccion);
        correoCli.setText(correo);
    }
   
    
     

   
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPFyV = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jFNumeroFactura2 = new javax.swing.JTextField();
        AnularFactura = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFacturas = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jFNumeroFactura3 = new javax.swing.JTextField();
        CambiarEstadoF = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPDatosCliente = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jTNombreCliente = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTTelefonoCliente = new javax.swing.JTextField();
        jLCITipoCliente = new javax.swing.JLabel();
        jTCIDelCliente = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTDireccionCliente = new javax.swing.JTextField();
        jCBNacionalExtranjero1 = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jTFApeliidosCliente = new javax.swing.JTextField();
        jBRegistrarFactura = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        correoCli = new javax.swing.JTextField();
        jCBJuridicoNatural1 = new javax.swing.JComboBox<>();
        jError7 = new javax.swing.JLabel();
        jError8 = new javax.swing.JLabel();
        jError9 = new javax.swing.JLabel();
        jError10 = new javax.swing.JLabel();
        jError11 = new javax.swing.JLabel();
        jError12 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jPDatosFactura = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jTFnumerofactura = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        jError6 = new javax.swing.JLabel();
        jPDatosNegocio = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jTFNombreNegocio = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTFRUCNegocio = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTFDirNegocio = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTFTelefonoNegocio = new javax.swing.JTextField();
        jError2 = new javax.swing.JLabel();
        jError1 = new javax.swing.JLabel();
        jError3 = new javax.swing.JLabel();
        jError4 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jTFSubtotal = new javax.swing.JTextField();
        IVAText = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPProducto = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        idItemFactura = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jBAgregarProducto = new javax.swing.JButton();
        jBQuitarProducto = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        nombreProducto = new javax.swing.JTextField();
        jBGenerarFactura = new javax.swing.JButton();
        jScrollPane26 = new javax.swing.JScrollPane();
        jTablaRegistrarFactura = new javax.swing.JTable();
        jCBEstadoPago = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jError5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableFacturas1 = new javax.swing.JTable();
        jBVerGanancias = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Facturación");
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        JPFyV.setBackground(new java.awt.Color(245, 245, 245));
        JPFyV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Consultar facturas", jPanel12);

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder("Anular Factura"));

        jLabel48.setText("N° de factura");

        jFNumeroFactura2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFNumeroFactura2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFNumeroFactura2KeyTyped(evt);
            }
        });

        AnularFactura.setText("Anular factura");
        AnularFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnularFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jFNumeroFactura2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(AnularFactura)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFNumeroFactura2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnularFactura)
                .addContainerGap())
        );

        jTableFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Fecha", "Factura", "Cliente", "Total", "Estado"
            }
        ));
        jScrollPane2.setViewportView(jTableFacturas);

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambiar estado de pago"));

        jLabel52.setText("N° de factura");

        jFNumeroFactura3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFNumeroFactura3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFNumeroFactura3KeyTyped(evt);
            }
        });

        CambiarEstadoF.setText("Cambiar estado de pago");
        CambiarEstadoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarEstadoFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addComponent(jFNumeroFactura3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CambiarEstadoF))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFNumeroFactura3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CambiarEstadoF)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(807, Short.MAX_VALUE)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(906, Short.MAX_VALUE)))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(429, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Cambiar estado de la factura", jPanel28);

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del cliente"));

        jLabel29.setText("Nombres");

        jTNombreCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTNombreClienteFocusLost(evt);
            }
        });
        jTNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNombreClienteKeyTyped(evt);
            }
        });

        jLabel30.setText("Teléfono móvil");

        jTTelefonoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTTelefonoClienteFocusLost(evt);
            }
        });
        jTTelefonoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTTelefonoClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTTelefonoClienteKeyTyped(evt);
            }
        });

        jLCITipoCliente.setText("Documento");

        jTCIDelCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCIDelClienteFocusLost(evt);
            }
        });
        jTCIDelCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCIDelClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCIDelClienteKeyTyped(evt);
            }
        });

        jLabel33.setText("Dirección");

        jTDireccionCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTDireccionClienteFocusLost(evt);
            }
        });
        jTDireccionCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTDireccionClienteKeyReleased(evt);
            }
        });

        jCBNacionalExtranjero1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Nacional", "Extranjero" }));
        jCBNacionalExtranjero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBNacionalExtranjero1ActionPerformed(evt);
            }
        });

        jLabel45.setText("Apellidos:");

        jTFApeliidosCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFApeliidosClienteFocusLost(evt);
            }
        });
        jTFApeliidosCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFApeliidosClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFApeliidosClienteKeyTyped(evt);
            }
        });

        jBRegistrarFactura.setText("Registrar datos básicos");
        jBRegistrarFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBRegistrarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarFacturaActionPerformed(evt);
            }
        });

        jLabel85.setText("Correo");

        correoCli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                correoCliFocusLost(evt);
            }
        });
        correoCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                correoCliKeyReleased(evt);
            }
        });

        jCBJuridicoNatural1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Natural o Jurídico", "Natural", "Jurídico" }));
        jCBJuridicoNatural1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBJuridicoNatural1ActionPerformed(evt);
            }
        });

        jError7.setForeground(new java.awt.Color(255, 102, 102));
        jError7.setText("*error");

        jError8.setForeground(new java.awt.Color(255, 102, 102));
        jError8.setText("Nombre inválido");

        jError9.setForeground(new java.awt.Color(255, 102, 102));
        jError9.setText("Apellido inválido");

        jError10.setForeground(new java.awt.Color(255, 102, 102));
        jError10.setText("*error");

        jError11.setForeground(new java.awt.Color(255, 102, 102));
        jError11.setText("Dirección inválida");

        jError12.setForeground(new java.awt.Color(255, 102, 102));
        jError12.setText("Correo inválido");

        jLabel113.setText("Nacionalidad:");

        jLabel114.setText("Tipo de cliente");

        javax.swing.GroupLayout jPDatosClienteLayout = new javax.swing.GroupLayout(jPDatosCliente);
        jPDatosCliente.setLayout(jPDatosClienteLayout);
        jPDatosClienteLayout.setHorizontalGroup(
            jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosClienteLayout.createSequentialGroup()
                        .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTDireccionCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(correoCli))
                        .addGap(18, 18, 18)
                        .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jError11)
                            .addComponent(jError12))
                        .addGap(146, 146, 146))
                    .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPDatosClienteLayout.createSequentialGroup()
                            .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPDatosClienteLayout.createSequentialGroup()
                                    .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel29)
                                        .addComponent(jLCITipoCliente)
                                        .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPDatosClienteLayout.createSequentialGroup()
                                            .addComponent(jCBNacionalExtranjero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPDatosClienteLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jTCIDelCliente))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDatosClienteLayout.createSequentialGroup()
                                            .addGap(0, 6, Short.MAX_VALUE)
                                            .addComponent(jTNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPDatosClienteLayout.createSequentialGroup()
                                    .addComponent(jLabel45)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTFApeliidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPDatosClienteLayout.createSequentialGroup()
                                    .addComponent(jLabel30)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTTelefonoCliente)))
                            .addGap(12, 12, 12)
                            .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jError10)
                                .addComponent(jError7)
                                .addComponent(jError8)
                                .addComponent(jError9))
                            .addGap(25, 156, Short.MAX_VALUE))
                        .addGroup(jPDatosClienteLayout.createSequentialGroup()
                            .addGap(113, 113, 113)
                            .addComponent(jBRegistrarFactura)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPDatosClienteLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel114)
                            .addGap(20, 20, 20)
                            .addComponent(jCBJuridicoNatural1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)))))
        );
        jPDatosClienteLayout.setVerticalGroup(
            jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosClienteLayout.createSequentialGroup()
                .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBNacionalExtranjero1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCBJuridicoNatural1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel113)
                        .addComponent(jLabel114)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTCIDelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jError7))
                    .addComponent(jLCITipoCliente, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jTNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jError8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jTFApeliidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jError9))
                .addGap(12, 12, 12)
                .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jTTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jError10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jError11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(jTDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel85)
                    .addGroup(jPDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(correoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jError12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBRegistrarFactura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.add(jPDatosCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 540, 270));

        jPDatosFactura.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Factura"));

        jLabel34.setText("Número de factura");

        jTFnumerofactura.setEditable(false);

        jLabel38.setText("Fecha de emisión");

        jDateChooserFecha.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserFecha.setDateFormatString("dd-MM-yyyy");
        jDateChooserFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooserFechaMouseClicked(evt);
            }
        });

        jError6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jError6.setForeground(new java.awt.Color(204, 0, 51));
        jError6.setText("*Vacio");

        javax.swing.GroupLayout jPDatosFacturaLayout = new javax.swing.GroupLayout(jPDatosFactura);
        jPDatosFactura.setLayout(jPDatosFacturaLayout);
        jPDatosFacturaLayout.setHorizontalGroup(
            jPDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosFacturaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jError6)
                    .addGroup(jPDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel38)
                        .addComponent(jLabel34)
                        .addComponent(jTFnumerofactura)
                        .addComponent(jDateChooserFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPDatosFacturaLayout.setVerticalGroup(
            jPDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosFacturaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFnumerofactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38)
                .addGap(12, 12, 12)
                .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jError6)
                .addContainerGap())
        );

        jPanel14.add(jPDatosFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 190, 180));

        jPDatosNegocio.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del negocio"));

        jLabel40.setText("Nombre del negocio");

        jTFNombreNegocio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFNombreNegocioFocusLost(evt);
            }
        });
        jTFNombreNegocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFNombreNegocioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreNegocioKeyTyped(evt);
            }
        });

        jLabel41.setText("RUC del negocio");

        jTFRUCNegocio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFRUCNegocioFocusLost(evt);
            }
        });
        jTFRUCNegocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFRUCNegocioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFRUCNegocioKeyTyped(evt);
            }
        });

        jLabel42.setText("Dirección del negocio");

        jTFDirNegocio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFDirNegocioFocusLost(evt);
            }
        });
        jTFDirNegocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFDirNegocioKeyReleased(evt);
            }
        });

        jLabel43.setText("Teléfono del negocio    ");

        jTFTelefonoNegocio.setForeground(new java.awt.Color(204, 204, 204));
        jTFTelefonoNegocio.setText("Ejm: 02-1234567");
        jTFTelefonoNegocio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTFTelefonoNegocio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFTelefonoNegocioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFTelefonoNegocioFocusLost(evt);
            }
        });
        jTFTelefonoNegocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFTelefonoNegocioKeyReleased(evt);
            }
        });

        jError2.setForeground(new java.awt.Color(255, 102, 102));
        jError2.setText("RUC inválido");

        jError1.setForeground(new java.awt.Color(255, 102, 102));
        jError1.setText("Nombre del negocio inválido");

        jError3.setForeground(new java.awt.Color(255, 102, 102));
        jError3.setText("Dirección inválida");

        jError4.setForeground(new java.awt.Color(255, 102, 102));
        jError4.setText("Formato: 02-1111111");

        javax.swing.GroupLayout jPDatosNegocioLayout = new javax.swing.GroupLayout(jPDatosNegocio);
        jPDatosNegocio.setLayout(jPDatosNegocioLayout);
        jPDatosNegocioLayout.setHorizontalGroup(
            jPDatosNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosNegocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDatosNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFNombreNegocio)
                    .addGroup(jPDatosNegocioLayout.createSequentialGroup()
                        .addGroup(jPDatosNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPDatosNegocioLayout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(31, 31, 31)
                                .addComponent(jError2))
                            .addGroup(jPDatosNegocioLayout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jError1))
                            .addGroup(jPDatosNegocioLayout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jError3))
                            .addGroup(jPDatosNegocioLayout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jError4)))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addComponent(jTFRUCNegocio)
                    .addComponent(jTFDirNegocio)
                    .addComponent(jTFTelefonoNegocio))
                .addContainerGap())
        );
        jPDatosNegocioLayout.setVerticalGroup(
            jPDatosNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosNegocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDatosNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jError1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFNombreNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPDatosNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jError2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFRUCNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPDatosNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jError3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFDirNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPDatosNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jError4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFTelefonoNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel14.add(jPDatosNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 330, -1));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel44.setText("Subtotal");
        jPanel14.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 71, -1));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel46.setText("IVA (%)");
        jPanel14.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 340, -1, -1));

        jTFSubtotal.setEditable(false);
        jPanel14.add(jTFSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 310, 151, -1));

        IVAText.setEditable(false);
        IVAText.setText("12");
        jPanel14.add(IVAText, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, 151, -1));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel49.setText("Total");
        jPanel14.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, -1, -1));

        jTextField5.setEditable(false);
        jPanel14.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 370, 151, -1));

        jPProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        jLabel37.setText("ID del ítem");

        idItemFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idItemFacturaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idItemFacturaKeyTyped(evt);
            }
        });

        jLabel84.setText("Cantidad");

        jTextField25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField25KeyTyped(evt);
            }
        });

        jBAgregarProducto.setText("Agregar Producto");
        jBAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarProductoActionPerformed(evt);
            }
        });

        jBQuitarProducto.setText("Quitar");
        jBQuitarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitarProductoActionPerformed(evt);
            }
        });

        jLabel36.setText("1/8 de Galón");

        jLabel64.setText("Nombre del ítem");

        nombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreProductoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPProductoLayout = new javax.swing.GroupLayout(jPProducto);
        jPProducto.setLayout(jPProductoLayout);
        jPProductoLayout.setHorizontalGroup(
            jPProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addComponent(jLabel37)
                    .addGroup(jPProductoLayout.createSequentialGroup()
                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36))
                    .addComponent(jLabel84)
                    .addGroup(jPProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(idItemFactura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addComponent(nombreProducto, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPProductoLayout.createSequentialGroup()
                        .addComponent(jBAgregarProducto)
                        .addGap(18, 18, 18)
                        .addComponent(jBQuitarProducto)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPProductoLayout.setVerticalGroup(
            jPProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPProductoLayout.createSequentialGroup()
                .addComponent(jLabel37)
                .addGap(2, 2, 2)
                .addComponent(idItemFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel84)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(27, 27, 27)
                .addGroup(jPProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregarProducto)
                    .addComponent(jBQuitarProducto))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel14.add(jPProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 250, 220));

        jBGenerarFactura.setText("Generar Factura");
        jBGenerarFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGenerarFacturaActionPerformed(evt);
            }
        });
        jPanel14.add(jBGenerarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, -1, -1));

        jTablaRegistrarFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablaRegistrarFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaRegistrarFacturaMouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(jTablaRegistrarFactura);

        jPanel14.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 830, 142));

        jCBEstadoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Pendiente de Pago", "Cancelado" }));
        jCBEstadoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEstadoPagoActionPerformed(evt);
            }
        });
        jPanel14.add(jCBEstadoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 160, -1));

        jLabel39.setText("Estado de Pago");
        jPanel14.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, -1, -1));

        jError5.setForeground(new java.awt.Color(255, 102, 102));
        jError5.setText("*Seleccione el estado del pago");
        jPanel14.add(jError5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));
        jPanel14.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 293, 1190, 10));

        jLabel67.setText("$");
        jPanel14.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 310, -1, -1));

        jLabel68.setText("$");
        jPanel14.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 370, -1, -1));

        jTabbedPane1.addTab("Registrar factura", jPanel14);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );

        jTableFacturas1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Fecha", "Factura", "Cliente", "Total", "Estado"
            }
        ));
        jScrollPane3.setViewportView(jTableFacturas1);

        jBVerGanancias.setText("Ver Ganancias Mensuales");
        jBVerGanancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVerGananciasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(jBVerGanancias)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jBVerGanancias)
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ganancias", jPanel22);

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

        JPFyV.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, -1));

        getContentPane().add(JPFyV, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFNumeroFactura2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFNumeroFactura2KeyReleased
        String numeroFacturaFilter = jFNumeroFactura2.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaFacturasTodas(cnx, numeroFacturaFilter); // Llamar al método con el filtro
        jTableFacturas.setModel(modelo);
    }//GEN-LAST:event_jFNumeroFactura2KeyReleased

    private void jFNumeroFactura2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFNumeroFactura2KeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Solo valores numéricos");
        }
    }//GEN-LAST:event_jFNumeroFactura2KeyTyped

    private void AnularFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnularFacturaActionPerformed
        String idFacturaStr = jFNumeroFactura2.getText();
        if (idFacturaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa el número de factura.");
            return;
        }
        // Verificar si el valor ingresado es válido
        if (idFacturaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa un número de factura válido.");
            return;
        }
        try {
            int idFactura = Integer.parseInt(idFacturaStr);
            boolean success = ActualizarEstadoFactura.anularFactura(cnx, idFactura);
            if (success) {
                JOptionPane.showMessageDialog(this, "Factura anulada exitosamente.");
                CreadorTablas creadorTablas = new CreadorTablas();
                DefaultTableModel modelo = creadorTablas.mostrarTablaFacturasTodas(cnx, idFacturaStr);
                jTableFacturas.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo anular la factura. Verifica el número de factura o su estado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa un número de factura válido.");
        }
    }//GEN-LAST:event_AnularFacturaActionPerformed

    private void jFNumeroFactura3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFNumeroFactura3KeyReleased
        String numeroFacturaFilter = jFNumeroFactura3.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarFacturasActivas(cnx, numeroFacturaFilter); // Llamar al método con el filtro
        jTableFacturas.setModel(modelo);
    }//GEN-LAST:event_jFNumeroFactura3KeyReleased

    private void jFNumeroFactura3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFNumeroFactura3KeyTyped
        char variable = evt.getKeyChar();
        if (Character.isLetter(variable)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo números");
        }
    }//GEN-LAST:event_jFNumeroFactura3KeyTyped

    private void CambiarEstadoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarEstadoFActionPerformed

        String idFacturaEstadoPago = jFNumeroFactura3.getText();
        if (idFacturaEstadoPago.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa El número de factura.");
            return;
        }
        try {
            int idFactura = Integer.parseInt(idFacturaEstadoPago);
            boolean success = ActualizarEstadoFactura.cambiarEstadoPago(cnx, idFactura);
            if (success) {
                JOptionPane.showMessageDialog(this, "Estado de Pago cancelado.");
                CreadorTablas creadorTablas = new CreadorTablas();
                DefaultTableModel modelo = creadorTablas.mostrarTablaFacturasCanceladas(cnx, idFacturaEstadoPago);
                jTableFacturas.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(this, "Verifica el número de factura.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa un número de factura válido.");
        }
    }//GEN-LAST:event_CambiarEstadoFActionPerformed

    private void jTNombreClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNombreClienteFocusLost
        nombreCFactura = validarRegistroF.camposDeRegistros(jTNombreCliente, jError8, "n");
    }//GEN-LAST:event_jTNombreClienteFocusLost

    private void jTNombreClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreClienteKeyReleased
        nombreCFactura = validarRegistroF.camposDeRegistros(jTNombreCliente, jError8, "n");
    }//GEN-LAST:event_jTNombreClienteKeyReleased

    private void jTNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreClienteKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "No se permiten valores numéricos en el campo Nombre.");
        }
    }//GEN-LAST:event_jTNombreClienteKeyTyped

    private void jTTelefonoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTTelefonoClienteFocusLost
        String tipoCliente = (String) jCBNacionalExtranjero1.getSelectedItem();
        telfCliente = validarRegistroF.camposCliente(jTTelefonoCliente, jError10, tipoCliente, "Ninguno", "b");
    }//GEN-LAST:event_jTTelefonoClienteFocusLost

    private void jTTelefonoClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTelefonoClienteKeyReleased
        String tipoCliente = (String) jCBNacionalExtranjero1.getSelectedItem();
        telfCliente = validarRegistroF.camposCliente(jTTelefonoCliente, jError10, tipoCliente, "Ninguno", "b");
    }//GEN-LAST:event_jTTelefonoClienteKeyReleased

    private void jTTelefonoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTelefonoClienteKeyTyped
        char keyChar = evt.getKeyChar();
        // Verificar si el carácter es un número, + o -
        if (!Character.isDigit(keyChar) && keyChar != '+' && keyChar != '-' || jTTelefonoCliente.getText().length() >= 14) {
            evt.consume();
            if (jTCIDelCliente.getText().length() >= 14) {
                JOptionPane.showMessageDialog(null, "Máximo 14 caracteres");
            }
        }
    }//GEN-LAST:event_jTTelefonoClienteKeyTyped

    private void jTCIDelClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCIDelClienteFocusLost
        String tipoCliente = (String) jCBNacionalExtranjero1.getSelectedItem();
        String natularJuridico = (String) jCBJuridicoNatural1.getSelectedItem();
        rucCliente = validarRegistroF.camposCliente(jTCIDelCliente, jError7, tipoCliente, natularJuridico, "a");
    }//GEN-LAST:event_jTCIDelClienteFocusLost

    private void jTCIDelClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCIDelClienteKeyReleased
        String filtroIdCliente = jTCIDelCliente.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarClienteParametrizado(cnx, filtroIdCliente, "N"); // Llamas al método con el filtro
        jTablaRegistrarFactura.setModel(modelo); // Actualizas la tabla con el nuevo modelo
        String tipoCliente = (String) jCBNacionalExtranjero1.getSelectedItem();
        String natularJuridico = (String) jCBJuridicoNatural1.getSelectedItem();
        rucCliente = validarRegistroF.camposCliente(jTCIDelCliente, jError7, tipoCliente, natularJuridico, "a");
    }//GEN-LAST:event_jTCIDelClienteKeyReleased

    private void jTCIDelClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCIDelClienteKeyTyped
        char variable = evt.getKeyChar();
        String nacionalExtranjero = jCBNacionalExtranjero1.getSelectedItem().toString();
        String naturalJuridico = jCBJuridicoNatural1.getSelectedItem().toString();

        if (nacionalExtranjero.equals("Selecciona") || naturalJuridico.equals("Natural o Jurídico")) {
            JOptionPane.showMessageDialog(null, "Selecciona los comboBox válidos");
            evt.consume();
        } else {
            if (!Character.isDigit(variable) || jTCIDelCliente.getText().length() >= 15) {
                evt.consume();
                if (jTCIDelCliente.getText().length() >= 15) {
                    JOptionPane.showMessageDialog(null, "Máximo 15 dígitos");
                }
            }
        }
    }//GEN-LAST:event_jTCIDelClienteKeyTyped

    private void jTDireccionClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTDireccionClienteFocusLost
        dirCliente = validarRegistroF.camposDeRegistros(jTDireccionCliente, jError11, "d");
    }//GEN-LAST:event_jTDireccionClienteFocusLost

    private void jTDireccionClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDireccionClienteKeyReleased
        dirCliente = validarRegistroF.camposDeRegistros(jTDireccionCliente, jError11, "d");
    }//GEN-LAST:event_jTDireccionClienteKeyReleased

    private void jCBNacionalExtranjero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBNacionalExtranjero1ActionPerformed
        jTCIDelCliente.setText("");
        String seleccion2 = (String) jCBJuridicoNatural1.getSelectedItem();
        String seleccion = (String) jCBNacionalExtranjero1.getSelectedItem();
        validarCamposJuridico();
        detectorExtranjeroNacional();
        if ("Natural".equals(seleccion2)) {

            if ("Nacional".equals(seleccion)) {
                jCBNacionalExtranjero1.setBackground((new Color(255, 255, 255)));
                jLCITipoCliente.setText("CI");
                jTTelefonoCliente.setText("+593-");
                telfCliente = false;
            } else if ("Extranjero".equals(seleccion)) {
                jCBNacionalExtranjero1.setBackground((new Color(255, 255, 255)));
                jLCITipoCliente.setText("Pasaporte");
                jTTelefonoCliente.setText("+1-");
                telfCliente = false;
            }
        } else if ("Jurídico".equals(seleccion2)) {
            jLCITipoCliente.setText("RUC");

        }
    }//GEN-LAST:event_jCBNacionalExtranjero1ActionPerformed

    private void jTFApeliidosClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFApeliidosClienteFocusLost
        apellidoCFactura = validarRegistroF.camposDeRegistros(jTFApeliidosCliente, jError9, "n");
    }//GEN-LAST:event_jTFApeliidosClienteFocusLost

    private void jTFApeliidosClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApeliidosClienteKeyReleased
        apellidoCFactura = validarRegistroF.camposDeRegistros(jTFApeliidosCliente, jError9, "n");
    }//GEN-LAST:event_jTFApeliidosClienteKeyReleased

    private void jTFApeliidosClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApeliidosClienteKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "No se permiten valores numéricos en el campo Apellido.");
        }
    }//GEN-LAST:event_jTFApeliidosClienteKeyTyped

    private void jBRegistrarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarFacturaActionPerformed
        JTextField[] campos = {jTFNombreNegocio, jTFRUCNegocio, jTFDirNegocio, jTFTelefonoNegocio,
            jTCIDelCliente, jTNombreCliente, jTFApeliidosCliente, jTTelefonoCliente, jTDireccionCliente, correoCli};
        Boolean[] booleansCliente = {nombreNegocioValido, rucV, dirNeg,
            telefonoNeg, rucCliente, nombreCFactura, apellidoCFactura, telfCliente, dirCliente, correoElectronico};
        JLabel[] labels = {jError1, jError2, jError3, jError4, jError7, jError8, jError9, jError10, jError11, jError12};
        String[] nombresCampos = {"nombre del negocio", "RUC del negocio", "dirección del negocio",
            "teléfono del negocio", "documento del cliente", "nombres del cliente",
            "apellidos del cliente", "teléfono móvil del cliente", "dirección del cliente",
            "correo del cliente"};
        boolean fecha = fechaVacia(jDateChooserFecha, jError6);
        List<String> errores = validadorCheck.validarCamposLista(campos, booleansCliente, labels, nombresCampos);
        errores.addAll(validadorCheck.validarCamposVaciosLista(campos, booleansCliente, labels, nombresCampos));
        if (!errores.isEmpty() || !fecha) {
            StringBuilder mensajeError = new StringBuilder("Se encontraron los siguientes errores:\n");
            for (String error : errores) {
                mensajeError.append("- ").append(error).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensajeError.toString(), "Errores", JOptionPane.ERROR_MESSAGE);
        } else {
            jError6.setVisible(false);
            int idFactura = Integer.parseInt(jTFnumerofactura.getText());
            String idCliente = jTCIDelCliente.getText();
            String esExtranjero = (String) jCBNacionalExtranjero1.getSelectedItem();
            try {

                // Datos del negocio
                String rucNegocio = jTFRUCNegocio.getText();
                String nombreNegocio = jTFNombreNegocio.getText();
                String direccionNegocio = jTFDirNegocio.getText();
                String telefonoNegocio = jTFTelefonoNegocio.getText();

                // Datos del cliente
                String nombresCliente = jTNombreCliente.getText();
                String apellidosCliente = jTFApeliidosCliente.getText();
                String telefonoCliente = jTTelefonoCliente.getText();
                String direccionCliente = jTDireccionCliente.getText();
                String tipo = (String) jCBJuridicoNatural1.getSelectedItem();
                String correoDelCli = correoCli.getText();

                // Datos de la factura
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String fechaEmision = dateFormat.format(jDateChooserFecha.getDate());
                //String estadoPago = (String) jCBEstadoPago.getSelectedItem();
                double porcentajeIVA = Double.parseDouble(IVAText.getText());

                // Verificar si la factura ya existe
                if (RegistrarDatosFactura.existeFactura(cnx, idFactura)) {
                    JOptionPane.showMessageDialog(this, "La factura ya está registrada");

                    return;
                }

                // Mostrar el diálogo de confirmación
                int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea registrar estos datos en la factura?",
                    "Confirmación de Registro", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    cambiarValoresFalsosF();
                    // Insertar negocio si no existe
                    RegistrarDatosFactura.insertarDatosNegocio(cnx, rucNegocio,
                        nombreNegocio, direccionNegocio, telefonoNegocio);
                    // Insertar cliente si no existe
                    RegistrarDatosFactura.insertarDatosCliente(cnx, idCliente, nombresCliente,
                        apellidosCliente, telefonoCliente,
                        direccionCliente, esExtranjero, tipo, correoDelCli);
                    // Insertar factura
                    RegistrarDatosFactura.insertarDatosFactura(cnx, idFactura, fechaEmision,
                        rucNegocio, idCliente,
                        porcentajeIVA);
                    JOptionPane.showMessageDialog(this, "Datos básicos registrados con éxito");
                    deshabilitarCampos();
                    cambiarSesion = false;
                }

                // Cerrar conexión
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al registrar la factura");
            }
        }
    }//GEN-LAST:event_jBRegistrarFacturaActionPerformed

    private void correoCliFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoCliFocusLost
        correoElectronico = validarRegistroF.camposDeRegistros(correoCli, jError12, "c");
    }//GEN-LAST:event_correoCliFocusLost

    private void correoCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoCliKeyReleased
        correoElectronico = validarRegistroF.camposDeRegistros(correoCli, jError12, "c");
    }//GEN-LAST:event_correoCliKeyReleased

    private void jCBJuridicoNatural1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBJuridicoNatural1ActionPerformed
        jTCIDelCliente.setText("");
        String seleccion = (String) jCBJuridicoNatural1.getSelectedItem();
        String seleccionExtranjero = (String) jCBNacionalExtranjero1.getSelectedItem();
        validarCamposJuridico();
        detectorExtranjeroNacional();
        if ("Jurídico".equals(seleccion)) {
            jLCITipoCliente.setText("RUC");
            jCBJuridicoNatural1.setBackground(new Color(255, 255, 255));
        } else if ("Natural".equals(seleccion)) {
            jCBJuridicoNatural1.setBackground(new Color(255, 255, 255));
            if ("Nacional".equals(seleccionExtranjero)) {
                jLCITipoCliente.setText("CI");
                //jTTelefonoCliente.setText("+593-");
            } else if ("Extranjero".equals(seleccionExtranjero)) {
                jLCITipoCliente.setText("Pasaporte");
                //jTTelefonoCliente.setText("+1-");
            }
        }
    }//GEN-LAST:event_jCBJuridicoNatural1ActionPerformed

    private void jDateChooserFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooserFechaMouseClicked
        jDateChooserFecha.setBackground(new Color(255, 204, 204)); // Color blanco
    }//GEN-LAST:event_jDateChooserFechaMouseClicked

    private void jTFNombreNegocioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFNombreNegocioFocusLost
        nombreNegocioValido = validarRegistroF.camposDeRegistros(jTFNombreNegocio, jError1, "d");
    }//GEN-LAST:event_jTFNombreNegocioFocusLost

    private void jTFNombreNegocioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreNegocioKeyReleased
        nombreNegocioValido = validarRegistroF.camposDeRegistros(jTFNombreNegocio, jError1, "d");
    }//GEN-LAST:event_jTFNombreNegocioKeyReleased

    private void jTFNombreNegocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreNegocioKeyTyped
        //        char c = evt.getKeyChar();
        //        if (!Character.isLetterOrDigit(c) && c != KeyEvent.VK_SPACE) {
            //            evt.consume(); // Evita que el carácter no válido se muestre en el campo de texto
            //        }
    }//GEN-LAST:event_jTFNombreNegocioKeyTyped

    private void jTFRUCNegocioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFRUCNegocioFocusLost
        rucV = validarRegistroF.camposDeRegistros(jTFRUCNegocio, jError2, "b");
    }//GEN-LAST:event_jTFRUCNegocioFocusLost

    private void jTFRUCNegocioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFRUCNegocioKeyReleased
        rucV = validarRegistroF.camposDeRegistros(jTFRUCNegocio, jError2, "b");
        String filtro = jTFRUCNegocio.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaNegocios(cnx, filtro); // Llamas al método para obtener el modelo actualizado
        jTablaRegistrarFactura.setModel(modelo);
    }//GEN-LAST:event_jTFRUCNegocioKeyReleased

    private void jTFRUCNegocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFRUCNegocioKeyTyped
        char variable = evt.getKeyChar();
        if (Character.isLetter(variable)) {
            getToolkit().beep();
            evt.consume();
            jTFRUCNegocio.requestFocus();
            JOptionPane.showMessageDialog(null, "Ingrese solo números");
        }
    }//GEN-LAST:event_jTFRUCNegocioKeyTyped

    private void jTFDirNegocioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFDirNegocioFocusLost
        dirNeg = validarRegistroF.camposDeRegistros(jTFDirNegocio, jError3, "d");
    }//GEN-LAST:event_jTFDirNegocioFocusLost

    private void jTFDirNegocioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDirNegocioKeyReleased
        dirNeg = validarRegistroF.camposDeRegistros(jTFDirNegocio, jError3, "d");
    }//GEN-LAST:event_jTFDirNegocioKeyReleased

    private void jTFTelefonoNegocioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFTelefonoNegocioFocusGained
        if (jTFTelefonoNegocio.getText().equals("Ejm: 02-1234567")) {
            jTFTelefonoNegocio.setText("");
            jTFTelefonoNegocio.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTFTelefonoNegocioFocusGained

    private void jTFTelefonoNegocioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFTelefonoNegocioFocusLost
        telefonoNeg = validarRegistroF.camposDeRegistros(jTFTelefonoNegocio, jError4, "t");
    }//GEN-LAST:event_jTFTelefonoNegocioFocusLost

    private void jTFTelefonoNegocioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoNegocioKeyReleased
        telefonoNeg = validarRegistroF.camposDeRegistros(jTFTelefonoNegocio, jError4, "t");
    }//GEN-LAST:event_jTFTelefonoNegocioKeyReleased

    private void idItemFacturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idItemFacturaKeyReleased
        String valor = idItemFactura.getText();
        String campo = "idItem";
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaItemsID(cnx, valor, campo, "idItem", "item", "idItem");
        jTablaRegistrarFactura.setModel(modelo);
    }//GEN-LAST:event_idItemFacturaKeyReleased

    private void idItemFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idItemFacturaKeyTyped
        char variable = evt.getKeyChar();
        if (Character.isLetter(variable)) {
            getToolkit().beep();
            evt.consume();
            idItemFactura.requestFocus();
            JOptionPane.showMessageDialog(null, "Ingrese solo números");
        }
    }//GEN-LAST:event_idItemFacturaKeyTyped

    private void jTextField25KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField25KeyTyped
        char variable = evt.getKeyChar();
        if (Character.isLetter(variable)) {
            getToolkit().beep();
            evt.consume();
            jTextField25.requestFocus();
            JOptionPane.showMessageDialog(null, "Ingrese solo números");
        }
    }//GEN-LAST:event_jTextField25KeyTyped

    private void jBAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarProductoActionPerformed
        if (idItemFactura.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese el identificador de un ítem para agregar el producto"
                + "\na los detalles de la factura");
            return;
        }

        if (jTextField25.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad que quiera agregar");
            return;
        }

        try {

            int idItem = Integer.parseInt(idItemFactura.getText());
            int cantidad = Integer.parseInt(jTextField25.getText());
            int idFactura = Integer.parseInt(jTFnumerofactura.getText());
            // Verificar stock y realizar la inserción en detalle_factura si es posible
            String selectStockQuery = "SELECT stock, precio FROM item WHERE idItem = ?";
            PreparedStatement selectStockStatement = cnx.prepareStatement(selectStockQuery);
            selectStockStatement.setInt(1, idItem);
            ResultSet stockResult = selectStockStatement.executeQuery();
            if (stockResult.next()) {
                int stockDisponible = stockResult.getInt("stock");
                double precioUnitario = stockResult.getDouble("precio");
                if (stockDisponible >= cantidad) {
                    // Calcular subtotal
                    double subtotal = cantidad * precioUnitario;
                    // Insertar en detalle_factura
                    RegistrarDatosFactura.insertarDetalleFactura(cnx, idFactura, idItem,
                        cantidad, precioUnitario, subtotal);
                    // Insertar en actualizarStock
                    RegistrarDatosFactura.actualizarStockYMostrarMensaje(cnx, idItem, cantidad);
                    RegistrarDatosFactura.PreciosTotales precios = RegistrarDatosFactura.obtenerPreciosTotales(cnx, idFactura);
                    jTextField5.setText(String.valueOf(precios.getPrecioTotalConIVADisplay())); // Precio Total con IVA
                    jTFSubtotal.setText(String.valueOf(precios.getPrecioTotalSinIVADisplay())); // Precio Total sin IVA
                    actualizarTablaComprasClienteID(idFactura);
                    idItemFactura.setText("");
                    nombreProducto.setText("");
                    jTextField25.setText("");
                } else {
                    String mensaje = "Stock insuficiente"
                    + "\nStock Diponible: " + stockDisponible;
                    String titulo = "Error de Stock";
                    JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El producto no existe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al agregar el producto");
        }
    }//GEN-LAST:event_jBAgregarProductoActionPerformed

    private void jBQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitarProductoActionPerformed
        if (idItemFactura.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese el identificador de un ítem "
                + "\nque deseas quitar de los detalles de la factua");
            return;
        }
        try {
            int idItem = Integer.parseInt(idItemFactura.getText());
            int idFactura = Integer.parseInt(jTFnumerofactura.getText());
            // Verificar si el producto está en detalle_factura y revertir cambios si es necesario
            String selectDetalleQuery = "SELECT idDetalle, cantidad FROM detalle_factura WHERE idItem = ? AND idFactura = ?";
            PreparedStatement selectDetalleStatement = cnx.prepareStatement(selectDetalleQuery);
            selectDetalleStatement.setInt(1, idItem);
            selectDetalleStatement.setInt(2, idFactura); // Aquí debes obtener el idFactura correspondiente
            ResultSet detalleResult = selectDetalleStatement.executeQuery();

            if (detalleResult.next()) {
                int idDetalle = detalleResult.getInt("idDetalle");
                int cantidadAgregada = detalleResult.getInt("cantidad");

                // Eliminar registro de detalle_factura
                RegistrarDatosFactura.quitarDetalleFactura(cnx, idDetalle);
                // Actualizar stock en la tabla item
                RegistrarDatosFactura.actualizarStock(cnx, idItem, cantidadAgregada);
                JOptionPane.showMessageDialog(this, "Producto quitado con éxito");
                RegistrarDatosFactura.PreciosTotales precios = RegistrarDatosFactura.obtenerPreciosTotales(cnx, idFactura);
                jTextField5.setText(String.valueOf(precios.getPrecioTotalConIVADisplay())); // Precio Total con IVA
                jTFSubtotal.setText(String.valueOf(precios.getPrecioTotalSinIVADisplay())); // Precio Total sin IVA
                actualizarTablaComprasClienteID(idFactura);

            } else {
                JOptionPane.showMessageDialog(this, "El producto no está en la factura");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al quitar el producto");
        }
    }//GEN-LAST:event_jBQuitarProductoActionPerformed

    private void nombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProductoKeyReleased
        String valor = nombreProducto.getText();
        String campo = "nombreItem";
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaItemsID(cnx, valor, campo, "idItem", "item", "idItem");
        jTablaRegistrarFactura.setModel(modelo);
    }//GEN-LAST:event_nombreProductoKeyReleased

    private void jBGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGenerarFacturaActionPerformed
        int numeroFactura = Integer.parseInt(jTFnumerofactura.getText());
        String estadoPago = (String) jCBEstadoPago.getSelectedItem();
        if (!ConsultarBD.existenRegistrosProductos(cnx, Integer.parseInt(jTFnumerofactura.getText()))) {
            JOptionPane.showMessageDialog(null, "No hay registros de productos para registrar la factura.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String rucNegocio = jTFRUCNegocio.getText(), nombreNegocio = jTFNombreNegocio.getText(), direccionNegocio = jTFDirNegocio.getText();
        String telefonoNegocio = jTFTelefonoNegocio.getText();
        // Datos del cliente
        String idCliente = jTCIDelCliente.getText(), nombresCliente = jTNombreCliente.getText(), apellidosCliente = jTFApeliidosCliente.getText(), telefonoCliente = jTTelefonoCliente.getText(),
        direccionCliente = jTDireccionCliente.getText(), correoCliente = correoCli.getText();
        // Datos de la factura
        int idFactura = Integer.parseInt(jTFnumerofactura.getText());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaEmision = dateFormat.format(jDateChooserFecha.getDate());
        double porcentajeIVA = Double.parseDouble(IVAText.getText());

        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modeloFactura = creadorTablas.mostrarItemsID(cnx, idFactura);
        String ducumento = jLCITipoCliente.getText();
        double precioTotalSinIVA = Double.parseDouble(jTFSubtotal.getText());
        double precioTotalConIVA = Double.parseDouble(jTextField5.getText());
        JFFactura facturaFrame = new JFFactura(precioTotalSinIVA, precioTotalConIVA, rucNegocio, nombreNegocio,
            direccionNegocio, telefonoNegocio, idCliente, nombresCliente, apellidosCliente, telefonoCliente,
            direccionCliente, fechaEmision, estadoPago, porcentajeIVA, idFactura, cnx, correoCliente, ducumento
        );

        if (estadoPago.equals("Seleccione")) {
            jError5.setVisible(true);
            JOptionPane.showMessageDialog(null, "Selecciona el estado de pago");
        } else {
            jError5.setVisible(false);
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea limpiar los campos y generar la factura?",
                "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                RegistrarDatosFactura.actualizarEstadoFactura(cnx, numeroFactura, estadoPago);
                facturaFrame.actualizarTablaFactura(modeloFactura);
                facturaFrame.setVisible(true);
                limpiarYCambiarCampos();
                cambiarSesion = true;
                //int nuevoNumeroFactura = RegistrarDatosFactura.obtenerNuevoNumeroFactura(cnx);
                //jTFnumerofactura.setText(String.valueOf(nuevoNumeroFactura));
            }
        }
    }//GEN-LAST:event_jBGenerarFacturaActionPerformed

    private void jTablaRegistrarFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaRegistrarFacturaMouseClicked

        int filaSeleccionada = jTablaRegistrarFactura.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel model = (DefaultTableModel) jTablaRegistrarFactura.getModel();
            boolean foundColumn = false;

            // Recorre todas las columnas del modelo
            for (int i = 0; i < model.getColumnCount(); i++) {
                String columnName = model.getColumnName(i);

                if (columnName.equals("ruc_negocio") || columnName.equals("nombreNegocio") || columnName.equals("direccionNegocio") || columnName.equals("telefonoNegocio")) {
                    String rucNegocio = getValueAtSelectedRow(model, filaSeleccionada, "ruc_negocio");
                    String nombreNegocio = getValueAtSelectedRow(model, filaSeleccionada, "nombreNegocio");
                    String direccionNegocio = getValueAtSelectedRow(model, filaSeleccionada, "direccionNegocio");
                    String telefonoDelNegocio = getValueAtSelectedRow(model, filaSeleccionada, "telefonoNegocio");
                    fillBusinessFields(rucNegocio, nombreNegocio, direccionNegocio, telefonoDelNegocio);
                    JTextField[] campos1 = {jTFNombreNegocio, jTFRUCNegocio, jTFDirNegocio, jTFTelefonoNegocio};
                    Boolean[] boleanosNeg = {nombreNegocioValido, rucV, dirNeg,
                        telefonoNeg};
                    JLabel[] labels1 = {jError1, jError2, jError3, jError4};
                    jTFTelefonoNegocio.setForeground(Color.BLACK);

                    boleanosNeg = validadorCheck.cambiarValoresVerdadFinal(boleanosNeg);
                    nombreNegocioValido = boleanosNeg[0];
                    rucV = boleanosNeg[1];
                    dirNeg = boleanosNeg[2];
                    telefonoNeg = boleanosNeg[3];
                    validadorCheck.validarCampos(campos1, boleanosNeg, labels1);
                    validadorCheck.validarCamposVacios(campos1, boleanosNeg, labels1);
                    foundColumn = true;
                    break; // Sale del bucle una vez que se haya encontrado una columna válida
                }
                if (columnName.equals("ID Cliente")
                    || columnName.equals("Nombres") || columnName.equals("Apellidos")
                    || columnName.equals("Teléfono movíl")
                    || columnName.equals("Dirección") || columnName.equals("Nacionalidad")
                    || columnName.equals("Tipo") || columnName.equals("Correo electronico")) {
                    String idCliente = getValueAtSelectedRow(model, filaSeleccionada, "ID Cliente");
                    String nombreCliente = getValueAtSelectedRow(model, filaSeleccionada, "Nombres");
                    String apellido = getValueAtSelectedRow(model, filaSeleccionada, "Apellidos");
                    String telefonoCliente = getValueAtSelectedRow(model, filaSeleccionada, "Teléfono movíl");
                    String direccionCliente = getValueAtSelectedRow(model, filaSeleccionada, "Dirección");
                    String esExtranjero = getValueAtSelectedRow(model, filaSeleccionada, "Nacionalidad");
                    String tipo = getValueAtSelectedRow(model, filaSeleccionada, "Tipo");
                    String correoCliente = getValueAtSelectedRow(model, filaSeleccionada, "Correo electronico");
                    JTextField[] campos = {jTCIDelCliente, jTNombreCliente, jTFApeliidosCliente, jTTelefonoCliente,
                        jTDireccionCliente, correoCli};
                    JLabel[] labels = {jError7, jError8, jError9, jError10, jError11, jError12};
                    Boolean[] boleanosCli = {rucCliente, nombreCFactura,
                        apellidoCFactura, telfCliente, dirCliente, correoElectronico};
                    fillClientFields(idCliente, nombreCliente, apellido, telefonoCliente, direccionCliente, esExtranjero, tipo, correoCliente);
                    boleanosCli = validadorCheck.cambiarValoresVerdadFinal(boleanosCli);
                    rucCliente = boleanosCli[0];
                    nombreCFactura = boleanosCli[1];
                    apellidoCFactura = boleanosCli[2];
                    telfCliente = boleanosCli[3];
                    dirCliente = boleanosCli[4];
                    correoElectronico = boleanosCli[5];
                    validadorCheck.validarCampos(campos, boleanosCli, labels);
                    validadorCheck.validarCamposVacios(campos, boleanosCli, labels);
                    // Marca que se ha encontrado una columna válida
                    foundColumn = true;
                    break; // Sale del bucle una vez que se haya encontrado una columna válida
                }
                //ID ítem", "Nombre ítem", "Stock", "Precio
                if (columnName.equals("ID ítem") || columnName.equals("Nombre ítem")
                    || columnName.equals("Stock") || columnName.equals("Precio")) {
                    String idtems = getValueAtSelectedRow(model, filaSeleccionada, "ID ítem");
                    String nombreproducto = getValueAtSelectedRow(model, filaSeleccionada, "Nombre ítem");
                    fillProducto(idtems, nombreproducto);

                    foundColumn = true;
                    break; // Sale del bucle una vez que se haya encontrado una columna válida
                }

            }
            if (!foundColumn) {
                // Si no se encontró una columna con los nombres específicos,
                // puedes manejarlo de acuerdo a tus necesidades
                // Por ejemplo, mostrar un mensaje de error o realizar otras acciones
            }
        }

    }//GEN-LAST:event_jTablaRegistrarFacturaMouseClicked

    private void jCBEstadoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEstadoPagoActionPerformed
        String estadoPago = (String) jCBEstadoPago.getSelectedItem();
        if (estadoPago.equals("Seleccione")) {
            jError5.setVisible(true);
            jCBEstadoPago.setBackground(new Color(255, 204, 204));
        } else {
            jCBEstadoPago.setBackground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_jCBEstadoPagoActionPerformed

    private void jBVerGananciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVerGananciasActionPerformed
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaGanancia(cnx);

        // Usar el modelo para llenar jTableFacturas1
        jTableFacturas1.setModel(modelo);
    }//GEN-LAST:event_jBVerGananciasActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
          getToolkit().beep();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        if (cambiarSesion) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro/a que quieres salir de esta ventana", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) { 
                this.dispose();
            }
        } else {
            String mensaje = "Tienes una factura pendiente.";
            String titulo = "¡Aviso Crítico!";
            JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(JFFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFFacturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnularFactura;
    private javax.swing.JButton CambiarEstadoF;
    private javax.swing.JTextField IVAText;
    private javax.swing.JPanel JPFyV;
    private javax.swing.JButton btnExit;
    private javax.swing.JTextField correoCli;
    private javax.swing.JTextField idItemFactura;
    private javax.swing.JButton jBAgregarProducto;
    private javax.swing.JButton jBGenerarFactura;
    private javax.swing.JButton jBQuitarProducto;
    private javax.swing.JButton jBRegistrarFactura;
    private javax.swing.JButton jBVerGanancias;
    private javax.swing.JComboBox<String> jCBEstadoPago;
    private javax.swing.JComboBox<String> jCBJuridicoNatural1;
    private javax.swing.JComboBox<String> jCBNacionalExtranjero1;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jError1;
    private javax.swing.JLabel jError10;
    private javax.swing.JLabel jError11;
    private javax.swing.JLabel jError12;
    private javax.swing.JLabel jError2;
    private javax.swing.JLabel jError3;
    private javax.swing.JLabel jError4;
    private javax.swing.JLabel jError5;
    private javax.swing.JLabel jError6;
    private javax.swing.JLabel jError7;
    private javax.swing.JLabel jError8;
    private javax.swing.JLabel jError9;
    private javax.swing.JTextField jFNumeroFactura2;
    private javax.swing.JTextField jFNumeroFactura3;
    private javax.swing.JLabel jLCITipoCliente;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JPanel jPDatosCliente;
    private javax.swing.JPanel jPDatosFactura;
    private javax.swing.JPanel jPDatosNegocio;
    private javax.swing.JPanel jPProducto;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTCIDelCliente;
    private javax.swing.JTextField jTDireccionCliente;
    private javax.swing.JTextField jTFApeliidosCliente;
    private javax.swing.JTextField jTFDirNegocio;
    private javax.swing.JTextField jTFNombreNegocio;
    private javax.swing.JTextField jTFRUCNegocio;
    private javax.swing.JTextField jTFSubtotal;
    private javax.swing.JTextField jTFTelefonoNegocio;
    private javax.swing.JTextField jTFnumerofactura;
    private javax.swing.JTextField jTNombreCliente;
    private javax.swing.JTextField jTTelefonoCliente;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablaRegistrarFactura;
    private javax.swing.JTable jTableFacturas;
    private javax.swing.JTable jTableFacturas1;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField nombreProducto;
    // End of variables declaration//GEN-END:variables
}
