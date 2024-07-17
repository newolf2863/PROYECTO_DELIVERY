package proyecto_encomienda.INCIDENTES;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PaquetePerdido extends Incidente {
    
    // Mapa para almacenar el último estado registrado por cada paquete
    private static Map<String, String> ultimoEstadoPorPaquete = new HashMap<>();

    @Override
    public void actuar() {
        // Lógica específica para Paquete Perdido
        System.out.println("Actuando sobre paquete perdido: " + getIdPaquete());
    }

    @Override
    public void guardarEnArchivo() {
        String archivo = "incidentes.txt";
        String estadoActual = getEstado();
        String idPaquete = getIdPaquete();
        
        // Obtener el último estado registrado para este paquete
        String ultimoEstado = ultimoEstadoPorPaquete.getOrDefault(idPaquete, null);
        
        // Verificar si el estado actual es igual al último estado registrado
        if (ultimoEstado != null && estadoActual.equals(ultimoEstado)) {
            System.out.println("No se puede guardar el mismo estado para el mismo paquete de manera consecutiva: " + estadoActual);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write("ID Paquete: " + idPaquete + "\n");
            writer.write("Descripción: " + getDescripcion() + "\n");
            writer.write("Fecha: " + getFecha().toString() + "\n");
            writer.write("Estado: " + estadoActual + "\n");
            writer.write("------------------------------\n");
            //System.out.println("Información del incidente guardada en archivo: " + new File(archivo).getAbsolutePath());
            //System.out.println("idPaquete"+idPaquete);
            // Actualizar el último estado registrado para este paquete
            ultimoEstadoPorPaquete.put(idPaquete, estadoActual);
        } catch (IOException e) {
            System.err.println("Error al guardar en archivo: " + e.getMessage());
        }
    }

    @Override
    public void registrarIncidente() {
        // Lógica específica para registrar un incidente de Paquete Perdido
        System.out.println("Incidente registrado (Paquete Perdido): " + getDescripcion());
    }
}
