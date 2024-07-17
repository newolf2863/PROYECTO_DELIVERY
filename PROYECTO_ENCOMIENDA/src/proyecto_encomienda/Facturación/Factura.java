
package proyecto_encomienda.Facturación;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private int id;
    private Paquete entrega;
    private Usuario cliente;
    private Date fechaEmision;
    private double montoTotal;

    // Constructor
    public Factura(int id, Paquete entrega, Usuario cliente, Date fechaEmision) {
        this.id = id;
        this.entrega = entrega;
        this.cliente = cliente;
        this.fechaEmision = fechaEmision;
    }

    // Métodos
    public void consultarFactura() {
        // Implementación del método
    }

    public void emitirFactura() {
        Precio precio = new Precio();
        montoTotal = precio.calcularTotal(entrega);
        System.out.println("Factura emitida. Monto total: " + montoTotal);
    }

    public void anularFactura() {
        // Implementación del método
    }

    public void calcularTotal() {
        // Implementación del método
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paquete getEntrega() {
        return entrega;
    }

    public void setEntrega(Paquete entrega) {
        this.entrega = entrega;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
