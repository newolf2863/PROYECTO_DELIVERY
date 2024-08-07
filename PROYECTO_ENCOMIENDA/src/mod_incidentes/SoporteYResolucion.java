/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

import mod_paquetes.Paquete;
import mod_paquetes.Seguimiento;

/**
 *
 * @author Issac
 */
public class SoporteYResolucion {
    private GestorIncidente gestorIncidente;

    public SoporteYResolucion(GestorIncidente gestor) {
        this.gestorIncidente = gestor;
    }

    public void gestionarConsulta(Paquete paquete) {
        // Lógica para gestionar la consulta
        gestorIncidente.crearIncidente(paquete);
    }


//    /**
//     * Método para resolver un incidente asociado a un paquete.
//     * Resuelve el incidente con los argumentos proporcionados y actualiza el seguimiento del paquete.
//     * 
//     * @param paquete El paquete cuyo incidente será resuelto.
//     * @param argumentos Argumentos necesarios para resolver el incidente.
//     */
    public void resolverIncidente(Paquete paquete, String ... argumentos) {
        gestorIncidente.iniciarSoporte(paquete, argumentos);
    }

}
