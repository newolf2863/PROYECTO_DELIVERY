/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_ecomienda.BDYValidaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class ModuloUsuarios {
    
     ArrayList<String> atributosActualizarUsuarios = new ArrayList<String>();

    public void addAtributo(String atributo) {
        this.atributosActualizarUsuarios.add(atributo);
    }
    
    public void actualizarDatos(Connection cnx, String atributoActualizar, String condicion, String tabla) {
        StringBuilder consultaBuilder = new StringBuilder();
        Iterator<String> i = this.atributosActualizarUsuarios.iterator();
        while (i.hasNext()) {
            consultaBuilder.append(i.next()).append(",");
        }
        String consulta = consultaBuilder.toString();
        if (consulta.endsWith(",")) {
            consulta = consulta.substring(0, consulta.length() - 1);
        }

        String sql = "UPDATE " + tabla + " SET " + consulta + " WHERE " + atributoActualizar + " = " + condicion;
        System.out.println(sql);

        try (PreparedStatement pss = cnx.prepareStatement(sql)) {
            pss.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente", "Actualizar", JOptionPane.DEFAULT_OPTION);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar actualizar: " + ex.getMessage());
        }
    }
    
    public static void consultarUsuario(Connection cnx, String fragmentoNombre, JTable jTable) {
    String query = "SELECT nombreUser, CI,rol, estado FROM usuarios WHERE nombreUser LIKE ?";

    try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
        preparedStatement.setString(1, "%" + fragmentoNombre + "%"); // Agregamos los comodines % para búsqueda parcial

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            DefaultTableModel model = new DefaultTableModel();
            
            // Definir los nombres de las columnas
            model.setColumnIdentifiers(new Object[]{"Nombre de Usuario","CI", "Rol", "Estado"});
            
            jTable.setModel(model); // Establecer el modelo en la tabla

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombreUser");
                String ci = resultSet.getString("CI");
                String rol = resultSet.getString("rol");
                String estado = resultSet.getString("estado");
                model.addRow(new Object[]{nombre,ci,rol,estado});
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Manejo de error, por ejemplo, mostrar un mensaje al usuario.
    }
}

    public DefaultTableModel consultarUsuario1(Connection c, String fragmentoNombre) {
    String[] nombresColumnas = {"Nombre del usuario","CI del usuario", "Contraseña", "rol",};
    DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
    String query = "SELECT  nombreUser,CI, passwordU, rol FROM usuarios WHERE nombreUser LIKE ?";
    try (PreparedStatement pst = c.prepareStatement(query)) {
        pst.setString(1, "%" + fragmentoNombre + "%"); // Aplicar el filtro de idItem
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Object[] fila = {
                rs.getString("nombreUser"),
                rs.getString("CI"),
                rs.getString("passwordU"),
                rs.getString("rol"),
            };
            modelo.addRow(fila);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al conectar");
    }

    return modelo;
}

    public static void cambiarEstadoUsuario(Connection cnx, String userToChange) {
        String obtenerEstadoQuery = "SELECT estado FROM usuarios WHERE nombreUser = ?";
        String actualizarEstadoQuery = "UPDATE usuarios SET estado = ? WHERE nombreUser = ?";

        try (PreparedStatement obtenerEstadoStatement = cnx.prepareStatement(obtenerEstadoQuery)) {
            obtenerEstadoStatement.setString(1, userToChange);
            try (ResultSet resultSet = obtenerEstadoStatement.executeQuery()) {
                if (resultSet.next()) {
                    String estadoActual = resultSet.getString("estado");
                    String nuevoEstado = estadoActual.equals("Activado") ? "Bloqueado" : "Activado";

                    try (PreparedStatement actualizarEstadoStatement = cnx.prepareStatement(actualizarEstadoQuery)) {
                        actualizarEstadoStatement.setString(1, nuevoEstado);
                        actualizarEstadoStatement.setString(2, userToChange);
                        actualizarEstadoStatement.executeUpdate();
                        System.out.println("Estado de usuario actualizado exitosamente.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar el estado del usuario.");
        }
    }

    public static String obtenerEstadoUsuario(Connection cnx, String nombreUsuario) {
        String estado = "";
        try {
            String query = "SELECT estado FROM usuarios WHERE nombreUser = ?";
            PreparedStatement preparedStatement = cnx.prepareStatement(query);
            preparedStatement.setString(1, nombreUsuario);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                estado = resultSet.getString("estado");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estado;
    }

    public void actualizarDatosUsuario(Connection conexion, String condicion,String nuevaCI, String nuevaClave, String nuevoRol) {
        try {
            Statement stmt = conexion.createStatement();
            String updateQuery = "UPDATE usuarios SET ";
            boolean cambiosRealizados = false;
            if (nuevaCI != null) {
                updateQuery += "CI = '" + nuevaCI + "', ";
                cambiosRealizados = true;
            }
            if (nuevaClave != null) {
                updateQuery += "passwordU = '" + nuevaClave + "', ";
                cambiosRealizados = true;
            }
            if (nuevoRol != null) {
                updateQuery += "rol = '" + nuevoRol + "', ";
                cambiosRealizados = true;
            }

            if (cambiosRealizados) {
                // Elimina la coma y el espacio al final del query
                updateQuery = updateQuery.substring(0, updateQuery.length() - 2);

                // Agrega la condición al final del query
                updateQuery += " WHERE " + condicion;

                stmt.executeUpdate(updateQuery);
                stmt.close();
            } else {
                System.out.println("No se realizaron cambios.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DefaultTableModel mostrarTablaUsuario(Connection c) {
        String[] nombresColumnas = {"Nombre del Usuario", "CI", "Contraseña", "Rol"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT * FROM usuarios ORDER BY idUsuario";

        try (PreparedStatement pst = c.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Object[] fila = {
                    rs.getString("nombreUser"),
                    rs.getString("CI"),
                    rs.getString("passwordU"),
                    rs.getString("rol"),};
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

        return modelo;
    }
}
