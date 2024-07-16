package GESTOR_PERFILES.GUIs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {

    private JPanel panelCampos;
    private JButton btnRegistrar;
    private JButton btnRegresar;
    private List<JTextField> camposTexto;

    public GUI(String tipoUsuario) {
        setTitle("Registro - " + tipoUsuario);
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

        switch (tipoUsuario) {
            /*
            case "Recepcionista":
                agregarCamposRecepcionista();
            case "Conductor":
                agregarCamposConductor();
             */
            case "Remitente":
                agregarCamposRemitente();
        }

        btnRegistrar = new JButton("Registrar");
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

    /*
    private void agregarCamposConductor() {

    }
     */
    private void agregarCamposRemitente() {
        agregarCampo("Nombre de la Empresa");
    }

    private void agregarCampo(String titulo) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espacio alrededor de los componentes
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nuevoTitulo = new JLabel(titulo);
        JTextField nuevoCampo = new JTextField(10);
        nuevoCampo.setPreferredSize(new Dimension(200, 25));

        // Añadir el título al layout
        gbc.gridx = 0;
        gbc.gridy = panelCampos.getComponentCount() / 2;
        gbc.gridwidth = 1;
        panelCampos.add(nuevoTitulo, gbc);

        // Añadir el campo de texto al layout
        gbc.gridx = 1;
        panelCampos.add(nuevoCampo, gbc);

        camposTexto.add(nuevoCampo);
        panelCampos.revalidate();
        panelCampos.repaint();
    }

    private void registrar() {
        // Lógica para registrar los datos
        for (JTextField campo : camposTexto) {
            System.out.println(campo.getText());
        }
        System.out.println("Datos registrados");
    }

    private void regresar() {
        this.dispose();
        new TipoUsuarioGUI().setVisible(true);
    }

}
