package mod_paquetes;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Seguimiento implements Serializable {
    private EstadoDelPaquete estadoActual;
    private ArrayList<String> estadosAnteriores;
    private String registroIncidente;
    private String resolucionIncidente;

    public Seguimiento(EstadoDelPaquete estado) {
        this.estadoActual = estado;
        this.estadosAnteriores = new ArrayList<>();
    }

    public void notificar(EstadoDelPaquete estado) {
        estadosAnteriores.add(estadoActual.toString());
        this.estadoActual = estado;
    }

    public boolean verificarEntregaPendiente() {
        return estadoActual instanceof Pendiente;
    }
    
    public EstadoDelPaquete obtenerEstado() {
        return this.estadoActual;
    }

    public ArrayList<String> obtenerEstadosAnteriores() {
        return estadosAnteriores;
    }
    
    public void registrarIncidente(String definicion) {
        registroIncidente = definicion;
    }
    
    public void resolverIncidente(String definicion) {
        resolucionIncidente = definicion;
        registroIncidente = "";
    }
    
    public String obtenerRegistroIncidente() {
        return this.registroIncidente;
    }
    
    public String obtenerResolucion() {
        return this.resolucionIncidente;
    }

    public void limpiarIncidente() {
        JOptionPane.showMessageDialog(null, "El incidente ha sido resuelto exitosamente.", "Incidente Resuelto", JOptionPane.INFORMATION_MESSAGE);
    }
}
