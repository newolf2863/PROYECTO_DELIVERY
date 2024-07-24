/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_ecomienda.BDYValidaciones;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarBD {

    public static boolean existenRegistrosProductos(Connection cnx, int idFactura) {
        String consulta = "SELECT COUNT(*) FROM vista_compras_cliente_agrupada WHERE idFactura = ?";

        try {
            PreparedStatement stmt = cnx.prepareStatement(consulta);
            stmt.setInt(1, idFactura);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int totalRegistros = rs.getInt(1);

                return totalRegistros > 0;
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static DefaultTableModel consultarInventario(Connection cnx, String campo, String valor) {
        DefaultTableModel modelo = new DefaultTableModel(null, new String[]{"ID Ítem", "Nonbre del ítem", "Stock", "Precio", "Estado"});

        String sql;
        if (campo.equals("idItem")) {
            if (valor.equals("null")) {
                sql = "SELECT * FROM item WHERE " + campo + " IS NULL";
            } else {
                sql = "SELECT * FROM item WHERE " + campo + " = " + valor
                        + " OR CAST(" + campo + " AS TEXT) LIKE '%" + valor + "%'";
            }
        } else if (campo.equals("stock") || campo.equals("precio")) {
            sql = "SELECT * FROM item WHERE " + campo + " = " + valor;
        } else {
            if (valor.equals("null")) {
                sql = "SELECT * FROM item WHERE " + campo + " IS NULL";
            } else {
                sql = "SELECT * FROM item WHERE " + campo + " LIKE '%" + valor + "%'";
            }
        }

        sql = sql + "Order by idItem";
        try {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idItem"),
                    rs.getString("nombreItem"),
                    rs.getBigDecimal("stock"),
                    rs.getBigDecimal("precio"),
                    rs.getString("estado")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta");
        }

        return modelo;
    }

    public static DefaultTableModel consultarHistorialF(Connection cnx, String campo, String valor) {
        DefaultTableModel modelo = new DefaultTableModel(null, new String[]{"idFactura", "fechaEmision",
            "idCliente", "nombres", "apellidos", "Precio Total con IVA", "estadoFactura", "estadoPago"});

        String sql;
        if (campo.equals("idFactura")) {
            if (valor.equals("null")) {
                sql = "SELECT * FROM vista_datos_f WHERE " + campo + " IS NULL";
            } else {
                sql = "SELECT * FROM vista_datos_f WHERE " + campo + " = " + valor
                        + " OR CAST(" + campo + " AS TEXT) LIKE '%" + valor + "%'";
            }
        } else if (campo.equals("Precio Total con IVA")) {
            sql = "SELECT * FROM vista_datos_f WHERE \"" + campo + "\" = " + valor;
        } else {
            if (valor.equals("null")) {
                sql = "SELECT * FROM vista_datos_f WHERE " + campo + " IS NULL";
            } else {
                sql = "SELECT * FROM vista_datos_f WHERE " + campo + " LIKE '%" + valor + "%'";
            }
        }

        //("Consulta SQL: " + sql);
        try {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idFactura"),
                    rs.getString("fechaEmision"),
                    rs.getString("idCliente"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getBigDecimal("Precio Total con IVA"),
                    rs.getString("estadoFactura"),
                    rs.getString("estadoPago")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta");
        }

        return modelo;
    }

    public static DefaultTableModel buscarElementoPorId(Connection cnx, String idItemStr) {
        DefaultTableModel modelo = new DefaultTableModel(null, new String[]{"idItem", "nombreItem", "stock", "precio", "estado"});

        String sql = "SELECT * FROM item WHERE idItem = " + idItemStr + " OR CAST(idItem AS TEXT) LIKE '%" + idItemStr + "%'";

        try (Statement stmt = cnx.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idItem"),
                    rs.getString("nombreItem"),
                    rs.getBigDecimal("stock"),
                    rs.getBigDecimal("precio"),
                    rs.getString("estado")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el elemento por ID.");
        }

        return modelo;
    }

    public static DefaultTableModel consultar(Connection cnx, String campo, String valor) throws SQLException {
        String[] nombresColumnas = {"idItem", "nombreItem", "stock", "precio", "estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT * FROM item WHERE " + campo + " LIKE ?";

        try (PreparedStatement pst = cnx.prepareStatement(sql)) {
            pst.setString(1, "%" + valor + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idItem"),
                    rs.getString("nombreItem"),
                    rs.getBigDecimal("stock"),
                    rs.getBigDecimal("precio"),
                    rs.getString("estado")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta");
        }

        return modelo;
    }

    public static DefaultTableModel buscarAtributoPorId(Connection connection, String campo, String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");

        // Renombrar la columna según el valor de campo
        if (campo.equals("nombreItem")) {
            modelo.addColumn("Nombre del ítem");
        } else if (campo.equals("stock")) {
            modelo.addColumn("Stock");
        } else if (campo.equals("precio")) {
            modelo.addColumn("Precio");
        } else {

            modelo.addColumn(campo); // Mantener el nombre original si no coincide con las opciones anteriores
        }

        String sql = "SELECT idItem, " + campo + " FROM item WHERE idItem = ?";
        try {
            int idItemValue = Integer.parseInt(valor);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idItemValue);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object[] fila = new Object[2]; // Dos columnas en la tabla
                fila[0] = resultSet.getInt("idItem");
                fila[1] = resultSet.getObject(campo);
                modelo.addRow(fila);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción de alguna manera adecuada
        }

        return modelo;
    }

    public static DefaultTableModel consultarUser(Connection cnx, String campo, String valor) {
        // Consulta SQL parametrizada para buscar en la tabla usuarios utilizando LIKE
        String consulta = "SELECT * FROM usuarios WHERE " + campo + " LIKE ?";

        try {
            PreparedStatement ps = cnx.prepareStatement(consulta);
            // Agregamos los símbolos '%' alrededor del valor para buscar coincidencias parciales
            ps.setString(1, "%" + valor + "%");

            ResultSet rs = ps.executeQuery();

            // Creamos un DefaultTableModel para mostrar los resultados en una tabla
            DefaultTableModel modelo = new DefaultTableModel();

            // Añadimos las columnas al modelo (ajusta esto según tus necesidades)
            modelo.addColumn("ID");
            modelo.addColumn("Nombre de usuario");
            modelo.addColumn("CI");
            modelo.addColumn("Rol");
            modelo.addColumn("Estado");

            // Iteramos a través de los resultados y añadimos filas al modelo
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("idUsuario"),
                    rs.getString("nombreUser"),
                    rs.getString("CI"),
                    rs.getString("rol"),
                    rs.getString("estado")
                });
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + e.getMessage());
            // En caso de error, devolvemos un modelo vacío en lugar de null
            return new DefaultTableModel();
        }
    }

    public static DefaultTableModel buscarPaquetePorId(Connection conexion, int idPaquete) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IDPaquete");
        modelo.addColumn("Peso");
        modelo.addColumn("Ancho");
        modelo.addColumn("Largo");
        modelo.addColumn("Contenido");
        modelo.addColumn("Remitente");
        modelo.addColumn("DireccionDestino");
        modelo.addColumn("Estado");
        modelo.addColumn("FechaEnvio");

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Consulta usando ILIKE para búsqueda parcial
            String sql = "SELECT * FROM Paquete WHERE CAST(IDPaquete AS TEXT) ILIKE ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, "%" + idPaquete + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[9];
                fila[0] = rs.getInt("IDPaquete");
                fila[1] = rs.getBigDecimal("peso");
                fila[2] = rs.getBigDecimal("ancho");
                fila[3] = rs.getBigDecimal("largo");
                fila[4] = rs.getString("contenido");
                fila[5] = rs.getString("remitente");
                fila[6] = rs.getString("direccionDestino");
                fila[7] = rs.getString("estado");
                fila[8] = rs.getTimestamp("fechaEnvio");

                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return modelo;
    }

}
