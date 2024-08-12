package mod_paquetes;

import java.io.Serializable;
import java.util.ArrayList;

public class Seguimiento implements Serializable {
    private EstadoDelPaquete estadoActual;
    private ArrayList<String> estadosAnteriores;
    private String incidente;
    private String registroIncidente;
    private String resolucionIncidente;

    public Seguimiento(EstadoDelPaquete estado) {
        this.estadoActual = estado;
        this.estadosAnteriores = new ArrayList<>();
        this.incidente = null;
    }

    public void actualizar(EstadoDelPaquete estado) {
        estadosAnteriores.add(estadoActual.toString());
        this.estadoActual = estado;
    }

    public EstadoDelPaquete obtenerEstado() {
        return this.estadoActual;
    }

    public ArrayList<String> obtenerEstadosAnteriores() {
        return estadosAnteriores;
    }

    public void registrarIncidente(String incidente, String definicion) {
        this.incidente = incidente;
        registroIncidente = definicion;
    }

    public void registrarResolucion(String definicion) {
        resolucionIncidente = definicion;
    }

    public String obtenerRegistroIncidente() {
        return this.registroIncidente;
    }

    public String obtenerResolucion() {
        return this.resolucionIncidente;
    }
    
    public boolean tieneIncidente() {
        return this.incidente != null;
    }
    
    public String getIncidente() {
        return this.incidente;
    }
}
