package validaciones;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * La clase ValidadorDeSwings proporciona métodos para validar y gestionar
 * el estado de los campos de texto en una interfaz gráfica de usuario (GUI).
 *
 * @author USUARIO
 */
public class ValidadorDeSwings {

    /**
     * Valida una lista de campos de texto en función de un array de valores booleanos
     * y actualiza el color y visibilidad de las etiquetas según la validez de cada campo.
     *
     * @param campos Un array de campos de texto a validar.
     * @param valores Un array de valores booleanos que representan la validez de cada campo.
     * @param labels Un array de etiquetas asociadas a los campos de texto.
     * @param nombresCampos Un array de nombres de los campos para incluir en los mensajes de error.
     * @return Una lista de mensajes de error para los campos inválidos.
     */
    public List<String> validarCamposLista(JTextField[] campos, Boolean[] valores, String[] nombresCampos) {
        List<String> errores = new ArrayList<>();

        for (int i = 0; i < campos.length; i++) {
            JTextField campo = campos[i];
            Boolean valor = valores[i]; // Cambié `boolean` a `Boolean` para permitir valores nulos
            String nombreCampo = nombresCampos[i];

            if (!valor) { // Valida con el estado booleano pasado
                errores.add("Error en el campo " + nombreCampo + ": El campo es inválido");
                campo.setBackground(new Color(255, 204, 204));
            } else {
                campo.setBackground(Color.WHITE);
            }
        }

        return errores;
    }

    /**
     * Valida que los campos de texto no estén vacíos y actualiza el color y visibilidad de las etiquetas.
     *
     * @param campos Un array de campos de texto a validar.
     * @param valores Un array de valores booleanos que representan la validez de cada campo.
     * @param nombresCampos Un array de nombres de los campos para incluir en los mensajes de error.
     * @return Una lista de mensajes de error para los campos vacíos.
     */
    public List<String> validarCamposVaciosLista(JTextField[] campos, Boolean[] valores, String[] nombresCampos) {
        List<String> errores = new ArrayList<>();
        for (int i = 0; i < campos.length; i++) {
            JTextField campo = campos[i];
            boolean valor = valores[i];
            if (campo.getText().isEmpty()) {
                campo.setBackground(new Color(255, 204, 204));
                String mensajeError = "Error en el campo " + nombresCampos[i] + ": El campo está vacío";
                errores.add(mensajeError);
            } else {
                if (valor) {
                    campo.setBackground(Color.WHITE);
                }
            }
        }
        return errores;
    }

    /**
     * Valida una lista de campos de texto en función de un array de valores booleanos
     * y actualiza el color y visibilidad de las etiquetas. Retorna true si todos los campos son válidos.
     *
     * @param campos Un array de campos de texto a validar.
     * @param valores Un array de valores booleanos que representan la validez de cada campo.
     * @param labels Un array de etiquetas asociadas a los campos de texto.
     * @return true si todos los campos son válidos; false si al menos uno es inválido.
     */
    public boolean validarCampos(JTextField[] campos, Boolean[] valores, JLabel[] labels) {
        boolean camposValidos = true; // Inicialmente asumimos que todos los campos son válidos
        for (int i = 0; i < campos.length; i++) {
            JTextField campo = campos[i];
            JLabel label = labels[i];
            boolean valor = valores[i];
            if (!valor) {
                camposValidos = false;
                label.setVisible(true);
                campo.setBackground(new Color(255, 204, 204));
            } else {
                label.setVisible(false);
                campo.setBackground(Color.WHITE);
            }
        }
        return camposValidos; // Retorna true si todos los campos son válidos, false si al menos uno está vacío
    }

    /**
     * Valida que los campos de texto no estén vacíos y actualiza el color y visibilidad de las etiquetas.
     *
     * @param campos Un array de campos de texto a validar.
     * @param valores Un array de valores booleanos que representan la validez de cada campo.
     * @param labels Un array de etiquetas asociadas a los campos de texto.
     * @return true si todos los campos tienen contenido; false si al menos uno está vacío.
     */
    public boolean validarCamposVacios(JTextField[] campos, Boolean[] valores, JLabel[] labels) {
        boolean camposValidos = true;
        for (int i = 0; i < campos.length; i++) {
            JTextField campo = campos[i];
            JLabel label = labels[i];
            boolean valor = valores[i];
            if (campo.getText().isEmpty()) {
                campo.setBackground(new Color(255, 204, 204));
                camposValidos = false;
                label.setVisible(true);
            } else {
                if (valor) {
                    label.setVisible(false);
                    campo.setBackground(Color.WHITE);
                }
            }
        }
        return camposValidos;
    }

    /**
     * Actualiza el estado del campo de texto en función del estado del JCheckBox.
     *
     * @param checkBox El JCheckBox que controla la habilitación del campo de texto.
     * @param textField El campo de texto a habilitar o deshabilitar.
     * @param flag Un valor booleano que indica si el campo debe ser habilitado o deshabilitado.
     * @param errorLabel La etiqueta que muestra el mensaje de error.
     */
    public void actualizarCampo(JCheckBox checkBox, JTextField textField, boolean flag, JLabel errorLabel) {
        if (checkBox.isSelected()) {
            textField.setEnabled(true);
            flag = false;
        } else {
            textField.setEnabled(false);
            flag = true;
            textField.setText("");
            textField.setBackground(Color.white);
            errorLabel.setVisible(false);
        }
    }

    /**
     * Cambia todos los valores del array a true.
     *
     * @param valores Un array de valores booleanos a modificar.
     * @return El array modificado con todos los valores en true.
     */
    public Boolean[] cambiarValoresVerdadFinal(Boolean[] valores) {
        for (int i = 0; i < valores.length; i++) {
            valores[i] = true;
        }
        return valores;
    }

    /**
     * Verifica que el campo de texto no esté vacío.
     *
     * @param campo El campo de texto a verificar.
     * @param nombreCampo El nombre del campo para incluir en mensajes de error.
     * @return true si el campo no está vacío; false si está vacío.
     */
    public boolean validarCampoNoVacio(JTextField campo, String nombreCampo) {
        if (campo.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Establece el color de fondo del campo de texto y muestra la etiqueta de error.
     *
     * @param campo El campo de texto a actualizar.
     * @param color El color de fondo a establecer.
     * @param labels La etiqueta de error asociada al campo.
     */
    public void setColorFondoCampo(JTextField campo, Color color, JLabel labels) {
        campo.setBackground(color);
        labels.setVisible(true);
    }

    /**
     * Actualiza el contenido del campo de texto en función del estado del JCheckBox.
     *
     * @param checkBox El JCheckBox que controla el valor del campo de texto.
     * @param valor El valor a establecer en el campo de texto si el JCheckBox está seleccionado.
     * @param textField El campo de texto a actualizar.
     * @param errorLabel La etiqueta que muestra el mensaje de error.
     */
    public void actualizarCampoSeleccionado(JCheckBox checkBox, String valor, JTextField textField, JLabel errorLabel) {
        if (checkBox.isSelected()) {
            textField.setText(valor);
            textField.setBackground(Color.white);
            errorLabel.setVisible(false);
        } else {
            textField.setText("");
        }
    }

    /**
     * Limpia el contenido de todos los campos de texto en el array.
     *
     * @param campos Un array de campos de texto a limpiar.
     */
    public void limpiarCampos(JTextField[] campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }
}
