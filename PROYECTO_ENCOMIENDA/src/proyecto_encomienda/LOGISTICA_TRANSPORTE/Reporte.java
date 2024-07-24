package proyecto_encomienda.LOGISTICA_TRANSPORTE;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ediso
 */
public class Reporte {
    private Envio envio;

    // Constructor
    public Reporte(Envio envio) {
        this.envio = envio;
    }

    // Método para verificar el estado del paquete
    public void verificarEstado() {
        String estado = envio.getEstado();
        System.out.println("El estado del envío es: " + estado);
    }

    // Método para generar un reporte

    //ARREGLAR
    public void generarReporte() {
        if (!envio.getPaquetes().isEmpty()) {
            System.out.println("Número de Tracking del paquete: " + envio.getPaquetes().get(0).getCodigoTracking());
        }
        //¿A QUE SE REFIERE LA DESCRIPCIÓN DEL PAQUETE?
        System.out.println("Descripción del paquete: " + envio.getDescripcion());
        System.out.println("Estado del envio: " + envio.getEstado());
        
        System.out.println("Fecha del reporte: " + new Date());
    }

    public static void generarYMostrarReportes(List<Envio> envios) {
        int i = 1;
        for (Envio envio : envios) {
            Reporte reporte = new Reporte(envio);
            System.out.println("*****************************************************************************************");
            System.out.println("***********************REPORTE DEL ENVIO " + i + " ***********************");
            reporte.generarReporte();
            System.out.println("*****************************************************************************************");
            System.out.println("***********************INFORMACION DEL ENVIO " + i + "***********************");
            envio.imprimirEnvio();
            i++;
        }
    }

}
