
package proyecto_encomienda.BaseDeDatos;

/**
 *
 * @author Moises Arequipa
 */
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class AccionesBD {

    // Método para realizar consultas parametrizadas
    public static DefaultTableModel buscarPorId(Connection conexion, String tabla, String columnaId, String id) {
        DefaultTableModel modelo = new DefaultTableModel();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Obtener metadatos de la tabla
            DatabaseMetaData metaData = conexion.getMetaData();
            rs = metaData.getColumns(null, null, tabla, null);
            while (rs.next()) {
                modelo.addColumn(rs.getString("COLUMN_NAME"));
            }
            rs.close();

            // Preparar y ejecutar consulta
            String sql = (id == null || id.isEmpty()) ? "SELECT * FROM " + tabla + " LIMIT 100" 
                                                     : "SELECT * FROM " + tabla + " WHERE " + columnaId + " ILIKE ?";
            ps = conexion.prepareStatement(sql);
            if (id != null && !id.isEmpty()) {
                ps.setString(1, "%" + id + "%");
            }
            rs = ps.executeQuery();

            // Llenar el modelo con los resultados
            while (rs.next()) {
                Object[] fila = new Object[modelo.getColumnCount()];
                for (int i = 0; i < modelo.getColumnCount(); i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return modelo;
    }

    // Método para realizar actualizaciones parametrizadas
    public static boolean actualizarPorId(Connection conexion, String tabla, String columnaId, String id, String[] columnas, Object[] valores) {
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
            ps = conexion.prepareStatement(sql.toString());
            for (int i = 0; i < valores.length; i++) {
                ps.setObject(i + 1, valores[i]);
            }
            ps.setObject(valores.length + 1, id);

            // Ejecutar la actualización
            int filasActualizadas = ps.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar recursos
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para realizar eliminaciones parametrizadas
    public static boolean eliminarPorId(Connection conexion, String tabla, String columnaId, String id) {
        PreparedStatement ps = null;
        try {
            // Preparar la consulta de eliminación
            String sql = "DELETE FROM " + tabla + " WHERE " + columnaId + " = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, id);

            // Ejecutar la eliminación
            int filasEliminadas = ps.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar recursos
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
