// vistas hechas con chat gpt y minimos cambios por el usuario
package main.java.vista.pptvista;

import java.awt.*;
import javax.swing.*;
import main.java.controlador.juegos.ppt;
import main.java.db.usuario;
import main.java.vista.menuVista.menuVista;

public class pptvista extends JFrame {

    private ppt juego = new ppt();

    private usuario user;
    private JButton btnPiedra = new JButton("Piedra");
    private JButton btnPapel = new JButton("Papel");
    private JButton btnTijera = new JButton("Tijera");
    private JButton btnVolver = new JButton("← Volver al menú");
    private JLabel lblResultado = new JLabel("Elige una opción", SwingConstants.CENTER);

    public pptvista(usuario user) {
        this.user = user;

        setTitle("Piedra, Papel o Tijera");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de botones de juego
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnPiedra);
        panelBotones.add(btnPapel);
        panelBotones.add(btnTijera);

        // Panel superior con botón volver
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.add(btnVolver);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(lblResultado, BorderLayout.SOUTH);

        // Acciones de los botones
        btnPiedra.addActionListener(e -> jugar(juego.piedra));
        btnPapel.addActionListener(e -> jugar(juego.papel));
        btnTijera.addActionListener(e -> jugar(juego.tijera));

        btnVolver.addActionListener(e -> {
            new menuVista(user).setVisible(true);
            dispose();
        });
    }

    private void jugar(int eleccionJugador) {
        int eleccionPC = juego.getEleccion();
        int resultado = juego.getGanador(eleccionJugador, eleccionPC);

        String[] opciones = { "", "Piedra", "Papel", "Tijera" };
        String mensaje = "Tú: " + opciones[eleccionJugador] + " - PC: " + opciones[eleccionPC] + " → ";

        if (resultado == 1) {
            user.sumarBoletos(100);
            mensaje += "¡Ganaste! Total: " + user.getterBoletos();
        } else if (resultado == 2) {
            user.resBoletos(50);
            mensaje += "Perdiste. Total: " + user.getterBoletos();
        } else {
            mensaje += "Empate.";
        }

        lblResultado.setText(mensaje);
    }
}

