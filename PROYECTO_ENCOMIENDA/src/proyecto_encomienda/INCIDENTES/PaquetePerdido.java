package proyecto_encomienda.INCIDENTES;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class PaquetePerdido extends Incidente {

    private static Map<String, String> ultimoEstadoPorPaquete = new HashMap<>();

    @Override
    public void actuar() {
        // Lógica específica para Paquete Perdido
        System.out.println("Actuando sobre paquete perdido: " + getIdPaquete());
    }

    @Override
    public void guardarEnArchivo() {
        String archivo = "incidentes.csv";
        String estadoActual = getEstado();
        String idPaquete = getIdPaquete();

        String ultimoEstado = ultimoEstadoPorPaquete.getOrDefault(idPaquete, null);

        if (ultimoEstado != null && estadoActual.equals(ultimoEstado)) {
            System.out.println("No se puede guardar el mismo estado para el mismo paquete de manera consecutiva: " + estadoActual);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), StandardCharsets.UTF_8))) {
            writer.write(getIdIncidente() + "," + idPaquete + "," + getDescripcion() + "," + getFecha().toString() + "," + estadoActual + "\n");
            ultimoEstadoPorPaquete.put(idPaquete, estadoActual);
        } catch (IOException e) {
            System.err.println("Error al guardar en archivo: " + e.getMessage());
        }
    }

    @Override
    public void registrarIncidente() {
        System.out.println("Incidente registrado (Paquete Perdido): " + getDescripcion());
    }
}
