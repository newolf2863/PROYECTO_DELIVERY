package GESTOR_PERFILES.GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipoUsuarioGUI extends JFrame {

    public TipoUsuarioGUI() {
        setTitle("Seleccionar Tipo de Usuario");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnRecepcionista = new JButton("Registrar Recepcionista");
        JButton btnConductor = new JButton("Registrar Conductor");
        JButton btnRemitente = new JButton("Registrar Remitente");

        btnRecepcionista.addActionListener(new TipoUsuarioActionListener("Recepcionista"));
        btnConductor.addActionListener(new TipoUsuarioActionListener("Conductor"));
        btnRemitente.addActionListener(new TipoUsuarioActionListener("Remitente"));

        panel.add(btnRecepcionista);
        panel.add(btnConductor);
        panel.add(btnRemitente);

        add(panel);
        setVisible(true);
    }

    private class TipoUsuarioActionListener implements ActionListener {
        private String tipoUsuario;

        public TipoUsuarioActionListener(String tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            TipoUsuarioGUI.this.dispose();
            RegistroGUI gui = new RegistroGUI(tipoUsuario);
            gui.setVisible(true);
        }
    }
}