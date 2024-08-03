/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

/**
 *
 * @author Rodrigo Haro
 */
public class ErrorDireccion extends Incidente {

    @Override
    public String registrar() {
        return "No se ha podido entregar el paquete en la dirección proporcionada";
    }

    @Override
    public String resolver(String[] argumentos) {
        return "Se ha entregado el paquete en una nueva dirección: " + argumentos[0];
    }
}
