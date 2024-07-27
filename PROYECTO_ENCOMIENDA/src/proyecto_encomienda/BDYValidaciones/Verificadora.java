/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.BDYValidaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Verificadora {

    public static boolean facturaExiste(int idFactura, Connection connection) {
        String selectFacturaQuery = "SELECT idFactura FROM factura WHERE idFactura = ?";
        try (PreparedStatement selectFacturaStatement = connection.prepareStatement(selectFacturaQuery)) {
            selectFacturaStatement.setInt(1, idFactura);
            ResultSet facturaResult = selectFacturaStatement.executeQuery();
            return facturaResult.next(); // Devuelve true si la factura existe
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia de la factura", "Error", JOptionPane.ERROR_MESSAGE);
            return true; // Tratamiento de error: considerarla existente para evitar problemas
        }
    }
    
    public static boolean itemExiste(int idItem, Connection connection) {
        String selectItemQuery = "SELECT idItem FROM item WHERE idItem = ?";
        try (PreparedStatement selectItemStatement = connection.prepareStatement(selectItemQuery)) {
            selectItemStatement.setInt(1, idItem);
            ResultSet itemResult = selectItemStatement.executeQuery();
            return itemResult.next(); // Devuelve true si el item existe
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia del item", "Error", JOptionPane.ERROR_MESSAGE);
            return true; // Tratamiento de error: considerarlo existente para evitar problemas
        }
    }
}
