/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.INCIDENTES;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Issac
 */

public class Inventario_0 {
    private List<Paquete> lista;
    private Date fechaIngreso;

    public Inventario_0() {
        this.lista = new ArrayList<>();
        this.fechaIngreso = new Date();
    }

    public void añadirPaquetes(Paquete paquete) {
        lista.add(paquete);
        System.out.println("Paquete añadido al inventario.");
    }

    public void verificarEstado() {
        System.out.println("Verificando el estado del inventario.");
    }

    public List<Paquete> getLista() {
        return lista;
    }

    public void setLista(List<Paquete> lista) {
        this.lista = lista;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public class Paquete {
    // Atributos y métodos de la clase Paquete
    }
}

