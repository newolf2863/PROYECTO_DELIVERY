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
 * La clase ValidadorDeRegistros proporciona métodos para validar distintos
 * tipos de datos y formatos en campos de texto, así como para gestionar
 * el contenido del portapapeles.
 *
 * @author USUARIO
 */
public class ValidadorDeRegistros {

    /**
     * Valida si la placa de un vehículo cumple con el formato especificado.
     * El formato debe ser de 3 letras seguidas de 3 dígitos.
     *
     * @param placa La placa del vehículo a validar.
     * @return true si la placa es válida; false en caso contrario.
     */
    public static boolean validarPlaca(String placa) {
        String patron = "^[A-Z]{3}\\d{3}$";
        return placa.matches(patron);
    }

    /**
     * Valida el contenido del campo de texto basado en el caso especificado
     * y actualiza el estado del campo y la etiqueta de acuerdo con la validez.
     *
     * @param textField El campo de texto a validar.
     * @param label La etiqueta que mostrará mensajes de error.
     * @param caso El caso que define el tipo de validación a realizar.
     * @return true si el campo es válido; false en caso contrario.
     */
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

    /**
     * Valida el contenido del campo de texto para campos específicos de clientes
     * y actualiza el estado del campo y la etiqueta de acuerdo con la validez.
     *
     * @param textField El campo de texto a validar.
     * @param label La etiqueta que mostrará mensajes de error.
     * @param caso El caso que define el tipo de validación a realizar.
     * @return true si el campo es válido; false en caso contrario.
     */
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

    /**
     * Valida que el valor tiene como máximo dos decimales.
     *
     * @param valor El valor a validar.
     * @return true si el valor tiene como máximo dos decimales; false en caso contrario.
     */
    public boolean validarMaximoDosDecimales(String valor) {
        try {
            double numero = Double.parseDouble(valor);
            int decimales = String.valueOf(numero).split("\\.")[1].length();
            return decimales <= 2;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    /**
     * Obtiene el contenido actual del portapapeles.
     *
     * @return El contenido del portapapeles como una cadena.
     */
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

    /**
     * Verifica si la cadena de texto es numérica.
     *
     * @param str La cadena de texto a verificar.
     * @return true si la cadena es numérica; false en caso contrario.
     */
    public boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    /**
     * Valida el formato del número de teléfono.
     * El formato debe ser: +593-XXXXXXXXX (donde X es un dígito).
     *
     * @param telefono El número de teléfono a validar.
     * @return true si el número de teléfono es válido; false en caso contrario.
     */
    public static boolean validarTelefono(String telefono) {
        String regexNacional = "^\\+593-\\d{9}$"; // Formato: +593-XXXXXXXXX
        boolean telefonoValido = telefono.matches(regexNacional);
        return telefonoValido;
    }

    /**
     * Valida el formato de la dirección.
     * La dirección puede contener letras, números y algunos caracteres especiales.
     *
     * @param dirNegocio La dirección a validar.
     * @return true si la dirección es válida; false en caso contrario.
     */
    public static boolean validarDireccion(String dirNegocio) {
        return dirNegocio.matches("^[A-Za-záéíóúÁÉÍÓÚñÑüÜ0-9]+([,.]?[ ]?[A-Za-záéíóúÁÉÍÓÚñÑüÜ0-9]+)*$");
    }

    /**
     * Valida el formato del correo electrónico. Solo permite correos de ciertos dominios.
     *
     * @param email El correo electrónico a validar.
     * @return true si el correo electrónico es válido; false en caso contrario.
     */
    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(gmail\\.com|outlook\\.com|yahoo\\.com|hotmail\\.com|epn\\.edu\\.ec)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Valida la cédula de identidad en formato ecuatoriano.
     * La cédula debe tener 10 dígitos y el dígito verificador se calcula con una fórmula específica.
     *
     * @param cedula La cédula a validar.
     * @return true si la cédula es válida; false en caso contrario.
     */
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

    /**
     * Valida que la cadena de texto representa nombres válidos.
     * Los nombres pueden contener letras y espacios.
     *
     * @param nombres La cadena de texto a validar.
     * @return true si la cadena es válida; false en caso contrario.
     */
    public static boolean validarNombres(String nombres) {
        return nombres.matches("^[A-Za-záéíóúÁÉÍÓÚñÑüÜ]+( [A-Za-záéíóúÁÉÍÓÚñÑüÜ]+)*$");
    }

    /**
     * Método de validación para RUC, aún no implementado.
     *
     * @param texto El texto a validar.
     * @return false en todos los casos hasta que se implemente la validación.
     */
    private boolean validarRUC(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
