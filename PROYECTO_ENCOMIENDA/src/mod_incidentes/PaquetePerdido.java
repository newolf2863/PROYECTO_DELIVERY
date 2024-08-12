/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change esta licencia
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar esta plantilla
 */
package mod_incidentes;

/**
 * Clase que representa un incidente de paquete perdido.
 * Esta clase extiende la clase abstracta Incidente y proporciona
 * implementaciones específicas para registrar y resolver el incidente.
 *
 * @autor Rodrigo Haro
 */
public class PaquetePerdido extends EstadoIncidente {

    /**
     * Registra el incidente de paquete perdido.
     *
     * @return Una cadena que describe el incidente registrado.
     */
    @Override
    public String registrar() {
        return "La ubicación de su paquete es desconocida";
    }

    /**
     * Resuelve el incidente de paquete perdido.
     *
     * @param argumentos Argumentos necesarios para resolver el incidente.
     *                   El primer argumento debe ser una cadena que indica si la resolución
     *                   es "Recuperado" o "Desconocido".
     * @return Una cadena que describe la resolución del incidente.
     */
    @Override
    public String resolver(String[] argumentos) {
        if (argumentos[0].equals("Recuperado")) {
            return "Se ha recuperado su paquete y pronto se le será entregado";
        } else if (argumentos[0].equals("Desconocido")) {
            return "Su paquete no se ha podido encontrar, por favor, acérquese a la agencia más cercana para recibir una compensación";
        }
        return "";
    }
}
