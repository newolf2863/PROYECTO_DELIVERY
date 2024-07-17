package proyecto_encomienda.INCIDENTES;


import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Paquete;
import proyecto_encomienda.INCIDENTES.GestorIncidentes;
import proyecto_encomienda.INCIDENTES.PaquetePerdido;
import proyecto_encomienda.INCIDENTES.RechazoEntrega;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;

public class main_Incidente {

    public static void main(String[] args){
        Inventario inventario=new Inventario();
        Scanner scanner = new Scanner(System.in);
        String archivo = "incidentes.txt";

        System.out.print("Ingrese el ID del paquete (codigoTracking): ");
        String codigoTracking = scanner.nextLine();

        // Verificar si el paquete ya existe en el archivo de incidentes
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
                    // Registrar un incidente para el paquete seleccionado
                    registrarIncidente(scanner, gestorIncidentes, codigoTracking);
                    break;
                case 2:
                    // Actualizar estado de un paquete existente
                    actualizarEstadoPaquete(scanner,archivo,codigoTracking);
                    break;
                case 3:
                    // Mostrar los incidentes registrados en el archivo
                    mostrarContenidoArchivo("incidentes.txt");
                    break;
                case 4:
                    // Salir del programa
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
                // Aquí asumo que cada línea del archivo tiene el formato "Paquete{codigoTracking='valor', ..."
                if (linea.contains("Paquete{codigoTracking='" + codigoTracking + "'")) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
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
                incidenteRechazo.setDescripcion("Cliente rechazó la entrega debido a daños en el paquete");
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

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.contains("ID Paquete: " + idPaquete)) {
                    paqueteEncontrado = true;

                    System.out.println("Paquete encontrado:");
                    while (!(linea = reader.readLine()).equals("------------------------------")) {
                        System.out.println(linea);
                        lineas.add(linea);
                    }

                    System.out.print("Ingrese el nuevo estado del paquete (Perdido/Rechazado): ");
                    String nuevoEstado = scanner.next();
                    scanner.nextLine(); // Limpiar el buffer

                    if (nuevoEstado.equalsIgnoreCase("Rechazado")) {
                        System.out.print("Ingrese la razón del rechazo: ");
                        String razon = scanner.nextLine();
                        System.out.println("Razón de rechazo registrada: " + razon);
                    }

                    lineas.add("Estado: " + nuevoEstado);
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
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
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
