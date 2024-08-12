/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

import mod_paquetes.Inventario;
import mod_paquetes.Paquete;
import mod_paquetes.Pendiente;

public class DevolucionPaquete extends Incidente {

    @Override
    public String getMensajeRegistro(Paquete paquete) {
        return "El cliente ha solicitado la devolución del paquete.";
    }

    @Override
    public String getMensajeResolucion(Paquete paquete) {
        return "El paquete será devuelto a la sucursal.";
    }

    @Override
    public String getMensajeSolicitud() {
        return "";
    }

    @Override
    public void manejar(Paquete paquete, String[] argumentos) {
        paquete.intercambiarDestinoOrigen();
        paquete.cambiarEstado(new Pendiente(paquete));
        Inventario.obtenerInstancia().guardarInventario();
    }

    @Override
    public String toString() {
        return "Devolución de Paquete";
    }
}
