package mod_facturacion;

import java.io.Serializable;
import mod_paquetes.Paquete;
import java.util.ArrayList;

public class Precio implements Serializable{
    private double precioTotalPaquete;
    private ArrayList<CalculoPrecio> precios;

    public Precio(Paquete paquete, CalculoPrecio precioPorDefecto, CalculoPrecio ... preciosAdicionales) {
        precios = new ArrayList<>();
        precioTotalPaquete = 0;
        precioTotalPaquete += precioPorDefecto.calcularValor(paquete);
        precios.add(precioPorDefecto);
        for (CalculoPrecio precio : preciosAdicionales) {
            double monto = precio.calcularValor(paquete);
            if (monto == 0) {
                monto = precio.calcularValorDependiente(precioTotalPaquete);
            }
            precioTotalPaquete += monto;
            precios.add(precio);
        }
    }

    public void desglosarPrecioTotal() {
        for (CalculoPrecio precio : precios) {
            System.out.println(precio);
        }
    }

    public double getPrecioTotalPaquete() {
        return precioTotalPaquete;
    }
    
    public ArrayList<CalculoPrecio> obtenerPreciosIndividuales() {
        return precios;
    }
}
