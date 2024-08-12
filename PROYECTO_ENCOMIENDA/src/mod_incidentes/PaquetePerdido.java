/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change esta licencia
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar esta plantilla
 */
package mod_incidentes;

import mod_facturacion.Cotizacion;
import mod_facturacion.Precio;
import mod_paquetes.Paquete;

/**
 * Clase que representa un incidente de paquete perdido.
 * Esta clase extiende la clase abstracta Incidente y proporciona
 * implementaciones específicas para registrar y resolver el incidente.
 *
 * @autor Rodrigo Haro
 */
public class PaquetePerdido extends Incidente {

    
    @Override
    public String getMensajeRegistro(Paquete paquete) {
        return "El paquete ha sido reportado como perdido.";
    }

    @Override
    public String getMensajeResolucion(Paquete paquete) {
        return "Lamentamos informarle que su paquete se ha perdido. Se le proporcionará una compensación de $" + feedback + ".";
    }

    @Override
    public String getMensajeSolicitud() {
        return "Por favor, ingrese el porcentaje de compensación para la pérdida del paquete (por ejemplo: 100).";
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
        return "Paquete Perdido";
    }
}
