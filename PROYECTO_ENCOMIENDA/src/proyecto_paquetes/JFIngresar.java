/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_paquetes;

import GUI.JFMenu;
import GUI.JFRecuperar;
import GUICONDUCTOR.JFMenuConductor;
import GUICONDUCTOR.JFPaquetesCliente;
import basededatos.DataBase;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mod_facturacion.Cotizacion;
import mod_paquetes.Inventario;

/**
 * Esta clase representa la interfaz gráfica de la ventana de inicio de sesión.
 * Contiene métodos para la interacción con la base de datos y la validación de
 * usuarios.
 *
 * @autor USUARIO
 */
public class JFIngresar extends javax.swing.JFrame {

    // Nombre de la base de datos a la que se conecta la aplicación
    String database = "envios";
    // Variables para el manejo de la posición del mouse al arrastrar la ventana
    int xMouse, yMouse;

    /**
     * Constructor de la clase JFIngresar.
     * Inicializa los componentes y configura el comportamiento de la ventana.
     */
    public JFIngresar() {
        // Inicializa los componentes de la interfaz gráfica
        initComponents();
        // Establece el icono de la ventana
        setIconImage(new ImageIcon(getClass().getResource("/iconos/AjustesBest.png")).getImage());
        // Coloca la ventana en el centro de la pantalla
        this.setLocationRelativeTo(null);
        // Establece el título de la ventana
        setTitle("Login Form");
        // Define la operación de cierre de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Configura el estilo del texto de "olvidasteContra" para cuando el mouse está
        // encima
        Font originalFont = olvidasteContra.getFont();
        Font boldFont = new Font(originalFont.getName(), Font.BOLD, originalFont.getSize());
        Color originalColor = olvidasteContra.getForeground();
        Color hoverColor = new Color(0, 0, 255);

        // Añade un mouse listener para cambiar el estilo del texto cuando el mouse
        // entra o sale
        olvidasteContra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                olvidasteContra.setFont(boldFont);
                olvidasteContra.setForeground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                olvidasteContra.setFont(originalFont);
                olvidasteContra.setForeground(originalColor);
            }
        });
    }
// puedes funcionar porfavor
    /**
     * Establece una conexión con la base de datos.
     *
     * @param url      La URL de la base de datos
     * @param username El nombre de usuario para la conexión
     * @param password La contraseña para la conexión
     * @return Una conexión a la base de datos
     * @throws SQLException Si ocurre un error al establecer la conexión
     */

    /**
     * Muestra un mensaje de error en un cuadro de diálogo.
     *
     * @param mensaje El mensaje de error a mostrar
     */
    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /**
     * Muestra el menú correspondiente al rol del usuario.
     *
     * @param userRole El rol del usuario
     * @param username El nombre de usuario
     */
    private void mostrarMenu(String userRole, String username) {
        if (userRole.equals("recepcionista")) {
            JFMenu menu = new JFMenu(DataBase.obtenerInstancia().obtenerRecepcionista(username));
            this.setVisible(false);
            menu.setVisible(true);
        } else {
            JFMenuConductor menu = new JFMenuConductor(DataBase.obtenerInstancia().obtenerConductor(username));
            this.setVisible(false);
            menu.setVisible(true);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        exitP = new javax.swing.JPanel();
        exitTXT = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFUser = new javax.swing.JTextField();
        jTFPassword = new javax.swing.JPasswordField();
        jBIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBMostrarC = new javax.swing.JButton();
        olvidasteContra = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        botonCliente = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(146, 10, 48));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(460, 24));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitP.setBackground(new java.awt.Color(146, 10, 48));
        exitP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        exitTXT.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        exitTXT.setForeground(new java.awt.Color(255, 255, 255));
        exitTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTXT.setText("X");
        exitTXT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTXTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTXTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTXTMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitPLayout = new javax.swing.GroupLayout(exitP);
        exitP.setLayout(exitPLayout);
        exitPLayout.setHorizontalGroup(
            exitPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitPLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exitPLayout.setVerticalGroup(
            exitPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(exitP, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, -1, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/paquete.png"))); // NOI18N
        jLabel2.setText("Inicio de sesión");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 8, 145, -1));

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 30));

        jTFUser.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTFUser.setForeground(new java.awt.Color(204, 204, 204));
        jTFUser.setText("Ingresa tu nombre de usuario");
        jTFUser.setBorder(null);
        jTFUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFUserFocusGained(evt);
            }
        });
        jTFUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFUserKeyTyped(evt);
            }
        });
        bg.add(jTFUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 340, 20));

        jTFPassword.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTFPassword.setForeground(new java.awt.Color(204, 204, 204));
        jTFPassword.setText("Ingresa tu contraseña");
        jTFPassword.setBorder(null);
        jTFPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFPasswordFocusGained(evt);
            }
        });
        jTFPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFPasswordKeyPressed(evt);
            }
        });
        bg.add(jTFPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 340, 20));

        jBIngresar.setBackground(new java.awt.Color(255, 250, 243));
        jBIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ingresar.png"))); // NOI18N
        jBIngresar.setText("Ingresar");
        jBIngresar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jBIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBIngresarMouseExited(evt);
            }
        });
        jBIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIngresarActionPerformed(evt);
            }
        });
        bg.add(jBIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 360, 110, 40));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel1.setText("Contraseña");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        jBMostrarC.setBackground(new java.awt.Color(255, 250, 243));
        jBMostrarC.setText("Mostrar Contraseña");
        jBMostrarC.setBorder(null);
        jBMostrarC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBMostrarC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBMostrarCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBMostrarCMouseExited(evt);
            }
        });
        jBMostrarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMostrarCActionPerformed(evt);
            }
        });
        bg.add(jBMostrarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 160, 40));

        olvidasteContra.setForeground(new java.awt.Color(102, 153, 255));
        olvidasteContra.setText("¿Olvidaste tu contraseña o usuario?");
        olvidasteContra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        olvidasteContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                olvidasteContraMouseClicked(evt);
            }
        });
        bg.add(olvidasteContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/gestionDePaquetes.png"))); // NOI18N
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 440, 120));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel4.setText("Iniciar sesión");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 340, 10));

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/user.png"))); // NOI18N
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 340, -1));

        botonCliente.setForeground(new java.awt.Color(102, 153, 255));
        botonCliente.setText("Verificar paquete o quejas");
        botonCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonClienteMouseClicked(evt);
            }
        });
        bg.add(botonCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/pass.png"))); // NOI18N
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel8.setText("Usuario");
        bg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 419));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento que se ejecuta al hacer clic en el botón "Ingresar".
     * Realiza la autenticación del usuario.
     *
     * @param evt El evento de clic
     */
    private void jBIngresarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBIngresarActionPerformed
        String username = jTFUser.getText();
        String password = new String(jTFPassword.getPassword());

        if (username.isEmpty() && password.isEmpty()) {
            mostrarMensajeError("Ingrese un usuario y contraseña");
        } else if (username.isEmpty()) {
            mostrarMensajeError("Ingrese un usuario");
        } else if (password.isEmpty()) {
            mostrarMensajeError("Ingrese una contraseña");
        } else {
            String role = DataBase.obtenerInstancia().comprobarCredencial(username, password);
            if (role != null) {
                System.out.println("Acceso permitido. Rol: " + role);
                mostrarMenu(role, username);
            } else {
                mostrarMensajeError("Credenciales incorrectas");
            }
        }
    }// GEN-LAST:event_jBIngresarActionPerformed

    /**
     * Alterna la visibilidad de la contraseña en el campo jTFPassword
     *
     * @param evt el evento de acción generado por el clic en el botón
     */
    private void jBMostrarCActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTFPassword.echoCharIsSet()) {
            jTFPassword.setEchoChar((char) 0);
        } else {
            jTFPassword.setEchoChar('*');
        }
    }

    /**
     * Maneja el clic en el texto "olvidasteContra"
     *
     * @param evt el evento de clic del ratón
     */
    private void olvidasteContraMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
        JFRecuperar recuperar = new JFRecuperar();
        recuperar.setVisible(true);
    }

    /**
     * Maneja el evento de tipeo en el campo de texto del usuario.
     * Restringe la entrada de caracteres para permitir solo letras, números y el
     * carácter 'ñ'.
     * Muestra un mensaje de advertencia si el usuario intenta ingresar un carácter
     * no permitido.
     *
     * @param evt El evento de tipeo generado al presionar una tecla en el campo de
     *            texto.
     */
    private void jTFUserKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTFUserKeyTyped
        char c = evt.getKeyChar();
        if (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
            if (!((Character.isLetter(c) && Character.isLowerCase(c))
                    || (Character.isLetter(c) && Character.isUpperCase(c))
                    || Character.isDigit(c) || c == 'ñ' || c == 'Ñ')) {
                evt.consume(); // No permite ingresar el carácter

                // Mostrar mensaje de advertencia
                JOptionPane.showMessageDialog(this, "Solo se permiten letras y números.");
            }
        }
    }// GEN-LAST:event_jTFUserKeyTyped

    /**
     * Maneja el evento de presionar el ratón en el panel.
     * Guarda la posición inicial del ratón para permitir el movimiento del panel.
     *
     * @param evt El evento de presionar el ratón en el panel.
     */
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }// GEN-LAST:event_jPanel1MousePressed

    /**
     * Maneja el evento de arrastrar el ratón en el panel.
     * Permite mover la ventana arrastrando el panel utilizando las coordenadas del
     * ratón.
     *
     * @param evt El evento de arrastrar el ratón en el panel.
     */
    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }// GEN-LAST:event_jPanel1MouseDragged

    /**
     * Maneja el evento de clic en el texto de salida.
     * Muestra un cuadro de confirmación para cerrar la aplicación y, si se
     * confirma,
     * termina la ejecución del programa.
     *
     * @param evt El evento de clic generado al hacer clic en el texto.
     */
    private void exitTXTMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_exitTXTMouseClicked
        int dialogResult = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres cerrar el sistema?",
                "Confirmación de cierre", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }// GEN-LAST:event_exitTXTMouseClicked

    /**
     * Maneja el evento de entrada del ratón en el texto de salida.
     * Cambia el color de fondo del panel de salida cuando el ratón entra en el área
     * del texto.
     *
     * @param evt El evento de entrada del ratón en el texto.
     */
    private void exitTXTMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_exitTXTMouseEntered
        exitP.setBackground(Color.red);
    }// GEN-LAST:event_exitTXTMouseEntered

    /**
     * Maneja el evento de salida del ratón del texto de salida.
     * Restaura el color de fondo del panel de salida cuando el ratón sale del área
     * del texto.
     *
     * @param evt El evento de salida del ratón del texto.
     */
    private void exitTXTMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_exitTXTMouseExited
        exitP.setBackground(new Color(146, 10, 48));
    }// GEN-LAST:event_exitTXTMouseExited

    /**
     * Maneja el evento de entrada del ratón en el botón de mostrar contraseña.
     * Cambia el color de fondo del botón cuando el ratón entra en el área del
     * botón.
     *
     * @param evt El evento de entrada del ratón en el botón.
     */
    private void jBMostrarCMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jBMostrarCMouseEntered
        jBMostrarC.setBackground(new Color(255, 51, 133));
        // [255,51,133]
    }// GEN-LAST:event_jBMostrarCMouseEntered

    /**
     * Maneja el evento de salida del ratón del botón de mostrar contraseña.
     * Restaura el color de fondo del botón cuando el ratón sale del área del botón.
     *
     * @param evt El evento de salida del ratón del botón.
     */
    private void jBMostrarCMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jBMostrarCMouseExited
        // [255,250,243]
        jBMostrarC.setBackground(new Color(255, 250, 243));
    }// GEN-LAST:event_jBMostrarCMouseExited

    /**
     * Maneja el evento de entrada del ratón en el botón de ingresar.
     * Cambia el color de fondo del botón cuando el ratón entra en el área del
     * botón.
     *
     * @param evt El evento de entrada del ratón en el botón.
     */
    private void jBIngresarMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jBIngresarMouseEntered
        jBIngresar.setBackground(new Color(255, 51, 133));
    }// GEN-LAST:event_jBIngresarMouseEntered

    /**
     * Maneja el evento de salida del ratón del botón de ingresar.
     * Restaura el color de fondo del botón cuando el ratón sale del área del botón.
     *
     * @param evt El evento de salida del ratón del botón.
     */
    private void jBIngresarMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jBIngresarMouseExited
        jBIngresar.setBackground(new Color(255, 250, 243));
    }// GEN-LAST:event_jBIngresarMouseExited

    /**
     * Maneja el evento de presión de una tecla en el campo de contraseña.
     * Actualmente no se ha implementado ningún manejo para este evento.
     *
     * @param evt El evento de presión de tecla en el campo de contraseña.
     */
    private void jTFPasswordKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTFPasswordKeyPressed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTFPasswordKeyPressed

    /**
     * Maneja el evento cuando el campo de texto del usuario gana el foco.
     * Limpia el texto de marcador de posición y restaura el color del texto cuando
     * el campo gana el foco.
     *
     * @param evt El evento de ganancia de foco en el campo de texto del usuario.
     */
    private void jTFUserFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTFUserFocusGained
        String password = new String(jTFPassword.getPassword());
        if (jTFUser.getText().equals("Ingresa tu nombre de usuario")) {
            jTFUser.setText("");
            jTFUser.setForeground(Color.black);
        }
        if (password.isEmpty()) {
            jTFPassword.setText("Ingresa tu contraseña");
            jTFPassword.setForeground(new Color(204, 204, 204));
        }
    }// GEN-LAST:event_jTFUserFocusGained

    /**
     * Maneja el evento cuando el campo de contraseña gana el foco.
     * Limpia el texto de marcador de posición y restaura el color del texto cuando
     * el campo gana el foco.
     *
     * @param evt El evento de ganancia de foco en el campo de contraseña.
     */
    private void jTFPasswordFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTFPasswordFocusGained
        String password = new String(jTFPassword.getPassword());
        if (password.equals("Ingresa tu contraseña")) {
            jTFPassword.setText("");
            jTFPassword.setForeground(Color.black);
        }
        if (jTFUser.getText().isEmpty()) {
            jTFUser.setText("Ingresa tu nombre de usuario");
            jTFUser.setForeground(new Color(204, 204, 204));
        }
    }// GEN-LAST:event_jTFPasswordFocusGained

    /**
     * Bloquea un usuario específico en la base de datos.
     * Actualiza el estado del usuario a 'Bloqueado' en la tabla de usuarios.
     *
     * @param nombreUsuario El nombre de usuario que se desea bloquear.
     */

    private void botonClienteMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_botonClienteMouseClicked
        this.dispose();
        JFPaquetesCliente recuperar = new JFPaquetesCliente();
        recuperar.setVisible(true);
    }// GEN-LAST:event_botonClienteMouseClicked

    private void bloquearUsuario(String nombreUsuario) {
        String updateQuery = "UPDATE usuarios SET estado = 'Bloqueado' WHERE nombreUser = ?";

    }

    /**
     * Verifica si un usuario está bloqueado en la base de datos.
     * Consulta el estado del usuario en la tabla de usuarios.
     *
     * @param nombreUsuario El nombre de usuario para verificar.
     * @return true si el usuario está bloqueado, false de lo contrario.
     */
    private boolean usuarioBloqueado(String nombreUsuario) {
        String query = "SELECT estado FROM usuarios WHERE nombreUser = ?";
        return false;
    }

    /**
     * Verifica si un usuario existe en la base de datos.
     * Consulta el número de usuarios con el nombre dado en la tabla de usuarios.
     *
     * @param nombreUsuario El nombre de usuario para verificar.
     * @return true si el usuario existe, false de lo contrario.
     */
    private boolean usuarioExiste(String nombreUsuario) {
        String query = "SELECT COUNT(*) AS count FROM usuarios WHERE nombreUser = ?";
        return true;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFIngresar.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFIngresar.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFIngresar.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFIngresar.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFIngresar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel botonCliente;
    private javax.swing.JPanel exitP;
    private javax.swing.JLabel exitTXT;
    private javax.swing.JButton jBIngresar;
    private javax.swing.JButton jBMostrarC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField jTFPassword;
    private javax.swing.JTextField jTFUser;
    private javax.swing.JLabel olvidasteContra;
    // End of variables declaration//GEN-END:variables
}
