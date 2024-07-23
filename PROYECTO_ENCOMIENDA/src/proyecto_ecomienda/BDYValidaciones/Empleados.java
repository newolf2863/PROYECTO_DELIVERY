/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_ecomienda.BDYValidaciones;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Empleados {

    private Connection cnx; // Debes establecer la conexión en esta clase

    public Empleados(Connection connection) {
        this.cnx = connection;
    }

public boolean registrarEmpleado(String ci, String nombres, String apellidos, String direccion,
        String fechaNacimiento, String sexo, String telefonoConvencional,
        String telefonoPersonal, String correoElectronico, String cargo) {
    boolean registroExitoso = false;
    try {
        // Primero, verificamos si ya existe un empleado con la misma CI
        String verificacionSql = "SELECT COUNT(*) FROM empleados WHERE CI = ?";
        PreparedStatement verificacionStmt = cnx.prepareStatement(verificacionSql);
        verificacionStmt.setString(1, ci);
        ResultSet resultSet = verificacionStmt.executeQuery();
        resultSet.next(); // Mover el cursor al primer resultado
        int cantidadRegistros = resultSet.getInt(1);

        if (cantidadRegistros > 0) {
            JOptionPane.showMessageDialog(null, "Ya existe un empleado registrado con la misma cédula.", "Error de registro", JOptionPane.ERROR_MESSAGE);
            return false; // No se registra el empleado si ya existe
        }

        // Si no existe, procedemos a registrar al empleado
        String sql = "INSERT INTO empleados (CI, nombres, apellidos, direccion, fecha_nacimiento, sexo, telefono_convencional, telefono_movil, correo_electronico, cargo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = cnx.prepareStatement(sql);
        preparedStatement.setString(1, ci);
        preparedStatement.setString(2, nombres);
        preparedStatement.setString(3, apellidos);
        preparedStatement.setString(4, direccion);
        preparedStatement.setString(5, fechaNacimiento);
        preparedStatement.setString(6, sexo);
        preparedStatement.setString(7, telefonoConvencional);
        preparedStatement.setString(8, telefonoPersonal);
        preparedStatement.setString(9, correoElectronico);
        preparedStatement.setString(10, cargo);

        int filasAfectadas = preparedStatement.executeUpdate();

        preparedStatement.close();

        if (filasAfectadas > 0) {
            registroExitoso = true;
            JOptionPane.showMessageDialog(null, "Empleado registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar al empleado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al registrar el empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return registroExitoso;
}



    public DefaultTableModel obtenerModeloTablaEmpleadosActualizar() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CI");
        model.addColumn("Nombres");
        model.addColumn("Apellidos");
        model.addColumn("Teléfono Personal");
        model.addColumn("Correo Electrónico");
        String sql = "SELECT CI, nombres, apellidos, telefono_movil, correo_electronico FROM empleados WHERE CI <> ?";
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setString(1, "0000000000");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vector<String> row = new Vector<>();
                row.add(resultSet.getString("CI"));
                row.add(resultSet.getString("nombres"));
                row.add(resultSet.getString("apellidos"));
                row.add(resultSet.getString("telefono_movil"));
                row.add(resultSet.getString("correo_electronico"));
                model.addRow(row);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }

    public DefaultTableModel obtenerModeloTablaEmpleados(String filtroCI) {
        String[] nombresColumnas = {"CI", "Nombres", "Apellidos", "Dirección", "Fecha de Nacimiento", "Sexo",
            "Teléfono Convencional", "Teléfono personal", "Correo Electrónico", "Cargo"};
        DefaultTableModel model = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT * FROM empleados WHERE CI LIKE ? AND CI <> '0000000000'";
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setString(1, "%" + filtroCI + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ci = resultSet.getString("CI");
                if (!ci.equals("0000000000")) {
                    Vector<String> row = new Vector<>();
                    row.add(ci);
                    row.add(resultSet.getString("nombres"));
                    row.add(resultSet.getString("apellidos"));
                    row.add(resultSet.getString("direccion"));
                    row.add(resultSet.getString("fecha_nacimiento"));
                    row.add(resultSet.getString("sexo"));
                    row.add(resultSet.getString("telefono_convencional"));
                    row.add(resultSet.getString("telefono_movil"));
                    row.add(resultSet.getString("correo_electronico"));
                    row.add(resultSet.getString("cargo"));
                    model.addRow(row);
                }
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }
    
    public DefaultTableModel obtenerModeloTablaEmpleados1(String filtroCI) {
        String[] nombresColumnas = {"CI", "Nombres", "Apellidos", "Dirección", "Fecha de Nacimiento", "Sexo",
            "Teléfono Convencional", "Teléfono Movil", "Correo Electrónico", "Cargo","Estado"};
        DefaultTableModel model = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT * FROM empleados WHERE CI LIKE ? AND CI <> '0000000000'";
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setString(1, "%" + filtroCI + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ci = resultSet.getString("CI");
                if (!ci.equals("0000000000")) {
                    Vector<String> row = new Vector<>();
                    row.add(ci);
                    row.add(resultSet.getString("nombres"));
                    row.add(resultSet.getString("apellidos"));
                    row.add(resultSet.getString("direccion"));
                    row.add(resultSet.getString("fecha_nacimiento"));
                    row.add(resultSet.getString("sexo"));
                    row.add(resultSet.getString("telefono_convencional"));
                    row.add(resultSet.getString("telefono_movil"));
                    row.add(resultSet.getString("correo_electronico"));
                    row.add(resultSet.getString("cargo"));
                    row.add(resultSet.getString("estadoEmpleado"));
                    model.addRow(row);
                }
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }

    public static DefaultTableModel buscarEmpleado(Connection connection, String campo, String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CI");

        switch (campo) {
            case "apellidos" -> {
                modelo.addColumn("Apellidos");
            }
            case "nombres" -> {
                modelo.addColumn("Nombres");
            }
            case "direccion" -> {
                modelo.addColumn("Direccion");
            }
            case "telefono_convencional" -> {
                modelo.addColumn("Teléfono convencional");
            }
            case "telefono_movil" -> {
                modelo.addColumn("Teléfono personal");
            }
            case "cargo" -> {
                modelo.addColumn("Cargo");
            }
            case "correo" -> {
                modelo.addColumn("Correo");
            }
        }

        String sql = "SELECT CI, " + campo + " FROM empleados WHERE CI LIKE ?";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "%" + valor + "%"); // Agregar % para búsqueda parcial
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Object[] fila = new Object[2]; // Dos columnas en la tabla
                        fila[0] = resultSet.getString("CI");
                        fila[1] = resultSet.getObject(campo);
                        modelo.addRow(fila);
                    }
                }
            } // Agregar % para búsqueda parcial // Agregar % para búsqueda parcial
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción de alguna manera adecuada
        }

        return modelo;
    }
    
    
    public void actualizarEstadoEmpleado(String CIEmpleado) {
        try {
            String sql = "SELECT estadoEmpleado FROM empleados WHERE CI = ?";
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setString(1, CIEmpleado);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String estadoEmpleado = resultSet.getString("estadoEmpleado");

                if ("Activo".equals(estadoEmpleado)) {
                    sql = "UPDATE empleados SET estadoEmpleado = 'Dado de baja' WHERE CI = ?";
                } else if ("Dado de baja".equals(estadoEmpleado)) {
                    sql = "UPDATE empleados SET estadoEmpleado = 'Activo' WHERE CI = ?";
                }

                statement = cnx.prepareStatement(sql);
                statement.setString(1, CIEmpleado);
                statement.executeUpdate();
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   public String obtenerEstadoEmpleado(String cicliente) {
    String estado = "Desconocido";
    try {
        String sql = "SELECT estadoEmpleado FROM empleados WHERE CI = ?";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
            preparedStatement.setString(1, cicliente);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    estado = rs.getString("estadoEmpleado");
                }
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el estado del Empleado desde la base de datos: " + e.getMessage());
    }
    return estado;
}
   
    public void cambiarEstadoEmpleado(String empleado, String nuevoEstado) {
    try {
        // Sentencia SQL para actualizar el estado del cliente al nuevo estado
        String sql = "UPDATE empleados SET estadoEmpleado = ? WHERE CI = ?";
        PreparedStatement preparedStatement = cnx.prepareStatement(sql);
        preparedStatement.setString(1, nuevoEstado);
        preparedStatement.setString(2, empleado);
        // Ejecutar la actualización
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            // La actualización fue exitosa      
        } else {
            // No se encontró ningún cliente con el ID proporcionado
        }

        // Cerrar la conexión y la PreparedStatement
        preparedStatement.close();
    } catch (SQLException e) {
        // Manejar errores de SQL
        e.printStackTrace();
    }
}



}
