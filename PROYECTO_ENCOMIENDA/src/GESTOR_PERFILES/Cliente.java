package GESTOR_PERFILES;

import java.util.Arrays;
import java.util.List;

public class Cliente extends Perfil {

    public Cliente(String nombre, String RUC, String direccion, String telefono, String email) {
        super(nombre, RUC, direccion, telefono, email);
    }

    @Override
    public void editarPerfil(List<String> datos) {
        setDireccion(datos.get(0));
        setTelefono(datos.get(1));
        setEmail(datos.get(2));
    }

    @Override
    public List<String> obtenerDatos() {
        return Arrays.asList(getNombre(), getRUC(), getDireccion(), getTelefono(), getEmail());
    }

    public void pagar() {
        //TODO implementar metodo pagar
    }

    public void asignarDatosDestinatario() {
        //TODO implementar metodo asignarDatosDestinatario
    }


}
