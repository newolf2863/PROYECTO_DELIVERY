package mod_transporte;

import java.io.Serializable;

public class Vehiculo implements Serializable {
    private String numeroPlaca;
    private double capacidad;   // 35 a 45 m3
    private Provincia ubicacion;

    public Vehiculo(String numeroPlaca, double capacidad, Provincia ubicacion) {
        this.numeroPlaca = numeroPlaca;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }



    public double getCapacidad() {
        return capacidad;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public Provincia getUbicacion() {
        return ubicacion;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "numeroPlaca='" + numeroPlaca + '\'' +
                '}';
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }
    
}
