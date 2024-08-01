package proyecto_encomienda.Facturación;

/**
 * Clase para calcular el precio de un envío basado en la distancia.
 * @author Xelan
 */
public class PrecioDistancia implements CalculoPrecio {
    private double precioPorKm;
    private double precio;
    private final int[] distancias;
    private final String[] ciudades;

    // Constructor
    public PrecioDistancia() {
        this.precioPorKm = 0.0304;
        this.distancias = new int[] {
            111, 391, 327, 432, 300, 204, 390, 112, 70, 640, 347, 527, 265, 
            329, 300, 213, 0, 165, 189, 239, 698, 14, 112, 153, 307, 106, 
            243, 818, 587, 362, 88, 561, 286, 224, 209, 294, 449, 556, 357, 
            236 
        };

        this.ciudades = new String[] {
            "Ambato", "Azogues", "Babahoyo", "Cuenca", "Esmeraldas", "Guaranda", 
            "Guayaquil", "Ibarra", "Latacunga", "Loja", "Macas", "Machala", 
            "Nueva Loja", "Portoviejo", "Pto. Fco. De Orellana", "Puyo", "Quito", 
            "Riobamba", "Tena", "Tulcán", "Zamora", "Aloag", "Sto. Domingo", 
            "Baños", "Bahía de Caraquez", "Baeza", "Rumichaca", "Macara", 
            "Huaquillas", "Manta", "Otavalo", "Salinas", "San Lorenzo", 
            "Quevedo", "Quininde", "Pte. San Miguel", "Pto. Putumayo", 
            "Pto. Morona", "Muisne", "Pedernales"
        };
    }

    // Método para obtener la distancia de una ciudad
    public int obtenerDistancia(String ciudad) {
        for (int i = 0; i < ciudades.length; i++) {
            if (ciudades[i].equalsIgnoreCase(ciudad)) {
                return distancias[i];
            }
        }
        // Si la ciudad no se encuentra, devuelve -1
        return -1;
    }

    // Implementación del método calcularValor de la interfaz CalculoPrecio
    @Override
    public void calcularValor(Paquete paquete) {
        String destino = paquete.getDireccionDestino();
        int distancia = obtenerDistancia(destino);
        
        if (distancia < 0) {
            System.out.println("Provincia no encontrada");
            this.precio = 0;
        } else if (distancia > 0) {
            this.precio = distancia * precioPorKm;
            System.out.println("Precio de envío: " + this.precio);
        } else {
            this.precio = 1.0; // Precio mínimo en caso de distancia 0
        }
    }

    // Getters y setters
    public double getPrecio() {
        return precio;
    }

    public double getPrecioPorKm() {
        return precioPorKm;
    }

    public void setPrecioPorKm(double precioPorKm) {
        this.precioPorKm = precioPorKm;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
