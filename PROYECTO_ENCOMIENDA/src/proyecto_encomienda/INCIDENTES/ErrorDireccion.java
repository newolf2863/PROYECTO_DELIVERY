package proyecto_encomienda.INCIDENTES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ErrorDireccion extends Incidente {
    private Connection cnx;

     public ErrorDireccion(String descripcion, int idPaquete, int idIncidente, Connection cnx) {
        super(descripcion, idPaquete, idIncidente);
        this.cnx = cnx;
    }

    @Override
    public void actuar() {
        // Implementar la lógica específica para actuar en caso de error de dirección
    }

    @Override
    public void registrarIncidente() {
        PreparedStatement stmt = null;
        
        try {
            String sql = "INSERT INTO Incidente (IDPaquete, tipoIncidente, descripcion) VALUES (?, ?, ?)";
            stmt = cnx.prepareStatement(sql);
            stmt.setInt(1, getIdPaquete());
            stmt.setString(2, "Error de Dirección");
            stmt.setString(3, getDescripcion());
            
            stmt.executeUpdate();
              javax.swing.JOptionPane.showMessageDialog(null, 
                      "Incidente registrado con éxito.", "Error en la dirección",
                      javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, 
                      "Error al registrar incidente.", "Incidente no Registrado",
                      javax.swing.JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

