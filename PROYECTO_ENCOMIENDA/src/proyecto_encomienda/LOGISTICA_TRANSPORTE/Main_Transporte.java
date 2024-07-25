
package proyecto_encomienda.LOGISTICA_TRANSPORTE;

/**
 *
 * @author ediso
 */
import GESTOR_PERFILES.Conductor;
import proyecto_encomienda.LOGISTICA_TRANSPORTE.Asignacion;
import  proyecto_encomienda.LOGISTICA_TRANSPORTE.Camion;
import  proyecto_encomienda.LOGISTICA_TRANSPORTE.Carro;
import  proyecto_encomienda.LOGISTICA_TRANSPORTE.Envio;
import  proyecto_encomienda.LOGISTICA_TRANSPORTE.Reporte;
import  proyecto_encomienda.LOGISTICA_TRANSPORTE.Ubicacion;
import  proyecto_encomienda.LOGISTICA_TRANSPORTE.Vehiculo;
import proyecto_encomienda.GESTION_PAQUETES.BACKEND.Paquete;


import java.util.ArrayList;
import java.util.List;

public class Main_Transporte {
    public static void main(String[] args) {
        // Crear instancias de conductores
        Conductor conductor1 = new Conductor("Juan Perez", "1745265689", "Quitumbe", "0985216452", "juan.perez@example.com", "151515155151");
        Conductor conductor2 = new Conductor("Maria Garcia", "0204513256", "Ajavi & Mariscal Sucre", "0985632419", "maria.garcia@example.com", "94449494949494");

        // Crear instancias de Ubicación
        Ubicacion ubicacion1 = new Ubicacion("Huigra", "Quito", "Pichincha", "12517");
        Ubicacion ubicacion2 = new Ubicacion("Goyes", "Guayaquil", "Guayas", "12121");

        // Crear instancia de AsignacionVehiculoConductor
        Asignacion asignacion = new Asignacion();

        // Agregar conductores a la lista de asignaciones
        asignacion.agregarConductor(conductor1);
        asignacion.agregarConductor(conductor2);

        // Crear instancias de Vehiculo
        Vehiculo vehiculo1 = new Carro("Toyota", "ABC-123", 5, ubicacion1);
        Vehiculo vehiculo2 = new Camion("Honda", "XYZ-789", 4, ubicacion2);

        // Agregar vehículos a la lista de asignaciones
        asignacion.agregarVehiculo(vehiculo1);
        asignacion.agregarVehiculo(vehiculo2);

        // Crear instancias de paquetes
        Paquete paquete1 = new Paquete("TBA777777777", 5.0, 10.0, "Libros", "Guaranda");
        Paquete paquete2 = new Paquete("TBA111111111", 10.0, 20.0, "Ropa", "Ambato");
        Paquete paquete3 = new Paquete("TBA222222222", 10.0, 20.0, "Ropa", "Riobamba");
        Paquete paquete4 = new Paquete("TBA555555555", 10.0, 20.0, "Ropa", "Rumiñahui");
        Paquete paquete5 = new Paquete("TBA999999999", 10.0, 20.0, "Ropa", "Chimbo");
        Paquete paquete6 = new Paquete("TBA333333333", 10.0, 20.0, "Ropa", "Atacames");

        // Agregar paquetes al inventario y asignar a un conductor
        List<Paquete> paquetes = new ArrayList<>();
        paquetes.add(paquete1);
        paquetes.add(paquete2);
        paquetes.add(paquete3);
        paquetes.add(paquete4);
        paquetes.add(paquete5);
        paquetes.add(paquete6);

        // Asignar paquetes automáticamente a los vehículos y conductores
        asignacion.asignarVehiculosYPaquetesAutomatica(paquetes);

        // Imprimir las asignaciones actuales
        asignacion.imprimirAsignaciones();

        // Crear envíos basados en las asignaciones
        List<Envio> envios = new ArrayList<>();
        for (Conductor conductor : asignacion.getListaAsignacionesConductor()) {
            Vehiculo vehiculo = asignacion.getVehiculoAsignado(conductor);
            List<Paquete> paquetesAsignados = asignacion.getPaquetesAsignados(conductor);
            if (paquetesAsignados != null && !paquetesAsignados.isEmpty()) {
                Ubicacion ubicacion = vehiculo.getUbicacion();
                Envio envio = new Envio("Envio para " + conductor.getNombre(), conductor, vehiculo, asignacion.getFechaAsignacion(conductor), ubicacion, paquetesAsignados);
                envios.add(envio);
            }
        }

        /*
        
        // Crear instancias de reportes
        int i = 1;
        for (Envio envio : envios) {
            Reporte reporte = new Reporte(envio);
            System.out.println("*****************************************************************************************");
            System.out.println("***********************REPORTE DEL ENVIO " + i + " ***********************");
            reporte.generarReporte();
            System.out.println("*****************************************************************************************");
            System.out.println("***********************INFORMACION DEL ENVIO" + i + "***********************");
            envio.imprimirEnvio();
            i++;
        }
        */

        Reporte.generarYMostrarReportes(envios);
    }
}
