/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validaciones;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class ValidadorDeRegistros {

    public static boolean validarPlaca(String placa) {
        String patron = "^[A-Z]{3}\\d{3}$";
        return placa.matches(patron);
    }

    public boolean camposDeRegistros(JTextField textField, JLabel label, String caso) {
        boolean valor = false;
        String texto = textField.getText();
        label.setVisible(true);

        switch (caso) {
            case "d" ->
                valor = validarDireccion(texto);
            case "b" ->
                valor = validarRUC(texto);
            case "n" ->
                valor = texto.matches("^[A-Za-záéíóúÁÉÍÓÚñÑüÜ]+( [A-Za-záéíóúÁÉÍÓÚñÑüÜ]+)*$");
            case "c" ->
                valor = validarEmail(texto);
            case "t" ->
                valor = validarTelefono(texto);
            case "telefono" ->
                valor = texto.matches("^\\d{10}$");
            case "cedula" ->
                valor = validarCedula(texto);
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

    public boolean camposCliente(JTextField textField, JLabel label, String caso) {
        boolean valor = false;
        switch (caso) {
            case "a" -> {
                boolean cedulaValida = validarCedula(textField.getText());
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
            case "b" -> {
                String telefono = textField.getText();
                valor = validarTelefono(telefono);
                if (!valor) {
                    label.setVisible(true);
                    label.setText("*Formato: +593-123456789");
                    textField.setBackground(new Color(255, 204, 204));
                } else {
                    label.setVisible(false);
                    textField.setBackground(new Color(255, 255, 255));
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

    public static boolean validarTelefono(String telefono) {
        String regexNacional = "^\\+593-\\d{9}$"; // Formato: +593-XXXXXXXXX
        boolean telefonoValido = telefono.matches(regexNacional);
        return telefonoValido;
    }
    
    public static boolean validarDireccion(String dirNegocio) {
        return dirNegocio.matches("^[A-Za-záéíóúÁÉÍÓÚñÑüÜ0-9]+([,.]?[ ]?[A-Za-záéíóúÁÉÍÓÚñÑüÜ0-9]+)*$");
    }
    
    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(gmail\\.com|outlook\\.com|yahoo\\.com|hotmail\\.com|epn\\.edu\\.ec)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static boolean validarCedula(String cedula) {
        // Verificar si la cédula tiene 10 dígitos
        if (cedula.length() != 10) {
            return false;
        }

        // Extraer los primeros 9 dígitos de la cédula
        String digitosCedula = cedula.substring(0, 9);

        // Verificar si los primeros 9 dígitos son numéricos
        if (!digitosCedula.matches("[0-9]+")) {
            return false;
        }

        // Convertir los dígitos a un array de enteros
        int[] numeros = new int[9];
        for (int i = 0; i < 9; i++) {
            numeros[i] = Integer.parseInt(digitosCedula.substring(i, i + 1));
        }

        // Calcular el dígito verificador
        int digitoVerificador = Integer.parseInt(cedula.substring(9));
        int suma = 0;
        for (int i = 0; i < 9; i++) {
            int numero = numeros[i];
            if (i % 2 == 0) {
                numero *= 2;
                if (numero > 9) {
                    numero -= 9;
                }
            }
            suma += numero;
        }
        int digitoCalculado = 10 - (suma % 10);
        if (digitoCalculado == 10) {
            digitoCalculado = 0;
        }

        // Comparar el dígito verificador calculado con el proporcionado
        return digitoCalculado == digitoVerificador;
    }
    
    public static boolean validarNombres(String nombres) {
        return nombres.matches("^[A-Za-záéíóúÁÉÍÓÚñÑüÜ]+( [A-Za-záéíóúÁÉÍÓÚñÑüÜ]+)*$");
    }

    private boolean validarRUC(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
