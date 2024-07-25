/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_encomienda.GUI;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_encomienda.BDYValidaciones.CreadorTablas;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.util.List;
import javax.swing.JLabel;
import proyecto_encomienda.BDYValidaciones.Proveedores;
import proyecto_encomienda.BDYValidaciones.ValidadorDeSwings;
import proyecto_encomienda.BDYValidaciones.ValidadorDeRegistros;
import proyecto_encomienda.BDYValidaciones.VisibilidadManager;

/**
 *
 * @author USUARIO
 */
public class JFConductores extends javax.swing.JFrame {
//Validadores

    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
//Conductores
    private boolean cIConductor = false;
    private boolean nombreConductor = false;
    private boolean cedulaProve = false;
    private boolean nombreProve = false;
    private boolean apellidoProve = false;
    private boolean telefonoProve = false;
//ConductoresActualizar
    private boolean cIConductor1 = false;
    private boolean nombreEmpresaProve1 = false;
    private boolean cedulaProve1 = false;
    private boolean nombreProve1 = false;
    private boolean apellidoProve1 = false;
    private boolean telefonoProve1 = false;
//Mouse
    int xMouse, yMouse;
    private VisibilidadManager visibilidadManager;
    Connection cnx;

    public JFConductores(Connection cnx) {
        initComponents();
        this.cnx = cnx;
        setIconImage(new ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/exclamacion.png")).getImage());
        // Inicializa el campo IDIncidentesTF con el siguiente ID
        this.visibilidadManager = new VisibilidadManager();
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        desaparecerLabels();
        setLocationRelativeTo(null);

    }
    
     public JFConductores() {
         initComponents();
     }

    private String getValueAtSelectedRow(DefaultTableModel model, int selectedRow, String columnName) {
        int colIndex = model.findColumn(columnName);
        return colIndex != -1 ? model.getValueAt(selectedRow, colIndex).toString() : "";
    }
    
      public void desaparecerLabels() {
        JLabel[] labels = {errorProveedores1,
            errorProveedores2, errorProveedores3, errorProveedores4, errorProveedores5, errorProveedores6, errorProveedores7,
            errorProveedores8};
        visibilidadManager.desvanecerLabels(labels);
    }

    private void limpiarCamposProve1() {
        JTextField[] campos = {jTRUCAct, jTNombreEmpresaAct, jTCedulaDespachadorAct, jTNombreDespachadorAct,
            jTApellidoDespachadorAct, jTATelefonoDespachador, jTCodigoProducto1, jTNombreProducto1};
        for (int i = 0; i < campos.length; i++) {
            JTextField campo = campos[i];
            campo.setText("");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPConductores = new javax.swing.JPanel();
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
        jScrollPane12 = new javax.swing.JScrollPane();
        jTablaProveedoresCE = new javax.swing.JTable();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conductores");
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        JPConductores.setBackground(new java.awt.Color(245, 245, 245));
        JPConductores.setMinimumSize(new java.awt.Dimension(810, 540));
        JPConductores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del conductor"));
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

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Conductor"));

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

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Inventario"));

        jLabel17.setText("CodigoTraking");

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

        javax.swing.GroupLayout jPCambiarEstadoPLayout = new javax.swing.GroupLayout(jPCambiarEstadoP);
        jPCambiarEstadoP.setLayout(jPCambiarEstadoPLayout);
        jPCambiarEstadoPLayout.setHorizontalGroup(
            jPCambiarEstadoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCambiarEstadoPLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPCambiarEstadoPLayout.setVerticalGroup(
            jPCambiarEstadoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCambiarEstadoPLayout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
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
                .addContainerGap(106, Short.MAX_VALUE))
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
                        .addContainerGap(13, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPPCLayout = new javax.swing.GroupLayout(jPPC);
        jPPC.setLayout(jPPCLayout);
        jPPCLayout.setHorizontalGroup(
            jPPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        jPPCLayout.setVerticalGroup(
            jPPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jPGP.addTab("Consultar", jPPC);

        JPConductores.add(jPGP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1030, 600));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1000, Short.MAX_VALUE)
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

        JPConductores.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, -1));

        getContentPane().add(JPConductores, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                    cIConductor = true;
                    nombreConductor = true;
                    cedulaProve = true;
                    nombreProve = true;
                    apellidoProve = true;
                    telefonoProve = true;
                    Boolean[] boleannosProvedores = {cIConductor, nombreConductor, cedulaProve,
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

    private void jTRUCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTRUCFocusLost
        cIConductor = validarRegistroF.camposDeRegistros(jTRUC, errorProveedores1, "b");
    }//GEN-LAST:event_jTRUCFocusLost

    private void jTRUCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTRUCKeyReleased
        cIConductor = validarRegistroF.camposDeRegistros(jTRUC, errorProveedores1, "b");

        String NRUC = jTRUC.getText();
        Proveedores prov = new Proveedores();
        DefaultTableModel modelo = prov.mostrarListaP(cnx, NRUC);
        jTablaProveedoresR.setModel(modelo);
    }//GEN-LAST:event_jTRUCKeyReleased

    private void jTNombreEmpresaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNombreEmpresaFocusLost
        nombreConductor = validarRegistroF.camposDeRegistros(jTNombreEmpresa, errorProveedores2, "d");
    }//GEN-LAST:event_jTNombreEmpresaFocusLost

    private void jTNombreEmpresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreEmpresaKeyReleased
        nombreConductor = validarRegistroF.camposDeRegistros(jTNombreEmpresa, errorProveedores2, "d");
    }//GEN-LAST:event_jTNombreEmpresaKeyReleased

    private void jTCedulaDespachadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCedulaDespachadorFocusLost
        cedulaProve = validarRegistroF.camposDeRegistros(jTCedulaDespachador, errorProveedores3, "cedula");
    }//GEN-LAST:event_jTCedulaDespachadorFocusLost

    private void jTCedulaDespachadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCedulaDespachadorKeyReleased
        cedulaProve = validarRegistroF.camposDeRegistros(jTCedulaDespachador, errorProveedores3, "cedula");
    }//GEN-LAST:event_jTCedulaDespachadorKeyReleased

    private void jTNombreDespachadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNombreDespachadorFocusLost
        nombreProve = validarRegistroF.camposDeRegistros(jTNombreDespachador, errorProveedores4, "n");
    }//GEN-LAST:event_jTNombreDespachadorFocusLost

    private void jTNombreDespachadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreDespachadorKeyReleased
        nombreProve = validarRegistroF.camposDeRegistros(jTNombreDespachador, errorProveedores4, "n");
    }//GEN-LAST:event_jTNombreDespachadorKeyReleased

    private void jTApellidoDespachadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTApellidoDespachadorFocusLost
        apellidoProve = validarRegistroF.camposDeRegistros(jTApellidoDespachador, errorProveedores5, "n");
    }//GEN-LAST:event_jTApellidoDespachadorFocusLost

    private void jTApellidoDespachadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTApellidoDespachadorKeyReleased
        apellidoProve = validarRegistroF.camposDeRegistros(jTApellidoDespachador, errorProveedores5, "n");
    }//GEN-LAST:event_jTApellidoDespachadorKeyReleased

    private void jTFTelefonoProvedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFTelefonoProvedorFocusLost
        telefonoProve = validarRegistroF.camposDeRegistros(jTFTelefonoProvedor, errorProveedores6, "telefono");
    }//GEN-LAST:event_jTFTelefonoProvedorFocusLost

    private void jTFTelefonoProvedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoProvedorKeyReleased
        telefonoProve = validarRegistroF.camposDeRegistros(jTFTelefonoProvedor, errorProveedores6, "telefono");
    }//GEN-LAST:event_jTFTelefonoProvedorKeyReleased

    private void jBRegistrarProovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarProovedorActionPerformed
        JTextField[] campos = {jTRUC, jTNombreEmpresa, jTCedulaDespachador, jTNombreDespachador,
            jTApellidoDespachador, jTFTelefonoProvedor};
        JLabel[] labels = {errorProveedores1, errorProveedores2, errorProveedores3,
            errorProveedores4, errorProveedores5, errorProveedores6};
        Proveedores prov = new Proveedores();
        String ciDespachador = jTCedulaDespachador.getText();
        Boolean[] boleannosProvedores = {cIConductor, nombreConductor, cedulaProve,
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

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        validadorCheck.actualizarCampo(jCheckBox8, jTATelefonoDespachador, telefonoProve1, errorProveedores7);
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jTATelefonoDespachadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTATelefonoDespachadorFocusLost
        telefonoProve1 = validarRegistroF.camposDeRegistros(jTATelefonoDespachador, errorProveedores7, "telefono");
    }//GEN-LAST:event_jTATelefonoDespachadorFocusLost

    private void jTATelefonoDespachadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTATelefonoDespachadorKeyReleased
        telefonoProve1 = validarRegistroF.camposDeRegistros(jTATelefonoDespachador, errorProveedores7, "telefono");
    }//GEN-LAST:event_jTATelefonoDespachadorKeyReleased

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        validadorCheck.actualizarCampo(jCheckBox2, jTNombreEmpresaAct, nombreEmpresaProve1, errorProveedores8);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jTNombreEmpresaActFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNombreEmpresaActFocusLost
        nombreEmpresaProve1 = validarRegistroF.camposDeRegistros(jTNombreEmpresaAct, errorProveedores8, "d");
    }//GEN-LAST:event_jTNombreEmpresaActFocusLost

    private void jTNombreEmpresaActKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreEmpresaActKeyReleased
        nombreEmpresaProve1 = validarRegistroF.camposDeRegistros(jTNombreEmpresaAct, errorProveedores8, "d");
    }//GEN-LAST:event_jTNombreEmpresaActKeyReleased

    private void jTNombreEmpresaActKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreEmpresaActKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNombreEmpresaActKeyTyped

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

    private void jTFIBuscarRUCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscarRUCKeyReleased
        String NRUC = jTFIBuscarRUC.getText();
        Proveedores prov = new Proveedores();
        DefaultTableModel modelo = prov.mostrarListaParcial(cnx, NRUC);
        jTablaProveedoresA.setModel(modelo);
    }//GEN-LAST:event_jTFIBuscarRUCKeyReleased

    private void jTFIBuscarRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscarRUCKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIBuscarRUCKeyTyped

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
            java.util.logging.Logger.getLogger(JFConductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFConductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFConductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFConductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFConductores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPConductores;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel errorProveedores1;
    private javax.swing.JLabel errorProveedores2;
    private javax.swing.JLabel errorProveedores3;
    private javax.swing.JLabel errorProveedores4;
    private javax.swing.JLabel errorProveedores5;
    private javax.swing.JLabel errorProveedores6;
    private javax.swing.JLabel errorProveedores7;
    private javax.swing.JLabel errorProveedores8;
    private javax.swing.JButton jBAgregarProductoProveedores;
    private javax.swing.JButton jBAgregarProductoProveedores1;
    private javax.swing.JButton jBIActualizarAct;
    private javax.swing.JButton jBQuitarProductoProveedores;
    private javax.swing.JButton jBQuitarProductoProveedores1;
    private javax.swing.JButton jBRegistrarProovedor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPActualizarProovedores;
    private javax.swing.JPanel jPCambiarEstadoP;
    private javax.swing.JTabbedPane jPGP;
    private javax.swing.JPanel jPPA;
    private javax.swing.JPanel jPPC;
    private javax.swing.JPanel jPPR;
    private javax.swing.JPanel jPProvedoresActualizar;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JTextField jTATelefonoDespachador;
    private javax.swing.JTextField jTApellidoDespachador;
    private javax.swing.JTextField jTApellidoDespachadorAct;
    private javax.swing.JTextField jTCedulaDespachador;
    private javax.swing.JTextField jTCedulaDespachadorAct;
    private javax.swing.JTextField jTCodigoProducto;
    private javax.swing.JTextField jTCodigoProducto1;
    private javax.swing.JTextField jTFIBuscarRUC;
    private javax.swing.JTextField jTFTelefonoProvedor;
    private javax.swing.JTextField jTNombreDespachador;
    private javax.swing.JTextField jTNombreDespachadorAct;
    private javax.swing.JTextField jTNombreEmpresa;
    private javax.swing.JTextField jTNombreEmpresaAct;
    private javax.swing.JTextField jTNombreProducto;
    private javax.swing.JTextField jTNombreProducto1;
    private javax.swing.JTextField jTRUC;
    private javax.swing.JTextField jTRUCAct;
    private javax.swing.JTable jTablaProveedoresA;
    private javax.swing.JTable jTablaProveedoresCE;
    private javax.swing.JTable jTablaProveedoresR;
    // End of variables declaration//GEN-END:variables
}
