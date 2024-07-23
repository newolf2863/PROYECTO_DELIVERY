/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_ecomienda.BDYValidaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class UsuarioManager {

    // Otras funciones y métodos aquí
    public static void crearUsuarioYOtorgarPrivilegios(Connection cnx, String nuevoUsuario, String nuevaContrasena) {
        String database="dbbestocolor";
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        try {
        String createUserQuery = "CREATE USER " + nuevoUsuario + " WITH PASSWORD '" + nuevaContrasena + "'";
        preparedStatement = cnx.prepareStatement(createUserQuery);
        preparedStatement.executeUpdate();
//
//        String grantQuery = "GRANT ALL PRIVILEGES ON DATABASE "+database + " TO " + nuevoUsuario;
//        preparedStatement1 = cnx.prepareStatement(grantQuery);
//        preparedStatement1.executeUpdate();
//
//        String grantQuery1 = "GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO " + nuevoUsuario;
//        preparedStatement2 = cnx.prepareStatement(grantQuery1);
//        preparedStatement2.executeUpdate();
        
        String grantQuery1 = "ALTER USER "+ nuevoUsuario+ " WITH SUPERUSER;";
        preparedStatement2 = cnx.prepareStatement(grantQuery1);
        preparedStatement2.executeUpdate();

        //JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + ex.getMessage());
    } finally {
        try {
            if (preparedStatement2 != null) preparedStatement2.close();
            if (preparedStatement1 != null) preparedStatement1.close();
            if (preparedStatement != null) preparedStatement.close();
        } catch (SQLException ex) {
            // Manejo de excepciones al cerrar
        }
    }
 }
    
}

