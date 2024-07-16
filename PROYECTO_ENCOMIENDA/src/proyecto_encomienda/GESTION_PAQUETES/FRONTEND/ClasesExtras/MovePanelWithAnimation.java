/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.GESTION_PAQUETES.FRONTEND.ClasesExtras;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovePanelWithAnimation extends JFrame {
    private JPanel panel;
    private JLabel moveButton;
    private int targetX;
    private Timer timer;
    private boolean bandera = false;

    public MovePanelWithAnimation() {
        // Configurar el Timer para la animación
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animatePanel();
            }
        });
    }

    public void startAnimation(JPanel panel, int targetX) {
        this.panel = panel;
        if (!bandera) {
            this.targetX = this.panel.getX() - targetX; // Nueva posición objetivo
            bandera = !bandera;
            
        } else {
            this.targetX = this.panel.getX() + targetX; // Nueva posición objetivo
            bandera = !bandera;
        }
        timer.start(); // Iniciar la animación

    }

    private void animatePanel() {
        int currentX = this.panel.getX();
        if (currentX > this.targetX) {
            this.panel.setLocation(currentX - 6, this.panel.getY()); // Mover el panel hacia la izquierda
            if (currentX - 6 <= this.targetX) {
                timer.stop(); // Detener el Timer cuando se alcanza la posición objetivo
                this.panel.setLocation(this.targetX, this.panel.getY()); // Asegurarse de que el panel esté en la posición exacta
            }
        } else if (currentX < this.targetX) {
            this.panel.setLocation(currentX + 6, this.panel.getY()); // Mover el panel hacia la derecha
            if (currentX + 6 >= this.targetX) {
                timer.stop(); // Detener el Timer cuando se alcanza la posición objetivo
                this.panel.setLocation(this.targetX, this.panel.getY()); // Asegurarse de que el panel esté en la posición exacta
            }
        } else {
            timer.stop();
        }
    }
    
    public void setBandera (boolean bandera){
        this.bandera = bandera;
    }

}

