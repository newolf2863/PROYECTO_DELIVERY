/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_ecomienda.BDYValidaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class RegistradoraDeUsuarios {
Map<String, Integer> preguntaToNumeroMap = new HashMap<>();

    public static void registrarUsuario(Connection cnx, String nombreUser, String CI, String password, String pregunta,
                                        String respuesta, String rolEmp) {
       Map<String, Integer> preguntaToNumeroMap = new HashMap<>();
        preguntaToNumeroMap.put("¿Cuál es el nombre de tu primera mascota?", 1);
        preguntaToNumeroMap.put("¿En qué ciudad naciste?", 2);
        preguntaToNumeroMap.put("¿Cuál fue tu primer trabajo?", 3);
        preguntaToNumeroMap.put("¿Cuál es tu película favorita?", 4);
        preguntaToNumeroMap.put("¿Cuál es tu comida favorita?", 5);
        preguntaToNumeroMap.put("¿Cuál es tu equipo deportivo favorito?", 6);
        preguntaToNumeroMap.put("¿Cuál es el nombre de tu mejor amigo/a de la infancia?", 7);
        preguntaToNumeroMap.put("¿Cuál es el nombre de tu profesor/a favorito/a?", 9);
        preguntaToNumeroMap.put("¿Cuál es tu canción favorita?", 9);
        int numpregunta = preguntaToNumeroMap.getOrDefault(pregunta, 0);
       
        try {
            String insertQuery = "INSERT INTO usuarios (nombreUser, CI, passwordU, numPregunta, respuesta, rol) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = cnx.prepareStatement(insertQuery);
            preparedStatement.setString(1, nombreUser);
            preparedStatement.setString(2, CI);
            preparedStatement.setString(3, password);
            preparedStatement.setInt(4, numpregunta);
            preparedStatement.setString(5, respuesta);
            preparedStatement.setString(6, rolEmp);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");

            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Empleado inexistente");
            
        }
    }
}