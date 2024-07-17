package GESTOR_PERFILES;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Recepcionista extends Perfil{

    public Recepcionista(String nombre, String RUC, String direccion, String telefono, String email) {
        super(nombre, RUC, direccion, telefono, email);
    }

    @Override
    public void editarPerfil(List<String> datos) {
        setDireccion(datos.get(0));
        setTelefono(datos.get(1));
        setEmail(datos.get(2));
    }

    @Override
    public List<String> obtenerDatos() {
        return Arrays.asList(getNombre(), getCI_RUC(), getDireccion(), getTelefono(), getEmail());
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

        String datosRecepcionista = String.format("ID: %s, Nombre: %s, Dirección: %s, Teléfono: %s, Email: %s",
                getCI_RUC(), getNombre(), getDireccion(), getTelefono(), getEmail());

        stringBuilder.append(datosRecepcionista).append(System.lineSeparator());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarRecepcionPaquete(){

    }

}
