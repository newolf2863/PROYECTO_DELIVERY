/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_paquetes;

import mod_facturacion.Cotizacion;
import mod_paquetes.Inventario;
import mod_transporte.FlotaVehiculo;

/**
 *
 * @author Rodrigo Haro
 */
public class Proyecto_paquetes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Inventario.obtenerInstancia().cargarInventario();
        Cotizacion.obtenerInstancia().cargarCotizacion();
        JFIngresar loginForm = new JFIngresar();
        loginForm.setVisible(true);
    }

}
