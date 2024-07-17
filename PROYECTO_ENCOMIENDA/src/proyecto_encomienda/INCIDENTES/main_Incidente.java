package proyecto_encomienda.INCIDENTES;

import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Paquete;

import java.time.LocalDateTime;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main_Incidente {
    public static void main(String[] args) {
        // Crear inventario
        Inventario inventario = new Inventario();

        // Leer datos del paquete desde la consola
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del paquete: ");
        String idPaquete = scanner.nextLine();

        System.out.print("Ingrese el ancho del paquete: ");
        double ancho = scanner.nextDouble();

        System.out.print("Ingrese el largo del paquete: ");
        double largo = scanner.nextDouble();

        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el contenido del paquete: ");
        String contenido = scanner.nextLine();

        System.out.print("Ingrese la dirección de destino: ");
        String destino = scanner.nextLine();

        // Crear el paquete y añadirlo al inventario
        Paquete paquete = new Paquete(idPaquete, ancho, largo, contenido, destino);
        inventario.agregarPaquete(paquete);

        // Crear un gestor de incidentes
        GestorIncidentes gestorIncidentes = new GestorIncidentes(inventario);

        // Crear un incidente de tipo PaquetePerdido
        PaquetePerdido incidente = new PaquetePerdido();
        incidente.setDescripcion("El paquete se perdió durante el tránsito");
        incidente.setFecha(LocalDateTime.now());
        incidente.setEstado("Perdido");

        // Procesar el incidente
        gestorIncidentes.crearIncidente(incidente, idPaquete);

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
