package proyecto_encomienda.GESTION_PAQUETES.BACKEND;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Paquete> paquetes;
    private static final String ARCHIVO_INVENTARIO = "inventario.txt";
    public Inventario() throws IOException {
        paquetes = new ArrayList<>();
        //cargarInventarioDesdeArchivo(); // Cargar el inventario al inicializar
    }
    
    public void agregarPaquete(Paquete paquete) {
        paquetes.add(paquete);
        guardarInventarioEnArchivo();
    }
    
    public Paquete obtenerPaquete(String codigoTracking) {
        for (Paquete paquete : paquetes) {
            if (paquete.getCodigoTracking().equals(codigoTracking)) {
                return paquete;
            }
        }
        return null;
    }
    
    public EstadoDelPaquete verificarEstadoPaquete(String codigoTracking) {
        for (Paquete paquete : paquetes) {
            if (paquete.getCodigoTracking().equals(codigoTracking)) {
                return paquete.obtenerEstado();
            }
        }
        return null;
    }

    public Paquete buscarPaquetePorId(String idPaquete) {
        for (Paquete paquete : paquetes) {
            if (paquete.getCodigoTracking().equals(idPaquete)) {
                return paquete;
            }
        }
        return null;
    }
    
    // Método para guardar todo el inventario en el archivo
    private void guardarInventarioEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_INVENTARIO))) {
            for (Paquete paquete : paquetes) {
                writer.write(paquete.toString()); // Guarda la representación del paquete como texto
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el inventario en el archivo: " + e.getMessage());
        }
    }
    
     /*private void cargarInventarioDesdeArchivo() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_INVENTARIO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Paquete paquete = parsearLineaComoPaquete(linea);
                if (paquete != null) {
                    paquetes.add(paquete);
                }
            }
        }    }

    private Paquete parsearLineaComoPaquete(String linea) {
    String[] partes = linea.split(",");

    // Verificar que haya suficientes partes para crear un Paquete válido
    if (partes.length >= 5) {
        try {
            String codigoTracking = partes[0].trim();
            double ancho = Double.parseDouble(partes[1].trim().split("=")[1]); // Ejemplo de cómo extraer el valor numérico
            double largo = Double.parseDouble(partes[2].trim().split("=")[1]);
            String contenido = partes[3].trim().split("=")[1];
            String destino = partes[4].trim().split("=")[1];

            // Crear y devolver un nuevo objeto Paquete
            return new Paquete(codigoTracking, ancho, largo, contenido, destino);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Error al parsear la línea como un Paquete: " + e.getMessage());
            return null;
        }
    } else {
        System.err.println("Error: La línea no contiene suficientes datos para crear un Paquete.");
        return null;
    }
}*/

}
