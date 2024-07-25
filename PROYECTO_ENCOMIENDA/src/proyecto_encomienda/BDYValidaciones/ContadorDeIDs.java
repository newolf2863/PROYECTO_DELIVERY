/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.BDYValidaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author USUARIO
 */


public class ContadorDeIDs {


    public int obtenerSiguienteIdIncidente(Connection cnx) {
        int siguienteId = 1; // Valor predeterminado en caso de que no haya incidentes
        String consulta = "SELECT COALESCE(MAX(IDIncidente), 0) AS max_id FROM Incidente";
        
        try (PreparedStatement stmt = cnx.prepareStatement(consulta);
             ResultSet rs = stmt.executeQuery()) {
            
            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                siguienteId = (maxId == 0) ? 1 : maxId + 1;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return siguienteId;
    }
}
