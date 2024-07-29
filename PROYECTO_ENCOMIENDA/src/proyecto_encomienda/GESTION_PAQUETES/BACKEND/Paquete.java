package proyecto_encomienda.GESTION_PAQUETES.BACKEND;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyecto_encomienda.GESTOR_PERFILES.Perfil;

public class Paquete {

    private EstadoDelPaquete estado;
    private Seguimiento seguimiento;
    private String codigoTracking;
    private double peso;
    private double ancho;
    private double largo;
    private double espesor;
    private String contenido;
    private String direccionDestino;
    private String provinciaOrigen;
    private String provinciaDestino;
    private String remitente;
    private int idPaquete;
    

    public Paquete(String codigoTracking, double ancho, double largo, String contenido, String destino) {
        this.estado = new Pendiente(this); // Asume que Pendiente es una subclase de EstadoDelPaquete
        this.seguimiento = new Seguimiento(estado); // Asume que Seguimiento está correctamente definido
        this.codigoTracking = codigoTracking;
        this.ancho = ancho;
        this.largo = largo;
        this.contenido = contenido;
        this.direccionDestino = destino;
    }

    public Paquete(String codigoTracking, double ancho, double largo, double espesor, double peso, String contenido, String remitente, String provinciaOrigen, String provinciaDestino, String direccionDestino) {
        this.estado = new Pendiente(this);
        this.seguimiento = new Seguimiento(estado);
        this.codigoTracking = codigoTracking;
        this.ancho = ancho;
        this.largo = largo;
        this.espesor = espesor;
        this.peso = peso;
        this.contenido = contenido;
        this.remitente = remitente;
        this.provinciaOrigen = provinciaOrigen;
        this.provinciaDestino = provinciaDestino;
        this.direccionDestino = direccionDestino;
    }

    public void cambiarEstado(EstadoDelPaquete estado) {
        this.estado = estado;
        seguimiento.notificar(estado); // Asume que Seguimiento tiene el método notificar
    }

    public ArrayList<String> obtenerHistorialEstados() {
        return seguimiento.obtenerEstadosAnteriores(); // Asume que Seguimiento tiene el método obtenerEstadosAnteriores
    }

    public EstadoDelPaquete obtenerEstado() {
        return estado;
    }
      
    
    
    public void iniciarEnvio() {
        estado.iniciarEnvio(); // Llama al método iniciarEnvio del estado actual
    }
     
  
    public void completarEnvio() {
        estado.completarEnvio(); // Asume que EstadoDelPaquete tiene el método completarEnvio
    }

    public EstadoDelPaquete getEstado() {
        return estado;
    }

    public void setEstado(String nuevoEstado) {
        this.estado.setEstado(nuevoEstado);
        seguimiento.notificar(this.estado);
    }

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }

    public String getCodigoTracking() {
        return codigoTracking;
    }

    public void setCodigoTracking(String codigoTracking) {
        this.codigoTracking = codigoTracking;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double[] getVolumen() {
        return new double[]{ancho, largo, espesor};
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }
    
    public void setEspesor(double espesor) {
        this.espesor = espesor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    /*
    public Perfil getRemitente() {
        return remitente;
    }

    public void setRemitente(Perfil remitente) {
        this.remitente = remitente;
    }
    */
    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    /*
    public static void ingresarPaquete(Connection cnx, Paquete paquete) {
        String sql = "INSERT INTO Paquete (idPaquete, peso,"
                + " ancho, largo, contenido, remitente, direccionDestino,estado)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?,'Pendiente')";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            stmt.setInt(1, paquete.getIdPaquete());
            stmt.setDouble(2, paquete.getPeso());
            stmt.setDouble(3, paquete.getAncho());
            stmt.setDouble(4, paquete.getLargo());
            stmt.setString(5, paquete.getContenido());
            stmt.setString(6, paquete.getRemitente());
            stmt.setString(7, paquete.getDireccionDestino());
            stmt.executeUpdate();

            // Mostrar mensaje de éxito en una ventana emergente
            JOptionPane.showMessageDialog(null, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
    @Override
    public String toString() {
        return "Paquete{"
                + "codigoTracking='" + codigoTracking + '\''
                + ", ancho=" + ancho
                + ", largo=" + largo
                + ", contenido='" + contenido + '\''
                + ", direccionDestino='" + direccionDestino + '\''
                + ", estado=" + estado
                + '}';
    }
    
}
