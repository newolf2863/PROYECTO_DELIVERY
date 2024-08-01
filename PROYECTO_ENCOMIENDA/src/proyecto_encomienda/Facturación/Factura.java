package proyecto_encomienda.Facturación;

import java.time.LocalDate;
import java.util.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class Factura {

    private static int idFac = 0; // Inicializar ID de facturas
    private int id;
    private Paquete paquete;
    private Precio precio;

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
    public Factura(Paquete entrega, String doc, String name, String lastname, String phone, String dir, String email, boolean nat, boolean country, Date fechaEmision) {
        this.id = idFac++;
        this.paquete = entrega;
        this.documento = doc;
        this.names = name;
        this.lastnames = lastname;
        this.telefono = phone;
        this.direction = dir;
        this.email = email;
        this.natural = nat;
        this.country = country;
        this.fechaEmision = fechaEmision;
        
        this.bussinessname = "Envios SA.";
        this.RUC = "0403020100001";
        this.bussinessdirection = "Av. Monteverde y Paez";
        this.bussinesphone = "0987654321";
    }

    // Método para calcular los precios y el IVA
    public void calcularPrecios() {
        this.precio = new Precio(this.paquete);
        this.precio.calcularTotal();

        this.subtotal = precio.getSubtotal();
        this.total = precio.getPrecioFinal();
        this.iva = this.total - this.subtotal; // Corrección de cálculo de IVA
    }

public void insertarFactura(Connection cnx) {
        String sql = "INSERT INTO Factura (documento, names, lastnames, telefono, direction, email, is_natural, country, fechaEmision, subtotal, total, iva) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            stmt.setString(1, documento);
            stmt.setString(2, names);
            stmt.setString(3, lastnames);
            stmt.setString(4, telefono);
            stmt.setString(5, direction);
            stmt.setString(6, email);
            stmt.setBoolean(7, natural);
            stmt.setBoolean(8, country);
            stmt.setDate(9, new java.sql.Date(fechaEmision.getTime()));
            stmt.setDouble(10, subtotal);
            stmt.setDouble(11, total);
            stmt.setDouble(12, iva);

            stmt.executeUpdate();
            System.out.println("Factura insertada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public static Factura buscarFacturaPorId(Connection cnx, int id) {
        String sql = "SELECT * FROM factura WHERE id = ?";
        Factura factura = null;

        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Recuperar los datos del ResultSet
                // Nota: Si el Paquete está en una tabla separada, deberás recuperarlo de esa tabla.
                // Aquí solo se recuperan los datos de Factura.
                factura = new Factura(
                    null, // En este caso, el Paquete no se recupera
                    rs.getString("documento"),
                    rs.getString("names"),
                    rs.getString("lastnames"),
                    rs.getString("telefono"),
                    rs.getString("direction"),
                    rs.getString("email"),
                    rs.getBoolean("is_natural"),
                    rs.getBoolean("country"),
                    rs.getDate("fechaEmision")
                );
                factura.subtotal = rs.getDouble("subtotal");
                factura.total = rs.getDouble("total");
                factura.iva = rs.getDouble("iva");
                factura.id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return factura;
    }

    // Getters y Setters si son necesarios

    // Getters
    public String getDocumento() {
        return documento;
    }

    public String getNames() {
        return names;
    }

    public String getLastnames() {
        return lastnames;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDirection() {
        return direction;
    }

    public String getEmail() {
        return email;
    }

    public boolean isNatural() {
        return natural;
    }

    public boolean isCountry() {
        return country;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }

    public double getIva() {
        return iva;
    }
}
