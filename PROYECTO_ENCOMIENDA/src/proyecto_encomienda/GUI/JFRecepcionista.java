/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_encomienda.GUI;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_encomienda.BDYValidaciones.ActualizarInventario;
import proyecto_encomienda.BDYValidaciones.Empleados;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import proyecto_encomienda.BDYValidaciones.ValidadorDeSwings;
import proyecto_encomienda.BDYValidaciones.ValidadorDeRegistros;

/**
 *
 * @author USUARIO
 */
public class JFRecepcionista extends javax.swing.JFrame {
    
    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
    //Recepcionista
    private boolean cedulaEmpleadoValidar = false;
    private boolean nombreEmpleadoValidar = false;
    private boolean apellidoEmpleadoValidar = false;
    private boolean cargoEmpleadoValidar = false;
    private boolean direccionEmpleadoValidar = false;
    private boolean telefonoConvenValidar = false;
    private boolean telefonoEmpleadoValiar = false;
    private boolean correoEmpleadoValidar = false;
    //Actualizar
    private boolean cargoEmpleadoValidar1 = false;
    private boolean direccionEmpleadoValidar1 = false;
    private boolean telefonoConvenValidar1 = false;
    private boolean telefonoEmpleadoValiar1 = false;
    private boolean correoEmpleadoValidar1 = false;
    //Conexion
    Connection cnx;
    //Mouse
    int xMouse, yMouse; 
    public JFRecepcionista(Connection cnx) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/icons8_Monitor_32px.png")).getImage());
        this.cnx=cnx;
        //All Files	C:\Users\USUARIO\GitHub\PROYECTO_DELIVERY\PROYECTO_ENCOMIENDA\src\proyecto_encomienda\GESTION_PAQUETES\FRONTEND\imagenes\caja.png
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setLocationRelativeTo(null);
        desvanecerP();
        // Opcional: Deshabilita la edición manual del campo de texto
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) FechaNacimientoEmpleado.getDateEditor();
        editor2.setEditable(false);
    }
    
    public JFRecepcionista() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/icons8_Monitor_32px.png")).getImage());
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setLocationRelativeTo(null);
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
  
   private String getValueAtSelectedRow(DefaultTableModel model, int selectedRow, String columnName) {
        int colIndex = model.findColumn(columnName);
        return colIndex != -1 ? model.getValueAt(selectedRow, colIndex).toString() : "";
    }
   
     public void desvanecerP() {
        JLabel[] labels = {
            jLErrorEmpleado1, jLErrorEmpleado2, jLErrorEmpleado3,
            jLErrorEmpleado4, jLErrorEmpleado5, jLErrorEmpleado6,
            jLErrorEmpleado7, jLErrorEmpleado8, jLErrorEmpleado9, jLErrorEmpleado10,
            jLErrorEmpleado11, jLErrorEmpleado12, jLErrorEmpleado13};
        for (int i = 0; i < labels.length; i++) {
            JLabel label = labels[i % labels.length];
            label.setVisible(false);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableEmpleadosAcutalizar2 = new javax.swing.JTable();
        jPEE = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        jTableEmpleadosAcutalizar3 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setTitle("Registro de Empleados");
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

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
                .addContainerGap(14, Short.MAX_VALUE))
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
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTPEmpleados.addTab("Actualizar", jPAE);

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

        javax.swing.GroupLayout jPCELayout = new javax.swing.GroupLayout(jPCE);
        jPCE.setLayout(jPCELayout);
        jPCELayout.setHorizontalGroup(
            jPCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCELayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPCELayout.setVerticalGroup(
            jPCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCELayout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        jTPEmpleados.addTab("Consultar", jPCE);

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
                .addGap(22, 22, 22)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPEELayout.setVerticalGroup(
            jPEELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEELayout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
        );

        jTPEmpleados.addTab("Cambiar de estado", jPEE);

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
        jLabel69.setText("Reccepcionista");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPEmpleadosTabLayout = new javax.swing.GroupLayout(jPEmpleadosTab);
        jPEmpleadosTab.setLayout(jPEmpleadosTabLayout);
        jPEmpleadosTabLayout.setHorizontalGroup(
            jPEmpleadosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEmpleadosTabLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jTPEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPEmpleadosTabLayout.setVerticalGroup(
            jPEmpleadosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEmpleadosTabLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTPEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPEmpleadosTab, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombreEmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreEmpleadoFocusLost
        nombreEmpleadoValidar = validarRegistroF.camposDeRegistros(NombreEmpleado, jLErrorEmpleado2, "n");
    }//GEN-LAST:event_NombreEmpleadoFocusLost

    private void NombreEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreEmpleadoKeyReleased
        nombreEmpleadoValidar = validarRegistroF.camposDeRegistros(NombreEmpleado, jLErrorEmpleado2, "n");
    }//GEN-LAST:event_NombreEmpleadoKeyReleased

    private void jTFApellidoEmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFApellidoEmpleadoFocusLost
        apellidoEmpleadoValidar = validarRegistroF.camposDeRegistros(jTFApellidoEmpleado, jLErrorEmpleado3, "n");
    }//GEN-LAST:event_jTFApellidoEmpleadoFocusLost

    private void jTFApellidoEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidoEmpleadoKeyReleased

        apellidoEmpleadoValidar = validarRegistroF.camposDeRegistros(jTFApellidoEmpleado, jLErrorEmpleado3, "n");
    }//GEN-LAST:event_jTFApellidoEmpleadoKeyReleased

    private void CedulaEmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CedulaEmpleadoFocusLost
        cedulaEmpleadoValidar = validarRegistroF.camposDeRegistros(CedulaEmpleado, jLErrorEmpleado1, "cedula");
    }//GEN-LAST:event_CedulaEmpleadoFocusLost

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

    private void CargoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CargoFocusLost
        cargoEmpleadoValidar = validarRegistroF.camposDeRegistros(Cargo, jLErrorEmpleado4, "n");
    }//GEN-LAST:event_CargoFocusLost

    private void CargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CargoKeyReleased
        cargoEmpleadoValidar = validarRegistroF.camposDeRegistros(Cargo, jLErrorEmpleado4, "n");
    }//GEN-LAST:event_CargoKeyReleased

    private void TelefonoConvencionalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TelefonoConvencionalFocusLost
        telefonoConvenValidar = validarRegistroF.camposDeRegistros(TelefonoConvencional, jLErrorEmpleado6, "t");
    }//GEN-LAST:event_TelefonoConvencionalFocusLost

    private void TelefonoConvencionalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelefonoConvencionalKeyReleased
        telefonoConvenValidar = validarRegistroF.camposDeRegistros(TelefonoConvencional, jLErrorEmpleado6, "t");
    }//GEN-LAST:event_TelefonoConvencionalKeyReleased

    private void TelefonoPersonalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TelefonoPersonalFocusLost

        telefonoEmpleadoValiar = validarRegistroF.camposDeRegistros(TelefonoPersonal, jLErrorEmpleado7, "telefono");
    }//GEN-LAST:event_TelefonoPersonalFocusLost

    private void TelefonoPersonalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelefonoPersonalKeyReleased
        telefonoEmpleadoValiar = validarRegistroF.camposDeRegistros(TelefonoPersonal, jLErrorEmpleado7, "telefono");
    }//GEN-LAST:event_TelefonoPersonalKeyReleased

    private void CorreoElectronicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CorreoElectronicoFocusLost
        correoEmpleadoValidar = validarRegistroF.camposDeRegistros(CorreoElectronico, jLErrorEmpleado8, "c");
    }//GEN-LAST:event_CorreoElectronicoFocusLost

    private void CorreoElectronicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CorreoElectronicoKeyReleased
        correoEmpleadoValidar = validarRegistroF.camposDeRegistros(CorreoElectronico, jLErrorEmpleado8, "c");
    }//GEN-LAST:event_CorreoElectronicoKeyReleased

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

    private void direccionEmpeladoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_direccionEmpeladoFocusLost
        direccionEmpleadoValidar = validarRegistroF.camposDeRegistros(direccionEmpelado, jLErrorEmpleado5, "d");
    }//GEN-LAST:event_direccionEmpeladoFocusLost

    private void direccionEmpeladoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionEmpeladoKeyReleased
        direccionEmpleadoValidar = validarRegistroF.camposDeRegistros(direccionEmpelado, jLErrorEmpleado5, "d");
    }//GEN-LAST:event_direccionEmpeladoKeyReleased

    private void TFDireccionActualizadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFDireccionActualizadoFocusLost
        direccionEmpleadoValidar1 = validarRegistroF.camposDeRegistros(TFDireccionActualizado, jLErrorEmpleado10, "d");
    }//GEN-LAST:event_TFDireccionActualizadoFocusLost

    private void TFDireccionActualizadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFDireccionActualizadoKeyReleased
        direccionEmpleadoValidar1 = validarRegistroF.camposDeRegistros(TFDireccionActualizado, jLErrorEmpleado10, "d");
    }//GEN-LAST:event_TFDireccionActualizadoKeyReleased

    private void TFTConvencionalActualizadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFTConvencionalActualizadoFocusLost
        telefonoConvenValidar1 = validarRegistroF.camposDeRegistros(TFTConvencionalActualizado, jLErrorEmpleado11, "t");
    }//GEN-LAST:event_TFTConvencionalActualizadoFocusLost

    private void TFTConvencionalActualizadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFTConvencionalActualizadoKeyReleased
        telefonoConvenValidar1 = validarRegistroF.camposDeRegistros(TFTConvencionalActualizado, jLErrorEmpleado11, "t");
    }//GEN-LAST:event_TFTConvencionalActualizadoKeyReleased

    private void TFTPersonalActualizadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFTPersonalActualizadoFocusLost

        telefonoEmpleadoValiar1 = validarRegistroF.camposDeRegistros(TFTPersonalActualizado, jLErrorEmpleado12, "telefono");
    }//GEN-LAST:event_TFTPersonalActualizadoFocusLost

    private void TFTPersonalActualizadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFTPersonalActualizadoKeyReleased
        telefonoEmpleadoValiar1 = validarRegistroF.camposDeRegistros(TFTPersonalActualizado, jLErrorEmpleado12, "telefono");
    }//GEN-LAST:event_TFTPersonalActualizadoKeyReleased

    private void TFEmailActualizadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFEmailActualizadoFocusLost
        correoEmpleadoValidar1 = validarRegistroF.camposDeRegistros(TFEmailActualizado, jLErrorEmpleado13, "c");
    }//GEN-LAST:event_TFEmailActualizadoFocusLost

    private void TFEmailActualizadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFEmailActualizadoKeyReleased
        correoEmpleadoValidar1 = validarRegistroF.camposDeRegistros(TFEmailActualizado, jLErrorEmpleado13, "c");
    }//GEN-LAST:event_TFEmailActualizadoKeyReleased

    private void TFCargoActualizadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFCargoActualizadoFocusLost
        cargoEmpleadoValidar1 = validarRegistroF.camposDeRegistros(TFCargoActualizado, jLErrorEmpleado9, "n");
    }//GEN-LAST:event_TFCargoActualizadoFocusLost

    private void TFCargoActualizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFCargoActualizadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFCargoActualizadoActionPerformed

    private void TFCargoActualizadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFCargoActualizadoKeyTyped
        cargoEmpleadoValidar1 = validarRegistroF.camposDeRegistros(TFCargoActualizado, jLErrorEmpleado9, "n");
    }//GEN-LAST:event_TFCargoActualizadoKeyTyped

    private void jCDireccionActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCDireccionActualizarActionPerformed
        validadorCheck.actualizarCampo(jCDireccionActualizar, TFDireccionActualizado, direccionEmpleadoValidar1, jLErrorEmpleado10);
    }//GEN-LAST:event_jCDireccionActualizarActionPerformed

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

    private void jTFIBuscadorAct5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscadorAct5KeyReleased
        String CIbuscar = jTFIBuscadorAct5.getText();
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
                actualizar.actualizarDatos(this.cnx, atributoActualizar, condicion, tabla, atributosActualizacion);
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

    private void jTPEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPEmpleadosMouseClicked


    }//GEN-LAST:event_jTPEmpleadosMouseClicked

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
            java.util.logging.Logger.getLogger(JFRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFRecepcionista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BActualizar;
    private javax.swing.JButton BRegistrar;
    private javax.swing.JComboBox<String> CBSexoActualizado;
    private javax.swing.JTextField Cargo;
    private javax.swing.JTextField CedulaEmpleado;
    private javax.swing.JTextField CorreoElectronico;
    private com.toedter.calendar.JDateChooser FechaNacimientoEmpleado;
    private javax.swing.JTextField NombreEmpleado;
    private javax.swing.JComboBox<String> SexoEmpleado;
    private javax.swing.JTextField TFApellidosActualizado;
    private javax.swing.JTextField TFCargoActualizado;
    private javax.swing.JTextField TFDireccionActualizado;
    private javax.swing.JTextField TFEmailActualizado;
    private javax.swing.JTextField TFFNacimientoActualizado;
    private javax.swing.JTextField TFNCedulaActualizado;
    private javax.swing.JTextField TFNombresActualizado;
    private javax.swing.JTextField TFTConvencionalActualizado;
    private javax.swing.JTextField TFTPersonalActualizado;
    private javax.swing.JTextField TelefonoConvencional;
    private javax.swing.JTextField TelefonoPersonal;
    private javax.swing.JButton btnExit;
    private javax.swing.JTextField direccionEmpelado;
    private javax.swing.JLabel documentoActualizar3;
    private javax.swing.JLabel errorEmpleados1;
    private javax.swing.JCheckBox jCApellidoActualizar;
    private javax.swing.JCheckBox jCCIActualizar;
    private javax.swing.JCheckBox jCCargoActualizar;
    private javax.swing.JCheckBox jCCorreoActualizar;
    private javax.swing.JCheckBox jCDireccionActualizar;
    private javax.swing.JCheckBox jCFechaActualizar;
    private javax.swing.JCheckBox jCNombreActualizar;
    private javax.swing.JCheckBox jCSexoActualizar;
    private javax.swing.JCheckBox jCTelefonoCActualizar;
    private javax.swing.JCheckBox jCTelefonoPActualizar;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JPanel jPAE;
    private javax.swing.JPanel jPCE;
    private javax.swing.JPanel jPDatosEmpleados;
    private javax.swing.JPanel jPDatosRecuperadosEmpleados;
    private javax.swing.JPanel jPEE;
    private javax.swing.JPanel jPEmpleadosTab;
    private javax.swing.JPanel jPRE;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTFApellidoEmpleado;
    private javax.swing.JTextField jTFIBuscadorAct5;
    private javax.swing.JTabbedPane jTPEmpleados;
    private javax.swing.JTable jTableEmpleadosAcutalizar;
    private javax.swing.JTable jTableEmpleadosAcutalizar1;
    private javax.swing.JTable jTableEmpleadosAcutalizar2;
    private javax.swing.JTable jTableEmpleadosAcutalizar3;
    // End of variables declaration//GEN-END:variables
}
