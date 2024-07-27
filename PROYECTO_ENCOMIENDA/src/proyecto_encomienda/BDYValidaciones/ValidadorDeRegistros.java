/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.BDYValidaciones;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static proyecto_encomienda.BDYValidaciones.ValidarTelefono.validarTelefonoClienteFactura;

/**
 *
 * @author USUARIO
 */
public class ValidadorDeRegistros {

    ValidarTelefono telefonoV = new ValidarTelefono();
    ValidadorCedulas validarDocumentos = new ValidadorCedulas();
    ValidadorDeDirecciones validarDireccion = new ValidadorDeDirecciones();

    public boolean camposDeRegistros(JTextField textField, JLabel label, String caso) {
        boolean valor = false;
        String texto = textField.getText();
        label.setVisible(true);

        switch (caso) {
            case "d" ->
                valor = validarDireccion.validarDireccion(texto);
            case "b" ->
                valor = validarDocumentos.validarRUC(texto);
            case "n" ->
                valor = texto.matches("^[A-Za-záéíóúÁÉÍÓÚñÑüÜ]+( [A-Za-záéíóúÁÉÍÓÚñÑüÜ]+)*$");
            case "c" ->
                valor = EmailValidator.isValidEmail(texto);
            case "t" ->
                valor = telefonoV.validarTelefonoNegocio(texto);
            case "telefono" ->
                valor = texto.matches("^\\d{10}$");
            case "cedula" ->
                valor = ValidadorCedulas.validarCedula(texto);
            case "precio" ->
                valor = validarMaximoDosDecimales(texto);
            case "v" ->
                valor = !texto.isEmpty();
            case "i" ->
                valor = texto.matches("^\\d+$");
        }
        if (valor) {
            textField.setBackground(new Color(255, 255, 255));
            label.setVisible(false);
        } else {
            textField.setBackground(new Color(255, 204, 204));
        }

        return valor;
    }

    public boolean camposCliente(JTextField textField, JLabel label,
            String tipoCliente, String natularJuridico, String caso) {
        boolean valor = false;
        switch (caso) {
            case "a" -> {
                String text = textField.getText();
                if (natularJuridico.equals("Jurídico")) {
                    valor = ValidadorCedulas.validarRUC(text);
                    if (!valor) {
                        label.setVisible(true);
                        valor = false;
                        label.setText("*RUC erroneo");
                        textField.setBackground((new Color(255, 204, 204)));
                    } else {
                        textField.setBackground(Color.WHITE);
                        label.setVisible(false);
                        valor = true;
                    }
                } else {
                    if (tipoCliente.equals("*Extranjero")) {
                        if (text.length() >= 8) {
                            valor = true;
                            textField.setBackground(Color.WHITE);
                        } else {
                            label.setVisible(true);
                            label.setText("*Pasaporte inválido");
                            textField.setBackground((new Color(255, 204, 204)));
                            valor = false;
                        }

                    } else {
                        boolean cedulaValida = ValidadorCedulas.validarCedula(text);
                        if (!cedulaValida) {
                            textField.setBackground((new Color(255, 204, 204)));
                            label.setVisible(true);
                            label.setText("*CI invalida");
                            valor = false;
                        } else {
                            textField.setBackground(Color.WHITE);
                            label.setVisible(false);
                            valor = true;
                        }
                    }
                }
            }
            case "b" -> {
                String telefono = textField.getText();

                valor = validarTelefonoClienteFactura(telefono, tipoCliente);
                if (tipoCliente.equals("Extranjero")) {
                    if (!valor) {
                        label.setVisible(true);
                        label.setText("*Formato: 1+123456789");
                        textField.setBackground(new Color(255, 204, 204));
                    } else {
                        label.setVisible(false);
                        textField.setBackground(new Color(255, 255, 255));
                    }
                } else {

                    if (tipoCliente.equals("Nacional")) {
                        if (!valor) {
                            label.setVisible(true);
                            label.setText("*Formato: 593+123456789");
                            textField.setBackground(new Color(255, 204, 204));
                        } else {
                            label.setVisible(false);
                            textField.setBackground(new Color(255, 255, 255));
                        }
                    }
                }

            }
        }
        return valor;
    }

    public boolean validarMaximoDosDecimales(String valor) {
        try {
            double numero = Double.parseDouble(valor);
            int decimales = String.valueOf(numero).split("\\.")[1].length();
            return decimales <= 2;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    public String getClipboardContent() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = clipboard.getContents(null);
        try {
            if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return (String) transferable.getTransferData(DataFlavor.stringFlavor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
