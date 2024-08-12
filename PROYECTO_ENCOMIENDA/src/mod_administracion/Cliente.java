package mod_administracion;

import mod_incidentes.PaqueteNoTieneIncidente;
import mod_incidentes.PaqueteYaTieneIncidente;
import mod_paquetes.Entregado;
import mod_paquetes.Paquete;

/**
 * Representa un cliente que puede reportar incidentes y consultar el estado de
 * los paquetes.
 * Extiende la clase {@link Usuario} para incluir funcionalidades específicas
 * para clientes.
 */
public class Cliente extends Usuario {

    /**
     * Constructor que inicializa los datos del cliente.
     *
     * @param nombres        el nombre del cliente.
     * @param apellidos      los apellidos del cliente.
     * @param identificacion el identificador único del cliente.
     * @param direccion      la dirección del cliente.
     * @param telefono       el número de teléfono del cliente.
     * @param email          la dirección de correo electrónico del cliente.
     */
    public Cliente(String nombres, String apellidos, String identificacion, String direccion, String telefono,
            String email) {
        super(nombres, apellidos, identificacion, direccion, telefono, email);
    }

    @Override
    public void reportarIncidente(Paquete paquete) throws ReporteNoPermitido, PaqueteYaTieneIncidente {
        if (paquete == null || !(paquete.obtenerEstado() instanceof Entregado)) {
            throw new ReporteNoPermitido();
        }
        gestorIncidente.crearIncidente(paquete);
    }
    
    
    @Override
    public void resolverIncidente(Paquete paquete, String[] argumentos) throws ReporteNoPermitido, PaqueteNoTieneIncidente {
        if (paquete == null || !(paquete.obtenerEstado() instanceof Entregado)) {
            throw new ReporteNoPermitido();
        }
        gestorIncidente.solucionarIncidente(paquete, argumentos);
    }

    public boolean consultarPaquete(Paquete paquete) {
        return paquete.getRemitente().getCedula().equals(this.getCedula());
    }
}
