/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.sql.Connection;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JPanel;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class JFFactura extends javax.swing.JFrame implements Printable {

    Connection cnx;


    public JFFactura(String obtenerCodigo, String obtenerFechaEmision, String obtenerCodigoTracking, 
            String obtenerNombreDestinatario, String obtenerProvinciaDestino, String obtenerDireccionDestino, 
            String obtenerDescripcion, String obtenerPesoPaquete, String nombresRemitente, String apellidosRemitente, 
            String direccionRemitente, String telefonoRemitente, String cedulaRemitente, double precioPaquete, 
            double precioDistancia, double precioImpuesto, double precioTotal) {
        initComponents(); // Inicializar componentes de la GUI

        this.setLocationRelativeTo(null);
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        jLCodigoFactura.setText(obtenerCodigo);
        jLCedulaRemitente.setText(cedulaRemitente);
        jLCodigoTracking.setText(obtenerCodigoTracking);
        jLDestinoProvincia.setText(obtenerProvinciaDestino);
        jLDireccionRemitente.setText(direccionRemitente);
        jLFechaFacturaEmitida.setText(obtenerFechaEmision);
        jLNombreDestinatario.setText(obtenerNombreDestinatario);
        jLNombresRemitente.setText(nombresRemitente);
        jLPrecioDistancia.setText(String.format("%.2f",precioDistancia));
        jLPrecioImpuestos.setText(String.format("%.2f",precioImpuesto));
        jLPrecioPaquete.setText(String.format("%.2f",precioPaquete));
        jLPrecioTotal.setText(String.format("%.2f",precioTotal));
        jLTelefonoRemitente.setText(telefonoRemitente);
        jLapellidosRemitente.setText(apellidosRemitente);
        jLDireccionDestino.setText(obtenerDireccionDestino);
        DefaultTableModel model = (DefaultTableModel) tblFactura.getModel();
            model.setRowCount(0);
            Object[] row = {
                1,
                obtenerDescripcion,
                obtenerPesoPaquete,
            };
            model.addRow(row);
        
        
    }
    public JFFactura() {
        initComponents(); // Inicializar componentes de la GUI

        this.setLocationRelativeTo(null);
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        
    }




    public void actualizarTablaFactura(DefaultTableModel nuevoModelo) {
        tblFactura.setModel(nuevoModelo);
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        // Dibuja el contenido del JPanel "Contenido" en el objeto Graphics
        Contenido.printAll(graphics);

        return Printable.PAGE_EXISTS;
    }

    public void generarPDF(JPanel panel, String filePath) {
        try {
            // Captura una captura de pantalla del JPanel
            BufferedImage screenshot = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
            panel.paint(screenshot.getGraphics());

            // Crea un nuevo documento PDF
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            // Dibuja la captura de pantalla en el PDF
            PDImageXObject pdImage = LosslessFactory.createFromImage(document, screenshot);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.drawImage(pdImage, 0, 0);
            contentStream.close();

            // Guarda el documento PDF
            document.save(filePath);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] convertirPDFaBytes(String filePath) {
        try {
            File file = new File(filePath);
            byte[] pdfBytes = new byte[(int) file.length()];

            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(pdfBytes);
            fileInputStream.close();

            return pdfBytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void guardarPDFenBD(int idFactura, byte[] pdfBytes) {
        try {
            String sql = "INSERT INTO tabla_pdf (idFactura, pdf) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
                preparedStatement.setInt(1, idFactura);
                preparedStatement.setBytes(2, pdfBytes);
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Factura guardada con exito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

        Contenido = new javax.swing.JPanel();
        nombreTienda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLCodigoFactura = new javax.swing.JLabel();
        direccionT = new javax.swing.JLabel();
        proforma = new javax.swing.JLabel();
        nombreC = new javax.swing.JLabel();
        jLFechaFacturaEmitida = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLCodigoTracking = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLDireccionDestino = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLCedulaRemitente = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        imprimirF = new javax.swing.JButton();
        jLPrecioPaquete = new javax.swing.JLabel();
        jLPrecioImpuestos = new javax.swing.JLabel();
        jLPrecioTotal = new javax.swing.JLabel();
        proforma1 = new javax.swing.JLabel();
        jLTelefonoRemitente = new javax.swing.JLabel();
        jLDireccionRemitente = new javax.swing.JLabel();
        jLapellidosRemitente = new javax.swing.JLabel();
        nombreC1 = new javax.swing.JLabel();
        direccionT1 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLPrecioDistancia = new javax.swing.JLabel();
        jLNombresRemitente = new javax.swing.JLabel();
        jLNombreDestinatario = new javax.swing.JLabel();
        jLDestinoProvincia = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Contenido.setBackground(new java.awt.Color(255, 255, 255));
        Contenido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Contenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreTienda.setFont(new java.awt.Font("Segoe UI Black", 2, 36)); // NOI18N
        nombreTienda.setText("Amber Express");
        nombreTienda.setToolTipText("");
        Contenido.add(nombreTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 340, 50));

        tblFactura.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Número", "Contenido", "Peso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFactura.setEnabled(false);
        jScrollPane1.setViewportView(tblFactura);

        Contenido.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 279, 530, 250));

        jLabel2.setText("N°");
        Contenido.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLCodigoFactura.setText("xxxxxxxxxx");
        Contenido.add(jLCodigoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 6, 141, -1));

        direccionT.setText("Destino:");
        Contenido.add(direccionT, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        proforma.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        proforma.setText("Destinatario:");
        Contenido.add(proforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        nombreC.setText("Nombre:");
        Contenido.add(nombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        jLFechaFacturaEmitida.setText("-");
        Contenido.add(jLFechaFacturaEmitida, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 107, -1));

        jLabel8.setText("Dirección:");
        Contenido.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 60, -1));

        jLabel9.setText("Teléfono movil:");
        Contenido.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel44.setText("Precio paquete:");
        Contenido.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 550, 110, 30));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel46.setText("IVA (15%)");
        Contenido.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 610, -1, -1));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel49.setText("Total");
        Contenido.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 637, -1, -1));

        jLabel1.setText("Código Tracking:");
        Contenido.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jLCodigoTracking.setText("-");
        Contenido.add(jLCodigoTracking, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 97, 20));

        jLabel3.setText("Apellidos:");
        Contenido.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLDireccionDestino.setText("-");
        Contenido.add(jLDireccionDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 125, -1));

        jLabel10.setText("CI:");
        Contenido.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLCedulaRemitente.setText("-");
        Contenido.add(jLCedulaRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 125, -1));

        jLabel12.setText("Fecha:");
        Contenido.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 43, -1));

        imprimirF.setText("Imprimir");
        imprimirF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirFActionPerformed(evt);
            }
        });
        Contenido.add(imprimirF, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 680, -1, -1));

        jLPrecioPaquete.setText("0.00");
        Contenido.add(jLPrecioPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 560, 70, -1));

        jLPrecioImpuestos.setText("0.00");
        Contenido.add(jLPrecioImpuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 614, 70, -1));

        jLPrecioTotal.setText("0.00");
        Contenido.add(jLPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 641, 70, -1));

        proforma1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        proforma1.setText("Remitente:");
        Contenido.add(proforma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLTelefonoRemitente.setText("-");
        Contenido.add(jLTelefonoRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 125, -1));

        jLDireccionRemitente.setText("-");
        Contenido.add(jLDireccionRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 125, -1));

        jLapellidosRemitente.setText("-");
        Contenido.add(jLapellidosRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 125, -1));

        nombreC1.setText("Nombres:");
        Contenido.add(nombreC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        direccionT1.setText("Dirección:");
        Contenido.add(direccionT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel45.setText("Precio distancia:");
        Contenido.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 583, 110, -1));

        jLPrecioDistancia.setText("0.00");
        Contenido.add(jLPrecioDistancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 590, 70, -1));

        jLNombresRemitente.setText("-");
        Contenido.add(jLNombresRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 125, -1));

        jLNombreDestinatario.setText("-");
        Contenido.add(jLNombreDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 125, -1));

        jLDestinoProvincia.setText("-");
        Contenido.add(jLDestinoProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 125, -1));

        getContentPane().add(Contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 718));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imprimirFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirFActionPerformed
        imprimirF.setVisible(false); // Ocultar el botón antes de la impresión

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);

        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException e) {
                e.printStackTrace();
                // Manejo de errores
            }
        }
        imprimirF.setVisible(true);

    }//GEN-LAST:event_imprimirFActionPerformed
    private byte[] readPDFBytes(String filePath) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(filePath); ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return outputStream.toByteArray();
        }
    }

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
            java.util.logging.Logger.getLogger(JFFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenido;
    private javax.swing.JLabel direccionT;
    private javax.swing.JLabel direccionT1;
    private javax.swing.JButton imprimirF;
    private javax.swing.JLabel jLCedulaRemitente;
    private javax.swing.JLabel jLCodigoFactura;
    private javax.swing.JLabel jLCodigoTracking;
    private javax.swing.JLabel jLDestinoProvincia;
    private javax.swing.JLabel jLDireccionDestino;
    private javax.swing.JLabel jLDireccionRemitente;
    private javax.swing.JLabel jLFechaFacturaEmitida;
    private javax.swing.JLabel jLNombreDestinatario;
    private javax.swing.JLabel jLNombresRemitente;
    private javax.swing.JLabel jLPrecioDistancia;
    private javax.swing.JLabel jLPrecioImpuestos;
    private javax.swing.JLabel jLPrecioPaquete;
    private javax.swing.JLabel jLPrecioTotal;
    private javax.swing.JLabel jLTelefonoRemitente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLapellidosRemitente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreC;
    private javax.swing.JLabel nombreC1;
    private javax.swing.JLabel nombreTienda;
    private javax.swing.JLabel proforma;
    private javax.swing.JLabel proforma1;
    private javax.swing.JTable tblFactura;
    // End of variables declaration//GEN-END:variables
}
