/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_ecomienda.BDYValidaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author USUARIO
 */
public class ContadorDeIDs {

    private Connection cnx;

    // Constructor para inicializar la conexión
    public ContadorDeIDs(Connection cnx) {
        this.cnx = cnx;
    }

    // Método para obtener el siguiente ID de incidente
    public int obtenerSiguienteIdIncidente() {
        int siguienteId = 1; // Valor predeterminado en caso de que no haya incidentes
        try {
            // Consulta para obtener el máximo ID de Incidente
            String consulta = "SELECT COALESCE(MAX(IDIncidente), 0) AS max_id FROM Incidente";
            PreparedStatement stmt = cnx.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                // Si maxId es 0 (no hay incidentes), establece el siguiente ID como 1
                siguienteId = (maxId == 0) ? 1 : maxId + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja cualquier error de conexión o consulta aquí
        }
        return siguienteId;
    }
}
