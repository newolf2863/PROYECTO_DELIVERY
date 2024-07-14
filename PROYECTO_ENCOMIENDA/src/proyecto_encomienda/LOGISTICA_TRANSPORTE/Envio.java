/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author juand_jus2zd
 */
public class Envio {
    private int IdEnvio;
    public String descripcion;

    public Envio(int IdEnvio, String descripcion) {
        this.IdEnvio = IdEnvio;
        this.descripcion = descripcion;
    }
    
    public int verificarEstadoEnvio(){
        return 0;
    }
    
    public boolean notificar(){
        return false;
    }

    public int getIdEnvio() {
        return IdEnvio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Envio{" + "IdEnvio=" + IdEnvio + ", descripcion=" + descripcion + '}';
    }
    
    
}
