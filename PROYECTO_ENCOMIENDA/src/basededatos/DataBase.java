package basededatos;

/**
 *
 * @autor Moises Arequipa
 */
import GUI.JFPaquetes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mod_administracion.Cliente;
import mod_administracion.Conductor;
import mod_administracion.Recepcionista;
import mod_administracion.Usuario;
import mod_transporte.Provincia;

public class DataBase {
    private static DataBase instancia; // Instancia singleton de la clase
    private Connection conexion; // Conexión a la base de datos
    
    /**
     * Constructor privado para implementar el patrón Singleton
     */
    private DataBase() {
        // Parámetros de conexión a la base de datos
        String HOST = "localhost";
        String PUERTO = "5432";
        String DB = "paquetes";
        String USER = "administrador";
        String PASSWORD = "123";
        
        try {
            // Cargar el driver de PostgreSQL
            Class.forName("org.postgresql.Driver");
            // Crear la URL de conexión
            String url ="jdbc:postgresql://"+HOST+":"+PUERTO+"/"+DB;
            // Establecer la conexión
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (Exception e) {
            // Mostrar un mensaje de error en caso de fallo en la conexión
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * Obtener la instancia singleton de la clase
     * @return instancia de DataBase
     */
    public static DataBase obtenerInstancia() {
        if (instancia == null) {
            instancia = new DataBase();
        }
        return instancia;
    }
    
    /**
     * Comprobar las credenciales del usuario
     * @param username nombre de usuario
     * @param password contraseña
     * @return rol del usuario si las credenciales son correctas, null en caso contrario
     */
    public String comprobarCredencial(String username, String password) {
        String query = "SELECT rol FROM Credencial WHERE nombreUsuario = ? AND clave = ?";
        try {
            // Preparar la consulta SQL
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Devolver el rol del usuario si se encuentra una coincidencia
                    return rs.getString("rol");
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            // Registrar el error en el logger
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Obtener los datos del recepcionista a partir del nombre de usuario
     * @param username nombre de usuario
     * @return objeto Recepcionista con los datos del recepcionista
     */
    public Recepcionista obtenerRecepcionista(String username) {
        String query = "SELECT u.nombres, u.apellidos, u.cedula AS identificacion, u.direccion, u.telefono, u.email, c.provincia " +
               "FROM Usuario u " +
               "JOIN Credencial c ON u.id = c.usuario_id " +
               "WHERE c.nombreUsuario = ?";
        try {
            // Preparar la consulta SQL
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, username);
            Provincia sucursal = null;
            Class<?> enumClass;
            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    try {
                        // Obtener la sucursal (provincia) del recepcionista
                        enumClass = Class.forName("mod_transporte.Provincia");
                        sucursal = (Provincia) Enum.valueOf((Class<Enum>) enumClass, rs.getString("Provincia"));
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(JFPaquetes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // Crear y devolver el objeto Recepcionista
                    return new Recepcionista(
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("identificacion"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        sucursal
                    );
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Obtener los datos del conductor a partir del nombre de usuario
     * @param username nombre de usuario
     * @return objeto Conductor con los datos del conductor
     */
    public Conductor obtenerConductor(String username) {
        String query = "SELECT u.nombres, u.apellidos, u.cedula AS identificacion, u.direccion, u.telefono, u.email, c.provincia " +
               "FROM Usuario u " +
               "JOIN Credencial c ON u.id = c.usuario_id " +
               "WHERE c.nombreUsuario = ?";
        try {
            // Preparar la consulta SQL
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, username);
            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Crear y devolver el objeto Conductor
                    return new Conductor(
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("identificacion"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email")
                    );
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Obtener los datos de un cliente a partir de su cédula
     * @param cedula cédula del cliente
     * @return objeto Cliente con los datos del cliente
     */
    public Cliente obtenerDatosPorCedula(String cedula) {
        String query = "SELECT nombres, apellidos, cedula AS identificacion, direccion, telefono, email " +
                       "FROM Usuario " +
                       "WHERE cedula = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, cedula);
            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Crear y devolver el objeto Cliente
                    return new Cliente(
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("identificacion"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email")
                    );
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Obtener los datos de un conductor a partir de su cédula
     * @param cedula cédula del conductor
     * @return objeto Conductor con los datos del conductor
     */
    public Conductor obtenerConductorPorCedula(String cedula) {
        String query = "SELECT nombres, apellidos, cedula AS identificacion, direccion, telefono, email " +
                       "FROM Usuario " +
                       "WHERE cedula = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, cedula);
            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Crear y devolver el objeto Conductor
                    return new Conductor(
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("identificacion"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email")
                    );
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Registrar un nuevo cliente en la base de datos
     * @param nombres nombres del cliente
     * @param apellidos apellidos del cliente
     * @param cedula cédula del cliente
     * @param direccion dirección del cliente
     * @param telefono teléfono del cliente
     * @param email correo electrónico del cliente
     */
    public void registrarCliente(String nombres, String apellidos, String cedula, String direccion, String telefono, String email) {
        String query = "INSERT INTO Usuario (nombres, apellidos, cedula, direccion, telefono, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, nombres);
            stmt.setString(2, apellidos);
            stmt.setString(3, cedula);
            stmt.setString(4, direccion);
            stmt.setString(5, telefono);
            stmt.setString(6, email);

            // Ejecutar la consulta de inserción
            int rowsInserted = stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, e);
            // Mostrar un mensaje de error en caso de fallo
            JOptionPane.showMessageDialog(null, "Error al registrar el cliente: " + e.getMessage());
        }
    }
    
    /**
     * Verificar si un cliente existe en la base de datos
     * @param cedula cédula del cliente
     * @return true si el cliente existe, false en caso contrario
     */
    public Boolean clienteExiste(String cedula) {
        String consulta = "SELECT COUNT(*) FROM Usuario WHERE cedula = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(consulta)) {
            stmt.setString(1, cedula);
            // Ejecutar la consulta
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Actualizar los datos de un usuario en la base de datos
     * @param cedula cédula del usuario
     * @param nuevaDireccion nueva dirección del usuario
     * @param nuevoTelefono nuevo teléfono del usuario
     * @param nuevoEmail nuevo correo electrónico del usuario
     * @return true si la actualización fue exitosa, false en caso contrario
     */
    public Boolean actualizarUsuario(String cedula, String nuevaDireccion, String nuevoTelefono, String nuevoEmail) {
        // Construir la consulta SQL dinámicamente en base a los parámetros proporcionados
        StringBuilder queryBuilder = new StringBuilder("UPDATE Usuario SET ");
        boolean hasPreviousField = false;

        if (nuevaDireccion != null && !nuevaDireccion.isEmpty()) {
            queryBuilder.append("direccion = ?");
            hasPreviousField = true;
        }
        if (nuevoTelefono != null && !nuevoTelefono.isEmpty()) {
            if (hasPreviousField) queryBuilder.append(", ");
            queryBuilder.append("telefono = ?");
            hasPreviousField = true;
        }
        if (nuevoEmail != null && !nuevoEmail.isEmpty()) {
            if (hasPreviousField) queryBuilder.append(", ");
            queryBuilder.append("email = ?");
        }

        queryBuilder.append(" WHERE cedula = ?");

        String query = queryBuilder.toString();

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            int paramIndex = 1;

            if (nuevaDireccion != null && !nuevaDireccion.isEmpty()) {
                stmt.setString(paramIndex++, nuevaDireccion);
            }
            if (nuevoTelefono != null && !nuevoTelefono.isEmpty()) {
                stmt.setString(paramIndex++, nuevoTelefono);
            }
            if (nuevoEmail != null && !nuevoEmail.isEmpty()) {
                stmt.setString(paramIndex++, nuevoEmail);
            }
            stmt.setString(paramIndex, cedula);  // El último parámetro es la cédula

            // Ejecutar la consulta de actualización
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    /**
     * Obtener todos los usuarios de la base de datos
     * @return lista de objetos Cliente con los datos de todos los usuarios
     */
    public ArrayList<Cliente> obtenerTodosLosUsuarios() {
        ArrayList<Cliente> usuarios = new ArrayList<>();
        String query = "SELECT nombres, apellidos, cedula, direccion, telefono, email FROM Usuario";

        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                // Crear y agregar un nuevo objeto Cliente a la lista
                Cliente usuario = new Cliente(
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("cedula"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("email")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
    
    /**
     * Insertar un nuevo conductor en la base de datos
     * @param nombres nombres del conductor
     * @param apellidos apellidos del conductor
     * @param cedula cédula del conductor
     * @param direccion dirección del conductor
     * @param telefono teléfono del conductor
     * @param email correo electrónico del conductor
     * @param nombreUsuario nombre de usuario para la credencial del conductor
     * @param clave contraseña para la credencial del conductor
     * @param provincia provincia asignada al conductor
     */
    public void insertarConductor(String nombres, String apellidos, String cedula, String direccion, String telefono, String email, String nombreUsuario, String clave, Provincia provincia) {
        String insertUsuarioSQL = "INSERT INTO Usuario (nombres, apellidos, cedula, direccion, telefono, email) VALUES (?, ?, ?, ?, ?, ?)";
        String insertCredencialSQL = "INSERT INTO Credencial (nombreUsuario, clave, rol, provincia, usuario_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmtUsuario = conexion.prepareStatement(insertUsuarioSQL, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtCredencial = conexion.prepareStatement(insertCredencialSQL)) {
             
            // Insertar datos en la tabla Usuario
            stmtUsuario.setString(1, nombres);
            stmtUsuario.setString(2, apellidos);
            stmtUsuario.setString(3, cedula);
            stmtUsuario.setString(4, direccion);
            stmtUsuario.setString(5, telefono);
            stmtUsuario.setString(6, email);
            int affectedRows = stmtUsuario.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Fallo la creación del usuario, no se pudo insertar.");
            }

            // Obtener el ID generado automáticamente
            try (ResultSet generatedKeys = stmtUsuario.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long usuarioId = generatedKeys.getLong(1);

                    // Insertar datos en la tabla Credencial
                    stmtCredencial.setString(1, nombreUsuario);
                    stmtCredencial.setString(2, clave);
                    stmtCredencial.setString(3, "conductor");
                    stmtCredencial.setString(4, provincia.name());
                    stmtCredencial.setLong(5, usuarioId);
                    stmtCredencial.executeUpdate();
                } else {
                    throw new SQLException("Fallo la creación del usuario, no se pudo obtener el ID.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Verificar si un nombre de usuario es único en la base de datos
     * @param nombreUsuario nombre de usuario a verificar
     * @return true si el nombre de usuario es único, false en caso contrario
     */
    public boolean esNombreUsuarioUnico(String nombreUsuario) {
        String query = "SELECT COUNT(*) FROM Credencial WHERE nombreUsuario = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, nombreUsuario);
            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count == 0; // Devuelve true si no existe el nombre de usuario
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; // Si ocurre un error, asumimos que no es único para evitar errores en la lógica de la aplicación
    }
    
    /**
     * Obtener todos los conductores de la base de datos
     * @return lista de objetos Conductor con los datos de todos los conductores
     */
    public ArrayList<Conductor> obtenerTodosLosConductores() {
        ArrayList<Conductor> conductores = new ArrayList<>();
        String query = "SELECT u.nombres, u.apellidos, u.cedula AS identificacion, u.direccion, u.telefono, u.email " +
                       "FROM Usuario u " +
                       "JOIN Credencial c ON u.id = c.usuario_id " +
                       "WHERE c.rol = 'conductor'";

        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Crear y agregar un nuevo objeto Conductor a la lista
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String identificacion = rs.getString("identificacion");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");

                Conductor conductor = new Conductor(nombres, apellidos, identificacion, direccion, telefono, email);
                conductores.add(conductor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conductores;
    } 

    public Cliente obtenerclientePorCedula(String cedula) {
        String query = "SELECT nombres, apellidos, cedula AS identificacion, direccion, telefono, email " +
                       "FROM Usuario " +
                       "WHERE cedula = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, cedula);
            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Crear y devolver el objeto Conductor
                    return new Cliente(
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("identificacion"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email")
                    );
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
