/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_encomienda;

import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Paquete;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Pendiente;

/**
 *
 * @author Issac
 */

public class PROYECTO_ENCOMIENDA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Paquete paquete1 = new Paquete("123456789", 20.5, 30.2, "Libros", "Quito, Ecuador");
        Paquete paquete2 = new Paquete("987654321", 35.4, 15.8, "Juguetes", "Guayaquil, Ecuador");
        Paquete paquete3 = new Paquete("000000000", 42.1, 23.9, "Ropa", "Cuenca, Ecuador");

        inventario.agregarPaquete(paquete1);
        inventario.agregarPaquete(paquete2);
        inventario.agregarPaquete(paquete3);
        
        System.out.println(inventario.verificarEstadoPaquete("123456789"));
        inventario.obtenerPaquete("123456789").iniciarEnvio();
        System.out.println(inventario.verificarEstadoPaquete("123456789"));
        inventario.obtenerPaquete("123456789").iniciarEnvio();
        System.out.println(inventario.verificarEstadoPaquete("123456789"));
        inventario.obtenerPaquete("123456789").completarEnvio();
        System.out.println(inventario.verificarEstadoPaquete("123456789"));
        Paquete paquete = inventario.obtenerPaquete("123456789");
        paquete.cambiarEstado(new Pendiente(paquete));
        System.out.println(inventario.verificarEstadoPaquete("123456789"));
        System.out.println(paquete.obtenerHistorialEstados());        
    }  
}
