package GESTOR_PERFILES;

import java.util.Arrays;
import java.util.List;

public class Recepcionista extends Perfil{

    private int turno = 0;


    public Recepcionista(String nombre, String RUC, String direccion, String telefono, String email) {
        super(nombre, RUC, direccion, telefono, email);
        this.turno++;
    }

    @Override
    public void editarPerfil(List<String> datos) {
        setDireccion(datos.get(0));
        setTelefono(datos.get(1));
        setEmail(datos.get(2));
    }

    @Override
    public List<String> obtenerDatos() {
        return Arrays.asList(getNombre(), getCI_RUC(), getDireccion(), getTelefono(), getEmail());
    }

    public void registrarRecepcionPaquete(){

    }

}
