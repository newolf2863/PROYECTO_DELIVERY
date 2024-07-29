/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_encomienda.GUI;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_encomienda.BDYValidaciones.ConsultarBD;
import proyecto_encomienda.BDYValidaciones.CreadorTablas;
import proyecto_encomienda.BDYValidaciones.IngresadorDeDatos;
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
import proyecto_encomienda.BDYValidaciones.TextPrompt;
import proyecto_encomienda.BDYValidaciones.ValidadorDeSwings;
import proyecto_encomienda.BDYValidaciones.ValidadorDeRegistros;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Paquete;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Pendiente;
import proyecto_encomienda.GESTOR_PERFILES.Perfil;


/**
 *
 * @author USUARIO
 */
public class JFGestionPaquetes extends javax.swing.JFrame {
    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
    private boolean anchoValidar = false;
    private boolean largoValidar = false;
    private boolean pesoValidar = false;
    private boolean remitenteValidar = false;
    private boolean destinoValidar = false;
    private boolean contenidoValidar=false;

    
    //Mouse
    int xMouse, yMouse; 
   
    public JFGestionPaquetes() {      
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/caja.png")).getImage());
      
        //All Files	C:\Users\USUARIO\GitHub\PROYECTO_DELIVERY\PROYECTO_ENCOMIENDA\src\proyecto_encomienda\GESTION_PAQUETES\FRONTEND\imagenes\caja.png
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);


        desvanecerP();
        setLocationRelativeTo(null);
        placeHolder();
    }
 

    
 
    private void placeHolder() {
        TextPrompt texto1 = new TextPrompt("Obligatorio", jTContenidoPaquete);
        TextPrompt texto2 = new TextPrompt("Obligatorio", jTAncho);
        TextPrompt texto3 = new TextPrompt("Obligatorio", jTPeso);
        TextPrompt texto = new TextPrompt("Obligatorio", jTRemitente);
        TextPrompt texto4 = new TextPrompt("Obligatorio", jTProvinciaOrigen);
        TextPrompt texto5 = new TextPrompt("Obligatorio", jTPeso);
    }    

    

     
     private void limpiarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Establece el número de filas a cero para vaciar la tabla
    }
     
     
     
      public void desvanecerP() {
        JLabel[] labels = {
             errorAncho, errorLargo, errorContenido,
             errorEspesor, errorPeso, errorProvinciaDestino, 
             errorProvinciaOrigen, errorRemitente, errorDireccionDestino};
        for (int i = 0; i < labels.length; i++) {
            JLabel label = labels[i % labels.length];
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
        jScrollPane8 = new javax.swing.JScrollPane();
        jTPaquetes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jTContenidoPaquete = new javax.swing.JTextField();
        jTProvinciaOrigen = new javax.swing.JTextField();
        jTPeso = new javax.swing.JTextField();
        jTAncho = new javax.swing.JTextField();
        jTEspesor = new javax.swing.JTextField();
        jTIdPaquete = new javax.swing.JTextField();
        jTLargo = new javax.swing.JTextField();
        jTRemitente = new javax.swing.JTextField();
        jTProvinciaDestino = new javax.swing.JTextField();
        errorPeso = new javax.swing.JLabel();
        errorAncho = new javax.swing.JLabel();
        errorProvinciaOrigen = new javax.swing.JLabel();
        errorContenido = new javax.swing.JLabel();
        errorEspesor = new javax.swing.JLabel();
        errorLargo = new javax.swing.JLabel();
        errorDireccionDestino = new javax.swing.JLabel();
        errorProvinciaDestino = new javax.swing.JLabel();
        jBtnBuscarRemitente = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        jTDireccionDestino = new javax.swing.JTextField();
        errorRemitente = new javax.swing.JLabel();
        jPID = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTCodigoTraking = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTiDPaquete1 = new javax.swing.JTextField();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTablaInventario4 = new javax.swing.JTable();
        jBRegistrarPAInventario = new javax.swing.JButton();
        jLabel115 = new javax.swing.JLabel();
        jTFDescripcionInventario = new javax.swing.JTextField();
        errorTraking1 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTablaInventario3 = new javax.swing.JTable();
        jPIA = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTablaInventario1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTablaInventario2 = new javax.swing.JTable();

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

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Gestión de Envios");

        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/icons8_Delete_32px.png"))); // NOI18N
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
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 896, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 30));

        jPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPIR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPIR.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 961, 153));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del paquete"));
        jPanel2.setPreferredSize(new java.awt.Dimension(1020, 360));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("ID Paquete");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 89, -1));

        jLabel13.setText("Provincia Destino");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, -1, -1));

        jLabel11.setText("Peso");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel60.setText("cm");
        jPanel2.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        jLabel14.setText("Ancho");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel53.setText("Remitente");
        jPanel2.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, -1));

        jLabel63.setText("Dirección destino");
        jPanel2.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        jLabel15.setText("Largo");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel16.setText("Espesor");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel64.setText("Kg");
        jPanel2.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, -1));

        jLabel65.setText("cm");
        jPanel2.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        jLabel66.setText("cm");
        jPanel2.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        jLabel17.setText("Contenido");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        jLabel18.setText("Provincia Origen");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 314, 123, -1));
        jPanel2.add(jTContenidoPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 290, -1));
        jPanel2.add(jTProvinciaOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 290, -1));
        jPanel2.add(jTPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 210, -1));
        jPanel2.add(jTAncho, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 210, -1));
        jPanel2.add(jTEspesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 210, -1));
        jPanel2.add(jTIdPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 210, -1));
        jPanel2.add(jTLargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 210, -1));
        jPanel2.add(jTRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 290, -1));
        jPanel2.add(jTProvinciaDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 290, -1));

        errorPeso.setForeground(new java.awt.Color(255, 0, 51));
        errorPeso.setText("Peso no válido");
        jPanel2.add(errorPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 90, 20));

        errorAncho.setForeground(new java.awt.Color(255, 0, 51));
        errorAncho.setText("Ancho no válido");
        jPanel2.add(errorAncho, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 110, 20));

        errorProvinciaOrigen.setForeground(new java.awt.Color(255, 0, 51));
        errorProvinciaOrigen.setText("Provincia origen no válido");
        jPanel2.add(errorProvinciaOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 170, 20));

        errorContenido.setForeground(new java.awt.Color(255, 0, 51));
        errorContenido.setText("Contenido no válido");
        jPanel2.add(errorContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 140, 20));

        errorEspesor.setForeground(new java.awt.Color(255, 0, 51));
        errorEspesor.setText("Espesor no válido");
        jPanel2.add(errorEspesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 110, 20));

        errorLargo.setForeground(new java.awt.Color(255, 0, 51));
        errorLargo.setText("Largo no válido");
        jPanel2.add(errorLargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 100, 20));

        errorDireccionDestino.setForeground(new java.awt.Color(255, 0, 51));
        errorDireccionDestino.setText("Destino no válido");
        jPanel2.add(errorDireccionDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 110, 20));

        errorProvinciaDestino.setForeground(new java.awt.Color(255, 0, 51));
        errorProvinciaDestino.setText("Provincia destino no válido");
        jPanel2.add(errorProvinciaDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 170, 20));

        jBtnBuscarRemitente.setText("Buscar");
        jBtnBuscarRemitente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarRemitenteActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnBuscarRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, -1, -1));

        jLabel54.setText("Remitente");
        jPanel2.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, -1, -1));

        jTDireccionDestino.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTDireccionDestinoFocusLost(evt);
            }
        });
        jTDireccionDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTDireccionDestinoKeyReleased(evt);
            }
        });
        jPanel2.add(jTDireccionDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 290, -1));

        errorRemitente.setForeground(new java.awt.Color(255, 0, 51));
        errorRemitente.setText("Remitente no válido");
        jPanel2.add(errorRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 130, 20));

        jPIR.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 360));

        jPanel_General.addTab("Registrar", jPIR);

        jPID.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar paquetes a un inventario"));

        jLabel12.setText("Código Tracking");

        jTCodigoTraking.setEditable(false);
        jTCodigoTraking.setEnabled(false);

        jLabel32.setText("ID Paquete");

        jTiDPaquete1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTiDPaquete1KeyReleased(evt);
            }
        });

        jTablaInventario4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID paquete", "Código Tracking", "Contenido del paquete"
            }
        ));
        jTablaInventario4.setCellSelectionEnabled(true);
        jTablaInventario4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaInventario4MouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(jTablaInventario4);

        jBRegistrarPAInventario.setText("Registrar paquetes a inventario");
        jBRegistrarPAInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarPAInventarioActionPerformed(evt);
            }
        });

        jLabel115.setText("Descripción");

        errorTraking1.setForeground(new java.awt.Color(255, 0, 51));
        errorTraking1.setText("Ingrese una descripción");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBRegistrarPAInventario)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel115))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTCodigoTraking, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jTiDPaquete1)
                            .addComponent(jTFDescripcionInventario)
                            .addComponent(errorTraking1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTCodigoTraking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jTiDPaquete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(jTFDescripcionInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorTraking1)
                .addGap(29, 29, 29)
                .addComponent(jBRegistrarPAInventario)
                .addGap(20, 20, 20))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPID.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 980, -1));

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
        jTablaInventario3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaInventario3MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTablaInventario3);

        jPID.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 920, 233));

        jPanel_General.addTab("Registrar paquetes a un inventario", jPID);

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
        jScrollPane7.setViewportView(jTablaInventario1);

        jPIA.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 256, 891, 237));

        jPanel_General.addTab("Actualizar", jPIA);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar Inventario"));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 51, -1, -1));

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

        jPanel5.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 243, 896, 252));

        jPanel_General.addTab("Consultar", jPanel5);

        jPrincipal.add(jPanel_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1030, 610));

        getContentPane().add(jPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1010, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablaInventario3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaInventario3MouseClicked
        int filaSeleccionada = jTablaInventario3.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Obtener los datos de la fila seleccionada
            String idPaquete = jTablaInventario3.getValueAt(filaSeleccionada, 0).toString(); // Suponiendo que el ID Paquete está en la columna 0
            String codigoTraking = jTCodigoTraking.getText(); // Suponiendo que Remitente está en la columna 2
            String descripcion = jTablaInventario3.getValueAt(filaSeleccionada, 4).toString();
            // Obtener el modelo de la tabla jTablaInventario4
            DefaultTableModel modeloTabla4 = (DefaultTableModel) jTablaInventario4.getModel();
            boolean modeloTabla4Vacio = modeloTabla4.getRowCount() == 0
            || modeloTabla4.getValueAt(0, 0) == null
            || modeloTabla4.getValueAt(0, 0).toString().isEmpty();

            if (modeloTabla4Vacio) {
                // Si modeloTabla4 está vacío en la primera celda, limpiar la tabla
                modeloTabla4.setRowCount(0);
            }

            // Verificar si el ID de paquete ya existe en jTablaInventario4
            boolean idExistente = false;
            for (int i = 0; i < modeloTabla4.getRowCount(); i++) {
                String idExistenteEnTabla4 = modeloTabla4.getValueAt(i, 0).toString();
                if (idExistenteEnTabla4.equals(idPaquete)) {
                    idExistente = true;
                    break;
                }
            }

            if (!idExistente) {
                // Agregar la fila a jTablaInventario4
                Object[] fila = {idPaquete, codigoTraking, descripcion};
                modeloTabla4.addRow(fila);

                // Ordenar automáticamente por el número de ID (columna 0) ascendente


                // Eliminar la fila de jTablaInventario3
                DefaultTableModel modeloTabla3 = (DefaultTableModel) jTablaInventario3.getModel();
                modeloTabla3.removeRow(filaSeleccionada);

                // Notificar al modelo de la tabla para que la vista se actualice
                modeloTabla3.fireTableDataChanged();
            } else {
                JOptionPane.showMessageDialog(null, "El paquete con ID " + idPaquete + " ya está en la tabla Inventario.");
            }
        }
    }//GEN-LAST:event_jTablaInventario3MouseClicked

    private void jTiDPaquete1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTiDPaquete1KeyReleased

    }//GEN-LAST:event_jTiDPaquete1KeyReleased

    private void jTablaInventario4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaInventario4MouseClicked
        // Obtener el índice de la fila seleccionada
        int filaSeleccionada = jTablaInventario4.getSelectedRow();

        // Verificar que haya una fila seleccionada
        if (filaSeleccionada != -1) {
            // Obtener el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) jTablaInventario4.getModel();

            // Eliminar la fila del modelo de datos
            modelo.removeRow(filaSeleccionada);

            // Si necesitas hacer más acciones después de eliminar la fila, aquí lo podrías hacer
            // Actualizar la vista de la tabla
            jTablaInventario4.setModel(modelo);
        }
    }//GEN-LAST:event_jTablaInventario4MouseClicked

    private void jBRegistrarPAInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarPAInventarioActionPerformed

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

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        JTextField[] campos = {jTAncho,jTPeso,jTPeso,jTRemitente, jTProvinciaOrigen, jTContenidoPaquete};
        boolean campoVacio = false;
        for (JTextField campo : campos) {
            if (campo.getText().isEmpty()) {
            campoVacio = true;
            break; // Salir del bucle si se encuentra un campo vacío
        }
}

        if (campoVacio) {
            StringBuilder mensajeError = new StringBuilder("Se encontraron los siguientes errores:\n");
            mensajeError.append("- ").append("Existe algun campo vacío").append("\n");

            JOptionPane.showMessageDialog(null, mensajeError.toString(), "Errores", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String idPaquete = jTIdPaquete.getText();
                String contenidoPaquete = jTContenidoPaquete.getText();
                double ancho = Double.parseDouble(jTAncho.getText());
                double largo = Double.parseDouble(jTLargo.getText());
                double espesor = Double.parseDouble(jTEspesor.getText());
                double peso = Double.parseDouble(jTPeso.getText());
                String remitente = jTRemitente.getText();
                String direccionDestino = jTDireccionDestino.getText();
                String provinciaOrigen = jTProvinciaOrigen.getText();
                String provinciaDestino = jTProvinciaDestino.getText();

                Paquete paquete = new Paquete(idPaquete, ancho, largo, espesor, peso, contenidoPaquete, remitente, provinciaOrigen, provinciaDestino, direccionDestino);
                //Paquete.ingresarPaquete(cnx, paquete);
                paquete.setEstado("Pendiente");
                
                Inventario inventario = Inventario.obtenerInstancia();
                inventario.agregarPaquete(paquete);
                // Llamar a iniciarEnvio después de registrar el paquete




                jTContenidoPaquete.setText("");
                jTAncho.setText("");
                jTPeso.setText("");
                jTProvinciaOrigen.setText("");
                jTRemitente.setText("");
                jTPeso.setText("");
                jTLargo.setText("");
                jTProvinciaDestino.setText("");
                jTDireccionDestino.setText("");


            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error en los datos numéricos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jBtnBuscarRemitenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarRemitenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnBuscarRemitenteActionPerformed

    private void jTDireccionDestinoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTDireccionDestinoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDireccionDestinoFocusLost

    private void jTDireccionDestinoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDireccionDestinoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDireccionDestinoKeyReleased

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
            java.util.logging.Logger.getLogger(JFGestionPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFGestionPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFGestionPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFGestionPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFGestionPaquetes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel errorAncho;
    private javax.swing.JLabel errorContenido;
    private javax.swing.JLabel errorDireccionDestino;
    private javax.swing.JLabel errorEspesor;
    private javax.swing.JLabel errorLargo;
    private javax.swing.JLabel errorPeso;
    private javax.swing.JLabel errorProvinciaDestino;
    private javax.swing.JLabel errorProvinciaOrigen;
    private javax.swing.JLabel errorRemitente;
    private javax.swing.JLabel errorTraking1;
    private javax.swing.JButton jBRegistrarPAInventario;
    private javax.swing.JButton jBtnBuscarRemitente;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPIA;
    private javax.swing.JPanel jPID;
    private javax.swing.JPanel jPIR;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jPanel_General;
    private javax.swing.JPanel jPrincipal;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTAncho;
    private javax.swing.JTextField jTCodigoTraking;
    private javax.swing.JTextField jTContenidoPaquete;
    private javax.swing.JTextField jTDireccionDestino;
    private javax.swing.JTextField jTEspesor;
    private javax.swing.JTextField jTFDescripcionInventario;
    private javax.swing.JTextField jTIdPaquete;
    private javax.swing.JTextField jTLargo;
    private javax.swing.JTable jTPaquetes;
    private javax.swing.JTextField jTPeso;
    private javax.swing.JTextField jTProvinciaDestino;
    private javax.swing.JTextField jTProvinciaOrigen;
    private javax.swing.JTextField jTRemitente;
    private javax.swing.JTable jTablaInventario1;
    private javax.swing.JTable jTablaInventario2;
    private javax.swing.JTable jTablaInventario3;
    private javax.swing.JTable jTablaInventario4;
    private javax.swing.JTextField jTiDPaquete1;
    // End of variables declaration//GEN-END:variables
}
