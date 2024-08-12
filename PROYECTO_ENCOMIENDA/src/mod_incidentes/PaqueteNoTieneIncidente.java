/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

/**
 *
 * @author Rodrigo Haro
 */
public class PaqueteNoTieneIncidente extends Exception {
    public PaqueteNoTieneIncidente() {
        super("El paquete no cuenta con un incidente registrado");
    }
}
