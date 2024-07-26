/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.BDYValidaciones;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Conductores {
    //Ejemplos para inserccion de datos
    public void ingresarDatoProveedor(Connection cnx, String ruc, String nombre_empresa) {
        try {
            // Verificar si el proveedor ya existe
            String sqlVerificacion = "SELECT COUNT(*) FROM proveedores WHERE ruc = ?";
            try (PreparedStatement verificacionStatement = cnx.prepareStatement(sqlVerificacion)) {
                verificacionStatement.setString(1, ruc);
                ResultSet resultSet = verificacionStatement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);

                if (count > 0) {
                    // El proveedor ya existe, no se realiza ninguna acción adicional.
                } else {
                    // Preparar la sentencia SQL INSERT
                    String sql = "INSERT INTO proveedores (ruc, nombre_empresa) VALUES (?, ?)";
                    // Establecer los valores de los parámetros
                    try (PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
                        preparedStatement.setString(1, ruc);
                        preparedStatement.setString(2, nombre_empresa);
                        // Ejecutar la sentencia SQL
                        int filasAfectadas = preparedStatement.executeUpdate();
                        if (filasAfectadas > 0) {
                            System.out.println("Datos del proveedor ingresados correctamente.");
                        } else {
                            //System.out.println("No se pudo ingresar datos del proveedor.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ingresarDatoDespachador(Connection cnx, String ci_despachador,
            String nombre_despachador, String apellido_despachador,
            String idProveedor, String numeroTelefono) {
        try {
            // Verificar si el despachador ya existe
            String sqlVerificacion = "SELECT COUNT(*) FROM despachadores WHERE ci_despachador = ?";
            try (PreparedStatement verificacionStatement = cnx.prepareStatement(sqlVerificacion)) {
                verificacionStatement.setString(1, ci_despachador);
                ResultSet resultSet = verificacionStatement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);

                if (count == 0) {
                    // El despachador no existe, proceder con la inserción
                    String sql = "INSERT INTO despachadores (ci_despachador, nombre_despachador, apellido_despachador, idProveedor, numero_telefono)"
                            + " VALUES (?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
                        preparedStatement.setString(1, ci_despachador);
                        preparedStatement.setString(2, nombre_despachador);
                        preparedStatement.setString(3, apellido_despachador);
                        preparedStatement.setString(4, idProveedor);
                        preparedStatement.setString(5, numeroTelefono);
                        int filasAfectadas = preparedStatement.executeUpdate();
                        if (filasAfectadas > 0) {
                            System.out.println("Datos del despachador ingresados correctamente.");
                        } else {
                            System.out.println("No se pudo ingresar datos del despachador.");
                        }
                    }
                } else {
                    // El despachador ya existe, no se realiza ninguna acción adicional.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existeConductor(Connection cnx, String ci_despachador) {
        try {
            String sql = "SELECT COUNT(*) FROM despachadores WHERE ci_despachador = ?";
            try (PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
                preparedStatement.setString(1, ci_despachador);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);

                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // En caso de error, se considera que no existe el despachador (puedes manejar errores de otra manera si lo prefieres)
        }
    }

    public DefaultTableModel mostrarListaP(Connection c, String ruc) {
        DefaultTableModel tableModel = new DefaultTableModel();

        // Agregar columnas a la tabla
        tableModel.addColumn("RUC del proveedor");
        tableModel.addColumn("Empresa");
        tableModel.addColumn("CI Despachador");
        tableModel.addColumn("Nombre Despachador");
        tableModel.addColumn("Apellido Despachador");
        tableModel.addColumn("Número de Teléfono");

        String sql = "SELECT * FROM vista_pd WHERE ruc_proveedor like ?";
        try (PreparedStatement preparedStatement = c.prepareStatement(sql)) {
            preparedStatement.setString(1, "%"+ruc+"%");
            ResultSet resultSet = preparedStatement.executeQuery();

            // Llenar la tabla con los resultados de la consulta
            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getString("ruc_proveedor"),
                    resultSet.getString("nombre_empresa"),
                    resultSet.getString("ci_despachador"),
                    resultSet.getString("nombre_despachador"),
                    resultSet.getString("apellido_despachador"),
                    resultSet.getString("numero_telefono")
                };
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableModel;
    }
    
    public DefaultTableModel mostrarListaParcial(Connection c, String ruc) {
    DefaultTableModel tableModel = new DefaultTableModel();

    // Agregar columnas a la tabla
    tableModel.addColumn("RUC del proveedor");
    tableModel.addColumn("Empresa");
    tableModel.addColumn("CI Despachador");
    tableModel.addColumn("Nombre Despachador");
    tableModel.addColumn("Apellido Despachador");
    tableModel.addColumn("Número de Teléfono");

    String sql = "SELECT * FROM vista_pd WHERE ruc_proveedor LIKE ?";
    try (PreparedStatement preparedStatement = c.prepareStatement(sql)) {
        preparedStatement.setString(1, "%" + ruc + "%");
        ResultSet resultSet = preparedStatement.executeQuery();

        // Llenar la tabla con los resultados de la consulta
        while (resultSet.next()) {
            Object[] row = {
                resultSet.getString("ruc_proveedor"),
                resultSet.getString("nombre_empresa"),
                resultSet.getString("ci_despachador"),
                resultSet.getString("nombre_despachador"),
                resultSet.getString("apellido_despachador"),
                resultSet.getString("numero_telefono")
            };
            tableModel.addRow(row);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return tableModel;
}


    public void agregarProductoDetalleEntrega(Connection cnx, int idItem, String nombreItem, String ci_despachador) {
        try {
            // Preparar la sentencia SQL INSERT
            String sql = "INSERT INTO detalle_entrega (idItem, nombreItem, ci_despachador) VALUES (?, ?, ?)";
            // Establecer los valores de los parámetros
            try (PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
                preparedStatement.setInt(1, idItem);
                preparedStatement.setString(2, nombreItem);
                preparedStatement.setString(3, ci_despachador);
                // Ejecutar la sentencia SQL
                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Producto agregado correctamente.");
                } else {
                    System.out.println("No se pudo agregar el producto.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existeProductoDetalleEntrega(Connection cnx, int idItem, String ciDespachador) {
        try {
            // Verificar si el producto existe en la tabla detalle_entrega
            String sql = "SELECT COUNT(*) FROM detalle_entrega WHERE idItem = ? AND ci_despachador = ?";
            try (PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
                preparedStatement.setInt(1, idItem);
                preparedStatement.setString(2, ciDespachador);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public DefaultTableModel mostrarListaProductos(Connection c, String CI) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CI del despachador");
        model.addColumn("ID del ítem");
        model.addColumn("Nombre del ítem");

        String sql = "SELECT ci_despachador, idItem, nombreItem FROM vista_detalle_entrega WHERE ci_despachador = ?";

        try (PreparedStatement preparedStatement = c.prepareStatement(sql)) {
            preparedStatement.setString(1, CI);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ciDespachador = resultSet.getString("ci_despachador");
                int idItem = resultSet.getInt("idItem");
                String nombreItem = resultSet.getString("nombreItem");
                model.addRow(new Object[]{ciDespachador, idItem, nombreItem});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }
    
   public DefaultTableModel mostrarListaProv(Connection c, String CI) {
    DefaultTableModel model = new DefaultTableModel();

    // Define los nombres de las columnas
    model.addColumn("RUC");
    model.addColumn("Nombre de la empresa");
    model.addColumn("CI del despachador");
    model.addColumn("Número de teléfono");
    model.addColumn("ID del ítem");
    model.addColumn("Nombre del ítem");

    // Consulta SQL parametrizada
    String sql = "SELECT * FROM vista_detalles_empresa WHERE ci_despachador like ?";

    try (PreparedStatement preparedStatement = c.prepareStatement(sql)) {
        preparedStatement.setString(1, "%"+CI+"%");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String ruc = resultSet.getString("ruc");
            String nombreEmpresa = resultSet.getString("nombre_empresa");
            String ciDespachador = resultSet.getString("ci_despachador");
            String numeroTelefono = resultSet.getString("numero_telefono");
            int idItem = resultSet.getInt("idItem");
            String nombreItem = resultSet.getString("nombreItem");

            model.addRow(new Object[]{ruc, nombreEmpresa, ciDespachador, numeroTelefono, idItem, nombreItem});
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return model;
}

    public void quitarProductoDetalleEntrega(Connection cnx, int idItem, String ciDespachador) {
        try {
            String sql = "DELETE FROM detalle_entrega WHERE idItem = ? AND ci_despachador = ?";

            try (PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
                preparedStatement.setInt(1, idItem);
                preparedStatement.setString(2, ciDespachador);

                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el producto para eliminar.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private String obtenerEstadoProveedor(Connection cnx, String rucProveedor) throws SQLException {
    String estadoActual = "";
    String query = "SELECT estado_empresa FROM proveedores WHERE ruc = ?";
    try (PreparedStatement stmt = cnx.prepareStatement(query)) {
        stmt.setString(1, rucProveedor);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                estadoActual = rs.getString("estado_empresa");
            }
        }
    }
    return estadoActual;
}
    
    public String cambiarEstadoProveedor(Connection cnx, String rucProveedor) {
    try {
        // Iniciar una transacción
        cnx.setAutoCommit(false);

        // Obtener el estado actual del proveedor
        String estadoActual = obtenerEstadoProveedor(cnx, rucProveedor);

        // Determinar el nuevo estado
        String nuevoEstado = (estadoActual.equals("Activo")) ? "Dado de baja" : "Activo";

        // Cambiar el estado del proveedor
        String updateProveedorSQL = "UPDATE proveedores SET estado_empresa = ? WHERE ruc = ?";
        PreparedStatement updateProveedorStmt = cnx.prepareStatement(updateProveedorSQL);
        updateProveedorStmt.setString(1, nuevoEstado);
        updateProveedorStmt.setString(2, rucProveedor);
        int rowsUpdatedProveedor = updateProveedorStmt.executeUpdate();

        // Cambiar el estado de los despachadores relacionados al proveedor
        String updateDespachadoresSQL = "UPDATE despachadores SET estado_despachador = ? WHERE idProveedor = ?";
        PreparedStatement updateDespachadoresStmt = cnx.prepareStatement(updateDespachadoresSQL);
        updateDespachadoresStmt.setString(1, nuevoEstado);
        updateDespachadoresStmt.setString(2, rucProveedor);
        int rowsUpdatedDespachadores = updateDespachadoresStmt.executeUpdate();

        if (rowsUpdatedProveedor > 0) {
            // Confirmar la transacción
            cnx.commit();

            // Restaurar el modo de autoconfirmación
            cnx.setAutoCommit(true);

            return "El estado del proveedor ha cambiado a: " + nuevoEstado;
        } else {
            throw new SQLException("Error al cambiar el estado del proveedor.");
        }

    } catch (SQLException e) {
        try {
            // Realizar rollback en caso de error
            cnx.rollback();
            cnx.setAutoCommit(true);
        } catch (SQLException ex) {
            // Manejar errores de rollback
        }
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}

// 
    
   public void cambiarEstadoDespachador(Connection cnx, String ciDespachador) {
    try {
        // Obtener el estado actual del despachador
        String obtenerEstadoSQL = "SELECT estado_despachador FROM despachadores WHERE ci_despachador = ?";
        PreparedStatement obtenerEstadoStmt = cnx.prepareStatement(obtenerEstadoSQL);
        obtenerEstadoStmt.setString(1, ciDespachador);
        String estadoActual = "";
        
        try (var resultSet = obtenerEstadoStmt.executeQuery()) {
            if (resultSet.next()) {
                estadoActual = resultSet.getString("estado_despachador");
            }
        }

        // Cambiar el estado del despachador
        String nuevoEstado = (estadoActual.equals("Activo")) ? "Dado de baja" : "Activo";
        String updateEstadoSQL = "UPDATE despachadores SET estado_despachador = ? WHERE ci_despachador = ?";
        PreparedStatement updateEstadoStmt = cnx.prepareStatement(updateEstadoSQL);
        updateEstadoStmt.setString(1, nuevoEstado);
        updateEstadoStmt.setString(2, ciDespachador);
        updateEstadoStmt.executeUpdate();

        // Mensaje de confirmación
        String mensajeConfirmacion = (nuevoEstado.equals("Dado de baja")) ? "Se ha dado de baja" : "Despachador activado";
        JOptionPane.showMessageDialog(null, mensajeConfirmacion);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public DefaultTableModel buscarDespachador(Connection cnx, String filtro) {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("CI del despachador");
    modelo.addColumn("RUC proveedor");
    modelo.addColumn("Estado");

    try {
        String buscarSQL = "SELECT ci_despachador, idProveedor, estado_despachador FROM despachadores WHERE ci_despachador LIKE ?";
        PreparedStatement buscarStmt = cnx.prepareStatement(buscarSQL);
        buscarStmt.setString(1, "%" + filtro + "%");

        try (ResultSet resultSet = buscarStmt.executeQuery()) {
            while (resultSet.next()) {
                String ciDespachador = resultSet.getString("ci_despachador");
                String rucProveedor = resultSet.getString("idProveedor");
                String estadoDespachador = resultSet.getString("estado_despachador");

                modelo.addRow(new Object[]{ciDespachador, rucProveedor, estadoDespachador});
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return modelo;
}
    
    public DefaultTableModel buscarProveedor(Connection cnx, String filtro) {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("RUC proveedor");
    modelo.addColumn("Estado");
    try {
        String buscarSQL = "SELECT ruc, estado_empresa FROM proveedores WHERE ruc LIKE ?";
        PreparedStatement buscarStmt = cnx.prepareStatement(buscarSQL);
        buscarStmt.setString(1, "%" + filtro + "%");

        try (ResultSet resultSet = buscarStmt.executeQuery()) {
            while (resultSet.next()) {
                String rucProveedor = resultSet.getString("ruc");
                String estadoDespachador = resultSet.getString("estado_empresa");
                modelo.addRow(new Object[]{rucProveedor, estadoDespachador});
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return modelo;
}
    
   public void actualizarTablas(Connection cnx, String rucProveedor, String nombreEmpresa, String numeroTelefono, String CIdespachador) {
    try {
        boolean actualizarProveedores = !nombreEmpresa.isEmpty();
        boolean actualizarDespachadores = !numeroTelefono.isEmpty();
        if (!actualizarProveedores && !actualizarDespachadores) {
            JOptionPane.showMessageDialog(null, "No se proporcionaron datos para actualizar", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Actualizar la tabla proveedores si se proporciona el RUC
        if (actualizarProveedores) {
            String updateProveedoresQuery = "UPDATE proveedores SET nombre_empresa = ? WHERE ruc = ?";
            try (PreparedStatement pstmtProveedores = cnx.prepareStatement(updateProveedoresQuery)) {
                pstmtProveedores.setString(1, nombreEmpresa);
                pstmtProveedores.setString(2, rucProveedor);
                pstmtProveedores.executeUpdate();
            }
        }

        // Actualizar la tabla despachadores si se proporciona el CI del despachador
        if (actualizarDespachadores) {
            String updateDespachadoresQuery = "UPDATE despachadores SET numero_telefono = ? WHERE ci_despachador = ?";
            try (PreparedStatement pstmtDespachadores = cnx.prepareStatement(updateDespachadoresQuery)) {
                pstmtDespachadores.setString(1, numeroTelefono);
                pstmtDespachadores.setString(2, CIdespachador);
                pstmtDespachadores.executeUpdate();
            }
        }

        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al intentar actualizar las tablas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    
    

}
