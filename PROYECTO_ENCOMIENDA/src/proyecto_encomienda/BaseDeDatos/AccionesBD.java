
package proyecto_encomienda.BaseDeDatos;

/**
 *
 * @author Moises Arequipa
 */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AccionesBD {

    // Método para realizar consultas parametrizadas
    public DefaultTableModel buscarPorId(Connection c, String id, String tabla, String[] columnasVisibles, String[] columnasBD, String columnaB) {
        DefaultTableModel modelo = new DefaultTableModel();

        // Agrega las columnas visibles al modelo
        for (String columna : columnasVisibles) {
            modelo.addColumn(columna);
        }

        try {
            String sql;
            PreparedStatement ps;

            if (id == null || id.isEmpty()) {
                // Si el id está vacío, mostrar los primeros 10 registros de la tabla
                sql = "SELECT * FROM " + tabla + " LIMIT 10";
                ps = c.prepareStatement(sql);
            } else {
                // Si el id tiene valor, filtrar por ese valor
                sql = "SELECT * FROM " + tabla + " WHERE CAST(" + columnaB + " AS TEXT) ILIKE ?";
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + id + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[columnasBD.length];
                for (int i = 0; i < columnasBD.length; i++) {
                    fila[i] = rs.getObject(columnasBD[i]);
                }
                modelo.addRow(fila);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
    
    public void actualizarDatos(Connection cnx, String atributoActualizar, String condicion, String tabla, String atributosActualizacion) {
        try {
            // Construye la consulta SQL para actualizar los datos
            String sql = "UPDATE " + tabla + " SET " + atributosActualizacion + " WHERE " + atributoActualizar + " = " + condicion;
            // Crea una declaración SQL
            Statement statement = cnx.createStatement();
            // Ejecuta la consulta SQL
            int rowsAffected = statement.executeUpdate(sql);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar ningún registro.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            // Cierra la declaración y la conexión
            statement.close();
        } catch (SQLException e) {
            // Manejo de excepciones en caso de error
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
