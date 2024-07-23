/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_ecomienda.BDYValidaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class IngresadorDeDatos {

    public static void ingresarItem(Connection cnx,
            int idItem, String nombreItem,
            int stock, double precio, String estado) {
        String query = "INSERT INTO item (idItem, nombreItem, stock, precio, estado) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setInt(1, idItem);
            statement.setString(2, nombreItem);
            statement.setInt(3, stock);
            statement.setDouble(4, precio);
            statement.setString(5, estado);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto agregado exitosamente.");
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngresadorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ingresarPaquete(Connection cnx, int idPaquete, double peso,
            double ancho, double largo,
            String contenido, String remitente, String destino) {
        // Query para insertar un nuevo paquete
        String query = "INSERT INTO Paquete (IDPaquete, peso, ancho, largo, contenido, remitente, direccionDestino, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, 'Pendiente')";

        try {
            // Preparar la consulta con parámetros
            PreparedStatement pstmt = cnx.prepareStatement(query);
            pstmt.setInt(1, idPaquete);
            pstmt.setDouble(2, peso);
            pstmt.setDouble(3, ancho);
            pstmt.setDouble(4, largo);
            pstmt.setString(5, contenido);
            pstmt.setString(6, remitente);
            pstmt.setString(7, destino);

            // Ejecutar la consulta
            pstmt.executeUpdate();

            System.out.println("Paquete ingresado correctamente en la base de datos.");
        } catch (SQLException e) {
            // Manejar cualquier error de SQL
            System.err.println("Error al ingresar el paquete: " + e.getMessage());
        }
    }
}
