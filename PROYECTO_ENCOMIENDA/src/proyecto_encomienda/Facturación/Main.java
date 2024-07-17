/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_encomienda.Facturación;

import java.util.Date;

/**
 *
 * @author USUARIO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Usuario usuario = new Usuario("John Doe", "123 Main St", "555-1234", "john@example.com");
        Paquete paquete = new Paquete(10.0, 2.0, "Electronics", "John Doe", "456 Elm St");

        Factura factura = new Factura(1, paquete, usuario, new Date());
        factura.emitirFactura();
    }
    
}
