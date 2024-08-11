/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validaciones;

/**
 * Clase para gestionar la sesión de usuario utilizando el patrón Singleton.
 * Esta clase asegura que solo exista una instancia de SessionManager en toda la aplicación.
 * Proporciona métodos para verificar y cambiar el estado de la sesión.
 *
 * @author USUARIO
 */
public class SessionManager {
    // Instancia única de SessionManager
    private static SessionManager instance;

    // Variable para determinar si la sesión debe ser cambiada
    private boolean cambiarSesion = true;

    // Constructor privado para prevenir la instanciación directa
    private SessionManager() { }

    /**
     * Obtiene la instancia única de SessionManager.
     * Si la instancia no existe, se crea una nueva.
     * El método está sincronizado para garantizar la seguridad en entornos multihilo.
     *
     * @return La instancia única de SessionManager.
     */
    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    /**
     * Verifica si la sesión debe ser cambiada.
     *
     * @return true si la sesión debe ser cambiada, false de lo contrario.
     */
    public boolean isCambiarSesion() {
        return cambiarSesion;
    }

    /**
     * Establece el estado para cambiar la sesión.
     *
     * @param cambiarSesion true para permitir el cambio de sesión, false para bloquearlo.
     */
    public void setCambiarSesion(boolean cambiarSesion) {
        this.cambiarSesion = cambiarSesion;
    }
}

