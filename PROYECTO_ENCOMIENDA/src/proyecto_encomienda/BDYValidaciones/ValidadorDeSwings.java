/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.BDYValidaciones;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class ValidadorDeSwings {

public List<String> validarCamposLista(JTextField[] campos, Boolean[] valores, JLabel[] labels, String[] nombresCampos) {
    List<String> errores = new ArrayList<>();

    for (int i = 0; i < campos.length; i++) {
        JTextField campo = campos[i];
        Boolean valor = valores[i]; // Cambié `boolean` a `Boolean` para permitir valores nulos
        JLabel label = labels[i];
        String nombreCampo = nombresCampos[i];

        // Validar campos vacíos
        if (campo.getText().isEmpty()) {
            errores.add("El campo " + nombreCampo + " no puede estar vacío.");
            label.setVisible(true);
            campo.setBackground(new Color(255, 204, 204));
        } else if (!valor) { // Valida con el estado booleano pasado
            errores.add("Error en el campo " + nombreCampo + ": El campo es inválido");
            label.setVisible(true);
            campo.setBackground(new Color(255, 204, 204));
        } else {
            campo.setBackground(Color.WHITE);
            label.setVisible(false);
        }
    }

    return errores;
}



public List<String> validarCamposVaciosLista(JTextField[] campos, Boolean[] valores, JLabel[] labels,String[] nombresCampos) {
    List<String> errores = new ArrayList<>();
    for (int i = 0; i < campos.length; i++) {
        JTextField campo = campos[i];
        JLabel label = labels[i];
        boolean valor = valores[i];
        if (campo.getText().isEmpty()) {
            label.setVisible(true);
            campo.setBackground(new Color(255, 204, 204));
            String mensajeError = "Error en el campo " +nombresCampos[i]+ ": El campo está vacío";
            errores.add(mensajeError);
        } else {
            if (valor) {
                label.setVisible(false);
                campo.setBackground(Color.WHITE);
            }
        }
    }
    return errores;
}

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

    public Boolean[] cambiarValoresVerdadFinal(Boolean[] valores) {
        for (int i = 0; i < valores.length; i++) {
            valores[i] = true;
        }
        return valores;
    }

    public boolean validarCampoNoVacio(JTextField campo, String nombreCampo) {
        if (campo.getText().isEmpty()) {
            return false;
        }
        return true;
    }
    
    public void setColorFondoCampo(JTextField campo, Color color, JLabel labels) {
        campo.setBackground(color);
        labels.setVisible(true);
    }

    public void actualizarCampoSeleccionado(JCheckBox checkBox, String valor, JTextField textField, JLabel errorLabel) {
        if (checkBox.isSelected()) {
            textField.setText(valor);
            textField.setBackground(Color.white);
            errorLabel.setVisible(false);
        } else {
            textField.setText("");
        }
    }

    public void limpiarCampos(JTextField[] campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }
}
