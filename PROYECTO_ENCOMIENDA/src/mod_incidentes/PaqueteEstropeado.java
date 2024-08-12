/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

/**
 * Clase que representa un incidente de paquete estropeado.
 * Esta clase extiende la clase abstracta Incidente y proporciona
 * implementaciones específicas para registrar y resolver el incidente.
 *
 * @autor Rodrigo Haro
 */
public class PaqueteEstropeado extends EstadoIncidente {

    /**
     * Registra el incidente de paquete estropeado.
     *
     * @return Una cadena que describe el incidente registrado.
     */
    @Override
    public String registrar() {
        return "El paquete se encuentra en malas condiciones";
    }

    /**
     * Resuelve el incidente de paquete estropeado.
     *
     * @param argumentos Argumentos necesarios para resolver el incidente.
     *                   El primer argumento debe ser una cadena que indica si la resolución
     *                   es "Remunerado" o "NoRemunerado". El segundo argumento es la compensación
     *                   en dólares si la resolución es "Remunerado".
     * @return Una cadena que describe la resolución del incidente.
     */
    @Override
    public String resolver(String[] argumentos) {
        if (argumentos[0].equals("Remunerado")) {
            return "Por los daños presentados en su paquete se le entregará una compensación de " + argumentos[1] + " dólares";
        } else if (argumentos[0].equals("NoRemunerado")) {
            return "No se pueden cubrir los daños que su paquete ha presentado. La empresa se deslinda de toda responsabilidad";
        }
        return "";    
    }

    @Override
    public String resolver() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
