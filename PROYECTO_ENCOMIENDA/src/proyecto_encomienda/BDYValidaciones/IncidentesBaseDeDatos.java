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
public class IncidentesBaseDeDatos {
    public static boolean verificarCodigoTracking(Connection c, int idPaquete) {
    boolean tieneCodigoTracking = false;
    String sql = "SELECT COUNT(*) FROM VistaDatosPaquete WHERE IDPaquete = ? AND codigoTraking IS NOT NULL";
    
    try (PreparedStatement ps = c.prepareStatement(sql)) {
        ps.setInt(1, idPaquete);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            tieneCodigoTracking = rs.getInt(1) > 0;
        }
        rs.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return tieneCodigoTracking;
}

}
