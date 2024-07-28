package proyecto_encomienda.INCIDENTES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ErrorDireccion extends Incidente {
    private Connection cnx;
    private String estado="";

    public ErrorDireccion(String descripcion, int idPaquete, int idIncidente, Connection cnx,String est) {
        super(descripcion, idPaquete, idIncidente,est);
        this.cnx = cnx;
        this.estado=est;
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
            stmt.setString(2, getEstado());
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

    @Override
    public void actualizarIncidente(String tabla, String columnaId, String id, String[] columnas, Object[] valores) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}

