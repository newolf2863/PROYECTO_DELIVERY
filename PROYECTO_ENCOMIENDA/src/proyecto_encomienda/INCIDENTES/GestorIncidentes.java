package proyecto_encomienda.INCIDENTES;

import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Inventario;
import java.sql.Connection;

public class GestorIncidentes {

    private Inventario inventario;
    private Connection cnx;

    public GestorIncidentes(Inventario inventario, Connection cnx) {
        this.inventario = inventario;
        this.cnx = cnx;
    }

    public void crearIncidente(Incidente incidente, int idPaquete) {
        // Lógica para crear y registrar el incidente
        incidente.registrarIncidente();
        incidente.guardarPaquete();
        incidente.notificarCliente();
        
    }
    
    public void actualizarIncidente(Incidente incidente, int idPaquete){
        //incidente.actualizarIncidente();
    }
}

