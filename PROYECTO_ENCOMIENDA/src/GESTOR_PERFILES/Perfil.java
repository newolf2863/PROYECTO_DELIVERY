package GESTOR_PERFILES;

import java.util.ArrayList;
import java.util.List;

public abstract class Perfil {

    private final String nombre;
    private final String RUC;
    private String direccion;
    private String telefono;
    private String email;


    public Perfil(String nombre, String RUC, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.RUC = RUC;
        this.telefono = telefono;
    }

    public abstract void editarPerfil(List<String> datos);

    public abstract List<String> obtenerDatos();

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRUC() {
        return RUC;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
