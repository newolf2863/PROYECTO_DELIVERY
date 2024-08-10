package mod_facturacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;

import java.util.ArrayList;

/**
 * Clase singleton que gestiona las cotizaciones y facturas en el sistema de facturación.
 */
public final class Cotizacion {
    /** Instancia única de la clase Cotizacion. */
    private static Cotizacion instancia;

    /** Lista de facturas emitidas. */
    private ArrayList<Factura> facturas;

    /**
     * Constructor privado para evitar la instanciación externa.
     */
    private Cotizacion() {
        facturas = new ArrayList<>();
    }

    /**
     * Obtiene la instancia única de la clase Cotizacion.
     *
     * @return la instancia única de Cotizacion.
     */
    public static Cotizacion obtenerInstancia() {
        if (instancia == null) {
            instancia = new Cotizacion();
        }
        return instancia;
    }

    /**
     * Obtiene el precio de un paquete específico.
     *
     * @param paquete el paquete del cual se calculará el precio.
     * @return el objeto Precio que contiene el cálculo del precio del paquete.
     */
    public static Precio obtenerPrecioPaquete(Paquete paquete) {
        Precio precio = new Precio(
                paquete, new PrecioPaquete(2, 2), new PrecioDistancia(0.01), new Impuesto(0.12));
        return precio;
    }

    /**
     * Emite una factura para un paquete específico y la guarda en la lista de facturas.
     *
     * @param paquete el paquete del cual se emitirá la factura.
     */
    public void emitirFacturaPaquete(Paquete paquete) {
        Precio precio = new Precio(
                paquete, new PrecioPaquete(5, 5), new PrecioDistancia(0.2), new Impuesto(0.12));
        facturas.add(new Factura(getSiguienteCodigoFactura(), paquete, precio));
        guardarCotizacion();
    }

    /**
     * Obtiene el siguiente código de factura disponible.
     *
     * @return el siguiente código de factura.
     */
    public String getSiguienteCodigoFactura() {
        if (facturas.isEmpty()) {
            return "1";
        }
        int codigo = Integer.parseInt(facturas.get(facturas.size() - 1).obtenerCodigo());
        codigo++;
        return String.valueOf(codigo);
    }

    /**
     * Obtiene la lista de facturas emitidas.
     *
     * @return la lista de facturas.
     */
    public ArrayList<Factura> obtenerFacturas() {
        return facturas;
    }

    /**
     * Guarda la lista de facturas en un archivo serializado.
     */
    public void guardarCotizacion() {
        String filePath = "src\\archivos\\facturas.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(facturas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga la lista de facturas desde un archivo serializado.
     */
    public void cargarCotizacion() {
        String filePath = "src\\archivos\\facturas.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            facturas = (ArrayList<Factura>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existe el archivo");
        }
    }
}
