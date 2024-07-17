/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.Facturación;

/**
 *
 * @author Xelan
 */
public class PrecioPaquete implements CalculoPrecio{
     private double precioPorDimension;
    private double precioPorPeso;
    
    

    

    public PrecioPaquete(double precioFinal, double precioPorDimension, double precioPorPeso) {
        this.precioPorDimension = precioPorDimension;
        this.precioPorPeso = precioPorPeso;
    }

    public void precioAtributo(){
        
    }

    public void calcularValor(double precioPorDimension, double precioPorPeso){
        
    }
    public void actualizarParametros(double precioPorDimension, double precioPorPeso){
        
    }



    public double getPrecioPorDimension() {
        return precioPorDimension;
    }



    public void setPrecioPorDimension(double precioPorDimension) {
        this.precioPorDimension = precioPorDimension;
    }



    public double getPrecioPorPeso() {
        return precioPorPeso;
    }



    public void setPrecioPorPeso(double precioPorPeso) {
        this.precioPorPeso = precioPorPeso;
    } 
    
}
