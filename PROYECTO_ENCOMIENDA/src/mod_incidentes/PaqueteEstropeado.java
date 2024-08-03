/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

/**
 *
 * @author Rodrigo Haro
 */
public class PaqueteEstropeado extends Incidente {

    @Override
    public String registrar() {
        return "El paquete se encuentra en malas condiciones";
    }

    @Override
    public String resolver(String[] argumentos) {
        if (argumentos[0].equals("Remunerado")) {
            return "Por los daños presentados en su paquete se le entregará una compensación de " + argumentos[1] + " dólares";
        } else if (argumentos[0].equals("NoRemunerado")) {
            return "No se pueden cubrir los daños que su paquete ha presentado. La empresa se deslinda de toda responsabilidad";
        }
        return "";    
    }
}
