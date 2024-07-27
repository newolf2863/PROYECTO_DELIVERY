package proyecto_encomienda.GUI;

import proyecto_encomienda.BDYValidaciones.UsuarioManager;
import proyecto_encomienda.BDYValidaciones.ModuloUsuarios;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_encomienda.BDYValidaciones.ConsultarBD;
import proyecto_encomienda.BDYValidaciones.CreadorTablas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import proyecto_encomienda.BDYValidaciones.RegistradoraDeUsuarios;
import proyecto_encomienda.BDYValidaciones.ValidadorCedulas;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import proyecto_encomienda.BDYValidaciones.SessionManager;
import proyecto_encomienda.BDYValidaciones.ValidadorDeSwings;
import proyecto_encomienda.BDYValidaciones.ValidadorDeRegistros;
import proyecto_encomienda.BDYValidaciones.VentanaManager;

/**
 *
 * @author Moises
 */
public class JFMenu extends javax.swing.JFrame {
//Vistas

    private JFInventario inventario = null;
    private JFRemitente remitente = null;
    private JFIncidente incidente = null;
    private JFConductores conductor = null;
    private JFFactura factura1 = null;
    private JFRecepcionista recepcionista = null;

//Clases   
    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();

    //Empleados
    private boolean cedulaEmpleadoValidar = false;
    private boolean nombreEmpleadoValidar = false;
    private boolean apellidoEmpleadoValidar = false;
    private boolean cargoEmpleadoValidar = false;
    private boolean direccionEmpleadoValidar = false;
    private boolean telefonoConvenValidar = false;
    private boolean telefonoEmpleadoValiar = false;
    private boolean correoEmpleadoValidar = false;

    private boolean cargoEmpleadoValidar1 = false;
    private boolean direccionEmpleadoValidar1 = false;
    private boolean telefonoConvenValidar1 = false;
    private boolean telefonoEmpleadoValiar1 = false;
    private boolean correoEmpleadoValidar1 = false;
    //Usuarios
    private boolean claveUsuario = false;
    //Actualizar usuarios
    private boolean claveUsuario2 = false;

//Mouses
    int xMouse, yMouse;

//Conexión y auditoria
    private String usuario;
    private String rol;
    Connection cnx;
    //Paneles   
    private JPanel[] clickedPanels = new JPanel[7];
    CardLayout contenido, contenido1;
    private boolean focusChanged = false;
    private String nombreUsuario;

    public JFMenu(String userRol, Connection cnx, String userName) {
        initComponents();
        setIconImage(new ImageIcon(getClass().
                getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/AjustesBest.png")).getImage());
        this.nombreUsuario = userName;
        this.cnx = cnx;
        this.usuario = userRol;
        setLocationRelativeTo(null);
        String fecha = "dd-MM-yyyy";
        Locale localM = null;
        String resultado;
        Date fechaYHora = new Date();

        resultado = mostrarFechaHora(fechaYHora, fecha, localM);
        //jDateChooserFecha.setText(resultado);
        txtID.setText("Usuario     :" + userRol);
        txtDateLog.setText("Fecha      : " + resultado);
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        contenido = (CardLayout) (panelContent.getLayout());
        contenido.show(panelContent, "card1");
        clickedPanels[0] = Clicked1;
        clickedPanels[1] = Clicked2;
        clickedPanels[2] = Clicked3;
        clickedPanels[3] = Clicked4;
        clickedPanels[4] = Clicked5;
        clickedPanels[5] = Clicked6;
        clickedPanels[6] = Clicked7;
        java.util.Date fechaActual = new java.util.Date();
        // Configura el JDateChooser
        desvanecer();
        //int nuevoNumeroFactura = RegistrarDatosFactura.obtenerNuevoNumeroFactura(cnx);
        //jTFnumerofactura.setText(String.valueOf(nuevoNumeroFactura));
        jTFAdminClave.setToolTipText("Aquí puedes ingresar tu contraseña.");
        jLInicio.setText("Bienvenido/a");
    }

    public void desvanecer() {
        Clicked1.setVisible(true);
        Clicked2.setVisible(false);
        Clicked3.setVisible(false);
        Clicked4.setVisible(false);
        Clicked5.setVisible(false);
        Clicked6.setVisible(false);
        Clicked7.setVisible(false);
    }

    public JFMenu() {
         initComponents();
        setIconImage(new ImageIcon(getClass().
                getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/AjustesBest.png")).getImage());
        //this.nombreUsuario = userName;
        //this.cnx = cnx;
        //this.usuario = userRol;
        setLocationRelativeTo(null);
        String fecha = "dd-MM-yyyy";
        Locale localM = null;
        String resultado;
        Date fechaYHora = new Date();

        resultado = mostrarFechaHora(fechaYHora, fecha, localM);
        //jDateChooserFecha.setText(resultado);
        txtID.setText("Usuario     :" + "Adminsitrador");
        txtDateLog.setText("Fecha      : " + resultado);
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        contenido = (CardLayout) (panelContent.getLayout());
        contenido.show(panelContent, "card1");
        clickedPanels[0] = Clicked1;
        clickedPanels[1] = Clicked2;
        clickedPanels[2] = Clicked3;
        clickedPanels[3] = Clicked4;
        clickedPanels[4] = Clicked5;
        clickedPanels[5] = Clicked6;
        clickedPanels[6] = Clicked7;
        java.util.Date fechaActual = new java.util.Date();
        // Configura el JDateChooser
        desvanecer();
        //int nuevoNumeroFactura = RegistrarDatosFactura.obtenerNuevoNumeroFactura(cnx);
        //jTFnumerofactura.setText(String.valueOf(nuevoNumeroFactura));
        jTFAdminClave.setToolTipText("Aquí puedes ingresar tu contraseña.");
        jLInicio.setText("Bienvenido/a");
    }

    private void cambiarSeccionMenu(int seccionIndex) {
        for (int i = 0; i < clickedPanels.length; i++) {
            clickedPanels[i].setVisible(i == seccionIndex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Home = new javax.swing.JPanel();
        PanelHome = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        menuProveedores = new javax.swing.JLabel();
        menuEmpleados = new javax.swing.JLabel();
        menuClientes = new javax.swing.JLabel();
        menuinventario = new javax.swing.JLabel();
        menuFacturacionYVenta = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        menuLogout = new javax.swing.JLabel();
        menuAdministracion = new javax.swing.JLabel();
        Clicked1 = new javax.swing.JPanel();
        Clicked2 = new javax.swing.JPanel();
        Clicked3 = new javax.swing.JPanel();
        Clicked4 = new javax.swing.JPanel();
        Clicked5 = new javax.swing.JPanel();
        Clicked7 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        menuIncidentes = new javax.swing.JLabel();
        Clicked6 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        panelContent = new javax.swing.JPanel();
        JPGPaquetes = new javax.swing.JPanel();
        jLInicio = new javax.swing.JLabel();
        JPRemitente = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        JPConductores = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        JPFyV = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        JPRecepcionista = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        JPIncidentes = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        JPAdministración = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jTPAdmin = new javax.swing.JTabbedPane();
        jPPR2 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jBRegistarUser = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTablaAdmin = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jTFNombreUser = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jTFIDemploye = new javax.swing.JTextField();
        jCBPreguntaControl = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jTFAdminClave = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jTFAdminRol = new javax.swing.JComboBox<>();
        jLabel77 = new javax.swing.JLabel();
        campoRespuesta = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jPPCE2 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jTFEliminarUser = new javax.swing.JTextField();
        jTCambiarEstadoUsuario = new javax.swing.JButton();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTablaAdmin1 = new javax.swing.JTable();
        jPPA2 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jTablaAdmin2 = new javax.swing.JTable();
        jPanel49 = new javax.swing.JPanel();
        jBIActualizarAct2 = new javax.swing.JButton();
        jPanel50 = new javax.swing.JPanel();
        jTFIBuscadorAct2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jCheckBox14 = new javax.swing.JCheckBox();
        claveUsuariocheck = new javax.swing.JCheckBox();
        ClaveEmpleadoUsuario = new javax.swing.JTextField();
        CIEmpleadoActualizar = new javax.swing.JTextField();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCBseleccionRol = new javax.swing.JComboBox<>();
        jCheckBox15 = new javax.swing.JCheckBox();
        jTFnombreUser = new javax.swing.JTextField();
        jPPC2 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jCBuscarProveedorConsultar2 = new javax.swing.JComboBox<>();
        jTFAdminConsultar = new javax.swing.JTextField();
        jBConsultarInventario3 = new javax.swing.JButton();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTablaAdmin3 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        AdminIVA = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        txtDateLog = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SistemaBestColor");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        Home.setLayout(new java.awt.CardLayout());

        PanelHome.setBackground(new java.awt.Color(245, 245, 245));
        PanelHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69)
                .addContainerGap(1295, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel69)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        PanelHome.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 20));

        jPanel1.setBackground(new java.awt.Color(41, 39, 40));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuProveedores.setBackground(new java.awt.Color(41, 39, 40));
        menuProveedores.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuProveedores.setForeground(new java.awt.Color(255, 255, 255));
        menuProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/camion.png"))); // NOI18N
        menuProveedores.setText("Conductores");
        menuProveedores.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuProveedoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuProveedoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuProveedoresMouseExited(evt);
            }
        });
        jPanel1.add(menuProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 210, 50));

        menuEmpleados.setBackground(new java.awt.Color(41, 39, 40));
        menuEmpleados.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        menuEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/icons8_Monitor_32px.png"))); // NOI18N
        menuEmpleados.setText("Registro de Empleados");
        menuEmpleados.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEmpleadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuEmpleadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuEmpleadosMouseExited(evt);
            }
        });
        jPanel1.add(menuEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 210, 52));

        menuClientes.setBackground(new java.awt.Color(41, 39, 40));
        menuClientes.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuClientes.setForeground(new java.awt.Color(255, 255, 255));
        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/icons8_Home_32px.png"))); // NOI18N
        menuClientes.setText("Remitente");
        menuClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuClientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuClientesMouseExited(evt);
            }
        });
        jPanel1.add(menuClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 210, 52));

        menuinventario.setBackground(new java.awt.Color(41, 39, 40));
        menuinventario.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuinventario.setForeground(new java.awt.Color(255, 255, 255));
        menuinventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/caja.png"))); // NOI18N
        menuinventario.setText("Gestión de Paquetes");
        menuinventario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuinventario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuinventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuinventarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuinventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuinventarioMouseExited(evt);
            }
        });
        jPanel1.add(menuinventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 210, 52));

        menuFacturacionYVenta.setBackground(new java.awt.Color(41, 39, 40));
        menuFacturacionYVenta.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuFacturacionYVenta.setForeground(new java.awt.Color(255, 255, 255));
        menuFacturacionYVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/factura.png"))); // NOI18N
        menuFacturacionYVenta.setText("Facturación y venta");
        menuFacturacionYVenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuFacturacionYVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuFacturacionYVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuFacturacionYVentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuFacturacionYVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuFacturacionYVentaMouseExited(evt);
            }
        });
        jPanel1.add(menuFacturacionYVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 210, 52));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Version 0.1");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 740, -1, -1));

        menuLogout.setBackground(new java.awt.Color(41, 39, 40));
        menuLogout.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuLogout.setForeground(new java.awt.Color(255, 255, 255));
        menuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/icons8_Sign_Out_32px.png"))); // NOI18N
        menuLogout.setText("     Cerrar sesión");
        menuLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuLogoutMouseExited(evt);
            }
        });
        jPanel1.add(menuLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 210, 52));

        menuAdministracion.setBackground(new java.awt.Color(41, 39, 40));
        menuAdministracion.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuAdministracion.setForeground(new java.awt.Color(255, 255, 255));
        menuAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/administracion.png"))); // NOI18N
        menuAdministracion.setText("     Administración");
        menuAdministracion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuAdministracion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuAdministracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAdministracionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuAdministracionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuAdministracionMouseExited(evt);
            }
        });
        jPanel1.add(menuAdministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 210, 52));

        Clicked1.setBackground(new java.awt.Color(178, 8, 55));

        javax.swing.GroupLayout Clicked1Layout = new javax.swing.GroupLayout(Clicked1);
        Clicked1.setLayout(Clicked1Layout);
        Clicked1Layout.setHorizontalGroup(
            Clicked1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Clicked1Layout.setVerticalGroup(
            Clicked1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel1.add(Clicked1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 10, 52));

        Clicked2.setBackground(new java.awt.Color(178, 8, 55));

        javax.swing.GroupLayout Clicked2Layout = new javax.swing.GroupLayout(Clicked2);
        Clicked2.setLayout(Clicked2Layout);
        Clicked2Layout.setHorizontalGroup(
            Clicked2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Clicked2Layout.setVerticalGroup(
            Clicked2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel1.add(Clicked2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 10, 52));

        Clicked3.setBackground(new java.awt.Color(178, 8, 55));

        javax.swing.GroupLayout Clicked3Layout = new javax.swing.GroupLayout(Clicked3);
        Clicked3.setLayout(Clicked3Layout);
        Clicked3Layout.setHorizontalGroup(
            Clicked3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Clicked3Layout.setVerticalGroup(
            Clicked3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel1.add(Clicked3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 10, 52));

        Clicked4.setBackground(new java.awt.Color(178, 8, 55));

        javax.swing.GroupLayout Clicked4Layout = new javax.swing.GroupLayout(Clicked4);
        Clicked4.setLayout(Clicked4Layout);
        Clicked4Layout.setHorizontalGroup(
            Clicked4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Clicked4Layout.setVerticalGroup(
            Clicked4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel1.add(Clicked4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 10, 52));

        Clicked5.setBackground(new java.awt.Color(178, 8, 55));

        javax.swing.GroupLayout Clicked5Layout = new javax.swing.GroupLayout(Clicked5);
        Clicked5.setLayout(Clicked5Layout);
        Clicked5Layout.setHorizontalGroup(
            Clicked5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Clicked5Layout.setVerticalGroup(
            Clicked5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel1.add(Clicked5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 10, 52));

        Clicked7.setBackground(new java.awt.Color(178, 8, 55));

        javax.swing.GroupLayout Clicked7Layout = new javax.swing.GroupLayout(Clicked7);
        Clicked7.setLayout(Clicked7Layout);
        Clicked7Layout.setHorizontalGroup(
            Clicked7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Clicked7Layout.setVerticalGroup(
            Clicked7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel1.add(Clicked7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 10, 52));

        jPanel13.setBackground(new java.awt.Color(146, 10, 48));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/menu.png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setContentAreaFilled(false);
        jPanel13.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 80, 50));

        jLabel1.setBackground(new java.awt.Color(178, 8, 55));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Envios");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel13.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 130, -1));

        jLabel2.setBackground(new java.awt.Color(178, 8, 55));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("2024");
        jPanel13.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 120, -1));

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 220, 60));

        menuIncidentes.setBackground(new java.awt.Color(41, 39, 40));
        menuIncidentes.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuIncidentes.setForeground(new java.awt.Color(255, 255, 255));
        menuIncidentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/exclamacion.png"))); // NOI18N
        menuIncidentes.setText("Incidentes");
        menuIncidentes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuIncidentes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuIncidentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuIncidentesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuIncidentesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuIncidentesMouseExited(evt);
            }
        });
        jPanel1.add(menuIncidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 210, 52));

        Clicked6.setBackground(new java.awt.Color(178, 8, 55));

        javax.swing.GroupLayout Clicked6Layout = new javax.swing.GroupLayout(Clicked6);
        Clicked6.setLayout(Clicked6Layout);
        Clicked6Layout.setHorizontalGroup(
            Clicked6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Clicked6Layout.setVerticalGroup(
            Clicked6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel1.add(Clicked6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 10, 52));

        PanelHome.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 770));

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
        PanelHome.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 20, 35, 35));

        panelContent.setLayout(new java.awt.CardLayout());

        JPGPaquetes.setBackground(new java.awt.Color(245, 245, 245));
        JPGPaquetes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLInicio.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N
        jLInicio.setForeground(new java.awt.Color(102, 102, 102));
        jLInicio.setText("Gestión de Paquetes");
        JPGPaquetes.add(jLInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 620, 250));

        panelContent.add(JPGPaquetes, "card1");

        JPRemitente.setBackground(new java.awt.Color(245, 245, 245));
        JPRemitente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 62)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Remitente");
        JPRemitente.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, -1));

        panelContent.add(JPRemitente, "card2");

        JPConductores.setBackground(new java.awt.Color(245, 245, 245));
        JPConductores.setMinimumSize(new java.awt.Dimension(810, 540));
        JPConductores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Conductores");
        JPConductores.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, -1, -1));

        panelContent.add(JPConductores, "card3");

        JPFyV.setBackground(new java.awt.Color(245, 245, 245));
        JPFyV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Facturación y Venta");
        JPFyV.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        panelContent.add(JPFyV, "card4");

        JPRecepcionista.setBackground(new java.awt.Color(245, 245, 245));
        JPRecepcionista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Recepcionista");
        JPRecepcionista.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, -1));

        panelContent.add(JPRecepcionista, "card5");

        JPIncidentes.setBackground(new java.awt.Color(245, 245, 245));
        JPIncidentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(102, 102, 102));
        jLabel117.setText("Incidentes");
        JPIncidentes.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        panelContent.add(JPIncidentes, "card6");

        JPAdministración.setBackground(new java.awt.Color(245, 245, 245));
        JPAdministración.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Administración");
        JPAdministración.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTPAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPAdminMouseClicked(evt);
            }
        });

        jBRegistarUser.setText("Registrar Usuario");
        jBRegistarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistarUserActionPerformed(evt);
            }
        });

        jTablaAdmin.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane20.setViewportView(jTablaAdmin);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Usuario"));

        jTFNombreUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFNombreUserFocusLost(evt);
            }
        });
        jTFNombreUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreUserActionPerformed(evt);
            }
        });
        jTFNombreUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFNombreUserKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreUserKeyTyped(evt);
            }
        });

        jLabel76.setText("Nombre del usuario");

        jLabel74.setText("CI del Empleado");

        jTFIDemploye.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFIDemployeFocusLost(evt);
            }
        });
        jTFIDemploye.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFIDemployeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFIDemployeKeyTyped(evt);
            }
        });

        jCBPreguntaControl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "¿Cuál es el nombre de tu primera mascota?", "¿En qué ciudad naciste?", "¿Cuál fue tu primer trabajo?", "¿Cuál es tu película favorita?", "¿Cuál es tu comida favorita?", "¿Cuál es tu equipo deportivo favorito?", "¿Cuál es el nombre de tu mejor amigo/a de la infancia?", "¿Cuál es el nombre de tu profesor/a favorito/a?", "¿Cuál es tu canción favorita?" }));
        jCBPreguntaControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPreguntaControlActionPerformed(evt);
            }
        });

        jLabel50.setText("Pregunta Control");

        jTFAdminClave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFAdminClaveFocusLost(evt);
            }
        });
        jTFAdminClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFAdminClaveKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFAdminClaveKeyTyped(evt);
            }
        });

        jLabel75.setText("Clave");

        jTFAdminRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Administrador", "Vendedor" }));
        jTFAdminRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAdminRolActionPerformed(evt);
            }
        });

        jLabel77.setText("Rol");

        campoRespuesta.setEnabled(false);

        jLabel51.setText("Respuesta control");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(campoRespuesta, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCBPreguntaControl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel50)
                    .addComponent(jLabel51)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel75)
                            .addComponent(jTFNombreUser)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel76)
                                .addGap(107, 107, 107))
                            .addComponent(jTFAdminClave))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel74)
                            .addComponent(jTFIDemploye, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77)
                            .addComponent(jTFAdminRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel74)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFIDemploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel76)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFNombreUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel75)
                        .addGap(18, 18, 18)
                        .addComponent(jTFAdminClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addGap(18, 18, 18)
                        .addComponent(jTFAdminRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBPreguntaControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jBRegistarUser)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBRegistarUser)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout jPPR2Layout = new javax.swing.GroupLayout(jPPR2);
        jPPR2.setLayout(jPPR2Layout);
        jPPR2Layout.setHorizontalGroup(
            jPPR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPR2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPPR2Layout.setVerticalGroup(
            jPPR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPR2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPAdmin.addTab("Registrar", jPPR2);

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambiar Estado del Usuario"));

        jLabel58.setText("Nombre del usuario");

        jTFEliminarUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFEliminarUserKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFEliminarUserKeyTyped(evt);
            }
        });

        jTCambiarEstadoUsuario.setText("Cambiar de estado");
        jTCambiarEstadoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCambiarEstadoUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel58)
                        .addGap(25, 25, 25)
                        .addComponent(jTFEliminarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jTCambiarEstadoUsuario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFEliminarUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addGap(18, 18, 18)
                .addComponent(jTCambiarEstadoUsuario)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTablaAdmin1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane21.setViewportView(jTablaAdmin1);

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPPCE2Layout = new javax.swing.GroupLayout(jPPCE2);
        jPPCE2.setLayout(jPPCE2Layout);
        jPPCE2Layout.setHorizontalGroup(
            jPPCE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPCE2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );
        jPPCE2Layout.setVerticalGroup(
            jPPCE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPCE2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jTPAdmin.addTab("Cambiar de estado al usuario", jPPCE2);

        jPPA2.setPreferredSize(new java.awt.Dimension(790, 459));

        jTablaAdmin2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablaAdmin2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaAdmin2MouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(jTablaAdmin2);

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder("Actualizar Usuario"));
        jPanel49.setToolTipText("");
        jPanel49.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jBIActualizarAct2.setText("Actualizar");
        jBIActualizarAct2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIActualizarAct2ActionPerformed(evt);
            }
        });

        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elegir usuario por:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        jTFIBuscadorAct2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFIBuscadorAct2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFIBuscadorAct2KeyTyped(evt);
            }
        });

        jLabel19.setText("Nombre del usuario");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jTFIBuscadorAct2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFIBuscadorAct2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jCheckBox14.setSelected(true);
        jCheckBox14.setText("CI del Empleado");
        jCheckBox14.setEnabled(false);

        claveUsuariocheck.setText("Clave");
        claveUsuariocheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claveUsuariocheckActionPerformed(evt);
            }
        });

        ClaveEmpleadoUsuario.setEnabled(false);
        ClaveEmpleadoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ClaveEmpleadoUsuarioKeyReleased(evt);
            }
        });

        CIEmpleadoActualizar.setEnabled(false);

        jCheckBox16.setText("Rol");
        jCheckBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox16ActionPerformed(evt);
            }
        });

        jCBseleccionRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Administrador", "Vendedor" }));
        jCBseleccionRol.setEnabled(false);

        jCheckBox15.setSelected(true);
        jCheckBox15.setText("Nombre de usuario");
        jCheckBox15.setEnabled(false);

        jTFnombreUser.setEnabled(false);

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel49Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jBIActualizarAct2))))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel49Layout.createSequentialGroup()
                                .addComponent(jCheckBox15)
                                .addGap(18, 18, 18)
                                .addComponent(jTFnombreUser, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel49Layout.createSequentialGroup()
                                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox14)
                                    .addComponent(claveUsuariocheck)
                                    .addComponent(jCheckBox16, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CIEmpleadoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jCBseleccionRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ClaveEmpleadoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CIEmpleadoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFnombreUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClaveEmpleadoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(claveUsuariocheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox16)
                    .addComponent(jCBseleccionRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBIActualizarAct2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPPA2Layout = new javax.swing.GroupLayout(jPPA2);
        jPPA2.setLayout(jPPA2Layout);
        jPPA2Layout.setHorizontalGroup(
            jPPA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPA2Layout.createSequentialGroup()
                .addGroup(jPPA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPA2Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPPA2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPPA2Layout.setVerticalGroup(
            jPPA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPA2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTPAdmin.addTab("Actualizar", jPPA2);

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar Usuario"));

        jCBuscarProveedorConsultar2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Nombre de usuario", "CI", "Rol" }));
        jCBuscarProveedorConsultar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBuscarProveedorConsultar2ActionPerformed(evt);
            }
        });

        jTFAdminConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFAdminConsultarKeyTyped(evt);
            }
        });

        jBConsultarInventario3.setText("Consultar");
        jBConsultarInventario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarInventario3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBuscarProveedorConsultar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFAdminConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jBConsultarInventario3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jCBuscarProveedorConsultar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFAdminConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBConsultarInventario3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTablaAdmin3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane23.setViewportView(jTablaAdmin3);

        javax.swing.GroupLayout jPPC2Layout = new javax.swing.GroupLayout(jPPC2);
        jPPC2.setLayout(jPPC2Layout);
        jPPC2Layout.setHorizontalGroup(
            jPPC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPC2Layout.createSequentialGroup()
                .addGroup(jPPC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPC2Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPPC2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(303, Short.MAX_VALUE))
        );
        jPPC2Layout.setVerticalGroup(
            jPPC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPC2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );

        jTPAdmin.addTab("Consultar", jPPC2);

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder("IVA"));

        AdminIVA.setText("12");
        AdminIVA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AdminIVAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AdminIVAKeyTyped(evt);
            }
        });

        jLabel55.setText("IVA");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(AdminIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(AdminIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(486, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(384, Short.MAX_VALUE))
        );

        jTPAdmin.addTab("Parámetros", jPanel8);

        JPAdministración.add(jTPAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 970, 630));

        panelContent.add(JPAdministración, "card7");

        PanelHome.add(panelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 1180, 690));

        txtID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtID.setForeground(new java.awt.Color(51, 51, 51));
        txtID.setText("Logged  :");
        PanelHome.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 290, -1));

        txtDateLog.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDateLog.setForeground(new java.awt.Color(51, 51, 51));
        txtDateLog.setText("Date      :");
        PanelHome.add(txtDateLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 310, -1));

        Home.add(PanelHome, "home");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        getToolkit().beep();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro de cerrar la aplicacion?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void menuinventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuinventarioMouseEntered
        menuinventario.setBackground(Color.decode("#333333"));
    }//GEN-LAST:event_menuinventarioMouseEntered

    private void menuinventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuinventarioMouseExited
        menuinventario.setBackground(Color.decode("#292728"));
        menuinventario.setOpaque(true);
    }//GEN-LAST:event_menuinventarioMouseExited

    private void menuinventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuinventarioMouseClicked
        contenido.show(panelContent, "card1");
        cambiarSeccionMenu(0);
        menuinventario.setBackground(Color.decode("#494848"));
        JFrame ventanaInventario = new JFInventario(cnx);
        VentanaManager.getInstance().mostrarVentana("inventario", ventanaInventario);
        jLInicio.setText("Paquetes");
    }//GEN-LAST:event_menuinventarioMouseClicked


    private void menuProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProveedoresMouseClicked
        contenido.show(panelContent, "card3");
        cambiarSeccionMenu(2);
        menuProveedores.setBackground(Color.decode("#494848"));
        JFrame ventanaConductor = new JFConductores(cnx);
        VentanaManager.getInstance().mostrarVentana("conductor", ventanaConductor);
    }//GEN-LAST:event_menuProveedoresMouseClicked

    private void menuProveedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProveedoresMouseEntered
        menuProveedores.setBackground(Color.decode("#333333"));
        menuProveedores.setOpaque(true);
    }//GEN-LAST:event_menuProveedoresMouseEntered

    private void menuProveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProveedoresMouseExited
        menuProveedores.setBackground(Color.decode("#292728"));
        menuProveedores.setOpaque(true);
    }//GEN-LAST:event_menuProveedoresMouseExited

    private void menuEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEmpleadosMouseClicked
        contenido.show(panelContent, "card5");
        cambiarSeccionMenu(4);
        menuEmpleados.setBackground(Color.decode("#494848"));
        JFrame ventanaRecepcionista = new JFRecepcionista(cnx);
        VentanaManager.getInstance().mostrarVentana("recepcionista", ventanaRecepcionista);
    }//GEN-LAST:event_menuEmpleadosMouseClicked

    private void menuEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEmpleadosMouseEntered
        menuEmpleados.setBackground(Color.decode("#333333"));
        menuEmpleados.setOpaque(true);
    }//GEN-LAST:event_menuEmpleadosMouseEntered

    private void menuEmpleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEmpleadosMouseExited
        menuEmpleados.setBackground(Color.decode("#292728"));
        menuEmpleados.setOpaque(true);
    }//GEN-LAST:event_menuEmpleadosMouseExited

    private void menuClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuClientesMouseClicked
        contenido.show(panelContent, "card2");
        cambiarSeccionMenu(1);
        menuClientes.setBackground(Color.decode("#494848"));
        JFrame remintente = new JFRemitente(cnx);
        VentanaManager.getInstance().mostrarVentana("remintente", remintente);
    }//GEN-LAST:event_menuClientesMouseClicked

    private void menuClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuClientesMouseEntered
        menuClientes.setBackground(Color.decode("#333333"));
        menuClientes.setOpaque(true);
    }//GEN-LAST:event_menuClientesMouseEntered

    private void menuClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuClientesMouseExited
        menuClientes.setBackground(Color.decode("#292728"));
        menuClientes.setOpaque(true);
    }//GEN-LAST:event_menuClientesMouseExited

    private void menuFacturacionYVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFacturacionYVentaMouseClicked
        contenido.show(panelContent, "card4");
        cambiarSeccionMenu(3);
        menuFacturacionYVenta.setBackground(Color.decode("#494848"));
        JFrame ventantaFactura = new JFFacturacion(cnx);
        VentanaManager.getInstance().mostrarVentana("factura1", ventantaFactura);
    }//GEN-LAST:event_menuFacturacionYVentaMouseClicked

    private void menuFacturacionYVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFacturacionYVentaMouseEntered
        menuFacturacionYVenta.setBackground(Color.decode("#333333"));
        menuFacturacionYVenta.setOpaque(true);
    }//GEN-LAST:event_menuFacturacionYVentaMouseEntered

    private void menuFacturacionYVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFacturacionYVentaMouseExited
        menuFacturacionYVenta.setBackground(Color.decode("#292728"));
        menuFacturacionYVenta.setOpaque(true);
    }//GEN-LAST:event_menuFacturacionYVentaMouseExited

    private void menuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseClicked
        getToolkit().beep();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        if (SessionManager.getInstance().isCambiarSesion()) {  // Accede a cambiarSesion a través del Singleton
            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Estás seguro/a que quieres salir de esta cuenta?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                // Crea una instancia del JFIngresar
                JFIngresar ingresarFrame = new JFIngresar();
                ingresarFrame.setVisible(true); // Muestra el JFIngresar

                // Cierra todas las ventanas abiertas, excepto la nueva ventana ingresarFrame
                Window[] windows = Window.getWindows(); // Obtiene todas las ventanas abiertas
                for (Window window : windows) {
                    if (window != ingresarFrame) { // Cierra todas las ventanas menos la nueva
                        window.dispose();
                    }
                }
                dispose();  // Cierra el JFrame actual si es necesario (es opcional si ya has cerrado todas las demás ventanas)
            }
        } else {
            String mensaje = "Tienes una factura pendiente.";
            String titulo = "¡Aviso Crítico!";
            JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuLogoutMouseClicked

    private void menuLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseEntered
        menuLogout.setBackground(Color.decode("#333333"));
        menuLogout.setOpaque(true);
    }//GEN-LAST:event_menuLogoutMouseEntered

    private void menuLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseExited
        menuLogout.setBackground(Color.decode("#292728"));
        menuLogout.setOpaque(true);
    }//GEN-LAST:event_menuLogoutMouseExited


    private void menuAdministracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAdministracionMouseClicked
        contenido.show(panelContent, "card7");
        cambiarSeccionMenu(6);
        menuAdministracion.setBackground(Color.decode("#494848"));
    }//GEN-LAST:event_menuAdministracionMouseClicked

    private void menuAdministracionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAdministracionMouseEntered
        menuAdministracion.setBackground(Color.decode("#333333"));
        menuAdministracion.setOpaque(true);
    }//GEN-LAST:event_menuAdministracionMouseEntered

    private void menuAdministracionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAdministracionMouseExited
        menuAdministracion.setBackground(Color.decode("#292728"));
        menuAdministracion.setOpaque(true);
    }//GEN-LAST:event_menuAdministracionMouseExited

    private void jTPAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPAdminMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPAdminMouseClicked

    private void jBConsultarInventario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarInventario3ActionPerformed
        String campo = (String) jCBuscarProveedorConsultar2.getSelectedItem();
        String valor = jTFAdminConsultar.getText();
        if (valor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor");
            return;
        }
        if (campo.equals("Selecciona")) {
            JOptionPane.showMessageDialog(null, "Selecciona un atributo");
            return;
        }

        switch (campo) {
            case "Nombre de usuario" -> {
                campo = "nombreUser";
            }
            case "CI" -> {
                campo = "CI";
            }
            case "Rol" -> {
                campo = "rol";
            }
        }
        DefaultTableModel modelo = ConsultarBD.consultarUser(cnx, campo, valor);
        jTablaAdmin3.setModel(modelo);
    }//GEN-LAST:event_jBConsultarInventario3ActionPerformed

    private void jTFAdminConsultarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFAdminConsultarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFAdminConsultarKeyTyped

    private void jCBuscarProveedorConsultar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBuscarProveedorConsultar2ActionPerformed
        jTFAdminConsultar.setText("");
    }//GEN-LAST:event_jCBuscarProveedorConsultar2ActionPerformed

    private void jTFIBuscadorAct2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscadorAct2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIBuscadorAct2KeyTyped

    private void jTFIBuscadorAct2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscadorAct2KeyReleased
        String usuarioACambiar = jTFIBuscadorAct2.getText();
        ModuloUsuarios usuario = new ModuloUsuarios();

        DefaultTableModel modelo = usuario.consultarUsuario1(cnx, usuarioACambiar);
        jTablaAdmin2.setModel(modelo);
    }//GEN-LAST:event_jTFIBuscadorAct2KeyReleased

    private void jBIActualizarAct2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIActualizarAct2ActionPerformed
        ModuloUsuarios usuarioACtualizar = new ModuloUsuarios();
        String rolActualizar = (String) jCBseleccionRol.getSelectedItem();
        String atributoActualizar = "CI";
        String condicion = "'" + this.CIEmpleadoActualizar.getText() + "'";
        String nombrereal = jTFnombreUser.getText().toLowerCase();

        if (claveUsuariocheck.isSelected()) {
            if (!nombrereal.isEmpty() && !ClaveEmpleadoUsuario.getText().isEmpty() && claveUsuario2) {
                try {
                    String sql = "ALTER USER " + nombrereal + " WITH PASSWORD '" + ClaveEmpleadoUsuario.getText() + "';";
                    PreparedStatement statement = this.cnx.prepareStatement(sql);
                    statement.executeUpdate();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                usuarioACtualizar.addAtributo("passwordU='" + ClaveEmpleadoUsuario.getText() + "'");
            } else {
                JOptionPane.showMessageDialog(null, "Verifique la contraseña", "Error al actualizar datos", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }
        if (jCheckBox16.isSelected()) {
            usuarioACtualizar.addAtributo("rol='" + rolActualizar + "'");
        }
        usuarioACtualizar.actualizarDatos(this.cnx, atributoActualizar, condicion, "usuarios");
        DefaultTableModel modelo = usuarioACtualizar.mostrarTablaUsuario(cnx);
        jTablaAdmin2.setModel(modelo);
    }//GEN-LAST:event_jBIActualizarAct2ActionPerformed

    private void jTablaAdmin2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaAdmin2MouseClicked
        int filaSeleccionada = jTablaAdmin2.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) jTablaAdmin2.getModel();
            String NombreUser = modelo.getValueAt(filaSeleccionada, 0).toString();
            String CI = modelo.getValueAt(filaSeleccionada, 1).toString();
            String clave = modelo.getValueAt(filaSeleccionada, 2).toString();
            String rolUsuarioDB = modelo.getValueAt(filaSeleccionada, 3).toString();
            jTFnombreUser.setText(NombreUser);
            CIEmpleadoActualizar.setText(CI);
            if (claveUsuariocheck.isSelected()) {
                ClaveEmpleadoUsuario.setText(clave);
            }
            if (jCheckBox16.isSelected()) {
                if (rolUsuarioDB.equals("Administrador")) {
                    jCBseleccionRol.setSelectedItem("Administrador");
                } else {
                    if (rolUsuarioDB.equals("Vendedor")) {
                        jCBseleccionRol.setSelectedItem("Vendedor");
                    }
                }
            }
        }
    }//GEN-LAST:event_jTablaAdmin2MouseClicked

    private void jTCambiarEstadoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCambiarEstadoUsuarioActionPerformed
        String userToChange = jTFEliminarUser.getText();
        if (!userToChange.equals(nombreUsuario)) {
        } else {
            JOptionPane.showMessageDialog(null, "No puedes cambiar tu propio estado.");
            return;
        }
        String estadoActual = ModuloUsuarios.obtenerEstadoUsuario(cnx, userToChange);
        int respuesta;
        if ("Activado".equals(estadoActual)) {
            respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas cambiar el estado a 'Bloqueado'?", "Confirmar Cambio de Estado", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                ModuloUsuarios.cambiarEstadoUsuario(cnx, userToChange);
                ModuloUsuarios.consultarUsuario(cnx, userToChange, jTablaAdmin1);
            }
        } else if ("Bloqueado".equals(estadoActual)) {
            respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas cambiar el estado a 'Activado'?", "Confirmar Cambio de Estado", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                ModuloUsuarios.cambiarEstadoUsuario(cnx, userToChange);
                ModuloUsuarios.consultarUsuario(cnx, userToChange, jTablaAdmin1);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Estado desconocido del elemento.");
        }
    }//GEN-LAST:event_jTCambiarEstadoUsuarioActionPerformed


    private void jTFEliminarUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFEliminarUserKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEliminarUserKeyTyped

    private void jTFEliminarUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFEliminarUserKeyReleased
        String usuarioACambiar = jTFEliminarUser.getText();
        ModuloUsuarios.consultarUsuario(cnx, usuarioACambiar, jTablaAdmin1);
    }//GEN-LAST:event_jTFEliminarUserKeyReleased

    private void jTFNombreUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreUserActionPerformed

    public boolean fechaVacia(JDateChooser dateChooser, JLabel label) {
        if (dateChooser.getDate() == null) {
            label.setVisible(true);
            return false;
        } else {
            label.setVisible(false);
            return true;
        }
    }

    private String getValueAtSelectedRow(DefaultTableModel model, int selectedRow, String columnName) {
        int colIndex = model.findColumn(columnName);
        return colIndex != -1 ? model.getValueAt(selectedRow, colIndex).toString() : "";
    }


    private void jBRegistarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistarUserActionPerformed
        String nuevoUsuario = jTFNombreUser.getText();
        String nuevaContrasena = jTFAdminClave.getText();
        String nombreUser = jTFNombreUser.getText();
        String CI = jTFIDemploye.getText();
        String pregunta = jCBPreguntaControl.getSelectedItem().toString();
        String respuesta = campoRespuesta.getText();
        String rolEmp = jTFAdminRol.getSelectedItem().toString();
        if (!claveUsuario) {
            JOptionPane.showMessageDialog(null, "Clave insegura");
            return;
        }
        if (!nuevoUsuario.isEmpty() && !nuevaContrasena.isEmpty() && !CI.isEmpty() && !respuesta.isEmpty()) {
            if (claveUsuario) {
                int respuestaUsuario = JOptionPane.showConfirmDialog(null,
                        "¿Estás seguro de registrar este usuario?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (respuestaUsuario == JOptionPane.YES_OPTION) {
                    // Si el usuario confirma, procedemos a registrar el usuario
                    RegistradoraDeUsuarios registrar = new RegistradoraDeUsuarios();
                    registrar.registrarUsuario(cnx, nombreUser, CI, nuevaContrasena, pregunta, respuesta, rolEmp);
                    UsuarioManager usuarioManager = new UsuarioManager();
                    //RegistradoraDeUsuarios.registrarUsuario(cnx, nombreUser, CI, password, pregunta, respuesta, rolEmp);
                    usuarioManager.crearUsuarioYOtorgarPrivilegios(cnx, nuevoUsuario, nuevaContrasena);
                    // Limpiar los campos después del registro
                    jTFNombreUser.setText("");
                    jTFIDemploye.setText("");
                    jTFAdminClave.setText("");
                    campoRespuesta.setText("");
                } else {
                    // Si el usuario cancela, no hacemos nada
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos obligatosio");
            return;
        }

    }//GEN-LAST:event_jBRegistarUserActionPerformed

    private void jTFAdminRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFAdminRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFAdminRolActionPerformed

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jTFNombreUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreUserKeyTyped
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_BACK_SPACE) {
            evt.consume(); // No permite ingresar el carácter
            //JOptionPane.showMessageDialog(this, "No se permiten espacios.");
        } else if (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
            if (!((Character.isLetter(c) && Character.isLowerCase(c))
                    || (Character.isLetter(c) && Character.isUpperCase(c))
                    || Character.isDigit(c) || c == 'ñ' || c == 'Ñ')) {
                evt.consume(); // No permite ingresar el carácter

                // Mostrar mensaje de advertencia
                JOptionPane.showMessageDialog(this, "Solo se permiten letras y números.");
            }
        }
    }//GEN-LAST:event_jTFNombreUserKeyTyped

    private void AdminIVAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdminIVAKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume(); // Consume el evento, evitando que se ingrese el carácter
        }
    }//GEN-LAST:event_AdminIVAKeyTyped

    private void AdminIVAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdminIVAKeyReleased
        String setIva = AdminIVA.getText();
//To do

//IVAText.setText(setIva);
    }//GEN-LAST:event_AdminIVAKeyReleased

    private void jTFNombreUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreUserKeyReleased
        String nombredelUser = jTFNombreUser.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaUsuarios(cnx, nombredelUser); // Llamar al método con el filtro
        jTablaAdmin.setModel(modelo);
    }//GEN-LAST:event_jTFNombreUserKeyReleased

    private void jTFIDemployeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIDemployeKeyReleased
        String CIEmpleado = jTFIDemploye.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaEmpleados(cnx, CIEmpleado); // Llamar al método con el filtro
        jTablaAdmin.setModel(modelo);
    }//GEN-LAST:event_jTFIDemployeKeyReleased

    private void jTFIDemployeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIDemployeKeyTyped
        char variable = evt.getKeyChar();
        if (Character.isLetter(variable) || Character.isSpaceChar(variable)) {
            evt.consume();
            jTFIDemploye.requestFocus();
            JOptionPane.showMessageDialog(null, "Ingrese solo números");
        }
    }//GEN-LAST:event_jTFIDemployeKeyTyped


    private void jTFAdminClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFAdminClaveKeyTyped

    }//GEN-LAST:event_jTFAdminClaveKeyTyped
    public boolean verificarContra(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return password.matches(regex);
    }
    private void jTFAdminClaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFAdminClaveKeyReleased
        validarClave(jTFAdminClave, "1");
    }//GEN-LAST:event_jTFAdminClaveKeyReleased

    private void ClaveEmpleadoUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ClaveEmpleadoUsuarioKeyReleased
        validarClave(ClaveEmpleadoUsuario, "2");
    }//GEN-LAST:event_ClaveEmpleadoUsuarioKeyReleased

    private void jTFIDemployeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFIDemployeFocusLost
        String idCedulaEmpleado = jTFIDemploye.getText();
        if (!ValidadorCedulas.validarCedula(idCedulaEmpleado)) {
            JOptionPane.showMessageDialog(null, "Cédula no valida");
        }
    }//GEN-LAST:event_jTFIDemployeFocusLost

    private void jTFAdminClaveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFAdminClaveFocusLost
        validarClave(jTFAdminClave, "1");
    }//GEN-LAST:event_jTFAdminClaveFocusLost

    private void jCBPreguntaControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBPreguntaControlActionPerformed
        String seleccion = (String) jCBPreguntaControl.getSelectedItem();
        if (!seleccion.equals("Seleccione una opción")) {
            campoRespuesta.setEnabled(true);
        } else {
            campoRespuesta.setEnabled(false);
        }
    }//GEN-LAST:event_jCBPreguntaControlActionPerformed

    private void jTFNombreUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFNombreUserFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreUserFocusLost

    public Boolean[] cambiarValoresVerdad(Boolean[] valores) {
        for (int i = 0; i < valores.length; i++) {
            valores[i] = true;
        }
        return valores;
    }

    private void claveUsuariocheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claveUsuariocheckActionPerformed
        if (claveUsuariocheck.isSelected()) {
            ClaveEmpleadoUsuario.setEnabled(true);
        } else {
            ClaveEmpleadoUsuario.setEnabled(false);
            claveUsuario2 = true;
            ClaveEmpleadoUsuario.setBackground(Color.white);
            ClaveEmpleadoUsuario.setText("");
        }
    }//GEN-LAST:event_claveUsuariocheckActionPerformed

    private void jCheckBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox16ActionPerformed
        if (jCheckBox16.isSelected()) {
            jCBseleccionRol.setEnabled(true);
        } else {
            jCBseleccionRol.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox16ActionPerformed


    private void menuIncidentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuIncidentesMouseClicked
        contenido.show(panelContent, "card6");
        cambiarSeccionMenu(5);
        menuIncidentes.setBackground(Color.decode("#494848"));
        JFrame ventanaIncidentes = new JFIncidente(cnx);
        VentanaManager.getInstance().mostrarVentana("inventario", ventanaIncidentes);

    }//GEN-LAST:event_menuIncidentesMouseClicked

    private void menuIncidentesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuIncidentesMouseEntered
        menuIncidentes.setBackground(Color.decode("#333333"));
        menuIncidentes.setOpaque(true);
    }//GEN-LAST:event_menuIncidentesMouseEntered

    private void menuIncidentesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuIncidentesMouseExited
        menuIncidentes.setBackground(Color.decode("#292728"));
        menuIncidentes.setOpaque(true);
    }//GEN-LAST:event_menuIncidentesMouseExited

    private void limpiarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Establece el número de filas a cero para vaciar la tabla
    }

    private void validarClave(JTextField textField, String esClaveUsuario) {
        String password = textField.getText();
        String mensaje = verificarContrase(password);
        if (esClaveUsuario.equals("1")) {
            claveUsuario = verificarContra(password);
        } else {
            if (esClaveUsuario.equals("2")) {
                claveUsuario2 = verificarContra(password);
            }
        }
        if (!mensaje.isEmpty()) {
            textField.setToolTipText(mensaje);
            textField.setBackground(new Color(255, 204, 204));
        } else {
            textField.setToolTipText(null);
            textField.setBackground(Color.white);
        }
    }

    private String verificarContrase(String contraseña) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("<html>La contraseña debe cumplir con lo siguiente:<br>");
        boolean cumpleRequisitos = true;
        if (!contraseña.matches(".*[A-Z].*")) {
            mensaje.append("- Debe contener al menos una letra mayúscula.<br>");
            cumpleRequisitos = false;
        }
        if (!contraseña.matches(".*[a-z].*")) {
            mensaje.append("- Debe contener al menos una letra minúscula.<br>");
            cumpleRequisitos = false;
        }
        if (!contraseña.matches(".*\\d.*")) {
            mensaje.append("- Debe contener al menos un dígito.<br>");
            cumpleRequisitos = false;
        }
        if (!contraseña.matches(".*[@#$%^&+=!].*")) {
            mensaje.append("- Debe contener al menos un carácter especial (@, #, $, %, ^, &, +, =, !).<br>");
            cumpleRequisitos = false;
        }
        if (contraseña.length() < 8) {
            mensaje.append("- Debe tener una longitud mínima de 8 caracteres.<br>");
            cumpleRequisitos = false;
        }

        if (cumpleRequisitos) {
            mensaje.setLength(0); // Si cumple todos los requisitos, vacía el mensaje
        } else {
            mensaje.append("</html>");
        }
        return mensaje.toString();
    }

    public void abrirPDFdesdeBD(int idFactura) {
        byte[] pdfBytes = obtenerPDFdesdeBD(idFactura);
        if (pdfBytes != null) {
            try {
                // Crear un archivo temporal único en la carpeta temporal del sistema
                Path tempFilePath = Files.createTempFile("temp_pdf_", ".pdf");

                // Escribir los bytes del PDF en el archivo temporal
                Files.write(tempFilePath, pdfBytes, StandardOpenOption.CREATE);

                // Abre el archivo temporal con una aplicación de visualización de PDF
                Desktop.getDesktop().open(tempFilePath.toFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public byte[] obtenerPDFdesdeBD(int idFactura) {
        try {
            String sql = "SELECT pdf FROM tabla_pdf WHERE idFactura = ?";
            try (PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
                preparedStatement.setInt(1, idFactura);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getBytes("pdf");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String mostrarFechaHora(Date fechaYHora, String formato, Locale local) {
        String fechaString;
        SimpleDateFormat formateador;
        if (local == null) {
            formateador = new SimpleDateFormat(formato);
        } else {
            formateador = new SimpleDateFormat(formato, local);
        }

        fechaString = formateador.format(fechaYHora);
        return fechaString;
    }

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
            java.util.logging.Logger.getLogger(JFMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AdminIVA;
    private javax.swing.JTextField CIEmpleadoActualizar;
    private javax.swing.JTextField ClaveEmpleadoUsuario;
    private javax.swing.JPanel Clicked1;
    private javax.swing.JPanel Clicked2;
    private javax.swing.JPanel Clicked3;
    private javax.swing.JPanel Clicked4;
    private javax.swing.JPanel Clicked5;
    private javax.swing.JPanel Clicked6;
    private javax.swing.JPanel Clicked7;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel JPAdministración;
    private javax.swing.JPanel JPConductores;
    private javax.swing.JPanel JPFyV;
    private javax.swing.JPanel JPGPaquetes;
    private javax.swing.JPanel JPIncidentes;
    private javax.swing.JPanel JPRecepcionista;
    private javax.swing.JPanel JPRemitente;
    private javax.swing.JPanel PanelHome;
    private javax.swing.JButton btnExit;
    private javax.swing.JTextField campoRespuesta;
    private javax.swing.JCheckBox claveUsuariocheck;
    private javax.swing.JButton jBConsultarInventario3;
    private javax.swing.JButton jBIActualizarAct2;
    private javax.swing.JButton jBRegistarUser;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCBPreguntaControl;
    private javax.swing.JComboBox<String> jCBseleccionRol;
    private javax.swing.JComboBox<String> jCBuscarProveedorConsultar2;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JLabel jLInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPPA2;
    private javax.swing.JPanel jPPC2;
    private javax.swing.JPanel jPPCE2;
    private javax.swing.JPanel jPPR2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JButton jTCambiarEstadoUsuario;
    private javax.swing.JTextField jTFAdminClave;
    private javax.swing.JTextField jTFAdminConsultar;
    private javax.swing.JComboBox<String> jTFAdminRol;
    private javax.swing.JTextField jTFEliminarUser;
    private javax.swing.JTextField jTFIBuscadorAct2;
    private javax.swing.JTextField jTFIDemploye;
    private javax.swing.JTextField jTFNombreUser;
    private javax.swing.JTextField jTFnombreUser;
    private javax.swing.JTabbedPane jTPAdmin;
    private javax.swing.JTable jTablaAdmin;
    private javax.swing.JTable jTablaAdmin1;
    private javax.swing.JTable jTablaAdmin2;
    private javax.swing.JTable jTablaAdmin3;
    private javax.swing.JLabel menuAdministracion;
    private javax.swing.JLabel menuClientes;
    private javax.swing.JLabel menuEmpleados;
    private javax.swing.JLabel menuFacturacionYVenta;
    private javax.swing.JLabel menuIncidentes;
    private javax.swing.JLabel menuLogout;
    private javax.swing.JLabel menuProveedores;
    private javax.swing.JLabel menuinventario;
    private javax.swing.JPanel panelContent;
    private javax.swing.JLabel txtDateLog;
    private javax.swing.JLabel txtID;
    // End of variables declaration//GEN-END:variables

}
