/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_encomienda.GUI;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_encomienda.BDYValidaciones.ActualizarInventario;
import proyecto_encomienda.BDYValidaciones.CreadorTablas;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_encomienda.BDYValidaciones.RegistrarDatosFactura;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import proyecto_encomienda.BDYValidaciones.ValidadorDeSwings;
import proyecto_encomienda.BDYValidaciones.ValidadorDeRegistros;


public class JFRemitente extends javax.swing.JFrame {

    private boolean documentoCliente = false;
    private boolean nombreCliente = false;
    private boolean apellidoCliente = false;
    private boolean correoCliente = false;
    private boolean telefonoCliente = false;
    private boolean direccionCliente = false;
    
    //Actualizar
    private boolean telfCliente1 = false;
    private boolean dirCliente1 = false;
    private boolean correoElectronico1 = false;
    //ClasesValidadoras
    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
    //Mouse
    int xMouse, yMouse; 
    //Conexion
    Connection cnx;
    public JFRemitente(Connection cnx) {
        initComponents();
        this.cnx = cnx;
        setIconImage(new ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/icons8_Home_32px.png")).getImage());
        this.cnx=cnx;
        //All Files	C:\Users\USUARIO\GitHub\PROYECTO_DELIVERY\PROYECTO_ENCOMIENDA\src\proyecto_encomienda\GESTION_PAQUETES\FRONTEND\imagenes\caja.png
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setLocationRelativeTo(null);
        desvanecer();
        jTFCIRegistrarC.setEnabled(false);
    }
    
    public JFRemitente() {
        initComponents();
}
    
    
     public void desvanecer() {    
        errorc1.setVisible(false);
        errorc2.setVisible(false);
        errorc3.setVisible(false);
        errorc4.setVisible(false);
        errorc5.setVisible(false);
        errorc6.setVisible(false);
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
    

    public void cambiarValoresVerdad1() {
        telfCliente1 = true;
        dirCliente1 = true;
        correoElectronico1 = true;
    }
    
      private String getValueAtSelectedRow(DefaultTableModel model, int selectedRow, String columnName) {
        int colIndex = model.findColumn(columnName);
        return colIndex != -1 ? model.getValueAt(selectedRow, colIndex).toString() : "";
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPRemitente = new javax.swing.JPanel();
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
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remitente");
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        JPRemitente.setBackground(new java.awt.Color(245, 245, 245));
        JPRemitente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPRemitente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPPR1.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 348, 1000, 210));

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

        javax.swing.GroupLayout jPCambiarEstadoLayout = new javax.swing.GroupLayout(jPCambiarEstado);
        jPCambiarEstado.setLayout(jPCambiarEstadoLayout);
        jPCambiarEstadoLayout.setHorizontalGroup(
            jPCambiarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        jPCambiarEstadoLayout.setVerticalGroup(
            jPCambiarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
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
                        .addContainerGap(9, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPPC1Layout = new javax.swing.GroupLayout(jPPC1);
        jPPC1.setLayout(jPPC1Layout);
        jPPC1Layout.setHorizontalGroup(
            jPPC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        jPPC1Layout.setVerticalGroup(
            jPPC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );

        jPClientes.addTab("Consultar", jPPC1);

        JPRemitente.add(jPClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1060, 610));

        jPanel1.setLayout(new java.awt.CardLayout());

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 950, Short.MAX_VALUE)
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

        jPanel1.add(jPanel3, "card2");

        JPRemitente.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, -1));

        getContentPane().add(JPRemitente, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFNombresRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFNombresRFocusLost
        nombreCliente = validarRegistroF.camposDeRegistros(jTFNombresR, errorc2, "n");
    }//GEN-LAST:event_jTFNombresRFocusLost

    private void jTFNombresRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombresRKeyReleased
        nombreCliente = validarRegistroF.camposDeRegistros(jTFNombresR, errorc2, "n");
    }//GEN-LAST:event_jTFNombresRKeyReleased

    private void jTFNombresRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombresRKeyTyped
        int maxLength = 40; // Límite de longitud de caracteres
        if (jTFNombresR.getText().length() >= maxLength) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFNombresRKeyTyped

    private void jTFTelefonoRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFTelefonoRFocusLost
        String tipoCliente = (String) jCBNacionalExtranjero.getSelectedItem();
        telefonoCliente = validarRegistroF.camposCliente(jTFTelefonoR, errorc5, tipoCliente, "Ninguno", "b");
    }//GEN-LAST:event_jTFTelefonoRFocusLost

    private void jTFTelefonoRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoRKeyReleased
        String tipoCliente = (String) jCBNacionalExtranjero.getSelectedItem();
        telefonoCliente = validarRegistroF.camposCliente(jTFTelefonoR, errorc5, tipoCliente, "Ninguno", "b");
    }//GEN-LAST:event_jTFTelefonoRKeyReleased

    private void jTFCIRegistrarCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFCIRegistrarCFocusLost
        String idCliente = jTFCIRegistrarC.getText();
        RegistrarDatosFactura registrar = new RegistrarDatosFactura();
        if (registrar.clienteYaRegistrado(cnx, idCliente)) {
            JOptionPane.showMessageDialog(this, "Cliente ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        String tipoCliente = (String) jCBNacionalExtranjero.getSelectedItem();
        String natularJuridico = (String) jCJuridicoNatural.getSelectedItem();
        documentoCliente = validarRegistroF.camposCliente(jTFCIRegistrarC, errorc1, tipoCliente, natularJuridico, "a");
    }//GEN-LAST:event_jTFCIRegistrarCFocusLost

    private void jTFCIRegistrarCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCIRegistrarCKeyReleased
        String filtroIdCliente = jTFCIRegistrarC.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarClienteParametrizado(cnx, filtroIdCliente, "N"); // Llamas al método con el filtro
        jTablaClientesR.setModel(modelo); // Actualizas la tabla con el nuevo modelo
        String tipoCliente = (String) jCBNacionalExtranjero.getSelectedItem();
        String natularJuridico = (String) jCJuridicoNatural.getSelectedItem();
        documentoCliente = validarRegistroF.camposCliente(jTFCIRegistrarC, errorc1, tipoCliente, natularJuridico, "a");
    }//GEN-LAST:event_jTFCIRegistrarCKeyReleased

    private void jTFDireccionRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFDireccionRFocusLost
        direccionCliente = validarRegistroF.camposDeRegistros(jTFDireccionR, errorc6, "d");
    }//GEN-LAST:event_jTFDireccionRFocusLost

    private void jTFDireccionRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDireccionRKeyReleased
        direccionCliente = validarRegistroF.camposDeRegistros(jTFDireccionR, errorc6, "d");
    }//GEN-LAST:event_jTFDireccionRKeyReleased

    private void jTFApellidosRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFApellidosRFocusLost
        apellidoCliente = validarRegistroF.camposDeRegistros(jTFApellidosR, errorc3, "n");
    }//GEN-LAST:event_jTFApellidosRFocusLost

    private void jTFApellidosRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidosRKeyReleased
        apellidoCliente = validarRegistroF.camposDeRegistros(jTFApellidosR, errorc3, "n");
    }//GEN-LAST:event_jTFApellidosRKeyReleased

    private void jTFApellidosRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidosRKeyTyped
        int maxLength = 64; // Límite de longitud de caracteres
        if (jTFApellidosR.getText().length() >= maxLength) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFApellidosRKeyTyped

    private void correoCli2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoCli2FocusLost
        correoCliente = validarRegistroF.camposDeRegistros(correoCli2, errorc4, "c");
    }//GEN-LAST:event_correoCli2FocusLost

    private void correoCli2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoCli2KeyReleased
        correoCliente = validarRegistroF.camposDeRegistros(correoCli2, errorc4, "c");
    }//GEN-LAST:event_correoCli2KeyReleased

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
                String telefonoClientes = jTFTelefonoR.getText();
                String direccionClientes = jTFDireccionR.getText();
                String tipo = (String) jCJuridicoNatural.getSelectedItem();
                String correoDelCli = correoCli2.getText();
                String idCliente = jTFCIRegistrarC.getText();

                try {
                    RegistrarDatosFactura.insertarDatosCliente(cnx, idCliente, nombresCliente,
                            apellidosCliente, telefonoClientes,
                            direccionClientes, esExtranjero, tipo, correoDelCli);
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
            actualizar.actualizarDatos(this.cnx, atributoActualizar, condicion, tabla, atributosActualizacion);
            String filtroIdCliente = jTFIBuscadorAct1.getText();
            CreadorTablas creadorTablas = new CreadorTablas();
            DefaultTableModel modelo = creadorTablas.mostrarClienteParametrizado(cnx, filtroIdCliente, "N");
            tablaActualizarCliente.setModel(modelo);
            JTextField[] camposParaLimpiar = {ciActualizar, nombreActualizar, apellidoActualizar, telefonoActualizar, direccionActualizar, correoActualizar};
            validadorCheck.limpiarCampos(camposParaLimpiar);
        }
    }//GEN-LAST:event_jBIActualizarAct1ActionPerformed

    private void jTFIBuscadorAct1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscadorAct1KeyReleased
        String filtroIdCliente = jTFIBuscadorAct1.getText();
        CreadorTablas creadorTablas = new CreadorTablas();
        DefaultTableModel modelo = creadorTablas.mostrarClienteParametrizado(cnx, filtroIdCliente, "N");
        tablaActualizarCliente.setModel(modelo);
    }//GEN-LAST:event_jTFIBuscadorAct1KeyReleased

    private void jTFIBuscadorAct1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFIBuscadorAct1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIBuscadorAct1KeyTyped

    private void telefonoSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoSelectActionPerformed
        validadorCheck.actualizarCampo(telefonoSelect, telefonoActualizar, telfCliente1, errorActualizarCliente1);
    }//GEN-LAST:event_telefonoSelectActionPerformed

    private void direccionSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionSelectActionPerformed
        validadorCheck.actualizarCampo(direccionSelect, direccionActualizar, dirCliente1, errorActualizarCliente2);
    }//GEN-LAST:event_direccionSelectActionPerformed

    private void direccionActualizarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_direccionActualizarFocusLost
        dirCliente1 = validarRegistroF.camposDeRegistros(direccionActualizar, errorActualizarCliente2, "d");
    }//GEN-LAST:event_direccionActualizarFocusLost

    private void direccionActualizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionActualizarKeyReleased
        dirCliente1 = validarRegistroF.camposDeRegistros(direccionActualizar, errorActualizarCliente2, "d");
    }//GEN-LAST:event_direccionActualizarKeyReleased

    private void telefonoActualizarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonoActualizarFocusLost
        String tipoCliente = (String) jCBNacionalExtranjero2.getSelectedItem();
        telfCliente1 = validarRegistroF.camposCliente(telefonoActualizar, errorActualizarCliente1, tipoCliente, "Ninguno", "b");
    }//GEN-LAST:event_telefonoActualizarFocusLost

    private void telefonoActualizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoActualizarKeyReleased
        String tipoCliente = (String) jCBNacionalExtranjero2.getSelectedItem();
        telfCliente1 = validarRegistroF.camposCliente(telefonoActualizar, errorActualizarCliente1, tipoCliente, "Ninguno", "b");
    }//GEN-LAST:event_telefonoActualizarKeyReleased

    private void correoSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoSelectActionPerformed
        validadorCheck.actualizarCampo(correoSelect, correoActualizar, correoElectronico1, errorActualizarCliente3);
    }//GEN-LAST:event_correoSelectActionPerformed

    private void correoActualizarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoActualizarFocusLost
        correoElectronico1 = validarRegistroF.camposDeRegistros(correoActualizar, errorActualizarCliente3, "c");
    }//GEN-LAST:event_correoActualizarFocusLost

    private void correoActualizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoActualizarKeyReleased
        correoElectronico1 = validarRegistroF.camposDeRegistros(correoActualizar, errorActualizarCliente3, "c");
    }//GEN-LAST:event_correoActualizarKeyReleased

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

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        getToolkit().beep();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro de cerrar la ventana?", "Warning", dialogButton);
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
            java.util.logging.Logger.getLogger(JFRemitente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFRemitente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFRemitente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRemitente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFRemitente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CIselect;
    private javax.swing.JPanel JPRemitente;
    private javax.swing.JTextField apellidoActualizar;
    private javax.swing.JCheckBox apellidoSelect;
    private javax.swing.JButton btnExit;
    private javax.swing.JTextField ciActualizar;
    private javax.swing.JTextField correoActualizar;
    private javax.swing.JTextField correoCli2;
    private javax.swing.JCheckBox correoSelect;
    private javax.swing.JTextField direccionActualizar;
    private javax.swing.JCheckBox direccionSelect;
    private javax.swing.JLabel documentoActualizar;
    private javax.swing.JLabel errorActualizarCliente1;
    private javax.swing.JLabel errorActualizarCliente2;
    private javax.swing.JLabel errorActualizarCliente3;
    private javax.swing.JLabel errorActualizarCliente4;
    private javax.swing.JLabel errorActualizarCliente5;
    private javax.swing.JLabel errorActualizarCliente6;
    private javax.swing.JLabel errorc1;
    private javax.swing.JLabel errorc2;
    private javax.swing.JLabel errorc3;
    private javax.swing.JLabel errorc4;
    private javax.swing.JLabel errorc5;
    private javax.swing.JLabel errorc6;
    private javax.swing.JButton jBIActualizarAct1;
    private javax.swing.JButton jBRegistarCliente;
    private javax.swing.JComboBox<String> jCBNacionalExtranjero;
    private javax.swing.JComboBox<String> jCBNacionalExtranjero2;
    private javax.swing.JComboBox<String> jCJuridicoNatural;
    private javax.swing.JComboBox<String> jCJuridicoNatural1;
    private javax.swing.JLabel jLTipoCli;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JPanel jPActualizarClientes;
    private javax.swing.JPanel jPCambiarEstado;
    private javax.swing.JTabbedPane jPClientes;
    private javax.swing.JPanel jPPA1;
    private javax.swing.JPanel jPPC1;
    private javax.swing.JPanel jPPCE1;
    private javax.swing.JPanel jPPR1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JTextField jTFApellidosR;
    private javax.swing.JTextField jTFCIRegistrarC;
    private javax.swing.JTextField jTFDireccionR;
    private javax.swing.JTextField jTFIBuscadorAct1;
    private javax.swing.JTextField jTFNombresR;
    private javax.swing.JTextField jTFTelefonoR;
    private javax.swing.JTable jTablaClientesR;
    private javax.swing.JTextField nombreActualizar;
    private javax.swing.JCheckBox nombreSelect;
    private javax.swing.JTable tablaActualizarCliente;
    private javax.swing.JTextField telefonoActualizar;
    private javax.swing.JCheckBox telefonoSelect;
    // End of variables declaration//GEN-END:variables
}
