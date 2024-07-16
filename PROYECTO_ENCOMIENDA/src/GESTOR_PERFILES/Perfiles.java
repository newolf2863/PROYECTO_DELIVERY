package GESTOR_PERFILES;

import java.util.ArrayList;
import java.util.List;

public class Perfiles {

    private List<Recepcionista> recepcionistas;
    private List<Conductor> conductores;

    public Perfiles() {

        recepcionistas = new ArrayList<>();
        conductores = new ArrayList<>();

    }

    public void agregarPerfil(Perfil perfil) {

        if (perfil instanceof Recepcionista) {
            recepcionistas.add((Recepcionista) perfil);
        } else if (perfil instanceof Conductor) {
            conductores.add((Conductor) perfil);
        }

    }


}
