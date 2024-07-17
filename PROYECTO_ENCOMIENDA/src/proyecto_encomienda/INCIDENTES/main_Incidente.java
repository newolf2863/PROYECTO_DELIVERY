package proyecto_encomienda.INCIDENTES;

import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Paquete;
import java.time.LocalDateTime;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main_Incidente {
    public static void main(String[] args) {
        // Crear inventario y añadir un paquete para el ejemplo
        Inventario inventario = new Inventario();
        Paquete paquete = new Paquete("12345", 10.0, 5.0, "Ropa", "Calle Falsa 123");
        inventario.agregarPaquete(paquete);

        // Crear un gestor de incidentes
        GestorIncidentes gestorIncidentes = new GestorIncidentes(inventario);

        // Crear un incidente de tipo PaquetePerdido
        PaquetePerdido incidente = new PaquetePerdido();
        incidente.setDescripcion("El paquete se perdió durante el tránsito");
        incidente.setFecha(LocalDateTime.now());
        incidente.setEstado("Perdido");

        // Procesar el incidente
        gestorIncidentes.crearIncidente(incidente, "12345");

        // Leer y mostrar el contenido del archivo
        mostrarContenidoArchivo("incidentes.txt");
    }

    public static void mostrarContenidoArchivo(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
