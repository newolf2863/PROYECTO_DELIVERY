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
import javax.swing.JTable;
import java.sql.ResultSet;

/**
 *
 * @author pc
 */
public class IngresadorDeDatos {
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

    public static void ingresarInventario(Connection cnx, int idInventario, String descripcion) {
        // Query para insertar un nuevo registro en Inventario
        String query = "INSERT INTO Inventario (codigoTracking, descripcion) VALUES (?, ?)";

        try {
            // Preparar la consulta con parámetros
            PreparedStatement pstmt = cnx.prepareStatement(query);
            pstmt.setInt(1, idInventario);
            pstmt.setString(2, descripcion);

            // Ejecutar la consulta
            pstmt.executeUpdate();

            System.out.println("Registro de inventario ingresado correctamente en la base de datos.");
        } catch (SQLException e) {
            // Manejar cualquier error de SQL
            System.err.println("Error al ingresar el registro de inventario: " + e.getMessage());
        }
    }
    
    public static void registrarDatosInventario(Connection cnx, JTable jTablaInventario4, String descripcion) {
        try {
            // Iniciar la transacción
            cnx.setAutoCommit(false);

            String queryInventario = "INSERT INTO Inventario (descripcion) VALUES (?) RETURNING idInventario";
            String queryInventarioPaquete = "INSERT INTO Inventario_Paquete (codigoTraking, idPaquete) VALUES (?, ?)";

            // Preparar la declaración para insertar en la tabla Inventario_Paquete
            PreparedStatement statementInventarioPaquete = cnx.prepareStatement(queryInventarioPaquete);

            // Iterar a través de todas las filas de la tabla jTablaInventario4
            for (int i = 0; i < jTablaInventario4.getRowCount(); i++) {

                // Preparar la declaración para insertar en la tabla Inventario
                PreparedStatement statementInventario = cnx.prepareStatement(queryInventario);
                statementInventario.setString(1, descripcion);

                // Ejecutar la inserción en la tabla Inventario y obtener el ID generado
                ResultSet rs = statementInventario.executeQuery();
                rs.next(); // Asegúrate de mover el cursor a la primera fila
                int idInventario = rs.getInt(1);

                // Obtener valores de la tabla jTablaInventario4
                String valorComoString = jTablaInventario4.getValueAt(i, 0).toString();
                int idPaquete = Integer.parseInt(valorComoString);
                String valorTraking = jTablaInventario4.getValueAt(i, 2).toString();
                int codigoTraking = Integer.parseInt(valorTraking);

                // Asignar los valores a la declaración preparada de Inventario_Paquete
                statementInventarioPaquete.setInt(1, codigoTraking);
                statementInventarioPaquete.setInt(2, idPaquete);

                // Ejecutar la inserción en Inventario_Paquete
                statementInventarioPaquete.executeUpdate();

                // Cerrar el ResultSet y el PreparedStatement de Inventario
                rs.close();
                statementInventario.close();
            }

            // Confirmar la transacción
            cnx.commit();

        } catch (SQLException ex) {
            try {
                // En caso de error, deshacer la transacción
                cnx.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
            ex.printStackTrace();
        } finally {
            try {
                // Restaurar el modo de confirmación automática
                cnx.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
