package GESTOR_PERFILES;
import proyecto_encomienda.*;

import java.util.Arrays;
import java.util.List;

public class Conductor extends Perfil {

    private String licencia;
    private Vehiculo vehiculo;

    public Conductor(String nombre, String RUC, String direccion, String telefono, String email, String licencia, Vehiculo vehiculo) {
        super(nombre, RUC, direccion, telefono, email);
        this.licencia = licencia;
        this.vehiculo = vehiculo;
    }

    @Override
    public void editarPerfil(List<String> datos) {
        setDireccion(datos.get(0));
        setTelefono(datos.get(1));
        setEmail(datos.get(2));
        setLicencia(datos.get(3));
    }

    @Override
    public List<String> obtenerDatos() {
        return Arrays.asList(getNombre(), getRUC(), getDireccion(), getTelefono(), getEmail(), getLicencia(), vehiculo.getPlaca());
    }

    /*public List<Paquete> consultarPaquetesAsignados(List<Asignacion> asignaciones){
        List<Paquete> paquetesAsignados = new ArrayList<>();
        for (int i = 0; i < asignaciones.size(); i++) {
            if (asignaciones.get(i).getCodigoTracking().equals())
        }
    }*/

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
