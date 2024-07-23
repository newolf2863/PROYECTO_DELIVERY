/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_ecomienda.BDYValidaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class RegistrarDatosFactura {

    public static void actualizarEstadoFactura(Connection cnx, int numeroFactura, String estadoPago) {
        try {
            // Crear la sentencia SQL para actualizar el estado de pago en la tabla factura
            String sql = "UPDATE factura SET estadoPago = ? WHERE idFactura = ?";

            // Preparar la declaración SQL
            PreparedStatement pstmt = cnx.prepareStatement(sql);

            // Establecer los valores de los parámetros en la sentencia SQL
            pstmt.setString(1, estadoPago);
            pstmt.setInt(2, numeroFactura);

            // Ejecutar la actualización
            int filasActualizadas = pstmt.executeUpdate();

            // Verificar si la actualización fue exitosa
            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "La factura se registro correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la factura con el número proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Cerrar la conexión
            pstmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la factura: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static class PreciosTotales {
    private double precioTotalConIVA;
    private double precioTotalSinIVA;

    public PreciosTotales(double precioTotalConIVA, double precioTotalSinIVA) {
        this.precioTotalConIVA = precioTotalConIVA;
        this.precioTotalSinIVA = precioTotalSinIVA;
    }

    public String getPrecioTotalConIVADisplay() {
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(precioTotalConIVA);
    }

    public String getPrecioTotalSinIVADisplay() {
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(precioTotalSinIVA);
    }
}


    public static int obtenerNuevoNumeroFactura(Connection cnx) {
        int nuevoNumeroFactura = 0;
        try {
            String consulta = "SELECT COALESCE(MAX(idFactura), 0) AS max_id FROM factura";
            PreparedStatement stmt = cnx.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                nuevoNumeroFactura = maxId + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja cualquier error de conexión o consulta aquí
        }
        return nuevoNumeroFactura;
    }

    public static void insertarFactura(Connection connection, int idFactura, String fechaEmision, String rucNegocio,
            String idCliente, String estadoPago, double porcentajeIVA) {
        try {
            String insertFacturaQuery = "INSERT INTO factura (idFactura, fechaEmision, estadoFactura, ruc_negocio, idCliente, estadoPago, porcentajeIVA) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertFacturaStatement = connection.prepareStatement(insertFacturaQuery);
            insertFacturaStatement.setInt(1, idFactura);
            insertFacturaStatement.setString(2, fechaEmision);
            insertFacturaStatement.setString(3, "Activo"); // Estado de la factura
            insertFacturaStatement.setString(4, rucNegocio);
            insertFacturaStatement.setString(5, idCliente);
            insertFacturaStatement.setString(6, estadoPago); // Estado de pago variable
            insertFacturaStatement.setDouble(7, porcentajeIVA);
            insertFacturaStatement.executeUpdate();
            insertFacturaStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores...
        }
    }

    public static void insertarDatosNegocio(Connection connection, String rucNegocio, String nombreNegocio,
            String direccionNegocio, String telefonoNegocio) throws SQLException {
        String selectNegocioQuery = "SELECT ruc_negocio FROM negocio WHERE ruc_negocio = ?";
        PreparedStatement selectNegocioStatement = connection.prepareStatement(selectNegocioQuery);
        selectNegocioStatement.setString(1, rucNegocio);
        ResultSet negocioResult = selectNegocioStatement.executeQuery();

        if (!negocioResult.next()) {
            String insertNegocioQuery = "INSERT INTO negocio (ruc_negocio, nombreNegocio, direccionNegocio, telefonoNegocio) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement insertNegocioStatement = connection.prepareStatement(insertNegocioQuery);
            insertNegocioStatement.setString(1, rucNegocio);
            insertNegocioStatement.setString(2, nombreNegocio);
            insertNegocioStatement.setString(3, direccionNegocio);
            insertNegocioStatement.setString(4, telefonoNegocio);
            insertNegocioStatement.executeUpdate();
            insertNegocioStatement.close();
        }
    }

    public static void insertarDatosNegocioC(Connection connection, String ruc_negocio_c, String nombreNegocio,
            String direccionNegocio, String telefonoNegocio) throws SQLException {
        String selectNegocioQuery = "SELECT ruc_negocio_c FROM negocio_copia WHERE ruc_negocio_c = ?";
        PreparedStatement selectNegocioStatement = connection.prepareStatement(selectNegocioQuery);
        selectNegocioStatement.setString(1, ruc_negocio_c);
        ResultSet negocioResult = selectNegocioStatement.executeQuery();

        if (!negocioResult.next()) {
            String insertNegocioQuery = "INSERT INTO negocio_copia (ruc_negocio_c, nombreNegocio, direccionNegocio, telefonoNegocio) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement insertNegocioStatement = connection.prepareStatement(insertNegocioQuery);
            insertNegocioStatement.setString(1, ruc_negocio_c);
            insertNegocioStatement.setString(2, nombreNegocio);
            insertNegocioStatement.setString(3, direccionNegocio);
            insertNegocioStatement.setString(4, telefonoNegocio);
            insertNegocioStatement.executeUpdate();
            insertNegocioStatement.close();
        }
    }

    public static void insertarDatosCliente(Connection connection, String idCliente, String nombres,
            String apellidos, String telefonoCliente,
            String direccionCliente, String esExtranjero, String tipo, String correoElectronicoCliente) throws SQLException {
        String selectClienteQuery = "SELECT idCliente FROM cliente WHERE idCliente = ?";
        PreparedStatement selectClienteStatement = connection.prepareStatement(selectClienteQuery);
        selectClienteStatement.setString(1, idCliente);
        ResultSet clienteResult = selectClienteStatement.executeQuery();

        if (!clienteResult.next()) {
            String insertClienteQuery = "INSERT INTO cliente (idCliente, nombres, apellidos, telefonoCliente, direccionCliente, esExtranjero, tipo, correoElectronicoCliente) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement insertClienteStatement = connection.prepareStatement(insertClienteQuery)) {
                insertClienteStatement.setString(1, idCliente);
                insertClienteStatement.setString(2, nombres);
                insertClienteStatement.setString(3, apellidos);
                insertClienteStatement.setString(4, telefonoCliente);
                insertClienteStatement.setString(5, direccionCliente);
                insertClienteStatement.setString(6, esExtranjero);
                insertClienteStatement.setString(7, tipo);
                insertClienteStatement.setString(8, correoElectronicoCliente);
                insertClienteStatement.executeUpdate();
            }
        }
    }

    public static String obtenerEstadoCliente(Connection cnx, String cicliente) {
        String estado = "Desconocido";
        try {
            // Crear una sentencia SQL parametrizada para evitar la inyección de SQL
            String sql = "SELECT estadoCliente FROM cliente WHERE idCliente = ?";
            try (PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
                preparedStatement.setString(1, cicliente);
                try ( // Ejecutar la consulta
                        ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        estado = rs.getString("estadoCliente");
                    } else {
                        estado = "Desconocido";
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el estado del cliente desde la base de datos: " + e.getMessage());
        }
        return estado;
    }

    public static void cambiarEstadoCliente(Connection cnx, String cicliente, String nuevoEstado) {
        try {
            // Sentencia SQL para actualizar el estado del cliente al nuevo estado
            String sql = "UPDATE cliente SET estadoCliente = ? WHERE idCliente = ?";
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setString(1, nuevoEstado);
            preparedStatement.setString(2, cicliente);
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

    public static void insertarDatosClienteC(Connection connection, String idCliente_c, String nombres,
            String apellidos, String telefonoCliente,
            String direccionCliente, String esExtranjero, String tipo, String correoElectronicoCliente) throws SQLException {
        String selectClienteQuery = "SELECT idCliente_c FROM cliente_copia WHERE idCliente_c = ?";
        PreparedStatement selectClienteStatement = connection.prepareStatement(selectClienteQuery);
        selectClienteStatement.setString(1, idCliente_c);
        ResultSet clienteResult = selectClienteStatement.executeQuery();

        if (!clienteResult.next()) {
            String insertClienteQuery = "INSERT INTO cliente_copia (idCliente_c, nombres, apellidos, telefonoCliente, direccionCliente, esExtranjero, tipo, correoElectronicoCliente) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertClienteStatement = connection.prepareStatement(insertClienteQuery);
            insertClienteStatement.setString(1, idCliente_c);
            insertClienteStatement.setString(2, nombres);
            insertClienteStatement.setString(3, apellidos);
            insertClienteStatement.setString(4, telefonoCliente);
            insertClienteStatement.setString(5, direccionCliente);
            insertClienteStatement.setString(6, esExtranjero);
            insertClienteStatement.setString(7, tipo);
            insertClienteStatement.setString(8, correoElectronicoCliente);
            insertClienteStatement.executeUpdate();
            insertClienteStatement.close();
        }
    }

    public static void insertarDatosFactura(Connection connection, int idFactura, String fechaEmision,
            String rucNegocio, String idCliente,
            double porcentajeIVA) throws SQLException {
        String insertFacturaQuery = "INSERT INTO factura (idFactura, fechaEmision, estadoFactura, ruc_negocio, idCliente, estadoPago, porcentajeIVA) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertFacturaStatement = connection.prepareStatement(insertFacturaQuery);
        insertFacturaStatement.setInt(1, idFactura);
        insertFacturaStatement.setString(2, fechaEmision);
        insertFacturaStatement.setString(3, "Activo"); // Estado de la factura
        insertFacturaStatement.setString(4, rucNegocio);
        insertFacturaStatement.setString(5, idCliente);
        insertFacturaStatement.setString(6, "Pendiente de Pago"); // Estado de pago variable
        insertFacturaStatement.setDouble(7, porcentajeIVA);
        insertFacturaStatement.executeUpdate();
        insertFacturaStatement.close();
    }

    public static void insertarDatosProforma(Connection connection, int idProforma, String fechaEmision,
            String rucNegocio_c, String idCliente_c,
            String estadoPago, double porcentajeIVA) throws SQLException {
        String insertFacturaQuery = "INSERT INTO Proforma (idProforma, fechaEmision, estadoFactura, ruc_negocio_c, idCliente_c, estadoPago, porcentajeIVA) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertFacturaStatement = connection.prepareStatement(insertFacturaQuery);
        insertFacturaStatement.setInt(1, idProforma);
        insertFacturaStatement.setString(2, fechaEmision);
        insertFacturaStatement.setString(3, "Activo"); // Estado de la factura
        insertFacturaStatement.setString(4, rucNegocio_c);
        insertFacturaStatement.setString(5, idCliente_c);
        insertFacturaStatement.setString(6, estadoPago); // Estado de pago variable
        insertFacturaStatement.setDouble(7, porcentajeIVA);
        insertFacturaStatement.executeUpdate();
        insertFacturaStatement.close();
    }

    public static boolean existeFactura(Connection connection, int idFactura) throws SQLException {
        String selectFacturaQuery = "SELECT idFactura FROM factura WHERE idFactura = ?";
        PreparedStatement selectFacturaStatement = connection.prepareStatement(selectFacturaQuery);
        selectFacturaStatement.setInt(1, idFactura);
        ResultSet facturaResult = selectFacturaStatement.executeQuery();

        return facturaResult.next();
    }

    public static void actualizarStockYMostrarMensaje(Connection connection, int idItem, int cantidad)
            throws SQLException {
        // Actualizar stock en la tabla item
        String updateStockQuery = "UPDATE item SET stock = stock - ? WHERE idItem = ?";
        PreparedStatement updateStockStatement = connection.prepareStatement(updateStockQuery);
        updateStockStatement.setInt(1, cantidad);
        updateStockStatement.setInt(2, idItem);
        updateStockStatement.executeUpdate();
        updateStockStatement.close();

        JOptionPane.showMessageDialog(null, "Producto agregado con éxito");

    }

    public static void actualizarStockYMostrarMensajeP(Connection connection, int idItem_copia, int cantidad)
            throws SQLException {
        // Actualizar stock en la tabla item
        String updateStockQuery = "UPDATE item_copia SET stock = stock - ? WHERE idItem_copia = ?";
        PreparedStatement updateStockStatement = connection.prepareStatement(updateStockQuery);
        updateStockStatement.setInt(1, cantidad);
        updateStockStatement.setInt(2, idItem_copia);
        updateStockStatement.executeUpdate();
        updateStockStatement.close();
        JOptionPane.showMessageDialog(null, "Producto agregado con éxito");
    }

    public static void insertarDetalleFactura(Connection connection, int idFactura, int idItem,
            int cantidad, double precioUnitario, double subtotal)
            throws SQLException {
        String insertDetalleQuery = "INSERT INTO detalle_factura (idFactura, idItem, cantidad, precioUnitario, subtotal) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement insertDetalleStatement = connection.prepareStatement(insertDetalleQuery);
        insertDetalleStatement.setInt(1, idFactura);
        insertDetalleStatement.setInt(2, idItem);
        insertDetalleStatement.setInt(3, cantidad);
        insertDetalleStatement.setDouble(4, precioUnitario);
        insertDetalleStatement.setDouble(5, subtotal);
        insertDetalleStatement.executeUpdate();
        insertDetalleStatement.close();
    }

    public static void insertarDetalleFacturaC(Connection connection, int idProforma, int idItem_copia,
            int cantidad, double precioUnitario, double subtotal)
            throws SQLException {
        String insertDetalleQuery = "INSERT INTO detalle_proforma (idProforma, idItem_copia, cantidad, precioUnitario, subtotal) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement insertDetalleStatement = connection.prepareStatement(insertDetalleQuery);
        insertDetalleStatement.setInt(1, idProforma);
        insertDetalleStatement.setInt(2, idItem_copia);
        insertDetalleStatement.setInt(3, cantidad);
        insertDetalleStatement.setDouble(4, precioUnitario);
        insertDetalleStatement.setDouble(5, subtotal);
        insertDetalleStatement.executeUpdate();
        insertDetalleStatement.close();
    }



public static PreciosTotales obtenerPreciosTotales(Connection connection, int idFactura) throws SQLException {
    String selectPrecioTotalConIVA = "SELECT \"Precio Total con IVA\" FROM vista_total_compras WHERE idFactura = ?";
    String selectPrecioTotalSinIVA = "SELECT \"Precio Total sin IVA\" FROM vista_total_compras WHERE idFactura = ?";

    PreparedStatement selectPrecioConIVAStatement = connection.prepareStatement(selectPrecioTotalConIVA);
    PreparedStatement selectPrecioSinIVAStatement = connection.prepareStatement(selectPrecioTotalSinIVA);

    selectPrecioConIVAStatement.setInt(1, idFactura);
    selectPrecioSinIVAStatement.setInt(1, idFactura);

    ResultSet precioConIVAResult = selectPrecioConIVAStatement.executeQuery();
    ResultSet precioSinIVAResult = selectPrecioSinIVAStatement.executeQuery();

    double precioTotalConIVA = 0.00;
    double precioTotalSinIVA = 0.00;

    if (precioConIVAResult.next()) {
        precioTotalConIVA = precioConIVAResult.getDouble("Precio Total con IVA");
        // Formatear el valor con DecimalFormat
        DecimalFormat df = new DecimalFormat("#0.00");
        String formattedPrecioConIVA = df.format(precioTotalConIVA);
        precioTotalConIVA = Double.parseDouble(formattedPrecioConIVA);
    }

    if (precioSinIVAResult.next()) {
        precioTotalSinIVA = precioSinIVAResult.getDouble("Precio Total sin IVA");
        // Formatear el valor con DecimalFormat
        DecimalFormat df = new DecimalFormat("#0.00");
        String formattedPrecioSinIVA = df.format(precioTotalSinIVA);
        precioTotalSinIVA = Double.parseDouble(formattedPrecioSinIVA);
    }

    return new PreciosTotales(precioTotalConIVA, precioTotalSinIVA);
}


    public static PreciosTotales obtenerPreciosTotalesC(Connection connection, int idProforma) throws SQLException {
        String selectPrecioTotalConIVA = "SELECT \"Precio Total con IVA\" FROM vista_total_proformas WHERE idProforma = ?";
        String selectPrecioTotalSinIVA = "SELECT \"Precio Total sin IVA\" FROM vista_total_proformas WHERE idProforma = ?";

        PreparedStatement selectPrecioConIVAStatement = connection.prepareStatement(selectPrecioTotalConIVA);
        PreparedStatement selectPrecioSinIVAStatement = connection.prepareStatement(selectPrecioTotalSinIVA);

        selectPrecioConIVAStatement.setInt(1, idProforma);
        selectPrecioSinIVAStatement.setInt(1, idProforma);

        ResultSet precioConIVAResult = selectPrecioConIVAStatement.executeQuery();
        ResultSet precioSinIVAResult = selectPrecioSinIVAStatement.executeQuery();

        double precioTotalConIVA = 0.00;
        double precioTotalSinIVA = 0.00;
        if (precioConIVAResult.next()) {
            precioTotalConIVA = precioConIVAResult.getDouble("Precio Total con IVA");
        }
        if (precioSinIVAResult.next()) {
            precioTotalSinIVA = precioSinIVAResult.getDouble("Precio Total sin IVA");
        }
        return new PreciosTotales(precioTotalConIVA, precioTotalSinIVA);
    }

    public static void quitarDetalleFactura(Connection connection, int idDetalle) throws SQLException {
        String deleteDetalleQuery = "DELETE FROM detalle_factura WHERE idDetalle = ?";
        PreparedStatement deleteDetalleStatement = connection.prepareStatement(deleteDetalleQuery);
        deleteDetalleStatement.setInt(1, idDetalle);
        deleteDetalleStatement.executeUpdate();
        deleteDetalleStatement.close();
    }

    public static void quitarDetalleFacturaC(Connection connection, int idDetalle_proforma) throws SQLException {
        String deleteDetalleQuery = "DELETE FROM detalle_proforma WHERE idDetalle_proforma = ?";
        PreparedStatement deleteDetalleStatement = connection.prepareStatement(deleteDetalleQuery);
        deleteDetalleStatement.setInt(1, idDetalle_proforma);
        deleteDetalleStatement.executeUpdate();
        deleteDetalleStatement.close();
    }

    public static void actualizarStock(Connection connection, int idItem, int cantidad) throws SQLException {
        String updateStockQuery = "UPDATE item SET stock = stock + ? WHERE idItem = ?";
        PreparedStatement updateStockStatement = connection.prepareStatement(updateStockQuery);
        updateStockStatement.setInt(1, cantidad);
        updateStockStatement.setInt(2, idItem);
        updateStockStatement.executeUpdate();
        updateStockStatement.close();
    }

    public static void actualizarStockC(Connection connection, int idItem_copia, int cantidad) throws SQLException {
        String updateStockQuery = "UPDATE item_copia SET stock = stock + ? WHERE idItem_copia = ?";
        PreparedStatement updateStockStatement = connection.prepareStatement(updateStockQuery);
        updateStockStatement.setInt(1, cantidad);
        updateStockStatement.setInt(2, idItem_copia);
        updateStockStatement.executeUpdate();
        updateStockStatement.close();
    }

    public boolean clienteYaRegistrado(Connection connection, String idCliente) {
        try {
            // Prepara la consulta SQL para verificar si el cliente ya está registrado
            String consulta = "SELECT COUNT(*) FROM cliente WHERE idCliente = ?";
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, idCliente);

            // Ejecuta la consulta
            ResultSet rs = stmt.executeQuery();

            // Verifica si el cliente ya está registrado
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }

            // Cierra recursos
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Manejo de excepciones en caso de error de consulta
            e.printStackTrace();
        }

        // Si llegamos aquí o hubo un error o el cliente no está registrado
        return false;
    }

}
