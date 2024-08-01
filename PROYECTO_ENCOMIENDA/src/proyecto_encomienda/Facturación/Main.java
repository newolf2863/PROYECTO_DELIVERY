/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_encomienda.Facturación;

import java.util.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author USUARIO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


      String url = "jdbc:postgresql://localhost:5432/envios";
        String user = "administrador";
        String password = "123";

        try (Connection cnx = DriverManager.getConnection(url, user, password)) {
            // Crear la tabla Factura si no existe
            String createTableSQL = "CREATE TABLE IF NOT EXISTS factura (" +
                                    "id SERIAL PRIMARY KEY," +
                                    "documento VARCHAR(50)," +
                                    "names VARCHAR(100)," +
                                    "lastnames VARCHAR(100)," +
                                    "telefono VARCHAR(15)," +
                                    "direction VARCHAR(255)," +
                                    "email VARCHAR(100)," +
                                    "is_natural BOOLEAN," +
                                    "country BOOLEAN," +
                                    "fechaEmision DATE," +
                                    "subtotal DECIMAL(10, 2)," +
                                    "total DECIMAL(10, 2)," +
                                    "iva DECIMAL(10, 2)" +
                                    ")";

            try (Statement stmt = cnx.createStatement()) {
                stmt.execute(createTableSQL);
                System.out.println("Tabla Factura creada exitosamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Crear una factura de ejemplo
            Paquete paquete = new Paquete(1, 30.0, 2.5, 40.0, "Electrónica", "Juan Pérez", "Loja");
            Factura factura = new Factura(paquete, "001", "Jhon", "Minda", "0987654321", "Loja", "juan@eeafd.com", true, true, new Date());
            factura.calcularPrecios();
            factura.insertarFactura(cnx);

            // Buscar una factura por ID
            Factura facturaBuscada = Factura.buscarFacturaPorId(cnx, 1); // Asumiendo que el ID de la factura que quieres buscar es 1

            if (facturaBuscada != null) {
                System.out.println("Factura encontrada:");
                System.out.println("Documento: " + facturaBuscada.getDocumento());
                System.out.println("Names: " + facturaBuscada.getNames());
                System.out.println("Lastnames: " + facturaBuscada.getLastnames());
                System.out.println("Teléfono: " + facturaBuscada.getTelefono());
                System.out.println("Dirección: " + facturaBuscada.getDirection());
                System.out.println("Email: " + facturaBuscada.getEmail());
                System.out.println("Es Natural: " + facturaBuscada.isNatural());
                System.out.println("Country: " + facturaBuscada.isCountry());
                System.out.println("Fecha de Emisión: " + facturaBuscada.getFechaEmision());
                System.out.println("Subtotal: " + facturaBuscada.getSubtotal());
                System.out.println("Total: " + facturaBuscada.getTotal());
                System.out.println("IVA: " + facturaBuscada.getIva());
            } else {
                System.out.println("Factura no encontrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
