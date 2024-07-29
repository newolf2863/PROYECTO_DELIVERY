package proyecto_encomienda.GESTOR_PERFILES;


import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Remitente extends Perfil{

    private String nombreEmpresa;
    private int id = 0;

    public Remitente(String nombre, String RUC, String direccion, String telefono, String email, String nombreEmpresa) {
        super(nombre, RUC, direccion, telefono, email);
        this.nombreEmpresa = nombreEmpresa;
        this.id++;
    }


    @Override
    public void editarPerfil(List<String> datos) {
        setDireccion(datos.get(0));
        setTelefono(datos.get(1));
        setEmail(datos.get(2));
        setNombreEmpresa(datos.get(3));
    }

    @Override
    public List<String> obtenerDatos() {
        return Arrays.asList(getNombre(), getCI_RUC(), getDireccion(), getTelefono(), getEmail(), getNombreEmpresa());
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

        String datosRecepcionista = String.format("ID: %s, Nombre: %s, Dirección: %s, Teléfono: %s, Email: %s, Nombre Empresa: %s",
                getCI_RUC(), getNombre(), getDireccion(), getTelefono(), getEmail(), getNombreEmpresa());

        stringBuilder.append(datosRecepcionista).append(System.lineSeparator());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}
