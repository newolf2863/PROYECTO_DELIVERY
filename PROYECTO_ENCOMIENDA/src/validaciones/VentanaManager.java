package validaciones;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * La clase VentanaManager gestiona la visibilidad y el acceso a ventanas en una aplicación.
 * Implementa el patrón de diseño Singleton para asegurar que solo haya una instancia de esta clase.
 */
public class VentanaManager {
    private static VentanaManager instance; // Instancia única de VentanaManager
    private Map<String, JFrame> ventanas; // Mapa para almacenar las ventanas con una clave asociada

    // Constructor privado para implementar el patrón Singleton
    private VentanaManager() {
        ventanas = new HashMap<>();
    }

    /**
     * Obtiene la instancia única de VentanaManager.
     *
     * @return La instancia única de VentanaManager.
     */
    public static VentanaManager getInstance() {
        if (instance == null) {
            instance = new VentanaManager();
        }
        return instance;
    }

    /**
     * Muestra una ventana específica. Si la ventana ya está visible, la trae al frente.
     * Si hay otras ventanas visibles, las oculta.
     *
     * @param clave La clave asociada a la ventana.
     * @param ventana La ventana JFrame a mostrar.
     */
    public void mostrarVentana(String clave, JFrame ventana) {
        // Oculta todas las ventanas visibles actualmente
        for(JFrame ventanaExistente : ventanas.values()){
            if(ventanaExistente.isVisible()){
                ventanaExistente.setVisible(false);
            }
        }

        // Si la ventana ya está almacenada y es visible, la trae al frente
        if (ventanas.containsKey(clave)) {
            JFrame ventanaExistente = ventanas.get(clave);
            if (ventanaExistente.isVisible()) {
                ventanaExistente.toFront();
                return;
            }
        }

        // Almacena la nueva ventana y la muestra
        ventanas.put(clave, ventana);
        ventana.setVisible(true);
    }
}
