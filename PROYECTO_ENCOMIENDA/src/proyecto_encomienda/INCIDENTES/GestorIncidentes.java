package proyecto_encomienda.INCIDENTES;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;

public class GestorIncidentes {
    private Inventario inventario;

    public GestorIncidentes(Inventario inventario) {
        this.inventario = inventario;
    }

    public void crearIncidente(Incidente incidente, String idPaquete) {
        // Leer el archivo inventario.txt
        try (BufferedReader br = new BufferedReader(new FileReader("inventario.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Buscar la línea que contiene el paquete con el idPaquete deseado
                if (line.contains("Paquete{codigoTracking='" + idPaquete)) {
                    // Obtener el codigoTracking del paquete
                    String codigoTracking = line.split("codigoTracking='")[1].split("'")[0];
                    incidente.setIdPaquete(codigoTracking);
                    incidente.registrarIncidente();
                    incidente.notificarCliente();
                    incidente.actuar();
                    incidente.guardarPaquete();
                    incidente.guardarEnArchivo();
                    return; // Salir del método después de encontrar y procesar el paquete
                }
            }
            // Si no se encuentra el paquete
            System.out.println("Paquete no encontrado en el inventario: " + idPaquete);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo inventario.txt: " + e.getMessage());
        }
    }
}
