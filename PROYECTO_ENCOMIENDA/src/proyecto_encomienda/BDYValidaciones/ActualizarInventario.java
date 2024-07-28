package proyecto_encomienda.BDYValidaciones;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class ActualizarInventario {

    ArrayList<String> atributosActualizar = new ArrayList<String>();

    public void addAtributo(String atributo) {
        this.atributosActualizar.add(atributo);
    }
    public void actualizarDatos(Connection cnx, String atributoActualizar, String condicion, String tabla) {
        StringBuilder consultaBuilder = new StringBuilder();
        Iterator<String> i = this.atributosActualizar.iterator();
        while (i.hasNext()) {
            consultaBuilder.append(i.next()).append(",");
        }
        String consulta = consultaBuilder.toString();
        if (consulta.endsWith(",")) {
            consulta = consulta.substring(0, consulta.length() - 1);
        }

        String sql = "UPDATE " + tabla + " SET " + consulta + " WHERE " + atributoActualizar + " = " + condicion;
        //System.out.println(sql);

        try (PreparedStatement pss = cnx.prepareStatement(sql)) {
            pss.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente", "Actualizar", JOptionPane.DEFAULT_OPTION);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar actualizar: " + ex.getMessage());
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
