
package basededatos;

/**
 *
 * @author Moises Arequipa
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
import mod_paquetes.Provincia;

public class DataBase {
    private static DataBase instancia;
    private Connection conexion;
    
    private DataBase() {      
        String HOST = "localhost";
        String PUERTO = "5432";
        String DB = "paquetes";
        String USER = "administrador";
        String PASSWORD = "123";
        
        try {
            Class.forName("org.postgresql.Driver");
            String url ="jdbc:postgresql://"+HOST+":"+PUERTO+"/"+DB;
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static DataBase obtenerInstancia() {
        if (instancia == null) {
            instancia = new DataBase();
        }
        return instancia;
    }
    
    public String comprobarCredencial(String username, String password) {
        String query = "SELECT rol FROM Credencial WHERE nombreUsuario = ? AND clave = ?";
        try {
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("rol");
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Recepcionista obtenerRecepcionista(String username) {
        String query = "SELECT u.nombres, u.apellidos, u.cedula AS identificacion, u.direccion, u.telefono, u.email, c.provincia " +
               "FROM Usuario u " +
               "JOIN Credencial c ON u.id = c.usuario_id " +
               "WHERE c.nombreUsuario = ?";
        try {
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, username);
            Provincia sucursal = null;
            Class<?> enumClass;
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    try {
                        enumClass = Class.forName("mod_paquetes.Provincia");
                        sucursal = (Provincia) Enum.valueOf((Class<Enum>) enumClass, rs.getString("Provincia"));
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(JFPaquetes.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
    
    public Conductor obtenerConductor(String username) {
        String query = "SELECT u.nombres, u.apellidos, u.cedula AS identificacion, u.direccion, u.telefono, u.email, c.provincia " +
               "FROM Usuario u " +
               "JOIN Credencial c ON u.id = c.usuario_id " +
               "WHERE c.nombreUsuario = ?";
        try {
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
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
    
    public Cliente obtenerDatosPorCedula(String cedula) {
        String query = "SELECT nombres, apellidos, cedula AS identificacion, direccion, telefono, email " +
                       "FROM Usuario " +
                       "WHERE cedula = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, cedula);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
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

    
    public Conductor obtenerConductorPorCedula(String cedula) {
        String query = "SELECT nombres, apellidos, cedula AS identificacion, direccion, telefono, email " +
                       "FROM Usuario " +
                       "WHERE cedula = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, cedula);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
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
    
    
    
    public void registrarCliente(String nombres, String apellidos, String cedula, String direccion, String telefono, String email) {
        String query = "INSERT INTO Usuario (nombres, apellidos, cedula, direccion, telefono, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, nombres);
            stmt.setString(2, apellidos);
            stmt.setString(3, cedula);
            stmt.setString(4, direccion);
            stmt.setString(5, telefono);
            stmt.setString(6, email);

            int rowsInserted = stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error al registrar el cliente: " + e.getMessage());
        }
    }
    
    public Boolean clienteExiste(String cedula) {
        String consulta = "SELECT COUNT(*) FROM Usuario WHERE cedula = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(consulta)) {
            stmt.setString(1, cedula);
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
    
    public ArrayList<Cliente> obtenerTodosLosUsuarios() {
        ArrayList<Cliente> usuarios = new ArrayList<>();
        String query = "SELECT nombres, apellidos, cedula, direccion, telefono, email FROM Usuario";

        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
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
    
    public boolean esNombreUsuarioUnico(String nombreUsuario) {
        String query = "SELECT COUNT(*) FROM Credencial WHERE nombreUsuario = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, nombreUsuario);
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
    
    public ArrayList<Conductor> obtenerTodosLosConductores() {
        ArrayList<Conductor> conductores = new ArrayList<>();
        String query = "SELECT u.nombres, u.apellidos, u.cedula AS identificacion, u.direccion, u.telefono, u.email " +
                       "FROM Usuario u " +
                       "JOIN Credencial c ON u.id = c.usuario_id " +
                       "WHERE c.rol = 'conductor'";

        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
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

   
}
