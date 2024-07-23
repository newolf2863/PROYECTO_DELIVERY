package proyecto_encomienda.INCIDENTES;

import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class GestorIncidentes {

    private Inventario inventario;

    public GestorIncidentes(Inventario inventario) {
        this.inventario = inventario;
    }

    public void crearIncidente(Incidente incidente, String idPaquete) {
        // Verificar si el paquete ya tiene un incidente registrado con el mismo tipo
        boolean existeIncidente = verificarExistenciaIncidente(idPaquete, incidente.getEstado());

        if (existeIncidente) {
            System.out.println("Ya existe un incidente de tipo " + incidente.getEstado() + " para el paquete " + idPaquete);
            return;
        }

        // Procesar el registro del nuevo incidente
        try (BufferedReader br = new BufferedReader(new FileReader("inventario.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Paquete{codigoTracking='" + idPaquete)) {
                    String codigoTracking = line.split("codigoTracking='")[1].split("'")[0];
                    incidente.setIdPaquete(codigoTracking);
                    incidente.setIdIncidente(generarIdIncidente()); // Generar ID único para el incidente
                    incidente.registrarIncidente();
                    incidente.notificarCliente();
                    incidente.actuar();
                    incidente.guardarPaquete();
                    guardarEnArchivo(incidente); // Guardar el incidente en el archivo
                    return;
                }
            }
            System.out.println("Paquete no encontrado en el inventario: " + idPaquete);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo inventario.txt: " + e.getMessage());
        }
    }

    private boolean verificarExistenciaIncidente(String idPaquete, String tipoIncidente) {
        // Leer el archivo incidentes.csv y verificar si ya existe un incidente del mismo tipo para el paquete
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("incidentes.csv"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String incidenteIdPaquete = parts[1];
                    String incidenteTipo = parts[2];
                    // Comparar idPaquete y tipoIncidente con los incidentes registrados
                    if (incidenteIdPaquete.equals(idPaquete) && incidenteTipo.equals(tipoIncidente)) {
                        return true; // Ya existe un incidente con el mismo tipo para este paquete
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo incidentes.csv: " + e.getMessage());
        }
        return false; // No se encontró un incidente con el mismo tipo para este paquete
    }

    private String generarIdIncidente() {
        return "INC-" + System.currentTimeMillis(); // Generar un ID único basado en el tiempo
    }

    private void guardarEnArchivo(Incidente incidente) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("incidentes.csv", true), StandardCharsets.UTF_8))) {
            writer.println(incidente.getIdIncidente() + "," + incidente.getIdPaquete() + "," + incidente.getEstado() + "," + incidente.getDescripcion() + "," + incidente.getFecha());
        }
    }

    public void cargarIncidentes() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("incidentes.csv"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String idIncidente = parts[0];
                    String idPaquete = parts[1];
                    String descripcion = parts[2];
                    String fecha = parts[3];
                    String estado = parts[4];
                    System.out.println("ID Incidente: " + idIncidente);
                    System.out.println("ID Paquete: " + idPaquete);
                    System.out.println("Descripción: " + descripcion);
                    System.out.println("Fecha: " + fecha);
                    System.out.println("Estado: " + estado);
                    System.out.println("------------------------------");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo incidentes.csv: " + e.getMessage());
        }
    }
}
