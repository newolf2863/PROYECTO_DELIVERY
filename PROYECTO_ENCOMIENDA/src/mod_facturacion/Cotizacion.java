package mod_facturacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;

import java.util.ArrayList;

public final class Cotizacion {
    private static Cotizacion instancia;
    private ArrayList<Factura> facturas;

    private Cotizacion() {
        facturas = new ArrayList<>();
    }

    public static Cotizacion obtenerInstancia() {
        if (instancia == null) {
            instancia = new Cotizacion();
        }
        return instancia;
    }

    public static Precio obtenerPrecioPaquete(Paquete paquete) {
        Precio precio = new Precio(
                paquete, new PrecioPaquete(2, 2), new PrecioDistancia(0.01), new Impuesto(0.12));
        return precio;
    }

    public void emitirFacturaPaquete(Paquete paquete) {
        Precio precio = new Precio(
                paquete, new PrecioPaquete(5, 5), new PrecioDistancia(0.2), new Impuesto(0.12));
        facturas.add(new Factura(getSiguienteCodigoFactura() ,paquete, precio));
        guardarCotizacion();
    }
    
     public String getSiguienteCodigoFactura() {
        if (facturas.isEmpty()) {
            return "1";
        }
        int codigo = Integer.parseInt(facturas.get(facturas.size() - 1).obtenerCodigo());
        codigo++;
        return String.valueOf(codigo);
    }
     
    public ArrayList<Factura> obtenerFacturas(){
         return facturas;
    }
     
    public void guardarCotizacion() {
        String filePath = "src\\archivos\\facturas.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(facturas);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void cargarCotizacion() {
        String filePath = "src\\archivos\\facturas.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            facturas = (ArrayList<Factura>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existe el archivo");
        }
    }
    
}
