package proyecto_encomienda.INCIDENTES;

import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Paquete;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main_Incidente {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);
        String archivo = "incidentes.csv";

        System.out.print("Ingrese el ID del paquete (codigoTracking): ");
        String codigoTracking = scanner.nextLine();

        // Verificar si el paquete ya existe en el inventario
        if (!paqueteExisteEnArchivo("inventario.txt", codigoTracking)) {
            System.out.print("Ingrese el ancho del paquete: ");
            double ancho = scanner.nextDouble();

            System.out.print("Ingrese el largo del paquete: ");
            double largo = scanner.nextDouble();

            scanner.nextLine(); // Limpiar el buffer después de nextDouble()

            System.out.print("Ingrese el contenido del paquete: ");
            String contenido = scanner.nextLine();

            System.out.print("Ingrese la dirección de destino: ");
            String destino = scanner.nextLine();

            // Crear el paquete y agregarlo al inventario
            Paquete paquete = new Paquete(codigoTracking, ancho, largo, contenido, destino);
            inventario.agregarPaquete(paquete);
            System.out.println("Paquete registrado y añadido al inventario.");
        } else {
            System.out.println("El paquete ya existe en el inventario. Actualizando estado...");
        }

        GestorIncidentes gestorIncidentes = new GestorIncidentes(inventario);

        boolean salir = false;
        while (!salir) {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Registrar incidente (Paquete Perdido o Rechazo de Entrega)");
            System.out.println("2. Actualizar estado de un paquete");
            System.out.println("3. Mostrar incidentes registrados");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer después de nextInt()

            switch (opcion) {
                case 1:
                    registrarIncidente(scanner, gestorIncidentes, codigoTracking);
                    break;
                case 2:
                    actualizarEstadoPaquete(scanner, archivo, codigoTracking);
                    break;
                case 3:
                    mostrarContenidoArchivo(archivo);
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }

    public static boolean paqueteExisteEnArchivo(String archivo, String codigoTracking) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.contains("Paquete{codigoTracking='" + codigoTracking)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }

    public static void mostrarContenidoArchivo(String archivo) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("incidentes.csv"), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) { // Ajustado para incluir el ID del incidente
                    System.out.println("ID Incidente: " + partes[0]);
                    System.out.println("ID Paquete: " + partes[1]);
                    System.out.println("Descripción: " + partes[2]);
                    System.out.println("Fecha: " + partes[3]);
                    System.out.println("Estado: " + partes[4]);
                    System.out.println("------------------------------");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void registrarIncidente(Scanner scanner, GestorIncidentes gestorIncidentes, String idPaquete) {
        System.out.println("Seleccione el tipo de incidente:");
        System.out.println("1. Paquete Perdido");
        System.out.println("2. Rechazo de Entrega");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                PaquetePerdido incidentePerdido = new PaquetePerdido();
                incidentePerdido.setDescripcion("El paquete se perdió durante el tránsito");
                incidentePerdido.setFecha(LocalDateTime.now());
                incidentePerdido.setEstado("Perdido");

                gestorIncidentes.crearIncidente(incidentePerdido, idPaquete);
                break;
            case 2:
                RechazoEntrega incidenteRechazo = new RechazoEntrega();
                System.out.print("Ingrese la razón del rechazo: ");
                String razon = scanner.nextLine();

                incidenteRechazo.setDescripcion(razon);
                incidenteRechazo.setFecha(LocalDateTime.now());
                incidenteRechazo.setEstado("Rechazado");

                gestorIncidentes.crearIncidente(incidenteRechazo, idPaquete);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public static void actualizarEstadoPaquete(Scanner scanner, String archivo, String idPaquete) {
        List<String> lineas = new ArrayList<>();
        boolean paqueteEncontrado = false;

        // Leer el archivo en UTF-8
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length > 1 && partes[1].equals(idPaquete)) {  // Verificar en la segunda columna
                    paqueteEncontrado = true;
                    System.out.println("Paquete encontrado:");
                    System.out.println("ID Incidente: " + partes[0]);
                    System.out.println("ID Paquete: " + partes[1]);
                    System.out.println("Descripción: " + partes[2]);
                    System.out.println("Fecha: " + partes[3]);
                    System.out.println("Estado: " + partes[4]);

                    System.out.println("Seleccione el nuevo estado del paquete:");
                    System.out.println("1. Perdido");
                    System.out.println("2. Rechazado");

                    // Leer la opción ingresada
                    System.out.print("Ingrese el número correspondiente a la opción: ");
                    int opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    String nuevoEstado = opcion == 1 ? "Perdido" : "Rechazado";

                    if (opcion == 2) {
                        System.out.print("Ingrese la razón del rechazo: ");
                        String razon = scanner.nextLine();
                        partes[2] = " Razón de rechazo: " + razon;
                    }

                    partes[4] = nuevoEstado;
                    lineas.add(String.join(",", partes));
                    System.out.println("Estado actualizado correctamente.");
                } else {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        if (!paqueteEncontrado) {
            System.out.println("No se encontró un paquete con el ID proporcionado.");
        } else {
            // Escribir el archivo en UTF-8
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo), StandardCharsets.UTF_8))) {
                for (String linea : lineas) {
                    writer.write(linea);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        }
    }

}
