/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

import mod_paquetes.Inventario;
import mod_paquetes.Paquete;

/**
 *
 * @author Issac
 */
public class SolucionDireccion extends SoporteYResolucion{
    public void resolverIncidente(String codigoTracking, String nuevaDireccion) {
        Inventario inventario = Inventario.obtenerInstancia();
        Paquete paquete = inventario.obtenerPaquete(codigoTracking);

        if (paquete == null) {
            System.out.println("Paquete no encontrado para el código de tracking: " + codigoTracking);
            return;
        }

        // Cambiar la dirección de destino
        paquete.setDireccionDestino(nuevaDireccion);

        // Marcar el incidente como resuelto o tomar alguna acción adicional si es necesario
        EstadoIncidente incidente = new ErrorDireccion(); // Asumiendo que se está corrigiendo un error de dirección
        super.resolverIncidente(paquete, incidente);

        // Guardar los cambios en el inventario
        inventario.guardarInventario();

        // Informar al usuario del cambio exitoso
        System.out.println("Dirección de entrega actualizada exitosamente para el código de tracking: " + codigoTracking);
        System.out.println("Nueva dirección de destino: " + nuevaDireccion);
    }
}
