package proyecto_encomienda.INCIDENTES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DanioPaquete extends Incidente {
    private Connection cnx;
    private String estado="";

    public DanioPaquete(String descripcion, int idPaquete, int idIncidente, Connection cnx,String est) {
        super(descripcion, idPaquete, idIncidente,est);
        this.cnx = cnx;
        this.setEstado(estado);
    }

    @Override
    public void actuar() {
        // Implementar la lógica específica para actuar en caso de daño en el paquete
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
                      "Incidente registrado con éxito.", "Daño en el paquete",
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
        if (columnas.length != valores.length) {
            throw new IllegalArgumentException("Columnas y valores deben tener la misma longitud");
        }

        PreparedStatement ps = null;
        try {
            // Construir la consulta SQL de actualización
            StringBuilder sql = new StringBuilder("UPDATE " + tabla + " SET ");
            for (int i = 0; i < columnas.length; i++) {
                sql.append(columnas[i]).append(" = ?");
                if (i < columnas.length - 1) {
                    sql.append(", ");
                }
            }
            sql.append(" WHERE ").append(columnaId).append(" = ?");
            
            // Preparar la consulta
            ps = cnx.prepareStatement(sql.toString());
            for (int i = 0; i < valores.length; i++) {
                ps.setObject(i + 1, valores[i]);
            }
            ps.setObject(valores.length + 1, id);

            // Ejecutar la actualización
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                javax.swing.JOptionPane.showMessageDialog(null, 
                        "Incidente actualizado con éxito.", "Actualización de Incidente",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, 
                        "No se encontró el incidente para actualizar.", "Actualización Fallida",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, 
                    "Error al actualizar incidente.", "Actualización Fallida",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


