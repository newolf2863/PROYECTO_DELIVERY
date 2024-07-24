/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_ecomienda.BDYValidaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class CreadorTablas {

    PreparedStatement ps = (null);
    
public DefaultTableModel mostrarTablaPaquetes(Connection c) {
    String[] nombresColumnas = {"IDPaquete", "Peso", "Ancho", "Largo", "Contenido", "Remitente", "Direccion-Destino", "Estado", "Fecha de envio"};
    DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
    String sql = "SELECT IDPaquete, peso, ancho, largo, contenido, remitente, direccionDestino, estado, fechaEnvio FROM Paquete ORDER BY IDPaquete";

    try (PreparedStatement pst = c.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
        while (rs.next()) {
            Object[] fila = {
                rs.getInt("IDPaquete"),
                rs.getBigDecimal("peso"),
                rs.getBigDecimal("ancho"),
                rs.getBigDecimal("largo"),
                rs.getString("contenido"),
                rs.getString("remitente"),
                rs.getString("direccionDestino"),
                rs.getString("estado"),
                rs.getTimestamp("fechaEnvio")
            };
            modelo.addRow(fila);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al conectar");
        e.printStackTrace();
    }

    return modelo;
}

    public DefaultTableModel mostrarTablaItems(Connection c) {
        String[] nombresColumnas = {"idItem", "nombreItem", "stock", "precio", "estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT * FROM item ORDER BY idItem"; // Cambia la consulta para obtener los datos de la tabla "item"

        try (PreparedStatement pst = c.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Object[] fila = {
                    rs.getBigDecimal("idItem"),
                    rs.getString("nombreItem"),
                    rs.getBigDecimal("stock"),
                    rs.getBigDecimal("precio"),
                    rs.getString("estado")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

        return modelo;
    }

    public DefaultTableModel mostrarTablaClientes(Connection c) {
        String[] nombresColumnas = {"idCliente", "nombres", "apellidos", "telefonoCliente", "direccionCliente"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT idCliente, nombres, apellidos, telefonoCliente, direccionCliente FROM cliente ORDER BY idCliente";

        try (PreparedStatement pst = c.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Object[] fila = {
                    rs.getString("idCliente"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("telefonoCliente"),
                    rs.getString("direccionCliente")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

        return modelo;
    }

    public DefaultTableModel mostrarClienteParametrizado(Connection c, String filtroIdCliente, String estado) {
        String[] nombresColumnas = {"ID Cliente", "Nombres",
            "Apellidos", "Teléfono movíl", "Dirección",
            "Nacionalidad", "Tipo", "Correo electronico"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "";
        if (estado.equals("Todos")) {
            sql = "SELECT idCliente, nombres, apellidos, telefonoCliente,"
                    + " direccionCliente,esExtranjero,tipo,correoElectronicoCliente "
                    + "FROM cliente WHERE idCliente LIKE ? ORDER BY idCliente";

        } else {
            sql = "SELECT idCliente, nombres, apellidos, telefonoCliente,"
                    + " direccionCliente,esExtranjero,tipo,correoElectronicoCliente "
                    + "FROM cliente WHERE estadoCliente = 'Activo' AND idCliente LIKE ? ORDER BY idCliente";
        }
        try (PreparedStatement pst = c.prepareStatement(sql)) {
            pst.setString(1, "%" + filtroIdCliente + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] fila = {
                    rs.getString("idCliente"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("telefonoCliente"),
                    rs.getString("direccionCliente"),
                    rs.getString("esExtranjero"),
                    rs.getString("tipo"),
                    rs.getString("correoElectronicoCliente")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

        return modelo;
    }

    public DefaultTableModel mostrarTipoCliente(Connection c, String esExtranjero, String tipoCliente, String idCliente) {
        String[] nombresColumnas = {"ID", "Nombres", "Apellidos",
            "Teléfono", "Dirección", "Correo Electrónico",
            "Nacionalidad", "Tipo", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String consulta = "SELECT idCliente, nombres, apellidos, telefonoCliente"
                + ", direccionCliente, esExtranjero ,tipo, correoElectronicoCliente, estadoCliente FROM cliente WHERE 1 = 1";

        // Condición para esExtranjero (si se proporciona)
        if (esExtranjero != null && !esExtranjero.isEmpty()) {
            consulta += " AND esExtranjero = ?";
        }

        // Condición para tipoCliente (si se proporciona)
        if (tipoCliente != null && !tipoCliente.isEmpty()) {
            consulta += " AND tipo = ?";
        }

        // Condición para idCliente (si se proporciona)
        if (idCliente != null && !idCliente.isEmpty()) {
            consulta += " AND idCliente LIKE ?";
        }

        try {
            PreparedStatement ps = c.prepareStatement(consulta);
            int parametro = 1; // Contador para los parámetros
            if (esExtranjero != null && !esExtranjero.isEmpty()) {
                ps.setString(parametro++, esExtranjero);
            }
            if (tipoCliente != null && !tipoCliente.isEmpty()) {
                ps.setString(parametro++, tipoCliente);
            }
            if (idCliente != null && !idCliente.isEmpty()) {
                ps.setString(parametro++, "%" + idCliente + "%"); // Agrega los símbolos % al patrón
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = {
                    rs.getString("idCliente"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("telefonoCliente"),
                    rs.getString("direccionCliente"),
                    rs.getString("esExtranjero"),
                    rs.getString("tipo"),
                    rs.getString("correoElectronicoCliente"),
                    rs.getString("estadoCliente")
                };
                // Agrega una fila al modelo de tabla con los datos obtenidos de la consulta
                modelo.addRow(fila);
            }

            // Cerrar recursos
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelo;
    }

    public DefaultTableModel mostrarTablaNegocios(Connection c, String filtro) {
        String[] nombresColumnas = {"ruc_negocio", "nombreNegocio", "direccionNegocio", "telefonoNegocio"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT ruc_negocio, nombreNegocio, direccionNegocio, telefonoNegocio FROM negocio WHERE ruc_negocio LIKE ? ORDER BY ruc_negocio";

        try (PreparedStatement pst = c.prepareStatement(sql)) {
            pst.setString(1, "%" + filtro + "%"); // Usamos LIKE para buscar parcialmente el ruc_negocio
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] fila = {
                    rs.getString("ruc_negocio"),
                    rs.getString("nombreNegocio"),
                    rs.getString("direccionNegocio"),
                    rs.getString("telefonoNegocio")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

        return modelo;
    }

    public DefaultTableModel mostrarTablaItemsID(Connection c, String idItemFilter, String campo, String iditemC, String tabla, String order) {
        String[] nombresColumnas = {"ID ítem", "Nombre ítem", "Stock", "Precio"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "";
        if (campo.equals("nombreItem")) {
            sql = "SELECT * FROM " + tabla + " WHERE nombreItem LIKE ? AND estado = 'Activo' ORDER BY " + order;
        } else {
            if (campo.equals(iditemC)) {
                sql = "SELECT * FROM " + tabla + " WHERE CAST(" + iditemC + " AS TEXT) LIKE ? AND estado = 'Activo' ORDER BY " + order;
            }
        }

        try (PreparedStatement pst = c.prepareStatement(sql)) {
            if (campo.equals("nombreItem")) {
                pst.setString(1, "%" + idItemFilter + "%");
            } else {
                if (campo.equals(iditemC)) {
                    pst.setString(1, "%" + idItemFilter + "%");
                }
            }
            // Aplicar el filtro de idItem
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] fila = {
                    rs.getBigDecimal(iditemC),
                    rs.getString("nombreItem"),
                    rs.getBigDecimal("stock"),
                    rs.getBigDecimal("precio"), //rs.getString("estado")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }
        return modelo;
    }

    public DefaultTableModel mostrarTablaFacturas(Connection c, String numeroFacturaFilter) {
        String[] nombresColumnas = {"N°Factura", "Fecha emision", "RUC Negocio", "ID Cliente", "Estado de Pago", "Porcentaje IVA"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT idFactura, fechaEmision, ruc_negocio, idCliente, estadoPago, porcentajeIVA "
                + "FROM factura WHERE CAST(idFactura AS TEXT) LIKE ? AND estadoFactura = 'Activo' ORDER BY idFactura";

        try (PreparedStatement pst = c.prepareStatement(sql)) {
            pst.setString(1, "%" + numeroFacturaFilter + "%"); // Aplicar el filtro de número de factura
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idFactura"),
                    rs.getString("fechaEmision"),
                    rs.getString("ruc_negocio"),
                    rs.getString("idCliente"),
                    rs.getString("estadoPago"),
                    rs.getBigDecimal("porcentajeIVA")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

        return modelo;
    }

    public DefaultTableModel mostrarTablaFacturasTodas(Connection c, String numeroFacturaFilter) {
        String[] nombresColumnas = {"N°Factura", "Fecha emision", "estadoFactura", "RUC Negocio", "ID Cliente", "Estado de Pago", "Porcentaje IVA"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT idFactura, fechaEmision, estadoFactura, ruc_negocio, idCliente, estadoPago, porcentajeIVA "
                + "FROM factura WHERE CAST(idFactura AS TEXT) LIKE ?  ORDER BY idFactura";

        try (PreparedStatement pst = c.prepareStatement(sql)) {
            pst.setString(1, "%" + numeroFacturaFilter + "%"); // Aplicar el filtro de número de factura
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idFactura"),
                    rs.getString("fechaEmision"),
                    rs.getString("estadoFactura"),
                    rs.getString("ruc_negocio"),
                    rs.getString("idCliente"),
                    rs.getString("estadoPago"),
                    rs.getBigDecimal("porcentajeIVA")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

        return modelo;
    }
    
    public DefaultTableModel mostrarTablaFacturasCanceladas(Connection c, String numeroFacturaFilter) {
    String[] nombresColumnas = {"N°Factura", "Fecha emision", "estadoFactura", "RUC Negocio", "ID Cliente", "Estado de Pago", "Porcentaje IVA"};
    DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
    String sql = "SELECT idFactura, fechaEmision, estadoFactura, ruc_negocio, idCliente, estadoPago, porcentajeIVA "
            + "FROM factura WHERE estadoPago = 'Cancelado' AND CAST(idFactura AS TEXT) LIKE ?  ORDER BY idFactura";

    try (PreparedStatement pst = c.prepareStatement(sql)) {
        pst.setString(1, "%" + numeroFacturaFilter + "%"); // Aplicar el filtro de número de factura
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Object[] fila = {
                rs.getInt("idFactura"),
                rs.getString("fechaEmision"),
                rs.getString("estadoFactura"),
                rs.getString("ruc_negocio"),
                rs.getString("idCliente"),
                rs.getString("estadoPago"),
                rs.getBigDecimal("porcentajeIVA")
            };
            modelo.addRow(fila);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al conectar");
    }

    return modelo;
}

    public DefaultTableModel mostrarFacturasActivas(Connection c, String numeroFacturaFilter) {
        String[] nombresColumnas = {"N°Factura", "Fecha emision", "estadoFactura", "RUC Negocio", "ID Cliente", "Estado de Pago", "Porcentaje IVA"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT idFactura, fechaEmision, estadoFactura, ruc_negocio, idCliente, estadoPago, porcentajeIVA "
                + "FROM factura WHERE CAST(idFactura AS TEXT) LIKE ?"
                + " and estadoPago Like 'Pendiente de Pago' and estadoFactura Like 'Activo' ORDER BY idFactura";

        try (PreparedStatement pst = c.prepareStatement(sql)) {
            pst.setString(1, "%" + numeroFacturaFilter + "%"); // Aplicar el filtro de número de factura
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idFactura"),
                    rs.getString("fechaEmision"),
                    rs.getString("estadoFactura"),
                    rs.getString("ruc_negocio"),
                    rs.getString("idCliente"),
                    rs.getString("estadoPago"),
                    rs.getBigDecimal("porcentajeIVA")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

        return modelo;
    }

    public DefaultTableModel mostrarTablaComprasClientePorId(Connection c, int idFactura) {
        String[] nombresColumnas = {"nombreItem", "cantidad", "precioUnitario", "total"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT * FROM vista_compras_cliente WHERE idFactura = ?"; // Filtrar por idFactura

        try (PreparedStatement pst = c.prepareStatement(sql)) {
            pst.setInt(1, idFactura); // Asignar el valor de idFactura al parámetro
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] fila = {
                    //rs.getInt("idFactura"),
                    //rs.getString("fechaEmision"),
                    //rs.getString("nombres"),
                    //rs.getString("apellidos"),                
                    //rs.getString("estadoFactura"),
                    rs.getString("nombreItem"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precioUnitario"),
                    rs.getBigDecimal("total"), //rs.getString("nombreNegocio")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

        return modelo;
    }

    public DefaultTableModel mostrarItemsID(Connection c, int idFactura) {
    String[] nombresColumnas = {"nombreItem", "cantidad_total", "precioUnitario", "total"};
    DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
    String sql = "SELECT * FROM vista_compras_cliente_agrupada WHERE idFactura = ?"; // Filtrar por idFactura

    try (PreparedStatement pst = c.prepareStatement(sql)) {
        pst.setInt(1, idFactura); // Asignar el valor de idFactura al parámetro
        ResultSet rs = pst.executeQuery();
        DecimalFormat df = new DecimalFormat("#0.00"); // Formato para los valores decimales

        while (rs.next()) {
            Object[] fila = {
                rs.getString("nombreItem"),
                rs.getInt("cantidad_total"),
                df.format(rs.getDouble("precioUnitario")), // Formatear el precioUnitario
                df.format(rs.getBigDecimal("total")) // Formatear el total
            };
            modelo.addRow(fila);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al conectar");
    }
    return modelo;
}

    public DefaultTableModel mostrarItemsIDC(Connection c, int idProforma) {
        String[] nombresColumnas = {"nombreItem", "cantidad_total", "precioUnitario", "total"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT * FROM vista_compras_proforma_agrupada WHERE idProforma = ?"; // Filtrar por idFactura

        try (PreparedStatement pst = c.prepareStatement(sql)) {
            pst.setInt(1, idProforma); // Asignar el valor de idFactura al parámetro
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] fila = {
                    rs.getString("nombreItem"),
                    rs.getInt("cantidad_total"),
                    rs.getDouble("precioUnitario"),
                    rs.getBigDecimal("total")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

        return modelo;
    }

    public DefaultTableModel crearModeloTabla(Connection cnx, String consultaSQL, String[] nombresColumnas) {
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        try {
            PreparedStatement pstmt = cnx.prepareStatement(consultaSQL);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idFactura"),
                    rs.getString("fechaEmision"),
                    rs.getInt("idCliente"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getDouble("Precio Total sin IVA"),
                    rs.getDouble("Precio Total con IVA"),
                    rs.getString("estadoFactura"),
                    rs.getString("estadoPago"), //rs.getString("Local")
                };
                modelo.addRow(fila);
            }

            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores
        }

        return modelo;
    }

    public DefaultTableModel mostrarTablaGanancia(Connection cnx) {
        String[] nombresColumnas = {"Año", "Mes", "Ganancia Neta", "Ganancia Bruta"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT año, mes_nombre, ganancia_neta, ganancia_bruta FROM gananciaM";
        try (PreparedStatement pst = cnx.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("año"),
                    rs.getString("mes_nombre"),
                    rs.getDouble("ganancia_neta"),
                    rs.getDouble("ganancia_bruta")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

        return modelo;
    }

    public DefaultTableModel mostrarTablaUsuarios(Connection c, String nombreUsuario) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre de Usuario");
        modelo.addColumn("CI");
        modelo.addColumn("Rol");
        modelo.addColumn("Estado");

        String query = "SELECT idUsuario, nombreUser, CI, rol, estado FROM usuarios "
                + "WHERE nombreUser like ? AND nombreUser <> 'administrador'";

        try (PreparedStatement statement = c.prepareStatement(query)) {
            statement.setString(1, "%" + nombreUsuario + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object[] fila = new Object[5];
                fila[0] = resultSet.getInt("idUsuario");
                fila[1] = resultSet.getString("nombreUser");
                fila[2] = resultSet.getString("CI");
                fila[3] = resultSet.getString("rol");
                fila[4] = resultSet.getString("estado");
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelo;
    }

    public DefaultTableModel mostrarTablaEmpleados(Connection cnx, String CIEmpleado) {
        String[] nombresColumnas = {"CI", "Nombres", "Apellidos", "Teléfono Móvil", "Cargo"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String query = "SELECT CI, nombres, apellidos, telefono_movil, cargo FROM empleados "
                + "WHERE CI LIKE ?";

        try (PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setString(1, "%" + CIEmpleado + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object[] fila = new Object[5];
                fila[0] = resultSet.getString("CI");
                fila[1] = resultSet.getString("nombres");
                fila[2] = resultSet.getString("apellidos");
                fila[3] = resultSet.getString("telefono_movil");
                fila[4] = resultSet.getString("cargo");
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelo;
    }

    public DefaultTableModel auditoria(Connection c, String nombreUsuario) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Auditoria");
    model.addColumn("Nombre Tabla");
    model.addColumn("Operación");
    model.addColumn("Valor Anterior");
    model.addColumn("Nuevo Valor");
    model.addColumn("Fecha de Actualización");
    model.addColumn("Usuario");
    try {
        String sql;
        PreparedStatement preparedStatement;
        
        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            // Si nombreUsuario es nulo o vacío, obtener todos los registros
            sql = "SELECT * FROM t_auditoria";
            preparedStatement = c.prepareStatement(sql);
        } else {
            // Si nombreUsuario tiene un valor, aplicar filtro
            sql = "SELECT * FROM t_auditoria WHERE usuario LIKE ?";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nombreUsuario + "%"); // Usamos % para buscar coincidencias parciales
        }

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int idAuditoria = resultSet.getInt("idauditoria");
            String nombreTabla = resultSet.getString("nombretabla");
            String operacion = resultSet.getString("operacion");
            String valorAnterior = resultSet.getString("valoranterior");
            String nuevoValor = resultSet.getString("nuevovalor");
            String fechaActualizacion = resultSet.getString("updatedate");
            String usuario = resultSet.getString("usuario");

            model.addRow(new Object[]{idAuditoria, nombreTabla, operacion, valorAnterior, nuevoValor, fechaActualizacion, usuario});
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return model;
}



}
