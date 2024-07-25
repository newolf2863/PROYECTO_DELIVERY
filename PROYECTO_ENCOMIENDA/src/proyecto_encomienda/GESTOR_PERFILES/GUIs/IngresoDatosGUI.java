package proyecto_encomienda.GESTOR_PERFILES.GUIs;

import proyecto_encomienda.GESTOR_PERFILES.Conductor;
import proyecto_encomienda.GESTOR_PERFILES.Recepcionista;
import proyecto_encomienda.GESTOR_PERFILES.Remitente;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class IngresoDatosGUI extends JFrame {

    private JPanel panelCampos;
    private JButton btnRegistrar;
    private JButton btnRegresar;
    private List<JTextField> camposTexto;
    private String tipoUsuario;
    private String tipoAcción;

    public IngresoDatosGUI(String tipoUsuario, String tipoAcción) {

        this.tipoUsuario = tipoUsuario;
        this.tipoAcción = tipoAcción;

        setTitle(tipoAcción + " - " + tipoUsuario);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panelCampos = new JPanel(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(panelCampos);

        camposTexto = new ArrayList<>();

        agregarCampo("Nombre");
        agregarCampo("CI/RUC");
        agregarCampo("Dirección");
        agregarCampo("Teléfono");
        agregarCampo("Email");

        if(tipoUsuario.equals("Recepcionista")){

        } else if (tipoUsuario.equals("Conductor")) {
            agregarCamposConductor();
        } else if (tipoUsuario.equals("Remitente")) {
            agregarCamposRemitente();
        }

        btnRegistrar = new JButton("Ingresar");
        btnRegresar = new JButton("Regresar");
        btnRegistrar.addActionListener(e -> registrar());
        btnRegresar.addActionListener(e -> regresar());

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnRegresar);

        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    /*
    private void agregarCamposRecepcionista() {

    }
    */

    private void agregarCamposConductor() {
        agregarCampo("Licencia:");
    }

    private void agregarCamposRemitente() {
        agregarCampo("Nombre de la Empresa:");
    }

    private void agregarCampo(String titulo) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espacio alrededor de los componentes
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nuevoTitulo = new JLabel(titulo);
        JTextField nuevoCampo = new JTextField(10);
        nuevoCampo.setPreferredSize(new Dimension(200, 25));

        gbc.gridx = 0;
        gbc.gridy = panelCampos.getComponentCount() / 2;
        gbc.gridwidth = 1;
        panelCampos.add(nuevoTitulo, gbc);

        gbc.gridx = 1;
        panelCampos.add(nuevoCampo, gbc);

        camposTexto.add(nuevoCampo);
        panelCampos.revalidate();
        panelCampos.repaint();
    }

    private void registrar() {

        if(tipoUsuario.equals("Recepcionista")){
            new Recepcionista(camposTexto.get(0).getText(), camposTexto.get(1).getText(),
                    camposTexto.get(2).getText(), camposTexto.get(3).getText(),
                    camposTexto.get(4).getText()).guardarDatos("PROYECTO_ENCOMIENDA/src/GESTOR_PERFILES/datos/recepcionistas.txt");
        } else if (tipoUsuario.equals("Conductor")) {
            new Conductor(camposTexto.get(0).getText(), camposTexto.get(1).getText(),
                    camposTexto.get(2).getText(), camposTexto.get(3).getText(),
                    camposTexto.get(4).getText(),
                    camposTexto.get(5).getText()).guardarDatos("PROYECTO_ENCOMIENDA/src/GESTOR_PERFILES/datos/conductores.txt");
        } else if (tipoUsuario.equals("Remitente")) {
            new Remitente(camposTexto.get(0).toString(), camposTexto.get(1).getText(),
                    camposTexto.get(2).getText(), camposTexto.get(3).getText(),
                    camposTexto.get(4).getText(),
                    camposTexto.get(5).getText()).guardarDatos("PROYECTO_ENCOMIENDA/src/GESTOR_PERFILES/datos/remitentes.txt");
        }
        JOptionPane.showMessageDialog(null, "¡Perfil ingresado con éxito!");
        for(JTextField campo : camposTexto){
            campo.setText("");
        }
    }

    private void regresar() {
        this.dispose();
        new TipoUsuarioGUI(tipoAcción).setVisible(true);
    }

}
