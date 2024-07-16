package GESTOR_PERFILES;

import java.util.Arrays;
import java.util.List;

public class Conductor extends Perfil {

    private String licencia;

    public Conductor(String nombre, String RUC, String direccion, String telefono, String email, String licencia) {
        super(nombre, RUC, direccion, telefono, email);
        this.licencia = licencia;
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
        return Arrays.asList(getNombre(), getCI_RUC(), getDireccion(), getTelefono(), getEmail(), getLicencia());
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

}
