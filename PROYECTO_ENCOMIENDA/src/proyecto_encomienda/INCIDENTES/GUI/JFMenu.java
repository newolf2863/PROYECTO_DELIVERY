package proyecto_encomienda.INCIDENTES.GUI;

import proyecto_ecomienda.BDYValidaciones.UsuarioManager;
import proyecto_ecomienda.BDYValidaciones.ModuloUsuarios;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
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
import proyecto_ecomienda.BDYValidaciones.ActualizarInventario;
import proyecto_ecomienda.BDYValidaciones.ConsultarBD;
import proyecto_ecomienda.BDYValidaciones.CreadorTablas;
import proyecto_ecomienda.BDYValidaciones.IngresadorDeDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_ecomienda.BDYValidaciones.ActualizarEstadoFactura;
import proyecto_ecomienda.BDYValidaciones.EmailValidator;
import proyecto_ecomienda.BDYValidaciones.Empleados;
import proyecto_ecomienda.BDYValidaciones.RegistrarDatosFactura;
import proyecto_ecomienda.BDYValidaciones.Verificadora;
import proyecto_ecomienda.BDYValidaciones.RegistradoraDeUsuarios;
import proyecto_ecomienda.BDYValidaciones.ValidadorCedulas;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import com.toedter.calendar.JTextFieldDateEditor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.text.AbstractDocument;
import proyecto_ecomienda.BDYValidaciones.Proveedores;
import proyecto_ecomienda.BDYValidaciones.NumberOnlyFilter;
import proyecto_ecomienda.BDYValidaciones.TextPrompt;
import proyecto_ecomienda.BDYValidaciones.ValidadorDeSwings;
import proyecto_ecomienda.BDYValidaciones.ValidadorDeRegistros;

/**
 *
 * @author Moises
 */
public class JFMenu extends javax.swing.JFrame {
//Clases

    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
//RegistrarDatosFactura facturaRegistrar = new RegistrarDatosFactura();
    //Clientes
    private boolean documentoCliente = false;
    private boolean nombreCliente = false;
    private boolean apellidoCliente = false;
    private boolean correoCliente = false;
    private boolean telefonoCliente = false;
    private boolean direccionCliente = false;
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
    //Proveedores

    private boolean rucProve = false;
    private boolean nombreEmpresaProve = false;
    private boolean cedulaProve = false;
    private boolean nombreProve = false;
    private boolean apellidoProve = false;
    private boolean telefonoProve = false;
    //ProveedoresAct
    private boolean rucProve1 = false;
    private boolean nombreEmpresaProve1 = false;
    private boolean cedulaProve1 = false;
    private boolean nombreProve1 = false;
    private boolean apellidoProve1 = false;
    private boolean telefonoProve1 = false;
    //Usuarios
    private boolean claveUsuario = false;
    //Actualizar usuarios
    private boolean claveUsuario2 = false;
//Banderas
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
    private boolean cambiarSesion = true;
//Banderas actualizar
    private boolean telfCliente1 = false;
    private boolean dirCliente1 = false;
    private boolean correoElectronico1 = false;
//Proforma
    private boolean nombreNegocioValido2 = false;
    private boolean estadoPagoP2 = false;
    private boolean rucV2 = false;
    private boolean dirNeg2 = false;
    private boolean telefonoNeg2 = false;
    private boolean rucCliente2 = false;
    private boolean nombreCFactura2 = false;
    private boolean apellidoCFactura2 = false;
    private boolean telfCliente2 = false;
    private boolean dirCliente2 = false;
    private boolean correoElectronico2 = false;
    private boolean cambiarSesion2 = true;
//Inventario
    private boolean anchoValidar = false;
    private boolean largoValidar = false;
    private boolean pesoValidar = false;
    private boolean remitenteValidar=false;

    private boolean nombreItemValidar1 = false;
    private boolean stockValidar1 = false;
    private boolean precioUValidar1 = false;

//Mouses
    int xMouse, yMouse;

//Conexión y auditoria
    private String usuario;
    private String rol;
    Connection cnx;
    //Paneles   
    private JPanel[] clickedPanels = new JPanel[6];
    CardLayout contenido, contenido1;
    private boolean focusChanged = false;
    private String nombreUsuario;

    public JFMenu(String userRol, Connection cnx, String userName) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/AjustesBest.png")).getImage());
        this.nombreUsuario = userName;
        this.cnx = cnx;
        this.usuario = userRol;
        setLocationRelativeTo(null);
        String fecha = "dd-MM-yyyy";
        Locale localM = null;
        String resultado;
        Date fechaYHora = new Date();
        mostrarOpcionesAdministrador();
        jTCIDelCliente.setEnabled(false);
        jTFCIRegistrarC.setEnabled(false);
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
        contadorProductos();
        setTablaPaquetes();
        java.util.Date fechaActual = new java.util.Date();
        // Configura el JDateChooser
        jDateChooserFecha.setMaxSelectableDate(fechaActual); // Fecha máxima permitida
        jDateChooserFecha.setMinSelectableDate(null);
        FechaNacimientoEmpleado.setMaxSelectableDate(fechaActual); // Fecha máxima permitida
        FechaNacimientoEmpleado.setMinSelectableDate(null);
        // Opcional: Deshabilita la edición manual del campo de texto
        JTextFieldDateEditor editor = (JTextFieldDateEditor) jDateChooserFecha.getDateEditor();
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) FechaNacimientoEmpleado.getDateEditor();
        editor.setEditable(false);
        editor2.setEditable(false);
        desvanecer();
        int nuevoNumeroFactura = RegistrarDatosFactura.obtenerNuevoNumeroFactura(cnx);
        jTFnumerofactura.setText(String.valueOf(nuevoNumeroFactura));
        jTFAdminClave.setToolTipText("Aquí puedes ingresar tu contraseña.");
        desvanecerP();
        placeHolder();
        //AbstractDocument doc = (AbstractDocument) jTAncho.getDocument();
        AbstractDocument doc1 = (AbstractDocument) jTFidItemDar.getDocument();
        //doc.setDocumentFilter(new NumberOnlyFilter());
    }

    private void placeHolder() {
        TextPrompt texto1 = new TextPrompt("Obligatorio", jTContenidoPaquete);
        TextPrompt texto2 = new TextPrompt("Obligatorio", jTAncho);
        TextPrompt texto3 = new TextPrompt("Obligatorio", jTPeso);
        TextPrompt texto = new TextPrompt("Obligatorio", jTRemitente);
        TextPrompt texto4 = new TextPrompt("Obligatorio", jTLargo);
        TextPrompt texto5 = new TextPrompt("Obligatorio", jTDestino);
    }

    private void mostrarOpcionesAdministrador() {

        menuAdministracion.setVisible(true);
        Clicked6.setVisible(true);
        jPActualizarClientes.setVisible(true);
        jPCambiarEstado.setVisible(true);
        jPDarDeBajaInventario.setVisible(true);
        jPActualizarProovedores.setVisible(false);
        jPCambiarEstadoP.setVisible(true);
    }

   public void contadorProductos() {
    try {
        // Consulta para obtener el máximo ID de Paquete
        String consulta = "SELECT COALESCE(MAX(IDPaquete), 0) AS max_id FROM Paquete";
        PreparedStatement stmt = cnx.prepareStatement(consulta);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            int maxId = rs.getInt("max_id");
            // Si maxId es 0 (no hay paquetes), establece el siguiente ID como 1
            int siguienteId = (maxId == 0) ? 1 : maxId + 1;
            jTiDPaquete.setText(String.valueOf(siguienteId));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Maneja cualquier error de conexión o consulta aquí
    }
}


    public void desvanecerP() {
        JLabel[] labels = {errorP1, errorP2, errorP3, errorP4,
            errorP5, errorP6, errorP7, errorP8, errorP9, errorP10, errorP11, errorP12, errorActualizarCliente1,
            errorActualizarCliente2, errorActualizarCliente3, errorInventario1, errorInventario2, errorInventario2,
            errorInventario4, errorInventario5, errorInventario6, errorInventario7, errorActualizarCliente4,
            errorActualizarCliente5, errorActualizarCliente6, errorProveedores1,
            errorProveedores2, errorProveedores3, errorProveedores4, errorProveedores5, errorProveedores6, errorProveedores7,
            errorProveedores8,
            jLErrorEmpleado1, jLErrorEmpleado2, jLErrorEmpleado3,
            jLErrorEmpleado4, jLErrorEmpleado5, jLErrorEmpleado6,
            jLErrorEmpleado7, jLErrorEmpleado8, jLErrorEmpleado9, jLErrorEmpleado10,
            jLErrorEmpleado11, jLErrorEmpleado12, jLErrorEmpleado13};
        for (int i = 0; i < labels.length; i++) {
            JLabel label = labels[i % labels.length];
            label.setVisible(false);
        }
    }

    public void desvanecer() {
        Clicked1.setVisible(true);
        Clicked2.setVisible(false);
        Clicked3.setVisible(false);
        Clicked4.setVisible(false);
        Clicked5.setVisible(false);
        Clicked6.setVisible(false);
        jChBiDItem.setEnabled(false);
        jChBiDItem.setSelected(true);
        //idItemFactura.setEnabled(false);
        jTextField25.setEnabled(false);
        jBAgregarProducto.setEnabled(false);
        jBQuitarProducto.setEnabled(false);
        jBGenerarFactura.setEnabled(false);
        iDProcutoP.setEnabled(false);
        cantidadProforma.setEnabled(false);
        jBAgregarProducto1.setEnabled(false);
        jBQuitarProducto1.setEnabled(false);
        jBGenerarFactura1.setEnabled(false);
        jError2.setVisible(false);
        jError1.setVisible(false);
        jError3.setVisible(false);
        jError4.setVisible(false);
        jError5.setVisible(false);
        jError6.setVisible(false);
        jCBEstadoPago.setEnabled(false);
        errorc1.setVisible(false);
        errorc2.setVisible(false);
        errorc3.setVisible(false);
        errorc4.setVisible(false);
        errorc5.setVisible(false);
        errorc6.setVisible(false);
        jError7.setVisible(false);
        jError8.setVisible(false);
        jError9.setVisible(false);
        jError10.setVisible(false);
        jError11.setVisible(false);
        jError12.setVisible(false);
    }

    private JFMenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        Clicked6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        panelContent = new javax.swing.JPanel();
        JPInventario = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel_General = new javax.swing.JTabbedPane();
        jPIR = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTPaquetes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTiDPaquete = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTPeso = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        errorInventario2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        errorInventario1 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jTContenidoPaquete = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        errorInventario3 = new javax.swing.JLabel();
        jTLargo = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jTRemitente = new javax.swing.JTextField();
        errorInventario8 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jTDestino = new javax.swing.JTextField();
        jTAncho = new javax.swing.JTextField();
        jPID = new javax.swing.JPanel();
        jPDarDeBajaInventario = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTFidItemDar = new javax.swing.JTextField();
        jBCambiarEstado = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTablaInventario3 = new javax.swing.JTable();
        jPIA = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPActualizarAtributos = new javax.swing.JPanel();
        jTFiDItem = new javax.swing.JTextField();
        jTFnombreItem = new javax.swing.JTextField();
        jTFstock = new javax.swing.JTextField();
        jChBiDItem = new javax.swing.JCheckBox();
        jChBnombreItem = new javax.swing.JCheckBox();
        jChBstock = new javax.swing.JCheckBox();
        jChBprecio = new javax.swing.JCheckBox();
        jTFPrecio = new javax.swing.JTextField();
        errorInventario4 = new javax.swing.JLabel();
        errorInventario5 = new javax.swing.JLabel();
        errorInventario6 = new javax.swing.JLabel();
        errorInventario7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jCBACSInventario = new javax.swing.JComboBox<>();
        jTFIBuscador = new javax.swing.JTextField();
        jBIActualizar = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTablaInventario1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jCBIConsultar = new javax.swing.JComboBox<>();
        jTFCInventario = new javax.swing.JTextField();
        jBConsultarInventario = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTablaInventario2 = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jCBIConsultar1 = new javax.swing.JComboBox<>();
        jTFCInventario1 = new javax.swing.JTextField();
        jBConsultarInventario4 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        JPClientes = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPClientes = new javax.swing.JTabbedPane();
        jPPR1 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTablaClientesR = new javax.swing.JTable();
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
        errorc1 = new javax.swing.JLabel();
        errorc2 = new javax.swing.JLabel();
        errorc3 = new javax.swing.JLabel();
        errorc4 = new javax.swing.JLabel();
        errorc5 = new javax.swing.JLabel();
        errorc6 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jCBNacionalExtranjero = new javax.swing.JComboBox<>();
        jCJuridicoNatural = new javax.swing.JComboBox<>();
        jBRegistarCliente = new javax.swing.JButton();
        jPPCE1 = new javax.swing.JPanel();
        jPCambiarEstado = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jTRUCCE1 = new javax.swing.JTextField();
        jBCambiarEstadoProveedor1 = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        tablaClienteCambiarEstado = new javax.swing.JTable();
        jPPA1 = new javax.swing.JPanel();
        jPActualizarClientes = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jBIActualizarAct1 = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jTFIBuscadorAct1 = new javax.swing.JTextField();
        documentoActualizar = new javax.swing.JLabel();
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
        errorActualizarCliente1 = new javax.swing.JLabel();
        errorActualizarCliente2 = new javax.swing.JLabel();
        errorActualizarCliente3 = new javax.swing.JLabel();
        errorActualizarCliente4 = new javax.swing.JLabel();
        errorActualizarCliente5 = new javax.swing.JLabel();
        errorActualizarCliente6 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tablaActualizarCliente = new javax.swing.JTable();
        jPanel38 = new javax.swing.JPanel();
        jCBNacionalExtranjero2 = new javax.swing.JComboBox<>();
        jCJuridicoNatural1 = new javax.swing.JComboBox<>();
        jPPC1 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jTProveedorConsultar1 = new javax.swing.JTextField();
        jBConsultarInventario2 = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTablaProveedoresConsultar1 = new javax.swing.JTable();
        jPanel41 = new javax.swing.JPanel();
        jCBNacionalExtranjero3 = new javax.swing.JComboBox<>();
        jCJuridicoNatural2 = new javax.swing.JComboBox<>();
        JPProovedores = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPGP = new javax.swing.JTabbedPane();
        jPPR = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTablaProveedoresR = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jTRUC = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTNombreEmpresa = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTCedulaDespachador = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTNombreDespachador = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTApellidoDespachador = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jTFTelefonoProvedor = new javax.swing.JTextField();
        errorProveedores3 = new javax.swing.JLabel();
        errorProveedores4 = new javax.swing.JLabel();
        errorProveedores5 = new javax.swing.JLabel();
        errorProveedores6 = new javax.swing.JLabel();
        errorProveedores1 = new javax.swing.JLabel();
        errorProveedores2 = new javax.swing.JLabel();
        jBRegistrarProovedor = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTCodigoProducto = new javax.swing.JTextField();
        jTNombreProducto = new javax.swing.JTextField();
        jBAgregarProductoProveedores = new javax.swing.JButton();
        jBQuitarProductoProveedores = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPProvedoresActualizar = new javax.swing.JPanel();
        jPCambiarEstadoP = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTRUCCE = new javax.swing.JTextField();
        jBCambiarEstadoProveedor = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTablaProveedoresCE = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        jBCambiarEstadoProveedor2 = new javax.swing.JButton();
        jLabel110 = new javax.swing.JLabel();
        jTCedulaDespachadorCE1 = new javax.swing.JTextField();
        jPPA = new javax.swing.JPanel();
        jPActualizarProovedores = new javax.swing.JPanel();
        jBIActualizarAct = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTablaProveedoresA = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jTCodigoProducto1 = new javax.swing.JTextField();
        jTNombreProducto1 = new javax.swing.JTextField();
        jBAgregarProductoProveedores1 = new javax.swing.JButton();
        jBQuitarProductoProveedores1 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jTCedulaDespachadorAct = new javax.swing.JTextField();
        jTNombreDespachadorAct = new javax.swing.JTextField();
        jTApellidoDespachadorAct = new javax.swing.JTextField();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jTATelefonoDespachador = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTNombreEmpresaAct = new javax.swing.JTextField();
        jTRUCAct = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jTFIBuscarRUC = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        errorProveedores7 = new javax.swing.JLabel();
        errorProveedores8 = new javax.swing.JLabel();
        jPPC = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jTProveedorConsultar = new javax.swing.JTextField();
        jBConsultarInventario1 = new javax.swing.JButton();
        jLabel112 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTablaProveedoresConsultar = new javax.swing.JTable();
        JPFyV = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistorialFacturas = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jTFAtributoC = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        SeleccionFacturaAtributo = new javax.swing.JComboBox<>();
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
        jPanel30 = new javax.swing.JPanel();
        jPDatosFactura1 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jTFnumerofactura1 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jDateChooserFecha1 = new com.toedter.calendar.JDateChooser();
        errorP5 = new javax.swing.JLabel();
        jPDatosNegocio1 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jTFNombreNegocio1 = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        jTFRUCNegocio1 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jTFDirNegocio1 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jTFTelefonoNegocio1 = new javax.swing.JTextField();
        errorP1 = new javax.swing.JLabel();
        errorP2 = new javax.swing.JLabel();
        errorP3 = new javax.swing.JLabel();
        errorP4 = new javax.swing.JLabel();
        jPDatosCliente1 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jTNombreCliente1 = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        jTTelefonoCliente1 = new javax.swing.JTextField();
        jLCITipoCliente1 = new javax.swing.JLabel();
        jTCIDelCliente1 = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jTDireccionCliente1 = new javax.swing.JTextField();
        jCBSeleccionTipoCliente1 = new javax.swing.JComboBox<>();
        jLabel98 = new javax.swing.JLabel();
        jTFApeliidosCliente1 = new javax.swing.JTextField();
        jBRegistrarFactura1 = new javax.swing.JButton();
        jLabel99 = new javax.swing.JLabel();
        correoCli1 = new javax.swing.JTextField();
        jCBNaturalOJuridico1 = new javax.swing.JComboBox<>();
        errorP7 = new javax.swing.JLabel();
        errorP8 = new javax.swing.JLabel();
        errorP9 = new javax.swing.JLabel();
        errorP10 = new javax.swing.JLabel();
        errorP11 = new javax.swing.JLabel();
        errorP12 = new javax.swing.JLabel();
        jPProducto1 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        iDProcutoP = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        cantidadProforma = new javax.swing.JTextField();
        jBAgregarProducto1 = new javax.swing.JButton();
        jBQuitarProducto1 = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jTFSubtotal1 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        IVAText1 = new javax.swing.JTextField();
        jTFTotal = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jBGenerarFactura1 = new javax.swing.JButton();
        jScrollPane27 = new javax.swing.JScrollPane();
        jTablaRegistrarFactura1 = new javax.swing.JTable();
        jCBEstadoPago1 = new javax.swing.JComboBox<>();
        jLabel90 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        errorP6 = new javax.swing.JLabel();
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
        JPEmpleados = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPEmpleadosTab = new javax.swing.JPanel();
        jTPEmpleados = new javax.swing.JTabbedPane();
        jPRE = new javax.swing.JPanel();
        jPDatosEmpleados = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        NombreEmpleado = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTFApellidoEmpleado = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        CedulaEmpleado = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        Cargo = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        SexoEmpleado = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        TelefonoConvencional = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        TelefonoPersonal = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        CorreoElectronico = new javax.swing.JTextField();
        BRegistrar = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        direccionEmpelado = new javax.swing.JTextField();
        FechaNacimientoEmpleado = new com.toedter.calendar.JDateChooser();
        errorEmpleados1 = new javax.swing.JLabel();
        jLErrorEmpleado1 = new javax.swing.JLabel();
        jLErrorEmpleado2 = new javax.swing.JLabel();
        jLErrorEmpleado3 = new javax.swing.JLabel();
        jLErrorEmpleado4 = new javax.swing.JLabel();
        jLErrorEmpleado5 = new javax.swing.JLabel();
        jLErrorEmpleado6 = new javax.swing.JLabel();
        jLErrorEmpleado7 = new javax.swing.JLabel();
        jLErrorEmpleado8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableEmpleadosAcutalizar = new javax.swing.JTable();
        jPAE = new javax.swing.JPanel();
        jPDatosRecuperadosEmpleados = new javax.swing.JPanel();
        TFNombresActualizado = new javax.swing.JTextField();
        TFApellidosActualizado = new javax.swing.JTextField();
        TFNCedulaActualizado = new javax.swing.JTextField();
        TFDireccionActualizado = new javax.swing.JTextField();
        TFFNacimientoActualizado = new javax.swing.JTextField();
        CBSexoActualizado = new javax.swing.JComboBox<>();
        TFTConvencionalActualizado = new javax.swing.JTextField();
        TFTPersonalActualizado = new javax.swing.JTextField();
        TFEmailActualizado = new javax.swing.JTextField();
        TFCargoActualizado = new javax.swing.JTextField();
        jCCIActualizar = new javax.swing.JCheckBox();
        jCNombreActualizar = new javax.swing.JCheckBox();
        jCApellidoActualizar = new javax.swing.JCheckBox();
        jCDireccionActualizar = new javax.swing.JCheckBox();
        jCCargoActualizar = new javax.swing.JCheckBox();
        jCFechaActualizar = new javax.swing.JCheckBox();
        jCSexoActualizar = new javax.swing.JCheckBox();
        jCTelefonoCActualizar = new javax.swing.JCheckBox();
        jCTelefonoPActualizar = new javax.swing.JCheckBox();
        jCCorreoActualizar = new javax.swing.JCheckBox();
        jPanel53 = new javax.swing.JPanel();
        jTFIBuscadorAct5 = new javax.swing.JTextField();
        documentoActualizar3 = new javax.swing.JLabel();
        jLErrorEmpleado9 = new javax.swing.JLabel();
        jLErrorEmpleado10 = new javax.swing.JLabel();
        jLErrorEmpleado11 = new javax.swing.JLabel();
        jLErrorEmpleado12 = new javax.swing.JLabel();
        jLErrorEmpleado13 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jTableEmpleadosAcutalizar1 = new javax.swing.JTable();
        BActualizar = new javax.swing.JButton();
        jPCE = new javax.swing.JPanel();
        PanelFiltros = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        TFConsultarEmpleado = new javax.swing.JTextField();
        CBConsultarEmpleado = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableEmpleadosAcutalizar2 = new javax.swing.JTable();
        PanelFiltros1 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        TFConsultarEmpleado1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPEE = new javax.swing.JPanel();
        jPanelEliminarEmpleado = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        TFNCedulaBuscar1 = new javax.swing.JTextField();
        BBuscarEliminar = new javax.swing.JButton();
        jScrollPane25 = new javax.swing.JScrollPane();
        jTableEmpleadosAcutalizar3 = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
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
        menuProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/assignment_turned_in_white_18dp.png"))); // NOI18N
        menuProveedores.setText("     Proveedores");
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
        menuEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/assignment_ind_white_18dp.png"))); // NOI18N
        menuEmpleados.setText("     Empleados");
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
        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/outline_edit_white_18dp.png"))); // NOI18N
        menuClientes.setText("     Clientes");
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
        menuinventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/playlist_add_white_18dp.png"))); // NOI18N
        menuinventario.setText("     Inventario");
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
        menuFacturacionYVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/monetization_on_white_18dp.png"))); // NOI18N
        menuFacturacionYVenta.setText("     Facturación y venta");
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
        jLabel3.setText("Version 1.6");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 740, -1, -1));

        menuLogout.setBackground(new java.awt.Color(41, 39, 40));
        menuLogout.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuLogout.setForeground(new java.awt.Color(255, 255, 255));
        menuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/home_white_18dp.png"))); // NOI18N
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
        jPanel1.add(menuLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 210, 52));

        menuAdministracion.setBackground(new java.awt.Color(41, 39, 40));
        menuAdministracion.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuAdministracion.setForeground(new java.awt.Color(255, 255, 255));
        menuAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/administracion.png"))); // NOI18N
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

        jPanel1.add(Clicked6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 10, 52));

        jPanel13.setBackground(new java.awt.Color(146, 10, 48));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setContentAreaFilled(false);
        jPanel13.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 80, 50));

        jLabel1.setBackground(new java.awt.Color(178, 8, 55));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Evios");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel13.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 130, -1));

        jLabel2.setBackground(new java.awt.Color(178, 8, 55));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("2024");
        jPanel13.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 120, -1));

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 220, 60));

        PanelHome.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 770));

        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/power_24dp.png"))); // NOI18N
        btnExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        PanelHome.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 20, 35, 35));

        btnHelp.setForeground(new java.awt.Color(255, 255, 255));
        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/help_outline_black_24dp.png"))); // NOI18N
        btnHelp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnHelp.setContentAreaFilled(false);
        btnHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        PanelHome.add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 20, 40, 35));

        panelContent.setLayout(new java.awt.CardLayout());

        JPInventario.setBackground(new java.awt.Color(245, 245, 245));
        JPInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Inventario");
        JPInventario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel_General.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_GeneralMouseClicked(evt);
            }
        });

        jTPaquetes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTPaquetes);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del paquete"));

        jLabel4.setText("ID Paquete");

        jTiDPaquete.setEditable(false);

        jLabel13.setText("contenido");

        jLabel11.setText("Peso");

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

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel60.setText("KG");

        errorInventario2.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario2.setText("Peso no valido");

        jLabel14.setText("Ancho");

        errorInventario1.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario1.setText("Ancho no valido");

        jLabel61.setText("m");

        jLabel35.setText("Largo");

        errorInventario3.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario3.setText("Largo no valido");

        jTLargo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTLargoFocusLost(evt);
            }
        });
        jTLargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTLargoKeyReleased(evt);
            }
        });

        jLabel62.setText("cm");

        jLabel53.setText("Remitente");

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

        errorInventario8.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario8.setText("Remitente no valido");

        jLabel63.setText("Destino");

        jTDestino.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTDestinoFocusLost(evt);
            }
        });
        jTDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTDestinoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTDestinoKeyTyped(evt);
            }
        });

        jTAncho.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAnchoFocusLost(evt);
            }
        });
        jTAncho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTAnchoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(jLabel63))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(errorInventario1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(errorInventario2)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jTPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel60)
                                            .addGap(65, 65, 65)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel35)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel53))
                                            .addGap(21, 21, 21)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTContenidoPaquete, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTLargo, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel62))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(errorInventario8)
                                                        .addComponent(jTRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(errorInventario3))
                                                    .addGap(0, 0, Short.MAX_VALUE)))))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTiDPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel61)))
                        .addGap(186, 186, 186))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTiDPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel61)
                                    .addComponent(jLabel14)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorInventario1)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel60))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel53)
                            .addComponent(jTRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorInventario8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62)
                            .addComponent(jTLargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorInventario3)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTContenidoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorInventario2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addComponent(jTDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPIRLayout = new javax.swing.GroupLayout(jPIR);
        jPIR.setLayout(jPIRLayout);
        jPIRLayout.setHorizontalGroup(
            jPIRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPIRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPIRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPIRLayout.createSequentialGroup()
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 961, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        jPIRLayout.setVerticalGroup(
            jPIRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIRLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel_General.addTab("Registrar", jPIR);

        jPID.setLayout(new java.awt.CardLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Identificador el producto"));

        jLabel12.setText("ID Ítem");

        jTFidItemDar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFidItemDarKeyReleased(evt);
            }
        });

        jBCambiarEstado.setText("Cambiar estado del producto");
        jBCambiarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCambiarEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTFidItemDar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jBCambiarEstado)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTFidItemDar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBCambiarEstado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTablaInventario3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(jTablaInventario3);

        javax.swing.GroupLayout jPDarDeBajaInventarioLayout = new javax.swing.GroupLayout(jPDarDeBajaInventario);
        jPDarDeBajaInventario.setLayout(jPDarDeBajaInventarioLayout);
        jPDarDeBajaInventarioLayout.setHorizontalGroup(
            jPDarDeBajaInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDarDeBajaInventarioLayout.createSequentialGroup()
                .addGroup(jPDarDeBajaInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDarDeBajaInventarioLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPDarDeBajaInventarioLayout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPDarDeBajaInventarioLayout.setVerticalGroup(
            jPDarDeBajaInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDarDeBajaInventarioLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jPID.add(jPDarDeBajaInventario, "jPDarDeBajaInventario");

        jPanel_General.addTab("Cambiar estado de un ítem", jPID);

        jPActualizarAtributos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actualizar Atributos de un producto", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N

        jTFiDItem.setEditable(false);
        jTFiDItem.setEnabled(false);

        jTFnombreItem.setEnabled(false);
        jTFnombreItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFnombreItemFocusLost(evt);
            }
        });
        jTFnombreItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFnombreItemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFnombreItemKeyTyped(evt);
            }
        });

        jTFstock.setEnabled(false);
        jTFstock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFstockFocusLost(evt);
            }
        });
        jTFstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFstockKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFstockKeyTyped(evt);
            }
        });

        jChBiDItem.setSelected(true);
        jChBiDItem.setText("ID Ítem");
        jChBiDItem.setToolTipText("");
        jChBiDItem.setEnabled(false);

        jChBnombreItem.setText("Nombre del producto");
        jChBnombreItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChBnombreItemActionPerformed(evt);
            }
        });

        jChBstock.setText("Stock");
        jChBstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChBstockActionPerformed(evt);
            }
        });

        jChBprecio.setText("Precio");
        jChBprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChBprecioActionPerformed(evt);
            }
        });

        jTFPrecio.setEnabled(false);
        jTFPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFPrecioFocusLost(evt);
            }
        });
        jTFPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFPrecioKeyTyped(evt);
            }
        });

        errorInventario4.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario4.setText("Nombre del ítem no válido");

        errorInventario5.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario5.setText("Stock no válido");

        errorInventario6.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario6.setText("Precio no válido");

        errorInventario7.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario7.setText("*Vacio");

        javax.swing.GroupLayout jPActualizarAtributosLayout = new javax.swing.GroupLayout(jPActualizarAtributos);
        jPActualizarAtributos.setLayout(jPActualizarAtributosLayout);
        jPActualizarAtributosLayout.setHorizontalGroup(
            jPActualizarAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPActualizarAtributosLayout.createSequentialGroup()
                .addGroup(jPActualizarAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChBiDItem)
                    .addComponent(jChBstock)
                    .addComponent(jChBnombreItem)
                    .addComponent(jChBprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPActualizarAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFiDItem, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFnombreItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFstock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPActualizarAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorInventario4)
                    .addComponent(errorInventario5)
                    .addComponent(errorInventario6)
                    .addComponent(errorInventario7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPActualizarAtributosLayout.setVerticalGroup(
            jPActualizarAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPActualizarAtributosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPActualizarAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errorInventario6)
                    .addGroup(jPActualizarAtributosLayout.createSequentialGroup()
                        .addGroup(jPActualizarAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFiDItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jChBiDItem)
                            .addComponent(errorInventario7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPActualizarAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFnombreItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jChBnombreItem)
                            .addComponent(errorInventario4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPActualizarAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jChBstock)
                            .addComponent(errorInventario5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPActualizarAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jChBprecio)
                            .addComponent(jTFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(143, 143, 143))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador  del producto a actualizar", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        jCBACSInventario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "ID Ítem", "Nombre del ítem", "Stock", "Precio", " " }));
        jCBACSInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBACSInventarioActionPerformed(evt);
            }
        });

        jTFIBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFIBuscadorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFIBuscadorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jCBACSInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 256, Short.MAX_VALUE))
                    .addComponent(jTFIBuscador))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jCBACSInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFIBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBIActualizar.setText("Actualizar");
        jBIActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPActualizarAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jBIActualizar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPActualizarAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBIActualizar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTablaInventario1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablaInventario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaInventario1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTablaInventario1);

        javax.swing.GroupLayout jPIALayout = new javax.swing.GroupLayout(jPIA);
        jPIA.setLayout(jPIALayout);
        jPIALayout.setHorizontalGroup(
            jPIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIALayout.createSequentialGroup()
                .addGroup(jPIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPIALayout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPIALayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPIALayout.setVerticalGroup(
            jPIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIALayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        jPanel_General.addTab("Actualizar", jPIA);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar Inventario"));

        jCBIConsultar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "ID Ítem", "Nombre del ítem", "Stock", "Precio", "Estado" }));
        jCBIConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBIConsultarActionPerformed(evt);
            }
        });

        jTFCInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFCInventarioKeyTyped(evt);
            }
        });

        jBConsultarInventario.setText("Consultar");
        jBConsultarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jBConsultarInventario))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBIConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFCInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jCBIConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFCInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBConsultarInventario)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTablaInventario2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(jTablaInventario2);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar Inventario por ID\n"));

        jCBIConsultar1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona el atributo", "nombreItem", "stock", "precio", "estado" }));
        jCBIConsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBIConsultar1ActionPerformed(evt);
            }
        });

        jTFCInventario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFCInventario1KeyTyped(evt);
            }
        });

        jBConsultarInventario4.setText("Consultar Inventario");
        jBConsultarInventario4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarInventario4ActionPerformed(evt);
            }
        });

        jLabel32.setText("ID del Item");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBConsultarInventario4)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jLabel32)
                            .addGap(18, 18, 18)
                            .addComponent(jTFCInventario1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCBIConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBIConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFCInventario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(33, 33, 33)
                .addComponent(jBConsultarInventario4)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jPanel_General.addTab("Consultar", jPanel5);

        JPInventario.add(jPanel_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 1040, 620));

        panelContent.add(JPInventario, "card1");

        JPClientes.setBackground(new java.awt.Color(245, 245, 245));
        JPClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Clientes");
        JPClientes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPPR1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPPR1.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 1000, 158));

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

        errorc1.setForeground(new java.awt.Color(255, 102, 102));
        errorc1.setText("*error");

        errorc2.setForeground(new java.awt.Color(255, 102, 102));
        errorc2.setText("Nombre inválido");

        errorc3.setForeground(new java.awt.Color(255, 102, 102));
        errorc3.setText("Apellido inválido");

        errorc4.setForeground(new java.awt.Color(255, 102, 102));
        errorc4.setText("Correo inválido");

        errorc5.setForeground(new java.awt.Color(255, 102, 102));
        errorc5.setText("*error");

        errorc6.setForeground(new java.awt.Color(255, 102, 102));
        errorc6.setText("Dirección inválida");

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jLabel89)
                        .addGap(18, 18, 18)
                        .addComponent(errorc3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel46Layout.createSequentialGroup()
                                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(errorc4))
                            .addComponent(jTFApellidosR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(correoCli2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTFCIRegistrarC, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel46Layout.createSequentialGroup()
                                    .addComponent(jLabel66)
                                    .addGap(18, 18, 18)
                                    .addComponent(errorc2))
                                .addComponent(jTFNombresR, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel46Layout.createSequentialGroup()
                                    .addComponent(jLTipoCli)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(errorc1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFDireccionR, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel46Layout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(errorc6))
                            .addComponent(jTFTelefonoR, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel46Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorc5)))
                        .addGap(45, 45, 45))))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLTipoCli)
                            .addComponent(errorc1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFCIRegistrarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(errorc2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNombresR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71)
                            .addComponent(errorc5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFTelefonoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(errorc6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFDireccionR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(errorc3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFApellidosR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(errorc4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(correoCli2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPPR1.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 23, -1, 241));

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecciona el tipo de cliente"));

        jCBNacionalExtranjero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Nacional", "Extranjero" }));
        jCBNacionalExtranjero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBNacionalExtranjeroActionPerformed(evt);
            }
        });

        jCJuridicoNatural.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Natural o Jurídico", "Natural", "Jurídico" }));
        jCJuridicoNatural.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCJuridicoNaturalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBNacionalExtranjero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCJuridicoNatural, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBNacionalExtranjero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCJuridicoNatural, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPPR1.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 23, -1, -1));

        jBRegistarCliente.setText("Registrar Cliente");
        jBRegistarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistarClienteActionPerformed(evt);
            }
        });
        jPPR1.add(jBRegistarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, -1, -1));

        jPClientes.addTab("Registrar", jPPR1);

        jPPCE1.setLayout(new java.awt.CardLayout());

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambiar Estado del Cliente"));

        jLabel56.setText("Documento");

        jTRUCCE1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTRUCCE1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTRUCCE1KeyTyped(evt);
            }
        });

        jBCambiarEstadoProveedor1.setText("Cambiar Estado");
        jBCambiarEstadoProveedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCambiarEstadoProveedor1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTRUCCE1)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jBCambiarEstadoProveedor1)
                .addGap(61, 61, 61))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTRUCCE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(18, 18, 18)
                .addComponent(jBCambiarEstadoProveedor1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tablaClienteCambiarEstado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane17.setViewportView(tablaClienteCambiarEstado);

        javax.swing.GroupLayout jPCambiarEstadoLayout = new javax.swing.GroupLayout(jPCambiarEstado);
        jPCambiarEstado.setLayout(jPCambiarEstadoLayout);
        jPCambiarEstadoLayout.setHorizontalGroup(
            jPCambiarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCambiarEstadoLayout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(529, Short.MAX_VALUE))
            .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
        );
        jPCambiarEstadoLayout.setVerticalGroup(
            jPCambiarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCambiarEstadoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );

        jPPCE1.add(jPCambiarEstado, "card1");

        jPClientes.addTab("Cambiar Estado", jPPCE1);

        jPPA1.setPreferredSize(new java.awt.Dimension(790, 459));
        jPPA1.setLayout(new java.awt.CardLayout());

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder("Actualizar Cliente"));
        jPanel40.setToolTipText("");
        jPanel40.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jBIActualizarAct1.setText("Actualizar");
        jBIActualizarAct1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIActualizarAct1ActionPerformed(evt);
            }
        });

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscardor", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        jTFIBuscadorAct1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFIBuscadorAct1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFIBuscadorAct1KeyTyped(evt);
            }
        });

        documentoActualizar.setText("Documento");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(documentoActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jTFIBuscadorAct1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFIBuscadorAct1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(documentoActualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CIselect.setSelected(true);
        CIselect.setText("CI");
        CIselect.setEnabled(false);

        nombreSelect.setSelected(true);
        nombreSelect.setText("Nombre");
        nombreSelect.setEnabled(false);

        apellidoSelect.setSelected(true);
        apellidoSelect.setText("Apellido");
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

        errorActualizarCliente1.setForeground(new java.awt.Color(255, 0, 51));
        errorActualizarCliente1.setText("*error");

        errorActualizarCliente2.setForeground(new java.awt.Color(255, 0, 51));
        errorActualizarCliente2.setText("*Dirección inválida");

        errorActualizarCliente3.setForeground(new java.awt.Color(255, 0, 51));
        errorActualizarCliente3.setText("Correo inválido");

        errorActualizarCliente4.setForeground(new java.awt.Color(255, 0, 51));
        errorActualizarCliente4.setText("*Vacio");

        errorActualizarCliente5.setForeground(new java.awt.Color(255, 0, 51));
        errorActualizarCliente5.setText("*Vacio");

        errorActualizarCliente6.setForeground(new java.awt.Color(255, 0, 51));
        errorActualizarCliente6.setText("*Vacio");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefonoSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel40Layout.createSequentialGroup()
                                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nombreSelect)
                                            .addComponent(CIselect))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(correoActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                            .addComponent(ciActualizar)
                                            .addComponent(direccionActualizar)
                                            .addComponent(telefonoActualizar)))
                                    .addComponent(correoSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(nombreActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(direccionSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel40Layout.createSequentialGroup()
                                                .addComponent(apellidoSelect)
                                                .addGap(18, 18, 18)
                                                .addComponent(apellidoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errorActualizarCliente2)
                                    .addComponent(errorActualizarCliente3)
                                    .addComponent(errorActualizarCliente1)
                                    .addComponent(errorActualizarCliente4)
                                    .addComponent(errorActualizarCliente5)
                                    .addComponent(errorActualizarCliente6)))))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jBIActualizarAct1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CIselect)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ciActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(errorActualizarCliente4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreSelect)
                    .addComponent(errorActualizarCliente5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidoSelect)
                    .addComponent(errorActualizarCliente6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoSelect)
                    .addComponent(telefonoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorActualizarCliente1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionSelect)
                    .addComponent(direccionActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorActualizarCliente2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correoSelect)
                    .addComponent(correoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorActualizarCliente3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBIActualizarAct1)
                .addGap(14, 14, 14))
        );

        tablaActualizarCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaActualizarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaActualizarClienteMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tablaActualizarCliente);

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecciona el tipo de cliente"));

        jCBNacionalExtranjero2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Nacional", "Extranjero" }));
        jCBNacionalExtranjero2.setEnabled(false);
        jCBNacionalExtranjero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBNacionalExtranjero2ActionPerformed(evt);
            }
        });

        jCJuridicoNatural1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Natural o Jurídico", "Natural", "Jurídico" }));
        jCJuridicoNatural1.setEnabled(false);
        jCJuridicoNatural1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCJuridicoNatural1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBNacionalExtranjero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCJuridicoNatural1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBNacionalExtranjero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCJuridicoNatural1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPActualizarClientesLayout = new javax.swing.GroupLayout(jPActualizarClientes);
        jPActualizarClientes.setLayout(jPActualizarClientesLayout);
        jPActualizarClientesLayout.setHorizontalGroup(
            jPActualizarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPActualizarClientesLayout.createSequentialGroup()
                .addGroup(jPActualizarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPActualizarClientesLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPActualizarClientesLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPActualizarClientesLayout.setVerticalGroup(
            jPActualizarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPActualizarClientesLayout.createSequentialGroup()
                .addGroup(jPActualizarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPActualizarClientesLayout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPActualizarClientesLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPPA1.add(jPActualizarClientes, "card1");

        jPClientes.addTab("Actualizar", jPPA1);

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar Cliente"));

        jTProveedorConsultar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTProveedorConsultar1KeyTyped(evt);
            }
        });

        jBConsultarInventario2.setText("Consultar");
        jBConsultarInventario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarInventario2ActionPerformed(evt);
            }
        });

        jLabel106.setText("Documento");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jBConsultarInventario2))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel106)
                            .addComponent(jTProveedorConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel106)
                .addGap(18, 18, 18)
                .addComponent(jTProveedorConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBConsultarInventario2)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTablaProveedoresConsultar1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane19.setViewportView(jTablaProveedoresConsultar1);

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecciona el tipo de cliente"));

        jCBNacionalExtranjero3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Nacional", "Extranjero" }));
        jCBNacionalExtranjero3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBNacionalExtranjero3ActionPerformed(evt);
            }
        });

        jCJuridicoNatural2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Natural o Jurídico", "Natural", "Jurídico" }));
        jCJuridicoNatural2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCJuridicoNatural2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBNacionalExtranjero3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCJuridicoNatural2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBNacionalExtranjero3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCJuridicoNatural2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPPC1Layout = new javax.swing.GroupLayout(jPPC1);
        jPPC1.setLayout(jPPC1Layout);
        jPPC1Layout.setHorizontalGroup(
            jPPC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPC1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPC1Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPPC1Layout.setVerticalGroup(
            jPPC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPC1Layout.createSequentialGroup()
                .addGroup(jPPC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPC1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPPC1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jPClientes.addTab("Consultar", jPPC1);

        JPClientes.add(jPClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1060, 610));

        panelContent.add(JPClientes, "card2");

        JPProovedores.setBackground(new java.awt.Color(245, 245, 245));
        JPProovedores.setMinimumSize(new java.awt.Dimension(810, 540));
        JPProovedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Proveedores");
        JPProovedores.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPPR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablaProveedoresR.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablaProveedoresR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaProveedoresRMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTablaProveedoresR);

        jPPR.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 317, 975, 240));

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del proovedor"));
        jPanel15.setToolTipText("");

        jTRUC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTRUCFocusLost(evt);
            }
        });
        jTRUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTRUCKeyReleased(evt);
            }
        });

        jLabel16.setText("Nombre de la Empresa");

        jTNombreEmpresa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTNombreEmpresaFocusLost(evt);
            }
        });
        jTNombreEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreEmpresaKeyReleased(evt);
            }
        });

        jLabel15.setText("RUC");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Despachador"));

        jLabel21.setText("Cédula");

        jTCedulaDespachador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCedulaDespachadorFocusLost(evt);
            }
        });
        jTCedulaDespachador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCedulaDespachadorKeyReleased(evt);
            }
        });

        jLabel22.setText("Nombre");

        jTNombreDespachador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTNombreDespachadorFocusLost(evt);
            }
        });
        jTNombreDespachador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreDespachadorKeyReleased(evt);
            }
        });

        jLabel23.setText("Apellido");

        jTApellidoDespachador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTApellidoDespachadorFocusLost(evt);
            }
        });
        jTApellidoDespachador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTApellidoDespachadorKeyReleased(evt);
            }
        });

        jLabel107.setText("Teléfono móvil");

        jTFTelefonoProvedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFTelefonoProvedorFocusLost(evt);
            }
        });
        jTFTelefonoProvedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFTelefonoProvedorKeyReleased(evt);
            }
        });

        errorProveedores3.setForeground(new java.awt.Color(255, 0, 51));
        errorProveedores3.setText("Cédula inválida");

        errorProveedores4.setForeground(new java.awt.Color(255, 0, 51));
        errorProveedores4.setText("Nombre inválido");

        errorProveedores5.setForeground(new java.awt.Color(255, 0, 51));
        errorProveedores5.setText("Apellido inválido");

        errorProveedores6.setForeground(new java.awt.Color(255, 0, 51));
        errorProveedores6.setText("Teléfono móvil inválido");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23)
                    .addComponent(jLabel107))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFTelefonoProvedor)
                    .addComponent(jTApellidoDespachador, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTNombreDespachador, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTCedulaDespachador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorProveedores3)
                    .addComponent(errorProveedores4)
                    .addComponent(errorProveedores5)
                    .addComponent(errorProveedores6))
                .addGap(129, 129, 129))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTCedulaDespachador, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorProveedores3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel21)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTNombreDespachador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(errorProveedores4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTApellidoDespachador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorProveedores5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFTelefonoProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(errorProveedores6))
                    .addComponent(jLabel107))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        errorProveedores1.setForeground(new java.awt.Color(255, 0, 51));
        errorProveedores1.setText("RUC no válido");

        errorProveedores2.setForeground(new java.awt.Color(255, 0, 51));
        errorProveedores2.setText("Nombre de la empresa inválido");

        jBRegistrarProovedor.setText("Registrar datos básicos");
        jBRegistrarProovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarProovedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTRUC, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(jTNombreEmpresa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errorProveedores2)
                                    .addComponent(errorProveedores1)))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jBRegistrarProovedor)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(errorProveedores1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(errorProveedores2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBRegistrarProovedor)
                .addGap(52, 52, 52))
        );

        jPPR.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 10, 660, 300));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        jLabel17.setText("IDItem");

        jLabel18.setText("Nombre");

        jTCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCodigoProductoKeyReleased(evt);
            }
        });

        jTNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreProductoKeyReleased(evt);
            }
        });

        jBAgregarProductoProveedores.setText("Agregar");
        jBAgregarProductoProveedores.setEnabled(false);
        jBAgregarProductoProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarProductoProveedoresActionPerformed(evt);
            }
        });

        jBQuitarProductoProveedores.setText("Quitar");
        jBQuitarProductoProveedores.setEnabled(false);
        jBQuitarProductoProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitarProductoProveedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBAgregarProductoProveedores)
                .addGap(18, 18, 18)
                .addComponent(jBQuitarProductoProveedores)
                .addGap(46, 46, 46))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jTCodigoProducto))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBQuitarProductoProveedores)
                    .addComponent(jBAgregarProductoProveedores))
                .addContainerGap())
        );

        jPPR.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, -1));

        jButton8.setText("Registrar proveedor");
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPPR.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, -1, -1));

        jPGP.addTab("Registrar", jPPR);

        jPProvedoresActualizar.setLayout(new java.awt.CardLayout());

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambiar Estado Proveedor"));

        jLabel20.setText("RUC");

        jTRUCCE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTRUCCEKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTRUCCEKeyTyped(evt);
            }
        });

        jBCambiarEstadoProveedor.setText("Cambiar Estado");
        jBCambiarEstadoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCambiarEstadoProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jTRUCCE, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addGap(14, 14, 14))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jBCambiarEstadoProveedor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTRUCCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(29, 29, 29)
                .addComponent(jBCambiarEstadoProveedor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTablaProveedoresCE.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane12.setViewportView(jTablaProveedoresCE);

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambiar del despachador"));

        jBCambiarEstadoProveedor2.setText("Cambiar Estado");
        jBCambiarEstadoProveedor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCambiarEstadoProveedor2ActionPerformed(evt);
            }
        });

        jLabel110.setText("Cédula Despachador");

        jTCedulaDespachadorCE1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCedulaDespachadorCE1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel110)
                .addGap(18, 18, 18)
                .addComponent(jTCedulaDespachadorCE1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(jBCambiarEstadoProveedor2)
                .addGap(119, 119, 119))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(jTCedulaDespachadorCE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jBCambiarEstadoProveedor2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPCambiarEstadoPLayout = new javax.swing.GroupLayout(jPCambiarEstadoP);
        jPCambiarEstadoP.setLayout(jPCambiarEstadoPLayout);
        jPCambiarEstadoPLayout.setHorizontalGroup(
            jPCambiarEstadoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCambiarEstadoPLayout.createSequentialGroup()
                .addGroup(jPCambiarEstadoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCambiarEstadoPLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPCambiarEstadoPLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPCambiarEstadoPLayout.setVerticalGroup(
            jPCambiarEstadoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCambiarEstadoPLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPCambiarEstadoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        jPProvedoresActualizar.add(jPCambiarEstadoP, "CambiarEstado");

        jPGP.addTab("Cambiar Estado", jPProvedoresActualizar);

        jPPA.setPreferredSize(new java.awt.Dimension(790, 459));
        jPPA.setLayout(new java.awt.CardLayout());

        jPActualizarProovedores.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPActualizarProovedores.setToolTipText("");
        jPActualizarProovedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jBIActualizarAct.setText("Actualizar");
        jBIActualizarAct.setEnabled(false);
        jBIActualizarAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIActualizarActActionPerformed(evt);
            }
        });

        jTablaProveedoresA.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablaProveedoresA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaProveedoresAMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(jTablaProveedoresA);

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        jLabel109.setText("IDItem");

        jLabel111.setText("Nombre");

        jTCodigoProducto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCodigoProducto1KeyReleased(evt);
            }
        });

        jTNombreProducto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreProducto1KeyReleased(evt);
            }
        });

        jBAgregarProductoProveedores1.setText("Agregar");
        jBAgregarProductoProveedores1.setEnabled(false);
        jBAgregarProductoProveedores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarProductoProveedores1ActionPerformed(evt);
            }
        });

        jBQuitarProductoProveedores1.setText("Quitar");
        jBQuitarProductoProveedores1.setEnabled(false);
        jBQuitarProductoProveedores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitarProductoProveedores1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBAgregarProductoProveedores1)
                .addGap(18, 18, 18)
                .addComponent(jBQuitarProductoProveedores1)
                .addGap(46, 46, 46))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel109)
                    .addComponent(jLabel111))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTNombreProducto1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jTCodigoProducto1))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel109)
                    .addComponent(jTCodigoProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel111)
                    .addComponent(jTNombreProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBQuitarProductoProveedores1)
                    .addComponent(jBAgregarProductoProveedores1))
                .addContainerGap())
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder("Actualizar proveedor"));

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Despachador"));

        jTCedulaDespachadorAct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTCedulaDespachadorAct.setEnabled(false);

        jTNombreDespachadorAct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTNombreDespachadorAct.setEnabled(false);

        jTApellidoDespachadorAct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTApellidoDespachadorAct.setEnabled(false);

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Cédula");
        jCheckBox3.setEnabled(false);

        jCheckBox4.setSelected(true);
        jCheckBox4.setText("Nombre");
        jCheckBox4.setEnabled(false);

        jCheckBox5.setSelected(true);
        jCheckBox5.setText("Apellido");
        jCheckBox5.setEnabled(false);

        jCheckBox8.setText("Teléfono");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jTATelefonoDespachador.setEnabled(false);
        jTATelefonoDespachador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTATelefonoDespachadorFocusLost(evt);
            }
        });
        jTATelefonoDespachador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTATelefonoDespachadorKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTCedulaDespachadorAct, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(jTNombreDespachadorAct)
                            .addComponent(jTApellidoDespachadorAct)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jCheckBox8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTATelefonoDespachador, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTCedulaDespachadorAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNombreDespachadorAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTApellidoDespachadorAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox8)
                    .addComponent(jTATelefonoDespachador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jCheckBox2.setText("Nombre de la Empresa");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("RUC");
        jCheckBox1.setEnabled(false);

        jTNombreEmpresaAct.setEnabled(false);
        jTNombreEmpresaAct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTNombreEmpresaActFocusLost(evt);
            }
        });
        jTNombreEmpresaAct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreEmpresaActKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNombreEmpresaActKeyTyped(evt);
            }
        });

        jTRUCAct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTRUCAct.setEnabled(false);

        jButton2.setText("Actualizar datos básicos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar proveedor:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        jTFIBuscarRUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFIBuscarRUCKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFIBuscarRUCKeyTyped(evt);
            }
        });

        jLabel24.setText("RUC");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFIBuscarRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFIBuscarRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        errorProveedores7.setForeground(new java.awt.Color(255, 0, 51));
        errorProveedores7.setText("Teléfono móvil inválido");

        errorProveedores8.setForeground(new java.awt.Color(255, 0, 51));
        errorProveedores8.setText("Nombre inválido");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTNombreEmpresaAct, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(jTRUCAct))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorProveedores8))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton2))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorProveedores7)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jTRUCAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNombreEmpresaAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2)
                    .addComponent(errorProveedores8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addComponent(errorProveedores7)
                        .addGap(25, 25, 25)))
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(17, 17, 17))))
        );

        javax.swing.GroupLayout jPActualizarProovedoresLayout = new javax.swing.GroupLayout(jPActualizarProovedores);
        jPActualizarProovedores.setLayout(jPActualizarProovedoresLayout);
        jPActualizarProovedoresLayout.setHorizontalGroup(
            jPActualizarProovedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPActualizarProovedoresLayout.createSequentialGroup()
                .addGroup(jPActualizarProovedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPActualizarProovedoresLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPActualizarProovedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPActualizarProovedoresLayout.createSequentialGroup()
                                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPActualizarProovedoresLayout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(jBIActualizarAct)))
                .addContainerGap())
        );
        jPActualizarProovedoresLayout.setVerticalGroup(
            jPActualizarProovedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPActualizarProovedoresLayout.createSequentialGroup()
                .addGroup(jPActualizarProovedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPActualizarProovedoresLayout.createSequentialGroup()
                        .addContainerGap(17, Short.MAX_VALUE)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPActualizarProovedoresLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jBIActualizarAct)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPPA.add(jPActualizarProovedores, "cardActualizar");

        jPGP.addTab("Actualizar", jPPA);

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar Proveedor"));

        jTProveedorConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTProveedorConsultarKeyTyped(evt);
            }
        });

        jBConsultarInventario1.setText("Consultar");
        jBConsultarInventario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarInventario1ActionPerformed(evt);
            }
        });

        jLabel112.setText("RUC");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBConsultarInventario1)
                .addGap(96, 96, 96))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jTProveedorConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTProveedorConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBConsultarInventario1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTablaProveedoresConsultar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane14.setViewportView(jTablaProveedoresConsultar);

        javax.swing.GroupLayout jPPCLayout = new javax.swing.GroupLayout(jPPC);
        jPPC.setLayout(jPPCLayout);
        jPPCLayout.setHorizontalGroup(
            jPPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPCLayout.createSequentialGroup()
                .addGroup(jPPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPCLayout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPPCLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPPCLayout.setVerticalGroup(
            jPPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPCLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jPGP.addTab("Consultar", jPPC);

        JPProovedores.add(jPGP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1030, 600));

        panelContent.add(JPProovedores, "card3");

        JPFyV.setBackground(new java.awt.Color(245, 245, 245));
        JPFyV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Facturación y Venta");
        JPFyV.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTableHistorialFacturas.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableHistorialFacturas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableHistorialFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHistorialFacturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHistorialFacturas);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar Historial de Facturas"));

        jTFAtributoC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFAtributoCKeyTyped(evt);
            }
        });

        jButton9.setText("Consultar");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        SeleccionFacturaAtributo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Número de factura", "Fecha", "Número de cédula", "Pasaporte", "RUC", "Estado", "Estado de pago", "Nombres del cliente", "Apellidos del cliente" }));
        SeleccionFacturaAtributo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionFacturaAtributoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(SeleccionFacturaAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTFAtributoC, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jButton9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFAtributoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeleccionFacturaAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
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
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(433, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Cambiar estado de la factura", jPanel28);

        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPDatosFactura1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Proforma"));

        jLabel72.setText("Número de la proforma");

        jTFnumerofactura1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFnumerofactura1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFnumerofactura1KeyTyped(evt);
            }
        });

        jLabel86.setText("Fecha de emision");

        jDateChooserFecha1.setDateFormatString("dd-MM-yyyy");

        errorP5.setForeground(new java.awt.Color(255, 102, 102));
        errorP5.setText("*Vacio");

        javax.swing.GroupLayout jPDatosFactura1Layout = new javax.swing.GroupLayout(jPDatosFactura1);
        jPDatosFactura1.setLayout(jPDatosFactura1Layout);
        jPDatosFactura1Layout.setHorizontalGroup(
            jPDatosFactura1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosFactura1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPDatosFactura1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosFactura1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel86)
                        .addComponent(jLabel72)
                        .addComponent(jTFnumerofactura1)
                        .addComponent(jDateChooserFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(errorP5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPDatosFactura1Layout.setVerticalGroup(
            jPDatosFactura1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosFactura1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFnumerofactura1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel86)
                .addGap(12, 12, 12)
                .addComponent(jDateChooserFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorP5)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel30.add(jPDatosFactura1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 200, 190));

        jPDatosNegocio1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del negocio"));

        jLabel91.setText("Nombre del negocio");

        jTFNombreNegocio1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFNombreNegocio1FocusLost(evt);
            }
        });
        jTFNombreNegocio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFNombreNegocio1KeyReleased(evt);
            }
        });

        jLabel92.setText("RUC del negocio");

        jTFRUCNegocio1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFRUCNegocio1FocusLost(evt);
            }
        });
        jTFRUCNegocio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFRUCNegocio1KeyReleased(evt);
            }
        });

        jLabel93.setText("Dirección del negocio");

        jTFDirNegocio1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFDirNegocio1FocusLost(evt);
            }
        });
        jTFDirNegocio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFDirNegocio1KeyReleased(evt);
            }
        });

        jLabel94.setText("Teléfono del negocio    ");

        jTFTelefonoNegocio1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFTelefonoNegocio1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFTelefonoNegocio1FocusLost(evt);
            }
        });
        jTFTelefonoNegocio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFTelefonoNegocio1KeyReleased(evt);
            }
        });

        errorP1.setForeground(new java.awt.Color(255, 102, 102));
        errorP1.setText("*Nombre erroneo");

        errorP2.setForeground(new java.awt.Color(255, 102, 102));
        errorP2.setText("*Ruc erroneo");

        errorP3.setForeground(new java.awt.Color(255, 102, 102));
        errorP3.setText("*Dirección erronea");

        errorP4.setForeground(new java.awt.Color(255, 102, 102));
        errorP4.setText("*Fomato: 02-123456");

        javax.swing.GroupLayout jPDatosNegocio1Layout = new javax.swing.GroupLayout(jPDatosNegocio1);
        jPDatosNegocio1.setLayout(jPDatosNegocio1Layout);
        jPDatosNegocio1Layout.setHorizontalGroup(
            jPDatosNegocio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosNegocio1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDatosNegocio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosNegocio1Layout.createSequentialGroup()
                        .addComponent(jLabel93)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(errorP3))
                    .addGroup(jPDatosNegocio1Layout.createSequentialGroup()
                        .addComponent(jLabel94)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorP4))
                    .addGroup(jPDatosNegocio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTFRUCNegocio1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPDatosNegocio1Layout.createSequentialGroup()
                            .addComponent(jLabel92)
                            .addGap(39, 39, 39)
                            .addComponent(errorP2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPDatosNegocio1Layout.createSequentialGroup()
                            .addComponent(jLabel91)
                            .addGap(18, 18, 18)
                            .addComponent(errorP1))
                        .addComponent(jTFNombreNegocio1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTFTelefonoNegocio1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTFDirNegocio1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPDatosNegocio1Layout.setVerticalGroup(
            jPDatosNegocio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosNegocio1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDatosNegocio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91)
                    .addComponent(errorP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFNombreNegocio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPDatosNegocio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(errorP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFRUCNegocio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPDatosNegocio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(errorP3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFDirNegocio1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPDatosNegocio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(errorP4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFTelefonoNegocio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel30.add(jPDatosNegocio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 300, 260));

        jPDatosCliente1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));

        jLabel95.setText("Nombres");

        jTNombreCliente1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTNombreCliente1FocusLost(evt);
            }
        });
        jTNombreCliente1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreCliente1KeyReleased(evt);
            }
        });

        jLabel96.setText("Teléfono movil");

        jTTelefonoCliente1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTTelefonoCliente1FocusLost(evt);
            }
        });
        jTTelefonoCliente1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTTelefonoCliente1KeyReleased(evt);
            }
        });

        jLCITipoCliente1.setText("Documento");

        jTCIDelCliente1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCIDelCliente1FocusLost(evt);
            }
        });
        jTCIDelCliente1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCIDelCliente1KeyReleased(evt);
            }
        });

        jLabel97.setText("Dirección");

        jTDireccionCliente1.setText("San Juan");
        jTDireccionCliente1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTDireccionCliente1FocusLost(evt);
            }
        });

        jCBSeleccionTipoCliente1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de cliente", "Nacional", "Extranjero" }));
        jCBSeleccionTipoCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBSeleccionTipoCliente1ActionPerformed(evt);
            }
        });

        jLabel98.setText("Apellidos:");

        jTFApeliidosCliente1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFApeliidosCliente1FocusLost(evt);
            }
        });
        jTFApeliidosCliente1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFApeliidosCliente1KeyReleased(evt);
            }
        });

        jBRegistrarFactura1.setText("Registrar Datos Basicos");
        jBRegistrarFactura1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarFactura1ActionPerformed(evt);
            }
        });

        jLabel99.setText("Correo");

        correoCli1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                correoCli1FocusLost(evt);
            }
        });

        jCBNaturalOJuridico1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Natural o Juridico", "Natural", "Jurídico" }));
        jCBNaturalOJuridico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBNaturalOJuridico1ActionPerformed(evt);
            }
        });

        errorP7.setForeground(new java.awt.Color(255, 102, 102));
        errorP7.setText("*error");

        errorP8.setForeground(new java.awt.Color(255, 102, 102));
        errorP8.setText("*Nombre erroneo");

        errorP9.setForeground(new java.awt.Color(255, 102, 102));
        errorP9.setText("*Apellido erroneo");

        errorP10.setForeground(new java.awt.Color(255, 102, 102));
        errorP10.setText("*error");

        errorP11.setForeground(new java.awt.Color(255, 102, 102));
        errorP11.setText("*Dirección inválida");

        errorP12.setForeground(new java.awt.Color(255, 102, 102));
        errorP12.setText("*Correo inválido");

        javax.swing.GroupLayout jPDatosCliente1Layout = new javax.swing.GroupLayout(jPDatosCliente1);
        jPDatosCliente1.setLayout(jPDatosCliente1Layout);
        jPDatosCliente1Layout.setHorizontalGroup(
            jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosCliente1Layout.createSequentialGroup()
                .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosCliente1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPDatosCliente1Layout.createSequentialGroup()
                                .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel97)
                                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTDireccionCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(correoCli1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errorP11)
                                    .addComponent(errorP12)))
                            .addGroup(jPDatosCliente1Layout.createSequentialGroup()
                                .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPDatosCliente1Layout.createSequentialGroup()
                                        .addComponent(jLabel96)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTTelefonoCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                                    .addGroup(jPDatosCliente1Layout.createSequentialGroup()
                                        .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel95)
                                            .addComponent(jLabel98)
                                            .addComponent(jLCITipoCliente1))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTNombreCliente1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                            .addComponent(jTCIDelCliente1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTFApeliidosCliente1)))
                                    .addGroup(jPDatosCliente1Layout.createSequentialGroup()
                                        .addComponent(jCBSeleccionTipoCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCBNaturalOJuridico1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errorP7)
                                    .addComponent(errorP8)
                                    .addComponent(errorP9)
                                    .addComponent(errorP10)))))
                    .addGroup(jPDatosCliente1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jBRegistrarFactura1)))
                .addGap(100, 132, Short.MAX_VALUE))
        );
        jPDatosCliente1Layout.setVerticalGroup(
            jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosCliente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBSeleccionTipoCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBNaturalOJuridico1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosCliente1Layout.createSequentialGroup()
                        .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLCITipoCliente1)
                            .addComponent(jTCIDelCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel95)
                            .addComponent(jTNombreCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorP8)))
                    .addComponent(errorP7))
                .addGap(18, 18, 18)
                .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosCliente1Layout.createSequentialGroup()
                        .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel98)
                            .addComponent(jTFApeliidosCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel96)
                            .addComponent(jTTelefonoCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorP10)))
                    .addComponent(errorP9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPDatosCliente1Layout.createSequentialGroup()
                        .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel97)
                            .addComponent(jTDireccionCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorP11))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel99))
                    .addGroup(jPDatosCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(correoCli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(errorP12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBRegistrarFactura1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel30.add(jPDatosCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 550, 270));

        jPProducto1.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        jLabel100.setText("ID del ítem");

        iDProcutoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                iDProcutoPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                iDProcutoPKeyTyped(evt);
            }
        });

        jLabel101.setText("cantidad");

        cantidadProforma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadProformaKeyTyped(evt);
            }
        });

        jBAgregarProducto1.setText("Agregar Producto");
        jBAgregarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarProducto1ActionPerformed(evt);
            }
        });

        jBQuitarProducto1.setText("Quitar");
        jBQuitarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitarProducto1ActionPerformed(evt);
            }
        });

        jLabel88.setText("Nombre del ítem");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel105.setText("1/8 de Galón");

        javax.swing.GroupLayout jPProducto1Layout = new javax.swing.GroupLayout(jPProducto1);
        jPProducto1.setLayout(jPProducto1Layout);
        jPProducto1Layout.setHorizontalGroup(
            jPProducto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPProducto1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPProducto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel101)
                    .addGroup(jPProducto1Layout.createSequentialGroup()
                        .addComponent(jBAgregarProducto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBQuitarProducto1))
                    .addGroup(jPProducto1Layout.createSequentialGroup()
                        .addComponent(cantidadProforma, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel105))
                    .addComponent(jLabel88)
                    .addComponent(jLabel100)
                    .addGroup(jPProducto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(iDProcutoP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPProducto1Layout.setVerticalGroup(
            jPProducto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPProducto1Layout.createSequentialGroup()
                .addComponent(jLabel100)
                .addGap(5, 5, 5)
                .addComponent(iDProcutoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel88)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel101)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPProducto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadProforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPProducto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregarProducto1)
                    .addComponent(jBQuitarProducto1))
                .addGap(20, 20, 20))
        );

        jPanel30.add(jPProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 343, -1, 250));

        jLabel102.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel102.setText("Subtotal");
        jPanel30.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 326, 71, -1));

        jTFSubtotal1.setEditable(false);
        jPanel30.add(jTFSubtotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 326, 151, -1));

        jLabel103.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel103.setText("IVA (%)");
        jPanel30.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 353, -1, -1));

        IVAText1.setEditable(false);
        IVAText1.setText("12");
        jPanel30.add(IVAText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 354, 151, -1));

        jTFTotal.setEditable(false);
        jPanel30.add(jTFTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 382, 151, -1));

        jLabel104.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel104.setText("Total");
        jPanel30.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 380, -1, -1));

        jBGenerarFactura1.setText("Generar Proforma");
        jBGenerarFactura1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGenerarFactura1ActionPerformed(evt);
            }
        });
        jPanel30.add(jBGenerarFactura1, new org.netbeans.lib.awtextra.AbsoluteConstraints(901, 416, -1, -1));

        jTablaRegistrarFactura1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablaRegistrarFactura1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaRegistrarFactura1MouseClicked(evt);
            }
        });
        jScrollPane27.setViewportView(jTablaRegistrarFactura1);

        jPanel30.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 451, 811, 142));

        jCBEstadoPago1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Pendiente de Pago", "Cancelado" }));
        jCBEstadoPago1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEstadoPago1ActionPerformed(evt);
            }
        });
        jPanel30.add(jCBEstadoPago1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 160, -1));

        jLabel90.setText("Estado de Pago");
        jPanel30.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, -1));

        jLabel70.setText("$");
        jPanel30.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 329, -1, -1));

        jLabel83.setText("$");
        jPanel30.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 385, 14, -1));
        jPanel30.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 300, 1110, 10));

        errorP6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorP6.setForeground(new java.awt.Color(255, 102, 102));
        errorP6.setText("*Selecciona el estado de pago");
        jPanel30.add(errorP6, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 370, -1, -1));

        jTabbedPane1.addTab("Generar proforma", jPanel30);

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
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ganancias", jPanel22);

        JPFyV.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1150, 630));

        panelContent.add(JPFyV, "card4");

        JPEmpleados.setBackground(new java.awt.Color(245, 245, 245));
        JPEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Empleados");
        JPEmpleados.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTPEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPEmpleadosMouseClicked(evt);
            }
        });

        jPDatosEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar datos de un empleado"));

        jLabel27.setText("Nombres");

        NombreEmpleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NombreEmpleadoFocusLost(evt);
            }
        });
        NombreEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NombreEmpleadoKeyReleased(evt);
            }
        });

        jLabel28.setText("Apellidos");

        jTFApellidoEmpleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFApellidoEmpleadoFocusLost(evt);
            }
        });
        jTFApellidoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFApellidoEmpleadoKeyReleased(evt);
            }
        });

        jLabel31.setText("Número de cédula");

        CedulaEmpleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CedulaEmpleadoFocusLost(evt);
            }
        });
        CedulaEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CedulaEmpleadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CedulaEmpleadoKeyTyped(evt);
            }
        });

        jLabel47.setText("Dirección");

        Cargo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CargoFocusLost(evt);
            }
        });
        Cargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CargoKeyReleased(evt);
            }
        });

        jLabel54.setText("Fecha de nacimiento");

        jLabel57.setText("Sexo");

        SexoEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        jLabel59.setText("Teléfono convencional");

        TelefonoConvencional.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TelefonoConvencionalFocusLost(evt);
            }
        });
        TelefonoConvencional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TelefonoConvencionalKeyReleased(evt);
            }
        });

        jLabel65.setText("Teléfono personal");

        TelefonoPersonal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TelefonoPersonalFocusLost(evt);
            }
        });
        TelefonoPersonal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TelefonoPersonalKeyReleased(evt);
            }
        });

        jLabel78.setText("Correo electrónico");

        CorreoElectronico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CorreoElectronicoFocusLost(evt);
            }
        });
        CorreoElectronico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CorreoElectronicoKeyReleased(evt);
            }
        });

        BRegistrar.setText("Registrar");
        BRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRegistrarActionPerformed(evt);
            }
        });

        jLabel79.setText("Cargo");

        direccionEmpelado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                direccionEmpeladoFocusLost(evt);
            }
        });
        direccionEmpelado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                direccionEmpeladoKeyReleased(evt);
            }
        });

        FechaNacimientoEmpleado.setDateFormatString("dd-MM-yyyy");

        errorEmpleados1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorEmpleados1.setForeground(new java.awt.Color(204, 0, 51));
        errorEmpleados1.setText("*Vacio");

        jLErrorEmpleado1.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorEmpleado1.setText("*Cédula inválida");

        jLErrorEmpleado2.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorEmpleado2.setText("*Nombre inválido");

        jLErrorEmpleado3.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorEmpleado3.setText("*Apellido inválido");

        jLErrorEmpleado4.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorEmpleado4.setText("*Cargo inválido");

        jLErrorEmpleado5.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorEmpleado5.setText("*Dirección inválida");

        jLErrorEmpleado6.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorEmpleado6.setText("*Formato 02-3150640");

        jLErrorEmpleado7.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorEmpleado7.setText("*Teléfono personal");

        jLErrorEmpleado8.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorEmpleado8.setText("*Correo inválido");

        javax.swing.GroupLayout jPDatosEmpleadosLayout = new javax.swing.GroupLayout(jPDatosEmpleados);
        jPDatosEmpleados.setLayout(jPDatosEmpleadosLayout);
        jPDatosEmpleadosLayout.setHorizontalGroup(
            jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel31)
                            .addComponent(jLabel47)
                            .addComponent(jLabel79))
                        .addGap(24, 24, 24)
                        .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                                .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(NombreEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFApellidoEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CedulaEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(direccionEmpelado, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(Cargo)
                                    .addComponent(jLErrorEmpleado3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLErrorEmpleado4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(64, 64, 64)
                                .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                                        .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel54)
                                            .addComponent(jLabel57))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(SexoEmpleado, 0, 187, Short.MAX_VALUE)
                                            .addComponent(FechaNacimientoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                                        .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel59)
                                            .addComponent(jLabel65)
                                            .addComponent(jLabel78))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TelefonoConvencional)
                                            .addComponent(TelefonoPersonal)
                                            .addComponent(CorreoElectronico)
                                            .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                                                .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLErrorEmpleado8)
                                                    .addComponent(jLErrorEmpleado6)
                                                    .addComponent(jLErrorEmpleado7))
                                                .addGap(0, 74, Short.MAX_VALUE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(errorEmpleados1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLErrorEmpleado1)
                            .addComponent(jLErrorEmpleado2)
                            .addComponent(jLErrorEmpleado5)))
                    .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(BRegistrar)))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPDatosEmpleadosLayout.setVerticalGroup(
            jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(CedulaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel54))
                    .addComponent(FechaNacimientoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorEmpleados1))
                .addGap(2, 2, 2)
                .addComponent(jLErrorEmpleado1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(NombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(SexoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLErrorEmpleado2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jTFApellidoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addComponent(TelefonoConvencional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLErrorEmpleado6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(TelefonoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cargo)
                            .addComponent(jLabel79))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDatosEmpleadosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLErrorEmpleado3)
                        .addGap(39, 39, 39)
                        .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLErrorEmpleado4)
                            .addComponent(jLErrorEmpleado7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(CorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direccionEmpelado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLErrorEmpleado5)
                    .addComponent(jLErrorEmpleado8))
                .addGap(23, 23, 23)
                .addComponent(BRegistrar)
                .addContainerGap())
        );

        jTableEmpleadosAcutalizar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTableEmpleadosAcutalizar);

        javax.swing.GroupLayout jPRELayout = new javax.swing.GroupLayout(jPRE);
        jPRE.setLayout(jPRELayout);
        jPRELayout.setHorizontalGroup(
            jPRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPDatosEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jPRELayout.setVerticalGroup(
            jPRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRELayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPDatosEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTPEmpleados.addTab("Registrar", jPRE);

        jPDatosRecuperadosEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("Actualizar empleado"));

        TFNombresActualizado.setEnabled(false);

        TFApellidosActualizado.setEnabled(false);

        TFNCedulaActualizado.setEnabled(false);

        TFDireccionActualizado.setEnabled(false);
        TFDireccionActualizado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFDireccionActualizadoFocusLost(evt);
            }
        });
        TFDireccionActualizado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFDireccionActualizadoKeyReleased(evt);
            }
        });

        TFFNacimientoActualizado.setEnabled(false);

        CBSexoActualizado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        CBSexoActualizado.setEnabled(false);

        TFTConvencionalActualizado.setEnabled(false);
        TFTConvencionalActualizado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFTConvencionalActualizadoFocusLost(evt);
            }
        });
        TFTConvencionalActualizado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFTConvencionalActualizadoKeyReleased(evt);
            }
        });

        TFTPersonalActualizado.setEnabled(false);
        TFTPersonalActualizado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFTPersonalActualizadoFocusLost(evt);
            }
        });
        TFTPersonalActualizado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFTPersonalActualizadoKeyReleased(evt);
            }
        });

        TFEmailActualizado.setEnabled(false);
        TFEmailActualizado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFEmailActualizadoFocusLost(evt);
            }
        });
        TFEmailActualizado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFEmailActualizadoKeyReleased(evt);
            }
        });

        TFCargoActualizado.setEnabled(false);
        TFCargoActualizado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFCargoActualizadoFocusLost(evt);
            }
        });
        TFCargoActualizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFCargoActualizadoActionPerformed(evt);
            }
        });
        TFCargoActualizado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFCargoActualizadoKeyTyped(evt);
            }
        });

        jCCIActualizar.setSelected(true);
        jCCIActualizar.setText("Número de cédula");
        jCCIActualizar.setEnabled(false);

        jCNombreActualizar.setSelected(true);
        jCNombreActualizar.setText("Nombres");
        jCNombreActualizar.setEnabled(false);

        jCApellidoActualizar.setSelected(true);
        jCApellidoActualizar.setText("Apellidos");
        jCApellidoActualizar.setEnabled(false);

        jCDireccionActualizar.setText("Dirección");
        jCDireccionActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCDireccionActualizarActionPerformed(evt);
            }
        });

        jCCargoActualizar.setText("Cargo");
        jCCargoActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCargoActualizarActionPerformed(evt);
            }
        });

        jCFechaActualizar.setSelected(true);
        jCFechaActualizar.setText("Fecha de nacimiento");
        jCFechaActualizar.setEnabled(false);

        jCSexoActualizar.setSelected(true);
        jCSexoActualizar.setText("Sexo");
        jCSexoActualizar.setEnabled(false);

        jCTelefonoCActualizar.setText("Teléfono convencional");
        jCTelefonoCActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTelefonoCActualizarActionPerformed(evt);
            }
        });

        jCTelefonoPActualizar.setText("Teléfono personal");
        jCTelefonoPActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTelefonoPActualizarActionPerformed(evt);
            }
        });

        jCCorreoActualizar.setText("Correo");
        jCCorreoActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCorreoActualizarActionPerformed(evt);
            }
        });

        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscardor", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        jTFIBuscadorAct5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFIBuscadorAct5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFIBuscadorAct5KeyTyped(evt);
            }
        });

        documentoActualizar3.setText("Número de cédula");

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(documentoActualizar3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jTFIBuscadorAct5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFIBuscadorAct5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(documentoActualizar3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLErrorEmpleado9.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorEmpleado9.setText("*Cargo inválido");

        jLErrorEmpleado10.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorEmpleado10.setText("*Dirección inválida");

        jLErrorEmpleado11.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorEmpleado11.setText("*Formato 02-3150640");

        jLErrorEmpleado12.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorEmpleado12.setText("*Teléfono personal");

        jLErrorEmpleado13.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorEmpleado13.setText("*Correo inválido");

        javax.swing.GroupLayout jPDatosRecuperadosEmpleadosLayout = new javax.swing.GroupLayout(jPDatosRecuperadosEmpleados);
        jPDatosRecuperadosEmpleados.setLayout(jPDatosRecuperadosEmpleadosLayout);
        jPDatosRecuperadosEmpleadosLayout.setHorizontalGroup(
            jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosRecuperadosEmpleadosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPDatosRecuperadosEmpleadosLayout.createSequentialGroup()
                        .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172))
                    .addGroup(jPDatosRecuperadosEmpleadosLayout.createSequentialGroup()
                        .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCCIActualizar)
                            .addComponent(jCNombreActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCApellidoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCCargoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLErrorEmpleado9)
                            .addComponent(jCDireccionActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLErrorEmpleado10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TFNombresActualizado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFApellidosActualizado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(TFDireccionActualizado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFCargoActualizado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFNCedulaActualizado))
                        .addGap(64, 64, 64)
                        .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPDatosRecuperadosEmpleadosLayout.createSequentialGroup()
                                .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCFechaActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCSexoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CBSexoActualizado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TFFNacimientoActualizado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPDatosRecuperadosEmpleadosLayout.createSequentialGroup()
                                .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCTelefonoCActualizar)
                                    .addComponent(jCTelefonoPActualizar)
                                    .addComponent(jCCorreoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLErrorEmpleado11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFTPersonalActualizado, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TFTConvencionalActualizado)
                                    .addComponent(TFEmailActualizado, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLErrorEmpleado13)
                            .addComponent(jLErrorEmpleado12))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPDatosRecuperadosEmpleadosLayout.setVerticalGroup(
            jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosRecuperadosEmpleadosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFNCedulaActualizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFFNacimientoActualizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCCIActualizar)
                    .addComponent(jCFechaActualizar))
                .addGap(27, 27, 27)
                .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFNombresActualizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBSexoActualizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCNombreActualizar)
                    .addComponent(jCSexoActualizar))
                .addGap(24, 24, 24)
                .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFApellidosActualizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFTConvencionalActualizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCApellidoActualizar)
                    .addComponent(jCTelefonoCActualizar))
                .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosRecuperadosEmpleadosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLErrorEmpleado11)
                        .addGap(5, 5, 5)
                        .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFTPersonalActualizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCTelefonoPActualizar))
                        .addGap(8, 8, 8)
                        .addComponent(jLErrorEmpleado12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFEmailActualizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCCorreoActualizar)))
                    .addGroup(jPDatosRecuperadosEmpleadosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCDireccionActualizar)
                            .addComponent(TFDireccionActualizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLErrorEmpleado10)
                        .addGap(15, 15, 15)
                        .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFCargoActualizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCCargoActualizar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPDatosRecuperadosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLErrorEmpleado13)
                    .addComponent(jLErrorEmpleado9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jTableEmpleadosAcutalizar1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableEmpleadosAcutalizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpleadosAcutalizar1MouseClicked(evt);
            }
        });
        jScrollPane24.setViewportView(jTableEmpleadosAcutalizar1);

        BActualizar.setText("Actualizar");
        BActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPAELayout = new javax.swing.GroupLayout(jPAE);
        jPAE.setLayout(jPAELayout);
        jPAELayout.setHorizontalGroup(
            jPAELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAELayout.createSequentialGroup()
                .addGroup(jPAELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPAELayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPAELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPDatosRecuperadosEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPAELayout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(BActualizar)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPAELayout.setVerticalGroup(
            jPAELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAELayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPDatosRecuperadosEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BActualizar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTPEmpleados.addTab("Actualizar", jPAE);

        PanelFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar empleado"));

        jLabel80.setText("Filtro");

        jLabel81.setText("Buscar");

        CBConsultarEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Apellidos", "Nombres", "Teléfono convencional", "Teléfono personal", "Direccón", "Cargo", "Correo electrónico" }));

        jButton4.setText("Consultar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelFiltrosLayout = new javax.swing.GroupLayout(PanelFiltros);
        PanelFiltros.setLayout(PanelFiltrosLayout);
        PanelFiltrosLayout.setHorizontalGroup(
            PanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFiltrosLayout.createSequentialGroup()
                .addGroup(PanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFiltrosLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(PanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel81)
                            .addComponent(jLabel80))
                        .addGap(38, 38, 38)
                        .addGroup(PanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBConsultarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFConsultarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFiltrosLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jButton4)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        PanelFiltrosLayout.setVerticalGroup(
            PanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFiltrosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(CBConsultarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(PanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(TFConsultarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(17, 17, 17))
        );

        jTableEmpleadosAcutalizar2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTableEmpleadosAcutalizar2);

        PanelFiltros1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar empleado"));

        jLabel108.setText("Número de cédula");

        jButton5.setText("Consultar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelFiltros1Layout = new javax.swing.GroupLayout(PanelFiltros1);
        PanelFiltros1.setLayout(PanelFiltros1Layout);
        PanelFiltros1Layout.setHorizontalGroup(
            PanelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFiltros1Layout.createSequentialGroup()
                .addGroup(PanelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFiltros1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel108)
                        .addGap(18, 18, 18)
                        .addComponent(TFConsultarEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFiltros1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jButton5)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        PanelFiltros1Layout.setVerticalGroup(
            PanelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFiltros1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(PanelFiltros1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel108)
                    .addComponent(TFConsultarEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPCELayout = new javax.swing.GroupLayout(jPCE);
        jPCE.setLayout(jPCELayout);
        jPCELayout.setHorizontalGroup(
            jPCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCELayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(PanelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(PanelFiltros1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCELayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPCELayout.setVerticalGroup(
            jPCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCELayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelFiltros1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jTPEmpleados.addTab("Consultar", jPCE);

        jPanelEliminarEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambiar estado del empleado"));

        jLabel82.setText("Número de cédula");

        TFNCedulaBuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFNCedulaBuscar1KeyReleased(evt);
            }
        });

        BBuscarEliminar.setText("Cambiar Estado");
        BBuscarEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBuscarEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEliminarEmpleadoLayout = new javax.swing.GroupLayout(jPanelEliminarEmpleado);
        jPanelEliminarEmpleado.setLayout(jPanelEliminarEmpleadoLayout);
        jPanelEliminarEmpleadoLayout.setHorizontalGroup(
            jPanelEliminarEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEliminarEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel82)
                .addGap(18, 18, 18)
                .addGroup(jPanelEliminarEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFNCedulaBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelEliminarEmpleadoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(BBuscarEliminar)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanelEliminarEmpleadoLayout.setVerticalGroup(
            jPanelEliminarEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEliminarEmpleadoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelEliminarEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(TFNCedulaBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BBuscarEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableEmpleadosAcutalizar3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane25.setViewportView(jTableEmpleadosAcutalizar3);

        javax.swing.GroupLayout jPEELayout = new javax.swing.GroupLayout(jPEE);
        jPEE.setLayout(jPEELayout);
        jPEELayout.setHorizontalGroup(
            jPEELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEELayout.createSequentialGroup()
                .addGroup(jPEELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEELayout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jPanelEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPEELayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPEELayout.setVerticalGroup(
            jPEELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEELayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanelEliminarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(96, 96, 96)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
        );

        jTPEmpleados.addTab("Cambiar de estado", jPEE);

        javax.swing.GroupLayout jPEmpleadosTabLayout = new javax.swing.GroupLayout(jPEmpleadosTab);
        jPEmpleadosTab.setLayout(jPEmpleadosTabLayout);
        jPEmpleadosTabLayout.setHorizontalGroup(
            jPEmpleadosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEmpleadosTabLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jTPEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPEmpleadosTabLayout.setVerticalGroup(
            jPEmpleadosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEmpleadosTabLayout.createSequentialGroup()
                .addGap(0, 39, Short.MAX_VALUE)
                .addComponent(jTPEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JPEmpleados.add(jPEmpleadosTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1080, 640));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Solo Administradores");
        JPEmpleados.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));

        panelContent.add(JPEmpleados, "card5");

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

        panelContent.add(JPAdministración, "card6");

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

    }//GEN-LAST:event_menuinventarioMouseClicked

    private void menuProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProveedoresMouseClicked
        contenido.show(panelContent, "card3");
        cambiarSeccionMenu(2);
        menuProveedores.setBackground(Color.decode("#494848"));
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
        Empleados empleados = new Empleados(cnx);
        DefaultTableModel modelo = empleados.obtenerModeloTablaEmpleadosActualizar();
        jTableEmpleadosAcutalizar.setModel(modelo);
        cambiarSeccionMenu(4);
        menuEmpleados.setBackground(Color.decode("#494848"));
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
        if (cambiarSesion) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro/a que quieres salir de esta cuenta", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                JFIngresar ingresarFrame = new JFIngresar(); // Crea una instancia del JFLogin
                ingresarFrame.setVisible(true); // Muestra el JFLogin
                dispose();
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

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        JOptionPane.showMessageDialog(null, "Muy pronto se implementará el manual", "Advertencia", JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_btnHelpActionPerformed

    private void jTFIBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscadorKeyReleased
        String campo = (String) jCBACSInventario.getSelectedItem();
        String valor = jTFIBuscador.getText();
        if (valor.isEmpty()) {
            return;
        }

        switch (campo) {
            case "ID Ítem" -> {
                campo = "idItem";
            }
            case "Nombre del ítem" -> {
                campo = "nombreItem";
            }
            case "Stock" -> {
                campo = "stock";
            }
            case "Precio" -> {
                campo = "precio";
            }
        }
        DefaultTableModel modelo = ConsultarBD.consultarInventario(cnx, campo, valor);
        jTablaInventario1.setModel(modelo);
    }//GEN-LAST:event_jTFIBuscadorKeyReleased

    private void jPanel_GeneralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_GeneralMouseClicked
        int selectedTabIndex = jPanel_General.getSelectedIndex();
        switch (selectedTabIndex) {
            case 0, 1, 2, 3 -> {
                setTablaPaquetes();
            }
        }
    }//GEN-LAST:event_jPanel_GeneralMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JTextField[] campos = {jTAncho, jTLargo, jTPeso, jTRemitente};
        Boolean[] booleanItem = {anchoValidar, largoValidar, pesoValidar,remitenteValidar};
        JLabel[] labels = {errorInventario1, errorInventario2, errorInventario3,errorInventario8};
        String[] nombresCampos = {"Ancho", "Largo",
            "Peso","Remitente"};
        List<String> errores = validadorCheck.validarCamposLista(campos, booleanItem, labels, nombresCampos);
        errores.addAll(validadorCheck.validarCamposVaciosLista(campos, booleanItem, labels, nombresCampos));
        if (!errores.isEmpty()) {
            StringBuilder mensajeError = new StringBuilder("Se encontraron los siguientes errores:\n");
            for (String error : errores) {
                mensajeError.append("- ").append(error).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensajeError.toString(), "Errores", JOptionPane.ERROR_MESSAGE);
        } else {
            int idPaquete = Integer.parseInt(jTiDPaquete.getText());
            String contenidoPaquete = jTContenidoPaquete.getText();
            double ancho = Double.parseDouble(jTAncho.getText());
            double peso = Double.parseDouble(jTPeso.getText());
            double largo=Double.parseDouble(jTLargo.getText());
            String remitente = jTRemitente.getText();
            String destino = jTDestino.getText();
            IngresadorDeDatos.ingresarPaquete(cnx,idPaquete,peso,ancho,largo, contenidoPaquete,remitente,destino);
            //IngresadorDeDatos.ingresarItem(cnx, idItem, nombreItem, stock, precio, "Activo");
            jTContenidoPaquete.setText("");
            jTAncho.setText("");
            jTPeso.setText("");
            contadorProductos();
            setTablaPaquetes();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBIActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIActualizarActionPerformed
        JTextField[] camposItem = {jTFnombreItem, jTFstock, jTFPrecio};
        JLabel[] labelsItem = {errorInventario4, errorInventario5, errorInventario6};
        List<String> camposInvalidos = new ArrayList<>();
        List<String> atributos = new ArrayList<>();
        ActualizarInventario actualizar = new ActualizarInventario();
        String atributoActualizar = "idItem";
        String condicion = "'" + this.jTFiDItem.getText() + "'";
        String tabla = "item";

        if (this.jChBiDItem.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(jTFiDItem, "ID del ítem")) {
                camposInvalidos.add("ID del ítem");
            }
        }

        if (this.jChBnombreItem.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(jTFnombreItem, "Nombre del Item")) {
                camposInvalidos.add("Nombre del Item");
            }
            atributos.add("nombreItem='" + jTFnombreItem.getText() + "'");
        }
        if (this.jChBstock.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(jTFstock, "Stock")) {
                camposInvalidos.add("Stock");
            }
            atributos.add("stock=" + jTFstock.getText());
        }
        if (this.jChBprecio.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(jTFPrecio, "Precio")) {
                camposInvalidos.add("Precio");
            }
            atributos.add("precio=" + jTFPrecio.getText());
        }
        if (atributos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione al menos un atributo", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detiene el registro si no se selecciona ningún atributo
        }
        if (!camposInvalidos.isEmpty()) {
            String camposInvalidosStr = String.join(", ", camposInvalidos);
            JOptionPane.showMessageDialog(this, "Los siguientes campos están vacíos: " + camposInvalidosStr, "Error", JOptionPane.ERROR_MESSAGE);

            // Pinta de rojo los campos vacíos de forma parametrizada
            for (String campoInvalido : camposInvalidos) {
                switch (campoInvalido) {
                    case "ID del ítem":
                        validadorCheck.setColorFondoCampo(jTFnombreItem, new Color(255, 204, 204), errorInventario7);
                        break;
                    case "Nombre del Item":
                        validadorCheck.setColorFondoCampo(jTFnombreItem, new Color(255, 204, 204), errorInventario4);
                        break;
                    case "Stock":
                        validadorCheck.setColorFondoCampo(jTFstock, new Color(255, 204, 204), errorInventario5);
                        break;
                    case "Precio":
                        validadorCheck.setColorFondoCampo(jTFPrecio, new Color(255, 204, 204), errorInventario6);
                        break;
                    // Puedes agregar más casos aquí para otros campos si es necesario
                }
            }
            return; // Detiene el registro si hay campos inválidos
        }
        String atributosActualizacion = String.join(", ", atributos);
        if (!stockValidar1 && !nombreItemValidar1 && !precioUValidar1) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar actualizar. "
                    + "\nPor favor, verifica los campos e inténtalo nuevamente.", "Error en el registro", JOptionPane.ERROR_MESSAGE);
        } else {
            actualizar.actualizarDatosF(this.cnx, atributoActualizar, condicion, tabla, atributosActualizacion);
            setTablaPaquetes();
        }
    }//GEN-LAST:event_jBIActualizarActionPerformed

    private void jBConsultarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarInventarioActionPerformed
        String campo = (String) jCBIConsultar.getSelectedItem();
        String valor = jTFCInventario.getText();
        if (campo.equals("Selecciona")) {
            JOptionPane.showMessageDialog(this, "Selecciona el campo por el \ncual vas a relizar la busqueda", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (valor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa un valor", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        switch (campo) {
            case "ID Ítem" -> {
                campo = "idItem";
            }
            case "Nombre del ítem" -> {
                campo = "nombreItem";
            }
            case "Stock" -> {
                campo = "stock";
            }
            case "Precio" -> {
                campo = "precio";
            }
            case "Estado" -> {
                campo = "estado";
            }
        }
        DefaultTableModel modelo = ConsultarBD.consultarInventario(cnx, campo, valor);
        jTablaInventario2.setModel(modelo);

    }//GEN-LAST:event_jBConsultarInventarioActionPerformed

    private void jBCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCambiarEstadoActionPerformed
        String idItemStr = jTFidItemDar.getText();

        if (idItemStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa un ID de elemento para cambiar su estado.");
            return;
        }

        int idItem;
        try {
            idItem = Integer.parseInt(idItemStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID de elemento no válido.");
            return;
        }

        String estadoActual = obtenerEstadoElementoDesdeBD(idItem);
        int respuesta;
        if ("Retirado".equals(estadoActual)) {
            respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas cambiar el estado a 'Activo'?", "Confirmar Cambio de Estado", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                ActualizarInventario.darDeAltaElemento(cnx, idItem);
                DefaultTableModel modelo = ConsultarBD.buscarElementoPorId(cnx, idItemStr);
                jTablaInventario3.setModel(modelo);
            }
        } else if ("Activo".equals(estadoActual)) {
            respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas cambiar el estado a 'Retirado'?", "Confirmar Cambio de Estado", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                ActualizarInventario.darDeBajaElemento(cnx, idItem);
                DefaultTableModel modelo = ConsultarBD.buscarElementoPorId(cnx, idItemStr);
                jTablaInventario3.setModel(modelo);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Producto no registrado.");
        }
    }//GEN-LAST:event_jBCambiarEstadoActionPerformed

    private void jTFidItemDarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFidItemDarKeyReleased
        String idItemStr = jTFidItemDar.getText();
        // Limpia la tabla si el campo de texto está vacío
        if (idItemStr.isEmpty()) {
            setTablaPaquetes();
            return;
        }
        // Realiza la búsqueda y actualiza la tabla
        DefaultTableModel modelo = ConsultarBD.buscarElementoPorId(cnx, idItemStr);
        jTablaInventario3.setModel(modelo);
    }//GEN-LAST:event_jTFidItemDarKeyReleased

    private void jTablaInventario1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaInventario1MouseClicked
        int filaSeleccionada = jTablaInventario1.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) jTablaInventario1.getModel();
            String idItem = modelo.getValueAt(filaSeleccionada, 0).toString();
            String nombreItem = modelo.getValueAt(filaSeleccionada, 1).toString();
            String stock = modelo.getValueAt(filaSeleccionada, 2).toString();
            String precio = modelo.getValueAt(filaSeleccionada, 3).toString();
            jTFiDItem.setText(idItem);
            jTFiDItem.setBackground(Color.white);
            errorInventario7.setVisible(false);
            validadorCheck.actualizarCampoSeleccionado(jChBnombreItem, nombreItem, jTFnombreItem, errorInventario4);
            validadorCheck.actualizarCampoSeleccionado(jChBstock, stock, jTFstock, errorInventario5);
            validadorCheck.actualizarCampoSeleccionado(jChBprecio, precio, jTFPrecio, errorInventario6);
            Boolean[] valoresItem = {nombreItemValidar1, stockValidar1, precioUValidar1};
            valoresItem = validadorCheck.cambiarValoresVerdadFinal(valoresItem);
            nombreItemValidar1 = valoresItem[0];
            stockValidar1 = valoresItem[1];
            precioUValidar1 = valoresItem[2];
        }
    }//GEN-LAST:event_jTablaInventario1MouseClicked

    private void jTFCInventarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCInventarioKeyTyped
        String campo = (String) jCBIConsultar.getSelectedItem();
        char c = evt.getKeyChar();
        // Verificar si el carácter es la tecla Backspace (\b)
        if (c == '\b') {
            return; // Permitir el evento si es la tecla Backspace
        }
        switch (campo) {
            case "idItem", "stock" -> {
                if (!Character.isDigit(c)) {
                    evt.consume(); // Cancelar el evento si no es un número
                    JOptionPane.showMessageDialog(null, "Ingresa solo números enteros en este campo.");
                }
            }
            case "nombreItem", "estado" -> {
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    evt.consume(); // Cancelar el evento si no es una letra o un espacio
                    JOptionPane.showMessageDialog(null, "Ingresa solo letras en este campo.");
                }
            }
            case "precio" -> {
                if (!Character.isDigit(c) && c != KeyEvent.VK_PERIOD) {
                    evt.consume(); // Cancelar el evento si no es un número
                    JOptionPane.showMessageDialog(null, "Ingresa solo números.");
                } else {
                    String nuevoTexto = jTFCInventario.getText() + c;
                    if (c == KeyEvent.VK_PERIOD && nuevoTexto.indexOf('.') != nuevoTexto.lastIndexOf('.')) {
                        evt.consume(); // Cancelar el evento si se ingresan múltiples puntos decimales
                    } else if (!validarRegistroF.validarMaximoDosDecimales(nuevoTexto)) {
                        evt.consume(); // Cancelar el evento si se ingresan más de dos decimales
                        JOptionPane.showMessageDialog(null, "El valor solo puede tener hasta dos decimales.");
                    }
                }
            }
            default -> {
            }
        }
    }//GEN-LAST:event_jTFCInventarioKeyTyped

    private void jCBIConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBIConsultarActionPerformed
        jTFCInventario.setText("");
    }//GEN-LAST:event_jCBIConsultarActionPerformed

    private void jCBACSInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBACSInventarioActionPerformed
        jTFIBuscador.setText("");
    }//GEN-LAST:event_jCBACSInventarioActionPerformed

    private void jTFIBuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscadorKeyTyped
        String campo = (String) jCBACSInventario.getSelectedItem();
        char c = evt.getKeyChar();

        // Verificar si el carácter es la tecla Backspace (\b)
        if (c == '\b') {
            return; // Permitir el evento si es la tecla Backspace
        }

        switch (campo) {
            case "ID Ítem", "Stock" -> {
                if (!Character.isDigit(c)) {
                    evt.consume(); // Cancelar el evento si no es un número
                    JOptionPane.showMessageDialog(null, "Ingresa solo números enteros en este campo.");
                }
            }
            case "Nombre del ítem" -> {
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    evt.consume(); // Cancelar el evento si no es una letra o un espacio
                    JOptionPane.showMessageDialog(null, "Ingresa solo letras en este campo.");
                }
            }
            case "Precio" -> {
                if (!Character.isDigit(c) && c != KeyEvent.VK_PERIOD) {
                    evt.consume(); // Cancelar el evento si no es un número
                    JOptionPane.showMessageDialog(null, "Ingresa solo números.");
                } else {
                    String nuevoTexto = jTFIBuscador.getText() + c;
                    if (c == KeyEvent.VK_PERIOD && nuevoTexto.indexOf('.') != nuevoTexto.lastIndexOf('.')) {
                        evt.consume(); // Cancelar el evento si se ingresan múltiples puntos decimales
                    } else if (!validarRegistroF.validarMaximoDosDecimales(nuevoTexto)) {
                        evt.consume(); // Cancelar el evento si se ingresan más de dos decimales
                        JOptionPane.showMessageDialog(null, "El valor solo puede tener hasta dos decimales.");
                    }
                }
            }
            default -> {
                evt.consume();
            }
        }
    }//GEN-LAST:event_jTFIBuscadorKeyTyped

    private void jTFnombreItemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFnombreItemKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "No se permiten valores numéricos en el campo Nombre.");
            jTFnombreItem.requestFocus();
        }
    }//GEN-LAST:event_jTFnombreItemKeyTyped

    private void jTFstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFstockKeyTyped
        //String campo = jTFstock.getText();
        char c = evt.getKeyChar();
        if (c == '\b') {
            return; // Permitir el evento si es la tecla Backspace
        }
        if (!Character.isDigit(c)) {
            evt.consume(); // Cancelar el evento si no es un número
            JOptionPane.showMessageDialog(null, "Ingresa solo números enteros en este campo.");
        }
    }//GEN-LAST:event_jTFstockKeyTyped

    private void jTFPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrecioKeyTyped
        char c = evt.getKeyChar();
        if (c == '\b') {
            return; // Permitir el evento si es la tecla Backspace
        }
        String nuevoTexto = jTFPrecio.getText() + c;
        if (!Character.isDigit(c) && c != KeyEvent.VK_PERIOD) {
            evt.consume(); // Cancelar el evento si no es un número
            JOptionPane.showMessageDialog(null, "Ingresa solo números.");
        } else if (c == KeyEvent.VK_PERIOD && nuevoTexto.indexOf('.') != nuevoTexto.lastIndexOf('.')) {
            evt.consume(); // Cancelar el evento si se ingresan múltiples puntos decimales
        } else if (!validarRegistroF.validarMaximoDosDecimales(nuevoTexto)) {
            evt.consume(); // Cancelar el evento si se ingresan más de dos decimales
            JOptionPane.showMessageDialog(null, "El valor solo puede tener hasta dos decimales.");
        }
    }//GEN-LAST:event_jTFPrecioKeyTyped

    private void limpiarCamposProve1() {
        JTextField[] campos = {jTRUCAct, jTNombreEmpresaAct, jTCedulaDespachadorAct, jTNombreDespachadorAct,
            jTApellidoDespachadorAct, jTATelefonoDespachador, jTCodigoProducto1, jTNombreProducto1};
        for (int i = 0; i < campos.length; i++) {
            JTextField campo = campos[i];
            campo.setText("");
        }
    }


    private void jBRegistrarProovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarProovedorActionPerformed
        JTextField[] campos = {jTRUC, jTNombreEmpresa, jTCedulaDespachador, jTNombreDespachador,
            jTApellidoDespachador, jTFTelefonoProvedor};
        JLabel[] labels = {errorProveedores1, errorProveedores2, errorProveedores3,
            errorProveedores4, errorProveedores5, errorProveedores6};
        Proveedores prov = new Proveedores();
        String ciDespachador = jTCedulaDespachador.getText();
        Boolean[] boleannosProvedores = {rucProve, nombreEmpresaProve, cedulaProve,
            nombreProve, apellidoProve, telefonoProve};
        String[] nombresCampos = {"RUC", "nombre de la empresa",
            "número de cédula del despachador", "nombre del despachador",
            "apellido del despachador", "teléfono del despachador"};
        List<String> errores = validadorCheck.validarCamposLista(campos, boleannosProvedores, labels, nombresCampos);
        errores.addAll(validadorCheck.validarCamposVaciosLista(campos, boleannosProvedores, labels, nombresCampos));

        if (!errores.isEmpty()) {
            StringBuilder mensajeError = new StringBuilder("Se encontraron los siguientes errores:\n");
            for (String error : errores) {
                mensajeError.append("- ").append(error).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensajeError.toString(), "Errores", JOptionPane.ERROR_MESSAGE);
        } else {
            if (prov.existeDespachador(cnx, ciDespachador)) {
                JOptionPane.showMessageDialog(null, "El despachador con cédula " + ciDespachador + " ya existe en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String idProveedor = jTRUC.getText();
                String nombreEmpresa = jTNombreEmpresa.getText();
                int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de ingresar estos datos?",
                        "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    prov.ingresarDatoProveedor(cnx, idProveedor, nombreEmpresa);
                    prov.ingresarDatoDespachador(cnx, ciDespachador,
                            jTNombreDespachador.getText(), jTApellidoDespachador.getText(),
                            idProveedor, jTFTelefonoProvedor.getText());
                    DefaultTableModel modelo = prov.mostrarListaP(cnx, idProveedor);
                    jTablaProveedoresR.setModel(modelo);
                    jBRegistrarProovedor.setEnabled(false);
                    jBAgregarProductoProveedores.setEnabled(true);
                    jBQuitarProductoProveedores.setEnabled(true);
                    jButton8.setEnabled(true);
                }
            }
        }

    }//GEN-LAST:event_jBRegistrarProovedorActionPerformed

    private void jTRUCCEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTRUCCEKeyReleased
        String ruc = jTRUCCE.getText();
        Proveedores prov = new Proveedores();

        DefaultTableModel model = prov.buscarProveedor(cnx, ruc);
        jTablaProveedoresCE.setModel(model);
    }//GEN-LAST:event_jTRUCCEKeyReleased

    private void jTRUCCEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTRUCCEKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTRUCCEKeyTyped

    private void jBCambiarEstadoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCambiarEstadoProveedorActionPerformed
        String ruc = jTRUCCE.getText();
        if (ruc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor");
            return;
        }
        Proveedores prov = new Proveedores();
        String mensaje = prov.cambiarEstadoProveedor(cnx, ruc);
        JOptionPane.showMessageDialog(null, mensaje);
        DefaultTableModel model = prov.buscarProveedor(cnx, ruc);
        jTablaProveedoresCE.setModel(model);
    }//GEN-LAST:event_jBCambiarEstadoProveedorActionPerformed

    private void jTablaProveedoresAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaProveedoresAMouseClicked
        int filaSeleccionada = jTablaProveedoresA.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel model = (DefaultTableModel) jTablaProveedoresA.getModel();
            boolean foundColumn = false;

            // Recorre todas las columnas del modelo
            for (int i = 0; i < model.getColumnCount(); i++) {
                String columnName = model.getColumnName(i);
                if (columnName.equals("RUC del proveedor")
                        || columnName.equals("Empresa") || columnName.equals("CI Despachador")
                        || columnName.equals("Nombre Despachador")
                        || columnName.equals("Apellido Despachador") || columnName.equals("Número de Teléfono")) {
                    String NRuc = getValueAtSelectedRow(model, filaSeleccionada, "RUC del proveedor");
                    String NEmpresa = getValueAtSelectedRow(model, filaSeleccionada, "Empresa");
                    String ciDespachador = getValueAtSelectedRow(model, filaSeleccionada, "CI Despachador");
                    String nombreDespachador = getValueAtSelectedRow(model, filaSeleccionada, "Nombre Despachador");
                    String apellidoDespachador = getValueAtSelectedRow(model, filaSeleccionada, "Apellido Despachador");
                    String numeroDespachador = getValueAtSelectedRow(model, filaSeleccionada, "Número de Teléfono");

                    jTRUCAct.setText(NRuc);
                    if (jCheckBox2.isSelected()) {
                        jTNombreEmpresaAct.setText(NEmpresa);
                    } else {
                        nombreEmpresaProve1 = true;
                    }
                    if (jCheckBox8.isSelected()) {
                        jTATelefonoDespachador.setText(numeroDespachador);
                    } else {
                        telefonoProve1 = true;
                    }
                    jTCedulaDespachadorAct.setText(ciDespachador);
                    jTNombreDespachadorAct.setText(nombreDespachador);
                    jTApellidoDespachadorAct.setText(apellidoDespachador);
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
    }//GEN-LAST:event_jTablaProveedoresAMouseClicked

    private void jTNombreEmpresaActKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreEmpresaActKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNombreEmpresaActKeyTyped

    private void jBIActualizarActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIActualizarActActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Desea finalizar la actualización?", "Finalizar Actualización", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            limpiarCamposProve1();
            jBAgregarProductoProveedores1.setEnabled(false);
            jBQuitarProductoProveedores1.setEnabled(false);
            jButton2.setEnabled(true);
            jBIActualizarAct.setEnabled(false);

        }

    }//GEN-LAST:event_jBIActualizarActActionPerformed

    private void jTFIBuscarRUCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscarRUCKeyReleased
        String NRUC = jTFIBuscarRUC.getText();
        Proveedores prov = new Proveedores();
        DefaultTableModel modelo = prov.mostrarListaParcial(cnx, NRUC);
        jTablaProveedoresA.setModel(modelo);
    }//GEN-LAST:event_jTFIBuscarRUCKeyReleased

    private void jTFIBuscarRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscarRUCKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIBuscarRUCKeyTyped

    private void jTProveedorConsultarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProveedorConsultarKeyTyped
        //rucProve = validarDocumentos(jTRUC);
        String NRUC = jTFIBuscarRUC.getText();
        Proveedores prov = new Proveedores();
        DefaultTableModel modelo = prov.mostrarListaP(cnx, NRUC);
        jTablaProveedoresA.setModel(modelo);
    }//GEN-LAST:event_jTProveedorConsultarKeyTyped

    private void jBConsultarInventario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarInventario1ActionPerformed
        String NRUC = jTProveedorConsultar.getText();
        if (NRUC.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor");
        } else {
            Proveedores prov = new Proveedores();
            DefaultTableModel modelo = prov.mostrarListaProv(cnx, NRUC);
            jTablaProveedoresConsultar.setModel(modelo);
        }
    }//GEN-LAST:event_jBConsultarInventario1ActionPerformed

    private void jBConsultarInventario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarInventario2ActionPerformed
        if (jTProveedorConsultar1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor");
            return;
        }
        String idCliente = jTProveedorConsultar1.getText();
        String esExtranjero = (String) jCBNacionalExtranjero3.getSelectedItem();
        String tipo = (String) jCJuridicoNatural2.getSelectedItem();

        if (esExtranjero.equals("Selecciona")) {
            esExtranjero = "";
        }
        if (tipo.equals("")) {
            tipo = "";
        }

        CreadorTablas tablas = new CreadorTablas();
        DefaultTableModel modelo = tablas.mostrarTipoCliente(cnx, esExtranjero, tipo, idCliente);
        jTablaProveedoresConsultar1.setModel(modelo);

    }//GEN-LAST:event_jBConsultarInventario2ActionPerformed

    private void jTProveedorConsultar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProveedorConsultar1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTProveedorConsultar1KeyTyped

    private void jTFIBuscadorAct1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscadorAct1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIBuscadorAct1KeyTyped

    private void jTFIBuscadorAct1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscadorAct1KeyReleased
        String filtroIdCliente = jTFIBuscadorAct1.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarClienteParametrizado(cnx, filtroIdCliente, "N");
        tablaActualizarCliente.setModel(modelo);
    }//GEN-LAST:event_jTFIBuscadorAct1KeyReleased

    private void jBIActualizarAct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIActualizarAct1ActionPerformed
        List<String> camposInvalidos = new ArrayList<>();
        List<String> atributos = new ArrayList<>();
        ActualizarInventario actualizar = new ActualizarInventario();
        String atributoActualizar = "idCliente";
        String condicion = "'" + this.ciActualizar.getText() + "'";
        String tabla = "cliente";
        if (this.CIselect.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(ciActualizar, "CI del cliente")) {
                camposInvalidos.add("CI del cliente");
            }
        }

        if (this.nombreSelect.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(nombreActualizar, "Nombre del cliente")) {
                camposInvalidos.add("Nombre del cliente");
            }
            atributos.add("nombres='" + nombreActualizar.getText() + "'");
        }

        if (this.apellidoSelect.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(apellidoActualizar, "Apellido del cliente")) {
                camposInvalidos.add("Apellido del cliente");
            }
            atributos.add("apellidos='" + apellidoActualizar.getText() + "'");
        }

        if (this.telefonoSelect.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(telefonoActualizar, "Teléfono del cliente")) {
                camposInvalidos.add("Teléfono del cliente");
            }
            atributos.add("telefonoCliente='" + telefonoActualizar.getText() + "'");
        }

        if (this.direccionSelect.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(direccionActualizar, "Dirección del cliente")) {
                camposInvalidos.add("Dirección del cliente");
            }
            atributos.add("direccionCliente='" + direccionActualizar.getText() + "'");
        }

        if (this.correoSelect.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(correoActualizar, "Correo del cliente")) {
                camposInvalidos.add("Correo del cliente");
            }
            atributos.add("correoElectronicoCliente='" + correoActualizar.getText() + "'");
        }

        if (!correoSelect.isSelected() && !direccionSelect.isSelected() && !telefonoSelect.isSelected()) {
            JOptionPane.showMessageDialog(this, "Seleccione al menos un atributo a actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detiene el registro si no se selecciona ningún atributo
        }

        if (!camposInvalidos.isEmpty()) {
            String camposInvalidosStr = String.join(", ", camposInvalidos);
            JOptionPane.showMessageDialog(this, "Los siguientes campos están vacíos: " + camposInvalidosStr, "Error", JOptionPane.ERROR_MESSAGE);

            // Pinta de rojo los campos vacíos de forma parametrizada
            for (String campoInvalido : camposInvalidos) {
                switch (campoInvalido) {
                    case "CI del cliente":
                        validadorCheck.setColorFondoCampo(ciActualizar, new Color(255, 204, 204), errorActualizarCliente4);
                        break;
                    case "Nombre del cliente":
                        validadorCheck.setColorFondoCampo(nombreActualizar, new Color(255, 204, 204), errorActualizarCliente5);
                        break;
                    case "Apellido del cliente":
                        validadorCheck.setColorFondoCampo(apellidoActualizar, new Color(255, 204, 204), errorActualizarCliente6);
                        break;
                    case "Teléfono del cliente":
                        validadorCheck.setColorFondoCampo(telefonoActualizar, new Color(255, 204, 204), errorActualizarCliente1);
                        break;
                    case "Dirección del cliente":
                        validadorCheck.setColorFondoCampo(direccionActualizar, new Color(255, 204, 204), errorActualizarCliente2);
                        break;
                    case "Correo del cliente":
                        validadorCheck.setColorFondoCampo(correoActualizar, new Color(255, 204, 204), errorActualizarCliente3);
                        break;

                    // Puedes agregar más casos aquí para otros campos si es necesario
                }
            }
            return; // Detiene el registro si hay campos inválidos
        }
        String atributosActualizacion = String.join(", ", atributos);
        if (!telfCliente1 && !dirCliente1 && !correoElectronico1) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar actualizar. "
                    + "\nPor favor, verifica los campos e inténtalo nuevamente.", "Error en el registro", JOptionPane.ERROR_MESSAGE);
        } else {
            actualizar.actualizarDatosF(this.cnx, atributoActualizar, condicion, tabla, atributosActualizacion);
            String filtroIdCliente = jTFIBuscadorAct1.getText();
            CreadorTablas creadorTablas = new CreadorTablas();
            DefaultTableModel modelo = creadorTablas.mostrarClienteParametrizado(cnx, filtroIdCliente, "N");
            tablaActualizarCliente.setModel(modelo);
            JTextField[] camposParaLimpiar = {ciActualizar, nombreActualizar, apellidoActualizar, telefonoActualizar, direccionActualizar, correoActualizar};
            validadorCheck.limpiarCampos(camposParaLimpiar);
        }
    }//GEN-LAST:event_jBIActualizarAct1ActionPerformed

    private void tablaActualizarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaActualizarClienteMouseClicked
        int filaSeleccionada = tablaActualizarCliente.getSelectedRow();
        boolean foundColumn = false;
        if (filaSeleccionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tablaActualizarCliente.getModel();
            for (int i = 0; i < model.getColumnCount(); i++) {
                String columnName = model.getColumnName(i);
                if (columnName.equals("ID Cliente")
                        || columnName.equals("Nombres") || columnName.equals("Apellidos")
                        || columnName.equals("Teléfono movíl")
                        || columnName.equals("Dirección") || columnName.equals("Nacionalidad")
                        || columnName.equals("Tipo") || columnName.equals("Correo electronico")) {
                    String idCliente = getValueAtSelectedRow(model, filaSeleccionada, "ID Cliente");
                    String nombreClienteA = getValueAtSelectedRow(model, filaSeleccionada, "Nombres");
                    String apellido = getValueAtSelectedRow(model, filaSeleccionada, "Apellidos");
                    String telefonoClienteA = getValueAtSelectedRow(model, filaSeleccionada, "Teléfono movíl");
                    String direccionClienteA = getValueAtSelectedRow(model, filaSeleccionada, "Dirección");
                    String esExtranjero = getValueAtSelectedRow(model, filaSeleccionada, "Nacionalidad");
                    String tipo = getValueAtSelectedRow(model, filaSeleccionada, "Tipo");
                    String correoClienteA = getValueAtSelectedRow(model, filaSeleccionada, "Correo electronico");

                    if (esExtranjero.equals("Extranjero")) {  // Supongo que "true" indica extranjero
                        jCBNacionalExtranjero2.setSelectedItem("Extranjero");
                    } else {
                        if (esExtranjero.equals("Nacional")) {  // Supongo que "true" indica extranjero
                            jCBNacionalExtranjero2.setSelectedItem("Nacional");
                        }
                    }
                    if (tipo.equals("Jurídico")) {  // Supongo que "true" indica extranjero
                        jCJuridicoNatural1.setSelectedItem("Jurídico");
                    } else {
                        if (tipo.equals("Natural")) {  // Supongo que "true" indica extranjero
                            jCJuridicoNatural1.setSelectedItem("Natural");
                        }
                    }
                    validadorCheck.actualizarCampoSeleccionado(CIselect, idCliente, ciActualizar, errorActualizarCliente4);
                    validadorCheck.actualizarCampoSeleccionado(nombreSelect, nombreClienteA, nombreActualizar, errorActualizarCliente5);
                    validadorCheck.actualizarCampoSeleccionado(apellidoSelect, apellido, apellidoActualizar, errorActualizarCliente6);
                    validadorCheck.actualizarCampoSeleccionado(telefonoSelect, telefonoClienteA, telefonoActualizar, errorActualizarCliente1);
                    validadorCheck.actualizarCampoSeleccionado(direccionSelect, direccionClienteA, direccionActualizar, errorActualizarCliente2);
                    validadorCheck.actualizarCampoSeleccionado(correoSelect, correoClienteA, correoActualizar, errorActualizarCliente3);
                    Boolean[] valoresItem = {telfCliente1, dirCliente1, correoElectronico1};
                    valoresItem = validadorCheck.cambiarValoresVerdadFinal(valoresItem);
                    telfCliente1 = valoresItem[0];
                    dirCliente1 = valoresItem[1];
                    correoElectronico1 = valoresItem[2];
                    foundColumn = true;
                    break; // Sale del bucle una vez que se haya encontrado una columna válida                 
                }
            }
        }
    }//GEN-LAST:event_tablaActualizarClienteMouseClicked

    private void jBCambiarEstadoProveedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCambiarEstadoProveedor1ActionPerformed
        String filtroIdCliente = jTRUCCE1.getText();
        if (filtroIdCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa un CI, RUC o pasaporte");
            return;
        }
        String nuevoEstado = "";
        String estadoActual = RegistrarDatosFactura.obtenerEstadoCliente(cnx, filtroIdCliente);
        int respuesta;
        if (estadoActual.equals("Desconocido")) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado en la base de datos.");
        } else {
            if ("Retirado".equals(estadoActual)) {
                nuevoEstado = "Activo";
            } else if ("Activo".equals(estadoActual)) {
                nuevoEstado = "Retirado";
            }

            if (!nuevoEstado.isEmpty()) {
                respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas cambiar el estado a '" + nuevoEstado + "'?", "Confirmar Cambio de Estado", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    RegistrarDatosFactura.cambiarEstadoCliente(cnx, filtroIdCliente, nuevoEstado);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Estado desconocido del elemento.");
            }
            CreadorTablas creadorTablas = new CreadorTablas();
            DefaultTableModel modelo = creadorTablas.mostrarTablaClientes(cnx); // Llamas al método con el filtro
            tablaClienteCambiarEstado.setModel(modelo); // Actualizas la tabla con el nuevo modelo 
        }

    }//GEN-LAST:event_jBCambiarEstadoProveedor1ActionPerformed

    private void jTRUCCE1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTRUCCE1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTRUCCE1KeyTyped

    private void jTRUCCE1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTRUCCE1KeyReleased
        String filtroIdCliente = jTRUCCE1.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarClienteParametrizado(cnx, filtroIdCliente, "Todos"); // Llamas al método con el filtro
        tablaClienteCambiarEstado.setModel(modelo); // Actualizas la tabla con el nuevo modelo 
    }//GEN-LAST:event_jTRUCCE1KeyReleased

    private void menuAdministracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAdministracionMouseClicked
        contenido.show(panelContent, "card6");
        cambiarSeccionMenu(5);
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

    private void TFCargoActualizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFCargoActualizadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFCargoActualizadoActionPerformed

    public boolean fechaVacia(JDateChooser dateChooser, JLabel label) {
        if (dateChooser.getDate() == null) {
            label.setVisible(true);
            return false;
        } else {
            label.setVisible(false);
            return true;
        }
    }
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

    private void jTFRUCNegocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFRUCNegocioKeyTyped
        char variable = evt.getKeyChar();
        if (Character.isLetter(variable)) {
            getToolkit().beep();
            evt.consume();
            jTFRUCNegocio.requestFocus();
            JOptionPane.showMessageDialog(null, "Ingrese solo números");
        }
    }//GEN-LAST:event_jTFRUCNegocioKeyTyped

    private void jTFTelefonoNegocioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFTelefonoNegocioFocusLost
        telefonoNeg = validarRegistroF.camposDeRegistros(jTFTelefonoNegocio, jError4, "t");
    }//GEN-LAST:event_jTFTelefonoNegocioFocusLost

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

    private void jTNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreClienteKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "No se permiten valores numéricos en el campo Nombre.");
        }
    }//GEN-LAST:event_jTNombreClienteKeyTyped

    private void jTFApeliidosClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApeliidosClienteKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "No se permiten valores numéricos en el campo Apellido.");
        }
    }//GEN-LAST:event_jTFApeliidosClienteKeyTyped

    private void jTTelefonoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTTelefonoClienteFocusLost
        String tipoCliente = (String) jCBNacionalExtranjero1.getSelectedItem();
        telfCliente = validarRegistroF.camposCliente(jTTelefonoCliente, jError10, tipoCliente, "Ninguno", "b");
    }//GEN-LAST:event_jTTelefonoClienteFocusLost

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

    private void idItemFacturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idItemFacturaKeyReleased
        String valor = idItemFactura.getText();
        String campo = "idItem";
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaItemsID(cnx, valor, campo, "idItem", "item", "idItem");
        jTablaRegistrarFactura.setModel(modelo);
    }//GEN-LAST:event_idItemFacturaKeyReleased

    private void jTCIDelClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCIDelClienteKeyReleased
        String filtroIdCliente = jTCIDelCliente.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarClienteParametrizado(cnx, filtroIdCliente, "N"); // Llamas al método con el filtro
        jTablaRegistrarFactura.setModel(modelo); // Actualizas la tabla con el nuevo modelo 
        String tipoCliente = (String) jCBNacionalExtranjero1.getSelectedItem();
        String natularJuridico = (String) jCBJuridicoNatural1.getSelectedItem();
        rucCliente = validarRegistroF.camposCliente(jTCIDelCliente, jError7, tipoCliente, natularJuridico, "a");
    }//GEN-LAST:event_jTCIDelClienteKeyReleased

    private void jTFRUCNegocioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFRUCNegocioKeyReleased
        rucV = validarRegistroF.camposDeRegistros(jTFRUCNegocio, jError2, "b");
        String filtro = jTFRUCNegocio.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaNegocios(cnx, filtro); // Llamas al método para obtener el modelo actualizado
        jTablaRegistrarFactura.setModel(modelo);
    }//GEN-LAST:event_jTFRUCNegocioKeyReleased

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
    public void imprimirValores(Boolean[] valores) {
        for (Boolean valor : valores) {
            System.out.println(valor);
        }
    }

    private String getValueAtSelectedRow(DefaultTableModel model, int selectedRow, String columnName) {
        int colIndex = model.findColumn(columnName);
        return colIndex != -1 ? model.getValueAt(selectedRow, colIndex).toString() : "";
    }

    private void fillBusinessFieldsP(String ruc, String nombre, String direccion, String telefono) {
        jTFRUCNegocio1.setText(ruc);
        jTFNombreNegocio1.setText(nombre);
        jTFDirNegocio1.setText(direccion);
        jTFTelefonoNegocio1.setText(telefono);
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

    private void fillClientP(String id, String nombre, String apellido, String telefono, String direccion, String esExtranjero, String tipo, String correo) {

        if (esExtranjero.equals("Extranjero")) {  // Supongo que "true" indica extranjero
            jCBSeleccionTipoCliente1.setSelectedItem("Extranjero");
        } else {
            if (esExtranjero.equals("Nacional")) {  // Supongo que "true" indica extranjero
                jCBSeleccionTipoCliente1.setSelectedItem("Nacional");
            }
        }

        if (tipo.equals("Jurídico")) {  // Supongo que "true" indica extranjero
            jCBNaturalOJuridico1.setSelectedItem("Jurídico");
        } else {
            if (tipo.equals("Natural")) {  // Supongo que "true" indica extranjero
                jCBNaturalOJuridico1.setSelectedItem("Natural");
            }
        }
        jTCIDelCliente1.setText(id);
        jTNombreCliente1.setText(nombre);
        jTFApeliidosCliente1.setText(apellido);
        jTTelefonoCliente1.setText(telefono);
        jTDireccionCliente1.setText(direccion);
        correoCli1.setText(correo);
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

    private void fillClientFields1(String id, String nombre, String apellido,
            String telefono, String direccion,
            String esExtranjero, String tipo, String correo) {
        if (esExtranjero.equals("Extranjero")) {  // Supongo que "true" indica extranjero
            jCBNacionalExtranjero.setSelectedItem("Extranjero");
        } else {
            if (esExtranjero.equals("Nacional")) {  // Supongo que "true" indica extranjero
                jCBNacionalExtranjero.setSelectedItem("Nacional");
            }
        }

        if (tipo.equals("Jurídico")) {  // Supongo que "true" indica extranjero
            jCJuridicoNatural.setSelectedItem("Jurídico");
        } else {
            if (tipo.equals("Natural")) {  // Supongo que "true" indica extranjero
                jCJuridicoNatural.setSelectedItem("Natural");
            }
        }
        jTFCIRegistrarC.setText(id);
        jTFNombresR.setText(nombre);
        jTFApellidosR.setText(apellido);
        jTFTelefonoR.setText(telefono);
        jTFDireccionR.setText(direccion);
        correoCli2.setText(correo);
    }


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
                int nuevoNumeroFactura = RegistrarDatosFactura.obtenerNuevoNumeroFactura(cnx);
                jTFnumerofactura.setText(String.valueOf(nuevoNumeroFactura));
            }
        }
    }//GEN-LAST:event_jBGenerarFacturaActionPerformed

    private void jCBIConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBIConsultar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBIConsultar1ActionPerformed

    private void jTFCInventario1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCInventario1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCInventario1KeyTyped

    private void jBConsultarInventario4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarInventario4ActionPerformed
        String campo = (String) jCBIConsultar1.getSelectedItem();
        if (campo.equals("Selecciona el atributo")) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un campo válido.");
            return; // Detener la ejecución si no se ha seleccionado un campo válido
        }
        String valor = jTFCInventario1.getText();
        if (valor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa un valor");
            return; // Detener la ejecución si el campo de valor está vacío
        }
        DefaultTableModel modelo = ConsultarBD.buscarAtributoPorId(cnx, campo, valor);
        if (modelo.getRowCount() == 0) {
            // No se encontraron resultados, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Ítem no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Se encontraron resultados, asignar el modelo a la tabla
            jTablaInventario2.setModel(modelo);
        }
    }//GEN-LAST:event_jBConsultarInventario4ActionPerformed

    private void correoCliFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoCliFocusLost
        correoElectronico = validarRegistroF.camposDeRegistros(correoCli, jError12, "c");
    }//GEN-LAST:event_correoCliFocusLost

    private void jCJuridicoNaturalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCJuridicoNaturalActionPerformed
        jTFCIRegistrarC.setText("");
        String seleccion = (String) jCJuridicoNatural.getSelectedItem();
        validarCamposJuridicoC();
        if ("Jurídico".equals(seleccion)) {
            jLTipoCli.setText("RUC");
        } else if ("Natural".equals(seleccion)) {
            String seleccionExtranjero = (String) jCBNacionalExtranjero.getSelectedItem();
            if ("Nacional".equals(seleccionExtranjero)) {
                jLTipoCli.setText("CI");
            } else if ("Extranjero".equals(seleccionExtranjero)) {
                jLTipoCli.setText("Pasaporte");
            }
        }
    }//GEN-LAST:event_jCJuridicoNaturalActionPerformed

    private void jCBNacionalExtranjeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBNacionalExtranjeroActionPerformed
        jTFCIRegistrarC.setText("");
        String seleccion2 = (String) jCJuridicoNatural.getSelectedItem();
        String seleccion = (String) jCBNacionalExtranjero.getSelectedItem();
        validarCamposJuridicoC();
        if ("Natural".equals(seleccion2)) {
            if ("Nacional".equals(seleccion)) {
                jLTipoCli.setText("CI");
            } else if ("Extranjero".equals(seleccion)) {
                jLTipoCli.setText("Pasaporte");
            }
        } else if ("Jurídico".equals(seleccion2)) {
            jLTipoCli.setText("RUC");
        }
    }//GEN-LAST:event_jCBNacionalExtranjeroActionPerformed

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
    public void detectorExtranjeroNacional() {
        String seleccionExtranjero = (String) jCBNacionalExtranjero1.getSelectedItem();
        if ("Nacional".equals(seleccionExtranjero)) {
            jTTelefonoCliente.setText("+593-");
        } else if ("Extranjero".equals(seleccionExtranjero)) {
            jTTelefonoCliente.setText("+1-");
        }
    }
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
    private void validarCamposJuridico() {
        String nacionalExtranjero = jCBNacionalExtranjero1.getSelectedItem().toString();
        String naturalJuridico = jCBJuridicoNatural1.getSelectedItem().toString();

        if (nacionalExtranjero.equals("Selecciona") || naturalJuridico.equals("Natural o Jurídico")) {
            jTCIDelCliente.setEnabled(false); // Deshabilitar el campo si las selecciones no son válidas
        } else {
            jTCIDelCliente.setEnabled(true); // Habilitar el campo si las selecciones son válidas
        }
    }

    private void validarCamposJuridicoC() {
        String nacionalExtranjero = jCBNacionalExtranjero.getSelectedItem().toString();
        String naturalJuridico = jCJuridicoNatural.getSelectedItem().toString();

        if (nacionalExtranjero.equals("Selecciona") || naturalJuridico.equals("Natural o Jurídico")) {
            jTFCIRegistrarC.setEnabled(false); // Deshabilitar el campo si las selecciones no son válidas
        } else {
            jTFCIRegistrarC.setEnabled(true); // Habilitar el campo si las selecciones son válidas
        }
    }


    private void jTFRUCNegocio1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFRUCNegocio1KeyReleased
        String filtro = jTFRUCNegocio1.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaNegocios(cnx, filtro); // Llamas al método para obtener el modelo actualizado
        jTablaRegistrarFactura1.setModel(modelo);
        rucV2 = validarRegistroF.camposDeRegistros(jTFRUCNegocio1, errorP2, "b");
    }//GEN-LAST:event_jTFRUCNegocio1KeyReleased

    private void jTFTelefonoNegocio1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFTelefonoNegocio1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTelefonoNegocio1FocusGained

    private void jTFTelefonoNegocio1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFTelefonoNegocio1FocusLost
        telefonoNeg2 = validarRegistroF.camposDeRegistros(jTFTelefonoNegocio1, errorP4, "t");
    }//GEN-LAST:event_jTFTelefonoNegocio1FocusLost

    private void jTTelefonoCliente1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTTelefonoCliente1FocusLost
        String tipoCliente = (String) jCBSeleccionTipoCliente1.getSelectedItem();
        telfCliente2 = validarRegistroF.camposCliente(jTTelefonoCliente1, errorP10, tipoCliente, "Ninguno", "b");
    }//GEN-LAST:event_jTTelefonoCliente1FocusLost

    private void jTCIDelCliente1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCIDelCliente1KeyReleased
        String filtroIdCliente = jTCIDelCliente1.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarClienteParametrizado(cnx, filtroIdCliente, "N"); // Llamas al método con el filtro
        jTablaRegistrarFactura1.setModel(modelo); // Actualizas la tabla con el nuevo modelo 
        String tipoCliente = (String) jCBSeleccionTipoCliente1.getSelectedItem();
        String natularJuridico = (String) jCBNaturalOJuridico1.getSelectedItem();
        rucCliente2 = validarRegistroF.camposCliente(jTCIDelCliente1, errorP7, tipoCliente, natularJuridico, "a");
    }//GEN-LAST:event_jTCIDelCliente1KeyReleased

    private void jCBSeleccionTipoCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSeleccionTipoCliente1ActionPerformed
        String seleccion2 = (String) jCBNaturalOJuridico1.getSelectedItem();
        String seleccion = (String) jCBSeleccionTipoCliente1.getSelectedItem();
        if ("Natural".equals(seleccion2)) {
            if ("Nacional".equals(seleccion)) {
                jLCITipoCliente1.setText("CI");
            } else if ("Extranjero".equals(seleccion)) {
                jLCITipoCliente1.setText("Pasaporte");
            }
        } else if ("Jurídico".equals(seleccion2)) {
            jLCITipoCliente1.setText("RUC");
        }
    }//GEN-LAST:event_jCBSeleccionTipoCliente1ActionPerformed

    private boolean validarCamposVaciosP() {
        JTextField[] camposP = {jTFNombreNegocio1, jTFRUCNegocio1, jTFDirNegocio1, jTFTelefonoNegocio1,
            jTCIDelCliente1, jTNombreCliente1, jTFApeliidosCliente1, jTTelefonoCliente1, jTDireccionCliente1, correoCli1};
        Boolean[] boleanosP = new Boolean[]{nombreNegocioValido2, estadoPagoP2,
            rucV2, dirNeg2, telefonoNeg2, rucCliente2, nombreCFactura2,
            apellidoCFactura2, telfCliente2, dirCliente2, correoElectronico2};

        boolean camposValidos = true; // Inicialmente asumimos que todos los campos son válidos

        for (int i = 0; i < camposP.length; i++) {
            JTextField campo = camposP[i];
            boolean valor = boleanosP[i];
            if (campo.getText().isEmpty()) {
                campo.setBackground(new Color(255, 204, 204));
                camposValidos = false; // Al menos un campo está vacío, marca como inválidos
            } else {
                if (valor) {
                    campo.setBackground(Color.WHITE); // Restaura el color de fondo predeterminado
                }
            }
        }
        return camposValidos; // Retorna true si todos los campos son válidos, false si al menos uno está vacío
    }

    private boolean validarCamposProforma() {
        JTextField[] camposP = {jTFNombreNegocio1, jTFRUCNegocio1, jTFDirNegocio1, jTFTelefonoNegocio1,
            jTCIDelCliente1, jTNombreCliente1, jTFApeliidosCliente1, jTTelefonoCliente1, jTDireccionCliente1, correoCli1};
        Boolean[] boleanosP = new Boolean[]{nombreNegocioValido2,
            rucV2, dirNeg2, telefonoNeg2, rucCliente2, nombreCFactura2,
            apellidoCFactura2, telfCliente2, dirCliente2, correoElectronico2};
        JLabel[] labels = {errorP1, errorP2, errorP3, errorP4, errorP7, errorP8, errorP9, errorP10, errorP11, errorP12};
        boolean camposValidos = true; // Inicialmente asumimos que todos los campos son válidos
        for (int i = 0; i < camposP.length; i++) {
            JTextField campo = camposP[i];
            JLabel label = labels[i % labels.length];
            boolean valor = boleanosP[i];
            if (!valor) {
                campo.setBackground(new Color(255, 204, 204));
                camposValidos = false;
            } else {
                label.setVisible(false);
                campo.setBackground(Color.WHITE);
            }
        }
        return camposValidos;
    }


    private void jBRegistrarFactura1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarFactura1ActionPerformed

        if (!hayProductosEnStockP()) {
            JOptionPane.showMessageDialog(this, "No hay productos en stock o no hay productos disponibles.");
        } else if (!validarCamposVaciosP() || jDateChooserFecha1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Llena todos los campos.");
        } else if (!validarCamposProforma()) {
            JOptionPane.showMessageDialog(this, "Error al ingresar los datos básicos.");
        } else {
            errorP5.setVisible(false);

            int idFactura = Integer.parseInt(jTFnumerofactura1.getText());

            try {

                // Datos del negocio
                String rucNegocio = jTFRUCNegocio1.getText();
                String nombreNegocio = jTFNombreNegocio1.getText();
                String direccionNegocio = jTFDirNegocio1.getText();
                String telefonoNegocio = jTFTelefonoNegocio1.getText();

                // Datos del cliente
                String idCliente = jTCIDelCliente1.getText();
                String nombresCliente = jTNombreCliente1.getText();
                String apellidosCliente = jTFApeliidosCliente1.getText();
                String telefonoCliente = jTTelefonoCliente1.getText();
                String direccionCliente = jTDireccionCliente1.getText();
                String esExtranjero = (String) jCBSeleccionTipoCliente1.getSelectedItem();
                String tipo = (String) jCBNaturalOJuridico1.getSelectedItem();
                String correoDelCli = correoCli1.getText();

                // Datos de la factura
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String fechaEmision = dateFormat.format(jDateChooserFecha1.getDate());
                //String estadoPago = (String) jCBEstadoPago1.getSelectedItem();
                double porcentajeIVA = Double.parseDouble(IVAText1.getText());
                // Mostrar el diálogo de confirmac           
                int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea registrar estos datos en la Proforma?",
                        "Confirmación de Registro", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    // Insertar negocio si no existe
                    RegistrarDatosFactura.insertarDatosNegocioC(cnx, rucNegocio,
                            nombreNegocio, direccionNegocio, telefonoNegocio);
                    // Insertar cliente si no existe
                    RegistrarDatosFactura.insertarDatosClienteC(cnx, idCliente, nombresCliente,
                            apellidosCliente, telefonoCliente,
                            direccionCliente, esExtranjero, tipo, correoDelCli);
                    // Insertar factura
                    RegistrarDatosFactura.insertarDatosProforma(cnx, idFactura, fechaEmision,
                            rucNegocio, idCliente,
                            "Pendiente de Pago", porcentajeIVA);
                    JOptionPane.showMessageDialog(this, "Proforma Registrada");
                    deshabilitarCamposP();
                }
                // Cerrar conexión
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al registrar la factura");
            }

        }


    }//GEN-LAST:event_jBRegistrarFactura1ActionPerformed

    private void correoCli1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoCli1FocusLost
        correoElectronico = validarRegistroF.camposDeRegistros(correoCli1, errorP12, "c");
    }//GEN-LAST:event_correoCli1FocusLost

    private void jCBNaturalOJuridico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBNaturalOJuridico1ActionPerformed
        String seleccion = (String) jCBNaturalOJuridico1.getSelectedItem();

        if ("Jurídico".equals(seleccion)) {
            jLCITipoCliente1.setText("RUC");
        } else if ("Natural".equals(seleccion)) {
            String seleccionExtranjero = (String) jCBSeleccionTipoCliente1.getSelectedItem();
            if ("Nacional".equals(seleccionExtranjero)) {
                jLCITipoCliente1.setText("CI");
            } else if ("Extranjero".equals(seleccionExtranjero)) {
                jLCITipoCliente1.setText("Pasaporte");
            }
        }
    }//GEN-LAST:event_jCBNaturalOJuridico1ActionPerformed

    private void iDProcutoPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iDProcutoPKeyReleased
        String valor = iDProcutoP.getText();
        String campo = "idItem_copia";
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaItemsID(cnx, valor, campo, "idItem_copia", "item_copia", "idItem_copia");
        jTablaRegistrarFactura1.setModel(modelo);
    }//GEN-LAST:event_iDProcutoPKeyReleased

    private void iDProcutoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iDProcutoPKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_iDProcutoPKeyTyped

    private void cantidadProformaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadProformaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadProformaKeyTyped

    private void jBAgregarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarProducto1ActionPerformed
        try {
            int idItem_copia = Integer.parseInt(iDProcutoP.getText());
            int cantidad = Integer.parseInt(cantidadProforma.getText());
            int idProforma = Integer.parseInt(jTFnumerofactura1.getText());
            // Verificar stock y realizar la inserción en detalle_factura si es posible
            String selectStockQuery = "SELECT stock, precio FROM item_copia WHERE idItem_copia = ?";
            PreparedStatement selectStockStatement = cnx.prepareStatement(selectStockQuery);
            selectStockStatement.setInt(1, idItem_copia);
            ResultSet stockResult = selectStockStatement.executeQuery();
            if (stockResult.next()) {
                int stockDisponible = stockResult.getInt("stock");
                double precioUnitario = stockResult.getDouble("precio");
                if (stockDisponible >= cantidad) {
                    // Calcular subtotal
                    double subtotal = cantidad * precioUnitario;
                    // Insertar en detalle_factura
                    RegistrarDatosFactura.insertarDetalleFacturaC(cnx, idProforma, idItem_copia,
                            cantidad, precioUnitario, subtotal);
                    // Insertar en actualizarStock
                    RegistrarDatosFactura.actualizarStockYMostrarMensajeP(cnx, idItem_copia, cantidad);

                    RegistrarDatosFactura.PreciosTotales precios = RegistrarDatosFactura.obtenerPreciosTotalesC(cnx, idProforma);
                    jTFTotal.setText(String.valueOf(precios.getPrecioTotalConIVADisplay())); // Precio Total con IVA
                    jTFSubtotal1.setText(String.valueOf(precios.getPrecioTotalSinIVADisplay())); // Precio Total sin IVA
                    actualizarTablaComprasClienteIDC(idProforma);
                } else {
                    JOptionPane.showMessageDialog(this, "No hay suficiente stock disponible");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El producto no existe");
            }
            //Cerrar conexión
            //cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al agregar el producto");
        }
    }//GEN-LAST:event_jBAgregarProducto1ActionPerformed

    private void jBQuitarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitarProducto1ActionPerformed
        try {
            int idItem = Integer.parseInt(iDProcutoP.getText());
            int idProforma = Integer.parseInt(jTFnumerofactura1.getText());
            // Verificar si el producto está en detalle_factura y revertir cambios si es necesario
            String selectDetalleQuery = "SELECT idDetalle_proforma, cantidad FROM detalle_proforma WHERE idItem_copia = ? AND idProforma = ?";
            PreparedStatement selectDetalleStatement = cnx.prepareStatement(selectDetalleQuery);
            selectDetalleStatement.setInt(1, idItem);
            selectDetalleStatement.setInt(2, idProforma);
            ResultSet detalleResult = selectDetalleStatement.executeQuery();

            if (detalleResult.next()) {
                int idDetalle_proforma = detalleResult.getInt("idDetalle_proforma");
                int cantidadAgregada = detalleResult.getInt("cantidad");
                // Eliminar registro de detalle_factura
                RegistrarDatosFactura.quitarDetalleFacturaC(cnx, idDetalle_proforma);
                // Actualizar stock en la tabla item
                RegistrarDatosFactura.actualizarStockC(cnx, idItem, cantidadAgregada);
                JOptionPane.showMessageDialog(this, "Producto quitado con éxito");
                RegistrarDatosFactura.PreciosTotales precios = RegistrarDatosFactura.obtenerPreciosTotalesC(cnx, idProforma);
                jTFTotal.setText(String.valueOf(precios.getPrecioTotalConIVADisplay())); // Precio Total con IVA
                jTFSubtotal1.setText(String.valueOf(precios.getPrecioTotalSinIVADisplay())); // Precio Total sin IVA
                actualizarTablaComprasClienteIDC(idProforma);
            } else {
                JOptionPane.showMessageDialog(this, "El producto no está en la factura");
            }
            //Cerrar conexión
            //cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al quitar el producto");
        }
    }//GEN-LAST:event_jBQuitarProducto1ActionPerformed

    private void jBGenerarFactura1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGenerarFactura1ActionPerformed
        String estadoPago = (String) jCBEstadoPago1.getSelectedItem();
        String rucNegocio = jTFRUCNegocio1.getText();
        String nombreNegocio = jTFNombreNegocio1.getText();
        String direccionNegocio = jTFDirNegocio1.getText();
        String telefonoNegocio = jTFTelefonoNegocio1.getText();

        // Datos del cliente
        String idCliente_c = jTCIDelCliente1.getText();
        String nombresCliente = jTNombreCliente1.getText();
        String apellidosCliente = jTFApeliidosCliente1.getText();
        String telefonoCliente = jTTelefonoCliente1.getText();
        String direccionCliente = jTDireccionCliente1.getText();

        // Datos de la factura
        int idProforma = Integer.parseInt(jTFnumerofactura1.getText());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaEmision = dateFormat.format(jDateChooserFecha1.getDate());
        //String estadoPago = (String) jCBEstadoPago1.getSelectedItem();
        double porcentajeIVA = Double.parseDouble(IVAText1.getText());
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modeloFactura = creadorTablas.mostrarItemsIDC(cnx, idProforma);

        double precioTotalSinIVA = Double.parseDouble(jTFSubtotal1.getText());
        double precioTotalConIVA = Double.parseDouble(jTFTotal.getText());
        JFFactura facturaFrame = new JFFactura(precioTotalSinIVA, precioTotalConIVA, rucNegocio, nombreNegocio,
                direccionNegocio, telefonoNegocio, idCliente_c, nombresCliente, apellidosCliente, telefonoCliente,
                direccionCliente, fechaEmision, porcentajeIVA, idProforma
        );

        if (estadoPago.equals("Selecciona")) {
            errorP6.setVisible(true);
            JOptionPane.showMessageDialog(null, "Selecciona el estado de pago");
        } else {

            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea limpiar los campos y generar la proforma?",
                    "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String deleteDetalleQuery = "DELETE FROM detalle_proforma WHERE idProforma = ?";
                try (PreparedStatement statement = cnx.prepareStatement(deleteDetalleQuery)) {
                    statement.setInt(1, idProforma);
                    statement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Manejo de errores si es necesario
                }
                // Eliminar el registro de la idProforma de la tabla Proforma
                String deleteProformaQuery = "DELETE FROM Proforma WHERE idProforma = ?";
                try (PreparedStatement statement = cnx.prepareStatement(deleteProformaQuery)) {
                    statement.setInt(1, idProforma);
                    statement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Manejo de errores si es necesario
                }
                String deleteClienteQuery = "DELETE FROM cliente_copia WHERE idCliente_c = ?";
                try (PreparedStatement statement = cnx.prepareStatement(deleteClienteQuery)) {
                    statement.setString(1, "'" + idCliente_c + "'"); // Asegúrate de tener el valor de idCliente_c
                    statement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Manejo de errores si es necesario
                }
                limpiarYCambiarCamposP();
                facturaFrame.actualizarTablaFactura(modeloFactura);
                facturaFrame.setVisible(true);
            }
        }
    }//GEN-LAST:event_jBGenerarFactura1ActionPerformed

    private void jTablaRegistrarFactura1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaRegistrarFactura1MouseClicked

        int filaSeleccionada = jTablaRegistrarFactura1.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel model = (DefaultTableModel) jTablaRegistrarFactura1.getModel();
            boolean foundColumn = false;

            // Recorre todas las columnas del modelo
            for (int i = 0; i < model.getColumnCount(); i++) {
                String columnName = model.getColumnName(i);

                if (columnName.equals("ruc_negocio") || columnName.equals("nombreNegocio") || columnName.equals("direccionNegocio") || columnName.equals("telefonoNegocio")) {
                    String rucNegocio = getValueAtSelectedRow(model, filaSeleccionada, "ruc_negocio");
                    String nombreNegocio = getValueAtSelectedRow(model, filaSeleccionada, "nombreNegocio");
                    String direccionNegocio = getValueAtSelectedRow(model, filaSeleccionada, "direccionNegocio");
                    String telefonoDelNegocio = getValueAtSelectedRow(model, filaSeleccionada, "telefonoNegocio");
                    fillBusinessFieldsP(rucNegocio, nombreNegocio, direccionNegocio, telefonoDelNegocio);
                    //jTFTelefonoNegocio1.setForeground(Color.BLACK);
                    /// Marca que se ha encontrado una columna válida
                    cambiarValoresNegoP();
                    validarCamposNegoP();
                    validarVaciosNegP();
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

                    fillClientP(idCliente, nombreCliente, apellido, telefonoCliente, direccionCliente, esExtranjero, tipo, correoCliente);
                    cambiarValoresClienteP();
                    validarClienteVacioP();
                    validarClienteP();
                    // Marca que se ha encontrado una columna válida
                    foundColumn = true;
                    break; // Sale del bucle una vez que se haya encontrado una columna válida
                }
                //ID ítem", "Nombre ítem", "Stock", "Precio
                if (columnName.equals("ID ítem") || columnName.equals("Nombre ítem")
                        || columnName.equals("Stock") || columnName.equals("Precio")) {
                    String idtems = getValueAtSelectedRow(model, filaSeleccionada, "ID ítem");
                    String nombreproducto = getValueAtSelectedRow(model, filaSeleccionada, "Nombre ítem");
                    iDProcutoP.setText(idtems);
                    jTextField1.setText(nombreproducto);

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

    }//GEN-LAST:event_jTablaRegistrarFactura1MouseClicked

    private void jFNumeroFactura2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFNumeroFactura2KeyReleased
        String numeroFacturaFilter = jFNumeroFactura2.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaFacturasTodas(cnx, numeroFacturaFilter); // Llamar al método con el filtro
        jTableFacturas.setModel(modelo);
    }//GEN-LAST:event_jFNumeroFactura2KeyReleased

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

    private void jFNumeroFactura2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFNumeroFactura2KeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Solo valores numéricos");
        }
    }//GEN-LAST:event_jFNumeroFactura2KeyTyped

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String campo = (String) SeleccionFacturaAtributo.getSelectedItem();
        String valor = jTFAtributoC.getText();
        String atributo = "";
        if (campo.equals("Selecciona")) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un campo válido.");
            return; // Detener la ejecución si no se ha seleccionado un campo válido
        }

        switch (campo) {
            case "Número de factura" -> {
                atributo = "idFactura";
            }
            case "Fecha" -> {
                atributo = "fechaEmision";
            }
            case "Pasaporte", "Número de cédula", "RUC" -> {
                atributo = "idCliente";
            }
            case "Estado" -> {
                atributo = "estadoFactura";
            }
            case "Estado de pago" -> {
                atributo = "estadoPago";
            }
            case "Nombres del cliente" -> {
                atributo = "nombres";
            }
            case "Apellidos del cliente" -> {
                atributo = "apellidos";
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Ingrese un campo válido");
                return;
            }
        }
        if (valor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa un valor en el campo.");
            return; // Detener la ejecución si el campo de valor está vacío
        }
        DefaultTableModel modelo = ConsultarBD.consultarHistorialF(cnx, atributo, valor);
        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Error, no se encontró el registro.");
            return;
        }
        jTableHistorialFacturas.setModel(modelo);

    }//GEN-LAST:event_jButton9ActionPerformed

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

    private void jBVerGananciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVerGananciasActionPerformed
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaGanancia(cnx);

        // Usar el modelo para llenar jTableFacturas1
        jTableFacturas1.setModel(modelo);

    }//GEN-LAST:event_jBVerGananciasActionPerformed

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

    private void jTCIDelClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCIDelClienteFocusLost
        String tipoCliente = (String) jCBNacionalExtranjero1.getSelectedItem();
        String natularJuridico = (String) jCBJuridicoNatural1.getSelectedItem();
        rucCliente = validarRegistroF.camposCliente(jTCIDelCliente, jError7, tipoCliente, natularJuridico, "a");
    }//GEN-LAST:event_jTCIDelClienteFocusLost

    private void jCBEstadoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEstadoPagoActionPerformed
        String estadoPago = (String) jCBEstadoPago.getSelectedItem();
        if (estadoPago.equals("Seleccione")) {
            jError5.setVisible(true);
            jCBEstadoPago.setBackground(new Color(255, 204, 204));
        } else {
            jCBEstadoPago.setBackground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_jCBEstadoPagoActionPerformed

    private void jTFNombreNegocioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFNombreNegocioFocusLost
        nombreNegocioValido = validarRegistroF.camposDeRegistros(jTFNombreNegocio, jError1, "d");
    }//GEN-LAST:event_jTFNombreNegocioFocusLost

    private void jTFRUCNegocioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFRUCNegocioFocusLost
        rucV = validarRegistroF.camposDeRegistros(jTFRUCNegocio, jError2, "b");
    }//GEN-LAST:event_jTFRUCNegocioFocusLost

    private void jTFDirNegocioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFDirNegocioFocusLost
        dirNeg = validarRegistroF.camposDeRegistros(jTFDirNegocio, jError3, "d");
    }//GEN-LAST:event_jTFDirNegocioFocusLost

    private void jTDireccionClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTDireccionClienteFocusLost
        dirCliente = validarRegistroF.camposDeRegistros(jTDireccionCliente, jError11, "d");
    }//GEN-LAST:event_jTDireccionClienteFocusLost

    private void AdminIVAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdminIVAKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume(); // Consume el evento, evitando que se ingrese el carácter
        }
    }//GEN-LAST:event_AdminIVAKeyTyped

    private void AdminIVAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdminIVAKeyReleased
        String setIva = AdminIVA.getText();
        IVAText.setText(setIva);
    }//GEN-LAST:event_AdminIVAKeyReleased

    private void jTableHistorialFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHistorialFacturasMouseClicked
        int selectedRow = jTableHistorialFacturas.getSelectedRow();
        if (selectedRow != -1) {
            int idFactura = (int) jTableHistorialFacturas.getValueAt(selectedRow, 0); // Obtén el idFactura de la fila seleccionada
            abrirPDFdesdeBD(idFactura);
        }
    }//GEN-LAST:event_jTableHistorialFacturasMouseClicked

    private void jTFAtributoCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFAtributoCKeyTyped
        char variable = evt.getKeyChar();
        String campo = (String) SeleccionFacturaAtributo.getSelectedItem();

        if (campo.equals("Selecciona")) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un campo válido.");
            return; // Detener la ejecución si no se ha seleccionado un campo válido
        }
        switch (campo) {
            case "Número de factura" -> {
                if (!Character.isDigit(variable)) {
                    evt.consume();
                }
            }
            case "Fecha" -> {
                if (!Character.isDigit(variable) && variable != '-') {
                    evt.consume();
                }
            }
            case "Pasaporte", "Número de cédula", "RUC" -> {
                // Aquí no hay restricciones de caracteres
            }
            case "Estado", "Estado de pago", "Nombres del cliente", "Apellidos del cliente" -> {
                if (!Character.isLetter(variable)) {
                    evt.consume();
                }
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Ingrese un campo válido");
                return;
            }
        }

    }//GEN-LAST:event_jTFAtributoCKeyTyped
    private boolean validarClienteVacioP() {
        JTextField[] camposP = {jTCIDelCliente1, jTNombreCliente1, jTFApeliidosCliente1, jTTelefonoCliente1, jTDireccionCliente1, correoCli1};
        Boolean[] boleanosP = new Boolean[]{rucCliente2, nombreCFactura2,
            apellidoCFactura2, telfCliente2, dirCliente2, correoElectronico2};
        boolean camposValidos = true; // Inicialmente asumimos que todos los campos son válidos
        for (int i = 0; i < camposP.length; i++) {
            JTextField campo = camposP[i];
            boolean valor = boleanosP[i];
            if (campo.getText().isEmpty()) {
                campo.setBackground(new Color(255, 204, 204));
                camposValidos = false; // Al menos un campo está vacío, marca como inválidos
            } else {
                if (valor) {
                    campo.setBackground(Color.WHITE); // Restaura el color de fondo predeterminado
                }
            }
        }
        return camposValidos; // Retorna true si todos los campos son válidos, false si al menos uno está vacío
    }

    private boolean validarClienteP() {
        JTextField[] camposP = {jTCIDelCliente1, jTNombreCliente1, jTFApeliidosCliente1, jTTelefonoCliente1, jTDireccionCliente1, correoCli1};
        Boolean[] boleanosP = new Boolean[]{rucCliente2, nombreCFactura2,
            apellidoCFactura2, telfCliente2, dirCliente2, correoElectronico2};
        JLabel[] labels = {errorP7, errorP8, errorP9, errorP10, errorP11, errorP12};
        boolean camposValidos = true; // Inicialmente asumimos que todos los campos son válidos
        for (int i = 0; i < camposP.length; i++) {
            JTextField campo = camposP[i];
            JLabel label = labels[i % labels.length];
            boolean valor = boleanosP[i];
            if (!valor) {
                campo.setBackground(new Color(255, 204, 204));
                camposValidos = false;
            } else {
                label.setVisible(false);
                campo.setBackground(Color.WHITE);
            }
        }
        return camposValidos;
    }

    private boolean validarVaciosNegP() {
        JTextField[] camposP = {jTFNombreNegocio1, jTFRUCNegocio1, jTFDirNegocio1, jTFTelefonoNegocio1};
        Boolean[] boleanosP = new Boolean[]{nombreNegocioValido2, estadoPagoP2,
            rucV2, dirNeg2, telefonoNeg2};
        boolean camposValidos = true; // Inicialmente asumimos que todos los campos son válidos
        for (int i = 0; i < camposP.length; i++) {
            JTextField campo = camposP[i];
            boolean valor = boleanosP[i];
            if (campo.getText().isEmpty()) {
                campo.setBackground(new Color(255, 204, 204));
                camposValidos = false; // Al menos un campo está vacío, marca como inválidos
            } else {
                if (valor) {
                    campo.setBackground(Color.WHITE); // Restaura el color de fondo predeterminado
                }
            }
        }
        return camposValidos; // Retorna true si todos los campos son válidos, false si al menos uno está vacío
    }

    private boolean validarCamposNegoP() {
        JTextField[] camposP = {jTFNombreNegocio1, jTFRUCNegocio1, jTFDirNegocio1, jTFTelefonoNegocio1};
        Boolean[] boleanosP = new Boolean[]{nombreNegocioValido2,
            rucV2, dirNeg2, telefonoNeg2};
        JLabel[] labels = {errorP1, errorP2, errorP3, errorP4};
        boolean camposValidos = true; // Inicialmente asumimos que todos los campos son válidos
        for (int i = 0; i < camposP.length; i++) {
            JTextField campo = camposP[i];
            JLabel label = labels[i % labels.length];
            boolean valor = boleanosP[i];
            if (!valor) {
                campo.setBackground(new Color(255, 204, 204));
                camposValidos = false;
            } else {
                label.setVisible(false);
                campo.setBackground(Color.WHITE);
            }
        }
        return camposValidos;
    }

    private void jBRegistarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistarClienteActionPerformed
        JTextField[] campos = {jTFCIRegistrarC, jTFNombresR, jTFApellidosR, correoCli2,
            jTFTelefonoR, jTFDireccionR};
        JLabel[] labels = {errorc1, errorc2, errorc3, errorc4, errorc5, errorc6};
        Boolean[] booleanosCliente = {documentoCliente, nombreCliente, apellidoCliente, correoCliente,
            telefonoCliente, direccionCliente};
        String[] nombresCampos = {"documento", "nombre", "apellido", "correo", "teléfono", "dirección"};
        List<String> errores = validadorCheck.validarCamposLista(campos, booleanosCliente, labels, nombresCampos);
        errores.addAll(validadorCheck.validarCamposVaciosLista(campos, booleanosCliente, labels, nombresCampos));
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
                String esExtranjero = (String) jCBNacionalExtranjero.getSelectedItem();
                String nombresCliente = jTFNombresR.getText();
                String apellidosCliente = jTFApellidosR.getText();
                String telefonoCliente = jTFTelefonoR.getText();
                String direccionCliente = jTFDireccionR.getText();
                String tipo = (String) jCJuridicoNatural.getSelectedItem();
                String correoDelCli = correoCli2.getText();
                String idCliente = jTFCIRegistrarC.getText();

                try {
                    RegistrarDatosFactura.insertarDatosCliente(cnx, idCliente, nombresCliente,
                            apellidosCliente, telefonoCliente,
                            direccionCliente, esExtranjero, tipo, correoDelCli);
                    CreadorTablas creartabla = new CreadorTablas();
                    DefaultTableModel modelo = creartabla.mostrarClienteParametrizado(cnx, idCliente, "N");
                    jTablaClientesR.setModel(modelo);
                } catch (SQLException ex) {
                    Logger.getLogger(JFMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Datos registrados correctamente");
            } else {
                // El usuario seleccionó "No", puedes realizar alguna otra acción o mostrar un mensaje adecuado
            }
        }
    }//GEN-LAST:event_jBRegistarClienteActionPerformed

    private void jTFCIRegistrarCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCIRegistrarCKeyReleased
        String filtroIdCliente = jTFCIRegistrarC.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarClienteParametrizado(cnx, filtroIdCliente, "N"); // Llamas al método con el filtro
        jTablaClientesR.setModel(modelo); // Actualizas la tabla con el nuevo modelo 
        String tipoCliente = (String) jCBNacionalExtranjero.getSelectedItem();
        String natularJuridico = (String) jCJuridicoNatural.getSelectedItem();
        documentoCliente = validarRegistroF.camposCliente(jTCIDelCliente, jError7, tipoCliente, natularJuridico, "a");
    }//GEN-LAST:event_jTFCIRegistrarCKeyReleased

    private void BRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRegistrarActionPerformed
        boolean registro = true;
        JTextField[] campos = {CedulaEmpleado, NombreEmpleado, jTFApellidoEmpleado, Cargo, direccionEmpelado,
            TelefonoConvencional, TelefonoPersonal, CorreoElectronico
        };
        Boolean[] booleanEmpleado = {cedulaEmpleadoValidar, nombreEmpleadoValidar, apellidoEmpleadoValidar,
            cargoEmpleadoValidar, direccionEmpleadoValidar, telefonoConvenValidar,
            telefonoEmpleadoValiar, correoEmpleadoValidar};

        JLabel[] labels = {jLErrorEmpleado1, jLErrorEmpleado2, jLErrorEmpleado3,
            jLErrorEmpleado4, jLErrorEmpleado5, jLErrorEmpleado6,
            jLErrorEmpleado7, jLErrorEmpleado8};
        String[] nombresCampos = {"cédula", "nombres", "apellidos", "cargo", "dirección", "télefono convencional",
            "teléfono personal", "correo"};
        List<String> errores = validadorCheck.validarCamposLista(campos, booleanEmpleado, labels, nombresCampos);
        boolean fecha = fechaVacia(FechaNacimientoEmpleado, errorEmpleados1);
        errores.addAll(validadorCheck.validarCamposVaciosLista(campos, booleanEmpleado, labels, nombresCampos));
        if (!errores.isEmpty() || !fecha) {
            StringBuilder mensajeError = new StringBuilder("Se encontraron los siguientes errores:\n");
            for (String error : errores) {
                mensajeError.append("- ").append(error).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensajeError.toString(), "Errores", JOptionPane.ERROR_MESSAGE);
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String fechaNacimiento = dateFormat.format(FechaNacimientoEmpleado.getDate());
            Empleados empleados = new Empleados(cnx); // Suponiendo que "cnx" es tu conexión a la base de datos
            registro = empleados.registrarEmpleado(CedulaEmpleado.getText(), NombreEmpleado.getText(), jTFApellidoEmpleado.getText(),
                    direccionEmpelado.getText(), fechaNacimiento,
                    (String) SexoEmpleado.getSelectedItem(), TelefonoConvencional.getText(),
                    TelefonoPersonal.getText(), CorreoElectronico.getText(), Cargo.getText());
            if (!registro) {

            } else {
                validadorCheck.limpiarCampos(campos);
                DefaultTableModel modelo = empleados.obtenerModeloTablaEmpleadosActualizar();
                jTableEmpleadosAcutalizar.setModel(modelo);

            }

        }

    }//GEN-LAST:event_BRegistrarActionPerformed

    private void CedulaEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CedulaEmpleadoKeyReleased
        cedulaEmpleadoValidar = validarRegistroF.camposDeRegistros(CedulaEmpleado, jLErrorEmpleado1, "cedula");
    }//GEN-LAST:event_CedulaEmpleadoKeyReleased

    private void CedulaEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CedulaEmpleadoKeyTyped
        char variable = evt.getKeyChar();
        if (Character.isLetter(variable)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo números");
        } else {
            String currentText = CedulaEmpleado.getText();
            if ((currentText + variable).length() >= 11) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_CedulaEmpleadoKeyTyped

    private void CedulaEmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CedulaEmpleadoFocusLost
        cedulaEmpleadoValidar = validarRegistroF.camposDeRegistros(CedulaEmpleado, jLErrorEmpleado1, "cedula");
    }//GEN-LAST:event_CedulaEmpleadoFocusLost

    private void jTPEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPEmpleadosMouseClicked
        Empleados empleados = new Empleados(cnx);
        DefaultTableModel modelo = empleados.obtenerModeloTablaEmpleadosActualizar();
        jTableEmpleadosAcutalizar.setModel(modelo);
    }//GEN-LAST:event_jTPEmpleadosMouseClicked

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActualizarActionPerformed
        ActualizarInventario actualizar = new ActualizarInventario();
        String atributoActualizar = "CI";
        String condicion = "'" + this.TFNCedulaActualizado.getText() + "'";//OJO
        String tabla = "empleados";
        List<String> camposInvalidos = new ArrayList<>();
        List<String> atributos = new ArrayList<>();

        if (this.jCCIActualizar.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(TFNCedulaActualizado, "CI")) {
                camposInvalidos.add("CI");
            }
        }
        if (this.jCDireccionActualizar.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(TFDireccionActualizado, "Dirección")) {
                camposInvalidos.add("Dirección");
            }
            atributos.add("direccion='" + TFDireccionActualizado.getText() + "'");
        }

        if (this.jCCargoActualizar.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(TFCargoActualizado, "Cargo")) {
                camposInvalidos.add("Cargo");
            }
            atributos.add("cargo='" + TFCargoActualizado.getText() + "'");
        }

        if (this.jCTelefonoCActualizar.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(TFTConvencionalActualizado, "Teléfono")) {
                camposInvalidos.add("Teléfono convencional");
            }
            atributos.add("telefono_convencional='" + TFTConvencionalActualizado.getText() + "'");
        }

        if (this.jCTelefonoPActualizar.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(TFTPersonalActualizado, "Teléfono personal")) {
                camposInvalidos.add("Teléfono personal");
            }
            atributos.add("telefono_movil='" + TFTPersonalActualizado.getText() + "'");
        }

        if (this.jCCorreoActualizar.isSelected()) {
            if (!validadorCheck.validarCampoNoVacio(TFEmailActualizado, "Correo")) {
                camposInvalidos.add("Correo");
            }
            atributos.add("correo_electronico='" + TFEmailActualizado.getText() + "'");
        }

        if (!jCDireccionActualizar.isSelected() && !jCCargoActualizar.isSelected() && !jCTelefonoCActualizar.isSelected()
                && !jCTelefonoPActualizar.isSelected() && !jCCorreoActualizar.isSelected()) {
            JOptionPane.showMessageDialog(this, "Seleccione al menos un atributo a actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            // Detiene el registro si no se selecciona ningún atributo
        } else {

            if (!camposInvalidos.isEmpty()) {
                String camposInvalidosStr = String.join(", ", camposInvalidos);
                JOptionPane.showMessageDialog(this, "Los siguientes campos están vacíos: " + camposInvalidosStr, "Error", JOptionPane.ERROR_MESSAGE);

                // Pinta de rojo los campos vacíos de forma parametrizada
                for (String campoInvalido : camposInvalidos) {
                    switch (campoInvalido) {
                        case "Dirección":
                            validadorCheck.setColorFondoCampo(TFDireccionActualizado, new Color(255, 204, 204), jLErrorEmpleado10);
                            break;
                        case "Cargo":
                            validadorCheck.setColorFondoCampo(TFCargoActualizado, new Color(255, 204, 204), jLErrorEmpleado9);
                            break;
                        case "Teléfono convencional":
                            validadorCheck.setColorFondoCampo(TFTConvencionalActualizado, new Color(255, 204, 204), jLErrorEmpleado11);
                            break;
                        case "Teléfono personal":
                            validadorCheck.setColorFondoCampo(TFTPersonalActualizado, new Color(255, 204, 204), jLErrorEmpleado12);
                            break;
                        case "Correo":
                            validadorCheck.setColorFondoCampo(TFEmailActualizado, new Color(255, 204, 204), jLErrorEmpleado13);
                            break;
                    }
                }
                return; // Detiene el registro si hay campos inválidos
            }
            String atributosActualizacion = String.join(", ", atributos);
            if (direccionEmpleadoValidar1 && correoEmpleadoValidar1 && telefonoEmpleadoValiar1
                    && telefonoConvenValidar1 && cargoEmpleadoValidar1) {
                actualizar.actualizarDatosF(this.cnx, atributoActualizar, condicion, tabla, atributosActualizacion);
                Empleados empleados = new Empleados(cnx);
                DefaultTableModel modelo = empleados.obtenerModeloTablaEmpleados(TFNCedulaActualizado.getText());
                jTableEmpleadosAcutalizar1.setModel(modelo);
                JTextField[] camposParaLimpiar = {TFNCedulaActualizado, TFNombresActualizado, TFApellidosActualizado, TFFNacimientoActualizado,
                    TFDireccionActualizado, TFCargoActualizado, TFTConvencionalActualizado,
                    TFTPersonalActualizado, TFEmailActualizado};
                validadorCheck.limpiarCampos(camposParaLimpiar);
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar actualizar. "
                        + "\nPor favor, verifica los campos e inténtalo nuevamente.", "Error en el registro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BActualizarActionPerformed

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

    private void SeleccionFacturaAtributoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionFacturaAtributoActionPerformed
        jTFAtributoC.setText("");
    }//GEN-LAST:event_SeleccionFacturaAtributoActionPerformed

    private void jTFTelefonoNegocioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFTelefonoNegocioFocusGained
        if (jTFTelefonoNegocio.getText().equals("Ejm: 02-1234567")) {
            jTFTelefonoNegocio.setText("");
            jTFTelefonoNegocio.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTFTelefonoNegocioFocusGained

    private void jTFNombreNegocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreNegocioKeyTyped
//        char c = evt.getKeyChar();
//        if (!Character.isLetterOrDigit(c) && c != KeyEvent.VK_SPACE) {
//            evt.consume(); // Evita que el carácter no válido se muestre en el campo de texto
//        }
    }//GEN-LAST:event_jTFNombreNegocioKeyTyped

    private void jDateChooserFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooserFechaMouseClicked
        jDateChooserFecha.setBackground(new Color(255, 204, 204)); // Color blanco
    }//GEN-LAST:event_jDateChooserFechaMouseClicked

    private void jTPesoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTPesoFocusLost
        pesoValidar = validarRegistroF.camposDeRegistros(jTPeso, errorInventario2, "precio");
    }//GEN-LAST:event_jTPesoFocusLost

    private void jTFnombreItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFnombreItemFocusLost
        nombreItemValidar1 = validarRegistroF.camposDeRegistros(jTFnombreItem, errorInventario4, "d");
    }//GEN-LAST:event_jTFnombreItemFocusLost

    private void jTFstockFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFstockFocusLost
        stockValidar1 = validarRegistroF.camposDeRegistros(jTFstock, errorInventario5, "v");
    }//GEN-LAST:event_jTFstockFocusLost
    public void cambiarValoresNego() {
        nombreNegocioValido = true;
        estadoPagoP = true;
        rucV = true;
        dirNeg = true;
        telefonoNeg = true;
    }

    public void cambiarValoresNegoP() {
        nombreNegocioValido2 = true;
        estadoPagoP2 = true;
        rucV2 = true;
        dirNeg2 = true;
        telefonoNeg2 = true;
    }

    public void cambiarValoresClienteP() {
        rucCliente2 = true;
        nombreCFactura2 = true;
        apellidoCFactura2 = true;
        telfCliente2 = true;
        dirCliente2 = true;
        correoElectronico2 = true;
    }

    public void cambiarValoresCliente() {
        rucCliente = true;
        nombreCFactura = true;
        apellidoCFactura = true;
        telfCliente = true;
        dirCliente = true;
        correoElectronico = true;
    }

    public void cambiarValoresVerdad1() {
        telfCliente1 = true;
        dirCliente1 = true;
        correoElectronico1 = true;
    }


    private void jTFNombresRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombresRKeyTyped
        int maxLength = 40; // Límite de longitud de caracteres
        if (jTFNombresR.getText().length() >= maxLength) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFNombresRKeyTyped

    private void jTFApellidosRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidosRKeyTyped
        int maxLength = 64; // Límite de longitud de caracteres
        if (jTFApellidosR.getText().length() >= maxLength) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFApellidosRKeyTyped

    private void jTNombreClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNombreClienteFocusLost
        nombreCFactura = validarRegistroF.camposDeRegistros(jTNombreCliente, jError8, "n");
    }//GEN-LAST:event_jTNombreClienteFocusLost

    private void jTFApeliidosClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFApeliidosClienteFocusLost
        apellidoCFactura = validarRegistroF.camposDeRegistros(jTFApeliidosCliente, jError9, "n");
    }//GEN-LAST:event_jTFApeliidosClienteFocusLost

    private void nombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProductoKeyReleased
        String valor = nombreProducto.getText();
        String campo = "nombreItem";
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaItemsID(cnx, valor, campo, "idItem", "item", "idItem");
        jTablaRegistrarFactura.setModel(modelo);
    }//GEN-LAST:event_nombreProductoKeyReleased

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

    private void jTFnumerofactura1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFnumerofactura1KeyTyped
        char variable = evt.getKeyChar();
        if (Character.isLetter(variable)) {
            getToolkit().beep();
            evt.consume();
            jTFnumerofactura1.requestFocus();
            JOptionPane.showMessageDialog(null, "Ingrese solo números");
        }
    }//GEN-LAST:event_jTFnumerofactura1KeyTyped

    private void jTFnumerofactura1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFnumerofactura1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFnumerofactura1KeyReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String valor = jTextField1.getText();
        String campo = "nombreItem";
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaItemsID(cnx, valor, campo, "idItem_copia", "item_copia", "idItem_copia");
        jTablaRegistrarFactura1.setModel(modelo);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTFRUCNegocio1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFRUCNegocio1FocusLost
        rucV2 = validarRegistroF.camposDeRegistros(jTFRUCNegocio1, errorP2, "b");
    }//GEN-LAST:event_jTFRUCNegocio1FocusLost

    private void jTFNombreNegocio1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFNombreNegocio1FocusLost
        nombreNegocioValido2 = validarRegistroF.camposDeRegistros(jTFNombreNegocio1, errorP1, "d");
    }//GEN-LAST:event_jTFNombreNegocio1FocusLost

    private void jTFDirNegocio1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFDirNegocio1FocusLost
        dirNeg2 = validarRegistroF.camposDeRegistros(jTFDirNegocio1, errorP3, "d");
    }//GEN-LAST:event_jTFDirNegocio1FocusLost

    private void jTCIDelCliente1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCIDelCliente1FocusLost
        String tipoCliente = (String) jCBSeleccionTipoCliente1.getSelectedItem();
        String natularJuridico = (String) jCBNaturalOJuridico1.getSelectedItem();
        rucCliente2 = validarRegistroF.camposCliente(jTCIDelCliente1, errorP7, tipoCliente, natularJuridico, "a");
    }//GEN-LAST:event_jTCIDelCliente1FocusLost

    private void jTNombreCliente1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNombreCliente1FocusLost
        nombreCFactura2 = validarRegistroF.camposDeRegistros(jTNombreCliente1, errorP8, "n");
    }//GEN-LAST:event_jTNombreCliente1FocusLost

    private void jTFApeliidosCliente1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFApeliidosCliente1FocusLost
        apellidoCFactura2 = validarRegistroF.camposDeRegistros(jTFApeliidosCliente1, errorP9, "n");
    }//GEN-LAST:event_jTFApeliidosCliente1FocusLost

    private void jTDireccionCliente1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTDireccionCliente1FocusLost
        dirCliente2 = validarRegistroF.camposDeRegistros(jTDireccionCliente1, errorP11, "d");
    }//GEN-LAST:event_jTDireccionCliente1FocusLost

    private void jCBEstadoPago1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEstadoPago1ActionPerformed
        String seleccion = (String) jCBEstadoPago1.getSelectedItem();
        if (!seleccion.equals("Selecciona")) {
            errorP6.setVisible(false);
        }
    }//GEN-LAST:event_jCBEstadoPago1ActionPerformed

    private void jCBNacionalExtranjero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBNacionalExtranjero2ActionPerformed
        String seleccion2 = (String) jCJuridicoNatural1.getSelectedItem();
        String seleccion = (String) jCBNacionalExtranjero2.getSelectedItem();
        if ("Natural".equals(seleccion2)) {
            if ("Nacional".equals(seleccion)) {
                CIselect.setText("CI");
                documentoActualizar.setText("CI");
            } else if ("Extranjero".equals(seleccion)) {
                CIselect.setText("Pasaporte");
                documentoActualizar.setText("Pasaporte");
            }
        } else if ("Jurídico".equals(seleccion2)) {
            CIselect.setText("RUC");
            documentoActualizar.setText("RUC");
        }

    }//GEN-LAST:event_jCBNacionalExtranjero2ActionPerformed

    private void jCJuridicoNatural1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCJuridicoNatural1ActionPerformed
        //jTFCIRegistrarC.setText("");
        String seleccion = (String) jCJuridicoNatural1.getSelectedItem();
        if ("Jurídico".equals(seleccion)) {
            CIselect.setText("RUC");
            documentoActualizar.setText("RUC");
        } else if ("Natural".equals(seleccion)) {
            String seleccionExtranjero = (String) jCBNacionalExtranjero.getSelectedItem();
            if ("Nacional".equals(seleccionExtranjero)) {
                CIselect.setText("CI");
                documentoActualizar.setText("CI");
            } else if ("Extranjero".equals(seleccionExtranjero)) {
                CIselect.setText("Pasaporte");
                documentoActualizar.setText("Pasaporte");
            }
        }
    }//GEN-LAST:event_jCJuridicoNatural1ActionPerformed

    private void telefonoActualizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoActualizarKeyReleased
        String tipoCliente = (String) jCBNacionalExtranjero2.getSelectedItem();
        telfCliente1 = validarRegistroF.camposCliente(telefonoActualizar, errorActualizarCliente1, tipoCliente, "Ninguno", "b");
    }//GEN-LAST:event_telefonoActualizarKeyReleased

    private void direccionActualizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionActualizarKeyReleased
        dirCliente1 = validarRegistroF.camposDeRegistros(direccionActualizar, errorActualizarCliente2, "d");
    }//GEN-LAST:event_direccionActualizarKeyReleased

    private void correoActualizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoActualizarKeyReleased
        correoElectronico1 = validarRegistroF.camposDeRegistros(correoActualizar, errorActualizarCliente3, "c");
    }//GEN-LAST:event_correoActualizarKeyReleased

    private void telefonoActualizarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonoActualizarFocusLost
        String tipoCliente = (String) jCBNacionalExtranjero2.getSelectedItem();
        telfCliente1 = validarRegistroF.camposCliente(telefonoActualizar, errorActualizarCliente1, tipoCliente, "Ninguno", "b");
    }//GEN-LAST:event_telefonoActualizarFocusLost

    private void direccionActualizarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_direccionActualizarFocusLost
        dirCliente1 = validarRegistroF.camposDeRegistros(direccionActualizar, errorActualizarCliente2, "d");
    }//GEN-LAST:event_direccionActualizarFocusLost

    private void correoActualizarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoActualizarFocusLost
        correoElectronico1 = validarRegistroF.camposDeRegistros(correoActualizar, errorActualizarCliente3, "c");
    }//GEN-LAST:event_correoActualizarFocusLost

    private void correoSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoSelectActionPerformed
        validadorCheck.actualizarCampo(correoSelect, correoActualizar, correoElectronico1, errorActualizarCliente3);
    }//GEN-LAST:event_correoSelectActionPerformed

    private void direccionSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionSelectActionPerformed
        validadorCheck.actualizarCampo(direccionSelect, direccionActualizar, dirCliente1, errorActualizarCliente2);
    }//GEN-LAST:event_direccionSelectActionPerformed

    private void telefonoSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoSelectActionPerformed
        validadorCheck.actualizarCampo(telefonoSelect, telefonoActualizar, telfCliente1, errorActualizarCliente1);
    }//GEN-LAST:event_telefonoSelectActionPerformed

    private void jCBNacionalExtranjero3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBNacionalExtranjero3ActionPerformed
        jTProveedorConsultar1.setText("");
        String seleccion2 = (String) jCJuridicoNatural2.getSelectedItem();
        String seleccion = (String) jCBNacionalExtranjero3.getSelectedItem();
        if ("Natural".equals(seleccion2)) {
            if ("Nacional".equals(seleccion)) {
                jLabel106.setText("CI");
            } else if ("Extranjero".equals(seleccion)) {
                jLabel106.setText("Pasaporte");
            }
        } else if ("Jurídico".equals(seleccion2)) {
            jLabel106.setText("RUC");
        }
    }//GEN-LAST:event_jCBNacionalExtranjero3ActionPerformed

    private void jCJuridicoNatural2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCJuridicoNatural2ActionPerformed
        jTProveedorConsultar1.setText("");
        String seleccion = (String) jCJuridicoNatural2.getSelectedItem();
        if ("Jurídico".equals(seleccion)) {
            jLabel106.setText("RUC");
        } else if ("Natural".equals(seleccion)) {
            String seleccionExtranjero = (String) jCJuridicoNatural2.getSelectedItem();
            if ("Nacional".equals(seleccionExtranjero)) {
                jLabel106.setText("CI");
            } else if ("Extranjero".equals(seleccionExtranjero)) {
                jLabel106.setText("Pasaporte");
            }
        }
    }//GEN-LAST:event_jCJuridicoNatural2ActionPerformed

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

    private void NombreEmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreEmpleadoFocusLost
        nombreEmpleadoValidar = validarRegistroF.camposDeRegistros(NombreEmpleado, jLErrorEmpleado2, "n");
    }//GEN-LAST:event_NombreEmpleadoFocusLost

    private void NombreEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreEmpleadoKeyReleased
        nombreEmpleadoValidar = validarRegistroF.camposDeRegistros(NombreEmpleado, jLErrorEmpleado2, "n");
    }//GEN-LAST:event_NombreEmpleadoKeyReleased

    private void jTFApellidoEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidoEmpleadoKeyReleased

        apellidoEmpleadoValidar = validarRegistroF.camposDeRegistros(jTFApellidoEmpleado, jLErrorEmpleado3, "n");
    }//GEN-LAST:event_jTFApellidoEmpleadoKeyReleased

    private void jTFApellidoEmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFApellidoEmpleadoFocusLost
        apellidoEmpleadoValidar = validarRegistroF.camposDeRegistros(jTFApellidoEmpleado, jLErrorEmpleado3, "n");
    }//GEN-LAST:event_jTFApellidoEmpleadoFocusLost

    private void CargoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CargoFocusLost
        cargoEmpleadoValidar = validarRegistroF.camposDeRegistros(Cargo, jLErrorEmpleado4, "n");
    }//GEN-LAST:event_CargoFocusLost

    private void CargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CargoKeyReleased
        cargoEmpleadoValidar = validarRegistroF.camposDeRegistros(Cargo, jLErrorEmpleado4, "n");
    }//GEN-LAST:event_CargoKeyReleased

    private void direccionEmpeladoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_direccionEmpeladoFocusLost
        direccionEmpleadoValidar = validarRegistroF.camposDeRegistros(direccionEmpelado, jLErrorEmpleado5, "d");
    }//GEN-LAST:event_direccionEmpeladoFocusLost

    private void direccionEmpeladoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionEmpeladoKeyReleased
        direccionEmpleadoValidar = validarRegistroF.camposDeRegistros(direccionEmpelado, jLErrorEmpleado5, "d");
    }//GEN-LAST:event_direccionEmpeladoKeyReleased

    private void TelefonoConvencionalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TelefonoConvencionalFocusLost
        telefonoConvenValidar = validarRegistroF.camposDeRegistros(TelefonoConvencional, jLErrorEmpleado6, "t");
    }//GEN-LAST:event_TelefonoConvencionalFocusLost

    private void TelefonoPersonalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TelefonoPersonalFocusLost

        telefonoEmpleadoValiar = validarRegistroF.camposDeRegistros(TelefonoPersonal, jLErrorEmpleado7, "telefono");
    }//GEN-LAST:event_TelefonoPersonalFocusLost

    private void TelefonoConvencionalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelefonoConvencionalKeyReleased
        telefonoConvenValidar = validarRegistroF.camposDeRegistros(TelefonoConvencional, jLErrorEmpleado6, "t");
    }//GEN-LAST:event_TelefonoConvencionalKeyReleased

    private void TelefonoPersonalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelefonoPersonalKeyReleased
        telefonoEmpleadoValiar = validarRegistroF.camposDeRegistros(TelefonoPersonal, jLErrorEmpleado7, "telefono");
    }//GEN-LAST:event_TelefonoPersonalKeyReleased

    private void CorreoElectronicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CorreoElectronicoFocusLost
        correoEmpleadoValidar = validarRegistroF.camposDeRegistros(CorreoElectronico, jLErrorEmpleado8, "c");
    }//GEN-LAST:event_CorreoElectronicoFocusLost

    private void CorreoElectronicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CorreoElectronicoKeyReleased
        correoEmpleadoValidar = validarRegistroF.camposDeRegistros(CorreoElectronico, jLErrorEmpleado8, "c");
    }//GEN-LAST:event_CorreoElectronicoKeyReleased

    private void jCDireccionActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCDireccionActualizarActionPerformed
        validadorCheck.actualizarCampo(jCDireccionActualizar, TFDireccionActualizado, direccionEmpleadoValidar1, jLErrorEmpleado10);
    }//GEN-LAST:event_jCDireccionActualizarActionPerformed

    private void TFDireccionActualizadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFDireccionActualizadoFocusLost
        direccionEmpleadoValidar1 = validarRegistroF.camposDeRegistros(TFDireccionActualizado, jLErrorEmpleado10, "d");
    }//GEN-LAST:event_TFDireccionActualizadoFocusLost

    private void TFDireccionActualizadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFDireccionActualizadoKeyReleased
        direccionEmpleadoValidar1 = validarRegistroF.camposDeRegistros(TFDireccionActualizado, jLErrorEmpleado10, "d");
    }//GEN-LAST:event_TFDireccionActualizadoKeyReleased

    private void TFTConvencionalActualizadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFTConvencionalActualizadoKeyReleased
        telefonoConvenValidar1 = validarRegistroF.camposDeRegistros(TFTConvencionalActualizado, jLErrorEmpleado11, "t");
    }//GEN-LAST:event_TFTConvencionalActualizadoKeyReleased

    private void TFTConvencionalActualizadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFTConvencionalActualizadoFocusLost
        telefonoConvenValidar1 = validarRegistroF.camposDeRegistros(TFTConvencionalActualizado, jLErrorEmpleado11, "t");
    }//GEN-LAST:event_TFTConvencionalActualizadoFocusLost

    private void TFTPersonalActualizadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFTPersonalActualizadoFocusLost

        telefonoEmpleadoValiar1 = validarRegistroF.camposDeRegistros(TFTPersonalActualizado, jLErrorEmpleado12, "telefono");
    }//GEN-LAST:event_TFTPersonalActualizadoFocusLost

    private void TFTPersonalActualizadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFTPersonalActualizadoKeyReleased
        telefonoEmpleadoValiar1 = validarRegistroF.camposDeRegistros(TFTPersonalActualizado, jLErrorEmpleado12, "telefono");
    }//GEN-LAST:event_TFTPersonalActualizadoKeyReleased

    private void TFEmailActualizadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFEmailActualizadoKeyReleased
        correoEmpleadoValidar1 = validarRegistroF.camposDeRegistros(TFEmailActualizado, jLErrorEmpleado13, "c");
    }//GEN-LAST:event_TFEmailActualizadoKeyReleased

    private void TFEmailActualizadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFEmailActualizadoFocusLost
        correoEmpleadoValidar1 = validarRegistroF.camposDeRegistros(TFEmailActualizado, jLErrorEmpleado13, "c");
    }//GEN-LAST:event_TFEmailActualizadoFocusLost

    private void jTFIBuscadorAct5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscadorAct5KeyReleased
        String CIbuscar = jTFIBuscadorAct5.getText();
        Empleados empleados = new Empleados(cnx);
        DefaultTableModel modelo = empleados.obtenerModeloTablaEmpleados(CIbuscar);
        jTableEmpleadosAcutalizar1.setModel(modelo);
    }//GEN-LAST:event_jTFIBuscadorAct5KeyReleased

    private void jTFIBuscadorAct5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscadorAct5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIBuscadorAct5KeyTyped

    private void jTableEmpleadosAcutalizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpleadosAcutalizar1MouseClicked
        int filaSeleccionada = jTableEmpleadosAcutalizar1.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel model = (DefaultTableModel) jTableEmpleadosAcutalizar1.getModel();
            for (int i = 0; i < model.getColumnCount(); i++) {
                String columnName = model.getColumnName(i);
                if (columnName.equals("CI")
                        || columnName.equals("Nombres") || columnName.equals("Apellidos")
                        || columnName.equals("Dirección")
                        || columnName.equals("Fecha de Nacimiento") || columnName.equals("Sexo")
                        || columnName.equals("Teléfono Convencional") || columnName.equals("Teléfono personal")
                        || columnName.equals("Correo Electrónico") || columnName.equals("Cargo")) {

                    String idCliente = getValueAtSelectedRow(model, filaSeleccionada, "CI");
                    String nombreCliente = getValueAtSelectedRow(model, filaSeleccionada, "Nombres");
                    String apellido = getValueAtSelectedRow(model, filaSeleccionada, "Apellidos");
                    String direccion = getValueAtSelectedRow(model, filaSeleccionada, "Dirección");
                    String fechaN = getValueAtSelectedRow(model, filaSeleccionada, "Fecha de Nacimiento");
                    String sexo = getValueAtSelectedRow(model, filaSeleccionada, "Sexo");
                    String telefonoConver = getValueAtSelectedRow(model, filaSeleccionada, "Teléfono Convencional");
                    String telefonoM = getValueAtSelectedRow(model, filaSeleccionada, "Teléfono personal");
                    String correo = getValueAtSelectedRow(model, filaSeleccionada, "Correo Electrónico");
                    String cargo = getValueAtSelectedRow(model, filaSeleccionada, "Cargo");
                    TFNCedulaActualizado.setText(idCliente);
                    TFNombresActualizado.setText(nombreCliente);
                    TFApellidosActualizado.setText(apellido);
                    TFFNacimientoActualizado.setText(fechaN);
                    if (sexo.equals("Femenino")) {
                        CBSexoActualizado.setSelectedItem("Femenino");
                    } else {
                        CBSexoActualizado.setSelectedItem("Masculino");
                    }

                    validadorCheck.actualizarCampoSeleccionado(jCDireccionActualizar, direccion, TFDireccionActualizado, jLErrorEmpleado10);
                    validadorCheck.actualizarCampoSeleccionado(jCTelefonoPActualizar, telefonoM, TFTPersonalActualizado, jLErrorEmpleado12);
                    validadorCheck.actualizarCampoSeleccionado(jCTelefonoCActualizar, telefonoConver, TFTConvencionalActualizado, jLErrorEmpleado11);
                    validadorCheck.actualizarCampoSeleccionado(jCCorreoActualizar, correo, TFEmailActualizado, jLErrorEmpleado13);
                    validadorCheck.actualizarCampoSeleccionado(jCCargoActualizar, cargo, TFCargoActualizado, jLErrorEmpleado9);
                    Boolean[] booleanosEmpleado = {direccionEmpleadoValidar1, cargoEmpleadoValidar1, telefonoConvenValidar1,
                        telefonoEmpleadoValiar1, correoEmpleadoValidar1};
                    booleanosEmpleado = validadorCheck.cambiarValoresVerdadFinal(booleanosEmpleado);
                    direccionEmpleadoValidar1 = booleanosEmpleado[0];
                    cargoEmpleadoValidar1 = booleanosEmpleado[1];
                    telefonoConvenValidar1 = booleanosEmpleado[2];
                    telefonoEmpleadoValiar1 = booleanosEmpleado[3];
                    correoEmpleadoValidar1 = booleanosEmpleado[4];
                    break; // Sale del bucle una vez que se haya encontrado una columna válida                 
                }
            }
        }
    }//GEN-LAST:event_jTableEmpleadosAcutalizar1MouseClicked

    private void jCCargoActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCargoActualizarActionPerformed
        validadorCheck.actualizarCampo(jCCargoActualizar, TFCargoActualizado, cargoEmpleadoValidar1, jLErrorEmpleado9);
    }//GEN-LAST:event_jCCargoActualizarActionPerformed

    private void jCTelefonoCActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTelefonoCActualizarActionPerformed
        validadorCheck.actualizarCampo(jCTelefonoCActualizar, TFTConvencionalActualizado, telefonoConvenValidar1, jLErrorEmpleado11);
    }//GEN-LAST:event_jCTelefonoCActualizarActionPerformed

    private void jCTelefonoPActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTelefonoPActualizarActionPerformed
        validadorCheck.actualizarCampo(jCTelefonoPActualizar, TFTPersonalActualizado, telefonoEmpleadoValiar1, jLErrorEmpleado12);
    }//GEN-LAST:event_jCTelefonoPActualizarActionPerformed

    private void jCCorreoActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCorreoActualizarActionPerformed
        validadorCheck.actualizarCampo(jCCorreoActualizar, TFEmailActualizado, correoEmpleadoValidar1, jLErrorEmpleado13);
    }//GEN-LAST:event_jCCorreoActualizarActionPerformed

    private void TFCargoActualizadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFCargoActualizadoFocusLost
        cargoEmpleadoValidar1 = validarRegistroF.camposDeRegistros(TFCargoActualizado, jLErrorEmpleado9, "n");
    }//GEN-LAST:event_TFCargoActualizadoFocusLost

    private void TFCargoActualizadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFCargoActualizadoKeyTyped
        cargoEmpleadoValidar1 = validarRegistroF.camposDeRegistros(TFCargoActualizado, jLErrorEmpleado9, "n");
    }//GEN-LAST:event_TFCargoActualizadoKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String CIbuscar = TFConsultarEmpleado1.getText();
        Empleados empleados = new Empleados(cnx);
        DefaultTableModel modelo = empleados.obtenerModeloTablaEmpleados(CIbuscar);
        jTableEmpleadosAcutalizar2.setModel(modelo);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String campo = (String) CBConsultarEmpleado.getSelectedItem();
        String atributo = "";
        switch (campo) {
            case "Apellidos" -> {
                atributo = "apellidos";
            }
            case "Nombres" -> {
                atributo = "nombres";
            }
            case "Direccón" -> {
                atributo = "direccion";
            }
            case "Teléfono convencional" -> {
                atributo = "telefono_convencional";
            }
            case "Teléfono personal" -> {
                atributo = "telefono_movil";
            }
            case "Cargo" -> {
                atributo = "cargo";
            }

            case "Correo electrónico" -> {
                atributo = "correo";
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Ingrese un campo valido");
                return;
            }

        }

        if (campo.equals("Selecciona")) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un campo válido.");
            return; // Detener la ejecución si no se ha seleccionado un campo válido
        }

        String valor = TFConsultarEmpleado.getText();
        if (valor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa un valor");
            return; // Detener la ejecución si el campo de valor está vacío
        }

        Empleados empleado = new Empleados(cnx);
        DefaultTableModel modelo = empleado.buscarEmpleado(cnx, atributo, valor);
        jTableEmpleadosAcutalizar2.setModel(modelo);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BBuscarEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBuscarEliminarActionPerformed
        String CIEmpleado = TFNCedulaBuscar1.getText();
        Empleados empleado = new Empleados(cnx);
        if (CIEmpleado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa el número de cédula de un empleado");
            return;
        }
        String nuevoEstado = "";
        String estadoActual = empleado.obtenerEstadoEmpleado(CIEmpleado);
        int respuesta;
        if (estadoActual.equals("Desconocido")) {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado en la base datos.");
        } else {
            if ("Dado de baja".equals(estadoActual)) {
                nuevoEstado = "Activo";
            } else if ("Activo".equals(estadoActual)) {
                nuevoEstado = "Dado de baja";
            }
            if (!nuevoEstado.isEmpty()) {
                respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas cambiar el estado a '" + nuevoEstado + "'?", "Confirmar Cambio de Estado", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    empleado.cambiarEstadoEmpleado(CIEmpleado, nuevoEstado);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Estado desconocido del elemento.");
            }
            DefaultTableModel modelo = empleado.obtenerModeloTablaEmpleados1(CIEmpleado); // Llamas al método con el filtro
            jTableEmpleadosAcutalizar3.setModel(modelo); // Actualizas la tabla con el nuevo modelo 
        }


    }//GEN-LAST:event_BBuscarEliminarActionPerformed

    private void TFNCedulaBuscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFNCedulaBuscar1KeyReleased
        String CIbuscar = TFNCedulaBuscar1.getText();
        Empleados empleados = new Empleados(cnx);
        DefaultTableModel modelo = empleados.obtenerModeloTablaEmpleados1(CIbuscar);
        jTableEmpleadosAcutalizar3.setModel(modelo);
    }//GEN-LAST:event_TFNCedulaBuscar1KeyReleased


    private void jTRUCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTRUCKeyReleased
        rucProve = validarRegistroF.camposDeRegistros(jTRUC, errorProveedores1, "b");

        String NRUC = jTRUC.getText();
        Proveedores prov = new Proveedores();
        DefaultTableModel modelo = prov.mostrarListaP(cnx, NRUC);
        jTablaProveedoresR.setModel(modelo);
    }//GEN-LAST:event_jTRUCKeyReleased

    private void jTRUCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTRUCFocusLost
        rucProve = validarRegistroF.camposDeRegistros(jTRUC, errorProveedores1, "b");
    }//GEN-LAST:event_jTRUCFocusLost

    private void jTNombreEmpresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreEmpresaKeyReleased
        nombreEmpresaProve = validarRegistroF.camposDeRegistros(jTNombreEmpresa, errorProveedores2, "d");
    }//GEN-LAST:event_jTNombreEmpresaKeyReleased

    private void jTNombreEmpresaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNombreEmpresaFocusLost
        nombreEmpresaProve = validarRegistroF.camposDeRegistros(jTNombreEmpresa, errorProveedores2, "d");
    }//GEN-LAST:event_jTNombreEmpresaFocusLost

    private void jTNombreDespachadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreDespachadorKeyReleased
        nombreProve = validarRegistroF.camposDeRegistros(jTNombreDespachador, errorProveedores4, "n");
    }//GEN-LAST:event_jTNombreDespachadorKeyReleased

    private void jTNombreDespachadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNombreDespachadorFocusLost
        nombreProve = validarRegistroF.camposDeRegistros(jTNombreDespachador, errorProveedores4, "n");
    }//GEN-LAST:event_jTNombreDespachadorFocusLost

    private void jTApellidoDespachadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTApellidoDespachadorKeyReleased
        apellidoProve = validarRegistroF.camposDeRegistros(jTApellidoDespachador, errorProveedores5, "n");
    }//GEN-LAST:event_jTApellidoDespachadorKeyReleased

    private void jTApellidoDespachadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTApellidoDespachadorFocusLost
        apellidoProve = validarRegistroF.camposDeRegistros(jTApellidoDespachador, errorProveedores5, "n");
    }//GEN-LAST:event_jTApellidoDespachadorFocusLost

    private void jTCedulaDespachadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCedulaDespachadorFocusLost
        cedulaProve = validarRegistroF.camposDeRegistros(jTCedulaDespachador, errorProveedores3, "cedula");
    }//GEN-LAST:event_jTCedulaDespachadorFocusLost

    private void jTCedulaDespachadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCedulaDespachadorKeyReleased
        cedulaProve = validarRegistroF.camposDeRegistros(jTCedulaDespachador, errorProveedores3, "cedula");
    }//GEN-LAST:event_jTCedulaDespachadorKeyReleased

    private void jTFTelefonoProvedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoProvedorKeyReleased
        telefonoProve = validarRegistroF.camposDeRegistros(jTFTelefonoProvedor, errorProveedores6, "telefono");
    }//GEN-LAST:event_jTFTelefonoProvedorKeyReleased

    private void jTFTelefonoProvedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFTelefonoProvedorFocusLost
        telefonoProve = validarRegistroF.camposDeRegistros(jTFTelefonoProvedor, errorProveedores6, "telefono");
    }//GEN-LAST:event_jTFTelefonoProvedorFocusLost

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        JTextField[] campos = {jTRUC, jTNombreEmpresa, jTCedulaDespachador, jTNombreDespachador,
            jTApellidoDespachador, jTFTelefonoProvedor};
        int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Desea terminar con el registro del proveedor?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            validadorCheck.limpiarCampos(campos);
            jBAgregarProductoProveedores.setEnabled(false);
            jBQuitarProductoProveedores.setEnabled(false);
            jBRegistrarProovedor.setEnabled(true);
            jButton8.setEnabled(false);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jBAgregarProductoProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarProductoProveedoresActionPerformed
        int idItem = Integer.parseInt(jTCodigoProducto.getText());
        String idItemText = jTCodigoProducto.getText().trim();
        String nombreItem = jTNombreProducto.getText();
        String ciDespachador = jTCedulaDespachador.getText();
        // Crear una instancia de Proovedores (asegúrate de tenerla correctamente inicializada)
        Proveedores prov = new Proveedores();
        if (idItemText.isEmpty() || nombreItem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el ID del item y el nombre del item.");
            return;
        }
        if (prov.existeProductoDetalleEntrega(cnx, idItem, ciDespachador)) {
            JOptionPane.showMessageDialog(null, "El producto ya estra agregado");
        } else {
            prov.agregarProductoDetalleEntrega(cnx, idItem, nombreItem, ciDespachador);
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
        }
        DefaultTableModel modelo = prov.mostrarListaProductos(cnx, ciDespachador);
        jTablaProveedoresR.setModel(modelo);

    }//GEN-LAST:event_jBAgregarProductoProveedoresActionPerformed

    private void jBQuitarProductoProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitarProductoProveedoresActionPerformed
        int idItem = Integer.parseInt(jTCodigoProducto.getText());
        String ciDespachador = jTCedulaDespachador.getText();
        String idItemText = jTCodigoProducto.getText().trim();

        if (idItemText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el ID del item");
            return;
        }
        // Crear una instancia de Proovedores (asegúrate de tenerla correctamente inicializada)
        Proveedores prov = new Proveedores();

        if (prov.existeProductoDetalleEntrega(cnx, idItem, ciDespachador)) {
            prov.quitarProductoDetalleEntrega(cnx, idItem, ciDespachador);
        } else {
            // Si el producto no existe, agregar una nueva fila   
            JOptionPane.showMessageDialog(null, "No existe el producto.");
        }
        DefaultTableModel modelo = prov.mostrarListaProductos(cnx, ciDespachador);
        jTablaProveedoresR.setModel(modelo);

    }//GEN-LAST:event_jBQuitarProductoProveedoresActionPerformed

    private void jTablaProveedoresRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaProveedoresRMouseClicked
        JTextField[] campos = {jTRUC, jTNombreEmpresa, jTCedulaDespachador, jTNombreDespachador,
            jTApellidoDespachador, jTFTelefonoProvedor};
        JLabel[] labels = {errorProveedores1, errorProveedores2, errorProveedores3,
            errorProveedores4, errorProveedores5, errorProveedores6};

        int filaSeleccionada = jTablaProveedoresR.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel model = (DefaultTableModel) jTablaProveedoresR.getModel();
            boolean foundColumn = false;

            // Recorre todas las columnas del modelo
            for (int i = 0; i < model.getColumnCount(); i++) {
                String columnName = model.getColumnName(i);
                if (columnName.equals("RUC del proveedor")
                        || columnName.equals("Empresa") || columnName.equals("CI Despachador")
                        || columnName.equals("Nombre Despachador")
                        || columnName.equals("Apellido Despachador") || columnName.equals("Número de Teléfono")) {
                    String NRuc = getValueAtSelectedRow(model, filaSeleccionada, "RUC del proveedor");
                    String NEmpresa = getValueAtSelectedRow(model, filaSeleccionada, "Empresa");
                    String ciDespachador = getValueAtSelectedRow(model, filaSeleccionada, "CI Despachador");
                    String nombreDespachador = getValueAtSelectedRow(model, filaSeleccionada, "Nombre Despachador");
                    String apellidoDespachador = getValueAtSelectedRow(model, filaSeleccionada, "Apellido Despachador");
                    String numeroDespachador = getValueAtSelectedRow(model, filaSeleccionada, "Número de Teléfono");
                    jTRUC.setText(NRuc);
                    jTNombreEmpresa.setText(NEmpresa);
                    jTCedulaDespachador.setText(ciDespachador);
                    jTNombreDespachador.setText(nombreDespachador);
                    jTApellidoDespachador.setText(apellidoDespachador);
                    jTFTelefonoProvedor.setText(numeroDespachador);
                    rucProve = true;
                    nombreEmpresaProve = true;
                    cedulaProve = true;
                    nombreProve = true;
                    apellidoProve = true;
                    telefonoProve = true;
                    Boolean[] boleannosProvedores = {rucProve, nombreEmpresaProve, cedulaProve,
                        nombreProve, apellidoProve, telefonoProve};
                    validadorCheck.validarCampos(campos, boleannosProvedores, labels);
                    validadorCheck.validarCamposVacios(campos, boleannosProvedores, labels);
                    foundColumn = true;
                    break; // Sale del bucle una vez que se haya encontrado una columna válida
                }
            }
            if (!foundColumn) {
            }
        }
    }//GEN-LAST:event_jTablaProveedoresRMouseClicked
    public Boolean[] cambiarValoresVerdad(Boolean[] valores) {
        for (int i = 0; i < valores.length; i++) {
            valores[i] = true;
        }
        return valores;
    }

    private void jTCodigoProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCodigoProductoKeyReleased
        String valor = jTCodigoProducto.getText();
        String campo = "idItem";
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaItemsID(cnx, valor, campo, "idItem", "item", "idItem");
        jTablaProveedoresR.setModel(modelo);
    }//GEN-LAST:event_jTCodigoProductoKeyReleased

    private void jTNombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreProductoKeyReleased
        String valor = jTNombreProducto.getText();
        String campo = "nombreItem";
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaItemsID(cnx, valor, campo, "idItem", "item", "idItem");
        jTablaProveedoresR.setModel(modelo);
    }//GEN-LAST:event_jTNombreProductoKeyReleased

    private void jBCambiarEstadoProveedor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCambiarEstadoProveedor2ActionPerformed
        String CIDespachador = jTCedulaDespachadorCE1.getText();
        if (CIDespachador.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor");
            return;
        }
        Proveedores prov = new Proveedores();
        prov.cambiarEstadoDespachador(cnx, CIDespachador);
        DefaultTableModel model = prov.buscarDespachador(cnx, CIDespachador);
        jTablaProveedoresCE.setModel(model);
    }//GEN-LAST:event_jBCambiarEstadoProveedor2ActionPerformed

    private void jTCedulaDespachadorCE1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCedulaDespachadorCE1KeyReleased
        String CIDespachador = jTCedulaDespachadorCE1.getText();
        Proveedores prov = new Proveedores();
        DefaultTableModel model = prov.buscarDespachador(cnx, CIDespachador);
        jTablaProveedoresCE.setModel(model);
    }//GEN-LAST:event_jTCedulaDespachadorCE1KeyReleased

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        validadorCheck.actualizarCampo(jCheckBox2, jTNombreEmpresaAct, nombreEmpresaProve1, errorProveedores8);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jTCodigoProducto1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCodigoProducto1KeyReleased
        String valor = jTCodigoProducto1.getText();
        String campo = "idItem";
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaItemsID(cnx, valor, campo, "idItem", "item", "idItem");
        jTablaProveedoresA.setModel(modelo);
    }//GEN-LAST:event_jTCodigoProducto1KeyReleased

    private void jTNombreProducto1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreProducto1KeyReleased
        String valor = jTNombreProducto1.getText();
        String campo = "nombreItem";
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarTablaItemsID(cnx, valor, campo, "idItem", "item", "idItem");
        jTablaProveedoresA.setModel(modelo);
    }//GEN-LAST:event_jTNombreProducto1KeyReleased

    private void jBAgregarProductoProveedores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarProductoProveedores1ActionPerformed
        int idItem = Integer.parseInt(jTCodigoProducto1.getText());
        String idItemText = jTCodigoProducto1.getText().trim();
        String nombreItem = jTNombreProducto1.getText();
        String ciDespachador = jTCedulaDespachadorAct.getText();
        // Crear una instancia de Proovedores (asegúrate de tenerla correctamente inicializada)
        Proveedores prov = new Proveedores();
        if (idItemText.isEmpty() || nombreItem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el ID del item y el nombre del item.");
            return;
        }

        if (prov.existeProductoDetalleEntrega(cnx, idItem, ciDespachador)) {
            JOptionPane.showMessageDialog(null, "El producto ya estra agregado");
        } else {
            prov.agregarProductoDetalleEntrega(cnx, idItem, nombreItem, ciDespachador);
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
        }
        DefaultTableModel modelo = prov.mostrarListaProductos(cnx, ciDespachador);
        jTablaProveedoresA.setModel(modelo);
        jTCodigoProducto1.setText("");
        jTNombreProducto1.setText("");
    }//GEN-LAST:event_jBAgregarProductoProveedores1ActionPerformed

    private void jBQuitarProductoProveedores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitarProductoProveedores1ActionPerformed
        int idItem = Integer.parseInt(jTCodigoProducto1.getText());
        String ciDespachador = jTCedulaDespachadorAct.getText();
        String idItemText = jTCodigoProducto1.getText().trim();

        if (idItemText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el ID del item");
            return;
        }
        Proveedores prov = new Proveedores();
        if (prov.existeProductoDetalleEntrega(cnx, idItem, ciDespachador)) {
            prov.quitarProductoDetalleEntrega(cnx, idItem, ciDespachador);
        } else {
            // Si el producto no existe, agregar una nueva fila   
            JOptionPane.showMessageDialog(null, "No existe el producto.");
        }
        DefaultTableModel modelo = prov.mostrarListaProductos(cnx, ciDespachador);
        jTablaProveedoresR.setModel(modelo);
        jTCodigoProducto1.setText("");
        jTNombreProducto1.setText("");
    }//GEN-LAST:event_jBQuitarProductoProveedores1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de actualizar estos datos?", "Confirmación", JOptionPane.YES_NO_OPTION);
        boolean atributosSeleccionados = false;
        String ruc = jTRUCAct.getText();
        String nombreEmpresa = jTNombreEmpresaAct.getText();
        String telefonoDes = jTATelefonoDespachador.getText();
        String ciDespachador = jTCedulaDespachadorAct.getText();
        if (this.jCheckBox2.isSelected()) {
            atributosSeleccionados = true;
            if (jTNombreEmpresaAct.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo 'Nombre de la empresa' no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            nombreEmpresaProve1 = true;
        }

        if (this.jCheckBox8.isSelected()) {
            atributosSeleccionados = true;
            if (jTATelefonoDespachador.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo 'Teléfono' no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            telefonoProve1 = true;
        }

        if (!atributosSeleccionados) {
            JOptionPane.showMessageDialog(this, "Seleccione al menos un atributo", "Error", JOptionPane.ERROR_MESSAGE);
            return;

        } else {
            if ((nombreEmpresaProve1 && telefonoProve1) && (jCheckBox2.isSelected() || jCheckBox8.isSelected())) {
                if (respuesta == JOptionPane.YES_OPTION) {
                    Proveedores prov = new Proveedores();
                    prov.actualizarTablas(cnx, ruc, nombreEmpresa, telefonoDes, ciDespachador);
                    DefaultTableModel modelo = prov.mostrarListaP(cnx, jTRUCAct.getText());
                    jTablaProveedoresA.setModel(modelo);
                    jBAgregarProductoProveedores1.setEnabled(true);
                    jBQuitarProductoProveedores1.setEnabled(true);
                    jButton2.setEnabled(false);
                    jBIActualizarAct.setEnabled(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Revise los campos");
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTNombreEmpresaActFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNombreEmpresaActFocusLost
        nombreEmpresaProve1 = validarRegistroF.camposDeRegistros(jTNombreEmpresaAct, errorProveedores8, "d");
    }//GEN-LAST:event_jTNombreEmpresaActFocusLost

    private void jTATelefonoDespachadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTATelefonoDespachadorFocusLost
        telefonoProve1 = validarRegistroF.camposDeRegistros(jTATelefonoDespachador, errorProveedores7, "telefono");
    }//GEN-LAST:event_jTATelefonoDespachadorFocusLost

    private void jTATelefonoDespachadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTATelefonoDespachadorKeyReleased
        telefonoProve1 = validarRegistroF.camposDeRegistros(jTATelefonoDespachador, errorProveedores7, "telefono");
    }//GEN-LAST:event_jTATelefonoDespachadorKeyReleased

    private void jTNombreEmpresaActKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreEmpresaActKeyReleased
        nombreEmpresaProve1 = validarRegistroF.camposDeRegistros(jTNombreEmpresaAct, errorProveedores8, "d");
    }//GEN-LAST:event_jTNombreEmpresaActKeyReleased

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        validadorCheck.actualizarCampo(jCheckBox8, jTATelefonoDespachador, telefonoProve1, errorProveedores7);
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jTFCIRegistrarCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFCIRegistrarCFocusLost
        String idCliente = jTFCIRegistrarC.getText();
        RegistrarDatosFactura registrar = new RegistrarDatosFactura();
        if (registrar.clienteYaRegistrado(cnx, idCliente)) {
            JOptionPane.showMessageDialog(this, "Cliente ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        String tipoCliente = (String) jCBNacionalExtranjero.getSelectedItem();
        String natularJuridico = (String) jCJuridicoNatural.getSelectedItem();
        documentoCliente = validarRegistroF.camposCliente(jTCIDelCliente, jError7, tipoCliente, natularJuridico, "a");
    }//GEN-LAST:event_jTFCIRegistrarCFocusLost

    private void jTPesoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesoKeyReleased
        pesoValidar = validarRegistroF.camposDeRegistros(jTPeso, errorInventario2, "precio");
    }//GEN-LAST:event_jTPesoKeyReleased

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

    private void jTFNombreNegocioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreNegocioKeyReleased
        nombreNegocioValido = validarRegistroF.camposDeRegistros(jTFNombreNegocio, jError1, "d");
    }//GEN-LAST:event_jTFNombreNegocioKeyReleased

    private void jTFDirNegocioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDirNegocioKeyReleased
        dirNeg = validarRegistroF.camposDeRegistros(jTFDirNegocio, jError3, "d");
    }//GEN-LAST:event_jTFDirNegocioKeyReleased

    private void jTFTelefonoNegocioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoNegocioKeyReleased
        telefonoNeg = validarRegistroF.camposDeRegistros(jTFTelefonoNegocio, jError4, "t");
    }//GEN-LAST:event_jTFTelefonoNegocioKeyReleased

    private void jTTelefonoClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTelefonoClienteKeyReleased
        String tipoCliente = (String) jCBNacionalExtranjero1.getSelectedItem();
        telfCliente = validarRegistroF.camposCliente(jTTelefonoCliente, jError10, tipoCliente, "Ninguno", "b");
    }//GEN-LAST:event_jTTelefonoClienteKeyReleased

    private void jTNombreClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreClienteKeyReleased
        nombreCFactura = validarRegistroF.camposDeRegistros(jTNombreCliente, jError8, "n");
    }//GEN-LAST:event_jTNombreClienteKeyReleased

    private void jTDireccionClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDireccionClienteKeyReleased
        dirCliente = validarRegistroF.camposDeRegistros(jTDireccionCliente, jError11, "d");
    }//GEN-LAST:event_jTDireccionClienteKeyReleased

    private void correoCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoCliKeyReleased
        correoElectronico = validarRegistroF.camposDeRegistros(correoCli, jError12, "c");
    }//GEN-LAST:event_correoCliKeyReleased

    private void jTFApeliidosClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApeliidosClienteKeyReleased
        apellidoCFactura = validarRegistroF.camposDeRegistros(jTFApeliidosCliente, jError9, "n");
    }//GEN-LAST:event_jTFApeliidosClienteKeyReleased

    private void jTFNombreNegocio1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreNegocio1KeyReleased
        nombreNegocioValido2 = validarRegistroF.camposDeRegistros(jTFNombreNegocio1, errorP1, "d");
    }//GEN-LAST:event_jTFNombreNegocio1KeyReleased

    private void jTFDirNegocio1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDirNegocio1KeyReleased
        dirNeg2 = validarRegistroF.camposDeRegistros(jTFDirNegocio1, errorP3, "d");
    }//GEN-LAST:event_jTFDirNegocio1KeyReleased

    private void jTFTelefonoNegocio1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoNegocio1KeyReleased
        telefonoNeg2 = validarRegistroF.camposDeRegistros(jTFTelefonoNegocio1, errorP4, "t");
    }//GEN-LAST:event_jTFTelefonoNegocio1KeyReleased

    private void jTNombreCliente1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreCliente1KeyReleased
        nombreCFactura2 = validarRegistroF.camposDeRegistros(jTNombreCliente1, errorP8, "n");
    }//GEN-LAST:event_jTNombreCliente1KeyReleased

    private void jTFApeliidosCliente1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApeliidosCliente1KeyReleased
        apellidoCFactura2 = validarRegistroF.camposDeRegistros(jTFApeliidosCliente1, errorP9, "n");
    }//GEN-LAST:event_jTFApeliidosCliente1KeyReleased

    private void jTTelefonoCliente1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTelefonoCliente1KeyReleased
        String tipoCliente = (String) jCBSeleccionTipoCliente1.getSelectedItem();
        telfCliente2 = validarRegistroF.camposCliente(jTTelefonoCliente1, errorP10, tipoCliente, "Ninguno", "b");
    }//GEN-LAST:event_jTTelefonoCliente1KeyReleased

    private void jChBnombreItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChBnombreItemActionPerformed
        validadorCheck.actualizarCampo(jChBnombreItem, jTFnombreItem, nombreItemValidar1, errorInventario4);
    }//GEN-LAST:event_jChBnombreItemActionPerformed

    private void jChBstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChBstockActionPerformed
        validadorCheck.actualizarCampo(jChBstock, jTFstock, stockValidar1, errorInventario5);
    }//GEN-LAST:event_jChBstockActionPerformed

    private void jChBprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChBprecioActionPerformed
        validadorCheck.actualizarCampo(jChBprecio, jTFPrecio, precioUValidar1, errorInventario6);
    }//GEN-LAST:event_jChBprecioActionPerformed

    private void jTFnombreItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFnombreItemKeyReleased
        nombreItemValidar1 = validarRegistroF.camposDeRegistros(jTFnombreItem, errorInventario4, "d");
    }//GEN-LAST:event_jTFnombreItemKeyReleased

    private void jTFPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrecioKeyReleased
        pesoValidar = validarRegistroF.camposDeRegistros(jTPeso, errorInventario2, "precio");
    }//GEN-LAST:event_jTFPrecioKeyReleased

    private void jTFstockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFstockKeyReleased
        stockValidar1 = validarRegistroF.camposDeRegistros(jTFstock, errorInventario5, "v");
    }//GEN-LAST:event_jTFstockKeyReleased

    private void jTFPrecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFPrecioFocusLost
        precioUValidar1 = validarRegistroF.camposDeRegistros(jTFPrecio, errorInventario6, "precio");
    }//GEN-LAST:event_jTFPrecioFocusLost

    private void jTFNombresRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombresRKeyReleased
        nombreCliente = validarRegistroF.camposDeRegistros(jTFNombresR, errorc2, "n");
    }//GEN-LAST:event_jTFNombresRKeyReleased

    private void jTFNombresRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFNombresRFocusLost
        nombreCliente = validarRegistroF.camposDeRegistros(jTFNombresR, errorc2, "n");
    }//GEN-LAST:event_jTFNombresRFocusLost

    private void jTFApellidosRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidosRKeyReleased
        apellidoCliente = validarRegistroF.camposDeRegistros(jTFApellidosR, errorc3, "n");
    }//GEN-LAST:event_jTFApellidosRKeyReleased

    private void jTFApellidosRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFApellidosRFocusLost
        apellidoCliente = validarRegistroF.camposDeRegistros(jTFApellidosR, errorc3, "n");
    }//GEN-LAST:event_jTFApellidosRFocusLost

    private void correoCli2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoCli2KeyReleased
        correoCliente = validarRegistroF.camposDeRegistros(correoCli2, errorc4, "c");
    }//GEN-LAST:event_correoCli2KeyReleased

    private void correoCli2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoCli2FocusLost
        correoCliente = validarRegistroF.camposDeRegistros(correoCli2, errorc4, "c");
    }//GEN-LAST:event_correoCli2FocusLost

    private void jTFTelefonoRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFTelefonoRFocusLost
        String tipoCliente = (String) jCBNacionalExtranjero.getSelectedItem();
        telefonoCliente = validarRegistroF.camposCliente(jTFTelefonoR, errorc5, tipoCliente, "Ninguno", "b");
    }//GEN-LAST:event_jTFTelefonoRFocusLost

    private void jTFTelefonoRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoRKeyReleased
        String tipoCliente = (String) jCBNacionalExtranjero.getSelectedItem();
        telefonoCliente = validarRegistroF.camposCliente(jTFTelefonoR, errorc5, tipoCliente, "Ninguno", "b");
    }//GEN-LAST:event_jTFTelefonoRKeyReleased

    private void jTFDireccionRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDireccionRKeyReleased
        direccionCliente = validarRegistroF.camposDeRegistros(jTFDireccionR, errorc6, "d");
    }//GEN-LAST:event_jTFDireccionRKeyReleased

    private void jTFDireccionRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFDireccionRFocusLost
        direccionCliente = validarRegistroF.camposDeRegistros(jTFDireccionR, errorc6, "d");
    }//GEN-LAST:event_jTFDireccionRFocusLost

    private void jTLargoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTLargoFocusLost
       largoValidar = validarRegistroF.camposDeRegistros(jTLargo, errorInventario3, "precio");
    }//GEN-LAST:event_jTLargoFocusLost

    private void jTLargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTLargoKeyReleased
       largoValidar = validarRegistroF.camposDeRegistros(jTLargo, errorInventario3, "precio");
    }//GEN-LAST:event_jTLargoKeyReleased

    private void jTRemitenteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTRemitenteFocusLost
        remitenteValidar = validarRegistroF.camposDeRegistros(jTRemitente, errorInventario8, "d");
    }//GEN-LAST:event_jTRemitenteFocusLost

    private void jTRemitenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTRemitenteKeyReleased
        remitenteValidar = validarRegistroF.camposDeRegistros(jTRemitente, errorInventario8, "d");
    }//GEN-LAST:event_jTRemitenteKeyReleased

    private void jTDestinoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTDestinoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDestinoFocusLost

    private void jTDestinoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDestinoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDestinoKeyReleased

    private void jTDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDestinoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDestinoKeyTyped

    private void jTAnchoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAnchoFocusLost
        anchoValidar = validarRegistroF.camposDeRegistros(jTAncho, errorInventario1, "precio");
    }//GEN-LAST:event_jTAnchoFocusLost

    private void jTAnchoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAnchoKeyReleased
        anchoValidar = validarRegistroF.camposDeRegistros(jTAncho, errorInventario1, "precio");
    }//GEN-LAST:event_jTAnchoKeyReleased

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

    public void setTablaPaquetes() {
        CreadorTablas cnn = new CreadorTablas();
        DefaultTableModel modelo = cnn.mostrarTablaPaquetes(cnx);
        this.jTPaquetes.setModel(modelo);
        this.jTablaInventario1.setModel(modelo);
        this.jTablaInventario2.setModel(modelo);
        this.jTablaInventario3.setModel(modelo);
    }

    private String obtenerEstadoElementoDesdeBD(int idItem) {
        String estado = "Desconocido"; // Valor por defecto si no se encuentra en la base de datos

        try {
            java.sql.Statement stmt = cnx.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery("SELECT estado FROM item WHERE idItem = " + idItem);
            if (rs.next()) {
                estado = rs.getString("estado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener el estado del elemento desde la base de datos.");
        }

        return estado;
    }

    private void actualizarTablaComprasClienteID(int idFactura) {
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarItemsID(cnx, idFactura);
        jTablaRegistrarFactura.setModel(modelo); // Actualizar la tabla con el nuevo modelo
    }

    private void actualizarTablaComprasClienteIDC(int idProforma) {
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarItemsIDC(cnx, idProforma);
        jTablaRegistrarFactura1.setModel(modelo); // Actualizar la tabla con el nuevo modelo
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

    private void deshabilitarCamposP() {
        // Deshabilitar los componentes
        jBRegistrarFactura1.setEnabled(false);
        jTFnumerofactura1.setEnabled(false);
        jDateChooserFecha1.setEnabled(false);
        jTFNombreNegocio1.setEnabled(false);
        jTFRUCNegocio1.setEnabled(false);
        jTFDirNegocio1.setEnabled(false);
        jTFTelefonoNegocio1.setEnabled(false);
        jCBSeleccionTipoCliente1.setEnabled(false);
        jCBNaturalOJuridico1.setEnabled(false);
        jTCIDelCliente1.setEnabled(false);
        jTNombreCliente1.setEnabled(false);
        jTFApeliidosCliente1.setEnabled(false);
        jTTelefonoCliente1.setEnabled(false);
        jTDireccionCliente1.setEnabled(false);
        correoCli1.setEnabled(false);
        jCBEstadoPago1.setEnabled(true);

        // Habilitar los componentes
        iDProcutoP.setEnabled(true);
        cantidadProforma.setEnabled(true);
        jBAgregarProducto1.setEnabled(true);
        jBQuitarProducto1.setEnabled(true);
        jBGenerarFactura1.setEnabled(true);

    }

    private void limpiarYCambiarCamposP() {
        jBRegistrarFactura1.setEnabled(true);
        jTFnumerofactura1.setEnabled(true);
        jDateChooserFecha1.setEnabled(true);
        jCBEstadoPago1.setEnabled(false);
        jTFNombreNegocio1.setEnabled(true);
        jTFRUCNegocio1.setEnabled(true);
        jTFDirNegocio1.setEnabled(true);
        jTFTelefonoNegocio1.setEnabled(true);
        jCBSeleccionTipoCliente1.setEnabled(true);
        jCBNaturalOJuridico1.setEnabled(true);
        jTCIDelCliente1.setEnabled(true);
        jTNombreCliente1.setEnabled(true);
        jTFApeliidosCliente1.setEnabled(true);
        jTTelefonoCliente1.setEnabled(true);
        jTDireccionCliente1.setEnabled(true);
        correoCli1.setEnabled(true);

        iDProcutoP.setEnabled(false);
        cantidadProforma.setEnabled(false);
        jBAgregarProducto1.setEnabled(false);
        jBQuitarProducto1.setEnabled(false);
        jBGenerarFactura1.setEnabled(false);

        jTFnumerofactura1.setText("");
        jTFSubtotal1.setText("");
        jTFTotal.setText("");
        iDProcutoP.setText("");
        cantidadProforma.setText("");
        jTFNombreNegocio1.setText("");
        jTFRUCNegocio1.setText("");
        jTFDirNegocio1.setText("");
        jTFTelefonoNegocio1.setText("");
        jTCIDelCliente1.setText("");
        jTNombreCliente1.setText("");
        jTFApeliidosCliente1.setText("");
        jTTelefonoCliente1.setText("");
        jTDireccionCliente1.setText("");
        correoCli1.setText("");

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

    private boolean hayProductosEnStockP() {
        try {
            String consulta = "SELECT COUNT(*) FROM item_copia WHERE stock > 0 AND estado = 'Activo'";
            PreparedStatement statement = cnx.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int cantidadProductosEnStock = resultSet.getInt(1);
                return cantidadProductosEnStock > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
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
    private javax.swing.JButton AnularFactura;
    private javax.swing.JButton BActualizar;
    private javax.swing.JButton BBuscarEliminar;
    private javax.swing.JButton BRegistrar;
    private javax.swing.JComboBox<String> CBConsultarEmpleado;
    private javax.swing.JComboBox<String> CBSexoActualizado;
    private javax.swing.JTextField CIEmpleadoActualizar;
    private javax.swing.JCheckBox CIselect;
    private javax.swing.JButton CambiarEstadoF;
    private javax.swing.JTextField Cargo;
    private javax.swing.JTextField CedulaEmpleado;
    private javax.swing.JTextField ClaveEmpleadoUsuario;
    private javax.swing.JPanel Clicked1;
    private javax.swing.JPanel Clicked2;
    private javax.swing.JPanel Clicked3;
    private javax.swing.JPanel Clicked4;
    private javax.swing.JPanel Clicked5;
    private javax.swing.JPanel Clicked6;
    private javax.swing.JTextField CorreoElectronico;
    private com.toedter.calendar.JDateChooser FechaNacimientoEmpleado;
    private javax.swing.JPanel Home;
    private javax.swing.JTextField IVAText;
    private javax.swing.JTextField IVAText1;
    private javax.swing.JPanel JPAdministración;
    private javax.swing.JPanel JPClientes;
    private javax.swing.JPanel JPEmpleados;
    private javax.swing.JPanel JPFyV;
    private javax.swing.JPanel JPInventario;
    private javax.swing.JPanel JPProovedores;
    private javax.swing.JTextField NombreEmpleado;
    private javax.swing.JPanel PanelFiltros;
    private javax.swing.JPanel PanelFiltros1;
    private javax.swing.JPanel PanelHome;
    private javax.swing.JComboBox<String> SeleccionFacturaAtributo;
    private javax.swing.JComboBox<String> SexoEmpleado;
    private javax.swing.JTextField TFApellidosActualizado;
    private javax.swing.JTextField TFCargoActualizado;
    private javax.swing.JTextField TFConsultarEmpleado;
    private javax.swing.JTextField TFConsultarEmpleado1;
    private javax.swing.JTextField TFDireccionActualizado;
    private javax.swing.JTextField TFEmailActualizado;
    private javax.swing.JTextField TFFNacimientoActualizado;
    private javax.swing.JTextField TFNCedulaActualizado;
    private javax.swing.JTextField TFNCedulaBuscar1;
    private javax.swing.JTextField TFNombresActualizado;
    private javax.swing.JTextField TFTConvencionalActualizado;
    private javax.swing.JTextField TFTPersonalActualizado;
    private javax.swing.JTextField TelefonoConvencional;
    private javax.swing.JTextField TelefonoPersonal;
    private javax.swing.JTextField apellidoActualizar;
    private javax.swing.JCheckBox apellidoSelect;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHelp;
    private javax.swing.JTextField campoRespuesta;
    private javax.swing.JTextField cantidadProforma;
    private javax.swing.JTextField ciActualizar;
    private javax.swing.JCheckBox claveUsuariocheck;
    private javax.swing.JTextField correoActualizar;
    private javax.swing.JTextField correoCli;
    private javax.swing.JTextField correoCli1;
    private javax.swing.JTextField correoCli2;
    private javax.swing.JCheckBox correoSelect;
    private javax.swing.JTextField direccionActualizar;
    private javax.swing.JTextField direccionEmpelado;
    private javax.swing.JCheckBox direccionSelect;
    private javax.swing.JLabel documentoActualizar;
    private javax.swing.JLabel documentoActualizar3;
    private javax.swing.JLabel errorActualizarCliente1;
    private javax.swing.JLabel errorActualizarCliente2;
    private javax.swing.JLabel errorActualizarCliente3;
    private javax.swing.JLabel errorActualizarCliente4;
    private javax.swing.JLabel errorActualizarCliente5;
    private javax.swing.JLabel errorActualizarCliente6;
    private javax.swing.JLabel errorEmpleados1;
    private javax.swing.JLabel errorInventario1;
    private javax.swing.JLabel errorInventario2;
    private javax.swing.JLabel errorInventario3;
    private javax.swing.JLabel errorInventario4;
    private javax.swing.JLabel errorInventario5;
    private javax.swing.JLabel errorInventario6;
    private javax.swing.JLabel errorInventario7;
    private javax.swing.JLabel errorInventario8;
    private javax.swing.JLabel errorP1;
    private javax.swing.JLabel errorP10;
    private javax.swing.JLabel errorP11;
    private javax.swing.JLabel errorP12;
    private javax.swing.JLabel errorP2;
    private javax.swing.JLabel errorP3;
    private javax.swing.JLabel errorP4;
    private javax.swing.JLabel errorP5;
    private javax.swing.JLabel errorP6;
    private javax.swing.JLabel errorP7;
    private javax.swing.JLabel errorP8;
    private javax.swing.JLabel errorP9;
    private javax.swing.JLabel errorProveedores1;
    private javax.swing.JLabel errorProveedores2;
    private javax.swing.JLabel errorProveedores3;
    private javax.swing.JLabel errorProveedores4;
    private javax.swing.JLabel errorProveedores5;
    private javax.swing.JLabel errorProveedores6;
    private javax.swing.JLabel errorProveedores7;
    private javax.swing.JLabel errorProveedores8;
    private javax.swing.JLabel errorc1;
    private javax.swing.JLabel errorc2;
    private javax.swing.JLabel errorc3;
    private javax.swing.JLabel errorc4;
    private javax.swing.JLabel errorc5;
    private javax.swing.JLabel errorc6;
    private javax.swing.JTextField iDProcutoP;
    private javax.swing.JTextField idItemFactura;
    private javax.swing.JButton jBAgregarProducto;
    private javax.swing.JButton jBAgregarProducto1;
    private javax.swing.JButton jBAgregarProductoProveedores;
    private javax.swing.JButton jBAgregarProductoProveedores1;
    private javax.swing.JButton jBCambiarEstado;
    private javax.swing.JButton jBCambiarEstadoProveedor;
    private javax.swing.JButton jBCambiarEstadoProveedor1;
    private javax.swing.JButton jBCambiarEstadoProveedor2;
    private javax.swing.JButton jBConsultarInventario;
    private javax.swing.JButton jBConsultarInventario1;
    private javax.swing.JButton jBConsultarInventario2;
    private javax.swing.JButton jBConsultarInventario3;
    private javax.swing.JButton jBConsultarInventario4;
    private javax.swing.JButton jBGenerarFactura;
    private javax.swing.JButton jBGenerarFactura1;
    private javax.swing.JButton jBIActualizar;
    private javax.swing.JButton jBIActualizarAct;
    private javax.swing.JButton jBIActualizarAct1;
    private javax.swing.JButton jBIActualizarAct2;
    private javax.swing.JButton jBQuitarProducto;
    private javax.swing.JButton jBQuitarProducto1;
    private javax.swing.JButton jBQuitarProductoProveedores;
    private javax.swing.JButton jBQuitarProductoProveedores1;
    private javax.swing.JButton jBRegistarCliente;
    private javax.swing.JButton jBRegistarUser;
    private javax.swing.JButton jBRegistrarFactura;
    private javax.swing.JButton jBRegistrarFactura1;
    private javax.swing.JButton jBRegistrarProovedor;
    private javax.swing.JButton jBVerGanancias;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCApellidoActualizar;
    private javax.swing.JComboBox<String> jCBACSInventario;
    private javax.swing.JComboBox<String> jCBEstadoPago;
    private javax.swing.JComboBox<String> jCBEstadoPago1;
    private javax.swing.JComboBox<String> jCBIConsultar;
    private javax.swing.JComboBox<String> jCBIConsultar1;
    private javax.swing.JComboBox<String> jCBJuridicoNatural1;
    private javax.swing.JComboBox<String> jCBNacionalExtranjero;
    private javax.swing.JComboBox<String> jCBNacionalExtranjero1;
    private javax.swing.JComboBox<String> jCBNacionalExtranjero2;
    private javax.swing.JComboBox<String> jCBNacionalExtranjero3;
    private javax.swing.JComboBox<String> jCBNaturalOJuridico1;
    private javax.swing.JComboBox<String> jCBPreguntaControl;
    private javax.swing.JComboBox<String> jCBSeleccionTipoCliente1;
    private javax.swing.JComboBox<String> jCBseleccionRol;
    private javax.swing.JComboBox<String> jCBuscarProveedorConsultar2;
    private javax.swing.JCheckBox jCCIActualizar;
    private javax.swing.JCheckBox jCCargoActualizar;
    private javax.swing.JCheckBox jCCorreoActualizar;
    private javax.swing.JCheckBox jCDireccionActualizar;
    private javax.swing.JCheckBox jCFechaActualizar;
    private javax.swing.JComboBox<String> jCJuridicoNatural;
    private javax.swing.JComboBox<String> jCJuridicoNatural1;
    private javax.swing.JComboBox<String> jCJuridicoNatural2;
    private javax.swing.JCheckBox jCNombreActualizar;
    private javax.swing.JCheckBox jCSexoActualizar;
    private javax.swing.JCheckBox jCTelefonoCActualizar;
    private javax.swing.JCheckBox jCTelefonoPActualizar;
    private javax.swing.JCheckBox jChBiDItem;
    private javax.swing.JCheckBox jChBnombreItem;
    private javax.swing.JCheckBox jChBprecio;
    private javax.swing.JCheckBox jChBstock;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox8;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private com.toedter.calendar.JDateChooser jDateChooserFecha1;
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
    private javax.swing.JLabel jLCITipoCliente1;
    private javax.swing.JLabel jLErrorEmpleado1;
    private javax.swing.JLabel jLErrorEmpleado10;
    private javax.swing.JLabel jLErrorEmpleado11;
    private javax.swing.JLabel jLErrorEmpleado12;
    private javax.swing.JLabel jLErrorEmpleado13;
    private javax.swing.JLabel jLErrorEmpleado2;
    private javax.swing.JLabel jLErrorEmpleado3;
    private javax.swing.JLabel jLErrorEmpleado4;
    private javax.swing.JLabel jLErrorEmpleado5;
    private javax.swing.JLabel jLErrorEmpleado6;
    private javax.swing.JLabel jLErrorEmpleado7;
    private javax.swing.JLabel jLErrorEmpleado8;
    private javax.swing.JLabel jLErrorEmpleado9;
    private javax.swing.JLabel jLTipoCli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPAE;
    private javax.swing.JPanel jPActualizarAtributos;
    private javax.swing.JPanel jPActualizarClientes;
    private javax.swing.JPanel jPActualizarProovedores;
    private javax.swing.JPanel jPCE;
    private javax.swing.JPanel jPCambiarEstado;
    private javax.swing.JPanel jPCambiarEstadoP;
    private javax.swing.JTabbedPane jPClientes;
    private javax.swing.JPanel jPDarDeBajaInventario;
    private javax.swing.JPanel jPDatosCliente;
    private javax.swing.JPanel jPDatosCliente1;
    private javax.swing.JPanel jPDatosEmpleados;
    private javax.swing.JPanel jPDatosFactura;
    private javax.swing.JPanel jPDatosFactura1;
    private javax.swing.JPanel jPDatosNegocio;
    private javax.swing.JPanel jPDatosNegocio1;
    private javax.swing.JPanel jPDatosRecuperadosEmpleados;
    private javax.swing.JPanel jPEE;
    private javax.swing.JPanel jPEmpleadosTab;
    private javax.swing.JTabbedPane jPGP;
    private javax.swing.JPanel jPIA;
    private javax.swing.JPanel jPID;
    private javax.swing.JPanel jPIR;
    private javax.swing.JPanel jPPA;
    private javax.swing.JPanel jPPA1;
    private javax.swing.JPanel jPPA2;
    private javax.swing.JPanel jPPC;
    private javax.swing.JPanel jPPC1;
    private javax.swing.JPanel jPPC2;
    private javax.swing.JPanel jPPCE1;
    private javax.swing.JPanel jPPCE2;
    private javax.swing.JPanel jPPR;
    private javax.swing.JPanel jPPR1;
    private javax.swing.JPanel jPPR2;
    private javax.swing.JPanel jPProducto;
    private javax.swing.JPanel jPProducto1;
    private javax.swing.JPanel jPProvedoresActualizar;
    private javax.swing.JPanel jPRE;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelEliminarEmpleado;
    private javax.swing.JTabbedPane jPanel_General;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTATelefonoDespachador;
    private javax.swing.JTextField jTAncho;
    private javax.swing.JTextField jTApellidoDespachador;
    private javax.swing.JTextField jTApellidoDespachadorAct;
    private javax.swing.JTextField jTCIDelCliente;
    private javax.swing.JTextField jTCIDelCliente1;
    private javax.swing.JButton jTCambiarEstadoUsuario;
    private javax.swing.JTextField jTCedulaDespachador;
    private javax.swing.JTextField jTCedulaDespachadorAct;
    private javax.swing.JTextField jTCedulaDespachadorCE1;
    private javax.swing.JTextField jTCodigoProducto;
    private javax.swing.JTextField jTCodigoProducto1;
    private javax.swing.JTextField jTContenidoPaquete;
    private javax.swing.JTextField jTDestino;
    private javax.swing.JTextField jTDireccionCliente;
    private javax.swing.JTextField jTDireccionCliente1;
    private javax.swing.JTextField jTFAdminClave;
    private javax.swing.JTextField jTFAdminConsultar;
    private javax.swing.JComboBox<String> jTFAdminRol;
    private javax.swing.JTextField jTFApeliidosCliente;
    private javax.swing.JTextField jTFApeliidosCliente1;
    private javax.swing.JTextField jTFApellidoEmpleado;
    private javax.swing.JTextField jTFApellidosR;
    private javax.swing.JTextField jTFAtributoC;
    private javax.swing.JTextField jTFCIRegistrarC;
    private javax.swing.JTextField jTFCInventario;
    private javax.swing.JTextField jTFCInventario1;
    private javax.swing.JTextField jTFDirNegocio;
    private javax.swing.JTextField jTFDirNegocio1;
    private javax.swing.JTextField jTFDireccionR;
    private javax.swing.JTextField jTFEliminarUser;
    private javax.swing.JTextField jTFIBuscador;
    private javax.swing.JTextField jTFIBuscadorAct1;
    private javax.swing.JTextField jTFIBuscadorAct2;
    private javax.swing.JTextField jTFIBuscadorAct5;
    private javax.swing.JTextField jTFIBuscarRUC;
    private javax.swing.JTextField jTFIDemploye;
    private javax.swing.JTextField jTFNombreNegocio;
    private javax.swing.JTextField jTFNombreNegocio1;
    private javax.swing.JTextField jTFNombreUser;
    private javax.swing.JTextField jTFNombresR;
    private javax.swing.JTextField jTFPrecio;
    private javax.swing.JTextField jTFRUCNegocio;
    private javax.swing.JTextField jTFRUCNegocio1;
    private javax.swing.JTextField jTFSubtotal;
    private javax.swing.JTextField jTFSubtotal1;
    private javax.swing.JTextField jTFTelefonoNegocio;
    private javax.swing.JTextField jTFTelefonoNegocio1;
    private javax.swing.JTextField jTFTelefonoProvedor;
    private javax.swing.JTextField jTFTelefonoR;
    private javax.swing.JTextField jTFTotal;
    private javax.swing.JTextField jTFiDItem;
    private javax.swing.JTextField jTFidItemDar;
    private javax.swing.JTextField jTFnombreItem;
    private javax.swing.JTextField jTFnombreUser;
    private javax.swing.JTextField jTFnumerofactura;
    private javax.swing.JTextField jTFnumerofactura1;
    private javax.swing.JTextField jTFstock;
    private javax.swing.JTextField jTLargo;
    private javax.swing.JTextField jTNombreCliente;
    private javax.swing.JTextField jTNombreCliente1;
    private javax.swing.JTextField jTNombreDespachador;
    private javax.swing.JTextField jTNombreDespachadorAct;
    private javax.swing.JTextField jTNombreEmpresa;
    private javax.swing.JTextField jTNombreEmpresaAct;
    private javax.swing.JTextField jTNombreProducto;
    private javax.swing.JTextField jTNombreProducto1;
    private javax.swing.JTabbedPane jTPAdmin;
    private javax.swing.JTabbedPane jTPEmpleados;
    private javax.swing.JTable jTPaquetes;
    private javax.swing.JTextField jTPeso;
    private javax.swing.JTextField jTProveedorConsultar;
    private javax.swing.JTextField jTProveedorConsultar1;
    private javax.swing.JTextField jTRUC;
    private javax.swing.JTextField jTRUCAct;
    private javax.swing.JTextField jTRUCCE;
    private javax.swing.JTextField jTRUCCE1;
    private javax.swing.JTextField jTRemitente;
    private javax.swing.JTextField jTTelefonoCliente;
    private javax.swing.JTextField jTTelefonoCliente1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablaAdmin;
    private javax.swing.JTable jTablaAdmin1;
    private javax.swing.JTable jTablaAdmin2;
    private javax.swing.JTable jTablaAdmin3;
    private javax.swing.JTable jTablaClientesR;
    private javax.swing.JTable jTablaInventario1;
    private javax.swing.JTable jTablaInventario2;
    private javax.swing.JTable jTablaInventario3;
    private javax.swing.JTable jTablaProveedoresA;
    private javax.swing.JTable jTablaProveedoresCE;
    private javax.swing.JTable jTablaProveedoresConsultar;
    private javax.swing.JTable jTablaProveedoresConsultar1;
    private javax.swing.JTable jTablaProveedoresR;
    private javax.swing.JTable jTablaRegistrarFactura;
    private javax.swing.JTable jTablaRegistrarFactura1;
    private javax.swing.JTable jTableEmpleadosAcutalizar;
    private javax.swing.JTable jTableEmpleadosAcutalizar1;
    private javax.swing.JTable jTableEmpleadosAcutalizar2;
    private javax.swing.JTable jTableEmpleadosAcutalizar3;
    private javax.swing.JTable jTableFacturas;
    private javax.swing.JTable jTableFacturas1;
    private javax.swing.JTable jTableHistorialFacturas;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTiDPaquete;
    private javax.swing.JLabel menuAdministracion;
    private javax.swing.JLabel menuClientes;
    private javax.swing.JLabel menuEmpleados;
    private javax.swing.JLabel menuFacturacionYVenta;
    private javax.swing.JLabel menuLogout;
    private javax.swing.JLabel menuProveedores;
    private javax.swing.JLabel menuinventario;
    private javax.swing.JTextField nombreActualizar;
    private javax.swing.JTextField nombreProducto;
    private javax.swing.JCheckBox nombreSelect;
    private javax.swing.JPanel panelContent;
    private javax.swing.JTable tablaActualizarCliente;
    private javax.swing.JTable tablaClienteCambiarEstado;
    private javax.swing.JTextField telefonoActualizar;
    private javax.swing.JCheckBox telefonoSelect;
    private javax.swing.JLabel txtDateLog;
    private javax.swing.JLabel txtID;
    // End of variables declaration//GEN-END:variables

}
