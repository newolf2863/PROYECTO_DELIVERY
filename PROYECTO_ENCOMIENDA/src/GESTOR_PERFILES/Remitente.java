package GESTOR_PERFILES;

import java.util.Arrays;
import java.util.List;

public class Remitente extends Perfil{

    private String empresa;
    private String nombreEmpresa;

    public Remitente(String nombre, String RUC, String direccion, String telefono, String email, String empresa, String nombreEmpresa) {
        super(nombre, RUC, direccion, telefono, email);
        this.empresa = empresa;
        this.nombreEmpresa = nombreEmpresa;
    }


    @Override
    public void editarPerfil(List<String> datos) {
        setDireccion(datos.get(0));
        setTelefono(datos.get(1));
        setEmail(datos.get(2));
        setEmpresa(datos.get(3));
        setNombreEmpresa(datos.get(4));
    }

    @Override
    public List<String> obtenerDatos() {
        return Arrays.asList(getNombre(), getRUC(), getDireccion(), getTelefono(), getEmail(), getEmpresa(), getNombreEmpresa());
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}
