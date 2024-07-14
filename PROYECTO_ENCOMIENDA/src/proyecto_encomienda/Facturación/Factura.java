
package proyecto_encomienda.Facturación;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Xelan
 */
public class Factura {
    private static int idFac = 1; 
    private int numFac;
    private String cliente;
    private String entrega;
    private LocalDate date;
    private ArrayList<Double> montos;
    
    public Factura(String cliente, String entrega, LocalDate date) {
        this.numFac = idFac;
        idFac++;
        this.cliente = cliente;
        this.entrega = entrega;
        this.date = date;
        this.montos = new ArrayList<>();
    }

    public int getNumFac() {
        return numFac;
    }

    public String getCliente() {
        return cliente;
    }


    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<Double> getMontos() {
        return montos;
    }

    public void addMonto(Double monto) {
        this.montos.add(monto);
    }

    public double getMontoTotal() {
        return montos.stream().mapToDouble(Double::doubleValue).sum();
    }
        @Override
    public String toString() {
        return "Factura{" +
                "numFac=" + numFac +
                ", cliente='" + cliente + '\'' +
                ", entrega='" + entrega + '\'' +
                ", date=" + date +
                ", montoTotal=" + getMontoTotal() +
                '}';
    }
}



