/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

public class PaqueteYaTieneIncidente extends Exception {
    public PaqueteYaTieneIncidente() {
        super("El paquete ya cuenta con un incidente registrado");
    }
}
