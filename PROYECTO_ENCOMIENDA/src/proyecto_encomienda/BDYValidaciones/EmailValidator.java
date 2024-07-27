/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.BDYValidaciones;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailValidator {
   public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(gmail\\.com|outlook\\.com|yahoo\\.com|hotmail\\.com|epn\\.edu\\.ec)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
   
    public static boolean isValidEmailGitHub(String email) {
        String regex = "^(?i)[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
