/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.GESTION_PAQUETES.BACKEND;

/**
 *
 * @author Juguitos
 */
public class Pendiente extends EstadoDelPaquete {

    public Pendiente(Paquete paquete) {
        super(paquete);
    }

    @Override
    public void iniciarEnvio() {
        // Implementación específica para iniciar el envío en estado pendiente
        System.out.println("Iniciando envío para el paquete " + paquete.getIdPaquete() + " en estado Pendiente");
    }

    @Override
    public void completarEnvio() {
        // Implementación específica para completar el envío en estado pendiente
        System.out.println("Completando envío para el paquete " + paquete.getIdPaquete() + " en estado Pendiente");
    }

    public static Pendiente valueOf(String estado) {
        if ("Pendiente".equalsIgnoreCase(estado)) {
            return new Pendiente(null); // Aquí deberías pasar el paquete correcto
        } else {
            throw new IllegalArgumentException("Estado no soportado: " + estado);
        }
    }
}
