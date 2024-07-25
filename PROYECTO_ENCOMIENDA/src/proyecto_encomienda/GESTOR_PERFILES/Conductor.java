package proyecto_encomienda.GESTOR_PERFILES;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Conductor extends Perfil {

    private String licencia;
    private int id;

    public Conductor(String nombre, String RUC, String direccion, String telefono, String email, String licencia) {
        super(nombre, RUC, direccion, telefono, email);
        this.licencia = licencia;
        this.id++;
    }

    @Override
    public void editarPerfil(List<String> datos) {
        setDireccion(datos.get(0));
        setTelefono(datos.get(1));
        setEmail(datos.get(2));
        setLicencia(datos.get(3));
    }

    @Override
    public List<String> obtenerDatos() {
        return Arrays.asList(getNombre(), getCI_RUC(), getDireccion(), getTelefono(), getEmail(), getLicencia());
    }

    @Override
    public void guardarDatos(String filePath) {

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {

        }

        String datosRecepcionista = String.format("ID: %s, Nombre: %s, Dirección: %s, Teléfono: %s, Email: %s, Licencia: %s",
                getCI_RUC(), getNombre(), getDireccion(), getTelefono(), getEmail(), getLicencia());

        stringBuilder.append(datosRecepcionista).append(System.lineSeparator());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public List<Paquete> consultarPaquetesAsignados(List<Asignacion> asignaciones){
        List<Paquete> paquetesAsignados = new ArrayList<>();
        for (int i = 0; i < asignaciones.size(); i++) {
            if (asignaciones.get(i).getCodigoTracking().equals())
        }
    }*/

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

}
