/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_ecomienda.BDYValidaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import java.sql.PreparedStatement;


public class ActualizarEstadoFactura {
     PreparedStatement ps = (null);
     
     public static boolean anularFactura(Connection connection, int idFactura) {
        String updateQuery = "UPDATE factura SET estadoFactura = 'Dado de baja' WHERE idFactura = ? AND estadoFactura = 'Activo'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setInt(1, idFactura);
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar el error adecuadamente en tu aplicación
            return false;
        }
    }
     
     public static boolean cambiarEstadoPago(Connection connection, int idFactura) {
        String updateQuery = "UPDATE factura SET estadoPago = 'Cancelado' WHERE idFactura = ? AND estadoFactura = 'Activo'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setInt(1, idFactura);
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar el error adecuadamente en tu aplicación
            return false;
        }
    }
}
