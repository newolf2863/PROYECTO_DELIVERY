/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.INCIDENTES;

/**
 *
 * @author Issac
 */
public class GestorIncidentes {
    private Inventario inventario;

    public GestorIncidentes(Inventario inventario) {
        this.inventario = inventario;
    }

    public void guardarPaquete(Incidente incidente) {
        incidente.guardarPaquete();
    }
}
