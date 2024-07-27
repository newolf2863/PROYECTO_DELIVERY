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
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Paquete;


/**
 *
 * @author USUARIO
 */
public class JFInventario extends javax.swing.JFrame {
    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
    private boolean anchoValidar = false;
    private boolean largoValidar = false;
    private boolean pesoValidar = false;
    private boolean remitenteValidar = false;
    private boolean destinoValidar = false;
    private boolean contenidoValidar=false;
    Connection cnx;
    
    //Mouse
    int xMouse, yMouse; 
    public JFInventario(Connection conexion) {      
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/caja.png")).getImage());
        this.cnx=conexion;
        //All Files	C:\Users\USUARIO\GitHub\PROYECTO_DELIVERY\PROYECTO_ENCOMIENDA\src\proyecto_encomienda\GESTION_PAQUETES\FRONTEND\imagenes\caja.png
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        contadorProductos();
        contadorTraking();
        desvanecerP();
        setLocationRelativeTo(null);
        placeHolder();
    }
    public JFInventario() {      
        initComponents();
    }
 private void placeHolder() {
        TextPrompt texto1 = new TextPrompt("Obligatorio", jTContenidoPaquete);
        TextPrompt texto2 = new TextPrompt("Obligatorio", jTAncho);
        TextPrompt texto3 = new TextPrompt("Obligatorio", jTPeso);
        TextPrompt texto = new TextPrompt("Obligatorio", jTRemitente);
        TextPrompt texto4 = new TextPrompt("Obligatorio", jTLargo);
        TextPrompt texto5 = new TextPrompt("Obligatorio", jTDestino);
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
    
    public void contadorTraking() {
        try {
            // Consulta para obtener el máximo ID de Paquete
            String consulta = "SELECT COALESCE(MAX(idInventario), 0) AS max_id FROM Inventario";
            PreparedStatement stmt = cnx.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                // Si maxId es 0 (no hay paquetes), establece el siguiente ID como 1
                int siguienteId = (maxId == 0) ? 1 : maxId + 1;
                jTCodigoTraking.setText(String.valueOf(siguienteId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja cualquier error de conexión o consulta aquí
        }
    }
    
    public void contadorInventario() {
        try {
            // Consulta para obtener el máximo ID de Paquete
            String consulta = "SELECT COALESCE(MAX(idInventario), 0) AS max_id FROM Inventario";
            PreparedStatement stmt = cnx.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                // Si maxId es 0 (no hay paquetes), establece el siguiente ID como 1
                int siguienteId = (maxId == 0) ? 1 : maxId + 1;
                jTCodigoTraking.setText(String.valueOf(siguienteId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja cualquier error de conexión o consulta aquí
        }
    }
    
    

     private void ordenarTablaPorCodigoTracking() {
        DefaultTableModel modeloTabla4 = (DefaultTableModel) jTablaInventario4.getModel();
        TableRowSorter<DefaultTableModel> ordenador = new TableRowSorter<>(modeloTabla4);
        jTablaInventario4.setRowSorter(ordenador);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING)); // Suponiendo que el código de tracking está en la columna 1
        ordenador.setSortKeys(sortKeys);
        ordenador.sort();
    }
     
     private void limpiarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Establece el número de filas a cero para vaciar la tabla
    }
     
     public void contadorTrakings() {
        try {
            // Consulta para obtener el máximo ID de Paquete
            String consulta = "SELECT COALESCE(MAX(codigoTraking), 0) AS max_id FROM Inventario_Paquete";
            PreparedStatement stmt = cnx.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                // Si maxId es 0 (no hay paquetes), establece el siguiente ID como 1
                int siguienteId = (maxId == 0) ? 1 : maxId + 1;
                jTCodigoTraking.setText(String.valueOf(siguienteId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja cualquier error de conexión o consulta aquí
        }
    }
     
      public void desvanecerP() {
        JLabel[] labels = {
             errorInventario1, errorInventario2, errorInventario2,
            errorInventario1, errorInventario2, errorInventario5, errorInventario4};
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
        errorInventario5 = new javax.swing.JLabel();
        jTLargo = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jTRemitente = new javax.swing.JTextField();
        errorInventario4 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jTDestino = new javax.swing.JTextField();
        jTAncho = new javax.swing.JTextField();
        errorInventario3 = new javax.swing.JLabel();
        errorInventario6 = new javax.swing.JLabel();
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 910, Short.MAX_VALUE)
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

        jTContenidoPaquete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTContenidoPaqueteFocusLost(evt);
            }
        });

        jLabel35.setText("Largo");

        errorInventario5.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario5.setText("Largo no valido");

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

        jLabel62.setText("m");

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

        errorInventario4.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario4.setText("Remitente no valido");

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

        errorInventario3.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario3.setText("Destino no válido");

        errorInventario6.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario6.setText("contenido no valido");

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
                                            .addComponent(jTContenidoPaquete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                            .addComponent(jTLargo))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel62)
                                        .addGap(192, 192, 192))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(errorInventario4)
                                            .addComponent(jTRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(errorInventario5)
                                            .addComponent(errorInventario6))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorInventario2)
                            .addComponent(jTDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTiDPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel61)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorInventario1)
                            .addComponent(errorInventario3))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                                .addComponent(jLabel14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel61))))
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
                        .addComponent(errorInventario4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62)
                            .addComponent(jTLargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorInventario5)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTContenidoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(errorInventario2)
                    .addComponent(errorInventario6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addComponent(jTDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorInventario3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );

        jPIR.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, 991, -1));

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

    private void jTPesoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTPesoFocusLost
        pesoValidar = validarRegistroF.camposDeRegistros(jTPeso, errorInventario2, "precio");
    }//GEN-LAST:event_jTPesoFocusLost

    private void jTPesoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesoKeyReleased
        pesoValidar = validarRegistroF.camposDeRegistros(jTPeso, errorInventario2, "precio");
    }//GEN-LAST:event_jTPesoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JTextField[] campos = {jTAncho,jTPeso,jTDestino,jTRemitente, jTLargo, jTContenidoPaquete};
        Boolean[] booleanItem = {anchoValidar,pesoValidar,destinoValidar,remitenteValidar, largoValidar, contenidoValidar};
        JLabel[] labels = {errorInventario1, errorInventario2, errorInventario3, errorInventario4,errorInventario5,errorInventario6};
        String[] nombresCampos = {"Ancho", "Peso", "Destino","Remitente", "Largo","Contenido del paquete"};
        List<String> errores = validadorCheck.validarCamposLista(campos, booleanItem, labels, nombresCampos);
        errores.addAll(validadorCheck.validarCamposVaciosLista(campos, booleanItem, labels, nombresCampos));
        String estado = "Pendiente";

        if (!errores.isEmpty()) {
            StringBuilder mensajeError = new StringBuilder("Se encontraron los siguientes errores:\n");
            for (String error : errores) {
                mensajeError.append("- ").append(error).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensajeError.toString(), "Errores", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int idPaquete = Integer.parseInt(jTiDPaquete.getText());
                String contenidoPaquete = jTContenidoPaquete.getText();
                double ancho = Double.parseDouble(jTAncho.getText());
                double peso = Double.parseDouble(jTPeso.getText());
                double largo = Double.parseDouble(jTLargo.getText());
                String remitente = jTRemitente.getText();
                String destino = jTDestino.getText();

                Paquete paquete = new Paquete(idPaquete, ancho, peso, largo, contenidoPaquete, remitente, destino);
                Paquete.ingresarPaquete(cnx, paquete);
                paquete.setEstado(estado);

                // Llamar a iniciarEnvio después de registrar el paquete
                paquete.iniciarEnvio();

                CreadorTablas cnn = new CreadorTablas();
                DefaultTableModel modelo = cnn.mostrarTablaPaquetes(cnx);

                jTContenidoPaquete.setText("");
                jTAncho.setText("");
                jTPeso.setText("");
                jTLargo.setText("");
                jTRemitente.setText("");
                jTDestino.setText("");
                contadorProductos();
                this.jTPaquetes.setModel(modelo);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error en los datos numéricos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTLargoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTLargoFocusLost
        largoValidar = validarRegistroF.camposDeRegistros(jTLargo, errorInventario5, "precio");
    }//GEN-LAST:event_jTLargoFocusLost

    private void jTLargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTLargoKeyReleased
        largoValidar = validarRegistroF.camposDeRegistros(jTLargo, errorInventario5, "precio");
    }//GEN-LAST:event_jTLargoKeyReleased

    private void jTRemitenteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTRemitenteFocusLost
        remitenteValidar = validarRegistroF.camposDeRegistros(jTRemitente, errorInventario4, "d");
    }//GEN-LAST:event_jTRemitenteFocusLost

    private void jTRemitenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTRemitenteKeyReleased
        remitenteValidar = validarRegistroF.camposDeRegistros(jTRemitente, errorInventario4, "d");
    }//GEN-LAST:event_jTRemitenteKeyReleased

    private void jTDestinoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTDestinoFocusLost
       destinoValidar = validarRegistroF.camposDeRegistros(jTDestino, errorInventario3, "d");
    }//GEN-LAST:event_jTDestinoFocusLost

    private void jTDestinoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDestinoKeyReleased
       destinoValidar = validarRegistroF.camposDeRegistros(jTDestino, errorInventario3, "d");
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
                ordenarTablaPorCodigoTracking();

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
        String idPaquete = jTiDPaquete1.getText();
        DefaultTableModel modelo = ConsultarBD.buscarPaquetePorId(cnx, idPaquete);
        jTablaInventario3.setModel(modelo);
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
        String descripcion = jTFDescripcionInventario.getText();
        IngresadorDeDatos.registrarDatosInventario(cnx, jTablaInventario4, descripcion);
        // Limpiar la tabla y otros elementos
        limpiarTabla(jTablaInventario4);
        contadorTraking();
        contadorTrakings();
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
            java.util.logging.Logger.getLogger(JFInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel errorInventario1;
    private javax.swing.JLabel errorInventario2;
    private javax.swing.JLabel errorInventario3;
    private javax.swing.JLabel errorInventario4;
    private javax.swing.JLabel errorInventario5;
    private javax.swing.JLabel errorInventario6;
    private javax.swing.JLabel errorTraking1;
    private javax.swing.JButton jBRegistrarPAInventario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
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
    private javax.swing.JTextField jTDestino;
    private javax.swing.JTextField jTFDescripcionInventario;
    private javax.swing.JTextField jTLargo;
    private javax.swing.JTable jTPaquetes;
    private javax.swing.JTextField jTPeso;
    private javax.swing.JTextField jTRemitente;
    private javax.swing.JTable jTablaInventario1;
    private javax.swing.JTable jTablaInventario2;
    private javax.swing.JTable jTablaInventario3;
    private javax.swing.JTable jTablaInventario4;
    private javax.swing.JTextField jTiDPaquete;
    private javax.swing.JTextField jTiDPaquete1;
    // End of variables declaration//GEN-END:variables
}
