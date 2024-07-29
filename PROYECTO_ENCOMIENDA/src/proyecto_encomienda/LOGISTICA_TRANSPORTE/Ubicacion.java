/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.LOGISTICA_TRANSPORTE;

/**
 *
 * @author ediso
 */
public class Ubicacion {
    private String direccionCalle;
    private String ciudad;
    private String provincia;
    private String codigoPostal;

    // Constructor
    public Ubicacion(String direccionCalle, String ciudad, String provincia, String codigoPostal) {
        this.direccionCalle = direccionCalle;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
    }

    // Getters
    public String getDireccionCalle() {
        return direccionCalle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    // Método para obtener la dirección completa
    public String obtenerDireccionCompleta() {
        return "Calle: " + direccionCalle + ", Cuidad: " + ciudad + ", Provincia: " + provincia + ", Código postal: " + codigoPostal;
    }
}
