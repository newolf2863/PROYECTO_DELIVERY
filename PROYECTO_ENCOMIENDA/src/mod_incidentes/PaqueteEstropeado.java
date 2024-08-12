/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

import mod_facturacion.Cotizacion;
import mod_facturacion.Precio;
import mod_paquetes.Paquete;

public class PaqueteEstropeado extends Incidente {

    @Override
    public String getMensajeRegistro(Paquete paquete) {
        return "El paquete se encuentra en malas condiciones.";
    }

    @Override
    public String getMensajeResolucion(Paquete paquete) {
        return "Por las condiciones de su paquete se le entregará una compensación de $" + feedback + ".";
    }

    @Override
    public String getMensajeSolicitud() {
        return "Por favor, ingrese el porcentaje de compensación para el daño del paquete (por ejemplo: 100).";
    }

    @Override
    public void manejar(Paquete paquete, String[] argumentos) {
        Precio precio = Cotizacion.obtenerInstancia().obtenerPrecioPaquete(paquete);
        double total = precio.getPrecioTotalPaquete();
        int porcentaje = Integer.parseInt(argumentos[0]);
        double valorCompensacion = (porcentaje / 100.0) * total;
        feedback = Double.toString(valorCompensacion);
    }

    @Override
    public String toString() {
        return "Paquete Estropeado";
    }
}
