package GESTOR_PERFILES.GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TipoUsuarioGUI extends JFrame {

    private String tipoAcción;

    public TipoUsuarioGUI(String tipoAcción) {

        this.tipoAcción = tipoAcción;

        setTitle("Seleccionar Tipo de Usuario");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnRecepcionista = new JButton(tipoAcción + " Recepcionista");
        JButton btnConductor = new JButton(tipoAcción + " Conductor");
        JButton btnRemitente = new JButton(tipoAcción + " Remitente");
        JButton btnRegresar = new JButton("Regresar");

        btnRecepcionista.addActionListener(new TipoUsuarioActionListener("Recepcionista"));
        btnConductor.addActionListener(new TipoUsuarioActionListener("Conductor"));
        btnRemitente.addActionListener(new TipoUsuarioActionListener("Remitente"));
        btnRegresar.addActionListener(e -> regresar());

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(btnRegresar);

        panel.add(btnRecepcionista);
        panel.add(btnConductor);
        panel.add(btnRemitente);

        add(panelBotones, BorderLayout.SOUTH);
        add(panel);
        setVisible(true);
    }

    private boolean buscarExistencia(String id, String tipoUsuario) {
        String ruta = identificarRutaArchivo(tipoUsuario);
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("ID: " + id)) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private String identificarRutaArchivo(String tipoUsuario) {

        if(tipoUsuario.equals("Conductor")){

            return "PROYECTO_ENCOMIENDA/src/GESTOR_PERFILES/datos/conductores.txt";

        }else if(tipoUsuario.equals("Recepcionista")){

            return "PROYECTO_ENCOMIENDA/src/GESTOR_PERFILES/datos/recepcionistas.txt";

        } else if (tipoUsuario.equals("Remitente")) {

            return "PROYECTO_ENCOMIENDA/src/GESTOR_PERFILES/datos/remitentes.txt";

        }
        return null;
    }

    private void regresar() {
        this.dispose();
        new TipoAcciónGUI().setVisible(true);
    }

    private class TipoUsuarioActionListener implements ActionListener {

        private String tipoUsuario;

        public TipoUsuarioActionListener(String tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if(tipoAcción.equals("Edición")){
                String id = JOptionPane.showInputDialog(null,
                        "Ingrese su número de cédula o RUC.");
                if(!buscarExistencia(id, tipoUsuario)){
                    JOptionPane.showMessageDialog(null, "¡El perfil no existe!");
                    return;
                }else{
                    JOptionPane.showMessageDialog(null, "¡Perfil encontrado!");
                }
            }
            TipoUsuarioGUI.this.dispose();
            IngresoDatosGUI gui = new IngresoDatosGUI(tipoUsuario, tipoAcción);
            gui.setVisible(true);
        }
    }
}