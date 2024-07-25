
package proyecto_encomienda.BDYValidaciones;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class VentanaManager {
    private static VentanaManager instance;
    private Map<String, JFrame> ventanas;

    // Constructor privado para singleton
    private VentanaManager() {
        ventanas = new HashMap<>();
    }

    // Obtener instancia singleton
    public static VentanaManager getInstance() {
        if (instance == null) {
            instance = new VentanaManager();
        }
        return instance;
    }

    // Mostrar ventana
    public void mostrarVentana(String clave, JFrame ventana) {
        if (ventanas.containsKey(clave)) {
            JFrame ventanaExistente = ventanas.get(clave);
            if (ventanaExistente.isVisible()) {
                ventanaExistente.toFront();
                return;
            }
        }
        ventanas.put(clave, ventana);
        ventana.setVisible(true);
    }
}

