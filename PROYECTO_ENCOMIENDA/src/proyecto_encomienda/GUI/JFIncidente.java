/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_encomienda.GUI;
import java.sql.Connection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_ecomienda.BDYValidaciones.CreadorTablas;
import proyecto_ecomienda.BDYValidaciones.ContadorDeIDs;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;
import proyecto_encomienda.INCIDENTES.DanioPaquete;
import proyecto_encomienda.INCIDENTES.ErrorDireccion;
import proyecto_encomienda.INCIDENTES.GestorIncidentes;
import proyecto_encomienda.INCIDENTES.Incidente;
import proyecto_encomienda.INCIDENTES.PaquetePerdido;
import proyecto_encomienda.INCIDENTES.RechazoEntrega;
/**
 *
 * @author Moises Arequipa
 * @Grupo: Segunda es Todo
 */
public class JFIncidente extends javax.swing.JFrame {

    /**
     * Creates new form JFIncidente
     */
    //Connexion
    Connection cnx;
    private ContadorDeIDs contadorDeIDs;
    //Mouse
    int xMouse, yMouse;
    public JFIncidente(Connection cnx) {
        initComponents();
        this.contadorDeIDs = new ContadorDeIDs(cnx);
    }
    
    public JFIncidente( ) {
        initComponents();
    }

    public void desvanecerP() {
        JLabel[] labels = {
             errorInventario1, errorInventario2, errorInventario2,
            errorInventario1, errorInventario2, errorInventario3, errorInventario8};
        for (int i = 0; i < labels.length; i++) {
            JLabel label = labels[i % labels.length];
            label.setVisible(false);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPIncidentes = new javax.swing.JPanel();
        jPIncidentes = new javax.swing.JPanel();
        jTPEmpleados1 = new javax.swing.JTabbedPane();
        jPRE1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        SeleccionIncidentesCB = new javax.swing.JComboBox<>();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        IDPIncidentesTF = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        RazonIncidentesTA = new javax.swing.JTextArea();
        RegistrarIncidentesButton = new javax.swing.JButton();
        jLabel136 = new javax.swing.JLabel();
        IDIncidentesTF = new javax.swing.JTextField();
        errorInventario1 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        jTIncidentes = new javax.swing.JTable();
        jPAE1 = new javax.swing.JPanel();
        jPEE1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        JPIncidentes.setBackground(new java.awt.Color(245, 245, 245));
        JPIncidentes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPIncidentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTPEmpleados1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPEmpleados1MouseClicked(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SeleccionIncidentesCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Daño en el Paquete", "Error de Dirección", "Paquete Perdido", "Rechazo Entrega" }));
        SeleccionIncidentesCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionIncidentesCBActionPerformed(evt);
            }
        });

        jLabel133.setText("Tipo de incidente:");

        jLabel134.setText("Código único del paquete");

        IDPIncidentesTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                IDPIncidentesTFKeyReleased(evt);
            }
        });

        jLabel135.setText("Descripción");

        RazonIncidentesTA.setColumns(20);
        RazonIncidentesTA.setRows(5);
        jScrollPane4.setViewportView(RazonIncidentesTA);

        RegistrarIncidentesButton.setText("Registrar");
        RegistrarIncidentesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarIncidentesButtonActionPerformed(evt);
            }
        });

        jLabel136.setText("Código único del incidente");

        IDIncidentesTF.setEditable(false);
        IDIncidentesTF.setEnabled(false);
        IDIncidentesTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDIncidentesTFActionPerformed(evt);
            }
        });

        errorInventario1.setForeground(new java.awt.Color(255, 0, 51));
        errorInventario1.setText("Código único inválido");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel134, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                        .addComponent(jLabel133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel135)
                    .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegistrarIncidentesButton)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(SeleccionIncidentesCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IDPIncidentesTF, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(IDIncidentesTF, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorInventario1))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel136)
                    .addComponent(IDIncidentesTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel134)
                    .addComponent(IDPIncidentesTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(errorInventario1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133)
                    .addComponent(SeleccionIncidentesCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel135))
                .addGap(18, 18, 18)
                .addComponent(RegistrarIncidentesButton)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTIncidentes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane28.setViewportView(jTIncidentes);

        javax.swing.GroupLayout jPRE1Layout = new javax.swing.GroupLayout(jPRE1);
        jPRE1.setLayout(jPRE1Layout);
        jPRE1Layout.setHorizontalGroup(
            jPRE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRE1Layout.createSequentialGroup()
                .addGroup(jPRE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPRE1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPRE1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPRE1Layout.setVerticalGroup(
            jPRE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRE1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTPEmpleados1.addTab("Registrar Incidente", jPRE1);

        javax.swing.GroupLayout jPAE1Layout = new javax.swing.GroupLayout(jPAE1);
        jPAE1.setLayout(jPAE1Layout);
        jPAE1Layout.setHorizontalGroup(
            jPAE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 965, Short.MAX_VALUE)
        );
        jPAE1Layout.setVerticalGroup(
            jPAE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        jTPEmpleados1.addTab("Actualizar", jPAE1);

        javax.swing.GroupLayout jPEE1Layout = new javax.swing.GroupLayout(jPEE1);
        jPEE1.setLayout(jPEE1Layout);
        jPEE1Layout.setHorizontalGroup(
            jPEE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 965, Short.MAX_VALUE)
        );
        jPEE1Layout.setVerticalGroup(
            jPEE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        jTPEmpleados1.addTab("Cambiar de estado", jPEE1);

        javax.swing.GroupLayout jPIncidentesLayout = new javax.swing.GroupLayout(jPIncidentes);
        jPIncidentes.setLayout(jPIncidentesLayout);
        jPIncidentesLayout.setHorizontalGroup(
            jPIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIncidentesLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jTPEmpleados1, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPIncidentesLayout.setVerticalGroup(
            jPIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIncidentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTPEmpleados1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        JPIncidentes.add(jPIncidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1080, 640));

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
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ecomienda/iconos/power_24dp.png"))); // NOI18N
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

        JPIncidentes.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, -1));

        getContentPane().add(JPIncidentes, "card6");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeleccionIncidentesCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionIncidentesCBActionPerformed

    }//GEN-LAST:event_SeleccionIncidentesCBActionPerformed

    private void IDPIncidentesTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDPIncidentesTFKeyReleased
        String idPaqueteStr = IDPIncidentesTF.getText().trim();
        DefaultTableModel modelo = new CreadorTablas().mostrarVistaDatosPaquete(cnx, idPaqueteStr);
        jTIncidentes.setModel(modelo);
    }//GEN-LAST:event_IDPIncidentesTFKeyReleased

    private void RegistrarIncidentesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarIncidentesButtonActionPerformed
        int idIncidente = Integer.parseInt(IDIncidentesTF.getText());
        int idPaquete = Integer.parseInt(IDPIncidentesTF.getText());
        String tipoIncidente = SeleccionIncidentesCB.getSelectedItem().toString();
        String descripcion = RazonIncidentesTA.getText();

        // Crear instancia de GestorIncidentes
        Inventario inventario = new Inventario(); // Asegúrate de tener una instancia de Inventario
        GestorIncidentes gestorIncidentes = new GestorIncidentes(inventario, cnx);

        // Crear el incidente según el tipo
        Incidente incidente = null;
        switch (tipoIncidente) {
            case "Daño en el Paquete":
            incidente = new DanioPaquete(descripcion, idPaquete, idIncidente, cnx);
            break;
            case "Error de Dirección":
            incidente = new ErrorDireccion(descripcion, idPaquete, idIncidente, cnx);
            break;
            case "Paquete Perdido":
            incidente = new PaquetePerdido(descripcion, idPaquete, idIncidente, cnx);
            break;
            case "Rechazo Entrega":
            incidente = new RechazoEntrega(descripcion, idPaquete, idIncidente, cnx);
            break;
            default:
            throw new IllegalArgumentException("Tipo de incidente desconocido: " + tipoIncidente);
        }

        // Registrar el incidente
         gestorIncidentes.crearIncidente(incidente, idPaquete);
    }//GEN-LAST:event_RegistrarIncidentesButtonActionPerformed

    private void IDIncidentesTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDIncidentesTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDIncidentesTFActionPerformed

    private void jTPEmpleados1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPEmpleados1MouseClicked

    }//GEN-LAST:event_jTPEmpleados1MouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        getToolkit().beep();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro de quieres cerrar la ventana?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            //this.dispose();
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
            java.util.logging.Logger.getLogger(JFIncidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFIncidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFIncidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFIncidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFIncidente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDIncidentesTF;
    private javax.swing.JTextField IDPIncidentesTF;
    private javax.swing.JPanel JPIncidentes;
    private javax.swing.JTextArea RazonIncidentesTA;
    private javax.swing.JButton RegistrarIncidentesButton;
    private javax.swing.JComboBox<String> SeleccionIncidentesCB;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel errorInventario1;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPAE1;
    private javax.swing.JPanel jPEE1;
    private javax.swing.JPanel jPIncidentes;
    private javax.swing.JPanel jPRE1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTIncidentes;
    private javax.swing.JTabbedPane jTPEmpleados1;
    // End of variables declaration//GEN-END:variables
}
