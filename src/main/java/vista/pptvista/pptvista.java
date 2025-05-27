package main.java.vista.pptvista;

import main.java.controlador.juegos.ppt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pptvista extends JFrame {

    private ppt juego = new ppt();

    private JButton btnPiedra = new JButton("Piedra");
    private JButton btnPapel = new JButton("Papel");
    private JButton btnTijera = new JButton("Tijera");
    private JLabel lblResultado = new JLabel("Elige una opción", SwingConstants.CENTER);

    public pptvista() {
        setTitle("Piedra, Papel o Tijera");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnPiedra);
        panelBotones.add(btnPapel);
        panelBotones.add(btnTijera);

        add(panelBotones, BorderLayout.CENTER);
        add(lblResultado, BorderLayout.SOUTH);

        // Acción de botones
        btnPiedra.addActionListener(e -> jugar(juego.piedra));
        btnPapel.addActionListener(e -> jugar(juego.papel));
        btnTijera.addActionListener(e -> jugar(juego.tijera));
    }

    private void jugar(int eleccionJugador) {
        int eleccionPC = juego.getEleccion();
        int resultado = juego.getGanador(eleccionJugador, eleccionPC);

        String[] opciones = { "", "Piedra", "Papel", "Tijera" };
        String mensaje = "Tú: " + opciones[eleccionJugador] + " - PC: " + opciones[eleccionPC] + " → ";

        if (resultado == 1) {
            mensaje += "¡Ganaste!";
        } else if (resultado == 2) {
            mensaje += "Perdiste.";
        } else {
            mensaje += "Empate.";
        }

        lblResultado.setText(mensaje);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new pptvista().setVisible(true);
        });
    }
}
