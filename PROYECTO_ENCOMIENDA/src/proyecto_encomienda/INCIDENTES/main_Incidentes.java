/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.INCIDENTES;

/**
 *
 * @author Issac
 */
public class main_Incidentes {      
    public void iniciar(){
        Inventario inventario = new Inventario();
        GestorIncidentes gestor = new GestorIncidentes(inventario);

        Incidente errorDireccion = new ErrorDireccion();
        Incidente paquetePerdido = new PaquetePerdido();
        Incidente dañoPaquete = new DañoPaquete();
        Incidente rechazoEntrega = new RechazoEntrega();

        gestor.guardarPaquete(errorDireccion);
        gestor.guardarPaquete(paquetePerdido);
        gestor.guardarPaquete(dañoPaquete);
        gestor.guardarPaquete(rechazoEntrega);

        errorDireccion.actuar();
        paquetePerdido.actuar();
        dañoPaquete.actuar();
        rechazoEntrega.actuar();
    }
    
}
