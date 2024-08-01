
package proyecto_encomienda.Facturación;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Factura {
    
    private  static int idFac;
    private int id;
    private Paquete paquete;
  
    private String documento;
    private String names;
    private String lastnames;
    private String telefono;
    private String direction;
    private String email;
    private boolean natural;
    private boolean country;
    
    private final String bussinessname;
    private final String RUC;
    private final String bussinessdirection;
    private final String bussinesphone;
    
    
    private Date fechaEmision;
    private double subtotal;
    private double total;
    private double iva;

    // Constructor
    public Factura(Paquete entrega, String doc, String name, String lastname, String phone, String dir, String email, String nat, String country, Date fechaEmision) {
        this.id = idFac++;
        this.paquete = entrega;
        this.documento= doc;
        this.names = name;
        this.lastnames= lastname;
        this.telefono= phone;
        this.direction= dir;
        this.email = email;
        this.natural= natural;
        this.country= this.country;
        
        this.bussinessname="Envios SA.";
        this.RUC="0403020100001";
        this.bussinessdirection="Av. Monteverde y Paez";
        this.bussinesphone="0987654321";
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
