package proyecto_encomienda.Facturación;



public class Paquete {

    private double peso;
    private double ancho;
    private double largo;
    private String contenido;
    private String direccionDestino;
    private int idPaquete;


    public Paquete(int idPaquete, double ancho, double peso, double largo, String contenido, String remitente, String destino) {

        this.idPaquete = idPaquete;
        this.ancho = ancho;
        this.largo = largo;
        this.peso = peso;
        this.contenido = contenido;
        this.direccionDestino = destino;
    }





    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
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
}
