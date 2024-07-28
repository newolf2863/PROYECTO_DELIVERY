package proyecto_encomienda.GESTION_PAQUETES.BACKEND;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Inventario {
    private static Inventario instancia;
    private ArrayList<Paquete> paquetes;
    private static final String ARCHIVO_INVENTARIO = "inventario.txt";
    private Inventario(){
        paquetes = new ArrayList<>();
        //cargarInventarioDesdeArchivo(); // Cargar el inventario al inicializar
    }
    
    public static Inventario obtenerInstancia() {
        if (instancia == null) {
            instancia = new Inventario();
        }
        return instancia;
    }
    
    public void agregarPaquete(Paquete paquete) {
        paquetes.add(paquete);
        guardarInventarioEnArchivo();
    }
    
    public void eliminarPaquete(Paquete paquete) {
        paquetes.remove(paquete);
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
    
    public ArrayList<Paquete> obtenerPaquetesPendientes() {
        ArrayList<Paquete> paquetesPendientes = new ArrayList<>();
        for (Paquete paquete : paquetes) {
            if (paquete.obtenerEstado() instanceof Pendiente) {
                paquetesPendientes.add(paquete);
            }
        }
        return paquetesPendientes;
    }
    
    public ArrayList<Paquete> obtenerPaquetes() {
        return paquetes;
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
    

}
