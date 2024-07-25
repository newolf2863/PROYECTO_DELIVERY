
package proyecto_encomienda.LOGISTICA_TRANSPORTE;
/**
 *
 * @author ediso
 */


import java.util.Date;
import java.util.List;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Paquete;
import proyecto_encomienda.GESTOR_PERFILES.Conductor;


public class Envio {
    private String descripcion;
    private Conductor conductor;
    private Vehiculo vehiculo;
    private Date fechaAsignacion;
    private String estado;
    private Ubicacion ubicacion;
    private List<Paquete> paquetes;

    // Constructor
    public Envio(String descripcion, Conductor conductor, Vehiculo vehiculo, Date fechaAsignacion, Ubicacion ubicacion, List<Paquete> paquetes) {
        this.descripcion = descripcion;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.fechaAsignacion = fechaAsignacion;
        this.ubicacion = ubicacion; 
        this.estado = "No entregado"; // Estado inicial
        this.paquetes = paquetes;
    }

    // Getters
    public String getDescripcion() {
        return descripcion;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public String getEstado() {
        return estado;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    // Método para actualizar el estado del envío
    public void setEstado(String nuevoEstado) {
        if (this.estado.equals("No entregado") && nuevoEstado.equals("Entregado")) {
            this.estado = nuevoEstado;
        } else if (this.estado.equals("Entregado")) {
            System.out.println("El envío ya ha sido entregado");
        }
    }

    // Método para imprimir la información del envío
    public void imprimirEnvio() {
        
        System.out.println("Descripción: " + descripcion);
        System.out.println("Conductor: " + conductor.getNombre());
        System.out.println("Vehículo: " + vehiculo.getMarca() + " " + vehiculo.getPlaca());
        System.out.println("Fecha de Asignación del envío: " + fechaAsignacion);
        System.out.println("Estado: " + estado);
        if (!paquetes.isEmpty()) {
            System.out.println("Paquetes enviados:");
            System.out.println("CÓDIGO TRANCKING DEL PAQUETE ----- DIRECCION DE ENTREGA");
            for (Paquete paquete : paquetes) {
                System.out.println(paquete.getCodigoTracking()+ "  -----  " + paquete.getDireccionDestino());

                System.out.println(paquete.getCodigoTracking() + "  -----  " + paquete.getDireccionDestino());

            }
        }
        System.out.println();
    }
}

