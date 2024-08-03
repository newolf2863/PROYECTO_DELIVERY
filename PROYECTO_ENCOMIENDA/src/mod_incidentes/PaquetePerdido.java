/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod_incidentes;

/**
 *
 * @author Rodrigo Haro
 */
public class PaquetePerdido extends Incidente {

    @Override
    public String registrar() {
        return "La ubicación de su paquete es desconocida";
    }

    @Override
    public String resolver(String[] argumentos) {
        if (argumentos[0].equals("Recuperado")) {
            return "Se ha recuperado su paquete y pronto se le será entregado";
        } else if (argumentos[0].equals("Desconocido")) {
            return "Su paquete no se ha podido encontrar, por favor, acérquese a la agencia más cercana para recibir una compensación";
        }
        return "";
    }
}
