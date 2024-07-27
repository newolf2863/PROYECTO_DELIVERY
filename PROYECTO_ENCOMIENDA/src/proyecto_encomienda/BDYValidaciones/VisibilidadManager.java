/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.BDYValidaciones;
import javax.swing.*;

public class VisibilidadManager {

    // Método para ocultar componentes JLabel
    public void desvanecerLabels(JLabel[] labels) {
        for (int i = 0; i < labels.length; i++) {
            JLabel label = labels[i % labels.length];
            label.setVisible(false);
        }
    }
}

