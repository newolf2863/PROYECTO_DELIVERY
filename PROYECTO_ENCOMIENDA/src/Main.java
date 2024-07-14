import GESTOR_PERFILES.Recepcionista;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Recepcionista re = new Recepcionista( "Juan Perez", "1754019304", "Cotocollao", "0980717039", "jose.merchan01@epn.edu.ec");
        String[] datos = re.obtenerDatos();


        for (int i = 0; i < datos.length; i++) {
            System.out.println(datos[i] + " " + i);
        }

    }

}
