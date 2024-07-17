package GESTOR_PERFILES.GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipoAcciónGUI extends JFrame {

    public TipoAcciónGUI() {
        setTitle("Ingresar al sistema");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));

        JButton btnRegistro = new JButton("Registrarse");
        JButton btnEdición = new JButton("Editar perfil");

        btnRegistro.addActionListener(new TipoUsuarioActionListener("Registro"));
        btnEdición.addActionListener(new TipoUsuarioActionListener("Edición"));

        panel.add(btnRegistro);
        panel.add(btnEdición);

        add(panel);
        setVisible(true);
    }

    private class TipoUsuarioActionListener implements ActionListener {
        private String tipoAcción;

        public TipoUsuarioActionListener(String tipoAcción) {
            this.tipoAcción = tipoAcción;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            TipoAcciónGUI.this.dispose();
            TipoUsuarioGUI gui = new TipoUsuarioGUI(tipoAcción);
            gui.setVisible(true);
        }
    }
}