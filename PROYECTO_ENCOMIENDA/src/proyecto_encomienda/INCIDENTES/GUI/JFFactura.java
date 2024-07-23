/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_encomienda.INCIDENTES.GUI;

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
    private String correCliente;

    public JFFactura(double subtotal, double total,
            String rucNegocio, String nombreNegocio,
            String direccionNegocio, String telefonoNegocio, String idCliente,
            String nombresCliente, String apellidosCliente, String telefonoCliente,
            String direccionCliente, String fechaEmision, String estadoPago,
            double porcentajeIVA, int idFactura, Connection cnx, String correo
    ,String documento) {
        initComponents(); // Inicializar componentes de la GUI
        this.cnx = cnx;
        this.setLocationRelativeTo(null);
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        jTextSubTotal.setText(decimalFormat.format(subtotal) + " $");
        Total.setText(decimalFormat.format(total) + " $");
        rucN.setText(rucNegocio);
        nombreTienda.setText(nombreNegocio);
        direccionT.setText(direccionNegocio);
        telefonoNegocioN.setText(telefonoNegocio);
        idClienteText.setText(idCliente);
        nombreC.setText(nombresCliente);
        jLabel3.setText(apellidosCliente);
        jLabel5.setText(telefonoCliente);
        jLabel8.setText(direccionCliente);
        jLabel7.setText(fechaEmision);
        jLabel10.setText(documento);
        //jLabel11.setText(estadoPago);
        iva.setText(String.valueOf(porcentajeIVA));
        numeroFactura.setText(String.valueOf(idFactura));
        correCliente = correo;
        EnviarCorreo.setVisible(false);
        guardarFactura.setVisible(true);
    }

    public JFFactura(double subtotal, double total,
            String rucNegocio, String nombreNegocio,
            String direccionNegocio, String telefonoNegocio, String idCliente,
            String nombresCliente, String apellidosCliente, String telefonoCliente,
            String direccionCliente, String fechaEmision,
            double porcentajeIVA, int idFactura) {
        initComponents(); // Inicializar componentes de la GUI
        this.setLocationRelativeTo(null);
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        jTextSubTotal.setText(decimalFormat.format(subtotal) + " $");
        Total.setText(decimalFormat.format(total) + " $");
        rucN.setText(rucNegocio);
        nombreTienda.setText(nombreNegocio);
        direccionT.setText(direccionNegocio);
        telefonoNegocioN.setText(telefonoNegocio);
        idClienteText.setText(idCliente);
        nombreC.setText(nombresCliente);
        jLabel3.setText(apellidosCliente);
        jLabel5.setText(telefonoCliente);
        jLabel8.setText(direccionCliente);
        jLabel7.setText(fechaEmision);
        //jLabel11.setText(estadoPago);
        iva.setText(String.valueOf(porcentajeIVA));
        numeroFactura.setText(String.valueOf(idFactura));
        proforma.setText("Proforma de: ");
        guardarFactura.setVisible(false);
        EnviarCorreo.setVisible(false);
    }

    private JFFactura() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        numeroFactura = new javax.swing.JLabel();
        direccionT = new javax.swing.JLabel();
        proforma = new javax.swing.JLabel();
        nombreC = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        ruc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rucN = new javax.swing.JLabel();
        telefonoNegocioN = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        idClienteText = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        imprimirF = new javax.swing.JButton();
        jTextSubTotal = new javax.swing.JLabel();
        iva = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        EnviarCorreo = new javax.swing.JButton();
        guardarFactura = new javax.swing.JButton();

        Contenido.setBackground(new java.awt.Color(255, 255, 255));
        Contenido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Contenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreTienda.setFont(new java.awt.Font("Segoe UI Black", 2, 48)); // NOI18N
        nombreTienda.setText("Tienda");
        nombreTienda.setToolTipText("");
        Contenido.add(nombreTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 28, 268, 42));

        tblFactura.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFactura.setEnabled(false);
        jScrollPane1.setViewportView(tblFactura);

        Contenido.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 279, 540, 298));

        jLabel2.setText("N°");
        Contenido.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        numeroFactura.setText("xxxxxxxxxx");
        Contenido.add(numeroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 6, 141, -1));

        direccionT.setText("Dirección");
        Contenido.add(direccionT, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 73, -1, -1));

        proforma.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        proforma.setText("Facturar A");
        Contenido.add(proforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 107, -1, -1));

        nombreC.setText("Nombre");
        Contenido.add(nombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 138, -1, -1));

        jLabel7.setText("Fecha");
        Contenido.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 25, 107, -1));

        jLabel8.setText("Dirección");
        Contenido.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 181, 216, -1));

        jLabel9.setText("Telefono movil");
        Contenido.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 209, -1, -1));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel44.setText("Subtotal");
        Contenido.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 583, 71, -1));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel46.setText("IVA (%)");
        Contenido.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 610, -1, -1));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel49.setText("Total");
        Contenido.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 637, -1, -1));

        ruc.setText("Ruc");
        Contenido.add(ruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 6, 43, -1));

        jLabel1.setText("Telefono");
        Contenido.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 47, -1, -1));

        rucN.setText("XXXXXX");
        Contenido.add(rucN, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 6, 107, -1));

        telefonoNegocioN.setText("02-xxxxxxx");
        Contenido.add(telefonoNegocioN, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 47, 97, -1));

        jLabel3.setText("Apellido");
        Contenido.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 159, -1, -1));

        jLabel5.setText("+593 XXXXXXXXXXX");
        Contenido.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 209, 125, -1));

        jLabel10.setText("CI o Pasaporte");
        Contenido.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 237, -1, -1));

        idClienteText.setText("N°99999999999999");
        Contenido.add(idClienteText, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 237, 125, -1));

        jLabel12.setText("Fecha");
        Contenido.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 25, 43, -1));

        imprimirF.setText("Imprimir");
        imprimirF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirFActionPerformed(evt);
            }
        });
        Contenido.add(imprimirF, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 680, -1, -1));

        jTextSubTotal.setText("0.00");
        Contenido.add(jTextSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 587, -1, -1));

        iva.setText("iva");
        Contenido.add(iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 614, 51, -1));

        Total.setText("0.00");
        Contenido.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 641, -1, -1));

        EnviarCorreo.setText("Enviar al correo");
        EnviarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarCorreoActionPerformed(evt);
            }
        });
        Contenido.add(EnviarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, -1, -1));

        guardarFactura.setText("Guardar factura");
        guardarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarFacturaActionPerformed(evt);
            }
        });
        Contenido.add(guardarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 680, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imprimirFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirFActionPerformed
        imprimirF.setVisible(false); // Ocultar el botón antes de la impresión
        EnviarCorreo.setVisible(false);
        guardarFactura.setVisible(false);
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
        guardarFactura.setVisible(true);
    }//GEN-LAST:event_imprimirFActionPerformed

    private void EnviarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarCorreoActionPerformed
        // Datos de autenticación para tu cuenta de correo
        String numeroFacturaTexto = numeroFactura.getText();
        int numeroFactura1 = Integer.parseInt(numeroFacturaTexto);
        final String username = "Pon tu correo de gmail aqui"; // Cambia esto
        final String password = "pon la clave de producto del gmail aqui"; // Cambia esto
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Cambia esto si no usas Gmail
        props.put("mail.smtp.port", "587"); // Cambia esto si es necesario
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correCliente)); // Usar el correo del cliente
            message.setSubject("Factura");

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Adjunto encontrarás tu factura.");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Read the PDF file into a byte array
            String tempFolderPath = "C:\\Users\\USUARIO\\OneDrive - Escuela Politécnica Nacional\\Documentos\\NetBeansProjects\\SistemaPintura\\src\\CarpetaTemporal";
            String filePath = tempFolderPath + "\\factura_" + numeroFactura1 + ".pdf";
            byte[] pdfBytes = readPDFBytes(filePath);

            // Attach the PDF bytes as an attachment
            MimeBodyPart attachPart = new MimeBodyPart();
            attachPart.setContent(pdfBytes, "application/pdf");
            attachPart.setFileName("factura_" + numeroFactura1 + ".pdf");
            multipart.addBodyPart(attachPart);

            message.setContent(multipart);

            Transport.send(message);

            JOptionPane.showMessageDialog(null,"Correo enviado exitosamente.");

        } catch (MessagingException e) {
            e.printStackTrace();
            // Manejo de errores
        } catch (IOException ex) {
            Logger.getLogger(JFFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_EnviarCorreoActionPerformed

    private void guardarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarFacturaActionPerformed
        imprimirF.setVisible(false);
        EnviarCorreo.setVisible(false);
        guardarFactura.setVisible(false);
        String tempFolderPath = "C:\\Users\\USUARIO\\OneDrive - Escuela Politécnica Nacional\\Documentos\\NetBeansProjects\\SistemaPintura\\src\\CarpetaTemporal";
        JPanel contenidoPanel = Contenido; // Sustituye "tuPanelContenido" por tu panel real
        String numeroFacturaTexto = numeroFactura.getText(); // Obtiene el número de factura como texto
        int numeroFactura1 = Integer.parseInt(numeroFacturaTexto);
        // Crear una carpeta temporal única para cada factura
        String tempFilePath = tempFolderPath + "\\" + "factura_" + numeroFactura1 + ".pdf";
        generarPDF(contenidoPanel, tempFilePath);
        byte[] pdfBytes = convertirPDFaBytes(tempFilePath);
        guardarPDFenBD(numeroFactura1, pdfBytes);
        EnviarCorreo.setVisible(true);
        imprimirF.setVisible(true);
    }//GEN-LAST:event_guardarFacturaActionPerformed
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenido;
    private javax.swing.JButton EnviarCorreo;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel direccionT;
    private javax.swing.JButton guardarFactura;
    private javax.swing.JLabel idClienteText;
    private javax.swing.JButton imprimirF;
    private javax.swing.JLabel iva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTextSubTotal;
    private javax.swing.JLabel nombreC;
    private javax.swing.JLabel nombreTienda;
    private javax.swing.JLabel numeroFactura;
    private javax.swing.JLabel proforma;
    private javax.swing.JLabel ruc;
    private javax.swing.JLabel rucN;
    private javax.swing.JTable tblFactura;
    private javax.swing.JLabel telefonoNegocioN;
    // End of variables declaration//GEN-END:variables
}
