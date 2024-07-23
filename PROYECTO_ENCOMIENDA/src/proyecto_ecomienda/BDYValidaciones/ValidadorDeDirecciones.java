/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_ecomienda.BDYValidaciones;

/**
 *
 * @author USUARIO
 */
public class ValidadorDeDirecciones {
    
     public boolean validarDireccion(String dirNegocio) {
        //String dirNegocio = jTFDirNegocio.getText();
        // La expresión regular permite comas en el medio pero no al inicio ni al final
        if (dirNegocio.matches("^[A-Za-záéíóúÁÉÍÓÚñÑüÜ0-9]+([,.]?[ ]?[A-Za-záéíóúÁÉÍÓÚñÑüÜ0-9]+)*$")) {
            return true;
        } else {
            return false;
        }
    }
}
